package V3;

import A2.a;
import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

/* renamed from: V3.g  reason: case insensitive filesystem */
public final class C2596g {

    /* renamed from: a  reason: collision with root package name */
    public final String f24135a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24136b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24137c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24138d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24139e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24140f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24141g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24142h;

    public C2596g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(str2, TtmlNode.TAG_BODY);
        m.e(str3, "settings");
        m.e(str4, "accept");
        m.e(str5, "reject");
        m.e(str6, "consentLink");
        m.e(str7, "privacyPolicyLink");
        m.e(str8, "privacyPolicyLinkText");
        this.f24135a = str;
        this.f24136b = str2;
        this.f24137c = str3;
        this.f24138d = str4;
        this.f24139e = str5;
        this.f24140f = str6;
        this.f24141g = str7;
        this.f24142h = str8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2596g)) {
            return false;
        }
        C2596g gVar = (C2596g) obj;
        if (m.a(this.f24135a, gVar.f24135a) && m.a(this.f24136b, gVar.f24136b) && m.a(this.f24137c, gVar.f24137c) && m.a(this.f24138d, gVar.f24138d) && m.a(this.f24139e, gVar.f24139e) && m.a(this.f24140f, gVar.f24140f) && m.a(this.f24141g, gVar.f24141g) && m.a(this.f24142h, gVar.f24142h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24142h.hashCode() + t.a(this.f24141g, t.a(this.f24140f, t.a(this.f24139e, t.a(this.f24138d, t.a(this.f24137c, t.a(this.f24136b, this.f24135a.hashCode() * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("InitScreen(title=");
        a5.append(this.f24135a);
        a5.append(", body=");
        a5.append(this.f24136b);
        a5.append(", settings=");
        a5.append(this.f24137c);
        a5.append(", accept=");
        a5.append(this.f24138d);
        a5.append(", reject=");
        a5.append(this.f24139e);
        a5.append(", consentLink=");
        a5.append(this.f24140f);
        a5.append(", privacyPolicyLink=");
        a5.append(this.f24141g);
        a5.append(", privacyPolicyLinkText=");
        a5.append(this.f24142h);
        a5.append(')');
        return a5.toString();
    }
}
