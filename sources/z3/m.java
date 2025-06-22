package Z3;

import C2.b;
import C2.c;
import V3.C2594e;
import V3.C2598i;
import V3.C2603n;
import V3.r;
import com.inmobi.cmp.model.ChoiceError;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class m implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public C2614c f24382a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f24383b;

    public m(C2614c cVar) {
        kotlin.jvm.internal.m.e(cVar, "coreUiLabelsResolver");
        this.f24382a = cVar;
    }

    public Object a(String str) {
        kotlin.jvm.internal.m.e(str, "jsonString");
        try {
            this.f24383b = new JSONObject(str);
            return new r(this.f24382a.a(str), b(), a());
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new r((C2594e) null, (C2603n) null, (C2598i) null, 7);
        }
    }

    public final C2603n b() {
        JSONObject jSONObject = this.f24383b;
        if (jSONObject == null) {
            kotlin.jvm.internal.m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumUiLabels");
        String optString = jSONObject2.optString("linksTitle");
        String a5 = C2615d.a(optString, "premiumUiLabels.optString(\"linksTitle\")", jSONObject2, "nonIabVendorsLabel", "premiumUiLabels.optString(\"nonIabVendorsLabel\")");
        String optString2 = jSONObject2.optString("uspDnsTitle");
        kotlin.jvm.internal.m.d(optString2, "premiumUiLabels.optString(\"uspDnsTitle\")");
        kotlin.jvm.internal.m.d(jSONObject2, "premiumUiLabels");
        List b5 = C2620i.b(jSONObject2, "uspDnsText");
        String optString3 = jSONObject2.optString("uspDoNotSellToggleText");
        String a6 = C2615d.a(optString3, "premiumUiLabels.optStrin…\"uspDoNotSellToggleText\")", jSONObject2, "uspPrivacyPolicyLinkText", "premiumUiLabels.optStrin…spPrivacyPolicyLinkText\")");
        String optString4 = jSONObject2.optString("uspDeleteDataLinkText");
        String a7 = C2615d.a(optString4, "premiumUiLabels.optString(\"uspDeleteDataLinkText\")", jSONObject2, "uspAccessDataLinkText", "premiumUiLabels.optString(\"uspAccessDataLinkText\")");
        String optString5 = jSONObject2.optString("uspAcceptButton");
        kotlin.jvm.internal.m.d(optString5, "premiumUiLabels.optString(\"uspAcceptButton\")");
        return new C2603n(optString, a5, optString2, b5, optString3, a6, optString4, a7, optString5, (List) null, 512);
    }

    public final C2598i a() {
        JSONObject jSONObject = this.f24383b;
        if (jSONObject == null) {
            kotlin.jvm.internal.m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("mobileUiLabels");
        String optString = jSONObject2.optString("doneLabel");
        String optString2 = jSONObject2.optString("searchLabel");
        String optString3 = jSONObject2.optString("cancelLabel");
        String optString4 = jSONObject2.optString("consentLabel");
        String optString5 = jSONObject2.optString("flexPurposesLabel");
        String optString6 = jSONObject2.optString("cookieAccessBodyText");
        String optString7 = jSONObject2.optString("showVendorsLabel");
        String optString8 = jSONObject2.optString("showIabLabel");
        String optString9 = jSONObject2.optString("noneLabel");
        String optString10 = jSONObject2.optString("someLabel");
        String optString11 = jSONObject2.optString("allLabel");
        String optString12 = jSONObject2.optString("closeLabel");
        String optString13 = jSONObject2.optString("allVendorsLabel");
        kotlin.jvm.internal.m.d(jSONObject2, "mobileUiLabels");
        List b5 = C2620i.b(jSONObject2, "summaryScreenBodyRejectService");
        List b6 = C2620i.b(jSONObject2, "summaryScreenBodyTextReject");
        kotlin.jvm.internal.m.d(optString, "optString(\"doneLabel\")");
        kotlin.jvm.internal.m.d(optString2, "optString(\"searchLabel\")");
        kotlin.jvm.internal.m.d(optString3, "optString(\"cancelLabel\")");
        kotlin.jvm.internal.m.d(optString7, "optString(\"showVendorsLabel\")");
        kotlin.jvm.internal.m.d(optString8, "optString(\"showIabLabel\")");
        kotlin.jvm.internal.m.d(optString4, "optString(\"consentLabel\")");
        kotlin.jvm.internal.m.d(optString5, "optString(\"flexPurposesLabel\")");
        kotlin.jvm.internal.m.d(optString6, "optString(\"cookieAccessBodyText\")");
        kotlin.jvm.internal.m.d(optString9, "optString(\"noneLabel\")");
        kotlin.jvm.internal.m.d(optString10, "optString(\"someLabel\")");
        kotlin.jvm.internal.m.d(optString11, "optString(\"allLabel\")");
        kotlin.jvm.internal.m.d(optString12, "optString(\"closeLabel\")");
        kotlin.jvm.internal.m.d(optString13, "optString(\"allVendorsLabel\")");
        return new C2598i(optString, optString2, optString3, optString7, optString8, optString4, optString5, optString6, optString9, optString10, optString11, optString12, optString13, b5, b6);
    }
}
