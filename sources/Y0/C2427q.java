package y0;

import A0.C1269e;
import A0.m;
import B0.F;
import B0.G;
import E0.g;
import G0.j;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.C0936k;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;
import v0.C2327a;
import v0.h;
import w0.C2333a;
import y0.C2409B;
import z0.C2441b;
import z0.C2444e;
import z0.C2446g;

/* renamed from: y0.q  reason: case insensitive filesystem */
class C2427q {

    /* renamed from: t  reason: collision with root package name */
    static final FilenameFilter f22667t = new C2426p();

    /* renamed from: a  reason: collision with root package name */
    private final Context f22668a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final D f22669b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2434y f22670c;

    /* renamed from: d  reason: collision with root package name */
    private final m f22671d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final C2446g f22672e;

    /* renamed from: f  reason: collision with root package name */
    private final I f22673f;

    /* renamed from: g  reason: collision with root package name */
    private final g f22674g;

    /* renamed from: h  reason: collision with root package name */
    private final C2412b f22675h;

    /* renamed from: i  reason: collision with root package name */
    private final C1269e f22676i;

    /* renamed from: j  reason: collision with root package name */
    private final C2327a f22677j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final C2333a f22678k;

    /* renamed from: l  reason: collision with root package name */
    private final C2424n f22679l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Z f22680m;

    /* renamed from: n  reason: collision with root package name */
    private C2409B f22681n;

    /* renamed from: o  reason: collision with root package name */
    private j f22682o = null;

    /* renamed from: p  reason: collision with root package name */
    final C0938m f22683p = new C0938m();

    /* renamed from: q  reason: collision with root package name */
    final C0938m f22684q = new C0938m();

    /* renamed from: r  reason: collision with root package name */
    final C0938m f22685r = new C0938m();

    /* renamed from: s  reason: collision with root package name */
    final AtomicBoolean f22686s = new AtomicBoolean(false);

    /* renamed from: y0.q$a */
    class a implements C2409B.a {
        a() {
        }

        public void a(j jVar, Thread thread, Throwable th) {
            C2427q.this.G(jVar, thread, th);
        }
    }

    /* renamed from: y0.q$b */
    class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f22689b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Thread f22690c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j f22691d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f22692e;

        /* renamed from: y0.q$b$a */
        class a implements C0936k {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f22694a;

            a(String str) {
                this.f22694a = str;
            }

            /* renamed from: b */
            public C0937l a(G0.d dVar) {
                String str = null;
                if (dVar == null) {
                    v0.g.f().k("Received null app settings, cannot send reports at crash time.");
                    return C0940o.e((Object) null);
                }
                C0937l l4 = C2427q.this.L();
                Z g4 = C2427q.this.f22680m;
                C2444e eVar = C2427q.this.f22672e.f22851a;
                if (b.this.f22692e) {
                    str = this.f22694a;
                }
                return C0940o.g(l4, g4.x(eVar, str));
            }
        }

        b(long j4, Throwable th, Thread thread, j jVar, boolean z4) {
            this.f22688a = j4;
            this.f22689b = th;
            this.f22690c = thread;
            this.f22691d = jVar;
            this.f22692e = z4;
        }

        /* renamed from: a */
        public C0937l call() {
            long c5 = C2427q.E(this.f22688a);
            String d5 = C2427q.this.A();
            if (d5 == null) {
                v0.g.f().d("Tried to write a fatal exception while no session was open.");
                return C0940o.e((Object) null);
            }
            C2427q.this.f22670c.a();
            C2427q.this.f22680m.t(this.f22689b, this.f22690c, d5, c5);
            C2427q.this.v(this.f22688a);
            C2427q.this.s(this.f22691d);
            C2427q.this.u(new C2419i().c(), Boolean.valueOf(this.f22692e));
            if (!C2427q.this.f22669b.d()) {
                return C0940o.e((Object) null);
            }
            return this.f22691d.a().o(C2427q.this.f22672e.f22851a, new a(d5));
        }
    }

    /* renamed from: y0.q$c */
    class c implements C0936k {
        c() {
        }

        /* renamed from: b */
        public C0937l a(Void voidR) {
            return C0940o.e(Boolean.TRUE);
        }
    }

    /* renamed from: y0.q$d */
    class d implements C0936k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0937l f22697a;

        /* renamed from: y0.q$d$a */
        class a implements C0936k {
            a() {
            }

            /* renamed from: b */
            public C0937l a(G0.d dVar) {
                if (dVar == null) {
                    v0.g.f().k("Received null app settings at app startup. Cannot send cached reports");
                    return C0940o.e((Object) null);
                }
                C0937l unused = C2427q.this.L();
                C2427q.this.f22680m.w(C2427q.this.f22672e.f22851a);
                C2427q.this.f22685r.e((Object) null);
                return C0940o.e((Object) null);
            }
        }

        d(C0937l lVar) {
            this.f22697a = lVar;
        }

        /* renamed from: b */
        public C0937l a(Boolean bool) {
            if (!bool.booleanValue()) {
                v0.g.f().i("Deleting cached crash reports...");
                C2427q.q(C2427q.this.J());
                C2427q.this.f22680m.v();
                C2427q.this.f22685r.e((Object) null);
                return C0940o.e((Object) null);
            }
            v0.g.f().b("Sending cached crash reports...");
            C2427q.this.f22669b.c(bool.booleanValue());
            return this.f22697a.o(C2427q.this.f22672e.f22851a, new a());
        }
    }

    /* renamed from: y0.q$e */
    class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f22700a;

        e(long j4) {
            this.f22700a = j4;
        }

        /* renamed from: a */
        public Void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong(CampaignEx.JSON_KEY_TIMESTAMP, this.f22700a);
            C2427q.this.f22678k.a("_ae", bundle);
            return null;
        }
    }

    C2427q(Context context, I i4, D d5, g gVar, C2434y yVar, C2412b bVar, m mVar, C1269e eVar, Z z4, C2327a aVar, C2333a aVar2, C2424n nVar, C2446g gVar2) {
        this.f22668a = context;
        this.f22673f = i4;
        this.f22669b = d5;
        this.f22674g = gVar;
        this.f22670c = yVar;
        this.f22675h = bVar;
        this.f22671d = mVar;
        this.f22676i = eVar;
        this.f22677j = aVar;
        this.f22678k = aVar2;
        this.f22679l = nVar;
        this.f22680m = z4;
        this.f22672e = gVar2;
    }

    /* access modifiers changed from: private */
    public String A() {
        SortedSet p4 = this.f22680m.p();
        if (!p4.isEmpty()) {
            return (String) p4.first();
        }
        return null;
    }

    private static long B() {
        return E(System.currentTimeMillis());
    }

    static List C(h hVar, String str, g gVar, byte[] bArr) {
        File q4 = gVar.q(str, "user-data");
        File q5 = gVar.q(str, "keys");
        File q6 = gVar.q(str, "rollouts-state");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C2418h("logs_file", "logs", bArr));
        arrayList.add(new G("crash_meta_file", TtmlNode.TAG_METADATA, hVar.g()));
        arrayList.add(new G("session_meta_file", "session", hVar.f()));
        arrayList.add(new G("app_meta_file", MBridgeConstans.DYNAMIC_VIEW_WX_APP, hVar.a()));
        arrayList.add(new G("device_meta_file", "device", hVar.c()));
        arrayList.add(new G("os_meta_file", "os", hVar.b()));
        arrayList.add(N(hVar));
        arrayList.add(new G("user_meta_file", "user", q4));
        arrayList.add(new G("keys_file", "keys", q5));
        arrayList.add(new G("rollouts_file", "rollouts", q6));
        return arrayList;
    }

    private InputStream D(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            v0.g.f().k("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        v0.g.f().g("No version control information found");
        return null;
    }

    /* access modifiers changed from: private */
    public static long E(long j4) {
        return j4 / 1000;
    }

    private C0937l K(long j4) {
        if (z()) {
            v0.g.f().k("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return C0940o.e((Object) null);
        }
        v0.g.f().b("Logging app exception event to Firebase Analytics");
        return C0940o.c(new ScheduledThreadPoolExecutor(1), new e(j4));
    }

    /* access modifiers changed from: private */
    public C0937l L() {
        ArrayList arrayList = new ArrayList();
        for (File file : J()) {
            try {
                arrayList.add(K(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                v0.g f4 = v0.g.f();
                f4.k("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return C0940o.f(arrayList);
    }

    private static boolean M(String str, File file, F.a aVar) {
        if (file == null || !file.exists()) {
            v0.g f4 = v0.g.f();
            f4.k("No minidump data found for session " + str);
        }
        if (aVar == null) {
            v0.g f5 = v0.g.f();
            f5.g("No Tombstones data found for session " + str);
        }
        if ((file == null || !file.exists()) && aVar == null) {
            return true;
        }
        return false;
    }

    private static L N(h hVar) {
        File e5 = hVar.e();
        if (e5 != null && e5.exists()) {
            return new G("minidump_file", "minidump", e5);
        }
        return new C2418h("minidump_file", "minidump", new byte[]{0});
    }

    private static byte[] P(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private C0937l T() {
        if (this.f22669b.d()) {
            v0.g.f().b("Automatic data collection is enabled. Allowing upload.");
            this.f22683p.e(Boolean.FALSE);
            return C0940o.e(Boolean.TRUE);
        }
        v0.g.f().b("Automatic data collection is disabled.");
        v0.g.f().i("Notifying that unsent reports are available.");
        this.f22683p.e(Boolean.TRUE);
        C0937l p4 = this.f22669b.j().p(new c());
        v0.g.f().b("Waiting for send/deleteUnsentReports to be called.");
        return C2441b.b(p4, this.f22684q.a());
    }

    private void U(String str) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            List a5 = ((ActivityManager) this.f22668a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
            if (a5.size() != 0) {
                this.f22680m.u(str, a5, new C1269e(this.f22674g, str), m.i(str, this.f22674g, this.f22672e));
                return;
            }
            v0.g f4 = v0.g.f();
            f4.i("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        v0.g f5 = v0.g.f();
        f5.i("ANR feature enabled, but device is API " + i4);
    }

    private static G.a n(I i4, C2412b bVar) {
        return G.a.b(i4.f(), bVar.f22623f, bVar.f22624g, i4.a().c(), E.b(bVar.f22621d).c(), bVar.f22625h);
    }

    private static G.b o(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return G.b.c(C2420j.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), C2420j.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), C2420j.w(), C2420j.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static G.c p() {
        return G.c.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, C2420j.x());
    }

    /* access modifiers changed from: private */
    public static void q(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t(boolean r4, G0.j r5, boolean r6) {
        /*
            r3 = this;
            z0.C2446g.c()
            java.util.ArrayList r0 = new java.util.ArrayList
            y0.Z r1 = r3.f22680m
            java.util.SortedSet r1 = r1.p()
            r0.<init>(r1)
            int r1 = r0.size()
            if (r1 > r4) goto L_0x001e
            v0.g r4 = v0.g.f()
            java.lang.String r5 = "No open sessions to be closed."
            r4.i(r5)
            return
        L_0x001e:
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r6 == 0) goto L_0x0034
            G0.d r5 = r5.b()
            G0.d$a r5 = r5.f6522b
            boolean r5 = r5.f6530b
            if (r5 == 0) goto L_0x0034
            r3.U(r1)
            goto L_0x003d
        L_0x0034:
            v0.g r5 = v0.g.f()
            java.lang.String r2 = "ANR feature disabled."
            r5.i(r2)
        L_0x003d:
            if (r6 == 0) goto L_0x004a
            v0.a r5 = r3.f22677j
            boolean r5 = r5.d(r1)
            if (r5 == 0) goto L_0x004a
            r3.x(r1)
        L_0x004a:
            if (r4 == 0) goto L_0x0054
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x005b
        L_0x0054:
            y0.n r4 = r3.f22679l
            r5 = 0
            r4.e(r5)
            r4 = r5
        L_0x005b:
            y0.Z r5 = r3.f22680m
            long r0 = B()
            r5.l(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.C2427q.t(boolean, G0.j, boolean):void");
    }

    /* access modifiers changed from: private */
    public void u(String str, Boolean bool) {
        long B4 = B();
        v0.g f4 = v0.g.f();
        f4.b("Opening a new session with ID " + str);
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{C2433x.k()});
        G.a n4 = n(this.f22673f, this.f22675h);
        G.c p4 = p();
        G.b o4 = o(this.f22668a);
        G.a aVar = n4;
        C2327a aVar2 = this.f22677j;
        G b5 = G.b(aVar, p4, o4);
        String str2 = str;
        aVar2.a(str2, format, B4, b5);
        if (bool.booleanValue() && str2 != null) {
            this.f22671d.l(str2);
        }
        this.f22676i.e(str2);
        this.f22679l.e(str2);
        this.f22680m.q(str2, B4);
    }

    /* access modifiers changed from: private */
    public void v(long j4) {
        try {
            g gVar = this.f22674g;
            if (!gVar.g(".ae" + j4).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e5) {
            v0.g.f().l("Could not create app exception marker file.", e5);
        }
    }

    private void x(String str) {
        v0.g f4 = v0.g.f();
        f4.i("Finalizing native report for session " + str);
        h b5 = this.f22677j.b(str);
        File e5 = b5.e();
        F.a d5 = b5.d();
        if (M(str, e5, d5)) {
            v0.g.f().k("No native core present");
            return;
        }
        long lastModified = e5.lastModified();
        C1269e eVar = new C1269e(this.f22674g, str);
        File k4 = this.f22674g.k(str);
        if (!k4.isDirectory()) {
            v0.g.f().k("Couldn't create directory to store native session files, aborting.");
            return;
        }
        v(lastModified);
        List C4 = C(b5, str, this.f22674g, eVar.b());
        M.b(k4, C4);
        v0.g.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f22680m.k(str, C4, d5);
        eVar.a();
    }

    private static boolean z() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String F() {
        InputStream D4 = D("META-INF/version-control-info.textproto");
        if (D4 == null) {
            return null;
        }
        v0.g.f().b("Read version control info");
        return Base64.encodeToString(P(D4), 0);
    }

    /* access modifiers changed from: package-private */
    public void G(j jVar, Thread thread, Throwable th) {
        H(jVar, thread, th, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void H(j jVar, Thread thread, Throwable th, boolean z4) {
        try {
            v0.g f4 = v0.g.f();
            f4.b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            long currentTimeMillis = System.currentTimeMillis();
            boolean z5 = z4;
            try {
                C0937l e5 = this.f22672e.f22851a.e(new b(currentTimeMillis, th, thread, jVar, z5));
                if (!z5) {
                    c0.b(e5);
                }
            } catch (TimeoutException unused) {
                v0.g.f().d("Cannot send reports. Timed out while fetching settings.");
            } catch (Exception e6) {
                v0.g.f().e("Error handling uncaught exception", e6);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        C2409B b5 = this.f22681n;
        if (b5 == null || !b5.a()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public List J() {
        return this.f22674g.h(f22667t);
    }

    /* access modifiers changed from: package-private */
    public void O(String str) {
        this.f22672e.f22851a.d(new C2425o(this, str));
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        try {
            String F4 = F();
            if (F4 != null) {
                R("com.crashlytics.version-control-info", F4);
                v0.g.f().g("Saved version control info");
            }
        } catch (IOException e5) {
            v0.g.f().l("Unable to save version control info", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void R(String str, String str2) {
        try {
            this.f22671d.k(str, str2);
        } catch (IllegalArgumentException e5) {
            Context context = this.f22668a;
            if (context == null || !C2420j.u(context)) {
                v0.g.f().d("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e5;
        }
    }

    /* access modifiers changed from: package-private */
    public void S(C0937l lVar) {
        if (!this.f22680m.o()) {
            v0.g.f().i("No crash reports are available to be sent.");
            this.f22683p.e(Boolean.FALSE);
            return;
        }
        v0.g.f().i("Crash reports are available to be sent.");
        T().o(this.f22672e.f22851a, new d(lVar));
    }

    /* access modifiers changed from: package-private */
    public void V(long j4, String str) {
        if (!I()) {
            this.f22676i.g(j4, str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        C2446g.c();
        if (!this.f22670c.c()) {
            String A4 = A();
            if (A4 == null || !this.f22677j.d(A4)) {
                return false;
            }
            return true;
        }
        v0.g.f().i("Found previous crash marker.");
        this.f22670c.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void s(j jVar) {
        t(false, jVar, false);
    }

    /* access modifiers changed from: package-private */
    public void w(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, j jVar) {
        this.f22682o = jVar;
        O(str);
        C2409B b5 = new C2409B(new a(), jVar, uncaughtExceptionHandler, this.f22677j);
        this.f22681n = b5;
        Thread.setDefaultUncaughtExceptionHandler(b5);
    }

    /* access modifiers changed from: package-private */
    public boolean y(j jVar) {
        C2446g.c();
        if (I()) {
            v0.g.f().k("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        v0.g.f().i("Finalizing previously open sessions.");
        try {
            t(true, jVar, true);
            v0.g.f().i("Closed all previously open sessions.");
            return true;
        } catch (Exception e5) {
            v0.g.f().e("Unable to finalize previously open sessions.", e5);
            return false;
        }
    }
}
