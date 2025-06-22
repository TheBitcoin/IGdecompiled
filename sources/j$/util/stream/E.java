package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C;
import java.util.function.DoubleConsumer;

public final class E extends I implements C1172f2 {

    /* renamed from: c  reason: collision with root package name */
    public static final D f5274c;

    /* renamed from: d  reason: collision with root package name */
    public static final D f5275d;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void accept(double d5) {
        o((Object) Double.valueOf(d5));
    }

    public final Object get() {
        if (this.f5320a) {
            return new C(((Double) this.f5321b).doubleValue());
        }
        return null;
    }

    static {
        X2 x22 = X2.DOUBLE_VALUE;
        C c5 = C.f5087c;
        f5274c = new D(true, x22, c5, new C1211o(7), new C1211o(8));
        C c6 = c5;
        f5275d = new D(false, x22, c6, new C1211o(7), new C1211o(8));
    }
}
