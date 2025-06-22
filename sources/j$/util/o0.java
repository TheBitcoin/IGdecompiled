package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class o0 implements W {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f5245a;

    /* renamed from: b  reason: collision with root package name */
    public int f5246b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5247c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5248d;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.a(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.h(this, consumer);
    }

    public o0(double[] dArr, int i4, int i5, int i6) {
        this.f5245a = dArr;
        this.f5246b = i4;
        this.f5247c = i5;
        this.f5248d = i6 | 16448;
    }

    public final W trySplit() {
        int i4 = this.f5246b;
        int i5 = (this.f5247c + i4) >>> 1;
        if (i4 >= i5) {
            return null;
        }
        this.f5246b = i5;
        return new o0(this.f5245a, i4, i5, this.f5248d);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i4;
        doubleConsumer.getClass();
        double[] dArr = this.f5245a;
        int length = dArr.length;
        int i5 = this.f5247c;
        if (length >= i5 && (i4 = this.f5246b) >= 0) {
            this.f5246b = i5;
            if (i4 < i5) {
                do {
                    doubleConsumer.accept(dArr[i4]);
                    i4++;
                } while (i4 < i5);
            }
        }
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        int i4 = this.f5246b;
        if (i4 < 0 || i4 >= this.f5247c) {
            return false;
        }
        this.f5246b = i4 + 1;
        doubleConsumer.accept(this.f5245a[i4]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f5247c - this.f5246b);
    }

    public final int characteristics() {
        return this.f5248d;
    }

    public final Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
