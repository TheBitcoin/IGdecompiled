package q1;

import android.webkit.WebView;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import w1.C2340g;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final l f21511a;

    /* renamed from: b  reason: collision with root package name */
    private final WebView f21512b;

    /* renamed from: c  reason: collision with root package name */
    private final List f21513c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f21514d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final String f21515e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21516f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21517g;

    /* renamed from: h  reason: collision with root package name */
    private final e f21518h;

    private d(l lVar, WebView webView, String str, List list, String str2, String str3, e eVar) {
        ArrayList arrayList = new ArrayList();
        this.f21513c = arrayList;
        this.f21511a = lVar;
        this.f21512b = webView;
        this.f21515e = str;
        this.f21518h = eVar;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String uuid = UUID.randomUUID().toString();
                this.f21514d.put(uuid, (m) it.next());
            }
        }
        this.f21517g = str2;
        this.f21516f = str3;
    }

    public static d a(l lVar, WebView webView, String str, String str2) {
        C2340g.b(lVar, "Partner is null");
        C2340g.b(webView, "WebView is null");
        if (str2 != null) {
            C2340g.c(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(lVar, webView, (String) null, (List) null, str, str2, e.HTML);
    }

    public static d b(l lVar, String str, List list, String str2, String str3) {
        C2340g.b(lVar, "Partner is null");
        C2340g.b(str, "OM SDK JS script content is null");
        C2340g.b(list, "VerificationScriptResources is null");
        if (str3 != null) {
            C2340g.c(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new d(lVar, (WebView) null, str, list, str2, str3, e.NATIVE);
    }

    public e c() {
        return this.f21518h;
    }

    public String d() {
        return this.f21517g;
    }

    public String e() {
        return this.f21516f;
    }

    public Map f() {
        return DesugarCollections.unmodifiableMap(this.f21514d);
    }

    public String g() {
        return this.f21515e;
    }

    public l h() {
        return this.f21511a;
    }

    public List i() {
        return DesugarCollections.unmodifiableList(this.f21513c);
    }

    public WebView j() {
        return this.f21512b;
    }
}
