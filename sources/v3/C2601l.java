package V3;

import A2.a;
import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

/* renamed from: V3.l  reason: case insensitive filesystem */
public final class C2601l {

    /* renamed from: a  reason: collision with root package name */
    public final String f24200a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24201b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24202c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24203d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24204e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24205f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24206g;

    public C2601l(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(str2, "bodyText");
        m.e(str3, "searchBarHint");
        m.e(str4, "partnersLabel");
        m.e(str5, "showAllVendorsMenu");
        m.e(str6, "showIABVendorsMenu");
        m.e(str7, "backLabel");
        this.f24200a = str;
        this.f24201b = str2;
        this.f24202c = str3;
        this.f24203d = str4;
        this.f24204e = str5;
        this.f24205f = str6;
        this.f24206g = str7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2601l)) {
            return false;
        }
        C2601l lVar = (C2601l) obj;
        if (m.a(this.f24200a, lVar.f24200a) && m.a(this.f24201b, lVar.f24201b) && m.a(this.f24202c, lVar.f24202c) && m.a(this.f24203d, lVar.f24203d) && m.a(this.f24204e, lVar.f24204e) && m.a(this.f24205f, lVar.f24205f) && m.a(this.f24206g, lVar.f24206g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24206g.hashCode() + t.a(this.f24205f, t.a(this.f24204e, t.a(this.f24203d, t.a(this.f24202c, t.a(this.f24201b, this.f24200a.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PartnerScreen(title=");
        a5.append(this.f24200a);
        a5.append(", bodyText=");
        a5.append(this.f24201b);
        a5.append(", searchBarHint=");
        a5.append(this.f24202c);
        a5.append(", partnersLabel=");
        a5.append(this.f24203d);
        a5.append(", showAllVendorsMenu=");
        a5.append(this.f24204e);
        a5.append(", showIABVendorsMenu=");
        a5.append(this.f24205f);
        a5.append(", backLabel=");
        a5.append(this.f24206g);
        a5.append(')');
        return a5.toString();
    }
}
