package m3;

import S2.C1601o;
import d3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

abstract class o extends n {

    static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f21202a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            m.e(str, "line");
            return str;
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21203a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f21203a = str;
        }

        /* renamed from: a */
        public final String invoke(String str) {
            m.e(str, "line");
            return this.f21203a + str;
        }
    }

    private static final l b(String str) {
        if (str.length() == 0) {
            return a.f21202a;
        }
        return new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                i4 = -1;
                break;
            } else if (!b.c(str.charAt(i4))) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 == -1) {
            return str.length();
        }
        return i4;
    }

    public static final String d(String str, String str2) {
        int i4;
        String str3;
        String str4 = str;
        m.e(str4, "<this>");
        String str5 = str2;
        m.e(str5, "newIndent");
        List U4 = w.U(str4);
        ArrayList arrayList = new ArrayList();
        for (Object next : U4) {
            if (!w.N((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1601o.p(arrayList, 10));
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            arrayList2.add(Integer.valueOf(c((String) obj)));
        }
        Integer num = (Integer) C1601o.R(arrayList2);
        if (num != null) {
            i4 = num.intValue();
        } else {
            i4 = 0;
        }
        int length = str4.length() + (str5.length() * U4.size());
        l b5 = b(str5);
        int j4 = C1601o.j(U4);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : U4) {
            int i7 = i5 + 1;
            if (i5 < 0) {
                C1601o.o();
            }
            String str6 = (String) next2;
            if ((i5 == 0 || i5 == j4) && w.N(str6)) {
                str6 = null;
            } else {
                String w02 = y.w0(str6, i4);
                if (!(w02 == null || (str3 = (String) b5.invoke(w02)) == null)) {
                    str6 = str3;
                }
            }
            if (str6 != null) {
                arrayList3.add(str6);
            }
            i5 = i7;
        }
        String sb = ((StringBuilder) C1601o.M(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 124, (Object) null)).toString();
        m.d(sb, "toString(...)");
        return sb;
    }

    public static String e(String str) {
        m.e(str, "<this>");
        return d(str, "");
    }
}
