package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.videocommon.listener.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    k f17119a = null;

    /* renamed from: b  reason: collision with root package name */
    k f17120b = null;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f17121c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f17122d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f17123e;

    /* renamed from: f  reason: collision with root package name */
    private String f17124f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ConcurrentHashMap<String, a> f17125g;

    /* renamed from: h  reason: collision with root package name */
    private c f17126h = new c() {
        public final void a(long j4, int i4) {
            if (i4 == 5 || i4 == 4) {
                boolean unused = j.this.f17122d = true;
                j.this.a();
            }
            if (i4 == 2) {
                boolean unused2 = j.this.f17122d = true;
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, a>> f17127i = new CopyOnWriteArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private Context f17128j;

    /* renamed from: k  reason: collision with root package name */
    private long f17129k = 3600;

    /* renamed from: l  reason: collision with root package name */
    private String f17130l;

    /* renamed from: m  reason: collision with root package name */
    private c f17131m;

    /* renamed from: n  reason: collision with root package name */
    private int f17132n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f17133o = 1;

    /* renamed from: p  reason: collision with root package name */
    private i f17134p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17135q;

    public j(Context context, List<CampaignEx> list, String str, int i4) {
        try {
            boolean a5 = h.a.f17107a.a(i4);
            this.f17135q = a5;
            if (a5) {
                this.f17130l = str;
                this.f17133o = i4;
                this.f17134p = new i(list, str, i4);
                return;
            }
        } catch (Exception unused) {
            this.f17134p = null;
            this.f17135q = false;
        }
        this.f17128j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list2 = this.f17121c;
        if (!(list2 == null || list == null)) {
            list2.addAll(list);
        }
        this.f17130l = str;
        this.f17133o = i4;
        b(this.f17121c);
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.f17135q || this.f17134p == null) && !ah.a().a("u_n_c_e_d", true) && (copyOnWriteArrayList = this.f17127i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i4 = 0;
                    while (i4 < this.f17127i.size()) {
                        Map map = this.f17127i.get(i4);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (currentTimeMillis - aVar.g() > this.f17129k * 1000 && aVar.k() == 1) {
                                    aVar.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                    aVar.a(this.f17132n);
                                    aVar.s();
                                    this.f17127i.remove(map);
                                    i4--;
                                }
                                if (!(aVar.k() == 1 || aVar.k() == 5 || aVar.k() == 0)) {
                                    aVar.s();
                                    this.f17127i.remove(map);
                                    i4--;
                                }
                            }
                        }
                        i4++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f17127i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i4 = 0;
                    while (i4 < this.f17127i.size()) {
                        Map map = this.f17127i.get(i4);
                        for (Map.Entry value : map.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar != null) {
                                if (aVar.l() != null) {
                                    if (aVar.f()) {
                                        aVar.r();
                                        this.f17127i.remove(map);
                                        i4--;
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                }
            } catch (Throwable unused) {
                af.b("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    private void f(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                e eVar = new e();
                eVar.a("cache", 1);
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(b(campaignEx)));
                if (b(campaignEx) == 100) {
                    eVar.a("resumed_breakpoint", "2");
                } else {
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("resource_type", 4);
                eVar.a("scenes", "1");
                eVar.a("url", campaignEx.getVideoUrlEncode());
                d.a().a("m_download_start", campaignEx, eVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            return this.f17127i;
        }
        return iVar.d();
    }

    private void b(List<CampaignEx> list) {
        String str;
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if (list != null && list.size() != 0) {
            if (list.get(0) != null) {
                this.f17124f = list.get(0).getCurrentLocalRid();
            }
            e();
            d();
            int i4 = this.f17133o;
            if (i4 != 1) {
                if (i4 != 287) {
                    if (i4 == 298) {
                        k b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                        this.f17120b = b5;
                        if (b5 == null) {
                            this.f17120b = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                        }
                        k kVar = this.f17120b;
                        if (kVar != null) {
                            this.f17129k = kVar.j();
                            this.f17132n = this.f17120b.k();
                        }
                    } else if (i4 != 94) {
                        if (i4 == 95) {
                            try {
                                if (!TextUtils.isEmpty(this.f17130l)) {
                                    k d5 = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                                    if (d5 == null) {
                                        d5 = k.e(this.f17130l);
                                    }
                                    if (d5 != null) {
                                        this.f17129k = d5.j();
                                        this.f17132n = d5.k();
                                    }
                                }
                            } catch (Exception unused) {
                                af.b("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                                return;
                            }
                        }
                    }
                }
                try {
                    com.mbridge.msdk.videocommon.d.a b6 = b.a().b();
                    if (b6 == null) {
                        b.a().c();
                    }
                    if (b6 != null) {
                        this.f17129k = b6.g();
                    }
                    if (!TextUtils.isEmpty(this.f17130l)) {
                        this.f17131m = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                    }
                    c cVar = this.f17131m;
                    if (cVar != null) {
                        this.f17132n = cVar.w();
                    }
                } catch (Exception unused2) {
                    af.b("UnitCacheCtroller", "make sure your had put reward jar into your project");
                    return;
                }
            } else {
                try {
                    if (!TextUtils.isEmpty(this.f17130l)) {
                        k d6 = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                        this.f17119a = d6;
                        if (d6 == null) {
                            this.f17119a = k.d(this.f17130l);
                        }
                        k kVar2 = this.f17119a;
                        if (kVar2 != null) {
                            this.f17129k = kVar2.j();
                            this.f17132n = this.f17119a.k();
                        }
                    }
                } catch (Exception unused3) {
                    af.b("UnitCacheCtroller", "make sure your had put native video jar into your project");
                    return;
                }
            }
            for (int i5 = 0; i5 < list.size(); i5++) {
                CampaignEx campaignEx = list.get(i5);
                if (campaignEx != null) {
                    int i6 = this.f17133o;
                    if (i6 == 94 || i6 == 287) {
                        str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                    } else {
                        str = campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                    }
                    if ((c(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.f17127i) != null) {
                        synchronized (copyOnWriteArrayList) {
                            int i7 = 0;
                            while (true) {
                                try {
                                    if (i7 >= this.f17127i.size()) {
                                        a aVar = new a(this.f17128j, campaignEx, this.f17130l, this.f17132n);
                                        aVar.a(this.f17132n);
                                        aVar.d(this.f17133o);
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(str, aVar);
                                        this.f17127i.add(hashMap);
                                        break;
                                    }
                                    Map map = this.f17127i.get(i7);
                                    if (map == null || !map.containsKey(str)) {
                                        i7++;
                                    } else {
                                        a aVar2 = (a) map.get(str);
                                        if (aVar2 != null) {
                                            aVar2.a(campaignEx);
                                            aVar2.a(this.f17132n);
                                            aVar2.e(false);
                                            map.remove(str);
                                            map.put(str, aVar2);
                                            this.f17127i.set(i7, map);
                                        }
                                        f(campaignEx);
                                    }
                                } catch (Throwable th) {
                                    if (MBridgeConstans.DEBUG) {
                                        af.b("UnitCacheCtroller", th.getMessage());
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
            }
            List<CampaignEx> list2 = this.f17121c;
            if (list2 != null && list2.size() > 0) {
                this.f17121c.clear();
            }
        }
    }

    public final void a(a aVar) {
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            this.f17123e = aVar;
        } else {
            iVar.a(aVar);
        }
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final void a(String str, a aVar) {
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            if (this.f17125g == null) {
                this.f17125g = new ConcurrentHashMap<>();
            }
            if (aVar != null && !TextUtils.isEmpty(str)) {
                this.f17125g.put(str, aVar);
                return;
            }
            return;
        }
        iVar.a(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            List<CampaignEx> list2 = this.f17121c;
            if (!(list2 == null || list == null)) {
                list2.addAll(list);
            }
            b(this.f17121c);
            return;
        }
        iVar.a(list);
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f17120b == null) {
                    this.f17120b = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l);
                }
                return this.f17120b.p();
            } else if (campaignEx.getAdType() == 42) {
                return d((CampaignEx) null);
            } else {
                if (this.f17131m == null) {
                    this.f17131m = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f17130l, false);
                }
                return this.f17131m.r();
            }
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }

    public final void a(CampaignEx campaignEx) {
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            List<CampaignEx> list = this.f17121c;
            if (!(list == null || campaignEx == null)) {
                list.add(campaignEx);
            }
            b(this.f17121c);
            return;
        }
        iVar.a(campaignEx);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01f5, code lost:
        if (r0 != 94) goto L_0x0209;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0183 A[SYNTHETIC, Splitter:B:99:0x0183] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.lang.String r26, int r27, boolean r28, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r29, boolean r30, com.mbridge.msdk.foundation.same.report.d.e r31) {
        /*
            r25 = this;
            r1 = r25
            r0 = r27
            r2 = r30
            r3 = r31
            boolean r4 = r1.f17135q
            if (r4 == 0) goto L_0x0017
            com.mbridge.msdk.videocommon.download.i r4 = r1.f17134p
            if (r4 == 0) goto L_0x0017
            r5 = r29
            java.util.List r0 = r4.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r5, (boolean) r2)
            return r0
        L_0x0017:
            r5 = r29
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r6 = ""
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r7 = r1.f17127i
            if (r7 == 0) goto L_0x028a
            monitor-enter(r7)
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00c5 }
            r11 = 0
        L_0x002a:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r12 = r1.f17127i     // Catch:{ Exception -> 0x00c5 }
            int r12 = r12.size()     // Catch:{ Exception -> 0x00c5 }
            if (r11 >= r12) goto L_0x0280
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r12 = r1.f17127i     // Catch:{ Exception -> 0x00c5 }
            java.lang.Object r12 = r12.get(r11)     // Catch:{ Exception -> 0x00c5 }
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x00c5 }
            java.util.Set r13 = r12.entrySet()     // Catch:{ Exception -> 0x00c5 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ Exception -> 0x00c5 }
        L_0x0042:
            boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x026c }
            if (r14 == 0) goto L_0x0274
            java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x026c }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ Exception -> 0x026c }
            java.lang.Object r14 = r14.getValue()     // Catch:{ Exception -> 0x026c }
            com.mbridge.msdk.videocommon.download.a r14 = (com.mbridge.msdk.videocommon.download.a) r14     // Catch:{ Exception -> 0x026c }
            if (r14 == 0) goto L_0x005c
            com.mbridge.msdk.foundation.entity.CampaignEx r15 = r14.l()     // Catch:{ Exception -> 0x026c }
            if (r15 != 0) goto L_0x0064
        L_0x005c:
            r16 = r6
            r22 = r7
            r20 = r8
            goto L_0x0271
        L_0x0064:
            com.mbridge.msdk.foundation.entity.CampaignEx r15 = r14.l()     // Catch:{ Exception -> 0x026c }
            java.util.Iterator r16 = r5.iterator()     // Catch:{ Exception -> 0x026c }
            r17 = 0
        L_0x006e:
            boolean r18 = r16.hasNext()     // Catch:{ Exception -> 0x026c }
            if (r18 == 0) goto L_0x00cf
            java.lang.Object r18 = r16.next()     // Catch:{ Exception -> 0x00c5 }
            com.mbridge.msdk.foundation.entity.CampaignEx r18 = (com.mbridge.msdk.foundation.entity.CampaignEx) r18     // Catch:{ Exception -> 0x00c5 }
            if (r15 == 0) goto L_0x00cc
            if (r18 == 0) goto L_0x00cc
            java.lang.String r19 = r15.getRequestId()     // Catch:{ Exception -> 0x00c5 }
            boolean r19 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x00c5 }
            if (r19 != 0) goto L_0x00cc
            java.lang.String r19 = r18.getRequestId()     // Catch:{ Exception -> 0x00c5 }
            boolean r19 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x00c5 }
            if (r19 != 0) goto L_0x00cc
            java.lang.String r10 = r15.getId()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r5 = r18.getId()     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = r10.equals(r5)     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x00cc
            java.lang.String r5 = r15.getRequestId()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r10 = r18.getRequestId()     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x00cc
            java.lang.String r5 = r18.getNLRid()     // Catch:{ Exception -> 0x00c5 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00c5 }
            if (r5 != 0) goto L_0x00ca
            java.lang.String r5 = r18.getNLRid()     // Catch:{ Exception -> 0x00c5 }
            r15.setNLRid(r5)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00ca
        L_0x00c0:
            r0 = move-exception
            r22 = r7
            goto L_0x0288
        L_0x00c5:
            r0 = move-exception
        L_0x00c6:
            r22 = r7
            goto L_0x0283
        L_0x00ca:
            r17 = 1
        L_0x00cc:
            r5 = r29
            goto L_0x006e
        L_0x00cf:
            if (r17 != 0) goto L_0x00d7
            java.lang.String r6 = "campaign is not available"
            r5 = r29
            goto L_0x0042
        L_0x00d7:
            if (r28 == 0) goto L_0x00e6
            boolean r5 = r15.isBidCampaign()     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x00e0
            goto L_0x00e6
        L_0x00e0:
            r16 = r6
            r20 = r8
            goto L_0x016a
        L_0x00e6:
            if (r28 != 0) goto L_0x00ef
            boolean r5 = r15.isBidCampaign()     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x00ef
            goto L_0x00e0
        L_0x00ef:
            java.lang.String r5 = r15.getendcard_url()     // Catch:{ Exception -> 0x026c }
            java.lang.String r10 = r15.getVideoUrlEncode()     // Catch:{ Exception -> 0x026c }
            java.lang.String r16 = ""
            com.mbridge.msdk.foundation.entity.CampaignEx$c r17 = r15.getRewardTemplateMode()     // Catch:{ Exception -> 0x026c }
            if (r17 == 0) goto L_0x0107
            com.mbridge.msdk.foundation.entity.CampaignEx$c r16 = r15.getRewardTemplateMode()     // Catch:{ Exception -> 0x00c5 }
            java.lang.String r16 = r16.e()     // Catch:{ Exception -> 0x00c5 }
        L_0x0107:
            r17 = r16
            r15.getRewardTemplateMode()     // Catch:{ Exception -> 0x026c }
            r16 = r6
            r6 = 287(0x11f, float:4.02E-43)
            r20 = r8
            r8 = 94
            if (r0 == r8) goto L_0x011c
            if (r0 != r6) goto L_0x0119
            goto L_0x011c
        L_0x0119:
            r6 = r16
            goto L_0x0174
        L_0x011c:
            boolean r9 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x013a }
            if (r9 != 0) goto L_0x0141
            java.lang.String r9 = "cmpt=1"
            r6 = r17
            boolean r9 = r6.contains(r9)     // Catch:{ Exception -> 0x013a }
            if (r9 != 0) goto L_0x0141
            boolean r6 = r1.a((int) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r15, (java.lang.String) r6)     // Catch:{ Exception -> 0x013a }
            if (r6 != 0) goto L_0x0141
            java.lang.String r6 = "template is null or download is not ready"
        L_0x0134:
            r5 = r29
        L_0x0136:
            r8 = r20
            goto L_0x0042
        L_0x013a:
            r0 = move-exception
            r22 = r7
        L_0x013d:
            r6 = r16
            goto L_0x0283
        L_0x0141:
            boolean r6 = r1.b((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x013a }
            if (r6 == 0) goto L_0x0172
            boolean r6 = r14.f()     // Catch:{ Exception -> 0x013a }
            if (r6 == 0) goto L_0x0153
            r14.r()     // Catch:{ Exception -> 0x013a }
            java.lang.String r6 = "task is displayed"
            goto L_0x0134
        L_0x0153:
            boolean r6 = com.mbridge.msdk.foundation.tools.ap.a(r10)     // Catch:{ Exception -> 0x013a }
            if (r6 == 0) goto L_0x015d
            r4.add(r14)     // Catch:{ Exception -> 0x013a }
            goto L_0x016a
        L_0x015d:
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x013a }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r14, (int) r6, (boolean) r2)     // Catch:{ Exception -> 0x013a }
            if (r6 == 0) goto L_0x016f
            r4.add(r14)     // Catch:{ Exception -> 0x013a }
        L_0x016a:
            r5 = r29
            r6 = r16
            goto L_0x0136
        L_0x016f:
            java.lang.String r6 = "video and image list is downloading or fail"
            goto L_0x0174
        L_0x0172:
            java.lang.String r6 = "endcard is downloading or fail"
        L_0x0174:
            java.lang.String r9 = r14.q()     // Catch:{ Exception -> 0x026c }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x026c }
            int r10 = r14.k()     // Catch:{ Exception -> 0x026c }
            r8 = 5
            if (r10 != r8) goto L_0x01b5
            boolean r8 = r14.f()     // Catch:{ Exception -> 0x00c5 }
            if (r8 == 0) goto L_0x0196
            r14.r()     // Catch:{ Exception -> 0x00c5 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r5 = r1.f17127i     // Catch:{ Exception -> 0x00c5 }
            r5.remove(r12)     // Catch:{ Exception -> 0x00c5 }
            int r11 = r11 + -1
            java.lang.String r6 = "task is displayed"
            goto L_0x0134
        L_0x0196:
            if (r9 != 0) goto L_0x01a7
            r8 = 0
            r14.a((int) r8, (int) r8)     // Catch:{ Exception -> 0x00c5 }
            r5 = 95
            if (r0 != r5) goto L_0x01a4
            r4.add(r14)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0134
        L_0x01a4:
            java.lang.String r6 = "resource path is not effective"
            goto L_0x0134
        L_0x01a7:
            r8 = 0
            boolean r5 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x00c5 }
            if (r5 == 0) goto L_0x01b2
            r4.add(r14)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x0134
        L_0x01b2:
            r0 = 0
            monitor-exit(r7)     // Catch:{ all -> 0x00c0 }
            return r0
        L_0x01b5:
            r8 = 0
            com.mbridge.msdk.foundation.tools.ah r9 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x026c }
            java.lang.String r8 = "u_n_c_e_d"
            r16 = r6
            r6 = 1
            boolean r8 = r9.a((java.lang.String) r8, (boolean) r6)     // Catch:{ Exception -> 0x013a }
            if (r8 != 0) goto L_0x0222
            long r8 = r14.g()     // Catch:{ Exception -> 0x013a }
            r22 = r8
            int r8 = r14.k()     // Catch:{ Exception -> 0x013a }
            if (r8 != r6) goto L_0x0205
            long r8 = r20 - r22
            r22 = r7
            long r6 = r1.f17129k     // Catch:{ Exception -> 0x0202 }
            r23 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r23
            int r23 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r23 <= 0) goto L_0x0207
            java.lang.String r6 = "download timeout"
            r14.b((java.lang.String) r6)     // Catch:{ Exception -> 0x0202 }
            r14.s()     // Catch:{ Exception -> 0x0202 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r6 = r1.f17127i     // Catch:{ Exception -> 0x0202 }
            r6.remove(r12)     // Catch:{ Exception -> 0x0202 }
            int r11 = r11 + -1
            java.lang.String r6 = "video download time over dlct"
            r7 = 1
            if (r0 == r7) goto L_0x01f7
            r7 = 94
            if (r0 != r7) goto L_0x0209
        L_0x01f7:
            r5 = r29
            r8 = r20
            r7 = r22
            goto L_0x0042
        L_0x01ff:
            r0 = move-exception
            goto L_0x0288
        L_0x0202:
            r0 = move-exception
            goto L_0x013d
        L_0x0205:
            r22 = r7
        L_0x0207:
            r6 = r16
        L_0x0209:
            r7 = 4
            if (r10 == r7) goto L_0x0212
            r7 = 2
            if (r10 != r7) goto L_0x0210
            goto L_0x0212
        L_0x0210:
            r7 = 1
            goto L_0x0227
        L_0x0212:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r5 = r1.f17127i     // Catch:{ Exception -> 0x021f }
            r5.remove(r12)     // Catch:{ Exception -> 0x021f }
            r14.s()     // Catch:{ Exception -> 0x021f }
            int r11 = r11 + -1
            java.lang.String r6 = "video download stop or pause"
            goto L_0x01f7
        L_0x021f:
            r0 = move-exception
            goto L_0x0283
        L_0x0222:
            r22 = r7
            r6 = r16
            goto L_0x0210
        L_0x0227:
            if (r10 != r7) goto L_0x024c
            boolean r7 = r14.f()     // Catch:{ Exception -> 0x021f }
            if (r7 == 0) goto L_0x0232
            java.lang.String r6 = "video was displayed"
            goto L_0x01f7
        L_0x0232:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY     // Catch:{ Exception -> 0x021f }
            if (r7 != 0) goto L_0x024c
            int r7 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x021f }
            boolean r7 = a((com.mbridge.msdk.videocommon.download.a) r14, (int) r7, (boolean) r2)     // Catch:{ Exception -> 0x021f }
            if (r7 == 0) goto L_0x024a
            boolean r7 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x021f }
            if (r7 == 0) goto L_0x024a
            r4.add(r14)     // Catch:{ Exception -> 0x021f }
            goto L_0x01f7
        L_0x024a:
            java.lang.String r6 = "video or endcard or image list is downloading or fail"
        L_0x024c:
            r7 = 94
            if (r0 == r7) goto L_0x0254
            r7 = 287(0x11f, float:4.02E-43)
            if (r0 != r7) goto L_0x01f7
        L_0x0254:
            int r7 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x021f }
            boolean r7 = a((com.mbridge.msdk.videocommon.download.a) r14, (int) r7, (boolean) r2)     // Catch:{ Exception -> 0x021f }
            if (r7 == 0) goto L_0x0268
            boolean r5 = r1.a((java.lang.String) r5, (com.mbridge.msdk.foundation.entity.CampaignEx) r15)     // Catch:{ Exception -> 0x021f }
            if (r5 == 0) goto L_0x0268
            r4.add(r14)     // Catch:{ Exception -> 0x021f }
            goto L_0x01f7
        L_0x0268:
            java.lang.String r5 = "video or endcard or image list is downloading or fail"
            r6 = r5
            goto L_0x01f7
        L_0x026c:
            r0 = move-exception
            r16 = r6
            goto L_0x00c6
        L_0x0271:
            java.lang.String r6 = "task or task's campaign is NULL"
            goto L_0x01f7
        L_0x0274:
            r16 = r6
            r22 = r7
            r20 = r8
            int r11 = r11 + 1
            r5 = r29
            goto L_0x002a
        L_0x0280:
            r22 = r7
            goto L_0x0286
        L_0x0283:
            r0.printStackTrace()     // Catch:{ all -> 0x01ff }
        L_0x0286:
            monitor-exit(r22)     // Catch:{ all -> 0x01ff }
            goto L_0x028a
        L_0x0288:
            monitor-exit(r22)     // Catch:{ all -> 0x01ff }
            throw r0
        L_0x028a:
            int r0 = r4.size()     // Catch:{ all -> 0x0298 }
            if (r0 != 0) goto L_0x02a2
            if (r3 == 0) goto L_0x02a2
            java.lang.String r0 = "is_ready_fail_reason"
            r3.a(r0, r6)     // Catch:{ all -> 0x0298 }
            goto L_0x02a2
        L_0x0298:
            r0 = move-exception
            java.lang.String r2 = "UnitCacheCtroller"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
        L_0x02a2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a(java.lang.String, int, boolean, java.util.List, boolean, com.mbridge.msdk.foundation.same.report.d.e):java.util.List");
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.f17119a;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.b("UnitCacheCtroller", e5.getMessage());
            return 100;
        }
    }

    public j(Context context, CampaignEx campaignEx, String str, int i4) {
        try {
            boolean a5 = h.a.f17107a.a(i4);
            this.f17135q = a5;
            if (a5) {
                this.f17130l = str;
                this.f17133o = i4;
                this.f17134p = new i(campaignEx, str, i4);
                return;
            }
        } catch (Exception unused) {
            this.f17134p = null;
            this.f17135q = false;
        }
        this.f17128j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list = this.f17121c;
        if (!(list == null || campaignEx == null)) {
            list.add(campaignEx);
        }
        this.f17130l = str;
        this.f17133o = i4;
        b(this.f17121c);
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return e(campaignEx);
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
            af.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } else if (!ap.b(H5DownLoadManager.getInstance().getH5ResAddress(str)) && !ap.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str))) {
            return false;
        } else {
            return true;
        }
    }

    public final a b(int i4, boolean z4) {
        i iVar;
        if (this.f17135q && (iVar = this.f17134p) != null) {
            return iVar.c();
        }
        try {
            return a(i4, z4);
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.f17135q || this.f17134p == null) && (copyOnWriteArrayList = this.f17127i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, a>> it = this.f17127i.iterator();
                    while (it.hasNext()) {
                        Map next = it.next();
                        if (next != null) {
                            for (Map.Entry value : next.entrySet()) {
                                a aVar = (a) value.getValue();
                                if (aVar != null) {
                                    if (aVar.k() == 1) {
                                        aVar.b("playing and stop download");
                                        aVar.s();
                                        this.f17127i.remove(next);
                                        return;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("UnitCacheCtroller", th.getMessage());
                }
            }
        }
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        i iVar;
        if (!this.f17135q || (iVar = this.f17134p) == null) {
            try {
                synchronized (this.f17127i) {
                    if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f17127i) != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<Map<String, a>> it = this.f17127i.iterator();
                        while (it.hasNext()) {
                            Map next = it.next();
                            if (next != null) {
                                for (Map.Entry entry : next.entrySet()) {
                                    if (entry != null && TextUtils.equals((CharSequence) entry.getKey(), str)) {
                                        this.f17127i.remove(next);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("UnitCacheCtroller", e5.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            iVar.b(str);
        }
    }

    public final boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            CampaignEx campaignEx = list.get(i4);
            if (campaignEx == null || !a(new a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str, this.f17132n), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01f0, code lost:
        if (r0 != 94) goto L_0x01ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0205 A[Catch:{ Exception -> 0x01fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0218 A[SYNTHETIC, Splitter:B:153:0x0218] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[Catch:{ Exception -> 0x0037 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.download.a a(int r25, boolean r26) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            boolean r3 = r1.f17135q
            if (r3 == 0) goto L_0x0013
            com.mbridge.msdk.videocommon.download.i r3 = r1.f17134p
            if (r3 == 0) goto L_0x0013
            com.mbridge.msdk.videocommon.download.a r0 = r3.b()
            return r0
        L_0x0013:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r3 = r1.f17127i
            r4 = 0
            if (r3 == 0) goto L_0x02a3
            monitor-enter(r3)
            int r5 = r1.f17133o     // Catch:{ Exception -> 0x0037 }
            r6 = 287(0x11f, float:4.02E-43)
            r7 = 94
            r8 = 1
            if (r5 == r7) goto L_0x003d
            if (r5 != r6) goto L_0x0025
            goto L_0x003d
        L_0x0025:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r9 = r1.f17130l     // Catch:{ Exception -> 0x0037 }
            java.util.concurrent.CopyOnWriteArrayList r5 = r5.a((java.lang.String) r9, (int) r8)     // Catch:{ Exception -> 0x0037 }
            if (r5 != 0) goto L_0x007b
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x0033:
            r0 = move-exception
            r6 = r3
            goto L_0x02a1
        L_0x0037:
            r0 = move-exception
            r6 = r3
            r16 = r4
            goto L_0x029c
        L_0x003d:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r9 = r1.f17130l     // Catch:{ Exception -> 0x0037 }
            java.util.List r5 = r5.a((java.lang.String) r9, (int) r8, (boolean) r2)     // Catch:{ Exception -> 0x0037 }
            if (r5 == 0) goto L_0x004f
            int r9 = r5.size()     // Catch:{ Exception -> 0x0037 }
            if (r9 != 0) goto L_0x005f
        L_0x004f:
            if (r0 == r7) goto L_0x0053
            if (r0 != r6) goto L_0x005f
        L_0x0053:
            com.mbridge.msdk.videocommon.a.a r5 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r9 = r1.f17130l     // Catch:{ Exception -> 0x0037 }
            java.lang.String r10 = ""
            java.util.List r5 = r5.c(r9, r8, r2, r10)     // Catch:{ Exception -> 0x0037 }
        L_0x005f:
            if (r5 == 0) goto L_0x0290
            java.lang.String r9 = "UnitCacheCtroller"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0037 }
            r10.<init>()     // Catch:{ Exception -> 0x0037 }
            java.lang.String r11 = "UnitCache isReady campaignList = "
            r10.append(r11)     // Catch:{ Exception -> 0x0037 }
            int r11 = r5.size()     // Catch:{ Exception -> 0x0037 }
            r10.append(r11)     // Catch:{ Exception -> 0x0037 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0037 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x0037 }
        L_0x007b:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0037 }
            r12 = 0
        L_0x0080:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.f17127i     // Catch:{ Exception -> 0x0037 }
            int r13 = r13.size()     // Catch:{ Exception -> 0x0037 }
            if (r12 >= r13) goto L_0x028c
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r13 = r1.f17127i     // Catch:{ Exception -> 0x0037 }
            java.lang.Object r13 = r13.get(r12)     // Catch:{ Exception -> 0x0037 }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ Exception -> 0x0037 }
            java.util.Set r14 = r13.entrySet()     // Catch:{ Exception -> 0x0037 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0037 }
        L_0x0098:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0037 }
            if (r15 == 0) goto L_0x0276
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0037 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ Exception -> 0x0037 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ Exception -> 0x0037 }
            com.mbridge.msdk.videocommon.download.a r15 = (com.mbridge.msdk.videocommon.download.a) r15     // Catch:{ Exception -> 0x0037 }
            if (r15 == 0) goto L_0x00b2
            com.mbridge.msdk.foundation.entity.CampaignEx r16 = r15.l()     // Catch:{ Exception -> 0x0037 }
            if (r16 != 0) goto L_0x00bc
        L_0x00b2:
            r6 = r3
            r16 = r4
        L_0x00b5:
            r2 = 94
            r3 = 287(0x11f, float:4.02E-43)
            r11 = 1
            goto L_0x01f2
        L_0x00bc:
            r16 = r4
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r15.l()     // Catch:{ Exception -> 0x00e6 }
            java.util.Iterator r17 = r5.iterator()     // Catch:{ Exception -> 0x00e6 }
            r18 = 0
        L_0x00c8:
            boolean r19 = r17.hasNext()     // Catch:{ Exception -> 0x00e6 }
            if (r19 == 0) goto L_0x00ea
            java.lang.Object r19 = r17.next()     // Catch:{ Exception -> 0x00e6 }
            com.mbridge.msdk.foundation.entity.CampaignEx r19 = (com.mbridge.msdk.foundation.entity.CampaignEx) r19     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = r4.getId()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r11 = r19.getId()     // Catch:{ Exception -> 0x00e6 }
            boolean r8 = r8.equals(r11)     // Catch:{ Exception -> 0x00e6 }
            if (r8 == 0) goto L_0x00e4
            r18 = 1
        L_0x00e4:
            r8 = 1
            goto L_0x00c8
        L_0x00e6:
            r0 = move-exception
            r6 = r3
            goto L_0x029c
        L_0x00ea:
            if (r18 != 0) goto L_0x00ee
        L_0x00ec:
            r6 = r3
            goto L_0x00b5
        L_0x00ee:
            if (r2 == 0) goto L_0x00f6
            boolean r8 = r4.isBidCampaign()     // Catch:{ Exception -> 0x00e6 }
            if (r8 == 0) goto L_0x00ec
        L_0x00f6:
            if (r2 != 0) goto L_0x00ff
            boolean r8 = r4.isBidCampaign()     // Catch:{ Exception -> 0x00e6 }
            if (r8 == 0) goto L_0x00ff
            goto L_0x00ec
        L_0x00ff:
            java.lang.String r8 = r4.getendcard_url()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r11 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r17 = ""
            com.mbridge.msdk.foundation.entity.CampaignEx$c r18 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x00e6 }
            if (r18 == 0) goto L_0x0117
            com.mbridge.msdk.foundation.entity.CampaignEx$c r17 = r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r17 = r17.e()     // Catch:{ Exception -> 0x00e6 }
        L_0x0117:
            r18 = r17
            r4.getRewardTemplateMode()     // Catch:{ Exception -> 0x00e6 }
            int r6 = r1.f17133o     // Catch:{ Exception -> 0x00e6 }
            if (r6 == r7) goto L_0x0124
            r6 = 287(0x11f, float:4.02E-43)
            if (r0 != r6) goto L_0x0161
        L_0x0124:
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ Exception -> 0x00e6 }
            if (r6 != 0) goto L_0x013d
            java.lang.String r6 = "cmpt=1"
            r7 = r18
            boolean r6 = r7.contains(r6)     // Catch:{ Exception -> 0x00e6 }
            if (r6 != 0) goto L_0x013d
            int r6 = r1.f17133o     // Catch:{ Exception -> 0x00e6 }
            boolean r6 = r1.a((int) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x00e6 }
            if (r6 != 0) goto L_0x013d
            goto L_0x00ec
        L_0x013d:
            boolean r6 = r1.b((java.lang.String) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x00e6 }
            if (r6 == 0) goto L_0x0161
            boolean r6 = r15.f()     // Catch:{ Exception -> 0x00e6 }
            if (r6 == 0) goto L_0x014d
            r15.r()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00ec
        L_0x014d:
            boolean r6 = com.mbridge.msdk.foundation.tools.ap.a(r11)     // Catch:{ Exception -> 0x00e6 }
            if (r6 == 0) goto L_0x0155
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r15
        L_0x0155:
            int r6 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x00e6 }
            boolean r6 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r6)     // Catch:{ Exception -> 0x00e6 }
            if (r6 == 0) goto L_0x0161
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r15
        L_0x0161:
            java.lang.String r6 = r15.q()     // Catch:{ Exception -> 0x00e6 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00e6 }
            int r7 = r15.k()     // Catch:{ Exception -> 0x00e6 }
            int r11 = r1.f17133o     // Catch:{ Exception -> 0x00e6 }
            r0 = 298(0x12a, float:4.18E-43)
            if (r11 != r0) goto L_0x017f
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x00e6 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r0)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x017f
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r15
        L_0x017f:
            r0 = 5
            r11 = 95
            if (r7 != r0) goto L_0x01b5
            boolean r0 = r15.f()     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x019f
            r15.r()     // Catch:{ Exception -> 0x00e6 }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ Exception -> 0x00e6 }
            r0.remove(r13)     // Catch:{ Exception -> 0x00e6 }
            int r12 = r12 + -1
            r0 = r25
        L_0x0196:
            r4 = r16
            r6 = 287(0x11f, float:4.02E-43)
            r7 = 94
            r8 = 1
            goto L_0x0098
        L_0x019f:
            if (r6 != 0) goto L_0x01ab
            r0 = 0
            r15.a((int) r0, (int) r0)     // Catch:{ Exception -> 0x00e6 }
            int r4 = r1.f17133o     // Catch:{ Exception -> 0x00e6 }
            if (r4 != r11) goto L_0x00ec
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r15
        L_0x01ab:
            boolean r0 = r1.a((java.lang.String) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x00e6 }
            if (r0 == 0) goto L_0x01b3
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r15
        L_0x01b3:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return r16
        L_0x01b5:
            r0 = 0
            com.mbridge.msdk.foundation.tools.ah r6 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r0 = "u_n_c_e_d"
            r11 = 1
            boolean r0 = r6.a((java.lang.String) r0, (boolean) r11)     // Catch:{ Exception -> 0x00e6 }
            if (r0 != 0) goto L_0x01fe
            long r20 = r15.g()     // Catch:{ Exception -> 0x00e6 }
            int r0 = r15.k()     // Catch:{ Exception -> 0x00e6 }
            if (r0 != r11) goto L_0x01fe
            long r20 = r9 - r20
            r6 = r3
            long r2 = r1.f17129k     // Catch:{ Exception -> 0x01fb }
            r22 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r22
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01ff
            java.lang.String r0 = "download timeout"
            r15.b((java.lang.String) r0)     // Catch:{ Exception -> 0x01fb }
            r15.s()     // Catch:{ Exception -> 0x01fb }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ Exception -> 0x01fb }
            r0.remove(r13)     // Catch:{ Exception -> 0x01fb }
            int r12 = r12 + -1
            int r0 = r1.f17133o     // Catch:{ Exception -> 0x01fb }
            r11 = 1
            if (r0 == r11) goto L_0x01f2
            r2 = 94
            if (r0 != r2) goto L_0x01ff
        L_0x01f2:
            r0 = r25
            r2 = r26
            r3 = r6
            goto L_0x0196
        L_0x01f8:
            r0 = move-exception
            goto L_0x02a1
        L_0x01fb:
            r0 = move-exception
            goto L_0x029c
        L_0x01fe:
            r6 = r3
        L_0x01ff:
            int r0 = r1.f17133o     // Catch:{ Exception -> 0x01fb }
            r2 = 95
            if (r0 != r2) goto L_0x0218
            boolean r0 = r15.f()     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x0216
            r15.r()     // Catch:{ Exception -> 0x01fb }
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ Exception -> 0x01fb }
            r0.remove(r13)     // Catch:{ Exception -> 0x01fb }
        L_0x0213:
            int r12 = r12 + -1
            goto L_0x01f2
        L_0x0216:
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            return r15
        L_0x0218:
            com.mbridge.msdk.foundation.tools.ah r0 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x01fb }
            java.lang.String r2 = "u_n_c_e_d"
            r11 = 1
            boolean r0 = r0.a((java.lang.String) r2, (boolean) r11)     // Catch:{ Exception -> 0x01fb }
            if (r0 != 0) goto L_0x022c
            r0 = 4
            if (r7 == r0) goto L_0x022e
            r0 = 2
            if (r7 != r0) goto L_0x022c
            goto L_0x022e
        L_0x022c:
            r11 = 1
            goto L_0x0237
        L_0x022e:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ Exception -> 0x01fb }
            r0.remove(r13)     // Catch:{ Exception -> 0x01fb }
            r15.s()     // Catch:{ Exception -> 0x01fb }
            goto L_0x0213
        L_0x0237:
            if (r7 != r11) goto L_0x025a
            boolean r0 = r15.f()     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x0244
            r2 = 94
            r3 = 287(0x11f, float:4.02E-43)
            goto L_0x01f2
        L_0x0244:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY     // Catch:{ Exception -> 0x01fb }
            if (r0 != 0) goto L_0x025a
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01fb }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r0)     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x025a
            boolean r0 = r1.a((java.lang.String) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x025a
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            return r15
        L_0x025a:
            int r0 = r1.f17133o     // Catch:{ Exception -> 0x01fb }
            r2 = 94
            r3 = 287(0x11f, float:4.02E-43)
            if (r0 == r2) goto L_0x0264
            if (r0 != r3) goto L_0x01f2
        L_0x0264:
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01fb }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r15, (int) r0)     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x01f2
            boolean r0 = r1.a((java.lang.String) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r4)     // Catch:{ Exception -> 0x01fb }
            if (r0 == 0) goto L_0x01f2
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            return r15
        L_0x0276:
            r6 = r3
            r16 = r4
            r2 = 94
            r3 = 287(0x11f, float:4.02E-43)
            r11 = 1
            int r12 = r12 + 1
            r0 = r25
            r2 = r26
            r3 = r6
            r6 = 287(0x11f, float:4.02E-43)
            r7 = 94
            r8 = 1
            goto L_0x0080
        L_0x028c:
            r6 = r3
            r16 = r4
            goto L_0x029f
        L_0x0290:
            r6 = r3
            r16 = r4
            java.lang.String r0 = "UnitCacheCtroller"
            java.lang.String r2 = "UnitCache isReady campaignList = 0"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x01fb }
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            return r16
        L_0x029c:
            r0.printStackTrace()     // Catch:{ all -> 0x01f8 }
        L_0x029f:
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            goto L_0x02a5
        L_0x02a1:
            monitor-exit(r6)     // Catch:{ all -> 0x01f8 }
            throw r0
        L_0x02a3:
            r16 = r4
        L_0x02a5:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a(int, boolean):com.mbridge.msdk.videocommon.download.a");
    }

    public static boolean a(a aVar, int i4) {
        long m4 = aVar.m();
        long j4 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            af.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i4 == 0) {
            if (aVar.l() == null || TextUtils.isEmpty(aVar.l().getVideoUrlEncode())) {
                return false;
            }
            return true;
        } else if (j4 > 0 && m4 * 100 >= j4 * ((long) i4)) {
            if (i4 != 100 || aVar.k() == 5) {
                return true;
            }
            aVar.s();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i4, boolean z4) {
        long m4 = aVar.m();
        long j4 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            af.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx l4 = aVar.l();
        if (l4 != null) {
            if (l4.getRsIgnoreCheckRule() != null && l4.getRsIgnoreCheckRule().size() > 0 && l4.getRsIgnoreCheckRule().contains(0)) {
                af.c("UnitCacheCtroller", "Is not check video download status");
                return true;
            } else if (l4.getIsTimeoutCheckVideoStatus() == 1 && l4.getVideoCheckType() == 1) {
                return true;
            } else {
                if (z4 && l4.getVideoCheckType() == 1) {
                    if (i4 == 0) {
                        return true;
                    }
                    if (!(j4 == 0 && m4 == 0) && m4 >= ((long) (i4 / 100)) * j4) {
                        l4.setIsTimeoutCheckVideoStatus(1);
                        return true;
                    }
                }
            }
        }
        return a(aVar, i4);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                af.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
                return true;
            } else if ((!campaignEx.isDynamicView() || ak.l(str)) && !ap.a(str) && !b(str, campaignEx)) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            af.b("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean a(int i4, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
            if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
                af.a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
                if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                    return false;
                }
            }
            return true;
        }
        af.c("UnitCacheCtroller", "Is not check template download status");
        return true;
    }

    public final a a(String str) {
        i iVar;
        if (this.f17135q && (iVar = this.f17134p) != null) {
            return iVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f17127i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                Iterator<Map<String, a>> it = this.f17127i.iterator();
                while (it.hasNext()) {
                    Map next = it.next();
                    if (next != null && next.containsKey(str)) {
                        a aVar = (a) next.get(str);
                        return aVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return null;
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map next = it.next();
                if (next != null) {
                    for (Map.Entry value : next.entrySet()) {
                        if (((a) value.getValue()).k() == 1) {
                            return true;
                        }
                    }
                    continue;
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x01dd A[Catch:{ Exception -> 0x0180, all -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01db A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00df A[Catch:{ Exception -> 0x0180, all -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x012e A[Catch:{ Exception -> 0x0180, all -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0133 A[Catch:{ Exception -> 0x0180, all -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0167 A[Catch:{ Exception -> 0x0180, all -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r1.f17135q
            if (r0 == 0) goto L_0x000e
            com.mbridge.msdk.videocommon.download.i r0 = r1.f17134p
            if (r0 == 0) goto L_0x000e
            r0.a()
            return
        L_0x000e:
            r1.d()
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r2 = r1.f17127i
            if (r2 == 0) goto L_0x0213
            monitor-enter(r2)
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ all -> 0x0022 }
            boolean r0 = r1.a((java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>) r0)     // Catch:{ all -> 0x0022 }
            r3 = 1
            if (r0 != 0) goto L_0x0025
            r1.f17122d = r3     // Catch:{ all -> 0x0022 }
            goto L_0x0025
        L_0x0022:
            r0 = move-exception
            goto L_0x0211
        L_0x0025:
            java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>> r0 = r1.f17127i     // Catch:{ all -> 0x0022 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0022 }
        L_0x002b:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x020f
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0022 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x003a
            goto L_0x002b
        L_0x003a:
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0022 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ all -> 0x0022 }
        L_0x0042:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0022 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0022 }
            r6 = r0
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ all -> 0x0022 }
            if (r6 != 0) goto L_0x0058
            goto L_0x0042
        L_0x0058:
            boolean r0 = r6.f()     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x005f
            goto L_0x0042
        L_0x005f:
            int r0 = r1.f17133o     // Catch:{ all -> 0x0022 }
            r7 = 95
            if (r0 != r7) goto L_0x0067
            r1.f17122d = r3     // Catch:{ all -> 0x0022 }
        L_0x0067:
            int r0 = r6.k()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r6.l()     // Catch:{ all -> 0x0022 }
            if (r8 == 0) goto L_0x0083
            if (r0 != 0) goto L_0x0083
            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ all -> 0x0022 }
            java.lang.String r9 = r8.getId()     // Catch:{ all -> 0x0022 }
            java.lang.String r10 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x0022 }
            int r0 = r0.b((java.lang.String) r9, (java.lang.String) r10)     // Catch:{ all -> 0x0022 }
        L_0x0083:
            r9 = r0
            com.mbridge.msdk.videocommon.download.j$2 r0 = new com.mbridge.msdk.videocommon.download.j$2     // Catch:{ all -> 0x0022 }
            r0.<init>(r8)     // Catch:{ all -> 0x0022 }
            r6.a((com.mbridge.msdk.videocommon.listener.a) r0)     // Catch:{ all -> 0x0022 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x0022 }
            int r10 = r1.f17133o     // Catch:{ all -> 0x0022 }
            if (r10 != r3) goto L_0x00a4
            com.mbridge.msdk.c.k r0 = r1.f17119a     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x00a0
            java.lang.String r0 = r1.f17130l     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.c.k r0 = com.mbridge.msdk.c.k.d(r0)     // Catch:{ all -> 0x0022 }
            r1.f17119a = r0     // Catch:{ all -> 0x0022 }
        L_0x00a0:
            int r0 = r1.d(r8)     // Catch:{ all -> 0x0022 }
        L_0x00a4:
            r10 = r0
            r6.c((int) r10)     // Catch:{ all -> 0x0022 }
            int r0 = r1.f17133o     // Catch:{ all -> 0x0022 }
            r11 = 94
            r12 = 298(0x12a, float:4.18E-43)
            r13 = 287(0x11f, float:4.02E-43)
            if (r0 == r11) goto L_0x0100
            if (r0 == r13) goto L_0x0100
            if (r0 != r7) goto L_0x00b7
            goto L_0x0100
        L_0x00b7:
            if (r0 != r12) goto L_0x00da
            com.mbridge.msdk.c.k r0 = r1.f17120b     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x00d1
            com.mbridge.msdk.c.h r0 = com.mbridge.msdk.c.h.a()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.controller.c r15 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0022 }
            java.lang.String r15 = r15.k()     // Catch:{ all -> 0x0022 }
            java.lang.String r14 = r1.f17130l     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.c.k r0 = r0.c(r15, r14)     // Catch:{ all -> 0x0022 }
            r1.f17120b = r0     // Catch:{ all -> 0x0022 }
        L_0x00d1:
            com.mbridge.msdk.c.k r0 = r1.f17120b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x00da
            int r0 = r0.g()     // Catch:{ all -> 0x0022 }
            goto L_0x00db
        L_0x00da:
            r0 = 0
        L_0x00db:
            int r14 = r1.f17133o     // Catch:{ all -> 0x0022 }
            if (r14 != r3) goto L_0x0129
            com.mbridge.msdk.c.k r14 = r1.f17119a     // Catch:{ all -> 0x0022 }
            if (r14 != 0) goto L_0x00f7
            com.mbridge.msdk.c.h r14 = com.mbridge.msdk.c.h.a()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.controller.c r15 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0022 }
            java.lang.String r15 = r15.k()     // Catch:{ all -> 0x0022 }
            java.lang.String r7 = r1.f17130l     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.c.k r7 = r14.c(r15, r7)     // Catch:{ all -> 0x0022 }
            r1.f17119a = r7     // Catch:{ all -> 0x0022 }
        L_0x00f7:
            com.mbridge.msdk.c.k r7 = r1.f17119a     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0129
            int r0 = r7.g()     // Catch:{ all -> 0x0022 }
            goto L_0x0129
        L_0x0100:
            com.mbridge.msdk.videocommon.d.c r0 = r1.f17131m     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x011f
            com.mbridge.msdk.videocommon.d.b r0 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0022 }
            java.lang.String r7 = r7.k()     // Catch:{ all -> 0x0022 }
            java.lang.String r14 = r1.f17130l     // Catch:{ all -> 0x0022 }
            int r15 = r1.f17133o     // Catch:{ all -> 0x0022 }
            if (r15 != r13) goto L_0x0118
            r15 = 1
            goto L_0x0119
        L_0x0118:
            r15 = 0
        L_0x0119:
            com.mbridge.msdk.videocommon.d.c r0 = r0.a((java.lang.String) r7, (java.lang.String) r14, (boolean) r15)     // Catch:{ all -> 0x0022 }
            r1.f17131m = r0     // Catch:{ all -> 0x0022 }
        L_0x011f:
            com.mbridge.msdk.videocommon.d.c r0 = r1.f17131m     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0128
            int r0 = r0.s()     // Catch:{ all -> 0x0022 }
            goto L_0x0129
        L_0x0128:
            r0 = 0
        L_0x0129:
            r6.b((int) r0)     // Catch:{ all -> 0x0022 }
            if (r8 == 0) goto L_0x0133
            int r7 = r8.getVideoCtnType()     // Catch:{ all -> 0x0022 }
            goto L_0x0134
        L_0x0133:
            r7 = 1
        L_0x0134:
            r6.e((int) r7)     // Catch:{ all -> 0x0022 }
            java.lang.String r14 = "UnitCacheCtroller"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r15.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = "ready_rate : "
            r15.append(r13)     // Catch:{ all -> 0x0022 }
            r15.append(r10)     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = " cd_rate : "
            r15.append(r13)     // Catch:{ all -> 0x0022 }
            r15.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = " videoCtnType : "
            r15.append(r0)     // Catch:{ all -> 0x0022 }
            r15.append(r7)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r15.toString()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.tools.af.b(r14, r0)     // Catch:{ all -> 0x0022 }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ all -> 0x0022 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r0)     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x01be
            java.lang.String r0 = ""
            if (r8 == 0) goto L_0x016f
            java.lang.String r0 = r8.getVideoUrlEncode()     // Catch:{ all -> 0x0022 }
        L_0x016f:
            r7 = r0
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f17123e     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x018e
            int r13 = r1.f17133o     // Catch:{ all -> 0x0022 }
            r14 = 297(0x129, float:4.16E-43)
            if (r13 == r14) goto L_0x017c
            if (r13 != r12) goto L_0x018e
        L_0x017c:
            r0.a(r7)     // Catch:{ Exception -> 0x0180 }
            goto L_0x018e
        L_0x0180:
            r0 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0022 }
            if (r13 == 0) goto L_0x018e
            java.lang.String r13 = "UnitCacheCtroller"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.tools.af.b(r13, r0)     // Catch:{ all -> 0x0022 }
        L_0x018e:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r0 = r1.f17125g     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x01be
            int r0 = r0.size()     // Catch:{ all -> 0x0022 }
            if (r0 <= 0) goto L_0x01be
            java.lang.String r0 = ""
            if (r8 == 0) goto L_0x01a0
            java.lang.String r0 = r8.getRequestId()     // Catch:{ all -> 0x0022 }
        L_0x01a0:
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r13 = r1.f17125g     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r13.get(r0)     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.videocommon.listener.a r0 = (com.mbridge.msdk.videocommon.listener.a) r0     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x01be
            if (r8 == 0) goto L_0x01be
            r0.a(r7)     // Catch:{ Exception -> 0x01b0 }
            goto L_0x01be
        L_0x01b0:
            r0 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x01be
            java.lang.String r7 = "UnitCacheCtroller"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.foundation.tools.af.b(r7, r0)     // Catch:{ all -> 0x0022 }
        L_0x01be:
            if (r9 == r3) goto L_0x0042
            r0 = 5
            if (r9 != r0) goto L_0x01c9
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r10)     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0042
        L_0x01c9:
            r0 = 4
            if (r9 == r0) goto L_0x0042
            android.content.Context r0 = r1.f17128j     // Catch:{ all -> 0x0022 }
            int r0 = com.mbridge.msdk.foundation.tools.ab.m(r0)     // Catch:{ all -> 0x0022 }
            r7 = 9
            r8 = 2
            if (r0 == r7) goto L_0x01dd
            int r0 = r1.f17132n     // Catch:{ all -> 0x0022 }
            if (r0 != r8) goto L_0x01dd
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            goto L_0x0213
        L_0x01dd:
            if (r9 == r8) goto L_0x01e5
            boolean r0 = r1.f17122d     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x01e5
            goto L_0x0042
        L_0x01e5:
            com.mbridge.msdk.videocommon.download.c r0 = r1.f17126h     // Catch:{ all -> 0x0022 }
            r6.a((com.mbridge.msdk.videocommon.download.c) r0)     // Catch:{ all -> 0x0022 }
            boolean r0 = a((com.mbridge.msdk.videocommon.download.a) r6, (int) r10)     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x01fd
            int r0 = r1.f17133o     // Catch:{ all -> 0x0022 }
            if (r0 == r11) goto L_0x01f8
            r7 = 287(0x11f, float:4.02E-43)
            if (r0 != r7) goto L_0x0042
        L_0x01f8:
            r6.o()     // Catch:{ all -> 0x0022 }
            goto L_0x0042
        L_0x01fd:
            int r0 = r1.f17133o     // Catch:{ all -> 0x0022 }
            if (r0 == r3) goto L_0x0207
            r7 = 95
            if (r0 == r7) goto L_0x0207
            if (r0 != r12) goto L_0x020a
        L_0x0207:
            r7 = 0
            r1.f17122d = r7     // Catch:{ all -> 0x0022 }
        L_0x020a:
            r6.o()     // Catch:{ all -> 0x0022 }
            goto L_0x0042
        L_0x020f:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            goto L_0x0213
        L_0x0211:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r0
        L_0x0213:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.j.a():void");
    }
}
