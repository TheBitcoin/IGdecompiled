package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    private static boolean enqueueContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r18, @androidx.annotation.NonNull java.util.List<? extends androidx.work.WorkRequest> r19, java.lang.String[] r20, java.lang.String r21, androidx.work.ExistingWorkPolicy r22) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            androidx.work.Configuration r3 = r18.getConfiguration()
            androidx.work.Clock r3 = r3.getClock()
            long r3 = r3.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r18.getWorkDatabase()
            r7 = 0
            if (r0 == 0) goto L_0x001e
            int r8 = r0.length
            if (r8 <= 0) goto L_0x001e
            r8 = 1
            goto L_0x001f
        L_0x001e:
            r8 = 0
        L_0x001f:
            if (r8 == 0) goto L_0x006c
            int r9 = r0.length
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
        L_0x0026:
            if (r10 >= r9) goto L_0x006f
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x0054
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Prerequisite "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.error(r1, r2)
            return r7
        L_0x0054:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x005c
            r15 = 1
            goto L_0x005d
        L_0x005c:
            r15 = 0
        L_0x005d:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x0064
            r13 = 1
            goto L_0x0069
        L_0x0064:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0069
            r12 = 1
        L_0x0069:
            int r10 = r10 + 1
            goto L_0x0026
        L_0x006c:
            r11 = 1
            r12 = 0
            r13 = 0
        L_0x006f:
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x0158
            if (r8 != 0) goto L_0x0158
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x0158
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x008d
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x0090
        L_0x008d:
            r14 = r18
            goto L_0x00d7
        L_0x0090:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00af
            java.util.Iterator r2 = r10.iterator()
        L_0x0098:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00af
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r14 = r14.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 == r15) goto L_0x00ae
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.RUNNING
            if (r14 != r15) goto L_0x0098
        L_0x00ae:
            return r7
        L_0x00af:
            r14 = r18
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.forName(r1, r14, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00c0:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00d2
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r15 = r15.id
            r2.delete(r15)
            goto L_0x00c0
        L_0x00d2:
            r17 = r5
            r6 = 1
            goto L_0x015d
        L_0x00d7:
            androidx.work.impl.model.DependencyDao r8 = r5.dependencyDao()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00e4:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x011e
            java.lang.Object r16 = r10.next()
            r6 = r16
            androidx.work.impl.model.WorkSpec$IdAndState r6 = (androidx.work.impl.model.WorkSpec.IdAndState) r6
            java.lang.String r7 = r6.id
            boolean r7 = r8.hasDependents(r7)
            if (r7 != 0) goto L_0x0118
            androidx.work.WorkInfo$State r7 = r6.state
            r17 = r5
            androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r5) goto L_0x0104
            r5 = 1
            goto L_0x0105
        L_0x0104:
            r5 = 0
        L_0x0105:
            r5 = r5 & r11
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x010c
            r13 = 1
            goto L_0x0111
        L_0x010c:
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x0111
            r12 = 1
        L_0x0111:
            java.lang.String r6 = r6.id
            r15.add(r6)
            r11 = r5
            goto L_0x011a
        L_0x0118:
            r17 = r5
        L_0x011a:
            r5 = r17
            r7 = 0
            goto L_0x00e4
        L_0x011e:
            r17 = r5
            androidx.work.ExistingWorkPolicy r5 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r5) goto L_0x014a
            if (r12 != 0) goto L_0x0128
            if (r13 == 0) goto L_0x014a
        L_0x0128:
            androidx.work.impl.model.WorkSpecDao r2 = r17.workSpecDao()
            java.util.List r5 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r5 = r5.iterator()
        L_0x0134:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0146
            java.lang.Object r6 = r5.next()
            androidx.work.impl.model.WorkSpec$IdAndState r6 = (androidx.work.impl.model.WorkSpec.IdAndState) r6
            java.lang.String r6 = r6.id
            r2.delete(r6)
            goto L_0x0134
        L_0x0146:
            java.util.List r15 = java.util.Collections.EMPTY_LIST
            r12 = 0
            r13 = 0
        L_0x014a:
            java.lang.Object[] r0 = r15.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0155
            r8 = 1
            goto L_0x0156
        L_0x0155:
            r8 = 0
        L_0x0156:
            r6 = 0
            goto L_0x015d
        L_0x0158:
            r14 = r18
            r17 = r5
            goto L_0x0156
        L_0x015d:
            java.util.Iterator r2 = r19.iterator()
        L_0x0161:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x01ee
            java.lang.Object r5 = r2.next()
            androidx.work.WorkRequest r5 = (androidx.work.WorkRequest) r5
            androidx.work.impl.model.WorkSpec r7 = r5.getWorkSpec()
            if (r8 == 0) goto L_0x0188
            if (r11 != 0) goto L_0x0188
            if (r13 == 0) goto L_0x017c
            androidx.work.WorkInfo$State r10 = androidx.work.WorkInfo.State.FAILED
            r7.state = r10
            goto L_0x018a
        L_0x017c:
            if (r12 == 0) goto L_0x0183
            androidx.work.WorkInfo$State r10 = androidx.work.WorkInfo.State.CANCELLED
            r7.state = r10
            goto L_0x018a
        L_0x0183:
            androidx.work.WorkInfo$State r10 = androidx.work.WorkInfo.State.BLOCKED
            r7.state = r10
            goto L_0x018a
        L_0x0188:
            r7.lastEnqueueTime = r3
        L_0x018a:
            androidx.work.WorkInfo$State r10 = r7.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r10 != r15) goto L_0x0191
            r6 = 1
        L_0x0191:
            androidx.work.impl.model.WorkSpecDao r10 = r17.workSpecDao()
            java.util.List r15 = r14.getSchedulers()
            androidx.work.impl.model.WorkSpec r7 = androidx.work.impl.utils.EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r15, r7)
            r10.insertWorkSpec(r7)
            if (r8 == 0) goto L_0x01c3
            int r7 = r0.length
            r10 = 0
        L_0x01a4:
            if (r10 >= r7) goto L_0x01c3
            r15 = r0[r10]
            r20 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r19 = r2
            java.lang.String r2 = r5.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r17.dependencyDao()
            r2.insertDependency(r0)
            int r10 = r10 + 1
            r2 = r19
            r0 = r20
            goto L_0x01a4
        L_0x01c3:
            r20 = r0
            r19 = r2
            androidx.work.impl.model.WorkTagDao r0 = r17.workTagDao()
            java.lang.String r2 = r5.getStringId()
            java.util.Set r7 = r5.getTags()
            r0.insertTags(r2, r7)
            if (r9 != 0) goto L_0x01e8
            androidx.work.impl.model.WorkNameDao r0 = r17.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r5 = r5.getStringId()
            r2.<init>(r1, r5)
            r0.insert(r2)
        L_0x01e8:
            r2 = r19
            r0 = r20
            goto L_0x0161
        L_0x01ee:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    private static boolean processContinuation(@NonNull WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z4 = false;
        if (parents != null) {
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z4 |= processContinuation(next);
                } else {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.warning(str, "Already enqueued work ids (" + TextUtils.join(", ", next.getIds()) + ")");
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | z4;
    }

    @VisibleForTesting
    public boolean addToDatabase() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), this.mWorkContinuation);
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @NonNull
    public Operation getOperation() {
        return this.mOperation;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.markState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
        } catch (Throwable th) {
            this.mOperation.markState(new Operation.State.FAILURE(th));
        }
    }

    @VisibleForTesting
    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    public EnqueueRunnable(@NonNull WorkContinuationImpl workContinuationImpl, @NonNull OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }
}
