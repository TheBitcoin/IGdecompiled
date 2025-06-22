package J3;

import java.util.Arrays;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f23601a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f23602b = new int[10];

    /* access modifiers changed from: package-private */
    public void a() {
        this.f23601a = 0;
        Arrays.fill(this.f23602b, 0);
    }

    /* access modifiers changed from: package-private */
    public int b(int i4) {
        return this.f23602b[i4];
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if ((this.f23601a & 2) != 0) {
            return this.f23602b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if ((this.f23601a & 128) != 0) {
            return this.f23602b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int e(int i4) {
        if ((this.f23601a & 16) != 0) {
            return this.f23602b[4];
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public int f(int i4) {
        if ((this.f23601a & 32) != 0) {
            return this.f23602b[5];
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i4) {
        if (((1 << i4) & this.f23601a) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void h(m mVar) {
        for (int i4 = 0; i4 < 10; i4++) {
            if (mVar.g(i4)) {
                i(i4, mVar.b(i4));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public m i(int i4, int i5) {
        if (i4 >= 0) {
            int[] iArr = this.f23602b;
            if (i4 < iArr.length) {
                this.f23601a = (1 << i4) | this.f23601a;
                iArr[i4] = i5;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Integer.bitCount(this.f23601a);
    }
}
