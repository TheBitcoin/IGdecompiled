package j$.util.stream;

import j$.util.f0;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class M0 extends O0 implements A0 {
    public final /* synthetic */ void forEach(Consumer consumer) {
        C1232t1.r(this, consumer);
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.u(this, j4, j5);
    }

    public final /* synthetic */ void h(Object[] objArr, int i4) {
        C1232t1.o(this, (Integer[]) objArr, i4);
    }

    public final Object c(int i4) {
        return new int[i4];
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.f0, j$.util.stream.h1] */
    public final f0 spliterator() {
        return new C1181h1(this);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m21spliterator() {
        return new C1181h1(this);
    }
}
