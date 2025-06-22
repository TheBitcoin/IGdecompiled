package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.List;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected c f14278a;

    /* renamed from: b  reason: collision with root package name */
    protected MBridgeIds f14279b;

    /* renamed from: c  reason: collision with root package name */
    protected e f14280c;

    /* renamed from: d  reason: collision with root package name */
    private RewardVideoListener f14281d;

    public a(c cVar) {
        this.f14278a = cVar;
    }

    /* access modifiers changed from: protected */
    public final void a(final com.mbridge.msdk.foundation.c.b bVar) {
        c cVar = this.f14278a;
        cVar.b((Object) cVar.a("adapter_model", this.f14280c, "command_manager", cVar, "scene", 2, "reason", bVar), (b) new b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f14279b, bVar);
            }

            public final void reqSuccessful(Object obj) {
                a.this.a(1, obj);
                a.this.a(2, obj);
            }
        });
    }

    public final void a(int i4, Object obj) {
        int i5;
        int i6;
        char c5;
        int i7;
        int i8;
        int i9;
        int i10 = i4;
        if (i10 != 1) {
            if (i10 == 2) {
                this.f14280c.c(2);
                if (!this.f14280c.s()) {
                    if (this.f14280c.D() == null || this.f14280c.D().b() == null) {
                        c5 = 7;
                        i7 = 0;
                        i8 = 0;
                        i9 = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b b5 = this.f14280c.D().b();
                        i9 = b5.a();
                        i7 = b5.b();
                        c5 = 7;
                        i8 = (this.f14280c.D().a() == null || this.f14280c.D().a().isEmpty()) ? 0 : this.f14280c.D().a().get(0).getFilterCallBackState();
                    }
                    c cVar = this.f14278a;
                    e eVar = this.f14280c;
                    f fVar = f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS;
                    Integer valueOf = Integer.valueOf(i9);
                    Integer valueOf2 = Integer.valueOf(i7);
                    Integer valueOf3 = Integer.valueOf(i8);
                    Object[] objArr = new Object[8];
                    objArr[0] = "cache";
                    objArr[1] = 2;
                    objArr[2] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX;
                    objArr[3] = valueOf;
                    objArr[4] = com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX;
                    objArr[5] = valueOf2;
                    objArr[6] = CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE;
                    objArr[c5] = valueOf3;
                    cVar.a((Object) eVar, fVar, (Object) cVar.a(objArr));
                    if (this.f14281d != null) {
                        this.f14280c.h(true);
                        this.f14281d.onVideoLoadSuccess(this.f14279b);
                    }
                }
            }
        } else if (!this.f14280c.q() && !this.f14280c.s()) {
            List<CampaignEx> a5 = this.f14280c.D() != null ? this.f14280c.D().a() : null;
            if (this.f14280c.D() == null || this.f14280c.D().b() == null) {
                i6 = 0;
                i5 = 0;
            } else {
                com.mbridge.msdk.newreward.function.c.a.b b6 = this.f14280c.D().b();
                i5 = b6.a();
                i6 = b6.b();
            }
            int filterCallBackState = (a5 == null || a5.isEmpty()) ? 0 : a5.get(0).getFilterCallBackState();
            c cVar2 = this.f14278a;
            e eVar2 = this.f14280c;
            cVar2.a((Object) eVar2, f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS, (Object) cVar2.a("metrics_data", obj, "auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i5), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i6), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState), "cache", 2));
            if (this.f14281d != null) {
                this.f14280c.f(true);
                this.f14281d.onLoadSuccess(this.f14279b);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.out.MBridgeIds r12, com.mbridge.msdk.foundation.c.b r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            com.mbridge.msdk.newreward.a.e r2 = r11.f14280c
            r3 = 2
            r2.c((int) r3)
            com.mbridge.msdk.newreward.a.e r2 = r11.f14280c
            boolean r2 = r2.s()
            if (r2 != 0) goto L_0x00ba
            com.mbridge.msdk.newreward.a.e r2 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r2 = r2.D()
            if (r2 == 0) goto L_0x0069
            com.mbridge.msdk.newreward.a.e r2 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r2 = r2.D()
            com.mbridge.msdk.newreward.function.c.a.b r2 = r2.b()
            if (r2 == 0) goto L_0x0069
            com.mbridge.msdk.newreward.a.e r2 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r2 = r2.D()
            com.mbridge.msdk.newreward.function.c.a.b r2 = r2.b()
            int r4 = r2.a()
            int r2 = r2.b()
            com.mbridge.msdk.newreward.a.e r5 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r5 = r5.D()
            java.util.List r5 = r5.a()
            if (r5 == 0) goto L_0x0067
            com.mbridge.msdk.newreward.a.e r5 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r5 = r5.D()
            java.util.List r5 = r5.a()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0067
            com.mbridge.msdk.newreward.a.e r5 = r11.f14280c
            com.mbridge.msdk.newreward.function.e.a r5 = r5.D()
            java.util.List r5 = r5.a()
            java.lang.Object r5 = r5.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            int r5 = r5.getFilterCallBackState()
            goto L_0x006c
        L_0x0067:
            r5 = 0
            goto L_0x006c
        L_0x0069:
            r2 = 0
            r4 = 0
            goto L_0x0067
        L_0x006c:
            com.mbridge.msdk.newreward.function.command.c r6 = r11.f14278a
            com.mbridge.msdk.newreward.a.e r7 = r11.f14280c
            com.mbridge.msdk.newreward.function.command.f r8 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_FAILED
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r9 = 8
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r10 = "metrics_data"
            r9[r1] = r10
            r9[r0] = r13
            java.lang.String r1 = "r_index"
            r9[r3] = r1
            r1 = 3
            r9[r1] = r4
            java.lang.String r1 = "s_show_index"
            r3 = 4
            r9[r3] = r1
            r1 = 5
            r9[r1] = r2
            java.lang.String r1 = "i_s_c_t"
            r2 = 6
            r9[r2] = r1
            r1 = 7
            r9[r1] = r5
            java.util.Map r1 = r6.a((java.lang.Object[]) r9)
            r6.a((java.lang.Object) r7, (com.mbridge.msdk.newreward.function.command.f) r8, (java.lang.Object) r1)
            com.mbridge.msdk.newout.RewardVideoListener r1 = r11.f14281d
            if (r1 == 0) goto L_0x00ba
            com.mbridge.msdk.newreward.a.e r1 = r11.f14280c
            r1.h(r0)
            com.mbridge.msdk.newout.RewardVideoListener r0 = r11.f14281d
            if (r0 == 0) goto L_0x00ba
            java.lang.String r13 = r13.b()
            r0.onVideoLoadFail(r12, r13)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.a.a.a(com.mbridge.msdk.out.MBridgeIds, com.mbridge.msdk.foundation.c.b):void");
    }

    public final void a(e eVar) {
        eVar.c(1);
        this.f14280c = eVar;
        this.f14281d = eVar.K();
        MBridgeIds mBridgeIds = (MBridgeIds) this.f14278a.a((Object) null, f.CREATE_BIDS);
        this.f14279b = mBridgeIds;
        mBridgeIds.setBidToken(this.f14280c.J());
        c cVar = this.f14278a;
        cVar.c((Object) cVar.a("command_type", f.PRE_HANDLE_LOAD, "command_manager", cVar, "adapter_model", this.f14280c), (b) new b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f14279b, bVar);
            }

            public final void reqSuccessful(Object obj) {
                a aVar = a.this;
                c cVar = aVar.f14278a;
                cVar.a((Object) cVar.a("command_manager", cVar, "adapter_model", aVar.f14280c), (b) a.this);
            }
        });
    }
}
