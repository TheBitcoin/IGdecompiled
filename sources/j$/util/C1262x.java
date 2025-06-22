package j$.util;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.x  reason: case insensitive filesystem */
public final class C1262x implements IntConsumer {
    private long count;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private long sum;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i4) {
        this.count++;
        this.sum += (long) i4;
        this.min = Math.min(this.min, i4);
        this.max = Math.max(this.max, i4);
    }

    public final void b(C1262x xVar) {
        this.count += xVar.count;
        this.sum += xVar.sum;
        this.min = Math.min(this.min, xVar.min);
        this.max = Math.max(this.max, xVar.max);
    }

    public final String toString() {
        String simpleName = C1262x.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        Long valueOf2 = Long.valueOf(this.sum);
        Integer valueOf3 = Integer.valueOf(this.min);
        long j4 = this.count;
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", new Object[]{simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(j4 > 0 ? ((double) this.sum) / ((double) j4) : 0.0d), Integer.valueOf(this.max)});
    }
}
