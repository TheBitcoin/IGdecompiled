package com.mbridge.msdk.newreward.a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.function.g.a;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private Deque<e> f14362a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f14363b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private RewardVideoListener f14364c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public f f14365d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f14366e;

    /* renamed from: f  reason: collision with root package name */
    private MBridgeIds f14367f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Map f14368g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b f14369h;

    /* renamed from: i  reason: collision with root package name */
    private int f14370i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f14371j = 1;

    /* renamed from: k  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.g.c f14372k;

    public d() {
        if (this.f14362a == null) {
            this.f14362a = new ConcurrentLinkedDeque();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC, Splitter:B:18:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0 A[Catch:{ Exception -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(com.mbridge.msdk.newreward.a.e r9) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            java.lang.String r2 = "error_code"
            java.util.Deque<com.mbridge.msdk.newreward.a.e> r3 = r8.f14362a     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x002b
            java.lang.Object r3 = r3.peek()     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.newreward.a.e r3 = (com.mbridge.msdk.newreward.a.e) r3     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x002b
            java.lang.String r4 = r3.i()     // Catch:{ Exception -> 0x0027 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0027 }
            if (r5 != 0) goto L_0x002b
            java.lang.String r5 = "-1"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0027 }
            if (r4 == 0) goto L_0x002b
            long r3 = r3.g()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002d
        L_0x0027:
            r9 = move-exception
            r0 = 0
            goto L_0x00d9
        L_0x002b:
            r3 = 0
        L_0x002d:
            com.mbridge.msdk.newreward.function.command.c r5 = r8.f14366e     // Catch:{ Exception -> 0x0027 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0027 }
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0027 }
            java.lang.String r6 = "adapter_model"
            r4[r1] = r6     // Catch:{ Exception -> 0x0027 }
            r4[r0] = r9     // Catch:{ Exception -> 0x0027 }
            java.lang.String r6 = "last_response_empty_time"
            r7 = 2
            r4[r7] = r6     // Catch:{ Exception -> 0x0027 }
            r6 = 3
            r4[r6] = r3     // Catch:{ Exception -> 0x0027 }
            java.util.Map r3 = r5.a((java.lang.Object[]) r4)     // Catch:{ Exception -> 0x0027 }
            com.mbridge.msdk.newreward.function.command.f r4 = com.mbridge.msdk.newreward.function.command.f.CHECK_IS_REQUEST_CONTROL     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r3 = r5.b((java.lang.Object) r3, (com.mbridge.msdk.newreward.function.command.f) r4)     // Catch:{ Exception -> 0x0027 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x009d
            int r4 = r3.size()     // Catch:{ Exception -> 0x0027 }
            if (r4 <= 0) goto L_0x009d
            com.mbridge.msdk.newout.RewardVideoListener r4 = r8.f14364c     // Catch:{ Exception -> 0x006d }
            java.lang.String r5 = "msg"
            if (r4 == 0) goto L_0x006f
            com.mbridge.msdk.out.MBridgeIds r6 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ Exception -> 0x006d }
            r6.<init>()     // Catch:{ Exception -> 0x006d }
            java.lang.Object r7 = r3.get(r5)     // Catch:{ Exception -> 0x006d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x006d }
            r4.onVideoLoadFail(r6, r7)     // Catch:{ Exception -> 0x006d }
            goto L_0x006f
        L_0x006d:
            r9 = move-exception
            goto L_0x00d9
        L_0x006f:
            java.lang.Object r4 = r3.get(r2)     // Catch:{ Exception -> 0x006d }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x006d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x006d }
            if (r4 != 0) goto L_0x0085
            java.lang.Object r1 = r3.get(r2)     // Catch:{ Exception -> 0x006d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x006d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x006d }
        L_0x0085:
            r2 = -1
            if (r1 != r2) goto L_0x008c
            r2 = 880018(0xd6d92, float:1.233168E-39)
            goto L_0x008f
        L_0x008c:
            r2 = 880002(0xd6d82, float:1.233145E-39)
        L_0x008f:
            java.lang.Object r3 = r3.get(r5)     // Catch:{ Exception -> 0x006d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x006d }
            com.mbridge.msdk.foundation.c.b r1 = com.mbridge.msdk.foundation.c.a.a(r1, r2, r3)     // Catch:{ Exception -> 0x006d }
            r8.a((com.mbridge.msdk.newreward.a.e) r9, (com.mbridge.msdk.foundation.c.b) r1)     // Catch:{ Exception -> 0x006d }
            goto L_0x009e
        L_0x009d:
            r0 = 0
        L_0x009e:
            if (r0 == 0) goto L_0x00d8
            com.mbridge.msdk.newreward.function.e.a r1 = r9.D()     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x00cd
            com.mbridge.msdk.newreward.function.e.a r1 = r9.D()     // Catch:{ Exception -> 0x006d }
            com.mbridge.msdk.newreward.function.c.a.b r1 = r1.b()     // Catch:{ Exception -> 0x006d }
            if (r1 == 0) goto L_0x00cd
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006d }
            r1.<init>()     // Catch:{ Exception -> 0x006d }
            com.mbridge.msdk.newreward.function.e.a r3 = r9.D()     // Catch:{ Exception -> 0x006d }
            com.mbridge.msdk.newreward.function.c.a.b r3 = r3.b()     // Catch:{ Exception -> 0x006d }
            int r3 = r3.a()     // Catch:{ Exception -> 0x006d }
            r1.append(r3)     // Catch:{ Exception -> 0x006d }
            r1.append(r2)     // Catch:{ Exception -> 0x006d }
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x006d }
        L_0x00cd:
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x006d }
            java.lang.String r9 = r9.G()     // Catch:{ Exception -> 0x006d }
            r1.b((java.lang.String) r9, (java.lang.String) r2)     // Catch:{ Exception -> 0x006d }
        L_0x00d8:
            return r0
        L_0x00d9:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x00e0
            r9.printStackTrace()
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.d.d(com.mbridge.msdk.newreward.a.e):boolean");
    }

    private void b(e eVar) {
        try {
            List<String> e5 = com.mbridge.msdk.newreward.function.d.c.a().b().e(eVar.h(), eVar.C(), eVar.H());
            if (e5 != null && e5.size() > 0) {
                String str = "";
                if (eVar.D() != null) {
                    if (eVar.D().b() != null) {
                        str = eVar.D().b().a() + str;
                    }
                }
                for (String b5 : e5) {
                    com.mbridge.msdk.foundation.same.report.d.d.a().b(b5, str);
                }
            }
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                e6.printStackTrace();
            }
        }
    }

    private void c(e eVar) {
        e eVar2;
        if (eVar != null && !TextUtils.isEmpty(eVar.k())) {
            try {
                Deque<e> deque = this.f14362a;
                if (deque != null) {
                    Iterator<e> it = deque.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        eVar2 = it.next();
                        if (eVar2 != null) {
                            if (eVar2.j()) {
                                if (eVar2.D() == null || !eVar2.D().c()) {
                                    if (eVar.k().equals(eVar2.G())) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                eVar2 = null;
                if (eVar2 != null) {
                    c cVar = this.f14366e;
                    cVar.c((Object) cVar.a("adapter_model", eVar, "queue_first_adapter_model", eVar2), com.mbridge.msdk.newreward.function.command.f.UPDATE_CAM_TOKEN_RULE);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a(Object obj) {
        try {
            this.f14364c = (RewardVideoListener) obj;
        } catch (Throwable unused) {
            this.f14364c = null;
        }
    }

    public final void a(Object... objArr) {
        this.f14366e = objArr[0];
        this.f14369h = objArr[1];
        com.mbridge.msdk.newreward.function.command.d.a().a(this.f14366e);
        final Map a5 = this.f14366e.a("mb_ad_type", Integer.valueOf(this.f14369h.e()), "mb_ad_is_header_bidding", Boolean.valueOf(this.f14369h.f()), "mb_ad_pid", this.f14369h.d(), "mb_ad_unit_id", this.f14369h.c());
        this.f14368g = a5;
        this.f14367f = (MBridgeIds) this.f14366e.a((Object) a5, com.mbridge.msdk.newreward.function.command.f.CREATE_BIDS);
        c cVar = this.f14366e;
        cVar.c((Object) cVar.a("mb_ad_unit_id", this.f14369h.c(), "command_type", com.mbridge.msdk.newreward.function.command.f.UNIT_INIT), (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            public final void reqSuccessful(Object obj) {
            }
        });
        com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f14369h.e(), this.f14369h.d(), this.f14369h.c());
        this.f14366e.a((Object) a5, com.mbridge.msdk.newreward.function.command.f.REQ_SETTING, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            public final void reqSuccessful(Object obj) {
                int i4;
                f unused = d.this.f14365d = (f) obj;
                Map unused2 = d.this.f14368g = a5;
                if (d.this.f14369h != null) {
                    d.this.f14369h.a(d.this.f14365d);
                }
                MBridgeDailyPlayModel mBridgeDailyPlayModel = (MBridgeDailyPlayModel) d.this.f14366e.a((Object) a5, com.mbridge.msdk.newreward.function.command.f.CREATE_DAILY);
                if (d.this.f14365d.b() == null) {
                    i4 = 0;
                } else {
                    i4 = d.this.f14365d.b().d();
                }
                mBridgeDailyPlayModel.setMaxPlayCount(i4);
            }
        });
        Map map = this.f14368g;
        map.put("command_type", com.mbridge.msdk.newreward.function.command.f.RESTORE_DB);
        this.f14366e.c((Object) map, (com.mbridge.msdk.newreward.a.b.b) new com.mbridge.msdk.newreward.a.b.b() {
            public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            public final void reqSuccessful(Object obj) {
                d.this.b(obj);
            }
        });
        c cVar2 = this.f14366e;
        cVar2.f(cVar2.a("controller_model", this.f14369h, "command_manager", cVar2, "adapter_manager", this));
        int a6 = ah.a().a(MBridgeCommon.SharedPreference.KEY_LOADING_CAPACITY, 1);
        this.f14371j = a6;
        if (a6 <= 0) {
            this.f14371j = 1;
        }
        this.f14372k = a.a();
    }

    public final void b(Object obj) {
        for (com.mbridge.msdk.newreward.function.c.a.b bVar : (List) obj) {
            Integer num = (Integer) this.f14368g.get("mb_ad_type");
            e eVar = new e(false, ((Integer) this.f14368g.get("mb_ad_type")).intValue(), bVar.h(), bVar.e(), bVar.i());
            com.mbridge.msdk.newreward.function.e.a aVar = new com.mbridge.msdk.newreward.function.e.a();
            aVar.a(bVar);
            eVar.a(aVar);
            eVar.a(this.f14365d);
            eVar.f(bVar.g());
            eVar.c(2);
            eVar.a(this.f14367f);
            eVar.f14403a = new g(this.f14366e);
            eVar.a(this.f14364c);
            this.f14362a.add(eVar);
        }
    }

    private void c() {
        try {
            b bVar = this.f14369h;
            if (bVar == null) {
                return;
            }
            if (bVar.a() != null) {
                this.f14366e.a((Object) this.f14369h.a(), com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START, (Object) null);
            } else {
                this.f14366e.a((Object) this.f14369h, com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_START, (Object) null);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    @Nullable
    public final e b() {
        e peek;
        Deque<e> deque = this.f14362a;
        if (deque == null || deque.size() == 0 || (peek = this.f14362a.peek()) == null) {
            return null;
        }
        return peek;
    }

    public final void a(e eVar, b bVar) {
        e peek;
        e eVar2 = eVar;
        b bVar2 = bVar;
        if (eVar2 != null && bVar2 != null) {
            eVar2.a(this.f14365d);
            eVar2.a(this.f14364c);
            eVar2.a(this.f14367f);
            com.mbridge.msdk.newreward.function.g.c cVar = this.f14372k;
            if (cVar != null) {
                eVar2.a(cVar);
            }
            c cVar2 = this.f14366e;
            if (cVar2 != null) {
                cVar2.a((Object) eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_START, (Object) null);
            }
            int integer = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, new Object[]{this.f14369h.c()}), 1);
            this.f14370i = integer;
            if (integer <= 0) {
                this.f14370i = 1;
            }
            if (a(1) < this.f14371j) {
                try {
                    synchronized (this.f14363b) {
                        if (!d(eVar)) {
                            if (a(false)) {
                                if (!eVar2.d()) {
                                    if (!TextUtils.isEmpty(eVar2.J()) && com.mbridge.msdk.newreward.function.h.c.c(eVar2.J())) {
                                        c cVar3 = this.f14366e;
                                        if (((Boolean) cVar3.b((Object) cVar3.a("adapter_model", eVar2, "command_manager", cVar3, "candidate_type", 1, "reason", new com.mbridge.msdk.foundation.c.b(880038)))).booleanValue()) {
                                            eVar2.c(true);
                                            c cVar4 = this.f14366e;
                                            com.mbridge.msdk.newreward.function.a.b bVar3 = (com.mbridge.msdk.newreward.function.a.b) cVar4.b((Object) cVar4.a("adapter_model", eVar2, "command_manager", cVar4, "candidate_type", 2, "reason", new com.mbridge.msdk.foundation.c.b(880038)));
                                            if (bVar3 != null && bVar3.h() == com.mbridge.msdk.newreward.function.a.b.f14465d) {
                                                eVar2.D().a(bVar3.a());
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS);
                                                this.f14364c.onLoadSuccess(this.f14367f);
                                                eVar2.f(true);
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS);
                                                this.f14364c.onVideoLoadSuccess(this.f14367f);
                                                eVar2.h(true);
                                            }
                                        }
                                    }
                                    int integer2 = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, new Object[]{eVar2.H()}), 1);
                                    if (this.f14362a.size() != 0) {
                                        if (this.f14362a.size() >= integer2) {
                                            if (!TextUtils.isEmpty(eVar2.J()) || (peek = this.f14362a.peek()) == null || peek.D() == null || peek.D().b() == null) {
                                                Iterator<e> it = this.f14362a.iterator();
                                                while (true) {
                                                    if (!it.hasNext()) {
                                                        break;
                                                    }
                                                    e next = it.next();
                                                    com.mbridge.msdk.newreward.function.c.a.b b5 = next.D().b();
                                                    if (b5 != null && b5.G() == 1) {
                                                        next.c(eVar2.G());
                                                        eVar2.d(true);
                                                        break;
                                                    }
                                                }
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS);
                                                this.f14364c.onLoadSuccess(this.f14367f);
                                                eVar2.f(true);
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS);
                                                this.f14364c.onVideoLoadSuccess(this.f14367f);
                                                eVar2.h(true);
                                            } else {
                                                eVar2.D().a(peek.D().b());
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_V3_CAMPAIGN_SUCCESS);
                                                this.f14364c.onLoadSuccess(this.f14367f);
                                                eVar2.f(true);
                                                a(eVar2, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS);
                                                this.f14364c.onVideoLoadSuccess(this.f14367f);
                                                eVar2.h(true);
                                            }
                                        }
                                    }
                                }
                            }
                            for (e next2 : this.f14362a) {
                                if (!next2.D().c() && next2.y() == 2) {
                                    this.f14362a.remove(next2);
                                    String str = "";
                                    if (!(next2.D() == null || next2.D().b() == null)) {
                                        str = next2.D().b().a() + "";
                                    }
                                    com.mbridge.msdk.foundation.same.report.d.d.a().b(next2.G(), str);
                                }
                            }
                            b(eVar);
                            while (a(2) > this.f14370i) {
                                this.f14362a.pollFirst();
                            }
                            this.f14362a.add(eVar2);
                            eVar2.f14403a = bVar2;
                            eVar2.b(SystemClock.elapsedRealtime());
                            bVar2.a(eVar2);
                        }
                    }
                } catch (Exception e5) {
                    RewardVideoListener rewardVideoListener = this.f14364c;
                    if (rewardVideoListener != null) {
                        rewardVideoListener.onVideoLoadFail(new MBridgeIds(), e5.getMessage());
                    }
                    a(eVar2, com.mbridge.msdk.foundation.c.a.b(880020, "errorCode: 3501 errorMessage: " + e5.getMessage()));
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(eVar2.h(), eVar2.C(), eVar2.H(), eVar2.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_EXCEPTION);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                RewardVideoListener rewardVideoListener2 = this.f14364c;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onVideoLoadFail(new MBridgeIds(), "current unit is loading");
                }
                a(eVar2, com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading"));
            }
        }
    }

    private void a(e eVar, com.mbridge.msdk.newreward.function.command.f fVar) {
        int i4;
        int i5;
        if (eVar != null) {
            List<CampaignEx> a5 = eVar.D() != null ? eVar.D().a() : null;
            try {
                if (eVar.D() == null || eVar.D().b() == null) {
                    i5 = 0;
                    i4 = 0;
                } else {
                    com.mbridge.msdk.newreward.function.c.a.b b5 = eVar.D().b();
                    i4 = b5.a();
                    i5 = b5.b();
                }
                int filterCallBackState = (a5 == null || a5.isEmpty()) ? 0 : a5.get(0).getFilterCallBackState();
                c cVar = this.f14366e;
                cVar.a((Object) eVar, fVar, (Object) cVar.a("metrics_data", a5, "auto_load", Integer.valueOf(eVar.I() ? 2 : 1), "cache", 1, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i4), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i5), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(filterCallBackState)));
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    private void a(e eVar, com.mbridge.msdk.foundation.c.b bVar) {
        int i4;
        int i5;
        int i6;
        eVar.c(2);
        eVar.h(true);
        if (eVar.D() == null || eVar.D().b() == null) {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        } else {
            com.mbridge.msdk.newreward.function.c.a.b b5 = eVar.D().b();
            i5 = b5.a();
            i4 = b5.b();
            i6 = (b5.E() == null || b5.E().isEmpty()) ? 0 : b5.E().get(0).getFilterCallBackState();
        }
        c cVar = this.f14366e;
        cVar.a((Object) eVar, com.mbridge.msdk.newreward.function.command.f.REPORT_LOAD_FAILED, (Object) cVar.a("metrics_data", bVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i5), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i4), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i6)));
    }

    public final void a(f fVar) {
        synchronized (this.f14363b) {
            try {
                if (this.f14362a.isEmpty()) {
                    this.f14369h.a(com.mbridge.msdk.newreward.function.h.d.a(""));
                    RewardVideoListener rewardVideoListener = this.f14364c;
                    if (rewardVideoListener != null) {
                        rewardVideoListener.onShowFail(this.f14367f, com.mbridge.msdk.foundation.c.a.a(890005));
                    }
                    c();
                    a(com.mbridge.msdk.foundation.c.a.a(890005));
                    return;
                }
                while (a(2) > this.f14370i) {
                    this.f14362a.pollFirst();
                }
                ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
                while (true) {
                    if (this.f14362a.isEmpty()) {
                        break;
                    }
                    try {
                        e peek = this.f14362a.peek();
                        if (peek == null || peek.D() == null || !peek.D().c()) {
                            if (peek == null || peek.y() != 2 || peek.D().c()) {
                                if (this.f14362a.size() == 1) {
                                    RewardVideoListener rewardVideoListener2 = this.f14364c;
                                    if (rewardVideoListener2 != null) {
                                        rewardVideoListener2.onShowFail(this.f14367f, com.mbridge.msdk.foundation.c.a.a(890007));
                                    }
                                    a(peek, com.mbridge.msdk.foundation.c.a.a(890007));
                                }
                                concurrentLinkedDeque.push(this.f14362a.poll());
                            } else {
                                if (this.f14362a.size() == 1) {
                                    this.f14369h.a(peek);
                                    RewardVideoListener rewardVideoListener3 = this.f14364c;
                                    if (rewardVideoListener3 != null) {
                                        rewardVideoListener3.onShowFail(this.f14367f, com.mbridge.msdk.foundation.c.a.a(890006));
                                    }
                                    a(peek, com.mbridge.msdk.foundation.c.a.a(890006));
                                }
                                this.f14362a.poll();
                            }
                        } else if (peek.h() != 287 || !ah.a().a("s_a_w_n_c", true) || ak.l(com.mbridge.msdk.foundation.controller.c.m().c())) {
                            c(peek);
                            b bVar = peek.f14403a;
                            peek.a(fVar);
                            this.f14369h.a(peek);
                            com.mbridge.msdk.newreward.function.command.d.a().a(peek);
                            bVar.b(peek);
                            this.f14362a.poll();
                        } else {
                            RewardVideoListener rewardVideoListener4 = this.f14364c;
                            if (rewardVideoListener4 != null) {
                                rewardVideoListener4.onShowFail(this.f14367f, com.mbridge.msdk.foundation.c.a.a(890011));
                            }
                            a(peek, com.mbridge.msdk.foundation.c.a.a(890011));
                            this.f14362a.poll();
                        }
                    } catch (Exception e5) {
                        if (this.f14362a.size() == 1) {
                            this.f14369h.a(com.mbridge.msdk.newreward.function.h.d.a(""));
                            RewardVideoListener rewardVideoListener5 = this.f14364c;
                            if (rewardVideoListener5 != null) {
                                rewardVideoListener5.onShowFail(this.f14367f, e5.getMessage());
                            }
                            a("show failed, exception is " + e5.getMessage());
                        }
                    }
                }
                while (!concurrentLinkedDeque.isEmpty()) {
                    this.f14362a.push(concurrentLinkedDeque.poll());
                }
                c();
            } catch (Throwable th) {
                c();
                a("show exception: " + th.getMessage());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.mbridge.msdk.newreward.a.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.mbridge.msdk.newreward.b.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(boolean r6) {
        /*
            r5 = this;
            java.util.Deque<com.mbridge.msdk.newreward.a.e> r0 = r5.f14362a
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = r1
        L_0x0008:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0036
            java.lang.Object r3 = r0.next()
            com.mbridge.msdk.newreward.a.e r3 = (com.mbridge.msdk.newreward.a.e) r3
            if (r3 != 0) goto L_0x0017
            goto L_0x0008
        L_0x0017:
            com.mbridge.msdk.newreward.function.e.a r1 = r3.D()
            if (r1 != 0) goto L_0x001e
            goto L_0x0024
        L_0x001e:
            com.mbridge.msdk.newreward.function.c.a.b r4 = r1.b()
            if (r4 != 0) goto L_0x0026
        L_0x0024:
            r1 = r3
            goto L_0x0008
        L_0x0026:
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0033
            r0 = 1
            if (r6 == 0) goto L_0x0032
            r5.a(r0, r3, r4)
        L_0x0032:
            return r0
        L_0x0033:
            r1 = r3
            r2 = r4
            goto L_0x0008
        L_0x0036:
            r0 = 0
            if (r6 == 0) goto L_0x0041
            if (r1 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            com.mbridge.msdk.newreward.b.b r1 = r5.f14369h
        L_0x003e:
            r5.a(r0, r1, r2)
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.d.a(boolean):boolean");
    }

    private void a(boolean z4, Object obj, com.mbridge.msdk.newreward.function.c.a.b bVar) {
        String str;
        if (this.f14366e != null && obj != null) {
            if (z4) {
                try {
                    str = String.valueOf(1);
                } catch (Throwable th) {
                    af.a("reportReadyCheck", th.getMessage());
                    return;
                }
            } else {
                str = String.valueOf(2);
            }
            String isReadyNotReadyReasonType = MBridgeGlobalCommon.getIsReadyNotReadyReasonType(bVar);
            if (z4) {
                c cVar = this.f14366e;
                cVar.a(obj, com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK, (Object) cVar.a("result", str));
                return;
            }
            c cVar2 = this.f14366e;
            cVar2.a(obj, com.mbridge.msdk.newreward.function.command.f.REPORT_IS_READY_CHECK, (Object) cVar2.a("result", str, "type", isReadyNotReadyReasonType));
        }
    }

    private int a(int i4) {
        int i5 = 0;
        if (this.f14362a.size() == 0) {
            return 0;
        }
        for (e next : this.f14362a) {
            if (i4 != 1) {
                if (i4 == 2) {
                    if (!next.D().c()) {
                    }
                }
            } else if (next.y() != 1) {
            }
            i5++;
        }
        return i5;
    }

    private void a(String str) {
        try {
            b bVar = this.f14369h;
            if (bVar != null) {
                c cVar = this.f14366e;
                cVar.a((Object) bVar, com.mbridge.msdk.newreward.function.command.f.REPORT_SHOW_FAIL, (Object) cVar.a("reason", str));
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void a(e eVar, String str) {
        int i4;
        int i5;
        if (eVar != null) {
            try {
                int i6 = 0;
                CampaignEx campaignEx = (eVar.D() == null || eVar.D().a() == null || eVar.D().a().isEmpty()) ? null : eVar.D().a().get(0);
                if (campaignEx != null) {
                    e eVar2 = new e();
                    if (eVar.D() == null || eVar.D().b() == null) {
                        i5 = 0;
                        i4 = 0;
                    } else {
                        com.mbridge.msdk.newreward.function.c.a.b b5 = eVar.D().b();
                        i5 = b5.a();
                        i4 = b5.b();
                        if (b5.E() != null && !b5.E().isEmpty()) {
                            i6 = b5.E().get(0).getFilterCallBackState();
                        }
                    }
                    eVar2.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i6));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i5));
                    eVar2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i4));
                    eVar2.a("reason", str);
                    com.mbridge.msdk.foundation.same.report.d.d.a().a("2000131", campaignEx, eVar2);
                    return;
                }
                a(str);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final List<e> a() {
        ArrayList arrayList = new ArrayList();
        Deque<e> deque = this.f14362a;
        if (!(deque == null || deque.size() == 0)) {
            for (e add : this.f14362a) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }

    public final void a(e eVar) {
        Deque<e> deque;
        if (eVar != null && (deque = this.f14362a) != null) {
            deque.addLast(eVar);
        }
    }
}
