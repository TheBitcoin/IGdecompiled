package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.o0  reason: case insensitive filesystem */
public final class C1212o0 extends C1220q0 implements C1182h2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final void accept(long j4) {
        if (!this.f5572a) {
            ? r02 = 0;
            r02.test(j4);
            throw r02;
        }
    }
}
