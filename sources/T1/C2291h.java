package t1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;
import w1.C2337d;

/* renamed from: t1.h  reason: case insensitive filesystem */
public class C2291h {

    /* renamed from: a  reason: collision with root package name */
    private static C2291h f21804a = new C2291h();

    /* renamed from: t1.h$a */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f21805a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21806b;

        a(WebView webView, String str) {
            this.f21805a = webView;
            this.f21806b = str;
        }

        public void run() {
            C2291h.this.p(this.f21805a, this.f21806b);
        }
    }

    private C2291h() {
    }

    public static final C2291h a() {
        return f21804a;
    }

    public void b(WebView webView, String str) {
        h(webView, "finishSession", str);
    }

    public void c(WebView webView, String str, float f4) {
        h(webView, "setDeviceVolume", Float.valueOf(f4), str);
    }

    public void d(WebView webView, String str, String str2) {
        h(webView, "setDeviceLockState", str2);
    }

    public void e(WebView webView, String str, String str2, JSONObject jSONObject) {
        h(webView, "publishMediaEvent", str2, jSONObject, str);
    }

    public void f(WebView webView, String str, JSONObject jSONObject) {
        h(webView, "init", jSONObject, str);
    }

    public void g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    public void h(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            k(sb, objArr);
            sb.append(")}");
            i(webView, sb);
            return;
        }
        C2337d.a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    public void i(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            p(webView, sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    public void j(WebView webView, JSONObject jSONObject) {
        h(webView, "setLastActivity", jSONObject);
    }

    /* access modifiers changed from: package-private */
    public void k(StringBuilder sb, Object[] objArr) {
        String obj;
        if (objArr != null && objArr.length > 0) {
            for (Object obj2 : objArr) {
                if (obj2 == null) {
                    obj = "null";
                } else {
                    if (obj2 instanceof String) {
                        obj = obj2.toString();
                        if (!obj.startsWith("{")) {
                            sb.append('\"');
                            sb.append(obj);
                            sb.append('\"');
                        }
                    } else {
                        sb.append(obj2);
                    }
                    sb.append(",");
                }
                sb.append(obj);
                sb.append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

    public void l(WebView webView, String str) {
        h(webView, "publishImpressionEvent", str);
    }

    public void m(WebView webView, String str, String str2) {
        h(webView, "setNativeViewHierarchy", str2, str);
    }

    public void n(WebView webView, String str, JSONObject jSONObject) {
        h(webView, "publishLoadedEvent", jSONObject, str);
    }

    public void o(WebView webView, String str, String str2) {
        h(webView, "setState", str2, str);
    }

    public boolean p(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: " + str);
            return true;
        }
    }

    public void q(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            p(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }
}
