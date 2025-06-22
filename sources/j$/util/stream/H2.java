package j$.util.stream;

import java.util.Arrays;

public final class H2 extends C1241v2 {

    /* renamed from: c  reason: collision with root package name */
    public long[] f5313c;

    /* renamed from: d  reason: collision with root package name */
    public int f5314d;

    public final void k(long j4) {
        if (j4 < 2147483639) {
            this.f5313c = new long[((int) j4)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        int i4 = 0;
        Arrays.sort(this.f5313c, 0, this.f5314d);
        C1187i2 i2Var = this.f5493a;
        i2Var.k((long) this.f5314d);
        if (!this.f5621b) {
            while (i4 < this.f5314d) {
                i2Var.accept(this.f5313c[i4]);
                i4++;
            }
        } else {
            while (i4 < this.f5314d && !i2Var.m()) {
                i2Var.accept(this.f5313c[i4]);
                i4++;
            }
        }
        i2Var.j();
        this.f5313c = null;
    }

    public final void accept(long j4) {
        long[] jArr = this.f5313c;
        int i4 = this.f5314d;
        this.f5314d = i4 + 1;
        jArr[i4] = j4;
    }
}
