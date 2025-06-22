package j$.util.stream;

/* renamed from: j$.util.stream.u  reason: case insensitive filesystem */
public final class C1234u extends C1175g0 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5610m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1234u(C1144a aVar, int i4, int i5) {
        super(aVar, i4, 1);
        this.f5610m = i5;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5610m) {
            case 0:
                return new C1219q(this, i2Var, 3);
            case 1:
                return new V(0, i2Var);
            case 2:
                return new T(this, i2Var, 3);
            case 3:
                return new C1150b0(this, i2Var, 1);
            case 4:
                return i2Var;
            default:
                return new C1150b0(this, i2Var, 4);
        }
    }
}
