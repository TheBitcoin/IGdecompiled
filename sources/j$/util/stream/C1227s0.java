package j$.util.stream;

import j$.util.concurrent.t;
import j$.util.i0;

/* renamed from: j$.util.stream.s0  reason: case insensitive filesystem */
public final class C1227s0 extends C1149b {

    /* renamed from: j  reason: collision with root package name */
    public final t f5588j;

    public C1227s0(t tVar, C1144a aVar, i0 i0Var) {
        super(aVar, i0Var);
        this.f5588j = tVar;
    }

    public C1227s0(C1227s0 s0Var, i0 i0Var) {
        super((C1149b) s0Var, i0Var);
        this.f5588j = s0Var.f5588j;
    }

    public final C1159d c(i0 i0Var) {
        return new C1227s0(this, i0Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0026 A[LOOP:0: B:3:0x0026->B:6:0x0031, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r4 = this;
            j$.util.stream.a r0 = r4.f5484a
            j$.util.concurrent.t r1 = r4.f5588j
            java.lang.Object r1 = r1.f5180c
            java.util.function.Supplier r1 = (java.util.function.Supplier) r1
            java.lang.Object r1 = r1.get()
            j$.util.stream.q0 r1 = (j$.util.stream.C1220q0) r1
            j$.util.i0 r2 = r4.f5485b
            r0.N(r2, r1)
            boolean r0 = r1.f5573b
            j$.util.concurrent.t r1 = r4.f5588j
            java.lang.Object r1 = r1.f5179b
            j$.util.stream.r0 r1 = (j$.util.stream.C1223r0) r1
            boolean r1 = r1.f5580b
            r2 = 0
            if (r0 != r1) goto L_0x0033
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.util.concurrent.atomic.AtomicReference r1 = r4.f5471h
        L_0x0026:
            boolean r3 = r1.compareAndSet(r2, r0)
            if (r3 == 0) goto L_0x002d
            goto L_0x0033
        L_0x002d:
            java.lang.Object r3 = r1.get()
            if (r3 == 0) goto L_0x0026
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1227s0.a():java.lang.Object");
    }

    public final Object h() {
        return Boolean.valueOf(!((C1223r0) this.f5588j.f5179b).f5580b);
    }
}
