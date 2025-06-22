package y0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.List;
import v0.f;

/* renamed from: y0.b  reason: case insensitive filesystem */
public class C2412b {

    /* renamed from: a  reason: collision with root package name */
    public final String f22618a;

    /* renamed from: b  reason: collision with root package name */
    public final String f22619b;

    /* renamed from: c  reason: collision with root package name */
    public final List f22620c;

    /* renamed from: d  reason: collision with root package name */
    public final String f22621d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22622e;

    /* renamed from: f  reason: collision with root package name */
    public final String f22623f;

    /* renamed from: g  reason: collision with root package name */
    public final String f22624g;

    /* renamed from: h  reason: collision with root package name */
    public final f f22625h;

    public C2412b(String str, String str2, List list, String str3, String str4, String str5, String str6, f fVar) {
        this.f22618a = str;
        this.f22619b = str2;
        this.f22620c = list;
        this.f22621d = str3;
        this.f22622e = str4;
        this.f22623f = str5;
        this.f22624g = str6;
        this.f22625h = fVar;
    }

    public static C2412b a(Context context, I i4, String str, String str2, List list, f fVar) {
        String packageName = context.getPackageName();
        String g4 = i4.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b5 = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new C2412b(str, str2, list, g4, packageName, b5, str3, fVar);
    }

    private static String b(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return Integer.toString(packageInfo.versionCode);
    }
}
