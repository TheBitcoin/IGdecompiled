package j$.util.stream;

public final class V extends C1157c2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5411b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ V(int i4, C1187i2 i2Var) {
        super(i2Var);
        this.f5411b = i4;
    }

    public final void accept(int i4) {
        switch (this.f5411b) {
            case 0:
                this.f5481a.accept((long) i4);
                return;
            default:
                this.f5481a.accept((double) i4);
                return;
        }
    }
}
