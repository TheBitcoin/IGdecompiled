package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public final class L1 extends P1 implements O1, C1177g2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f5365b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjIntConsumer f5366c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1215p f5367d;

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final void f(O1 o12) {
        this.f5380a = this.f5367d.apply(this.f5380a, ((L1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5365b.get();
    }

    public final void accept(int i4) {
        this.f5366c.accept(this.f5380a, i4);
    }

    public L1(Supplier supplier, ObjIntConsumer objIntConsumer, C1215p pVar) {
        this.f5365b = supplier;
        this.f5366c = objIntConsumer;
        this.f5367d = pVar;
    }
}
