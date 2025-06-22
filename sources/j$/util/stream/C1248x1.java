package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.x1  reason: case insensitive filesystem */
public final class C1248x1 implements O1, C1172f2 {

    /* renamed from: a  reason: collision with root package name */
    public double f5630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ double f5631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f5632c;

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

    public C1248x1(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        this.f5631b = d5;
        this.f5632c = doubleBinaryOperator;
    }

    public final void f(O1 o12) {
        accept(((C1248x1) o12).f5630a);
    }

    public final void k(long j4) {
        this.f5630a = this.f5631b;
    }

    public final void accept(double d5) {
        this.f5630a = this.f5632c.applyAsDouble(this.f5630a, d5);
    }

    public final Object get() {
        return Double.valueOf(this.f5630a);
    }
}
