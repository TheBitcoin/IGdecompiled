package V3;

import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.m;

/* renamed from: V3.h  reason: case insensitive filesystem */
public final class C2597h {

    /* renamed from: a  reason: collision with root package name */
    public final String f24143a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24144b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24145c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24146d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24147e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24148f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24149g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24150h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24151i;

    /* renamed from: j  reason: collision with root package name */
    public final String f24152j;

    /* renamed from: k  reason: collision with root package name */
    public final String f24153k;

    public C2597h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(str2, TtmlNode.TAG_BODY);
        m.e(str3, "objected");
        m.e(str4, "accept");
        m.e(str5, "objectAllButton");
        m.e(str6, "searchBarHint");
        m.e(str7, "purposesLabel");
        m.e(str8, "partnersLabel");
        m.e(str9, "showAllVendorsMenu");
        m.e(str10, "showIABVendorsMenu");
        m.e(str11, "backLabel");
        this.f24143a = str;
        this.f24144b = str2;
        this.f24145c = str3;
        this.f24146d = str4;
        this.f24147e = str5;
        this.f24148f = str6;
        this.f24149g = str7;
        this.f24150h = str8;
        this.f24151i = str9;
        this.f24152j = str10;
        this.f24153k = str11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2597h)) {
            return false;
        }
        C2597h hVar = (C2597h) obj;
        if (m.a(this.f24143a, hVar.f24143a) && m.a(this.f24144b, hVar.f24144b) && m.a(this.f24145c, hVar.f24145c) && m.a(this.f24146d, hVar.f24146d) && m.a(this.f24147e, hVar.f24147e) && m.a(this.f24148f, hVar.f24148f) && m.a(this.f24149g, hVar.f24149g) && m.a(this.f24150h, hVar.f24150h) && m.a(this.f24151i, hVar.f24151i) && m.a(this.f24152j, hVar.f24152j) && m.a(this.f24153k, hVar.f24153k)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24153k.hashCode() + t.a(this.f24152j, t.a(this.f24151i, t.a(this.f24150h, t.a(this.f24149g, t.a(this.f24148f, t.a(this.f24147e, t.a(this.f24146d, t.a(this.f24145c, t.a(this.f24144b, this.f24143a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "LegInterestScreen(title=" + this.f24143a + ", body=" + this.f24144b + ", objected=" + this.f24145c + ", accept=" + this.f24146d + ", objectAllButton=" + this.f24147e + ", searchBarHint=" + this.f24148f + ", purposesLabel=" + this.f24149g + ", partnersLabel=" + this.f24150h + ", showAllVendorsMenu=" + this.f24151i + ", showIABVendorsMenu=" + this.f24152j + ", backLabel=" + this.f24153k + ')';
    }
}
