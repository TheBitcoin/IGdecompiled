package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbbanner.common.b.d;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f13891a = "b";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f13892b;

    /* renamed from: c  reason: collision with root package name */
    private int f13893c = 0;

    /* renamed from: d  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.a.b f13894d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.mbridge.msdk.mbbanner.common.util.a f13895e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.mbridge.msdk.mbbanner.common.b.b f13896f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f13897g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f13898h = false;

    /* renamed from: i  reason: collision with root package name */
    private Timer f13899i = new Timer();

    /* renamed from: j  reason: collision with root package name */
    private volatile List<String> f13900j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f13901k = false;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f13902l = false;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f13903m = false;

    /* renamed from: n  reason: collision with root package name */
    private String f13904n = "";

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private b f13917a;

        /* renamed from: b  reason: collision with root package name */
        private String f13918b;

        /* renamed from: c  reason: collision with root package name */
        private CampaignEx f13919c;

        public a(b bVar, String str, CampaignEx campaignEx) {
            this.f13917a = bVar;
            this.f13918b = str;
            this.f13919c = campaignEx;
        }

        public final void onFailedLoad(String str, String str2) {
            String str3;
            if (MBridgeConstans.DEBUG) {
                af.c(b.f13891a, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f13917a;
            if (bVar != null) {
                str3 = str2;
                bVar.a(this.f13918b, 1, str3, false, this.f13919c);
            } else {
                str3 = str2;
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.f13918b, this.f13919c.getCurrentLocalRid());
                a5.a(this.f13919c);
                a5.a(10);
                e eVar = new e();
                a5.a(10);
                eVar.a("resource_type", 10);
                eVar.a("result", 3);
                eVar.a("url", str3);
                com.mbridge.msdk.mbbanner.common.d.a.a("m_download_end", a5, eVar);
            } catch (Throwable th) {
                af.b(b.f13891a, th.getMessage());
            }
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            String str2;
            if (MBridgeConstans.DEBUG) {
                af.c(b.f13891a, "DownloadImageListener campaign image success");
            }
            b bVar = this.f13917a;
            if (bVar != null) {
                str2 = str;
                bVar.a(this.f13918b, 1, str2, true, this.f13919c);
            } else {
                str2 = str;
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(this.f13918b, this.f13919c.getCurrentLocalRid());
                a5.a(this.f13919c);
                a5.a(10);
                a5.a(10);
                e eVar = new e();
                eVar.a("resource_type", 10);
                eVar.a("result", 1);
                eVar.a("url", str2);
                com.mbridge.msdk.mbbanner.common.d.a.a("m_download_end", a5, eVar);
            } catch (Throwable th) {
                af.b(b.f13891a, th.getMessage());
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f13892b = context.getApplicationContext();
        this.f13894d = bVar;
        this.f13896f = bVar2;
        this.f13895e = aVar;
    }

    private void a(String str, int i4) {
        if (this.f13903m) {
            return;
        }
        if ((this.f13901k || this.f13902l) && this.f13900j.size() == 0) {
            af.c(f13891a, "在子线程处理业务逻辑 完成");
            this.f13898h = true;
            this.f13903m = true;
            this.f13899i.cancel();
            this.f13895e.a(this.f13896f, str, i4);
            this.f13897g.a(str);
        }
    }

    public final void a(String str, int i4, String str2, boolean z4, CampaignEx campaignEx) {
        if (!z4) {
            if (i4 == -1) {
                String str3 = f13891a;
                af.b(str3, " unitId =" + str + " --> time out!");
            }
            this.f13899i.cancel();
            String str4 = f13891a;
            af.c(str4, "在子线程处理业务逻辑 完成");
            af.c(str4, "downloadResource--> Fail");
            this.f13898h = true;
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880027);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar.a(mBridgeIds);
            bVar.b(this.f13894d.d());
            bVar.a(campaignEx);
            this.f13895e.b(this.f13896f, bVar);
            this.f13897g.a(str);
        } else if (i4 == 1) {
            af.c(f13891a, "downloadResource--> Success Image");
            synchronized (this) {
                try {
                    this.f13900j.remove(str2);
                    if (this.f13900j.size() == 0) {
                        a(str, i4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i4 == 2) {
            af.c(f13891a, "downloadResource--> Success banner_html");
            this.f13902l = true;
            a(str, i4);
        } else if (i4 == 3) {
            af.c(f13891a, "downloadResource--> Success banner_url");
            this.f13901k = true;
            a(str, i4);
        }
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.a aVar, d dVar) {
        boolean z4;
        try {
            af.c(f13891a, "requestCampaign--> started");
            this.f13897g = dVar;
            AnonymousClass2 r02 = new com.mbridge.msdk.mbbanner.common.f.a() {
                public final void a(CampaignUnit campaignUnit) {
                    try {
                        af.c(b.f13891a, "requestCampaign--> Succeed");
                        campaignUnit.setLocalRequestId(aVar.e());
                        b.this.f13895e.a(b.this.f13896f, campaignUnit, this.unitId);
                        b.a(b.this, this.unitId, aVar.e(), campaignUnit);
                    } catch (Exception e5) {
                        String a5 = b.f13891a;
                        af.c(a5, "requestCampaign--> Fail with exception = " + e5.getMessage());
                        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880000);
                        bVar.a(new MBridgeIds(this.placementId, this.unitId));
                        bVar.b(aVar.e());
                        bVar.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                        bVar.a((Throwable) e5);
                        b.this.f13895e.a(b.this.f13896f, bVar);
                        b.this.f13897g.a(this.unitId);
                    }
                }

                public final void a(int i4, String str) {
                    String a5 = b.f13891a;
                    af.c(a5, "requestCampaign--> Fail errorCode:" + i4 + " msg:" + str);
                    com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880003);
                    bVar.a(i4 + "#" + str);
                    bVar.a(new MBridgeIds(this.placementId, this.unitId));
                    bVar.b(aVar.e());
                    b.this.f13895e.a(b.this.f13896f, bVar);
                    b.this.f13897g.a(this.unitId);
                }
            };
            r02.setUnitId(str2);
            r02.setPlacementId(str);
            r02.setAdType(296);
            com.mbridge.msdk.mbbanner.common.e.a aVar2 = new com.mbridge.msdk.mbbanner.common.e.a(this.f13892b);
            this.f13893c = a(str2);
            com.mbridge.msdk.foundation.same.net.f.e a5 = com.mbridge.msdk.mbbanner.common.a.c.a(false, this.f13892b, str2, this.f13894d.a(), this.f13893c, aVar);
            String d5 = ak.d(str2);
            if (!TextUtils.isEmpty(d5)) {
                a5.a("j", d5);
            }
            String c5 = aVar.c();
            if (!TextUtils.isEmpty(c5)) {
                r02.a(c5);
                z4 = true;
            } else {
                z4 = false;
            }
            this.f13895e.a(z4);
            aVar2.choiceV3OrV5BySetting(1, a5, r02, c5, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } catch (Exception e5) {
            af.b(f13891a, e5.getMessage());
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880002);
            bVar.a(new MBridgeIds(str, str2));
            this.f13895e.a(this.f13896f, bVar);
            this.f13897g.a(str2);
        }
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        final String str2;
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    String str3 = f13891a;
                    af.c(str3, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    int i4 = 0;
                    while (i4 < ads.size()) {
                        final CampaignEx campaignEx = ads.get(i4);
                        if (!(campaignEx == null || campaignEx.getOfferType() == 99)) {
                            if (TextUtils.isEmpty(campaignEx.getBannerUrl()) && TextUtils.isEmpty(campaignEx.getBannerHtml())) {
                                if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                                }
                            }
                            if (ak.c(campaignEx)) {
                                campaignEx.setRtinsType(ak.c(this.f13892b, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.c.a(this.f13892b, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                ak.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.f13150x);
                                this.f13904n = "APP ALREADY INSTALLED";
                            }
                            final Context context = this.f13892b;
                            try {
                                str2 = str;
                                try {
                                    com.mbridge.msdk.foundation.same.c.a(campaignEx, context, (com.mbridge.msdk.foundation.same.report.d.c) null, new c.a((com.mbridge.msdk.foundation.same.report.d.a.a) null) {
                                        public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                                            if (!TextUtils.isEmpty(str)) {
                                                e eVar = new e();
                                                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                                cVar.a(str, eVar);
                                                try {
                                                    com.mbridge.msdk.foundation.same.report.d.d.a().a(str, cVar, campaignEx, context, null);
                                                } catch (Exception e5) {
                                                    af.b("BannerReport", e5.getMessage());
                                                }
                                            }
                                        }
                                    });
                                } catch (Exception e5) {
                                    e = e5;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                str2 = str;
                                af.b(f13891a, e.getMessage());
                                i4++;
                                str = str2;
                            }
                            i4++;
                            str = str2;
                        }
                        str2 = str;
                        i4++;
                        str = str2;
                    }
                    String str4 = f13891a;
                    af.c(str4, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                }
            } catch (Exception e7) {
                af.b(f13891a, e7.getMessage());
            }
        }
        return arrayList;
    }

    private void a(String str, List<CampaignEx> list) {
        if (list != null && !list.isEmpty()) {
            for (CampaignEx next : list) {
                if (!TextUtils.isEmpty(next.getImageUrl())) {
                    this.f13900j.add(next.getImageUrl());
                    com.mbridge.msdk.foundation.same.c.b.a(this.f13892b).a(next.getImageUrl(), new a(this, str, next));
                    com.mbridge.msdk.foundation.same.report.d.c a5 = com.mbridge.msdk.mbbanner.common.d.a.a(str, next.getCurrentLocalRid());
                    a5.a(next);
                    a5.a(10);
                    e eVar = new e();
                    eVar.a("resource_type", 10);
                    com.mbridge.msdk.mbbanner.common.d.a.a("m_download_start", a5, eVar);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A[SYNTHETIC, Splitter:B:25:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A[SYNTHETIC, Splitter:B:37:0x00a4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r14, java.lang.String r15, com.mbridge.msdk.foundation.entity.CampaignEx r16) {
        /*
            r13 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r15)
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x00b4
            r2 = 0
            com.mbridge.msdk.foundation.same.b.c r0 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.aq.b(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r3)     // Catch:{ Exception -> 0x002a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x002a }
            if (r4 == 0) goto L_0x002c
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002a }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x002a }
            goto L_0x002c
        L_0x0026:
            r0 = move-exception
            r14 = r0
            goto L_0x00a2
        L_0x002a:
            r0 = move-exception
            goto L_0x0066
        L_0x002c:
            java.lang.String r4 = ".html"
            java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x002a }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x002a }
            r4.<init>(r0, r3)     // Catch:{ Exception -> 0x002a }
            android.net.Uri r0 = android.net.Uri.parse(r15)     // Catch:{ Exception -> 0x002a }
            r0.getPath()     // Catch:{ Exception -> 0x002a }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002a }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002a }
            byte[] r0 = r15.getBytes()     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            r3.write(r0)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            r3.flush()     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            java.lang.String r1 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            r3.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0074
        L_0x0055:
            r0 = move-exception
            java.lang.String r2 = f13891a
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r2, r0)
            goto L_0x0074
        L_0x0060:
            r0 = move-exception
            r14 = r0
            r2 = r3
            goto L_0x00a2
        L_0x0064:
            r0 = move-exception
            r2 = r3
        L_0x0066:
            java.lang.String r3 = f13891a     // Catch:{ all -> 0x0026 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0026 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0074
            r2.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0074:
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0097
            boolean r2 = r0.isFile()
            if (r2 == 0) goto L_0x0097
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L_0x008c
            goto L_0x0097
        L_0x008c:
            r4 = 2
            r6 = 1
            r2 = r13
            r3 = r14
            r5 = r15
            r7 = r16
            r2.a(r3, r4, r5, r6, r7)
            goto L_0x00a1
        L_0x0097:
            r9 = 2
            r11 = 0
            r7 = r13
            r8 = r14
            r10 = r15
            r12 = r16
            r7.a(r8, r9, r10, r11, r12)
        L_0x00a1:
            return r1
        L_0x00a2:
            if (r2 == 0) goto L_0x00b3
            r2.close()     // Catch:{ Exception -> 0x00a8 }
            goto L_0x00b3
        L_0x00a8:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = f13891a
            java.lang.String r15 = r15.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r15)
        L_0x00b3:
            throw r14
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.b.a(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):java.lang.String");
    }

    private int a(String str) {
        try {
            int b5 = this.f13894d.b();
            if (b5 > this.f13894d.c()) {
                return 0;
            }
            return b5;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    static /* synthetic */ void a(b bVar, final String str, String str2, final CampaignUnit campaignUnit) {
        com.mbridge.msdk.foundation.c.b bVar2;
        CampaignEx campaignEx;
        String str3;
        b bVar3;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.c.b bVar4 = new com.mbridge.msdk.foundation.c.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar4.a(mBridgeIds);
            bVar4.b(str2);
            bVar.f13895e.a(bVar.f13896f, bVar4);
            bVar.f13897g.a(str);
            return;
        }
        List<CampaignEx> a5 = bVar.a(str, campaignUnit);
        new Thread(new Runnable() {
            public final void run() {
                af.c(b.f13891a, "在单独子线程保存数据库 开始");
                j.a((f) g.a(b.this.f13892b)).a();
                CampaignUnit campaignUnit = campaignUnit;
                if (!(campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0)) {
                    BannerUtils.uisList(b.this.f13892b, campaignUnit.getAds());
                }
                af.c(b.f13891a, "在单独子线程保存数据库 完成");
            }
        }).start();
        int i4 = 0;
        if (a5 == null || a5.size() == 0) {
            b bVar5 = bVar;
            String str4 = str;
            af.c(f13891a, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
            if (bVar5.f13904n.contains("INSTALLED")) {
                bVar2 = new com.mbridge.msdk.foundation.c.b(880021, "APP ALREADY INSTALLED");
            } else {
                bVar2 = new com.mbridge.msdk.foundation.c.b(880003);
            }
            MBridgeIds mBridgeIds2 = new MBridgeIds();
            mBridgeIds2.setUnitId(str4);
            bVar2.a(mBridgeIds2);
            bVar2.b(str2);
            if (!(campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || (campaignEx = campaignUnit.getAds().get(0)) == null)) {
                bVar2.a(campaignEx);
            }
            bVar5.f13895e.a(bVar5.f13896f, bVar2);
            bVar5.f13897g.a(str4);
            return;
        }
        String str5 = f13891a;
        af.c(str5, "在子线程处理业务逻辑 开始");
        final CampaignEx campaignEx2 = a5.get(0);
        bVar.f13899i.schedule(new TimerTask() {
            public final void run() {
                if (!b.this.f13898h) {
                    boolean unused = b.this.f13898h = true;
                    b.this.a(str, -1, "", false, campaignEx2);
                }
            }
        }, (long) MBridgeCommon.DEFAULT_LOAD_TIMEOUT);
        bVar.f13894d.a(campaignUnit.getSessionId());
        int i5 = bVar.f13893c;
        try {
            if (a5.size() > 0) {
                i5 += a5.size();
            }
            if (i5 > bVar.f13894d.c()) {
                af.c(str5, "saveNextOffset 重置offset为0");
                i5 = 0;
            }
            af.c(str5, "saveNextOffset 算出 下次的offset是:" + i5);
            if (ap.b(str)) {
                bVar.f13894d.a(i5);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        String trim = campaignEx2.getBannerUrl().trim();
        if (!TextUtils.isEmpty(trim)) {
            if (!TextUtils.isEmpty(trim)) {
                bVar3 = bVar;
                str3 = str;
                bVar3.a(str3, 3, trim, true, campaignEx2);
            } else {
                bVar3 = bVar;
                str3 = str;
            }
            if (a5.size() > 0) {
                while (i4 < a5.size()) {
                    a5.get(i4).setBannerUrl(campaignEx2.getBannerUrl());
                    a5.get(i4).setHasMBTplMark(true);
                    i4++;
                }
            }
        } else {
            bVar3 = bVar;
            str3 = str;
            String trim2 = campaignEx2.getBannerHtml().trim();
            if (!TextUtils.isEmpty(trim2)) {
                String a6 = bVar3.a(str3, trim2, campaignEx2);
                if (a5.size() > 0) {
                    while (i4 < a5.size()) {
                        a5.get(i4).setBannerHtml(a6);
                        a5.get(i4).setHasMBTplMark(trim2.contains("<MBTPLMARK>"));
                        i4++;
                    }
                }
            } else {
                bVar3.f13902l = true;
                bVar3.f13901k = true;
            }
        }
        bVar3.a(str3, a5);
    }
}
