package androidx.work.impl.model;

import S2.C1601o;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.privacysandbox.ads.adservices.adselection.u;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j3.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
public final class WorkSpec {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new b();
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;
    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;
    @Embedded
    public Constraints constraints;
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;
    @ColumnInfo(defaultValue = "0")
    private final int generation;
    @ColumnInfo(name = "id")
    @PrimaryKey
    public final String id;
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;
    @ColumnInfo(name = "input")
    public Data input;
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;
    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;
    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;
    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;
    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;
    @ColumnInfo(name = "output")
    public Data output;
    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;
    @ColumnInfo(name = "state")
    public WorkInfo.State state;
    @ColumnInfo(defaultValue = "-256", name = "stop_reason")
    private final int stopReason;
    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public final long calculateNextRunTime(boolean z4, int i4, BackoffPolicy backoffPolicy, long j4, long j5, int i5, boolean z5, long j6, long j7, long j8, long j9) {
            long j10;
            long j11 = j9;
            m.e(backoffPolicy, "backoffPolicy");
            if (j11 != Long.MAX_VALUE && z5) {
                return i5 == 0 ? j11 : e.b(j11, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + j5);
            }
            if (z4) {
                if (backoffPolicy == BackoffPolicy.LINEAR) {
                    j10 = j4 * ((long) i4);
                } else {
                    j10 = (long) Math.scalb((float) j4, i4 - 1);
                }
                return e.d(j10, WorkRequest.MAX_BACKOFF_MILLIS) + j5;
            } else if (z5) {
                long j12 = i5 == 0 ? j5 + j6 : j5 + j8;
                return (j7 == j8 || i5 != 0) ? j12 : j12 + (j8 - j7);
            } else if (j5 == -1) {
                return Long.MAX_VALUE;
            } else {
                return j5 + j6;
            }
        }

        private Companion() {
        }
    }

    public static final class IdAndState {
        @ColumnInfo(name = "id")
        public String id;
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(String str, WorkInfo.State state2) {
            m.e(str, "id");
            m.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            this.id = str;
            this.state = state2;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = idAndState.id;
            }
            if ((i4 & 2) != 0) {
                state2 = idAndState.state;
            }
            return idAndState.copy(str, state2);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String str, WorkInfo.State state2) {
            m.e(str, "id");
            m.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            return new IdAndState(str, state2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return m.a(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        m.d(tagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = tagWithPrefix;
    }

    public WorkSpec(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j4, long j5, long j6, Constraints constraints2, @IntRange(from = 0) int i4, BackoffPolicy backoffPolicy2, long j7, long j8, long j9, long j10, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i5, int i6, long j11, int i7, int i8) {
        Constraints constraints3 = constraints2;
        BackoffPolicy backoffPolicy3 = backoffPolicy2;
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        m.e(str, "id");
        m.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        m.e(str2, "workerClassName");
        m.e(str3, "inputMergerClassName");
        m.e(data, "input");
        m.e(data2, "output");
        m.e(constraints3, "constraints");
        m.e(backoffPolicy3, "backoffPolicy");
        m.e(outOfQuotaPolicy3, "outOfQuotaPolicy");
        this.id = str;
        this.state = state2;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data2;
        this.initialDelay = j4;
        this.intervalDuration = j5;
        this.flexDuration = j6;
        this.constraints = constraints3;
        this.runAttemptCount = i4;
        this.backoffPolicy = backoffPolicy3;
        this.backoffDelayDuration = j7;
        this.lastEnqueueTime = j8;
        this.minimumRetentionDuration = j9;
        this.scheduleRequestedAt = j10;
        this.expedited = z4;
        this.outOfQuotaPolicy = outOfQuotaPolicy3;
        this.periodCount = i5;
        this.generation = i6;
        this.nextScheduleTimeOverride = j11;
        this.nextScheduleTimeOverrideGeneration = i7;
        this.stopReason = i8;
    }

    /* access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        Iterable<WorkInfoPojo> iterable = list;
        ArrayList arrayList = new ArrayList(C1601o.p(iterable, 10));
        for (WorkInfoPojo workInfo : iterable) {
            arrayList.add(workInfo.toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j4, long j5, long j6, Constraints constraints2, int i4, BackoffPolicy backoffPolicy2, long j7, long j8, long j9, long j10, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i5, int i6, long j11, int i7, int i8, int i9, Object obj) {
        WorkSpec workSpec2 = workSpec;
        int i10 = i9;
        String str4 = (i10 & 1) != 0 ? workSpec2.id : str;
        WorkInfo.State state3 = (i10 & 2) != 0 ? workSpec2.state : state2;
        String str5 = (i10 & 4) != 0 ? workSpec2.workerClassName : str2;
        String str6 = (i10 & 8) != 0 ? workSpec2.inputMergerClassName : str3;
        Data data3 = (i10 & 16) != 0 ? workSpec2.input : data;
        Data data4 = (i10 & 32) != 0 ? workSpec2.output : data2;
        long j12 = (i10 & 64) != 0 ? workSpec2.initialDelay : j4;
        long j13 = (i10 & 128) != 0 ? workSpec2.intervalDuration : j5;
        long j14 = (i10 & 256) != 0 ? workSpec2.flexDuration : j6;
        Constraints constraints3 = (i10 & 512) != 0 ? workSpec2.constraints : constraints2;
        int i11 = (i10 & 1024) != 0 ? workSpec2.runAttemptCount : i4;
        String str7 = str4;
        BackoffPolicy backoffPolicy3 = (i10 & 2048) != 0 ? workSpec2.backoffPolicy : backoffPolicy2;
        WorkInfo.State state4 = state3;
        long j15 = (i10 & 4096) != 0 ? workSpec2.backoffDelayDuration : j7;
        long j16 = (i10 & 8192) != 0 ? workSpec2.lastEnqueueTime : j8;
        long j17 = (i10 & 16384) != 0 ? workSpec2.minimumRetentionDuration : j9;
        long j18 = (i10 & 32768) != 0 ? workSpec2.scheduleRequestedAt : j10;
        return workSpec2.copy(str7, state4, str5, str6, data3, data4, j12, j13, j14, constraints3, i11, backoffPolicy3, j15, j16, j17, j18, (i9 & 65536) != 0 ? workSpec2.expedited : z4, (i9 & 131072) != 0 ? workSpec2.outOfQuotaPolicy : outOfQuotaPolicy2, (i9 & 262144) != 0 ? workSpec2.periodCount : i5, (i9 & 524288) != 0 ? workSpec2.generation : i6, (i9 & 1048576) != 0 ? workSpec2.nextScheduleTimeOverride : j11, (i9 & 2097152) != 0 ? workSpec2.nextScheduleTimeOverrideGeneration : i7, (i9 & 4194304) != 0 ? workSpec2.stopReason : i8);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j4, long j5, long j6, Constraints constraints2, @IntRange(from = 0) int i4, BackoffPolicy backoffPolicy2, long j7, long j8, long j9, long j10, boolean z4, OutOfQuotaPolicy outOfQuotaPolicy2, int i5, int i6, long j11, int i7, int i8) {
        String str4 = str;
        m.e(str4, "id");
        WorkInfo.State state3 = state2;
        m.e(state3, MRAIDCommunicatorUtil.KEY_STATE);
        String str5 = str2;
        m.e(str5, "workerClassName");
        String str6 = str3;
        m.e(str6, "inputMergerClassName");
        Data data3 = data;
        m.e(data3, "input");
        Data data4 = data2;
        m.e(data4, "output");
        Constraints constraints3 = constraints2;
        m.e(constraints3, "constraints");
        m.e(backoffPolicy2, "backoffPolicy");
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        m.e(outOfQuotaPolicy3, "outOfQuotaPolicy");
        OutOfQuotaPolicy outOfQuotaPolicy4 = outOfQuotaPolicy3;
        return new WorkSpec(str4, state3, str5, str6, data3, data4, j4, j5, j6, constraints3, i4, backoffPolicy2, j7, j8, j9, j10, z4, outOfQuotaPolicy4, i5, i6, j11, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return m.a(this.id, workSpec.id) && this.state == workSpec.state && m.a(this.workerClassName, workSpec.workerClassName) && m.a(this.inputMergerClassName, workSpec.inputMergerClassName) && m.a(this.input, workSpec.input) && m.a(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && m.a(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final boolean hasConstraints() {
        return !m.a(Constraints.NONE, this.constraints);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31) + this.inputMergerClassName.hashCode()) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + u.a(this.initialDelay)) * 31) + u.a(this.intervalDuration)) * 31) + u.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + u.a(this.backoffDelayDuration)) * 31) + u.a(this.lastEnqueueTime)) * 31) + u.a(this.minimumRetentionDuration)) * 31) + u.a(this.scheduleRequestedAt)) * 31;
        boolean z4 = this.expedited;
        if (z4) {
            z4 = true;
        }
        return ((((((((((((hashCode + (z4 ? 1 : 0)) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + this.periodCount) * 31) + this.generation) * 31) + u.a(this.nextScheduleTimeOverride)) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason;
    }

    public final boolean isBackedOff() {
        if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
            return false;
        }
        return true;
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration != 0) {
            return true;
        }
        return false;
    }

    public final void setBackoffDelayDuration(long j4) {
        if (j4 > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j4 < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = e.g(j4, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j4) {
        this.nextScheduleTimeOverride = j4;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i4) {
        this.nextScheduleTimeOverrideGeneration = i4;
    }

    public final void setPeriodCount(int i4) {
        this.periodCount = i4;
    }

    public final void setPeriodic(long j4) {
        if (j4 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(e.b(j4, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), e.b(j4, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS));
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    public final void setPeriodic(long j4, long j5) {
        if (j4 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = e.b(j4, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (j5 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j5 > this.intervalDuration) {
            Logger logger = Logger.get();
            String str = TAG;
            logger.warning(str, "Flex duration greater than interval duration; Changed to " + j4);
        }
        this.flexDuration = e.g(j5, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this.intervalDuration);
    }

    public static final class WorkInfoPojo {
        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;
        @ColumnInfo(name = "backoff_policy")
        private BackoffPolicy backoffPolicy;
        @Embedded
        private final Constraints constraints;
        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;
        @ColumnInfo(name = "generation")
        private final int generation;
        @ColumnInfo(name = "id")
        private final String id;
        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;
        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;
        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;
        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;
        @ColumnInfo(name = "output")
        private final Data output;
        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;
        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        private final List<Data> progress;
        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;
        @ColumnInfo(name = "state")
        private final WorkInfo.State state;
        @ColumnInfo(name = "stop_reason")
        private final int stopReason;
        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        private final List<String> tags;

        public WorkInfoPojo(String str, WorkInfo.State state2, Data data, long j4, long j5, long j6, Constraints constraints2, int i4, BackoffPolicy backoffPolicy2, long j7, long j8, int i5, int i6, long j9, int i7, List<String> list, List<Data> list2) {
            BackoffPolicy backoffPolicy3 = backoffPolicy2;
            List<String> list3 = list;
            List<Data> list4 = list2;
            m.e(str, "id");
            m.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
            m.e(data, "output");
            m.e(constraints2, "constraints");
            m.e(backoffPolicy3, "backoffPolicy");
            m.e(list3, "tags");
            m.e(list4, "progress");
            this.id = str;
            this.state = state2;
            this.output = data;
            this.initialDelay = j4;
            this.intervalDuration = j5;
            this.flexDuration = j6;
            this.constraints = constraints2;
            this.runAttemptCount = i4;
            this.backoffPolicy = backoffPolicy3;
            this.backoffDelayDuration = j7;
            this.lastEnqueueTime = j8;
            this.periodCount = i5;
            this.generation = i6;
            this.nextScheduleTimeOverride = j9;
            this.stopReason = i7;
            this.tags = list3;
            this.progress = list4;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state2, Data data, long j4, long j5, long j6, Constraints constraints2, int i4, BackoffPolicy backoffPolicy2, long j7, long j8, int i5, int i6, long j9, int i7, List list, List list2, int i8, Object obj) {
            WorkInfoPojo workInfoPojo2 = workInfoPojo;
            int i9 = i8;
            return workInfoPojo2.copy((i9 & 1) != 0 ? workInfoPojo2.id : str, (i9 & 2) != 0 ? workInfoPojo2.state : state2, (i9 & 4) != 0 ? workInfoPojo2.output : data, (i9 & 8) != 0 ? workInfoPojo2.initialDelay : j4, (i9 & 16) != 0 ? workInfoPojo2.intervalDuration : j5, (i9 & 32) != 0 ? workInfoPojo2.flexDuration : j6, (i9 & 64) != 0 ? workInfoPojo2.constraints : constraints2, (i9 & 128) != 0 ? workInfoPojo2.runAttemptCount : i4, (i9 & 256) != 0 ? workInfoPojo2.backoffPolicy : backoffPolicy2, (i9 & 512) != 0 ? workInfoPojo2.backoffDelayDuration : j7, (i9 & 1024) != 0 ? workInfoPojo2.lastEnqueueTime : j8, (i9 & 2048) != 0 ? workInfoPojo2.periodCount : i5, (i9 & 4096) != 0 ? workInfoPojo2.generation : i6, (i9 & 8192) != 0 ? workInfoPojo2.nextScheduleTimeOverride : j9, (i9 & 16384) != 0 ? workInfoPojo2.stopReason : i7, (32768 & i9) != 0 ? workInfoPojo2.tags : list, (i9 & 65536) != 0 ? workInfoPojo2.progress : list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j4 = this.intervalDuration;
            if (j4 != 0) {
                return new WorkInfo.PeriodicityInfo(j4, this.flexDuration);
            }
            return null;
        }

        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        public final List<String> component16() {
            return this.tags;
        }

        public final List<Data> component17() {
            return this.progress;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        public final WorkInfoPojo copy(String str, WorkInfo.State state2, Data data, long j4, long j5, long j6, Constraints constraints2, int i4, BackoffPolicy backoffPolicy2, long j7, long j8, int i5, int i6, long j9, int i7, List<String> list, List<Data> list2) {
            String str2 = str;
            m.e(str2, "id");
            WorkInfo.State state3 = state2;
            m.e(state3, MRAIDCommunicatorUtil.KEY_STATE);
            Data data2 = data;
            m.e(data2, "output");
            Constraints constraints3 = constraints2;
            m.e(constraints3, "constraints");
            BackoffPolicy backoffPolicy3 = backoffPolicy2;
            m.e(backoffPolicy3, "backoffPolicy");
            m.e(list, "tags");
            List<Data> list3 = list2;
            m.e(list3, "progress");
            List<Data> list4 = list3;
            return new WorkInfoPojo(str2, state3, data2, j4, j5, j6, constraints3, i4, backoffPolicy3, j7, j8, i5, i6, j9, i7, list, list4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return m.a(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && m.a(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && m.a(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && m.a(this.tags, workInfoPojo.tags) && m.a(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + u.a(this.initialDelay)) * 31) + u.a(this.intervalDuration)) * 31) + u.a(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31) + u.a(this.backoffDelayDuration)) * 31) + u.a(this.lastEnqueueTime)) * 31) + this.periodCount) * 31) + this.generation) * 31) + u.a(this.nextScheduleTimeOverride)) * 31) + this.stopReason) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final boolean isBackedOff() {
            if (this.state != WorkInfo.State.ENQUEUED || this.runAttemptCount <= 0) {
                return false;
            }
            return true;
        }

        public final boolean isPeriodic() {
            if (this.intervalDuration != 0) {
                return true;
            }
            return false;
        }

        public final void setBackoffDelayDuration(long j4) {
            this.backoffDelayDuration = j4;
        }

        public final void setBackoffPolicy(BackoffPolicy backoffPolicy2) {
            m.e(backoffPolicy2, "<set-?>");
            this.backoffPolicy = backoffPolicy2;
        }

        public final void setLastEnqueueTime(long j4) {
            this.lastEnqueueTime = j4;
        }

        public final void setPeriodCount(int i4) {
            this.periodCount = i4;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            Data data;
            if (!this.progress.isEmpty()) {
                data = this.progress.get(0);
            } else {
                data = Data.EMPTY;
            }
            Data data2 = data;
            UUID fromString = UUID.fromString(this.id);
            m.d(fromString, "fromString(id)");
            WorkInfo.State state2 = this.state;
            HashSet hashSet = new HashSet(this.tags);
            Data data3 = this.output;
            m.d(data2, "progress");
            return new WorkInfo(fromString, state2, hashSet, data3, data2, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ WorkInfoPojo(java.lang.String r29, androidx.work.WorkInfo.State r30, androidx.work.Data r31, long r32, long r34, long r36, androidx.work.Constraints r38, int r39, androidx.work.BackoffPolicy r40, long r41, long r43, int r45, int r46, long r47, int r49, java.util.List r50, java.util.List r51, int r52, kotlin.jvm.internal.C2103g r53) {
            /*
                r28 = this;
                r0 = r52
                r1 = r0 & 8
                r2 = 0
                if (r1 == 0) goto L_0x000a
                r8 = r2
                goto L_0x000c
            L_0x000a:
                r8 = r32
            L_0x000c:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0012
                r10 = r2
                goto L_0x0014
            L_0x0012:
                r10 = r34
            L_0x0014:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x001a
                r12 = r2
                goto L_0x001c
            L_0x001a:
                r12 = r36
            L_0x001c:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0025
                androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
                r16 = r1
                goto L_0x0027
            L_0x0025:
                r16 = r40
            L_0x0027:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x0030
                r4 = 30000(0x7530, double:1.4822E-319)
                r17 = r4
                goto L_0x0032
            L_0x0030:
                r17 = r41
            L_0x0032:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0039
                r19 = r2
                goto L_0x003b
            L_0x0039:
                r19 = r43
            L_0x003b:
                r0 = r0 & 2048(0x800, float:2.87E-42)
                if (r0 == 0) goto L_0x0059
                r0 = 0
                r21 = 0
            L_0x0042:
                r4 = r28
                r5 = r29
                r6 = r30
                r7 = r31
                r14 = r38
                r15 = r39
                r22 = r46
                r23 = r47
                r25 = r49
                r26 = r50
                r27 = r51
                goto L_0x005c
            L_0x0059:
                r21 = r45
                goto L_0x0042
            L_0x005c:
                r4.<init>(r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r22, r23, r25, r26, r27)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.WorkInfoPojo.<init>(java.lang.String, androidx.work.WorkInfo$State, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, int, int, long, int, java.util.List, java.util.List, int, kotlin.jvm.internal.g):void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkSpec(java.lang.String r35, androidx.work.WorkInfo.State r36, java.lang.String r37, java.lang.String r38, androidx.work.Data r39, androidx.work.Data r40, long r41, long r43, long r45, androidx.work.Constraints r47, int r48, androidx.work.BackoffPolicy r49, long r50, long r52, long r54, long r56, boolean r58, androidx.work.OutOfQuotaPolicy r59, int r60, int r61, long r62, int r64, int r65, int r66, kotlin.jvm.internal.C2103g r67) {
        /*
            r34 = this;
            r0 = r66
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r36
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001d
            java.lang.Class<androidx.work.OverwritingInputMerger> r1 = androidx.work.OverwritingInputMerger.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "OverwritingInputMerger::class.java.name"
            kotlin.jvm.internal.m.d(r1, r2)
            r6 = r1
            goto L_0x001f
        L_0x001d:
            r6 = r38
        L_0x001f:
            r1 = r0 & 16
            java.lang.String r2 = "EMPTY"
            if (r1 == 0) goto L_0x002c
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.m.d(r1, r2)
            r7 = r1
            goto L_0x002e
        L_0x002c:
            r7 = r39
        L_0x002e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0039
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.m.d(r1, r2)
            r8 = r1
            goto L_0x003b
        L_0x0039:
            r8 = r40
        L_0x003b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0043
            r9 = r2
            goto L_0x0045
        L_0x0043:
            r9 = r41
        L_0x0045:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x004b
            r11 = r2
            goto L_0x004d
        L_0x004b:
            r11 = r43
        L_0x004d:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0053
            r13 = r2
            goto L_0x0055
        L_0x0053:
            r13 = r45
        L_0x0055:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x005d
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r15 = r1
            goto L_0x005f
        L_0x005d:
            r15 = r47
        L_0x005f:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x0067
            r16 = 0
            goto L_0x0069
        L_0x0067:
            r16 = r48
        L_0x0069:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0072
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x0074
        L_0x0072:
            r17 = r49
        L_0x0074:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x007b
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x007d
        L_0x007b:
            r18 = r50
        L_0x007d:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r20 = -1
            if (r1 == 0) goto L_0x0086
            r22 = r20
            goto L_0x0088
        L_0x0086:
            r22 = r52
        L_0x0088:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r2 = r54
        L_0x008f:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0098
            r24 = r20
            goto L_0x009a
        L_0x0098:
            r24 = r56
        L_0x009a:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a2
            r26 = 0
            goto L_0x00a4
        L_0x00a2:
            r26 = r58
        L_0x00a4:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ae
            androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r27 = r1
            goto L_0x00b0
        L_0x00ae:
            r27 = r59
        L_0x00b0:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b8
            r28 = 0
            goto L_0x00ba
        L_0x00b8:
            r28 = r60
        L_0x00ba:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c2
            r29 = 0
            goto L_0x00c4
        L_0x00c2:
            r29 = r61
        L_0x00c4:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d1
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r30 = r20
            goto L_0x00d3
        L_0x00d1:
            r30 = r62
        L_0x00d3:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00db
            r32 = 0
            goto L_0x00dd
        L_0x00db:
            r32 = r64
        L_0x00dd:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00f1
            r0 = -256(0xffffffffffffff00, float:NaN)
            r33 = -256(0xffffffffffffff00, float:NaN)
        L_0x00e6:
            r5 = r37
            r20 = r22
            r22 = r2
            r2 = r34
            r3 = r35
            goto L_0x00f4
        L_0x00f1:
            r33 = r65
            goto L_0x00e6
        L_0x00f4:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, long, int, int, int, kotlin.jvm.internal.g):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r36, java.lang.String r37) {
        /*
            r35 = this;
            java.lang.String r0 = "id"
            r2 = r36
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "workerClassName_"
            r4 = r37
            kotlin.jvm.internal.m.e(r4, r0)
            r33 = 8388602(0x7ffffa, float:1.1754935E-38)
            r34 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 0
            r32 = 0
            r1 = r35
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r37, androidx.work.impl.model.WorkSpec r38) {
        /*
            r36 = this;
            r0 = r38
            java.lang.String r1 = "newId"
            r3 = r37
            kotlin.jvm.internal.m.e(r3, r1)
            java.lang.String r1 = "other"
            kotlin.jvm.internal.m.e(r0, r1)
            java.lang.String r5 = r0.workerClassName
            androidx.work.WorkInfo$State r4 = r0.state
            java.lang.String r6 = r0.inputMergerClassName
            androidx.work.Data r7 = new androidx.work.Data
            androidx.work.Data r1 = r0.input
            r7.<init>((androidx.work.Data) r1)
            androidx.work.Data r8 = new androidx.work.Data
            androidx.work.Data r1 = r0.output
            r8.<init>((androidx.work.Data) r1)
            long r9 = r0.initialDelay
            long r11 = r0.intervalDuration
            long r13 = r0.flexDuration
            androidx.work.Constraints r15 = new androidx.work.Constraints
            androidx.work.Constraints r1 = r0.constraints
            r15.<init>(r1)
            int r1 = r0.runAttemptCount
            androidx.work.BackoffPolicy r2 = r0.backoffPolicy
            r16 = r1
            r17 = r2
            long r1 = r0.backoffDelayDuration
            r18 = r1
            long r1 = r0.lastEnqueueTime
            r20 = r1
            long r1 = r0.minimumRetentionDuration
            r22 = r1
            long r1 = r0.scheduleRequestedAt
            r24 = r1
            boolean r1 = r0.expedited
            androidx.work.OutOfQuotaPolicy r2 = r0.outOfQuotaPolicy
            r26 = r1
            int r1 = r0.periodCount
            r28 = r1
            r27 = r2
            long r1 = r0.nextScheduleTimeOverride
            r30 = r1
            int r1 = r0.nextScheduleTimeOverrideGeneration
            int r0 = r0.stopReason
            r34 = 524288(0x80000, float:7.34684E-40)
            r35 = 0
            r29 = 0
            r2 = r36
            r33 = r0
            r32 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29, r30, r32, r33, r34, r35)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.impl.model.WorkSpec):void");
    }
}
