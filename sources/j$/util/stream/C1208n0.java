package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.n0  reason: case insensitive filesystem */
public final class C1208n0 extends C1220q0 implements C1177g2 {
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final void accept(int i4) {
        if (!this.f5572a) {
            ? r02 = 0;
            r02.test(i4);
            throw r02;
        }
    }
}
