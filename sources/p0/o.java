package p0;

import M.C0333n;
import M.C0335p;
import M.C0337s;
import R.n;
import android.content.Context;
import android.text.TextUtils;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final String f21452a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21453b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21454c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21455d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21456e;

    /* renamed from: f  reason: collision with root package name */
    private final String f21457f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21458g;

    private o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C0335p.p(!n.a(str), "ApplicationId must be set.");
        this.f21453b = str;
        this.f21452a = str2;
        this.f21454c = str3;
        this.f21455d = str4;
        this.f21456e = str5;
        this.f21457f = str6;
        this.f21458g = str7;
    }

    public static o a(Context context) {
        C0337s sVar = new C0337s(context);
        String a5 = sVar.a("google_app_id");
        if (TextUtils.isEmpty(a5)) {
            return null;
        }
        return new o(a5, sVar.a("google_api_key"), sVar.a("firebase_database_url"), sVar.a("ga_trackingId"), sVar.a("gcm_defaultSenderId"), sVar.a("google_storage_bucket"), sVar.a("project_id"));
    }

    public String b() {
        return this.f21452a;
    }

    public String c() {
        return this.f21453b;
    }

    public String d() {
        return this.f21456e;
    }

    public String e() {
        return this.f21458g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!C0333n.a(this.f21453b, oVar.f21453b) || !C0333n.a(this.f21452a, oVar.f21452a) || !C0333n.a(this.f21454c, oVar.f21454c) || !C0333n.a(this.f21455d, oVar.f21455d) || !C0333n.a(this.f21456e, oVar.f21456e) || !C0333n.a(this.f21457f, oVar.f21457f) || !C0333n.a(this.f21458g, oVar.f21458g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C0333n.b(this.f21453b, this.f21452a, this.f21454c, this.f21455d, this.f21456e, this.f21457f, this.f21458g);
    }

    public String toString() {
        return C0333n.c(this).a("applicationId", this.f21453b).a("apiKey", this.f21452a).a("databaseUrl", this.f21454c).a("gcmSenderId", this.f21456e).a("storageBucket", this.f21457f).a("projectId", this.f21458g).toString();
    }
}
