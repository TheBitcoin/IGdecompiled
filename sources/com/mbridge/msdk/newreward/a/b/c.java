package com.mbridge.msdk.newreward.a.b;

import android.os.SystemClock;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.b.f;
import com.mbridge.msdk.newreward.function.c.b.i;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.IOException;
import java.util.Map;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f14285a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f14286a;

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.b.b f14287b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f14288c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14289d;

        /* renamed from: e  reason: collision with root package name */
        private final b f14290e;

        /* renamed from: f  reason: collision with root package name */
        private final String f14291f;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.b bVar2, boolean z4, int i4, b bVar3, String str) {
            this.f14286a = bVar;
            this.f14287b = bVar2;
            this.f14288c = z4;
            this.f14289d = i4;
            this.f14290e = bVar3;
            this.f14291f = str;
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x00dd  */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.foundation.c.b a(int r11) {
            /*
                r10 = this;
                java.lang.String r0 = "load exception with no mCampaignRequestError"
                r1 = 0
                r2 = 0
                r3 = 880002(0xd6d82, float:1.233145E-39)
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                if (r4 == 0) goto L_0x00db
                int r4 = r4.c()     // Catch:{ Exception -> 0x003f }
                r5 = 9
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                if (r4 != r5) goto L_0x0042
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                int r2 = r4.a()     // Catch:{ Exception -> 0x003f }
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                java.lang.String r0 = r4.b()     // Catch:{ Exception -> 0x003f }
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                int r3 = r4.c()     // Catch:{ Exception -> 0x003f }
                r4 = -1
                if (r3 != r4) goto L_0x0031
                r3 = 880017(0xd6d91, float:1.233166E-39)
                goto L_0x0034
            L_0x0031:
                r3 = 880003(0xd6d83, float:1.233147E-39)
            L_0x0034:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                java.lang.String r4 = r4.f()     // Catch:{ Exception -> 0x003f }
                r5 = 1
                r9 = r7
                r7 = r4
                r4 = r9
                goto L_0x009e
            L_0x003f:
                r11 = move-exception
                goto L_0x00d8
            L_0x0042:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                int r4 = r4.c()     // Catch:{ Exception -> 0x003f }
                r5 = 10
                if (r4 != r5) goto L_0x0064
                r4 = 880023(0xd6d97, float:1.233175E-39)
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f14287b     // Catch:{ Exception -> 0x005e }
                java.lang.String r0 = r5.d()     // Catch:{ Exception -> 0x005e }
                r4 = r7
                r2 = 880023(0xd6d97, float:1.233175E-39)
                r3 = 880023(0xd6d97, float:1.233175E-39)
            L_0x005c:
                r5 = 0
                goto L_0x009e
            L_0x005e:
                r11 = move-exception
                r2 = 880023(0xd6d97, float:1.233175E-39)
                goto L_0x00d8
            L_0x0064:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                int r4 = r4.c()     // Catch:{ Exception -> 0x003f }
                switch(r4) {
                    case 1: goto L_0x0074;
                    case 2: goto L_0x0071;
                    case 3: goto L_0x0074;
                    case 4: goto L_0x0074;
                    case 5: goto L_0x0074;
                    case 6: goto L_0x006d;
                    case 7: goto L_0x0071;
                    case 8: goto L_0x0074;
                    default: goto L_0x006d;
                }     // Catch:{ Exception -> 0x003f }
            L_0x006d:
                r3 = 880020(0xd6d94, float:1.23317E-39)
                goto L_0x0074
            L_0x0071:
                r3 = 880003(0xd6d83, float:1.233147E-39)
            L_0x0074:
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch:{ Exception -> 0x003f }
                if (r4 == 0) goto L_0x009c
                com.mbridge.msdk.newreward.function.c.b.b r4 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                com.mbridge.msdk.tracker.network.ad r4 = r4.e()     // Catch:{ Exception -> 0x003f }
                int r4 = r4.b()     // Catch:{ Exception -> 0x003f }
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f14287b     // Catch:{ Exception -> 0x0099 }
                com.mbridge.msdk.tracker.network.ad r5 = r5.e()     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = r5.c()     // Catch:{ Exception -> 0x0099 }
                com.mbridge.msdk.newreward.function.c.b.b r5 = r10.f14287b     // Catch:{ Exception -> 0x0099 }
                java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x0099 }
                r2 = r4
                r4 = r5
                goto L_0x005c
            L_0x0099:
                r11 = move-exception
                r2 = r4
                goto L_0x00d8
            L_0x009c:
                r4 = r7
                goto L_0x005c
            L_0x009e:
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)     // Catch:{ Exception -> 0x003f }
                java.lang.String r6 = "can_retry"
                boolean r8 = r10.f14288c     // Catch:{ Exception -> 0x003f }
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x003f }
                r1.a(r6, r8)     // Catch:{ Exception -> 0x003f }
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x003f }
                r1.a(r6, r11)     // Catch:{ Exception -> 0x003f }
                java.lang.String r11 = "campaign_request_error"
                com.mbridge.msdk.newreward.function.c.b.b r6 = r10.f14287b     // Catch:{ Exception -> 0x003f }
                r1.a(r11, r6)     // Catch:{ Exception -> 0x003f }
                r1.b((boolean) r5)     // Catch:{ Exception -> 0x003f }
                boolean r11 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x003f }
                if (r11 != 0) goto L_0x00c9
                r1.e(r7)     // Catch:{ Exception -> 0x003f }
            L_0x00c9:
                boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003f }
                if (r11 != 0) goto L_0x00d2
                r1.f(r4)     // Catch:{ Exception -> 0x003f }
            L_0x00d2:
                java.lang.String r11 = r10.f14291f     // Catch:{ Exception -> 0x003f }
                r1.d(r11)     // Catch:{ Exception -> 0x003f }
                goto L_0x00db
            L_0x00d8:
                r11.printStackTrace()
            L_0x00db:
                if (r1 != 0) goto L_0x00e1
                com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
            L_0x00e1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.c.a.a(int):com.mbridge.msdk.foundation.c.b");
        }

        public final void run() {
            b bVar = this.f14290e;
            if (bVar != null && this.f14287b != null) {
                try {
                    bVar.reqFailed(a(this.f14289d));
                } catch (Exception e5) {
                    af.b("ReqCampaignService", "run: ", e5);
                }
            }
        }
    }

    private static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f14292a;

        /* renamed from: b  reason: collision with root package name */
        private final b f14293b;

        public b(com.mbridge.msdk.newreward.function.c.a.b bVar, b bVar2) {
            this.f14292a = bVar;
            this.f14293b = bVar2;
        }

        public final void run() {
            com.mbridge.msdk.newreward.function.c.a.b bVar;
            b bVar2 = this.f14293b;
            if (bVar2 != null && (bVar = this.f14292a) != null) {
                try {
                    bVar2.reqSuccessful(bVar);
                } catch (Exception e5) {
                    af.b("ReqCampaignService", "run: ", e5);
                }
            }
        }
    }

    /* renamed from: com.mbridge.msdk.newreward.a.b.c$c  reason: collision with other inner class name */
    private static class C0191c implements com.mbridge.msdk.newreward.function.c.b.c {

        /* renamed from: a  reason: collision with root package name */
        private final b f14294a;

        public C0191c(b bVar) {
            this.f14294a = bVar;
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            MBridgeTaskManager.commonExecute(new b(bVar, this.f14294a));
        }

        public final void b(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, true, 401, this.f14294a, aVar.k()));
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, 402, this.f14294a, aVar.k()));
        }

        public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j4, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, this.f14294a, aVar.k()));
        }
    }

    public c(e eVar) {
        this.f14285a = eVar;
    }

    public final void a(Object obj, b bVar) throws IOException {
        int i4;
        int d5;
        if (obj != null) {
            try {
                long p4 = this.f14285a.p();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (p4 <= 0) {
                    this.f14285a.c(elapsedRealtime);
                    p4 = elapsedRealtime;
                }
                com.mbridge.msdk.newreward.function.f.e eVar = (com.mbridge.msdk.newreward.function.f.e) obj;
                int b5 = eVar.b();
                String c5 = eVar.c();
                String d6 = eVar.d();
                String e5 = eVar.e();
                Map<String, String> f4 = eVar.f();
                i iVar = new i(b5, c5, d6, Math.max(((long) this.f14285a.P()) - (elapsedRealtime - p4), 0), e5);
                iVar.a(f4);
                iVar.b(this.f14285a.G());
                iVar.a((com.mbridge.msdk.newreward.function.c.b.c) new C0191c(bVar));
                byte[] p5 = iVar.p();
                if (p5 != null) {
                    i4 = p5.length;
                } else {
                    i4 = 0;
                }
                iVar.a(com.mbridge.msdk.foundation.same.net.f.e.f13346h, String.valueOf(i4));
                if (p5 != null && (d5 = d.f().d()) > 0 && i4 > d5) {
                    iVar.a(1);
                    iVar.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                }
                f.a().a((com.mbridge.msdk.newreward.function.c.b.a) iVar);
            } catch (Exception e6) {
                throw new IOException(e6);
            }
        } else {
            throw new IOException("ReqCampaignService doReq: params is null");
        }
    }
}
