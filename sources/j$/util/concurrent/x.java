package j$.util.concurrent;

import j$.util.C1127b;
import j$.util.Z;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class x implements Z {

    /* renamed from: a  reason: collision with root package name */
    public long f5185a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5186b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5187c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5188d;

    public final int characteristics() {
        return 17728;
    }

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

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public x(long j4, long j5, int i4, int i5) {
        this.f5185a = j4;
        this.f5186b = j5;
        this.f5187c = i4;
        this.f5188d = i5;
    }

    /* renamed from: a */
    public final x trySplit() {
        long j4 = this.f5185a;
        long j5 = (this.f5186b + j4) >>> 1;
        if (j5 <= j4) {
            return null;
        }
        this.f5185a = j5;
        return new x(j4, j5, this.f5187c, this.f5188d);
    }

    public final long estimateSize() {
        return this.f5186b - this.f5185a;
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j4 = this.f5185a;
        if (j4 >= this.f5186b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().b(this.f5187c, this.f5188d));
        this.f5185a = j4 + 1;
        return true;
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j4 = this.f5185a;
        long j5 = this.f5186b;
        if (j4 < j5) {
            this.f5185a = j5;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                intConsumer.accept(current.b(this.f5187c, this.f5188d));
                j4++;
            } while (j4 < j5);
        }
    }
}
