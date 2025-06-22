package j$.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Consumer;

/* renamed from: j$.util.a  reason: case insensitive filesystem */
public final class C1126a implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final List f5113a;

    /* renamed from: b  reason: collision with root package name */
    public int f5114b;

    /* renamed from: c  reason: collision with root package name */
    public int f5115c;

    public final int characteristics() {
        return 16464;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public C1126a(List list) {
        this.f5113a = list;
        this.f5114b = 0;
        this.f5115c = -1;
    }

    public C1126a(C1126a aVar, int i4, int i5) {
        this.f5113a = aVar.f5113a;
        this.f5114b = i4;
        this.f5115c = i5;
    }

    public final int a() {
        int i4 = this.f5115c;
        if (i4 >= 0) {
            return i4;
        }
        int size = this.f5113a.size();
        this.f5115c = size;
        return size;
    }

    public final i0 trySplit() {
        int a5 = a();
        int i4 = this.f5114b;
        int i5 = (a5 + i4) >>> 1;
        if (i4 >= i5) {
            return null;
        }
        this.f5114b = i5;
        return new C1126a(this, i4, i5);
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int a5 = a();
        int i4 = this.f5114b;
        if (i4 >= a5) {
            return false;
        }
        this.f5114b = i4 + 1;
        try {
            consumer.accept(this.f5113a.get(i4));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int a5 = a();
        int i4 = this.f5114b;
        this.f5114b = a5;
        while (i4 < a5) {
            try {
                consumer.accept(this.f5113a.get(i4));
                i4++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public final long estimateSize() {
        return (long) (a() - this.f5114b);
    }
}
