package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.e;
import com.mbridge.msdk.tracker.m;
import java.net.URLEncoder;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f13472a;

    /* renamed from: b  reason: collision with root package name */
    private volatile m f13473b;

    public static f a() {
        if (f13472a == null) {
            synchronized (f.class) {
                try {
                    if (f13472a == null) {
                        f13472a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13472a;
    }

    public final void b() {
        if (this.f13473b != null) {
            this.f13473b.f();
        }
    }

    public final void c() {
        d().f();
    }

    public final m d() {
        if (this.f13473b == null) {
            this.f13473b = d.a().c();
        }
        return this.f13473b;
    }

    public final void a(Context context, String str, String str2, String str3, String str4, int i4) {
        m d5 = a().d();
        if (d5 != null) {
            if (!d5.a("2000105")) {
                af.a("MetricsReportUtil", "reportClickImpException can not track");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(str2)) {
                    jSONObject.put("url", "");
                } else {
                    jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
                }
                jSONObject.put("type", i4);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("rid", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("rid_n", str4);
                }
                try {
                    long[] h4 = d5.h();
                    jSONObject.put("track_time", h4[0]);
                    jSONObject.put("track_count", h4[1]);
                    jSONObject.put("session_id", d5.b());
                } catch (Exception unused) {
                }
                jSONObject.put("reason", URLEncoder.encode(str, "utf-8"));
                e eVar = new e("2000105");
                eVar.a(jSONObject);
                eVar.b(0);
                eVar.a(0);
                eVar.a(c.c());
                d5.a(eVar);
            } catch (Exception e5) {
                af.b("MetricsReportUtil", e5.getMessage());
            }
        }
    }
}
