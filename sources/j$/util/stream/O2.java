package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.c0;
import j$.util.f0;
import j$.util.v0;
import j$.util.w0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class O2 extends Q2 implements c0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ P2 f5378g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.j(this, consumer);
    }

    public final void a(int i4, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i4]);
    }

    public final f0 b(Object obj, int i4, int i5) {
        long[] jArr = (long[]) obj;
        int i6 = i5 + i4;
        w0.a(((long[]) Objects.requireNonNull(jArr)).length, i4, i6);
        return new v0(jArr, i4, i6, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public O2(P2 p22, int i4, int i5, int i6, int i7) {
        super(p22, i4, i5, i6, i7);
        this.f5378g = p22;
    }

    public final f0 c(int i4, int i5, int i6, int i7) {
        return new O2(this.f5378g, i4, i5, i6, i7);
    }
}
