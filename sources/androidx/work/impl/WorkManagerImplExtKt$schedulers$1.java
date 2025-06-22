package androidx.work.impl;

import S2.C1594h;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import d3.t;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class WorkManagerImplExtKt$schedulers$1 extends n implements t {
    final /* synthetic */ Scheduler[] $schedulers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WorkManagerImplExtKt$schedulers$1(Scheduler[] schedulerArr) {
        super(6);
        this.$schedulers = schedulerArr;
    }

    public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        m.e(context, "<anonymous parameter 0>");
        m.e(configuration, "<anonymous parameter 1>");
        m.e(taskExecutor, "<anonymous parameter 2>");
        m.e(workDatabase, "<anonymous parameter 3>");
        m.e(trackers, "<anonymous parameter 4>");
        m.e(processor, "<anonymous parameter 5>");
        return C1594h.I(this.$schedulers);
    }
}
