package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f13450a = new HashMap();

    public final void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                if (!(obj instanceof String)) {
                    Map<String, String> map = this.f13450a;
                    map.put(str, obj + "");
                } else if (!TextUtils.isEmpty((String) obj)) {
                    this.f13450a.put(str, (String) obj);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final Object b(String str) {
        return this.f13450a.get(str);
    }

    public final void c(String str) {
        if (this.f13450a != null && !TextUtils.isEmpty(str)) {
            this.f13450a.remove(str);
        }
    }

    public final boolean a(String str) {
        return this.f13450a.containsKey(str);
    }

    public final Map<String, String> a() {
        return this.f13450a;
    }

    public final void a(e eVar) {
        Map<String, String> map;
        Map<String, String> map2;
        if (eVar != null && (map = eVar.f13450a) != null && (map2 = this.f13450a) != null) {
            map2.putAll(map);
        }
    }

    public final void a(Map map) {
        if (map != null && map.size() > 0) {
            this.f13450a.putAll(map);
        }
    }
}
