package androidx.work.impl;

import S2.C1601o;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Operation;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.EnqueueUtilsKt;
import androidx.work.impl.utils.futures.SettableFuture;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.a;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;
import o0.C2172d;

public final class WorkerUpdater {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Operation enqueueUniquelyNamedPeriodic(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        m.e(workManagerImpl, "<this>");
        m.e(str, RewardPlus.NAME);
        m.e(workRequest, "workRequest");
        OperationImpl operationImpl = new OperationImpl();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new k(workManagerImpl, str, operationImpl, new WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1(workRequest, workManagerImpl, str, operationImpl), workRequest));
        return operationImpl;
    }

    /* access modifiers changed from: private */
    public static final void enqueueUniquelyNamedPeriodic$lambda$4(WorkManagerImpl workManagerImpl, String str, OperationImpl operationImpl, a aVar, WorkRequest workRequest) {
        String str2 = str;
        OperationImpl operationImpl2 = operationImpl;
        WorkManagerImpl workManagerImpl2 = workManagerImpl;
        m.e(workManagerImpl2, "$this_enqueueUniquelyNamedPeriodic");
        m.e(str2, "$name");
        m.e(operationImpl2, "$operation");
        a aVar2 = aVar;
        m.e(aVar2, "$enqueueNew");
        WorkRequest workRequest2 = workRequest;
        m.e(workRequest2, "$workRequest");
        WorkSpecDao workSpecDao = workManagerImpl2.getWorkDatabase().workSpecDao();
        List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workSpecDao.getWorkSpecIdAndStatesForName(str2);
        if (workSpecIdAndStatesForName.size() > 1) {
            failWorkTypeChanged(operationImpl2, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) C1601o.I(workSpecIdAndStatesForName);
        if (idAndState == null) {
            aVar2.invoke();
            return;
        }
        WorkSpec workSpec = workSpecDao.getWorkSpec(idAndState.id);
        if (workSpec == null) {
            operationImpl2.markState(new Operation.State.FAILURE(new IllegalStateException("WorkSpec with " + idAndState.id + ", that matches a name \"" + str2 + "\", wasn't found")));
        } else if (!workSpec.isPeriodic()) {
            failWorkTypeChanged(operationImpl2, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
        } else if (idAndState.state == WorkInfo.State.CANCELLED) {
            workSpecDao.delete(idAndState.id);
            aVar2.invoke();
        } else {
            WorkSpec copy$default = WorkSpec.copy$default(workRequest2.getWorkSpec(), idAndState.id, (WorkInfo.State) null, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, 8388606, (Object) null);
            try {
                Processor processor = workManagerImpl2.getProcessor();
                m.d(processor, "processor");
                WorkDatabase workDatabase = workManagerImpl2.getWorkDatabase();
                m.d(workDatabase, "workDatabase");
                Configuration configuration = workManagerImpl2.getConfiguration();
                m.d(configuration, "configuration");
                List<Scheduler> schedulers = workManagerImpl2.getSchedulers();
                m.d(schedulers, "schedulers");
                Configuration configuration2 = configuration;
                updateWorkImpl(processor, workDatabase, configuration2, schedulers, copy$default, workRequest2.getTags());
                operationImpl2.markState(Operation.SUCCESS);
            } catch (Throwable th) {
                operationImpl2.markState(new Operation.State.FAILURE(th));
            }
        }
    }

    private static final void failWorkTypeChanged(OperationImpl operationImpl, String str) {
        operationImpl.markState(new Operation.State.FAILURE(new UnsupportedOperationException(str)));
    }

    private static final WorkManager.UpdateResult updateWorkImpl(Processor processor, WorkDatabase workDatabase, Configuration configuration, List<? extends Scheduler> list, WorkSpec workSpec, Set<String> set) {
        String str = workSpec.id;
        WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        } else if (workSpec2.state.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        } else {
            if (!(workSpec2.isPeriodic() ^ workSpec.isPeriodic())) {
                boolean isEnqueued = processor.isEnqueued(str);
                if (!isEnqueued) {
                    for (Scheduler cancel : list) {
                        cancel.cancel(str);
                    }
                }
                WorkDatabase workDatabase2 = workDatabase;
                List<? extends Scheduler> list2 = list;
                workDatabase2.runInTransaction((Runnable) new i(workDatabase2, workSpec2, workSpec, list2, str, set, isEnqueued));
                if (!isEnqueued) {
                    Schedulers.schedule(configuration, workDatabase2, list2);
                }
                return isEnqueued ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
            }
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = WorkerUpdater$updateWorkImpl$type$1.INSTANCE;
            throw new UnsupportedOperationException("Can't update " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpec2)) + " Worker to " + ((String) workerUpdater$updateWorkImpl$type$1.invoke(workSpec)) + " Worker. Update operation must preserve worker's type.");
        }
    }

    /* access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$2(WorkDatabase workDatabase, WorkSpec workSpec, WorkSpec workSpec2, List list, String str, Set set, boolean z4) {
        WorkSpec workSpec3 = workSpec;
        List list2 = list;
        String str2 = str;
        Set set2 = set;
        WorkDatabase workDatabase2 = workDatabase;
        m.e(workDatabase2, "$workDatabase");
        m.e(workSpec3, "$oldWorkSpec");
        WorkSpec workSpec4 = workSpec2;
        m.e(workSpec4, "$newWorkSpec");
        m.e(list2, "$schedulers");
        m.e(str2, "$workSpecId");
        m.e(set2, "$tags");
        WorkSpecDao workSpecDao = workDatabase2.workSpecDao();
        WorkTagDao workTagDao = workDatabase2.workTagDao();
        WorkInfo.State state = workSpec3.state;
        int i4 = workSpec3.runAttemptCount;
        long j4 = workSpec3.lastEnqueueTime;
        int periodCount = workSpec3.getPeriodCount();
        long nextScheduleTimeOverride = workSpec3.getNextScheduleTimeOverride();
        int nextScheduleTimeOverrideGeneration = workSpec3.getNextScheduleTimeOverrideGeneration();
        WorkTagDao workTagDao2 = workTagDao;
        WorkSpec copy$default = WorkSpec.copy$default(workSpec4, (String) null, state, (String) null, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, i4, (BackoffPolicy) null, 0, j4, 0, 0, false, (OutOfQuotaPolicy) null, periodCount, workSpec3.getGeneration() + 1, nextScheduleTimeOverride, nextScheduleTimeOverrideGeneration, 0, 4447229, (Object) null);
        if (workSpec2.getNextScheduleTimeOverrideGeneration() == 1) {
            copy$default.setNextScheduleTimeOverride(workSpec2.getNextScheduleTimeOverride());
            copy$default.setNextScheduleTimeOverrideGeneration(copy$default.getNextScheduleTimeOverrideGeneration() + 1);
        }
        workSpecDao.updateWorkSpec(EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(list2, copy$default));
        workTagDao2.deleteByWorkSpecId(str2);
        workTagDao2.insertTags(str2, set2);
        if (!z4) {
            workSpecDao.markWorkSpecScheduled(str2, -1);
            workDatabase.workProgressDao().delete(str2);
        }
    }

    /* access modifiers changed from: private */
    public static final void updateWorkImpl$lambda$3(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        m.e(workManagerImpl, "$this_updateWorkImpl");
        m.e(workRequest, "$workRequest");
        if (!settableFuture.isCancelled()) {
            try {
                Processor processor = workManagerImpl.getProcessor();
                m.d(processor, "processor");
                WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
                m.d(workDatabase, "workDatabase");
                Configuration configuration = workManagerImpl.getConfiguration();
                m.d(configuration, "configuration");
                List<Scheduler> schedulers = workManagerImpl.getSchedulers();
                m.d(schedulers, "schedulers");
                settableFuture.set(updateWorkImpl(processor, workDatabase, configuration, schedulers, workRequest.getWorkSpec(), workRequest.getTags()));
            } catch (Throwable th) {
                settableFuture.setException(th);
            }
        }
    }

    public static final C2172d updateWorkImpl(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        m.e(workManagerImpl, "<this>");
        m.e(workRequest, "workRequest");
        SettableFuture create = SettableFuture.create();
        workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor().execute(new j(create, workManagerImpl, workRequest));
        m.d(create, "future");
        return create;
    }
}
