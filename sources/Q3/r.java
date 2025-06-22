package q3;

import R2.s;
import V2.g;
import o3.I;
import q3.v;

final class r extends e implements s {
    public r(g gVar, d dVar) {
        super(gVar, dVar, true, true);
    }

    /* access modifiers changed from: protected */
    public void M0(Throwable th, boolean z4) {
        if (!Q0().s(th) && !z4) {
            I.a(getContext(), th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: R0 */
    public void N0(s sVar) {
        v.a.a(Q0(), (Throwable) null, 1, (Object) null);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public /* bridge */ /* synthetic */ v n() {
        return P0();
    }
}
