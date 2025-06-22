package androidx.datastore.core;

import V2.d;
import kotlin.coroutines.jvm.internal.b;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;
import x3.a;
import x3.c;

public final class SingleProcessCoordinator implements InterProcessCoordinator {
    private final String filePath;
    private final a mutex = c.b(false, 1, (Object) null);
    private final C1035e updateNotifications = C1037g.r(new SingleProcessCoordinator$updateNotifications$1((d) null));
    private final AtomicInt version = new AtomicInt(0);

    public SingleProcessCoordinator(String str) {
        m.e(str, "filePath");
        this.filePath = str;
    }

    public C1035e getUpdateNotifications() {
        return this.updateNotifications;
    }

    public Object getVersion(d dVar) {
        return b.b(this.version.get());
    }

    public Object incrementAndGetVersion(d dVar) {
        return b.b(this.version.incrementAndGet());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r9.c((java.lang.Object) null, r0) == r1) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object lock(d3.l r8, V2.d r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessCoordinator$lock$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator$lock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessCoordinator$lock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$lock$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r8 = r0.L$0
            x3.a r8 = (x3.a) r8
            R2.n.b(r9)     // Catch:{ all -> 0x0031 }
            goto L_0x006b
        L_0x0031:
            r9 = move-exception
            goto L_0x0073
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.L$1
            x3.a r8 = (x3.a) r8
            java.lang.Object r2 = r0.L$0
            d3.l r2 = (d3.l) r2
            R2.n.b(r9)
            r9 = r8
            r8 = r2
            goto L_0x005b
        L_0x0049:
            R2.n.b(r9)
            x3.a r9 = r7.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r9.c(r5, r0)
            if (r2 != r1) goto L_0x005b
            goto L_0x0067
        L_0x005b:
            r0.L$0 = r9     // Catch:{ all -> 0x006f }
            r0.L$1 = r5     // Catch:{ all -> 0x006f }
            r0.label = r3     // Catch:{ all -> 0x006f }
            java.lang.Object r8 = r8.invoke(r0)     // Catch:{ all -> 0x006f }
            if (r8 != r1) goto L_0x0068
        L_0x0067:
            return r1
        L_0x0068:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x006b:
            r8.d(r5)
            return r9
        L_0x006f:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0073:
            r8.d(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.lock(d3.l, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object tryLock(d3.p r7, V2.d r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessCoordinator$tryLock$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = (androidx.datastore.core.SingleProcessCoordinator$tryLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessCoordinator$tryLock$1 r0 = new androidx.datastore.core.SingleProcessCoordinator$tryLock$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            boolean r7 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            x3.a r0 = (x3.a) r0
            R2.n.b(r8)     // Catch:{ all -> 0x0030 }
            goto L_0x0057
        L_0x0030:
            r8 = move-exception
            goto L_0x0061
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            R2.n.b(r8)
            x3.a r8 = r6.mutex
            boolean r2 = r8.a(r4)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r2)     // Catch:{ all -> 0x005d }
            r0.L$0 = r8     // Catch:{ all -> 0x005d }
            r0.Z$0 = r2     // Catch:{ all -> 0x005d }
            r0.label = r3     // Catch:{ all -> 0x005d }
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch:{ all -> 0x005d }
            if (r7 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r8
            r8 = r7
            r7 = r2
        L_0x0057:
            if (r7 == 0) goto L_0x005c
            r0.d(r4)
        L_0x005c:
            return r8
        L_0x005d:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L_0x0061:
            if (r7 == 0) goto L_0x0066
            r0.d(r4)
        L_0x0066:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessCoordinator.tryLock(d3.p, V2.d):java.lang.Object");
    }
}
