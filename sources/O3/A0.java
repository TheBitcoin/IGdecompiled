package o3;

import R2.s;
import V2.g;
import d3.l;
import d3.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import t3.C1066p;
import t3.C1067q;
import t3.y;

public class A0 implements C1001s0, C1004u, J0 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3625a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3626b;
    private volatile Object _parentHandle;
    private volatile Object _state;

    private static final class a extends C0991n {

        /* renamed from: i  reason: collision with root package name */
        private final A0 f3627i;

        public a(V2.d dVar, A0 a02) {
            super(dVar, 1);
            this.f3627i = a02;
        }

        /* access modifiers changed from: protected */
        public String H() {
            return "AwaitContinuation";
        }

        public Throwable t(C1001s0 s0Var) {
            Throwable e5;
            Object f02 = this.f3627i.f0();
            if ((f02 instanceof c) && (e5 = ((c) f02).e()) != null) {
                return e5;
            }
            if (f02 instanceof A) {
                return ((A) f02).f3624a;
            }
            return s0Var.l();
        }
    }

    private static final class b extends z0 {

        /* renamed from: e  reason: collision with root package name */
        private final A0 f3628e;

        /* renamed from: f  reason: collision with root package name */
        private final c f3629f;

        /* renamed from: g  reason: collision with root package name */
        private final C1002t f3630g;

        /* renamed from: h  reason: collision with root package name */
        private final Object f3631h;

        public b(A0 a02, c cVar, C1002t tVar, Object obj) {
            this.f3628e = a02;
            this.f3629f = cVar;
            this.f3630g = tVar;
            this.f3631h = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            r((Throwable) obj);
            return s.f8222a;
        }

        public void r(Throwable th) {
            this.f3628e.U(this.f3629f, this.f3630g, this.f3631h);
        }
    }

    private static final class c implements C0992n0 {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f3632b;

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f3633c;

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f3634d;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with root package name */
        private final F0 f3635a;

        static {
            Class<c> cls = c.class;
            f3632b = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
            Class<Object> cls2 = Object.class;
            f3633c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
            f3634d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
        }

        public c(F0 f02, boolean z4, Throwable th) {
            this.f3635a = f02;
            this._isCompleting = z4 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList c() {
            return new ArrayList(4);
        }

        private final Object d() {
            return f3634d.get(this);
        }

        private final void k(Object obj) {
            f3634d.set(this, obj);
        }

        public final void a(Throwable th) {
            Throwable e5 = e();
            if (e5 == null) {
                l(th);
            } else if (th != e5) {
                Object d5 = d();
                if (d5 == null) {
                    k(th);
                } else if (d5 instanceof Throwable) {
                    if (th != d5) {
                        ArrayList c5 = c();
                        c5.add(d5);
                        c5.add(th);
                        k(c5);
                    }
                } else if (d5 instanceof ArrayList) {
                    ((ArrayList) d5).add(th);
                } else {
                    throw new IllegalStateException(("State is " + d5).toString());
                }
            }
        }

        public F0 b() {
            return this.f3635a;
        }

        public final Throwable e() {
            return (Throwable) f3633c.get(this);
        }

        public final boolean f() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        public final boolean g() {
            if (f3632b.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            if (d() == B0.f3644e) {
                return true;
            }
            return false;
        }

        public final List i(Throwable th) {
            ArrayList arrayList;
            Object d5 = d();
            if (d5 == null) {
                arrayList = c();
            } else if (d5 instanceof Throwable) {
                ArrayList c5 = c();
                c5.add(d5);
                arrayList = c5;
            } else if (d5 instanceof ArrayList) {
                arrayList = (ArrayList) d5;
            } else {
                throw new IllegalStateException(("State is " + d5).toString());
            }
            Throwable e5 = e();
            if (e5 != null) {
                arrayList.add(0, e5);
            }
            if (th != null && !m.a(th, e5)) {
                arrayList.add(th);
            }
            k(B0.f3644e);
            return arrayList;
        }

        public boolean isActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }

        public final void j(boolean z4) {
            f3632b.set(this, z4 ? 1 : 0);
        }

        public final void l(Throwable th) {
            f3633c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    public static final class d extends C1067q.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ A0 f3636d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f3637e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(C1067q qVar, A0 a02, Object obj) {
            super(qVar);
            this.f3636d = a02;
            this.f3637e = obj;
        }

        /* renamed from: f */
        public Object d(C1067q qVar) {
            if (this.f3636d.f0() == this.f3637e) {
                return null;
            }
            return C1066p.a();
        }
    }

    static {
        Class<A0> cls = A0.class;
        Class<Object> cls2 = Object.class;
        f3625a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f3626b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public A0(boolean z4) {
        C0968b0 b0Var;
        if (z4) {
            b0Var = B0.f3646g;
        } else {
            b0Var = B0.f3645f;
        }
        this._state = b0Var;
    }

    private final int B0(Object obj) {
        if (obj instanceof C0968b0) {
            if (((C0968b0) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f3625a, this, obj, B0.f3646g)) {
                return -1;
            }
            w0();
            return 1;
        } else if (!(obj instanceof C0990m0)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(f3625a, this, obj, ((C0990m0) obj).b())) {
                return -1;
            }
            w0();
            return 1;
        }
    }

    private final String C0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f()) {
                return "Cancelling";
            }
            if (cVar.g()) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof C0992n0) {
            if (((C0992n0) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof A) {
            return "Cancelled";
        } else {
            return "Completed";
        }
    }

    public static /* synthetic */ CancellationException E0(A0 a02, Throwable th, String str, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                str = null;
            }
            return a02.D0(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean G0(C0992n0 n0Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(f3625a, this, n0Var, B0.g(obj))) {
            return false;
        }
        u0((Throwable) null);
        v0(obj);
        T(n0Var, obj);
        return true;
    }

    private final boolean H(Object obj, F0 f02, z0 z0Var) {
        int q4;
        d dVar = new d(z0Var, this, obj);
        do {
            q4 = f02.l().q(z0Var, f02, dVar);
            if (q4 == 1) {
                return true;
            }
        } while (q4 != 2);
        return false;
    }

    private final boolean H0(C0992n0 n0Var, Throwable th) {
        F0 d02 = d0(n0Var);
        if (d02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f3625a, this, n0Var, new c(d02, false, th))) {
            return false;
        }
        s0(d02, th);
        return true;
    }

    private final void I(Throwable th, List list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th2 = (Throwable) it.next();
                if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    R2.a.a(th, th2);
                }
            }
        }
    }

    private final Object I0(Object obj, Object obj2) {
        if (!(obj instanceof C0992n0)) {
            return B0.f3640a;
        }
        if ((!(obj instanceof C0968b0) && !(obj instanceof z0)) || (obj instanceof C1002t) || (obj2 instanceof A)) {
            return J0((C0992n0) obj, obj2);
        }
        if (G0((C0992n0) obj, obj2)) {
            return obj2;
        }
        return B0.f3642c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0065, code lost:
        if (r2 == null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0067, code lost:
        s0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006a, code lost:
        r7 = X(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        if (r7 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0074, code lost:
        if (K0(r1, r7, r8) == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0078, code lost:
        return o3.B0.f3641b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007d, code lost:
        return W(r1, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object J0(o3.C0992n0 r7, java.lang.Object r8) {
        /*
            r6 = this;
            o3.F0 r0 = r6.d0(r7)
            if (r0 != 0) goto L_0x000b
            t3.F r7 = o3.B0.f3642c
            return r7
        L_0x000b:
            boolean r1 = r7 instanceof o3.A0.c
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r7
            o3.A0$c r1 = (o3.A0.c) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            o3.A0$c r1 = new o3.A0$c
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.C r3 = new kotlin.jvm.internal.C
            r3.<init>()
            monitor-enter(r1)
            boolean r4 = r1.g()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0031
            t3.F r7 = o3.B0.f3640a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r7
        L_0x002f:
            r7 = move-exception
            goto L_0x007e
        L_0x0031:
            r4 = 1
            r1.j(r4)     // Catch:{ all -> 0x002f }
            if (r1 == r7) goto L_0x0045
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f3625a     // Catch:{ all -> 0x002f }
            boolean r4 = androidx.concurrent.futures.a.a(r4, r6, r7, r1)     // Catch:{ all -> 0x002f }
            if (r4 != 0) goto L_0x0045
            t3.F r7 = o3.B0.f3642c     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            return r7
        L_0x0045:
            boolean r4 = r1.f()     // Catch:{ all -> 0x002f }
            boolean r5 = r8 instanceof o3.A     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0051
            r5 = r8
            o3.A r5 = (o3.A) r5     // Catch:{ all -> 0x002f }
            goto L_0x0052
        L_0x0051:
            r5 = r2
        L_0x0052:
            if (r5 == 0) goto L_0x0059
            java.lang.Throwable r5 = r5.f3624a     // Catch:{ all -> 0x002f }
            r1.a(r5)     // Catch:{ all -> 0x002f }
        L_0x0059:
            java.lang.Throwable r5 = r1.e()     // Catch:{ all -> 0x002f }
            if (r4 != 0) goto L_0x0060
            r2 = r5
        L_0x0060:
            r3.f20968a = r2     // Catch:{ all -> 0x002f }
            R2.s r3 = R2.s.f8222a     // Catch:{ all -> 0x002f }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x006a
            r6.s0(r0, r2)
        L_0x006a:
            o3.t r7 = r6.X(r7)
            if (r7 == 0) goto L_0x0079
            boolean r7 = r6.K0(r1, r7, r8)
            if (r7 == 0) goto L_0x0079
            t3.F r7 = o3.B0.f3641b
            return r7
        L_0x0079:
            java.lang.Object r7 = r6.W(r1, r8)
            return r7
        L_0x007e:
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.A0.J0(o3.n0, java.lang.Object):java.lang.Object");
    }

    private final boolean K0(c cVar, C1002t tVar, Object obj) {
        while (C1001s0.a.d(tVar.f3728e, false, false, new b(this, cVar, tVar, obj), 1, (Object) null) == H0.f3657a) {
            tVar = r0(tVar);
            if (tVar == null) {
                return false;
            }
        }
        return true;
    }

    private final Object L(V2.d dVar) {
        a aVar = new a(W2.b.b(dVar), this);
        aVar.z();
        C0995p.a(aVar, i(new K0(aVar)));
        Object v4 = aVar.v();
        if (v4 == W2.b.c()) {
            h.c(dVar);
        }
        return v4;
    }

    private final Object P(Object obj) {
        Object I02;
        do {
            Object f02 = f0();
            if (!(f02 instanceof C0992n0) || ((f02 instanceof c) && ((c) f02).g())) {
                return B0.f3640a;
            }
            I02 = I0(f02, new A(V(obj), false, 2, (C2103g) null));
        } while (I02 == B0.f3642c);
        return I02;
    }

    private final boolean Q(Throwable th) {
        if (j0()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        C1000s e02 = e0();
        if (e02 == null || e02 == H0.f3657a) {
            return z4;
        }
        if (e02.a(th) || z4) {
            return true;
        }
        return false;
    }

    private final void T(C0992n0 n0Var, Object obj) {
        A a5;
        C1000s e02 = e0();
        if (e02 != null) {
            e02.dispose();
            A0(H0.f3657a);
        }
        Throwable th = null;
        if (obj instanceof A) {
            a5 = (A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            th = a5.f3624a;
        }
        if (n0Var instanceof z0) {
            try {
                ((z0) n0Var).r(th);
            } catch (Throwable th2) {
                h0(new D("Exception in completion handler " + n0Var + " for " + this, th2));
            }
        } else {
            F0 b5 = n0Var.b();
            if (b5 != null) {
                t0(b5, th);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void U(c cVar, C1002t tVar, Object obj) {
        C1002t r02 = r0(tVar);
        if (r02 == null || !K0(cVar, r02, obj)) {
            J(W(cVar, obj));
        }
    }

    private final Throwable V(Object obj) {
        boolean z4;
        if (obj == null) {
            z4 = true;
        } else {
            z4 = obj instanceof Throwable;
        }
        if (z4) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new C1003t0(R(), (Throwable) null, this);
            }
            return th;
        }
        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((J0) obj).z();
    }

    private final Object W(c cVar, Object obj) {
        A a5;
        Throwable th;
        boolean f4;
        Throwable a02;
        if (obj instanceof A) {
            a5 = (A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            th = a5.f3624a;
        } else {
            th = null;
        }
        synchronized (cVar) {
            f4 = cVar.f();
            List i4 = cVar.i(th);
            a02 = a0(cVar, i4);
            if (a02 != null) {
                I(a02, i4);
            }
        }
        if (!(a02 == null || a02 == th)) {
            obj = new A(a02, false, 2, (C2103g) null);
        }
        if (a02 != null && (Q(a02) || g0(a02))) {
            m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((A) obj).b();
        }
        if (!f4) {
            u0(a02);
        }
        v0(obj);
        androidx.concurrent.futures.a.a(f3625a, this, cVar, B0.g(obj));
        T(cVar, obj);
        return obj;
    }

    private final C1002t X(C0992n0 n0Var) {
        C1002t tVar;
        if (n0Var instanceof C1002t) {
            tVar = (C1002t) n0Var;
        } else {
            tVar = null;
        }
        if (tVar != null) {
            return tVar;
        }
        F0 b5 = n0Var.b();
        if (b5 != null) {
            return r0(b5);
        }
        return null;
    }

    private final Throwable Z(Object obj) {
        A a5;
        if (obj instanceof A) {
            a5 = (A) obj;
        } else {
            a5 = null;
        }
        if (a5 != null) {
            return a5.f3624a;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Throwable a0(o3.A0.c r4, java.util.List r5) {
        /*
            r3 = this;
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r4 = r4.f()
            if (r4 == 0) goto L_0x0017
            o3.t0 r4 = new o3.t0
            java.lang.String r5 = r3.R()
            r4.<init>(r5, r1, r3)
            return r4
        L_0x0017:
            return r1
        L_0x0018:
            r4 = r5
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x001f:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0031
            java.lang.Object r0 = r4.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            boolean r2 = r2 instanceof java.util.concurrent.CancellationException
            if (r2 != 0) goto L_0x001f
            r1 = r0
        L_0x0031:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x0036
            return r1
        L_0x0036:
            r4 = 0
            java.lang.Object r4 = r5.get(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.A0.a0(o3.A0$c, java.util.List):java.lang.Throwable");
    }

    private final F0 d0(C0992n0 n0Var) {
        F0 b5 = n0Var.b();
        if (b5 != null) {
            return b5;
        }
        if (n0Var instanceof C0968b0) {
            return new F0();
        }
        if (n0Var instanceof z0) {
            y0((z0) n0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + n0Var).toString());
    }

    private final boolean k0() {
        Object f02;
        do {
            f02 = f0();
            if (!(f02 instanceof C0992n0)) {
                return false;
            }
        } while (B0(f02) < 0);
        return true;
    }

    private final Object l0(V2.d dVar) {
        C0991n nVar = new C0991n(W2.b.b(dVar), 1);
        nVar.z();
        C0995p.a(nVar, i(new L0(nVar)));
        Object v4 = nVar.v();
        if (v4 == W2.b.c()) {
            h.c(dVar);
        }
        if (v4 == W2.b.c()) {
            return v4;
        }
        return s.f8222a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        s0(((o3.A0.c) r2).b(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return o3.B0.f3640a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.f0()
            boolean r3 = r2 instanceof o3.A0.c
            if (r3 == 0) goto L_0x0050
            monitor-enter(r2)
            r3 = r2
            o3.A0$c r3 = (o3.A0.c) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.h()     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x001c
            t3.F r7 = o3.B0.f3643d     // Catch:{ all -> 0x001a }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r7 = move-exception
            goto L_0x004e
        L_0x001c:
            r3 = r2
            o3.A0$c r3 = (o3.A0.c) r3     // Catch:{ all -> 0x001a }
            boolean r3 = r3.f()     // Catch:{ all -> 0x001a }
            if (r7 != 0) goto L_0x0027
            if (r3 != 0) goto L_0x0033
        L_0x0027:
            if (r1 != 0) goto L_0x002d
            java.lang.Throwable r1 = r6.V(r7)     // Catch:{ all -> 0x001a }
        L_0x002d:
            r7 = r2
            o3.A0$c r7 = (o3.A0.c) r7     // Catch:{ all -> 0x001a }
            r7.a(r1)     // Catch:{ all -> 0x001a }
        L_0x0033:
            r7 = r2
            o3.A0$c r7 = (o3.A0.c) r7     // Catch:{ all -> 0x001a }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x001a }
            if (r3 != 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            o3.A0$c r2 = (o3.A0.c) r2
            o3.F0 r7 = r2.b()
            r6.s0(r7, r0)
        L_0x0049:
            t3.F r7 = o3.B0.f3640a
            return r7
        L_0x004e:
            monitor-exit(r2)
            throw r7
        L_0x0050:
            boolean r3 = r2 instanceof o3.C0992n0
            if (r3 == 0) goto L_0x00a1
            if (r1 != 0) goto L_0x005a
            java.lang.Throwable r1 = r6.V(r7)
        L_0x005a:
            r3 = r2
            o3.n0 r3 = (o3.C0992n0) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006e
            boolean r2 = r6.H0(r3, r1)
            if (r2 == 0) goto L_0x0002
            t3.F r7 = o3.B0.f3640a
            return r7
        L_0x006e:
            o3.A r3 = new o3.A
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.I0(r2, r3)
            t3.F r4 = o3.B0.f3640a
            if (r3 == r4) goto L_0x0086
            t3.F r2 = o3.B0.f3642c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0086:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a1:
            t3.F r7 = o3.B0.f3643d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.A0.m0(java.lang.Object):java.lang.Object");
    }

    private final z0 p0(l lVar, boolean z4) {
        z0 z0Var = null;
        if (z4) {
            if (lVar instanceof C1005u0) {
                z0Var = (C1005u0) lVar;
            }
            if (z0Var == null) {
                z0Var = new C0998q0(lVar);
            }
        } else {
            if (lVar instanceof z0) {
                z0Var = (z0) lVar;
            }
            if (z0Var == null) {
                z0Var = new C0999r0(lVar);
            }
        }
        z0Var.t(this);
        return z0Var;
    }

    private final C1002t r0(C1067q qVar) {
        while (qVar.m()) {
            qVar = qVar.l();
        }
        while (true) {
            qVar = qVar.k();
            if (!qVar.m()) {
                if (qVar instanceof C1002t) {
                    return (C1002t) qVar;
                }
                if (qVar instanceof F0) {
                    return null;
                }
            }
        }
    }

    private final void s0(F0 f02, Throwable th) {
        u0(th);
        Object j4 = f02.j();
        m.c(j4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        D d5 = null;
        for (C1067q qVar = (C1067q) j4; !m.a(qVar, f02); qVar = qVar.k()) {
            if (qVar instanceof C1005u0) {
                z0 z0Var = (z0) qVar;
                try {
                    z0Var.r(th);
                } catch (Throwable th2) {
                    if (d5 != null) {
                        R2.a.a(d5, th2);
                    } else {
                        d5 = new D("Exception in completion handler " + z0Var + " for " + this, th2);
                        s sVar = s.f8222a;
                    }
                }
            }
        }
        if (d5 != null) {
            h0(d5);
        }
        Q(th);
    }

    private final void t0(F0 f02, Throwable th) {
        Object j4 = f02.j();
        m.c(j4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        D d5 = null;
        for (C1067q qVar = (C1067q) j4; !m.a(qVar, f02); qVar = qVar.k()) {
            if (qVar instanceof z0) {
                z0 z0Var = (z0) qVar;
                try {
                    z0Var.r(th);
                } catch (Throwable th2) {
                    if (d5 != null) {
                        R2.a.a(d5, th2);
                    } else {
                        d5 = new D("Exception in completion handler " + z0Var + " for " + this, th2);
                        s sVar = s.f8222a;
                    }
                }
            }
        }
        if (d5 != null) {
            h0(d5);
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [o3.m0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void x0(o3.C0968b0 r3) {
        /*
            r2 = this;
            o3.F0 r0 = new o3.F0
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            o3.m0 r1 = new o3.m0
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3625a
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.A0.x0(o3.b0):void");
    }

    private final void y0(z0 z0Var) {
        z0Var.e(new F0());
        androidx.concurrent.futures.a.a(f3625a, this, z0Var, z0Var.k());
    }

    public final boolean A() {
        return !(f0() instanceof C0992n0);
    }

    public final void A0(C1000s sVar) {
        f3626b.set(this, sVar);
    }

    /* access modifiers changed from: protected */
    public final CancellationException D0(Throwable th, String str) {
        CancellationException cancellationException;
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            if (str == null) {
                str = R();
            }
            cancellationException = new C1003t0(str, th, this);
        }
        return cancellationException;
    }

    public final Z E(boolean z4, boolean z5, l lVar) {
        A a5;
        z0 p02 = p0(lVar, z4);
        while (true) {
            Object f02 = f0();
            if (f02 instanceof C0968b0) {
                C0968b0 b0Var = (C0968b0) f02;
                if (!b0Var.isActive()) {
                    x0(b0Var);
                } else if (androidx.concurrent.futures.a.a(f3625a, this, f02, p02)) {
                    break;
                }
            } else {
                Throwable th = null;
                if (f02 instanceof C0992n0) {
                    F0 b5 = ((C0992n0) f02).b();
                    if (b5 == null) {
                        m.c(f02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        y0((z0) f02);
                    } else {
                        Z z6 = H0.f3657a;
                        if (z4 && (f02 instanceof c)) {
                            synchronized (f02) {
                                try {
                                    th = ((c) f02).e();
                                    if (th != null) {
                                        if ((lVar instanceof C1002t) && !((c) f02).g()) {
                                        }
                                        s sVar = s.f8222a;
                                    }
                                    if (H(f02, b5, p02)) {
                                        if (th == null) {
                                            return p02;
                                        }
                                        z6 = p02;
                                        s sVar2 = s.f8222a;
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        if (th != null) {
                            if (z5) {
                                lVar.invoke(th);
                            }
                            return z6;
                        } else if (H(f02, b5, p02)) {
                            break;
                        }
                    }
                } else {
                    if (z5) {
                        if (f02 instanceof A) {
                            a5 = (A) f02;
                        } else {
                            a5 = null;
                        }
                        if (a5 != null) {
                            th = a5.f3624a;
                        }
                        lVar.invoke(th);
                    }
                    return H0.f3657a;
                }
            }
        }
        return p02;
    }

    public final String F0() {
        return q0() + '{' + C0(f0()) + '}';
    }

    /* access modifiers changed from: protected */
    public final Object K(V2.d dVar) {
        Object f02;
        do {
            f02 = f0();
            if (!(f02 instanceof C0992n0)) {
                if (!(f02 instanceof A)) {
                    return B0.h(f02);
                }
                throw ((A) f02).f3624a;
            }
        } while (B0(f02) < 0);
        return L(dVar);
    }

    public final boolean M(Throwable th) {
        return N(th);
    }

    public final boolean N(Object obj) {
        Object a5 = B0.f3640a;
        if (c0() && (a5 = P(obj)) == B0.f3641b) {
            return true;
        }
        if (a5 == B0.f3640a) {
            a5 = m0(obj);
        }
        if (a5 == B0.f3640a || a5 == B0.f3641b) {
            return true;
        }
        if (a5 == B0.f3643d) {
            return false;
        }
        J(a5);
        return true;
    }

    public void O(Throwable th) {
        N(th);
    }

    /* access modifiers changed from: protected */
    public String R() {
        return "Job was cancelled";
    }

    public boolean S(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!N(th) || !b0()) {
            return false;
        }
        return true;
    }

    public final Object Y() {
        Object f02 = f0();
        if (f02 instanceof C0992n0) {
            throw new IllegalStateException("This job has not completed yet");
        } else if (!(f02 instanceof A)) {
            return B0.h(f02);
        } else {
            throw ((A) f02).f3624a;
        }
    }

    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new C1003t0(R(), (Throwable) null, this);
        }
        O(cancellationException);
    }

    public boolean b0() {
        return true;
    }

    public boolean c0() {
        return false;
    }

    public final C1000s e0() {
        return (C1000s) f3626b.get(this);
    }

    public final Object f0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3625a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public Object fold(Object obj, p pVar) {
        return C1001s0.a.b(this, obj, pVar);
    }

    public final Object g(V2.d dVar) {
        if (!k0()) {
            C1009w0.f(dVar.getContext());
            return s.f8222a;
        }
        Object l02 = l0(dVar);
        if (l02 == W2.b.c()) {
            return l02;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public boolean g0(Throwable th) {
        return false;
    }

    public g.b get(g.c cVar) {
        return C1001s0.a.c(this, cVar);
    }

    public final g.c getKey() {
        return C1001s0.f3726k0;
    }

    public C1001s0 getParent() {
        C1000s e02 = e0();
        if (e02 != null) {
            return e02.getParent();
        }
        return null;
    }

    public final Z i(l lVar) {
        return E(false, true, lVar);
    }

    /* access modifiers changed from: protected */
    public final void i0(C1001s0 s0Var) {
        if (s0Var == null) {
            A0(H0.f3657a);
            return;
        }
        s0Var.start();
        C1000s k4 = s0Var.k(this);
        A0(k4);
        if (A()) {
            k4.dispose();
            A0(H0.f3657a);
        }
    }

    public boolean isActive() {
        Object f02 = f0();
        if (!(f02 instanceof C0992n0) || !((C0992n0) f02).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean isCancelled() {
        Object f02 = f0();
        if (f02 instanceof A) {
            return true;
        }
        if (!(f02 instanceof c) || !((c) f02).f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean j0() {
        return false;
    }

    public final C1000s k(C1004u uVar) {
        Z d5 = C1001s0.a.d(this, true, false, new C1002t(uVar), 2, (Object) null);
        m.c(d5, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (C1000s) d5;
    }

    public final CancellationException l() {
        Object f02 = f0();
        if (f02 instanceof c) {
            Throwable e5 = ((c) f02).e();
            if (e5 != null) {
                CancellationException D02 = D0(e5, N.a(this) + " is cancelling");
                if (D02 != null) {
                    return D02;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (f02 instanceof C0992n0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (f02 instanceof A) {
            return E0(this, ((A) f02).f3624a, (String) null, 1, (Object) null);
        } else {
            return new C1003t0(N.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public g minusKey(g.c cVar) {
        return C1001s0.a.e(this, cVar);
    }

    public final boolean n0(Object obj) {
        Object I02;
        do {
            I02 = I0(f0(), obj);
            if (I02 == B0.f3640a) {
                return false;
            }
            if (I02 == B0.f3641b) {
                return true;
            }
        } while (I02 == B0.f3642c);
        J(I02);
        return true;
    }

    public final Object o0(Object obj) {
        Object I02;
        do {
            I02 = I0(f0(), obj);
            if (I02 == B0.f3640a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, Z(obj));
            }
        } while (I02 == B0.f3642c);
        return I02;
    }

    public g plus(g gVar) {
        return C1001s0.a.f(this, gVar);
    }

    public String q0() {
        return N.a(this);
    }

    public final boolean start() {
        int B02;
        do {
            B02 = B0(f0());
            if (B02 == 0) {
                return false;
            }
        } while (B02 != 1);
        return true;
    }

    public String toString() {
        return F0() + '@' + N.b(this);
    }

    public final void w(J0 j02) {
        N(j02);
    }

    public CancellationException z() {
        Throwable th;
        Object f02 = f0();
        CancellationException cancellationException = null;
        if (f02 instanceof c) {
            th = ((c) f02).e();
        } else if (f02 instanceof A) {
            th = ((A) f02).f3624a;
        } else if (!(f02 instanceof C0992n0)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + f02).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new C1003t0("Parent job is " + C0(f02), th, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z0(o3.z0 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.f0()
            boolean r1 = r0 instanceof o3.z0
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            goto L_0x0027
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f3625a
            o3.b0 r2 = o3.B0.f3646g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            goto L_0x0027
        L_0x0018:
            boolean r1 = r0 instanceof o3.C0992n0
            if (r1 == 0) goto L_0x0027
            o3.n0 r0 = (o3.C0992n0) r0
            o3.F0 r0 = r0.b()
            if (r0 == 0) goto L_0x0027
            r4.n()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.A0.z0(o3.z0):void");
    }

    /* access modifiers changed from: protected */
    public void w0() {
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
    }

    public void h0(Throwable th) {
        throw th;
    }

    /* access modifiers changed from: protected */
    public void u0(Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void v0(Object obj) {
    }
}
