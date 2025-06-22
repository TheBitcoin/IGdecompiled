package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f16967a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, c> f16968b;

    /* renamed from: c  reason: collision with root package name */
    private long f16969c;

    /* renamed from: d  reason: collision with root package name */
    private long f16970d;

    /* renamed from: e  reason: collision with root package name */
    private long f16971e;

    /* renamed from: f  reason: collision with root package name */
    private long f16972f;

    /* renamed from: g  reason: collision with root package name */
    private long f16973g;

    /* renamed from: h  reason: collision with root package name */
    private long f16974h;

    /* renamed from: i  reason: collision with root package name */
    private int f16975i = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f16976j;

    /* renamed from: k  reason: collision with root package name */
    private String f16977k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f16978l = "";

    public final String a() {
        return this.f16977k;
    }

    public final String b() {
        return this.f16976j;
    }

    public final String c() {
        return this.f16978l;
    }

    public final long d() {
        return this.f16969c * 1000;
    }

    public final long e() {
        return this.f16970d * 1000;
    }

    public final long f() {
        return this.f16971e * 1000;
    }

    public final long g() {
        return this.f16972f;
    }

    public final long h() {
        return this.f16973g;
    }

    public final long i() {
        return this.f16974h;
    }

    public final Map<String, c> j() {
        return this.f16968b;
    }

    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f16967a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry next : this.f16967a.entrySet()) {
                        jSONObject2.put((String) next.getKey(), ((Integer) next.getValue()).intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            Map<String, c> map2 = this.f16968b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next2 : this.f16968b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String str = (String) next2.getKey();
                        c cVar = (c) next2.getValue();
                        if (cVar != null) {
                            jSONObject3.put(RewardPlus.NAME, cVar.a());
                            jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                            jSONObject3.put("id", str);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f16969c);
            jSONObject.put("ruct", this.f16970d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f16971e);
            jSONObject.put("dlct", this.f16972f);
            jSONObject.put("vcct", this.f16973g);
            jSONObject.put("current_time", this.f16974h);
            jSONObject.put("vtag", this.f16977k);
            jSONObject.put("isDefault", this.f16975i);
            return jSONObject;
        } catch (Exception e7) {
            e7.printStackTrace();
            return jSONObject;
        }
    }

    public final void a(long j4) {
        this.f16969c = j4;
    }

    public final void b(long j4) {
        this.f16970d = j4;
    }

    public final void c(long j4) {
        this.f16971e = j4;
    }

    public final void d(long j4) {
        this.f16972f = j4;
    }

    public final void e(long j4) {
        this.f16973g = j4;
    }

    public final void a(Map<String, Integer> map) {
        this.f16967a = map;
    }

    public final void b(Map<String, c> map) {
        this.f16968b = map;
    }

    public final void a(int i4) {
        this.f16975i = i4;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.f16976j = jSONObject.optString("ab_id", "");
                    aVar2.f16978l = jSONObject.optString("rid", "");
                    if (optJSONObject != null && optJSONObject.length() > 0) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            int optInt = optJSONObject.optInt(next, 1000);
                            if (!TextUtils.isEmpty(next)) {
                                if (TextUtils.isEmpty(next) || optInt != 0) {
                                    hashMap.put(next, Integer.valueOf(optInt));
                                } else {
                                    hashMap.put(next, 1000);
                                }
                            }
                        }
                        aVar2.f16967a = hashMap;
                    }
                    aVar2.f16968b = c.a(jSONObject.optJSONArray("reward"));
                    aVar2.f16969c = jSONObject.optLong("getpf", 43200);
                    aVar2.f16970d = jSONObject.optLong("ruct", 5400);
                    aVar2.f16971e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600);
                    aVar2.f16972f = jSONObject.optLong("dlct", 3600);
                    aVar2.f16973g = jSONObject.optLong("vcct", 5);
                    aVar2.f16974h = jSONObject.optLong("current_time");
                    aVar2.f16977k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e5) {
                    e = e5;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return aVar;
            }
        }
        return aVar;
    }
}
