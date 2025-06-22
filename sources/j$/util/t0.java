package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class t0 implements Z {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5657a;

    /* renamed from: b  reason: collision with root package name */
    public int f5658b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5659c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5660d;

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C1127b.b(this, consumer);
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C1127b.i(this, consumer);
    }

    public t0(int[] iArr, int i4, int i5, int i6) {
        this.f5657a = iArr;
        this.f5658b = i4;
        this.f5659c = i5;
        this.f5660d = i6 | 16448;
    }

    public final Z trySplit() {
        int i4 = this.f5658b;
        int i5 = (this.f5659c + i4) >>> 1;
        if (i4 >= i5) {
            return null;
        }
        this.f5658b = i5;
        return new t0(this.f5657a, i4, i5, this.f5660d);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        int i4;
        intConsumer.getClass();
        int[] iArr = this.f5657a;
        int length = iArr.length;
        int i5 = this.f5659c;
        if (length >= i5 && (i4 = this.f5658b) >= 0) {
            this.f5658b = i5;
            if (i4 < i5) {
                do {
                    intConsumer.accept(iArr[i4]);
                    i4++;
                } while (i4 < i5);
            }
        }
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        int i4 = this.f5658b;
        if (i4 < 0 || i4 >= this.f5659c) {
            return false;
        }
        this.f5658b = i4 + 1;
        intConsumer.accept(this.f5657a[i4]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f5659c - this.f5658b);
    }

    public final int characteristics() {
        return this.f5660d;
    }

    public final Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
