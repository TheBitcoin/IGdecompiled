package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class G1 extends P1 implements O1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f5297b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f5298c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f5299d;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final void f(O1 o12) {
        this.f5380a = this.f5299d.apply(this.f5380a, ((G1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5297b.get();
    }

    public final void accept(Object obj) {
        this.f5298c.accept(this.f5380a, obj);
    }

    public G1(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f5297b = supplier;
        this.f5298c = biConsumer;
        this.f5299d = binaryOperator;
    }
}
