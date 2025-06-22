package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public final class D1 extends P1 implements O1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f5269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiFunction f5270c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f5271d;

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
        this.f5380a = this.f5271d.apply(this.f5380a, ((D1) o12).f5380a);
    }

    public final void k(long j4) {
        this.f5380a = this.f5269b;
    }

    public final void accept(Object obj) {
        this.f5380a = this.f5270c.apply(this.f5380a, obj);
    }

    public D1(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.f5269b = obj;
        this.f5270c = biFunction;
        this.f5271d = binaryOperator;
    }
}
