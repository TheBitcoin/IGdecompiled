package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.i;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends d {

    /* renamed from: o  reason: collision with root package name */
    public boolean f16617o = true;

    private a q() {
        if (this.f16587l == null) {
            this.f16587l = new a(c.m().c(), this.f16585j);
        }
        return this.f16587l;
    }

    public final void a(JSONObject jSONObject) {
        try {
            jSONObject.put("device", new i(c.m().c()).a());
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r4, android.content.Context r5) {
        /*
            r3 = this;
            java.lang.String r5 = r4.getNoticeUrl()
            r0 = 0
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.f13139m     // Catch:{ all -> 0x001a }
            java.lang.String r5 = r5.getQueryParameter(r1)     // Catch:{ all -> 0x001a }
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x001b
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
        L_0x001b:
            r5 = 0
        L_0x001c:
            com.mbridge.msdk.video.signal.a$a r1 = r3.f16588m
            r2 = 2
            if (r5 != r2) goto L_0x0022
            r0 = 1
        L_0x0022:
            r1.a(r0)
            com.mbridge.msdk.click.a r5 = r3.q()
            com.mbridge.msdk.video.signal.a$a r0 = r3.f16588m
            r5.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r0)
            com.mbridge.msdk.click.a r5 = r3.q()
            r5.a((com.mbridge.msdk.foundation.entity.CampaignEx) r4)
            com.mbridge.msdk.foundation.controller.c r5 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r5 = r5.c()
            com.mbridge.msdk.video.module.b.b.d(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.l.a(com.mbridge.msdk.foundation.entity.CampaignEx, android.content.Context):void");
    }
}
