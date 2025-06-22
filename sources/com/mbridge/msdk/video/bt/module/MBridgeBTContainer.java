package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.a.a;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.C2205a;
import q1.C2206b;
import r1.C2215a;
import r1.C2216b;

public class MBridgeBTContainer extends AbstractJSContainer implements c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f15827a = "MBridgeBTContainer";
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public boolean f15828A = true;

    /* renamed from: B  reason: collision with root package name */
    private String f15829B;

    /* renamed from: C  reason: collision with root package name */
    private boolean f15830C = false;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public List<CampaignEx> f15831D;

    /* renamed from: E  reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f15832E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public com.mbridge.msdk.video.bt.module.a.a f15833F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public h f15834G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public h f15835H;

    /* renamed from: I  reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.b f15836I;

    /* renamed from: J  reason: collision with root package name */
    private String f15837J;

    /* renamed from: K  reason: collision with root package name */
    private String f15838K;

    /* renamed from: L  reason: collision with root package name */
    private String f15839L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public boolean f15840M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public int f15841N;

    /* renamed from: O  reason: collision with root package name */
    private String f15842O;

    /* renamed from: P  reason: collision with root package name */
    private d f15843P;

    /* renamed from: Q  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.d.c f15844Q;

    /* renamed from: R  reason: collision with root package name */
    private C2206b f15845R = null;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public C2216b f15846S = null;

    /* renamed from: T  reason: collision with root package name */
    private C2205a f15847T = null;

    /* renamed from: b  reason: collision with root package name */
    private int f15848b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f15849c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f15850d;

    /* renamed from: e  reason: collision with root package name */
    private MBridgeBTLayout f15851e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WindVaneWebView f15852f;

    /* renamed from: g  reason: collision with root package name */
    private LayoutInflater f15853g;

    /* renamed from: h  reason: collision with root package name */
    private Context f15854h;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public TextView f15855x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ImageView f15856y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f15857z = false;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private List<CampaignEx> f15862a;

        /* renamed from: b  reason: collision with root package name */
        private Context f15863b;

        /* renamed from: c  reason: collision with root package name */
        private String f15864c;

        /* renamed from: d  reason: collision with root package name */
        private String f15865d;

        public a(List<CampaignEx> list, Context context, String str, String str2) {
            this.f15862a = list;
            this.f15863b = context;
            this.f15864c = str;
            this.f15865d = str2;
        }

        public final void run() {
            List<CampaignEx> list = this.f15862a;
            if (list != null && list.size() > 0) {
                try {
                    e.a((f) g.a(this.f15863b)).a(this.f15864c, this.f15862a);
                    com.mbridge.msdk.videocommon.a.a.a().c(this.f15865d, this.f15862a.get(0).getAdType());
                } catch (Exception unused) {
                    af.a(MBridgeBTContainer.f15827a, "remove campaign failed");
                }
            }
        }
    }

    private class b extends a.C0207a {
        private b() {
        }

        public final void a() {
            super.a();
        }

        public final void b() {
            super.b();
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            aj.a(campaign, MBridgeBTContainer.this.f15850d);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String optString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && optString.equals(BuildConfig.VERSION_NAME) && MBridgeBTContainer.this.f16906i != null) {
                        if (MBridgeBTContainer.this.f15828A) {
                            MBridgeBTContainer.this.onAdClose();
                        } else {
                            MBridgeBTContainer.this.f16906i.finish();
                        }
                    }
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            aj.a(campaign, MBridgeBTContainer.this.f15850d);
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            aj.b(campaign, MBridgeBTContainer.this.f15850d);
        }

        public final void a(boolean z4) {
            super.a(z4);
            if (MBridgeBTContainer.this.f15846S != null) {
                try {
                    MBridgeBTContainer.this.f15846S.a(C2215a.CLICK);
                    af.a("omsdk", "btc adUserInteraction click");
                } catch (Exception e5) {
                    af.a("omsdk", e5.getMessage());
                }
            }
            MBridgeBTContainer.this.f15835H.a(z4, MBridgeBTContainer.this.f16908k, MBridgeBTContainer.this.f16907j);
        }

        public final void a(int i4, String str) {
            super.a(i4, str);
        }
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        init(context);
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            int a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 48.0f);
            int a6 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a5, a5);
            layoutParams.setMargins(a6, a6, a6, a6);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeBTContainer.this.onAdClose();
                }
            });
            addView(imageView);
        } catch (Throwable th) {
            af.b(f15827a, th.getMessage());
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                int optInt = jSONObject.optInt(TtmlNode.LEFT, -999);
                int optInt2 = jSONObject.optInt("top", -999);
                int optInt3 = jSONObject.optInt(TtmlNode.RIGHT, -999);
                int optInt4 = jSONObject.optInt("bottom", -999);
                if (!(optInt == -999 || c5 == null)) {
                    layoutParams.leftMargin = ak.a(c5, (float) optInt);
                }
                if (!(optInt2 == -999 || c5 == null)) {
                    layoutParams.topMargin = ak.a(c5, (float) optInt2);
                }
                if (!(optInt3 == -999 || c5 == null)) {
                    layoutParams.rightMargin = ak.a(c5, (float) optInt3);
                }
                if (!(optInt4 == -999 || c5 == null)) {
                    layoutParams.bottomMargin = ak.a(c5, (float) optInt4);
                }
                int optInt5 = jSONObject.optInt("width");
                int optInt6 = jSONObject.optInt("height");
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.f16906i);
            mBTempContainer.setMute(this.f16913p);
            mBTempContainer.setBidCampaign(this.f15857z);
            mBTempContainer.setIV(this.f16914q);
            mBTempContainer.setBigOffer(this.f15828A);
            mBTempContainer.setIVRewardEnable(this.f16916s, this.f16917t, this.f16918u);
            mBTempContainer.setShowRewardListener(this.f15835H);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.f15854h);
            mBTempContainer.onCreate();
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f15852f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", this.f15848b);
                jSONObject2.put("id", this.f15829B);
                jSONObject2.put("eventName", str);
                jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, jSONObject);
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f15852f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.a.d.c().a((WebView) this.f15852f, "broadcast", this.f15829B);
            }
        }
    }

    public void click(int i4, String str) {
    }

    public int findID(String str) {
        return x.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public C2205a getAdEvents() {
        return this.f15847T;
    }

    public C2206b getAdSession() {
        return this.f15845R;
    }

    public List<CampaignEx> getCampaigns() {
        return this.f15831D;
    }

    public C2216b getVideoEvents() {
        return this.f15846S;
    }

    public void handlerH5Exception(int i4, String str) {
    }

    public void init(Context context) {
        this.f15854h = context;
        this.f15853g = LayoutInflater.from(context);
    }

    public void onAdClose() {
        Activity activity = this.f16906i;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
            if (b5 != null && b5.size() > 0) {
                for (View next : b5.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onBackPressed();
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onBackPressed();
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onBackPressed();
                    }
                }
            }
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
            if (b5 != null && b5.size() > 0) {
                for (View next : b5.values()) {
                    if (next instanceof MBTempContainer) {
                        ((MBTempContainer) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTWebView) {
                        ((MBridgeBTWebView) next).onConfigurationChanged(configuration);
                    } else if (next instanceof MBridgeBTLayout) {
                        ((MBridgeBTLayout) next).onConfigurationChanged(configuration);
                    }
                }
            }
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:41|(2:42|43)|49|50|51|52|53) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x01be */
    /* JADX WARNING: Missing exception handler attribute for start block: B:92:0x038d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(boolean r11) {
        /*
            r10 = this;
            java.lang.String r0 = "omsdk"
            java.lang.String r1 = ""
            java.lang.String r2 = "_"
            java.lang.String r3 = "mbridge_bt_container"
            int r3 = r10.findLayout(r3)     // Catch:{ all -> 0x0014 }
            if (r3 >= 0) goto L_0x0017
            java.lang.String r11 = "mbridge_bt_container layout null"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            return
        L_0x0014:
            r11 = move-exception
            goto L_0x03fc
        L_0x0017:
            android.view.LayoutInflater r4 = r10.f15853g     // Catch:{ all -> 0x0014 }
            android.view.View r3 = r4.inflate(r3, r10)     // Catch:{ all -> 0x0014 }
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3     // Catch:{ all -> 0x0014 }
            r10.f15850d = r3     // Catch:{ all -> 0x0014 }
            if (r3 != 0) goto L_0x0029
            java.lang.String r11 = "ViewIds null"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            return
        L_0x0029:
            r10.f15838K = r1     // Catch:{ all -> 0x0014 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r10.f15831D     // Catch:{ all -> 0x0014 }
            r4 = 0
            if (r3 == 0) goto L_0x004f
            int r3 = r3.size()     // Catch:{ all -> 0x0014 }
            if (r3 <= 0) goto L_0x004f
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r10.f15831D     // Catch:{ all -> 0x0014 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3     // Catch:{ all -> 0x0014 }
            java.lang.String r5 = r3.getCMPTEntryUrl()     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = r3.getRequestId()     // Catch:{ all -> 0x0014 }
            r10.f15838K = r6     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r3.getCurrentLocalRid()     // Catch:{ all -> 0x0014 }
            r10.f15839L = r3     // Catch:{ all -> 0x0014 }
            goto L_0x0050
        L_0x004f:
            r5 = r1
        L_0x0050:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r3.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r3.append(r6)     // Catch:{ all -> 0x0014 }
            r3.append(r2)     // Catch:{ all -> 0x0014 }
            java.lang.String r6 = r10.f15838K     // Catch:{ all -> 0x0014 }
            r3.append(r6)     // Catch:{ all -> 0x0014 }
            r3.append(r2)     // Catch:{ all -> 0x0014 }
            r3.append(r5)     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.videocommon.a$a r3 = com.mbridge.msdk.videocommon.a.a(r3)     // Catch:{ all -> 0x0014 }
            r6 = 0
            if (r3 == 0) goto L_0x0099
            java.lang.String r7 = r3.b()     // Catch:{ all -> 0x0014 }
            r10.f15829B = r7     // Catch:{ all -> 0x0014 }
            java.lang.String r7 = f15827a     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r8.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r9 = "get BT wraper.getTag = "
            r8.append(r9)     // Catch:{ all -> 0x0014 }
            java.lang.String r9 = r10.f15829B     // Catch:{ all -> 0x0014 }
            r8.append(r9)     // Catch:{ all -> 0x0014 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ all -> 0x0014 }
            r3.a((java.lang.String) r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r3.a()     // Catch:{ all -> 0x0014 }
            goto L_0x009a
        L_0x0099:
            r3 = r6
        L_0x009a:
            r10.f15852f = r3     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r3.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r7 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r3.append(r7)     // Catch:{ all -> 0x0014 }
            r3.append(r2)     // Catch:{ all -> 0x0014 }
            java.lang.String r7 = r10.f15838K     // Catch:{ all -> 0x0014 }
            r3.append(r7)     // Catch:{ all -> 0x0014 }
            r3.append(r2)     // Catch:{ all -> 0x0014 }
            r3.append(r5)     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.videocommon.a.b(r3)     // Catch:{ all -> 0x0014 }
            q1.b r3 = r10.f15845R     // Catch:{ all -> 0x0014 }
            r5 = 1
            if (r3 == 0) goto L_0x00f4
            r3.d(r10)     // Catch:{ Exception -> 0x00ec }
            q1.b r3 = r10.f15845R     // Catch:{ Exception -> 0x00ec }
            r3.g()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = "btc:  adSession.start();"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x00ec }
            q1.a r3 = r10.f15847T     // Catch:{ Exception -> 0x00ec }
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = "btc:   adEvents.loaded"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x00ec }
            r1.c r3 = r1.C2217c.STANDALONE     // Catch:{ Exception -> 0x00ec }
            r1.d r3 = r1.C2218d.b(r5, r3)     // Catch:{ Exception -> 0x00ec }
            q1.a r7 = r10.f15847T     // Catch:{ Exception -> 0x00ec }
            r7.d(r3)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = "btc:   adEvents.impressionOccurred"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x00ec }
            q1.a r3 = r10.f15847T     // Catch:{ Exception -> 0x00ec }
            r3.b()     // Catch:{ Exception -> 0x00ec }
            goto L_0x00f4
        L_0x00ec:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0014 }
        L_0x00f4:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r10.f15852f     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x03b2
            com.mbridge.msdk.video.signal.factory.b r11 = new com.mbridge.msdk.video.signal.factory.b     // Catch:{ all -> 0x0014 }
            android.app.Activity r3 = r10.f16906i     // Catch:{ all -> 0x0014 }
            r11.<init>(r3, r10, r0)     // Catch:{ all -> 0x0014 }
            r10.registerJsFactory(r11)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r10.f15852f     // Catch:{ all -> 0x0014 }
            r0.setApiManagerJSFactory(r11)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r10.f15852f     // Catch:{ all -> 0x0014 }
            android.view.ViewParent r0 = r0.getParent()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0116
            java.lang.String r11 = "preload template webview is null or load error"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x0116:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r10.f15852f     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r0.getObject()     // Catch:{ all -> 0x0014 }
            boolean r0 = r0 instanceof com.mbridge.msdk.video.signal.a.k     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x01e3
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = r10.f15852f     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r0.getObject()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.signal.a.k r0 = (com.mbridge.msdk.video.signal.a.k) r0     // Catch:{ all -> 0x0014 }
            r11.a((com.mbridge.msdk.video.signal.a.k) r0)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r11 = r10.f15852f     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x01d8
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x0014 }
            r11.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f13138l     // Catch:{ all -> 0x0014 }
            android.content.Context r3 = r10.getContext()     // Catch:{ all -> 0x0014 }
            float r3 = com.mbridge.msdk.foundation.tools.ak.d((android.content.Context) r3)     // Catch:{ all -> 0x0014 }
            double r7 = (double) r3     // Catch:{ all -> 0x0014 }
            r11.put(r0, r7)     // Catch:{ all -> 0x0014 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r0.<init>()     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r3 = "name"
            com.mbridge.msdk.videocommon.b.c r7 = r10.f16911n     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r7 = r7.a()     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r0.put(r3, r7)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r3 = "amount"
            com.mbridge.msdk.videocommon.b.c r7 = r10.f16911n     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            int r7 = r7.b()     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r0.put(r3, r7)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r3 = "id"
            java.lang.String r7 = r10.f16912o     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r0.put(r3, r7)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r3 = "userId"
            java.lang.String r7 = r10.f16910m     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r11.put(r3, r7)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r3 = "reward"
            r11.put(r3, r0)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r0 = "playVideoMute"
            int r3 = r10.f16913p     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r11.put(r0, r3)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            java.lang.String r0 = "extra"
            java.lang.String r3 = r10.f15842O     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            r11.put(r0, r3)     // Catch:{ JSONException -> 0x0181, Exception -> 0x017f }
            goto L_0x0196
        L_0x017f:
            r0 = move-exception
            goto L_0x0183
        L_0x0181:
            r0 = move-exception
            goto L_0x018d
        L_0x0183:
            java.lang.String r3 = f15827a     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0014 }
            goto L_0x0196
        L_0x018d:
            java.lang.String r3 = f15827a     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ all -> 0x0014 }
        L_0x0196:
            com.mbridge.msdk.video.bt.module.b.c r0 = new com.mbridge.msdk.video.bt.module.b.c     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.a.b r3 = r10.c()     // Catch:{ all -> 0x0014 }
            r0.<init>(r3, r1)     // Catch:{ all -> 0x0014 }
            r10.f15835H = r0     // Catch:{ all -> 0x0014 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x01be }
            r0.<init>()     // Catch:{ Exception -> 0x01be }
            java.lang.String r1 = "type"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01be }
            r0.a(r1, r3)     // Catch:{ Exception -> 0x01be }
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x01be }
            java.lang.String r3 = "2000133"
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r7 = r10.f15831D     // Catch:{ Exception -> 0x01be }
            r1.a((java.lang.String) r3, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x01be }
        L_0x01be:
            com.mbridge.msdk.video.signal.g r0 = r10.getJSNotifyProxy()     // Catch:{ all -> 0x0014 }
            r0.a((java.lang.Object) r11)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.signal.d r11 = r10.getJSCommon()     // Catch:{ all -> 0x0014 }
            r11.b((boolean) r5)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.signal.d r11 = r10.getJSCommon()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$b r0 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$b     // Catch:{ all -> 0x0014 }
            r0.<init>()     // Catch:{ all -> 0x0014 }
            r11.a((com.mbridge.msdk.video.signal.a.C0206a) r0)     // Catch:{ all -> 0x0014 }
        L_0x01d8:
            com.mbridge.msdk.video.signal.d r11 = r10.getJSCommon()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.signal.a.d r11 = (com.mbridge.msdk.video.signal.a.d) r11     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.signal.a$a r11 = r11.f16588m     // Catch:{ all -> 0x0014 }
            r11.a()     // Catch:{ all -> 0x0014 }
        L_0x01e3:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r11 = r10.f15852f     // Catch:{ all -> 0x0014 }
            r11.setBackgroundColor(r4)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.a.d r11 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f16907j     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f15838K     // Catch:{ all -> 0x0014 }
            java.util.LinkedHashMap r11 = r11.b((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x03ac
            java.lang.String r0 = r10.f15829B     // Catch:{ all -> 0x0014 }
            boolean r0 = r11.containsKey(r0)     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x03ac
            java.lang.String r0 = r10.f15829B     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r11.get(r0)     // Catch:{ all -> 0x0014 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x0014 }
            boolean r1 = r0 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0332
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r0 = (com.mbridge.msdk.video.bt.module.MBridgeBTLayout) r0     // Catch:{ all -> 0x0014 }
            r10.f15851e = r0     // Catch:{ all -> 0x0014 }
            android.webkit.WebView r0 = r0.getBtWebView()     // Catch:{ Exception -> 0x022d }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r0 = (com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r0     // Catch:{ Exception -> 0x022d }
            java.lang.Object r1 = r0.getObject()     // Catch:{ Exception -> 0x022d }
            com.mbridge.msdk.video.signal.a.k r1 = (com.mbridge.msdk.video.signal.a.k) r1     // Catch:{ Exception -> 0x022d }
            q1.a r3 = r10.f15847T     // Catch:{ Exception -> 0x022d }
            r1.a((q1.C2205a) r3)     // Catch:{ Exception -> 0x022d }
            r1.b r3 = r10.f15846S     // Catch:{ Exception -> 0x022d }
            r1.a((r1.C2216b) r3)     // Catch:{ Exception -> 0x022d }
            q1.b r3 = r10.f15845R     // Catch:{ Exception -> 0x022d }
            r1.a((q1.C2206b) r3)     // Catch:{ Exception -> 0x022d }
            r0.setObject(r1)     // Catch:{ Exception -> 0x022d }
            goto L_0x0237
        L_0x022d:
            r0 = move-exception
            java.lang.String r1 = f15827a     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)     // Catch:{ all -> 0x0014 }
        L_0x0237:
            com.mbridge.msdk.foundation.d.b r0 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r1.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r1.append(r3)     // Catch:{ all -> 0x0014 }
            r1.append(r2)     // Catch:{ all -> 0x0014 }
            r1.append(r5)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1 r3 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$1     // Catch:{ all -> 0x0014 }
            r3.<init>()     // Catch:{ all -> 0x0014 }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.foundation.d.a) r3)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r0 = r10.f15851e     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r10.f15852f     // Catch:{ all -> 0x0014 }
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x0014 }
            r7 = -1
            r3.<init>(r7, r7)     // Catch:{ all -> 0x0014 }
            r0.addView(r1, r4, r3)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.d.b r0 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r1.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r1.append(r3)     // Catch:{ all -> 0x0014 }
            r1.append(r2)     // Catch:{ all -> 0x0014 }
            r3 = 2
            r1.append(r3)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0014 }
            r0.c(r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.d.b r0 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r1.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r1.append(r3)     // Catch:{ all -> 0x0014 }
            r1.append(r2)     // Catch:{ all -> 0x0014 }
            r1.append(r5)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.widget.FeedBackButton r0 = r0.b(r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.d.b r1 = com.mbridge.msdk.foundation.d.b.a()     // Catch:{ all -> 0x0014 }
            boolean r1 = r1.b()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x02f0
            if (r0 == 0) goto L_0x02f0
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()     // Catch:{ Exception -> 0x02b0 }
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1     // Catch:{ Exception -> 0x02b0 }
            r6 = r1
            goto L_0x02b4
        L_0x02b0:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0014 }
        L_0x02b4:
            if (r6 != 0) goto L_0x02bf
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0014 }
            int r1 = com.mbridge.msdk.foundation.d.b.f12875b     // Catch:{ all -> 0x0014 }
            int r3 = com.mbridge.msdk.foundation.d.b.f12874a     // Catch:{ all -> 0x0014 }
            r6.<init>(r1, r3)     // Catch:{ all -> 0x0014 }
        L_0x02bf:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0014 }
            android.content.Context r1 = r1.c()     // Catch:{ all -> 0x0014 }
            r3 = 1092616192(0x41200000, float:10.0)
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r3)     // Catch:{ all -> 0x0014 }
            r6.topMargin = r1     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0014 }
            android.content.Context r1 = r1.c()     // Catch:{ all -> 0x0014 }
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r3)     // Catch:{ all -> 0x0014 }
            r6.leftMargin = r1     // Catch:{ all -> 0x0014 }
            r0.setLayoutParams(r6)     // Catch:{ all -> 0x0014 }
            android.view.ViewParent r1 = r0.getParent()     // Catch:{ all -> 0x0014 }
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x02eb
            r1.removeView(r0)     // Catch:{ all -> 0x0014 }
        L_0x02eb:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r1 = r10.f15851e     // Catch:{ all -> 0x0014 }
            r1.addView(r0)     // Catch:{ all -> 0x0014 }
        L_0x02f0:
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r0 = r10.f15851e     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f15829B     // Catch:{ all -> 0x0014 }
            r0.setTag(r1)     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f15829B     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r1 = r10.f15851e     // Catch:{ all -> 0x0014 }
            r11.put(r0, r1)     // Catch:{ all -> 0x0014 }
            java.util.Collection r0 = r11.values()     // Catch:{ all -> 0x0014 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0014 }
        L_0x0306:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x0328
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0014 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0014 }
            boolean r3 = r1 instanceof com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x0306
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r1 = (com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout) r1     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r1.getInstanceId()     // Catch:{ all -> 0x0014 }
            r10.f15837J = r0     // Catch:{ all -> 0x0014 }
            android.widget.FrameLayout r0 = r10.f15850d     // Catch:{ all -> 0x0014 }
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams     // Catch:{ all -> 0x0014 }
            r3.<init>(r7, r7)     // Catch:{ all -> 0x0014 }
            r0.addView(r1, r3)     // Catch:{ all -> 0x0014 }
        L_0x0328:
            java.lang.String r0 = r10.f15837J     // Catch:{ all -> 0x0014 }
            r11.remove(r0)     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f15837J     // Catch:{ all -> 0x0014 }
            r11.put(r0, r10)     // Catch:{ all -> 0x0014 }
        L_0x0332:
            com.mbridge.msdk.video.bt.a.d r11 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f16907j     // Catch:{ all -> 0x0014 }
            int r1 = r10.f16913p     // Catch:{ all -> 0x0014 }
            r11.a((java.lang.String) r0, (int) r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.a.d r11 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f15829B     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f15838K     // Catch:{ all -> 0x0014 }
            r11.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.a.d r11 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r10.f15837J     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f15838K     // Catch:{ all -> 0x0014 }
            r11.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.a.d r11 = com.mbridge.msdk.video.bt.a.d.c()     // Catch:{ all -> 0x0014 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
            r0.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f16907j     // Catch:{ all -> 0x0014 }
            r0.append(r1)     // Catch:{ all -> 0x0014 }
            r0.append(r2)     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = r10.f15838K     // Catch:{ all -> 0x0014 }
            r0.append(r1)     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0014 }
            android.app.Activity r1 = r10.f16906i     // Catch:{ all -> 0x0014 }
            r11.a((java.lang.String) r0, (android.app.Activity) r1)     // Catch:{ all -> 0x0014 }
            android.content.Context r11 = r10.getContext()     // Catch:{ all -> 0x038d }
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x038d }
            java.util.concurrent.ThreadPoolExecutor r0 = com.mbridge.msdk.foundation.same.f.a.b()     // Catch:{ all -> 0x038d }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a r1 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$a     // Catch:{ all -> 0x038d }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r10.f15831D     // Catch:{ all -> 0x038d }
            java.lang.String r3 = r10.f16907j     // Catch:{ all -> 0x038d }
            java.lang.String r5 = r10.f16908k     // Catch:{ all -> 0x038d }
            r1.<init>(r2, r11, r3, r5)     // Catch:{ all -> 0x038d }
            r0.execute(r1)     // Catch:{ all -> 0x038d }
            goto L_0x0394
        L_0x038d:
            java.lang.String r11 = f15827a     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = "remove campaign failed"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ all -> 0x0014 }
        L_0x0394:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r11 = r10.f15831D     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x0410
            int r11 = r11.size()     // Catch:{ all -> 0x0014 }
            if (r11 <= 0) goto L_0x0410
            com.mbridge.msdk.videocommon.d.c r11 = r10.f16909l     // Catch:{ all -> 0x0014 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r10.f15831D     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0014 }
            r10.a((com.mbridge.msdk.videocommon.d.c) r11, (com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x03ac:
            java.lang.String r11 = "big template webviewLayout is null"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x03b2:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r10.f15831D     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x03f6
            int r0 = r0.size()     // Catch:{ all -> 0x0014 }
            if (r0 <= 0) goto L_0x03f6
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r10.f15831D     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x03f6
            if (r11 != 0) goto L_0x03ce
            boolean r11 = r0.isDynamicView()     // Catch:{ all -> 0x0014 }
            if (r11 == 0) goto L_0x03f6
        L_0x03ce:
            android.content.Context r11 = r10.f15854h     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.dynview.e.d r0 = r10.f15843P     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x03da
            java.lang.String r11 = "ChoiceOneCallback is null"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x03da:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0014 }
            r0.<init>()     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = "choice_one_callback"
            com.mbridge.msdk.video.dynview.e.d r2 = r10.f15843P     // Catch:{ all -> 0x0014 }
            r0.put(r1, r2)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.dynview.b.a()     // Catch:{ all -> 0x0014 }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r10.f15831D     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2 r2 = new com.mbridge.msdk.video.bt.module.MBridgeBTContainer$2     // Catch:{ all -> 0x0014 }
            r2.<init>()     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.video.dynview.h.a r3 = new com.mbridge.msdk.video.dynview.h.a     // Catch:{ all -> 0x0014 }
            r3.<init>(r11, r1, r2, r0)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x03f6:
            java.lang.String r11 = "big template webview is null"
            r10.a((java.lang.String) r11)     // Catch:{ all -> 0x0014 }
            goto L_0x0410
        L_0x03fc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onCreate exception "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.a((java.lang.String) r11)
        L_0x0410:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.onCreate(boolean):void");
    }

    public void onDestroy() {
        if (!this.f15830C) {
            this.f15830C = true;
            if (this.f15845R != null) {
                af.b("omsdk", "btc onDestroy");
                this.f15845R.c();
            }
            super.onDestroy();
            com.mbridge.msdk.video.bt.a.d c5 = com.mbridge.msdk.video.bt.a.d.c();
            c5.d(this.f16907j + "_" + this.f15838K);
            try {
                WindVaneWebView windVaneWebView = this.f15852f;
                if (windVaneWebView != null) {
                    ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    this.f15852f.clearWebView();
                    this.f15852f.release();
                }
                if (this.f15836I != null) {
                    this.f15836I = null;
                }
                if (this.f15833F != null) {
                    this.f15833F = null;
                }
                if (this.f15854h != null) {
                    this.f15854h = null;
                }
                List<CampaignEx> list = this.f15831D;
                if (list != null && list.size() > 0) {
                    for (CampaignEx next : this.f15831D) {
                        if (!(next == null || next.getRewardTemplateMode() == null)) {
                            com.mbridge.msdk.videocommon.a.b(this.f16907j + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    }
                    com.mbridge.msdk.video.dynview.b.a.a().b();
                }
                com.mbridge.msdk.video.bt.a.d.c().f(this.f15829B);
                com.mbridge.msdk.video.bt.a.d.c().g(this.f16907j);
                com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K).remove(this.f15829B);
                com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K).remove(this.f15837J);
                com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K).clear();
            } catch (Throwable th) {
                af.a(f15827a, th.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onPause() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onPause();
        List<CampaignEx> list = this.f15831D;
        if (!(list == null || list.size() <= 0 || (campaignEx = this.f15831D.get(0)) == null || !campaignEx.isDynamicView() || (aVar = com.mbridge.msdk.video.dynview.b.a.a().f15985a) == null)) {
            aVar.b();
        }
        try {
            LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
            if (b5 != null && b5.size() > 0) {
                for (View next : b5.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onPause();
                    }
                }
            }
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
        }
    }

    public void onResume() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onResume();
        List<CampaignEx> list = this.f15831D;
        if (!(list == null || list.size() <= 0 || (campaignEx = this.f15831D.get(0)) == null || !campaignEx.isDynamicView() || (aVar = com.mbridge.msdk.video.dynview.b.a.a().f15985a) == null)) {
            aVar.a();
        }
        if (!com.mbridge.msdk.foundation.d.b.f12876c) {
            try {
                LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
                if (b5 != null && b5.size() > 0) {
                    for (View next : b5.values()) {
                        if (next instanceof MBridgeBTVideoView) {
                            ((MBridgeBTVideoView) next).onResume();
                        }
                    }
                }
            } catch (Throwable th) {
                af.a(f15827a, th.getMessage());
            }
        }
    }

    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.f15831D;
        if (list != null && list.size() > 0 && (campaignEx = this.f15831D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a.a().b();
        }
        try {
            LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
            if (b5 != null && b5.size() > 0) {
                for (View next : b5.values()) {
                    if (next instanceof MBridgeBTVideoView) {
                        ((MBridgeBTVideoView) next).onStop();
                    }
                }
            }
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
        }
    }

    public void reactDeveloper(Object obj, String str) {
        int i4;
        if (this.f15833F == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, getUnitId());
            String optString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
            CampaignEx campaignEx = this.f15831D.get(0);
            boolean z4 = true;
            if (optInt == 1 && optJSONObject != null) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (optBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            JSONObject jSONObject2 = null;
            switch (optInt) {
                case 1:
                    this.f15833F.a();
                    this.f15833F.a(2, optString2, optString);
                    break;
                case 2:
                    if (optJSONObject != null) {
                        jSONObject2 = optJSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                    }
                    String str2 = "";
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE);
                    }
                    this.f15833F.a(str2);
                    this.f15833F.a(4, optString2, optString);
                    break;
                case 3:
                    this.f15833F.a(optString2, optString);
                    this.f15833F.a(5, optString2, optString);
                    break;
                case 4:
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000147", this.f15831D, eVar);
                    } catch (Throwable th) {
                        af.b(f15827a, th.getMessage());
                    }
                    this.f15833F.b(optString2, optString);
                    this.f15833F.a(6, optString2, optString);
                    break;
                case 5:
                    this.f15833F.a(jSONObject.optBoolean("isAutoClick"), optString2, optString);
                    break;
                case 6:
                    if (optJSONObject != null) {
                        if (optJSONObject.optInt("convert") != 1) {
                            z4 = false;
                        }
                        jSONObject2 = optJSONObject.optJSONObject("reward");
                        String optString3 = optJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(optString3)) {
                            this.f15842O = optString3;
                        }
                    } else {
                        z4 = false;
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject.optJSONObject("campaign"));
                    com.mbridge.msdk.videocommon.b.c a5 = com.mbridge.msdk.videocommon.b.c.a(jSONObject2);
                    if (a5 == null) {
                        a5 = this.f16911n;
                    }
                    this.f15833F.a(7, optString2, optString);
                    try {
                        com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar2.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000152", parseCampaignWithBackData, eVar2);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                    if (this.f16914q && ((i4 = this.f16916s) == com.mbridge.msdk.foundation.same.a.f13110H || i4 == com.mbridge.msdk.foundation.same.a.f13111I)) {
                        this.f15833F.a(this.f15840M, this.f15841N);
                    }
                    if (!z4) {
                        a5.a(0);
                        af.a("omsdk", "bt videoEvents :" + this.f15846S);
                        C2216b bVar = this.f15846S;
                        if (bVar != null) {
                            try {
                                bVar.l();
                            } catch (Exception e6) {
                                af.a("omsdk", e6.getMessage());
                            }
                        }
                    }
                    this.f15833F.a(z4, a5);
                    af.a(f15827a, "sendToServerRewardInfo");
                    if (!this.f16914q && z4) {
                        if (parseCampaignWithBackData != null) {
                            com.mbridge.msdk.video.module.b.b.a(parseCampaignWithBackData, a5, optString, this.f16910m, this.f15842O);
                        } else {
                            com.mbridge.msdk.video.module.b.b.a(campaignEx, a5, optString, this.f16910m, this.f15842O);
                        }
                    }
                    com.mbridge.msdk.foundation.same.report.d.d.a().a("2000134", parseCampaignWithBackData);
                    break;
            }
            a(obj);
        } catch (JSONException e7) {
            a(obj, e7.getMessage());
            af.a(f15827a, e7.getMessage());
        }
    }

    public void reportUrls(Object obj, String str) {
        boolean z4;
        boolean z5;
        String str2 = str;
        String str3 = f15827a;
        af.a(str3, "reportUrls:" + str2);
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    String a5 = ak.a(optString, "&tun=", ab.q() + "");
                    int optInt2 = jSONObject.optInt("report");
                    CampaignEx campaignEx = null;
                    if (optInt2 == 0) {
                        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                        List<CampaignEx> list = this.f15831D;
                        if (list != null) {
                            campaignEx = list.get(0);
                        }
                        CampaignEx campaignEx2 = campaignEx;
                        if (optInt != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        com.mbridge.msdk.click.a.a(c5, campaignEx2, "", a5, false, z5);
                    } else {
                        Context c6 = com.mbridge.msdk.foundation.controller.c.m().c();
                        List<CampaignEx> list2 = this.f15831D;
                        if (list2 != null) {
                            campaignEx = list2.get(0);
                        }
                        CampaignEx campaignEx3 = campaignEx;
                        if (optInt != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        com.mbridge.msdk.click.a.a(c6, campaignEx3, "", a5, false, z4, optInt2);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString("".getBytes(), 2));
            } catch (Throwable th) {
                af.b(f15827a, "reportUrls", th);
            }
        }
    }

    public void setAdEvents(C2205a aVar) {
        this.f15847T = aVar;
    }

    public void setAdSession(C2206b bVar) {
        this.f15845R = bVar;
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.f15833F = aVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        if (campaignEx.getSpareOfferFlag() == 1) {
            com.mbridge.msdk.videocommon.d.c cVar = this.f16909l;
            if (cVar == null) {
                return;
            }
            if (cVar.y() == 1) {
                campaignEx.setCbt(1);
            } else {
                campaignEx.setCbt(0);
            }
        } else {
            campaignEx.setCbt(0);
        }
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.f15832E = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023 A[Catch:{ Exception -> 0x001a }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[Catch:{ Exception -> 0x001a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCampaigns(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4) {
        /*
            r3 = this;
            r3.f15831D = r4
            java.lang.String r0 = ""
            if (r4 == 0) goto L_0x001c
            int r1 = r4.size()     // Catch:{ Exception -> 0x001a }
            if (r1 <= 0) goto L_0x001c
            r1 = 0
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x001a }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x001a }
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.getCurrentLocalRid()     // Catch:{ Exception -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r4 = move-exception
            goto L_0x0043
        L_0x001c:
            r1 = r0
        L_0x001d:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x001a }
            if (r2 != 0) goto L_0x002d
            com.mbridge.msdk.foundation.same.report.d.d r2 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x001a }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r2.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x001a }
            r3.f15844Q = r0     // Catch:{ Exception -> 0x001a }
        L_0x002d:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.f15844Q     // Catch:{ Exception -> 0x001a }
            if (r0 != 0) goto L_0x0038
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x001a }
            r0.<init>()     // Catch:{ Exception -> 0x001a }
            r3.f15844Q = r0     // Catch:{ Exception -> 0x001a }
        L_0x0038:
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.f15844Q     // Catch:{ Exception -> 0x001a }
            r0.c((java.lang.String) r1)     // Catch:{ Exception -> 0x001a }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r3.f15844Q     // Catch:{ Exception -> 0x001a }
            r0.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)     // Catch:{ Exception -> 0x001a }
            return
        L_0x0043:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x004a
            r4.printStackTrace()
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.setCampaigns(java.util.List):void");
    }

    public void setChoiceOneCallback(d dVar) {
        this.f15843P = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.f15842O = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f16920w = bVar;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7, int i8) {
        String a5;
        TextView textView;
        int i9 = i8;
        try {
            a5 = s.a(i4, i5, i6, i7, i8);
            af.b(f15827a, a5);
            WindVaneWebView windVaneWebView = this.f15852f;
            if (windVaneWebView != null) {
                if ((windVaneWebView.getObject() instanceof k) && !TextUtils.isEmpty(a5)) {
                    ((k) this.f15852f.getObject()).b(a5);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f15852f, "oncutoutfetched", Base64.encodeToString(a5.getBytes(), 0));
                }
            }
            List<CampaignEx> list = this.f15831D;
            if (list != null && list.size() > 0) {
                if (this.f15831D.get(0).isDynamicView() && (textView = this.f15855x) != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                    if (layoutParams != null) {
                        if (i5 > 0) {
                            layoutParams.leftMargin = i5;
                        }
                        if (i6 > 0) {
                            layoutParams.rightMargin = i6;
                        }
                        if (i7 > 0) {
                            layoutParams.topMargin = i7;
                        }
                        if (i9 > 0) {
                            layoutParams.bottomMargin = i9;
                        }
                        this.f15855x.setLayoutParams(layoutParams);
                        if (this.f15856y != null) {
                            try {
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f15856y.getLayoutParams());
                                layoutParams2.leftMargin = layoutParams.rightMargin;
                                layoutParams2.topMargin = layoutParams.topMargin;
                                this.f15856y.setLayoutParams(layoutParams2);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception e6) {
            af.b(f15827a, e6.getMessage());
        } catch (Throwable th) {
            af.a(f15827a, th.getMessage());
            return;
        }
        com.mbridge.msdk.video.bt.a.d.c().a(i4, i5, i6, i7, i9);
        LinkedHashMap<String, View> b5 = com.mbridge.msdk.video.bt.a.d.c().b(this.f16907j, this.f15838K);
        if (b5 != null && b5.size() > 0) {
            for (View next : b5.values()) {
                if (next instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) next).setNotchPadding(i5, i6, i7, i9);
                }
                if (next instanceof MBTempContainer) {
                    ((MBTempContainer) next).setNotchPadding(i4, i5, i6, i7, i9);
                }
                if ((next instanceof WindVaneWebView) && !TextUtils.isEmpty(a5)) {
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((Object) next, "oncutoutfetched", Base64.encodeToString(a5.getBytes(), 0));
                }
                i9 = i8;
            }
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.f15834G = hVar;
    }

    public void setVideoEvents(C2216b bVar) {
        this.f15846S = bVar;
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.f15836I == null) {
            this.f15836I = new com.mbridge.msdk.video.bt.module.a.b() {
                public final void a(String str) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.f16908k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.f16907j);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void b(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void c(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, boolean z4, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(RewardPlus.NAME, cVar.a());
                                jSONObject3.put(RewardPlus.AMOUNT, cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z4);
                            jSONObject2.put("convert", z4 ? 1 : 2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(boolean z4, int i4) {
                    boolean unused = MBridgeBTContainer.this.f15840M = z4;
                    int unused2 = MBridgeBTContainer.this.f15841N = i4;
                }

                public final void a(String str, String str2) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, MBridgeBTContainer.this.f16908k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTContainer.this.f16907j);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f15852f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            String a5 = MBridgeBTContainer.f15827a;
                            af.a(a5, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(MBridgeBTContainer.f15827a, e5.getMessage());
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) MBridgeBTContainer.this.f15852f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                public final void a(String str, int i4, String str2, String str3) {
                    if (MBridgeBTContainer.this.f15834G != null) {
                        MBridgeBTContainer.this.f15834G.a(i4, str2, str3);
                    }
                }
            };
        }
        return this.f15836I;
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.f15832E;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a next : list) {
            if (next.l().getId().equals(campaignEx.getId())) {
                af.a(f15827a, "tempContainer task initSuccess");
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        h hVar = this.f15834G;
        if (hVar != null) {
            hVar.a(this.f15844Q, str);
        }
        super.a(str);
    }

    /* access modifiers changed from: protected */
    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a5 : pv_urls) {
                        CampaignEx campaignEx2 = campaignEx;
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2, this.f16907j, a5, false, true);
                        campaignEx = campaignEx2;
                    }
                }
            } catch (Throwable th) {
                af.b(f15827a, th.getMessage());
            }
        }
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> a5 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (a5 != null && a5.size() > 0 && a5.get(0) != null) {
                    int c5 = a5.get(0).c();
                    String b5 = a5.get(0).b();
                    if (c5 == 1) {
                        hashMap.put("encrypt_p=", "encrypt_p=" + b5);
                        hashMap.put("irlfa=", "irlfa=" + 1);
                        for (Map.Entry entry : hashMap.entrySet()) {
                            campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                        }
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
