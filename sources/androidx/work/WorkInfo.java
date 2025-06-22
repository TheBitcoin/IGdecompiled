package androidx.work;

import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.privacysandbox.ads.adservices.adselection.u;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class WorkInfo {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final int STOP_REASON_APP_STANDBY = 12;
    public static final int STOP_REASON_BACKGROUND_RESTRICTION = 11;
    public static final int STOP_REASON_CANCELLED_BY_APP = 1;
    public static final int STOP_REASON_CONSTRAINT_BATTERY_NOT_LOW = 5;
    public static final int STOP_REASON_CONSTRAINT_CHARGING = 6;
    public static final int STOP_REASON_CONSTRAINT_CONNECTIVITY = 7;
    public static final int STOP_REASON_CONSTRAINT_DEVICE_IDLE = 8;
    public static final int STOP_REASON_CONSTRAINT_STORAGE_NOT_LOW = 9;
    public static final int STOP_REASON_DEVICE_STATE = 4;
    public static final int STOP_REASON_ESTIMATED_APP_LAUNCH_TIME_CHANGED = 15;
    public static final int STOP_REASON_NOT_STOPPED = -256;
    public static final int STOP_REASON_PREEMPT = 2;
    public static final int STOP_REASON_QUOTA = 10;
    public static final int STOP_REASON_SYSTEM_PROCESSING = 14;
    public static final int STOP_REASON_TIMEOUT = 3;
    public static final int STOP_REASON_UNKNOWN = -512;
    public static final int STOP_REASON_USER = 13;
    private final Constraints constraints;
    private final int generation;
    private final UUID id;
    private final long initialDelayMillis;
    private final long nextScheduleTimeMillis;
    private final Data outputData;
    private final PeriodicityInfo periodicityInfo;
    private final Data progress;
    private final int runAttemptCount;
    private final State state;
    private final int stopReason;
    private final Set<String> tags;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class PeriodicityInfo {
        private final long flexIntervalMillis;
        private final long repeatIntervalMillis;

        public PeriodicityInfo(long j4, long j5) {
            this.repeatIntervalMillis = j4;
            this.flexIntervalMillis = j5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (m.a(PeriodicityInfo.class, obj.getClass())) {
                    PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
                    if (periodicityInfo.repeatIntervalMillis == this.repeatIntervalMillis && periodicityInfo.flexIntervalMillis == this.flexIntervalMillis) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public final long getFlexIntervalMillis() {
            return this.flexIntervalMillis;
        }

        public final long getRepeatIntervalMillis() {
            return this.repeatIntervalMillis;
        }

        public int hashCode() {
            return (u.a(this.repeatIntervalMillis) * 31) + u.a(this.flexIntervalMillis);
        }

        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.repeatIntervalMillis + ", flexIntervalMillis=" + this.flexIntervalMillis + '}';
        }
    }

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            if (this == SUCCEEDED || this == FAILED || this == CANCELLED) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            r16 = 4088(0xff8, float:5.729E-42)
            r17 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (m.a(WorkInfo.class, obj.getClass())) {
                WorkInfo workInfo = (WorkInfo) obj;
                if (this.runAttemptCount == workInfo.runAttemptCount && this.generation == workInfo.generation && m.a(this.id, workInfo.id) && this.state == workInfo.state && m.a(this.outputData, workInfo.outputData) && m.a(this.constraints, workInfo.constraints) && this.initialDelayMillis == workInfo.initialDelayMillis && m.a(this.periodicityInfo, workInfo.periodicityInfo) && this.nextScheduleTimeMillis == workInfo.nextScheduleTimeMillis && this.stopReason == workInfo.stopReason && m.a(this.tags, workInfo.tags)) {
                    return m.a(this.progress, workInfo.progress);
                }
                return false;
            }
        }
        return false;
    }

    public final Constraints getConstraints() {
        return this.constraints;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final UUID getId() {
        return this.id;
    }

    public final long getInitialDelayMillis() {
        return this.initialDelayMillis;
    }

    public final long getNextScheduleTimeMillis() {
        return this.nextScheduleTimeMillis;
    }

    public final Data getOutputData() {
        return this.outputData;
    }

    public final PeriodicityInfo getPeriodicityInfo() {
        return this.periodicityInfo;
    }

    public final Data getProgress() {
        return this.progress;
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    public final State getState() {
        return this.state;
    }

    @RequiresApi(31)
    public final int getStopReason() {
        return this.stopReason;
    }

    public final Set<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int i4;
        int hashCode = ((((((((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.outputData.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.runAttemptCount) * 31) + this.generation) * 31) + this.constraints.hashCode()) * 31) + u.a(this.initialDelayMillis)) * 31;
        PeriodicityInfo periodicityInfo2 = this.periodicityInfo;
        if (periodicityInfo2 != null) {
            i4 = periodicityInfo2.hashCode();
        } else {
            i4 = 0;
        }
        return ((((hashCode + i4) * 31) + u.a(this.nextScheduleTimeMillis)) * 31) + this.stopReason;
    }

    public String toString() {
        return "WorkInfo{id='" + this.id + "', state=" + this.state + ", outputData=" + this.outputData + ", tags=" + this.tags + ", progress=" + this.progress + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", constraints=" + this.constraints + ", initialDelayMillis=" + this.initialDelayMillis + ", periodicityInfo=" + this.periodicityInfo + ", nextScheduleTimeMillis=" + this.nextScheduleTimeMillis + "}, stopReason=" + this.stopReason;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            r16 = 4080(0xff0, float:5.717E-42)
            r17 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            r16 = 4064(0xfe0, float:5.695E-42)
            r17 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            r16 = 4032(0xfc0, float:5.65E-42)
            r17 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            r16 = 3968(0xf80, float:5.56E-42)
            r17 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r8 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25, androidx.work.Constraints r26) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            java.lang.String r0 = "constraints"
            r9 = r26
            kotlin.jvm.internal.m.e(r9, r0)
            r16 = 3840(0xf00, float:5.381E-42)
            r17 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r8 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25, androidx.work.Constraints r26, long r27) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            java.lang.String r0 = "constraints"
            r9 = r26
            kotlin.jvm.internal.m.e(r9, r0)
            r16 = 3584(0xe00, float:5.022E-42)
            r17 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r8 = r25
            r10 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints, long):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25, androidx.work.Constraints r26, long r27, androidx.work.WorkInfo.PeriodicityInfo r29) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            java.lang.String r0 = "constraints"
            r9 = r26
            kotlin.jvm.internal.m.e(r9, r0)
            r16 = 3072(0xc00, float:4.305E-42)
            r17 = 0
            r13 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r8 = r25
            r10 = r27
            r12 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints, long, androidx.work.WorkInfo$PeriodicityInfo):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set<java.lang.String> r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25, androidx.work.Constraints r26, long r27, androidx.work.WorkInfo.PeriodicityInfo r29, long r30) {
        /*
            r18 = this;
            java.lang.String r0 = "id"
            r2 = r19
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "state"
            r3 = r20
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "tags"
            r4 = r21
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "outputData"
            r5 = r22
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "progress"
            r6 = r23
            kotlin.jvm.internal.m.e(r6, r0)
            java.lang.String r0 = "constraints"
            r9 = r26
            kotlin.jvm.internal.m.e(r9, r0)
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 0
            r15 = 0
            r1 = r18
            r7 = r24
            r8 = r25
            r10 = r27
            r12 = r29
            r13 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints, long, androidx.work.WorkInfo$PeriodicityInfo, long):void");
    }

    public WorkInfo(UUID uuid, State state2, Set<String> set, Data data, Data data2, int i4, int i5, Constraints constraints2, long j4, PeriodicityInfo periodicityInfo2, long j5, int i6) {
        m.e(uuid, "id");
        m.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        m.e(set, "tags");
        m.e(data, "outputData");
        m.e(data2, "progress");
        m.e(constraints2, "constraints");
        this.id = uuid;
        this.state = state2;
        this.tags = set;
        this.outputData = data;
        this.progress = data2;
        this.runAttemptCount = i4;
        this.generation = i5;
        this.constraints = constraints2;
        this.initialDelayMillis = j4;
        this.periodicityInfo = periodicityInfo2;
        this.nextScheduleTimeMillis = j5;
        this.stopReason = i6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkInfo(java.util.UUID r19, androidx.work.WorkInfo.State r20, java.util.Set r21, androidx.work.Data r22, androidx.work.Data r23, int r24, int r25, androidx.work.Constraints r26, long r27, androidx.work.WorkInfo.PeriodicityInfo r29, long r30, int r32, int r33, kotlin.jvm.internal.C2103g r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 8
            java.lang.String r2 = "EMPTY"
            if (r1 == 0) goto L_0x000f
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.m.d(r1, r2)
            r7 = r1
            goto L_0x0011
        L_0x000f:
            r7 = r22
        L_0x0011:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001c
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.m.d(r1, r2)
            r8 = r1
            goto L_0x001e
        L_0x001c:
            r8 = r23
        L_0x001e:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0025
            r9 = 0
            goto L_0x0027
        L_0x0025:
            r9 = r24
        L_0x0027:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002d
            r10 = 0
            goto L_0x002f
        L_0x002d:
            r10 = r25
        L_0x002f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0037
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r11 = r1
            goto L_0x0039
        L_0x0037:
            r11 = r26
        L_0x0039:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0041
            r1 = 0
            r12 = r1
            goto L_0x0043
        L_0x0041:
            r12 = r27
        L_0x0043:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x004a
            r1 = 0
            r14 = r1
            goto L_0x004c
        L_0x004a:
            r14 = r29
        L_0x004c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0057
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r15 = r1
            goto L_0x0059
        L_0x0057:
            r15 = r30
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x006a
            r0 = -256(0xffffffffffffff00, float:NaN)
            r17 = -256(0xffffffffffffff00, float:NaN)
        L_0x0061:
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            goto L_0x006d
        L_0x006a:
            r17 = r32
            goto L_0x0061
        L_0x006d:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkInfo.<init>(java.util.UUID, androidx.work.WorkInfo$State, java.util.Set, androidx.work.Data, androidx.work.Data, int, int, androidx.work.Constraints, long, androidx.work.WorkInfo$PeriodicityInfo, long, int, int, kotlin.jvm.internal.g):void");
    }
}
