package M;

import J.C0303b;
import android.os.Bundle;

public final class g0 extends Q {

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ C0322c f534g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(C0322c cVar, int i4, Bundle bundle) {
        super(cVar, i4, (Bundle) null);
        this.f534g = cVar;
    }

    /* access modifiers changed from: protected */
    public final void f(C0303b bVar) {
        if (!this.f534g.t() || !C0322c.h0(this.f534g)) {
            this.f534g.f473p.a(bVar);
            this.f534g.L(bVar);
            return;
        }
        C0322c.d0(this.f534g, 16);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        this.f534g.f473p.a(C0303b.f322e);
        return true;
    }
}
