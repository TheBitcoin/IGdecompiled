package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.video.dynview.moffer.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.h;
import java.util.ArrayList;
import java.util.List;

public class MBridgeContainerView extends MBridgeBaseView implements f, h {

    /* renamed from: A  reason: collision with root package name */
    private int f16267A = 1;

    /* renamed from: B  reason: collision with root package name */
    private boolean f16268B = false;

    /* renamed from: C  reason: collision with root package name */
    private boolean f16269C = false;

    /* renamed from: D  reason: collision with root package name */
    private boolean f16270D = false;

    /* renamed from: E  reason: collision with root package name */
    private boolean f16271E = true;

    /* renamed from: F  reason: collision with root package name */
    private boolean f16272F = false;

    /* renamed from: G  reason: collision with root package name */
    private boolean f16273G = false;

    /* renamed from: H  reason: collision with root package name */
    private int f16274H;

    /* renamed from: I  reason: collision with root package name */
    private boolean f16275I = false;

    /* renamed from: J  reason: collision with root package name */
    private boolean f16276J = false;

    /* renamed from: K  reason: collision with root package name */
    private int f16277K;

    /* renamed from: L  reason: collision with root package name */
    private int f16278L;

    /* renamed from: M  reason: collision with root package name */
    private int f16279M;

    /* renamed from: N  reason: collision with root package name */
    private int f16280N;

    /* renamed from: O  reason: collision with root package name */
    private int f16281O;

    /* renamed from: P  reason: collision with root package name */
    private String f16282P;

    /* renamed from: Q  reason: collision with root package name */
    private b f16283Q;

    /* renamed from: R  reason: collision with root package name */
    private boolean f16284R = false;

    /* renamed from: S  reason: collision with root package name */
    private boolean f16285S = false;

    /* renamed from: T  reason: collision with root package name */
    private List<CampaignEx> f16286T = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private MBridgePlayableView f16287m;

    /* renamed from: n  reason: collision with root package name */
    private MBridgeClickCTAView f16288n;

    /* renamed from: o  reason: collision with root package name */
    private MBridgeClickMiniCardView f16289o;

    /* renamed from: p  reason: collision with root package name */
    private MBridgeNativeEndCardView f16290p;

    /* renamed from: q  reason: collision with root package name */
    private MBridgeH5EndCardView f16291q;

    /* renamed from: r  reason: collision with root package name */
    private MBridgeVastEndCardView f16292r;

    /* renamed from: s  reason: collision with root package name */
    private MBridgeLandingPageView f16293s;

    /* renamed from: t  reason: collision with root package name */
    private MBridgeVideoEndCoverView f16294t;

    /* renamed from: u  reason: collision with root package name */
    private MBridgeAlertWebview f16295u;

    /* renamed from: v  reason: collision with root package name */
    private MBridgeOrderCampView f16296v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f16297w;

    /* renamed from: x  reason: collision with root package name */
    private int f16298x;

    /* renamed from: y  reason: collision with root package name */
    private int f16299y = 1;

    /* renamed from: z  reason: collision with root package name */
    private int f16300z = 1;

    public MBridgeContainerView(Context context) {
        super(context);
    }

    private void b() {
        if (this.f16291q == null) {
            a(this.f16283Q, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f16291q;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.f16291q.setError(true);
            }
        } else {
            this.f16275I = true;
            addView(this.f16291q);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f16291q.excuteTask();
            this.f16291q.setNotchValue(this.f16282P, this.f16277K, this.f16278L, this.f16279M, this.f16280N);
            n nVar = new n();
            nVar.f(this.f16239b.getRequestId());
            nVar.g(this.f16239b.getRequestIdNotice());
            nVar.e(this.f16239b.getId());
            nVar.d(this.f16239b.isMraid() ? n.f13061a : n.f13062b);
            g.d(nVar, this.f16238a, this.f16297w);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.f16291q;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.f16297w);
        }
    }

    private void e() {
        this.f16299y = 1;
        if (this.f16290p == null) {
            a(this.f16283Q, 2);
        }
        addView(this.f16290p);
        onConfigurationChanged(getResources().getConfiguration());
        this.f16290p.notifyShowListener();
        this.f16285S = true;
        bringToFront();
    }

    private void f() {
        if (this.f16289o == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.f16270D && this.f16271E) {
            this.f16271E = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f16289o, layoutParams);
    }

    private void g() {
        if (this.f16295u == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.f16238a);
            this.f16295u = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.f16297w);
            this.f16295u.setCampaign(this.f16239b);
        }
        this.f16295u.preLoadData(this.f16283Q);
    }

    private void h() {
        this.f16269C = false;
        this.f16285S = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i4 = 0;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View childAt = viewGroup.getChildAt(i4);
                if (!(childAt instanceof MBridgeContainerView)) {
                    viewGroup.bringChildToFront(childAt);
                } else {
                    i4++;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r11 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.f16239b
            if (r0 != 0) goto L_0x0005
            goto L_0x0071
        L_0x0005:
            java.lang.String r0 = r0.getendcard_url()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 404(0x194, float:5.66E-43)
            if (r1 != 0) goto L_0x0027
            java.lang.String r1 = "ecid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r1)     // Catch:{ all -> 0x001d }
            int r2 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x001d }
            r7 = r2
            goto L_0x0029
        L_0x001d:
            r0 = move-exception
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0027:
            r7 = 404(0x194, float:5.66E-43)
        L_0x0029:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r3 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView
            android.content.Context r4 = r11.f16238a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.f16239b
            int r0 = r0.getAdSpaceT()
            r1 = 2
            if (r0 != r1) goto L_0x0039
            r0 = 1
            r8 = 1
            goto L_0x003b
        L_0x0039:
            r0 = 0
            r8 = 0
        L_0x003b:
            int r9 = r11.f16248k
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.f16239b
            int r10 = r0.getMof_tplid()
            r5 = 0
            r6 = 1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r11.f16290p = r3
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r11.f16239b
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L_0x006a
            com.mbridge.msdk.video.module.a.a r0 = r11.notifyListener
            if (r0 == 0) goto L_0x0062
            boolean r1 = r0 instanceof com.mbridge.msdk.video.module.a.a.k
            if (r1 == 0) goto L_0x0062
            com.mbridge.msdk.video.module.a.a.k r0 = (com.mbridge.msdk.video.module.a.a.k) r0
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f16239b
            r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r1)
        L_0x0062:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = r11.f16290p
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f16239b
            r0.setCampaign(r1)
            goto L_0x0071
        L_0x006a:
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView r0 = r11.f16290p
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r11.f16239b
            r0.setCampaign(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeContainerView.i():void");
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list != null) {
            this.f16286T = list;
        }
    }

    public void addView(View view) {
        if (view != null) {
            a(view);
            super.addView(view);
            return;
        }
        af.b(MBridgeBaseView.TAG, "view is null");
    }

    public boolean canBackPress() {
        if (this.f16290p != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f16293s;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    public void configurationChanged(int i4, int i5, int i6) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getVisibility() == 0) {
            this.f16289o.resizeMiniCard(i4, i5);
        }
    }

    public void defaultShow() {
        super.defaultShow();
    }

    public boolean endCardShowing() {
        return this.f16268B;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isPlayable()) {
            return false;
        }
        return true;
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView == null) {
            return this.f16287m;
        }
        return mBridgeH5EndCardView;
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f16239b.isDynamicView() || !TextUtils.isEmpty(this.f16239b.getendcard_url())) {
            return null;
        }
        int size = this.f16286T.size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                if (this.f16286T.get(i5) != null && this.f16286T.get(i5).getId() == this.f16239b.getId()) {
                    i4 = i5 - 1;
                    break;
                }
                i5++;
            } else {
                break;
            }
        }
        if (i4 < 0 || i4 >= size || this.f16286T.get(i4) == null) {
            return null;
        }
        return this.f16286T.get(i4);
    }

    public boolean getShowingTransparent() {
        return this.f16270D;
    }

    public String getUnitID() {
        return this.f16297w;
    }

    public int getVideoInteractiveType() {
        return this.f16298x;
    }

    public int getVideoSkipTime() {
        return this.f16274H;
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.f16275I) {
                return;
            }
        }
        a();
    }

    public void hideAlertWebview() {
        if (!isLast()) {
            if (this.f16284R && !this.f16285S) {
                h();
                this.f16284R = false;
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.f16295u;
            if (mBridgeAlertWebview != null && mBridgeAlertWebview.getParent() != null) {
                removeView(this.f16295u);
                MBridgeClickCTAView mBridgeClickCTAView = this.f16288n;
                if (mBridgeClickCTAView != null && mBridgeClickCTAView.getParent() != null) {
                    setWrapContent();
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
                    }
                }
            }
        }
    }

    public void init(Context context) {
        setVisibility(0);
    }

    public void install(CampaignEx campaignEx) {
        this.notifyListener.a(105, campaignEx);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null || viewGroup.indexOfChild(this) != 0) {
            return false;
        }
        return true;
    }

    public void ivRewardAdsWithoutVideo(String str) {
        this.notifyListener.a(103, str);
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView == null || !mBridgeClickMiniCardView.isLoadSuccess()) {
            return false;
        }
        return true;
    }

    public boolean miniCardShowing() {
        return this.f16269C;
    }

    public void notifyCloseBtn(int i4) {
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i4);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i4);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f16287m, this.f16288n, this.f16289o, this.f16290p, this.f16291q, this.f16292r, this.f16293s, this.f16294t};
        for (int i4 = 0; i4 < 8; i4++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i4];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.f16290p != null || this.f16292r != null) {
            this.notifyListener.a(104, "");
            try {
                a.a().b();
            } catch (Exception e5) {
                af.b(MBridgeBaseView.TAG, e5.getMessage());
            }
        } else if (this.f16293s != null) {
            this.notifyListener.a(103, "");
        } else {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.onBackPress();
            }
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.f16269C) {
            this.notifyListener.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void orientation(Configuration configuration) {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f16287m, this.f16289o, this.f16291q, this.f16295u};
        for (int i4 = 0; i4 < 4; i4++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i4];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.f16283Q = bVar;
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null) {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                if (this.f16287m == null) {
                    this.f16287m = new MBridgePlayableView(this.f16238a);
                }
                this.f16287m.setCloseDelayShowTime(this.f16300z);
                this.f16287m.setPlayCloseBtnTm(this.f16267A);
                this.f16287m.setCampaign(this.f16239b);
                this.f16287m.setNotifyListener(new i(this.notifyListener) {
                    public final void a(int i4, Object obj) {
                        int i5;
                        super.a(i4, obj);
                        if (i4 == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.f(MBridgeContainerView.this.f16239b.getRequestId());
                            nVar.g(MBridgeContainerView.this.f16239b.getRequestIdNotice());
                            nVar.e(MBridgeContainerView.this.f16239b.getId());
                            if (MBridgeContainerView.this.f16239b.isMraid()) {
                                i5 = n.f13061a;
                            } else {
                                i5 = n.f13062b;
                            }
                            nVar.d(i5);
                            MBridgeContainerView mBridgeContainerView2 = MBridgeContainerView.this;
                            g.d(nVar, mBridgeContainerView2.f16238a, mBridgeContainerView2.f16297w);
                        }
                    }
                });
                this.f16287m.preLoadData(bVar);
            } else {
                b(this.f16298x);
                if (this.f16239b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f16239b.getVideo_end_type()));
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f16239b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!ak.l(this.f16239b.getendcard_url())) {
                        try {
                            String a5 = aq.a(this.f16239b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a5) && Integer.parseInt(a5) == 1) {
                                a.a().a(this.f16239b, 2);
                            }
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f16239b.getVideo_end_type()));
                        }
                    }, (long) getVideoSkipTime());
                }
            }
            g();
        }
    }

    public void readyStatus(int i4) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i4);
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.f16291q = null;
        }
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f16293s;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f16290p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.f16290p.release();
        }
        if (this.notifyListener != null) {
            this.notifyListener = null;
        }
    }

    public void resizeMiniCard(int i4, int i5, int i6) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i4, i5);
            this.f16289o.setRadius(i6);
            removeAllViews();
            setMatchParent();
            this.f16285S = true;
            bringToFront();
            f();
        }
    }

    public void setCloseDelayTime(int i4) {
        this.f16300z = i4;
    }

    public void setEndscreenType(int i4) {
        this.f16299y = i4;
    }

    public void setJSFactory(b bVar) {
        this.f16283Q = bVar;
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.f16289o.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7, int i8) {
        af.b(MBridgeBaseView.TAG, "NOTCH ContainerView " + String.format("%1s-%2s-%3s-%4s-%5s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i4)}));
        this.f16281O = i4;
        this.f16277K = i5;
        this.f16278L = i6;
        this.f16279M = i7;
        this.f16280N = i8;
        this.f16282P = s.a(i4, i5, i6, i7, i8);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f16290p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i5, i6, i7, i8);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.f16325p == null)) {
            mBridgeH5EndCardView.setNotchValue(this.f16282P, i5, i6, i7, i8);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f16291q.f16325p, "oncutoutfetched", Base64.encodeToString(this.f16282P.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (!(mBridgePlayableView == null || mBridgePlayableView.f16325p == null)) {
            mBridgePlayableView.setNotchValue(this.f16282P, i5, i6, i7, i8);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f16287m.f16325p, "oncutoutfetched", Base64.encodeToString(this.f16282P.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.f16296v;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i5, i6, i7, i8);
        }
    }

    public void setNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f16287m, this.f16288n, this.f16289o, this.f16290p, this.f16291q, this.f16292r, this.f16293s, this.f16294t};
        for (int i4 = 0; i4 < 8; i4++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i4];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.f16289o, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f16290p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f16290p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i4) {
        this.f16267A = i4;
    }

    public void setRewardStatus(boolean z4) {
        this.f16276J = z4;
    }

    public void setShowingTransparent(boolean z4) {
        this.f16270D = z4;
    }

    public void setUnitID(String str) {
        this.f16297w = str;
    }

    public void setVideoInteractiveType(int i4) {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            this.f16298x = i4;
            return;
        }
        int a5 = com.mbridge.msdk.video.dynview.i.a.a(this.f16239b);
        if (a5 == 100) {
            this.f16298x = i4;
        } else {
            this.f16298x = a5;
        }
    }

    public void setVideoSkipTime(int i4) {
        this.f16274H = i4;
    }

    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.f16295u;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1 && !this.f16285S) {
            removeAllViews();
            bringToFront();
            this.f16284R = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.f16295u == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.f16295u;
        if (!(mBridgeAlertWebview2 == null || mBridgeAlertWebview2.getParent() == null)) {
            removeView(this.f16295u);
        }
        addView(this.f16295u);
        setBackgroundColor(0);
        this.f16295u.webviewshow();
        return true;
    }

    public void showEndcard(int i4) {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null) {
            if (i4 == 1) {
                this.notifyListener.a(104, "");
            } else if (i4 == 100) {
                if (campaignEx.getPlayable_ads_without_video() == 2) {
                    this.f16273G = true;
                }
                a((View) this.f16287m);
                setMatchParent();
                e();
            } else if (i4 == 3) {
                removeAllViews();
                setMatchParent();
                if (this.f16292r == null) {
                    a(this.f16283Q, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.f16292r, layoutParams);
                this.f16292r.notifyShowListener();
                this.f16285S = true;
                bringToFront();
            } else if (i4 == 4) {
                this.notifyListener.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.f16293s == null) {
                    a(this.f16283Q, 4);
                }
                this.f16293s.setUnitId(this.f16297w);
                this.f16293s.preLoadData(this.f16283Q);
                addView(this.f16293s);
                this.f16285S = true;
                bringToFront();
            } else if (i4 != 5) {
                removeAllViews();
                setMatchParent();
                this.f16285S = true;
                bringToFront();
                a();
                this.notifyListener.a(117, "");
            } else {
                this.notifyListener.a(106, "");
            }
        }
        this.f16268B = true;
    }

    public void showMiniCard(int i4, int i5, int i6, int i7, int i8) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i4, i5, i6, i7);
            this.f16289o.setRadius(i8);
            this.f16289o.setCloseVisible(8);
            this.f16289o.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.f16285S = true;
            bringToFront();
            f();
            if (!this.f16272F) {
                this.f16272F = true;
                this.notifyListener.a(109, "");
                this.notifyListener.a(117, "");
            }
        }
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.f16238a);
        this.f16296v = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.f16286T);
        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.f16286T);
        }
        this.f16296v.setNotifyListener(new i(this.notifyListener));
        this.f16296v.setRewarded(this.f16276J);
        this.f16296v.setNotchPadding(this.f16277K, this.f16278L, this.f16279M, this.f16280N);
        this.f16296v.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() {
            public final void a() {
                com.mbridge.msdk.video.module.a.a aVar = MBridgeContainerView.this.notifyListener;
                if (aVar != null) {
                    aVar.a(117, "");
                }
            }

            public final void b() {
                if (MBridgeContainerView.this.f16239b.getAdSpaceT() == 2) {
                    MBridgeContainerView.this.showVideoEndCover();
                    return;
                }
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                mBridgeContainerView.showEndcard(mBridgeContainerView.f16239b.getVideo_end_type());
            }
        });
        this.f16296v.createView(this);
    }

    public void showPlayableView() {
        if (this.f16239b != null && !this.f16273G) {
            removeAllViews();
            setMatchParent();
            if (this.f16287m == null) {
                preLoadData(this.f16283Q);
            }
            addView(this.f16287m);
            MBridgePlayableView mBridgePlayableView = this.f16287m;
            if (mBridgePlayableView != null) {
                mBridgePlayableView.setUnitId(this.f16297w);
                CampaignEx campaignEx = this.f16239b;
                if (campaignEx != null && campaignEx.isMraid() && this.f16239b.getPlayable_ads_without_video() == 2) {
                    this.f16287m.setCloseVisible(0);
                }
                this.f16287m.setNotchValue(this.f16282P, this.f16277K, this.f16278L, this.f16279M, this.f16280N);
            }
            this.f16285S = true;
            bringToFront();
        }
    }

    public void showVideoClickView(int i4) {
        if (this.f16239b == null) {
            return;
        }
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 == 2) {
                    MBridgeClickCTAView mBridgeClickCTAView = this.f16288n;
                    if (!(mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null)) {
                        removeView(this.f16288n);
                    }
                    MBridgeAlertWebview mBridgeAlertWebview = this.f16295u;
                    if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
                        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getParent() == null) {
                            try {
                                CampaignEx campaignEx = this.f16239b;
                                if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 1) {
                                    setMatchParent();
                                    f();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (miniCardLoaded()) {
                            MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
                            if (!(mBridgeH5EndCardView == null || mBridgeH5EndCardView.getParent() == null)) {
                                removeView(this.f16291q);
                            }
                            this.notifyListener.a(112, "");
                            CampaignEx campaignEx2 = this.f16239b;
                            if (campaignEx2 != null && !campaignEx2.isHasReportAdTrackPause()) {
                                this.f16239b.setHasReportAdTrackPause(true);
                                com.mbridge.msdk.video.module.b.b.f(this.f16238a, this.f16239b);
                            }
                            if (this.f16270D) {
                                this.notifyListener.a(115, "");
                            } else {
                                this.f16285S = true;
                                bringToFront();
                                webviewshow();
                                onConfigurationChanged(getResources().getConfiguration());
                            }
                            this.f16269C = true;
                            return;
                        }
                        h();
                    }
                }
            } else if (!this.f16268B) {
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f16291q;
                if (!(mBridgeH5EndCardView2 == null || mBridgeH5EndCardView2.getParent() == null)) {
                    removeView(this.f16291q);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f16289o;
                if (!(mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null)) {
                    removeView(this.f16289o);
                }
                MBridgeClickCTAView mBridgeClickCTAView2 = this.f16288n;
                if (mBridgeClickCTAView2 == null || mBridgeClickCTAView2.getParent() == null) {
                    try {
                        CampaignEx campaignEx3 = this.f16239b;
                        if (campaignEx3 != null && campaignEx3.getPlayable_ads_without_video() == 1) {
                            this.f16285S = true;
                            if (this.f16288n == null) {
                                b(-1);
                            }
                            if (this.f16288n != null) {
                                CampaignEx campaignEx4 = this.f16239b;
                                if (campaignEx4 == null || !campaignEx4.isDynamicView()) {
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                    layoutParams.addRule(12, -1);
                                    addView(this.f16288n, 0, layoutParams);
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                }
            }
        } else if (!isLast() && !endCardShowing()) {
            h();
        }
    }

    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.f16294t;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.f16283Q;
            this.f16283Q = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.f16238a);
                this.f16294t = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.f16239b);
                this.f16294t.setNotifyListener(new i(this.notifyListener));
                this.f16294t.preLoadData(bVar);
            }
        }
        addView(this.f16294t);
        onConfigurationChanged(getResources().getConfiguration());
        this.f16285S = true;
        bringToFront();
    }

    public void toggleCloseBtn(int i4) {
        MBridgePlayableView mBridgePlayableView = this.f16287m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i4);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f16291q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i4);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            e eVar = new e();
            eVar.a("type", 2);
            d.a().a("2000152", eVar);
            d.a().a("2000134", this.f16239b);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        if (this.f16239b != null) {
            this.notifyListener.a(122, "");
            this.notifyListener.a(104, "");
        }
    }

    public void webviewshow() {
        try {
            e eVar = new e();
            eVar.a("type", 3);
            d.a().a("2000133", this.f16239b, eVar);
        } catch (Exception unused) {
        }
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f16287m, this.f16289o, this.f16291q, this.f16295u};
        for (int i4 = 0; i4 < 4; i4++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i4];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
            return;
        }
        af.b(MBridgeBaseView.TAG, "view is null");
    }

    private void a() {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null) {
            boolean isDynamicView = campaignEx.isDynamicView();
            boolean l4 = ak.l(this.f16239b.getendcard_url());
            if (isDynamicView && !l4 && !this.f16239b.isMraid()) {
                e();
                return;
            }
        }
        if (this.f16299y != 2 || this.f16275I) {
            e();
        } else {
            b();
        }
    }

    /* access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.module.a.a aVar;
        CampaignEx campaignEx2;
        this.f16283Q = bVar;
        CampaignEx campaignEx3 = this.f16239b;
        if (campaignEx3 != null) {
            if (num == null) {
                num = Integer.valueOf(campaignEx3.getVideo_end_type());
            }
            if (!isLast()) {
                h();
            }
            int intValue = num.intValue();
            if (intValue == 1) {
                return;
            }
            if (intValue == 3) {
                if (this.f16292r == null) {
                    this.f16292r = new MBridgeVastEndCardView(this.f16238a);
                }
                this.f16292r.setCampaign(this.f16239b);
                this.f16292r.setNotifyListener(new l(this.notifyListener));
                this.f16292r.preLoadData(bVar);
            } else if (intValue == 4) {
                if (this.f16293s == null) {
                    this.f16293s = new MBridgeLandingPageView(this.f16238a);
                }
                this.f16293s.setCampaign(this.f16239b);
                this.f16293s.setNotifyListener(new i(this.notifyListener));
            } else if (intValue == 5) {
            } else {
                if (this.f16299y == 2) {
                    boolean isDynamicView = this.f16239b.isDynamicView();
                    boolean l4 = ak.l(this.f16239b.getendcard_url());
                    if ((!isDynamicView || l4 || (campaignEx2 = this.f16239b) == null || campaignEx2.isMraid()) && (campaignEx = this.f16239b) != null && campaignEx.getAdSpaceT() != 2) {
                        if (this.f16291q == null) {
                            this.f16291q = new MBridgeH5EndCardView(this.f16238a);
                            try {
                                e eVar = new e();
                                eVar.a("type", 3);
                                d.a().a("2000154", this.f16239b, eVar);
                            } catch (Throwable th) {
                                af.b(MBridgeBaseView.TAG, th.getMessage());
                            }
                        }
                        if (this.f16239b.getDynamicTempCode() == 5 && (aVar = this.notifyListener) != null && (aVar instanceof k)) {
                            ((k) aVar).a(this.f16239b);
                        }
                        this.f16291q.setCampaign(this.f16239b);
                        this.f16291q.setCloseDelayShowTime(this.f16300z);
                        this.f16291q.setNotifyListener(new i(this.notifyListener));
                        this.f16291q.setUnitId(this.f16297w);
                        this.f16291q.setNotchValue(this.f16282P, this.f16277K, this.f16278L, this.f16279M, this.f16280N);
                        this.f16291q.preLoadData(bVar);
                        if (!this.f16270D) {
                            addView(this.f16291q);
                            return;
                        }
                        return;
                    }
                    return;
                }
                CampaignEx campaignEx4 = this.f16239b;
                int b5 = (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null) ? 0 : this.f16239b.getRewardTemplateMode().b();
                if (this.f16290p == null) {
                    CampaignEx campaignEx5 = this.f16239b;
                    if (campaignEx5 == null || !campaignEx5.isDynamicView()) {
                        Context context = this.f16238a;
                        CampaignEx campaignEx6 = this.f16239b;
                        boolean z4 = campaignEx6 != null && campaignEx6.getAdSpaceT() == 2;
                        CampaignEx campaignEx7 = this.f16239b;
                        MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(context, (AttributeSet) null, false, -1, z4, b5, campaignEx7 == null ? 0 : campaignEx7.getMof_tplid());
                        this.f16290p = mBridgeNativeEndCardView;
                        mBridgeNativeEndCardView.setCampaign(this.f16239b);
                    } else {
                        i();
                    }
                }
                this.f16290p.setLayout();
                if (this.f16239b.isDynamicView()) {
                    a a5 = a.a();
                    if (a5.a(this.f16239b.getRequestId() + "_" + this.f16239b.getId())) {
                        try {
                            a a6 = a.a();
                            MBridgeNativeEndCardView mBridgeNativeEndCardView2 = this.f16290p;
                            a6.a(mBridgeNativeEndCardView2, this.f16239b.getRequestId() + "_" + this.f16239b.getId(), new i(this.notifyListener));
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                    } else {
                        try {
                            String a7 = aq.a(this.f16239b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(a7) && Integer.parseInt(a7) == 1) {
                                a.a().a(this.f16239b, this.f16290p, new i(this.notifyListener), 2);
                            }
                        } catch (Exception e6) {
                            af.b(MBridgeBaseView.TAG, e6.getMessage());
                        }
                    }
                }
                this.f16290p.setUnitId(this.f16297w);
                this.f16290p.setCloseBtnDelay(this.f16300z);
                this.f16290p.setNotifyListener(new i(this.notifyListener));
                this.f16290p.preLoadData(bVar);
                this.f16290p.setNotchPadding(this.f16277K, this.f16278L, this.f16279M, this.f16280N);
            }
        }
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void b(int i4) {
        if (i4 == -3) {
            return;
        }
        if (i4 != -2) {
            if (this.f16288n == null) {
                this.f16288n = new MBridgeClickCTAView(this.f16238a);
            }
            this.f16288n.setCampaign(this.f16239b);
            this.f16288n.setUnitId(this.f16297w);
            this.f16288n.setNotifyListener(new i(this.notifyListener));
            this.f16288n.preLoadData(this.f16283Q);
            return;
        }
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && campaignEx.getVideo_end_type() == 2) {
            if (this.f16289o == null) {
                this.f16289o = new MBridgeClickMiniCardView(this.f16238a);
            }
            this.f16289o.setCampaign(this.f16239b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f16289o;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(mBridgeClickMiniCardView, this.notifyListener));
            this.f16289o.preLoadData(this.f16283Q);
            setMatchParent();
            f();
            h();
        }
    }
}
