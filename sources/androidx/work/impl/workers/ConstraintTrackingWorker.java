package androidx.work.impl.workers;

import R2.s;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j.C0922a;
import j.C0923b;
import j.C0924c;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.C1001s0;
import o3.G;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConstraintTrackingWorker extends ListenableWorker implements OnConstraintsStateChangedListener {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future = SettableFuture.create();
    private final Object lock = new Object();
    private final WorkerParameters workerParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters2) {
        super(context, workerParameters2);
        m.e(context, "appContext");
        m.e(workerParameters2, "workerParameters");
        this.workerParameters = workerParameters2;
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (!this.future.isCancelled()) {
            String string = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
            Logger logger = Logger.get();
            m.d(logger, "get()");
            if (string == null || string.length() == 0) {
                logger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                SettableFuture<ListenableWorker.Result> settableFuture = this.future;
                m.d(settableFuture, "future");
                boolean unused = ConstraintTrackingWorkerKt.setFailed(settableFuture);
                return;
            }
            ListenableWorker createWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.workerParameters);
            this.delegate = createWorkerWithDefaultFallback;
            if (createWorkerWithDefaultFallback == null) {
                logger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                SettableFuture<ListenableWorker.Result> settableFuture2 = this.future;
                m.d(settableFuture2, "future");
                boolean unused2 = ConstraintTrackingWorkerKt.setFailed(settableFuture2);
                return;
            }
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            m.d(instance, "getInstance(applicationContext)");
            WorkSpecDao workSpecDao = instance.getWorkDatabase().workSpecDao();
            String uuid = getId().toString();
            m.d(uuid, "id.toString()");
            WorkSpec workSpec = workSpecDao.getWorkSpec(uuid);
            if (workSpec == null) {
                SettableFuture<ListenableWorker.Result> settableFuture3 = this.future;
                m.d(settableFuture3, "future");
                boolean unused3 = ConstraintTrackingWorkerKt.setFailed(settableFuture3);
                return;
            }
            Trackers trackers = instance.getTrackers();
            m.d(trackers, "workManagerImpl.trackers");
            WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(trackers);
            G taskCoroutineDispatcher = instance.getWorkTaskExecutor().getTaskCoroutineDispatcher();
            m.d(taskCoroutineDispatcher, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
            this.future.addListener(new C0923b(WorkConstraintsTrackerKt.listen(workConstraintsTracker, workSpec, taskCoroutineDispatcher, this)), new SynchronousExecutor());
            if (workConstraintsTracker.areAllConstraintsMet(workSpec)) {
                String access$getTAG$p = ConstraintTrackingWorkerKt.TAG;
                logger.debug(access$getTAG$p, "Constraints met for delegate " + string);
                try {
                    ListenableWorker listenableWorker = this.delegate;
                    m.b(listenableWorker);
                    C2172d startWork = listenableWorker.startWork();
                    m.d(startWork, "delegate!!.startWork()");
                    startWork.addListener(new C0924c(this, startWork), getBackgroundExecutor());
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                String access$getTAG$p2 = ConstraintTrackingWorkerKt.TAG;
                logger.debug(access$getTAG$p2, "Constraints not met for delegate " + string + ". Requesting retry.");
                SettableFuture<ListenableWorker.Result> settableFuture4 = this.future;
                m.d(settableFuture4, "future");
                boolean unused4 = ConstraintTrackingWorkerKt.setRetry(settableFuture4);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$1(C1001s0 s0Var) {
        m.e(s0Var, "$job");
        s0Var.a((CancellationException) null);
    }

    /* access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$3(ConstraintTrackingWorker constraintTrackingWorker, C2172d dVar) {
        m.e(constraintTrackingWorker, "this$0");
        m.e(dVar, "$innerFuture");
        synchronized (constraintTrackingWorker.lock) {
            try {
                if (constraintTrackingWorker.areConstraintsUnmet) {
                    SettableFuture<ListenableWorker.Result> settableFuture = constraintTrackingWorker.future;
                    m.d(settableFuture, "future");
                    boolean unused = ConstraintTrackingWorkerKt.setRetry(settableFuture);
                } else {
                    constraintTrackingWorker.future.setFuture(dVar);
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void startWork$lambda$0(ConstraintTrackingWorker constraintTrackingWorker) {
        m.e(constraintTrackingWorker, "this$0");
        constraintTrackingWorker.setupAndRunConstraintTrackingWork();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        m.e(workSpec, "workSpec");
        m.e(constraintsState, MRAIDCommunicatorUtil.KEY_STATE);
        Logger logger = Logger.get();
        String access$getTAG$p = ConstraintTrackingWorkerKt.TAG;
        logger.debug(access$getTAG$p, "Constraints changed for " + workSpec);
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            synchronized (this.lock) {
                this.areConstraintsUnmet = true;
                s sVar = s.f8222a;
            }
        }
    }

    public void onStopped() {
        int i4;
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            if (Build.VERSION.SDK_INT >= 31) {
                i4 = getStopReason();
            } else {
                i4 = 0;
            }
            listenableWorker.stop(i4);
        }
    }

    public C2172d startWork() {
        getBackgroundExecutor().execute(new C0922a(this));
        SettableFuture<ListenableWorker.Result> settableFuture = this.future;
        m.d(settableFuture, "future");
        return settableFuture;
    }
}
