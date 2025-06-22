package M;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class e0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final int f511a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0322c f512b;

    public e0(C0322c cVar, int i4) {
        this.f512b = cVar;
        this.f511a = i4;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0331l lVar;
        C0322c cVar = this.f512b;
        if (iBinder == null) {
            C0322c.d0(cVar, 16);
            return;
        }
        synchronized (cVar.f471n) {
            try {
                C0322c cVar2 = this.f512b;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof C0331l)) {
                    lVar = new U(iBinder);
                } else {
                    lVar = (C0331l) queryLocalInterface;
                }
                cVar2.f472o = lVar;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f512b.e0(0, (Bundle) null, this.f511a);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f512b.f471n) {
            this.f512b.f472o = null;
        }
        C0322c cVar = this.f512b;
        int i4 = this.f511a;
        Handler handler = cVar.f469l;
        handler.sendMessage(handler.obtainMessage(6, i4, 1));
    }
}
