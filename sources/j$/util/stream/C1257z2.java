package j$.util.stream;

import java.util.Arrays;

/* renamed from: j$.util.stream.z2  reason: case insensitive filesystem */
public final class C1257z2 extends C1241v2 {

    /* renamed from: c  reason: collision with root package name */
    public P2 f5650c;

    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.P2, j$.util.stream.R2] */
    public final void k(long j4) {
        ? r22;
        if (j4 < 2147483639) {
            if (j4 > 0) {
                int i4 = (int) j4;
            } else {
                r22 = new R2();
            }
            this.f5650c = r22;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        long[] jArr = (long[]) this.f5650c.d();
        Arrays.sort(jArr);
        C1187i2 i2Var = this.f5493a;
        i2Var.k((long) jArr.length);
        int i4 = 0;
        if (!this.f5621b) {
            int length = jArr.length;
            while (i4 < length) {
                i2Var.accept(jArr[i4]);
                i4++;
            }
        } else {
            int length2 = jArr.length;
            while (i4 < length2) {
                long j4 = jArr[i4];
                if (i2Var.m()) {
                    break;
                }
                i2Var.accept(j4);
                i4++;
            }
        }
        i2Var.j();
    }

    public final void accept(long j4) {
        this.f5650c.accept(j4);
    }
}
