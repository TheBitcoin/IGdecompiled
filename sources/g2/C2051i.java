package g2;

import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.i  reason: case insensitive filesystem */
public final class C2051i {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20680f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20681a;

    /* renamed from: b  reason: collision with root package name */
    private String f20682b;

    /* renamed from: c  reason: collision with root package name */
    private int f20683c;

    /* renamed from: d  reason: collision with root package name */
    private String f20684d;

    /* renamed from: e  reason: collision with root package name */
    private int f20685e;

    /* renamed from: g2.i$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C2051i a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectData");
            C2051i iVar = new C2051i();
            iVar.f(jSONObject);
            return iVar;
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public final void f(JSONObject jSONObject) {
        if (!jSONObject.isNull("id")) {
            this.f20681a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("sha256")) {
            this.f20682b = jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("active")) {
            this.f20683c = jSONObject.optInt("active");
        }
        if (!jSONObject.isNull("url")) {
            this.f20684d = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("isTurbo")) {
            this.f20685e = jSONObject.optInt("isTurbo");
        }
    }

    public final int b() {
        return this.f20683c;
    }

    public final String c() {
        if (this.f20684d == null) {
            return null;
        }
        return this.f20684d + UptodownApp.f17422D.q() + ":webp";
    }

    public final long d() {
        return this.f20681a;
    }

    public final String e() {
        return this.f20684d;
    }
}
