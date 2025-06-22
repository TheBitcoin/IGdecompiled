package j$.util.stream;

import j$.util.Objects;
import j$.util.i0;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public final class P0 extends G0 {
    public final i0 spliterator() {
        return new C1181h1(this);
    }

    public final void h(Object[] objArr, int i4) {
        Objects.requireNonNull(objArr);
        E0 e02 = this.f5294a;
        e02.h(objArr, i4);
        this.f5295b.h(objArr, i4 + ((int) e02.count()));
    }

    public final Object[] n(IntFunction intFunction) {
        long j4 = this.f5296c;
        if (j4 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) j4);
            h(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void forEach(Consumer consumer) {
        this.f5294a.forEach(consumer);
        this.f5295b.forEach(consumer);
    }

    public final E0 g(long j4, long j5, IntFunction intFunction) {
        if (j4 == 0 && j5 == this.f5296c) {
            return this;
        }
        long count = this.f5294a.count();
        if (j4 >= count) {
            return this.f5295b.g(j4 - count, j5 - count, intFunction);
        } else if (j5 <= count) {
            return this.f5294a.g(j4, j5, intFunction);
        } else {
            return C1232t1.F(X2.REFERENCE, this.f5294a.g(j4, count, intFunction), this.f5295b.g(0, j5 - count, intFunction));
        }
    }

    public final String toString() {
        long j4 = this.f5296c;
        if (j4 < 32) {
            return String.format("ConcNode[%s.%s]", new Object[]{this.f5294a, this.f5295b});
        }
        return String.format("ConcNode[size=%d]", new Object[]{Long.valueOf(j4)});
    }
}
