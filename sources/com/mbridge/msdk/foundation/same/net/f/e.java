package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.net.c.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f13339a = "h";

    /* renamed from: b  reason: collision with root package name */
    public static String f13340b = "i";

    /* renamed from: c  reason: collision with root package name */
    public static String f13341c = "coppa";

    /* renamed from: d  reason: collision with root package name */
    public static String f13342d = "d";

    /* renamed from: e  reason: collision with root package name */
    public static String f13343e = "e";

    /* renamed from: f  reason: collision with root package name */
    public static String f13344f = "a";

    /* renamed from: g  reason: collision with root package name */
    public static String f13345g = "f";

    /* renamed from: h  reason: collision with root package name */
    public static String f13346h = "g";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13347i = "e";

    /* renamed from: j  reason: collision with root package name */
    private Map<String, a> f13348j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    private Map<String, String> f13349k = new LinkedHashMap();

    public e() {
    }

    public final void a(String str, String str2) {
        if (str2 == null) {
            af.b(f13347i, "add() value is null!");
        }
        if (!TextUtils.isEmpty(str) && str2 != null) {
            this.f13349k.put(str, str2);
        }
    }

    public final String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : this.f13349k.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME));
                sb.append("=");
                sb.append(URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return sb.toString();
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f13349k.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME), URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
            for (Map.Entry next2 : this.f13348j.entrySet()) {
                jSONObject.put(URLEncoder.encode((String) next2.getKey(), C.UTF8_NAME), URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), C.UTF8_NAME));
            }
        } catch (JSONException e5) {
            af.b(f13347i, e5.getMessage());
        } catch (UnsupportedEncodingException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry next : this.f13349k.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), C.UTF8_NAME));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), C.UTF8_NAME));
            }
            for (Map.Entry next2 : this.f13348j.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next2.getKey(), C.UTF8_NAME));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + ((a) next2.getValue()).a().getName(), C.UTF8_NAME));
            }
        } catch (UnsupportedEncodingException e5) {
            af.b(f13347i, e5.getMessage());
        }
        return sb.toString();
    }

    public e(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                a((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public final Map<String, String> a() {
        return this.f13349k;
    }

    public final void a(String str) {
        this.f13349k.remove(str);
        this.f13348j.remove(str);
    }
}
