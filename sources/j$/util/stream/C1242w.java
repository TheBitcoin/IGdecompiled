package j$.util.stream;

import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.w  reason: case insensitive filesystem */
public final class C1242w extends C1250y {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5622m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f5623n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1242w(C1144a aVar, int i4, Object obj, int i5) {
        super(aVar, i4, 1);
        this.f5622m = i5;
        this.f5623n = obj;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1242w(C1254z zVar, DoubleConsumer doubleConsumer) {
        super(zVar, 0, 1);
        this.f5622m = 1;
        this.f5623n = doubleConsumer;
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5622m) {
            case 0:
                return new C1238v(this, i2Var);
            case 1:
                return new C1219q(this, i2Var, 5);
            case 2:
                return new C1203m(this, i2Var, 6);
            default:
                return new W1(this, i2Var);
        }
    }
}
