package B3;

import A3.b;
import S2.C1601o;
import java.util.List;
import kotlin.jvm.internal.m;
import n1.C2163f;
import o1.C2183k;

public final class c extends e {
    public String b(b bVar) {
        m.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C2163f.f21293b;
                m.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C2163f.f21294c;
                m.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 3:
                String str3 = C2163f.f21295d;
                m.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str3;
            case 6:
                String str4 = C2163f.f21296e;
                m.d(str4, "SALE_OPT_OUT");
                return str4;
            case 8:
                String str5 = C2163f.f21297f;
                m.d(str5, "TARGETED_ADVERTISING_OPT_OUT");
                return str5;
            case 9:
                String str6 = C2163f.f21298g;
                m.d(str6, "SENSITIVE_DATA_PROCESSING");
                return str6;
            case 10:
                String str7 = C2163f.f21299h;
                m.d(str7, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str7;
            case 12:
                String str8 = C2163f.f21300i;
                m.d(str8, "MSPA_COVERED_TRANSACTION");
                return str8;
            case 13:
                String str9 = C2163f.f21301j;
                m.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                return str9;
            case 14:
                String str10 = C2163f.f21302k;
                m.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                return str10;
            default:
                return "";
        }
    }

    public void d(b bVar, boolean z4) {
        List list;
        m.e(bVar, "field");
        if (z4) {
            list = C1601o.k(1, 1, 1);
        } else {
            list = C1601o.k(2, 2, 2);
        }
        c(bVar, list);
        this.f94d.setKnownChildSensitiveDataConsents(list);
    }

    public String g() {
        String str = C2183k.f21409f;
        m.d(str, "NAME");
        return str;
    }

    public int i() {
        return C2183k.f21407d;
    }

    public void f(boolean z4) {
    }

    public void h(boolean z4) {
    }

    public void k(boolean z4) {
    }
}
