package J;

import M.C0335p;
import M.W;
import M.X;
import R.a;
import R.i;
import U.b;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;

abstract class D {

    /* renamed from: a  reason: collision with root package name */
    static final B f293a = new v(z.k("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final B f294b = new w(z.k("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final B f295c = new x(z.k("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final B f296d = new y(z.k("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static volatile X f297e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f298f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Context f299g;

    static N a(String str, z zVar, boolean z4, boolean z5) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, zVar, z4, z5);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static N b(String str, boolean z4, boolean z5, boolean z6) {
        return g(str, z4, false, false, true);
    }

    static /* synthetic */ String c(boolean z4, String str, z zVar) {
        String str2;
        if (z4 || !f(str, zVar, true, false).f316a) {
            str2 = "not allowed";
        } else {
            str2 = "debug cert rejected";
        }
        MessageDigest b5 = a.b("SHA-256");
        C0335p.l(b5);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, i.a(b5.digest(zVar.l0())), Boolean.valueOf(z4), "12451000.false"});
    }

    static synchronized void d(Context context) {
        synchronized (D.class) {
            if (f299g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f299g = context.getApplicationContext();
            }
        }
    }

    static boolean e() {
        boolean z4;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            h();
            z4 = f297e.d();
        } catch (RemoteException | DynamiteModule.a e5) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            z4 = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z4;
    }

    private static N f(String str, z zVar, boolean z4, boolean z5) {
        try {
            h();
            C0335p.l(f299g);
            try {
                if (f297e.R(new I(str, zVar, z4, z5), b.l0(f299g.getPackageManager()))) {
                    return N.b();
                }
                return new L(new u(z4, str, zVar), (K) null);
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                return N.d("module call", e5);
            }
        } catch (DynamiteModule.a e6) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
            return N.d("module init: ".concat(String.valueOf(e6.getMessage())), e6);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [U.a, android.os.IBinder] */
    private static N g(String str, boolean z4, boolean z5, boolean z6, boolean z7) {
        N n4;
        G g4;
        PackageManager.NameNotFoundException nameNotFoundException;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            C0335p.l(f299g);
            try {
                h();
                E e5 = new E(str, z4, false, b.l0(f299g), false, true);
                if (z7) {
                    g4 = f297e.p(e5);
                } else {
                    g4 = f297e.O(e5);
                }
                if (g4.g()) {
                    n4 = N.f(g4.h());
                } else {
                    String c5 = g4.c();
                    if (g4.j() == 4) {
                        nameNotFoundException = new PackageManager.NameNotFoundException();
                    } else {
                        nameNotFoundException = null;
                    }
                    if (c5 == null) {
                        c5 = "error checking package certificate";
                    }
                    n4 = N.g(g4.h(), g4.j(), c5, nameNotFoundException);
                }
            } catch (DynamiteModule.a e6) {
                DynamiteModule.a aVar = e6;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", aVar);
                n4 = N.d("module init: ".concat(String.valueOf(aVar.getMessage())), aVar);
            }
        } catch (RemoteException e7) {
            RemoteException remoteException = e7;
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException);
            n4 = N.d("module call", remoteException);
        } catch (Throwable th) {
            Throwable th2 = th;
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return n4;
    }

    private static void h() {
        if (f297e == null) {
            C0335p.l(f299g);
            synchronized (f298f) {
                try {
                    if (f297e == null) {
                        f297e = W.i(DynamiteModule.e(f299g, DynamiteModule.f1374f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
