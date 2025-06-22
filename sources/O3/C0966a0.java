package o3;

import R2.s;

/* renamed from: o3.a0  reason: case insensitive filesystem */
final class C0966a0 extends C0985k {

    /* renamed from: a  reason: collision with root package name */
    private final Z f3688a;

    public C0966a0(Z z4) {
        this.f3688a = z4;
    }

    public void a(Throwable th) {
        this.f3688a.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return s.f8222a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f3688a + ']';
    }
}
