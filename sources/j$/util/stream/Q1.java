package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

public final class Q1 extends U1 implements C1172f2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public final Object get() {
        return Long.valueOf(this.f5409b);
    }

    public final void f(O1 o12) {
        this.f5409b += ((U1) o12).f5409b;
    }

    public final void accept(double d5) {
        this.f5409b++;
    }
}
