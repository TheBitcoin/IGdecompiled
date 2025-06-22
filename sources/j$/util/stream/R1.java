package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

public final class R1 extends U1 implements C1177g2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public final Object get() {
        return Long.valueOf(this.f5409b);
    }

    public final void f(O1 o12) {
        this.f5409b += ((U1) o12).f5409b;
    }

    public final void accept(int i4) {
        this.f5409b++;
    }
}
