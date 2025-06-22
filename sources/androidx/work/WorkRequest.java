package androidx.work;

import S2.N;
import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class WorkRequest {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    @SuppressLint({"MinMaxConstant"})
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public WorkRequest(UUID uuid, WorkSpec workSpec2, Set<String> set) {
        m.e(uuid, "id");
        m.e(workSpec2, "workSpec");
        m.e(set, "tags");
        this.id = uuid;
        this.workSpec = workSpec2;
        this.tags = set;
    }

    public UUID getId() {
        return this.id;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final String getStringId() {
        String uuid = getId().toString();
        m.d(uuid, "id.toString()");
        return uuid;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> getTags() {
        return this.tags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public Builder(Class<? extends ListenableWorker> cls) {
            m.e(cls, "workerClass");
            this.workerClass = cls;
            UUID randomUUID = UUID.randomUUID();
            m.d(randomUUID, "randomUUID()");
            this.id = randomUUID;
            String uuid = this.id.toString();
            m.d(uuid, "id.toString()");
            String name = cls.getName();
            m.d(name, "workerClass.name");
            this.workSpec = new WorkSpec(uuid, name);
            String name2 = cls.getName();
            m.d(name2, "workerClass.name");
            this.tags = N.e(name2);
        }

        public final B addTag(String str) {
            m.e(str, "tag");
            this.tags.add(str);
            return getThisObject$work_runtime_release();
        }

        public final W build() {
            boolean z4;
            W buildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            int i4 = Build.VERSION.SDK_INT;
            if ((i4 < 24 || !constraints.hasContentUriTriggers()) && !constraints.requiresBatteryNotLow() && !constraints.requiresCharging() && (i4 < 23 || !constraints.requiresDeviceIdle())) {
                z4 = false;
            } else {
                z4 = true;
            }
            WorkSpec workSpec2 = this.workSpec;
            if (workSpec2.expedited) {
                if (z4) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (workSpec2.initialDelay > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            UUID randomUUID = UUID.randomUUID();
            m.d(randomUUID, "randomUUID()");
            setId(randomUUID);
            return buildInternal$work_runtime_release;
        }

        public abstract W buildInternal$work_runtime_release();

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public abstract B getThisObject$work_runtime_release();

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final B keepResultsForAtLeast(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j4);
            return getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long j4, TimeUnit timeUnit) {
            m.e(backoffPolicy, "backoffPolicy");
            m.e(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(timeUnit.toMillis(j4));
            return getThisObject$work_runtime_release();
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z4) {
            this.backoffCriteriaSet = z4;
        }

        public final B setConstraints(Constraints constraints) {
            m.e(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return getThisObject$work_runtime_release();
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
            m.e(outOfQuotaPolicy, "policy");
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.expedited = true;
            workSpec2.outOfQuotaPolicy = outOfQuotaPolicy;
            return getThisObject$work_runtime_release();
        }

        public final B setId(UUID uuid) {
            m.e(uuid, "id");
            this.id = uuid;
            String uuid2 = uuid.toString();
            m.d(uuid2, "id.toString()");
            this.workSpec = new WorkSpec(uuid2, this.workSpec);
            return getThisObject$work_runtime_release();
        }

        public final void setId$work_runtime_release(UUID uuid) {
            m.e(uuid, "<set-?>");
            this.id = uuid;
        }

        public B setInitialDelay(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j4);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialRunAttemptCount(int i4) {
            this.workSpec.runAttemptCount = i4;
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setInitialState(WorkInfo.State state) {
            m.e(state, MRAIDCommunicatorUtil.KEY_STATE);
            this.workSpec.state = state;
            return getThisObject$work_runtime_release();
        }

        public final B setInputData(Data data) {
            m.e(data, "inputData");
            this.workSpec.input = data;
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setLastEnqueueTime(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j4);
            return getThisObject$work_runtime_release();
        }

        @VisibleForTesting
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final B setScheduleRequestedAt(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j4);
            return getThisObject$work_runtime_release();
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec2) {
            m.e(workSpec2, "<set-?>");
            this.workSpec = workSpec2;
        }

        @RequiresApi(26)
        public final B keepResultsForAtLeast(Duration duration) {
            m.e(duration, TypedValues.TransitionType.S_DURATION);
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            m.e(backoffPolicy, "backoffPolicy");
            m.e(duration, TypedValues.TransitionType.S_DURATION);
            this.backoffCriteriaSet = true;
            WorkSpec workSpec2 = this.workSpec;
            workSpec2.backoffPolicy = backoffPolicy;
            workSpec2.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return getThisObject$work_runtime_release();
        }

        @RequiresApi(26)
        public B setInitialDelay(Duration duration) {
            m.e(duration, TypedValues.TransitionType.S_DURATION);
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }
    }
}
