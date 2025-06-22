package I;

import android.os.IBinder;
import android.os.RemoteException;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f273a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IBinder f274b;

    public /* synthetic */ q(x xVar, IBinder iBinder) {
        this.f273a = xVar;
        this.f274b = iBinder;
    }

    public final void run() {
        x xVar = this.f273a;
        IBinder iBinder = this.f274b;
        synchronized (xVar) {
            if (iBinder == null) {
                xVar.a(0, "Null service connection");
                return;
            }
            try {
                xVar.f283c = new y(iBinder);
                xVar.f281a = 2;
                xVar.c();
            } catch (RemoteException e5) {
                xVar.a(0, e5.getMessage());
            }
        }
    }
}
