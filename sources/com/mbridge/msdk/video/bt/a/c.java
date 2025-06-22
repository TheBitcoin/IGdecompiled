package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.bt.a.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    int f15757a;

    /* renamed from: b  reason: collision with root package name */
    int f15758b;

    /* renamed from: c  reason: collision with root package name */
    private String f15759c;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static c f15760a = new c();
    }

    public static c a() {
        return a.f15760a;
    }

    private c() {
        this.f15759c = "handlerNativeResult";
        this.f15757a = 0;
        this.f15758b = 1;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String optString = jSONObject.optString("uniqueIdentifier");
                    String optString2 = jSONObject.optString(RewardPlus.NAME);
                    if (!TextUtils.isEmpty(optString)) {
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            int i4 = 0;
                            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.toString())) {
                                i4 = optJSONObject.optInt("type", 0);
                            }
                            a(this.f15757a, "receivedMessage", obj);
                            if (optString.equalsIgnoreCase("reporter")) {
                                com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, optString2, optJSONArray, i4);
                                return;
                            } else if (optString.equalsIgnoreCase("MediaPlayer")) {
                                b unused = b.a.f15756a;
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    a(this.f15758b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e5) {
                af.a("HandlerH5MessageManager", e5.getMessage());
                a(this.f15758b, e5.getMessage(), obj);
                return;
            } catch (Throwable th) {
                af.a("HandlerH5MessageManager", th.getMessage());
                a(this.f15758b, th.getMessage(), obj);
                return;
            }
        }
        a(this.f15758b, "params is null", obj);
    }

    private void a(int i4, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e5) {
            af.a("HandlerH5MessageManager", e5.getMessage());
        } catch (Throwable th) {
            af.a("HandlerH5MessageManager", th.getMessage());
        }
    }
}
