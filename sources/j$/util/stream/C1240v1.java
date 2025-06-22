package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.v1  reason: case insensitive filesystem */
public final class C1240v1 extends P1 implements O1, C1182h2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f5618b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjLongConsumer f5619c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1215p f5620d;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final void f(O1 o12) {
        this.f5380a = this.f5620d.apply(this.f5380a, ((C1240v1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5618b.get();
    }

    public final void accept(long j4) {
        this.f5619c.accept(this.f5380a, j4);
    }

    public C1240v1(Supplier supplier, ObjLongConsumer objLongConsumer, C1215p pVar) {
        this.f5618b = supplier;
        this.f5619c = objLongConsumer;
        this.f5620d = pVar;
    }
}
