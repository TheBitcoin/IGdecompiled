package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.E;
import java.util.function.LongConsumer;

public final class G extends I implements C1182h2 {

    /* renamed from: c  reason: collision with root package name */
    public static final D f5292c;

    /* renamed from: d  reason: collision with root package name */
    public static final D f5293d;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void accept(long j4) {
        o((Object) Long.valueOf(j4));
    }

    public final Object get() {
        if (this.f5320a) {
            return new E(((Long) this.f5321b).longValue());
        }
        return null;
    }

    static {
        X2 x22 = X2.LONG_VALUE;
        E e5 = E.f5093c;
        f5292c = new D(true, x22, e5, new C1211o(11), new C1211o(12));
        E e6 = e5;
        f5293d = new D(false, x22, e6, new C1211o(11), new C1211o(12));
    }
}
