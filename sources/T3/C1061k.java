package t3;

import R2.s;
import V2.d;
import d3.l;
import o3.C0970c0;
import o3.S0;

/* renamed from: t3.k  reason: case insensitive filesystem */
public abstract class C1061k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f4500a = new F("UNDEFINED");

    /* renamed from: b  reason: collision with root package name */
    public static final F f4501b = new F("REUSABLE_CLAIMED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r8.P0() != false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        if (r8.P0() != false) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(V2.d r6, java.lang.Object r7, d3.l r8) {
        /*
            boolean r0 = r6 instanceof t3.C1060j
            if (r0 == 0) goto L_0x00b3
            t3.j r6 = (t3.C1060j) r6
            java.lang.Object r8 = o3.E.b(r7, r8)
            o3.G r0 = r6.f4496d
            V2.g r1 = r6.getContext()
            boolean r0 = r0.isDispatchNeeded(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f4498f = r8
            r6.f3680c = r1
            o3.G r7 = r6.f4496d
            V2.g r8 = r6.getContext()
            r7.dispatch(r8, r6)
            goto L_0x00ad
        L_0x0026:
            o3.S0 r0 = o3.S0.f3672a
            o3.c0 r0 = r0.b()
            boolean r2 = r0.L()
            if (r2 == 0) goto L_0x003b
            r6.f4498f = r8
            r6.f3680c = r1
            r0.H(r6)
            goto L_0x00ad
        L_0x003b:
            r0.J(r1)
            r2 = 0
            V2.g r3 = r6.getContext()     // Catch:{ all -> 0x0068 }
            o3.s0$b r4 = o3.C1001s0.f3726k0     // Catch:{ all -> 0x0068 }
            V2.g$b r3 = r3.get(r4)     // Catch:{ all -> 0x0068 }
            o3.s0 r3 = (o3.C1001s0) r3     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x006a
            boolean r4 = r3.isActive()     // Catch:{ all -> 0x0068 }
            if (r4 != 0) goto L_0x006a
            java.util.concurrent.CancellationException r7 = r3.l()     // Catch:{ all -> 0x0068 }
            r6.a(r8, r7)     // Catch:{ all -> 0x0068 }
            R2.m$a r8 = R2.m.f8216a     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = R2.n.a(r7)     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = R2.m.a(r7)     // Catch:{ all -> 0x0068 }
            r6.resumeWith(r7)     // Catch:{ all -> 0x0068 }
            goto L_0x0092
        L_0x0068:
            r7 = move-exception
            goto L_0x00a9
        L_0x006a:
            V2.d r8 = r6.f4497e     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = r6.f4499g     // Catch:{ all -> 0x0068 }
            V2.g r4 = r8.getContext()     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = t3.J.c(r4, r3)     // Catch:{ all -> 0x0068 }
            t3.F r5 = t3.J.f4469a     // Catch:{ all -> 0x0068 }
            if (r3 == r5) goto L_0x007f
            o3.U0 r8 = o3.F.g(r8, r4, r3)     // Catch:{ all -> 0x0068 }
            goto L_0x0080
        L_0x007f:
            r8 = r2
        L_0x0080:
            V2.d r5 = r6.f4497e     // Catch:{ all -> 0x009c }
            r5.resumeWith(r7)     // Catch:{ all -> 0x009c }
            R2.s r7 = R2.s.f8222a     // Catch:{ all -> 0x009c }
            if (r8 == 0) goto L_0x008f
            boolean r7 = r8.P0()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x0092
        L_0x008f:
            t3.J.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x0092:
            boolean r7 = r0.O()     // Catch:{ all -> 0x0068 }
            if (r7 != 0) goto L_0x0092
        L_0x0098:
            r0.D(r1)
            goto L_0x00ad
        L_0x009c:
            r7 = move-exception
            if (r8 == 0) goto L_0x00a5
            boolean r8 = r8.P0()     // Catch:{ all -> 0x0068 }
            if (r8 == 0) goto L_0x00a8
        L_0x00a5:
            t3.J.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x00a8:
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x00a9:
            r6.i(r7, r2)     // Catch:{ all -> 0x00ae }
            goto L_0x0098
        L_0x00ad:
            return
        L_0x00ae:
            r6 = move-exception
            r0.D(r1)
            throw r6
        L_0x00b3:
            r6.resumeWith(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C1061k.b(V2.d, java.lang.Object, d3.l):void");
    }

    public static /* synthetic */ void c(d dVar, Object obj, l lVar, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }

    public static final boolean d(C1060j jVar) {
        s sVar = s.f8222a;
        C0970c0 b5 = S0.f3672a.b();
        if (b5.M()) {
            return false;
        }
        if (b5.L()) {
            jVar.f4498f = sVar;
            jVar.f3680c = 1;
            b5.H(jVar);
            return true;
        }
        b5.J(true);
        try {
            jVar.run();
            do {
            } while (b5.O());
        } catch (Throwable th) {
            b5.D(true);
            throw th;
        }
        b5.D(true);
        return false;
    }
}
