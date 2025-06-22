package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.W;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class s3 extends v3 implements W, DoubleConsumer {

    /* renamed from: f  reason: collision with root package name */
    public double f5599f;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.h(this, consumer);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.y3, j$.util.i0] */
    public final i0 c(i0 i0Var) {
        return new y3((W) i0Var, this);
    }

    public final void e(Object obj) {
        ((DoubleConsumer) obj).accept(this.f5599f);
    }

    public final void accept(double d5) {
        this.f5599f = d5;
    }

    public final C1158c3 g(int i4) {
        return new Z2(i4);
    }
}
