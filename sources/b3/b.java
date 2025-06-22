package B3;

import S2.C1601o;
import kotlin.jvm.internal.m;
import n1.C2162e;
import o1.C2182j;

public final class b extends e {
    public String b(A3.b bVar) {
        m.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C2162e.f21279b;
                m.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C2162e.f21280c;
                m.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 3:
                String str3 = C2162e.f21281d;
                m.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str3;
            case 6:
                String str4 = C2162e.f21282e;
                m.d(str4, "SALE_OPT_OUT");
                return str4;
            case 8:
                String str5 = C2162e.f21283f;
                m.d(str5, "TARGETED_ADVERTISING_OPT_OUT");
                return str5;
            case 9:
                String str6 = C2162e.f21284g;
                m.d(str6, "SENSITIVE_DATA_PROCESSING");
                return str6;
            case 10:
                String str7 = C2162e.f21285h;
                m.d(str7, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str7;
            case 12:
                String str8 = C2162e.f21286i;
                m.d(str8, "MSPA_COVERED_TRANSACTION");
                return str8;
            case 13:
                String str9 = C2162e.f21287j;
                m.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                return str9;
            case 14:
                String str10 = C2162e.f21288k;
                m.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                return str10;
            default:
                return "";
        }
    }

    public void d(A3.b bVar, boolean z4) {
        int i4;
        m.e(bVar, "field");
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(bVar, Integer.valueOf(i4));
        this.f94d.setKnownChildSensitiveDataConsents(C1601o.e(Integer.valueOf(i4)));
    }

    public String g() {
        String str = C2182j.f21405f;
        m.d(str, "NAME");
        return str;
    }

    public int i() {
        return C2182j.f21403d;
    }

    public void f(boolean z4) {
    }

    public void h(boolean z4) {
    }

    public void k(boolean z4) {
    }
}
