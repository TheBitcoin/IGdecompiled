package T3;

import A2.a;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: T3.j  reason: case insensitive filesystem */
public final class C2582j extends C2580h {

    /* renamed from: e  reason: collision with root package name */
    public final List f24005e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24006f;

    /* renamed from: g  reason: collision with root package name */
    public final String f24007g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24008h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24009i;

    /* renamed from: j  reason: collision with root package name */
    public final String f24010j;

    /* renamed from: k  reason: collision with root package name */
    public final String f24011k;

    /* renamed from: l  reason: collision with root package name */
    public final String f24012l;

    /* renamed from: m  reason: collision with root package name */
    public final String f24013m;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C2582j(java.util.List r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
        L_0x000b:
            r1 = r11
            r11 = r0 & 2
            r2 = 0
            if (r11 == 0) goto L_0x0012
            r12 = r2
        L_0x0012:
            r11 = r0 & 4
            if (r11 == 0) goto L_0x0018
            r3 = r2
            goto L_0x0019
        L_0x0018:
            r3 = r13
        L_0x0019:
            r11 = r0 & 8
            if (r11 == 0) goto L_0x001f
            r4 = r2
            goto L_0x0020
        L_0x001f:
            r4 = r14
        L_0x0020:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x0026
            r5 = r2
            goto L_0x0027
        L_0x0026:
            r5 = r15
        L_0x0027:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x002d
            r6 = r2
            goto L_0x002f
        L_0x002d:
            r6 = r16
        L_0x002f:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x0035
            r7 = r2
            goto L_0x0037
        L_0x0035:
            r7 = r17
        L_0x0037:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x003d
            r8 = r2
            goto L_0x003f
        L_0x003d:
            r8 = r18
        L_0x003f:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0047
            r9 = r2
        L_0x0044:
            r0 = r10
            r2 = r12
            goto L_0x004a
        L_0x0047:
            r9 = r19
            goto L_0x0044
        L_0x004a:
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: T3.C2582j.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        for (C2587o a5 : this.f24005e) {
            arrayList.add(new JSONObject(a5.a()));
        }
        jSONObject.put("userEvents", new JSONArray(arrayList));
        jSONObject.putOpt("acceptanceState", this.f24006f);
        jSONObject.putOpt("objectionState", this.f24007g);
        jSONObject.putOpt("tcData", this.f24008h);
        jSONObject.putOpt("gppData", this.f24009i);
        jSONObject.putOpt(MRAIDCommunicatorUtil.KEY_STATE, this.f24010j);
        jSONObject.putOpt("jurisdiction", this.f24011k);
        jSONObject.putOpt("nonIabConsentData", this.f24012l);
        jSONObject.putOpt("uspData", this.f24013m);
        jSONObject.put("clientTimestamp", this.f23995a);
        jSONObject.put("operationType", this.f23996b.f23973a);
        jSONObject.putOpt("sessionId", this.f23997c);
        jSONObject.put("domain", this.f23998d);
        String jSONObject2 = jSONObject.toString();
        m.d(jSONObject2, "JSONObject().apply {\n   … domain)\n    }.toString()");
        return jSONObject2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2582j)) {
            return false;
        }
        C2582j jVar = (C2582j) obj;
        if (m.a(this.f24005e, jVar.f24005e) && m.a(this.f24006f, jVar.f24006f) && m.a(this.f24007g, jVar.f24007g) && m.a(this.f24008h, jVar.f24008h) && m.a(this.f24009i, jVar.f24009i) && m.a(this.f24010j, jVar.f24010j) && m.a(this.f24011k, jVar.f24011k) && m.a(this.f24012l, jVar.f24012l) && m.a(this.f24013m, jVar.f24013m)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int hashCode = this.f24005e.hashCode() * 31;
        String str = this.f24006f;
        int i11 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i12 = (hashCode + i4) * 31;
        String str2 = this.f24007g;
        if (str2 == null) {
            i5 = 0;
        } else {
            i5 = str2.hashCode();
        }
        int i13 = (i12 + i5) * 31;
        String str3 = this.f24008h;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = str3.hashCode();
        }
        int i14 = (i13 + i6) * 31;
        String str4 = this.f24009i;
        if (str4 == null) {
            i7 = 0;
        } else {
            i7 = str4.hashCode();
        }
        int i15 = (i14 + i7) * 31;
        String str5 = this.f24010j;
        if (str5 == null) {
            i8 = 0;
        } else {
            i8 = str5.hashCode();
        }
        int i16 = (i15 + i8) * 31;
        String str6 = this.f24011k;
        if (str6 == null) {
            i9 = 0;
        } else {
            i9 = str6.hashCode();
        }
        int i17 = (i16 + i9) * 31;
        String str7 = this.f24012l;
        if (str7 == null) {
            i10 = 0;
        } else {
            i10 = str7.hashCode();
        }
        int i18 = (i17 + i10) * 31;
        String str8 = this.f24013m;
        if (str8 != null) {
            i11 = str8.hashCode();
        }
        return i18 + i11;
    }

    public String toString() {
        StringBuilder a5 = a.a("TrackingUserDoneLog(userEvents=");
        a5.append(this.f24005e);
        a5.append(", acceptanceState=");
        a5.append(this.f24006f);
        a5.append(", objectionState=");
        a5.append(this.f24007g);
        a5.append(", tcData=");
        a5.append(this.f24008h);
        a5.append(", gppData=");
        a5.append(this.f24009i);
        a5.append(", state=");
        a5.append(this.f24010j);
        a5.append(", jurisdiction=");
        a5.append(this.f24011k);
        a5.append(", nonIabConsentData=");
        a5.append(this.f24012l);
        a5.append(", uspData=");
        a5.append(this.f24013m);
        a5.append(')');
        return a5.toString();
    }

    public C2582j(List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        m.e(list, "userEvents");
        this.f24005e = list;
        this.f24006f = str;
        this.f24007g = str2;
        this.f24008h = str3;
        this.f24009i = str4;
        this.f24010j = str5;
        this.f24011k = str6;
        this.f24012l = str7;
        this.f24013m = str8;
    }
}
