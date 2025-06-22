package com.google.android.gms.internal.measurement;

import java.util.Arrays;

public final class D5 {

    /* renamed from: f  reason: collision with root package name */
    private static final D5 f1442f = new D5(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f1443a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f1444b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f1445c;

    /* renamed from: d  reason: collision with root package name */
    private int f1446d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1447e;

    private D5() {
        this(0, new int[8], new Object[8], true);
    }

    static D5 c(D5 d5, D5 d52) {
        int i4 = d5.f1443a + d52.f1443a;
        int[] copyOf = Arrays.copyOf(d5.f1444b, i4);
        System.arraycopy(d52.f1444b, 0, copyOf, d5.f1443a, d52.f1443a);
        Object[] copyOf2 = Arrays.copyOf(d5.f1445c, i4);
        System.arraycopy(d52.f1445c, 0, copyOf2, d5.f1443a, d52.f1443a);
        return new D5(i4, copyOf, copyOf2, true);
    }

    private final void d(int i4) {
        int[] iArr = this.f1444b;
        if (i4 > iArr.length) {
            int i5 = this.f1443a;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.f1444b = Arrays.copyOf(iArr, i4);
            this.f1445c = Arrays.copyOf(this.f1445c, i4);
        }
    }

    private static void f(int i4, Object obj, W5 w5) {
        int i5 = i4 >>> 3;
        int i6 = i4 & 7;
        if (i6 == 0) {
            w5.f(i5, ((Long) obj).longValue());
        } else if (i6 == 1) {
            w5.w(i5, ((Long) obj).longValue());
        } else if (i6 == 2) {
            w5.j(i5, (K3) obj);
        } else if (i6 != 3) {
            if (i6 == 5) {
                w5.h(i5, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(B4.a());
        } else if (w5.A() == 1) {
            w5.d(i5);
            ((D5) obj).j(w5);
            w5.a(i5);
        } else {
            w5.a(i5);
            ((D5) obj).j(w5);
            w5.d(i5);
        }
    }

    public static D5 k() {
        return f1442f;
    }

    static D5 l() {
        return new D5();
    }

    private final void n() {
        if (!this.f1447e) {
            throw new UnsupportedOperationException();
        }
    }

    public final int a() {
        int m02;
        int i4 = this.f1446d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f1443a; i6++) {
            int i7 = this.f1444b[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 == 0) {
                m02 = C0520b4.m0(i8, ((Long) this.f1445c[i6]).longValue());
            } else if (i9 == 1) {
                m02 = C0520b4.P(i8, ((Long) this.f1445c[i6]).longValue());
            } else if (i9 == 2) {
                m02 = C0520b4.Q(i8, (K3) this.f1445c[i6]);
            } else if (i9 == 3) {
                m02 = (C0520b4.s0(i8) << 1) + ((D5) this.f1445c[i6]).a();
            } else if (i9 == 5) {
                m02 = C0520b4.h0(i8, ((Integer) this.f1445c[i6]).intValue());
            } else {
                throw new IllegalStateException(B4.a());
            }
            i5 += m02;
        }
        this.f1446d = i5;
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final D5 b(D5 d5) {
        if (d5.equals(f1442f)) {
            return this;
        }
        n();
        int i4 = this.f1443a + d5.f1443a;
        d(i4);
        System.arraycopy(d5.f1444b, 0, this.f1444b, this.f1443a, d5.f1443a);
        System.arraycopy(d5.f1445c, 0, this.f1445c, this.f1443a, d5.f1443a);
        this.f1443a = i4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void e(int i4, Object obj) {
        n();
        d(this.f1443a + 1);
        int[] iArr = this.f1444b;
        int i5 = this.f1443a;
        iArr[i5] = i4;
        this.f1445c[i5] = obj;
        this.f1443a = i5 + 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof D5)) {
            return false;
        }
        D5 d5 = (D5) obj;
        int i4 = this.f1443a;
        if (i4 == d5.f1443a) {
            int[] iArr = this.f1444b;
            int[] iArr2 = d5.f1444b;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    Object[] objArr = this.f1445c;
                    Object[] objArr2 = d5.f1445c;
                    int i6 = this.f1443a;
                    int i7 = 0;
                    while (i7 < i6) {
                        if (objArr[i7].equals(objArr2[i7])) {
                            i7++;
                        }
                    }
                    return true;
                } else if (iArr[i5] != iArr2[i5]) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void g(W5 w5) {
        if (w5.A() == 2) {
            for (int i4 = this.f1443a - 1; i4 >= 0; i4--) {
                w5.o(this.f1444b[i4] >>> 3, this.f1445c[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.f1443a; i5++) {
            w5.o(this.f1444b[i5] >>> 3, this.f1445c[i5]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void h(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.f1443a; i5++) {
            C0512a5.d(sb, i4, String.valueOf(this.f1444b[i5] >>> 3), this.f1445c[i5]);
        }
    }

    public final int hashCode() {
        int i4 = this.f1443a;
        int i5 = (i4 + 527) * 31;
        int[] iArr = this.f1444b;
        int i6 = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i4; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i5 + i7) * 31;
        Object[] objArr = this.f1445c;
        int i10 = this.f1443a;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = (i6 * 31) + objArr[i11].hashCode();
        }
        return i9 + i6;
    }

    public final int i() {
        int i4 = this.f1446d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f1443a; i6++) {
            i5 += C0520b4.Z(this.f1444b[i6] >>> 3, (K3) this.f1445c[i6]);
        }
        this.f1446d = i5;
        return i5;
    }

    public final void j(W5 w5) {
        if (this.f1443a != 0) {
            if (w5.A() == 1) {
                for (int i4 = 0; i4 < this.f1443a; i4++) {
                    f(this.f1444b[i4], this.f1445c[i4], w5);
                }
                return;
            }
            for (int i5 = this.f1443a - 1; i5 >= 0; i5--) {
                f(this.f1444b[i5], this.f1445c[i5], w5);
            }
        }
    }

    public final void m() {
        if (this.f1447e) {
            this.f1447e = false;
        }
    }

    private D5(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.f1446d = -1;
        this.f1443a = i4;
        this.f1444b = iArr;
        this.f1445c = objArr;
        this.f1447e = z4;
    }
}
