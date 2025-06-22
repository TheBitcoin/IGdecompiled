package G1;

import C1.e;
import C1.q;
import D1.b;
import S2.C1601o;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import d3.l;
import java.io.InputStream;
import java.util.Collection;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class c extends WebView implements q.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f6576a;

    /* renamed from: b  reason: collision with root package name */
    private final f f6577b;

    /* renamed from: c  reason: collision with root package name */
    private l f6578c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6579d;

    public static final class a extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f6580a;

        /* renamed from: G1.c$a$a  reason: collision with other inner class name */
        static final class C0086a extends n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ WebChromeClient.CustomViewCallback f6581a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0086a(WebChromeClient.CustomViewCallback customViewCallback) {
                super(0);
                this.f6581a = customViewCallback;
            }

            public final void invoke() {
                this.f6581a.onCustomViewHidden();
            }
        }

        a(c cVar) {
            this.f6580a = cVar;
        }

        public Bitmap getDefaultVideoPoster() {
            Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
            if (defaultVideoPoster == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            }
            return defaultVideoPoster;
        }

        public void onHideCustomView() {
            super.onHideCustomView();
            this.f6580a.f6576a.onExitFullscreen();
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            m.e(customViewCallback, "callback");
            super.onShowCustomView(view, customViewCallback);
            this.f6580a.f6576a.a(view, new C0086a(customViewCallback));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Context context, b bVar, AttributeSet attributeSet, int i4, int i5, C2103g gVar) {
        this(context, bVar, (i5 & 4) != 0 ? null : attributeSet, (i5 & 8) != 0 ? 0 : i4);
    }

    private final void d(E1.a aVar, String str) {
        String str2;
        String str3 = str;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(-1);
        addJavascriptInterface(new q(this), "YouTubePlayerBridge");
        InputStream openRawResource = getResources().openRawResource(B1.a.ayp_youtube_player);
        m.d(openRawResource, "resources.openRawResourc…R.raw.ayp_youtube_player)");
        String a5 = d.a(openRawResource);
        if (str3 != null) {
            str2 = '\'' + str3 + '\'';
        } else {
            str2 = "undefined";
        }
        loadDataWithBaseURL(aVar.b(), m3.m.w(m3.m.w(a5, "<<injectedVideoId>>", str2, false, 4, (Object) null), "<<injectedPlayerVars>>", aVar.toString(), false, 4, (Object) null), "text/html", "utf-8", (String) null);
        setWebChromeClient(new a(this));
    }

    public void a() {
        l lVar = this.f6578c;
        if (lVar == null) {
            m.u("youTubePlayerInitListener");
            lVar = null;
        }
        lVar.invoke(this.f6577b);
    }

    public final boolean c(D1.c cVar) {
        m.e(cVar, "listener");
        return this.f6577b.h().add(cVar);
    }

    public void destroy() {
        this.f6577b.k();
        super.destroy();
    }

    public final void e(l lVar, E1.a aVar, String str) {
        m.e(lVar, "initListener");
        this.f6578c = lVar;
        if (aVar == null) {
            aVar = E1.a.f6312b.a();
        }
        d(aVar, str);
    }

    public final boolean f() {
        return this.f6579d;
    }

    public e getInstance() {
        return this.f6577b;
    }

    public Collection<D1.c> getListeners() {
        return C1601o.d0(this.f6577b.h());
    }

    public final e getYoutubePlayer$core_release() {
        return this.f6577b;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i4) {
        if (!this.f6579d || !(i4 == 8 || i4 == 4)) {
            super.onWindowVisibilityChanged(i4);
        }
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z4) {
        this.f6579d = z4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, b bVar, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
        m.e(bVar, "listener");
        this.f6576a = bVar;
        this.f6577b = new f(this);
    }
}
