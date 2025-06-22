package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public final class B1 extends P1 implements O1, C1172f2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Supplier f5256b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ObjDoubleConsumer f5257c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C1215p f5258d;

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public final void f(O1 o12) {
        this.f5380a = this.f5258d.apply(this.f5380a, ((B1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5256b.get();
    }

    public final void accept(double d5) {
        this.f5257c.accept(this.f5380a, d5);
    }

    public B1(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, C1215p pVar) {
        this.f5256b = supplier;
        this.f5257c = objDoubleConsumer;
        this.f5258d = pVar;
    }
}
