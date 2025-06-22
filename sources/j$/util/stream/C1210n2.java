package j$.util.stream;

/* renamed from: j$.util.stream.n2  reason: case insensitive filesystem */
public final class C1210n2 extends C1162d2 {

    /* renamed from: b  reason: collision with root package name */
    public long f5551b;

    /* renamed from: c  reason: collision with root package name */
    public long f5552c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1214o2 f5553d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1210n2(C1214o2 o2Var, C1187i2 i2Var) {
        super(i2Var);
        this.f5553d = o2Var;
        this.f5551b = o2Var.f5556m;
        long j4 = o2Var.f5557n;
        this.f5552c = j4 < 0 ? Long.MAX_VALUE : j4;
    }

    public final void k(long j4) {
        this.f5493a.k(C1232t1.x(j4, this.f5553d.f5556m, this.f5552c));
    }

    public final void accept(long j4) {
        long j5 = this.f5551b;
        if (j5 == 0) {
            long j6 = this.f5552c;
            if (j6 > 0) {
                this.f5552c = j6 - 1;
                this.f5493a.accept(j4);
                return;
            }
            return;
        }
        this.f5551b = j5 - 1;
    }

    public final boolean m() {
        return this.f5552c == 0 || this.f5493a.m();
    }
}
