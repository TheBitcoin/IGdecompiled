package N0;

import K0.C1493b;
import K0.C1494c;
import K0.C1498g;

class i implements C1498g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7772a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7773b = false;

    /* renamed from: c  reason: collision with root package name */
    private C1494c f7774c;

    /* renamed from: d  reason: collision with root package name */
    private final f f7775d;

    i(f fVar) {
        this.f7775d = fVar;
    }

    private void a() {
        if (!this.f7772a) {
            this.f7772a = true;
            return;
        }
        throw new C1493b("Cannot encode a second value in the ValueEncoderContext");
    }

    public C1498g b(String str) {
        a();
        this.f7775d.i(this.f7774c, str, this.f7773b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void c(C1494c cVar, boolean z4) {
        this.f7772a = false;
        this.f7774c = cVar;
        this.f7773b = z4;
    }

    public C1498g f(boolean z4) {
        a();
        this.f7775d.o(this.f7774c, z4, this.f7773b);
        return this;
    }
}
