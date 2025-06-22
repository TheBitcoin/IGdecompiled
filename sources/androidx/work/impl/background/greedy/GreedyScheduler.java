package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import o3.C1001s0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    private static final int NON_THROTTLE_RUN_ATTEMPT_COUNT = 5;
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private final Configuration mConfiguration;
    private final Map<WorkGenerationalId, C1001s0> mConstrainedWorkSpecs = new HashMap();
    private final WorkConstraintsTracker mConstraintsTracker;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    private final Map<WorkGenerationalId, AttemptData> mFirstRunAttempts = new HashMap();
    Boolean mInDefaultProcess;
    private final Object mLock = new Object();
    private final Processor mProcessor;
    private boolean mRegisteredExecutionListener;
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private final TaskExecutor mTaskExecutor;
    private final TimeLimiter mTimeLimiter;
    private final WorkLauncher mWorkLauncher;

    private static class AttemptData {
        final int mRunAttemptCount;
        final long mTimeStamp;

        private AttemptData(int i4, long j4) {
            this.mRunAttemptCount = i4;
            this.mTimeStamp = j4;
        }
    }

    public GreedyScheduler(@NonNull Context context, @NonNull Configuration configuration, @NonNull Trackers trackers, @NonNull Processor processor, @NonNull WorkLauncher workLauncher, @NonNull TaskExecutor taskExecutor) {
        this.mContext = context;
        RunnableScheduler runnableScheduler = configuration.getRunnableScheduler();
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, runnableScheduler, configuration.getClock());
        this.mTimeLimiter = new TimeLimiter(runnableScheduler, workLauncher);
        this.mTaskExecutor = taskExecutor;
        this.mConstraintsTracker = new WorkConstraintsTracker(trackers);
        this.mConfiguration = configuration;
        this.mProcessor = processor;
        this.mWorkLauncher = workLauncher;
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mConfiguration));
    }

    private void registerExecutionListenerIfNeeded() {
        if (!this.mRegisteredExecutionListener) {
            this.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
    }

    private void removeConstraintTrackingFor(@NonNull WorkGenerationalId workGenerationalId) {
        C1001s0 remove;
        synchronized (this.mLock) {
            remove = this.mConstrainedWorkSpecs.remove(workGenerationalId);
        }
        if (remove != null) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, "Stopping tracking for " + workGenerationalId);
            remove.a((CancellationException) null);
        }
    }

    private long throttleIfNeeded(WorkSpec workSpec) {
        long max;
        synchronized (this.mLock) {
            try {
                WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec);
                AttemptData attemptData = this.mFirstRunAttempts.get(generationalId);
                if (attemptData == null) {
                    attemptData = new AttemptData(workSpec.runAttemptCount, this.mConfiguration.getClock().currentTimeMillis());
                    this.mFirstRunAttempts.put(generationalId, attemptData);
                }
                max = attemptData.mTimeStamp + (((long) Math.max((workSpec.runAttemptCount - attemptData.mRunAttemptCount) - 5, 0)) * WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
            } catch (Throwable th) {
                throw th;
            }
        }
        return max;
    }

    public void cancel(@NonNull String str) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process");
            return;
        }
        registerExecutionListenerIfNeeded();
        Logger logger = Logger.get();
        String str2 = TAG;
        logger.debug(str2, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(str);
        }
        for (StartStopToken next : this.mStartStopTokens.remove(str)) {
            this.mTimeLimiter.cancel(next);
            this.mWorkLauncher.stopWork(next);
        }
    }

    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    public void onConstraintsStateChanged(@NonNull WorkSpec workSpec, @NonNull ConstraintsState constraintsState) {
        WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec);
        if (!(constraintsState instanceof ConstraintsState.ConstraintsMet)) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, "Constraints not met: Cancelling work ID " + generationalId);
            StartStopToken remove = this.mStartStopTokens.remove(generationalId);
            if (remove != null) {
                this.mTimeLimiter.cancel(remove);
                this.mWorkLauncher.stopWorkWithReason(remove, ((ConstraintsState.ConstraintsNotMet) constraintsState).getReason());
            }
        } else if (!this.mStartStopTokens.contains(generationalId)) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            logger2.debug(str2, "Constraints met: Scheduling work ID " + generationalId);
            StartStopToken startStopToken = this.mStartStopTokens.tokenFor(generationalId);
            this.mTimeLimiter.track(startStopToken);
            this.mWorkLauncher.startWork(startStopToken);
        }
    }

    public void onExecuted(@NonNull WorkGenerationalId workGenerationalId, boolean z4) {
        StartStopToken remove = this.mStartStopTokens.remove(workGenerationalId);
        if (remove != null) {
            this.mTimeLimiter.cancel(remove);
        }
        removeConstraintTrackingFor(workGenerationalId);
        if (!z4) {
            synchronized (this.mLock) {
                this.mFirstRunAttempts.remove(workGenerationalId);
            }
        }
    }

    public void schedule(@NonNull WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
            return;
        }
        registerExecutionListenerIfNeeded();
        HashSet<WorkSpec> hashSet = new HashSet<>();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                long max = Math.max(workSpec.calculateNextRunTime(), throttleIfNeeded(workSpec));
                long currentTimeMillis = this.mConfiguration.getClock().currentTimeMillis();
                if (workSpec.state == WorkInfo.State.ENQUEUED) {
                    if (currentTimeMillis < max) {
                        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.schedule(workSpec, max);
                        }
                    } else if (workSpec.hasConstraints()) {
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 23 && workSpec.constraints.requiresDeviceIdle()) {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (i4 < 24 || !workSpec.constraints.hasContentUriTriggers()) {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.id);
                        } else {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                        Logger.get().debug(TAG, "Starting work for " + workSpec.id);
                        StartStopToken startStopToken = this.mStartStopTokens.tokenFor(workSpec);
                        this.mTimeLimiter.track(startStopToken);
                        this.mWorkLauncher.startWork(startStopToken);
                    }
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    String join = TextUtils.join(",", hashSet2);
                    Logger.get().debug(TAG, "Starting tracking for " + join);
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec2);
                        if (!this.mConstrainedWorkSpecs.containsKey(generationalId)) {
                            this.mConstrainedWorkSpecs.put(generationalId, WorkConstraintsTrackerKt.listen(this.mConstraintsTracker, workSpec2, this.mTaskExecutor.getTaskCoroutineDispatcher(), this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    @VisibleForTesting
    public void setDelayedWorkTracker(@NonNull DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }
}
