package j$.util.stream;

import j$.util.B;
import j$.util.function.Consumer$CC;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public final class E1 implements O1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5276a;

    /* renamed from: b  reason: collision with root package name */
    public Object f5277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BinaryOperator f5278c;

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

    public E1(BinaryOperator binaryOperator) {
        this.f5278c = binaryOperator;
    }

    public final void f(O1 o12) {
        E1 e12 = (E1) o12;
        if (!e12.f5276a) {
            accept(e12.f5277b);
        }
    }

    public final void k(long j4) {
        this.f5276a = true;
        this.f5277b = null;
    }

    public final void accept(Object obj) {
        if (this.f5276a) {
            this.f5276a = false;
            this.f5277b = obj;
            return;
        }
        this.f5277b = this.f5278c.apply(this.f5277b, obj);
    }

    public final Object get() {
        return this.f5276a ? B.f5085b : new B(this.f5277b);
    }
}
