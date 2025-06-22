package j$.util.stream;

import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.function.Consumer;

public abstract class P implements C3, D3 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5379a;

    public /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ void k(long j4) {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public P(boolean z4) {
        this.f5379a = z4;
    }

    public final int d() {
        if (this.f5379a) {
            return 0;
        }
        return W2.f5433r;
    }

    public final void e(C1144a aVar, i0 i0Var) {
        if (this.f5379a) {
            new Q(aVar, i0Var, this).invoke();
        } else {
            new S(aVar, i0Var, aVar.O(this)).invoke();
        }
    }
}
