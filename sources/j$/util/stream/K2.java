package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.W;
import j$.util.f0;
import j$.util.o0;
import j$.util.w0;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class K2 extends Q2 implements W {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ L2 f5361g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.h(this, consumer);
    }

    public final void a(int i4, Object obj, Object obj2) {
        ((DoubleConsumer) obj2).accept(((double[]) obj)[i4]);
    }

    public final f0 b(Object obj, int i4, int i5) {
        double[] dArr = (double[]) obj;
        int i6 = i5 + i4;
        w0.a(((double[]) Objects.requireNonNull(dArr)).length, i4, i6);
        return new o0(dArr, i4, i6, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public K2(L2 l22, int i4, int i5, int i6, int i7) {
        super(l22, i4, i5, i6, i7);
        this.f5361g = l22;
    }

    public final f0 c(int i4, int i5, int i6, int i7) {
        return new K2(this.f5361g, i4, i5, i6, i7);
    }
}
