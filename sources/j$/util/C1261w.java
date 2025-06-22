package j$.util;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.w  reason: case insensitive filesystem */
public final class C1261w implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public double f5670a;

    /* renamed from: b  reason: collision with root package name */
    public double f5671b;
    private long count;
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void accept(double d5) {
        this.count++;
        this.f5671b += d5;
        c(d5);
        this.min = Math.min(this.min, d5);
        this.max = Math.max(this.max, d5);
    }

    public final void b(C1261w wVar) {
        this.count += wVar.count;
        this.f5671b += wVar.f5671b;
        c(wVar.sum);
        c(wVar.f5670a);
        this.min = Math.min(this.min, wVar.min);
        this.max = Math.max(this.max, wVar.max);
    }

    public final void c(double d5) {
        double d6 = d5 - this.f5670a;
        double d7 = this.sum;
        double d8 = d7 + d6;
        this.f5670a = (d8 - d7) - d6;
        this.sum = d8;
    }

    public final String toString() {
        double d5;
        String simpleName = C1261w.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        double d6 = this.sum + this.f5670a;
        if (Double.isNaN(d6) && Double.isInfinite(this.f5671b)) {
            d6 = this.f5671b;
        }
        Double valueOf2 = Double.valueOf(d6);
        Double valueOf3 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d7 = this.sum + this.f5670a;
            if (Double.isNaN(d7) && Double.isInfinite(this.f5671b)) {
                d7 = this.f5671b;
            }
            d5 = d7 / ((double) this.count);
        } else {
            d5 = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", new Object[]{simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(d5), Double.valueOf(this.max)});
    }
}
