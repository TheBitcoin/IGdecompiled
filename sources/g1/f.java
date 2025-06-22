package G1;

import C1.e;
import D1.c;
import S2.C1601o;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import d3.l;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;

final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final WebView f6585a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6586b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Set f6587c = new LinkedHashSet();

    public f(WebView webView) {
        m.e(webView, "webView");
        this.f6585a = webView;
    }

    private final void i(WebView webView, String str, Object... objArr) {
        String str2;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof String) {
                StringBuilder sb = new StringBuilder();
                sb.append('\'');
                sb.append(obj);
                sb.append('\'');
                str2 = sb.toString();
            } else {
                str2 = obj.toString();
            }
            arrayList.add(str2);
        }
        this.f6586b.post(new e(webView, str, arrayList));
    }

    /* access modifiers changed from: private */
    public static final void j(WebView webView, String str, List list) {
        m.e(webView, "$this_invoke");
        m.e(str, "$function");
        m.e(list, "$stringArgs");
        webView.loadUrl("javascript:" + str + '(' + C1601o.O(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null) + ')');
    }

    public boolean a(c cVar) {
        m.e(cVar, "listener");
        return this.f6587c.remove(cVar);
    }

    public void b() {
        i(this.f6585a, "toggleFullscreen", new Object[0]);
    }

    public void c(String str, float f4) {
        m.e(str, "videoId");
        i(this.f6585a, "cueVideo", str, Float.valueOf(f4));
    }

    public boolean d(c cVar) {
        m.e(cVar, "listener");
        return this.f6587c.add(cVar);
    }

    public void e(String str, float f4) {
        m.e(str, "videoId");
        i(this.f6585a, "loadVideo", str, Float.valueOf(f4));
    }

    public void f() {
        i(this.f6585a, CampaignEx.JSON_NATIVE_VIDEO_MUTE, new Object[0]);
    }

    public final Set h() {
        return this.f6587c;
    }

    public final void k() {
        this.f6587c.clear();
        this.f6586b.removeCallbacksAndMessages((Object) null);
    }

    public void pause() {
        i(this.f6585a, "pauseVideo", new Object[0]);
    }

    public void play() {
        i(this.f6585a, "playVideo", new Object[0]);
    }
}
