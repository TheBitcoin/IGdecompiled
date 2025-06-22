package z0;

import android.os.Build;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import v0.g;

/* renamed from: z0.g  reason: case insensitive filesystem */
public final class C2446g {

    /* renamed from: e  reason: collision with root package name */
    public static final a f22849e = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static boolean f22850f;

    /* renamed from: a  reason: collision with root package name */
    public final C2444e f22851a;

    /* renamed from: b  reason: collision with root package name */
    public final C2444e f22852b;

    /* renamed from: c  reason: collision with root package name */
    public final C2444e f22853c;

    /* renamed from: d  reason: collision with root package name */
    public final C2444e f22854d;

    /* renamed from: z0.g$a */
    public static final class a {

        /* renamed from: z0.g$a$a  reason: collision with other inner class name */
        /* synthetic */ class C0276a extends k implements d3.a {
            C0276a(Object obj) {
                super(0, obj, a.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
            }

            /* renamed from: d */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).k());
            }
        }

        /* renamed from: z0.g$a$b */
        static final class b extends n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f22855a = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Must be called on a background thread, was called on " + C2446g.f22849e.j() + '.';
            }
        }

        /* renamed from: z0.g$a$c */
        /* synthetic */ class c extends k implements d3.a {
            c(Object obj) {
                super(0, obj, a.class, "isBlockingThread", "isBlockingThread()Z", 0);
            }

            /* renamed from: d */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).l());
            }
        }

        /* renamed from: z0.g$a$d */
        static final class d extends n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            public static final d f22856a = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Must be called on a blocking thread, was called on " + C2446g.f22849e.j() + '.';
            }
        }

        /* renamed from: z0.g$a$e */
        /* synthetic */ class e extends k implements d3.a {
            e(Object obj) {
                super(0, obj, a.class, "isNotMainThread", "isNotMainThread()Z", 0);
            }

            /* renamed from: d */
            public final Boolean invoke() {
                return Boolean.valueOf(((a) this.receiver).m());
            }
        }

        /* renamed from: z0.g$a$f */
        static final class f extends n implements d3.a {

            /* renamed from: a  reason: collision with root package name */
            public static final f f22857a = new f();

            f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Must not be called on a main thread, was called on " + C2446g.f22849e.j() + '.';
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private final void h(d3.a aVar, d3.a aVar2) {
            if (!((Boolean) aVar.invoke()).booleanValue()) {
                g.f().b((String) aVar2.invoke());
                i();
            }
        }

        /* access modifiers changed from: private */
        public final String j() {
            return Thread.currentThread().getName();
        }

        /* access modifiers changed from: private */
        public final boolean k() {
            String j4 = j();
            m.d(j4, "threadName");
            return m3.m.D(j4, "Firebase Background Thread #", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final boolean l() {
            String j4 = j();
            m.d(j4, "threadName");
            return m3.m.D(j4, "Firebase Blocking Thread #", false, 2, (Object) null);
        }

        /* access modifiers changed from: private */
        public final boolean m() {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Looper.getMainLooper().isCurrentThread()) {
                    return true;
                }
                return false;
            } else if (!m.a(Looper.getMainLooper(), Looper.myLooper())) {
                return true;
            } else {
                return false;
            }
        }

        public final void e() {
            h(new C0276a(this), b.f22855a);
        }

        public final void f() {
            h(new c(this), d.f22856a);
        }

        public final void g() {
            h(new e(this), f.f22857a);
        }

        public final boolean i() {
            return C2446g.f22850f;
        }

        public final void n(boolean z4) {
            C2446g.f22850f = z4;
        }

        private a() {
        }
    }

    public C2446g(ExecutorService executorService, ExecutorService executorService2) {
        m.e(executorService, "backgroundExecutorService");
        m.e(executorService2, "blockingExecutorService");
        this.f22851a = new C2444e(executorService);
        this.f22852b = new C2444e(executorService);
        this.f22853c = new C2444e(executorService);
        this.f22854d = new C2444e(executorService2);
    }

    public static final void c() {
        f22849e.e();
    }

    public static final void d() {
        f22849e.f();
    }

    public static final void e() {
        f22849e.g();
    }

    public static final void f(boolean z4) {
        f22849e.n(z4);
    }
}
