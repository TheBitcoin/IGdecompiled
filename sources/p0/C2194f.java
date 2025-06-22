package p0;

import M.C0333n;
import M.C0335p;
import P0.f;
import R.k;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import androidx.lifecycle.i;
import com.google.android.gms.common.api.internal.C0502a;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import s0.C2268c;
import s0.C2272g;
import s0.o;
import s0.x;
import t0.m;

/* renamed from: p0.f  reason: case insensitive filesystem */
public class C2194f {
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Object f21437k = new Object();

    /* renamed from: l  reason: collision with root package name */
    static final Map f21438l = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f21439a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21440b;

    /* renamed from: c  reason: collision with root package name */
    private final o f21441c;

    /* renamed from: d  reason: collision with root package name */
    private final o f21442d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f21443e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f21444f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private final x f21445g;

    /* renamed from: h  reason: collision with root package name */
    private final R0.b f21446h;

    /* renamed from: i  reason: collision with root package name */
    private final List f21447i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List f21448j = new CopyOnWriteArrayList();

    /* renamed from: p0.f$a */
    public interface a {
        void a(boolean z4);
    }

    /* renamed from: p0.f$b */
    private static class b implements C0502a.C0023a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference f21449a = new AtomicReference();

        private b() {
        }

        /* access modifiers changed from: private */
        public static void c(Context context) {
            if (k.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f21449a.get() == null) {
                    b bVar = new b();
                    if (i.a(f21449a, (Object) null, bVar)) {
                        C0502a.c(application);
                        C0502a.b().a(bVar);
                    }
                }
            }
        }

        public void a(boolean z4) {
            synchronized (C2194f.f21437k) {
                try {
                    ArrayList arrayList = new ArrayList(C2194f.f21438l.values());
                    int size = arrayList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        C2194f fVar = (C2194f) obj;
                        if (fVar.f21443e.get()) {
                            fVar.w(z4);
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: p0.f$c */
    private static class c extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference f21450b = new AtomicReference();

        /* renamed from: a  reason: collision with root package name */
        private final Context f21451a;

        public c(Context context) {
            this.f21451a = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f21450b.get() == null) {
                c cVar = new c(context);
                if (i.a(f21450b, (Object) null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f21451a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (C2194f.f21437k) {
                try {
                    for (C2194f d5 : C2194f.f21438l.values()) {
                        d5.p();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            c();
        }
    }

    protected C2194f(Context context, String str, o oVar) {
        this.f21439a = (Context) C0335p.l(context);
        this.f21440b = C0335p.f(str);
        this.f21441c = (o) C0335p.l(oVar);
        p b5 = FirebaseInitProvider.b();
        e1.c.b("Firebase");
        e1.c.b("ComponentDiscovery");
        List b6 = C2272g.c(context, ComponentDiscoveryService.class).b();
        e1.c.a();
        e1.c.b("Runtime");
        o.b f4 = o.m(m.INSTANCE).d(b6).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(C2268c.q(context, Context.class, new Class[0])).b(C2268c.q(this, C2194f.class, new Class[0])).b(C2268c.q(oVar, o.class, new Class[0])).f(new e1.b());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.c()) {
            f4.b(C2268c.q(b5, p.class, new Class[0]));
        }
        o e5 = f4.e();
        this.f21442d = e5;
        e1.c.a();
        this.f21445g = new x(new C2192d(this, context));
        this.f21446h = e5.d(f.class);
        g(new C2193e(this));
        e1.c.a();
    }

    public static /* synthetic */ void a(C2194f fVar, boolean z4) {
        if (!z4) {
            ((f) fVar.f21446h.get()).h();
        } else {
            fVar.getClass();
        }
    }

    public static /* synthetic */ W0.a b(C2194f fVar, Context context) {
        return new W0.a(context, fVar.o(), (O0.c) fVar.f21442d.a(O0.c.class));
    }

    private void i() {
        C0335p.p(!this.f21444f.get(), "FirebaseApp was deleted");
    }

    public static C2194f l() {
        C2194f fVar;
        synchronized (f21437k) {
            try {
                fVar = (C2194f) f21438l.get("[DEFAULT]");
                if (fVar != null) {
                    ((f) fVar.f21446h.get()).h();
                } else {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + R.m.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public void p() {
        if (!UserManagerCompat.isUserUnlocked(this.f21439a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + m());
            c.b(this.f21439a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + m());
        this.f21442d.p(u());
        ((f) this.f21446h.get()).h();
    }

    public static C2194f q(Context context) {
        synchronized (f21437k) {
            try {
                if (f21438l.containsKey("[DEFAULT]")) {
                    C2194f l4 = l();
                    return l4;
                }
                o a5 = o.a(context);
                if (a5 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                C2194f r4 = r(context, a5);
                return r4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static C2194f r(Context context, o oVar) {
        return s(context, oVar, "[DEFAULT]");
    }

    public static C2194f s(Context context, o oVar, String str) {
        C2194f fVar;
        b.c(context);
        String v4 = v(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f21437k) {
            Map map = f21438l;
            C0335p.p(!map.containsKey(v4), "FirebaseApp name " + v4 + " already exists!");
            C0335p.m(context, "Application context cannot be null.");
            fVar = new C2194f(context, v4, oVar);
            map.put(v4, fVar);
        }
        fVar.p();
        return fVar;
    }

    private static String v(String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    public void w(boolean z4) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a a5 : this.f21447i) {
            a5.a(z4);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2194f)) {
            return false;
        }
        return this.f21440b.equals(((C2194f) obj).m());
    }

    public void g(a aVar) {
        i();
        if (this.f21443e.get() && C0502a.b().d()) {
            aVar.a(true);
        }
        this.f21447i.add(aVar);
    }

    public void h(C2195g gVar) {
        i();
        C0335p.l(gVar);
        this.f21448j.add(gVar);
    }

    public int hashCode() {
        return this.f21440b.hashCode();
    }

    public Object j(Class cls) {
        i();
        return this.f21442d.a(cls);
    }

    public Context k() {
        i();
        return this.f21439a;
    }

    public String m() {
        i();
        return this.f21440b;
    }

    public o n() {
        i();
        return this.f21441c;
    }

    public String o() {
        return R.c.a(m().getBytes(Charset.defaultCharset())) + "+" + R.c.a(n().c().getBytes(Charset.defaultCharset()));
    }

    public boolean t() {
        i();
        return ((W0.a) this.f21445g.get()).b();
    }

    public String toString() {
        return C0333n.c(this).a(RewardPlus.NAME, this.f21440b).a("options", this.f21441c).toString();
    }

    public boolean u() {
        return "[DEFAULT]".equals(m());
    }
}
