package o3;

import S2.C1593g;
import t3.C1064n;

/* renamed from: o3.c0  reason: case insensitive filesystem */
public abstract class C0970c0 extends G {

    /* renamed from: a  reason: collision with root package name */
    private long f3690a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3691b;

    /* renamed from: c  reason: collision with root package name */
    private C1593g f3692c;

    public static /* synthetic */ void F(C0970c0 c0Var, boolean z4, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            c0Var.D(z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long G(boolean z4) {
        if (z4) {
            return 4294967296L;
        }
        return 1;
    }

    public static /* synthetic */ void K(C0970c0 c0Var, boolean z4, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            c0Var.J(z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void D(boolean z4) {
        long G4 = this.f3690a - G(z4);
        this.f3690a = G4;
        if (G4 <= 0 && this.f3691b) {
            shutdown();
        }
    }

    public final void H(W w4) {
        C1593g gVar = this.f3692c;
        if (gVar == null) {
            gVar = new C1593g();
            this.f3692c = gVar;
        }
        gVar.k(w4);
    }

    /* access modifiers changed from: protected */
    public long I() {
        C1593g gVar = this.f3692c;
        if (gVar != null && !gVar.isEmpty()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void J(boolean z4) {
        this.f3690a += G(z4);
        if (!z4) {
            this.f3691b = true;
        }
    }

    public final boolean L() {
        if (this.f3690a >= G(true)) {
            return true;
        }
        return false;
    }

    public final boolean M() {
        C1593g gVar = this.f3692c;
        if (gVar != null) {
            return gVar.isEmpty();
        }
        return true;
    }

    public abstract long N();

    public final boolean O() {
        W w4;
        C1593g gVar = this.f3692c;
        if (gVar == null || (w4 = (W) gVar.v()) == null) {
            return false;
        }
        w4.run();
        return true;
    }

    public boolean P() {
        return false;
    }

    public final G limitedParallelism(int i4) {
        C1064n.a(i4);
        return this;
    }

    public abstract void shutdown();
}
