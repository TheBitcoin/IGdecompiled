package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import d3.t;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

/* synthetic */ class WorkManagerImplExtKt$WorkManagerImpl$1 extends k implements t {
    public static final WorkManagerImplExtKt$WorkManagerImpl$1 INSTANCE = new WorkManagerImplExtKt$WorkManagerImpl$1();

    WorkManagerImplExtKt$WorkManagerImpl$1() {
        super(6, WorkManagerImplExtKt.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    public final List<Scheduler> invoke(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        m.e(context, "p0");
        m.e(configuration, "p1");
        m.e(taskExecutor, "p2");
        m.e(workDatabase, "p3");
        m.e(trackers, "p4");
        m.e(processor, "p5");
        return WorkManagerImplExtKt.createSchedulers(context, configuration, taskExecutor, workDatabase, trackers, processor);
    }
}
