package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.List;

public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* renamed from: a  reason: collision with root package name */
    protected ToolBar f14066a;

    /* renamed from: b  reason: collision with root package name */
    protected ToolBar f14067b;

    /* renamed from: c  reason: collision with root package name */
    protected ProgressBar f14068c;

    /* renamed from: d  reason: collision with root package name */
    protected BaseWebView f14069d;

    /* renamed from: e  reason: collision with root package name */
    private int f14070e;

    /* renamed from: f  reason: collision with root package name */
    private int f14071f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f14072g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f14073h;

    /* renamed from: i  reason: collision with root package name */
    private b f14074i;

    /* renamed from: j  reason: collision with root package name */
    private a f14075j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f14076k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public View.OnClickListener f14077l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public View.OnClickListener f14078m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public View.OnClickListener f14079n;

    /* renamed from: o  reason: collision with root package name */
    private Handler f14080o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f14081p;

    /* renamed from: q  reason: collision with root package name */
    private WebViewClient f14082q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public String f14083r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public b f14084s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f14085t;

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f14086u = new Runnable() {
        public final void run() {
            af.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f14081p + "ms");
            if (CommonWebView.this.f14084s != null) {
                boolean unused = CommonWebView.this.f14085t = false;
                CommonWebView.this.f14084s.a(CommonWebView.this.f14083r);
            }
        }
    };

    public interface a {
        void a();
    }

    public interface b {
        void a(String str);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init();
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.f14075j.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.f14074i.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        View view;
        ToolBar toolBar;
        ToolBar toolBar2 = this.f14066a;
        if (toolBar2 != null) {
            view = toolBar2.getItem(str);
        } else {
            view = null;
        }
        if (view != null || (toolBar = this.f14067b) == null) {
            return view;
        }
        return toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.f14069d;
        if (baseWebView == null) {
            return "";
        }
        return baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.f14069d;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.f14066a;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.f14067b;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.f14066a.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f14072g = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f14072g, layoutParams);
        this.f14070e = ak.a(getContext(), 40.0f);
        this.f14071f = ak.a(getContext(), 40.0f);
        this.f14074i = new b();
        this.f14075j = new a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.f14069d == null) {
                this.f14069d = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.f14069d.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.f14069d;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.f14074i);
            this.f14069d.setWebChromeClient(this.f14075j);
            addWebViewClient(bVar);
        } catch (Throwable th) {
            af.b("CommonWebView", "webview is error", th);
        }
        this.f14072g.addView(this.f14069d);
    }

    public void loadUrl(String str) {
        this.f14069d.loadUrl(str);
        if (this.f14082q != null) {
            a();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.f14076k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.f14077l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.f14079n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.f14078m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.f14075j.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.f14074i.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.f14066a.getParent()).removeView(this.f14066a);
        this.f14072g.addView(this.f14066a);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.f14066a.getParent()).removeView(this.f14066a);
        addView(this.f14066a, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.f14073h = onClickListener;
    }

    public void setPageLoadTimtout(int i4) {
        this.f14081p = i4;
        if (this.f14080o == null) {
            this.f14080o = new Handler(Looper.getMainLooper());
        }
        if (this.f14082q == null) {
            AnonymousClass7 r22 = new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                    boolean unused = CommonWebView.this.f14085t = false;
                    CommonWebView.this.f14080o.removeCallbacks(CommonWebView.this.f14086u);
                }

                public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    String unused = CommonWebView.this.f14083r = str;
                    if (!CommonWebView.this.f14085t) {
                        boolean unused2 = CommonWebView.this.f14085t = true;
                        CommonWebView.this.a();
                    }
                }

                public final void onReceivedError(WebView webView, int i4, String str, String str2) {
                    boolean unused = CommonWebView.this.f14085t = false;
                    CommonWebView.this.f14080o.removeCallbacks(CommonWebView.this.f14086u);
                }

                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    String unused = CommonWebView.this.f14083r = str;
                    if (CommonWebView.this.f14085t) {
                        CommonWebView.this.f14080o.removeCallbacks(CommonWebView.this.f14086u);
                    }
                    boolean unused2 = CommonWebView.this.f14085t = true;
                    CommonWebView.this.a();
                    return false;
                }
            };
            this.f14082q = r22;
            addWebViewClient(r22);
        }
    }

    public void setPageLoadTimtoutListener(b bVar) {
        this.f14084s = bVar;
    }

    public void setToolBarTitle(String str, int i4) {
        this.f14066a.setTitle(str, i4);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.f14066a;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.f14067b;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View findToolBarButton = findToolBarButton(str);
        if (findToolBarButton != null) {
            findToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.f14066a.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z4) {
        a(arrayList, z4);
    }

    public void useDeeplink() {
        addWebViewClient(new WebViewClient() {
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (aj.a.b(str)) {
                    aj.a.a(CommonWebView.this.getContext(), str, (NativeListener.NativeTrackingListener) null);
                }
                return CommonWebView.this.a(webView, str);
            }
        });
    }

    public void useDefaultToolBar() {
        if (this.f14067b == null) {
            this.f14067b = new ToolBar(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f14071f);
            layoutParams.bottomMargin = 0;
            this.f14067b.setLayoutParams(layoutParams);
            this.f14067b.setBackgroundColor(-1);
            this.f14067b.setOnItemClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BaseWebView baseWebView = CommonWebView.this.f14069d;
                    if (baseWebView != null) {
                        baseWebView.stopLoading();
                        String str = (String) view.getTag();
                        if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                            CommonWebView.this.f14067b.getItem(ToolBar.FORWARD).setEnabled(true);
                            if (CommonWebView.this.f14069d.canGoBack()) {
                                CommonWebView.this.f14069d.goBack();
                            }
                            CommonWebView.this.f14067b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f14069d.canGoBack());
                            if (CommonWebView.this.f14076k != null) {
                                CommonWebView.this.f14076k.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.FORWARD)) {
                            CommonWebView.this.f14067b.getItem(ToolBar.BACKWARD).setEnabled(true);
                            if (CommonWebView.this.f14069d.canGoForward()) {
                                CommonWebView.this.f14069d.goForward();
                            }
                            CommonWebView.this.f14067b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f14069d.canGoForward());
                            if (CommonWebView.this.f14077l != null) {
                                CommonWebView.this.f14077l.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.REFRESH)) {
                            CommonWebView.this.f14067b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f14069d.canGoBack());
                            CommonWebView.this.f14067b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f14069d.canGoForward());
                            CommonWebView.this.f14069d.reload();
                            if (CommonWebView.this.f14078m != null) {
                                CommonWebView.this.f14078m.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.EXITS)) {
                            if (CommonWebView.this.f14073h != null) {
                                CommonWebView.this.f14073h.onClick(view);
                            }
                        } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                            if (CommonWebView.this.f14079n != null) {
                                CommonWebView.this.f14079n.onClick(view);
                            }
                            c.d(CommonWebView.this.getContext(), CommonWebView.this.f14069d.getUrl());
                        }
                    }
                }
            });
            addWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CommonWebView.this.f14067b.getItem(ToolBar.BACKWARD).setEnabled(true);
                    CommonWebView.this.f14067b.getItem(ToolBar.FORWARD).setEnabled(false);
                    return false;
                }
            });
            addView(this.f14067b);
        }
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f14068c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                af.c("CommonWebView", "newProgress! 开始! = " + str);
                CommonWebView.this.f14068c.setVisible(true);
                CommonWebView.this.f14068c.setProgressState(5);
            }
        });
        addWebChromeClient(new WebChromeClient() {
            public final void onProgressChanged(WebView webView, int i4) {
                af.c("CommonWebView", "newProgress! = " + i4);
                if (i4 == 100) {
                    CommonWebView.this.f14068c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            CommonWebView.this.f14068c.setVisible(false);
                        }
                    }, 200);
                }
            }
        });
        addView(this.f14068c);
        this.f14068c.initResource(true);
    }

    public void setToolBarTitle(String str) {
        this.f14066a.setTitle(str);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z4) {
        if (this.f14066a == null) {
            ToolBar.a aVar = new ToolBar.a();
            aVar.f14097a = 40;
            ToolBar.a.f14095b = 80;
            ToolBar toolBar = new ToolBar(getContext(), aVar, (List<ToolBar.b>) arrayList);
            this.f14066a = toolBar;
            toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
            if (z4) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f14070e);
                layoutParams.addRule(10);
                this.f14066a.setLayoutParams(layoutParams);
                this.f14072g.addView(this.f14066a);
                return;
            }
            this.f14066a.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f14070e));
            addView(this.f14066a, 0);
        }
    }

    public CommonWebView(Context context) {
        super(context);
        init();
    }

    /* access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        boolean z4 = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setComponent((ComponentName) null);
                            parseUri.setSelector((Intent) null);
                            parseUri.setFlags(268435456);
                            getContext().startActivity(parseUri);
                            return true;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (!parse2.getScheme().equals("http")) {
                                    if (!parse2.getScheme().equals("https")) {
                                        str = stringExtra;
                                    }
                                }
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                        } catch (Throwable th) {
                            af.b("CommonWebView", th.getMessage());
                        }
                    }
                    if (c.e(getContext(), str)) {
                        af.b("CommonWebView", "openDeepLink");
                        return true;
                    } else if (!TextUtils.isEmpty(str)) {
                        if (str.startsWith("http") || str.startsWith("https")) {
                            z4 = true;
                        }
                        return !z4;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            af.b("CommonWebView", th2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f14080o.postDelayed(this.f14086u, (long) this.f14081p);
    }
}
