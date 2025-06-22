package M;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

final class p0 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q0 f571a;

    /* synthetic */ p0(q0 q0Var, o0 o0Var) {
        this.f571a = q0Var;
    }

    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        if (i4 == 0) {
            synchronized (this.f571a.f575f) {
                try {
                    l0 l0Var = (l0) message.obj;
                    n0 n0Var = (n0) this.f571a.f575f.get(l0Var);
                    if (n0Var != null && n0Var.i()) {
                        if (n0Var.j()) {
                            n0Var.g("GmsClientSupervisor");
                        }
                        this.f571a.f575f.remove(l0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } else if (i4 != 1) {
            return false;
        } else {
            synchronized (this.f571a.f575f) {
                try {
                    l0 l0Var2 = (l0) message.obj;
                    n0 n0Var2 = (n0) this.f571a.f575f.get(l0Var2);
                    if (n0Var2 != null && n0Var2.a() == 3) {
                        String valueOf = String.valueOf(l0Var2);
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                        ComponentName b5 = n0Var2.b();
                        if (b5 == null) {
                            b5 = l0Var2.a();
                        }
                        if (b5 == null) {
                            String c5 = l0Var2.c();
                            C0335p.l(c5);
                            b5 = new ComponentName(c5, EnvironmentCompat.MEDIA_UNKNOWN);
                        }
                        n0Var2.onServiceDisconnected(b5);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }
}
