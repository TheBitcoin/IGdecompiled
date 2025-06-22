package j$.util.concurrent;

import j$.util.C1127b;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class f extends p implements i0 {

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentHashMap f5143i;

    /* renamed from: j  reason: collision with root package name */
    public long f5144j;

    public final int characteristics() {
        return 4353;
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

    public f(l[] lVarArr, int i4, int i5, int i6, long j4, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i4, i5, i6);
        this.f5143i = concurrentHashMap;
        this.f5144j = j4;
    }

    public final i0 trySplit() {
        int i4 = this.f5165f;
        int i5 = this.f5166g;
        int i6 = (i4 + i5) >>> 1;
        if (i6 <= i4) {
            return null;
        }
        l[] lVarArr = this.f5160a;
        this.f5166g = i6;
        long j4 = this.f5144j >>> 1;
        this.f5144j = j4;
        return new f(lVarArr, this.f5167h, i6, i5, j4, this.f5143i);
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            l a5 = a();
            if (a5 != null) {
                consumer.accept(new k(a5.f5153b, a5.f5154c, this.f5143i));
            } else {
                return;
            }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        l a5 = a();
        if (a5 == null) {
            return false;
        }
        consumer.accept(new k(a5.f5153b, a5.f5154c, this.f5143i));
        return true;
    }

    public final long estimateSize() {
        return this.f5144j;
    }
}
