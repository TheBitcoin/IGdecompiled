package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.y2  reason: case insensitive filesystem */
public final class C1253y2 extends C1237u2 {

    /* renamed from: c  reason: collision with root package name */
    public N2 f5640c;

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.N2, j$.util.stream.R2] */
    public final void k(long j4) {
        ? r22;
        if (j4 < 2147483639) {
            if (j4 > 0) {
                int i4 = (int) j4;
            } else {
                r22 = new R2();
            }
            this.f5640c = r22;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        int[] iArr = (int[]) this.f5640c.d();
        Arrays.sort(iArr);
        C1187i2 i2Var = this.f5481a;
        i2Var.k((long) iArr.length);
        int i4 = 0;
        if (!this.f5613b) {
            int length = iArr.length;
            while (i4 < length) {
                i2Var.accept(iArr[i4]);
                i4++;
            }
        } else {
            int length2 = iArr.length;
            while (i4 < length2) {
                int i5 = iArr[i4];
                if (i2Var.m()) {
                    break;
                }
                i2Var.accept(i5);
                i4++;
            }
        }
        i2Var.j();
    }

    public final void accept(int i4) {
        this.f5640c.accept(i4);
    }
}
