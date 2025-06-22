package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.c0;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class u3 extends v3 implements c0, LongConsumer {

    /* renamed from: f  reason: collision with root package name */
    public long f5614f;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.j(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 c(i0 i0Var) {
        return new y3((c0) i0Var, this);
    }

    public final void e(Object obj) {
        ((LongConsumer) obj).accept(this.f5614f);
    }

    public final void accept(long j4) {
        this.f5614f = j4;
    }

    public final C1158c3 g(int i4) {
        return new C1153b3(i4);
    }
}
