package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

class g0 implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f11376f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f11377g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f11378h;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f11379a;

    /* renamed from: b  reason: collision with root package name */
    private final I f11380b;

    /* renamed from: c  reason: collision with root package name */
    private final PowerManager.WakeLock f11381c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final f0 f11382d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11383e;

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private g0 f11384a;

        public a(g0 g0Var) {
            this.f11384a = g0Var;
        }

        public void a() {
            if (g0.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            g0.this.f11379a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            try {
                g0 g0Var = this.f11384a;
                if (g0Var != null) {
                    if (g0Var.i()) {
                        if (g0.j()) {
                            Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                        }
                        this.f11384a.f11382d.k(this.f11384a, 0);
                        context.unregisterReceiver(this);
                        this.f11384a = null;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    g0(f0 f0Var, Context context, I i4, long j4) {
        this.f11382d = f0Var;
        this.f11379a = context;
        this.f11383e = j4;
        this.f11380b = i4;
        this.f11381c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean z4;
        boolean booleanValue;
        synchronized (f11376f) {
            try {
                Boolean bool = f11378h;
                if (bool == null) {
                    z4 = g(context, "android.permission.ACCESS_NETWORK_STATE", bool);
                } else {
                    z4 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z4);
                f11378h = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        boolean z4;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z4;
    }

    private static boolean h(Context context) {
        boolean z4;
        boolean booleanValue;
        synchronized (f11376f) {
            try {
                Boolean bool = f11377g;
                if (bool == null) {
                    z4 = g(context, "android.permission.WAKE_LOCK", bool);
                } else {
                    z4 = bool.booleanValue();
                }
                Boolean valueOf = Boolean.valueOf(z4);
                f11377g = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo networkInfo;
        boolean z4;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f11379a.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (networkInfo == null || !networkInfo.isConnected()) {
                z4 = false;
            } else {
                z4 = true;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return z4;
    }

    /* access modifiers changed from: private */
    public static boolean j() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
            return false;
        }
        return true;
    }

    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f11379a)) {
            this.f11381c.acquire(C1791e.f11356a);
        }
        try {
            this.f11382d.l(true);
            if (!this.f11380b.g()) {
                this.f11382d.l(false);
                if (h(this.f11379a)) {
                    try {
                        wakeLock = this.f11381c;
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                } else {
                    return;
                }
            } else if (!f(this.f11379a) || i()) {
                if (this.f11382d.o()) {
                    this.f11382d.l(false);
                } else {
                    this.f11382d.p(this.f11383e);
                }
                if (h(this.f11379a)) {
                    wakeLock = this.f11381c;
                } else {
                    return;
                }
            } else {
                new a(this).a();
                if (h(this.f11379a)) {
                    wakeLock = this.f11381c;
                } else {
                    return;
                }
            }
            wakeLock.release();
        } catch (IOException e5) {
            Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e5.getMessage());
            this.f11382d.l(false);
            if (h(this.f11379a)) {
                this.f11381c.release();
            }
        } catch (Throwable th) {
            if (h(this.f11379a)) {
                try {
                    this.f11381c.release();
                } catch (RuntimeException unused2) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
