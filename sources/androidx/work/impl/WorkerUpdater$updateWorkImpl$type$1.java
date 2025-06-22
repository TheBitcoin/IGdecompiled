package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class WorkerUpdater$updateWorkImpl$type$1 extends n implements l {
    public static final WorkerUpdater$updateWorkImpl$type$1 INSTANCE = new WorkerUpdater$updateWorkImpl$type$1();

    WorkerUpdater$updateWorkImpl$type$1() {
        super(1);
    }

    public final String invoke(WorkSpec workSpec) {
        m.e(workSpec, "spec");
        return workSpec.isPeriodic() ? "Periodic" : "OneTime";
    }
}
