package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class d implements a.C0192a, com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.a.a f14733a;

    /* renamed from: b  reason: collision with root package name */
    com.mbridge.msdk.newreward.a.b.b f14734b;

    /* renamed from: c  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.c f14735c;

    /* renamed from: d  reason: collision with root package name */
    e f14736d;

    /* renamed from: e  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.receiver.a.c f14737e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f14738f = UUID.randomUUID().toString();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f14739g = UUID.randomUUID().toString();

    /* renamed from: h  reason: collision with root package name */
    private long f14740h = WorkRequest.MIN_BACKOFF_MILLIS;

    /* renamed from: i  reason: collision with root package name */
    private Map f14741i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f14742j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f14743k = false;

    /* renamed from: l  reason: collision with root package name */
    private final int f14744l = 1;

    /* renamed from: m  reason: collision with root package name */
    private final int f14745m = 1;

    /* renamed from: n  reason: collision with root package name */
    private final int f14746n = 2;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f14747o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Handler f14748p = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880049, "second request reason miss");
                try {
                    Object obj = message.obj;
                    if (obj instanceof com.mbridge.msdk.foundation.c.b) {
                        b5 = (com.mbridge.msdk.foundation.c.b) obj;
                    }
                    if (message.arg1 == 2) {
                        com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14738f);
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f14736d.h(), d.this.f14736d.C(), d.this.f14736d.H(), d.this.f14736d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
                    } else if (!(b5 == null || b5.a((Object) "campaign_request_error_type") == null)) {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f14736d.h(), d.this.f14736d.C(), d.this.f14736d.H(), d.this.f14736d.G(), ((Integer) b5.a((Object) "campaign_request_error_type")).intValue());
                    }
                } catch (Exception unused) {
                }
                d.this.f14734b.reqFailed(b5);
            }
        }
    };

    private final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f14751b;

        /* renamed from: c  reason: collision with root package name */
        private final Map f14752c;

        public a(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f14751b = bVar;
            this.f14752c = map;
        }

        private void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            int i4;
            int i5;
            try {
                if (bVar.a() > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, bVar.a() + "");
                    hashMap.put("invalid_ad_ids", d.this.f14736d.b());
                    this.f14752c.put("params_ext_map_key", hashMap);
                    this.f14751b.a((Object) this.f14752c);
                    int a5 = bVar.a();
                    int b5 = bVar.b();
                    if (bVar.E() == null || bVar.E().isEmpty()) {
                        i4 = 0;
                    } else {
                        i4 = bVar.E().get(0).getFilterCallBackState();
                    }
                    d dVar = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar.f14735c;
                    e eVar = dVar.f14736d;
                    f fVar = f.REPORT_LOAD_V3_START;
                    if (eVar.I()) {
                        i5 = 2;
                    } else {
                        i5 = 1;
                    }
                    cVar.a((Object) eVar, fVar, (Object) cVar.a("auto_load", Integer.valueOf(i5), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(d.this.f14736d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(a5), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(b5), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i4)));
                    com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
                    bVar2.a(this.f14751b);
                    boolean unused = d.this.f14747o = true;
                    d dVar2 = d.this;
                    dVar2.f14733a.a(bVar2, new b(bVar2, this.f14752c));
                }
            } catch (Exception unused2) {
            }
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            int i4;
            int i5;
            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar2, dVar.f14736d, dVar.f14735c, 1);
            if (d.this.f14737e.a(eVar)) {
                d.this.f14737e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14739g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14738f);
            if (!d.this.f14742j) {
                boolean unused = d.this.f14742j = true;
                try {
                    d dVar2 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f14735c;
                    e eVar2 = dVar2.f14736d;
                    f fVar = f.REPORT_LOAD_V3_RES_FAIL;
                    if (eVar2.I()) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    Integer valueOf = Integer.valueOf(i4);
                    if (bVar2.m()) {
                        i5 = 1;
                    } else {
                        i5 = 2;
                    }
                    cVar.a((Object) eVar2, fVar, (Object) cVar.a("auto_load", valueOf, "result", Integer.valueOf(i5), "code", Integer.valueOf(bVar2.i()), "reason", bVar2.b(), "timeout", Integer.valueOf(d.this.f14736d.P()), "hst", bVar2.j(), "err_desc", bVar2.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                ((MBridgeOffsetManager) d.this.f14735c.a((Object) null, f.CREATE_OFFSET)).resetOffset();
                if (bVar2 != null) {
                    try {
                        if (bVar2.a((Object) "campaign_request_error_type") != null) {
                            com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f14736d.h(), d.this.f14736d.C(), d.this.f14736d.H(), d.this.f14736d.G(), ((Integer) bVar2.a((Object) "campaign_request_error_type")).intValue());
                        }
                    } catch (Exception unused2) {
                    }
                }
                d.this.f14734b.reqFailed(bVar2);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void reqSuccessful(java.lang.Object r21) {
            /*
                r20 = this;
                r1 = r20
                r2 = 4
                r4 = 2
                r5 = 0
                r6 = 1
                com.mbridge.msdk.newreward.a.c.a r0 = com.mbridge.msdk.newreward.a.c.a.a()
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r7 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                java.lang.String r7 = r7.f14739g
                r0.a(r7)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                boolean r0 = r0.f14742j
                if (r0 == 0) goto L_0x001c
                return
            L_0x001c:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                boolean unused = r0.f14742j = r6
                r7 = r21
                com.mbridge.msdk.newreward.function.c.a.b r7 = (com.mbridge.msdk.newreward.function.c.a.b) r7
                if (r7 == 0) goto L_0x0050
                int r0 = r7.a()
                int r8 = r7.b()
                java.util.List r9 = r7.E()
                if (r9 == 0) goto L_0x004e
                java.util.List r9 = r7.E()
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x004e
                java.util.List r9 = r7.E()
                java.lang.Object r9 = r9.get(r5)
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9
                int r9 = r9.getFilterCallBackState()
                goto L_0x0053
            L_0x004e:
                r9 = 0
                goto L_0x0053
            L_0x0050:
                r0 = 0
                r8 = 0
                goto L_0x004e
            L_0x0053:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r10 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r11 = r10.f14735c
                com.mbridge.msdk.newreward.a.e r10 = r10.f14736d
                com.mbridge.msdk.newreward.function.command.f r12 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS
                boolean r13 = r10.I()
                if (r13 == 0) goto L_0x0063
                r13 = 2
                goto L_0x0064
            L_0x0063:
                r13 = 1
            L_0x0064:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
                java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
                r16 = 3
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r3 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.e r3 = r3.f14736d
                int r3 = r3.P()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                if (r7 == 0) goto L_0x0093
                java.lang.String r17 = r7.J()
            L_0x0090:
                r18 = 2
                goto L_0x0096
            L_0x0093:
                java.lang.String r17 = ""
                goto L_0x0090
            L_0x0096:
                r4 = 18
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r19 = "metrics_data"
                r4[r5] = r19
                r4[r6] = r7
                java.lang.String r19 = "auto_load"
                r4[r18] = r19
                r4[r16] = r13
                java.lang.String r13 = "result"
                r4[r2] = r13
                r13 = 5
                r4[r13] = r14
                java.lang.String r13 = "cache"
                r14 = 6
                r4[r14] = r13
                r13 = 7
                r4[r13] = r15
                java.lang.String r13 = "timeout"
                r14 = 8
                r4[r14] = r13
                r13 = 9
                r4[r13] = r3
                java.lang.String r3 = "r_index"
                r13 = 10
                r4[r13] = r3
                r3 = 11
                r4[r3] = r0
                java.lang.String r0 = "s_show_index"
                r3 = 12
                r4[r3] = r0
                r0 = 13
                r4[r0] = r8
                java.lang.String r0 = "i_s_c_t"
                r3 = 14
                r4[r3] = r0
                r0 = 15
                r4[r0] = r9
                java.lang.String r0 = "hst"
                r3 = 16
                r4[r3] = r0
                r0 = 17
                r4[r0] = r17
                java.util.Map r0 = r11.a((java.lang.Object[]) r4)
                r11.a((java.lang.Object) r10, (com.mbridge.msdk.newreward.function.command.f) r12, (java.lang.Object) r0)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r0 = r0.f14735c
                com.mbridge.msdk.newreward.function.command.f r3 = com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET
                r4 = 0
                java.lang.Object r0 = r0.a((java.lang.Object) r4, (com.mbridge.msdk.newreward.function.command.f) r3)
                com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager r0 = (com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager) r0
                java.util.List r3 = r7.u()
                int r3 = r3.size()
                r0.increaseOffset(r3)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r3 = r0.f14735c
                com.mbridge.msdk.newreward.a.e r0 = r0.f14736d
                java.lang.String r8 = "adapter_model"
                java.lang.String r9 = "campaign"
                java.lang.Object[] r10 = new java.lang.Object[r2]
                r10[r5] = r8
                r10[r6] = r0
                r10[r18] = r9
                r10[r16] = r7
                java.util.Map r0 = r3.a((java.lang.Object[]) r10)
                r3.e(r0)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this     // Catch:{ MBridgeError -> 0x0139 }
                com.mbridge.msdk.newreward.function.command.c r3 = r0.f14735c     // Catch:{ MBridgeError -> 0x0139 }
                com.mbridge.msdk.newreward.a.e r0 = r0.f14736d     // Catch:{ MBridgeError -> 0x0139 }
                java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ MBridgeError -> 0x0139 }
                r10[r5] = r8     // Catch:{ MBridgeError -> 0x0139 }
                r10[r6] = r0     // Catch:{ MBridgeError -> 0x0139 }
                r10[r18] = r9     // Catch:{ MBridgeError -> 0x0139 }
                r10[r16] = r7     // Catch:{ MBridgeError -> 0x0139 }
                java.util.Map r0 = r3.a((java.lang.Object[]) r10)     // Catch:{ MBridgeError -> 0x0139 }
                r3.c(r0)     // Catch:{ MBridgeError -> 0x0139 }
                goto L_0x01aa
            L_0x0139:
                r0 = move-exception
                com.mbridge.msdk.newreward.a.c.a r3 = com.mbridge.msdk.newreward.a.c.a.a()
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r8 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                java.lang.String r8 = r8.f14738f
                r3.a(r8)
                java.lang.String r3 = r0.getErrorMessage()
                java.lang.String r8 = "APP ALREADY INSTALLED"
                boolean r3 = r3.contains(r8)
                java.lang.String r8 = "errorCode: 3507 errorMessage: data load failed, errorMsg is "
                if (r3 == 0) goto L_0x019b
                com.mbridge.msdk.newreward.function.d.c r2 = com.mbridge.msdk.newreward.function.d.c.a()
                com.mbridge.msdk.newreward.function.d.a r9 = r2.b()
                int r10 = r7.c()
                java.lang.String r11 = r7.d()
                java.lang.String r12 = r7.e()
                java.lang.String r13 = r7.g()
                r14 = 403(0x193, float:5.65E-43)
                r9.a((int) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)
                r1.a(r7)
                int r2 = r0.getErrorCode()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r8)
                java.lang.String r0 = r0.getErrorMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r3 = 880021(0xd6d95, float:1.233172E-39)
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.b.b r2 = r2.f14734b
                r2.reqFailed(r0)
                return
            L_0x019b:
                java.lang.String r3 = r0.getErrorMessage()
                java.lang.String r10 = "FILTER BUT CALLBACK SUCCEED"
                boolean r3 = r3.contains(r10)
                if (r3 == 0) goto L_0x01eb
                r1.a(r7)
            L_0x01aa:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.b.b r3 = r0.f14734b
                com.mbridge.msdk.newreward.function.command.c r0 = r0.f14735c
                java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r10 = "type"
                r2[r5] = r10
                r2[r6] = r8
                java.lang.String r5 = "object"
                r2[r18] = r5
                r2[r16] = r7
                java.util.Map r0 = r0.a((java.lang.Object[]) r2)
                r3.reqSuccessful(r0)
                com.mbridge.msdk.newreward.function.command.b r0 = r1.f14751b
                com.mbridge.msdk.newreward.function.command.f r2 = com.mbridge.msdk.newreward.function.command.f.REQ_DOWN_CAMPAIGN
                r0.a((com.mbridge.msdk.newreward.function.command.f) r2)
                java.util.Map r0 = r1.f14752c
                r0.put(r9, r7)
                com.mbridge.msdk.newreward.function.command.b r0 = r1.f14751b
                java.util.Map r2 = r1.f14752c
                r0.a((java.lang.Object) r2)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.a.a r2 = r0.f14733a
                com.mbridge.msdk.newreward.function.command.b r3 = r1.f14751b
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$c r5 = new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$c
                r5.<init>()
                r2.a(r3, r5)
                return
            L_0x01eb:
                com.mbridge.msdk.newreward.function.d.c r2 = com.mbridge.msdk.newreward.function.d.c.a()
                com.mbridge.msdk.newreward.function.d.a r9 = r2.b()
                int r10 = r7.c()
                java.lang.String r11 = r7.d()
                java.lang.String r12 = r7.e()
                java.lang.String r13 = r7.g()
                r14 = 403(0x193, float:5.65E-43)
                r9.a((int) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (int) r14)
                int r2 = r0.getErrorCode()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r8)
                java.lang.String r0 = r0.getErrorMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r3 = 880003(0xd6d83, float:1.233147E-39)
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.b.b r2 = r2.f14734b
                r2.reqFailed(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.a.reqSuccessful(java.lang.Object):void");
        }
    }

    private final class b implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f14754b;

        /* renamed from: c  reason: collision with root package name */
        private final Map f14755c;

        public b(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f14754b = bVar;
            this.f14755c = map;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            int i4;
            int i5;
            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar2, dVar.f14736d, dVar.f14735c, 1);
            if (d.this.f14737e.a(eVar)) {
                d.this.f14737e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14739g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14738f);
            if (!d.this.f14743k) {
                boolean unused = d.this.f14743k = true;
                try {
                    d dVar2 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f14735c;
                    e eVar2 = dVar2.f14736d;
                    f fVar = f.REPORT_LOAD_V3_RES_FAIL;
                    if (eVar2.I()) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    Integer valueOf = Integer.valueOf(i4);
                    if (bVar2.m()) {
                        i5 = 1;
                    } else {
                        i5 = 2;
                    }
                    cVar.a((Object) eVar2, fVar, (Object) cVar.a("auto_load", valueOf, "result", Integer.valueOf(i5), "code", Integer.valueOf(bVar2.i()), "reason", bVar2.b(), "timeout", Integer.valueOf(d.this.f14736d.P()), "hst", bVar2.j(), "err_desc", bVar2.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                ((MBridgeOffsetManager) d.this.f14735c.a((Object) null, f.CREATE_OFFSET)).resetOffset();
                d.a(d.this, bVar2, true, (com.mbridge.msdk.newreward.function.c.a.b) null);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0085  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void reqSuccessful(java.lang.Object r21) {
            /*
                r20 = this;
                r1 = r20
                r0 = 4
                r3 = 2
                r4 = 0
                r5 = 1
                com.mbridge.msdk.newreward.a.c.a r6 = com.mbridge.msdk.newreward.a.c.a.a()
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r7 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                java.lang.String r7 = r7.f14739g
                r6.a(r7)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r6 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                boolean r6 = r6.f14743k
                if (r6 == 0) goto L_0x001c
                return
            L_0x001c:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r6 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                boolean unused = r6.f14743k = r5
                r6 = r21
                com.mbridge.msdk.newreward.function.c.a.b r6 = (com.mbridge.msdk.newreward.function.c.a.b) r6
                if (r6 == 0) goto L_0x0050
                int r7 = r6.a()
                int r8 = r6.b()
                java.util.List r9 = r6.E()
                if (r9 == 0) goto L_0x004e
                java.util.List r9 = r6.E()
                boolean r9 = r9.isEmpty()
                if (r9 != 0) goto L_0x004e
                java.util.List r9 = r6.E()
                java.lang.Object r9 = r9.get(r4)
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = (com.mbridge.msdk.foundation.entity.CampaignEx) r9
                int r9 = r9.getFilterCallBackState()
                goto L_0x0053
            L_0x004e:
                r9 = 0
                goto L_0x0053
            L_0x0050:
                r7 = 0
                r8 = 0
                goto L_0x004e
            L_0x0053:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r10 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r11 = r10.f14735c
                com.mbridge.msdk.newreward.a.e r10 = r10.f14736d
                com.mbridge.msdk.newreward.function.command.f r12 = com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_RES_SUCCESS
                boolean r13 = r10.I()
                if (r13 == 0) goto L_0x0063
                r13 = 2
                goto L_0x0064
            L_0x0063:
                r13 = 1
            L_0x0064:
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
                java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
                r16 = 3
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.e r2 = r2.f14736d
                int r2 = r2.P()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                if (r6 == 0) goto L_0x0085
                java.lang.String r17 = r6.J()
                goto L_0x0087
            L_0x0085:
                java.lang.String r17 = ""
            L_0x0087:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                r18 = 2
                r3 = 18
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r19 = "metrics_data"
                r3[r4] = r19
                r3[r5] = r6
                java.lang.String r19 = "auto_load"
                r3[r18] = r19
                r3[r16] = r13
                java.lang.String r13 = "result"
                r3[r0] = r13
                r13 = 5
                r3[r13] = r14
                java.lang.String r13 = "cache"
                r14 = 6
                r3[r14] = r13
                r13 = 7
                r3[r13] = r15
                java.lang.String r13 = "timeout"
                r14 = 8
                r3[r14] = r13
                r13 = 9
                r3[r13] = r2
                java.lang.String r2 = "hst"
                r13 = 10
                r3[r13] = r2
                r2 = 11
                r3[r2] = r17
                java.lang.String r2 = "r_index"
                r13 = 12
                r3[r13] = r2
                r2 = 13
                r3[r2] = r7
                java.lang.String r2 = "s_show_index"
                r7 = 14
                r3[r7] = r2
                r2 = 15
                r3[r2] = r8
                java.lang.String r2 = "i_s_c_t"
                r7 = 16
                r3[r7] = r2
                r2 = 17
                r3[r2] = r9
                java.util.Map r2 = r11.a((java.lang.Object[]) r3)
                r11.a((java.lang.Object) r10, (com.mbridge.msdk.newreward.function.command.f) r12, (java.lang.Object) r2)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r2 = r2.f14735c
                r3 = 0
                com.mbridge.msdk.newreward.function.command.f r7 = com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET
                java.lang.Object r2 = r2.a((java.lang.Object) r3, (com.mbridge.msdk.newreward.function.command.f) r7)
                com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager r2 = (com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager) r2
                java.util.List r3 = r6.u()
                int r3 = r3.size()
                r2.increaseOffset(r3)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.c r3 = r2.f14735c
                com.mbridge.msdk.newreward.a.e r2 = r2.f14736d
                java.lang.String r7 = "adapter_model"
                java.lang.String r8 = "campaign"
                java.lang.Object[] r9 = new java.lang.Object[r0]
                r9[r4] = r7
                r9[r5] = r2
                r9[r18] = r8
                r9[r16] = r6
                java.util.Map r2 = r3.a((java.lang.Object[]) r9)
                r3.e(r2)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this     // Catch:{ MBridgeError -> 0x0178 }
                com.mbridge.msdk.newreward.function.command.c r3 = r2.f14735c     // Catch:{ MBridgeError -> 0x0178 }
                com.mbridge.msdk.newreward.a.e r2 = r2.f14736d     // Catch:{ MBridgeError -> 0x0178 }
                java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ MBridgeError -> 0x0178 }
                r9[r4] = r7     // Catch:{ MBridgeError -> 0x0178 }
                r9[r5] = r2     // Catch:{ MBridgeError -> 0x0178 }
                r9[r18] = r8     // Catch:{ MBridgeError -> 0x0178 }
                r9[r16] = r6     // Catch:{ MBridgeError -> 0x0178 }
                java.util.Map r2 = r3.a((java.lang.Object[]) r9)     // Catch:{ MBridgeError -> 0x0178 }
                r3.d(r2)     // Catch:{ MBridgeError -> 0x0178 }
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.b.b r3 = r2.f14734b
                com.mbridge.msdk.newreward.function.command.c r2 = r2.f14735c
                java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r9 = "type"
                r0[r4] = r9
                r0[r5] = r7
                java.lang.String r4 = "object"
                r0[r18] = r4
                r0[r16] = r6
                java.util.Map r0 = r2.a((java.lang.Object[]) r0)
                r3.reqSuccessful(r0)
                com.mbridge.msdk.newreward.function.command.b r0 = r1.f14754b
                com.mbridge.msdk.newreward.function.command.f r2 = com.mbridge.msdk.newreward.function.command.f.REQ_DOWN_CAMPAIGN
                r0.a((com.mbridge.msdk.newreward.function.command.f) r2)
                java.util.Map r0 = r1.f14755c
                r0.put(r8, r6)
                com.mbridge.msdk.newreward.function.command.b r0 = r1.f14754b
                java.util.Map r2 = r1.f14755c
                r0.a((java.lang.Object) r2)
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r0 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.function.command.a.a r2 = r0.f14733a
                com.mbridge.msdk.newreward.function.command.b r3 = r1.f14754b
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$d r4 = new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$d
                r4.<init>(r6)
                r2.a(r3, r4)
                return
            L_0x0178:
                r0 = move-exception
                com.mbridge.msdk.newreward.a.c.a r2 = com.mbridge.msdk.newreward.a.c.a.a()
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r3 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                java.lang.String r3 = r3.f14738f
                r2.a(r3)
                com.mbridge.msdk.newreward.function.d.c r2 = com.mbridge.msdk.newreward.function.d.c.a()
                com.mbridge.msdk.newreward.function.d.a r7 = r2.b()
                int r8 = r6.c()
                java.lang.String r9 = r6.d()
                java.lang.String r10 = r6.e()
                java.lang.String r11 = r6.g()
                r12 = 403(0x193, float:5.65E-43)
                r7.a((int) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
                java.lang.String r2 = r0.getErrorMessage()
                java.lang.String r3 = "APP ALREADY INSTALLED"
                boolean r2 = r2.contains(r3)
                java.lang.String r3 = "errorCode: 3507 errorMessage: data load failed, errorMsg is "
                if (r2 == 0) goto L_0x01d0
                int r2 = r0.getErrorCode()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                java.lang.String r0 = r0.getErrorMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3 = 880021(0xd6d95, float:1.233172E-39)
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
                goto L_0x01ee
            L_0x01d0:
                int r2 = r0.getErrorCode()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r3)
                java.lang.String r0 = r0.getErrorMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r3 = 880003(0xd6d83, float:1.233147E-39)
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.a(r2, r3, r0)
            L_0x01ee:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d r2 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.this
                com.mbridge.msdk.newreward.a.b.b r2 = r2.f14734b
                r2.reqFailed(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d.b.reqSuccessful(java.lang.Object):void");
        }
    }

    private class c implements com.mbridge.msdk.newreward.a.b.b {
        private c() {
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f14736d, dVar.f14735c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.f14737e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, (com.mbridge.msdk.newreward.function.c.a.b) null);
            } else {
                d.this.f14737e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
            }
        }

        public final void reqSuccessful(Object obj) {
            d.this.f14748p.removeMessages(1);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14738f);
            d dVar = d.this;
            dVar.f14734b.reqSuccessful(dVar.f14735c.a("type", 2, "object", obj));
        }
    }

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$d  reason: collision with other inner class name */
    private class C0196d implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.c.a.b f14758b;

        public C0196d(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            this.f14758b = bVar;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f14736d, dVar.f14735c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.f14737e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, this.f14758b);
            } else {
                d.this.f14737e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
            }
        }

        public final void reqSuccessful(Object obj) {
            d.this.f14748p.removeMessages(1);
            com.mbridge.msdk.newreward.function.c.a.b bVar = this.f14758b;
            if (bVar != null && bVar.a() == 0) {
                this.f14758b.c(3);
                d.this.f14736d.D().a(this.f14758b);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f14758b);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f14738f);
            d dVar = d.this;
            dVar.f14734b.reqSuccessful(dVar.f14735c.a("type", 2, "object", obj));
        }
    }

    private int b() {
        com.mbridge.msdk.newreward.function.e.f x4;
        com.mbridge.msdk.videocommon.d.c b5;
        try {
            e eVar = this.f14736d;
            if (eVar == null || (x4 = eVar.x()) == null || (b5 = x4.b()) == null) {
                return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
            }
            return b5.F() * 1000;
        } catch (Exception unused) {
            return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f14733a = aVar;
        this.f14737e = new com.mbridge.msdk.newreward.function.command.receiver.a.c(aVar);
    }

    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        try {
            this.f14734b = bVar2;
            int b5 = b();
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f14738f, (long) b5, this);
            bVar.a(f.REQ_CAMPAIGN);
            Map map = (Map) bVar.b();
            this.f14741i = map;
            this.f14735c = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            e eVar = (e) this.f14741i.get("adapter_model");
            this.f14736d = eVar;
            eVar.g(b5);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f14735c;
            e eVar2 = this.f14736d;
            cVar.a((Object) eVar2, f.REPORT_LOAD_V3_START, (Object) cVar.a("auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(this.f14736d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
            this.f14733a.a(bVar, new a(bVar, this.f14741i));
            long a5 = (long) ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_RETRY_TIMEOUT, 0);
            this.f14740h = a5;
            if (a5 > 0) {
                com.mbridge.msdk.newreward.a.c.a.a().a(this.f14739g, this.f14740h, this);
            }
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f14736d.h(), this.f14736d.C(), this.f14736d.H(), this.f14736d.G(), !TextUtils.isEmpty(this.f14736d.J()), this.f14736d.J(), this.f14736d.T());
        } catch (Exception e5) {
            Exception exc = e5;
            af.b("LoadControllerReceiver", "action", exc);
            if (this.f14736d != null) {
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f14736d.h(), this.f14736d.C(), this.f14736d.H(), this.f14736d.G(), 8);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f14739g);
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f14738f);
            if (bVar2 != null) {
                bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, exc.getMessage()));
            }
        }
    }

    public final void a(String str, long j4) {
        if (TextUtils.equals(str, this.f14738f)) {
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f14736d.h(), this.f14736d.C(), this.f14736d.H(), this.f14736d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT);
            String a5 = a();
            com.mbridge.msdk.newreward.a.b.b bVar = this.f14734b;
            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880010, "errorCode: 3401 errorMessage: " + a5));
        } else if (TextUtils.equals(str, this.f14739g) && this.f14737e != null) {
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e((com.mbridge.msdk.foundation.c.b) null, this.f14736d, this.f14735c, 3);
            com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
            bVar2.a(f.REQ_CAMPAIGN);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f14735c;
            bVar2.a((Object) cVar.a("adapter_model", this.f14736d, "command_manager", cVar));
            this.f14737e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) new a(bVar2, this.f14741i));
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        try {
            e eVar = this.f14736d;
            if (!(eVar == null || eVar.D() == null)) {
                com.mbridge.msdk.newreward.function.c.a.b b5 = this.f14736d.D().b();
                if (b5 == null || b5.u() == null || b5.u().size() <= 0) {
                    sb.append(" load timeout ");
                } else {
                    for (com.mbridge.msdk.newreward.function.c.a.a next : b5.u()) {
                        if (next != null) {
                            n d5 = next.d();
                            if (d5 != null && !d5.d()) {
                                sb.append(" video timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> c5 = next.c();
                            if (c5 != null && !c5.d()) {
                                sb.append(" video_template timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> f4 = next.f();
                            if (f4 != null && !f4.d()) {
                                sb.append(" ec_template timeout ");
                            }
                        }
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return sb.toString();
    }

    static /* synthetic */ void a(d dVar, com.mbridge.msdk.foundation.c.b bVar, boolean z4, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        e eVar = dVar.f14736d;
        if (!(eVar == null || eVar.D() == null || dVar.f14736d.D().b() == null || dVar.f14736d.D().b().a() == 0 || !dVar.f14747o)) {
            int i4 = 1;
            if (!dVar.f14748p.hasMessages(1)) {
                Message obtainMessage = dVar.f14748p.obtainMessage(1);
                obtainMessage.obj = bVar;
                if (!z4) {
                    i4 = 2;
                }
                obtainMessage.arg1 = i4;
                dVar.f14748p.sendMessageDelayed(obtainMessage, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                return;
            }
        }
        if (!z4) {
            if (bVar2 != null && bVar2.a() == 0) {
                dVar.f14736d.D().a(bVar2);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar2);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(dVar.f14738f);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f14736d.h(), dVar.f14736d.C(), dVar.f14736d.H(), dVar.f14736d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
        } else if (bVar != null) {
            try {
                if (bVar.a((Object) "campaign_request_error_type") != null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f14736d.h(), dVar.f14736d.C(), dVar.f14736d.H(), dVar.f14736d.G(), ((Integer) bVar.a((Object) "campaign_request_error_type")).intValue());
                }
            } catch (Exception unused) {
            }
        }
        dVar.f14734b.reqFailed(bVar);
    }
}
