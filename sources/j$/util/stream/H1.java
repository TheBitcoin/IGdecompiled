package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class H1 extends P1 implements O1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f5310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f5311c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f5312d;

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
        this.f5312d.accept(this.f5380a, ((H1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5310b.get();
    }

    public final void accept(Object obj) {
        this.f5311c.accept(this.f5380a, obj);
    }

    public H1(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f5310b = supplier;
        this.f5311c = biConsumer;
        this.f5312d = biConsumer2;
    }
}
