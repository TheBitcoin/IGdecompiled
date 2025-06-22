package G0;

import D0.C1292a;
import D0.b;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.Command;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import v0.g;
import y0.C2433x;
import z0.C2446g;

class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f6518a;

    /* renamed from: b  reason: collision with root package name */
    private final b f6519b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6520c;

    public c(String str, b bVar) {
        this(str, bVar, g.f());
    }

    private C1292a b(C1292a aVar, k kVar) {
        c(aVar, "X-CRASHLYTICS-GOOGLE-APP-ID", kVar.f6551a);
        c(aVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        c(aVar, "X-CRASHLYTICS-API-CLIENT-VERSION", C2433x.k());
        c(aVar, "Accept", "application/json");
        c(aVar, "X-CRASHLYTICS-DEVICE-MODEL", kVar.f6552b);
        c(aVar, "X-CRASHLYTICS-OS-BUILD-VERSION", kVar.f6553c);
        c(aVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", kVar.f6554d);
        c(aVar, "X-CRASHLYTICS-INSTALLATION-ID", kVar.f6555e.a().c());
        return aVar;
    }

    private void c(C1292a aVar, String str, String str2) {
        if (str2 != null) {
            aVar.d(str, str2);
        }
    }

    private JSONObject e(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e5) {
            g gVar = this.f6520c;
            gVar.l("Failed to parse settings JSON from " + this.f6518a, e5);
            g gVar2 = this.f6520c;
            gVar2.k("Settings response " + str);
            return null;
        }
    }

    private Map f(k kVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", kVar.f6558h);
        hashMap.put("display_version", kVar.f6557g);
        hashMap.put("source", Integer.toString(kVar.f6559i));
        String str = kVar.f6556f;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    public JSONObject a(k kVar, boolean z4) {
        C2446g.d();
        if (z4) {
            try {
                Map f4 = f(kVar);
                C1292a b5 = b(d(f4), kVar);
                g gVar = this.f6520c;
                gVar.b("Requesting settings from " + this.f6518a);
                g gVar2 = this.f6520c;
                gVar2.i("Settings query params were: " + f4);
                return g(b5.c());
            } catch (IOException e5) {
                this.f6520c.e("Settings request failed.", e5);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }

    /* access modifiers changed from: protected */
    public C1292a d(Map map) {
        C1292a a5 = this.f6519b.a(this.f6518a, map);
        return a5.d(Command.HTTP_HEADER_USER_AGENT, "Crashlytics Android SDK/" + C2433x.k()).d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* access modifiers changed from: package-private */
    public JSONObject g(D0.c cVar) {
        int b5 = cVar.b();
        g gVar = this.f6520c;
        gVar.i("Settings response code was: " + b5);
        if (h(b5)) {
            return e(cVar.a());
        }
        g gVar2 = this.f6520c;
        gVar2.d("Settings request failed; (status: " + b5 + ") from " + this.f6518a);
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean h(int i4) {
        if (i4 == 200 || i4 == 201 || i4 == 202 || i4 == 203) {
            return true;
        }
        return false;
    }

    c(String str, b bVar, g gVar) {
        if (str != null) {
            this.f6520c = gVar;
            this.f6519b = bVar;
            this.f6518a = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
