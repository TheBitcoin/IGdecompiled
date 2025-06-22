package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONObject;

public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {

    /* renamed from: w  reason: collision with root package name */
    private boolean f16265w = false;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final String a() {
        CampaignEx campaignEx = this.f16239b;
        String str = null;
        if (campaignEx != null) {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                str = rewardTemplateMode.c();
            }
            if (!TextUtils.isEmpty(str) && str.contains(".zip")) {
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
                if (!TextUtils.isEmpty(h5ResAddress)) {
                    return h5ResAddress;
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @RequiresApi(api = 11)
    public final void e() {
        super.e();
        if (this.f16242e) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.f16322m);
            setClickable(true);
        }
    }

    @RequiresApi(api = 11)
    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f16242e) {
            a(this.f16322m);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i4, int i5) {
        View findViewById = ((Activity) this.f16238a).getWindow().findViewById(16908290);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        if (i4 > 0 && i5 > 0 && i4 <= width && i5 <= height) {
            ViewGroup.LayoutParams layoutParams = this.f16322m.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            this.f16322m.setLayoutParams(layoutParams);
        }
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z4) {
        setClickable(z4);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i4, int i5, int i6, int i7) {
        this.f16265w = true;
        resizeMiniCard(i6, i7);
    }

    public void setRadius(int i4) {
        if (i4 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) ak.a(getContext(), (float) i4));
            gradientDrawable.setColor(-1);
            this.f16325p.setBackground(gradientDrawable);
            this.f16325p.setClipToOutline(true);
        }
    }

    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f16325p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() {
                public final void run() {
                    try {
                        af.a(MBridgeBaseView.TAG, "webviewshow");
                        String str = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.f16325p.getLocationOnScreen(iArr);
                            af.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", ak.b(c.m().c(), (float) iArr[0]));
                            jSONObject.put("startY", ak.b(c.m().c(), (float) iArr[1]));
                            str = jSONObject.toString();
                        } catch (Throwable th) {
                            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                        }
                        g.a().a((WebView) MBridgeClickMiniCardView.this.f16325p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            });
            e eVar = new e();
            eVar.a("type", 3);
            d.a().a("2000133", this.f16239b, eVar);
        }
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @RequiresApi(api = 11)
    private void a(View view) {
        int f4 = ak.f(this.f16238a);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((((float) f4) * 0.7f) + 0.5f);
        layoutParams.height = (int) ((((float) ak.e(this.f16238a)) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }
}
