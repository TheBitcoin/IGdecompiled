package j$.util.stream;

/* renamed from: j$.util.stream.s  reason: case insensitive filesystem */
public final class C1226s extends C1250y {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5587m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1226s(C1144a aVar, int i4, int i5) {
        super(aVar, i4, 1);
        this.f5587m = i5;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5587m) {
            case 0:
                return new C1219q(this, i2Var, 1);
            case 1:
                return i2Var;
            case 2:
                return new C1219q(this, i2Var, 4);
            case 3:
                return new V(1, i2Var);
            case 4:
                return new T(this, i2Var, 4);
            case 5:
                return new C1162d2(i2Var);
            default:
                return new C1150b0(this, i2Var, 3);
        }
    }
}
