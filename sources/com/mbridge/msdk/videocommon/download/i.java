package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f17108a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f17109b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17110c = c.m().c();

    /* renamed from: d  reason: collision with root package name */
    private final String f17111d;

    /* renamed from: e  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f17112e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17113f;

    /* renamed from: g  reason: collision with root package name */
    private final CopyOnWriteArrayList<CampaignEx> f17114g;

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f17115h = new ConcurrentHashMap<>();

    public i(List<CampaignEx> list, String str, int i4) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f17114g = copyOnWriteArrayList;
        this.f17111d = str;
        this.f17113f = i4;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f17111d + " getVideoTemplateUrl error", e5);
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.videocommon.download.a c(com.mbridge.msdk.foundation.entity.CampaignEx r6) {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.videocommon.download.a r1 = new com.mbridge.msdk.videocommon.download.a     // Catch:{ Exception -> 0x0040 }
            android.content.Context r2 = r5.f17110c     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = r5.f17111d     // Catch:{ Exception -> 0x0040 }
            int r4 = r5.f()     // Catch:{ Exception -> 0x0040 }
            r1.<init>(r2, r6, r3, r4)     // Catch:{ Exception -> 0x0040 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.f17113f     // Catch:{ Exception -> 0x003d }
            r1.d((int) r2)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.f(r6)     // Catch:{ Exception -> 0x003d }
            r1.c((int) r2)     // Catch:{ Exception -> 0x003d }
            int r2 = r5.e()     // Catch:{ Exception -> 0x003d }
            r1.b((int) r2)     // Catch:{ Exception -> 0x003d }
            int r6 = r5.d(r6)     // Catch:{ Exception -> 0x003d }
            r1.e((int) r6)     // Catch:{ Exception -> 0x003d }
            r1.a((com.mbridge.msdk.videocommon.download.c) r0)     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.videocommon.download.i$a r6 = new com.mbridge.msdk.videocommon.download.i$a     // Catch:{ Exception -> 0x003d }
            java.lang.String r0 = r5.f17111d     // Catch:{ Exception -> 0x003d }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.listener.a> r2 = r5.f17109b     // Catch:{ Exception -> 0x003d }
            com.mbridge.msdk.videocommon.listener.a r3 = r5.f17108a     // Catch:{ Exception -> 0x003d }
            r6.<init>(r0, r2, r3)     // Catch:{ Exception -> 0x003d }
            r1.a((com.mbridge.msdk.videocommon.listener.a) r6)     // Catch:{ Exception -> 0x003d }
            return r1
        L_0x003d:
            r6 = move-exception
            r0 = r1
            goto L_0x0041
        L_0x0040:
            r6 = move-exception
        L_0x0041:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0064
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.f17111d
            r1.append(r2)
            java.lang.String r2 = " createAndStartCampaignDownloadTask error "
            r1.append(r2)
            java.lang.String r6 = r6.getMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.String r1 = "RewardVideoRefactorManager"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r6)
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.c(com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.videocommon.download.a");
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            af.a("RewardVideoRefactorManager", this.f17111d + " getVideoCtnType error " + e5.getMessage());
            return 1;
        }
    }

    private boolean e(CampaignEx campaignEx) {
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
            af.a("RewardVideoRefactorManager", this.f17111d + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private int g() {
        try {
            return c(this.f17111d).r();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.a("RewardVideoRefactorManager", this.f17111d + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f17108a = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.f17109b == null) {
            this.f17109b = new ConcurrentHashMap<>();
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.f17109b.put(str, aVar);
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.f17111d)) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.d.c c5 = c(this.f17111d);
            if (c5 != null) {
                return c5.w();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f17111d + " getDlnet error " + e5.getMessage());
            }
        }
        return 1;
    }

    private int e() {
        com.mbridge.msdk.videocommon.d.c c5 = c(this.f17111d);
        if (c5 == null) {
            return 0;
        }
        try {
            return c5.s();
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            af.a("RewardVideoRefactorManager", this.f17111d + " getCDRate error " + e5.getMessage());
            return 0;
        }
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.f17114g.addAll(list);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f17111d + " update error", e5);
                }
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.f17115h);
            return copyOnWriteArrayList;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f17111d + " getCampaignDownLoadTaskList error:" + e5.getMessage());
            return null;
        }
    }

    public i(CampaignEx campaignEx, String str, int i4) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.f17114g = copyOnWriteArrayList;
        this.f17111d = str;
        this.f17113f = i4;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public final a b() {
        List<a> list;
        if (this.f17114g.size() == 0) {
            af.a("RewardVideoRefactorManager", this.f17111d + " isReady campaignExes is null");
            return null;
        }
        try {
            list = a((List<CampaignEx>) this.f17114g, false);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", this.f17111d + " isReady error", e5);
            }
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    private static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f17116a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f17117b;

        /* renamed from: c  reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.listener.a f17118c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f17116a = str;
            this.f17117b = concurrentHashMap;
            this.f17118c = aVar;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f17118c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f17116a + " videoDownloadListener onDownLoadDone error: " + e5.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f17117b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a5 : concurrentHashMap.values()) {
                    try {
                        a5.a(str);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f17116a + " videoDownloadListener onDownLoadDone error: " + e6.getMessage());
                        }
                    }
                }
            }
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f17118c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f17116a + " videoDownloadListener onDownLoadFailed error: " + e5.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f17117b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a5 : concurrentHashMap.values()) {
                    try {
                        a5.a(str, str2);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("RewardVideoRefactorManager", this.f17116a + " videoDownloadListener onDownLoadFailed error: " + e6.getMessage());
                        }
                    }
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.f17114g.add(campaignEx);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f17111d + " update error", e5);
                }
            }
        }
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f17114g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            af.a("RewardVideoRefactorManager", this.f17111d + " load campaignExes is null");
            return;
        }
        Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (next != null) {
                try {
                    String str = next.getRequestId() + next.getId() + next.getVideoUrlEncode();
                    if (!this.f17115h.containsKey(str)) {
                        a(next, str, (a) null);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardVideoRefactorManager", this.f17111d + " handlerCampaignLoadEvent error", e5);
                    }
                }
            }
        }
    }

    private com.mbridge.msdk.videocommon.d.c c(String str) {
        try {
            if (this.f17112e == null) {
                this.f17112e = b.a().a(c.m().k(), str, this.f17113f == 287);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("RewardVideoRefactorManager", this.f17111d + " getRewardUnitSetting error " + e5.getMessage());
            }
        }
        return this.f17112e;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.f17115h.containsKey(str)) {
                    a remove = this.f17115h.remove(str);
                    if (remove != null) {
                        CampaignEx l4 = remove.l();
                        if (l4 != null) {
                            this.f17114g.remove(l4);
                            if (MBridgeConstans.DEBUG) {
                                af.a("RewardVideoRefactorManager", this.f17111d + " removeCampaignDownloadTask campaign name: " + l4.getAppName());
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardVideoRefactorManager", this.f17111d + " removeCampaignDownloadTask error:" + e5.getMessage());
                }
            }
        }
    }

    public final a c() {
        try {
            return b();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            af.b("RewardVideoRefactorManager", this.f17111d + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (r7.getRsIgnoreCheckRule().contains(0) != false) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c0, code lost:
        if (r7.getVideoCheckType() == 1) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x012f, code lost:
        if (com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r8.j(), r8.m()) >= r17) goto L_0x013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0167 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01bf A[Catch:{ Exception -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01df A[Catch:{ Exception -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01ee A[Catch:{ Exception -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01f5 A[Catch:{ Exception -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x001d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "\n\t\t\tisIgnore = "
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "RewardVideoRefactorManager"
            if (r19 == 0) goto L_0x0385
            int r0 = r19.size()
            if (r0 != 0) goto L_0x0015
            goto L_0x0385
        L_0x0015:
            int r5 = r19.size()
            java.util.Iterator r6 = r19.iterator()
        L_0x001d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0384
            java.lang.Object r0 = r6.next()
            r7 = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            if (r7 != 0) goto L_0x002d
            goto L_0x001d
        L_0x002d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d6 }
            r0.<init>()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r8 = r7.getRequestId()     // Catch:{ Exception -> 0x01d6 }
            r0.append(r8)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r8 = r7.getId()     // Catch:{ Exception -> 0x01d6 }
            r0.append(r8)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r8 = r7.getVideoUrlEncode()     // Catch:{ Exception -> 0x01d6 }
            r0.append(r8)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01d6 }
            j$.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.download.a> r8 = r1.f17115h     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x01d6 }
            com.mbridge.msdk.videocommon.download.a r8 = (com.mbridge.msdk.videocommon.download.a) r8     // Catch:{ Exception -> 0x01d6 }
            com.mbridge.msdk.videocommon.download.a r8 = r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (java.lang.String) r0, (com.mbridge.msdk.videocommon.download.a) r8)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x005a
            goto L_0x001d
        L_0x005a:
            r9 = 0
            r10 = 1
            int r0 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x0134 }
            boolean r11 = r8.d()     // Catch:{ Exception -> 0x0134 }
            if (r11 != 0) goto L_0x0138
            int r11 = r1.f(r7)     // Catch:{ Exception -> 0x0134 }
            int r12 = r1.f()     // Catch:{ Exception -> 0x0134 }
            boolean r13 = r8.d()     // Catch:{ Exception -> 0x0134 }
            if (r13 == 0) goto L_0x0076
            goto L_0x0138
        L_0x0076:
            boolean r13 = r1.e(r7)     // Catch:{ Exception -> 0x0134 }
            if (r13 == 0) goto L_0x007e
            goto L_0x0138
        L_0x007e:
            java.lang.String r13 = r8.e()     // Catch:{ Exception -> 0x0134 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0134 }
            if (r13 == 0) goto L_0x008a
            goto L_0x0138
        L_0x008a:
            r13 = 3
            if (r12 != r13) goto L_0x008f
            goto L_0x0138
        L_0x008f:
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x0134 }
            if (r12 == 0) goto L_0x00b6
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x00af }
            int r12 = r12.size()     // Catch:{ Exception -> 0x00af }
            if (r12 <= 0) goto L_0x00b6
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x00af }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00af }
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x00af }
            if (r12 == 0) goto L_0x00b6
            goto L_0x0138
        L_0x00af:
            r0 = move-exception
            r19 = 0
        L_0x00b2:
            r10 = 0
        L_0x00b3:
            r11 = 0
            goto L_0x01bb
        L_0x00b6:
            int r12 = r7.getIsTimeoutCheckVideoStatus()     // Catch:{ Exception -> 0x0134 }
            if (r12 != r10) goto L_0x00c4
            int r12 = r7.getVideoCheckType()     // Catch:{ Exception -> 0x00af }
            if (r12 != r10) goto L_0x00c4
            goto L_0x0138
        L_0x00c4:
            long r12 = r8.m()     // Catch:{ Exception -> 0x0134 }
            long r14 = r8.j()     // Catch:{ Exception -> 0x0134 }
            if (r20 == 0) goto L_0x00fb
            r19 = 0
            int r9 = r7.getVideoCheckType()     // Catch:{ Exception -> 0x00f8 }
            if (r9 != r10) goto L_0x00e5
            if (r11 != 0) goto L_0x00da
            goto L_0x013a
        L_0x00da:
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 != 0) goto L_0x00e8
            int r9 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r9 == 0) goto L_0x00e5
            goto L_0x00e8
        L_0x00e5:
            r17 = r11
            goto L_0x00ff
        L_0x00e8:
            int r9 = r11 / 100
            r17 = r11
            long r10 = (long) r9     // Catch:{ Exception -> 0x00f8 }
            long r10 = r10 * r14
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 < 0) goto L_0x00ff
            r9 = 1
            r7.setIsTimeoutCheckVideoStatus(r9)     // Catch:{ Exception -> 0x00f8 }
            goto L_0x013a
        L_0x00f8:
            r0 = move-exception
        L_0x00f9:
            r9 = 0
            goto L_0x00b2
        L_0x00fb:
            r17 = r11
            r19 = 0
        L_0x00ff:
            java.lang.String r9 = r8.e()     // Catch:{ Exception -> 0x00f8 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00f8 }
            if (r9 == 0) goto L_0x010a
            goto L_0x013a
        L_0x010a:
            if (r17 != 0) goto L_0x0121
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r8.l()     // Catch:{ Exception -> 0x00f8 }
            if (r9 == 0) goto L_0x0132
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r8.l()     // Catch:{ Exception -> 0x00f8 }
            java.lang.String r9 = r9.getVideoUrlEncode()     // Catch:{ Exception -> 0x00f8 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00f8 }
            if (r9 != 0) goto L_0x0132
            goto L_0x013a
        L_0x0121:
            long r9 = r8.j()     // Catch:{ Exception -> 0x00f8 }
            long r11 = r8.m()     // Catch:{ Exception -> 0x00f8 }
            int r9 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r9, r11)     // Catch:{ Exception -> 0x00f8 }
            r10 = r17
            if (r9 < r10) goto L_0x0132
            goto L_0x013a
        L_0x0132:
            r9 = 0
            goto L_0x013b
        L_0x0134:
            r0 = move-exception
            r19 = 0
            goto L_0x00f9
        L_0x0138:
            r19 = 0
        L_0x013a:
            r9 = 1
        L_0x013b:
            r8.d((boolean) r9)     // Catch:{ Exception -> 0x0151 }
            boolean r10 = r8.b()     // Catch:{ Exception -> 0x0151 }
            if (r10 != 0) goto L_0x0154
            java.lang.String r10 = r7.getendcard_url()     // Catch:{ Exception -> 0x0151 }
            boolean r10 = r1.a((java.lang.String) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.videocommon.download.a) r8)     // Catch:{ Exception -> 0x0151 }
            if (r10 == 0) goto L_0x014f
            goto L_0x0154
        L_0x014f:
            r10 = 0
            goto L_0x0155
        L_0x0151:
            r0 = move-exception
            goto L_0x00b2
        L_0x0154:
            r10 = 1
        L_0x0155:
            if (r0 != 0) goto L_0x0161
            if (r10 == 0) goto L_0x0161
            r11 = 1
            r8.b((boolean) r11)     // Catch:{ Exception -> 0x015e }
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            goto L_0x00b3
        L_0x0161:
            boolean r11 = r8.c()     // Catch:{ Exception -> 0x015e }
            if (r11 != 0) goto L_0x01b0
            java.lang.String r11 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r7)     // Catch:{ Exception -> 0x015e }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x015e }
            if (r12 == 0) goto L_0x0172
            goto L_0x01b0
        L_0x0172:
            boolean r12 = r8.c()     // Catch:{ Exception -> 0x015e }
            if (r12 == 0) goto L_0x0179
            goto L_0x01b0
        L_0x0179:
            boolean r12 = r7.isDynamicView()     // Catch:{ Exception -> 0x015e }
            if (r12 == 0) goto L_0x0180
            goto L_0x01b0
        L_0x0180:
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x015e }
            if (r12 == 0) goto L_0x01a1
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x015e }
            int r12 = r12.size()     // Catch:{ Exception -> 0x015e }
            if (r12 <= 0) goto L_0x01a1
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x015e }
            r16 = 1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x015e }
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x015e }
            if (r12 == 0) goto L_0x01a1
            goto L_0x01b0
        L_0x01a1:
            int r12 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x015e }
            if (r12 != 0) goto L_0x01b0
            java.lang.String r11 = com.mbridge.msdk.videocommon.download.f.a(r11)     // Catch:{ Exception -> 0x015e }
            if (r11 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r11 = 0
            goto L_0x01b1
        L_0x01b0:
            r11 = 1
        L_0x01b1:
            if (r0 != 0) goto L_0x01d9
            if (r11 == 0) goto L_0x01d9
            r12 = 1
            r8.c((boolean) r12)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01d9
        L_0x01ba:
            r0 = move-exception
        L_0x01bb:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01d6 }
            if (r12 == 0) goto L_0x01d9
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d6 }
            r12.<init>()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r13 = r1.f17111d     // Catch:{ Exception -> 0x01d6 }
            r12.append(r13)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r13 = " checkResourceReadyState error"
            r12.append(r13)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x01d6 }
            com.mbridge.msdk.foundation.tools.af.b(r4, r12, r0)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x01d9
        L_0x01d6:
            r0 = move-exception
            goto L_0x0368
        L_0x01d9:
            boolean r0 = r8.a()     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x01e8
            if (r9 == 0) goto L_0x01e6
            if (r10 == 0) goto L_0x01e6
            if (r11 == 0) goto L_0x01e6
            goto L_0x01e8
        L_0x01e6:
            r0 = 0
            goto L_0x01e9
        L_0x01e8:
            r0 = 1
        L_0x01e9:
            r8.a((boolean) r0)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x01f1
            r3.add(r8)     // Catch:{ Exception -> 0x01d6 }
        L_0x01f1:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01d6 }
            if (r12 == 0) goto L_0x001d
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01d6 }
            if (r12 != 0) goto L_0x0200
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x01d6 }
            r12.<init>()     // Catch:{ Exception -> 0x01d6 }
        L_0x0200:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d6 }
            r13.<init>()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = r1.f17111d     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "  campaign name = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = r7.getAppName()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "\n\t\tcampaign id = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = r7.getId()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "\n\t\trequest id = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = r7.getRequestId()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "\n\t\tadType = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            int r14 = r1.f17113f     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "\n\t\tunitID = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = r1.f17111d     // Catch:{ Exception -> 0x01d6 }
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "\n\t\tisReady = "
            r13.append(r14)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisDynamicView = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r7.isDynamicView()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisTPL = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = r7.getCMPTEntryUrl()     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01d6 }
            r16 = 1
            r0 = r0 ^ 1
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tcurrentSuccessSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r3.size()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisReadyCheckSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r5)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\ttotalCampaignSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.f17114g     // Catch:{ Exception -> 0x01d6 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tlinkType = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r7.getLinkType()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tloadTimeoutState = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisVideoReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r9)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r2)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\treadyRate == "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r1.f(r7)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tCDRate = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r1.e()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tdlnet = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r1.f()     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tctn = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r1.d(r7)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tdownloadState = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            int r0 = r8.k()     // Catch:{ Exception -> 0x01d6 }
            r8 = 2
            if (r0 == 0) goto L_0x0310
            r9 = 1
            if (r0 == r9) goto L_0x030d
            if (r0 == r8) goto L_0x030a
            r9 = 4
            if (r0 == r9) goto L_0x0307
            r9 = 5
            if (r0 == r9) goto L_0x0304
            java.lang.String r0 = "Unknown"
            goto L_0x0312
        L_0x0304:
            java.lang.String r0 = "DOWNLOAD_DONE"
            goto L_0x0312
        L_0x0307:
            java.lang.String r0 = "DOWNLOAD_STOP"
            goto L_0x0312
        L_0x030a:
            java.lang.String r0 = "DOWNLOAD_PAUSE"
            goto L_0x0312
        L_0x030d:
            java.lang.String r0 = "DOWNLOAD_RUN"
            goto L_0x0312
        L_0x0310:
            java.lang.String r0 = "DOWNLOAD_READY"
        L_0x0312:
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisTemplateReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r11)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r2)     // Catch:{ Exception -> 0x01d6 }
            r16 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\tisEndCardReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r10)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r2)     // Catch:{ Exception -> 0x01d6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tisOnlyPlayable = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r1.e(r7)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = "\n\t\t\tisPlayableEndCard(dynamicView) = "
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = r7.getendcard_url()     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r0)     // Catch:{ Exception -> 0x01d6 }
            r13.append(r0)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x01d6 }
            com.mbridge.msdk.foundation.tools.af.b(r4, r0)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x001d
        L_0x0368:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L_0x001d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r1.f17111d
            r7.append(r8)
            java.lang.String r8 = " isReady error"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.mbridge.msdk.foundation.tools.af.b(r4, r7, r0)
            goto L_0x001d
        L_0x0384:
            return r3
        L_0x0385:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.f17111d
            r0.append(r2)
            java.lang.String r2 = " isReady campaignExes is null"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r4, (java.lang.String) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.a(java.util.List, boolean):java.util.List");
    }

    private a a(CampaignEx campaignEx, String str, a aVar) {
        if (aVar != null) {
            return aVar;
        }
        a c5 = c(campaignEx);
        c5.n();
        this.f17115h.put(str, c5);
        return c5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ad A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r6, com.mbridge.msdk.foundation.entity.CampaignEx r7, com.mbridge.msdk.videocommon.download.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "RewardVideoRefactorManager"
            r1 = 0
            if (r7 == 0) goto L_0x00cf
            if (r8 != 0) goto L_0x0009
            goto L_0x00cf
        L_0x0009:
            boolean r8 = r8.b()     // Catch:{ all -> 0x0027 }
            r2 = 1
            if (r8 == 0) goto L_0x002a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r6.<init>()     // Catch:{ all -> 0x0027 }
            java.lang.String r7 = r5.f17111d     // Catch:{ all -> 0x0027 }
            r6.append(r7)     // Catch:{ all -> 0x0027 }
            java.lang.String r7 = " checkEndCardZipOrSourceDownLoad endCard download success"
            r6.append(r7)     // Catch:{ all -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0027 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0027 }
            return r2
        L_0x0027:
            r6 = move-exception
            goto L_0x00ae
        L_0x002a:
            java.util.ArrayList r8 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            r3 = 2
            if (r8 == 0) goto L_0x004a
            java.util.ArrayList r8 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            int r8 = r8.size()     // Catch:{ all -> 0x0027 }
            if (r8 <= 0) goto L_0x004a
            java.util.ArrayList r8 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0027 }
            boolean r8 = r8.contains(r4)     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x004a
            return r2
        L_0x004a:
            boolean r8 = r7.isDynamicView()     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x0057
            boolean r8 = com.mbridge.msdk.foundation.tools.ak.l((java.lang.String) r6)     // Catch:{ all -> 0x0027 }
            if (r8 != 0) goto L_0x0057
            return r2
        L_0x0057:
            boolean r8 = com.mbridge.msdk.foundation.tools.ap.a(r6)     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x005e
            return r2
        L_0x005e:
            boolean r8 = r7.isMraid()     // Catch:{ all -> 0x0027 }
            if (r8 != 0) goto L_0x0077
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x006b
            goto L_0x0077
        L_0x006b:
            int r8 = r7.getLoadTimeoutState()     // Catch:{ all -> 0x0027 }
            if (r8 != r2) goto L_0x0079
            boolean r8 = r5.e(r7)     // Catch:{ all -> 0x0027 }
            if (r8 != 0) goto L_0x0079
        L_0x0077:
            r6 = 1
            goto L_0x00ab
        L_0x0079:
            java.util.ArrayList r8 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x0098
            java.util.ArrayList r8 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            int r8 = r8.size()     // Catch:{ all -> 0x0027 }
            if (r8 <= 0) goto L_0x0098
            java.util.ArrayList r7 = r7.getRsIgnoreCheckRule()     // Catch:{ all -> 0x0027 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0027 }
            boolean r7 = r7.contains(r8)     // Catch:{ all -> 0x0027 }
            if (r7 == 0) goto L_0x0098
            goto L_0x0077
        L_0x0098:
            java.lang.String r7 = com.mbridge.msdk.videocommon.download.f.a(r6)     // Catch:{ all -> 0x0027 }
            boolean r7 = com.mbridge.msdk.foundation.tools.ap.b(r7)     // Catch:{ all -> 0x0027 }
            if (r7 == 0) goto L_0x00a3
            goto L_0x0077
        L_0x00a3:
            java.lang.String r6 = com.mbridge.msdk.videocommon.download.f.b(r6)     // Catch:{ all -> 0x0027 }
            boolean r6 = com.mbridge.msdk.foundation.tools.ap.b(r6)     // Catch:{ all -> 0x0027 }
        L_0x00ab:
            if (r6 == 0) goto L_0x00cf
            return r2
        L_0x00ae:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L_0x00cf
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r5.f17111d
            r7.append(r8)
            java.lang.String r8 = " checkEndCardDownload error "
            r7.append(r8)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r6)
        L_0x00cf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.i.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.videocommon.download.a):boolean");
    }

    public final a a(String str) {
        if (!TextUtils.isEmpty(str) && this.f17115h.containsKey(str)) {
            return this.f17115h.get(str);
        }
        return null;
    }
}
