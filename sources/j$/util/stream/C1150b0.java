package j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

/* renamed from: j$.util.stream.b0  reason: case insensitive filesystem */
public final class C1150b0 extends C1162d2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5473b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1144a f5474c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1150b0(C1144a aVar, C1187i2 i2Var, int i4) {
        super(i2Var);
        this.f5473b = i4;
        this.f5474c = aVar;
    }

    public void k(long j4) {
        switch (this.f5473b) {
            case 4:
                this.f5493a.k(-1);
                return;
            default:
                super.k(j4);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable, java.util.function.LongUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Throwable, java.util.function.LongToIntFunction] */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.LongToDoubleFunction] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final void accept(long j4) {
        switch (this.f5473b) {
            case 0:
                this.f5493a.accept(((LongFunction) ((r) this.f5474c).f5577n).apply(j4));
                return;
            case 1:
                ((C1234u) this.f5474c).getClass();
                ? r02 = 0;
                r02.applyAsLong(j4);
                throw r02;
            case 2:
                ((C1230t) this.f5474c).getClass();
                ? r03 = 0;
                r03.applyAsInt(j4);
                throw r03;
            case 3:
                ((C1226s) this.f5474c).getClass();
                ? r04 = 0;
                r04.applyAsDouble(j4);
                throw r04;
            case 4:
                ((C1234u) this.f5474c).getClass();
                ? r05 = 0;
                r05.test(j4);
                throw r05;
            default:
                ((LongConsumer) ((C1165e0) this.f5474c).f5497n).accept(j4);
                this.f5493a.accept(j4);
                return;
        }
    }
}
