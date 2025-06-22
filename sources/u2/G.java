package u2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import kotlin.jvm.internal.m;

public final class G {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21895a;

    public G(Context context) {
        m.e(context, "context");
        this.f21895a = context;
    }

    private final boolean a() {
        if ((this.f21895a.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    private final boolean c() {
        m mVar = new m();
        PackageManager packageManager = this.f21895a.getPackageManager();
        m.d(packageManager, "getPackageManager(...)");
        String packageName = this.f21895a.getPackageName();
        m.d(packageName, "getPackageName(...)");
        return m3.m.p(mVar.j(packageManager, packageName), "822b9ca12b534ebcf426632221d951bfc60eb08f9f0cf2839c321b0685c2e8a4", true);
    }

    public final boolean b() {
        if (c() && !a() && !Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
            return false;
        }
        return true;
    }
}
