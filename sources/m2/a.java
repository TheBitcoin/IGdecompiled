package M2;

import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f7737a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7738b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7739c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7740d;

    public a(String str, String str2, String str3, String str4) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(str2, "sectionTitle");
        m.e(str3, "description");
        m.e(str4, "confirm");
        this.f7737a = str;
        this.f7738b = str2;
        this.f7739c = str3;
        this.f7740d = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (m.a(this.f7737a, aVar.f7737a) && m.a(this.f7738b, aVar.f7738b) && m.a(this.f7739c, aVar.f7739c) && m.a(this.f7740d, aVar.f7740d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7740d.hashCode() + t.a(this.f7739c, t.a(this.f7738b, this.f7737a.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("Banner(title=");
        a5.append(this.f7737a);
        a5.append(", sectionTitle=");
        a5.append(this.f7738b);
        a5.append(", description=");
        a5.append(this.f7739c);
        a5.append(", confirm=");
        a5.append(this.f7740d);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r2 = this;
            r4 = r7 & 1
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x0007
            r3 = r6
        L_0x0007:
            r4 = r7 & 2
            r0 = 0
            if (r4 == 0) goto L_0x000e
            r4 = r6
            goto L_0x000f
        L_0x000e:
            r4 = r0
        L_0x000f:
            r1 = r7 & 4
            if (r1 == 0) goto L_0x0014
            r5 = r6
        L_0x0014:
            r7 = r7 & 8
            if (r7 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r6 = r0
        L_0x001a:
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }
}
