package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.D;
import java.util.function.IntConsumer;

public final class F extends I implements C1177g2 {

    /* renamed from: c  reason: collision with root package name */
    public static final D f5281c;

    /* renamed from: d  reason: collision with root package name */
    public static final D f5282d;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i4) {
        o((Object) Integer.valueOf(i4));
    }

    public final Object get() {
        if (this.f5320a) {
            return new D(((Integer) this.f5321b).intValue());
        }
        return null;
    }

    static {
        X2 x22 = X2.INT_VALUE;
        D d5 = D.f5090c;
        f5281c = new D(true, x22, d5, new C1211o(9), new C1211o(10));
        D d6 = d5;
        f5282d = new D(false, x22, d6, new C1211o(9), new C1211o(10));
    }
}
