package com.mbridge.msdk.newreward.function.c.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ac;
import com.mbridge.msdk.tracker.network.ad;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.y;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h extends u<JSONObject> implements w.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f14558a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f14559b = 1;

    /* renamed from: c  reason: collision with root package name */
    private e f14560c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, String> f14561d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f14562e;

    public h(String str) {
        super(0, str, 0, "setting");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        e eVar = this.f14560c;
        if (eVar != null) {
            if (jSONObject == null) {
                try {
                    eVar.a((u<JSONObject>) this, new d(-1));
                } catch (Exception e5) {
                    af.b("RewardSettingRequest", "onError Exception: ", e5);
                }
            } else {
                eVar.a(jSONObject, (u<JSONObject>) this);
            }
        }
    }

    public final Map<String, String> c() {
        Map<String, String> map = this.f14562e;
        if (map == null) {
            HashMap hashMap = new HashMap();
            this.f14562e = hashMap;
            return hashMap;
        }
        map.put("Charset", C.UTF8_NAME);
        return this.f14562e;
    }

    public final boolean d() {
        return true;
    }

    public final void a(e eVar) {
        this.f14560c = eVar;
    }

    public final void a(Map<String, String> map) {
        if (this.f14561d == null) {
            this.f14561d = new HashMap<>();
        }
        if (map != null && !map.isEmpty()) {
            this.f14561d.putAll(map);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f14561d == null) {
            this.f14561d = new HashMap<>();
        }
        return this.f14561d;
    }

    /* access modifiers changed from: protected */
    public final w<JSONObject> a(r rVar) {
        if (rVar != null) {
            try {
                byte[] bArr = rVar.f15601b;
                if (bArr != null) {
                    if (bArr.length != 0) {
                        return w.a(new JSONObject(new String(bArr, f.a(rVar.f15602c))), f.a(rVar));
                    }
                }
            } catch (UnsupportedEncodingException e5) {
                af.b("RewardSettingRequest", "parseNetworkResponse UnsupportedEncodingException: ", e5);
                return w.a(new com.mbridge.msdk.tracker.network.f(e5));
            } catch (Exception e6) {
                af.b("RewardSettingRequest", "parseNetworkResponse Exception: ", e6);
                return w.a(new ac((Throwable) e6));
            }
        }
        return w.a(new y());
    }

    public final void a(String str, String str2) {
        if (this.f14562e == null) {
            this.f14562e = new HashMap();
        }
        this.f14562e.put(str, str2);
    }

    public final void a(ad adVar) {
        this.f14560c.a((u<JSONObject>) this, new d(-1, adVar.getMessage()));
    }
}
