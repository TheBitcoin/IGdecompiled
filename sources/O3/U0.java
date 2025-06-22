package o3;

import R2.l;
import R2.p;
import R2.s;
import V2.d;
import V2.g;
import t3.B;
import t3.J;

public final class U0 extends B {

    /* renamed from: e  reason: collision with root package name */
    private final ThreadLocal f3677e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public U0(V2.g r3, V2.d r4) {
        /*
            r2 = this;
            o3.V0 r0 = o3.V0.f3679a
            V2.g$b r1 = r3.get(r0)
            if (r1 != 0) goto L_0x000d
            V2.g r0 = r3.plus(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f3677e = r0
            V2.g r4 = r4.getContext()
            V2.e$b r0 = V2.e.f8442a0
            V2.g$b r4 = r4.get(r0)
            boolean r4 = r4 instanceof o3.G
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = t3.J.c(r3, r4)
            t3.J.a(r3, r4)
            r2.Q0(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.U0.<init>(V2.g, V2.d):void");
    }

    /* access modifiers changed from: protected */
    public void L0(Object obj) {
        if (this.threadLocalIsSet) {
            l lVar = (l) this.f3677e.get();
            if (lVar != null) {
                J.a((g) lVar.a(), lVar.b());
            }
            this.f3677e.remove();
        }
        Object a5 = E.a(obj, this.f4461d);
        d dVar = this.f4461d;
        g context = dVar.getContext();
        U0 u02 = null;
        Object c5 = J.c(context, (Object) null);
        if (c5 != J.f4469a) {
            u02 = F.g(dVar, context, c5);
        }
        try {
            this.f4461d.resumeWith(a5);
            s sVar = s.f8222a;
            if (u02 == null || u02.P0()) {
                J.a(context, c5);
            }
        } catch (Throwable th) {
            if (u02 == null || u02.P0()) {
                J.a(context, c5);
            }
            throw th;
        }
    }

    public final boolean P0() {
        boolean z4;
        if (!this.threadLocalIsSet || this.f3677e.get() != null) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f3677e.remove();
        return !z4;
    }

    public final void Q0(g gVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f3677e.set(p.a(gVar, obj));
    }
}
