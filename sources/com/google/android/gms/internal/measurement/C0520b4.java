package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.measurement.b4  reason: case insensitive filesystem */
public abstract class C0520b4 extends L3 {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f1756b = Logger.getLogger(C0520b4.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f1757c = F5.w();

    /* renamed from: a  reason: collision with root package name */
    C0547e4 f1758a;

    /* renamed from: com.google.android.gms.internal.measurement.b4$a */
    private static class a extends C0520b4 {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f1759d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1760e;

        /* renamed from: f  reason: collision with root package name */
        private int f1761f;

        a(byte[] bArr, int i4, int i5) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if (((bArr.length - i5) | i5) >= 0) {
                this.f1759d = bArr;
                this.f1761f = 0;
                this.f1760e = i5;
            } else {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i5)}));
            }
        }

        private final void A0(byte[] bArr, int i4, int i5) {
            try {
                System.arraycopy(bArr, i4, this.f1759d, this.f1761f, i5);
                this.f1761f += i5;
            } catch (IndexOutOfBoundsException e5) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1761f), Integer.valueOf(this.f1760e), Integer.valueOf(i5)}), e5);
            }
        }

        public final void H(int i4) {
            if (i4 >= 0) {
                U(i4);
            } else {
                N((long) i4);
            }
        }

        public final void K(int i4, int i5) {
            V(i4, 0);
            H(i5);
        }

        public final void L(int i4, long j4) {
            V(i4, 0);
            N(j4);
        }

        public final void M(int i4, K3 k32) {
            V(1, 3);
            b0(2, i4);
            n(3, k32);
            V(1, 4);
        }

        public final void N(long j4) {
            if (!C0520b4.f1757c || b() < 10) {
                while ((j4 & -128) != 0) {
                    byte[] bArr = this.f1759d;
                    int i4 = this.f1761f;
                    this.f1761f = i4 + 1;
                    bArr[i4] = (byte) (((int) j4) | 128);
                    j4 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f1759d;
                    int i5 = this.f1761f;
                    this.f1761f = i5 + 1;
                    bArr2[i5] = (byte) ((int) j4);
                } catch (IndexOutOfBoundsException e5) {
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1761f), Integer.valueOf(this.f1760e), 1}), e5);
                }
            } else {
                while ((j4 & -128) != 0) {
                    byte[] bArr3 = this.f1759d;
                    int i6 = this.f1761f;
                    this.f1761f = i6 + 1;
                    F5.m(bArr3, (long) i6, (byte) (((int) j4) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr4 = this.f1759d;
                int i7 = this.f1761f;
                this.f1761f = 1 + i7;
                F5.m(bArr4, (long) i7, (byte) ((int) j4));
            }
        }

        public final void U(int i4) {
            while ((i4 & -128) != 0) {
                byte[] bArr = this.f1759d;
                int i5 = this.f1761f;
                this.f1761f = i5 + 1;
                bArr[i5] = (byte) (i4 | 128);
                i4 >>>= 7;
            }
            try {
                byte[] bArr2 = this.f1759d;
                int i6 = this.f1761f;
                this.f1761f = i6 + 1;
                bArr2[i6] = (byte) i4;
            } catch (IndexOutOfBoundsException e5) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1761f), Integer.valueOf(this.f1760e), 1}), e5);
            }
        }

        public final void V(int i4, int i5) {
            U((i4 << 3) | i5);
        }

        public final void a(byte[] bArr, int i4, int i5) {
            A0(bArr, i4, i5);
        }

        public final int b() {
            return this.f1760e - this.f1761f;
        }

        public final void b0(int i4, int i5) {
            V(i4, 0);
            U(i5);
        }

        public final void j(byte b5) {
            int i4 = this.f1761f;
            try {
                int i5 = i4 + 1;
                try {
                    this.f1759d[i4] = b5;
                    this.f1761f = i5;
                } catch (IndexOutOfBoundsException e5) {
                    e = e5;
                    i4 = i5;
                    throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f1760e), 1}), e);
                }
            } catch (IndexOutOfBoundsException e6) {
                e = e6;
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.f1760e), 1}), e);
            }
        }

        public final void k(int i4) {
            try {
                byte[] bArr = this.f1759d;
                int i5 = this.f1761f;
                int i6 = i5 + 1;
                this.f1761f = i6;
                bArr[i5] = (byte) i4;
                int i7 = i5 + 2;
                this.f1761f = i7;
                bArr[i6] = (byte) (i4 >> 8);
                int i8 = i5 + 3;
                this.f1761f = i8;
                bArr[i7] = (byte) (i4 >> 16);
                this.f1761f = i5 + 4;
                bArr[i8] = (byte) (i4 >>> 24);
            } catch (IndexOutOfBoundsException e5) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1761f), Integer.valueOf(this.f1760e), 1}), e5);
            }
        }

        public final void l(int i4, int i5) {
            V(i4, 5);
            k(i5);
        }

        public final void m(int i4, long j4) {
            V(i4, 1);
            s(j4);
        }

        public final void n(int i4, K3 k32) {
            V(i4, 2);
            t(k32);
        }

        public final void o(int i4, Z4 z4) {
            V(1, 3);
            b0(2, i4);
            V(3, 2);
            u(z4);
            V(1, 4);
        }

        /* access modifiers changed from: package-private */
        public final void p(int i4, Z4 z4, C0638o5 o5Var) {
            V(i4, 2);
            U(((C3) z4).e(o5Var));
            o5Var.f(z4, this.f1758a);
        }

        public final void q(int i4, String str) {
            V(i4, 2);
            v(str);
        }

        public final void r(int i4, boolean z4) {
            V(i4, 0);
            j(z4 ? (byte) 1 : 0);
        }

        public final void s(long j4) {
            try {
                byte[] bArr = this.f1759d;
                int i4 = this.f1761f;
                int i5 = i4 + 1;
                this.f1761f = i5;
                bArr[i4] = (byte) ((int) j4);
                int i6 = i4 + 2;
                this.f1761f = i6;
                bArr[i5] = (byte) ((int) (j4 >> 8));
                int i7 = i4 + 3;
                this.f1761f = i7;
                bArr[i6] = (byte) ((int) (j4 >> 16));
                int i8 = i4 + 4;
                this.f1761f = i8;
                bArr[i7] = (byte) ((int) (j4 >> 24));
                int i9 = i4 + 5;
                this.f1761f = i9;
                bArr[i8] = (byte) ((int) (j4 >> 32));
                int i10 = i4 + 6;
                this.f1761f = i10;
                bArr[i9] = (byte) ((int) (j4 >> 40));
                int i11 = i4 + 7;
                this.f1761f = i11;
                bArr[i10] = (byte) ((int) (j4 >> 48));
                this.f1761f = i4 + 8;
                bArr[i11] = (byte) ((int) (j4 >> 56));
            } catch (IndexOutOfBoundsException e5) {
                throw new b(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f1761f), Integer.valueOf(this.f1760e), 1}), e5);
            }
        }

        public final void t(K3 k32) {
            U(k32.q());
            k32.o(this);
        }

        public final void u(Z4 z4) {
            U(z4.d());
            z4.a(this);
        }

        public final void v(String str) {
            int i4 = this.f1761f;
            try {
                int v02 = C0520b4.v0(str.length() * 3);
                int v03 = C0520b4.v0(str.length());
                if (v03 == v02) {
                    int i5 = i4 + v03;
                    this.f1761f = i5;
                    int b5 = J5.b(str, this.f1759d, i5, b());
                    this.f1761f = i4;
                    U((b5 - i4) - v03);
                    this.f1761f = b5;
                    return;
                }
                U(J5.a(str));
                this.f1761f = J5.b(str, this.f1759d, this.f1761f, b());
            } catch (N5 e5) {
                this.f1761f = i4;
                w(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new b(e6);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.b4$b */
    public static class b extends IOException {
        b(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        b(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static int A(K3 k32) {
        int q4 = k32.q();
        return v0(q4) + q4;
    }

    public static int B(Z4 z4) {
        return z4.d();
    }

    public static int C(String str) {
        int i4;
        try {
            i4 = J5.a(str);
        } catch (N5 unused) {
            i4 = str.getBytes(C0684u4.f2196a).length;
        }
        return v0(i4) + i4;
    }

    public static C0520b4 D(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int P(int i4, long j4) {
        return v0(i4 << 3) + 8;
    }

    public static int Q(int i4, K3 k32) {
        int v02 = v0(i4 << 3);
        int q4 = k32.q();
        return v02 + v0(q4) + q4;
    }

    static int R(int i4, Z4 z4, C0638o5 o5Var) {
        return v0(i4 << 3) + g(z4, o5Var);
    }

    public static int S(long j4) {
        return 8;
    }

    public static int T(Z4 z4) {
        int d5 = z4.d();
        return v0(d5) + d5;
    }

    public static int X(int i4) {
        return n0((long) i4);
    }

    public static int Y(int i4, long j4) {
        return v0(i4 << 3) + n0(j4);
    }

    public static int Z(int i4, K3 k32) {
        return (v0(8) << 1) + w0(2, i4) + Q(3, k32);
    }

    public static int a0(long j4) {
        return n0(j4);
    }

    public static int c(double d5) {
        return 8;
    }

    public static int c0(int i4) {
        return 4;
    }

    public static int d(float f4) {
        return 4;
    }

    public static int d0(int i4, int i5) {
        return v0(i4 << 3) + n0((long) i5);
    }

    public static int e(int i4, double d5) {
        return v0(i4 << 3) + 8;
    }

    public static int e0(int i4, long j4) {
        return v0(i4 << 3) + 8;
    }

    public static int f(int i4, float f4) {
        return v0(i4 << 3) + 4;
    }

    public static int f0(long j4) {
        return 8;
    }

    static int g(Z4 z4, C0638o5 o5Var) {
        int e5 = ((C3) z4).e(o5Var);
        return v0(e5) + e5;
    }

    public static int g0(int i4) {
        return n0((long) i4);
    }

    public static int h(boolean z4) {
        return 1;
    }

    public static int h0(int i4, int i5) {
        return v0(i4 << 3) + 4;
    }

    public static int i(byte[] bArr) {
        int length = bArr.length;
        return v0(length) + length;
    }

    public static int i0(int i4, long j4) {
        return v0(i4 << 3) + n0(u0(j4));
    }

    public static int j0(long j4) {
        return n0(u0(j4));
    }

    public static int k0(int i4) {
        return 4;
    }

    public static int l0(int i4, int i5) {
        return v0(i4 << 3) + n0((long) i5);
    }

    public static int m0(int i4, long j4) {
        return v0(i4 << 3) + n0(j4);
    }

    public static int n0(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public static int o0(int i4) {
        return v0(z0(i4));
    }

    public static int p0(int i4, int i5) {
        return v0(i4 << 3) + 4;
    }

    public static int s0(int i4) {
        return v0(i4 << 3);
    }

    public static int t0(int i4, int i5) {
        return v0(i4 << 3) + v0(z0(i5));
    }

    private static long u0(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static int v0(int i4) {
        return (352 - (Integer.numberOfLeadingZeros(i4) * 9)) >>> 6;
    }

    public static int w0(int i4, int i5) {
        return v0(i4 << 3) + v0(i5);
    }

    static int x(int i4, Z4 z4, C0638o5 o5Var) {
        return (v0(i4 << 3) << 1) + ((C3) z4).e(o5Var);
    }

    public static int y(int i4, String str) {
        return v0(i4 << 3) + C(str);
    }

    public static int z(int i4, boolean z4) {
        return v0(i4 << 3) + 1;
    }

    private static int z0(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public final void E() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void F(double d5) {
        s(Double.doubleToRawLongBits(d5));
    }

    public final void G(float f4) {
        k(Float.floatToRawIntBits(f4));
    }

    public abstract void H(int i4);

    public final void I(int i4, double d5) {
        m(i4, Double.doubleToRawLongBits(d5));
    }

    public final void J(int i4, float f4) {
        l(i4, Float.floatToRawIntBits(f4));
    }

    public abstract void K(int i4, int i5);

    public abstract void L(int i4, long j4);

    public abstract void M(int i4, K3 k32);

    public abstract void N(long j4);

    public final void O(boolean z4) {
        j(z4 ? (byte) 1 : 0);
    }

    public abstract void U(int i4);

    public abstract void V(int i4, int i5);

    public abstract int b();

    public abstract void b0(int i4, int i5);

    public abstract void j(byte b5);

    public abstract void k(int i4);

    public abstract void l(int i4, int i5);

    public abstract void m(int i4, long j4);

    public abstract void n(int i4, K3 k32);

    public abstract void o(int i4, Z4 z4);

    /* access modifiers changed from: package-private */
    public abstract void p(int i4, Z4 z4, C0638o5 o5Var);

    public abstract void q(int i4, String str);

    public final void q0(int i4, long j4) {
        L(i4, u0(j4));
    }

    public abstract void r(int i4, boolean z4);

    public final void r0(long j4) {
        N(u0(j4));
    }

    public abstract void s(long j4);

    public abstract void t(K3 k32);

    public abstract void u(Z4 z4);

    public abstract void v(String str);

    /* access modifiers changed from: package-private */
    public final void w(String str, N5 n5) {
        f1756b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", n5);
        byte[] bytes = str.getBytes(C0684u4.f2196a);
        try {
            U(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new b(e5);
        }
    }

    public final void x0(int i4) {
        U(z0(i4));
    }

    public final void y0(int i4, int i5) {
        b0(i4, z0(i5));
    }

    private C0520b4() {
    }
}
