package q1;

import java.net.URL;
import org.json.JSONObject;
import w1.C2336c;
import w1.C2340g;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final String f21561a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f21562b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21563c;

    private m(String str, URL url, String str2) {
        this.f21561a = str;
        this.f21562b = url;
        this.f21563c = str2;
    }

    public static m a(String str, URL url, String str2) {
        C2340g.d(str, "VendorKey is null or empty");
        C2340g.b(url, "ResourceURL is null");
        C2340g.d(str2, "VerificationParameters is null or empty");
        return new m(str, url, str2);
    }

    public static m b(URL url) {
        C2340g.b(url, "ResourceURL is null");
        return new m((String) null, url, (String) null);
    }

    public URL c() {
        return this.f21562b;
    }

    public String d() {
        return this.f21561a;
    }

    public String e() {
        return this.f21563c;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, "vendorKey", this.f21561a);
        C2336c.g(jSONObject, "resourceUrl", this.f21562b.toString());
        C2336c.g(jSONObject, "verificationParameters", this.f21563c);
        return jSONObject;
    }
}
