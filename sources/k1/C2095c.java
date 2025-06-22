package k1;

import j$.time.ZonedDateTime;
import l1.C2111f;

/* renamed from: k1.c  reason: case insensitive filesystem */
public class C2095c extends C2093a {
    public C2095c(ZonedDateTime zonedDateTime) {
        d(zonedDateTime);
    }

    public void a(String str) {
        this.f20929a = C2111f.a(str);
    }

    public String b() {
        return C2111f.b((ZonedDateTime) this.f20929a);
    }

    public String e(String str, int i4) {
        return str.substring(i4, i4 + 36);
    }
}
