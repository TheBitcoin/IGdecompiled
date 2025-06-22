package j$.util.stream;

import j$.util.C1127b;
import j$.util.W;
import j$.util.i0;
import java.util.function.Consumer;

public final class m3 extends p3 implements W {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.h(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.r3, j$.util.i0] */
    public final i0 a(i0 i0Var, long j4, long j5, long j6, long j7) {
        return new r3((W) i0Var, j4, j5, j6, j7);
    }

    public final Object b() {
        return new C1247x0(1);
    }
}
