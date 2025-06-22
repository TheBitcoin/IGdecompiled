package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.lang.reflect.Method;

public class BrowserView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private CampaignEx f13703a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f13704b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f13705c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public WebView f13706d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f13707e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ToolBar f13708f;

    public interface a {
        void a();

        void a(WebView webView, int i4, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f13703a = campaignEx;
        init();
    }

    public void destroy() {
        WebView webView = this.f13706d;
        if (webView != null) {
            webView.stopLoading();
            this.f13706d.setWebViewClient((WebViewClient) null);
            this.f13706d.destroy();
            this.f13706d = null;
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f13707e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f13706d == null) {
                this.f13706d = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f13706d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            af.b("BrowserView", "webview is error", th);
        }
        this.f13708f = new ToolBar(getContext());
        this.f13708f.setLayoutParams(new LinearLayout.LayoutParams(-1, ak.a(getContext(), 40.0f)));
        this.f13708f.setBackgroundColor(-1);
        addView(this.f13707e);
        WebView webView = this.f13706d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f13708f);
        this.f13707e.initResource(true);
        this.f13708f.getItem(ToolBar.BACKWARD).setEnabled(false);
        this.f13708f.getItem(ToolBar.FORWARD).setEnabled(false);
        this.f13708f.setOnItemClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                boolean z4;
                if (BrowserView.this.f13706d != null) {
                    BrowserView.this.f13706d.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z5 = false;
                if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                    BrowserView.this.f13708f.getItem(ToolBar.FORWARD).setEnabled(true);
                    if (BrowserView.this.f13706d != null && BrowserView.this.f13706d.canGoBack()) {
                        BrowserView.this.f13706d.goBack();
                    }
                    View item = BrowserView.this.f13708f.getItem(ToolBar.BACKWARD);
                    if (BrowserView.this.f13706d != null && BrowserView.this.f13706d.canGoBack()) {
                        z5 = true;
                    }
                    item.setEnabled(z5);
                } else if (TextUtils.equals(str, ToolBar.FORWARD)) {
                    BrowserView.this.f13708f.getItem(ToolBar.BACKWARD).setEnabled(true);
                    if (BrowserView.this.f13706d != null && BrowserView.this.f13706d.canGoForward()) {
                        BrowserView.this.f13706d.goForward();
                    }
                    View item2 = BrowserView.this.f13708f.getItem(ToolBar.FORWARD);
                    if (BrowserView.this.f13706d != null && BrowserView.this.f13706d.canGoForward()) {
                        z5 = true;
                    }
                    item2.setEnabled(z5);
                } else if (TextUtils.equals(str, ToolBar.REFRESH)) {
                    View item3 = BrowserView.this.f13708f.getItem(ToolBar.BACKWARD);
                    if (BrowserView.this.f13706d == null || !BrowserView.this.f13706d.canGoBack()) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    item3.setEnabled(z4);
                    View item4 = BrowserView.this.f13708f.getItem(ToolBar.FORWARD);
                    if (BrowserView.this.f13706d != null && BrowserView.this.f13706d.canGoForward()) {
                        z5 = true;
                    }
                    item4.setEnabled(z5);
                    if (BrowserView.this.f13706d != null) {
                        BrowserView.this.f13706d.loadUrl(BrowserView.this.f13704b);
                    }
                } else if (TextUtils.equals(str, ToolBar.EXITS) && BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.a();
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f13706d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f13705c = aVar;
    }

    public void setWebView(WebView webView) {
        this.f13706d = webView;
    }

    private WebView a() {
        WebChromeClient webChromeClient;
        WebSettings settings;
        WebView webView = new WebView(getContext());
        try {
            settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
        } catch (Throwable th) {
            af.b("BrowserView", th.getMessage());
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        try {
            settings.setMixedContentMode(0);
        } catch (Exception e5) {
            af.b("BrowserView", e5.getMessage());
        }
        settings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        Class<WebSettings> cls = WebSettings.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, new Object[]{Boolean.FALSE});
        } catch (Exception e6) {
            af.b("BrowserView", e6.getMessage());
        }
        webView.setDownloadListener(new com.mbridge.msdk.foundation.same.g.a(this.f13703a));
        webView.setWebViewClient(new WebViewClient() {
            public final void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                af.c("BrowserView", "onLoadResource 开始! = " + str);
                if (BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.a(webView, str);
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                if (BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.c(webView, str);
                }
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                af.c("BrowserView", "开始! = " + str);
                String unused = BrowserView.this.f13704b = str;
                if (BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.a(webView, str, bitmap);
                }
                BrowserView.this.f13707e.setVisible(true);
                BrowserView.this.f13707e.setProgressState(5);
            }

            public final void onReceivedError(WebView webView, int i4, String str, String str2) {
                if (BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.a(webView, i4, str, str2);
                }
            }

            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (webView != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView);
                        }
                        webView.destroy();
                    } catch (Throwable th) {
                        af.b("BrowserView", th.getMessage());
                        return true;
                    }
                }
                if (BrowserView.this.f13705c != null) {
                    BrowserView.this.f13705c.a();
                }
                return true;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                af.c("BrowserView", "js大跳! = " + str);
                BrowserView.this.f13708f.getItem(ToolBar.BACKWARD).setEnabled(true);
                BrowserView.this.f13708f.getItem(ToolBar.FORWARD).setEnabled(false);
                if (BrowserView.this.f13705c != null) {
                    return BrowserView.this.f13705c.b(webView, str);
                }
                return false;
            }
        });
        if (ab.s() <= 10) {
            webChromeClient = new WebChromeClient() {
                public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                    return true;
                }

                public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                    return true;
                }

                public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    return true;
                }

                public final void onProgressChanged(WebView webView, int i4) {
                    if (i4 == 100) {
                        BrowserView.this.f13707e.setProgressState(7);
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                BrowserView.this.f13707e.setVisible(false);
                            }
                        }, 200);
                    }
                }
            };
        } else {
            webChromeClient = new WebChromeClient() {
                public final void onProgressChanged(WebView webView, int i4) {
                    if (i4 == 100) {
                        BrowserView.this.f13707e.setProgressState(7);
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                BrowserView.this.f13707e.setVisible(false);
                            }
                        }, 200);
                    }
                }
            };
        }
        webView.setWebChromeClient(webChromeClient);
        return webView;
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
