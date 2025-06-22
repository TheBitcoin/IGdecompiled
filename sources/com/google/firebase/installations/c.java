package com.google.firebase.installations;

import M.C0335p;
import S0.e;
import S0.g;
import T0.d;
import U0.f;
import android.text.TextUtils;
import com.google.firebase.installations.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;
import p0.C2194f;
import s0.x;

public class c implements e {

    /* renamed from: m  reason: collision with root package name */
    private static final Object f11184m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static final ThreadFactory f11185n = new a();

    /* renamed from: a  reason: collision with root package name */
    private final C2194f f11186a;

    /* renamed from: b  reason: collision with root package name */
    private final U0.c f11187b;

    /* renamed from: c  reason: collision with root package name */
    private final T0.c f11188c;

    /* renamed from: d  reason: collision with root package name */
    private final i f11189d;

    /* renamed from: e  reason: collision with root package name */
    private final x f11190e;

    /* renamed from: f  reason: collision with root package name */
    private final g f11191f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f11192g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f11193h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f11194i;

    /* renamed from: j  reason: collision with root package name */
    private String f11195j;

    /* renamed from: k  reason: collision with root package name */
    private Set f11196k;

    /* renamed from: l  reason: collision with root package name */
    private final List f11197l;

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f11198a = new AtomicInteger(1);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.f11198a.getAndIncrement())}));
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11199a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f11200b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                U0.f$b[] r0 = U0.f.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11200b = r0
                r1 = 1
                U0.f$b r2 = U0.f.b.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f11200b     // Catch:{ NoSuchFieldError -> 0x001d }
                U0.f$b r3 = U0.f.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f11200b     // Catch:{ NoSuchFieldError -> 0x0028 }
                U0.f$b r3 = U0.f.b.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                U0.d$b[] r2 = U0.d.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f11199a = r2
                U0.d$b r3 = U0.d.b.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f11199a     // Catch:{ NoSuchFieldError -> 0x0043 }
                U0.d$b r2 = U0.d.b.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.b.<clinit>():void");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    c(p0.C2194f r10, R0.b r11, java.util.concurrent.ExecutorService r12, java.util.concurrent.Executor r13) {
        /*
            r9 = this;
            U0.c r4 = new U0.c
            android.content.Context r0 = r10.k()
            r4.<init>(r0, r11)
            T0.c r5 = new T0.c
            r5.<init>(r10)
            com.google.firebase.installations.i r6 = com.google.firebase.installations.i.c()
            s0.x r7 = new s0.x
            S0.a r11 = new S0.a
            r11.<init>(r10)
            r7.<init>(r11)
            S0.g r8 = new S0.g
            r8.<init>()
            r0 = r9
            r3 = r10
            r1 = r12
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.<init>(p0.f, R0.b, java.util.concurrent.ExecutorService, java.util.concurrent.Executor):void");
    }

    private synchronized void A(String str) {
        this.f11195j = str;
    }

    private synchronized void B(d dVar, d dVar2) {
        if (this.f11196k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator it = this.f11196k.iterator();
            if (it.hasNext()) {
                android.support.v4.media.a.a(it.next());
                dVar2.d();
                throw null;
            }
        }
    }

    public static /* synthetic */ T0.b e(C2194f fVar) {
        return new T0.b(fVar);
    }

    private C0937l f() {
        C0938m mVar = new C0938m();
        h(new e(this.f11189d, mVar));
        return mVar.a();
    }

    private C0937l g() {
        C0938m mVar = new C0938m();
        h(new f(mVar));
        return mVar.a();
    }

    private void h(h hVar) {
        synchronized (this.f11192g) {
            this.f11197l.add(hVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(boolean r3) {
        /*
            r2 = this;
            T0.d r0 = r2.r()
            boolean r1 = r0.i()     // Catch:{ d -> 0x001d }
            if (r1 != 0) goto L_0x0024
            boolean r1 = r0.l()     // Catch:{ d -> 0x001d }
            if (r1 == 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            if (r3 != 0) goto L_0x001f
            com.google.firebase.installations.i r3 = r2.f11189d     // Catch:{ d -> 0x001d }
            boolean r3 = r3.f(r0)     // Catch:{ d -> 0x001d }
            if (r3 == 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            return
        L_0x001d:
            r3 = move-exception
            goto L_0x0061
        L_0x001f:
            T0.d r3 = r2.k(r0)     // Catch:{ d -> 0x001d }
            goto L_0x0028
        L_0x0024:
            T0.d r3 = r2.x(r0)     // Catch:{ d -> 0x001d }
        L_0x0028:
            r2.u(r3)
            r2.B(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.d()
            r2.A(r0)
        L_0x003b:
            boolean r0 = r3.i()
            if (r0 == 0) goto L_0x004c
            com.google.firebase.installations.d r3 = new com.google.firebase.installations.d
            com.google.firebase.installations.d$a r0 = com.google.firebase.installations.d.a.BAD_CONFIG
            r3.<init>(r0)
            r2.y(r3)
            return
        L_0x004c:
            boolean r0 = r3.j()
            if (r0 == 0) goto L_0x005d
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.y(r3)
            return
        L_0x005d:
            r2.z(r3)
            return
        L_0x0061:
            r2.y(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.i(boolean):void");
    }

    /* access modifiers changed from: private */
    public final void j(boolean z4) {
        d s4 = s();
        if (z4) {
            s4 = s4.p();
        }
        z(s4);
        this.f11194i.execute(new S0.d(this, z4));
    }

    private d k(d dVar) {
        f e5 = this.f11187b.e(l(), dVar.d(), t(), dVar.f());
        int i4 = b.f11200b[e5.b().ordinal()];
        if (i4 == 1) {
            return dVar.o(e5.c(), e5.d(), this.f11189d.b());
        } else if (i4 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            if (i4 == 3) {
                A((String) null);
                return dVar.r();
            }
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
    }

    private synchronized String n() {
        return this.f11195j;
    }

    private T0.b o() {
        return (T0.b) this.f11190e.get();
    }

    public static c p() {
        return q(C2194f.l());
    }

    public static c q(C2194f fVar) {
        boolean z4;
        if (fVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.b(z4, "Null is not a valid value of FirebaseApp.");
        return (c) fVar.j(e.class);
    }

    private T0.d r() {
        b a5;
        T0.d d5;
        synchronized (f11184m) {
            try {
                a5 = b.a(this.f11186a.k(), "generatefid.lock");
                d5 = this.f11188c.d();
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d5;
    }

    private T0.d s() {
        b a5;
        T0.d d5;
        synchronized (f11184m) {
            try {
                a5 = b.a(this.f11186a.k(), "generatefid.lock");
                d5 = this.f11188c.d();
                if (d5.j()) {
                    d5 = this.f11188c.b(d5.t(w(d5)));
                }
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d5;
    }

    private void u(T0.d dVar) {
        b a5;
        synchronized (f11184m) {
            try {
                a5 = b.a(this.f11186a.k(), "generatefid.lock");
                this.f11188c.b(dVar);
                if (a5 != null) {
                    a5.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void v() {
        C0335p.g(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0335p.g(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0335p.g(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0335p.b(i.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        C0335p.b(i.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String w(T0.d dVar) {
        if ((!this.f11186a.m().equals("CHIME_ANDROID_SDK") && !this.f11186a.u()) || !dVar.m()) {
            return this.f11191f.a();
        }
        String f4 = o().f();
        if (TextUtils.isEmpty(f4)) {
            return this.f11191f.a();
        }
        return f4;
    }

    private T0.d x(T0.d dVar) {
        String str;
        if (dVar.d() == null || dVar.d().length() != 11) {
            str = null;
        } else {
            str = o().i();
        }
        U0.d d5 = this.f11187b.d(l(), dVar.d(), t(), m(), str);
        int i4 = b.f11199a[d5.e().ordinal()];
        if (i4 == 1) {
            return dVar.s(d5.c(), d5.d(), this.f11189d.b(), d5.b().c(), d5.b().d());
        } else if (i4 == 2) {
            return dVar.q("BAD CONFIG");
        } else {
            throw new d("Firebase Installations Service is unavailable. Please try again later.", d.a.UNAVAILABLE);
        }
    }

    private void y(Exception exc) {
        synchronized (this.f11192g) {
            try {
                Iterator it = this.f11197l.iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).b(exc)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    private void z(T0.d dVar) {
        synchronized (this.f11192g) {
            try {
                Iterator it = this.f11197l.iterator();
                while (it.hasNext()) {
                    if (((h) it.next()).a(dVar)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    public C0937l a(boolean z4) {
        v();
        C0937l f4 = f();
        this.f11193h.execute(new S0.c(this, z4));
        return f4;
    }

    public C0937l getId() {
        v();
        String n4 = n();
        if (n4 != null) {
            return C0940o.e(n4);
        }
        C0937l g4 = g();
        this.f11193h.execute(new S0.b(this));
        return g4;
    }

    /* access modifiers changed from: package-private */
    public String l() {
        return this.f11186a.n().b();
    }

    /* access modifiers changed from: package-private */
    public String m() {
        return this.f11186a.n().c();
    }

    /* access modifiers changed from: package-private */
    public String t() {
        return this.f11186a.n().e();
    }

    c(ExecutorService executorService, Executor executor, C2194f fVar, U0.c cVar, T0.c cVar2, i iVar, x xVar, g gVar) {
        this.f11192g = new Object();
        this.f11196k = new HashSet();
        this.f11197l = new ArrayList();
        this.f11186a = fVar;
        this.f11187b = cVar;
        this.f11188c = cVar2;
        this.f11189d = iVar;
        this.f11190e = xVar;
        this.f11191f = gVar;
        this.f11193h = executorService;
        this.f11194i = executor;
    }
}
