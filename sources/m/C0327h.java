package M;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Executor;

/* renamed from: M.h  reason: case insensitive filesystem */
public abstract class C0327h {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f535a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static q0 f536b = null;

    /* renamed from: c  reason: collision with root package name */
    static HandlerThread f537c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Executor f538d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f539e = false;

    public static C0327h a(Context context) {
        Looper looper;
        synchronized (f535a) {
            try {
                if (f536b == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f539e) {
                        looper = b().getLooper();
                    } else {
                        looper = context.getMainLooper();
                    }
                    f536b = new q0(applicationContext, looper, f538d);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f536b;
    }

    public static HandlerThread b() {
        synchronized (f535a) {
            try {
                HandlerThread handlerThread = f537c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f537c = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = f537c;
                return handlerThread3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(l0 l0Var, ServiceConnection serviceConnection, String str);

    public final void d(String str, String str2, int i4, ServiceConnection serviceConnection, String str3, boolean z4) {
        c(new l0(str, str2, 4225, z4), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean e(l0 l0Var, ServiceConnection serviceConnection, String str, Executor executor);
}
