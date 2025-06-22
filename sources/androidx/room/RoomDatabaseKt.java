package androidx.room;

import V2.d;
import W2.b;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.jvm.internal.h;
import o3.C0991n;
import o3.C1001s0;

public final class RoomDatabaseKt {
    /* access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, C1001s0 s0Var, d dVar) {
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        nVar.q(new RoomDatabaseKt$acquireTransactionThread$2$1(s0Var));
        try {
            executor.execute(new RoomDatabaseKt$acquireTransactionThread$2$2(nVar, s0Var));
        } catch (RejectedExecutionException e5) {
            nVar.y(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e5));
        }
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            h.c(dVar);
        }
        return v4;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object createTransactionContext(androidx.room.RoomDatabase r6, V2.d r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$createTransactionContext$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = (androidx.room.RoomDatabaseKt$createTransactionContext$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = new androidx.room.RoomDatabaseKt$createTransactionContext$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.L$1
            o3.y r6 = (o3.C1012y) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            R2.n.b(r7)
            goto L_0x006c
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            R2.n.b(r7)
            r7 = 0
            o3.y r7 = o3.C1013y0.b(r7, r3, r7)
            V2.g r2 = r0.getContext()
            o3.s0$b r4 = o3.C1001s0.f3726k0
            V2.g$b r2 = r2.get(r4)
            o3.s0 r2 = (o3.C1001s0) r2
            if (r2 == 0) goto L_0x0057
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>(r7)
            r2.i(r4)
        L_0x0057:
            java.util.concurrent.Executor r2 = r6.getTransactionExecutor()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = acquireTransactionThread(r2, r7, r0)
            if (r0 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x006c:
            V2.e r7 = (V2.e) r7
            androidx.room.TransactionElement r1 = new androidx.room.TransactionElement
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.getSuspendingTransactionId()
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.b(r6)
            o3.Q0 r6 = o3.R0.a(r0, r6)
            V2.g r7 = r7.plus(r1)
            V2.g r6 = r7.plus(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.createTransactionContext(androidx.room.RoomDatabase, V2.d):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: d3.l} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r7 == r1) goto L_0x007a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> java.lang.Object withTransaction(androidx.room.RoomDatabase r5, d3.l r6, V2.d r7) {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt$withTransaction$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = (androidx.room.RoomDatabaseKt$withTransaction$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = new androidx.room.RoomDatabaseKt$withTransaction$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            R2.n.b(r7)
            return r7
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            d3.l r6 = (d3.l) r6
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            R2.n.b(r7)
            goto L_0x0066
        L_0x0041:
            R2.n.b(r7)
            V2.g r7 = r0.getContext()
            androidx.room.TransactionElement$Key r2 = androidx.room.TransactionElement.Key
            V2.g$b r7 = r7.get(r2)
            androidx.room.TransactionElement r7 = (androidx.room.TransactionElement) r7
            if (r7 == 0) goto L_0x0059
            V2.e r7 = r7.getTransactionDispatcher$room_ktx_release()
            if (r7 == 0) goto L_0x0059
            goto L_0x0068
        L_0x0059:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = createTransactionContext(r5, r0)
            if (r7 != r1) goto L_0x0066
            goto L_0x007a
        L_0x0066:
            V2.g r7 = (V2.g) r7
        L_0x0068:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r5 = o3.C0977g.g(r7, r2, r0)
            if (r5 != r1) goto L_0x007b
        L_0x007a:
            return r1
        L_0x007b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.withTransaction(androidx.room.RoomDatabase, d3.l, V2.d):java.lang.Object");
    }
}
