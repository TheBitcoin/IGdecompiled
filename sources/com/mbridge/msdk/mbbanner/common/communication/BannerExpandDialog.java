package com.mbridge.msdk.mbbanner.common.communication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbbanner.common.b.a;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class BannerExpandDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final String f13971a = "BannerExpandDialog";

    /* renamed from: b  reason: collision with root package name */
    private String f13972b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13973c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f13974d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WindVaneWebView f13975e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f13976f;

    /* renamed from: g  reason: collision with root package name */
    private String f13977g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public List<CampaignEx> f13978h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f13979i;

    /* renamed from: j  reason: collision with root package name */
    private b f13980j = new b() {
        public final void close() {
            BannerExpandDialog.this.dismiss();
        }

        public final void expand(String str, boolean z4) {
        }

        public final CampaignEx getMraidCampaign() {
            return null;
        }

        public final void open(String str) {
            try {
                if (BannerExpandDialog.this.f13975e == null || System.currentTimeMillis() - BannerExpandDialog.this.f13975e.lastTouchTime <= ((long) com.mbridge.msdk.click.b.a.f12045c) || !com.mbridge.msdk.click.b.a.a((CampaignEx) BannerExpandDialog.this.f13978h.get(0), BannerExpandDialog.this.f13975e.getUrl(), com.mbridge.msdk.click.b.a.f12043a)) {
                    af.b("BannerExpandDialog", str);
                    if (BannerExpandDialog.this.f13978h.size() > 1) {
                        c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (BannerExpandDialog.this.f13979i != null) {
                        BannerExpandDialog.this.f13979i.a(true, str);
                    }
                }
            } catch (Throwable th) {
                af.b("BannerExpandDialog", "open", th);
            }
        }

        public final void unload() {
            close();
        }

        public final void useCustomClose(boolean z4) {
            int i4;
            try {
                TextView g4 = BannerExpandDialog.this.f13976f;
                if (z4) {
                    i4 = 4;
                } else {
                    i4 = 0;
                }
                g4.setVisibility(i4);
            } catch (Throwable th) {
                af.b("BannerExpandDialog", "useCustomClose", th);
            }
        }
    };

    public BannerExpandDialog(Context context, Bundle bundle, a aVar) {
        super(context);
        if (bundle != null) {
            this.f13972b = bundle.getString("url");
            this.f13973c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.f13979i = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i4;
        CampaignEx campaignEx;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f13974d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.f13975e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f13974d.addView(this.f13975e);
        TextView textView = new TextView(getContext());
        this.f13976f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f13976f.setLayoutParams(layoutParams);
        TextView textView2 = this.f13976f;
        if (this.f13973c) {
            i4 = 4;
        } else {
            i4 = 0;
        }
        textView2.setVisibility(i4);
        this.f13976f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BannerExpandDialog.this.dismiss();
            }
        });
        BitmapDrawable a5 = c.m().a(this.f13977g, 296);
        if (a5 != null) {
            ImageView imageView = new ImageView(c.m().c());
            ak.a(imageView, a5, this.f13974d.getResources().getDisplayMetrics());
            this.f13974d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f13974d.addView(this.f13976f);
        setContentView(this.f13974d);
        a();
        this.f13975e.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() {
                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                        String str = (String) obj;
                    }
                });
                BannerExpandDialog.a(BannerExpandDialog.this);
            }
        });
        this.f13975e.setObject(this.f13980j);
        this.f13975e.loadUrl(this.f13972b);
        List<CampaignEx> list = this.f13978h;
        if (!(list == null || list.size() <= 0 || (campaignEx = this.f13978h.get(0)) == null || campaignEx.getPrivacyButtonTemplateVisibility() == 0)) {
            MBAdChoice mBAdChoice = new MBAdChoice(c.m().c());
            mBAdChoice.setCampaign(campaignEx);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ak.a(c.m().c(), 12.0f), ak.a(c.m().c(), 12.0f));
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = layoutParams.topMargin;
            layoutParams2.rightMargin = layoutParams.rightMargin;
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() {
                public final void close() {
                    BannerExpandDialog.this.a();
                }

                public final void showed() {
                }

                public final void summit(String str) {
                    BannerExpandDialog.this.a();
                }
            });
            this.f13974d.addView(mBAdChoice, layoutParams2);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                if (BannerExpandDialog.this.f13979i != null) {
                    BannerExpandDialog.this.f13979i.a(false);
                }
                BannerExpandDialog.this.f13975e.loadDataWithBaseURL((String) null, "", "text/html", "utf-8", (String) null);
                BannerExpandDialog.this.f13974d.removeView(BannerExpandDialog.this.f13975e);
                BannerExpandDialog.this.f13975e.release();
                WindVaneWebView unused = BannerExpandDialog.this.f13975e = null;
                a unused2 = BannerExpandDialog.this.f13979i = null;
            }
        });
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.f13977g = str;
        this.f13978h = list;
    }

    static /* synthetic */ void a(BannerExpandDialog bannerExpandDialog) {
        BannerExpandDialog bannerExpandDialog2 = bannerExpandDialog;
        try {
            int i4 = c.m().c().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i4 == 2 ? "landscape" : i4 == 1 ? "portrait" : "undefined");
            jSONObject.put("locked", "true");
            HashMap i5 = ab.i(c.m().c());
            int intValue = ((Integer) i5.get("width")).intValue();
            int intValue2 = ((Integer) i5.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put(MRAIDCommunicatorUtil.KEY_PLACEMENTTYPE, MRAIDCommunicatorUtil.PLACEMENT_INTERSTITIAL);
            hashMap.put(MRAIDCommunicatorUtil.KEY_STATE, MRAIDCommunicatorUtil.STATES_EXPANDED);
            hashMap.put(MRAIDCommunicatorUtil.KEY_VIEWABLE, "true");
            hashMap.put(MRAIDCommunicatorUtil.KEY_CURRENTORIENTATION, jSONObject);
            int[] iArr = new int[2];
            bannerExpandDialog2.f13975e.getLocationInWindow(iArr);
            com.mbridge.msdk.mbsignalcommon.mraid.a a5 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView = bannerExpandDialog2.f13975e;
            a5.a(windVaneWebView, (float) iArr[0], (float) iArr[1], (float) windVaneWebView.getWidth(), (float) bannerExpandDialog2.f13975e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a a6 = com.mbridge.msdk.mbsignalcommon.mraid.a.a();
            WindVaneWebView windVaneWebView2 = bannerExpandDialog2.f13975e;
            a6.b(windVaneWebView2, (float) iArr[0], (float) iArr[1], (float) windVaneWebView2.getWidth(), (float) bannerExpandDialog2.f13975e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(bannerExpandDialog2.f13975e, (float) ab.j(c.m().c()), (float) ab.h(c.m().c()));
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(bannerExpandDialog2.f13975e, (float) intValue, (float) intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) bannerExpandDialog2.f13975e, (Map<String, Object>) hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(bannerExpandDialog2.f13975e);
        } catch (Throwable th) {
            af.b("BannerExpandDialog", "notifyMraid", th);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }
}
