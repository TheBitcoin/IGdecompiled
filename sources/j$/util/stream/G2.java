package j$.util.stream;

import java.util.Arrays;

public final class G2 extends C1237u2 {

    /* renamed from: c  reason: collision with root package name */
    public int[] f5300c;

    /* renamed from: d  reason: collision with root package name */
    public int f5301d;

    public final void k(long j4) {
        if (j4 < 2147483639) {
            this.f5300c = new int[((int) j4)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        int i4 = 0;
        Arrays.sort(this.f5300c, 0, this.f5301d);
        C1187i2 i2Var = this.f5481a;
        i2Var.k((long) this.f5301d);
        if (!this.f5613b) {
            while (i4 < this.f5301d) {
                i2Var.accept(this.f5300c[i4]);
                i4++;
            }
        } else {
            while (i4 < this.f5301d && !i2Var.m()) {
                i2Var.accept(this.f5300c[i4]);
                i4++;
            }
        }
        i2Var.j();
        this.f5300c = null;
    }

    public final void accept(int i4) {
        int[] iArr = this.f5300c;
        int i5 = this.f5301d;
        this.f5301d = i5 + 1;
        iArr[i5] = i4;
    }
}
