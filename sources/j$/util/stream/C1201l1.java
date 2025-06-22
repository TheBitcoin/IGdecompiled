package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.l1  reason: case insensitive filesystem */
public final class C1201l1 extends C1217p1 implements C1172f2 {

    /* renamed from: h  reason: collision with root package name */
    public final double[] f5539h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public C1201l1(i0 i0Var, C1144a aVar, double[] dArr) {
        super(i0Var, aVar, dArr.length);
        this.f5539h = dArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1201l1(j$.util.stream.C1201l1 r10, j$.util.i0 r11, long r12, long r14) {
        /*
            r9 = this;
            double[] r0 = r10.f5539h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            double[] r10 = r2.f5539h
            r1.f5539h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1201l1.<init>(j$.util.stream.l1, j$.util.i0, long, long):void");
    }

    public final C1217p1 b(i0 i0Var, long j4, long j5) {
        return new C1201l1(this, i0Var, j4, j5);
    }

    public final void accept(double d5) {
        int i4 = this.f5565f;
        if (i4 < this.f5566g) {
            double[] dArr = this.f5539h;
            this.f5565f = i4 + 1;
            dArr[i4] = d5;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f5565f));
    }
}
