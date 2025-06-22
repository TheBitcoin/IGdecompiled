package j$.util.stream;

/* renamed from: j$.util.stream.p2  reason: case insensitive filesystem */
public final class C1218p2 extends C1152b2 {

    /* renamed from: b  reason: collision with root package name */
    public long f5567b;

    /* renamed from: c  reason: collision with root package name */
    public long f5568c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1222q2 f5569d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1218p2(C1222q2 q2Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5569d = q2Var;
        this.f5567b = q2Var.f5574m;
        long j4 = q2Var.f5575n;
        this.f5568c = j4 < 0 ? Long.MAX_VALUE : j4;
    }

    public final void k(long j4) {
        this.f5475a.k(C1232t1.x(j4, this.f5569d.f5574m, this.f5568c));
    }

    public final void accept(double d5) {
        long j4 = this.f5567b;
        if (j4 == 0) {
            long j5 = this.f5568c;
            if (j5 > 0) {
                this.f5568c = j5 - 1;
                this.f5475a.accept(d5);
                return;
            }
            return;
        }
        this.f5567b = j4 - 1;
    }

    public final boolean m() {
        return this.f5568c == 0 || this.f5475a.m();
    }
}
