package N1;

import O1.M0;
import O1.r;
import R2.n;
import R2.s;
import U1.h;
import U1.i;
import V2.g;
import W1.C1609e;
import W1.C1612h;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import androidx.documentfile.provider.DocumentFile;
import androidx.multidex.MultiDexApplication;
import androidx.work.PeriodicWorkRequest;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public abstract class k extends MultiDexApplication {

    /* renamed from: g  reason: collision with root package name */
    public static final a f7778g = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static Activity f7779h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static T1.f f7780i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static int f7781j;

    /* renamed from: k  reason: collision with root package name */
    public static Context f7782k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static int f7783l;

    /* renamed from: m  reason: collision with root package name */
    public static String f7784m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static ResultReceiver f7785n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static String f7786o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static T1.a f7787p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static T1.c f7788q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static Typeface f7789r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public static Typeface f7790s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public static h f7791t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static U1.c f7792u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static boolean f7793v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static String f7794w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static String f7795x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static String f7796y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public static String f7797z;

    /* renamed from: a  reason: collision with root package name */
    private ResultReceiver f7798a = new V1.a((Handler) null);

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f7799b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f7800c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f7801d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private i f7802e = O();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public NsdManager.RegistrationListener f7803f = new c(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void A(Activity activity) {
            k.f7779h = activity;
        }

        public final void B(Context context) {
            m.e(context, "<set-?>");
            k.f7782k = context;
        }

        public final void C(T1.c cVar) {
            k.f7788q = cVar;
        }

        public final void D(String str) {
            k.f7794w = str;
        }

        public final void E(String str) {
            k.f7795x = str;
        }

        public final void F(T1.f fVar) {
            k.f7780i = fVar;
        }

        public final void G(int i4) {
            k.f7781j = i4;
        }

        public final void H(h hVar) {
            k.f7791t = hVar;
        }

        public final void I(String str) {
            m.e(str, "<set-?>");
            k.f7784m = str;
        }

        public final void J(int i4) {
            k.f7783l = i4;
        }

        public final void K(U1.c cVar) {
            k.f7792u = cVar;
        }

        public final void L(boolean z4) {
            k.f7793v = z4;
        }

        public final void M(String str) {
            k.f7797z = str;
        }

        public final void N(String str) {
            k.f7796y = str;
        }

        public final void O(String str) {
            k.f7786o = str;
        }

        public final void P(ResultReceiver resultReceiver) {
            k.f7785n = resultReceiver;
        }

        public final void Q(int i4) {
            T1.c j4 = j();
            if (j4 != null) {
                j4.d(i4);
            }
        }

        public final Context a(Context context) {
            m.e(context, "context");
            String f4 = new P1.a(context).f();
            if (f4 == null) {
                return context;
            }
            return C1609e.f8671a.a(context, new Locale(f4));
        }

        public final void b() {
            c((String) null);
        }

        public final void c(String str) {
            File[] listFiles = new C1612h().g(h()).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!m3.m.p(file.getAbsolutePath(), str, true) && file.lastModified() < System.currentTimeMillis() - ((long) 3600000)) {
                        W1.i iVar = new W1.i();
                        m.d(file, "child");
                        iVar.a(file);
                    }
                }
            }
        }

        public final void d(Context context, EditText editText) {
            IBinder iBinder;
            m.e(context, "<this>");
            Object systemService = context.getSystemService("input_method");
            m.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (editText != null) {
                iBinder = editText.getWindowToken();
            } else {
                iBinder = null;
            }
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }

        public final void e() {
            k.f7787p = null;
        }

        public final void f() {
            C((T1.c) null);
        }

        public final Activity g() {
            return k.f7779h;
        }

        public final Context h() {
            Context context = k.f7782k;
            if (context != null) {
                return context;
            }
            m.u("appContext");
            return null;
        }

        public final T1.a i() {
            if (k.f7787p == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            T1.a b5 = k.f7787p;
            m.b(b5);
            if (currentTimeMillis - b5.d() > PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                k.f7787p = null;
            }
            return k.f7787p;
        }

        public final T1.c j() {
            return k.f7788q;
        }

        public final String k() {
            return k.f7794w;
        }

        public final String l() {
            return k.f7795x;
        }

        public final T1.f m() {
            return k.f7780i;
        }

        public final int n() {
            return k.f7781j;
        }

        public final h o() {
            return k.f7791t;
        }

        public final String p() {
            String str = k.f7784m;
            if (str != null) {
                return str;
            }
            m.u("myNsdServiceName");
            return null;
        }

        public final int q() {
            return k.f7783l;
        }

        public final U1.c r() {
            return k.f7792u;
        }

        public final boolean s() {
            return k.f7793v;
        }

        public final String t() {
            return k.f7797z;
        }

        public final String u() {
            return k.f7796y;
        }

        public final ResultReceiver v() {
            return k.f7785n;
        }

        public final Typeface w() {
            return k.f7789r;
        }

        public final Typeface x() {
            return k.f7790s;
        }

        public final void y(String str, long j4, String str2, long j5) {
            m.e(str, "packageName");
            m.e(str2, RewardPlus.NAME);
            k.f7787p = new T1.a();
            T1.a b5 = k.f7787p;
            if (b5 != null) {
                b5.f(str, j4, str2, j5);
            }
        }

        public final void z(String str, int i4) {
            m.e(str, "filename");
            C(new T1.c());
            T1.c j4 = j();
            if (j4 != null) {
                j4.c(str, i4);
            }
        }

        private a() {
        }
    }

    public static final class c implements NsdManager.RegistrationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f7805a;

        c(k kVar) {
            this.f7805a = kVar;
        }

        public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i4) {
            m.e(nsdServiceInfo, "nsdServiceInfo");
            this.f7805a.Q("onRegistrationFailed");
            this.f7805a.T();
        }

        public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, "nsdServiceInfo");
            a aVar = k.f7778g;
            String serviceName = nsdServiceInfo.getServiceName();
            m.d(serviceName, "nsdServiceInfo.serviceName");
            aVar.I(serviceName);
            this.f7805a.f7801d.set(true);
        }

        public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, "nsdServiceInfo");
            this.f7805a.W();
        }

        public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i4) {
            m.e(nsdServiceInfo, "nsdServiceInfo");
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f7806a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DocumentFile f7807b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f7808c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f7809a;

            a(V2.d dVar) {
                super(2, dVar);
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f7809a == 0) {
                    n.b(obj);
                    a aVar = k.f7778g;
                    if (aVar.g() != null && (aVar.g() instanceof M0)) {
                        Activity g4 = aVar.g();
                        m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                        ((M0) g4).q1(true);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f7810a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C f7811b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ k f7812c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C c5, k kVar, V2.d dVar) {
                super(2, dVar);
                this.f7811b = c5;
                this.f7812c = kVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f7811b, this.f7812c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f7810a == 0) {
                    n.b(obj);
                    Object obj2 = this.f7811b.f20968a;
                    if (obj2 != null) {
                        this.f7812c.V((File) obj2);
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(DocumentFile documentFile, k kVar, V2.d dVar) {
            super(2, dVar);
            this.f7807b = documentFile;
            this.f7808c = kVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f7807b, this.f7808c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
            if (o3.C0977g.g(r11, r1, r10) == r0) goto L_0x00b2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b2, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
            if (o3.C0977g.g(r11, r1, r10) == r0) goto L_0x00b2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r10.f7806a
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0020
                if (r1 == r3) goto L_0x001c
                if (r1 != r2) goto L_0x0014
                R2.n.b(r11)
                goto L_0x00b3
            L_0x0014:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001c:
                R2.n.b(r11)
                goto L_0x0036
            L_0x0020:
                R2.n.b(r11)
                o3.E0 r11 = o3.Y.c()
                N1.k$d$a r1 = new N1.k$d$a
                r1.<init>(r4)
                r10.f7806a = r3
                java.lang.Object r11 = o3.C0977g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x0036
                goto L_0x00b2
            L_0x0036:
                N1.k$a r11 = N1.k.f7778g
                android.content.Context r1 = r11.h()
                android.content.ContentResolver r1 = r1.getContentResolver()
                if (r1 == 0) goto L_0x004d
                androidx.documentfile.provider.DocumentFile r3 = r10.f7807b
                android.net.Uri r3 = r3.getUri()
                java.io.InputStream r1 = r1.openInputStream(r3)
                goto L_0x004e
            L_0x004d:
                r1 = r4
            L_0x004e:
                kotlin.jvm.internal.C r3 = new kotlin.jvm.internal.C
                r3.<init>()
                if (r1 == 0) goto L_0x009f
                r5 = 8192(0x2000, float:1.14794E-41)
                byte[] r6 = new byte[r5]
                kotlin.jvm.internal.A r7 = new kotlin.jvm.internal.A
                r7.<init>()
                W1.h r8 = new W1.h
                r8.<init>()
                android.content.Context r11 = r11.h()
                java.io.File r11 = r8.g(r11)
                androidx.documentfile.provider.DocumentFile r8 = r10.f7807b
                java.lang.String r8 = r8.getName()
                if (r8 == 0) goto L_0x009c
                java.io.File r8 = new java.io.File
                androidx.documentfile.provider.DocumentFile r9 = r10.f7807b
                java.lang.String r9 = r9.getName()
                kotlin.jvm.internal.m.b(r9)
                r8.<init>(r11, r9)
                r3.f20968a = r8
                java.io.FileOutputStream r11 = new java.io.FileOutputStream
                java.lang.Object r8 = r3.f20968a
                java.io.File r8 = (java.io.File) r8
                r11.<init>(r8)
            L_0x008c:
                r8 = 0
                int r9 = r1.read(r6, r8, r5)
                r7.f20966a = r9
                if (r9 <= 0) goto L_0x0099
                r11.write(r6, r8, r9)
                goto L_0x008c
            L_0x0099:
                r11.close()
            L_0x009c:
                r1.close()
            L_0x009f:
                o3.E0 r11 = o3.Y.c()
                N1.k$d$b r1 = new N1.k$d$b
                N1.k r5 = r10.f7808c
                r1.<init>(r3, r5, r4)
                r10.f7806a = r2
                java.lang.Object r11 = o3.C0977g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x00b3
            L_0x00b2:
                return r0
            L_0x00b3:
                R2.s r11 = R2.s.f8222a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: N1.k.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f7813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f7814b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DocumentFile f7815c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(k kVar, DocumentFile documentFile, V2.d dVar) {
            super(2, dVar);
            this.f7814b = kVar;
            this.f7815c = documentFile;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f7814b, this.f7815c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f7813a;
            if (i4 == 0) {
                n.b(obj);
                k kVar = this.f7814b;
                DocumentFile documentFile = this.f7815c;
                this.f7813a = 1;
                if (kVar.R(documentFile, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f7816a;

        f(k kVar) {
            this.f7816a = kVar;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.e(activity, "activity");
            if (activity instanceof M0) {
                a aVar = k.f7778g;
                aVar.J(aVar.q() + 1);
                if (aVar.q() == 1) {
                    this.f7816a.P(activity);
                }
            }
        }

        public void onActivityDestroyed(Activity activity) {
            m.e(activity, "activity");
            if (activity instanceof M0) {
                a aVar = k.f7778g;
                if (aVar.q() > 0) {
                    aVar.J(aVar.q() - 1);
                }
                if (aVar.q() == 0) {
                    this.f7816a.S();
                    aVar.H((h) null);
                    aVar.K((U1.c) null);
                }
            }
        }

        public void onActivityPaused(Activity activity) {
            m.e(activity, "activity");
            k.f7778g.A((Activity) null);
        }

        public void onActivityResumed(Activity activity) {
            m.e(activity, "activity");
            k.f7778g.A(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.e(activity, "activity");
            m.e(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            m.e(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            m.e(activity, "activity");
        }
    }

    private final i O() {
        return new b(this);
    }

    /* access modifiers changed from: private */
    public final Object R(DocumentFile documentFile, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(documentFile, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void Y() {
        AssetManager assetManager;
        try {
            assetManager = getAssets();
        } catch (Exception e5) {
            e5.printStackTrace();
            assetManager = null;
        }
        if (assetManager != null) {
            f7789r = Typeface.createFromAsset(assetManager, "fonts/Geomanist-Medium.ttf");
            f7790s = Typeface.createFromAsset(assetManager, "fonts/Geomanist-Regular.ttf");
            return;
        }
        Typeface typeface = Typeface.DEFAULT;
        f7789r = typeface;
        f7790s = typeface;
    }

    private final void Z() {
        registerActivityLifecycleCallbacks(new f(this));
    }

    /* access modifiers changed from: private */
    public final void a0() {
        NsdManager f4;
        try {
            h hVar = f7791t;
            if (hVar != null && (f4 = hVar.f()) != null) {
                f4.unregisterService(this.f7803f);
            }
        } catch (Exception unused) {
        }
    }

    public void J(Uri uri, S1.f fVar, r rVar) {
        m.e(uri, "uri");
        m.e(fVar, "listener");
        m.e(rVar, "coreBaseActivity");
        fVar.a();
    }

    public void K(File file, S1.f fVar, r rVar) {
        m.e(file, "file");
        m.e(fVar, "listener");
        m.e(rVar, "coreBaseActivity");
        fVar.a();
    }

    public final void L() {
        if (!this.f7801d.get() && this.f7799b.compareAndSet(true, false)) {
            P(f7778g.h());
        }
    }

    public final AtomicBoolean M() {
        return this.f7800c;
    }

    public final ResultReceiver N() {
        return this.f7798a;
    }

    public final void P(Context context) {
        m.e(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        a aVar = f7778g;
        h.a aVar2 = h.f8425h;
        m.d(string, "deviceId");
        aVar.I(aVar2.b(string));
        if (f7791t == null) {
            f7791t = new h(context, this.f7802e);
        }
        f7792u = new U1.c(this.f7802e, context);
    }

    public abstract void Q(String str);

    public final void S() {
        a0();
        U1.c cVar = f7792u;
        if (cVar != null) {
            cVar.r();
        }
        h hVar = f7791t;
        if (hVar != null) {
            hVar.j();
        }
    }

    public final void T() {
        if (this.f7799b.compareAndSet(false, true)) {
            S();
        }
    }

    public final void U(DocumentFile documentFile) {
        m.e(documentFile, "docfile");
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new e(this, documentFile, (V2.d) null), 3, (Object) null);
    }

    public final void V(File file) {
        m.e(file, "file");
        T1.e eVar = new T1.e();
        eVar.a(file);
        U1.c cVar = f7792u;
        m.b(cVar);
        cVar.q(eVar);
    }

    public final void W() {
        if (this.f7799b.get()) {
            this.f7801d.set(false);
        }
        if (!this.f7800c.get() && this.f7799b.compareAndSet(true, false)) {
            P(f7778g.h());
        }
    }

    public final void X(ResultReceiver resultReceiver) {
        m.e(resultReceiver, "<set-?>");
        this.f7798a = resultReceiver;
    }

    public void onCreate() {
        super.onCreate();
        Z();
        a aVar = f7778g;
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "applicationContext");
        aVar.B(aVar.a(applicationContext));
        Y();
    }

    public static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f7804a;

        b(k kVar) {
            this.f7804a = kVar;
        }

        public void a() {
            U1.c r4 = k.f7778g.r();
            if (r4 != null) {
                r4.c();
            }
        }

        public void b() {
            this.f7804a.Q("onReadResponseFailed");
            this.f7804a.T();
        }

        public void c() {
            this.f7804a.Q("onConnectionToServerFailed");
            this.f7804a.T();
        }

        public void d(String str) {
            U1.c r4;
            U1.d i4;
            m.e(str, "remoteSocketAddress");
            a aVar = k.f7778g;
            U1.c r5 = aVar.r();
            m.b(r5);
            if (r5.k()) {
                if (aVar.g() != null && (aVar.g() instanceof M0)) {
                    Activity g4 = aVar.g();
                    m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                    ((M0) g4).X0();
                }
            } else if (aVar.o() != null && (r4 = aVar.r()) != null && (i4 = r4.i()) != null) {
                i4.l();
            }
        }

        public void e() {
            this.f7804a.Q("onDiscoveryServicesFailed");
        }

        public void f(int i4) {
            this.f7804a.a0();
            a aVar = k.f7778g;
            h o4 = aVar.o();
            if (o4 != null) {
                o4.i(i4, this.f7804a.f7803f);
            }
            h o5 = aVar.o();
            if (o5 != null) {
                o5.d();
            }
        }

        public void g() {
            this.f7804a.M().set(false);
            this.f7804a.L();
        }

        public void i() {
            this.f7804a.Q("onRegistrationFailed");
            this.f7804a.T();
        }

        public void j(T1.e eVar) {
            m.e(eVar, "fti");
            a aVar = k.f7778g;
            if (aVar.g() != null && (aVar.g() instanceof M0)) {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).L0(eVar);
            }
        }

        public void k() {
            this.f7804a.Q("onReadResponseClosed");
            this.f7804a.T();
        }

        public void l() {
            a aVar = k.f7778g;
            if (aVar.g() == null || !(aVar.g() instanceof M0)) {
                aVar.L(true);
            } else {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).T0();
            }
            U1.c r4 = aVar.r();
            m.b(r4);
            r4.i().l();
        }

        public void m(String str) {
            m.e(str, NotificationCompat.CATEGORY_MESSAGE);
            k kVar = this.f7804a;
            kVar.Q("onReceivingFileError: " + str);
            a aVar = k.f7778g;
            if (aVar.g() == null || !(aVar.g() instanceof M0)) {
                aVar.M(str);
            } else {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).Y0(str);
            }
            this.f7804a.T();
        }

        public void n(int i4) {
            a aVar = k.f7778g;
            if (aVar.g() != null && (aVar.g() instanceof M0)) {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).u1(i4);
            }
        }

        public void o(int i4) {
            a aVar = k.f7778g;
            if (aVar.g() != null && (aVar.g() instanceof M0)) {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).u1(i4);
            }
        }

        public void p(String str) {
            m.e(str, NotificationCompat.CATEGORY_MESSAGE);
            this.f7804a.Q(str);
            this.f7804a.T();
        }

        public void r(String str) {
            NsdServiceInfo nsdServiceInfo;
            m.e(str, "serviceName");
            a aVar = k.f7778g;
            U1.c r4 = aVar.r();
            m.b(r4);
            if (!r4.k()) {
                h o4 = aVar.o();
                m.b(o4);
                ArrayList g4 = o4.g();
                int size = g4.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        nsdServiceInfo = null;
                        break;
                    }
                    Object obj = g4.get(i4);
                    i4++;
                    nsdServiceInfo = (NsdServiceInfo) obj;
                    if (m3.m.p(str, nsdServiceInfo.getServiceName(), true)) {
                        break;
                    }
                }
                if (nsdServiceInfo != null) {
                    h o5 = k.f7778g.o();
                    m.b(o5);
                    o5.k(nsdServiceInfo);
                    return;
                }
                this.f7804a.T();
                a aVar2 = k.f7778g;
                if (aVar2.g() != null && (aVar2.g() instanceof M0)) {
                    Activity g5 = aVar2.g();
                    m.c(g5, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                    String string = aVar2.h().getString(i.error_nsd_service_not_found, new Object[]{h.f8425h.c(str)});
                    m.d(string, "appContext.getString(\n  …                        )");
                    ((M0) g5).Y0(string);
                }
            }
        }

        public void s() {
            this.f7804a.M().set(true);
        }

        public void t(File file) {
            m.e(file, "file");
            a aVar = k.f7778g;
            if (aVar.g() != null && (aVar.g() instanceof M0)) {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).s1();
            }
        }

        public void u(T1.e eVar) {
            U1.c r4;
            U1.a h4;
            m.e(eVar, "fti");
            if (eVar.d() != null && (r4 = k.f7778g.r()) != null && (h4 = r4.h()) != null) {
                File d5 = eVar.d();
                m.b(d5);
                h4.f(d5);
            }
        }

        public void v() {
            U1.c r4 = k.f7778g.r();
            m.b(r4);
            r4.i().l();
        }

        public void w(T1.e eVar) {
            m.e(eVar, "fti");
            U1.c r4 = k.f7778g.r();
            m.b(r4);
            r4.i().m(eVar);
        }

        public void x(String str) {
            m.e(str, NotificationCompat.CATEGORY_MESSAGE);
            k kVar = this.f7804a;
            kVar.Q("onSendFileFailed: " + str);
            this.f7804a.T();
            a aVar = k.f7778g;
            if (aVar.g() == null || !(aVar.g() instanceof M0)) {
                aVar.N(str);
                return;
            }
            Activity g4 = aVar.g();
            m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
            ((M0) g4).d1(str);
        }

        public void y(String str, String str2) {
            U1.a h4;
            m.e(str, "filename");
            m.e(str2, "result");
            a aVar = k.f7778g;
            if (aVar.g() == null || !(aVar.g() instanceof M0)) {
                aVar.D(str);
                aVar.E(str2);
            } else {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).R0(str, str2);
            }
            U1.c r4 = aVar.r();
            if (r4 != null && (h4 = r4.h()) != null) {
                h4.e();
            }
        }

        public void z(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, "nsdServiceInfo");
            a aVar = k.f7778g;
            U1.c r4 = aVar.r();
            if (r4 != null) {
                r4.p();
            }
            if (aVar.g() != null && (aVar.g() instanceof M0)) {
                Activity g4 = aVar.g();
                m.c(g4, "null cannot be cast to non-null type com.uptodown.core.activities.NsdActivity");
                ((M0) g4).b1(nsdServiceInfo);
            }
        }

        public void h() {
        }

        public void q() {
        }
    }
}
