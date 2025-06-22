package B3;

import A3.b;
import S2.C1601o;
import kotlin.jvm.internal.m;
import n1.C2166i;
import o1.C2185m;

public final class f extends e {
    public String b(b bVar) {
        m.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C2166i.f21338b;
                m.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C2166i.f21339c;
                m.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 3:
                String str3 = C2166i.f21340d;
                m.d(str3, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str3;
            case 6:
                String str4 = C2166i.f21341e;
                m.d(str4, "SALE_OPT_OUT");
                return str4;
            case 8:
                String str5 = C2166i.f21342f;
                m.d(str5, "TARGETED_ADVERTISING_OPT_OUT");
                return str5;
            case 9:
                String str6 = C2166i.f21343g;
                m.d(str6, "SENSITIVE_DATA_PROCESSING");
                return str6;
            case 10:
                String str7 = C2166i.f21344h;
                m.d(str7, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str7;
            case 12:
                String str8 = C2166i.f21345i;
                m.d(str8, "MSPA_COVERED_TRANSACTION");
                return str8;
            case 13:
                String str9 = C2166i.f21346j;
                m.d(str9, "MSPA_OPT_OUT_OPTION_MODE");
                return str9;
            case 14:
                String str10 = C2166i.f21347k;
                m.d(str10, "MSPA_SERVICE_PROVIDER_MODE");
                return str10;
            default:
                return "";
        }
    }

    public void d(b bVar, boolean z4) {
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
        String str = C2185m.f21417f;
        m.d(str, "NAME");
        return str;
    }

    public int i() {
        return C2185m.f21415d;
    }

    public void f(boolean z4) {
    }

    public void h(boolean z4) {
    }

    public void k(boolean z4) {
    }
}
