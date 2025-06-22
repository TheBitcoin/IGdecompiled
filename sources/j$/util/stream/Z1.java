package j$.util.stream;

public abstract class Z1 extends C1147a2 {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f5456l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z1(C1144a aVar, int i4, int i5) {
        super(aVar, i4);
        this.f5456l = i5;
    }

    public final boolean I() {
        switch (this.f5456l) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final C1174g unordered() {
        switch (this.f5456l) {
            case 0:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new Z1(this, W2.f5433r, 1);
            default:
                if (!W2.ORDERED.n(this.f5463f)) {
                    return this;
                }
                return new Z1(this, W2.f5433r, 1);
        }
    }
}
