package com.mbridge.msdk.newreward.player.view.ectemplate;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.presenter.ECWebPresenter;
import com.mbridge.msdk.newreward.player.view.floatview.FloatWebTemplateView;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import org.json.JSONObject;

public class WebViewEC extends FrameLayout implements View.OnClickListener, IBaseWebView {
    private final String TAG = "WebViewEC";
    private boolean hasWebViewShow = false;
    /* access modifiers changed from: private */
    public boolean isWebViewAttached = false;
    private ImageView mCloseImageView;
    /* access modifiers changed from: private */
    public FloatWebTemplateView mExpandView;
    private ImageView mLinkImageView;
    private ECWebPresenter mWebECPresenter;
    private MBWebView mWebView;
    private final Runnable webViewShowRunnable = new Runnable() {
        public void run() {
            WebViewEC.this.webViewShow();
            WebViewEC.this.setNotch();
        }
    };

    public WebViewEC(@NonNull Context context) {
        super(context);
        initPresenter();
    }

    public void addViewToCurrentViewGroup(View view) {
    }

    public ImageView getPrivacyButton() {
        return this.mLinkImageView;
    }

    public int getRenderStatus() {
        return this.mWebECPresenter.getRenderStatus();
    }

    public MBWebView getWebView() {
        return this.mWebView;
    }

    public void hideCTAView() {
    }

    public void initPresenter() {
        ECWebPresenter eCWebPresenter = new ECWebPresenter(this);
        this.mWebECPresenter = eCWebPresenter;
        eCWebPresenter.getView();
    }

    public boolean initViews(boolean z4) {
        MBWebView mBWebView = new MBWebView(new MutableContextWrapper(c.m().c()));
        this.mWebView = mBWebView;
        mBWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mCloseImageView = new ImageView(getContext());
        int a5 = ak.a(getContext(), 48.0f);
        int a6 = ak.a(getContext(), 5.0f);
        int a7 = ak.a(getContext(), 15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a5, a5);
        layoutParams.topMargin = a7;
        layoutParams.rightMargin = a7;
        layoutParams.gravity = 8388661;
        this.mCloseImageView.setLayoutParams(layoutParams);
        this.mCloseImageView.setPadding(a6, a6, a6, a6);
        this.mCloseImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.mCloseImageView.setImageResource(x.a(getContext(), "mbridge_reward_close", "drawable"));
        this.mCloseImageView.setOnClickListener(this);
        this.mCloseImageView.setVisibility(4);
        this.mLinkImageView = new ImageView(getContext());
        int a8 = ak.a(getContext(), 35.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a8, a8);
        layoutParams2.topMargin = a7;
        layoutParams2.leftMargin = a7;
        layoutParams2.gravity = 8388659;
        this.mLinkImageView.setLayoutParams(layoutParams2);
        this.mLinkImageView.setImageResource(x.a(getContext(), "mbridge_reward_notice", "drawable"));
        this.mLinkImageView.setId(at.a());
        this.mLinkImageView.setOnClickListener(this);
        this.mLinkImageView.setVisibility(4);
        this.mWebView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                boolean unused = WebViewEC.this.isWebViewAttached = true;
            }

            public void onViewDetachedFromWindow(View view) {
                boolean unused = WebViewEC.this.isWebViewAttached = false;
            }
        });
        addView(this.mWebView);
        addView(this.mCloseImageView);
        return true;
    }

    public void onActivityLifeCycleCallback(String str) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.onActivityLifeCycleCallback(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mWebECPresenter.onAttachedToWindow();
    }

    public void onClick(View view) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.click(view);
        }
    }

    public void onCloseViewClick(@BridgeParameter(key = "type") int i4) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (eCWebPresenter != null) {
            eCWebPresenter.click((View) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            MBCommunicatorUtil.fireEvent(this.mWebView, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            af.b("WebViewEC", e5.getMessage());
        }
    }

    public void onDestroyWebContent(@BridgeParameter(key = "type") int i4) {
        MBWebView mBWebView = this.mWebView;
        if (mBWebView != null) {
            mBWebView.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.webViewShowRunnable);
        this.mWebECPresenter.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ECWebPresenter eCWebPresenter = this.mWebECPresenter;
        if (!(eCWebPresenter == null || motionEvent == null)) {
            eCWebPresenter.handleInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onWebViewShow(@BridgeParameter(key = "type") int i4) {
        if (this.mWebView.isAttachedToWindow()) {
            Rect rect = new Rect();
            this.mWebView.getHitRect(rect);
            if (this.mWebView.getLocalVisibleRect(rect)) {
                this.mWebView.post(this.webViewShowRunnable);
            }
        }
        if (this.hasWebViewShow) {
            return true;
        }
        this.hasWebViewShow = true;
        return false;
    }

    public void preloadWebContent(String str) {
        if (this.mWebView != null) {
            this.mWebECPresenter.addECModel();
            if (!TextUtils.isEmpty(str)) {
                this.mWebView.loadUrl(str);
            } else {
                this.mWebECPresenter.setRenderError();
            }
        }
    }

    public void removeTempleFromSuperView(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public void setNativeCloseButtonVisibility(int i4) {
        ECWebPresenter eCWebPresenter;
        ImageView imageView = this.mCloseImageView;
        if (imageView != null) {
            imageView.setVisibility(i4);
        }
        if (i4 == 0 && (eCWebPresenter = this.mWebECPresenter) != null) {
            eCWebPresenter.setCanResponseBack(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e A[Catch:{ all -> 0x0090 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[Catch:{ all -> 0x0090 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNotch() {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0090 }
            r1 = 23
            if (r0 < r1) goto L_0x009a
            android.view.WindowInsets r1 = r7.getRootWindowInsets()     // Catch:{ all -> 0x0090 }
            r2 = 28
            if (r0 < r2) goto L_0x009a
            android.view.DisplayCutout r0 = r1.getDisplayCutout()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x009a
            int r1 = r0.getSafeInsetLeft()     // Catch:{ all -> 0x0090 }
            int r2 = r0.getSafeInsetTop()     // Catch:{ all -> 0x0090 }
            int r3 = r0.getSafeInsetRight()     // Catch:{ all -> 0x0090 }
            int r0 = r0.getSafeInsetBottom()     // Catch:{ all -> 0x0090 }
            android.view.Display r4 = r7.getDisplay()     // Catch:{ all -> 0x0090 }
            int r4 = r4.getRotation()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x002f
            goto L_0x0041
        L_0x002f:
            r5 = 1
            if (r4 != r5) goto L_0x0035
            r4 = 90
            goto L_0x0042
        L_0x0035:
            r5 = 2
            if (r4 != r5) goto L_0x003b
            r4 = 180(0xb4, float:2.52E-43)
            goto L_0x0042
        L_0x003b:
            r5 = 3
            if (r4 != r5) goto L_0x0041
            r4 = 270(0x10e, float:3.78E-43)
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            com.mbridge.msdk.newreward.player.presenter.ECWebPresenter r5 = r7.mWebECPresenter     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.s.a(r4, r1, r3, r2, r0)     // Catch:{ all -> 0x0090 }
            r5.setNotchData(r4)     // Catch:{ all -> 0x0090 }
            android.content.Context r4 = r7.getContext()     // Catch:{ all -> 0x0090 }
            r5 = 1097859072(0x41700000, float:15.0)
            int r4 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r4, (float) r5)     // Catch:{ all -> 0x0090 }
            android.widget.ImageView r5 = r7.mCloseImageView     // Catch:{ all -> 0x0090 }
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch:{ all -> 0x0090 }
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x0061
            r6 = r4
            goto L_0x0062
        L_0x0061:
            r6 = r2
        L_0x0062:
            r5.topMargin = r6     // Catch:{ all -> 0x0090 }
            r5.leftMargin = r1     // Catch:{ all -> 0x0090 }
            if (r3 != 0) goto L_0x006a
            r6 = r4
            goto L_0x006b
        L_0x006a:
            r6 = r3
        L_0x006b:
            r5.rightMargin = r6     // Catch:{ all -> 0x0090 }
            r5.bottomMargin = r0     // Catch:{ all -> 0x0090 }
            android.widget.ImageView r6 = r7.mCloseImageView     // Catch:{ all -> 0x0090 }
            r6.setLayoutParams(r5)     // Catch:{ all -> 0x0090 }
            android.widget.ImageView r5 = r7.mLinkImageView     // Catch:{ all -> 0x0090 }
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()     // Catch:{ all -> 0x0090 }
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5     // Catch:{ all -> 0x0090 }
            if (r2 != 0) goto L_0x007f
            r2 = r4
        L_0x007f:
            r5.topMargin = r2     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0084
            r1 = r4
        L_0x0084:
            r5.leftMargin = r1     // Catch:{ all -> 0x0090 }
            r5.rightMargin = r3     // Catch:{ all -> 0x0090 }
            r5.bottomMargin = r0     // Catch:{ all -> 0x0090 }
            android.widget.ImageView r0 = r7.mLinkImageView     // Catch:{ all -> 0x0090 }
            r0.setLayoutParams(r5)     // Catch:{ all -> 0x0090 }
            return
        L_0x0090:
            r0 = move-exception
            java.lang.String r1 = "WebViewEC"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r1, r0)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC.setNotch():void");
    }

    public void show(ViewGroup viewGroup) {
        if (getParent() != null) {
            viewGroup.bringToFront();
        } else if (viewGroup != null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        this.mWebECPresenter.onShown();
    }

    public void showCTAView(String str, CampaignEx campaignEx) {
    }

    public void showMRAIDExpandView(String str, int i4) {
        if (this.mExpandView == null) {
            this.mExpandView = new FloatWebTemplateView(getContext());
        }
        this.mExpandView.setRenderUrl(str);
        this.mExpandView.setFloatViewType(FloatWebTemplateView.FLOAT_EXPAND_VIEW);
        this.mExpandView.addShowReqListener(new b() {
            public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            }

            public void reqSuccessful(Object obj) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!str.equals("show") && str.equals("remove")) {
                        WebViewEC webViewEC = WebViewEC.this;
                        webViewEC.removeView(webViewEC.mExpandView);
                    }
                }
            }
        });
        this.mExpandView.show(this);
    }

    public void showMiniCard() {
    }

    public void webViewShow() {
        try {
            if (this.mWebECPresenter.getRenderStatus() >= 2) {
                int i4 = getResources().getConfiguration().orientation;
                String str = "undefined";
                if (i4 != 0) {
                    if (i4 == 1) {
                        str = "portrait";
                    } else if (i4 == 2) {
                        str = "landscape";
                    }
                }
                MBCommunicatorUtil.notifyShowDataInfo(this.mWebView, i4, this.mWebECPresenter.getCampaignOrientation());
                MBCommunicatorUtil.notifyWebViewShowed(this.mWebView, str, this.mWebECPresenter.getWebViewShowExtraData());
            }
        } catch (Throwable th) {
            af.b("WebViewEC", th.getMessage());
        }
    }

    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initPresenter();
    }

    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        initPresenter();
    }

    @RequiresApi(api = 21)
    public WebViewEC(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        initPresenter();
    }
}
