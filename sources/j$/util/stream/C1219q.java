package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

/* renamed from: j$.util.stream.q  reason: case insensitive filesystem */
public final class C1219q extends C1152b2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5570b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1144a f5571c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1219q(C1144a aVar, C1187i2 i2Var, int i4) {
        super(i2Var);
        this.f5570b = i4;
        this.f5571c = aVar;
    }

    public void k(long j4) {
        switch (this.f5570b) {
            case 4:
                this.f5475a.k(-1);
                return;
            default:
                super.k(j4);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable, java.util.function.DoubleUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Throwable, java.util.function.DoubleToIntFunction] */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.DoubleToLongFunction] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final void accept(double d5) {
        switch (this.f5570b) {
            case 0:
                this.f5475a.accept(((DoubleFunction) ((r) this.f5571c).f5577n).apply(d5));
                return;
            case 1:
                ((C1226s) this.f5571c).getClass();
                ? r02 = 0;
                r02.applyAsDouble(d5);
                throw r02;
            case 2:
                ((C1230t) this.f5571c).getClass();
                ? r03 = 0;
                r03.applyAsInt(d5);
                throw r03;
            case 3:
                ((C1234u) this.f5571c).getClass();
                ? r04 = 0;
                r04.applyAsLong(d5);
                throw r04;
            case 4:
                ((C1226s) this.f5571c).getClass();
                ? r05 = 0;
                r05.test(d5);
                throw r05;
            default:
                ((DoubleConsumer) ((C1242w) this.f5571c).f5623n).accept(d5);
                this.f5475a.accept(d5);
                return;
        }
    }
}
