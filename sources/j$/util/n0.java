package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public final class n0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f5240a;

    /* renamed from: b  reason: collision with root package name */
    public int f5241b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5242c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5243d;

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public n0(Object[] objArr, int i4, int i5, int i6) {
        this.f5240a = objArr;
        this.f5241b = i4;
        this.f5242c = i5;
        this.f5243d = i6 | 16448;
    }

    public final i0 trySplit() {
        int i4 = this.f5241b;
        int i5 = (this.f5242c + i4) >>> 1;
        if (i4 >= i5) {
            return null;
        }
        this.f5241b = i5;
        return new n0(this.f5240a, i4, i5, this.f5243d);
    }

    public final void forEachRemaining(Consumer consumer) {
        int i4;
        consumer.getClass();
        Object[] objArr = this.f5240a;
        int length = objArr.length;
        int i5 = this.f5242c;
        if (length >= i5 && (i4 = this.f5241b) >= 0) {
            this.f5241b = i5;
            if (i4 < i5) {
                do {
                    consumer.accept(objArr[i4]);
                    i4++;
                } while (i4 < i5);
            }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i4 = this.f5241b;
        if (i4 < 0 || i4 >= this.f5242c) {
            return false;
        }
        this.f5241b = i4 + 1;
        consumer.accept(this.f5240a[i4]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f5242c - this.f5241b);
    }

    public final int characteristics() {
        return this.f5243d;
    }

    public final Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
