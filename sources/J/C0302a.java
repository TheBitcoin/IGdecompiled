package J;

import M.C0335p;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: J.a  reason: case insensitive filesystem */
public class C0302a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    boolean f320a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f321b = new LinkedBlockingQueue();

    public IBinder a(long j4, TimeUnit timeUnit) {
        C0335p.k("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f320a) {
            this.f320a = true;
            IBinder iBinder = (IBinder) this.f321b.poll(j4, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f321b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
