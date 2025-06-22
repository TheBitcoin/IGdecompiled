package V3;

import A2.a;
import A3.l;
import E2.t;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: V3.n  reason: case insensitive filesystem */
public final class C2603n {

    /* renamed from: a  reason: collision with root package name */
    public final String f24209a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24210b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24211c;

    /* renamed from: d  reason: collision with root package name */
    public final List f24212d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24213e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24214f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24215g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24216h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24217i;

    /* renamed from: j  reason: collision with root package name */
    public final List f24218j;

    public C2603n(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, List list2) {
        m.e(str, "linksTitle");
        m.e(str2, "nonIabVendorsLabel");
        m.e(str3, "uspDnsTitle");
        m.e(list, "uspDnsText");
        m.e(str4, "uspDoNotSellToggleText");
        m.e(str5, "uspPrivacyPolicyLinkText");
        m.e(str6, "uspDeleteDataLinkText");
        m.e(str7, "uspAccessDataLinkText");
        m.e(str8, "uspAcceptButton");
        m.e(list2, "initScreenCustomLinks");
        this.f24209a = str;
        this.f24210b = str2;
        this.f24211c = str3;
        this.f24212d = list;
        this.f24213e = str4;
        this.f24214f = str5;
        this.f24215g = str6;
        this.f24216h = str7;
        this.f24217i = str8;
        this.f24218j = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2603n)) {
            return false;
        }
        C2603n nVar = (C2603n) obj;
        if (m.a(this.f24209a, nVar.f24209a) && m.a(this.f24210b, nVar.f24210b) && m.a(this.f24211c, nVar.f24211c) && m.a(this.f24212d, nVar.f24212d) && m.a(this.f24213e, nVar.f24213e) && m.a(this.f24214f, nVar.f24214f) && m.a(this.f24215g, nVar.f24215g) && m.a(this.f24216h, nVar.f24216h) && m.a(this.f24217i, nVar.f24217i) && m.a(this.f24218j, nVar.f24218j)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24218j.hashCode() + t.a(this.f24217i, t.a(this.f24216h, t.a(this.f24215g, t.a(this.f24214f, t.a(this.f24213e, l.a(this.f24212d, t.a(this.f24211c, t.a(this.f24210b, this.f24209a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PremiumUiLabels(linksTitle=");
        a5.append(this.f24209a);
        a5.append(", nonIabVendorsLabel=");
        a5.append(this.f24210b);
        a5.append(", uspDnsTitle=");
        a5.append(this.f24211c);
        a5.append(", uspDnsText=");
        a5.append(this.f24212d);
        a5.append(", uspDoNotSellToggleText=");
        a5.append(this.f24213e);
        a5.append(", uspPrivacyPolicyLinkText=");
        a5.append(this.f24214f);
        a5.append(", uspDeleteDataLinkText=");
        a5.append(this.f24215g);
        a5.append(", uspAccessDataLinkText=");
        a5.append(this.f24216h);
        a5.append(", uspAcceptButton=");
        a5.append(this.f24217i);
        a5.append(", initScreenCustomLinks=");
        a5.append(this.f24218j);
        a5.append(')');
        return a5.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C2603n(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.List r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.List r12, int r13) {
        /*
            r2 = this;
            r0 = r13 & 1
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0007
            r3 = r1
        L_0x0007:
            r0 = r13 & 2
            if (r0 == 0) goto L_0x000c
            r4 = r1
        L_0x000c:
            r0 = r13 & 4
            if (r0 == 0) goto L_0x0011
            r5 = r1
        L_0x0011:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0019
            java.util.List r6 = S2.C1601o.h()
        L_0x0019:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x001e
            r7 = r1
        L_0x001e:
            r0 = r13 & 32
            if (r0 == 0) goto L_0x0023
            r8 = r1
        L_0x0023:
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0028
            r9 = r1
        L_0x0028:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002d
            r10 = r1
        L_0x002d:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0032
            r11 = r1
        L_0x0032:
            r13 = r13 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x003b
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
        L_0x003b:
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: V3.C2603n.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int):void");
    }
}
