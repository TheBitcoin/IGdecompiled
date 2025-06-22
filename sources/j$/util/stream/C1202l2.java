package j$.util.stream;

/* renamed from: j$.util.stream.l2  reason: case insensitive filesystem */
public final class C1202l2 extends C1157c2 {

    /* renamed from: b  reason: collision with root package name */
    public long f5540b;

    /* renamed from: c  reason: collision with root package name */
    public long f5541c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1206m2 f5542d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1202l2(C1206m2 m2Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5542d = m2Var;
        this.f5540b = m2Var.f5548m;
        long j4 = m2Var.f5549n;
        this.f5541c = j4 < 0 ? Long.MAX_VALUE : j4;
    }

    public final void k(long j4) {
        this.f5481a.k(C1232t1.x(j4, this.f5542d.f5548m, this.f5541c));
    }

    public final void accept(int i4) {
        long j4 = this.f5540b;
        if (j4 == 0) {
            long j5 = this.f5541c;
            if (j5 > 0) {
                this.f5541c = j5 - 1;
                this.f5481a.accept(i4);
                return;
            }
            return;
        }
        this.f5540b = j4 - 1;
    }

    public final boolean m() {
        return this.f5541c == 0 || this.f5481a.m();
    }
}
