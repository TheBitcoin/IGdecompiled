package Z3;

import C3.a;
import C3.b;
import C3.c;
import C3.d;
import C3.e;
import C3.f;
import C3.g;
import V3.C2594e;
import V3.C2598i;
import V3.C2603n;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.l  reason: case insensitive filesystem */
public final class C2623l implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public ChoiceCmpCallback f24379a;

    /* renamed from: b  reason: collision with root package name */
    public C2614c f24380b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f24381c;

    public C2623l(ChoiceCmpCallback choiceCmpCallback, C2614c cVar) {
        m.e(cVar, "coreUiLabelsResolver");
        this.f24379a = choiceCmpCallback;
        this.f24380b = cVar;
    }

    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            this.f24381c = new JSONObject(str);
            return new f(c(), a(), b(), this.f24380b.a(str), (C2598i) null, d(), 16);
        } catch (JSONException unused) {
            ChoiceCmpCallback choiceCmpCallback = this.f24379a;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onCmpError(ChoiceError.UNKNOWN_CONFIG);
            }
            return new f((g) null, (a) null, (e) null, (C2594e) null, (C2598i) null, (C2603n) null, 63);
        }
    }

    public final e b() {
        JSONObject jSONObject = this.f24381c;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("nonIabVendorsInfo");
        JSONArray optJSONArray = jSONObject2.optJSONArray("nonIabVendorList");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i4);
                int optInt = jSONObject3.optInt("vendorId");
                String optString = jSONObject3.optString("pCode");
                String a5 = C2615d.a(optString, "nonIABVendor.optString(\"pCode\")", jSONObject3, RewardPlus.NAME, "nonIABVendor.optString(\"name\")");
                String optString2 = jSONObject3.optString("description", "");
                m.d(optString2, "nonIABVendor.optString(\"description\", EMPTY)");
                String optString3 = jSONObject3.optString("privacyPolicyUrl", "");
                m.d(optString3, "nonIABVendor.optString(\"privacyPolicyUrl\", EMPTY)");
                m.d(jSONObject3, "nonIABVendor");
                arrayList.add(new d(optInt, optString, a5, optString2, optString3, C2620i.a(jSONObject3, "nonIabPurposeConsentIds"), C2620i.a(jSONObject3, "nonIabPurposeLegitimateInterestIds")));
                i4 = i5;
            }
        }
        String optString4 = jSONObject2.optString("updateAt");
        return new e(arrayList, optString4, C2615d.a(optString4, "nonIabVendors.optString(\"updateAt\")", jSONObject2, "nonIabVendorsHash", "nonIabVendors.optString(\"nonIabVendorsHash\")"));
    }

    public final g c() {
        JSONObject jSONObject = this.f24381c;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumProperties");
        m.d(jSONObject2, "premiumProperties");
        return new g(C2620i.a(jSONObject2, "vendorBlacklist"), C2620i.a(jSONObject2, "vendorWhitelist"), C2620i.a(jSONObject2, "googleWhitelist"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: V3.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: V3.n} */
    /* JADX WARNING: type inference failed for: r12v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.util.ArrayList] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V3.C2603n d() {
        /*
            r14 = this;
            org.json.JSONObject r0 = r14.f24381c
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = "json"
            kotlin.jvm.internal.m.u(r0)
            r0 = r1
        L_0x000b:
            java.lang.String r2 = "premiumUiLabels"
            org.json.JSONObject r0 = r0.optJSONObject(r2)
            if (r0 != 0) goto L_0x0015
            goto L_0x0090
        L_0x0015:
            java.lang.String r2 = "initScreenCustomLinks"
            org.json.JSONArray r2 = r0.optJSONArray(r2)
            if (r2 != 0) goto L_0x001e
            goto L_0x004a
        L_0x001e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r2.length()
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x004a
            int r5 = r4 + 1
            org.json.JSONObject r4 = r2.optJSONObject(r4)
            V3.o r6 = new V3.o
            java.lang.String r7 = "label"
            java.lang.String r7 = r4.optString(r7)
            java.lang.String r8 = "link"
            java.lang.String r9 = "initScreenCustomLink.optString(\"link\")"
            java.lang.String r10 = "initScreenCustomLink.optString(\"label\")"
            java.lang.String r4 = Z3.C2615d.a(r7, r10, r4, r8, r9)
            r6.<init>(r7, r4)
            r1.add(r6)
            r4 = r5
            goto L_0x0028
        L_0x004a:
            if (r1 != 0) goto L_0x0051
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0051:
            r12 = r1
            java.lang.String r1 = "uspDnsTitle"
            java.lang.String r5 = r0.optString(r1)
            java.lang.String r1 = "uspDnsText"
            java.util.List r6 = Z3.C2620i.b(r0, r1)
            java.lang.String r1 = "uspDeleteDataLinkText"
            java.lang.String r9 = r0.optString(r1)
            java.lang.String r1 = "uspAccessDataLinkText"
            java.lang.String r10 = r0.optString(r1)
            java.lang.String r1 = "uspPrivacyPolicyLinkText"
            java.lang.String r8 = r0.optString(r1)
            V3.n r2 = new V3.n
            java.lang.String r0 = "optString(\"uspDnsTitle\")"
            kotlin.jvm.internal.m.d(r5, r0)
            java.lang.String r0 = "optString(\"uspPrivacyPolicyLinkText\")"
            kotlin.jvm.internal.m.d(r8, r0)
            java.lang.String r0 = "optString(\"uspDeleteDataLinkText\")"
            kotlin.jvm.internal.m.d(r9, r0)
            java.lang.String r0 = "optString(\"uspAccessDataLinkText\")"
            kotlin.jvm.internal.m.d(r10, r0)
            r11 = 0
            r13 = 275(0x113, float:3.85E-43)
            r3 = 0
            r4 = 0
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r1 = r2
        L_0x0090:
            if (r1 != 0) goto L_0x00a4
            V3.n r2 = new V3.n
            r12 = 0
            r13 = 1023(0x3ff, float:1.434E-42)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Z3.C2623l.d():V3.n");
    }

    public final a a() {
        a aVar;
        c cVar;
        boolean z4;
        boolean z5;
        boolean z6;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        List list;
        a aVar2;
        JSONObject jSONObject = this.f24381c;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("coreConfig");
        String optString = jSONObject2.optString("inmobiAccountId");
        m.d(optString, "coreConfig.optString(\"inmobiAccountId\")");
        m.d(jSONObject2, "coreConfig");
        List b5 = C2620i.b(jSONObject2, "privacyMode");
        List b6 = C2620i.b(jSONObject2, "uspJurisdiction");
        String optString2 = jSONObject2.optString("uspLspact");
        String a5 = C2615d.a(optString2, "coreConfig.optString(\"uspLspact\")", jSONObject2, "hashCode", "coreConfig.optString(\"hashCode\")");
        String optString3 = jSONObject2.optString("publisherCountryCode");
        String a6 = C2615d.a(optString3, "coreConfig.optString(\"publisherCountryCode\")", jSONObject2, "publisherName", "coreConfig.optString(\"publisherName\")");
        List a7 = C2620i.a(jSONObject2, "vendorPurposeIds");
        List a8 = C2620i.a(jSONObject2, "vendorFeaturesIds");
        List a9 = C2620i.a(jSONObject2, "vendorPurposeLegitimateInterestIds");
        List a10 = C2620i.a(jSONObject2, "vendorSpecialFeaturesIds");
        List a11 = C2620i.a(jSONObject2, "vendorSpecialPurposesIds");
        boolean optBoolean = jSONObject2.optBoolean("googleEnabled");
        String optString4 = jSONObject2.optString("consentScope");
        a aVar3 = aVar;
        String a12 = C2615d.a(optString4, "coreConfig.optString(\"consentScope\")", jSONObject2, "lang_", "coreConfig.optString(\"lang_\")");
        String optString5 = jSONObject2.optString("displayUi");
        m.d(optString5, "coreConfig.optString(\"displayUi\")");
        boolean optBoolean2 = jSONObject2.optBoolean("initScreenRejectButtonShowing");
        String optString6 = jSONObject2.optString("publisherLogo");
        String str9 = a12;
        m.d(optString6, "coreConfig.optString(\"publisherLogo\")");
        List a13 = C2620i.a(jSONObject2, "publisherPurposeIds");
        List a14 = C2620i.a(jSONObject2, "publisherPurposeLegitimateInterestIds");
        List a15 = C2620i.a(jSONObject2, "publisherSpecialPurposesIds");
        List a16 = C2620i.a(jSONObject2, "publisherFeaturesIds");
        List a17 = C2620i.a(jSONObject2, "publisherSpecialFeaturesIds");
        List a18 = C2620i.a(jSONObject2, "publisherConsentRestrictionIds");
        List a19 = C2620i.a(jSONObject2, "publisherLIRestrictionIds");
        List a20 = C2620i.a(jSONObject2, "stacks");
        int optInt = jSONObject2.optInt("vendorListUpdateFreq");
        String optString7 = jSONObject2.optString("thirdPartyStorageType");
        String str10 = optString5;
        m.d(optString7, "coreConfig.optString(\"thirdPartyStorageType\")");
        String str11 = optString7;
        boolean optBoolean3 = jSONObject2.optBoolean("suppressCcpaLinks", false);
        String optString8 = jSONObject2.optString("uspDeleteDataLink");
        String str12 = optString4;
        String str13 = optString6;
        String a21 = C2615d.a(optString8, "coreConfig.optString(\"uspDeleteDataLink\")", jSONObject2, "uspAccessDataLink", "coreConfig.optString(\"uspAccessDataLink\")");
        String optString9 = jSONObject2.optString("uspPrivacyPolicyLink");
        m.d(optString9, "coreConfig.optString(\"uspPrivacyPolicyLink\")");
        String str14 = a21;
        int optInt2 = jSONObject2.optInt("gvlVersion", 2);
        Integer valueOf = Integer.valueOf(jSONObject2.optInt("totalVendors"));
        String optString10 = jSONObject2.optString("gdprEncodingMode");
        String optString11 = jSONObject2.optString("mspaJurisdiction");
        int i5 = optInt2;
        boolean optBoolean4 = jSONObject2.optBoolean("isCoveredTransaction", false);
        String optString12 = jSONObject2.optString("mspaSignalMode");
        String str15 = optString8;
        boolean optBoolean5 = jSONObject2.optBoolean("ccpaViaUsp", true);
        List a22 = C2620i.a(jSONObject2, "mspaOptOutPurposeIds");
        List a23 = C2620i.a(jSONObject2, "mspaSensitiveDataPurposeIds");
        String optString13 = jSONObject2.optString("cmpVersion");
        List b7 = C2620i.b(jSONObject2, "consentLocations");
        boolean z7 = optBoolean5;
        boolean optBoolean6 = jSONObject2.optBoolean("mspaAutoPopUp", false);
        JSONObject optJSONObject = jSONObject2.optJSONObject("gbcConfig");
        if (optJSONObject == null) {
            int i6 = i5;
            z6 = optBoolean4;
            aVar2 = aVar3;
            str6 = str9;
            str5 = str10;
            str4 = str13;
            str = optString9;
            str7 = str12;
            str2 = str14;
            i4 = i6;
            str3 = str15;
            z5 = z7;
            z4 = optBoolean6;
            cVar = new c(false, (List) null, (List) null, 7);
        } else {
            boolean z8 = optBoolean6;
            String str16 = optString9;
            boolean optBoolean7 = optJSONObject.optBoolean("enabled", false);
            List b8 = C2620i.b(optJSONObject, "locations");
            boolean z9 = optBoolean4;
            JSONArray optJSONArray = optJSONObject.optJSONArray("applicablePurposes");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null) {
                str8 = optString;
                list = b5;
            } else {
                str8 = optString;
                int length = optJSONArray.length();
                list = b5;
                int i7 = 0;
                while (i7 < length) {
                    int i8 = i7 + 1;
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i7);
                    int i9 = length;
                    int optInt3 = jSONObject3.optInt("id");
                    String optString14 = jSONObject3.optString("defaultValue");
                    m.d(optString14, "gbcPurpose.optString(\"defaultValue\")");
                    arrayList.add(new b(optInt3, GBCConsentValue.valueOf(optString14)));
                    i7 = i8;
                    optJSONArray = optJSONArray;
                    length = i9;
                    b6 = b6;
                }
            }
            List list2 = b6;
            c cVar2 = new c(optBoolean7, b8, arrayList);
            aVar2 = aVar3;
            str6 = str9;
            str5 = str10;
            str4 = str13;
            str3 = str15;
            z5 = z7;
            z4 = z8;
            optString = str8;
            b5 = list;
            b6 = list2;
            cVar = cVar2;
            str = str16;
            str7 = str12;
            str2 = str14;
            i4 = i5;
            z6 = z9;
        }
        return new a(optString, b5, b6, optString2, a5, optString3, a6, a7, a8, a9, a10, a11, optBoolean, str7, str6, str5, optBoolean2, str4, a13, a14, a15, a16, a17, a18, a19, a20, optInt, str11, optBoolean3, str3, str2, str, i4, valueOf, optString10, optString11, z6, optString12, z5, a22, a23, optString13, b7, z4, cVar);
    }
}
