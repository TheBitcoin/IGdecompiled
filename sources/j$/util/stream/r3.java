package j$.util.stream;

import j$.util.i0;

public abstract class r3 {

    /* renamed from: a  reason: collision with root package name */
    public final long f5582a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5583b;

    /* renamed from: c  reason: collision with root package name */
    public i0 f5584c;

    /* renamed from: d  reason: collision with root package name */
    public long f5585d;

    /* renamed from: e  reason: collision with root package name */
    public long f5586e;

    public abstract i0 a(i0 i0Var, long j4, long j5, long j6, long j7);

    public r3(i0 i0Var, long j4, long j5, long j6, long j7) {
        this.f5584c = i0Var;
        this.f5582a = j4;
        this.f5583b = j5;
        this.f5585d = j6;
        this.f5586e = j7;
    }

    public final i0 trySplit() {
        long j4 = this.f5586e;
        if (this.f5582a >= j4 || this.f5585d >= j4) {
            return null;
        }
        while (true) {
            i0 trySplit = this.f5584c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f5585d;
            long min = Math.min(estimateSize, this.f5583b);
            long j5 = estimateSize;
            long j6 = this.f5582a;
            if (j6 >= min) {
                this.f5585d = min;
            } else {
                long j7 = this.f5583b;
                if (min >= j7) {
                    this.f5584c = trySplit;
                    this.f5586e = min;
                } else {
                    long j8 = this.f5585d;
                    if (j8 < j6 || j5 > j7) {
                        this.f5585d = min;
                        return a(trySplit, j6, j7, j8, min);
                    }
                    this.f5585d = min;
                    return trySplit;
                }
            }
        }
    }

    public final long estimateSize() {
        long j4 = this.f5586e;
        long j5 = this.f5582a;
        if (j5 < j4) {
            return j4 - Math.max(j5, this.f5585d);
        }
        return 0;
    }

    public final int characteristics() {
        return this.f5584c.characteristics();
    }
}
