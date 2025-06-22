package M;

import R.k;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class n0 implements ServiceConnection, r0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f563a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f564b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f565c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f566d;

    /* renamed from: e  reason: collision with root package name */
    private final l0 f567e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f568f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ q0 f569g;

    public n0(q0 q0Var, l0 l0Var) {
        this.f569g = q0Var;
        this.f567e = l0Var;
    }

    public final int a() {
        return this.f564b;
    }

    public final ComponentName b() {
        return this.f568f;
    }

    public final IBinder c() {
        return this.f566d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f563a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        this.f564b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (k.l()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            q0 q0Var = this.f569g;
            try {
                boolean d5 = q0Var.f579j.d(q0Var.f576g, str, this.f567e.b(q0Var.f576g), this, 4225, executor);
                this.f565c = d5;
                if (d5) {
                    this.f569g.f577h.sendMessageDelayed(this.f569g.f577h.obtainMessage(1, this.f567e), this.f569g.f581l);
                } else {
                    this.f564b = 2;
                    try {
                        q0 q0Var2 = this.f569g;
                        q0Var2.f579j.c(q0Var2.f576g, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            Throwable th22 = th;
            StrictMode.setVmPolicy(vmPolicy);
            throw th22;
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f563a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f569g.f577h.removeMessages(1, this.f567e);
        q0 q0Var = this.f569g;
        q0Var.f579j.c(q0Var.f576g, this);
        this.f565c = false;
        this.f564b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f563a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f563a.isEmpty();
    }

    public final boolean j() {
        return this.f565c;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f569g.f575f) {
            try {
                this.f569g.f577h.removeMessages(1, this.f567e);
                this.f566d = iBinder;
                this.f568f = componentName;
                for (ServiceConnection onServiceConnected : this.f563a.values()) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.f564b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f569g.f575f) {
            try {
                this.f569g.f577h.removeMessages(1, this.f567e);
                this.f566d = null;
                this.f568f = componentName;
                for (ServiceConnection onServiceDisconnected : this.f563a.values()) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.f564b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
