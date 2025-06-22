package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.video.dynview.e.f;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import q1.C2206b;
import r1.C2215a;
import r1.C2216b;

public class MBridgeVideoView extends MBridgeBaseView implements j {
    /* access modifiers changed from: private */
    public static long aQ = 0;

    /* renamed from: m  reason: collision with root package name */
    private static int f16426m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static int f16427n = 0;

    /* renamed from: o  reason: collision with root package name */
    private static int f16428o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static int f16429p = 0;

    /* renamed from: q  reason: collision with root package name */
    private static int f16430q = 0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static boolean f16431r = false;
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public com.mbridge.msdk.video.module.a.a f16432A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public a f16433B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public boolean f16434C = false;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public com.mbridge.msdk.video.dynview.e.a f16435D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public f f16436E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public int f16437F = 0;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public boolean f16438G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public FrameLayout f16439H;

    /* renamed from: I  reason: collision with root package name */
    private MBridgeClickCTAView f16440I;

    /* renamed from: J  reason: collision with root package name */
    private com.mbridge.msdk.video.signal.factory.b f16441J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public int f16442K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public int f16443L;

    /* renamed from: M  reason: collision with root package name */
    private RelativeLayout f16444M;

    /* renamed from: N  reason: collision with root package name */
    private boolean f16445N = false;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public boolean f16446O = false;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public boolean f16447P = false;

    /* renamed from: Q  reason: collision with root package name */
    private String f16448Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public int f16449R;

    /* renamed from: S  reason: collision with root package name */
    private int f16450S;

    /* renamed from: T  reason: collision with root package name */
    private int f16451T;

    /* renamed from: U  reason: collision with root package name */
    private MBAlertDialog f16452U;

    /* renamed from: V  reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f16453V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public String f16454W = "";
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public boolean aB = false;
    /* access modifiers changed from: private */
    public boolean aC = false;
    /* access modifiers changed from: private */
    public AlphaAnimation aD;
    private MBridgeBaitClickView aE;
    /* access modifiers changed from: private */
    public int aF = 0;
    /* access modifiers changed from: private */
    public int aG = 5;
    private int aH = 5;
    /* access modifiers changed from: private */
    public int aI = 5;
    private AcquireRewardPopViewParameters aJ;
    /* access modifiers changed from: private */
    public MBAcquireRewardPopView aK;
    private boolean aL = false;
    /* access modifiers changed from: private */
    public RelativeLayout aM;
    /* access modifiers changed from: private */
    public CollapsibleWebView aN;
    /* access modifiers changed from: private */
    public RelativeLayout aO;
    /* access modifiers changed from: private */
    public boolean aP = false;
    /* access modifiers changed from: private */
    public int aR = 0;
    /* access modifiers changed from: private */
    public boolean aS = false;
    /* access modifiers changed from: private */
    public boolean aT = false;
    private c aU = new c(this);
    private boolean aV = false;
    private Runnable aW = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.f16439H != null) {
                MBridgeVideoView.this.f16439H.setVisibility(8);
            }
        }
    };
    /* access modifiers changed from: private */
    public final Runnable aX = new Runnable() {
        public final void run() {
            if (MBridgeVideoView.this.aG <= 0) {
                MBridgeVideoView.this.showRewardPopView();
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                mBridgeVideoView.removeCallbacks(mBridgeVideoView.aX);
                return;
            }
            MBridgeVideoView.aa(MBridgeVideoView.this);
            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
            mBridgeVideoView2.postDelayed(mBridgeVideoView2.aX, 1000);
        }
    };
    private double aa;
    private double ab;
    private boolean ac = false;
    private boolean ad = false;
    private boolean ae = false;
    private boolean af = false;
    private boolean ag = false;
    private boolean ah = false;
    private boolean ai = false;
    /* access modifiers changed from: private */
    public boolean aj = false;
    private boolean ak = false;
    private int al;
    /* access modifiers changed from: private */
    public boolean am = false;
    private int an = 2;
    private C2206b ao;
    /* access modifiers changed from: private */
    public C2216b ap;
    /* access modifiers changed from: private */
    public String aq;
    /* access modifiers changed from: private */
    public int ar;
    private int as;
    private int at;
    /* access modifiers changed from: private */
    public boolean au = false;
    /* access modifiers changed from: private */
    public boolean av = false;
    /* access modifiers changed from: private */
    public boolean aw = false;
    /* access modifiers changed from: private */
    public boolean ax = true;
    /* access modifiers changed from: private */
    public boolean ay = false;
    private boolean az = false;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize = 1;
    public int mCurrPlayNum = 1;
    public int mCurrentPlayProgressTime = 0;
    public int mMuteSwitch = 0;
    public PlayerView mPlayerView;
    public SoundImageView mSoundImageView;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public TextView f16455s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public View f16456t;
    public TextView tvFlag;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public RelativeLayout f16457u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public ImageView f16458v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public ProgressBar f16459w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public FeedBackButton f16460x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ImageView f16461y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public MBridgeSegmentsProgressBar f16462z;

    public interface a {
        void a();
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f16494a;

        /* renamed from: b  reason: collision with root package name */
        public int f16495b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16496c;

        public final String toString() {
            return "ProgressData{curPlayPosition=" + this.f16494a + ", allDuration=" + this.f16495b + '}';
        }
    }

    private static final class c extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private MBridgeVideoView f16497a;

        /* renamed from: b  reason: collision with root package name */
        private int f16498b;

        /* renamed from: c  reason: collision with root package name */
        private int f16499c;

        /* renamed from: d  reason: collision with root package name */
        private int f16500d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f16501e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public C2216b f16502f;

        /* renamed from: g  reason: collision with root package name */
        private b f16503g = new b();

        /* renamed from: h  reason: collision with root package name */
        private boolean f16504h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f16505i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f16506j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f16507k;

        /* renamed from: l  reason: collision with root package name */
        private String f16508l;

        /* renamed from: m  reason: collision with root package name */
        private CampaignEx f16509m;

        /* renamed from: n  reason: collision with root package name */
        private int f16510n;

        /* renamed from: o  reason: collision with root package name */
        private int f16511o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f16512p = false;

        public c(MBridgeVideoView mBridgeVideoView) {
            this.f16497a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.f16508l = mBridgeVideoView.getUnitId();
                this.f16509m = mBridgeVideoView.getCampaign();
            }
        }

        private void d() {
            MBridgeVideoView mBridgeVideoView = this.f16497a;
            if (mBridgeVideoView != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.f16455s.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -2;
                    layoutParams.height = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 25.0f);
                    this.f16497a.f16455s.setLayoutParams(layoutParams);
                }
                int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                this.f16497a.f16455s.setPadding(a5, 0, a5, 0);
            }
        }

        public final int b() {
            return this.f16500d;
        }

        public final void c() {
            this.f16497a = null;
            boolean unused = MBridgeVideoView.f16431r = false;
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                C2216b bVar = this.f16502f;
                if (bVar != null) {
                    bVar.b();
                    af.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f16497a.notifyListener.a(14, "");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if (this.f16502f != null) {
                    af.a("omsdk", "play:  videoEvents.bufferStart()");
                    this.f16502f.c();
                }
                this.f16497a.notifyListener.a(13, "");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onPlayCompleted() {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            boolean unused = this.f16497a.ay = true;
            CampaignEx campaignEx = this.f16509m;
            if (campaignEx != null) {
                if (!this.f16507k || campaignEx.getRewardTemplateMode() == null || this.f16509m.getRewardTemplateMode().f() != 5002010) {
                    this.f16497a.f16455s.setText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                } else {
                    this.f16497a.f16455s.setText("0");
                }
                this.f16509m.setVideoPlayProgress(100);
                if (this.f16509m.getAdSpaceT() == 2) {
                    this.f16497a.f16456t.setVisibility(4);
                    if (this.f16497a.f16460x != null) {
                        this.f16497a.f16460x.setClickable(false);
                    }
                    SoundImageView soundImageView = this.f16497a.mSoundImageView;
                    if (soundImageView != null) {
                        soundImageView.setClickable(false);
                    }
                }
            } else {
                this.f16497a.f16455s.setText("0");
            }
            C2216b bVar = this.f16502f;
            if (bVar != null) {
                bVar.d();
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f16497a.mPlayerView.setClickable(false);
            String e5 = this.f16497a.b(true);
            CampaignEx campaignEx2 = this.f16509m;
            if (!(campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || this.f16509m.getRewardTemplateMode().f() != 5002010)) {
                this.f16497a.j();
            }
            CampaignEx campaignEx3 = this.f16509m;
            if (!(campaignEx3 == null || campaignEx3.getDynamicTempCode() != 5 || (mBridgeVideoView = this.f16497a) == null || mBridgeVideoView.f16435D == null)) {
                MBridgeVideoView mBridgeVideoView2 = this.f16497a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("position", Integer.valueOf(this.f16497a.mCurrPlayNum));
                    int i4 = this.f16497a.mMuteSwitch;
                    if (i4 != 0) {
                        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i4));
                    }
                    this.f16497a.f16435D.a(hashMap);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f16497a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.notifyListener.a(121, "");
                this.f16497a.notifyListener.a(11, e5);
            }
            int i5 = this.f16499c;
            this.f16498b = i5;
            this.f16497a.mCurrentPlayProgressTime = i5;
            boolean unused2 = MBridgeVideoView.f16431r = true;
        }

        public final void onPlayError(String str) {
            af.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f16497a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.notifyListener.a(12, str);
            }
        }

        /* JADX WARNING: type inference failed for: r0v65, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r6v30, types: [java.lang.CharSequence] */
        /* JADX WARNING: type inference failed for: r6v36, types: [java.lang.CharSequence] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0368  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0393  */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x0421 A[Catch:{ all -> 0x041b }] */
        /* JADX WARNING: Removed duplicated region for block: B:192:0x045d A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:211:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r19, int r20) {
            /*
                r18 = this;
                r1 = r18
                r2 = r19
                r3 = r20
                r5 = 1
                super.onPlayProgress(r19, r20)
                long r6 = com.mbridge.msdk.video.module.MBridgeVideoView.aQ
                r8 = 0
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 != 0) goto L_0x001b
                long r6 = java.lang.System.currentTimeMillis()
                long unused = com.mbridge.msdk.video.module.MBridgeVideoView.aQ = r6
            L_0x001b:
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a
                boolean r6 = r6.aT
                if (r6 != 0) goto L_0x0039
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a
                com.mbridge.msdk.video.dynview.e.f r6 = r6.f16436E
                if (r6 == 0) goto L_0x0039
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a
                boolean unused = r6.aT = r5
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a
                com.mbridge.msdk.video.dynview.e.f r6 = r6.f16436E
                r6.a()
            L_0x0039:
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a
                boolean r6 = r6.f16242e
                java.lang.String r7 = "DefaultVideoPlayerStatusListener"
                java.lang.String r8 = ""
                if (r6 == 0) goto L_0x034e
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = r1.f16509m
                if (r6 == 0) goto L_0x0070
                int r6 = r6.getVideoCompleteTime()
                if (r6 > 0) goto L_0x004e
                r6 = r3
            L_0x004e:
                com.mbridge.msdk.foundation.d.b r9 = com.mbridge.msdk.foundation.d.b.a()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = r1.f16509m
                java.lang.String r11 = r11.getCampaignUnitId()
                r10.append(r11)
                java.lang.String r11 = "_"
                r10.append(r11)
                r10.append(r5)
                java.lang.String r10 = r10.toString()
                r9.b(r10, r2)
                goto L_0x0071
            L_0x0070:
                r6 = 0
            L_0x0071:
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = r1.f16509m
                java.lang.String r10 = "0"
                java.lang.String r11 = "mbridge_reward_video_view_reward_time_left"
                java.lang.String r12 = "mbridge_reward_video_view_reward_time_complete"
                java.lang.String r13 = "mbridge_reward_video_view_reward_time_left_skip_time"
                r14 = 4
                java.lang.String r15 = "string"
                if (r9 == 0) goto L_0x01e7
                boolean r9 = r9.isDynamicView()
                if (r9 == 0) goto L_0x01e7
                com.mbridge.msdk.foundation.entity.CampaignEx r9 = r1.f16509m
                int r9 = r9.getDynamicTempCode()
                r16 = 0
                r0 = 5
                if (r9 != r0) goto L_0x01e4
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ Exception -> 0x01d8 }
                int r0 = r0.f16437F     // Catch:{ Exception -> 0x01d8 }
                com.mbridge.msdk.video.module.MBridgeVideoView r9 = r1.f16497a     // Catch:{ Exception -> 0x01d8 }
                if (r9 != 0) goto L_0x009d
                goto L_0x034e
            L_0x009d:
                android.content.Context r9 = r9.getContext()     // Catch:{ Exception -> 0x01d8 }
                android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x01d8 }
                com.mbridge.msdk.foundation.controller.c r16 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x01d8 }
                r17 = 100
                android.content.Context r4 = r16.c()     // Catch:{ Exception -> 0x0100 }
                int r4 = com.mbridge.msdk.foundation.tools.x.a(r4, r12, r15)     // Catch:{ Exception -> 0x0100 }
                java.lang.CharSequence r4 = r9.getText(r4)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.video.module.MBridgeVideoView r9 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.content.Context r9 = r9.getContext()     // Catch:{ Exception -> 0x0100 }
                android.content.res.Resources r9 = r9.getResources()     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.foundation.controller.c r12 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0100 }
                android.content.Context r12 = r12.c()     // Catch:{ Exception -> 0x0100 }
                int r11 = com.mbridge.msdk.foundation.tools.x.a(r12, r11, r15)     // Catch:{ Exception -> 0x0100 }
                java.lang.CharSequence r9 = r9.getText(r11)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0100 }
                if (r6 < 0) goto L_0x0166
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f16509m     // Catch:{ Exception -> 0x0100 }
                int r0 = r0.getUseSkipTime()     // Catch:{ Exception -> 0x0100 }
                if (r0 != r5) goto L_0x0151
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                int r0 = r0.f16449R     // Catch:{ Exception -> 0x0100 }
                int r0 = java.lang.Math.min(r0, r6)     // Catch:{ Exception -> 0x0100 }
                if (r0 >= r6) goto L_0x0121
                if (r0 <= 0) goto L_0x0121
                int r0 = r0 - r2
                if (r0 > 0) goto L_0x0103
                int r0 = r6 - r2
                boolean r6 = r1.f16507k     // Catch:{ Exception -> 0x0100 }
                if (r6 == 0) goto L_0x0153
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.TextView r6 = r6.f16455s     // Catch:{ Exception -> 0x0100 }
                r6.setVisibility(r14)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0153
            L_0x0100:
                r0 = move-exception
                goto L_0x01db
            L_0x0103:
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.content.Context r6 = r6.getContext()     // Catch:{ Exception -> 0x0100 }
                android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0100 }
                android.content.Context r9 = r9.c()     // Catch:{ Exception -> 0x0100 }
                int r9 = com.mbridge.msdk.foundation.tools.x.a(r9, r13, r15)     // Catch:{ Exception -> 0x0100 }
                java.lang.CharSequence r6 = r6.getText(r9)     // Catch:{ Exception -> 0x0100 }
                r9 = r6
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0100 }
                goto L_0x0153
            L_0x0121:
                int r0 = r6 - r2
                boolean r6 = r1.f16507k     // Catch:{ Exception -> 0x0100 }
                if (r6 == 0) goto L_0x0153
                if (r0 > 0) goto L_0x0133
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.TextView r6 = r6.f16455s     // Catch:{ Exception -> 0x0100 }
                r6.setVisibility(r14)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0153
            L_0x0133:
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.content.Context r6 = r6.getContext()     // Catch:{ Exception -> 0x0100 }
                android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0100 }
                android.content.Context r9 = r9.c()     // Catch:{ Exception -> 0x0100 }
                int r9 = com.mbridge.msdk.foundation.tools.x.a(r9, r13, r15)     // Catch:{ Exception -> 0x0100 }
                java.lang.CharSequence r6 = r6.getText(r9)     // Catch:{ Exception -> 0x0100 }
                r9 = r6
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0100 }
                goto L_0x0153
            L_0x0151:
                int r0 = r6 - r2
            L_0x0153:
                if (r0 > 0) goto L_0x0156
                goto L_0x018a
            L_0x0156:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
                r4.<init>()     // Catch:{ Exception -> 0x0100 }
                r4.append(r0)     // Catch:{ Exception -> 0x0100 }
                r4.append(r9)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0100 }
                goto L_0x018a
            L_0x0166:
                int r0 = r0 - r2
                if (r0 > 0) goto L_0x016c
                if (r6 > 0) goto L_0x018a
                goto L_0x018b
            L_0x016c:
                if (r6 > 0) goto L_0x017e
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
                r4.<init>()     // Catch:{ Exception -> 0x0100 }
                r4.append(r0)     // Catch:{ Exception -> 0x0100 }
                r4.append(r8)     // Catch:{ Exception -> 0x0100 }
            L_0x0179:
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0100 }
                goto L_0x018a
            L_0x017e:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
                r4.<init>()     // Catch:{ Exception -> 0x0100 }
                r4.append(r0)     // Catch:{ Exception -> 0x0100 }
                r4.append(r9)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0179
            L_0x018a:
                r10 = r4
            L_0x018b:
                com.mbridge.msdk.video.module.MBridgeVideoView$b r4 = r1.f16503g     // Catch:{ Exception -> 0x0100 }
                r4.f16494a = r2     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.TextView r4 = r4.f16455s     // Catch:{ Exception -> 0x0100 }
                r4.setText(r10)     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.ProgressBar r4 = r4.f16459w     // Catch:{ Exception -> 0x0100 }
                if (r4 == 0) goto L_0x01b5
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.ProgressBar r4 = r4.f16459w     // Catch:{ Exception -> 0x0100 }
                int r4 = r4.getVisibility()     // Catch:{ Exception -> 0x0100 }
                if (r4 != 0) goto L_0x01b5
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                android.widget.ProgressBar r4 = r4.f16459w     // Catch:{ Exception -> 0x0100 }
                r4.setProgress(r2)     // Catch:{ Exception -> 0x0100 }
            L_0x01b5:
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                int r4 = r4.aI     // Catch:{ Exception -> 0x0100 }
                if (r0 >= r4) goto L_0x0350
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r4 = r4.aK     // Catch:{ Exception -> 0x0100 }
                if (r4 == 0) goto L_0x0350
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                boolean r4 = r4.f16447P     // Catch:{ Exception -> 0x0100 }
                if (r4 == 0) goto L_0x0350
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ Exception -> 0x0100 }
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r4 = r4.aK     // Catch:{ Exception -> 0x0100 }
                r4.onTimeLessThanReduce(r0)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0350
            L_0x01d8:
                r0 = move-exception
                r17 = 100
            L_0x01db:
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r7, r0)
                goto L_0x0350
            L_0x01e4:
                r17 = 100
                goto L_0x01ea
            L_0x01e7:
                r16 = 0
                goto L_0x01e4
            L_0x01ea:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                if (r0 != 0) goto L_0x01f0
                goto L_0x0349
            L_0x01f0:
                boolean r4 = r1.f16507k
                if (r4 == 0) goto L_0x0206
                int r0 = r3 - r2
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                java.lang.Object[] r4 = new java.lang.Object[r5]
                r4[r16] = r0
                java.lang.String r0 = "%s"
                java.lang.String r0 = java.lang.String.format(r0, r4)
                goto L_0x028e
            L_0x0206:
                if (r6 <= r3) goto L_0x0209
                r6 = r3
            L_0x0209:
                if (r6 > 0) goto L_0x020e
                int r4 = r3 - r2
                goto L_0x0210
            L_0x020e:
                int r4 = r6 - r2
            L_0x0210:
                if (r4 > 0) goto L_0x0232
                if (r6 > 0) goto L_0x0215
                goto L_0x0230
            L_0x0215:
                android.content.Context r0 = r0.getContext()
                android.content.res.Resources r0 = r0.getResources()
                com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r4 = r4.c()
                int r4 = com.mbridge.msdk.foundation.tools.x.a(r4, r12, r15)
                java.lang.CharSequence r0 = r0.getText(r4)
                r10 = r0
                java.lang.String r10 = (java.lang.String) r10
            L_0x0230:
                r0 = 0
                goto L_0x026c
            L_0x0232:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                if (r6 > 0) goto L_0x0244
                r0.<init>()
                r0.append(r4)
                r0.append(r8)
            L_0x023f:
                java.lang.String r0 = r0.toString()
                goto L_0x026a
            L_0x0244:
                r0.<init>()
                r0.append(r4)
                com.mbridge.msdk.video.module.MBridgeVideoView r9 = r1.f16497a
                android.content.Context r9 = r9.getContext()
                android.content.res.Resources r9 = r9.getResources()
                com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r10 = r10.c()
                int r10 = com.mbridge.msdk.foundation.tools.x.a(r10, r11, r15)
                java.lang.CharSequence r9 = r9.getText(r10)
                java.lang.String r9 = (java.lang.String) r9
                r0.append(r9)
                goto L_0x023f
            L_0x026a:
                r10 = r0
                r0 = r4
            L_0x026c:
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                int r4 = r4.aI
                if (r0 >= r4) goto L_0x028d
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r4 = r4.aK
                if (r4 == 0) goto L_0x028d
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                boolean r4 = r4.f16447P
                if (r4 == 0) goto L_0x028d
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView r4 = r4.aK
                r4.onTimeLessThanReduce(r0)
            L_0x028d:
                r0 = r10
            L_0x028e:
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f16509m
                if (r4 == 0) goto L_0x0323
                int r4 = r4.getUseSkipTime()
                if (r4 != r5) goto L_0x0323
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                int r4 = r4.f16449R
                int r4 = java.lang.Math.min(r4, r3)
                if (r4 >= r6) goto L_0x02e5
                if (r4 < 0) goto L_0x02e5
                int r4 = r4 - r2
                if (r4 <= 0) goto L_0x02d5
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r4)
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r6 = r6.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r13, r15)
                java.lang.CharSequence r4 = r4.getText(r6)
                java.lang.String r4 = (java.lang.String) r4
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                goto L_0x0323
            L_0x02d5:
                boolean r6 = r1.f16507k
                if (r6 == 0) goto L_0x0323
                if (r4 != 0) goto L_0x0323
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                android.widget.TextView r4 = r4.f16455s
                r4.setVisibility(r14)
                goto L_0x0323
            L_0x02e5:
                int r6 = r6 - r2
                boolean r4 = r1.f16507k
                if (r4 == 0) goto L_0x0323
                if (r6 <= 0) goto L_0x0318
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                android.content.Context r4 = r4.getContext()
                android.content.res.Resources r4 = r4.getResources()
                com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r6 = r6.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r6, r13, r15)
                java.lang.CharSequence r4 = r4.getText(r6)
                java.lang.String r4 = (java.lang.String) r4
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                goto L_0x0323
            L_0x0318:
                if (r6 != 0) goto L_0x0323
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                android.widget.TextView r4 = r4.f16455s
                r4.setVisibility(r14)
            L_0x0323:
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                android.widget.TextView r4 = r4.f16455s
                r4.setText(r0)
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                android.widget.ProgressBar r0 = r0.f16459w
                if (r0 == 0) goto L_0x0349
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                android.widget.ProgressBar r0 = r0.f16459w
                int r0 = r0.getVisibility()
                if (r0 != 0) goto L_0x0349
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                android.widget.ProgressBar r0 = r0.f16459w
                r0.setProgress(r2)
            L_0x0349:
                com.mbridge.msdk.video.module.MBridgeVideoView$b r0 = r1.f16503g
                r0.f16494a = r2
                goto L_0x0350
            L_0x034e:
                r17 = 100
            L_0x0350:
                r1.f16499c = r3
                com.mbridge.msdk.video.module.MBridgeVideoView$b r0 = r1.f16503g
                r0.f16495b = r3
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a
                boolean r4 = r4.aA
                r0.f16496c = r4
                r1.f16498b = r2
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                android.widget.ImageView r0 = r0.f16461y
                if (r0 == 0) goto L_0x0382
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                android.widget.ImageView r0 = r0.f16461y
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r8)
                int r6 = r1.f16498b
                r4.append(r6)
                java.lang.String r4 = r4.toString()
                r0.setTag(r4)
            L_0x0382:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                r0.mCurrentPlayProgressTime = r2
                com.mbridge.msdk.video.module.a.a r0 = r0.notifyListener
                r4 = 15
                com.mbridge.msdk.video.module.MBridgeVideoView$b r6 = r1.f16503g
                r0.a(r4, r6)
                r1.b r0 = r1.f16502f
                if (r0 == 0) goto L_0x03db
                int r4 = r2 * 100
                int r4 = r4 / r3
                int r6 = r2 + 1
                int r6 = r6 * 100
                int r6 = r6 / r3
                r8 = 25
                java.lang.String r9 = "omsdk"
                if (r4 > r8) goto L_0x03b2
                if (r8 >= r6) goto L_0x03b2
                boolean r8 = r1.f16504h
                if (r8 != 0) goto L_0x03b2
                r1.f16504h = r5
                r0.h()
                java.lang.String r0 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r9, (java.lang.String) r0)
                goto L_0x03db
            L_0x03b2:
                r8 = 50
                if (r4 > r8) goto L_0x03c7
                if (r8 >= r6) goto L_0x03c7
                boolean r8 = r1.f16505i
                if (r8 != 0) goto L_0x03c7
                r1.f16505i = r5
                r0.i()
                java.lang.String r0 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r9, (java.lang.String) r0)
                goto L_0x03db
            L_0x03c7:
                r8 = 75
                if (r4 > r8) goto L_0x03db
                if (r8 >= r6) goto L_0x03db
                boolean r4 = r1.f16506j
                if (r4 != 0) goto L_0x03db
                r1.f16506j = r5
                r0.n()
                java.lang.String r0 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r9, (java.lang.String) r0)
            L_0x03db:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                boolean r0 = r0.am
                if (r0 == 0) goto L_0x03fa
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                boolean r0 = r0.au
                if (r0 != 0) goto L_0x03fa
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                int r0 = r0.ar
                int r4 = com.mbridge.msdk.foundation.same.a.f13111I
                if (r0 != r4) goto L_0x03fa
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a
                r0.e()
            L_0x03fa:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                if (r0 == 0) goto L_0x041d
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r0 = r0.f16462z     // Catch:{ all -> 0x041b }
                if (r0 == 0) goto L_0x041d
                int r0 = r2 * 100
                int r0 = r0 / r3
                com.mbridge.msdk.video.module.MBridgeVideoView r4 = r1.f16497a     // Catch:{ all -> 0x041b }
                com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar r4 = r4.f16462z     // Catch:{ all -> 0x041b }
                com.mbridge.msdk.video.module.MBridgeVideoView r6 = r1.f16497a     // Catch:{ all -> 0x041b }
                int r6 = r6.mCurrPlayNum     // Catch:{ all -> 0x041b }
                int r6 = r6 - r5
                r4.setProgress(r0, r6)     // Catch:{ all -> 0x041b }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f16509m     // Catch:{ all -> 0x041b }
                r4.setVideoPlayProgress(r0)     // Catch:{ all -> 0x041b }
                goto L_0x041d
            L_0x041b:
                r0 = move-exception
                goto L_0x044c
            L_0x041d:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                if (r0 == 0) goto L_0x0453
                int r0 = r0.f16443L     // Catch:{ all -> 0x041b }
                r4 = -5
                if (r0 == r4) goto L_0x042f
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                int r0 = r0.f16443L     // Catch:{ all -> 0x041b }
                goto L_0x0435
            L_0x042f:
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                int r0 = r0.f16442K     // Catch:{ all -> 0x041b }
            L_0x0435:
                r4 = -1
                if (r0 == r4) goto L_0x0453
                if (r2 != r0) goto L_0x0453
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = r0.f16239b     // Catch:{ all -> 0x041b }
                if (r0 == 0) goto L_0x0453
                boolean r0 = r0.isDynamicView()     // Catch:{ all -> 0x041b }
                if (r0 == 0) goto L_0x0453
                com.mbridge.msdk.video.module.MBridgeVideoView r0 = r1.f16497a     // Catch:{ all -> 0x041b }
                r0.setCTALayoutVisibleOrGone()     // Catch:{ all -> 0x041b }
                goto L_0x0453
            L_0x044c:
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r7, r0)
            L_0x0453:
                int r0 = r1.f16510n
                r4 = 100
                if (r0 == r4) goto L_0x04fd
                boolean r4 = r1.f16512p
                if (r4 != 0) goto L_0x04fd
                if (r0 != 0) goto L_0x0461
                goto L_0x04fd
            L_0x0461:
                int r4 = r1.f16511o
                if (r4 <= r0) goto L_0x0469
                int r0 = r0 / 2
                r1.f16511o = r0
            L_0x0469:
                int r0 = r1.f16511o
                if (r0 < 0) goto L_0x04fd
                int r0 = r0 * r3
                r17 = 100
                int r0 = r0 / 100
                if (r2 < r0) goto L_0x04fd
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f16509m
                int r2 = r2.getAdType()
                r3 = 94
                if (r2 == r3) goto L_0x04af
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f16509m
                int r2 = r2.getAdType()
                r3 = 287(0x11f, float:4.02E-43)
                if (r2 != r3) goto L_0x048a
                goto L_0x04af
            L_0x048a:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getId()
                r2.append(r3)
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getVideoUrlEncode()
                r2.append(r3)
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getBidToken()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                goto L_0x04d3
            L_0x04af:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getRequestId()
                r2.append(r3)
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getId()
                r2.append(r3)
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f16509m
                java.lang.String r3 = r3.getVideoUrlEncode()
                r2.append(r3)
                java.lang.String r2 = r2.toString()
            L_0x04d3:
                com.mbridge.msdk.videocommon.download.b r3 = com.mbridge.msdk.videocommon.download.b.getInstance()
                java.lang.String r4 = r1.f16508l
                com.mbridge.msdk.videocommon.download.a r2 = r3.a((java.lang.String) r4, (java.lang.String) r2)
                if (r2 == 0) goto L_0x04fd
                r2.p()
                r1.f16512p = r5
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "CDRate is : "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r0 = " and start download !"
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                com.mbridge.msdk.foundation.tools.af.b(r7, r0)
            L_0x04fd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.c.onPlayProgress(int, int):void");
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void onPlayStarted(int i4) {
            float f4;
            PlayerView playerView;
            CampaignEx campaignEx;
            super.onPlayStarted(i4);
            MBridgeVideoView mBridgeVideoView = this.f16497a;
            if (mBridgeVideoView != null) {
                MBridgeVideoView.C(mBridgeVideoView);
            }
            if (!this.f16501e) {
                MBridgeVideoView mBridgeVideoView2 = this.f16497a;
                if (mBridgeVideoView2 != null) {
                    boolean unused = mBridgeVideoView2.f16438G = true;
                    this.f16497a.notifyListener.a(10, this.f16503g);
                }
                this.f16501e = true;
            }
            this.f16500d = i4;
            CampaignEx campaignEx2 = this.f16509m;
            if (campaignEx2 != null) {
                int videoCompleteTime = campaignEx2.getVideoCompleteTime();
                if (videoCompleteTime <= 0) {
                    videoCompleteTime = i4;
                }
                String str = "mbridge_reward_shape_progress";
                if (this.f16509m.isDynamicView()) {
                    MBridgeVideoView mBridgeVideoView3 = this.f16497a;
                    if (!(mBridgeVideoView3 == null || mBridgeVideoView3.f16455s == null)) {
                        if (this.f16509m.getDynamicTempCode() == 5) {
                            MBridgeVideoView mBridgeVideoView4 = this.f16497a;
                            if (mBridgeVideoView4.mCurrPlayNum > 1 && videoCompleteTime <= 0) {
                                mBridgeVideoView4.f16455s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                                d();
                            }
                        }
                        if (videoCompleteTime > 0) {
                            if (!this.f16507k || this.f16509m.getDynamicTempCode() == 5) {
                                d();
                            }
                            str = "mbridge_reward_video_time_count_num_bg";
                        }
                        CampaignEx campaignEx3 = this.f16509m;
                        if (campaignEx3 != null && campaignEx3.getUseSkipTime() == 1 && this.f16507k) {
                            d();
                        }
                        this.f16497a.f16455s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                    }
                } else if (videoCompleteTime > 0) {
                    this.f16497a.f16455s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 30.0f));
                    int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f);
                    layoutParams.addRule(1, x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_native_endcard_feed_btn", "id"));
                    layoutParams.setMargins(a5, 0, 0, 0);
                    this.f16497a.f16455s.setPadding(a5, 0, a5, 0);
                    this.f16497a.f16455s.setLayoutParams(layoutParams);
                } else {
                    this.f16497a.f16455s.setBackgroundResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, "drawable"));
                }
            }
            MBridgeVideoView mBridgeVideoView5 = this.f16497a;
            if (!(mBridgeVideoView5 == null || mBridgeVideoView5.f16459w == null)) {
                this.f16497a.f16459w.setMax(i4);
            }
            MBridgeVideoView mBridgeVideoView6 = this.f16497a;
            if (!(mBridgeVideoView6 == null || mBridgeVideoView6.f16457u == null || (campaignEx = this.f16509m) == null || campaignEx.getAdSpaceT() != 2)) {
                this.f16497a.f16457u.setVisibility(0);
            }
            MBridgeVideoView mBridgeVideoView7 = this.f16497a;
            if (!(mBridgeVideoView7 == null || mBridgeVideoView7.f16455s == null || this.f16497a.f16455s.getVisibility() != 0)) {
                this.f16497a.n();
            }
            boolean unused2 = MBridgeVideoView.f16431r = false;
            if (this.f16497a != null && this.f16509m.isDynamicView()) {
                if (this.f16497a.f16443L != -5) {
                    if (this.f16497a.f16443L == 0) {
                        this.f16497a.setCTALayoutVisibleOrGone();
                    }
                } else if (this.f16497a.f16442K == 0) {
                    this.f16497a.setCTALayoutVisibleOrGone();
                }
            }
            MBridgeVideoView mBridgeVideoView8 = this.f16497a;
            if (mBridgeVideoView8 != null) {
                mBridgeVideoView8.showMoreOfferInPlayTemplate();
                this.f16497a.showBaitClickView();
                MBridgeVideoView.I(this.f16497a);
            }
            if (this.f16502f != null) {
                try {
                    MBridgeVideoView mBridgeVideoView9 = this.f16497a;
                    if (mBridgeVideoView9 == null || (playerView = mBridgeVideoView9.mPlayerView) == null) {
                        f4 = 0.0f;
                    } else {
                        f4 = playerView.getVolume();
                    }
                    this.f16502f.m((float) i4, f4);
                    af.a("omsdk", "play video view:  videoEvents.start");
                } catch (Exception e5) {
                    af.b("omsdk", e5.getMessage());
                }
            }
        }

        public final void a(CampaignEx campaignEx) {
            this.f16509m = campaignEx;
        }

        public final void a(boolean z4) {
            this.f16507k = z4;
        }

        public final void a(String str) {
            this.f16508l = str;
        }

        public final int a() {
            return this.f16498b;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0095 A[Catch:{ Exception -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.f16510n = r3
                r2.f16511o = r4
                com.mbridge.msdk.foundation.tools.ah r3 = com.mbridge.msdk.foundation.tools.ah.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00b0
            L_0x0015:
                int r3 = r2.f16510n
                r4 = 100
                if (r3 == r4) goto L_0x00b0
                int r4 = r2.f16511o
                if (r4 != 0) goto L_0x00b0
                boolean r4 = r2.f16512p
                if (r4 != 0) goto L_0x00b0
                if (r3 == 0) goto L_0x00b0
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.f16509m
                if (r3 != 0) goto L_0x002b
                goto L_0x00b0
            L_0x002b:
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x0063 }
                r4 = 94
                if (r3 == r4) goto L_0x0065
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x0063 }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x003e
                goto L_0x0065
            L_0x003e:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
                r3.<init>()     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0063 }
                goto L_0x0089
            L_0x0063:
                r3 = move-exception
                goto L_0x00a5
            L_0x0065:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0063 }
                r3.<init>()     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r2.f16509m     // Catch:{ Exception -> 0x0063 }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x0063 }
                r3.append(r4)     // Catch:{ Exception -> 0x0063 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0063 }
            L_0x0089:
                com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0063 }
                java.lang.String r1 = r2.f16508l     // Catch:{ Exception -> 0x0063 }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x0063 }
                if (r3 == 0) goto L_0x00b0
                r3.p()     // Catch:{ Exception -> 0x0063 }
                r3 = 1
                r2.f16512p = r3     // Catch:{ Exception -> 0x0063 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0063 }
                if (r3 == 0) goto L_0x00b0
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ Exception -> 0x0063 }
                return
            L_0x00a5:
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00b0
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)
            L_0x00b0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.c.a(int, int):void");
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
    }

    static /* synthetic */ void C(MBridgeVideoView mBridgeVideoView) {
        CollapsibleWebView collapsibleWebView = mBridgeVideoView.aN;
        if (collapsibleWebView != null && mBridgeVideoView.f16239b != null && TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            mBridgeVideoView.aN.loadUrl(mBridgeVideoView.f16239b.getClickURL());
            mBridgeVideoView.aN.setToolBarTitle(mBridgeVideoView.f16239b.getAppName());
            g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (b5 == null) {
                h.a();
                b5 = i.a();
            }
            mBridgeVideoView.aN.setPageLoadTimtout((int) b5.ar());
            mBridgeVideoView.aN.setPageLoadListener(new CollapsibleWebView.a() {
                public final void a(View view, String str) {
                    JSONObject jSONObject;
                    if (!MBridgeVideoView.this.aP) {
                        boolean unused = MBridgeVideoView.this.aP = true;
                        if (!(MBridgeVideoView.this.aM == null || MBridgeVideoView.this.aM.getVisibility() == 0)) {
                            MBridgeVideoView.this.aM.setVisibility(0);
                        }
                        Context context = MBridgeVideoView.this.getContext();
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        com.mbridge.msdk.click.a.a(context, mBridgeVideoView.f16239b, mBridgeVideoView.getUnitId(), MBridgeVideoView.this.f16239b.getNoticeUrl(), true, false, com.mbridge.msdk.click.a.a.f12016i);
                        com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c().getApplicationContext(), MBridgeVideoView.this.f16239b);
                        e eVar = new e();
                        eVar.a("result", 1);
                        if (MBridgeVideoView.this.f16432A != null) {
                            JSONObject jSONObject2 = null;
                            try {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f13136j, MBridgeVideoView.this.a(0));
                                } catch (JSONException e5) {
                                    e = e5;
                                    jSONObject2 = jSONObject;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                e.printStackTrace();
                                jSONObject = jSONObject2;
                                MBridgeVideoView.this.f16432A.a(131, jSONObject);
                                MBridgeVideoView.this.f16239b.setClickType(1);
                                MBridgeVideoView.this.f16239b.setClickTempSource(1);
                                MBridgeVideoView.this.f16239b.setTriggerClickSource(2);
                                d.a().a("2000149", MBridgeVideoView.this.f16239b);
                                eVar.a("type", 9);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add("web_view");
                                eVar.a("click_path", arrayList.toString());
                                d.a().a("2000150", MBridgeVideoView.this.f16239b, eVar);
                                eVar.a("url", str);
                                d.a().a("m_webview_render", MBridgeVideoView.this.f16239b, eVar);
                            }
                            MBridgeVideoView.this.f16432A.a(131, jSONObject);
                            MBridgeVideoView.this.f16239b.setClickType(1);
                            MBridgeVideoView.this.f16239b.setClickTempSource(1);
                            MBridgeVideoView.this.f16239b.setTriggerClickSource(2);
                            d.a().a("2000149", MBridgeVideoView.this.f16239b);
                            eVar.a("type", 9);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add("web_view");
                            eVar.a("click_path", arrayList2.toString());
                            d.a().a("2000150", MBridgeVideoView.this.f16239b, eVar);
                        }
                        eVar.a("url", str);
                        d.a().a("m_webview_render", MBridgeVideoView.this.f16239b, eVar);
                    }
                }

                public final void b(View view, Map<String, String> map) {
                }

                public final void b(View view, String str) {
                    a(str, "timeout");
                }

                public final void a(View view, Map<String, String> map) {
                    String str;
                    String str2 = "";
                    if (map != null) {
                        String str3 = map.get("url");
                        if (str3 != null) {
                            str2 = str3;
                        }
                        str = map.get("description");
                    } else {
                        str = str2;
                    }
                    a(str2, str);
                }

                private void a(String str, String str2) {
                    if (!MBridgeVideoView.this.aP) {
                        boolean unused = MBridgeVideoView.this.aP = true;
                        if (str == null) {
                            str = "";
                        }
                        if (MBridgeVideoView.this.aM != null && MBridgeVideoView.this.aM.getVisibility() == 0) {
                            MBridgeVideoView.this.aM.setVisibility(8);
                        }
                        e eVar = new e();
                        eVar.a("result", 2);
                        eVar.a("url", str);
                        if (Build.VERSION.SDK_INT >= 23) {
                            eVar.a("reason", str2);
                        }
                        d.a().a("m_webview_render", MBridgeVideoView.this.f16239b, eVar);
                    }
                }
            });
            mBridgeVideoView.aN.setWebViewClient(new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                }

                public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                }
            });
            mBridgeVideoView.aN.setCollapseListener(new CommonWebView.a() {
                public final void a() {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(0);
                        e eVar = new e();
                        eVar.a(NotificationCompat.CATEGORY_STATUS, 1);
                        d.a().a("m_webview_zoom", MBridgeVideoView.this.f16239b, eVar);
                    }
                    if (MBridgeVideoView.this.aN != null) {
                        MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
                    }
                    MBridgeVideoView.this.h();
                }
            });
            mBridgeVideoView.aN.setExpandListener(new CommonWebView.a() {
                public final void a() {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(8);
                        e eVar = new e();
                        eVar.a(NotificationCompat.CATEGORY_STATUS, 2);
                        d.a().a("m_webview_zoom", MBridgeVideoView.this.f16239b, eVar);
                    }
                    if (MBridgeVideoView.this.aN != null) {
                        MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.aR, 0, 0);
                    }
                    MBridgeVideoView.this.g();
                }
            });
            mBridgeVideoView.aN.setExitsClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeVideoView.this.aO != null) {
                        MBridgeVideoView.this.aO.setVisibility(0);
                    }
                    if (MBridgeVideoView.this.aM != null) {
                        MBridgeVideoView.this.aM.setVisibility(8);
                    }
                    if (!MBridgeVideoView.this.ay) {
                        MBridgeVideoView.this.h();
                    }
                }
            });
        }
    }

    static /* synthetic */ void I(MBridgeVideoView mBridgeVideoView) {
        String str;
        CampaignEx campaignEx = mBridgeVideoView.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView() && !mBridgeVideoView.f16445N) {
            if (!TextUtils.isEmpty(mBridgeVideoView.f16239b.getMof_template_url())) {
                str = mBridgeVideoView.f16239b.getMof_template_url();
            } else if (mBridgeVideoView.f16239b.getRewardTemplateMode() != null) {
                str = mBridgeVideoView.f16239b.getRewardTemplateMode().e();
            } else {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String a5 = aq.a(str, "guideShow");
                    String a6 = aq.a(str, "guideDelay");
                    String a7 = aq.a(str, "guideTime");
                    String a8 = aq.a(str, "guideRewardTime");
                    if (!TextUtils.isEmpty(a5)) {
                        mBridgeVideoView.aF = Integer.parseInt(a5);
                    }
                    if (!TextUtils.isEmpty(a6)) {
                        int parseInt = Integer.parseInt(a6);
                        mBridgeVideoView.aG = parseInt;
                        if (parseInt > 10 || parseInt < 3) {
                            mBridgeVideoView.aG = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a7)) {
                        int parseInt2 = Integer.parseInt(a7);
                        mBridgeVideoView.aH = parseInt2;
                        if (parseInt2 > 10 || parseInt2 < 3) {
                            mBridgeVideoView.aH = 5;
                        }
                    }
                    if (!TextUtils.isEmpty(a8)) {
                        int parseInt3 = Integer.parseInt(a8);
                        mBridgeVideoView.aI = parseInt3;
                        if (parseInt3 > 10 || parseInt3 < 5) {
                            mBridgeVideoView.aI = 5;
                        }
                    }
                    int i4 = mBridgeVideoView.aF;
                    if (i4 <= 0) {
                        return;
                    }
                    if (i4 <= 2) {
                        int o4 = mBridgeVideoView.o();
                        if (o4 == 0 || o4 > mBridgeVideoView.aG) {
                            int i5 = o4 - mBridgeVideoView.aG;
                            if (i5 >= 0 && mBridgeVideoView.aI > i5) {
                                mBridgeVideoView.aI = i5;
                            }
                            int p4 = mBridgeVideoView.p();
                            if (mBridgeVideoView.aI >= p4) {
                                mBridgeVideoView.aI = p4 - mBridgeVideoView.aG;
                            }
                            if (mBridgeVideoView.aG < p4) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(mBridgeVideoView.f16239b.getAppName());
                                String str2 = "US";
                                g a9 = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                                if (a9 != null) {
                                    str2 = a9.r();
                                }
                                mBridgeVideoView.aJ = new AcquireRewardPopViewParameters.Builder("", mBridgeVideoView.f16454W, mBridgeVideoView.aF, str2).setAutoDismissTime(mBridgeVideoView.aH).setReduceTime(mBridgeVideoView.aI).setBehaviourListener(new AcquireRewardPopViewBehaviourListener() {
                                    public final void onOutOfContentClicked(float f4, float f5) {
                                        if (MBridgeVideoView.this.f16432A != null) {
                                            MBridgeVideoView.this.f16432A.a(105, "");
                                        }
                                    }

                                    public final void onReceivedFail(String str) {
                                        boolean unused = MBridgeVideoView.this.f16447P = false;
                                        if (com.mbridge.msdk.e.b.b()) {
                                            MBridgeVideoView.this.setCover(false);
                                        }
                                        MBridgeVideoView.this.h();
                                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView.f16239b, mBridgeVideoView.f16454W, MBridgeVideoView.this.aF, 2, str);
                                    }

                                    public final void onReceivedSuccess(int i4) {
                                        boolean unused = MBridgeVideoView.this.f16447P = false;
                                        if (com.mbridge.msdk.e.b.b()) {
                                            MBridgeVideoView.this.setCover(false);
                                        }
                                        int A4 = MBridgeVideoView.this.o() - i4;
                                        MBridgeVideoView.this.f16239b.setVideoCompleteTime(A4);
                                        MBridgeVideoView.this.h();
                                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                                        if (aVar != null) {
                                            aVar.a(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, Integer.valueOf(A4));
                                        }
                                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView.f16239b, mBridgeVideoView.f16454W, MBridgeVideoView.this.aF, 1, "");
                                    }
                                }).setRightAnswerList(arrayList).build();
                                mBridgeVideoView.postDelayed(mBridgeVideoView.aX, 1000);
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
        }
    }

    static /* synthetic */ int aa(MBridgeVideoView mBridgeVideoView) {
        int i4 = mBridgeVideoView.aG;
        mBridgeVideoView.aG = i4 - 1;
        return i4;
    }

    public void addCTAView() {
        if (this.f16439H != null) {
            if (this.f16440I == null) {
                MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
                this.f16440I = mBridgeClickCTAView;
                mBridgeClickCTAView.setCampaign(this.f16239b);
                this.f16440I.setUnitId(this.f16454W);
                com.mbridge.msdk.video.module.a.a aVar = this.f16432A;
                if (aVar != null) {
                    this.f16440I.setNotifyListener(new com.mbridge.msdk.video.module.a.a.i(aVar));
                }
                this.f16440I.preLoadData(this.f16441J);
            }
            this.f16439H.addView(this.f16440I);
        }
    }

    public void alertWebViewShowed() {
        this.f16446O = true;
        setShowingAlertViewCover(true);
    }

    public void closeVideoOperate(int i4, int i5) {
        if (i4 == 1) {
            this.aB = true;
            if (getVisibility() == 0) {
                e();
            }
            try {
                e eVar = new e();
                eVar.a("type", 1);
                d.a().a("2000152", eVar);
                d.a().a("2000148", this.f16239b, eVar);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
        if (i5 == 1) {
            gonePlayingCloseView();
        } else if (i5 != 2) {
        } else {
            if (!this.aA || getVisibility() != 0) {
                j();
            }
        }
    }

    public void defaultShow() {
        super.defaultShow();
        this.ac = true;
        showVideoLocation(0, 0, ak.f(this.f16238a), ak.e(this.f16238a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.f16449R == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.f16452U;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(125, "");
        }
    }

    public int getBorderViewHeight() {
        return f16430q;
    }

    public int getBorderViewLeft() {
        return f16428o;
    }

    public int getBorderViewRadius() {
        return f16426m;
    }

    public int getBorderViewTop() {
        return f16427n;
    }

    public int getBorderViewWidth() {
        return f16429p;
    }

    public int getCloseAlert() {
        return this.f16451T;
    }

    public String getCurrentProgress() {
        int i4;
        try {
            int a5 = this.aU.a();
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null) {
                i4 = campaignEx.getVideoLength();
            } else {
                i4 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(a5, i4));
            jSONObject.put("time", a5);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, i4 + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public int getMute() {
        return this.an;
    }

    public String getUnitId() {
        return this.f16454W;
    }

    public int getVideoSkipTime() {
        return this.f16449R;
    }

    public void gonePlayingCloseView() {
        if (this.f16242e && this.f16456t.getVisibility() != 8) {
            this.f16456t.setVisibility(8);
            this.ag = false;
        }
        if (!this.aV && !this.aj && !this.ah) {
            this.aV = true;
            int i4 = this.f16449R;
            if (i4 >= 0) {
                if (i4 == 0) {
                    this.aj = true;
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            boolean unused = MBridgeVideoView.this.aj = true;
                        }
                    }, (long) (this.f16449R * 1000));
                }
            }
        }
    }

    public void hideAlertView(int i4) {
        if (this.f16446O) {
            this.f16446O = false;
            this.au = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f16454W, false);
            int i5 = i4;
            com.mbridge.msdk.foundation.same.report.i.a(this.f16238a, this.f16239b, com.mbridge.msdk.videocommon.d.c.f16988a, this.f16454W, 1, i5, 1);
            if (i5 == 0) {
                h();
                if (this.am) {
                    int i6 = this.ar;
                    if (i6 == com.mbridge.msdk.foundation.same.a.f13111I || i6 == com.mbridge.msdk.foundation.same.a.f13110H) {
                        this.av = true;
                        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        CampaignEx campaignEx = this.f16239b;
                        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f16239b.getRewardTemplateMode().f() != 5002010) {
                            this.aA = true;
                            gonePlayingCloseView();
                            return;
                        }
                        j();
                        return;
                    }
                    return;
                }
                return;
            }
            this.aw = true;
            boolean z4 = this.am;
            if (z4 && this.ar == com.mbridge.msdk.foundation.same.a.f13111I) {
                h();
            } else if (!z4 || this.ar != com.mbridge.msdk.foundation.same.a.f13110H) {
                com.mbridge.msdk.video.module.a.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.aS = true;
                    aVar2.a(2, "");
                }
            } else {
                com.mbridge.msdk.video.module.a.a aVar3 = this.notifyListener;
                if (aVar3 != null) {
                    this.aS = true;
                    aVar3.a(2, b(this.ay));
                }
            }
        }
    }

    public void init(Context context) {
    }

    public boolean isH5Canvas() {
        if (getLayoutParams().height >= ak.e(this.f16238a.getApplicationContext())) {
            return false;
        }
        return true;
    }

    public boolean isInstDialogShowing() {
        return this.aL;
    }

    public boolean isMiniCardShowing() {
        return this.af;
    }

    public boolean isRewardPopViewShowing() {
        return this.f16447P;
    }

    public boolean isShowingAlertView() {
        return this.f16446O;
    }

    public boolean isShowingTransparent() {
        return this.ak;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i4 = indexOfChild + 1;
        boolean z4 = false;
        while (i4 <= childCount - 1) {
            if (viewGroup.getChildAt(i4).getVisibility() == 0 && this.af) {
                return false;
            }
            i4++;
            z4 = true;
        }
        return z4;
    }

    public void notifyCloseBtn(int i4) {
        if (i4 == 0) {
            this.ah = true;
            this.aj = false;
        } else if (i4 == 1) {
            this.ai = true;
        }
    }

    public void notifyVideoClose() {
        this.aS = true;
        this.notifyListener.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPress() {
        boolean z4;
        if (!this.af && !this.f16446O && !this.av) {
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f16239b.getRewardTemplateMode().f() == 5002010 && (z4 = this.ay)) {
                com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
                if (aVar != null) {
                    this.aS = true;
                    aVar.a(2, b(z4));
                }
            } else if (this.ag) {
                e();
            } else {
                boolean z5 = this.ah;
                if (z5 && this.ai) {
                    e();
                } else if (!z5 && this.aj) {
                    e();
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f16239b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.f16242e && this.ac) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aW != null) {
                getHandler().removeCallbacks(this.aW);
            }
            if (this.aF != 0) {
                removeCallbacks(this.aX);
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f16441J = bVar;
        if (!this.f16242e) {
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.f16448Q) && this.f16239b != null) {
            C2206b bVar2 = this.ao;
            if (bVar2 != null) {
                bVar2.d(this.mPlayerView);
                SoundImageView soundImageView = this.mSoundImageView;
                if (soundImageView != null) {
                    this.ao.a(soundImageView, q1.h.OTHER, (String) null);
                }
                this.ao.a(this.f16455s, q1.h.OTHER, (String) null);
                this.ao.a(this.f16456t, q1.h.VIDEO_CONTROLS, (String) null);
            }
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && ap.b(campaignEx.getVideoResolution())) {
                String videoResolution = this.f16239b.getVideoResolution();
                af.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                String[] split = videoResolution.split("x");
                if (split.length == 2) {
                    if (ak.m(split[0]) > 0.0d) {
                        this.aa = ak.m(split[0]);
                    }
                    if (ak.m(split[1]) > 0.0d) {
                        this.ab = ak.m(split[1]);
                    }
                    af.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.aa + "  mVideoH:" + this.ab);
                }
                if (this.aa <= 0.0d) {
                    this.aa = 1280.0d;
                }
                if (this.ab <= 0.0d) {
                    this.ab = 720.0d;
                }
            }
            this.mPlayerView.initBufferIngParam(this.f16450S);
            this.mPlayerView.initVFPData(this.f16448Q, this.f16239b.getVideoUrlEncode(), this.aU);
            soundOperate(this.an, -1, (String) null);
        }
        f16431r = false;
    }

    public void progressBarOperate(int i4) {
        ProgressBar progressBar;
        if (!this.f16242e) {
            return;
        }
        if (i4 == 1) {
            ProgressBar progressBar2 = this.f16459w;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
        } else if (i4 == 2 && (progressBar = this.f16459w) != null) {
            progressBar.setVisibility(0);
        }
    }

    public void progressOperate(int i4, int i5) {
        int i6;
        if (this.f16242e) {
            af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i4);
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null) {
                i6 = campaignEx.getVideoLength();
            } else {
                i6 = 0;
            }
            if (i4 > 0 && i4 <= i6 && this.mPlayerView != null) {
                af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i4);
                this.mPlayerView.seekTo(i4 * 1000);
            }
            if (i5 == 1) {
                this.f16455s.setVisibility(8);
            } else if (i5 == 2) {
                this.f16455s.setVisibility(0);
            }
            if (this.f16455s.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null && !this.ae) {
                playerView.release();
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                d.a().a("2000146", this.f16239b, eVar);
            }
            c cVar = this.aU;
            if (cVar != null) {
                cVar.c();
            }
            if (this.f16432A != null) {
                this.f16432A = null;
            }
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void setAdSession(C2206b bVar) {
        this.ao = bVar;
    }

    public void setBufferTimeout(int i4) {
        this.f16450S = i4;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && this.f16439H != null) {
            if (campaignEx.getRewardTemplateMode() == null || this.f16239b.getRewardTemplateMode().f() != 902) {
                int i4 = this.f16443L;
                if (i4 != -5) {
                    if (i4 != -3) {
                        if (this.f16440I == null) {
                            addCTAView();
                        }
                        if (this.f16443L == -1) {
                            if (this.f16439H.getVisibility() != 0) {
                                this.f16439H.setVisibility(0);
                                postDelayed(this.aW, 3000);
                            } else {
                                this.f16439H.setVisibility(8);
                                getHandler().removeCallbacks(this.aW);
                            }
                        }
                        if (this.f16443L >= 0) {
                            this.f16439H.setVisibility(0);
                        }
                    }
                } else if (this.f16442K >= -1) {
                    if (this.f16440I == null) {
                        addCTAView();
                    }
                    int i5 = this.f16442K;
                    if (i5 >= 0) {
                        this.f16439H.setVisibility(0);
                    } else if (i5 != -1) {
                    } else {
                        if (this.f16439H.getVisibility() != 0) {
                            this.f16439H.setVisibility(0);
                            postDelayed(this.aW, 3000);
                            return;
                        }
                        this.f16439H.setVisibility(8);
                        getHandler().removeCallbacks(this.aW);
                    }
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, List<CampaignEx> list, int i4, int i5) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.f16435D = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i4;
        this.f16437F = i5;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.f16239b;
            if (campaignEx2 != null && campaignEx2.getProgressBarShow() == 1 && (mBridgeSegmentsProgressBar = this.f16462z) != null) {
                mBridgeSegmentsProgressBar.init(1, 3);
                this.f16462z.setVisibility(0);
                return;
            }
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.f16462z;
        if (mBridgeSegmentsProgressBar2 != null && this.mCampOrderViewData != null) {
            if (this.mCampaignSize > 1) {
                mBridgeSegmentsProgressBar2.setVisibility(0);
                this.f16462z.init(this.mCampaignSize, 2);
                for (int i6 = 0; i6 < this.mCampOrderViewData.size(); i6++) {
                    int videoPlayProgress = this.mCampOrderViewData.get(i6).getVideoPlayProgress();
                    if (videoPlayProgress > 0) {
                        this.f16462z.setProgress(videoPlayProgress, i6);
                    }
                    if (this.mCampOrderViewData.get(i6).isRewardPopViewShowed) {
                        this.f16445N = true;
                    }
                }
                return;
            }
            CampaignEx campaignEx3 = this.f16239b;
            if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
                this.f16462z.setVisibility(8);
                return;
            }
            MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.f16462z;
            if (mBridgeSegmentsProgressBar3 != null) {
                mBridgeSegmentsProgressBar3.init(1, 3);
                this.f16462z.setVisibility(0);
            }
        }
    }

    public void setCampaign(CampaignEx campaignEx) {
        int i4;
        super.setCampaign(campaignEx);
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(campaignEx);
            c cVar2 = this.aU;
            if (campaignEx == null) {
                i4 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f16454W, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i4 = campaignEx.getReady_rate();
            } else {
                i4 = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f16454W, false).r();
            }
            cVar2.a(i4, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f16454W, false).s());
        }
    }

    public void setCloseAlert(int i4) {
        this.f16451T = i4;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.f16432A = aVar;
    }

    public void setCover(boolean z4) {
        if (this.f16242e) {
            this.mPlayerView.setIsCovered(z4);
        }
    }

    public void setDialogRole(int i4) {
        boolean z4 = true;
        if (i4 != 1) {
            z4 = false;
        }
        this.ax = z4;
        af.b(MBridgeBaseView.TAG, i4 + " " + this.ax);
    }

    public void setIPlayVideoViewLayoutCallBack(f fVar) {
        this.f16436E = fVar;
    }

    public void setIVRewardEnable(int i4, int i5, int i6) {
        this.ar = i4;
        this.as = i5;
        this.at = i6;
    }

    public void setInstDialogState(boolean z4) {
        PlayerView playerView;
        this.aL = z4;
        if (com.mbridge.msdk.e.b.a() && (playerView = this.mPlayerView) != null) {
            playerView.setIsCovered(z4);
        }
    }

    public void setIsIV(boolean z4) {
        this.am = z4;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(z4);
        }
    }

    public void setMiniEndCardState(boolean z4) {
        this.af = z4;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        MBridgeVideoView mBridgeVideoView;
        RelativeLayout relativeLayout;
        try {
            af.b(MBridgeBaseView.TAG, "NOTCH VideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i8 = layoutParams.leftMargin;
            int i9 = layoutParams.rightMargin;
            int i10 = layoutParams.topMargin;
            int i11 = layoutParams.bottomMargin;
            this.aR = i6;
            if (Math.max(Math.max(i8, i9), Math.max(i10, i11)) <= Math.max(Math.max(i4, i5), Math.max(i6, i7)) && (relativeLayout = this.f16457u) != null) {
                mBridgeVideoView = this;
                final int i12 = i4;
                final int i13 = i5;
                final int i14 = i6;
                final int i15 = i7;
                try {
                    relativeLayout.postDelayed(new Runnable() {
                        public final void run() {
                            if (MBridgeVideoView.this.f16457u != null) {
                                MBridgeVideoView.this.f16457u.setVisibility(0);
                                CampaignEx campaignEx = MBridgeVideoView.this.f16239b;
                                if (campaignEx != null && campaignEx.getAdSpaceT() != 2) {
                                    MBridgeVideoView.this.f16457u.setPadding(i12, i14, i13, i15);
                                    MBridgeVideoView.this.f16457u.startAnimation(MBridgeVideoView.this.aD);
                                }
                            }
                        }
                    }, 200);
                } catch (Exception e5) {
                    e = e5;
                    af.b(MBridgeBaseView.TAG, e.getMessage());
                }
            } else {
                mBridgeVideoView = this;
            }
            if (mBridgeVideoView.f16455s.getVisibility() == 0) {
                n();
            }
        } catch (Exception e6) {
            e = e6;
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void setPlayURL(String str) {
        this.f16448Q = str;
    }

    public void setPlayerViewAttachListener(a aVar) {
        this.f16433B = aVar;
    }

    public void setScaleFitXY(int i4) {
        this.al = i4;
    }

    public void setShowingAlertViewCover(boolean z4) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z4 && (mBAcquireRewardPopView = this.aK) != null && this.f16447P && this.f16446O) {
            mBAcquireRewardPopView.onPause();
        }
        this.mPlayerView.setIsCovered(z4);
    }

    public void setShowingTransparent(boolean z4) {
        this.ak = z4;
    }

    public void setSoundState(int i4) {
        this.an = i4;
    }

    public void setUnitId(String str) {
        this.f16454W = str;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setVideoEvents(C2216b bVar) {
        this.ap = bVar;
        c cVar = this.aU;
        if (cVar != null) {
            C2216b unused = cVar.f16502f = bVar;
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f16239b = campaignEx;
            this.f16245h = campaignEx.isDynamicView();
        }
        if (this.f16245h) {
            final com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a((View) this, campaignEx);
            com.mbridge.msdk.video.dynview.b.a().a(a5, new com.mbridge.msdk.video.dynview.e.h() {
                public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                    af.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }

                public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        if (!(this == null || aVar.a() == null)) {
                            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                            this.addView(aVar.a());
                        }
                        if (aVar.b() != null) {
                            for (View onClickListener : aVar.b()) {
                                onClickListener.setOnClickListener(new com.mbridge.msdk.widget.a() {
                                    /* access modifiers changed from: protected */
                                    public final void onNoDoubleClick(View view) {
                                        if (view instanceof TextView) {
                                            MBridgeVideoView.this.f16239b.setTriggerClickSource(1);
                                        } else {
                                            MBridgeVideoView.this.f16239b.setTriggerClickSource(2);
                                        }
                                        if (MBridgeVideoView.this.f16239b.getRewardTemplateMode() == null || MBridgeVideoView.this.f16239b.getRewardTemplateMode().f() != 902) {
                                            MBridgeVideoView.a(MBridgeVideoView.this, "video_play_click");
                                        } else {
                                            MBridgeVideoView.b(MBridgeVideoView.this);
                                        }
                                    }
                                });
                            }
                        }
                        boolean unused = MBridgeVideoView.this.aC = aVar.c();
                        MBridgeVideoView.this.b();
                        boolean unused2 = MBridgeVideoView.f16431r = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        CampaignEx campaignEx = mBridgeVideoView.f16239b;
                        if (campaignEx != null) {
                            campaignEx.setTemplateRenderSucc(mBridgeVideoView.aC);
                        }
                        int unused3 = MBridgeVideoView.this.f16442K = a5.j();
                        int unused4 = MBridgeVideoView.this.f16443L = a5.m();
                    }
                }
            });
            return;
        }
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f16240c.inflate(findLayout, this);
            b();
        }
        f16431r = false;
        CampaignEx campaignEx2 = this.f16239b;
        if (campaignEx2 != null && campaignEx2.getAdSpaceT() == 2 && this.tvFlag != null) {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.tvFlag.setText("AD");
            } else {
                this.tvFlag.setText("广告");
            }
        }
    }

    public void setVideoSkipTime(int i4) {
        this.f16449R = i4;
    }

    public void setVisible(int i4) {
        setVisibility(i4);
    }

    public void showAlertView() {
        CampaignEx campaignEx;
        if (!this.af) {
            if (this.f16453V == null) {
                this.f16453V = new com.mbridge.msdk.widget.dialog.a() {
                    public final void a() {
                        boolean unused = MBridgeVideoView.this.f16446O = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.f16446O);
                        if (MBridgeVideoView.this.am && (MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f13111I || MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f13110H)) {
                            boolean unused2 = MBridgeVideoView.this.av = true;
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                            if (aVar != null) {
                                aVar.a(124, "");
                            }
                            boolean unused3 = MBridgeVideoView.this.aA = true;
                            MBridgeVideoView.this.gonePlayingCloseView();
                        }
                        MBridgeVideoView.this.h();
                        MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f16238a, mBridgeVideoView2.f16239b, mBridgeVideoView2.aq, MBridgeVideoView.this.f16454W, 1, 0, 1);
                    }

                    public final void b() {
                        boolean unused = MBridgeVideoView.this.f16446O = false;
                        boolean unused2 = MBridgeVideoView.this.aw = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.f16446O);
                        MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                        com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f16238a, mBridgeVideoView2.f16239b, mBridgeVideoView2.aq, MBridgeVideoView.this.f16454W, 1, 1, 1);
                        if (MBridgeVideoView.this.am && MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.f13110H) {
                            MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                            if (mBridgeVideoView3.notifyListener != null) {
                                boolean unused3 = mBridgeVideoView3.aS = true;
                                MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                                mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.b(mBridgeVideoView4.ay));
                            }
                        } else if (!MBridgeVideoView.this.am || MBridgeVideoView.this.ar != com.mbridge.msdk.foundation.same.a.f13111I) {
                            MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
                            if (mBridgeVideoView5.notifyListener != null) {
                                boolean unused4 = mBridgeVideoView5.aS = true;
                                MBridgeVideoView.this.notifyListener.a(2, "");
                            }
                        } else {
                            MBridgeVideoView.this.h();
                        }
                    }

                    public final void c() {
                    }
                };
            }
            if (this.f16452U == null) {
                MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.f16453V);
                this.f16452U = mBAlertDialog;
                C2206b bVar = this.ao;
                if (bVar != null) {
                    bVar.a(mBAlertDialog.getWindow().getDecorView(), q1.h.NOT_VISIBLE, (String) null);
                }
            }
            if (this.am) {
                this.f16452U.makeIVAlertView(this.ar, this.f16454W);
            } else {
                this.f16452U.makeRVAlertView(this.f16454W);
            }
            PlayerView playerView = this.mPlayerView;
            if (playerView == null) {
                return;
            }
            if (!playerView.isComplete() || !((campaignEx = this.f16239b) == null || campaignEx.getRewardTemplateMode() == null || this.f16239b.getRewardTemplateMode().f() != 5002010)) {
                this.f16452U.show();
                this.au = true;
                this.f16446O = true;
                setShowingAlertViewCover(true);
                com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f16454W, false);
                String str = com.mbridge.msdk.videocommon.d.c.f16988a;
                this.aq = str;
                com.mbridge.msdk.foundation.same.report.i.a(this.f16238a, this.f16239b, str, this.f16454W, 1, 1);
            }
        }
    }

    public void showBaitClickView() {
        int parseInt;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView() && this.f16239b.getRewardTemplateMode() != null) {
            String e5 = this.f16239b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e5)) {
                try {
                    String a5 = aq.a(e5, "bait_click");
                    if (!TextUtils.isEmpty(a5) && (parseInt = Integer.parseInt(a5)) != 0 && (mBridgeBaitClickView = this.aE) != null) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.aE.init(parseInt);
                        this.aE.startAnimation();
                        this.aE.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                                if (mBridgeVideoView.notifyListener != null) {
                                    mBridgeVideoView.f16239b.setTriggerClickSource(2);
                                    MBridgeVideoView.a(MBridgeVideoView.this, "bait_click_clicked");
                                }
                            }
                        });
                    }
                } catch (Exception e6) {
                    af.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    public void showIVRewardAlertView(String str) {
        this.notifyListener.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && this.f16444M != null && campaignEx.isDynamicView() && this.f16239b.getRewardTemplateMode() != null) {
            String e5 = this.f16239b.getRewardTemplateMode().e();
            if (!TextUtils.isEmpty(e5)) {
                try {
                    String a5 = aq.a(e5, "mof");
                    if (!TextUtils.isEmpty(a5) && Integer.parseInt(a5) == 1) {
                        com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f16239b, this, new com.mbridge.msdk.video.module.a.a.i(this.f16432A), 1);
                    }
                } catch (Exception e6) {
                    af.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
        if (mBAcquireRewardPopView != null && (acquireRewardPopViewParameters = this.aJ) != null) {
            try {
                mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
                this.aK.setVisibility(0);
                setCover(true);
                g();
                this.f16447P = true;
                CampaignEx campaignEx = this.f16239b;
                if (campaignEx != null) {
                    campaignEx.isRewardPopViewShowed = true;
                }
            } catch (Exception e5) {
                af.b(MBridgeBaseView.TAG, e5.getMessage());
            }
        }
    }

    public void showVideoLocation(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        float f4;
        af.c(MBridgeBaseView.TAG, "showVideoLocation marginTop:" + i4 + " marginLeft:" + i5 + " width:" + i6 + "  height:" + i7 + " radius:" + i8 + " borderTop:" + i9 + " borderLeft:" + i10 + " borderWidth:" + i11 + " borderHeight:" + i12);
        if (this.f16242e) {
            this.f16457u.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.f16457u.getVisibility() != 0) {
                this.f16457u.setVisibility(0);
            }
            if (this.f16455s.getVisibility() == 0) {
                n();
            }
            int f5 = ak.f(this.f16238a);
            int e5 = ak.e(this.f16238a);
            if (i6 <= 0 || i7 <= 0 || f5 < i6 || e5 < i7 || this.ac) {
                k();
                return;
            }
            f16427n = i9;
            f16428o = i10;
            f16429p = i11 + 4;
            f16430q = i12 + 4;
            float f6 = ((float) i6) / ((float) i7);
            try {
                f4 = (float) (this.aa / this.ab);
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                f4 = 0.0f;
            }
            if (i8 > 0) {
                f16426m = i8;
                if (i8 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius((float) ak.a(getContext(), (float) i8));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.mPlayerView.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.mPlayerView.setClipToOutline(true);
                }
            }
            if (Math.abs(f6 - f4) <= 0.1f || this.al == 1) {
                k();
                if (this.ak) {
                    setLayoutCenter(i6, i7);
                    if (f16431r) {
                        this.notifyListener.a(114, "");
                    } else {
                        this.notifyListener.a(116, "");
                    }
                } else {
                    setLayoutParam(i5, i4, i6, i7);
                }
            } else {
                k();
                videoOperate(1);
            }
        }
    }

    public void soundOperate(int i4, int i5) {
        soundOperate(i4, i5, "2");
    }

    public void videoOperate(int i4) {
        af.a(MBridgeBaseView.TAG, "VideoView videoOperate:" + i4);
        if (!this.f16242e) {
            return;
        }
        if (i4 == 1) {
            if (getVisibility() == 0 && isfront()) {
                af.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                RelativeLayout relativeLayout = this.aO;
                if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.f16446O || com.mbridge.msdk.foundation.d.b.f12876c) {
                    return;
                }
                if (!com.mbridge.msdk.e.b.a()) {
                    h();
                } else if (!this.af && !this.aL) {
                    h();
                }
            }
        } else if (i4 == 2) {
            if (getVisibility() == 0 && isfront()) {
                af.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                g();
            }
        } else if (i4 == 3) {
            if (!this.ae) {
                this.mPlayerView.stop();
                CampaignEx campaignEx = this.f16239b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f16239b.getRewardTemplateMode().f() != 5002010) {
                    this.mPlayerView.release();
                    this.ae = true;
                    e eVar = new e();
                    eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                    d.a().a("2000146", this.f16239b, eVar);
                }
            }
        } else if (i4 == 5) {
            if (com.mbridge.msdk.e.b.a()) {
                this.aL = true;
                if (!this.ae) {
                    g();
                }
            }
        } else if (i4 == 4) {
            if (com.mbridge.msdk.e.b.a()) {
                this.aL = false;
                if (!this.ae && !isMiniCardShowing()) {
                    h();
                }
            }
        } else if (i4 == 6 && !this.ae) {
            this.mPlayerView.release();
            this.ae = true;
            e eVar2 = new e();
            eVar2.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
            d.a().a("2000146", this.f16239b, eVar2);
        }
    }

    private int p() {
        int i4 = 0;
        try {
            c cVar = this.aU;
            if (cVar != null) {
                i4 = cVar.b();
            }
            return i4 == 0 ? this.f16239b.getVideoLength() : i4;
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    public void soundOperate(int i4, int i5, String str) {
        com.mbridge.msdk.video.module.a.a aVar;
        SoundImageView soundImageView;
        if (this.f16242e) {
            this.an = i4;
            if (i4 == 1) {
                SoundImageView soundImageView2 = this.mSoundImageView;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.mPlayerView.closeSound();
                try {
                    C2216b bVar = this.ap;
                    if (bVar != null) {
                        bVar.o(0.0f);
                        af.a("omsdk", "play video view:  mute");
                    }
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
            } else if (i4 == 2) {
                SoundImageView soundImageView3 = this.mSoundImageView;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.mPlayerView.openSound();
                try {
                    C2216b bVar2 = this.ap;
                    if (bVar2 != null) {
                        bVar2.o(1.0f);
                        af.a("omsdk", "play video view:  unmute");
                    }
                } catch (Exception e6) {
                    af.a("OMSDK", e6.getMessage());
                }
            }
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.mSoundImageView;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i5 == 1) {
                SoundImageView soundImageView5 = this.mSoundImageView;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i5 == 2 && (soundImageView = this.mSoundImageView) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str != null && str.equals("2") && (aVar = this.notifyListener) != null) {
            aVar.a(7, Integer.valueOf(i4));
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        PlayerView playerView;
        boolean f4 = f();
        this.f16242e = f4;
        if (!f4) {
            af.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (ah.a().a("i_l_s_t_r_i", false) && (playerView = this.mPlayerView) != null) {
            playerView.setNotifyListener(new PlayerView.OnPlayerViewVisibleListener() {
                public final void playerViewVisibleCallback() {
                    if (!MBridgeVideoView.this.f16434C) {
                        boolean unused = MBridgeVideoView.this.f16434C = true;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        if (mBridgeVideoView.notifyListener != null && mBridgeVideoView.f16433B != null) {
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            mBridgeVideoView2.notifyListener.a(20, mBridgeVideoView2.f16433B);
                        }
                    }
                }
            });
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aD = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x013c, code lost:
        if (r5 < r0) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x013e, code lost:
        if (r0 == 0) goto L_0x0140;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0157 A[Catch:{ Exception -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f16239b     // Catch:{ Exception -> 0x0031 }
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x0034
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0034
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f16239b     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.f()     // Catch:{ Exception -> 0x0031 }
            r3 = 5002010(0x4c531a, float:7.009309E-39)
            if (r0 != r3) goto L_0x0034
            boolean r0 = r8.aS     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0034
            boolean r0 = r8.ay     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0034
            com.mbridge.msdk.video.module.a.a r3 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r3 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            java.lang.String r0 = r8.b((boolean) r0)     // Catch:{ Exception -> 0x0031 }
            r3.a(r1, r0)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0031:
            r0 = move-exception
            goto L_0x0167
        L_0x0034:
            boolean r0 = r8.am     // Catch:{ Exception -> 0x0031 }
            r3 = 8
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x010f
            int r0 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r5 = com.mbridge.msdk.foundation.same.a.f13110H     // Catch:{ Exception -> 0x0031 }
            if (r0 == r5) goto L_0x0046
            int r5 = com.mbridge.msdk.foundation.same.a.f13111I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r5) goto L_0x010f
        L_0x0046:
            boolean r5 = r8.au     // Catch:{ Exception -> 0x0031 }
            if (r5 == 0) goto L_0x005e
            int r3 = com.mbridge.msdk.foundation.same.a.f13111I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r3) goto L_0x0170
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x005e:
            int r5 = com.mbridge.msdk.foundation.same.a.f13111I     // Catch:{ Exception -> 0x0031 }
            if (r0 != r5) goto L_0x0076
            boolean r0 = r8.aB     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0076
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0076:
            boolean r0 = r8.ax     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            com.mbridge.msdk.playercommon.PlayerView r0 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r0 = r0.getCurPosition()     // Catch:{ Exception -> 0x0031 }
            int r0 = r0 / 1000
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getDuration()     // Catch:{ Exception -> 0x0031 }
            if (r5 != 0) goto L_0x0091
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r8.f16239b     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getVideoLength()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0097
        L_0x0091:
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getDuration()     // Catch:{ Exception -> 0x0031 }
        L_0x0097:
            float r6 = (float) r0     // Catch:{ Exception -> 0x0031 }
            float r5 = (float) r5     // Catch:{ Exception -> 0x0031 }
            float r6 = r6 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r6 = r6 * r5
            int r5 = (int) r6     // Catch:{ Exception -> 0x0031 }
            int r6 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r7 = com.mbridge.msdk.foundation.same.a.f13110H     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00e1
            r8.g()     // Catch:{ Exception -> 0x0031 }
            int r6 = r8.as     // Catch:{ Exception -> 0x0031 }
            int r7 = com.mbridge.msdk.foundation.same.a.f13112J     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00c2
            int r7 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r5 < r7) goto L_0x00c2
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00c2:
            int r7 = com.mbridge.msdk.foundation.same.a.f13113K     // Catch:{ Exception -> 0x0031 }
            if (r6 != r7) goto L_0x00da
            int r6 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r0 < r6) goto L_0x00da
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            boolean r2 = r8.ay     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = r8.b((boolean) r2)     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r2)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00da:
            com.mbridge.msdk.video.module.a.a r1 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r1 == 0) goto L_0x00e1
            r1.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
        L_0x00e1:
            int r1 = r8.ar     // Catch:{ Exception -> 0x0031 }
            int r2 = com.mbridge.msdk.foundation.same.a.f13111I     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x0170
            int r1 = r8.as     // Catch:{ Exception -> 0x0031 }
            int r2 = com.mbridge.msdk.foundation.same.a.f13112J     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x00fc
            int r2 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r5 < r2) goto L_0x00fc
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x00fc:
            int r2 = com.mbridge.msdk.foundation.same.a.f13113K     // Catch:{ Exception -> 0x0031 }
            if (r1 != r2) goto L_0x0170
            int r1 = r8.at     // Catch:{ Exception -> 0x0031 }
            if (r0 < r1) goto L_0x0170
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x010f:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f16239b     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x015d
            int r0 = r0.getAdSpaceT()     // Catch:{ Exception -> 0x0031 }
            if (r0 == r1) goto L_0x015d
            int r0 = r8.o()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.playercommon.PlayerView r5 = r8.mPlayerView     // Catch:{ Exception -> 0x0031 }
            int r5 = r5.getCurPosition()     // Catch:{ Exception -> 0x0031 }
            int r5 = r5 / 1000
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r8.f16239b     // Catch:{ Exception -> 0x0031 }
            int r6 = r6.getDynamicTempCode()     // Catch:{ Exception -> 0x0031 }
            r7 = 5
            if (r6 != r7) goto L_0x013a
            int r6 = r8.mCurrPlayNum     // Catch:{ Exception -> 0x0031 }
            if (r6 <= r2) goto L_0x013a
            if (r0 != 0) goto L_0x0135
            goto L_0x0153
        L_0x0135:
            if (r0 <= 0) goto L_0x0153
            if (r5 >= r0) goto L_0x0153
            goto L_0x0140
        L_0x013a:
            if (r0 <= 0) goto L_0x013e
            if (r5 < r0) goto L_0x0140
        L_0x013e:
            if (r0 != 0) goto L_0x0153
        L_0x0140:
            int r0 = r8.f16451T     // Catch:{ Exception -> 0x0031 }
            if (r0 != r2) goto L_0x0153
            boolean r0 = r8.ak     // Catch:{ Exception -> 0x0031 }
            if (r0 != 0) goto L_0x0153
            r8.g()     // Catch:{ Exception -> 0x0031 }
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r0.a(r3, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0153:
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x015d:
            com.mbridge.msdk.video.module.a.a r0 = r8.notifyListener     // Catch:{ Exception -> 0x0031 }
            if (r0 == 0) goto L_0x0170
            r8.aS = r2     // Catch:{ Exception -> 0x0031 }
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0031 }
            return
        L_0x0167:
            java.lang.String r1 = "MBridgeBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.e():void");
    }

    private boolean f() {
        try {
            this.mPlayerView = (PlayerView) findViewById(filterFindViewId(this.aC, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(filterFindViewId(this.aC, "mbridge_sound_switch"));
            this.f16455s = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_count"));
            View findViewById = findViewById(filterFindViewId(this.aC, "mbridge_rl_playing_close"));
            this.f16456t = findViewById;
            if (findViewById != null) {
                findViewById.setVisibility(4);
            }
            this.f16457u = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_top_control"));
            this.f16458v = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_videoview_bg"));
            this.f16459w = (ProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_video_progress_bar"));
            this.f16460x = (FeedBackButton) findViewById(filterFindViewId(this.aC, "mbridge_native_endcard_feed_btn"));
            this.f16461y = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_iv_link"));
            this.aM = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_scale_webview_layout"));
            this.aO = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_header_layout"));
            if (this.aM != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.aN = collapsibleWebView;
                this.aM.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            ak.a(1, this.f16461y, this.f16239b, this.f16238a, false, new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    MBridgeVideoView.this.h();
                }

                public final void showed() {
                    MBridgeVideoView.this.g();
                }

                public final void summit(String str) {
                    MBridgeVideoView.this.h();
                }
            });
            this.f16462z = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_reward_segment_progressbar"));
            this.f16439H = (FrameLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_cta_layout"));
            this.aE = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aC, "mbridge_animation_click_view"));
            this.f16444M = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_moreoffer_layout"));
            this.aK = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.aC, "mbridge_reward_popview"));
            this.tvFlag = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_flag"));
            return isNotNULL(this.mPlayerView, this.mSoundImageView, this.f16455s, this.f16456t);
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        boolean z4;
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.f16239b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.aX);
                }
                if (com.mbridge.msdk.e.b.a()) {
                    PlayerView playerView2 = this.mPlayerView;
                    if (!this.aL && !this.f16446O) {
                        if (!this.f16447P) {
                            z4 = false;
                            playerView2.setIsCovered(z4);
                        }
                    }
                    z4 = true;
                    playerView2.setIsCovered(z4);
                }
                CampaignEx campaignEx2 = this.f16239b;
                if (campaignEx2 != null && campaignEx2.getNativeVideoTracking() != null && !this.f16239b.isHasReportAdTrackPause()) {
                    this.f16239b.setHasReportAdTrackPause(true);
                    Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                    CampaignEx campaignEx3 = this.f16239b;
                    com.mbridge.msdk.click.a.a(c5, campaignEx3, this.f16454W, campaignEx3.getNativeVideoTracking().m(), false, false);
                }
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        c cVar;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f16239b.getRewardTemplateMode().f() == 5002010 && (relativeLayout = this.aO) != null && relativeLayout.getVisibility() != 0) {
                return;
            }
            if (!this.ad) {
                boolean playVideo = this.mPlayerView.playVideo();
                CampaignEx campaignEx2 = this.f16239b;
                if (!(campaignEx2 == null || campaignEx2.getPlayable_ads_without_video() == 2 || playVideo || (cVar = this.aU) == null)) {
                    cVar.onPlayError("play video failed");
                }
                this.ad = true;
                return;
            }
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null && this.f16447P) {
                mBAcquireRewardPopView.onResume();
            }
            if (this.f16447P) {
                return;
            }
            if (!com.mbridge.msdk.e.b.a()) {
                i();
            } else if (!this.aL && !this.f16446O) {
                this.mPlayerView.setIsCovered(false);
                i();
            }
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage(), e5);
        }
    }

    private void i() {
        if (this.ay) {
            if (!this.az) {
                this.mPlayerView.seekToEndFrame();
            }
            this.az = true;
        } else {
            this.mPlayerView.onResume();
        }
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
            post(this.aX);
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.f16242e && this.f16456t.getVisibility() != 0) {
            if (!this.f16245h || this.f16438G) {
                this.f16456t.setVisibility(0);
            }
            this.ag = true;
        }
    }

    private void k() {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && campaignEx.getAdSpaceT() != 2) {
            l();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0138 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0142 A[Catch:{ all -> 0x00ce }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f16238a
            int r0 = com.mbridge.msdk.foundation.tools.ak.f((android.content.Context) r0)
            float r0 = (float) r0
            android.content.Context r1 = r14.f16238a
            int r1 = com.mbridge.msdk.foundation.tools.ak.e((android.content.Context) r1)
            float r1 = (float) r1
            double r2 = r14.aa
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x016a
            double r6 = r14.ab
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x016a
            r4 = 0
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x016a
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0027
            goto L_0x016a
        L_0x0027:
            double r2 = r2 / r6
            float r4 = r0 / r1
            double r4 = (double) r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "videoWHDivide:"
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = "  screenWHDivide:"
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "MBridgeBaseView"
            com.mbridge.msdk.foundation.tools.af.c(r7, r6)
            java.lang.Double r6 = java.lang.Double.valueOf(r2)
            double r8 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.Double) r6)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            double r4 = com.mbridge.msdk.foundation.tools.ak.a((java.lang.Double) r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r10 = "videoWHDivideFinal:"
            r6.append(r10)
            r6.append(r8)
            java.lang.String r10 = "  screenWHDivideFinal:"
            r6.append(r10)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            com.mbridge.msdk.foundation.tools.af.c(r7, r6)
            com.mbridge.msdk.playercommon.PlayerView r6 = r14.mPlayerView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r6 = (android.widget.FrameLayout.LayoutParams) r6
            r10 = 17
            r11 = -1
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0094
            double r4 = (double) r0
            double r8 = r14.ab
            double r4 = r4 * r8
            double r8 = r14.aa
            double r4 = r4 / r8
            r6.width = r11
            int r4 = (int) r4
            r6.height = r4
            r6.gravity = r10
            goto L_0x00a7
        L_0x0094:
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x00a3
            double r4 = (double) r1
            double r4 = r4 * r2
            int r4 = (int) r4
            r6.width = r4
            r6.height = r11
            r6.gravity = r10
            goto L_0x00a7
        L_0x00a3:
            r6.width = r11
            r6.height = r11
        L_0x00a7:
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r14.f16239b     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x0161
            boolean r4 = r4.isDynamicView()     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x0161
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r14.f16239b     // Catch:{ all -> 0x00ce }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x00d1
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r14.f16239b     // Catch:{ all -> 0x00ce }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r4 = r4.getRewardTemplateMode()     // Catch:{ all -> 0x00ce }
            int r4 = r4.f()     // Catch:{ all -> 0x00ce }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r14.f16239b     // Catch:{ all -> 0x00ce }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r5 = r5.getRewardTemplateMode()     // Catch:{ all -> 0x00ce }
            int r5 = r5.b()     // Catch:{ all -> 0x00ce }
            goto L_0x00df
        L_0x00ce:
            r0 = move-exception
            goto L_0x015a
        L_0x00d1:
            android.content.Context r4 = r14.f16238a     // Catch:{ all -> 0x00ce }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x00ce }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x00ce }
            int r5 = r4.orientation     // Catch:{ all -> 0x00ce }
            r4 = 904(0x388, float:1.267E-42)
        L_0x00df:
            r8 = 102(0x66, float:1.43E-43)
            r9 = 202(0xca, float:2.83E-43)
            if (r4 == r8) goto L_0x00eb
            if (r4 != r9) goto L_0x00e8
            goto L_0x00eb
        L_0x00e8:
            r5 = 202(0xca, float:2.83E-43)
            goto L_0x0108
        L_0x00eb:
            r8 = 1
            if (r5 != r8) goto L_0x00fd
            r6.width = r11     // Catch:{ all -> 0x00ce }
            r6.gravity = r10     // Catch:{ all -> 0x00ce }
            double r1 = r14.ab     // Catch:{ all -> 0x00ce }
            double r12 = r14.aa     // Catch:{ all -> 0x00ce }
            double r9 = (double) r0     // Catch:{ all -> 0x00ce }
            double r12 = r12 / r9
            double r1 = r1 / r12
            int r1 = (int) r1     // Catch:{ all -> 0x00ce }
            r6.height = r1     // Catch:{ all -> 0x00ce }
            goto L_0x00e8
        L_0x00fd:
            r6.height = r11     // Catch:{ all -> 0x00ce }
            r6.gravity = r10     // Catch:{ all -> 0x00ce }
            double r8 = (double) r1     // Catch:{ all -> 0x00ce }
            double r8 = r8 * r2
            int r1 = (int) r8     // Catch:{ all -> 0x00ce }
            r6.width = r1     // Catch:{ all -> 0x00ce }
            goto L_0x00e8
        L_0x0108:
            if (r4 != r5) goto L_0x011f
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f16239b     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x00ce }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ce }
            if (r1 != 0) goto L_0x011f
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r14.f16239b     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x00ce }
            r14.a((java.lang.String) r1)     // Catch:{ all -> 0x00ce }
        L_0x011f:
            r1 = 302(0x12e, float:4.23E-43)
            if (r4 == r1) goto L_0x012c
            r1 = 802(0x322, float:1.124E-42)
            if (r4 == r1) goto L_0x012c
            r1 = 5002010(0x4c531a, float:7.009309E-39)
            if (r4 != r1) goto L_0x0161
        L_0x012c:
            double r1 = r14.aa     // Catch:{ all -> 0x00ce }
            double r3 = r14.ab     // Catch:{ all -> 0x00ce }
            double r8 = r1 / r3
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x0142
            r6.width = r11     // Catch:{ all -> 0x00ce }
            double r8 = (double) r0     // Catch:{ all -> 0x00ce }
            double r3 = r3 * r8
            double r3 = r3 / r1
            int r0 = (int) r3     // Catch:{ all -> 0x00ce }
            r6.height = r0     // Catch:{ all -> 0x00ce }
            goto L_0x0161
        L_0x0142:
            android.content.Context r0 = r14.getContext()     // Catch:{ all -> 0x00ce }
            r1 = 1130102784(0x435c0000, float:220.0)
            int r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (float) r1)     // Catch:{ all -> 0x00ce }
            double r1 = r14.aa     // Catch:{ all -> 0x00ce }
            double r3 = (double) r0     // Catch:{ all -> 0x00ce }
            double r1 = r1 * r3
            double r3 = r14.ab     // Catch:{ all -> 0x00ce }
            double r1 = r1 / r3
            int r1 = (int) r1     // Catch:{ all -> 0x00ce }
            r6.width = r1     // Catch:{ all -> 0x00ce }
            r6.height = r0     // Catch:{ all -> 0x00ce }
            goto L_0x0161
        L_0x015a:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r7, r0)
        L_0x0161:
            com.mbridge.msdk.playercommon.PlayerView r0 = r14.mPlayerView
            r0.setLayoutParams(r6)
            r14.setMatchParent()
            return
        L_0x016a:
            r14.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.l():void");
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (!isLandscape() && this.f16242e) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                int f4 = ak.f(this.f16238a);
                layoutParams.width = -1;
                layoutParams.height = (f4 * 9) / 16;
                layoutParams.gravity = 17;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f16454W);
            com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
            a5.a(this.f16454W + "_" + 1, this.f16239b);
        }
        if (!com.mbridge.msdk.foundation.d.b.a().b()) {
            FeedBackButton feedBackButton = this.f16460x;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        } else if (this.f16460x != null) {
            com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
            a6.a(this.f16454W + "_" + 1, this.f16460x);
        }
    }

    /* access modifiers changed from: private */
    public int o() {
        try {
            int p4 = p();
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null) {
                int videoCompleteTime = campaignEx.getVideoCompleteTime();
                if (this.f16239b.getDynamicTempCode() != 5 && videoCompleteTime > p4) {
                    videoCompleteTime = p4;
                }
                return videoCompleteTime <= 0 ? p4 : videoCompleteTime;
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f16242e) {
            if (!this.f16245h) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        MBridgeVideoView.this.f16239b.setClickTempSource(1);
                        MBridgeVideoView.this.f16239b.setTriggerClickSource(2);
                        d.a().a("m_player_click", MBridgeVideoView.this.f16239b);
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f13136j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                    }
                });
            } else if (com.mbridge.msdk.video.dynview.i.a.a(this.f16239b) == -1 || com.mbridge.msdk.video.dynview.i.a.a(this.f16239b) == 100) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f13136j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                            MBridgeVideoView.this.f16239b.setClickTempSource(1);
                            MBridgeVideoView.this.f16239b.setTriggerClickSource(2);
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                        if (MBridgeVideoView.this.ap != null) {
                            try {
                                MBridgeVideoView.this.ap.a(C2215a.CLICK);
                                af.a("omsdk", "play video view:  click");
                            } catch (Exception e6) {
                                af.b("omsdk", e6.getMessage());
                            }
                        }
                        MBridgeVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.mSoundImageView;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        e eVar = new e();
                        Integer num = 2;
                        PlayerView playerView = MBridgeVideoView.this.mPlayerView;
                        if (playerView != null) {
                            eVar.a("mute_state", Boolean.valueOf(playerView.isSilent()));
                            if (MBridgeVideoView.this.mPlayerView.isSilent()) {
                                num = 1;
                            }
                        }
                        if (num.intValue() == 1) {
                            MBridgeVideoView.this.mMuteSwitch = 2;
                        } else {
                            MBridgeVideoView.this.mMuteSwitch = 1;
                        }
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                        if (aVar != null) {
                            aVar.a(5, num);
                        }
                        d.a().a("m_sound_click", MBridgeVideoView.this.f16239b, eVar);
                    }
                });
            }
            this.f16456t.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        e eVar = new e();
                        eVar.a("type", 1);
                        d.a().a("2000152", eVar);
                        d.a().a("2000148", MBridgeVideoView.this.f16239b, eVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    if (MBridgeVideoView.this.am) {
                        boolean unused = MBridgeVideoView.this.aB = true;
                        CampaignEx campaignEx = MBridgeVideoView.this.f16239b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && MBridgeVideoView.this.f16239b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.ay) {
                            MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                            if (mBridgeVideoView.notifyListener != null) {
                                boolean unused2 = mBridgeVideoView.aS = true;
                                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                                mBridgeVideoView2.notifyListener.a(2, mBridgeVideoView2.b(mBridgeVideoView2.ay));
                            }
                        } else if (!MBridgeVideoView.this.ax) {
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                            if (aVar != null) {
                                aVar.a(123, "");
                            }
                        } else {
                            MBridgeVideoView.this.e();
                        }
                    } else {
                        CampaignEx campaignEx2 = MBridgeVideoView.this.f16239b;
                        if (campaignEx2 == null || campaignEx2.getRewardTemplateMode() == null || MBridgeVideoView.this.f16239b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.ay) {
                            MBridgeVideoView.this.e();
                            return;
                        }
                        MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                        if (mBridgeVideoView3.notifyListener != null) {
                            boolean unused3 = mBridgeVideoView3.aS = true;
                            MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                            mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.b(mBridgeVideoView4.ay));
                        }
                    }
                }
            });
        }
    }

    private String a(int i4, int i5) {
        if (i5 != 0) {
            double d5 = (double) (((float) i4) / ((float) i5));
            try {
                return ak.a(Double.valueOf(d5)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i5 + "";
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, new com.mbridge.msdk.foundation.same.c.c() {
            public final void onFailedLoad(String str, String str2) {
                af.b(MBridgeBaseView.TAG, str);
            }

            public final void onSuccessLoad(final Bitmap bitmap, String str) {
                if (bitmap != null) {
                    try {
                        if (!bitmap.isRecycled() && MBridgeVideoView.this.f16458v != null) {
                            com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() {
                                public final void run() {
                                    try {
                                        final Bitmap a5 = p.a(bitmap, 10);
                                        MBridgeVideoView.this.f16458v.post(new Runnable() {
                                            public final void run() {
                                                MBridgeVideoView.this.f16458v.setVisibility(0);
                                                MBridgeVideoView.this.f16458v.setImageBitmap(a5);
                                            }
                                        });
                                    } catch (Exception e5) {
                                        af.b(MBridgeBaseView.TAG, e5.getMessage());
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String b(boolean z4) {
        if (!this.am) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.au) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f13108F);
            }
            if (this.aw) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f13106D);
            }
            if (this.av) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.f13107E);
            }
            jSONObject.put("complete_info", z4 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            af.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[SYNTHETIC, Splitter:B:28:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeVideoView r8, java.lang.String r9) {
        /*
            com.mbridge.msdk.video.module.a.a r0 = r8.f16432A
            if (r0 == 0) goto L_0x009e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f16239b
            if (r0 == 0) goto L_0x0056
            r1 = 1
            r0.setClickTempSource(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0029
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002b }
            r2.<init>()     // Catch:{ Exception -> 0x002b }
            int r0 = r0.f()     // Catch:{ Exception -> 0x002b }
            r2.append(r0)     // Catch:{ Exception -> 0x002b }
            r2.append(r1)     // Catch:{ Exception -> 0x002b }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x002b }
        L_0x0029:
            r7 = r1
            goto L_0x002e
        L_0x002b:
            r0 = move-exception
            r9 = r0
            goto L_0x0053
        L_0x002e:
            android.content.Context r0 = r8.f16238a     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            java.lang.String r2 = r1.getCampaignUnitId()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            boolean r3 = r1.isBidCampaign()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            java.lang.String r4 = r1.getRequestId()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            java.lang.String r5 = r1.getRequestIdNotice()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f16239b     // Catch:{ Exception -> 0x002b }
            java.lang.String r6 = r1.getId()     // Catch:{ Exception -> 0x002b }
            r1 = r9
            com.mbridge.msdk.foundation.same.report.i.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002b }
            goto L_0x0056
        L_0x0053:
            r9.printStackTrace()
        L_0x0056:
            r9 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006a }
            r1.<init>()     // Catch:{ JSONException -> 0x006a }
            java.lang.String r9 = com.mbridge.msdk.foundation.same.a.f13136j     // Catch:{ JSONException -> 0x0067 }
            r0 = 0
            org.json.JSONObject r0 = r8.a(r0)     // Catch:{ JSONException -> 0x0067 }
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x0067 }
            goto L_0x0070
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            r9 = r0
            goto L_0x006d
        L_0x006a:
            r0 = move-exception
            r1 = r9
            goto L_0x0068
        L_0x006d:
            r9.printStackTrace()
        L_0x0070:
            com.mbridge.msdk.video.module.a.a r9 = r8.f16432A
            r0 = 105(0x69, float:1.47E-43)
            r9.a(r0, r1)
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r9 = r9.c()
            if (r9 == 0) goto L_0x009e
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0093 }
            android.content.Context r9 = r9.c()     // Catch:{ Exception -> 0x0093 }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ Exception -> 0x0093 }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f16239b     // Catch:{ Exception -> 0x0093 }
            com.mbridge.msdk.video.module.b.b.d(r9, r8)     // Catch:{ Exception -> 0x0093 }
            goto L_0x009e
        L_0x0093:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "MBridgeBaseView"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r9, r8)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.a(com.mbridge.msdk.video.module.MBridgeVideoView, java.lang.String):void");
    }

    static /* synthetic */ void b(MBridgeVideoView mBridgeVideoView) {
        CampaignEx campaignEx = mBridgeVideoView.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView() && mBridgeVideoView.f16439H != null) {
            if (mBridgeVideoView.f16440I == null) {
                mBridgeVideoView.addCTAView();
            }
            if (mBridgeVideoView.f16439H.getVisibility() != 0) {
                mBridgeVideoView.f16439H.setVisibility(0);
                mBridgeVideoView.postDelayed(mBridgeVideoView.aW, 3000);
                return;
            }
            mBridgeVideoView.f16439H.setVisibility(8);
            mBridgeVideoView.getHandler().removeCallbacks(mBridgeVideoView.aW);
        }
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
