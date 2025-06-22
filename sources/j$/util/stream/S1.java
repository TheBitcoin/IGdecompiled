package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

public final class S1 extends U1 implements C1182h2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final Object get() {
        return Long.valueOf(this.f5409b);
    }

    public final void f(O1 o12) {
        this.f5409b += ((U1) o12).f5409b;
    }

    public final void accept(long j4) {
        this.f5409b++;
    }
}
