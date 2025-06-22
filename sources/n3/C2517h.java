package N3;

import O3.C2536b;
import S2.C1594h;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: N3.h  reason: case insensitive filesystem */
public class C2517h implements Serializable, Comparable {

    /* renamed from: d  reason: collision with root package name */
    public static final a f23704d = new a((C2103g) null);

    /* renamed from: e  reason: collision with root package name */
    public static final C2517h f23705e = new C2517h(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f23706a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f23707b;

    /* renamed from: c  reason: collision with root package name */
    private transient String f23708c;

    /* renamed from: N3.h$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C2517h a(String str) {
            m.e(str, "<this>");
            byte[] a5 = C2510a.a(str);
            if (a5 != null) {
                return new C2517h(a5);
            }
            return null;
        }

        public final C2517h b(String str) {
            m.e(str, "<this>");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * 2;
                    bArr[i4] = (byte) ((C2536b.e(str.charAt(i5)) << 4) + C2536b.e(str.charAt(i5 + 1)));
                }
                return new C2517h(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final C2517h c(String str) {
            m.e(str, "<this>");
            C2517h hVar = new C2517h(c0.a(str));
            hVar.E(str);
            return hVar;
        }

        public final C2517h d(byte... bArr) {
            m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            m.d(copyOf, "copyOf(this, size)");
            return new C2517h(copyOf);
        }

        private a() {
        }
    }

    public C2517h(byte[] bArr) {
        m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
        this.f23706a = bArr;
    }

    public static /* synthetic */ C2517h J(C2517h hVar, int i4, int i5, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                i4 = 0;
            }
            if ((i6 & 2) != 0) {
                i5 = C2511b.c();
            }
            return hVar.I(i4, i5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    public static final C2517h c(String str) {
        return f23704d.a(str);
    }

    public static final C2517h d(String str) {
        return f23704d.b(str);
    }

    public static final C2517h f(String str) {
        return f23704d.c(str);
    }

    public static /* synthetic */ int p(C2517h hVar, C2517h hVar2, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = 0;
            }
            return hVar.n(hVar2, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int u(C2517h hVar, C2517h hVar2, int i4, int i5, Object obj) {
        if (obj == null) {
            if ((i5 & 2) != 0) {
                i4 = C2511b.c();
            }
            return hVar.s(hVar2, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final C2517h w(byte... bArr) {
        return f23704d.d(bArr);
    }

    public final void E(String str) {
        this.f23708c = str;
    }

    public final C2517h F() {
        return e("SHA-256");
    }

    public final int G() {
        return k();
    }

    public final boolean H(C2517h hVar) {
        m.e(hVar, "prefix");
        return x(0, hVar, 0, hVar.G());
    }

    public C2517h I(int i4, int i5) {
        int d5 = C2511b.d(this, i5);
        if (i4 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (d5 > i().length) {
            throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
        } else if (d5 - i4 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        } else if (i4 == 0 && d5 == i().length) {
            return this;
        } else {
            return new C2517h(C1594h.h(i(), i4, d5));
        }
    }

    public C2517h K() {
        int i4 = 0;
        while (i4 < i().length) {
            byte b5 = i()[i4];
            if (b5 < 65 || b5 > 90) {
                i4++;
            } else {
                byte[] i5 = i();
                byte[] copyOf = Arrays.copyOf(i5, i5.length);
                m.d(copyOf, "copyOf(this, size)");
                copyOf[i4] = (byte) (b5 + 32);
                for (int i6 = i4 + 1; i6 < copyOf.length; i6++) {
                    byte b6 = copyOf[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        copyOf[i6] = (byte) (b6 + 32);
                    }
                }
                return new C2517h(copyOf);
            }
        }
        return this;
    }

    public byte[] L() {
        byte[] i4 = i();
        byte[] copyOf = Arrays.copyOf(i4, i4.length);
        m.d(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public String M() {
        String l4 = l();
        if (l4 != null) {
            return l4;
        }
        String c5 = c0.c(q());
        E(c5);
        return c5;
    }

    public void N(C2514e eVar, int i4, int i5) {
        m.e(eVar, "buffer");
        C2536b.d(this, eVar, i4, i5);
    }

    public String a() {
        return C2510a.c(i(), (byte[]) null, 1, (Object) null);
    }

    /* renamed from: b */
    public int compareTo(C2517h hVar) {
        m.e(hVar, "other");
        int G4 = G();
        int G5 = hVar.G();
        int min = Math.min(G4, G5);
        int i4 = 0;
        while (i4 < min) {
            byte h4 = h(i4) & 255;
            byte h5 = hVar.h(i4) & 255;
            if (h4 == h5) {
                i4++;
            } else if (h4 < h5) {
                return -1;
            } else {
                return 1;
            }
        }
        if (G4 == G5) {
            return 0;
        }
        if (G4 < G5) {
            return -1;
        }
        return 1;
    }

    public C2517h e(String str) {
        m.e(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.f23706a, 0, G());
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
            if (hVar.G() != i().length || !hVar.y(0, i(), 0, i().length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean g(C2517h hVar) {
        m.e(hVar, "suffix");
        return x(G() - hVar.G(), hVar, 0, hVar.G());
    }

    public final byte h(int i4) {
        return r(i4);
    }

    public int hashCode() {
        int j4 = j();
        if (j4 != 0) {
            return j4;
        }
        int hashCode = Arrays.hashCode(i());
        z(hashCode);
        return hashCode;
    }

    public final byte[] i() {
        return this.f23706a;
    }

    public final int j() {
        return this.f23707b;
    }

    public int k() {
        return i().length;
    }

    public final String l() {
        return this.f23708c;
    }

    public String m() {
        char[] cArr = new char[(i().length * 2)];
        int i4 = 0;
        for (byte b5 : i()) {
            int i5 = i4 + 1;
            cArr[i4] = C2536b.f()[(b5 >> 4) & 15];
            i4 += 2;
            cArr[i5] = C2536b.f()[b5 & 15];
        }
        return m3.m.k(cArr);
    }

    public final int n(C2517h hVar, int i4) {
        m.e(hVar, "other");
        return o(hVar.q(), i4);
    }

    public int o(byte[] bArr, int i4) {
        m.e(bArr, "other");
        int length = i().length - bArr.length;
        int max = Math.max(i4, 0);
        if (max > length) {
            return -1;
        }
        while (!C2511b.a(i(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public byte[] q() {
        return i();
    }

    public byte r(int i4) {
        return i()[i4];
    }

    public final int s(C2517h hVar, int i4) {
        m.e(hVar, "other");
        return t(hVar.q(), i4);
    }

    public int t(byte[] bArr, int i4) {
        m.e(bArr, "other");
        for (int min = Math.min(C2511b.d(this, i4), i().length - bArr.length); -1 < min; min--) {
            if (C2511b.a(i(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public String toString() {
        C2517h hVar;
        if (i().length == 0) {
            return "[size=0]";
        }
        int a5 = C2536b.c(i(), 64);
        if (a5 != -1) {
            String M4 = M();
            String substring = M4.substring(0, a5);
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String w4 = m3.m.w(m3.m.w(m3.m.w(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (a5 < M4.length()) {
                return "[size=" + i().length + " text=" + w4 + "…]";
            }
            return "[text=" + w4 + ']';
        } else if (i().length <= 64) {
            return "[hex=" + m() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(i().length);
            sb.append(" hex=");
            int d5 = C2511b.d(this, 64);
            if (d5 > i().length) {
                throw new IllegalArgumentException(("endIndex > length(" + i().length + ')').toString());
            } else if (d5 >= 0) {
                if (d5 == i().length) {
                    hVar = this;
                } else {
                    hVar = new C2517h(C1594h.h(i(), 0, d5));
                }
                sb.append(hVar.m());
                sb.append("…]");
                return sb.toString();
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
        }
    }

    public final C2517h v() {
        return e(SameMD5.TAG);
    }

    public boolean x(int i4, C2517h hVar, int i5, int i6) {
        m.e(hVar, "other");
        return hVar.y(i5, i(), i4, i6);
    }

    public boolean y(int i4, byte[] bArr, int i5, int i6) {
        m.e(bArr, "other");
        if (i4 < 0 || i4 > i().length - i6 || i5 < 0 || i5 > bArr.length - i6 || !C2511b.a(i(), i4, bArr, i5, i6)) {
            return false;
        }
        return true;
    }

    public final void z(int i4) {
        this.f23707b = i4;
    }
}
