package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public final class F1 extends C1232t1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f5284h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f5285i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Supplier f5286j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Collector f5287k;

    public final O1 Z() {
        return new G1(this.f5286j, this.f5285i, this.f5284h);
    }

    public final int d() {
        if (this.f5287k.characteristics().contains(C1179h.UNORDERED)) {
            return W2.f5433r;
        }
        return 0;
    }

    public F1(X2 x22, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        this.f5284h = binaryOperator;
        this.f5285i = biConsumer;
        this.f5286j = supplier;
        this.f5287k = collector;
    }
}
