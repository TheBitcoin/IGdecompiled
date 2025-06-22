package j$.util.concurrent;

import j$.util.C1127b;
import j$.util.W;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class w implements W {

    /* renamed from: a  reason: collision with root package name */
    public long f5181a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5182b;

    /* renamed from: c  reason: collision with root package name */
    public final double f5183c;

    /* renamed from: d  reason: collision with root package name */
    public final double f5184d;

    public final int characteristics() {
        return 17728;
    }

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

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public w(long j4, long j5, double d5, double d6) {
        this.f5181a = j4;
        this.f5182b = j5;
        this.f5183c = d5;
        this.f5184d = d6;
    }

    /* renamed from: a */
    public final w trySplit() {
        long j4 = this.f5181a;
        long j5 = (this.f5182b + j4) >>> 1;
        if (j5 <= j4) {
            return null;
        }
        this.f5181a = j5;
        return new w(j4, j5, this.f5183c, this.f5184d);
    }

    public final long estimateSize() {
        return this.f5182b - this.f5181a;
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j4 = this.f5181a;
        if (j4 >= this.f5182b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().a(this.f5183c, this.f5184d));
        this.f5181a = j4 + 1;
        return true;
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j4 = this.f5181a;
        long j5 = this.f5182b;
        if (j4 < j5) {
            this.f5181a = j5;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(current.a(this.f5183c, this.f5184d));
                j4++;
            } while (j4 < j5);
        }
    }
}
