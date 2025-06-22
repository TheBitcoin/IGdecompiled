package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollapsibleWebView extends CommonWebView {

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f14055e;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<CommonWebView.a> f14056f;

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f14057g;

    /* renamed from: h  reason: collision with root package name */
    private String f14058h;

    /* renamed from: i  reason: collision with root package name */
    private String f14059i;

    public interface a {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f14055e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f14056f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public String getCollapseIconName() {
        return this.f14058h;
    }

    public String getExpandIconName() {
        return this.f14059i;
    }

    public void init() {
        super.init();
        this.f14055e = new CopyOnWriteArrayList<>();
        this.f14056f = new CopyOnWriteArrayList<>();
        this.f14057g = new CopyOnWriteArrayList<>();
        this.f14058h = "mbridge_arrow_down_white_blackbg";
        this.f14059i = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList arrayList = new ArrayList();
        ToolBar.b bVar = new ToolBar.b("doCollapse");
        bVar.f14100c = false;
        bVar.f14099b = "mbridge_arrow_down_white_blackbg";
        bVar.f14101d = new View.OnClickListener() {
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doCollapse");
                CollapsibleWebView.this.showToolBarButton("doSpand");
                CollapsibleWebView.a(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar);
        ToolBar.b bVar2 = new ToolBar.b("doSpand");
        bVar2.f14099b = "mbridge_arrow_up_black";
        bVar2.f14101d = new View.OnClickListener() {
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doSpand");
                CollapsibleWebView.this.showToolBarButton("doCollapse");
                CollapsibleWebView.b(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar2);
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new CommonWebView.b() {
            public final void a(String str) {
                CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
                CollapsibleWebView.a(collapsibleWebView, (View) collapsibleWebView.f14069d, str);
            }
        });
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new WebViewClient() {

            /* renamed from: a  reason: collision with root package name */
            Boolean f14063a = Boolean.FALSE;

            /* renamed from: b  reason: collision with root package name */
            String f14064b = "";

            public final void onPageFinished(WebView webView, String str) {
                if (!this.f14063a.booleanValue()) {
                    CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, str);
                    this.f14063a = Boolean.FALSE;
                }
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (!TextUtils.isEmpty(str)) {
                    this.f14064b = str;
                }
            }

            public final void onReceivedError(WebView webView, int i4, String str, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                hashMap.put("url", str2);
                hashMap.put("description", str);
                if (!this.f14063a.booleanValue() && this.f14064b.equals(str2)) {
                    this.f14063a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "http");
                String str = webResourceRequest.getUrl() + "";
                hashMap.put("url", str);
                hashMap.put("statusCode", webResourceResponse.getStatusCode() + "");
                hashMap.put("description", "http error");
                if (!this.f14063a.booleanValue() && (this.f14064b.equals(str) || TextUtils.isEmpty(this.f14064b))) {
                    this.f14063a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "ssl");
                hashMap.put("url", sslError.getUrl());
                hashMap.put("description", "ssl error");
                if (!this.f14063a.booleanValue()) {
                    String str = this.f14064b;
                    if (str.equals(sslError.getUrl() + "")) {
                        this.f14063a = Boolean.TRUE;
                        CollapsibleWebView.a(CollapsibleWebView.this, (View) webView, (Map) hashMap);
                    }
                }
                CollapsibleWebView.b(CollapsibleWebView.this, (View) webView, (Map) hashMap);
            }

            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                af.b("CollapsibleWebView", "WebView called onRenderProcessGone");
                return true;
            }
        });
    }

    public void setCollapseIconName(String str) {
        this.f14058h = str;
    }

    public void setCollapseListener(CommonWebView.a aVar) {
        this.f14055e.add(aVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i4, int i5, int i6, int i7) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f14066a.getLayoutParams();
        layoutParams.setMargins(i4, i5, i6, i7);
        this.f14066a.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.f14059i = str;
    }

    public void setExpandListener(CommonWebView.a aVar) {
        this.f14056f.add(aVar);
    }

    public void setPageLoadListener(a aVar) {
        this.f14057g.add(aVar);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f14057g.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.f14057g.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f14057g.iterator();
        while (it.hasNext()) {
            it.next().a(view, (Map<String, String>) map);
        }
    }

    static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.f14057g.iterator();
        while (it.hasNext()) {
            it.next().b(view, (Map<String, String>) map);
        }
    }
}
