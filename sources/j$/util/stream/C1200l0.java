package j$.util.stream;

import java.util.function.Supplier;

/* renamed from: j$.util.stream.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C1200l0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5537a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1223r0 f5538b;

    public /* synthetic */ C1200l0(C1223r0 r0Var, int i4) {
        this.f5537a = i4;
        this.f5538b = r0Var;
    }

    public final Object get() {
        switch (this.f5537a) {
            case 0:
                return new C1220q0(this.f5538b);
            case 1:
                return new C1220q0(this.f5538b);
            default:
                return new C1220q0(this.f5538b);
        }
    }
}
