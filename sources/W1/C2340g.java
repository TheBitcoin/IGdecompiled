package w1;

import android.text.TextUtils;
import p1.C2201a;
import q1.f;
import q1.i;
import q1.k;
import q1.n;

/* renamed from: w1.g  reason: case insensitive filesystem */
public abstract class C2340g {
    public static void a() {
        if (!C2201a.b()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(String str, int i4, String str2) {
        if (str.length() > i4) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void e(k kVar, f fVar, i iVar) {
        if (kVar == k.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (fVar == f.DEFINED_BY_JAVASCRIPT && kVar == k.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (iVar == i.DEFINED_BY_JAVASCRIPT && kVar == k.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void f(n nVar) {
        i(nVar);
        g(nVar);
    }

    public static void g(n nVar) {
        if (nVar.r()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void h(n nVar) {
        if (nVar.w()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    private static void i(n nVar) {
        if (!nVar.w()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }

    public static void j(n nVar) {
        if (!nVar.u()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void k(n nVar) {
        if (!nVar.v()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    public static void l(n nVar) {
        if (nVar.t().r() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void m(n nVar) {
        if (nVar.t().s() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }
}
