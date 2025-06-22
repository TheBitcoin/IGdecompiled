package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

public final class Z2 extends C1158c3 implements DoubleConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final double[] f5457c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public Z2(int i4) {
        this.f5457c = new double[i4];
    }

    public final void b(Object obj, long j4) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i4 = 0; ((long) i4) < j4; i4++) {
            doubleConsumer.accept(this.f5457c[i4]);
        }
    }

    public final void accept(double d5) {
        int i4 = this.f5482b;
        this.f5482b = i4 + 1;
        this.f5457c[i4] = d5;
    }
}
