package N1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import kotlin.jvm.internal.m;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7777a;

    public j(Context context) {
        m.e(context, "context");
        this.f7777a = context;
    }

    public static /* synthetic */ void e(j jVar, Uri uri, String str, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        if ((i4 & 8) != 0) {
            z5 = false;
        }
        jVar.b(uri, str, z4, z5);
    }

    public static /* synthetic */ void f(j jVar, File file, String str, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        jVar.c(file, str, z4);
    }

    public static /* synthetic */ void g(j jVar, String str, String str2, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        if ((i4 & 8) != 0) {
            z5 = false;
        }
        jVar.d(str, str2, z4, z5);
    }

    public final void a(File file, String str, boolean z4) {
        m.e(file, "file");
        String absolutePath = file.getAbsolutePath();
        m.d(absolutePath, "file.absolutePath");
        d(absolutePath, str, z4, true);
    }

    public final void b(Uri uri, String str, boolean z4, boolean z5) {
        m.e(uri, "uri");
        Intent intent = new Intent(this.f7777a, InstallerActivity.class);
        intent.setData(uri);
        intent.putExtra("requireUserAction", z4);
        intent.putExtra("backgroundInstallation", z5);
        intent.addFlags(268435456);
        if (!(str == null || str.length() == 0)) {
            intent.putExtra("newFeatures", str);
        }
        this.f7777a.startActivity(intent);
    }

    public final void c(File file, String str, boolean z4) {
        m.e(file, "file");
        String absolutePath = file.getAbsolutePath();
        m.d(absolutePath, "file.absolutePath");
        g(this, absolutePath, str, z4, false, 8, (Object) null);
    }

    public final void d(String str, String str2, boolean z4, boolean z5) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        Intent intent = new Intent(this.f7777a, InstallerActivity.class);
        intent.putExtra("realPath", str);
        intent.putExtra("requireUserAction", z4);
        intent.putExtra("backgroundInstallation", z5);
        intent.addFlags(268435456);
        if (!(str2 == null || str2.length() == 0)) {
            intent.putExtra("newFeatures", str2);
        }
        this.f7777a.startActivity(intent);
    }

    public final void h(String str) {
        int i4;
        m.e(str, "packageName");
        Intent intent = new Intent("android.intent.action.DELETE", Uri.fromParts("package", str, (String) null));
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 31 || i5 >= 34) {
            i4 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            i4 = 167772160;
        }
        PendingIntent activity = PendingIntent.getActivity(this.f7777a, 0, intent, i4);
        PackageInstaller packageInstaller = this.f7777a.getPackageManager().getPackageInstaller();
        m.d(packageInstaller, "context.packageManager.packageInstaller");
        packageInstaller.uninstall(str, activity.getIntentSender());
    }
}
