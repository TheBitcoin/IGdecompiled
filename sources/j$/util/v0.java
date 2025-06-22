package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class v0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f5666a;

    /* renamed from: b  reason: collision with root package name */
    public int f5667b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5668c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5669d;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.c(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.j(this, consumer);
    }

    public v0(long[] jArr, int i4, int i5, int i6) {
        this.f5666a = jArr;
        this.f5667b = i4;
        this.f5668c = i5;
        this.f5669d = i6 | 16448;
    }

    public final c0 trySplit() {
        int i4 = this.f5667b;
        int i5 = (this.f5668c + i4) >>> 1;
        if (i4 >= i5) {
            return null;
        }
        this.f5667b = i5;
        return new v0(this.f5666a, i4, i5, this.f5669d);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        int i4;
        longConsumer.getClass();
        long[] jArr = this.f5666a;
        int length = jArr.length;
        int i5 = this.f5668c;
        if (length >= i5 && (i4 = this.f5667b) >= 0) {
            this.f5667b = i5;
            if (i4 < i5) {
                do {
                    longConsumer.accept(jArr[i4]);
                    i4++;
                } while (i4 < i5);
            }
        }
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        int i4 = this.f5667b;
        if (i4 < 0 || i4 >= this.f5668c) {
            return false;
        }
        this.f5667b = i4 + 1;
        longConsumer.accept(this.f5666a[i4]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f5668c - this.f5667b);
    }

    public final int characteristics() {
        return this.f5669d;
    }

    public final Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
