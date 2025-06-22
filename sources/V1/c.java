package v1;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import q1.d;
import q1.m;
import q1.n;
import t1.C2290g;
import t1.C2291h;
import w1.C2336c;
import w1.C2339f;

public class c extends C2329a {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public WebView f21991g;

    /* renamed from: h  reason: collision with root package name */
    private Long f21992h = null;

    /* renamed from: i  reason: collision with root package name */
    private final Map f21993i;

    /* renamed from: j  reason: collision with root package name */
    private final String f21994j;

    class a extends WebViewClient {
        a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (c.this.w() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                c.this.c((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WebView f21996a;

        b() {
            this.f21996a = c.this.f21991g;
        }

        public void run() {
            this.f21996a.destroy();
        }
    }

    public c(String str, Map map, String str2) {
        super(str);
        this.f21993i = map;
        this.f21994j = str2;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        WebView webView = new WebView(C2290g.c().a());
        this.f21991g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f21991g.getSettings().setAllowContentAccess(false);
        this.f21991g.getSettings().setAllowFileAccess(false);
        this.f21991g.setWebViewClient(new a());
        c(this.f21991g);
        C2291h.a().p(this.f21991g, this.f21994j);
        for (String str : this.f21993i.keySet()) {
            C2291h.a().q(this.f21991g, ((m) this.f21993i.get(str)).c().toExternalForm(), str);
        }
        this.f21992h = Long.valueOf(C2339f.b());
    }

    public void k(n nVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map f4 = dVar.f();
        for (String str : f4.keySet()) {
            C2336c.g(jSONObject, str, ((m) f4.get(str)).f());
        }
        l(nVar, dVar, jSONObject);
    }

    public void o() {
        long j4;
        super.o();
        if (this.f21992h == null) {
            j4 = 4000;
        } else {
            j4 = TimeUnit.MILLISECONDS.convert(C2339f.b() - this.f21992h.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new b(), Math.max(4000 - j4, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.f21991g = null;
    }

    public void y() {
        super.y();
        A();
    }
}
