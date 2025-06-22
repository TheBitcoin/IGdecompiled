package com.mbridge.msdk.newreward.function.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f14448a = 4;

    /* renamed from: b  reason: collision with root package name */
    public static int f14449b = 5;

    /* renamed from: c  reason: collision with root package name */
    private static String f14450c = "BaseCandidateCache";

    /* renamed from: d  reason: collision with root package name */
    private JSONArray f14451d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f14452e;

    /* renamed from: f  reason: collision with root package name */
    private String f14453f;

    /* renamed from: g  reason: collision with root package name */
    private int f14454g;

    /* renamed from: h  reason: collision with root package name */
    private String f14455h;

    /* renamed from: i  reason: collision with root package name */
    private e f14456i;

    /* renamed from: j  reason: collision with root package name */
    private c f14457j;

    /* renamed from: com.mbridge.msdk.newreward.function.a.a$a  reason: collision with other inner class name */
    public static class C0193a {

        /* renamed from: a  reason: collision with root package name */
        private b f14458a;

        /* renamed from: b  reason: collision with root package name */
        private double f14459b;

        public C0193a(double d5, b bVar) {
            this.f14459b = d5;
            this.f14458a = bVar;
        }

        public final b a() {
            return this.f14458a;
        }
    }

    public final JSONObject a(String str) {
        JSONArray jSONArray = this.f14451d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.f14451d.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i4 = 0; i4 < this.f14451d.length(); i4++) {
            try {
                JSONObject optJSONObject = this.f14451d.optJSONObject(i4);
                if (optJSONObject != null && str.equals(optJSONObject.getString("g"))) {
                    this.f14452e = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }

    public final String b(String str) {
        b c5 = c(str);
        if (!(c5 == null || c5.h() == com.mbridge.msdk.foundation.b.c.f12737c || c5.h() == com.mbridge.msdk.foundation.b.c.f12735a)) {
            String[] split = z.a(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public final b c(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            bVar.d("bid token exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
            return bVar;
        }
        JSONArray jSONArray = this.f14451d;
        if (jSONArray == null || jSONArray.length() == 0) {
            bVar.d("config is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
            return bVar;
        }
        String a5 = z.a(str.split("_")[3]);
        if (TextUtils.isEmpty(a5)) {
            bVar.d("bid token exception:decode error");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
            return bVar;
        }
        String[] split = a5.split("\\|");
        if (split.length == 0) {
            bVar.d("bid token can not get bid price");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
            return bVar;
        }
        if (split.length > 0) {
            try {
                Double.parseDouble(split[0]);
            } catch (Exception unused) {
                bVar.d("bid token can not cast bid price");
                bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
                return bVar;
            }
        }
        if (TextUtils.isEmpty(this.f14453f)) {
            bVar.d("unitId is empty");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12737c);
        }
        return bVar;
    }

    public final double d(String str) {
        b c5 = c(str);
        if (!(c5 == null || c5.h() == com.mbridge.msdk.foundation.b.c.f12737c || c5.h() == com.mbridge.msdk.foundation.b.c.f12735a)) {
            try {
                String[] split = z.a(str.split("_")[3]).split("\\|");
                if (split.length > 0) {
                    return Double.parseDouble(split[0]);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final void e(String str) {
        this.f14453f = str;
    }

    public final void f(String str) {
        this.f14455h = str;
    }

    private List<String> b(List<String> list, int i4, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            arrayList.add(a(list.get(i5), i4, str, str2));
        }
        return arrayList;
    }

    public final void a(JSONArray jSONArray) {
        this.f14451d = jSONArray;
    }

    public final void a(List<com.mbridge.msdk.newreward.function.c.a.a> list, com.mbridge.msdk.foundation.same.report.d.c cVar, String str, int i4, String str2, int i5, double d5) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        CampaignEx h4 = list.get(i6).h();
                        h4.setReadyState(0);
                        if (cVar != null) {
                            h4.setNLRid(cVar.f());
                        }
                        h4.setNRid(str);
                        h4.setReasond(str2);
                        h4.setTyped(i4);
                        String b5 = z.b(d5 + "");
                        h4.setNoticeUrl(a(h4.getNoticeUrl(), i5, str, b5));
                        h4.setClickURL(a(h4.getClickURL(), i5, str, b5));
                        h4.setImpressionURL(a(h4.getImpressionURL(), i5, str, b5));
                        h4.setOnlyImpressionURL(a(h4.getOnlyImpressionURL(), i5, str, b5));
                        h4.setAdvImp(a(h4.getAdvImpList(), i5, str, b5));
                        j nativeVideoTracking = h4.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i5, str, b5));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i5, str, b5));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i5, str, b5));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i5, str, b5));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i5, str, b5));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i5, str, b5));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i5, str, b5));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i5, str, b5));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i5, str, b5));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i5, str, b5));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i5, str, b5));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i5, str, b5));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i5, str, b5));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i5, str, b5));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i5, str, b5));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i5, str, b5));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i5, str, b5));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i5, str, b5));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i5, str, b5));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i5, str, b5));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i5, str, b5));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i5, str, b5));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i5, str, b5));
                            h4.setNativeVideoTracking(nativeVideoTracking);
                            h4.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        h4.setPv_urls(b(h4.getPv_urls(), i5, str, b5));
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final b a() {
        b bVar = new b();
        try {
            JSONArray jSONArray = this.f14451d;
            if (jSONArray == null || jSONArray.length() == 0) {
                bVar.d("setting config is null");
                bVar.a(com.mbridge.msdk.foundation.b.c.f12735a);
                return bVar;
            }
        } catch (Exception unused) {
            bVar.d("checkConfigAndDB exception");
            bVar.a(com.mbridge.msdk.foundation.b.c.f12737c);
        }
        return bVar;
    }

    public final List<b> a(int i4, int i5, String str) {
        return com.mbridge.msdk.newreward.function.d.c.a().b().a(i5, str, this.f14453f, true, 0, "");
    }

    private String a(String str, int i4, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (aq.c(str) > 0) {
            return str + "&ca_sce=" + i4 + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i4 + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i4, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, next.getKey());
                jSONObject.put("url", a((String) next.getValue(), i4, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private String[] a(String[] strArr, int i4, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i5 = 0; i5 < strArr.length; i5++) {
            strArr2[i5] = a(strArr[i5], i4, str, str2);
        }
        return strArr2;
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i4, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            Map map = list.get(i5);
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    map.put(entry.getKey(), a((String) entry.getValue(), i4, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public final void a(int i4) {
        this.f14454g = i4;
    }

    public final void a(e eVar) {
        this.f14456i = eVar;
    }

    public final void a(c cVar) {
        this.f14457j = cVar;
    }

    public final void a(String str, String str2, int i4, double d5) {
        if (d5 != 0.0d) {
            if (i4 == 1) {
                String str3 = str2;
                a(f14448a, 3, (List<CampaignEx>) null, true, str3, str, -1, this.f14453f);
            } else if (i4 == 2) {
                String str4 = str2;
                a(f14448a, 1, (List<CampaignEx>) null, true, str4, str, -1, this.f14453f);
            } else if (i4 == 3) {
                try {
                    String str5 = str2;
                    a(f14448a, 4, (List<CampaignEx>) null, true, str5, str, -1, this.f14453f);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0127 A[SYNTHETIC, Splitter:B:44:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0183 A[Catch:{ Exception -> 0x0029 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018f A[Catch:{ Exception -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r17, int r18, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            r2 = r19
            r4 = 1
            java.lang.String r5 = ""
            com.mbridge.msdk.foundation.same.report.d.e r6 = new com.mbridge.msdk.foundation.same.report.d.e
            r6.<init>()
            java.lang.String r7 = "type"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029 }
            r8.<init>()     // Catch:{ Exception -> 0x0029 }
            r8.append(r0)     // Catch:{ Exception -> 0x0029 }
            r8.append(r5)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0029 }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r7 = "result"
            if (r20 == 0) goto L_0x002c
            java.lang.String r8 = "1"
            goto L_0x002e
        L_0x0029:
            r0 = move-exception
            goto L_0x01ac
        L_0x002c:
            java.lang.String r8 = "2"
        L_0x002e:
            r6.a(r7, r8)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r7 = "max_usage_limit"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029 }
            r8.<init>()     // Catch:{ Exception -> 0x0029 }
            r9 = r23
            r8.append(r9)     // Catch:{ Exception -> 0x0029 }
            r8.append(r5)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0029 }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r7 = "unit_id"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029 }
            r8.<init>()     // Catch:{ Exception -> 0x0029 }
            r12 = r24
            r8.append(r12)     // Catch:{ Exception -> 0x0029 }
            r8.append(r5)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0029 }
            r6.a(r7, r8)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r7 = "scene"
            java.lang.String r8 = "db"
            r6.a(r7, r8)     // Catch:{ Exception -> 0x0029 }
            org.json.JSONObject r7 = r1.f14452e     // Catch:{ Exception -> 0x0029 }
            if (r7 == 0) goto L_0x0071
            java.lang.String r8 = "config"
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0029 }
            r6.a(r8, r7)     // Catch:{ Exception -> 0x0029 }
        L_0x0071:
            java.lang.String r7 = "lrid"
            java.lang.String r8 = "rid"
            if (r0 != r4) goto L_0x011d
            boolean r0 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0029 }
            if (r0 == 0) goto L_0x011d
            com.mbridge.msdk.newreward.function.d.c r0 = com.mbridge.msdk.newreward.function.d.c.a()     // Catch:{ JSONException -> 0x0107 }
            com.mbridge.msdk.newreward.function.d.a r9 = r0.b()     // Catch:{ JSONException -> 0x0107 }
            int r10 = r1.f14454g     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r11 = r1.f14455h     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r15 = ""
            r13 = 1
            r14 = 0
            java.util.List r0 = r9.a((int) r10, (java.lang.String) r11, (java.lang.String) r12, (boolean) r13, (int) r14, (java.lang.String) r15)     // Catch:{ JSONException -> 0x0107 }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0107 }
            r9.<init>()     // Catch:{ JSONException -> 0x0107 }
            if (r0 == 0) goto L_0x010e
            int r10 = r0.size()     // Catch:{ JSONException -> 0x0107 }
            if (r10 <= 0) goto L_0x010e
            r10 = 0
        L_0x009f:
            int r11 = r0.size()     // Catch:{ JSONException -> 0x0107 }
            if (r10 >= r11) goto L_0x010e
            java.lang.Object r11 = r0.get(r10)     // Catch:{ JSONException -> 0x0107 }
            com.mbridge.msdk.newreward.function.c.a.b r11 = (com.mbridge.msdk.newreward.function.c.a.b) r11     // Catch:{ JSONException -> 0x0107 }
            if (r11 == 0) goto L_0x010a
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0107 }
            r12.<init>()     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r13 = r11.f()     // Catch:{ JSONException -> 0x0107 }
            r12.put(r8, r13)     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r13 = "ts"
            long r14 = r11.I()     // Catch:{ JSONException -> 0x0107 }
            r12.put(r13, r14)     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r13 = r11.g()     // Catch:{ JSONException -> 0x0107 }
            r12.put(r7, r13)     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r13 = "ecppv"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0107 }
            r14.<init>()     // Catch:{ JSONException -> 0x0107 }
            r15 = 1
            double r3 = r11.s()     // Catch:{ JSONException -> 0x0105 }
            r14.append(r3)     // Catch:{ JSONException -> 0x0105 }
            r14.append(r5)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r3 = r14.toString()     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.b(r3)     // Catch:{ JSONException -> 0x0105 }
            r12.put(r13, r3)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r3 = "state"
            int r4 = r11.j()     // Catch:{ JSONException -> 0x0105 }
            r12.put(r3, r4)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r3 = "showCount"
            int r4 = r11.t()     // Catch:{ JSONException -> 0x0105 }
            r12.put(r3, r4)     // Catch:{ JSONException -> 0x0105 }
            java.lang.String r3 = "interval_ts"
            long r13 = r11.q()     // Catch:{ JSONException -> 0x0105 }
            r12.put(r3, r13)     // Catch:{ JSONException -> 0x0105 }
            r9.put(r12)     // Catch:{ JSONException -> 0x0105 }
            goto L_0x010b
        L_0x0105:
            r0 = move-exception
            goto L_0x0119
        L_0x0107:
            r0 = move-exception
            r15 = 1
            goto L_0x0119
        L_0x010a:
            r15 = 1
        L_0x010b:
            int r10 = r10 + r15
            r4 = 1
            goto L_0x009f
        L_0x010e:
            r15 = 1
            java.lang.String r0 = "cache"
            java.lang.String r3 = r9.toString()     // Catch:{ JSONException -> 0x0105 }
            r6.a(r0, r3)     // Catch:{ JSONException -> 0x0105 }
            goto L_0x011e
        L_0x0119:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0029 }
            goto L_0x011e
        L_0x011d:
            r15 = 1
        L_0x011e:
            r3 = 0
            if (r2 == 0) goto L_0x0183
            int r0 = r2.size()     // Catch:{ Exception -> 0x0029 }
            if (r0 <= 0) goto L_0x0183
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0144 }
            r0.<init>()     // Catch:{ JSONException -> 0x0144 }
            r4 = 0
            java.lang.Object r9 = r2.get(r4)     // Catch:{ JSONException -> 0x0144 }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ JSONException -> 0x0144 }
            if (r9 == 0) goto L_0x0148
            java.lang.String r4 = r9.getCurrentLocalRid()     // Catch:{ JSONException -> 0x0144 }
            com.mbridge.msdk.foundation.same.report.d.d r9 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ JSONException -> 0x0142 }
            com.mbridge.msdk.foundation.same.report.d.c r3 = r9.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0142 }
            goto L_0x014a
        L_0x0142:
            r0 = move-exception
            goto L_0x017f
        L_0x0144:
            r0 = move-exception
            r4 = r22
            goto L_0x017f
        L_0x0148:
            r4 = r22
        L_0x014a:
            r5 = 0
        L_0x014b:
            int r9 = r2.size()     // Catch:{ JSONException -> 0x0142 }
            if (r5 >= r9) goto L_0x0173
            java.lang.Object r9 = r2.get(r5)     // Catch:{ JSONException -> 0x0142 }
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9     // Catch:{ JSONException -> 0x0142 }
            if (r9 == 0) goto L_0x0171
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0142 }
            r10.<init>()     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r11 = r9.getRequestId()     // Catch:{ JSONException -> 0x0142 }
            r10.put(r8, r11)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r11 = "rid_n"
            java.lang.String r9 = r9.getRequestIdNotice()     // Catch:{ JSONException -> 0x0142 }
            r10.put(r11, r9)     // Catch:{ JSONException -> 0x0142 }
            r0.put(r10)     // Catch:{ JSONException -> 0x0142 }
        L_0x0171:
            int r5 = r5 + r15
            goto L_0x014b
        L_0x0173:
            java.lang.String r2 = "c_info"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0142 }
            r6.a(r2, r0)     // Catch:{ JSONException -> 0x0142 }
        L_0x017c:
            r2 = r21
            goto L_0x0187
        L_0x017f:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0029 }
            goto L_0x017c
        L_0x0183:
            r2 = r21
            r4 = r22
        L_0x0187:
            r6.a(r8, r2)     // Catch:{ Exception -> 0x0029 }
            r6.a(r7, r4)     // Catch:{ Exception -> 0x0029 }
            if (r3 != 0) goto L_0x0194
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0029 }
            r0.<init>()     // Catch:{ Exception -> 0x0029 }
        L_0x0194:
            com.mbridge.msdk.newreward.function.command.c r0 = r1.f14457j     // Catch:{ Exception -> 0x0029 }
            com.mbridge.msdk.newreward.a.e r2 = r1.f14456i     // Catch:{ Exception -> 0x0029 }
            com.mbridge.msdk.newreward.function.command.f r3 = com.mbridge.msdk.newreward.function.command.f.METRICS_KEY_M_CANDIDATE_DB     // Catch:{ Exception -> 0x0029 }
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0029 }
            java.lang.String r5 = "metrics_data"
            r7 = 0
            r4[r7] = r5     // Catch:{ Exception -> 0x0029 }
            r4[r15] = r6     // Catch:{ Exception -> 0x0029 }
            java.util.Map r4 = r0.a((java.lang.Object[]) r4)     // Catch:{ Exception -> 0x0029 }
            r0.a((java.lang.Object) r2, (com.mbridge.msdk.newreward.function.command.f) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0029 }
            goto L_0x01af
        L_0x01ac:
            r0.printStackTrace()
        L_0x01af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.a.a.a(int, int, java.util.List, boolean, java.lang.String, java.lang.String, int, java.lang.String):void");
    }
}
