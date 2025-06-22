package com.google.firebase.messaging;

import I.C0294a;
import M.C0335p;
import O0.d;
import R0.b;
import S0.e;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.a0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;
import o.j;
import p0.C2190b;
import p0.C2194f;
import q0.C2204a;

public class FirebaseMessaging {

    /* renamed from: l  reason: collision with root package name */
    private static final long f11231l = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: m  reason: collision with root package name */
    private static a0 f11232m;

    /* renamed from: n  reason: collision with root package name */
    static b f11233n = new r();

    /* renamed from: o  reason: collision with root package name */
    static ScheduledExecutorService f11234o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2194f f11235a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11236b;

    /* renamed from: c  reason: collision with root package name */
    private final D f11237c;

    /* renamed from: d  reason: collision with root package name */
    private final V f11238d;

    /* renamed from: e  reason: collision with root package name */
    private final a f11239e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f11240f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f11241g;

    /* renamed from: h  reason: collision with root package name */
    private final C0937l f11242h;

    /* renamed from: i  reason: collision with root package name */
    private final I f11243i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11244j;

    /* renamed from: k  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f11245k;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private final d f11246a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11247b;

        /* renamed from: c  reason: collision with root package name */
        private O0.b f11248c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f11249d;

        a(d dVar) {
            this.f11246a = dVar;
        }

        public static /* synthetic */ void a(a aVar, O0.a aVar2) {
            if (aVar.c()) {
                FirebaseMessaging.this.B();
            }
        }

        private Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context k4 = FirebaseMessaging.this.f11235a.k();
            SharedPreferences sharedPreferences = k4.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = k4.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(k4.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            try {
                if (!this.f11247b) {
                    Boolean d5 = d();
                    this.f11249d = d5;
                    if (d5 == null) {
                        A a5 = new A(this);
                        this.f11248c = a5;
                        this.f11246a.b(C2190b.class, a5);
                    }
                    this.f11247b = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            boolean z4;
            try {
                b();
                Boolean bool = this.f11249d;
                if (bool != null) {
                    z4 = bool.booleanValue();
                } else {
                    z4 = FirebaseMessaging.this.f11235a.t();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return z4;
        }
    }

    FirebaseMessaging(C2194f fVar, Q0.a aVar, b bVar, b bVar2, e eVar, b bVar3, d dVar) {
        this(fVar, aVar, bVar, bVar2, eVar, bVar3, dVar, new I(fVar.k()));
    }

    private synchronized void A() {
        if (!this.f11244j) {
            C(0);
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        if (D(r())) {
            A();
        }
    }

    public static /* synthetic */ C0937l a(FirebaseMessaging firebaseMessaging, String str, a0.a aVar, String str2) {
        o(firebaseMessaging.f11236b).f(firebaseMessaging.p(), str, str2, firebaseMessaging.f11243i.a());
        if (aVar == null || !str2.equals(aVar.f11334a)) {
            firebaseMessaging.v(str2);
        }
        return C0940o.e(str2);
    }

    public static /* synthetic */ void b(FirebaseMessaging firebaseMessaging) {
        if (firebaseMessaging.w()) {
            firebaseMessaging.B();
        }
    }

    public static /* synthetic */ void c(FirebaseMessaging firebaseMessaging, C0938m mVar) {
        firebaseMessaging.getClass();
        try {
            mVar.c(firebaseMessaging.k());
        } catch (Exception e5) {
            mVar.b(e5);
        }
    }

    public static /* synthetic */ j d() {
        return null;
    }

    public static /* synthetic */ void f(FirebaseMessaging firebaseMessaging, C0294a aVar) {
        firebaseMessaging.getClass();
        if (aVar != null) {
            H.y(aVar.c());
            firebaseMessaging.t();
        }
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull C2194f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.j(FirebaseMessaging.class);
            C0335p.m(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static /* synthetic */ void h(FirebaseMessaging firebaseMessaging, f0 f0Var) {
        if (firebaseMessaging.w()) {
            f0Var.n();
        }
    }

    public static synchronized FirebaseMessaging n() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(C2194f.l());
        }
        return instance;
    }

    private static synchronized a0 o(Context context) {
        a0 a0Var;
        synchronized (FirebaseMessaging.class) {
            try {
                if (f11232m == null) {
                    f11232m = new a0(context);
                }
                a0Var = f11232m;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return a0Var;
    }

    private String p() {
        if ("[DEFAULT]".equals(this.f11235a.m())) {
            return "";
        }
        return this.f11235a.o();
    }

    public static j s() {
        return (j) f11233n.get();
    }

    private void t() {
        this.f11237c.e().f(this.f11240f, new C1809x(this));
    }

    /* access modifiers changed from: private */
    public void u() {
        O.c(this.f11236b);
        Q.f(this.f11236b, this.f11237c, z());
        if (z()) {
            t();
        }
    }

    private void v(String str) {
        if ("[DEFAULT]".equals(this.f11235a.m())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f11235a.m());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C1800n(this.f11236b).g(intent);
        }
    }

    private boolean z() {
        O.c(this.f11236b);
        if (!O.d(this.f11236b)) {
            return false;
        }
        if (this.f11235a.j(C2204a.class) != null) {
            return true;
        }
        if (!H.a() || f11233n == null) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized void C(long j4) {
        l(new b0(this, Math.min(Math.max(30, 2 * j4), f11231l)), j4);
        this.f11244j = true;
    }

    /* access modifiers changed from: package-private */
    public boolean D(a0.a aVar) {
        if (aVar == null || aVar.b(this.f11243i.a())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        a0.a r4 = r();
        if (!D(r4)) {
            return r4.f11334a;
        }
        String c5 = I.c(this.f11235a);
        try {
            return (String) C0940o.a(this.f11238d.b(c5, new C1810y(this, c5, r4)));
        } catch (InterruptedException | ExecutionException e5) {
            throw new IOException(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(Runnable runnable, long j4) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f11234o == null) {
                    f11234o = new ScheduledThreadPoolExecutor(1, new S.a("TAG"));
                }
                f11234o.schedule(runnable, j4, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context m() {
        return this.f11236b;
    }

    public C0937l q() {
        C0938m mVar = new C0938m();
        this.f11240f.execute(new C1808w(this, mVar));
        return mVar.a();
    }

    /* access modifiers changed from: package-private */
    public a0.a r() {
        return o(this.f11236b).d(p(), I.c(this.f11235a));
    }

    public boolean w() {
        return this.f11239e.c();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f11243i.g();
    }

    /* access modifiers changed from: package-private */
    public synchronized void y(boolean z4) {
        this.f11244j = z4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FirebaseMessaging(p0.C2194f r11, Q0.a r12, R0.b r13, R0.b r14, S0.e r15, R0.b r16, O0.d r17, com.google.firebase.messaging.I r18) {
        /*
            r10 = this;
            com.google.firebase.messaging.D r0 = new com.google.firebase.messaging.D
            r1 = r11
            r3 = r13
            r4 = r14
            r5 = r15
            r2 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r7 = com.google.firebase.messaging.C1801o.f()
            java.util.concurrent.ScheduledExecutorService r8 = com.google.firebase.messaging.C1801o.c()
            java.util.concurrent.Executor r9 = com.google.firebase.messaging.C1801o.b()
            r2 = r12
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r0
            r0 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(p0.f, Q0.a, R0.b, R0.b, S0.e, R0.b, O0.d, com.google.firebase.messaging.I):void");
    }

    FirebaseMessaging(C2194f fVar, Q0.a aVar, b bVar, d dVar, I i4, D d5, Executor executor, Executor executor2, Executor executor3) {
        this.f11244j = false;
        f11233n = bVar;
        this.f11235a = fVar;
        this.f11239e = new a(dVar);
        Context k4 = fVar.k();
        this.f11236b = k4;
        C1803q qVar = new C1803q();
        this.f11245k = qVar;
        this.f11243i = i4;
        this.f11237c = d5;
        this.f11238d = new V(executor);
        this.f11240f = executor2;
        this.f11241g = executor3;
        Context k5 = fVar.k();
        if (k5 instanceof Application) {
            ((Application) k5).registerActivityLifecycleCallbacks(qVar);
        } else {
            Log.w("FirebaseMessaging", "Context " + k5 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new C1804s(this));
        }
        executor2.execute(new C1805t(this));
        C0937l e5 = f0.e(this, i4, d5, k4, C1801o.g());
        this.f11242h = e5;
        e5.f(executor2, new C1806u(this));
        executor2.execute(new C1807v(this));
    }
}
