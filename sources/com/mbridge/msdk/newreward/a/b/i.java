package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.b.c;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;

public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final e f14324a;

    public i(e eVar) {
        this.f14324a = eVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r6 = com.mbridge.msdk.foundation.same.net.e.d.f().f13297M;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00dc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r21, com.mbridge.msdk.newreward.a.b.b r22) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = r22
            java.lang.String r0 = "mcd"
            java.lang.String r3 = "oneId"
            r4 = 880001(0xd6d81, float:1.233144E-39)
            if (r21 != 0) goto L_0x001a
            if (r2 == 0) goto L_0x0155
            com.mbridge.msdk.foundation.c.b r0 = new com.mbridge.msdk.foundation.c.b
            java.lang.String r3 = "ReqMoreOfferService doReq: params is null"
            r0.<init>(r4, r3)
            r2.reqFailed(r0)
            return
        L_0x001a:
            com.mbridge.msdk.newreward.a.e r5 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            long r5 = r5.p()     // Catch:{ Exception -> 0x0031 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0031 }
            r9 = 0
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 > 0) goto L_0x0034
            com.mbridge.msdk.newreward.a.e r5 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            r5.c((long) r7)     // Catch:{ Exception -> 0x0031 }
            r5 = r7
            goto L_0x0034
        L_0x0031:
            r0 = move-exception
            goto L_0x0136
        L_0x0034:
            r11 = r21
            com.mbridge.msdk.newreward.function.f.b r11 = (com.mbridge.msdk.newreward.function.f.b) r11     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            int r14 = r12.h()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            java.lang.String r15 = r12.C()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            java.lang.String r16 = r12.H()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r12 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            int r12 = r12.P()     // Catch:{ Exception -> 0x0031 }
            long r12 = (long) r12     // Catch:{ Exception -> 0x0031 }
            long r7 = r7 - r5
            long r12 = r12 - r7
            java.util.Map r5 = r11.b()     // Catch:{ Exception -> 0x0031 }
            if (r5 == 0) goto L_0x012b
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0031 }
            if (r6 == 0) goto L_0x0061
            goto L_0x012b
        L_0x0061:
            com.mbridge.msdk.foundation.same.net.e.d r6 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r6.f13297M     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.e r7 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.function.e.a r7 = r7.D()     // Catch:{ Exception -> 0x0031 }
            r8 = 0
            if (r7 == 0) goto L_0x00d9
            com.mbridge.msdk.newreward.a.e r7 = r1.f14324a     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.function.e.a r7 = r7.D()     // Catch:{ Exception -> 0x0031 }
            java.util.List r7 = r7.a()     // Catch:{ Exception -> 0x0031 }
            if (r7 == 0) goto L_0x00d9
            boolean r11 = r7.isEmpty()     // Catch:{ Exception -> 0x0031 }
            if (r11 != 0) goto L_0x00d9
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00dc }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x00dc }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = r7.getReq_ext_data()     // Catch:{ Exception -> 0x00dc }
            r11.<init>(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = "mof_domain"
            java.lang.String r7 = r11.optString(r7)     // Catch:{ Exception -> 0x00dc }
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r17 != 0) goto L_0x00ae
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00dc }
            r6.<init>()     // Catch:{ Exception -> 0x00dc }
            r6.append(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r7 = "/openapi/ad/v3"
            r6.append(r7)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00dc }
        L_0x00ae:
            java.lang.String r7 = "parent_id"
            java.lang.String r7 = r11.optString(r7)     // Catch:{ Exception -> 0x00dc }
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r17 != 0) goto L_0x00bf
            java.lang.String r8 = "mof_parent_id"
            r5.put(r8, r7)     // Catch:{ Exception -> 0x00dc }
        L_0x00bf:
            java.lang.String r7 = r11.optString(r3)     // Catch:{ Exception -> 0x00dc }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00dc }
            if (r8 != 0) goto L_0x00cc
            r5.put(r3, r7)     // Catch:{ Exception -> 0x00dc }
        L_0x00cc:
            java.lang.String r3 = r11.optString(r0)     // Catch:{ Exception -> 0x00dc }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00dc }
            if (r7 != 0) goto L_0x00d9
            r5.put(r0, r3)     // Catch:{ Exception -> 0x00dc }
        L_0x00d9:
            r19 = r6
            goto L_0x00e3
        L_0x00dc:
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r0.f13297M     // Catch:{ Exception -> 0x0031 }
            goto L_0x00d9
        L_0x00e3:
            com.mbridge.msdk.newreward.function.c.b.g r0 = new com.mbridge.msdk.newreward.function.c.b.g     // Catch:{ Exception -> 0x0031 }
            long r17 = java.lang.Math.max(r12, r9)     // Catch:{ Exception -> 0x0031 }
            r13 = r0
            r13.<init>(r14, r15, r16, r17, r19)     // Catch:{ Exception -> 0x0031 }
            r13.a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.newreward.a.b.i$a r0 = new com.mbridge.msdk.newreward.a.b.i$a     // Catch:{ Exception -> 0x0031 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0031 }
            r13.a((com.mbridge.msdk.newreward.function.c.b.c) r0)     // Catch:{ Exception -> 0x0031 }
            byte[] r0 = r13.p()     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0100
            int r8 = r0.length     // Catch:{ Exception -> 0x0031 }
            goto L_0x0101
        L_0x0100:
            r8 = 0
        L_0x0101:
            java.lang.String r3 = com.mbridge.msdk.foundation.same.net.f.e.f13346h     // Catch:{ Exception -> 0x0031 }
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0031 }
            r13.a(r3, r5)     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0123
            com.mbridge.msdk.foundation.same.net.e.d r0 = com.mbridge.msdk.foundation.same.net.e.d.f()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.d()     // Catch:{ Exception -> 0x0031 }
            if (r0 <= 0) goto L_0x0123
            if (r8 <= r0) goto L_0x0123
            r0 = 1
            r13.a((int) r0)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r13.b(r0, r3)     // Catch:{ Exception -> 0x0031 }
        L_0x0123:
            com.mbridge.msdk.newreward.function.c.b.f r0 = com.mbridge.msdk.newreward.function.c.b.f.a()     // Catch:{ Exception -> 0x0031 }
            r0.a((com.mbridge.msdk.newreward.function.c.b.a) r13)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0155
        L_0x012b:
            com.mbridge.msdk.foundation.c.b r0 = new com.mbridge.msdk.foundation.c.b     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = "ReqMoreOfferService doReq: MoreOfferReqParameters is null"
            r0.<init>(r4, r3)     // Catch:{ Exception -> 0x0031 }
            r2.reqFailed(r0)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0136:
            if (r2 == 0) goto L_0x0155
            com.mbridge.msdk.foundation.c.b r3 = new com.mbridge.msdk.foundation.c.b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "ReqMoreOfferService doReq: parse "
            r5.append(r6)
            java.lang.String r0 = r0.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r3.<init>(r4, r0)
            r2.reqFailed(r3)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.i.a(java.lang.Object, com.mbridge.msdk.newreward.a.b.b):void");
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final b f14325a;

        public a(b bVar) {
            this.f14325a = bVar;
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar) {
            b bVar2 = this.f14325a;
            if (bVar2 != null) {
                bVar2.reqSuccessful(bVar);
            }
        }

        public final void b(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f14325a != null) {
                this.f14325a.reqFailed(a(bVar2, 401, aVar.k()));
            }
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f14325a != null) {
                this.f14325a.reqFailed(a(bVar2, 402, aVar.k()));
            }
        }

        public final void a(b bVar, com.mbridge.msdk.newreward.function.c.b.a aVar, long j4, com.mbridge.msdk.newreward.function.c.b.b bVar2) {
            if (this.f14325a != null) {
                this.f14325a.reqFailed(a(bVar2, (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT, aVar.k()));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6  */
        /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.foundation.c.b a(com.mbridge.msdk.newreward.function.c.b.b r10, int r11, java.lang.String r12) {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                r2 = 880002(0xd6d82, float:1.233145E-39)
                java.lang.String r3 = "load exception with no mCampaignRequestError"
                if (r10 == 0) goto L_0x00b4
                int r4 = r10.c()     // Catch:{ Exception -> 0x0035 }
                r5 = 9
                r6 = 880003(0xd6d83, float:1.233147E-39)
                java.lang.String r7 = ""
                if (r4 != r5) goto L_0x0038
                int r1 = r10.a()     // Catch:{ Exception -> 0x0035 }
                java.lang.String r3 = r10.b()     // Catch:{ Exception -> 0x0035 }
                int r2 = r10.c()     // Catch:{ Exception -> 0x0035 }
                r4 = -1
                if (r2 != r4) goto L_0x0029
                r2 = 880017(0xd6d91, float:1.233166E-39)
                goto L_0x002c
            L_0x0029:
                r2 = 880003(0xd6d83, float:1.233147E-39)
            L_0x002c:
                java.lang.String r4 = r10.f()     // Catch:{ Exception -> 0x0035 }
                r5 = 1
                r8 = r7
                r7 = r4
                r4 = r8
                goto L_0x0086
            L_0x0035:
                r10 = move-exception
                goto L_0x00b1
            L_0x0038:
                int r4 = r10.c()     // Catch:{ Exception -> 0x0035 }
                r5 = 10
                if (r4 != r5) goto L_0x0055
                r4 = 880023(0xd6d97, float:1.233175E-39)
                java.lang.String r3 = r10.d()     // Catch:{ Exception -> 0x0050 }
                r4 = r7
                r1 = 880023(0xd6d97, float:1.233175E-39)
                r2 = 880023(0xd6d97, float:1.233175E-39)
            L_0x004e:
                r5 = 0
                goto L_0x0086
            L_0x0050:
                r10 = move-exception
                r1 = 880023(0xd6d97, float:1.233175E-39)
                goto L_0x00b1
            L_0x0055:
                int r4 = r10.c()     // Catch:{ Exception -> 0x0035 }
                switch(r4) {
                    case 0: goto L_0x0061;
                    case 1: goto L_0x0064;
                    case 2: goto L_0x0064;
                    case 3: goto L_0x0064;
                    case 4: goto L_0x0064;
                    case 5: goto L_0x0061;
                    case 6: goto L_0x005d;
                    case 7: goto L_0x005d;
                    default: goto L_0x005c;
                }     // Catch:{ Exception -> 0x0035 }
            L_0x005c:
                goto L_0x0064
            L_0x005d:
                r2 = 880003(0xd6d83, float:1.233147E-39)
                goto L_0x0064
            L_0x0061:
                r2 = 880020(0xd6d94, float:1.23317E-39)
            L_0x0064:
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch:{ Exception -> 0x0035 }
                if (r4 == 0) goto L_0x0084
                com.mbridge.msdk.tracker.network.ad r4 = r10.e()     // Catch:{ Exception -> 0x0035 }
                int r4 = r4.b()     // Catch:{ Exception -> 0x0035 }
                com.mbridge.msdk.tracker.network.ad r5 = r10.e()     // Catch:{ Exception -> 0x0081 }
                java.lang.String r3 = r5.c()     // Catch:{ Exception -> 0x0081 }
                java.lang.String r5 = r10.d()     // Catch:{ Exception -> 0x0081 }
                r1 = r4
                r4 = r5
                goto L_0x004e
            L_0x0081:
                r10 = move-exception
                r1 = r4
                goto L_0x00b1
            L_0x0084:
                r4 = r7
                goto L_0x004e
            L_0x0086:
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)     // Catch:{ Exception -> 0x0035 }
                java.lang.String r6 = "campaign_request_error_type"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0035 }
                r0.a(r6, r11)     // Catch:{ Exception -> 0x0035 }
                java.lang.String r11 = "campaign_request_error"
                r0.a(r11, r10)     // Catch:{ Exception -> 0x0035 }
                r0.b((boolean) r5)     // Catch:{ Exception -> 0x0035 }
                boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0035 }
                if (r10 != 0) goto L_0x00a4
                r0.e(r7)     // Catch:{ Exception -> 0x0035 }
            L_0x00a4:
                boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0035 }
                if (r10 != 0) goto L_0x00ad
                r0.f(r4)     // Catch:{ Exception -> 0x0035 }
            L_0x00ad:
                r0.d(r12)     // Catch:{ Exception -> 0x0035 }
                goto L_0x00b4
            L_0x00b1:
                r10.printStackTrace()
            L_0x00b4:
                if (r0 != 0) goto L_0x00ba
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)
            L_0x00ba:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.i.a.a(com.mbridge.msdk.newreward.function.c.b.b, int, java.lang.String):com.mbridge.msdk.foundation.c.b");
        }
    }
}
