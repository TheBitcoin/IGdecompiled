package k2;

import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.m;
import l2.k;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f20948a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20949b;

    /* renamed from: c  reason: collision with root package name */
    public final String f20950c;

    /* renamed from: d  reason: collision with root package name */
    public final String f20951d;

    /* renamed from: e  reason: collision with root package name */
    public final String f20952e = "116";

    public b(Context context) {
        m.e(context, "context");
        String packageName = context.getPackageName();
        m.d(packageName, "context.packageName");
        this.f20948a = packageName;
        k kVar = k.f21023a;
        PackageManager packageManager = context.getPackageManager();
        m.d(packageManager, "context.packageManager");
        this.f20949b = kVar.b(packageManager, packageName);
        this.f20950c = String.valueOf(kVar.d(context));
        this.f20951d = kVar.f(context);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", this.f20948a);
        String str = this.f20951d;
        if (str != null) {
            jSONObject.put("version", str);
        }
        jSONObject.put("uptodownSDKVersion", this.f20952e);
        jSONObject.put("versionCode", this.f20950c);
        String str2 = this.f20949b;
        if (str2 != null) {
            jSONObject.put("md5Signature", str2);
        }
        return jSONObject;
    }
}
