package j$.util.stream;

import java.util.function.Consumer;

public final class r extends Z1 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5576m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f5577n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(C1144a aVar, int i4, Object obj, int i5) {
        super(aVar, i4, 1);
        this.f5576m = i5;
        this.f5577n = obj;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5576m) {
            case 0:
                return new C1219q(this, i2Var, 0);
            case 1:
                return new T(this, i2Var, 0);
            case 2:
                return new C1150b0(this, i2Var, 0);
            case 3:
                return new C1203m(this, i2Var, 1);
            case 4:
                return new C1203m(this, i2Var, 2);
            case 5:
                return new C1203m(this, i2Var, 3);
            default:
                return new C1199l(this, i2Var);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(C1147a2 a2Var, Consumer consumer) {
        super(a2Var, 0, 1);
        this.f5576m = 3;
        this.f5577n = consumer;
    }
}
