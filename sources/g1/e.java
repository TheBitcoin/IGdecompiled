package G1;

import android.webkit.WebView;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebView f6582a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f6583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f6584c;

    public /* synthetic */ e(WebView webView, String str, List list) {
        this.f6582a = webView;
        this.f6583b = str;
        this.f6584c = list;
    }

    public final void run() {
        f.j(this.f6582a, this.f6583b, this.f6584c);
    }
}
