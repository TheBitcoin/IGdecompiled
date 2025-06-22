package j$.util.stream;

import java.util.function.IntConsumer;

public final class U extends Y {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5407m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f5408n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U(C1144a aVar, int i4, Object obj, int i5) {
        super(aVar, i4, 1);
        this.f5407m = i5;
        this.f5408n = obj;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5407m) {
            case 0:
                return new T(this, i2Var, 1);
            case 1:
                return new W(this, i2Var);
            case 2:
                return new C1203m(this, i2Var, 4);
            default:
                return new W1(this, i2Var);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public U(Z z4, IntConsumer intConsumer) {
        super(z4, 0, 1);
        this.f5407m = 0;
        this.f5408n = intConsumer;
    }
}
