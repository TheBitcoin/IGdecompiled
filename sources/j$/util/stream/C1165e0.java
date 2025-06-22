package j$.util.stream;

import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.e0  reason: case insensitive filesystem */
public final class C1165e0 extends C1175g0 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5496m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f5497n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1165e0(C1144a aVar, int i4, Object obj, int i5) {
        super(aVar, i4, 1);
        this.f5496m = i5;
        this.f5497n = obj;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5496m) {
            case 0:
                return new C1160d0(this, i2Var);
            case 1:
                return new C1150b0(this, i2Var, 5);
            case 2:
                return new W1(this, i2Var);
            default:
                return new C1203m(this, i2Var, 5);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1165e0(C1180h0 h0Var, LongConsumer longConsumer) {
        super(h0Var, 0, 1);
        this.f5496m = 1;
        this.f5497n = longConsumer;
    }
}
