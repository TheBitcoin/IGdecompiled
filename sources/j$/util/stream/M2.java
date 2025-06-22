package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.Z;
import j$.util.f0;
import j$.util.t0;
import j$.util.w0;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class M2 extends Q2 implements Z {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ N2 f5372g;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.i(this, consumer);
    }

    public final void a(int i4, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i4]);
    }

    public final f0 b(Object obj, int i4, int i5) {
        int[] iArr = (int[]) obj;
        int i6 = i5 + i4;
        w0.a(((int[]) Objects.requireNonNull(iArr)).length, i4, i6);
        return new t0(iArr, i4, i6, 1040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M2(N2 n22, int i4, int i5, int i6, int i7) {
        super(n22, i4, i5, i6, i7);
        this.f5372g = n22;
    }

    public final f0 c(int i4, int i5, int i6, int i7) {
        return new M2(this.f5372g, i4, i5, i6, i7);
    }
}
