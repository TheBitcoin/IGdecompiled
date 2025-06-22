package androidx.datastore.core;

import R2.s;
import V2.d;
import W2.b;
import o3.C1001s0;
import o3.C1006v;
import o3.C1010x;
import x3.a;
import x3.c;

public abstract class RunOnce {
    private final C1006v didRun = C1010x.b((C1001s0) null, 1, (Object) null);
    private final a runMutex = c.b(false, 1, (Object) null);

    public final Object awaitComplete(d dVar) {
        Object p4 = this.didRun.p(dVar);
        if (p4 == b.c()) {
            return p4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public abstract Object doRun(d dVar);

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c A[SYNTHETIC, Splitter:B:32:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runIfNeeded(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.RunOnce$runIfNeeded$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce$runIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004c
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.L$1
            x3.a r1 = (x3.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            R2.n.b(r7)     // Catch:{ all -> 0x0035 }
            goto L_0x008b
        L_0x0035:
            r7 = move-exception
            goto L_0x0096
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003f:
            java.lang.Object r2 = r0.L$1
            x3.a r2 = (x3.a) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.RunOnce r4 = (androidx.datastore.core.RunOnce) r4
            R2.n.b(r7)
            r7 = r2
            goto L_0x006a
        L_0x004c:
            R2.n.b(r7)
            o3.v r7 = r6.didRun
            boolean r7 = r7.A()
            if (r7 == 0) goto L_0x005a
            R2.s r7 = R2.s.f8222a
            return r7
        L_0x005a:
            x3.a r7 = r6.runMutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r7.c(r5, r0)
            if (r2 != r1) goto L_0x0069
            goto L_0x0088
        L_0x0069:
            r4 = r6
        L_0x006a:
            o3.v r2 = r4.didRun     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.A()     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x007c
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0078 }
            r7.d(r5)
            return r0
        L_0x0078:
            r0 = move-exception
            r1 = r7
            r7 = r0
            goto L_0x0096
        L_0x007c:
            r0.L$0 = r4     // Catch:{ all -> 0x0078 }
            r0.L$1 = r7     // Catch:{ all -> 0x0078 }
            r0.label = r3     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r4.doRun(r0)     // Catch:{ all -> 0x0078 }
            if (r0 != r1) goto L_0x0089
        L_0x0088:
            return r1
        L_0x0089:
            r1 = r7
            r0 = r4
        L_0x008b:
            o3.v r7 = r0.didRun     // Catch:{ all -> 0x0035 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0035 }
            r7.v(r0)     // Catch:{ all -> 0x0035 }
            r1.d(r5)
            return r0
        L_0x0096:
            r1.d(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(V2.d):java.lang.Object");
    }
}
