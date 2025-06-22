package I;

import S.a;
import a0.e;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import k0.C0937l;

public final class D {

    /* renamed from: e  reason: collision with root package name */
    private static D f229e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f230a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f231b;

    /* renamed from: c  reason: collision with root package name */
    private x f232c = new x(this, (w) null);

    /* renamed from: d  reason: collision with root package name */
    private int f233d = 1;

    D(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f231b = scheduledExecutorService;
        this.f230a = context.getApplicationContext();
    }

    public static synchronized D b(Context context) {
        D d5;
        synchronized (D.class) {
            try {
                if (f229e == null) {
                    e.a();
                    f229e = new D(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new a("MessengerIpcClient"))));
                }
                d5 = f229e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return d5;
    }

    private final synchronized int f() {
        int i4;
        i4 = this.f233d;
        this.f233d = i4 + 1;
        return i4;
    }

    private final synchronized C0937l g(A a5) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(a5.toString()));
            }
            if (!this.f232c.g(a5)) {
                x xVar = new x(this, (w) null);
                this.f232c = xVar;
                xVar.g(a5);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a5.f226b.a();
    }

    public final C0937l c(int i4, Bundle bundle) {
        return g(new z(f(), i4, bundle));
    }

    public final C0937l d(int i4, Bundle bundle) {
        return g(new C(f(), i4, bundle));
    }
}
