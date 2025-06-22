package com.mbridge.msdk.newreward.a.b;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.c.b.f;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.mbridge.msdk.newreward.function.f.d;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.network.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private String f14339a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f14340a;

        /* renamed from: b  reason: collision with root package name */
        private final b f14341b;

        public a(com.mbridge.msdk.foundation.c.b bVar, b bVar2) {
            this.f14340a = bVar;
            this.f14341b = bVar2;
        }

        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            b bVar2 = this.f14341b;
            if (bVar2 != null && (bVar = this.f14340a) != null) {
                bVar2.reqFailed(bVar);
            }
        }
    }

    private static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f14344a;

        /* renamed from: b  reason: collision with root package name */
        private JSONObject f14345b;

        /* renamed from: c  reason: collision with root package name */
        private final b f14346c;

        public c(String str, JSONObject jSONObject, b bVar) {
            this.f14344a = str;
            this.f14345b = jSONObject;
            this.f14346c = bVar;
        }

        public final void run() {
            com.mbridge.msdk.videocommon.d.c cVar;
            if (this.f14346c != null && this.f14345b != null) {
                try {
                    String k4 = com.mbridge.msdk.foundation.controller.c.m().k();
                    if (ak.a(this.f14345b)) {
                        JSONObject optJSONObject = this.f14345b.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        this.f14345b = optJSONObject;
                        if (optJSONObject != null) {
                            if (optJSONObject.optInt("vtag_status", 0) == 1) {
                                String e5 = com.mbridge.msdk.videocommon.d.b.a().e(k4, this.f14344a);
                                if (!TextUtils.isEmpty(e5)) {
                                    this.f14345b = h.a().a(new JSONObject(e5), this.f14345b);
                                }
                            }
                            if (com.mbridge.msdk.videocommon.d.b.e(this.f14345b.toString())) {
                                this.f14345b.put("current_time", System.currentTimeMillis());
                                com.mbridge.msdk.videocommon.d.b.a().a(k4, this.f14344a, this.f14345b.toString());
                            }
                            cVar = com.mbridge.msdk.videocommon.d.c.c(this.f14345b.toString());
                            this.f14346c.reqSuccessful(cVar);
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().d(k4, this.f14344a);
                    }
                    cVar = null;
                    this.f14346c.reqSuccessful(cVar);
                } catch (Throwable th) {
                    af.b("ReqRewardUnitSettingService", th.getMessage());
                }
            }
        }
    }

    public final void a(Object obj, b bVar) throws IOException {
        String str;
        int i4;
        int d5;
        String str2;
        if (obj != null) {
            d dVar = (d) obj;
            String k4 = com.mbridge.msdk.foundation.controller.c.m().k();
            this.f14339a = dVar.b();
            dVar.b(com.mbridge.msdk.newreward.function.c.b.h.f14559b);
            if (!com.mbridge.msdk.videocommon.d.b.a().d(this.f14339a)) {
                com.mbridge.msdk.videocommon.d.b.a().a(this.f14339a);
                try {
                    com.mbridge.msdk.videocommon.d.c f4 = com.mbridge.msdk.videocommon.d.b.a().f(k4, this.f14339a);
                    if (f4 == null) {
                        str2 = "";
                    } else {
                        str2 = f4.j();
                    }
                    dVar.b(str2);
                } catch (Throwable th) {
                    af.b("ReqRewardUnitSettingService", th.getMessage());
                }
                try {
                    if (com.mbridge.msdk.foundation.same.net.e.d.f().f13328r) {
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().f13294J;
                    } else {
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().f13293I;
                    }
                    if (com.mbridge.msdk.foundation.same.net.e.d.f().f13328r) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uri", str);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, dVar.d());
                        e.a().a(com.mbridge.msdk.foundation.same.net.e.d.f().f13322l, com.mbridge.msdk.foundation.same.net.e.d.f().f13326p, jSONObject.toString(), true, new b(this.f14339a, bVar));
                        return;
                    }
                    com.mbridge.msdk.newreward.function.c.b.h hVar = new com.mbridge.msdk.newreward.function.c.b.h(str);
                    hVar.a(dVar.c());
                    hVar.a((com.mbridge.msdk.newreward.function.c.b.e) new b(this.f14339a, bVar));
                    byte[] p4 = hVar.p();
                    if (p4 != null) {
                        i4 = p4.length;
                    } else {
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.mbridge.msdk.foundation.same.net.f.e.f13346h, String.valueOf(i4));
                    hVar.a((Map<String, String>) hashMap);
                    if (p4 != null && (d5 = com.mbridge.msdk.foundation.same.net.e.d.f().d()) > 0 && i4 > d5) {
                        hVar.a(1);
                        hVar.a("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                    }
                    f.a().a((u<JSONObject>) hVar);
                } catch (Exception e5) {
                    throw new IOException(e5);
                }
            }
        } else {
            throw new IOException("ReqRewardUnitSettingService doReq: params is null");
        }
    }

    private static final class b implements com.mbridge.msdk.foundation.same.net.b<JSONObject>, com.mbridge.msdk.newreward.function.c.b.e {

        /* renamed from: a  reason: collision with root package name */
        private final String f14342a;

        /* renamed from: b  reason: collision with root package name */
        private final b f14343b;

        public b(String str, b bVar) {
            this.f14342a = str;
            this.f14343b = bVar;
        }

        public final void a(JSONObject jSONObject, u<JSONObject> uVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f14342a);
            MBridgeTaskManager.commonExecute(new c(this.f14342a, jSONObject, this.f14343b));
        }

        public final void onError(com.mbridge.msdk.foundation.same.net.a.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f14342a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f14343b));
        }

        public final void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f14342a);
            MBridgeTaskManager.commonExecute(new c(this.f14342a, (JSONObject) dVar.f13256c, this.f14343b));
        }

        public final void a(u<JSONObject> uVar, com.mbridge.msdk.newreward.function.c.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f14342a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f14343b));
        }
    }
}
