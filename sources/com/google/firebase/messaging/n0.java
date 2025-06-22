package com.google.firebase.messaging;

import Q.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C0937l;
import k0.C0938m;

class n0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11412a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f11413b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f11414c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue f11415d;

    /* renamed from: e  reason: collision with root package name */
    private k0 f11416e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11417f;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f11418a;

        /* renamed from: b  reason: collision with root package name */
        private final C0938m f11419b = new C0938m();

        a(Intent intent) {
            this.f11418a = intent;
        }

        public static /* synthetic */ void b(a aVar) {
            aVar.getClass();
            Log.w("FirebaseMessaging", "Service took too long to process intent: " + aVar.f11418a.getAction() + " finishing.");
            aVar.d();
        }

        /* access modifiers changed from: package-private */
        public void c(ScheduledExecutorService scheduledExecutorService) {
            e().b(scheduledExecutorService, new m0(scheduledExecutorService.schedule(new l0(this), 20, TimeUnit.SECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f11419b.e((Object) null);
        }

        /* access modifiers changed from: package-private */
        public C0937l e() {
            return this.f11419b.a();
        }
    }

    n0(Context context, String str) {
        this(context, str, a());
    }

    private static ScheduledThreadPoolExecutor a() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(40, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    private void b() {
        while (!this.f11415d.isEmpty()) {
            ((a) this.f11415d.poll()).d();
        }
    }

    private synchronized void c() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f11415d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                k0 k0Var = this.f11416e;
                if (k0Var == null || !k0Var.isBinderAlive()) {
                    e();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f11416e.b((a) this.f11415d.poll());
            }
        } finally {
            while (true) {
            }
        }
    }

    private void e() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.f11417f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (!this.f11417f) {
            this.f11417f = true;
            try {
                if (!b.b().a(this.f11412a, this.f11413b, this, 65)) {
                    Log.e("FirebaseMessaging", "binding to the service failed");
                    this.f11417f = false;
                    b();
                }
            } catch (SecurityException e5) {
                Log.e("FirebaseMessaging", "Exception while binding the service", e5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized C0937l d(Intent intent) {
        a aVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            aVar = new a(intent);
            aVar.c(this.f11414c);
            this.f11415d.add(aVar);
            c();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return aVar.e();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f11417f = false;
            if (!(iBinder instanceof k0)) {
                Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
                b();
                return;
            }
            this.f11416e = (k0) iBinder;
            c();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        c();
    }

    n0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f11415d = new ArrayDeque();
        this.f11417f = false;
        Context applicationContext = context.getApplicationContext();
        this.f11412a = applicationContext;
        this.f11413b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f11414c = scheduledExecutorService;
    }
}
