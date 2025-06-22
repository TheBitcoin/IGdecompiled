package N3;

import O3.C2539e;
import S2.C1594h;
import java.security.MessageDigest;
import kotlin.jvm.internal.m;

public final class W extends C2517h {

    /* renamed from: f  reason: collision with root package name */
    private final transient byte[][] f23663f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int[] f23664g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public W(byte[][] bArr, int[] iArr) {
        super(C2517h.f23705e.i());
        m.e(bArr, "segments");
        m.e(iArr, "directory");
        this.f23663f = bArr;
        this.f23664g = iArr;
    }

    private final C2517h Q() {
        return new C2517h(L());
    }

    public C2517h I(int i4, int i5) {
        int d5 = C2511b.d(this, i5);
        if (i4 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i4 + " < 0").toString());
        } else if (d5 <= G()) {
            int i6 = d5 - i4;
            if (i6 < 0) {
                throw new IllegalArgumentException(("endIndex=" + d5 + " < beginIndex=" + i4).toString());
            } else if (i4 == 0 && d5 == G()) {
                return this;
            } else {
                if (i4 == d5) {
                    return C2517h.f23705e;
                }
                int b5 = C2539e.b(this, i4);
                int b6 = C2539e.b(this, d5 - 1);
                byte[][] bArr = (byte[][]) C1594h.i(P(), b5, b6 + 1);
                int[] iArr = new int[(bArr.length * 2)];
                int i7 = 0;
                if (b5 <= b6) {
                    int i8 = b5;
                    int i9 = 0;
                    while (true) {
                        iArr[i9] = Math.min(O()[i8] - i4, i6);
                        int i10 = i9 + 1;
                        iArr[i9 + bArr.length] = O()[P().length + i8];
                        if (i8 == b6) {
                            break;
                        }
                        i8++;
                        i9 = i10;
                    }
                }
                if (b5 != 0) {
                    i7 = O()[b5 - 1];
                }
                int length = bArr.length;
                iArr[length] = iArr[length] + (i4 - i7);
                return new W(bArr, iArr);
            }
        } else {
            throw new IllegalArgumentException(("endIndex=" + d5 + " > length(" + G() + ')').toString());
        }
    }

    public C2517h K() {
        return Q().K();
    }

    public byte[] L() {
        byte[] bArr = new byte[G()];
        int length = P().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = O()[length + i4];
            int i8 = O()[i4];
            int i9 = i8 - i5;
            C1594h.d(P()[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    public void N(C2514e eVar, int i4, int i5) {
        int i6;
        m.e(eVar, "buffer");
        int i7 = i4 + i5;
        int b5 = C2539e.b(this, i4);
        while (i4 < i7) {
            if (b5 == 0) {
                i6 = 0;
            } else {
                i6 = O()[b5 - 1];
            }
            int i8 = O()[P().length + b5];
            int min = Math.min(i7, (O()[b5] - i6) + i6) - i4;
            int i9 = i8 + (i4 - i6);
            U u4 = new U(P()[b5], i9, i9 + min, true, false);
            U u5 = eVar.f23694a;
            if (u5 == null) {
                u4.f23657g = u4;
                u4.f23656f = u4;
                eVar.f23694a = u4;
            } else {
                m.b(u5);
                U u6 = u5.f23657g;
                m.b(u6);
                u6.c(u4);
            }
            i4 += min;
            b5++;
        }
        eVar.z(eVar.A() + ((long) i5));
    }

    public final int[] O() {
        return this.f23664g;
    }

    public final byte[][] P() {
        return this.f23663f;
    }

    public String a() {
        return Q().a();
    }

    public C2517h e(String str) {
        m.e(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = P().length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = O()[length + i4];
            int i7 = O()[i4];
            instance.update(P()[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
        byte[] digest = instance.digest();
        m.d(digest, "digestBytes");
        return new C2517h(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2517h) {
            C2517h hVar = (C2517h) obj;
            if (hVar.G() != G() || !x(0, hVar, 0, G())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int j4 = j();
        if (j4 != 0) {
            return j4;
        }
        int length = P().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i4 < length) {
            int i7 = O()[length + i4];
            int i8 = O()[i4];
            byte[] bArr = P()[i4];
            int i9 = (i8 - i5) + i7;
            while (i7 < i9) {
                i6 = (i6 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i5 = i8;
        }
        z(i6);
        return i6;
    }

    public int k() {
        return O()[P().length - 1];
    }

    public String m() {
        return Q().m();
    }

    public int o(byte[] bArr, int i4) {
        m.e(bArr, "other");
        return Q().o(bArr, i4);
    }

    public byte[] q() {
        return L();
    }

    public byte r(int i4) {
        int i5;
        C2511b.b((long) O()[P().length - 1], (long) i4, 1);
        int b5 = C2539e.b(this, i4);
        if (b5 == 0) {
            i5 = 0;
        } else {
            i5 = O()[b5 - 1];
        }
        return P()[b5][(i4 - i5) + O()[P().length + b5]];
    }

    public int t(byte[] bArr, int i4) {
        m.e(bArr, "other");
        return Q().t(bArr, i4);
    }

    public String toString() {
        return Q().toString();
    }

    public boolean x(int i4, C2517h hVar, int i5, int i6) {
        int i7;
        m.e(hVar, "other");
        if (i4 < 0 || i4 > G() - i6) {
            return false;
        }
        int i8 = i6 + i4;
        int b5 = C2539e.b(this, i4);
        while (i4 < i8) {
            if (b5 == 0) {
                i7 = 0;
            } else {
                i7 = O()[b5 - 1];
            }
            int i9 = O()[P().length + b5];
            int min = Math.min(i8, (O()[b5] - i7) + i7) - i4;
            if (!hVar.y(i5, P()[b5], i9 + (i4 - i7), min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            b5++;
        }
        return true;
    }

    public boolean y(int i4, byte[] bArr, int i5, int i6) {
        int i7;
        m.e(bArr, "other");
        if (i4 < 0 || i4 > G() - i6 || i5 < 0 || i5 > bArr.length - i6) {
            return false;
        }
        int i8 = i6 + i4;
        int b5 = C2539e.b(this, i4);
        while (i4 < i8) {
            if (b5 == 0) {
                i7 = 0;
            } else {
                i7 = O()[b5 - 1];
            }
            int i9 = O()[P().length + b5];
            int min = Math.min(i8, (O()[b5] - i7) + i7) - i4;
            if (!C2511b.a(P()[b5], i9 + (i4 - i7), bArr, i5, min)) {
                return false;
            }
            i5 += min;
            i4 += min;
            b5++;
        }
        return true;
    }
}
