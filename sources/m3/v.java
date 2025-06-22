package m3;

import S2.C1588b;
import j3.e;
import kotlin.jvm.internal.m;

abstract class v extends u {
    public static int j(String str, String str2, boolean z4) {
        m.e(str, "<this>");
        m.e(str2, "other");
        if (z4) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    public static String k(char[] cArr) {
        m.e(cArr, "<this>");
        return new String(cArr);
    }

    public static String l(char[] cArr, int i4, int i5) {
        m.e(cArr, "<this>");
        C1588b.f8237a.a(i4, i5, cArr.length);
        return new String(cArr, i4, i5 - i4);
    }

    public static byte[] m(String str) {
        m.e(str, "<this>");
        byte[] bytes = str.getBytes(d.f21160b);
        m.d(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean n(String str, String str2, boolean z4) {
        m.e(str, "<this>");
        m.e(str2, "suffix");
        if (!z4) {
            return str.endsWith(str2);
        }
        return r(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return n(str, str2, z4);
    }

    public static boolean p(String str, String str2, boolean z4) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z4) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean q(String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return p(str, str2, z4);
    }

    public static final boolean r(String str, int i4, String str2, int i5, int i6, boolean z4) {
        m.e(str, "<this>");
        m.e(str2, "other");
        if (!z4) {
            return str.regionMatches(i4, str2, i5, i6);
        }
        return str.regionMatches(z4, i4, str2, i5, i6);
    }

    public static String s(CharSequence charSequence, int i4) {
        m.e(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i4 + '.').toString());
        } else if (i4 == 0) {
            return "";
        } else {
            int i5 = 1;
            if (i4 == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(charSequence.length() * i4);
                if (1 <= i4) {
                    while (true) {
                        sb.append(charSequence);
                        if (i5 == i4) {
                            break;
                        }
                        i5++;
                    }
                }
                String sb2 = sb.toString();
                m.b(sb2);
                return sb2;
            }
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                cArr[i6] = charAt;
            }
            return new String(cArr);
        }
    }

    public static final String t(String str, char c5, char c6, boolean z4) {
        m.e(str, "<this>");
        if (!z4) {
            String replace = str.replace(c5, c6);
            m.d(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (c.f(charAt, c5, z4)) {
                charAt = c6;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }

    public static String u(String str, String str2, String str3, boolean z4) {
        m.e(str, "<this>");
        m.e(str2, "oldValue");
        m.e(str3, "newValue");
        int i4 = 0;
        int H4 = w.H(str, str2, 0, z4);
        if (H4 < 0) {
            return str;
        }
        int length = str2.length();
        int a5 = e.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i4, H4);
                sb.append(str3);
                i4 = H4 + length;
                if (H4 >= str.length() || (H4 = w.H(str, str2, H4 + a5, z4)) <= 0) {
                    sb.append(str, i4, str.length());
                    String sb2 = sb.toString();
                    m.d(sb2, "toString(...)");
                }
                sb.append(str, i4, H4);
                sb.append(str3);
                i4 = H4 + length;
                break;
            } while ((H4 = w.H(str, str2, H4 + a5, z4)) <= 0);
            sb.append(str, i4, str.length());
            String sb22 = sb.toString();
            m.d(sb22, "toString(...)");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String v(String str, char c5, char c6, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return t(str, c5, c6, z4);
    }

    public static /* synthetic */ String w(String str, String str2, String str3, boolean z4, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        return u(str, str2, str3, z4);
    }

    public static boolean x(String str, String str2, boolean z4) {
        m.e(str, "<this>");
        m.e(str2, "prefix");
        if (!z4) {
            return str.startsWith(str2);
        }
        return r(str, 0, str2, 0, str2.length(), z4);
    }

    public static /* synthetic */ boolean y(String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return x(str, str2, z4);
    }
}
