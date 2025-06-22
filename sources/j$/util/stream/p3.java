package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.f0;
import java.util.Comparator;

public abstract class p3 extends r3 implements f0 {
    public abstract Object b();

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
    public p3(j$.util.f0 r13, long r14, long r16) {
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
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.p3.<init>(j$.util.f0, long, long):void");
    }

    public final boolean tryAdvance(Object obj) {
        long j4;
        Objects.requireNonNull(obj);
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
            ((f0) this.f5584c).tryAdvance(b());
            this.f5585d++;
        }
        if (j4 >= this.f5586e) {
            return false;
        }
        this.f5585d = j4 + 1;
        return ((f0) this.f5584c).tryAdvance(obj);
    }

    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        long j4 = this.f5586e;
        long j5 = this.f5582a;
        if (j5 < j4) {
            long j6 = this.f5585d;
            if (j6 < j4) {
                if (j6 < j5 || ((f0) this.f5584c).estimateSize() + j6 > this.f5583b) {
                    while (j5 > this.f5585d) {
                        ((f0) this.f5584c).tryAdvance(b());
                        this.f5585d++;
                    }
                    while (this.f5585d < this.f5586e) {
                        ((f0) this.f5584c).tryAdvance(obj);
                        this.f5585d++;
                    }
                    return;
                }
                ((f0) this.f5584c).forEachRemaining(obj);
                this.f5585d = this.f5586e;
            }
        }
    }
}
