package P2;

import A2.a;
import E2.t;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f7989a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7990b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7991c;

    public b(String str, String str2, String str3) {
        m.e(str, "country");
        m.e(str2, TtmlNode.TAG_REGION);
        m.e(str3, "city");
        this.f7989a = str;
        this.f7990b = str2;
        this.f7991c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (m.a(this.f7989a, bVar.f7989a) && m.a(this.f7990b, bVar.f7990b) && m.a(this.f7991c, bVar.f7991c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7991c.hashCode() + t.a(this.f7990b, this.f7989a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("GeoIP(country=");
        a5.append(this.f7989a);
        a5.append(", region=");
        a5.append(this.f7990b);
        a5.append(", city=");
        a5.append(this.f7991c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            r2 = r5 & 1
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x0009
            r2 = r3
            goto L_0x000a
        L_0x0009:
            r2 = r4
        L_0x000a:
            r0 = r5 & 2
            if (r0 == 0) goto L_0x0010
            r0 = r3
            goto L_0x0011
        L_0x0010:
            r0 = r4
        L_0x0011:
            r5 = r5 & 4
            if (r5 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r1.<init>(r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P2.b.<init>(java.lang.String, java.lang.String, java.lang.String, int):void");
    }
}
