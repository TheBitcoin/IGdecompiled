package M;

import Q.b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import b0.e;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class q0 extends C0327h {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f575f = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f576g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile Handler f577h;

    /* renamed from: i  reason: collision with root package name */
    private final p0 f578i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final b f579j;

    /* renamed from: k  reason: collision with root package name */
    private final long f580k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final long f581l;

    /* renamed from: m  reason: collision with root package name */
    private volatile Executor f582m;

    q0(Context context, Looper looper, Executor executor) {
        p0 p0Var = new p0(this, (o0) null);
        this.f578i = p0Var;
        this.f576g = context.getApplicationContext();
        this.f577h = new e(looper, p0Var);
        this.f579j = b.b();
        this.f580k = 5000;
        this.f581l = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.f582m = executor;
    }

    /* access modifiers changed from: protected */
    public final void c(l0 l0Var, ServiceConnection serviceConnection, String str) {
        C0335p.m(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f575f) {
            try {
                n0 n0Var = (n0) this.f575f.get(l0Var);
                if (n0Var == null) {
                    String obj = l0Var.toString();
                    throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
                } else if (n0Var.h(serviceConnection)) {
                    n0Var.f(serviceConnection, str);
                    if (n0Var.i()) {
                        this.f577h.sendMessageDelayed(this.f577h.obtainMessage(0, l0Var), this.f580k);
                    }
                } else {
                    String obj2 = l0Var.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean e(l0 l0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j4;
        C0335p.m(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f575f) {
            try {
                n0 n0Var = (n0) this.f575f.get(l0Var);
                if (executor == null) {
                    executor = this.f582m;
                }
                if (n0Var == null) {
                    n0Var = new n0(this, l0Var);
                    n0Var.d(serviceConnection, serviceConnection, str);
                    n0Var.e(str, executor);
                    this.f575f.put(l0Var, n0Var);
                } else {
                    this.f577h.removeMessages(0, l0Var);
                    if (!n0Var.h(serviceConnection)) {
                        n0Var.d(serviceConnection, serviceConnection, str);
                        int a5 = n0Var.a();
                        if (a5 == 1) {
                            serviceConnection.onServiceConnected(n0Var.b(), n0Var.c());
                        } else if (a5 == 2) {
                            n0Var.e(str, executor);
                        }
                    } else {
                        String obj = l0Var.toString();
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                    }
                }
                j4 = n0Var.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return j4;
    }
}
