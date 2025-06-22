package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f13484a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13485b;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, String> f13486a = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f13487b;

        public a(String str) {
            this.f13487b = str;
        }

        public final k a() {
            return new k(this);
        }
    }

    private String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(this.f13485b)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, this.f13485b);
                a(this.f13484a, jSONObject);
                d.a().a(jSONObject);
            } catch (Throwable th) {
                af.b("SameCommonReporter", th.getMessage());
            }
        }
    }

    private k(a aVar) {
        this.f13485b = aVar.f13487b;
        this.f13484a = aVar.f13486a;
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        if (map != null && !map.isEmpty() && jSONObject != null) {
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, b(map.get(next)));
                }
            } catch (Exception e5) {
                af.b("SameCommonReporter", e5.getMessage());
            }
        }
    }
}
