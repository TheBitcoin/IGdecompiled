package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.Z;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class t3 extends v3 implements Z, IntConsumer {

    /* renamed from: f  reason: collision with root package name */
    public int f5609f;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.i(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 c(i0 i0Var) {
        return new y3((Z) i0Var, this);
    }

    public final void e(Object obj) {
        ((IntConsumer) obj).accept(this.f5609f);
    }

    public final void accept(int i4) {
        this.f5609f = i4;
    }

    public final C1158c3 g(int i4) {
        return new C1148a3(i4);
    }
}
