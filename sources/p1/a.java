package P1;

import W1.C1612h;
import W1.F;
import W1.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0095a f7987b = new C0095a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f7988a;

    /* renamed from: P1.a$a  reason: collision with other inner class name */
    public static final class C0095a {
        public /* synthetic */ C0095a(C2103g gVar) {
            this();
        }

        private C0095a() {
        }
    }

    public a(Context context) {
        m.e(context, "context");
        this.f7988a = context;
    }

    private final void K(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f7988a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private final boolean e(String str, boolean z4) {
        try {
            SharedPreferences sharedPreferences = this.f7988a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z4);
            }
        } catch (Exception unused) {
        }
        return z4;
    }

    private final String g(String str, String str2) {
        try {
            SharedPreferences sharedPreferences = this.f7988a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getString(str, str2);
            }
        } catch (Exception unused) {
        }
        return str2;
    }

    static /* synthetic */ String h(a aVar, String str, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        return aVar.g(str, str2);
    }

    private final void z(String str, boolean z4) {
        try {
            SharedPreferences.Editor edit = this.f7988a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putBoolean(str, z4);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void A(boolean z4) {
        z("device_rooted", z4);
        if (!z4) {
            M(false);
            B(false);
        }
    }

    public final void B(boolean z4) {
        z("install_apk_as_root_system", z4);
    }

    public final void C(String str) {
        K("language", str);
    }

    public final void D(boolean z4) {
        z("notification_permission_request", z4);
    }

    public final void E(boolean z4) {
        z("sdcard_as_backup_storage", z4);
    }

    public final void F(boolean z4) {
        z("storage_sdcard", z4);
    }

    public final void G(boolean z4) {
        z("search_apk_worker_active", z4);
    }

    public final void H(boolean z4) {
        z("show_hidden_files", z4);
    }

    public final void I(boolean z4) {
        z("show_installation_details", z4);
    }

    public final void J(boolean z4) {
        z("warn_installed", z4);
    }

    public final void L(boolean z4) {
        z("system_app", z4);
    }

    public final void M(boolean z4) {
        z("user_asked_for_show_permissions", z4);
    }

    public final boolean N() {
        return e("warn_installed", true);
    }

    public final void a() {
        boolean z4;
        boolean e5 = new F(this.f7988a, (S1.a) null).e();
        if (e5 || Build.VERSION.SDK_INT > 29) {
            z4 = false;
        } else {
            z4 = t.f8713a.d();
        }
        A(z4);
        L(e5);
    }

    public final String b() {
        String g4 = g("xapk_extension", ".xapk");
        if (g4 == null || m3.m.y(g4, ".", false, 2, (Object) null)) {
            return g4;
        }
        return '.' + g4;
    }

    public final Object c() {
        String h4 = h(this, "outputdir", (String) null, 2, (Object) null);
        if (h4 != null) {
            if (n()) {
                Uri n4 = new C1612h().n(this.f7988a);
                if (n4 != null) {
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this.f7988a, n4);
                    if (fromTreeUri != null) {
                        for (String str : m3.m.j0(h4, new String[]{"/"}, false, 0, 6, (Object) null)) {
                            DocumentFile findFile = fromTreeUri.findFile(str);
                            if (findFile == null) {
                                fromTreeUri = fromTreeUri.createDirectory(str);
                                if (fromTreeUri == null) {
                                    break;
                                }
                            } else {
                                fromTreeUri = findFile;
                            }
                        }
                    }
                    if (fromTreeUri != null && fromTreeUri.exists()) {
                        return fromTreeUri;
                    }
                }
                E(false);
            }
            File file = new File(h4);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
        }
        File c5 = new C1612h().c(this.f7988a);
        if (c5 == null) {
            return null;
        }
        y(c5.getAbsolutePath());
        return c5;
    }

    public final String d() {
        String h4 = h(this, "outputdir", (String) null, 2, (Object) null);
        if (h4 != null) {
            return h4;
        }
        File c5 = new C1612h().c(this.f7988a);
        if (c5 == null) {
            return null;
        }
        String absolutePath = c5.getAbsolutePath();
        y(absolutePath);
        return absolutePath;
    }

    public final String f() {
        return h(this, "language", (String) null, 2, (Object) null);
    }

    public final boolean i() {
        return e("app_name_included", true);
    }

    public final boolean j() {
        return e("packagename_included", false);
    }

    public final boolean k() {
        return e("versioncode_included", true);
    }

    public final boolean l() {
        return e("device_rooted", false);
    }

    public final boolean m() {
        return e("install_apk_as_root_system", false);
    }

    public final boolean n() {
        return e("sdcard_as_backup_storage", false);
    }

    public final boolean o() {
        return e("storage_sdcard", false);
    }

    public final boolean p() {
        return e("search_apk_worker_active", true);
    }

    public final boolean q() {
        return e("show_hidden_files", false);
    }

    public final boolean r() {
        return e("show_installation_details", false);
    }

    public final boolean s() {
        return e("system_app", false);
    }

    public final boolean t() {
        return e("user_asked_for_show_permissions", false);
    }

    public final void u(boolean z4) {
        z("app_name_included", z4);
    }

    public final void v(boolean z4) {
        z("packagename_included", z4);
    }

    public final void w(boolean z4) {
        z("versioncode_included", z4);
    }

    public final void x(String str) {
        m.e(str, "value");
        K("xapk_extension", str);
    }

    public final void y(String str) {
        K("outputdir", str);
    }
}
