package j$.util.stream;

import java.util.Arrays;

public final class F2 extends C1233t2 {

    /* renamed from: c  reason: collision with root package name */
    public double[] f5288c;

    /* renamed from: d  reason: collision with root package name */
    public int f5289d;

    public final void k(long j4) {
        if (j4 < 2147483639) {
            this.f5288c = new double[((int) j4)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        int i4 = 0;
        Arrays.sort(this.f5288c, 0, this.f5289d);
        C1187i2 i2Var = this.f5475a;
        i2Var.k((long) this.f5289d);
        if (!this.f5608b) {
            while (i4 < this.f5289d) {
                i2Var.accept(this.f5288c[i4]);
                i4++;
            }
        } else {
            while (i4 < this.f5289d && !i2Var.m()) {
                i2Var.accept(this.f5288c[i4]);
                i4++;
            }
        }
        i2Var.j();
        this.f5288c = null;
    }

    public final void accept(double d5) {
        double[] dArr = this.f5288c;
        int i4 = this.f5289d;
        this.f5289d = i4 + 1;
        dArr[i4] = d5;
    }
}
