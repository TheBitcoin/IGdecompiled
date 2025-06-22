package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

public class u0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final Collection f5661a;

    /* renamed from: b  reason: collision with root package name */
    public Iterator f5662b = null;

    /* renamed from: c  reason: collision with root package name */
    public final int f5663c;

    /* renamed from: d  reason: collision with root package name */
    public long f5664d;

    /* renamed from: e  reason: collision with root package name */
    public int f5665e;

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public u0(int i4, Collection collection) {
        this.f5661a = collection;
        this.f5663c = i4 | 16448;
    }

    public final i0 trySplit() {
        long j4;
        Iterator it = this.f5662b;
        if (it == null) {
            Collection collection = this.f5661a;
            Iterator it2 = collection.iterator();
            this.f5662b = it2;
            j4 = (long) collection.size();
            this.f5664d = j4;
            it = it2;
        } else {
            j4 = this.f5664d;
        }
        if (j4 <= 1 || !it.hasNext()) {
            return null;
        }
        int i4 = this.f5665e + 1024;
        if (((long) i4) > j4) {
            i4 = (int) j4;
        }
        if (i4 > 33554432) {
            i4 = 33554432;
        }
        Object[] objArr = new Object[i4];
        int i5 = 0;
        do {
            objArr[i5] = it.next();
            i5++;
            if (i5 >= i4 || !it.hasNext()) {
                this.f5665e = i5;
                long j5 = this.f5664d;
            }
            objArr[i5] = it.next();
            i5++;
            break;
        } while (!it.hasNext());
        this.f5665e = i5;
        long j52 = this.f5664d;
        if (j52 != Long.MAX_VALUE) {
            this.f5664d = j52 - ((long) i5);
        }
        return new n0(objArr, 0, i5, this.f5663c);
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f5662b;
        if (it == null) {
            Collection collection = this.f5661a;
            Iterator it2 = collection.iterator();
            this.f5662b = it2;
            this.f5664d = (long) collection.size();
            it = it2;
        }
        C1127b.t(it, consumer);
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        if (this.f5662b == null) {
            Collection collection = this.f5661a;
            this.f5662b = collection.iterator();
            this.f5664d = (long) collection.size();
        }
        if (!this.f5662b.hasNext()) {
            return false;
        }
        consumer.accept(this.f5662b.next());
        return true;
    }

    public final long estimateSize() {
        if (this.f5662b != null) {
            return this.f5664d;
        }
        Collection collection = this.f5661a;
        this.f5662b = collection.iterator();
        long size = (long) collection.size();
        this.f5664d = size;
        return size;
    }

    public final int characteristics() {
        return this.f5663c;
    }

    public Comparator getComparator() {
        if (C1127b.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
