package j$.util.concurrent;

import j$.util.C1127b;
import j$.util.c0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class y implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public long f5189a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5190b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5191c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5192d;

    public final int characteristics() {
        return 17728;
    }

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

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public y(long j4, long j5, long j6, long j7) {
        this.f5189a = j4;
        this.f5190b = j5;
        this.f5191c = j6;
        this.f5192d = j7;
    }

    /* renamed from: a */
    public final y trySplit() {
        long j4 = this.f5189a;
        long j5 = (this.f5190b + j4) >>> 1;
        if (j5 <= j4) {
            return null;
        }
        this.f5189a = j5;
        return new y(j4, j5, this.f5191c, this.f5192d);
    }

    public final long estimateSize() {
        return this.f5190b - this.f5189a;
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j4 = this.f5189a;
        if (j4 >= this.f5190b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().c(this.f5191c, this.f5192d));
        this.f5189a = j4 + 1;
        return true;
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j4 = this.f5189a;
        long j5 = this.f5190b;
        if (j4 < j5) {
            this.f5189a = j5;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                longConsumer.accept(current.c(this.f5191c, this.f5192d));
                j4++;
            } while (j4 < j5);
        }
    }
}
