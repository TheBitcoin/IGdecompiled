package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import org.json.JSONObject;
import q1.C2205a;
import q1.C2206b;
import q1.h;
import r1.C2215a;
import r1.C2216b;

public class MBridgeBTVideoView extends BTBaseView {
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public static boolean f15896K = false;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public static long f15897Q;

    /* renamed from: A  reason: collision with root package name */
    private C2206b f15898A;

    /* renamed from: B  reason: collision with root package name */
    private C2205a f15899B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public C2216b f15900C;

    /* renamed from: D  reason: collision with root package name */
    private a f15901D;
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public int f15902E = 2;

    /* renamed from: F  reason: collision with root package name */
    private int f15903F;

    /* renamed from: G  reason: collision with root package name */
    private boolean f15904G = false;

    /* renamed from: H  reason: collision with root package name */
    private int f15905H = 2;

    /* renamed from: I  reason: collision with root package name */
    private int f15906I = 1;

    /* renamed from: J  reason: collision with root package name */
    private String f15907J;

    /* renamed from: L  reason: collision with root package name */
    private boolean f15908L = false;

    /* renamed from: M  reason: collision with root package name */
    private boolean f15909M = false;

    /* renamed from: N  reason: collision with root package name */
    private boolean f15910N = false;

    /* renamed from: O  reason: collision with root package name */
    private RelativeLayout f15911O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public ProgressBar f15912P;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public PlayerView f15913p;

    /* renamed from: q  reason: collision with root package name */
    private SoundImageView f15914q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public TextView f15915r;

    /* renamed from: s  reason: collision with root package name */
    private View f15916s;

    /* renamed from: t  reason: collision with root package name */
    private FeedBackButton f15917t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f15918u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public WebView f15919v;

    /* renamed from: w  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f15920w;

    /* renamed from: x  reason: collision with root package name */
    private int f15921x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f15922y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f15923z = 0;

    private static final class a extends DefaultVideoPlayerStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private MBridgeBTVideoView f15927a;

        /* renamed from: b  reason: collision with root package name */
        private WebView f15928b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public C2216b f15929c;

        /* renamed from: d  reason: collision with root package name */
        private String f15930d;

        /* renamed from: e  reason: collision with root package name */
        private String f15931e;

        /* renamed from: f  reason: collision with root package name */
        private int f15932f;

        /* renamed from: g  reason: collision with root package name */
        private int f15933g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f15934h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f15935i = false;

        /* renamed from: j  reason: collision with root package name */
        private boolean f15936j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f15937k = false;

        /* renamed from: l  reason: collision with root package name */
        private int f15938l;

        /* renamed from: m  reason: collision with root package name */
        private int f15939m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f15940n = false;

        /* renamed from: o  reason: collision with root package name */
        private boolean f15941o = false;

        public a(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, C2216b bVar) {
            this.f15927a = mBridgeBTVideoView;
            this.f15928b = webView;
            this.f15929c = bVar;
            if (mBridgeBTVideoView != null) {
                this.f15930d = mBridgeBTVideoView.f15767d;
                this.f15931e = mBridgeBTVideoView.f15766c;
            }
        }

        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                if (this.f15929c != null && this.f15941o) {
                    af.b("omsdk", "bt onBufferingEnd");
                    this.f15941o = false;
                    this.f15929c.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final void onBufferingStart(String str) {
            try {
                af.b("omsdk", "bt onBufferingStart1");
                super.onBufferingStart(str);
                if (this.f15929c != null) {
                    af.b("omsdk", "bt onBufferingStart");
                    this.f15929c.c();
                    this.f15941o = true;
                }
                if ((str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) || str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) && this.f15928b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f15762n);
                        jSONObject.put("id", this.f15930d);
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
                        g.a().a(this.f15928b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        d.c().a(this.f15928b, e5.getMessage());
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public final void onPlayCompleted() {
            super.onPlayCompleted();
            MBridgeBTVideoView mBridgeBTVideoView = this.f15927a;
            CampaignEx campaignEx = mBridgeBTVideoView.f15765b;
            if (campaignEx == null) {
                mBridgeBTVideoView.f15915r.setText("0");
            } else if (campaignEx.getVideoCompleteTime() > 0) {
                this.f15927a.f15915r.setText(x.a(c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
            } else {
                this.f15927a.f15915r.setText("0");
            }
            this.f15927a.f15913p.setClickable(false);
            WebView webView = this.f15928b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f15930d);
            }
            C2216b bVar = this.f15929c;
            if (bVar != null) {
                bVar.d();
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f15932f = this.f15933g;
            boolean unused = MBridgeBTVideoView.f15896K = true;
            this.f15927a.stop();
        }

        public final void onPlayError(String str) {
            super.onPlayError(str);
            if (this.f15928b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f15763o);
                    jSONObject.put("id", this.f15930d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject2.put("id", this.f15930d);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    g.a().a(this.f15928b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e5) {
                    d.c().a(this.f15928b, e5.getMessage());
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02c9 A[Catch:{ Exception -> 0x0291 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPlayProgress(int r11, int r12) {
            /*
                r10 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                java.lang.String r1 = "id"
                super.onPlayProgress(r11, r12)
                long r2 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.f15897Q
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L_0x0018
                long r2 = java.lang.System.currentTimeMillis()
                long unused = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.f15897Q = r2
            L_0x0018:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                boolean r3 = r2.f15771h
                r4 = 287(0x11f, float:4.02E-43)
                r5 = 1
                if (r3 == 0) goto L_0x016c
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f15765b
                if (r2 == 0) goto L_0x004d
                int r2 = r2.getVideoCompleteTime()
                com.mbridge.msdk.foundation.d.b r3 = com.mbridge.msdk.foundation.d.b.a()
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f15927a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f15765b
                java.lang.String r7 = r7.getCampaignUnitId()
                r6.append(r7)
                java.lang.String r7 = "_"
                r6.append(r7)
                r6.append(r5)
                java.lang.String r6 = r6.toString()
                r3.b(r6, r11)
                goto L_0x004e
            L_0x004d:
                r2 = 0
            L_0x004e:
                if (r2 > r12) goto L_0x0052
                if (r2 > 0) goto L_0x0053
            L_0x0052:
                r2 = r12
            L_0x0053:
                if (r2 > 0) goto L_0x0058
                int r3 = r12 - r11
                goto L_0x005a
            L_0x0058:
                int r3 = r2 - r11
            L_0x005a:
                java.lang.String r6 = "string"
                if (r3 > 0) goto L_0x0082
                if (r2 > 0) goto L_0x0063
                java.lang.String r3 = "0"
                goto L_0x00bb
            L_0x0063:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f15927a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                java.lang.String r8 = "mbridge_reward_video_view_reward_time_complete"
                int r7 = com.mbridge.msdk.foundation.tools.x.a(r7, r8, r6)
                java.lang.CharSequence r3 = r3.getText(r7)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x00bb
            L_0x0082:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                if (r2 > 0) goto L_0x0096
                r7.<init>()
                r7.append(r3)
                java.lang.String r3 = ""
            L_0x008e:
                r7.append(r3)
                java.lang.String r3 = r7.toString()
                goto L_0x00bb
            L_0x0096:
                r7.<init>()
                r7.append(r3)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f15927a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r8 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r8 = r8.c()
                java.lang.String r9 = "mbridge_reward_video_view_reward_time_left"
                int r8 = com.mbridge.msdk.foundation.tools.x.a(r8, r9, r6)
                java.lang.CharSequence r3 = r3.getText(r8)
                java.lang.String r3 = (java.lang.String) r3
                goto L_0x008e
            L_0x00bb:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f15927a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f15765b
                if (r7 == 0) goto L_0x0163
                int r7 = r7.getUseSkipTime()
                if (r7 != r5) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f15927a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f15765b
                int r7 = r7.getVst()
                int r7 = java.lang.Math.min(r7, r12)
                r8 = 4
                java.lang.String r9 = "mbridge_reward_video_view_reward_time_left_skip_time"
                if (r7 >= r2) goto L_0x011f
                if (r7 < 0) goto L_0x011f
                int r7 = r7 - r11
                if (r7 <= 0) goto L_0x0109
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r7)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r10.f15927a
                android.content.Context r3 = r3.getContext()
                android.content.res.Resources r3 = r3.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r7, r9, r6)
                java.lang.CharSequence r3 = r3.getText(r6)
                java.lang.String r3 = (java.lang.String) r3
                r2.append(r3)
                java.lang.String r3 = r2.toString()
                goto L_0x0163
            L_0x0109:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f15765b
                int r2 = r2.getAdType()
                if (r2 != r4) goto L_0x0163
                if (r7 != 0) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.widget.TextView r2 = r2.f15915r
                r2.setVisibility(r8)
                goto L_0x0163
            L_0x011f:
                int r2 = r2 - r11
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r7 = r10.f15927a
                com.mbridge.msdk.foundation.entity.CampaignEx r7 = r7.f15765b
                int r7 = r7.getAdType()
                if (r7 != r4) goto L_0x0163
                if (r2 <= 0) goto L_0x0158
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.content.Context r2 = r2.getContext()
                android.content.res.Resources r2 = r2.getResources()
                com.mbridge.msdk.foundation.controller.c r7 = com.mbridge.msdk.foundation.controller.c.m()
                android.content.Context r7 = r7.c()
                int r6 = com.mbridge.msdk.foundation.tools.x.a(r7, r9, r6)
                java.lang.CharSequence r2 = r2.getText(r6)
                java.lang.String r2 = (java.lang.String) r2
                r3.append(r2)
                java.lang.String r3 = r3.toString()
                goto L_0x0163
            L_0x0158:
                if (r2 != 0) goto L_0x0163
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.widget.TextView r2 = r2.f15915r
                r2.setVisibility(r8)
            L_0x0163:
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.widget.TextView r2 = r2.f15915r
                r2.setText(r3)
            L_0x016c:
                r10.f15933g = r12
                r10.f15932f = r11
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.widget.ProgressBar r2 = r2.f15912P
                int r3 = r10.f15933g
                r2.setMax(r3)
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r10.f15927a
                android.widget.ProgressBar r2 = r2.f15912P
                int r3 = r10.f15932f
                r2.setProgress(r3)
                android.webkit.WebView r2 = r10.f15928b
                if (r2 == 0) goto L_0x01ec
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x01de }
                r2.<init>()     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = "code"
                int r6 = com.mbridge.msdk.video.bt.module.BTBaseView.f15762n     // Catch:{ Exception -> 0x01de }
                r2.put(r3, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = r10.f15930d     // Catch:{ Exception -> 0x01de }
                r2.put(r1, r3)     // Catch:{ Exception -> 0x01de }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01de }
                r3.<init>()     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = r10.f15930d     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "progress"
                java.lang.String r6 = com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.b(r11, r12)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "time"
                java.lang.String r6 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "duration"
                java.lang.String r6 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x01de }
                r3.put(r1, r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = "data"
                r2.put(r1, r3)     // Catch:{ Exception -> 0x01de }
                com.mbridge.msdk.mbsignalcommon.windvane.g r1 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ Exception -> 0x01de }
                android.webkit.WebView r3 = r10.f15928b     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = "onPlayerProgressChanged"
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01de }
                byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x01de }
                r7 = 2
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r7)     // Catch:{ Exception -> 0x01de }
                r1.a((android.webkit.WebView) r3, (java.lang.String) r6, (java.lang.String) r2)     // Catch:{ Exception -> 0x01de }
                goto L_0x01ec
            L_0x01de:
                r1 = move-exception
                com.mbridge.msdk.video.bt.a.d r2 = com.mbridge.msdk.video.bt.a.d.c()
                android.webkit.WebView r3 = r10.f15928b
                java.lang.String r1 = r1.getMessage()
                r2.a((android.webkit.WebView) r3, (java.lang.String) r1)
            L_0x01ec:
                r1.b r1 = r10.f15929c
                r2 = 100
                if (r1 == 0) goto L_0x023a
                int r3 = r11 * 100
                int r3 = r3 / r12
                int r6 = r11 + 1
                int r6 = r6 * 100
                int r6 = r6 / r12
                r7 = 25
                java.lang.String r8 = "omsdk"
                if (r3 > r7) goto L_0x0211
                if (r7 >= r6) goto L_0x0211
                boolean r7 = r10.f15935i
                if (r7 != 0) goto L_0x0211
                r10.f15935i = r5
                r1.h()
                java.lang.String r1 = "play:  videoEvents.firstQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
                goto L_0x023a
            L_0x0211:
                r7 = 50
                if (r3 > r7) goto L_0x0226
                if (r7 >= r6) goto L_0x0226
                boolean r7 = r10.f15936j
                if (r7 != 0) goto L_0x0226
                r10.f15936j = r5
                r1.i()
                java.lang.String r1 = "play:  videoEvents.midpoint()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
                goto L_0x023a
            L_0x0226:
                r7 = 75
                if (r3 > r7) goto L_0x023a
                if (r7 >= r6) goto L_0x023a
                boolean r3 = r10.f15937k
                if (r3 != 0) goto L_0x023a
                r10.f15937k = r5
                r1.n()
                java.lang.String r1 = "play:  videoEvents.thirdQuartile()"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r8, (java.lang.String) r1)
            L_0x023a:
                int r1 = r10.f15938l     // Catch:{ Exception -> 0x0291 }
                if (r1 == r2) goto L_0x02ef
                boolean r3 = r10.f15940n     // Catch:{ Exception -> 0x0291 }
                if (r3 != 0) goto L_0x02ef
                if (r1 != 0) goto L_0x0246
                goto L_0x02ef
            L_0x0246:
                int r1 = r10.f15939m     // Catch:{ Exception -> 0x0291 }
                if (r1 < 0) goto L_0x02ef
                int r12 = r12 * r1
                int r12 = r12 / r2
                if (r11 < r12) goto L_0x02ef
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r11 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = r11.f15765b     // Catch:{ Exception -> 0x0291 }
                int r11 = r11.getAdType()     // Catch:{ Exception -> 0x0291 }
                r1 = 94
                if (r11 == r1) goto L_0x0293
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r11 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = r11.f15765b     // Catch:{ Exception -> 0x0291 }
                int r11 = r11.getAdType()     // Catch:{ Exception -> 0x0291 }
                if (r11 != r4) goto L_0x0266
                goto L_0x0293
            L_0x0266:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
                r11.<init>()     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getBidToken()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0291 }
                goto L_0x02bd
            L_0x0291:
                r11 = move-exception
                goto L_0x02e8
            L_0x0293:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
                r11.<init>()     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getRequestId()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r10.f15927a     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f15765b     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch:{ Exception -> 0x0291 }
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0291 }
            L_0x02bd:
                com.mbridge.msdk.videocommon.download.b r1 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x0291 }
                java.lang.String r2 = r10.f15931e     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.videocommon.download.a r11 = r1.a((java.lang.String) r2, (java.lang.String) r11)     // Catch:{ Exception -> 0x0291 }
                if (r11 == 0) goto L_0x02ef
                r11.p()     // Catch:{ Exception -> 0x0291 }
                r10.f15940n = r5     // Catch:{ Exception -> 0x0291 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0291 }
                r11.<init>()     // Catch:{ Exception -> 0x0291 }
                java.lang.String r1 = "CDRate is : "
                r11.append(r1)     // Catch:{ Exception -> 0x0291 }
                r11.append(r12)     // Catch:{ Exception -> 0x0291 }
                java.lang.String r12 = " and start download !"
                r11.append(r12)     // Catch:{ Exception -> 0x0291 }
                java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0291 }
                com.mbridge.msdk.foundation.tools.af.b(r0, r11)     // Catch:{ Exception -> 0x0291 }
                goto L_0x02ef
            L_0x02e8:
                java.lang.String r11 = r11.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r11)
            L_0x02ef:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.onPlayProgress(int, int):void");
        }

        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        public final void onPlayStarted(int i4) {
            float f4;
            super.onPlayStarted(i4);
            if (!this.f15934h) {
                this.f15927a.f15912P.setMax(i4);
                WebView webView = this.f15928b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f15930d);
                }
                this.f15934h = true;
                if (this.f15929c != null) {
                    try {
                        MBridgeBTVideoView mBridgeBTVideoView = this.f15927a;
                        if (mBridgeBTVideoView == null || mBridgeBTVideoView.f15913p == null) {
                            f4 = 0.0f;
                        } else {
                            f4 = this.f15927a.f15913p.getVolume();
                        }
                        this.f15929c.m((float) i4, f4);
                        af.a("omsdk", "play2: videoEvents.start()");
                    } catch (Exception e5) {
                        af.b("omsdk", e5.getMessage());
                    }
                }
            }
            boolean unused = MBridgeBTVideoView.f15896K = false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a7 A[Catch:{ Exception -> 0x006f }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r3, int r4) {
            /*
                r2 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                r2.f15938l = r3
                r2.f15939m = r4
                com.mbridge.msdk.foundation.tools.ah r3 = com.mbridge.msdk.foundation.tools.ah.a()
                java.lang.String r4 = "h_c_r_w_p_c"
                r1 = 0
                boolean r3 = r3.a((java.lang.String) r4, (boolean) r1)
                if (r3 != 0) goto L_0x0015
                goto L_0x00c2
            L_0x0015:
                int r3 = r2.f15938l
                r4 = 100
                if (r3 == r4) goto L_0x00c2
                int r4 = r2.f15939m
                if (r4 != 0) goto L_0x00c2
                boolean r4 = r2.f15940n
                if (r4 != 0) goto L_0x00c2
                if (r3 == 0) goto L_0x00c2
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.f15927a
                if (r3 == 0) goto L_0x00c2
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.f15765b
                if (r3 != 0) goto L_0x002f
                goto L_0x00c2
            L_0x002f:
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x006f }
                r4 = 94
                if (r3 == r4) goto L_0x0071
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r3 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.f15765b     // Catch:{ Exception -> 0x006f }
                int r3 = r3.getAdType()     // Catch:{ Exception -> 0x006f }
                r4 = 287(0x11f, float:4.02E-43)
                if (r3 != r4) goto L_0x0044
                goto L_0x0071
            L_0x0044:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getBidToken()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
                goto L_0x009b
            L_0x006f:
                r3 = move-exception
                goto L_0x00b7
            L_0x0071:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
                r3.<init>()     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getRequestId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r4 = r2.f15927a     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.f15765b     // Catch:{ Exception -> 0x006f }
                java.lang.String r4 = r4.getVideoUrlEncode()     // Catch:{ Exception -> 0x006f }
                r3.append(r4)     // Catch:{ Exception -> 0x006f }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
            L_0x009b:
                com.mbridge.msdk.videocommon.download.b r4 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch:{ Exception -> 0x006f }
                java.lang.String r1 = r2.f15931e     // Catch:{ Exception -> 0x006f }
                com.mbridge.msdk.videocommon.download.a r3 = r4.a((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x006f }
                if (r3 == 0) goto L_0x00c2
                r3.p()     // Catch:{ Exception -> 0x006f }
                r3 = 1
                r2.f15940n = r3     // Catch:{ Exception -> 0x006f }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x006f }
                if (r3 == 0) goto L_0x00c2
                java.lang.String r3 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)     // Catch:{ Exception -> 0x006f }
                return
            L_0x00b7:
                boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r4 == 0) goto L_0x00c2
                java.lang.String r3 = r3.getMessage()
                com.mbridge.msdk.foundation.tools.af.b(r0, r3)
            L_0x00c2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.a.a(int, int):void");
        }
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
    }

    public C2205a getAdEvents() {
        return this.f15899B;
    }

    public C2206b getAdSession() {
        return this.f15898A;
    }

    public int getMute() {
        return this.f15902E;
    }

    public C2216b getVideoEvents() {
        return this.f15900C;
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (findLayout > 0) {
            this.f15769f.inflate(findLayout, this);
            boolean c5 = c();
            this.f15771h = c5;
            if (!c5) {
                af.b(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            a();
        }
        f15896K = false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        View rootView;
        int i4;
        int i5;
        super.onAttachedToWindow();
        if (!this.f15910N) {
            this.f15905H = d.c().e(this.f15766c);
        }
        View view = this.f15916s;
        int i6 = 0;
        if (view != null) {
            if (this.f15922y == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            view.setVisibility(i5);
        }
        SoundImageView soundImageView = this.f15914q;
        if (soundImageView != null) {
            if (this.f15923z == 0) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            soundImageView.setVisibility(i4);
        }
        CampaignEx campaignEx = this.f15765b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f15766c);
            b a5 = b.a();
            a5.a(this.f15766c + "_" + 1, this.f15765b);
        }
        TextView textView = this.f15915r;
        if (textView != null) {
            if (this.f15921x == 0) {
                i6 = 8;
            }
            textView.setVisibility(i6);
            if (this.f15915r.getVisibility() == 0 && b.a().b()) {
                b a6 = b.a();
                a6.a(this.f15766c + "_" + 1, this.f15917t);
            }
        }
        if (this.f15898A != null && (rootView = getRootView()) != null) {
            this.f15898A.f(rootView);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestory() {
        try {
            if (this.f15913p != null) {
                C2206b bVar = this.f15898A;
                if (bVar != null) {
                    bVar.c();
                }
                this.f15913p.setOnClickListener((View.OnClickListener) null);
                this.f15913p.release();
                this.f15913p = null;
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - f15897Q));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000146", this.f15765b, eVar);
            }
            SoundImageView soundImageView = this.f15914q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener((View.OnClickListener) null);
            }
            View view = this.f15916s;
            if (view != null) {
                view.setOnClickListener((View.OnClickListener) null);
            }
            if (this.f15919v != null) {
                this.f15919v = null;
            }
            if (this.f15898A != null) {
                this.f15898A = null;
            }
            if (this.f15900C != null) {
                this.f15900C = null;
            }
            setOnClickListener((View.OnClickListener) null);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.f15909M = isPlayIng;
            this.f15913p.setIsBTVideoPlaying(isPlayIng);
            C2216b bVar = this.f15900C;
            if (bVar != null) {
                this.f15913p.setVideoEvents(bVar);
            }
            this.f15913p.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f15913p.setIsCovered(false);
            if (this.f15909M) {
                this.f15913p.start(true);
            }
            this.f15913p.resumeOMSDK();
        }
    }

    public void onStop() {
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.f15913p;
            if (playerView != null) {
                playerView.pause();
                WebView webView = this.f15919v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPause", this.f15767d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    public void play() {
        a aVar;
        try {
            if (!this.f15910N) {
                String d5 = d();
                this.f15907J = d5;
                this.f15913p.initVFPData(d5, this.f15765b.getVideoUrlEncode(), this.f15901D);
                if (this.f15905H == 1) {
                    playMute();
                } else {
                    playUnMute();
                }
                try {
                    if (this.f15899B != null) {
                        af.b("omsdk", "bt impressionOccurred");
                        this.f15899B.b();
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                if (!this.f15913p.playVideo() && (aVar = this.f15901D) != null) {
                    aVar.onPlayError("play video failed");
                }
                this.f15910N = true;
                return;
            }
            if (this.f15904G) {
                this.f15913p.playVideo(0);
                this.f15904G = false;
            } else {
                this.f15913p.start(false);
            }
            try {
                C2216b bVar = this.f15900C;
                if (bVar != null) {
                    bVar.k();
                    af.a("omsdk", "btv play2:  videoEvents.resume()");
                }
            } catch (Throwable th2) {
                af.a(BTBaseView.TAG, th2.getMessage());
            }
            WebView webView = this.f15919v;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerPlay", this.f15767d);
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.f15913p;
            if (!(playerView == null || this.f15919v == null)) {
                playerView.closeSound();
                this.f15914q.setSoundStatus(false);
                this.f15902E = 1;
                try {
                    C2216b bVar = this.f15900C;
                    if (bVar != null) {
                        bVar.o(0.0f);
                    }
                } catch (Exception e5) {
                    af.a("OMSDK", e5.getMessage());
                }
                BTBaseView.a(this.f15919v, "onPlayerMute", this.f15767d);
                return true;
            }
        } catch (Exception e6) {
            af.b(BTBaseView.TAG, e6.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.f15913p;
            if (playerView == null || this.f15919v == null) {
                return false;
            }
            playerView.openSound();
            this.f15914q.setSoundStatus(true);
            this.f15902E = 2;
            try {
                C2216b bVar = this.f15900C;
                if (bVar != null) {
                    bVar.o(1.0f);
                }
            } catch (Exception e5) {
                af.a("OMSDK", e5.getMessage());
            }
            BTBaseView.a(this.f15919v, "onUnmute", this.f15767d);
            return true;
        } catch (Exception e6) {
            af.b(BTBaseView.TAG, e6.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        String str;
        int i4;
        if (this.f15765b.getAdType() == 94 || this.f15765b.getAdType() == 287) {
            str = this.f15765b.getRequestId() + this.f15765b.getId() + this.f15765b.getVideoUrlEncode();
        } else {
            str = this.f15765b.getId() + this.f15765b.getVideoUrlEncode() + this.f15765b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f15766c, str);
        if (a5 != null) {
            this.f15920w = a5;
        }
        this.f15903F = e();
        String d5 = d();
        this.f15907J = d5;
        if (this.f15771h && !TextUtils.isEmpty(d5) && this.f15765b != null) {
            C2206b bVar = this.f15898A;
            if (bVar != null) {
                bVar.d(this.f15913p);
                C2206b bVar2 = this.f15898A;
                SoundImageView soundImageView = this.f15914q;
                h hVar = h.OTHER;
                bVar2.a(soundImageView, hVar, (String) null);
                this.f15898A.a(this.f15915r, hVar, (String) null);
                this.f15898A.a(this.f15916s, h.VIDEO_CONTROLS, (String) null);
            }
            a aVar = new a(this, this.f15919v, this.f15900C);
            this.f15901D = aVar;
            CampaignEx campaignEx = this.f15765b;
            if (campaignEx == null) {
                i4 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f15766c, false).r();
            } else if (campaignEx.getReady_rate() != -1) {
                i4 = campaignEx.getReady_rate();
            } else {
                i4 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f15766c, false).r();
            }
            aVar.a(i4, com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f15766c, false).s());
            this.f15913p.setDesk(false);
            this.f15913p.initBufferIngParam(this.f15903F);
            soundOperate(this.f15902E, -1, (String) null);
        }
        f15896K = false;
    }

    public void resume() {
        try {
            PlayerView playerView = this.f15913p;
            if (playerView != null) {
                if (this.f15904G) {
                    playerView.playVideo(0);
                    this.f15904G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    C2216b bVar = this.f15900C;
                    if (bVar != null) {
                        bVar.k();
                        af.a("omsdk", "btv play3:  videoEvents.resume()");
                    }
                } catch (Throwable th) {
                    af.a(BTBaseView.TAG, th.getMessage());
                }
                WebView webView = this.f15919v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerResume", this.f15767d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage());
        }
    }

    public void setAdEvents(C2205a aVar) {
        this.f15899B = aVar;
    }

    public void setAdSession(C2206b bVar) {
        this.f15898A = bVar;
    }

    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.f15915r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_shape_progress", "drawable"));
            this.f15915r.setWidth(ak.a(c.m().c(), 30.0f));
            return;
        }
        this.f15915r.setBackgroundResource(x.a(c.m().c(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ak.a(c.m().c(), 30.0f));
        int a5 = ak.a(c.m().c(), 5.0f);
        layoutParams.setMargins(a5, 0, 0, 0);
        this.f15915r.setPadding(a5, 0, a5, 0);
        this.f15915r.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i4) {
        int i5;
        View view = this.f15916s;
        if (i4 == 0) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        view.setVisibility(i5);
    }

    public void setCountDownTextViewVisable(int i4) {
        int i5;
        TextView textView = this.f15915r;
        if (i4 == 0) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        textView.setVisibility(i5);
    }

    public void setCreateWebView(WebView webView) {
        this.f15919v = webView;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        if (i4 <= 0) {
            i4 = this.f15911O.getPaddingLeft();
        }
        if (i5 <= 0) {
            i5 = this.f15911O.getPaddingRight();
        }
        if (i6 <= 0) {
            i6 = this.f15911O.getPaddingTop();
        }
        if (i7 <= 0) {
            i7 = this.f15911O.getPaddingBottom();
        }
        af.b(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}));
        this.f15911O.setPadding(i4, i6, i5, i7);
    }

    public void setOrientation(int i4) {
        this.f15906I = i4;
    }

    public void setPlaybackParams(float f4) {
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            playerView.setPlaybackParams(f4);
        }
    }

    public void setProgressBarState(int i4) {
        int i5;
        ProgressBar progressBar = this.f15912P;
        if (progressBar != null) {
            if (i4 == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            progressBar.setVisibility(i5);
            CampaignEx campaignEx = this.f15765b;
            if (campaignEx != null && campaignEx.getProgressBarShow() == 1) {
                this.f15912P.setVisibility(0);
            }
        }
    }

    public void setShowClose(int i4) {
        this.f15922y = i4;
    }

    public void setShowMute(int i4) {
        this.f15923z = i4;
    }

    public void setShowTime(int i4) {
        this.f15921x = i4;
    }

    public void setSoundImageViewVisble(int i4) {
        int i5;
        SoundImageView soundImageView = this.f15914q;
        if (i4 == 0) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        soundImageView.setVisibility(i5);
    }

    public void setVideoEvents(C2216b bVar) {
        this.f15900C = bVar;
        a aVar = this.f15901D;
        if (aVar != null) {
            C2216b unused = aVar.f15929c = bVar;
        }
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVolume(float f4, float f5) {
        PlayerView playerView = this.f15913p;
        if (playerView != null) {
            playerView.setVolume(f4, f5);
        }
    }

    public void soundOperate(int i4, int i5, String str) {
        if (this.f15771h) {
            this.f15902E = i4;
            if (i4 == 1) {
                this.f15914q.setSoundStatus(false);
                this.f15913p.closeSound();
            } else if (i4 == 2) {
                this.f15914q.setSoundStatus(true);
                this.f15913p.openSound();
            }
            if (i5 == 1) {
                this.f15914q.setVisibility(8);
            } else if (i5 == 2) {
                this.f15914q.setVisibility(0);
            }
            C2216b bVar = this.f15900C;
            if (bVar != null) {
                try {
                    bVar.o(this.f15913p.getVolume());
                } catch (Exception e5) {
                    af.b("omsdk", e5.getMessage());
                }
            }
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.f15913p;
            if (playerView != null) {
                playerView.pause();
                this.f15913p.stop();
                this.f15904G = true;
                WebView webView = this.f15919v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerStop", this.f15767d);
                }
            }
        } catch (Exception e5) {
            af.b(BTBaseView.TAG, e5.getMessage(), e5);
        }
    }

    private boolean c() {
        try {
            this.f15913p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.f15914q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.f15915r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.f15916s = findViewById(findID("mbridge_rl_playing_close"));
            this.f15911O = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.f15912P = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.f15913p.setIsBTVideo(true);
            this.f15917t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.f15918u = (ImageView) findViewById(findID("mbridge_iv_link"));
            return isNotNULL(this.f15913p, this.f15914q, this.f15915r, this.f15916s);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private String d() {
        try {
            String videoUrlEncode = this.f15765b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.f15920w;
            if (aVar != null) {
                String h4 = aVar.h();
                return (ap.a(h4) || !new File(h4).exists()) ? videoUrlEncode : h4;
            }
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return "";
        }
    }

    private int e() {
        int i4 = 5;
        try {
            com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
            if (b5 == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (b5 != null) {
                i4 = (int) b5.h();
            }
            af.c(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + i4);
            return i4;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    /* access modifiers changed from: private */
    public static String b(int i4, int i5) {
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

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        if (this.f15771h) {
            this.f15914q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean isSilent = MBridgeBTVideoView.this.f15913p.isSilent();
                    if (MBridgeBTVideoView.this.f15919v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f15762n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f15767d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.f15902E);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f15919v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            af.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + MBridgeBTVideoView.this.f15902E);
                        } catch (Exception e5) {
                            d.c().a(MBridgeBTVideoView.this.f15919v, e5.getMessage());
                        }
                    }
                }
            });
            this.f15916s.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.f15919v != null) {
                        BTBaseView.a(MBridgeBTVideoView.this.f15919v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.f15767d);
                    }
                }
            });
            setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTVideoView.this.f15900C != null) {
                        try {
                            MBridgeBTVideoView.this.f15900C.a(C2215a.CLICK);
                            af.a("omsdk", "btv adUserInteraction click");
                        } catch (Exception e5) {
                            af.b("omsdk", e5.getMessage());
                        }
                    }
                    if (MBridgeBTVideoView.this.f15919v != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", BTBaseView.f15762n);
                            jSONObject.put("id", MBridgeBTVideoView.this.f15767d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("x", String.valueOf(view.getX()));
                            jSONObject2.put("y", String.valueOf(view.getY()));
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            g.a().a(MBridgeBTVideoView.this.f15919v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception unused) {
                            d.c().a(MBridgeBTVideoView.this.f15919v, "onClicked", MBridgeBTVideoView.this.f15767d);
                        }
                    }
                }
            });
        }
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
