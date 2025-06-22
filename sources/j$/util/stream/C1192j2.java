package j$.util.stream;

/* renamed from: j$.util.stream.j2  reason: case insensitive filesystem */
public final class C1192j2 extends C1167e2 {

    /* renamed from: b  reason: collision with root package name */
    public long f5522b;

    /* renamed from: c  reason: collision with root package name */
    public long f5523c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1197k2 f5524d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1192j2(C1197k2 k2Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5524d = k2Var;
        this.f5522b = k2Var.f5530m;
        long j4 = k2Var.f5531n;
        this.f5523c = j4 < 0 ? Long.MAX_VALUE : j4;
    }

    public final void k(long j4) {
        this.f5498a.k(C1232t1.x(j4, this.f5524d.f5530m, this.f5523c));
    }

    public final void accept(Object obj) {
        long j4 = this.f5522b;
        if (j4 == 0) {
            long j5 = this.f5523c;
            if (j5 > 0) {
                this.f5523c = j5 - 1;
                this.f5498a.accept(obj);
                return;
            }
            return;
        }
        this.f5522b = j4 - 1;
    }

    public final boolean m() {
        return this.f5523c == 0 || this.f5498a.m();
    }
}
