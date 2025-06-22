package com.mbridge.msdk.video.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeNativeEndCardView extends MBridgeNativeEndCardViewDiff {

    /* renamed from: A  reason: collision with root package name */
    private LinearLayout f16354A;

    /* renamed from: B  reason: collision with root package name */
    private Runnable f16355B;

    /* renamed from: C  reason: collision with root package name */
    private Runnable f16356C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public RelativeLayout f16357D;

    /* renamed from: E  reason: collision with root package name */
    private b f16358E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public boolean f16359F = false;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public boolean f16360G = false;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public boolean f16361H = false;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f16362I = false;

    /* renamed from: J  reason: collision with root package name */
    private int f16363J = 0;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public AlphaAnimation f16364K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public int f16365L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public int f16366M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public int f16367N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public int f16368O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public Bitmap f16369P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public View f16370Q;

    /* renamed from: R  reason: collision with root package name */
    private FeedBackButton f16371R;

    /* renamed from: S  reason: collision with root package name */
    private String f16372S;

    /* renamed from: T  reason: collision with root package name */
    private CampaignUnit f16373T;

    /* renamed from: U  reason: collision with root package name */
    private MBShakeView f16374U;

    /* renamed from: V  reason: collision with root package name */
    private com.mbridge.msdk.shake.b f16375V;

    /* renamed from: W  reason: collision with root package name */
    private MBridgeBaitClickView f16376W;
    /* access modifiers changed from: private */
    public boolean aa = false;
    private int ab = 1;
    private String ac;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f16377m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f16378n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f16379o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ImageView f16380p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ImageView f16381q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f16382r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f16383s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f16384t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f16385u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f16386v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f16387w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f16388x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f16389y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f16390z;

    public MBridgeNativeEndCardView(Context context) {
        super(context);
    }

    static /* synthetic */ void p(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        CampaignEx campaignEx = mBridgeNativeEndCardView.f16239b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(mBridgeNativeEndCardView.f16372S);
            com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
            a5.a(mBridgeNativeEndCardView.f16372S + "_" + 2, mBridgeNativeEndCardView.f16239b);
        }
        if (com.mbridge.msdk.foundation.d.b.a().b()) {
            com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
            a6.a(mBridgeNativeEndCardView.f16372S + "_" + 2, (a) new a() {
                public final void close() {
                    boolean unused = MBridgeNativeEndCardView.this.f16362I = false;
                }

                public final void showed() {
                    boolean unused = MBridgeNativeEndCardView.this.f16362I = true;
                }

                public final void summit(String str) {
                    boolean unused = MBridgeNativeEndCardView.this.f16362I = false;
                }
            });
            com.mbridge.msdk.foundation.d.b a7 = com.mbridge.msdk.foundation.d.b.a();
            a7.c(mBridgeNativeEndCardView.f16372S + "_" + 1);
            if (mBridgeNativeEndCardView.f16371R != null) {
                com.mbridge.msdk.foundation.d.b a8 = com.mbridge.msdk.foundation.d.b.a();
                a8.a(mBridgeNativeEndCardView.f16372S + "_" + 2, mBridgeNativeEndCardView.f16371R);
                return;
            }
            return;
        }
        FeedBackButton feedBackButton = mBridgeNativeEndCardView.f16371R;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.f16238a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean canBackPress() {
        View view = this.f16370Q;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView() && (campaignUnit = this.f16373T) != null && campaignUnit.getAds() != null && this.f16373T.getAds().size() > 0) {
            ArrayList<CampaignEx> ads = this.f16373T.getAds();
            int size = ads.size();
            int i4 = 0;
            while (i4 < size) {
                CampaignEx campaignEx2 = ads.get(i4);
                i4++;
                CampaignEx campaignEx3 = campaignEx2;
                if (!TextUtils.isEmpty(campaignEx3.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(c.m().c());
                    campaignEx3.getIconUrl();
                }
            }
        }
    }

    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.aa;
    }

    public void notifyShowListener() {
        this.notifyListener.a(110, "");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i4;
        MBridgeBaitClickView mBridgeBaitClickView;
        super.onAttachedToWindow();
        if (this.f16355B == null) {
            this.f16355B = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeNativeEndCardView.this.f16360G = true;
                    if (MBridgeNativeEndCardView.this.f16370Q != null) {
                        MBridgeNativeEndCardView.this.f16370Q.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.f16355B;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.f16363J * 1000));
            if (!this.f16361H) {
                this.f16361H = true;
            }
            try {
                CampaignEx campaignEx = this.f16239b;
                if (campaignEx != null) {
                    if (campaignEx.isDynamicView()) {
                        String str = this.f16239b.getendcard_url();
                        if (TextUtils.isEmpty(str)) {
                            str = this.f16239b.getEndScreenUrl();
                        }
                        String a5 = aq.a(str, "alac");
                        if (!TextUtils.isEmpty(a5) && a5.equals("1")) {
                            if (this.f16239b.getAutoShowStoreMiniCard() != 1) {
                                postDelayed(new Runnable() {
                                    public final void run() {
                                        MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                                        MBridgeNativeEndCardView.this.f16239b.setClickType(1);
                                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                                    }
                                }, 1000);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        try {
            CampaignEx campaignEx2 = this.f16239b;
            if (campaignEx2 != null) {
                if (campaignEx2.isDynamicView()) {
                    String str2 = this.f16239b.getendcard_url();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.f16239b.getEndScreenUrl();
                    }
                    String a6 = aq.a(str2, "bait_click");
                    i4 = Integer.parseInt(a6);
                    if (!(TextUtils.isEmpty(a6) || i4 == 0 || (mBridgeBaitClickView = this.f16376W) == null)) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.f16376W.init(1342177280, i4);
                        if (this.f16239b.getEcTemplateId() == 1302) {
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setShape(0);
                            gradientDrawable.setColor(1342177280);
                            gradientDrawable.setStroke(0, SupportMenu.CATEGORY_MASK);
                            gradientDrawable.setCornerRadius(25.0f);
                            this.f16376W.setBackground(gradientDrawable);
                        }
                        this.f16376W.startAnimation();
                        this.f16376W.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th2) {
            af.b(MBridgeBaseView.TAG, th2.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.f16239b;
            if (campaignEx3 != null) {
                if (campaignEx3.isDynamicView()) {
                    String str3 = this.f16239b.getendcard_url();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = this.f16239b.getEndScreenUrl();
                    }
                    String a7 = aq.a(str3, "shake_show");
                    String a8 = aq.a(str3, "shake_strength");
                    String a9 = aq.a(str3, "shake_time");
                    if (!TextUtils.isEmpty(a7) && a7.equals("1")) {
                        if (this.f16374U == null) {
                            MBridgeBaitClickView mBridgeBaitClickView2 = this.f16376W;
                            if (mBridgeBaitClickView2 != null) {
                                mBridgeBaitClickView2.setVisibility(8);
                            }
                            MBShakeView mBShakeView = new MBShakeView(getContext());
                            this.f16374U = mBShakeView;
                            mBShakeView.initView(this.f16239b.getAdCall(), true);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            if (!isLandscape()) {
                                layoutParams.addRule(2, filterFindViewId(this.aa, "mbridge_iv_logo"));
                                layoutParams.addRule(14);
                                this.f16374U.setPadding(0, 0, 0, ak.a(getContext(), 20.0f));
                            } else {
                                layoutParams.addRule(13);
                            }
                            this.f16374U.setLayoutParams(layoutParams);
                            RelativeLayout relativeLayout = this.f16379o;
                            if (relativeLayout != null) {
                                if (relativeLayout.isShown()) {
                                    this.f16379o.addView(this.f16374U);
                                    TextView textView = this.ctaView;
                                    if (textView != null) {
                                        textView.setVisibility(4);
                                    }
                                    this.f16374U.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(5);
                                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                                        }
                                    });
                                    int i5 = 10;
                                    if (!TextUtils.isEmpty(a8)) {
                                        int parseInt = Integer.parseInt(a8);
                                        if (parseInt > 0) {
                                            i5 = parseInt;
                                        }
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(a9);
                                    int i6 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
                                    if (!isEmpty) {
                                        int parseInt2 = Integer.parseInt(a9);
                                        if (parseInt2 > 0) {
                                            i6 = parseInt2 * 1000;
                                        }
                                    }
                                    this.f16375V = new com.mbridge.msdk.shake.b(i5, i6) {
                                        public final void a() {
                                            if ((!com.mbridge.msdk.e.b.a() || !MBridgeNativeEndCardView.this.checkChinaShakeState()) && !MBridgeNativeEndCardView.this.f16362I && MBridgeNativeEndCardView.this.f16361H) {
                                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                                mBridgeNativeEndCardView.f16243f = 0.0f;
                                                mBridgeNativeEndCardView.f16244g = 0.0f;
                                                mBridgeNativeEndCardView.f16239b.setTriggerClickSource(5);
                                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 4);
                                            }
                                        }
                                    };
                                    com.mbridge.msdk.shake.a.a().a(this.f16375V);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            af.b(MBridgeBaseView.TAG, th3.getMessage());
        }
        try {
            CampaignEx campaignEx4 = this.f16239b;
            if (campaignEx4 != null) {
                if (campaignEx4.getAutoShowStoreMiniCard() != 0) {
                    if (!TextUtils.isEmpty(this.f16239b.getDeepLinkURL())) {
                        long showStoreMiniCardDelayTime = (long) this.f16239b.getShowStoreMiniCardDelayTime();
                        if (showStoreMiniCardDelayTime == 0) {
                            showStoreMiniCardDelayTime = 1;
                        }
                        if (this.f16356C == null) {
                            this.f16356C = new Runnable() {
                                public final void run() {
                                    MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                                    MBridgeNativeEndCardView.this.f16239b.setClickType(1);
                                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                                }
                            };
                        }
                        postDelayed(this.f16356C, showStoreMiniCardDelayTime * 1000);
                    }
                }
            }
        } catch (Throwable th4) {
            af.b(MBridgeBaseView.TAG, th4.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f16355B;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f16356C;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        if (this.f16375V != null) {
            com.mbridge.msdk.shake.a.a().b(this.f16375V);
            this.f16375V = null;
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            RelativeLayout relativeLayout = this.f16357D;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            int i4 = configuration.orientation;
            this.f16241d = i4;
            if (i4 == 2) {
                removeView(this.f16377m);
                a((View) this.f16378n);
                return;
            }
            removeView(this.f16378n);
            a((View) this.f16377m);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0160 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0192 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r7) {
        /*
            r6 = this;
            r6.f16358E = r7
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f16239b     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x01a3
            boolean r7 = r6.f16242e     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x01a3
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11 r7 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11     // Catch:{ all -> 0x0063 }
            r7.<init>()     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r6.f16238a     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x0063 }
            r0.a(r1, r7)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.video.module.a.a.j r7 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x0063 }
            android.widget.ImageView r0 = r6.f16382r     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            android.content.Context r1 = r1.c()     // Catch:{ all -> 0x0063 }
            r2 = 1090519040(0x41000000, float:8.0)
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)     // Catch:{ all -> 0x0063 }
            r7.<init>(r0, r1)     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r6.f16238a     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.getIconUrl()     // Catch:{ all -> 0x0063 }
            r0.a(r1, r7)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.f16387w     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAppName()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.ctaView     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0067
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAdCall()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r7 = r0
            goto L_0x019a
        L_0x0067:
            android.widget.TextView r7 = r6.f16388x     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0074
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAppDesc()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x0074:
            android.widget.TextView r7 = r6.f16389y     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0092
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f16239b     // Catch:{ all -> 0x0063 }
            int r1 = r1.getNumberRating()     // Catch:{ all -> 0x0063 }
            r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = ")"
            r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x0092:
            android.widget.LinearLayout r7 = r6.f16390z     // Catch:{ all -> 0x0063 }
            r7.removeAllViews()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f16239b     // Catch:{ all -> 0x0063 }
            double r0 = r7.getRating()     // Catch:{ all -> 0x0063 }
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 > 0) goto L_0x00a5
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00a5:
            android.widget.LinearLayout r7 = r6.f16390z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.videocommon.view.StarLevelView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00b0
            com.mbridge.msdk.videocommon.view.StarLevelView r7 = (com.mbridge.msdk.videocommon.view.StarLevelView) r7     // Catch:{ all -> 0x0063 }
            r7.initScore(r0)     // Catch:{ all -> 0x0063 }
        L_0x00b0:
            android.widget.LinearLayout r7 = r6.f16390z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00c1
            com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView r7 = (com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r6.f16239b     // Catch:{ all -> 0x0063 }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x0063 }
            r7.setRatingAndUser(r0, r2)     // Catch:{ all -> 0x0063 }
        L_0x00c1:
            android.widget.LinearLayout r7 = r6.f16390z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00cd
            com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView r7 = (com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            int r0 = (int) r0     // Catch:{ all -> 0x0063 }
            r7.setRating(r0)     // Catch:{ all -> 0x0063 }
        L_0x00cd:
            android.widget.LinearLayout r7 = r6.f16354A     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x00e0
            boolean r0 = r7 instanceof com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x00e0
            com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView r7 = (com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f16239b     // Catch:{ all -> 0x0063 }
            int r0 = r0.getNumberRating()     // Catch:{ all -> 0x0063 }
            r7.setHeatCount(r0)     // Catch:{ all -> 0x0063 }
        L_0x00e0:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ all -> 0x0063 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x00fd
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f16239b     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = "alecfc=1"
            boolean r7 = r7.contains(r0)     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x00fd
            r7 = 1
            r6.f16359F = r7     // Catch:{ all -> 0x0063 }
        L_0x00fd:
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getLanguage()     // Catch:{ all -> 0x0063 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "drawable"
            if (r0 != 0) goto L_0x0139
            java.lang.String r0 = "zh"
            boolean r7 = r7.equals(r0)     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0139
            android.widget.ImageView r7 = r6.f16383s     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0063 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0063 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0063 }
            r7.setImageDrawable(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "广告"
            r6.ac = r7     // Catch:{ all -> 0x0063 }
            goto L_0x015c
        L_0x0139:
            android.widget.ImageView r7 = r6.f16383s     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0063 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0063 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0063 }
            r7.setImageDrawable(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "AD"
            r6.ac = r7     // Catch:{ all -> 0x0063 }
        L_0x015c:
            int r7 = r6.ab     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x017e
            android.widget.ImageView r7 = r6.f16383s     // Catch:{ all -> 0x0063 }
            r0 = 4
            if (r7 == 0) goto L_0x0168
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x0168:
            android.widget.ImageView r7 = r6.f16385u     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x016f
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x016f:
            android.widget.TextView r7 = r6.f16384t     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x017e
            r0 = 0
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.f16384t     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r6.ac     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x017e:
            android.widget.ImageView r1 = r6.f16386v     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r6.f16239b     // Catch:{ all -> 0x0063 }
            android.content.Context r3 = r6.f16238a     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$12 r5 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$12     // Catch:{ all -> 0x0063 }
            r5.<init>()     // Catch:{ all -> 0x0063 }
            r0 = 2
            r4 = 1
            com.mbridge.msdk.foundation.tools.ak.a(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0063 }
            boolean r7 = r6.f16360G     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x0199
            android.view.View r7 = r6.f16370Q     // Catch:{ all -> 0x0063 }
            r0 = 8
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x0199:
            return
        L_0x019a:
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r7)
        L_0x01a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.f16364K;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.f16355B = null;
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void setCloseBtnDelay(int i4) {
        this.f16363J = i4;
    }

    public void setLayout() {
        String str;
        if (this.f16245h) {
            if (com.mbridge.msdk.e.b.a()) {
                str = "cn_";
            } else {
                str = "en_";
            }
            com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a(getContext(), this.f16239b, this.f16246i, str);
            this.ab = a5.n();
            com.mbridge.msdk.video.dynview.b.a().a(a5, new h() {
                public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                    af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                }

                public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        MBridgeNativeEndCardView.this.addView(aVar.a());
                        boolean unused = MBridgeNativeEndCardView.this.aa = aVar.c();
                        if (MBridgeNativeEndCardView.this.ctaViewCanGet(aVar.a(), MBridgeNativeEndCardView.this.aa)) {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                            mBridgeNativeEndCardView.f16242e = mBridgeNativeEndCardView.b(aVar.a());
                            MBridgeNativeEndCardView.this.b();
                        } else {
                            boolean unused2 = MBridgeNativeEndCardView.this.aa = false;
                            MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                            mBridgeNativeEndCardView2.f16245h = false;
                            mBridgeNativeEndCardView2.a();
                        }
                        MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                        CampaignEx campaignEx = mBridgeNativeEndCardView3.f16239b;
                        if (campaignEx != null) {
                            campaignEx.setECTemplateRenderSucc(mBridgeNativeEndCardView3.aa);
                        }
                    }
                }
            });
            return;
        }
        a();
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            this.f16373T = campaignUnit;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.f16373T.getAds().size() > 5 && (mBShakeView = this.f16374U) != null) {
                mBShakeView.setPadding(0, 0, 0, ak.a(getContext(), 5.0f));
            }
        }
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        af.b(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}));
        this.f16365L = i4;
        this.f16366M = i5;
        this.f16367N = i6;
        this.f16368O = i7;
        f();
    }

    public void setOnPause() {
        this.f16361H = false;
    }

    public void setOnResume() {
        this.f16361H = true;
    }

    public void setUnitId(String str) {
        this.f16372S = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r6.f16247j != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r6.f16247j != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int e() {
        /*
            r6 = this;
            int r0 = r6.f16248k
            java.lang.String r1 = "mbridge_reward_endcard_native_land"
            java.lang.String r2 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r3 = "mbridge_reward_endcard_native_hor"
            java.lang.String r4 = "mbridge_reward_endcard_native_half_portrait"
            if (r0 != 0) goto L_0x001e
            boolean r0 = r6.f16247j
            if (r0 == 0) goto L_0x0011
            r3 = r4
        L_0x0011:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L_0x0031
            boolean r0 = r6.f16247j
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            r1 = r2
        L_0x001c:
            r3 = r1
            goto L_0x0031
        L_0x001e:
            r5 = 1
            if (r0 != r5) goto L_0x0027
            boolean r5 = r6.f16247j
            if (r5 == 0) goto L_0x0029
            r3 = r4
            goto L_0x0029
        L_0x0027:
            java.lang.String r3 = ""
        L_0x0029:
            r4 = 2
            if (r0 != r4) goto L_0x0031
            boolean r0 = r6.f16247j
            if (r0 == 0) goto L_0x001c
            goto L_0x001b
        L_0x0031:
            int r0 = r6.findLayout(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.e():int");
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (this.f16242e && (relativeLayout = this.f16357D) != null) {
            relativeLayout.postDelayed(new Runnable() {
                public final void run() {
                    if (MBridgeNativeEndCardView.this.f16357D != null) {
                        CampaignEx campaignEx = MBridgeNativeEndCardView.this.f16239b;
                        if (!(campaignEx == null || campaignEx.isDynamicView() || MBridgeNativeEndCardView.this.f16239b.getAdSpaceT() == 2)) {
                            MBridgeNativeEndCardView.this.f16357D.setPadding(MBridgeNativeEndCardView.this.f16365L, MBridgeNativeEndCardView.this.f16367N, MBridgeNativeEndCardView.this.f16366M, MBridgeNativeEndCardView.this.f16368O);
                            MBridgeNativeEndCardView.this.f16357D.startAnimation(MBridgeNativeEndCardView.this.f16364K);
                        }
                        MBridgeNativeEndCardView.this.f16357D.setVisibility(0);
                    }
                    if (!(MBridgeNativeEndCardView.this.f16370Q == null || MBridgeNativeEndCardView.this.f16370Q.getVisibility() == 0 || !MBridgeNativeEndCardView.this.f16360G)) {
                        MBridgeNativeEndCardView.this.f16370Q.setVisibility(0);
                    }
                    MBridgeNativeEndCardView.p(MBridgeNativeEndCardView.this);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f16242e) {
            this.f16379o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.f16359F) {
                        MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.f16370Q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.f16245h) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a.a().b();
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                        try {
                            CampaignEx campaignEx = MBridgeNativeEndCardView.this.f16239b;
                            if (campaignEx != null) {
                                String a5 = aq.a(campaignEx.getendcard_url(), "ecid");
                                String a6 = aq.a(MBridgeNativeEndCardView.this.f16239b.getendcard_url(), "mof");
                                e eVar = new e();
                                eVar.a("type", "choseFromTwoClose");
                                eVar.a("endcard_id", a5);
                                eVar.a("mof", a6);
                                com.mbridge.msdk.video.module.b.a.a("2000103", MBridgeNativeEndCardView.this.f16239b, eVar);
                            }
                        } catch (Exception e6) {
                            if (MBridgeConstans.DEBUG) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    try {
                        e eVar2 = new e();
                        eVar2.a("type", 2);
                        d.a().a("2000152", eVar2);
                        d.a().a("2000134", MBridgeNativeEndCardView.this.f16239b);
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    MBridgeNativeEndCardView.this.notifyListener.a(104, "");
                }
            });
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setOnClickListener(new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void onNoDoubleClick(View view) {
                        MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(1);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                });
            }
            this.f16382r.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView == null) {
                        return;
                    }
                    if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                        MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                }
            });
            this.f16381q.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView == null) {
                        return;
                    }
                    if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                        MBridgeNativeEndCardView.this.f16239b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        int e5 = e();
        if (e5 > 0) {
            this.f16242e = b(e5);
            b();
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null) {
                campaignEx.setECTemplateRenderSucc(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        c();
        if (!this.f16242e) {
            this.notifyListener.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.f16364K = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.f16358E);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        f();
    }

    private boolean b(int i4) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f16240c.inflate(i4, (ViewGroup) null);
            this.f16378n = viewGroup;
            addView(viewGroup);
            return b((View) this.f16378n);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f16240c.inflate(i4, (ViewGroup) null);
        this.f16377m = viewGroup2;
        addView(viewGroup2);
        return b((View) this.f16377m);
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        View view2 = view;
        try {
            this.f16379o = (RelativeLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_layout"));
            this.f16381q = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner"));
            this.f16382r = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_icon"));
            this.f16383s = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_flag"));
            this.f16384t = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_flag"));
            this.f16385u = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_logo"));
            this.f16386v = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_link"));
            this.f16387w = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_apptitle"));
            this.f16390z = (LinearLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_sv_starlevel"));
            this.f16354A = (LinearLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_sv_heat_count_level"));
            this.f16370Q = view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_close"));
            this.ctaView = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_cta"));
            this.f16371R = (FeedBackButton) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_endcard_feed_btn"));
            this.f16357D = (RelativeLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_controller"));
            this.f16380p = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner_bg"));
            this.f16376W = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aa, "mbridge_animation_click_view"));
            this.f16388x = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_appdesc"));
            if (this.f16245h) {
                ImageView imageView = this.f16381q;
                if (imageView != null && (imageView instanceof RoundImageView)) {
                    ((RoundImageView) imageView).setBorderRadius(10);
                }
                ImageView imageView2 = this.f16382r;
                if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                    ((RoundImageView) imageView2).setBorderRadius(10);
                }
                return isNotNULL(this.f16381q, this.f16382r, this.f16387w, this.f16390z, this.f16370Q, this.ctaView);
            }
            TextView textView = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_number"));
            this.f16389y = textView;
            return isNotNULL(this.f16381q, this.f16382r, this.f16387w, this.f16388x, textView, this.f16390z, this.f16370Q, this.ctaView);
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z4, int i4, boolean z5, int i5, int i6) {
        super(context, attributeSet, z4, i4, z5, i5, i6);
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, final Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.f.a.d().execute(new Runnable() {
                public final void run() {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    Bitmap unused = mBridgeNativeEndCardView.f16369P = mBridgeNativeEndCardView.blurBitmap(bitmap);
                    if (MBridgeNativeEndCardView.this.f16369P != null && !MBridgeNativeEndCardView.this.f16369P.isRecycled() && MBridgeNativeEndCardView.this.f16380p != null) {
                        MBridgeNativeEndCardView.this.f16380p.post(new Runnable() {
                            public final void run() {
                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                if (mBridgeNativeEndCardView.f16245h) {
                                    mBridgeNativeEndCardView.f16380p.setBackground((Drawable) null);
                                }
                                af.b("async", "执行异步加载图");
                                MBridgeNativeEndCardView.this.f16380p.setImageBitmap(MBridgeNativeEndCardView.this.f16369P);
                            }
                        });
                    }
                }
            });
        } catch (Exception e5) {
            af.a(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i4) {
        JSONObject jSONObject;
        JSONException jSONException;
        CampaignEx campaignEx = mBridgeNativeEndCardView.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeNativeEndCardView.f16239b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + str;
                }
                i.a(c.m().c(), "end_card_click", mBridgeNativeEndCardView.f16239b.getCampaignUnitId(), mBridgeNativeEndCardView.f16239b.isBidCampaign(), mBridgeNativeEndCardView.f16239b.getRequestId(), mBridgeNativeEndCardView.f16239b.getRequestIdNotice(), mBridgeNativeEndCardView.f16239b.getId(), str);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f13136j, mBridgeNativeEndCardView.a(i4));
                if (mBridgeNativeEndCardView.f16239b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e6) {
                jSONException = e6;
                jSONObject2 = jSONObject;
                jSONException.printStackTrace();
                jSONObject = jSONObject2;
                mBridgeNativeEndCardView.f16239b.setClickTempSource(2);
                mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e7) {
            jSONException = e7;
            jSONException.printStackTrace();
            jSONObject = jSONObject2;
            mBridgeNativeEndCardView.f16239b.setClickTempSource(2);
            mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
        }
        mBridgeNativeEndCardView.f16239b.setClickTempSource(2);
        mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
    }
}
