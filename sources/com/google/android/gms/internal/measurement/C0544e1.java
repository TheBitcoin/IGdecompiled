package com.google.android.gms.internal.measurement;

import M.C0335p;
import R.d;
import R.g;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.work.WorkRequest;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import f0.n;
import f0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* renamed from: com.google.android.gms.internal.measurement.e1  reason: case insensitive filesystem */
public class C0544e1 {

    /* renamed from: j  reason: collision with root package name */
    private static volatile C0544e1 f1869j;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1870a;

    /* renamed from: b  reason: collision with root package name */
    protected final d f1871b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f1872c;

    /* renamed from: d  reason: collision with root package name */
    private final e0.a f1873d;

    /* renamed from: e  reason: collision with root package name */
    private final List f1874e;

    /* renamed from: f  reason: collision with root package name */
    private int f1875f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f1876g;

    /* renamed from: h  reason: collision with root package name */
    private String f1877h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile P0 f1878i;

    /* renamed from: com.google.android.gms.internal.measurement.e1$a */
    abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final long f1879a;

        /* renamed from: b  reason: collision with root package name */
        final long f1880b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f1881c;

        a(C0544e1 e1Var) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: protected */
        public void b() {
        }

        public void run() {
            if (C0544e1.this.f1876g) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e5) {
                C0544e1.this.r(e5, false, this.f1881c);
                b();
            }
        }

        a(boolean z4) {
            this.f1879a = C0544e1.this.f1871b.currentTimeMillis();
            this.f1880b = C0544e1.this.f1871b.elapsedRealtime();
            this.f1881c = z4;
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.e1$b */
    static class b extends Y0 {

        /* renamed from: a  reason: collision with root package name */
        private final t f1883a;

        b(t tVar) {
            this.f1883a = tVar;
        }

        public final int A() {
            return System.identityHashCode(this.f1883a);
        }

        public final void V(String str, String str2, Bundle bundle, long j4) {
            this.f1883a.a(str, str2, bundle, j4);
        }
    }

    /* renamed from: com.google.android.gms.internal.measurement.e1$c */
    class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C0544e1.this.l(new A1(this, bundle, activity));
        }

        public final void onActivityDestroyed(Activity activity) {
            C0544e1.this.l(new F1(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            C0544e1.this.l(new E1(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            C0544e1.this.l(new B1(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Q0 q02 = new Q0();
            C0544e1.this.l(new G1(this, activity, q02));
            Bundle i4 = q02.i(50);
            if (i4 != null) {
                bundle.putAll(i4);
            }
        }

        public final void onActivityStarted(Activity activity) {
            C0544e1.this.l(new C1(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            C0544e1.this.l(new D1(this, activity));
        }
    }

    private C0544e1(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z4;
        if (str == null || !E(str2, str3)) {
            this.f1870a = "FA";
        } else {
            this.f1870a = str;
        }
        this.f1871b = g.b();
        boolean z5 = true;
        this.f1872c = I0.a().a(new C0616m1(this), 1);
        this.f1873d = new e0.a(this);
        this.f1874e = new ArrayList();
        if (!B(context) || J()) {
            if (!E(str2, str3)) {
                this.f1877h = "fa";
                if (str2 == null || str3 == null) {
                    if (str2 == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4 ^ (str3 != null ? false : z5)) {
                        Log.w(this.f1870a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                    }
                } else {
                    Log.v(this.f1870a, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
                }
            } else {
                this.f1877h = str2;
            }
            Context context2 = context;
            l(new C0535d1(this, str2, str3, context2, bundle));
            Application application = (Application) context2.getApplicationContext();
            if (application == null) {
                Log.w(this.f1870a, "Unable to register lifecycle notifications. Application null.");
            } else {
                application.registerActivityLifecycleCallbacks(new c());
            }
        } else {
            this.f1877h = null;
            this.f1876g = true;
            Log.w(this.f1870a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
        }
    }

    private static boolean B(Context context) {
        try {
            if (new n(context, n.a(context)).b("google_app_id") != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final boolean E(String str, String str2) {
        if (str2 == null || str == null || J()) {
            return false;
        }
        return true;
    }

    private final boolean J() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static C0544e1 e(Context context) {
        return f(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static C0544e1 f(Context context, String str, String str2, String str3, Bundle bundle) {
        C0335p.l(context);
        if (f1869j == null) {
            synchronized (C0544e1.class) {
                try {
                    if (f1869j == null) {
                        f1869j = new C0544e1(context, str, str2, str3, bundle);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1869j;
    }

    /* access modifiers changed from: private */
    public final void l(a aVar) {
        this.f1872c.execute(aVar);
    }

    /* access modifiers changed from: private */
    public final void r(Exception exc, boolean z4, boolean z5) {
        Exception exc2;
        C0544e1 e1Var;
        this.f1876g |= z4;
        if (z4) {
            Log.w(this.f1870a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z5) {
            e1Var = this;
            exc2 = exc;
            e1Var.i(5, "Error with data collection. Data lost.", exc2, (Object) null, (Object) null);
        } else {
            e1Var = this;
            exc2 = exc;
        }
        Log.w(e1Var.f1870a, "Error with data collection. Data lost.", exc2);
    }

    private final void u(String str, String str2, Bundle bundle, boolean z4, boolean z5, Long l4) {
        l(new C0721z1(this, l4, str, str2, bundle, z4, z5));
    }

    public final void A(String str, String str2, Bundle bundle) {
        u(str, str2, bundle, true, true, (Long) null);
    }

    public final void C(String str) {
        l(new C0625n1(this, str));
    }

    public final String F() {
        Q0 q02 = new Q0();
        l(new C0642p1(this, q02));
        return q02.m0(50);
    }

    public final String G() {
        Q0 q02 = new Q0();
        l(new C0681u1(this, q02));
        return q02.m0(500);
    }

    public final String H() {
        Q0 q02 = new Q0();
        l(new C0657r1(this, q02));
        return q02.m0(500);
    }

    public final String I() {
        Q0 q02 = new Q0();
        l(new C0650q1(this, q02));
        return q02.m0(500);
    }

    public final int a(String str) {
        Q0 q02 = new Q0();
        l(new C0697w1(this, str, q02));
        Integer num = (Integer) Q0.k(q02.i(WorkRequest.MIN_BACKOFF_MILLIS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long b() {
        Q0 q02 = new Q0();
        l(new C0665s1(this, q02));
        Long l02 = q02.l0(500);
        if (l02 != null) {
            return l02.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f1871b.currentTimeMillis()).nextLong();
        int i4 = this.f1875f + 1;
        this.f1875f = i4;
        return nextLong + ((long) i4);
    }

    /* access modifiers changed from: protected */
    public final P0 c(Context context, boolean z4) {
        try {
            return S0.asInterface(DynamiteModule.e(context, DynamiteModule.f1373e, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e5) {
            r(e5, true, false);
            return null;
        }
    }

    public final List g(String str, String str2) {
        Q0 q02 = new Q0();
        l(new C0580i1(this, str, str2, q02));
        List list = (List) Q0.k(q02.i(5000), List.class);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

    public final Map h(String str, String str2, boolean z4) {
        Q0 q02 = new Q0();
        l(new C0673t1(this, str, str2, z4, q02));
        Bundle i4 = q02.i(5000);
        if (i4 == null || i4.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(i4.size());
        for (String next : i4.keySet()) {
            Object obj = i4.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void i(int i4, String str, Object obj, Object obj2, Object obj3) {
        l(new C0689v1(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    public final void j(Activity activity, String str, String str2) {
        l(new C0598k1(this, activity, str, str2));
    }

    public final void k(Bundle bundle) {
        l(new C0553f1(this, bundle));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r4.f1878i == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.f1878i.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
        android.util.Log.w(r4.f1870a, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        l(new com.google.android.gms.internal.measurement.C0713y1(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(f0.t r5) {
        /*
            r4 = this;
            M.C0335p.l(r5)
            java.util.List r0 = r4.f1874e
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r4.f1874e     // Catch:{ all -> 0x0028 }
            int r2 = r2.size()     // Catch:{ all -> 0x0028 }
            if (r1 >= r2) goto L_0x002d
            java.util.List r2 = r4.f1874e     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0028 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0028 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0028 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            java.lang.String r5 = r4.f1870a     // Catch:{ all -> 0x0028 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r5 = move-exception
            goto L_0x0057
        L_0x002a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002d:
            com.google.android.gms.internal.measurement.e1$b r1 = new com.google.android.gms.internal.measurement.e1$b     // Catch:{ all -> 0x0028 }
            r1.<init>(r5)     // Catch:{ all -> 0x0028 }
            java.util.List r2 = r4.f1874e     // Catch:{ all -> 0x0028 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0028 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0028 }
            r2.add(r3)     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            com.google.android.gms.internal.measurement.P0 r5 = r4.f1878i
            if (r5 == 0) goto L_0x004e
            com.google.android.gms.internal.measurement.P0 r5 = r4.f1878i     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0047 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0047 }
            return
        L_0x0047:
            java.lang.String r5 = r4.f1870a
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004e:
            com.google.android.gms.internal.measurement.y1 r5 = new com.google.android.gms.internal.measurement.y1
            r5.<init>(r4, r1)
            r4.l(r5)
            return
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0544e1.p(f0.t):void");
    }

    public final void q(Boolean bool) {
        l(new C0607l1(this, bool));
    }

    public final void s(String str, Bundle bundle) {
        u((String) null, str, bundle, false, true, (Long) null);
    }

    public final void t(String str, String str2, Bundle bundle) {
        l(new C0589j1(this, str, str2, bundle));
    }

    public final void v(String str, String str2, Object obj, boolean z4) {
        l(new C0571h1(this, str, str2, obj, z4));
    }

    public final e0.a x() {
        return this.f1873d;
    }

    public final void z(String str) {
        l(new C0634o1(this, str));
    }
}
