package I;

import M.C0335p;
import Q.b;
import a0.f;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class x implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    int f281a = 0;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f282b = new Messenger(new f(Looper.getMainLooper(), new u(this)));

    /* renamed from: c  reason: collision with root package name */
    y f283c;

    /* renamed from: d  reason: collision with root package name */
    final Queue f284d = new ArrayDeque();

    /* renamed from: e  reason: collision with root package name */
    final SparseArray f285e = new SparseArray();

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ D f286f;

    /* synthetic */ x(D d5, w wVar) {
        this.f286f = d5;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i4, String str) {
        b(i4, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i4, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i5 = this.f281a;
            if (i5 == 0) {
                throw new IllegalStateException();
            } else if (i5 == 1 || i5 == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f281a = 4;
                b.b().c(this.f286f.f230a, this);
                B b5 = new B(i4, str, th);
                for (A c5 : this.f284d) {
                    c5.c(b5);
                }
                this.f284d.clear();
                for (int i6 = 0; i6 < this.f285e.size(); i6++) {
                    ((A) this.f285e.valueAt(i6)).c(b5);
                }
                this.f285e.clear();
            } else if (i5 == 3) {
                this.f281a = 4;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f286f.f231b.execute(new r(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.f281a == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i4) {
        A a5 = (A) this.f285e.get(i4);
        if (a5 != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i4);
            this.f285e.remove(i4);
            a5.c(new B(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f281a     // Catch:{ all -> 0x0026 }
            r1 = 2
            if (r0 != r1) goto L_0x003a
            java.util.Queue r0 = r2.f284d     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x003a
            android.util.SparseArray r0 = r2.f285e     // Catch:{ all -> 0x0026 }
            int r0 = r0.size()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "MessengerIpcClient"
            java.lang.String r1 = "Finished handling requests, unbinding"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x003c
        L_0x0028:
            r0 = 3
            r2.f281a = r0     // Catch:{ all -> 0x0026 }
            I.D r0 = r2.f286f     // Catch:{ all -> 0x0026 }
            Q.b r1 = Q.b.b()     // Catch:{ all -> 0x0026 }
            android.content.Context r0 = r0.f230a     // Catch:{ all -> 0x0026 }
            r1.c(r0, r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return
        L_0x003a:
            monitor-exit(r2)
            return
        L_0x003c:
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I.x.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(A a5) {
        boolean z4;
        int i4 = this.f281a;
        if (i4 == 0) {
            this.f284d.add(a5);
            if (this.f281a == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0335p.o(z4);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f281a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!b.b().a(this.f286f.f230a, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.f286f.f231b.schedule(new s(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e5) {
                b(0, "Unable to bind to service", e5);
            }
        } else if (i4 == 1) {
            this.f284d.add(a5);
            return true;
        } else if (i4 != 2) {
            return false;
        } else {
            this.f284d.add(a5);
            c();
            return true;
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f286f.f231b.execute(new q(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f286f.f231b.execute(new t(this));
    }
}
