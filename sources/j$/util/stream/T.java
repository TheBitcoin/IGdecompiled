package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public final class T extends C1157c2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5404b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1144a f5405c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T(C1144a aVar, C1187i2 i2Var, int i4) {
        super(i2Var);
        this.f5404b = i4;
        this.f5405c = aVar;
    }

    public void k(long j4) {
        switch (this.f5404b) {
            case 5:
                this.f5481a.k(-1);
                return;
            default:
                super.k(j4);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.IntUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.IntToLongFunction] */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Throwable, java.util.function.IntToDoubleFunction] */
    /* JADX WARNING: type inference failed for: r0v22, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final void accept(int i4) {
        switch (this.f5404b) {
            case 0:
                this.f5481a.accept(((IntFunction) ((r) this.f5405c).f5577n).apply(i4));
                return;
            case 1:
                ((IntConsumer) ((U) this.f5405c).f5408n).accept(i4);
                this.f5481a.accept(i4);
                return;
            case 2:
                ((C1230t) this.f5405c).getClass();
                ? r02 = 0;
                r02.applyAsInt(i4);
                throw r02;
            case 3:
                ((C1234u) this.f5405c).getClass();
                ? r03 = 0;
                r03.applyAsLong(i4);
                throw r03;
            case 4:
                ((C1226s) this.f5405c).getClass();
                ? r04 = 0;
                r04.applyAsDouble(i4);
                throw r04;
            default:
                ((C1230t) this.f5405c).getClass();
                ? r05 = 0;
                r05.test(i4);
                throw r05;
        }
    }
}
