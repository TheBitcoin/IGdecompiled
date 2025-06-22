package j$.util.stream;

/* renamed from: j$.util.stream.t  reason: case insensitive filesystem */
public final class C1230t extends Y {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5600m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1230t(C1144a aVar, int i4, int i5) {
        super(aVar, i4, 1);
        this.f5600m = i5;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5600m) {
            case 0:
                return new C1219q(this, i2Var, 2);
            case 1:
                return new T(this, i2Var, 2);
            case 2:
                return i2Var;
            case 3:
                return new T(this, i2Var, 5);
            default:
                return new C1150b0(this, i2Var, 2);
        }
    }
}
