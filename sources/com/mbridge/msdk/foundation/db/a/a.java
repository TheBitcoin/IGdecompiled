package com.mbridge.msdk.foundation.db.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12881a = "FrequencyDaoMiddle";

    /* renamed from: b  reason: collision with root package name */
    private static a f12882b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f12883c = "FrequencyDaoMiddle";

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f12884d = new JSONArray();

    private a() {
        try {
            String str = (String) an.a(c.m().c(), f12883c, f12884d.toString());
            if (!TextUtils.isEmpty(str)) {
                f12884d = new JSONArray(str);
            }
        } catch (Exception e5) {
            af.b(f12881a, e5.getMessage());
        }
    }

    public static a a() {
        if (f12882b == null) {
            synchronized (a.class) {
                try {
                    if (f12882b == null) {
                        f12882b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12882b;
    }

    private void c() {
        try {
            if (f12884d != null) {
                an.b(c.m().c(), f12883c, f12884d.toString());
            }
        } catch (Exception e5) {
            af.b(f12881a, e5.getMessage());
        }
    }

    public final String[] b() {
        ArrayList arrayList = new ArrayList();
        if (f12884d != null) {
            for (int i4 = 0; i4 < f12884d.length(); i4++) {
                try {
                    JSONObject jSONObject = f12884d.getJSONObject(i4);
                    if (jSONObject != null && jSONObject.optInt("fc_a") < jSONObject.optInt("impression_count")) {
                        arrayList.add(jSONObject.optString("id"));
                    }
                } catch (JSONException e5) {
                    af.b(f12881a, e5.getMessage());
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            strArr[i5] = (String) arrayList.get(i5);
        }
        return strArr;
    }

    public final void a(g gVar) {
        JSONObject a5;
        if (gVar != null && (a5 = a(gVar.a(), gVar.c(), gVar.d(), gVar.f(), gVar.e(), gVar.b())) != null) {
            if (f12884d == null) {
                f12884d = new JSONArray();
            }
            f12884d.put(a5);
            c();
        }
    }

    public final void a(String str) {
        if (f12884d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < f12884d.length(); i4++) {
                try {
                    JSONObject jSONObject = f12884d.getJSONObject(i4);
                    if (jSONObject != null) {
                        if (jSONObject.optString("id", "").equals(str)) {
                            jSONObject.put("impression_count", jSONObject.optInt("impression_count", 0) + 1);
                            jSONArray.put(jSONObject);
                        } else {
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e5) {
                    af.b(f12881a, e5.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f12884d = jSONArray;
            }
            c();
        }
    }

    public final void a(long j4) {
        if (f12884d != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < f12884d.length(); i4++) {
                try {
                    JSONObject jSONObject = f12884d.getJSONObject(i4);
                    if (jSONObject != null && ((long) jSONObject.optInt(CampaignEx.JSON_KEY_ST_TS)) >= j4) {
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e5) {
                    af.b(f12881a, e5.getMessage());
                }
            }
            if (jSONArray.length() > 0) {
                f12884d = jSONArray;
            }
        }
        c();
    }

    private JSONObject a(String str, int i4, int i5, long j4, int i6, int i7) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", str);
                jSONObject2.put("fc_a", i4);
                jSONObject2.put("fc_b", i5);
                jSONObject2.put(CampaignEx.JSON_KEY_ST_TS, j4);
                jSONObject2.put("impression_count", i6);
                jSONObject2.put("click_count", i7);
                return jSONObject2;
            } catch (Exception e5) {
                e = e5;
                jSONObject = jSONObject2;
                af.b(f12881a, e.getMessage());
                return jSONObject;
            }
        } catch (Exception e6) {
            e = e6;
            af.b(f12881a, e.getMessage());
            return jSONObject;
        }
    }
}
