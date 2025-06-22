package androidx.work.impl.utils;

import S2.C1601o;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;

public final class EnqueueUtilsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i4;
        m.e(workDatabase, "workDatabase");
        m.e(configuration, "configuration");
        m.e(workContinuationImpl, "continuation");
        if (Build.VERSION.SDK_INT >= 24) {
            List l4 = C1601o.l(workContinuationImpl);
            int i5 = 0;
            while (!l4.isEmpty()) {
                WorkContinuationImpl workContinuationImpl2 = (WorkContinuationImpl) C1601o.x(l4);
                List<? extends WorkRequest> work = workContinuationImpl2.getWork();
                m.d(work, "current.work");
                Iterable<WorkRequest> iterable = work;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    i4 = 0;
                    for (WorkRequest workSpec : iterable) {
                        if (workSpec.getWorkSpec().constraints.hasContentUriTriggers() && (i4 = i4 + 1) < 0) {
                            C1601o.n();
                        }
                    }
                } else {
                    i4 = 0;
                }
                i5 += i4;
                List<WorkContinuationImpl> parents = workContinuationImpl2.getParents();
                if (parents != null) {
                    l4.addAll(parents);
                }
            }
            if (i5 != 0) {
                int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
                int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
                if (countNonFinishedContentUriTriggerWorkers + i5 > contentUriTriggerWorkersLimit) {
                    throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + contentUriTriggerWorkersLimit + ";\nalready enqueued count: " + countNonFinishedContentUriTriggerWorkers + ";\ncurrent enqueue operation count: " + i5 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
                }
            }
        }
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        WorkSpec workSpec2 = workSpec;
        m.e(workSpec2, "workSpec");
        Constraints constraints = workSpec2.constraints;
        String str = workSpec2.workerClassName;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (m.a(str, cls.getName()) || (!constraints.requiresBatteryNotLow() && !constraints.requiresStorageNotLow())) {
            return workSpec;
        }
        Data build = new Data.Builder().putAll(workSpec2.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build();
        m.d(build, "Builder().putAll(workSpe…ame)\n            .build()");
        String name = cls.getName();
        m.d(name, RewardPlus.NAME);
        return WorkSpec.copy$default(workSpec2, (String) null, (WorkInfo.State) null, name, (String) null, build, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 0, 0, 0, 8388587, (Object) null);
    }

    private static final boolean usesScheduler(List<? extends Scheduler> list, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterable<Scheduler> iterable = list;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            for (Scheduler scheduler : iterable) {
                if (cls.isAssignableFrom(scheduler.getClass())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException unused) {
        }
    }

    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> list, WorkSpec workSpec) {
        m.e(list, "schedulers");
        m.e(workSpec, "workSpec");
        int i4 = Build.VERSION.SDK_INT;
        if (23 <= i4 && i4 < 26) {
            return tryDelegateConstrainedWorkSpec(workSpec);
        }
        if (i4 > 22 || !usesScheduler(list, Schedulers.GCM_SCHEDULER)) {
            return workSpec;
        }
        return tryDelegateConstrainedWorkSpec(workSpec);
    }
}
