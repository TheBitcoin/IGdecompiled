package com.mbridge.msdk.reward.player;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q1.C2205a;
import q1.C2206b;
import r1.C2216b;

public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";

    /* renamed from: A  reason: collision with root package name */
    private boolean f15367A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public int f15368B = 1;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public int f15369C = 0;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public int f15370D = 0;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public int f15371E = 0;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public int f15372F = 0;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public int f15373G = 0;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public int f15374H = 0;

    /* renamed from: I  reason: collision with root package name */
    private String f15375I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public c f15376J;

    /* renamed from: K  reason: collision with root package name */
    private boolean f15377K = false;

    /* renamed from: L  reason: collision with root package name */
    private boolean f15378L;

    /* renamed from: M  reason: collision with root package name */
    private C2206b f15379M = null;

    /* renamed from: N  reason: collision with root package name */
    private C2216b f15380N = null;

    /* renamed from: O  reason: collision with root package name */
    private C2205a f15381O = null;

    /* renamed from: P  reason: collision with root package name */
    private long f15382P = 0;

    /* renamed from: Q  reason: collision with root package name */
    private String f15383Q = "";

    /* renamed from: R  reason: collision with root package name */
    private boolean f15384R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f15385S = false;

    /* renamed from: T  reason: collision with root package name */
    private boolean f15386T = false;

    /* renamed from: U  reason: collision with root package name */
    private com.mbridge.msdk.video.dynview.e.a f15387U = new com.mbridge.msdk.video.dynview.e.a() {
        public final void a(Map<String, Object> map) {
            if (map != null) {
                if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                    int unused = MBRewardVideoActivity.this.f15393e = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
                }
                if (map.containsKey("position")) {
                    int intValue = ((Integer) map.get("position")).intValue();
                    if (MBRewardVideoActivity.this.f15408t != null && MBRewardVideoActivity.this.f15408t.size() > 0 && intValue >= 1) {
                        MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                        CampaignEx unused2 = mBRewardVideoActivity.f15406r = (CampaignEx) mBRewardVideoActivity.f15408t.get(intValue);
                        MBRewardVideoActivity.b(MBRewardVideoActivity.this);
                        int i4 = intValue - 1;
                        if (MBRewardVideoActivity.this.f15408t.get(i4) != null) {
                            MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                            int unused3 = mBRewardVideoActivity2.f15369C = mBRewardVideoActivity2.f15369C - ((CampaignEx) MBRewardVideoActivity.this.f15408t.get(i4)).getVideoLength();
                        }
                        MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                        MBRewardVideoActivity.this.f15406r.setVideoCompleteTime(mBRewardVideoActivity3.a(mBRewardVideoActivity3.f15406r.getVideoCompleteTime(), MBRewardVideoActivity.this.f15368B));
                        MBRewardVideoActivity.this.f15406r.setShowIndex(MBRewardVideoActivity.this.f15368B);
                        MBRewardVideoActivity.this.f15406r.setShowType(1);
                        MBRewardVideoActivity mBRewardVideoActivity4 = MBRewardVideoActivity.this;
                        mBRewardVideoActivity4.b(mBRewardVideoActivity4.f15406r);
                    }
                }
            }
        }
    };

    /* renamed from: V  reason: collision with root package name */
    private d f15388V = new d() {
        public final void countDownClick() {
            if (MBRewardVideoActivity.this.f15410v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.f15410v, 500);
            }
            boolean unused = MBRewardVideoActivity.this.f15399k = true;
            MBRewardVideoActivity.this.b();
            if (MBRewardVideoActivity.this.f15409u != null) {
                MBRewardVideoActivity.this.f15409u.setNotchPadding(MBRewardVideoActivity.this.f15374H, MBRewardVideoActivity.this.f15370D, MBRewardVideoActivity.this.f15372F, MBRewardVideoActivity.this.f15371E, MBRewardVideoActivity.this.f15373G);
            }
        }

        public final void itemClick(CampaignEx campaignEx) {
            if (campaignEx != null) {
                if (MBRewardVideoActivity.this.f15410v != null) {
                    new com.mbridge.msdk.video.dynview.h.b().b((View) MBRewardVideoActivity.this.f15410v, 500);
                }
                CampaignEx unused = MBRewardVideoActivity.this.f15406r = campaignEx;
                MBRewardVideoActivity.this.f15406r.setShowType(2);
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.b(mBRewardVideoActivity.f15406r);
                return;
            }
            MBRewardVideoActivity.this.a("campaign is null");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f15389a;

    /* renamed from: b  reason: collision with root package name */
    private String f15390b;

    /* renamed from: c  reason: collision with root package name */
    private String f15391c;

    /* renamed from: d  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.b.c f15392d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f15393e = 2;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15394f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f15395g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f15396h;

    /* renamed from: i  reason: collision with root package name */
    private int f15397i;

    /* renamed from: j  reason: collision with root package name */
    private int f15398j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f15399k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15400l = false;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public h f15401m;

    /* renamed from: n  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f15402n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15403o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15404p = false;

    /* renamed from: q  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f15405q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public CampaignEx f15406r;

    /* renamed from: s  reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f15407s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public List<CampaignEx> f15408t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public MBTempContainer f15409u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public MBridgeBTContainer f15410v;

    /* renamed from: w  reason: collision with root package name */
    private WindVaneWebView f15411w;

    /* renamed from: x  reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.a f15412x;

    /* renamed from: y  reason: collision with root package name */
    private String f15413y;

    /* renamed from: z  reason: collision with root package name */
    private String f15414z;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f15419a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15420b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15421c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f15419a = list;
            this.f15420b = str;
            this.f15421c = str2;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f15419a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.f15419a) {
                        if (!(next == null || next.l() == null)) {
                            CampaignEx l4 = next.l();
                            try {
                                AppletModelManager.getInstance().remove(l4);
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    af.b("MBRewardVideoActivity", "AppletModelManager remove error", e5);
                                }
                            }
                            String str = l4.getRequestId() + l4.getId() + l4.getVideoUrlEncode();
                            j c5 = com.mbridge.msdk.videocommon.download.b.getInstance().c(this.f15420b);
                            if (c5 != null) {
                                try {
                                    c5.b(str);
                                } catch (Exception e6) {
                                    if (MBridgeConstans.DEBUG) {
                                        af.b("DownLoadManager", e6.getMessage());
                                    }
                                }
                            }
                            if (l4.getRewardTemplateMode() != null) {
                                if (!TextUtils.isEmpty(l4.getRewardTemplateMode().e())) {
                                    com.mbridge.msdk.videocommon.a.b(this.f15420b + "_" + l4.getId() + "_" + this.f15421c + "_" + l4.getRewardTemplateMode().e());
                                    com.mbridge.msdk.videocommon.a.b(l4.getAdType(), l4);
                                }
                                if (!TextUtils.isEmpty(l4.getCMPTEntryUrl())) {
                                    com.mbridge.msdk.videocommon.a.b(this.f15420b + "_" + this.f15421c + "_" + l4.getCMPTEntryUrl());
                                }
                                com.mbridge.msdk.videocommon.a.a.a().a(l4);
                            }
                        }
                    }
                }
            } catch (Exception e7) {
                af.a("MBRewardVideoActivity", e7.getMessage());
            }
        }
    }

    private static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f15422a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15423b;

        public b(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f15422a = list;
            this.f15423b = str;
        }

        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f15422a;
                if (list != null && list.size() > 0) {
                    for (com.mbridge.msdk.videocommon.download.a next : this.f15422a) {
                        if (!(next == null || next.l() == null)) {
                            com.mbridge.msdk.videocommon.a.a.a().a(next.l(), this.f15423b);
                        }
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity) {
        int i4 = mBRewardVideoActivity.f15368B;
        mBRewardVideoActivity.f15368B = i4 + 1;
        return i4;
    }

    private void c(CampaignEx campaignEx) {
    }

    public void changeHalfScreenPadding(int i4) {
        int e5;
        int f4;
        int e6;
        int f5;
        float f6;
        try {
            CampaignEx campaignEx = this.f15406r;
            if (campaignEx != null && campaignEx.getAdSpaceT() == 2) {
                getWindow().getDecorView().setBackgroundColor(-1728053248);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15409u.getLayoutParams();
                layoutParams.gravity = 17;
                if (this.f15406r.getRewardTemplateMode().b() == 0) {
                    if (i4 == 2) {
                        e6 = (int) (((float) ak.e((Context) this)) * 0.6f);
                        f5 = ak.f((Context) this);
                    } else {
                        e5 = (int) (((float) ak.e((Context) this)) * 0.6f);
                        f4 = ak.f((Context) this);
                        f6 = ((float) f4) * 0.7f;
                        int i5 = (int) f6;
                        layoutParams.height = e6;
                        layoutParams.width = i5;
                        this.f15409u.setLayoutParams(layoutParams);
                    }
                } else if (this.f15406r.getRewardTemplateMode().b() == 2) {
                    e6 = (int) (((float) ak.e((Context) this)) * 0.6f);
                    f5 = ak.f((Context) this);
                } else {
                    e5 = (int) (((float) ak.e((Context) this)) * 0.6f);
                    f4 = ak.f((Context) this);
                    f6 = ((float) f4) * 0.7f;
                    int i52 = (int) f6;
                    layoutParams.height = e6;
                    layoutParams.width = i52;
                    this.f15409u.setLayoutParams(layoutParams);
                }
                f6 = ((float) f5) * 0.6f;
                int i522 = (int) f6;
                layoutParams.height = e6;
                layoutParams.width = i522;
                this.f15409u.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    public int findID(String str) {
        return x.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public void finish() {
        this.f15385S = true;
        if (this.f15379M != null) {
            af.b("omsdk", "mbrewardvideoac finish");
            this.f15379M.e();
            this.f15379M.c();
            this.f15379M = null;
        }
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f15409u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f15410v = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f15389a);
        super.finish();
    }

    public void onBackPressed() {
        this.f15386T = true;
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f15409u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.f15409u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        int i4;
        WindVaneWebView windVaneWebView;
        List<com.mbridge.msdk.videocommon.download.a> list;
        String str2 = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a((Context) this);
        this.f15382P = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onCreate";
        } else {
            str = this.f15383Q + "_onCreate";
        }
        this.f15383Q = str;
        try {
            Intent intent = getIntent();
            this.f15389a = intent.getStringExtra(INTENT_UNITID);
            this.f15390b = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.f15392d = com.mbridge.msdk.videocommon.b.c.b(intent.getStringExtra(INTENT_REWARD));
            this.f15391c = intent.getStringExtra(INTENT_USERID);
            this.f15393e = intent.getIntExtra(INTENT_MUTE, 2);
            this.f15394f = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c m4 = com.mbridge.msdk.foundation.controller.c.m();
            int i5 = 94;
            if (this.f15394f) {
                i4 = 287;
            } else {
                i4 = 94;
            }
            m4.b(i4);
            this.f15395g = intent.getBooleanExtra(INTENT_ISBID, false);
            this.f15414z = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.f15377K = booleanExtra;
            if (booleanExtra) {
                this.f15401m = MBridgeGlobalCommon.showRewardListenerMap.get(this.f15389a);
            } else {
                this.f15401m = com.mbridge.msdk.reward.b.a.f15243f.get(this.f15389a);
            }
            if (this.f15394f) {
                this.f15396h = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.f15397i = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.f15398j = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.f15399k = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.f15407s = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f15389a);
            this.f15408t = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f15389a);
            int findLayout = findLayout("mbridge_more_offer_activity");
            if (findLayout < 0) {
                a("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(findLayout);
            if (TextUtils.isEmpty(this.f15389a)) {
                a("data empty error");
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            if (this.f15401m == null) {
                a("showRewardListener is null");
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = RewardUnitCacheManager.getInstance().get(this.f15390b, this.f15389a);
            this.f15402n = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.d.c a5 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f15389a);
                this.f15402n = a5;
                if (a5 == null) {
                    this.f15402n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f15389a, this.f15394f);
                }
            }
            com.mbridge.msdk.videocommon.d.c cVar2 = this.f15402n;
            if (cVar2 != null) {
                this.f15392d.a(cVar2.m());
                this.f15392d.a(this.f15402n.n());
            }
            com.mbridge.msdk.videocommon.b.c cVar3 = this.f15392d;
            if (cVar3 != null && cVar3.b() <= 0) {
                this.f15392d.a(1);
            }
            int a6 = x.a(this, "mbridge_reward_activity_open", "anim");
            int a7 = x.a(this, "mbridge_reward_activity_stay", "anim");
            if (a6 > 1 && a7 > 1) {
                overridePendingTransition(a6, a7);
            }
            if (bundle != null) {
                this.f15404p = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
            }
            af.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.f15399k);
            if (!this.f15399k) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.f15407s;
                if (list2 != null && list2.size() > 0) {
                    this.f15405q = this.f15407s.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.f15405q;
                if (aVar != null) {
                    this.f15406r = aVar.l();
                    this.f15405q.e(true);
                    this.f15405q.f(false);
                    CampaignEx campaignEx = this.f15406r;
                    if (campaignEx != null) {
                        this.f15375I = campaignEx.getCurrentLocalRid();
                        this.f15406r.setShowIndex(1);
                        this.f15406r.setShowType(1);
                        com.mbridge.msdk.reward.b.a.f15240b = this.f15406r.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f15406r.getMaitve(), this.f15406r.getMaitve_src());
                    }
                }
                if (this.f15405q == null || this.f15406r == null || this.f15392d == null) {
                    a("data empty error");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f15406r);
                b((List<CampaignEx>) arrayList);
                a(this.f15406r);
                b();
                if (!com.mbridge.msdk.e.b.a()) {
                    a();
                    return;
                }
                return;
            }
            b(this.f15408t);
            this.f15413y = str2;
            List<CampaignEx> list3 = this.f15408t;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx2 = this.f15408t.get(0);
                a(campaignEx2);
                str2 = campaignEx2.getCMPTEntryUrl();
                this.f15413y = campaignEx2.getRequestId();
                this.f15375I = campaignEx2.getCurrentLocalRid();
                com.mbridge.msdk.reward.b.a.f15240b = campaignEx2.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2.getMaitve(), campaignEx2.getMaitve_src());
            }
            a.C0208a a8 = com.mbridge.msdk.videocommon.a.a(this.f15389a + "_" + this.f15413y + "_" + str2);
            com.mbridge.msdk.videocommon.download.a aVar2 = null;
            if (a8 != null) {
                windVaneWebView = a8.a();
            } else {
                windVaneWebView = null;
            }
            this.f15411w = windVaneWebView;
            if (windVaneWebView == null) {
                if (this.f15405q == null && (list = this.f15407s) != null && list.size() > 0) {
                    this.f15405q = this.f15407s.get(0);
                }
                if (this.f15405q == null) {
                    com.mbridge.msdk.videocommon.download.b instance = com.mbridge.msdk.videocommon.download.b.getInstance();
                    if (this.f15394f) {
                        i5 = 287;
                    }
                    String str3 = this.f15389a;
                    boolean z4 = this.f15395g;
                    j c5 = instance.c(str3);
                    if (c5 != null) {
                        aVar2 = c5.b(i5, z4);
                    }
                    this.f15405q = aVar2;
                }
                com.mbridge.msdk.videocommon.download.a aVar3 = this.f15405q;
                if (aVar3 != null) {
                    this.f15406r = aVar3.l();
                    this.f15405q.e(true);
                    this.f15405q.f(false);
                }
                if (!(this.f15405q == null || this.f15406r == null)) {
                    if (this.f15392d != null) {
                        this.f15399k = false;
                        List<CampaignEx> a9 = com.mbridge.msdk.videocommon.a.a.a().a(this.f15408t);
                        if (a9 == null) {
                            a("no available campaign");
                            return;
                        }
                        int size = a9.size();
                        if (size == 0) {
                            a("no available campaign");
                            return;
                        } else if (a9.get(0) == null || !a9.get(0).isDynamicView()) {
                            b();
                        } else if (size == 1) {
                            CampaignEx campaignEx3 = a9.get(0);
                            this.f15406r = campaignEx3;
                            if (campaignEx3 != null) {
                                this.f15375I = campaignEx3.getCurrentLocalRid();
                                this.f15406r.setCampaignIsFiltered(true);
                            }
                            b(this.f15406r);
                        } else {
                            a(a9);
                        }
                    }
                }
                a("data empty error");
                return;
            }
            a(this.f15408t.get(0));
            WindVaneWebView windVaneWebView2 = this.f15411w;
            if (windVaneWebView2 != null) {
                try {
                    k kVar = (k) windVaneWebView2.getObject();
                    kVar.a(this.f15381O);
                    kVar.a(this.f15379M);
                    kVar.a(this.f15380N);
                    this.f15411w.setObject(kVar);
                } catch (Exception e5) {
                    af.b("MBRewardVideoActivity", e5.getMessage());
                }
            }
            c();
            if (!com.mbridge.msdk.e.b.a()) {
                a();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            b(this.f15408t);
            a("onCreate error" + th);
        }
    }

    public void onDestroy() {
        String str;
        String str2;
        int i4;
        int i5;
        int i6;
        int i7;
        h hVar;
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onDestroy";
        } else {
            str = this.f15383Q + "_onDestroy";
        }
        this.f15383Q = str;
        super.onDestroy();
        h hVar2 = this.f15401m;
        if (hVar2 != null && (hVar2 instanceof com.mbridge.msdk.video.bt.module.b.b)) {
            try {
                com.mbridge.msdk.video.bt.module.b.b bVar = (com.mbridge.msdk.video.bt.module.b.b) hVar2;
                if (!bVar.f15958b && !bVar.f15959c) {
                    this.f15384R = true;
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
        e eVar = new e();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str2 = "unKnown";
        } else {
            str2 = this.f15383Q;
        }
        eVar.a("activity_life_cycle", str2);
        eVar.a("activity_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.f15382P));
        if (this.f15384R) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        eVar.a("is_unexpected_destroy", Integer.valueOf(i4));
        if (this.f15401m == null) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        eVar.a("is_listener_null", Integer.valueOf(i5));
        if (this.f15385S) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        eVar.a("is_called_finish", Integer.valueOf(i6));
        if (this.f15386T) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        eVar.a("is_back_pressed", Integer.valueOf(i7));
        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000151", this.f15406r, eVar);
        try {
            if (this.f15384R && (hVar = this.f15401m) != null) {
                hVar.a(this.f15376J, "show fail : unexpected destroy");
            }
        } catch (Throwable th2) {
            af.b("MBRewardVideoActivity", th2.getMessage());
        }
        com.mbridge.msdk.video.module.b.b.a(this.f15389a);
        e();
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f15409u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f15410v = null;
        }
        this.f15387U = null;
        this.f15388V = null;
        com.mbridge.msdk.foundation.d.b.a().c(this.f15389a + "_" + 1);
        com.mbridge.msdk.foundation.d.b.a().c(this.f15389a + "_" + 2);
        com.mbridge.msdk.foundation.same.f.a.b().execute(new a(this.f15407s, this.f15389a, this.f15413y));
    }

    public void onPause() {
        String str;
        super.onPause();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onPause";
        } else {
            str = this.f15383Q + "_onPause";
        }
        this.f15383Q = str;
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        String str;
        super.onRestart();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onRestart";
        } else {
            str = this.f15383Q + "_onRestart";
        }
        this.f15383Q = str;
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    public void onResume() {
        String str;
        MBridgeVideoView mBridgeVideoView;
        super.onResume();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onResume";
        } else {
            str = this.f15383Q + "_onResume";
        }
        this.f15383Q = str;
        if (com.mbridge.msdk.foundation.d.b.f12876c) {
            MBTempContainer mBTempContainer = this.f15409u;
            if (mBTempContainer != null && (mBridgeVideoView = mBTempContainer.mbridgeVideoView) != null) {
                mBridgeVideoView.setCover(false);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a((Context) this);
        try {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new b(this.f15389a, this.f15407s));
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
        MBTempContainer mBTempContainer2 = this.f15409u;
        if (mBTempContainer2 != null) {
            mBTempContainer2.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.f15404p);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        String str;
        super.onStart();
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onStart";
        } else {
            str = this.f15383Q + "_onStart";
        }
        this.f15383Q = str;
        if (!com.mbridge.msdk.foundation.d.b.f12876c) {
            new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    MBRewardVideoActivity.this.onResume();
                }

                public final void showed() {
                    MBRewardVideoActivity.this.onPause();
                }

                public final void summit(String str) {
                    MBRewardVideoActivity.this.onResume();
                }
            };
            MBTempContainer mBTempContainer = this.f15409u;
            if (mBTempContainer != null) {
                mBTempContainer.onStart();
                this.f15406r.setCampaignUnitId(this.f15389a);
                com.mbridge.msdk.foundation.d.b.a().a(this.f15389a + "_" + 1, this.f15406r);
            }
            MBridgeBTContainer mBridgeBTContainer = this.f15410v;
            if (mBridgeBTContainer != null) {
                mBridgeBTContainer.onStart();
                List<CampaignEx> list = this.f15408t;
                if (list != null && list.size() > 0) {
                    CampaignEx campaignEx = this.f15408t.get(0);
                    campaignEx.setCampaignUnitId(this.f15389a);
                    com.mbridge.msdk.foundation.d.b.a().a(this.f15389a + "_" + 1, campaignEx);
                }
            }
            if (!this.f15367A) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f15389a + "_" + 1, 1);
                com.mbridge.msdk.foundation.d.b.a().c(this.f15389a + "_" + 2);
                this.f15367A = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        String str;
        if (TextUtils.isEmpty(this.f15383Q)) {
            str = "onStop";
        } else {
            str = this.f15383Q + "_onStop";
        }
        this.f15383Q = str;
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    public void setTheme(int i4) {
        super.setTheme(x.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }

    public void setTopControllerPadding(int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        this.f15370D = i5;
        this.f15372F = i6;
        this.f15371E = i7;
        this.f15373G = i8;
        this.f15374H = i4;
        MBTempContainer mBTempContainer = this.f15409u;
        if (mBTempContainer != null) {
            int i14 = i4;
            int i15 = i5;
            int i16 = i6;
            int i17 = i7;
            int i18 = i8;
            mBTempContainer.setNotchPadding(i14, i15, i16, i17, i18);
            i9 = i18;
            i10 = i17;
            i11 = i16;
            i12 = i15;
            i13 = i14;
        } else {
            i13 = i4;
            i12 = i5;
            i11 = i6;
            i10 = i7;
            i9 = i8;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f15410v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i13, i12, i11, i10, i9);
        }
        int i19 = i13;
        int i20 = i12;
        int i21 = i11;
        com.mbridge.msdk.video.dynview.a.a.f15981e = i19;
        com.mbridge.msdk.video.dynview.a.a.f15977a = i20;
        com.mbridge.msdk.video.dynview.a.a.f15978b = i21;
        com.mbridge.msdk.video.dynview.a.a.f15979c = i10;
        com.mbridge.msdk.video.dynview.a.a.f15980d = i9;
    }

    private com.mbridge.msdk.video.bt.module.a.a d() {
        if (this.f15412x == null) {
            this.f15412x = new com.mbridge.msdk.video.bt.module.a.a() {
                public final void a() {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(MBRewardVideoActivity.this.f15376J);
                    }
                }

                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.b(str, str2);
                    }
                }

                public final void a(boolean z4, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(MBRewardVideoActivity.this.f15376J, z4, cVar);
                    }
                }

                public final void a(boolean z4, int i4) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(z4, i4);
                    }
                }

                public final void a(String str) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(MBRewardVideoActivity.this.f15376J, str);
                    }
                }

                public final void a(boolean z4, String str, String str2) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(z4, str, str2);
                    }
                }

                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(str, str2);
                    }
                }

                public final void a(int i4, String str, String str2) {
                    if (MBRewardVideoActivity.this.f15401m != null) {
                        MBRewardVideoActivity.this.f15401m.a(i4, str, str2);
                    }
                }
            };
        }
        return this.f15412x;
    }

    private void e() {
        try {
            List<CampaignEx> list = this.f15408t;
            if (list != null && list.size() > 0) {
                for (CampaignEx d5 : this.f15408t) {
                    d(d5);
                }
            }
            CampaignEx campaignEx = this.f15406r;
            if (campaignEx != null) {
                d(campaignEx);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void c() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        int findID = findID("mbridge_bt_container");
        if (findID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(findID);
        this.f15410v = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            a("env error");
        }
        this.f15410v.setVisibility(0);
        com.mbridge.msdk.video.bt.module.a.a d5 = d();
        this.f15412x = d5;
        this.f15410v.setBTContainerCallback(d5);
        this.f15410v.setShowRewardVideoListener(this.f15401m);
        this.f15410v.setChoiceOneCallback(this.f15388V);
        this.f15410v.setCampaigns(this.f15408t);
        this.f15410v.setCampaignDownLoadTasks(this.f15407s);
        this.f15410v.setRewardUnitSetting(this.f15402n);
        this.f15410v.setUnitId(this.f15389a);
        this.f15410v.setPlacementId(this.f15390b);
        this.f15410v.setUserId(this.f15391c);
        this.f15410v.setActivity(this);
        CampaignEx campaignEx = this.f15406r;
        if (!((campaignEx == null || (rewardPlus = campaignEx.getRewardPlus()) == null) && (this.f15408t.get(0) == null || (rewardPlus = this.f15408t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f15392d = cVar;
        }
        this.f15410v.setReward(this.f15392d);
        this.f15410v.setIVRewardEnable(this.f15396h, this.f15397i, this.f15398j);
        this.f15410v.setIV(this.f15394f);
        this.f15410v.setMute(this.f15393e);
        this.f15410v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.f15410v.setDeveloperExtraData(this.f15414z);
        this.f15410v.init(this);
        this.f15410v.setAdSession(this.f15379M);
        this.f15410v.setVideoEvents(this.f15380N);
        this.f15410v.setAdEvents(this.f15381O);
        this.f15410v.onCreate(this.f15377K);
        if (com.mbridge.msdk.e.b.a() && (list = this.f15408t) != null && list.size() > 0 && this.f15408t.get(0) != null) {
            c(this.f15408t.get(0));
        }
    }

    /* access modifiers changed from: private */
    public void b(CampaignEx campaignEx) {
        CampaignEx l4;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.f15407s;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a next : this.f15407s) {
                    if (next != null && (l4 = next.l()) != null && TextUtils.equals(l4.getId(), campaignEx.getId()) && TextUtils.equals(l4.getRequestId(), campaignEx.getRequestId())) {
                        this.f15405q = next;
                    }
                }
            }
            this.f15399k = true;
            b();
            MBTempContainer mBTempContainer = this.f15409u;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.f15374H, this.f15370D, this.f15372F, this.f15371E, this.f15373G);
            }
        } catch (Exception e5) {
            af.b("MBRewardVideoActivity", e5.getMessage());
            a("more offer to one offer exception");
        }
    }

    private void d(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
                campaignEx.getImageUrl();
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c());
                campaignEx.getIconUrl();
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isActiveOm() && this.f15379M == null) {
                    C2206b a5 = com.mbridge.msdk.a.b.a(getApplicationContext(), false, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f15389a, campaignEx.getVideoUrlEncode(), campaignEx.getRequestIdNotice());
                    this.f15379M = a5;
                    if (a5 != null) {
                        this.f15381O = C2205a.a(a5);
                        this.f15380N = C2216b.g(this.f15379M);
                    }
                }
            } catch (Throwable th) {
                af.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        CampaignEx campaignEx;
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        List<CampaignEx> list2;
        int findID = findID("mbridge_temp_container");
        if (findID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(findID);
        this.f15409u = mBTempContainer;
        if (mBTempContainer == null) {
            a("env error");
        }
        List<CampaignEx> list3 = this.f15408t;
        if (list3 == null || list3.size() <= 0 || !this.f15408t.get(0).isDynamicView()) {
            this.f15409u.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.h.b().c((View) this.f15409u, 500);
        }
        changeHalfScreenPadding(-1);
        this.f15409u.setActivity(this);
        this.f15409u.setBidCampaign(this.f15395g);
        this.f15409u.setBigOffer(this.f15399k);
        this.f15409u.setUnitId(this.f15389a);
        this.f15409u.setCampaign(this.f15406r);
        if (this.f15406r.getDynamicTempCode() == 5 && (list2 = this.f15408t) != null && list2.size() > 1) {
            View findViewById = findViewById(findID("mbridge_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f15409u.removeAllViews();
            this.f15409u.setCampOrderViewData(this.f15408t, this.f15369C);
            this.f15409u.setCamPlayOrderCallback(this.f15387U, this.f15368B);
        }
        this.f15409u.setCampaignDownLoadTask(this.f15405q);
        this.f15409u.setIV(this.f15394f);
        CampaignEx campaignEx2 = this.f15406r;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.f15409u.setIVRewardEnable(this.f15396h, this.f15397i, this.f15398j);
        } else {
            this.f15409u.setIVRewardEnable(0, 0, 0);
        }
        this.f15409u.setMute(this.f15393e);
        CampaignEx campaignEx3 = this.f15406r;
        if (!((campaignEx3 == null || (rewardPlus = campaignEx3.getRewardPlus()) == null) && ((list = this.f15408t) == null || list.size() <= 0 || this.f15408t.get(0) == null || (rewardPlus = this.f15408t.get(0).getRewardPlus()) == null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f15392d = cVar;
        }
        this.f15409u.setReward(this.f15392d);
        this.f15409u.setRewardUnitSetting(this.f15402n);
        this.f15409u.setPlacementId(this.f15390b);
        this.f15409u.setUserId(this.f15391c);
        this.f15409u.setShowRewardListener(this.f15401m);
        this.f15409u.setDeveloperExtraData(this.f15414z);
        this.f15409u.init(this);
        this.f15409u.setAdSession(this.f15379M);
        this.f15409u.setAdEvents(this.f15381O);
        this.f15409u.setVideoEvents(this.f15380N);
        this.f15409u.onCreate();
        if (com.mbridge.msdk.e.b.a() && (campaignEx = this.f15406r) != null) {
            c(campaignEx);
        }
    }

    private void a() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable a5 = com.mbridge.msdk.foundation.controller.c.m().a(this.f15389a, this.f15394f ? 287 : 94);
            if (a5 != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                ak.a(imageView, a5, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void a(List<CampaignEx> list) {
        int i4;
        if (list == null) {
            a("no available campaign");
        } else if (list.size() == 0) {
            a("no available campaign");
        } else {
            if (list.get(0) != null) {
                i4 = list.get(0).getDynamicTempCode();
                this.f15375I = list.get(0).getCurrentLocalRid();
            } else {
                i4 = 0;
            }
            if (i4 != 5) {
                c();
                return;
            }
            for (CampaignEx next : list) {
                if (next != null) {
                    this.f15369C += next.getVideoLength();
                }
            }
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                int a5 = a(campaignEx.getVideoCompleteTime(), this.f15368B);
                this.f15406r = campaignEx;
                campaignEx.setCampaignIsFiltered(true);
                this.f15368B = 1;
                this.f15406r.setVideoCompleteTime(a5);
                this.f15406r.setShowIndex(this.f15368B);
                this.f15406r.setShowType(1);
                b(this.f15406r);
                return;
            }
            a("campaign is less");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        af.b("MBRewardVideoActivity", str);
        b(this.f15408t);
        h hVar = this.f15401m;
        if (hVar != null) {
            hVar.a(this.f15376J, str);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public int a(int i4, int i5) {
        List<CampaignEx> list = this.f15408t;
        if (!(list == null || list.size() == 0)) {
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < this.f15408t.size(); i8++) {
                if (this.f15408t.get(0) != null) {
                    if (i8 == 0) {
                        i7 = this.f15408t.get(0).getVideoCompleteTime();
                    }
                    i6 += this.f15408t.get(i8).getVideoLength();
                }
            }
            if (i5 == 1) {
                if (i4 == 0) {
                    if (i6 >= 45) {
                        return 45;
                    }
                } else if (i6 > i4) {
                    if (i4 > 45) {
                        return 45;
                    }
                }
                return i6;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < i5 - 1; i10++) {
                if (this.f15408t.get(i10) != null) {
                    i9 += this.f15408t.get(i10).getVideoLength();
                }
            }
            if (i7 > i9) {
                return i7 - i9;
            }
            return 0;
        }
        return i4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[Catch:{ Exception -> 0x0010 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e A[SYNTHETIC, Splitter:B:32:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3 A[Catch:{ Exception -> 0x0010 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6) {
        /*
            r5 = this;
            boolean r0 = r5.f15378L
            if (r0 == 0) goto L_0x0006
            goto L_0x00cb
        L_0x0006:
            r0 = 0
            if (r6 != 0) goto L_0x003f
            boolean r6 = r5.f15399k     // Catch:{ Exception -> 0x0010 }
            if (r6 == 0) goto L_0x0013
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.f15408t     // Catch:{ Exception -> 0x0010 }
            goto L_0x003f
        L_0x0010:
            r6 = move-exception
            goto L_0x00c4
        L_0x0013:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0010 }
            r6.<init>()     // Catch:{ Exception -> 0x0010 }
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r5.f15407s     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r5.f15407s     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.videocommon.download.a r1 = (com.mbridge.msdk.videocommon.download.a) r1     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.l()     // Catch:{ Exception -> 0x0010 }
            if (r1 == 0) goto L_0x003f
            java.util.List<com.mbridge.msdk.videocommon.download.a> r1 = r5.f15407s     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.videocommon.download.a r1 = (com.mbridge.msdk.videocommon.download.a) r1     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.l()     // Catch:{ Exception -> 0x0010 }
            r6.add(r1)     // Catch:{ Exception -> 0x0010 }
        L_0x003f:
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x0056
            boolean r2 = r6.isEmpty()     // Catch:{ Exception -> 0x0010 }
            if (r2 != 0) goto L_0x0056
            java.lang.Object r0 = r6.get(r0)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x0010 }
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r0.getCurrentLocalRid()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0010 }
            if (r2 != 0) goto L_0x0067
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r2.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0010 }
            r5.f15376J = r0     // Catch:{ Exception -> 0x0010 }
        L_0x0067:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r5.f15376J     // Catch:{ Exception -> 0x0010 }
            java.lang.String r1 = "2000129"
            r2 = 1
            if (r0 != 0) goto L_0x00b1
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0010 }
            r0.<init>()     // Catch:{ Exception -> 0x0010 }
            r5.f15376J = r0     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x0010 }
            r0.<init>()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "unit_id"
            java.lang.String r4 = r5.f15389a     // Catch:{ Exception -> 0x0010 }
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "hb"
            boolean r4 = r5.f15395g     // Catch:{ Exception -> 0x0010 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0010 }
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "adtp"
            boolean r4 = r5.f15394f     // Catch:{ Exception -> 0x0010 }
            if (r4 == 0) goto L_0x0095
            r4 = 287(0x11f, float:4.02E-43)
            goto L_0x0097
        L_0x0095:
            r4 = 94
        L_0x0097:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0010 }
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "lrid"
            java.lang.String r4 = r5.f15375I     // Catch:{ Exception -> 0x0010 }
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = "his_reason"
            java.lang.String r4 = "show campaign is null"
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r3 = r5.f15376J     // Catch:{ Exception -> 0x0010 }
            r3.a(r1, r0)     // Catch:{ Exception -> 0x0010 }
        L_0x00b1:
            if (r6 == 0) goto L_0x00b8
            com.mbridge.msdk.foundation.same.report.d.c r0 = r5.f15376J     // Catch:{ Exception -> 0x0010 }
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r6)     // Catch:{ Exception -> 0x0010 }
        L_0x00b8:
            r5.f15378L = r2     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.reward.c.a.a r6 = com.mbridge.msdk.reward.c.a.a.a()     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r5.f15376J     // Catch:{ Exception -> 0x0010 }
            r6.a(r1, r0)     // Catch:{ Exception -> 0x0010 }
            return
        L_0x00c4:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x00cb
            r6.printStackTrace()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.player.MBRewardVideoActivity.b(java.util.List):void");
    }
}
