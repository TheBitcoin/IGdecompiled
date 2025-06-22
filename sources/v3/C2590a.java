package V3;

import A2.a;
import A3.l;
import E2.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: V3.a  reason: case insensitive filesystem */
public final class C2590a {

    /* renamed from: a  reason: collision with root package name */
    public final String f24055a;

    /* renamed from: b  reason: collision with root package name */
    public final List f24056b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24057c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24058d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24059e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24060f;

    public C2590a(String str, List list, String str2, String str3, String str4, String str5) {
        m.e(str, CampaignEx.JSON_KEY_TITLE);
        m.e(list, TtmlNode.TAG_BODY);
        m.e(str2, "deleteDataLinkText");
        m.e(str3, "accessDataLinkText");
        m.e(str4, "privacyPolicyLinkText");
        m.e(str5, "backLabel");
        this.f24055a = str;
        this.f24056b = list;
        this.f24057c = str2;
        this.f24058d = str3;
        this.f24059e = str4;
        this.f24060f = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2590a)) {
            return false;
        }
        C2590a aVar = (C2590a) obj;
        if (m.a(this.f24055a, aVar.f24055a) && m.a(this.f24056b, aVar.f24056b) && m.a(this.f24057c, aVar.f24057c) && m.a(this.f24058d, aVar.f24058d) && m.a(this.f24059e, aVar.f24059e) && m.a(this.f24060f, aVar.f24060f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24060f.hashCode() + t.a(this.f24059e, t.a(this.f24058d, t.a(this.f24057c, l.a(this.f24056b, this.f24055a.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("CCPAScreen(title=");
        a5.append(this.f24055a);
        a5.append(", body=");
        a5.append(this.f24056b);
        a5.append(", deleteDataLinkText=");
        a5.append(this.f24057c);
        a5.append(", accessDataLinkText=");
        a5.append(this.f24058d);
        a5.append(", privacyPolicyLinkText=");
        a5.append(this.f24059e);
        a5.append(", backLabel=");
        a5.append(this.f24060f);
        a5.append(')');
        return a5.toString();
    }
}
