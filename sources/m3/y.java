package m3;

import S2.S;
import d3.l;
import j3.d;
import j3.e;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

abstract class y extends x {

    static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21209a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(CharSequence charSequence) {
            m.e(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final List A0(CharSequence charSequence, int i4, int i5, boolean z4, l lVar) {
        int i6;
        m.e(charSequence, "<this>");
        m.e(lVar, "transform");
        S.a(i4, i5);
        int length = charSequence.length();
        int i7 = length / i5;
        int i8 = 0;
        if (length % i5 == 0) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        ArrayList arrayList = new ArrayList(i7 + i6);
        while (i8 >= 0 && i8 < length) {
            int i9 = i8 + i4;
            if (i9 < 0 || i9 > length) {
                if (!z4) {
                    break;
                }
                i9 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i8, i9)));
            i8 += i5;
        }
        return arrayList;
    }

    public static List v0(CharSequence charSequence, int i4) {
        m.e(charSequence, "<this>");
        return z0(charSequence, i4, i4, true);
    }

    public static final String w0(String str, int i4) {
        m.e(str, "<this>");
        if (i4 >= 0) {
            String substring = str.substring(e.c(i4, str.length()));
            m.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }

    public static char x0(CharSequence charSequence) {
        m.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(w.F(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String y0(String str, d dVar) {
        m.e(str, "<this>");
        m.e(dVar, "indices");
        if (dVar.isEmpty()) {
            return "";
        }
        return w.n0(str, dVar);
    }

    public static final List z0(CharSequence charSequence, int i4, int i5, boolean z4) {
        m.e(charSequence, "<this>");
        return A0(charSequence, i4, i5, z4, a.f21209a);
    }
}
