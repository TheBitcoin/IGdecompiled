package m3;

import R2.l;
import S2.C1594h;
import S2.C1601o;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import d3.p;
import j3.d;
import j3.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import l3.h;

abstract class w extends v {

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char[] f21204a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f21205b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z4) {
            super(2);
            this.f21204a = cArr;
            this.f21205b = z4;
        }

        public final l a(CharSequence charSequence, int i4) {
            m.e(charSequence, "$this$$receiver");
            int M4 = w.M(charSequence, this.f21204a, i4, this.f21205b);
            if (M4 < 0) {
                return null;
            }
            return R2.p.a(Integer.valueOf(M4), 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f21206a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f21207b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list, boolean z4) {
            super(2);
            this.f21206a = list;
            this.f21207b = z4;
        }

        public final l a(CharSequence charSequence, int i4) {
            m.e(charSequence, "$this$$receiver");
            l z4 = w.E(charSequence, this.f21206a, i4, this.f21207b, false);
            if (z4 != null) {
                return R2.p.a(z4.c(), Integer.valueOf(((String) z4.d()).length()));
            }
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class c extends n implements d3.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f21208a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f21208a = charSequence;
        }

        /* renamed from: a */
        public final String invoke(d dVar) {
            m.e(dVar, "it");
            return w.m0(this.f21208a, dVar);
        }
    }

    public static final boolean A(CharSequence charSequence, char c5, boolean z4) {
        m.e(charSequence, "<this>");
        if (K(charSequence, c5, 0, z4, 2, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean B(CharSequence charSequence, CharSequence charSequence2, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (L(charSequence, (String) charSequence2, 0, z4, 2, (Object) null) >= 0) {
                return true;
            }
            return false;
        }
        CharSequence charSequence3 = charSequence;
        if (J(charSequence3, charSequence2, 0, charSequence3.length(), z4, false, 16, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, char c5, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return A(charSequence, c5, z4);
    }

    public static /* synthetic */ boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return B(charSequence, charSequence2, z4);
    }

    /* access modifiers changed from: private */
    public static final l E(CharSequence charSequence, Collection collection, int i4, boolean z4, boolean z5) {
        j3.b bVar;
        CharSequence charSequence2;
        Object obj;
        boolean z6;
        Object obj2;
        int i5;
        if (z4 || collection.size() != 1) {
            CharSequence charSequence3 = charSequence;
            int i6 = i4;
            if (!z5) {
                bVar = new d(e.a(i6, 0), charSequence3.length());
            } else {
                bVar = e.h(e.c(i6, F(charSequence3)), 0);
            }
            if (charSequence3 instanceof String) {
                int c5 = bVar.c();
                int h4 = bVar.h();
                int j4 = bVar.j();
                if ((j4 > 0 && c5 <= h4) || (j4 < 0 && h4 <= c5)) {
                    int i7 = c5;
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z6 = z4;
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            z6 = z4;
                            if (v.r(str, 0, (String) charSequence3, i7, str.length(), z6)) {
                                break;
                            }
                            z4 = z6;
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (i7 == h4) {
                                break;
                            }
                            i7 += j4;
                            z4 = z6;
                        } else {
                            return R2.p.a(Integer.valueOf(i7), str2);
                        }
                    }
                }
            } else {
                boolean z7 = z4;
                int c6 = bVar.c();
                int h5 = bVar.h();
                int j5 = bVar.j();
                if ((j5 > 0 && c6 <= h5) || (j5 < 0 && h5 <= c6)) {
                    int i8 = c6;
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                charSequence2 = charSequence3;
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            boolean z8 = z7;
                            charSequence2 = charSequence3;
                            z7 = z8;
                            if (d0(str3, 0, charSequence2, i8, str3.length(), z8)) {
                                break;
                            }
                            charSequence3 = charSequence2;
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (i8 == h5) {
                                break;
                            }
                            i8 += j5;
                            charSequence3 = charSequence2;
                        } else {
                            return R2.p.a(Integer.valueOf(i8), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) C1601o.T(collection);
        if (!z5) {
            i5 = L(charSequence, str5, i4, false, 4, (Object) null);
        } else {
            i5 = R(charSequence, str5, i4, false, 4, (Object) null);
        }
        if (i5 < 0) {
            return null;
        }
        return R2.p.a(Integer.valueOf(i5), str5);
    }

    public static int F(CharSequence charSequence) {
        m.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int G(CharSequence charSequence, char c5, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c5, i4);
        }
        return M(charSequence, new char[]{c5}, i4, z4);
    }

    public static final int H(CharSequence charSequence, String str, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(str, TypedValues.Custom.S_STRING);
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i4);
        }
        return J(charSequence, str, i4, charSequence.length(), z4, false, 16, (Object) null);
    }

    private static final int I(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5) {
        j3.b bVar;
        if (!z5) {
            bVar = new d(e.a(i4, 0), e.c(i5, charSequence.length()));
        } else {
            bVar = e.h(e.c(i4, F(charSequence)), e.a(i5, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            boolean z6 = z4;
            int c5 = bVar.c();
            int h4 = bVar.h();
            int j4 = bVar.j();
            if ((j4 <= 0 || c5 > h4) && (j4 >= 0 || h4 > c5)) {
                return -1;
            }
            int i6 = c5;
            while (true) {
                boolean z7 = z6;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z6 = z7;
                if (d0(charSequence4, 0, charSequence3, i6, charSequence2.length(), z7)) {
                    return i6;
                }
                if (i6 == h4) {
                    return -1;
                }
                i6 += j4;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        } else {
            int c6 = bVar.c();
            int h5 = bVar.h();
            int j5 = bVar.j();
            if ((j5 <= 0 || c6 > h5) && (j5 >= 0 || h5 > c6)) {
                return -1;
            }
            int i7 = c6;
            while (true) {
                boolean z8 = z4;
                if (v.r((String) charSequence2, 0, (String) charSequence, i7, charSequence2.length(), z8)) {
                    return i7;
                }
                if (i7 == h5) {
                    return -1;
                }
                i7 += j5;
                z4 = z8;
            }
        }
    }

    static /* synthetic */ int J(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5, int i6, Object obj) {
        boolean z6;
        if ((i6 & 16) != 0) {
            z6 = false;
        } else {
            z6 = z5;
        }
        return I(charSequence, charSequence2, i4, i5, z4, z6);
    }

    public static /* synthetic */ int K(CharSequence charSequence, char c5, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return G(charSequence, c5, i4, z4);
    }

    public static /* synthetic */ int L(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return H(charSequence, str, i4, z4);
    }

    public static final int M(CharSequence charSequence, char[] cArr, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            int a5 = e.a(i4, 0);
            int F4 = F(charSequence);
            if (a5 > F4) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(a5);
                for (char f4 : cArr) {
                    if (c.f(f4, charAt, z4)) {
                        return a5;
                    }
                }
                if (a5 == F4) {
                    return -1;
                }
                a5++;
            }
        } else {
            return ((String) charSequence).indexOf(C1594h.D(cArr), i4);
        }
    }

    public static boolean N(CharSequence charSequence) {
        m.e(charSequence, "<this>");
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (!b.c(charSequence.charAt(i4))) {
                return false;
            }
        }
        return true;
    }

    public static final int O(CharSequence charSequence, char c5, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c5, i4);
        }
        return S(charSequence, new char[]{c5}, i4, z4);
    }

    public static final int P(CharSequence charSequence, String str, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(str, TypedValues.Custom.S_STRING);
        if (z4 || !(charSequence instanceof String)) {
            return I(charSequence, str, i4, 0, z4, true);
        }
        return ((String) charSequence).lastIndexOf(str, i4);
    }

    public static /* synthetic */ int Q(CharSequence charSequence, char c5, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = F(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return O(charSequence, c5, i4, z4);
    }

    public static /* synthetic */ int R(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = F(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return P(charSequence, str, i4, z4);
    }

    public static final int S(CharSequence charSequence, char[] cArr, int i4, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(cArr, "chars");
        if (z4 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int c5 = e.c(i4, F(charSequence)); -1 < c5; c5--) {
                char charAt = charSequence.charAt(c5);
                for (char f4 : cArr) {
                    if (c.f(f4, charAt, z4)) {
                        return c5;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(C1594h.D(cArr), i4);
    }

    public static final l3.e T(CharSequence charSequence) {
        m.e(charSequence, "<this>");
        return l0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List U(CharSequence charSequence) {
        m.e(charSequence, "<this>");
        return h.o(T(charSequence));
    }

    public static final CharSequence V(CharSequence charSequence, int i4, char c5) {
        m.e(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
        } else if (i4 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i4);
            sb.append(charSequence);
            int length = i4 - charSequence.length();
            int i5 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c5);
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                }
            }
            return sb;
        }
    }

    public static String W(String str, int i4, char c5) {
        m.e(str, "<this>");
        return V(str, i4, c5).toString();
    }

    public static final CharSequence X(CharSequence charSequence, int i4, char c5) {
        m.e(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
        } else if (i4 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i4);
            int length = i4 - charSequence.length();
            int i5 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c5);
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static String Y(String str, int i4, char c5) {
        m.e(str, "<this>");
        return X(str, i4, c5).toString();
    }

    private static final l3.e Z(CharSequence charSequence, char[] cArr, int i4, boolean z4, int i5) {
        e0(i5);
        return new e(charSequence, i4, i5, new a(cArr, z4));
    }

    private static final l3.e a0(CharSequence charSequence, String[] strArr, int i4, boolean z4, int i5) {
        e0(i5);
        return new e(charSequence, i4, i5, new b(C1594h.c(strArr), z4));
    }

    static /* synthetic */ l3.e b0(CharSequence charSequence, char[] cArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return Z(charSequence, cArr, i4, z4, i5);
    }

    static /* synthetic */ l3.e c0(CharSequence charSequence, String[] strArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return a0(charSequence, strArr, i4, z4, i5);
    }

    public static final boolean d0(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6, boolean z4) {
        m.e(charSequence, "<this>");
        m.e(charSequence2, "other");
        if (i5 < 0 || i4 < 0 || i4 > charSequence.length() - i6 || i5 > charSequence2.length() - i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!c.f(charSequence.charAt(i4 + i7), charSequence2.charAt(i5 + i7), z4)) {
                return false;
            }
        }
        return true;
    }

    public static final void e0(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i4).toString());
        }
    }

    public static final List f0(CharSequence charSequence, char[] cArr, boolean z4, int i4) {
        m.e(charSequence, "<this>");
        m.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return h0(charSequence, String.valueOf(cArr[0]), z4, i4);
        }
        CharSequence charSequence2 = charSequence;
        Iterable<d> g4 = h.g(b0(charSequence2, cArr, 0, z4, i4, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C1601o.p(g4, 10));
        for (d m02 : g4) {
            arrayList.add(m0(charSequence2, m02));
        }
        return arrayList;
    }

    public static final List g0(CharSequence charSequence, String[] strArr, boolean z4, int i4) {
        m.e(charSequence, "<this>");
        m.e(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return h0(charSequence, str, z4, i4);
            }
        }
        CharSequence charSequence2 = charSequence;
        Iterable<d> g4 = h.g(c0(charSequence2, strArr, 0, z4, i4, 2, (Object) null));
        ArrayList arrayList = new ArrayList(C1601o.p(g4, 10));
        for (d m02 : g4) {
            arrayList.add(m0(charSequence2, m02));
        }
        return arrayList;
    }

    private static final List h0(CharSequence charSequence, String str, boolean z4, int i4) {
        boolean z5;
        e0(i4);
        int i5 = 0;
        int H4 = H(charSequence, str, 0, z4);
        if (H4 == -1 || i4 == 1) {
            return C1601o.e(charSequence.toString());
        }
        if (i4 > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i6 = 10;
        if (z5) {
            i6 = e.c(i4, 10);
        }
        ArrayList arrayList = new ArrayList(i6);
        do {
            arrayList.add(charSequence.subSequence(i5, H4).toString());
            i5 = str.length() + H4;
            if ((z5 && arrayList.size() == i4 - 1) || (H4 = H(charSequence, str, i5, z4)) == -1) {
                arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i5, H4).toString());
            i5 = str.length() + H4;
            break;
        } while ((H4 = H(charSequence, str, i5, z4)) == -1);
        arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List i0(CharSequence charSequence, char[] cArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return f0(charSequence, cArr, z4, i4);
    }

    public static /* synthetic */ List j0(CharSequence charSequence, String[] strArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return g0(charSequence, strArr, z4, i4);
    }

    public static final l3.e k0(CharSequence charSequence, String[] strArr, boolean z4, int i4) {
        m.e(charSequence, "<this>");
        m.e(strArr, "delimiters");
        CharSequence charSequence2 = charSequence;
        return h.m(c0(charSequence2, strArr, 0, z4, i4, 2, (Object) null), new c(charSequence2));
    }

    public static /* synthetic */ l3.e l0(CharSequence charSequence, String[] strArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return k0(charSequence, strArr, z4, i4);
    }

    public static final String m0(CharSequence charSequence, d dVar) {
        m.e(charSequence, "<this>");
        m.e(dVar, "range");
        return charSequence.subSequence(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1).toString();
    }

    public static final String n0(String str, d dVar) {
        m.e(str, "<this>");
        m.e(dVar, "range");
        String substring = str.substring(dVar.getStart().intValue(), dVar.getEndInclusive().intValue() + 1);
        m.d(substring, "substring(...)");
        return substring;
    }

    public static final String o0(String str, char c5, String str2) {
        m.e(str, "<this>");
        m.e(str2, "missingDelimiterValue");
        String str3 = str;
        int K4 = K(str3, c5, 0, false, 6, (Object) null);
        if (K4 == -1) {
            return str2;
        }
        String substring = str3.substring(K4 + 1, str3.length());
        m.d(substring, "substring(...)");
        return substring;
    }

    public static final String p0(String str, String str2, String str3) {
        m.e(str, "<this>");
        m.e(str2, "delimiter");
        m.e(str3, "missingDelimiterValue");
        String str4 = str;
        String str5 = str2;
        int L4 = L(str4, str5, 0, false, 6, (Object) null);
        if (L4 == -1) {
            return str3;
        }
        String substring = str4.substring(L4 + str5.length(), str4.length());
        m.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String q0(String str, char c5, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return o0(str, c5, str2);
    }

    public static /* synthetic */ String r0(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        return p0(str, str2, str3);
    }

    public static String s0(String str, char c5, String str2) {
        m.e(str, "<this>");
        m.e(str2, "missingDelimiterValue");
        String str3 = str;
        int Q4 = Q(str3, c5, 0, false, 6, (Object) null);
        if (Q4 == -1) {
            return str2;
        }
        String substring = str3.substring(Q4 + 1, str3.length());
        m.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String t0(String str, char c5, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return s0(str, c5, str2);
    }

    public static CharSequence u0(CharSequence charSequence) {
        int i4;
        m.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z4 = false;
        while (i5 <= length) {
            if (!z4) {
                i4 = i5;
            } else {
                i4 = length;
            }
            boolean c5 = b.c(charSequence.charAt(i4));
            if (!z4) {
                if (!c5) {
                    z4 = true;
                } else {
                    i5++;
                }
            } else if (!c5) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }
}
