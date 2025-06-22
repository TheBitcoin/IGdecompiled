package Z3;

import C2.b;
import C2.c;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z3.d;
import z3.e;
import z3.i;

public final class n implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f24384a;

    public n(Locale locale) {
        m.e(locale, "appLocale");
        this.f24384a = locale;
    }

    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            return e(new JSONObject(str));
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new e();
        }
    }

    public final Map b(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        m.d(keys, "purposes.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            m.d(next, LeanbackPreferenceDialogFragment.ARG_KEY);
            linkedHashMap.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
        return linkedHashMap;
    }

    public final Map c(JSONObject jSONObject, int i4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        m.d(keys, "features.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                m.d(next, LeanbackPreferenceDialogFragment.ARG_KEY);
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString(RewardPlus.NAME);
                linkedHashMap.put(next, new d(optInt, optString, C2615d.a(optString, "feature.optString(\"name\")", optJSONObject, "description", "feature.optString(\"description\")"), d(optJSONObject, i4)));
            }
        }
        return linkedHashMap;
    }

    public final String d(JSONObject jSONObject, int i4) {
        String str;
        if (i4 > 2) {
            JSONArray optJSONArray = jSONObject.optJSONArray("illustrations");
            if (optJSONArray == null) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder();
                int length = optJSONArray.length();
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    F f4 = F.f20971a;
                    String format = String.format("* %s", Arrays.copyOf(new Object[]{optJSONArray.getString(i5)}, 1));
                    m.d(format, "format(format, *args)");
                    sb.append(format);
                    m.d(sb, "append(value)");
                    sb.append(10);
                    m.d(sb, "append('\\n')");
                    i5 = i6;
                }
                str = sb.toString();
                m.d(str, "str.toString()");
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        String optString = jSONObject.optString("descriptionLegal");
        m.d(optString, "{\n            feature.op…criptionLegal\")\n        }");
        return optString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0314  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final z3.e e(org.json.JSONObject r49) {
        /*
            r48 = this;
            r0 = r48
            r1 = r49
            z3.e r2 = new z3.e
            r2.<init>()
            java.lang.String r3 = "gvlSpecificationVersion"
            int r3 = r1.optInt(r3)
            r2.f4800a = r3
            java.lang.String r3 = "vendorListVersion"
            int r3 = r1.optInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f4801b = r3
            java.lang.String r3 = "tcfPolicyVersion"
            int r3 = r1.optInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.f4802c = r3
            java.lang.String r3 = "lastUpdated"
            java.lang.String r3 = r1.optString(r3)
            java.lang.String r4 = "vendorListJson.optString(\"lastUpdated\")"
            kotlin.jvm.internal.m.d(r3, r4)
            java.util.Locale r4 = r0.f24384a
            java.lang.String r5 = "dateString"
            kotlin.jvm.internal.m.e(r3, r5)
            java.lang.String r5 = "format"
            java.lang.String r6 = "yyyy-MM-dd'T'HH:mm:ss"
            kotlin.jvm.internal.m.e(r6, r5)
            java.lang.String r5 = "locale"
            kotlin.jvm.internal.m.e(r4, r5)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            r5.<init>(r6, r4)
            java.util.Date r3 = r5.parse(r3)
            if (r3 != 0) goto L_0x0053
            goto L_0x0056
        L_0x0053:
            r3.getTime()
        L_0x0056:
            java.lang.String r3 = "purposes"
            org.json.JSONObject r4 = r1.getJSONObject(r3)
            java.lang.String r5 = "vendorListJson.getJSONObject(\"purposes\")"
            kotlin.jvm.internal.m.d(r4, r5)
            int r5 = r2.f4800a
            java.util.Map r4 = r0.f(r4, r5)
            java.lang.String r5 = "<set-?>"
            kotlin.jvm.internal.m.e(r4, r5)
            r2.f4803d = r4
            java.lang.String r4 = "specialPurposes"
            org.json.JSONObject r6 = r1.getJSONObject(r4)
            java.lang.String r7 = "vendorListJson.getJSONObject(\"specialPurposes\")"
            kotlin.jvm.internal.m.d(r6, r7)
            int r7 = r2.f4800a
            java.util.Map r6 = r0.f(r6, r7)
            kotlin.jvm.internal.m.e(r6, r5)
            r2.f4804e = r6
            java.lang.String r6 = "features"
            org.json.JSONObject r7 = r1.getJSONObject(r6)
            java.lang.String r8 = "vendorListJson.getJSONObject(\"features\")"
            kotlin.jvm.internal.m.d(r7, r8)
            int r8 = r2.f4800a
            java.util.Map r7 = r0.c(r7, r8)
            kotlin.jvm.internal.m.e(r7, r5)
            r2.f4805f = r7
            java.lang.String r7 = "specialFeatures"
            org.json.JSONObject r8 = r1.getJSONObject(r7)
            java.lang.String r9 = "vendorListJson.getJSONObject(\"specialFeatures\")"
            kotlin.jvm.internal.m.d(r8, r9)
            int r9 = r2.f4800a
            java.util.Map r8 = r0.c(r8, r9)
            kotlin.jvm.internal.m.e(r8, r5)
            r2.f4806g = r8
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.lang.String r9 = "stacks"
            org.json.JSONObject r9 = r1.getJSONObject(r9)
            java.util.Iterator r10 = r9.keys()
            java.lang.String r11 = "stacks.keys()"
            kotlin.jvm.internal.m.d(r10, r11)
        L_0x00c4:
            boolean r11 = r10.hasNext()
            java.lang.String r12 = "description"
            java.lang.String r13 = "name"
            java.lang.String r14 = "id"
            java.lang.String r15 = "key"
            if (r11 == 0) goto L_0x011d
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            r16 = r10
            org.json.JSONObject r10 = r9.getJSONObject(r11)
            kotlin.jvm.internal.m.d(r11, r15)
            z3.j r17 = new z3.j
            int r18 = r10.optInt(r14)
            java.lang.String r13 = r10.optString(r13)
            java.lang.String r14 = "stack.optString(\"name\")"
            kotlin.jvm.internal.m.d(r13, r14)
            java.lang.String r12 = r10.optString(r12)
            java.lang.String r14 = "stack.optString(\"description\")"
            kotlin.jvm.internal.m.d(r12, r14)
            java.lang.String r14 = "stack"
            kotlin.jvm.internal.m.d(r10, r14)
            java.util.List r14 = Z3.C2620i.a(r10, r3)
            java.util.List r21 = S2.C1601o.b0(r14)
            java.util.List r10 = Z3.C2620i.a(r10, r7)
            java.util.List r22 = S2.C1601o.b0(r10)
            r20 = r12
            r19 = r13
            r17.<init>(r18, r19, r20, r21, r22)
            r10 = r17
            r8.put(r11, r10)
            r10 = r16
            goto L_0x00c4
        L_0x011d:
            kotlin.jvm.internal.m.e(r8, r5)
            r2.f4809j = r8
            int r8 = r2.f4800a
            r9 = 2
            if (r8 <= r9) goto L_0x0189
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.lang.String r10 = "dataCategories"
            org.json.JSONObject r10 = r1.getJSONObject(r10)
            java.util.Iterator r11 = r10.keys()
            java.lang.String r9 = "dataCategories.keys()"
            kotlin.jvm.internal.m.d(r11, r9)
        L_0x013b:
            boolean r9 = r11.hasNext()
            if (r9 == 0) goto L_0x017d
            java.lang.Object r9 = r11.next()
            java.lang.String r9 = (java.lang.String) r9
            r17 = r11
            org.json.JSONObject r11 = r10.getJSONObject(r9)
            kotlin.jvm.internal.m.d(r9, r15)
            r18 = r10
            z3.b r10 = new z3.b
            int r0 = r11.optInt(r14)
            r19 = r7
            java.lang.String r7 = r11.optString(r13)
            r20 = r6
            java.lang.String r6 = "dataCategory.optString(\"name\")"
            r21 = r4
            java.lang.String r4 = "dataCategory.optString(\"description\")"
            java.lang.String r4 = Z3.C2615d.a(r7, r6, r11, r12, r4)
            r10.<init>(r0, r7, r4)
            r8.put(r9, r10)
            r0 = r48
            r11 = r17
            r10 = r18
            r7 = r19
            r6 = r20
            r4 = r21
            goto L_0x013b
        L_0x017d:
            r21 = r4
            r20 = r6
            r19 = r7
            kotlin.jvm.internal.m.e(r8, r5)
            r2.f4810k = r8
            goto L_0x018f
        L_0x0189:
            r21 = r4
            r20 = r6
            r19 = r7
        L_0x018f:
            int r0 = r2.f4800a
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.lang.String r5 = "vendors"
            org.json.JSONObject r1 = r1.optJSONObject(r5)
            if (r1 != 0) goto L_0x01a0
            goto L_0x0362
        L_0x01a0:
            java.util.Iterator r5 = r1.keys()
            java.lang.String r6 = "vendors.keys()"
            kotlin.jvm.internal.m.d(r5, r6)
        L_0x01a9:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0362
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            org.json.JSONObject r7 = r1.optJSONObject(r6)
            if (r7 != 0) goto L_0x01bc
            goto L_0x01a9
        L_0x01bc:
            kotlin.jvm.internal.m.d(r6, r15)
            int r23 = r7.optInt(r14)
            java.lang.String r8 = r7.optString(r13)
            java.util.List r9 = Z3.C2620i.a(r7, r3)
            java.util.Set r26 = S2.C1601o.c0(r9)
            java.lang.String r9 = "legIntPurposes"
            java.util.List r9 = Z3.C2620i.a(r7, r9)
            java.util.Set r27 = S2.C1601o.c0(r9)
            java.lang.String r9 = "flexiblePurposes"
            java.util.List r9 = Z3.C2620i.a(r7, r9)
            java.util.Set r28 = S2.C1601o.c0(r9)
            r9 = r21
            java.util.List r10 = Z3.C2620i.a(r7, r9)
            java.util.Set r29 = S2.C1601o.c0(r10)
            r10 = r20
            java.util.List r11 = Z3.C2620i.a(r7, r10)
            java.util.Set r30 = S2.C1601o.c0(r11)
            r11 = r19
            java.util.List r12 = Z3.C2620i.a(r7, r11)
            java.util.Set r31 = S2.C1601o.c0(r12)
            java.lang.String r12 = "policyUrl"
            r49 = r1
            java.lang.String r1 = ""
            java.lang.String r12 = r7.optString(r12, r1)
            r17 = r5
            java.lang.String r5 = "deletedDate"
            java.lang.String r5 = r7.optString(r5, r1)
            kotlin.jvm.internal.m.d(r5, r1)
            int r1 = r5.length()
            r18 = 0
            if (r1 != 0) goto L_0x0221
            r33 = r18
            goto L_0x0223
        L_0x0221:
            r33 = r5
        L_0x0223:
            java.lang.String r1 = "overflow"
            r5 = 2
            if (r0 <= r5) goto L_0x0236
            z3.h r5 = new z3.h
            int r1 = r7.optInt(r1)
            r5.<init>(r1)
            r19 = r0
        L_0x0233:
            r34 = r5
            goto L_0x024f
        L_0x0236:
            org.json.JSONObject r1 = r7.optJSONObject(r1)
            if (r1 != 0) goto L_0x0241
            r19 = r0
            r34 = r18
            goto L_0x024f
        L_0x0241:
            z3.h r5 = new z3.h
            r19 = r0
            java.lang.String r0 = "httpGetLimit"
            int r0 = r1.optInt(r0)
            r5.<init>(r0)
            goto L_0x0233
        L_0x024f:
            java.lang.String r0 = "cookieMaxAgeSeconds"
            int r35 = r7.optInt(r0)
            java.lang.String r0 = "useCookies"
            r1 = 0
            boolean r36 = r7.optBoolean(r0, r1)
            java.lang.String r0 = "cookieRefresh"
            boolean r37 = r7.optBoolean(r0, r1)
            java.lang.String r0 = "usesNonCookieAccess"
            boolean r0 = r7.optBoolean(r0, r1)
            java.lang.String r5 = "dataRetention"
            org.json.JSONObject r5 = r7.optJSONObject(r5)
            if (r5 != 0) goto L_0x0277
            r21 = r0
            r44 = r3
            r40 = r18
            goto L_0x02b4
        L_0x0277:
            java.lang.String r1 = "stdRetention"
            int r1 = r5.optInt(r1)
            r21 = r0
            org.json.JSONObject r0 = r5.optJSONObject(r3)
            r44 = r3
            if (r0 != 0) goto L_0x028c
            r0 = r18
            r3 = r48
            goto L_0x0292
        L_0x028c:
            r3 = r48
            java.util.Map r0 = r3.b(r0)
        L_0x0292:
            if (r0 != 0) goto L_0x0299
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
        L_0x0299:
            org.json.JSONObject r5 = r5.optJSONObject(r9)
            if (r5 != 0) goto L_0x02a2
            r5 = r18
            goto L_0x02a6
        L_0x02a2:
            java.util.Map r5 = r3.b(r5)
        L_0x02a6:
            if (r5 != 0) goto L_0x02ad
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
        L_0x02ad:
            z3.c r3 = new z3.c
            r3.<init>(r1, r0, r5)
            r40 = r3
        L_0x02b4:
            java.lang.String r0 = "urls"
            org.json.JSONArray r0 = r7.optJSONArray(r0)
            if (r0 != 0) goto L_0x02c3
        L_0x02bc:
            r45 = r9
            r46 = r10
            r47 = r11
            goto L_0x0312
        L_0x02c3:
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            int r3 = r0.length()
            r5 = 0
        L_0x02cd:
            if (r5 >= r3) goto L_0x030f
            int r18 = r5 + 1
            org.json.JSONObject r5 = r0.getJSONObject(r5)
            r20 = r0
            z3.k r0 = new z3.k
            r22 = r3
            java.lang.String r3 = "langId"
            java.lang.String r3 = r5.optString(r3)
            r45 = r9
            java.lang.String r9 = "privacy"
            r46 = r10
            java.lang.String r10 = "url.optString(\"privacy\")"
            r47 = r11
            java.lang.String r11 = "url.optString(\"langId\")"
            java.lang.String r9 = Z3.C2615d.a(r3, r11, r5, r9, r10)
            java.lang.String r10 = "legIntClaim"
            java.lang.String r5 = r5.optString(r10)
            java.lang.String r10 = "url.optString(\"legIntClaim\")"
            kotlin.jvm.internal.m.d(r5, r10)
            r0.<init>(r3, r9, r5)
            r1.add(r0)
            r5 = r18
            r0 = r20
            r3 = r22
            r9 = r45
            r10 = r46
            r11 = r47
            goto L_0x02cd
        L_0x030f:
            r18 = r1
            goto L_0x02bc
        L_0x0312:
            if (r18 != 0) goto L_0x0319
            java.util.LinkedHashSet r18 = new java.util.LinkedHashSet
            r18.<init>()
        L_0x0319:
            r41 = r18
            java.lang.String r0 = "dataDeclaration"
            java.util.List r0 = Z3.C2620i.a(r7, r0)
            java.util.Set r39 = S2.C1601o.c0(r0)
            java.lang.String r0 = "deviceStorageDisclosureUrl"
            java.lang.String r0 = r7.optString(r0)
            z3.l r22 = new z3.l
            java.lang.String r1 = "optString(\"name\")"
            kotlin.jvm.internal.m.d(r8, r1)
            java.lang.String r1 = "optString(\"policyUrl\", EMPTY)"
            kotlin.jvm.internal.m.d(r12, r1)
            java.lang.Boolean r38 = java.lang.Boolean.valueOf(r21)
            java.lang.String r1 = "optString(\"deviceStorageDisclosureUrl\")"
            kotlin.jvm.internal.m.d(r0, r1)
            r25 = 0
            r43 = 4
            r42 = r0
            r24 = r8
            r32 = r12
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            r0 = r22
            r4.put(r6, r0)
            r1 = r49
            r5 = r17
            r0 = r19
            r3 = r44
            r21 = r45
            r20 = r46
            r19 = r47
            goto L_0x01a9
        L_0x0362:
            r2.a(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Z3.n.e(org.json.JSONObject):z3.e");
    }

    public final Map f(JSONObject jSONObject, int i4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        m.d(keys, "purposes.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                m.d(next, LeanbackPreferenceDialogFragment.ARG_KEY);
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString(RewardPlus.NAME);
                linkedHashMap.put(next, new i(optInt, optString, C2615d.a(optString, "purpose.optString(\"name\")", optJSONObject, "description", "purpose.optString(\"description\")"), d(optJSONObject, i4)));
            }
        }
        return linkedHashMap;
    }
}
