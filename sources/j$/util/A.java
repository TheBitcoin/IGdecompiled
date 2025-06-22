package j$.util;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public final class A implements LongConsumer, IntConsumer {
    private long count;
    private long max = Long.MIN_VALUE;
    private long min = Long.MAX_VALUE;
    private long sum;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void accept(int i4) {
        accept((long) i4);
    }

    public final void accept(long j4) {
        this.count++;
        this.sum += j4;
        this.min = Math.min(this.min, j4);
        this.max = Math.max(this.max, j4);
    }

    public final void b(A a5) {
        this.count += a5.count;
        this.sum += a5.sum;
        this.min = Math.min(this.min, a5.min);
        this.max = Math.max(this.max, a5.max);
    }

    public final String toString() {
        String simpleName = A.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        Long valueOf2 = Long.valueOf(this.sum);
        Long valueOf3 = Long.valueOf(this.min);
        long j4 = this.count;
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", new Object[]{simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(j4 > 0 ? ((double) this.sum) / ((double) j4) : 0.0d), Long.valueOf(this.max)});
    }
}
