package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.p0  reason: case insensitive filesystem */
public final class C1216p0 extends C1220q0 implements C1172f2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final void accept(double d5) {
        if (!this.f5572a) {
            ? r02 = 0;
            r02.test(d5);
            throw r02;
        }
    }
}
