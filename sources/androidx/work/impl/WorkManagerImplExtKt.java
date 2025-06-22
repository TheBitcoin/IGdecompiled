package androidx.work.impl;

import S2.C1601o;
import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import d3.t;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class WorkManagerImplExtKt {
    /* access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler createBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        m.d(createBestAvailableBackgroundScheduler, "createBestAvailableBackg…kDatabase, configuration)");
        return C1601o.k(createBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    public static final WorkManagerImpl createTestWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        m.d(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
        return createWorkManager$default(context, configuration, taskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), (Trackers) null, (Processor) null, (t) null, 112, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        return createWorkManager$default(context, configuration, (TaskExecutor) null, (WorkDatabase) null, (Trackers) null, (Processor) null, (t) null, 124, (Object) null);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, t tVar, int i4, Object obj) {
        Trackers trackers2;
        Processor processor2;
        WorkManagerImplExtKt$WorkManagerImpl$1 workManagerImplExtKt$WorkManagerImpl$1;
        if ((i4 & 4) != 0) {
            taskExecutor = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
        }
        TaskExecutor taskExecutor2 = taskExecutor;
        if ((i4 & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            m.d(applicationContext, "context.applicationContext");
            SerialExecutor serialTaskExecutor = taskExecutor2.getSerialTaskExecutor();
            m.d(serialTaskExecutor, "workTaskExecutor.serialTaskExecutor");
            workDatabase = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(R.bool.workmanager_test_configuration));
        }
        if ((i4 & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            m.d(applicationContext2, "context.applicationContext");
            trackers2 = new Trackers(applicationContext2, taskExecutor2, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (C2103g) null);
        } else {
            trackers2 = trackers;
        }
        if ((i4 & 32) != 0) {
            processor2 = new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase);
        } else {
            processor2 = processor;
        }
        if ((i4 & 64) != 0) {
            workManagerImplExtKt$WorkManagerImpl$1 = WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE;
        } else {
            workManagerImplExtKt$WorkManagerImpl$1 = tVar;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase, trackers2, processor2, workManagerImplExtKt$WorkManagerImpl$1);
    }

    public static final t schedulers(Scheduler... schedulerArr) {
        m.e(schedulerArr, "schedulers");
        return new WorkManagerImplExtKt$schedulers$1(schedulerArr);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        return createWorkManager$default(context, configuration, taskExecutor, (WorkDatabase) null, (Trackers) null, (Processor) null, (t) null, 120, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        m.e(workDatabase, "workDatabase");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, (Trackers) null, (Processor) null, (t) null, 112, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        m.e(workDatabase, "workDatabase");
        m.e(trackers, "trackers");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, (Processor) null, (t) null, 96, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        m.e(workDatabase, "workDatabase");
        m.e(trackers, "trackers");
        m.e(processor, "processor");
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, processor, (t) null, 64, (Object) null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, t tVar) {
        m.e(context, "context");
        m.e(configuration, "configuration");
        m.e(taskExecutor, "workTaskExecutor");
        m.e(workDatabase, "workDatabase");
        m.e(trackers, "trackers");
        m.e(processor, "processor");
        m.e(tVar, "schedulersCreator");
        Configuration configuration2 = configuration;
        Context context2 = context;
        t tVar2 = tVar;
        Processor processor2 = processor;
        Trackers trackers2 = trackers;
        WorkDatabase workDatabase2 = workDatabase;
        TaskExecutor taskExecutor2 = taskExecutor;
        Configuration configuration3 = configuration2;
        return new WorkManagerImpl(context2.getApplicationContext(), configuration3, taskExecutor2, workDatabase2, (List) tVar2.invoke(context2, configuration3, taskExecutor2, workDatabase2, trackers2, processor2), processor2, trackers2);
    }
}
