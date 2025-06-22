package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class q3 extends r3 implements i0 {
    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q3(j$.util.i0 r13, long r14, long r16) {
        /*
            r12 = this;
            long r0 = r13.estimateSize()
            r6 = r16
            long r10 = java.lang.Math.min(r0, r6)
            r8 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r2.<init>(r3, r4, r6, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.q3.<init>(j$.util.i0, long, long):void");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.r3, j$.util.i0] */
    public final i0 a(i0 i0Var, long j4, long j5, long j6, long j7) {
        return new r3(i0Var, j4, j5, j6, j7);
    }

    public final boolean tryAdvance(Consumer consumer) {
        long j4;
        Objects.requireNonNull(consumer);
        long j5 = this.f5586e;
        long j6 = this.f5582a;
        if (j6 >= j5) {
            return false;
        }
        while (true) {
            j4 = this.f5585d;
            if (j6 <= j4) {
                break;
            }
            this.f5584c.tryAdvance(new C1145a0(21));
            this.f5585d++;
        }
        if (j4 >= this.f5586e) {
            return false;
        }
        this.f5585d = j4 + 1;
        return this.f5584c.tryAdvance(consumer);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        long j4 = this.f5586e;
        long j5 = this.f5582a;
        if (j5 < j4) {
            long j6 = this.f5585d;
            if (j6 < j4) {
                if (j6 < j5 || this.f5584c.estimateSize() + j6 > this.f5583b) {
                    while (j5 > this.f5585d) {
                        this.f5584c.tryAdvance(new C1145a0(22));
                        this.f5585d++;
                    }
                    while (this.f5585d < this.f5586e) {
                        this.f5584c.tryAdvance(consumer);
                        this.f5585d++;
                    }
                    return;
                }
                this.f5584c.forEachRemaining(consumer);
                this.f5585d = this.f5586e;
            }
        }
    }
}
