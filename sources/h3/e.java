package H3;

import D3.C2463k;
import D3.C2464l;
import D3.C2469q;
import D3.C2470r;
import D3.x;
import D3.z;
import E3.c;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f23377a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(C2469q qVar) {
        return j(qVar.a("Content-Length"));
    }

    public static long b(z zVar) {
        return a(zVar.o());
    }

    public static boolean c(z zVar) {
        if (zVar.A().g().equals("HEAD")) {
            return false;
        }
        int i4 = zVar.i();
        if (((i4 >= 100 && i4 < 200) || i4 == 204 || i4 == 304) && b(zVar) == -1 && !"chunked".equalsIgnoreCase(zVar.l("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static boolean d(C2469q qVar) {
        return k(qVar).contains("*");
    }

    public static boolean e(z zVar) {
        return d(zVar.o());
    }

    public static int f(String str, int i4) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i4;
        }
    }

    public static void g(C2464l lVar, C2470r rVar, C2469q qVar) {
        if (lVar != C2464l.f23091a) {
            List f4 = C2463k.f(rVar, qVar);
            if (!f4.isEmpty()) {
                lVar.a(rVar, f4);
            }
        }
    }

    public static int h(String str, int i4, String str2) {
        while (i4 < str.length() && str2.indexOf(str.charAt(i4)) == -1) {
            i4++;
        }
        return i4;
    }

    public static int i(String str, int i4) {
        while (i4 < str.length() && ((r0 = str.charAt(i4)) == ' ' || r0 == 9)) {
            i4++;
        }
        return i4;
    }

    private static long j(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static Set k(C2469q qVar) {
        Set set = Collections.EMPTY_SET;
        int e5 = qVar.e();
        for (int i4 = 0; i4 < e5; i4++) {
            if ("Vary".equalsIgnoreCase(qVar.c(i4))) {
                String f4 = qVar.f(i4);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : f4.split(",")) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    private static Set l(z zVar) {
        return k(zVar.o());
    }

    public static C2469q m(C2469q qVar, C2469q qVar2) {
        Set k4 = k(qVar2);
        if (k4.isEmpty()) {
            return new C2469q.a().d();
        }
        C2469q.a aVar = new C2469q.a();
        int e5 = qVar.e();
        for (int i4 = 0; i4 < e5; i4++) {
            String c5 = qVar.c(i4);
            if (k4.contains(c5)) {
                aVar.a(c5, qVar.f(i4));
            }
        }
        return aVar.d();
    }

    public static C2469q n(z zVar) {
        return m(zVar.u().A().d(), zVar.o());
    }

    public static boolean o(z zVar, C2469q qVar, x xVar) {
        for (String str : l(zVar)) {
            if (!c.n(qVar.g(str), xVar.e(str))) {
                return false;
            }
        }
        return true;
    }
}
