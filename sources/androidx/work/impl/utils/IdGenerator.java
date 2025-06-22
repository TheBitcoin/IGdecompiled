package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.m;

public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public IdGenerator(WorkDatabase workDatabase2) {
        m.e(workDatabase2, "workDatabase");
        this.workDatabase = workDatabase2;
    }

    /* access modifiers changed from: private */
    public static final Integer nextAlarmManagerId$lambda$1(IdGenerator idGenerator) {
        m.e(idGenerator, "this$0");
        return Integer.valueOf(IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }

    /* access modifiers changed from: private */
    public static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator idGenerator, int i4, int i5) {
        m.e(idGenerator, "this$0");
        int access$nextId = IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        if (i4 > access$nextId || access$nextId > i5) {
            IdGeneratorKt.updatePreference(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, i4 + 1);
        } else {
            i4 = access$nextId;
        }
        return Integer.valueOf(i4);
    }

    public final int nextAlarmManagerId() {
        Object runInTransaction = this.workDatabase.runInTransaction(new e(this));
        m.d(runInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) runInTransaction).intValue();
    }

    public final int nextJobSchedulerIdWithRange(int i4, int i5) {
        Object runInTransaction = this.workDatabase.runInTransaction(new f(this, i4, i5));
        m.d(runInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) runInTransaction).intValue();
    }
}
