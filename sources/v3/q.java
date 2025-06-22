package V3;

import A2.a;
import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f24224a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24225b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24226c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24227d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24228e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24229f;

    public q(String str, String str2, String str3, String str4, String str5, String str6) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(str2, "legalDescriptionTextLabel");
        m.e(str3, "agreeToAllButton");
        m.e(str4, "searchBarHint");
        m.e(str5, "closeLabel");
        m.e(str6, "backLabel");
        this.f24224a = str;
        this.f24225b = str2;
        this.f24226c = str3;
        this.f24227d = str4;
        this.f24228e = str5;
        this.f24229f = str6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (m.a(this.f24224a, qVar.f24224a) && m.a(this.f24225b, qVar.f24225b) && m.a(this.f24226c, qVar.f24226c) && m.a(this.f24227d, qVar.f24227d) && m.a(this.f24228e, qVar.f24228e) && m.a(this.f24229f, qVar.f24229f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24229f.hashCode() + t.a(this.f24228e, t.a(this.f24227d, t.a(this.f24226c, t.a(this.f24225b, this.f24224a.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("StacksScreen(title=");
        a5.append(this.f24224a);
        a5.append(", legalDescriptionTextLabel=");
        a5.append(this.f24225b);
        a5.append(", agreeToAllButton=");
        a5.append(this.f24226c);
        a5.append(", searchBarHint=");
        a5.append(this.f24227d);
        a5.append(", closeLabel=");
        a5.append(this.f24228e);
        a5.append(", backLabel=");
        a5.append(this.f24229f);
        a5.append(')');
        return a5.toString();
    }
}
