package j$.util.stream;

public final class G3 extends C1167e2 {

    /* renamed from: b  reason: collision with root package name */
    public long f5302b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5303c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f5304d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ F3 f5305e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public G3(F3 f32, C1187i2 i2Var, boolean z4) {
        super(i2Var);
        this.f5305e = f32;
        this.f5304d = z4;
    }

    public final void accept(Object obj) {
        boolean z4;
        boolean z5;
        if (!this.f5303c) {
            boolean test = this.f5305e.f5291n.test(obj);
            this.f5303c = !test;
            if (test) {
                z4 = false;
                z5 = this.f5304d;
                if (z5 && !z4) {
                    this.f5302b++;
                }
                if (!z5 || z4) {
                    this.f5498a.accept(obj);
                }
                return;
            }
        }
        z4 = true;
        z5 = this.f5304d;
        this.f5302b++;
        if (!z5) {
        }
        this.f5498a.accept(obj);
    }
}
