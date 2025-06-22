package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.z1  reason: case insensitive filesystem */
public final class C1256z1 implements O1, C1172f2 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5647a;

    /* renamed from: b  reason: collision with root package name */
    public double f5648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DoubleBinaryOperator f5649c;

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

    public C1256z1(DoubleBinaryOperator doubleBinaryOperator) {
        this.f5649c = doubleBinaryOperator;
    }

    public final void f(O1 o12) {
        C1256z1 z1Var = (C1256z1) o12;
        if (!z1Var.f5647a) {
            accept(z1Var.f5648b);
        }
    }

    public final void k(long j4) {
        this.f5647a = true;
        this.f5648b = 0.0d;
    }

    public final void accept(double d5) {
        if (this.f5647a) {
            this.f5647a = false;
            this.f5648b = d5;
            return;
        }
        this.f5648b = this.f5649c.applyAsDouble(this.f5648b, d5);
    }

    public final Object get() {
        return this.f5647a ? C.f5087c : new C(this.f5648b);
    }
}
