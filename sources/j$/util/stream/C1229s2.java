package j$.util.stream;

import j$.util.i0;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.s2  reason: case insensitive filesystem */
public final class C1229s2 extends C1149b {

    /* renamed from: j  reason: collision with root package name */
    public final C1144a f5593j;

    /* renamed from: k  reason: collision with root package name */
    public final IntFunction f5594k;

    /* renamed from: l  reason: collision with root package name */
    public final long f5595l;

    /* renamed from: m  reason: collision with root package name */
    public final long f5596m;

    /* renamed from: n  reason: collision with root package name */
    public long f5597n;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f5598o;

    public final void f() {
        this.f5472i = true;
        if (this.f5598o) {
            d(C1232t1.H(this.f5593j.E()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ea, code lost:
        if (r2 >= r0) goto L_0x00ec;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCompletion(java.util.concurrent.CountedCompleter r14) {
        /*
            r13 = this;
            j$.util.stream.d r0 = r13.f5487d
            r1 = 1
            if (r0 != 0) goto L_0x0007
            r2 = 1
            goto L_0x0008
        L_0x0007:
            r2 = 0
        L_0x0008:
            r3 = 0
            if (r2 != 0) goto L_0x009b
            j$.util.stream.s2 r0 = (j$.util.stream.C1229s2) r0
            long r5 = r0.f5597n
            j$.util.stream.d r0 = r13.f5488e
            j$.util.stream.s2 r0 = (j$.util.stream.C1229s2) r0
            long r7 = r0.f5597n
            long r5 = r5 + r7
            r13.f5597n = r5
            boolean r0 = r13.f5472i
            if (r0 == 0) goto L_0x002b
            r13.f5597n = r3
            j$.util.stream.a r0 = r13.f5593j
            j$.util.stream.X2 r0 = r0.E()
            j$.util.stream.X0 r0 = j$.util.stream.C1232t1.H(r0)
        L_0x0029:
            r5 = r0
            goto L_0x0070
        L_0x002b:
            long r5 = r13.f5597n
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x003c
            j$.util.stream.a r0 = r13.f5593j
            j$.util.stream.X2 r0 = r0.E()
            j$.util.stream.X0 r0 = j$.util.stream.C1232t1.H(r0)
            goto L_0x0029
        L_0x003c:
            j$.util.stream.d r0 = r13.f5487d
            j$.util.stream.s2 r0 = (j$.util.stream.C1229s2) r0
            long r5 = r0.f5597n
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0051
            j$.util.stream.d r0 = r13.f5488e
            j$.util.stream.s2 r0 = (j$.util.stream.C1229s2) r0
            java.lang.Object r0 = r0.i()
            j$.util.stream.E0 r0 = (j$.util.stream.E0) r0
            goto L_0x0029
        L_0x0051:
            j$.util.stream.a r0 = r13.f5593j
            j$.util.stream.X2 r0 = r0.E()
            j$.util.stream.d r2 = r13.f5487d
            j$.util.stream.s2 r2 = (j$.util.stream.C1229s2) r2
            java.lang.Object r2 = r2.i()
            j$.util.stream.E0 r2 = (j$.util.stream.E0) r2
            j$.util.stream.d r5 = r13.f5488e
            j$.util.stream.s2 r5 = (j$.util.stream.C1229s2) r5
            java.lang.Object r5 = r5.i()
            j$.util.stream.E0 r5 = (j$.util.stream.E0) r5
            j$.util.stream.G0 r0 = j$.util.stream.C1232t1.F(r0, r2, r5)
            goto L_0x0029
        L_0x0070:
            boolean r0 = r13.b()
            if (r0 == 0) goto L_0x0096
            long r6 = r13.f5596m
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x008b
            long r6 = r5.count()
            long r8 = r13.f5595l
            long r10 = r13.f5596m
            long r8 = r8 + r10
            long r6 = java.lang.Math.min(r6, r8)
        L_0x0089:
            r8 = r6
            goto L_0x008e
        L_0x008b:
            long r6 = r13.f5597n
            goto L_0x0089
        L_0x008e:
            long r6 = r13.f5595l
            java.util.function.IntFunction r10 = r13.f5594k
            j$.util.stream.E0 r5 = r5.g(r6, r8, r10)
        L_0x0096:
            r13.d(r5)
            r13.f5598o = r1
        L_0x009b:
            long r0 = r13.f5596m
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x00ef
            boolean r0 = r13.b()
            if (r0 != 0) goto L_0x00ef
            long r0 = r13.f5595l
            long r2 = r13.f5596m
            long r0 = r0 + r2
            boolean r2 = r13.f5598o
            if (r2 == 0) goto L_0x00b3
            long r2 = r13.f5597n
            goto L_0x00b7
        L_0x00b3:
            long r2 = r13.j(r0)
        L_0x00b7:
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x00bc
            goto L_0x00ec
        L_0x00bc:
            java.util.concurrent.CountedCompleter r4 = r13.getCompleter()
            j$.util.stream.d r4 = (j$.util.stream.C1159d) r4
            j$.util.stream.s2 r4 = (j$.util.stream.C1229s2) r4
            r5 = r13
        L_0x00c5:
            if (r4 == 0) goto L_0x00e8
            j$.util.stream.d r6 = r4.f5488e
            if (r5 != r6) goto L_0x00dc
            j$.util.stream.d r5 = r4.f5487d
            j$.util.stream.s2 r5 = (j$.util.stream.C1229s2) r5
            if (r5 == 0) goto L_0x00dc
            long r5 = r5.j(r0)
            long r5 = r5 + r2
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00db
            goto L_0x00ec
        L_0x00db:
            r2 = r5
        L_0x00dc:
            java.util.concurrent.CountedCompleter r5 = r4.getCompleter()
            j$.util.stream.d r5 = (j$.util.stream.C1159d) r5
            j$.util.stream.s2 r5 = (j$.util.stream.C1229s2) r5
            r12 = r5
            r5 = r4
            r4 = r12
            goto L_0x00c5
        L_0x00e8:
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x00ef
        L_0x00ec:
            r13.g()
        L_0x00ef:
            super.onCompletion(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1229s2.onCompletion(java.util.concurrent.CountedCompleter):void");
    }

    public C1229s2(C1144a aVar, C1144a aVar2, i0 i0Var, IntFunction intFunction, long j4, long j5) {
        super(aVar2, i0Var);
        this.f5593j = aVar;
        this.f5594k = intFunction;
        this.f5595l = j4;
        this.f5596m = j5;
    }

    public C1229s2(C1229s2 s2Var, i0 i0Var) {
        super((C1149b) s2Var, i0Var);
        this.f5593j = s2Var.f5593j;
        this.f5594k = s2Var.f5594k;
        this.f5595l = s2Var.f5595l;
        this.f5596m = s2Var.f5596m;
    }

    public final C1159d c(i0 i0Var) {
        return new C1229s2(this, i0Var);
    }

    public final Object h() {
        return C1232t1.H(this.f5593j.E());
    }

    public final Object a() {
        long j4 = -1;
        if (b()) {
            W2 w22 = W2.SIZED;
            C1144a aVar = this.f5593j;
            int i4 = aVar.f5460c;
            int i5 = w22.f5442e;
            if ((i4 & i5) == i5) {
                j4 = aVar.C(this.f5485b);
            }
            C1243w0 F4 = this.f5593j.F(j4, this.f5594k);
            C1187i2 J4 = this.f5593j.J(this.f5484a.f5463f, F4);
            C1144a aVar2 = this.f5484a;
            aVar2.x(this.f5485b, aVar2.O(J4));
            return F4.a();
        }
        C1243w0 F5 = this.f5593j.F(-1, this.f5594k);
        if (this.f5595l == 0) {
            C1187i2 J5 = this.f5593j.J(this.f5484a.f5463f, F5);
            C1144a aVar3 = this.f5484a;
            aVar3.x(this.f5485b, aVar3.O(J5));
        } else {
            this.f5484a.N(this.f5485b, F5);
        }
        E0 a5 = F5.a();
        this.f5597n = a5.count();
        this.f5598o = true;
        this.f5485b = null;
        return a5;
    }

    public final long j(long j4) {
        if (this.f5598o) {
            return this.f5597n;
        }
        C1229s2 s2Var = (C1229s2) this.f5487d;
        C1229s2 s2Var2 = (C1229s2) this.f5488e;
        if (s2Var == null || s2Var2 == null) {
            return this.f5597n;
        }
        long j5 = s2Var.j(j4);
        if (j5 >= j4) {
            return j5;
        }
        return s2Var2.j(j4) + j5;
    }
}
