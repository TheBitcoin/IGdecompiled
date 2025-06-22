package j$.util.stream;

import java.util.Arrays;

public final class I2 extends C1245w2 {

    /* renamed from: d  reason: collision with root package name */
    public Object[] f5326d;

    /* renamed from: e  reason: collision with root package name */
    public int f5327e;

    public final void k(long j4) {
        if (j4 < 2147483639) {
            this.f5326d = new Object[((int) j4)];
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        int i4 = 0;
        Arrays.sort(this.f5326d, 0, this.f5327e, this.f5626b);
        C1187i2 i2Var = this.f5498a;
        i2Var.k((long) this.f5327e);
        if (!this.f5627c) {
            while (i4 < this.f5327e) {
                i2Var.accept(this.f5326d[i4]);
                i4++;
            }
        } else {
            while (i4 < this.f5327e && !i2Var.m()) {
                i2Var.accept(this.f5326d[i4]);
                i4++;
            }
        }
        i2Var.j();
        this.f5326d = null;
    }

    public final void accept(Object obj) {
        Object[] objArr = this.f5326d;
        int i4 = this.f5327e;
        this.f5327e = i4 + 1;
        objArr[i4] = obj;
    }
}
