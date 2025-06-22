package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.x2  reason: case insensitive filesystem */
public final class C1249x2 extends C1233t2 {

    /* renamed from: c  reason: collision with root package name */
    public L2 f5633c;

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.L2, j$.util.stream.R2] */
    public final void k(long j4) {
        ? r22;
        if (j4 < 2147483639) {
            if (j4 > 0) {
                int i4 = (int) j4;
            } else {
                r22 = new R2();
            }
            this.f5633c = r22;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        double[] dArr = (double[]) this.f5633c.d();
        Arrays.sort(dArr);
        C1187i2 i2Var = this.f5475a;
        i2Var.k((long) dArr.length);
        int i4 = 0;
        if (!this.f5608b) {
            int length = dArr.length;
            while (i4 < length) {
                i2Var.accept(dArr[i4]);
                i4++;
            }
        } else {
            int length2 = dArr.length;
            while (i4 < length2) {
                double d5 = dArr[i4];
                if (i2Var.m()) {
                    break;
                }
                i2Var.accept(d5);
                i4++;
            }
        }
        i2Var.j();
    }

    public final void accept(double d5) {
        this.f5633c.accept(d5);
    }
}
