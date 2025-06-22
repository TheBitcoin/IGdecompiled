package o3;

import R2.s;
import V2.g;
import j3.e;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m;
import t3.N;
import t3.O;

/* renamed from: o3.d0  reason: case insensitive filesystem */
public abstract class C0972d0 extends C0974e0 implements T {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3694d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3695e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f3696f;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* renamed from: o3.d0$a */
    private final class a extends b {

        /* renamed from: c  reason: collision with root package name */
        private final C0989m f3697c;

        public a(long j4, C0989m mVar) {
            super(j4);
            this.f3697c = mVar;
        }

        public void run() {
            this.f3697c.e(C0972d0.this, s.f8222a);
        }

        public String toString() {
            return super.toString() + this.f3697c;
        }
    }

    /* renamed from: o3.d0$b */
    public static abstract class b implements Runnable, Comparable, Z, O {
        private volatile Object _heap;

        /* renamed from: a  reason: collision with root package name */
        public long f3699a;

        /* renamed from: b  reason: collision with root package name */
        private int f3700b = -1;

        public b(long j4) {
            this.f3699a = j4;
        }

        public N b() {
            Object obj = this._heap;
            if (obj instanceof N) {
                return (N) obj;
            }
            return null;
        }

        public void c(N n4) {
            if (this._heap != C0978g0.f3705a) {
                this._heap = n4;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        public int d() {
            return this.f3700b;
        }

        public final void dispose() {
            c cVar;
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj != C0978g0.f3705a) {
                        if (obj instanceof c) {
                            cVar = (c) obj;
                        } else {
                            cVar = null;
                        }
                        if (cVar != null) {
                            cVar.g(this);
                        }
                        this._heap = C0978g0.f3705a;
                        s sVar = s.f8222a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* renamed from: e */
        public int compareTo(b bVar) {
            int i4 = ((this.f3699a - bVar.f3699a) > 0 ? 1 : ((this.f3699a - bVar.f3699a) == 0 ? 0 : -1));
            if (i4 > 0) {
                return 1;
            }
            if (i4 < 0) {
                return -1;
            }
            return 0;
        }

        public final int f(long j4, c cVar, C0972d0 d0Var) {
            synchronized (this) {
                if (this._heap == C0978g0.f3705a) {
                    return 2;
                }
                synchronized (cVar) {
                    try {
                        b bVar = (b) cVar.b();
                        if (d0Var.A()) {
                            return 1;
                        }
                        if (bVar == null) {
                            cVar.f3701c = j4;
                        } else {
                            long j5 = bVar.f3699a;
                            if (j5 - j4 < 0) {
                                j4 = j5;
                            }
                            if (j4 - cVar.f3701c > 0) {
                                cVar.f3701c = j4;
                            }
                        }
                        long j6 = this.f3699a;
                        long j7 = cVar.f3701c;
                        if (j6 - j7 < 0) {
                            this.f3699a = j7;
                        }
                        cVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean g(long j4) {
            if (j4 - this.f3699a >= 0) {
                return true;
            }
            return false;
        }

        public void setIndex(int i4) {
            this.f3700b = i4;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f3699a + ']';
        }
    }

    /* renamed from: o3.d0$c */
    public static final class c extends N {

        /* renamed from: c  reason: collision with root package name */
        public long f3701c;

        public c(long j4) {
            this.f3701c = j4;
        }
    }

    static {
        Class<C0972d0> cls = C0972d0.class;
        Class<Object> cls2 = Object.class;
        f3694d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        f3695e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
        f3696f = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleted");
    }

    /* access modifiers changed from: private */
    public final boolean A() {
        if (f3696f.get(this) != 0) {
            return true;
        }
        return false;
    }

    private final void U() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3694d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f3694d, this, (Object) null, C0978g0.f3706b)) {
                    return;
                }
            } else if (obj instanceof t3.s) {
                ((t3.s) obj).d();
                return;
            } else if (obj != C0978g0.f3706b) {
                t3.s sVar = new t3.s(8, true);
                m.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (androidx.concurrent.futures.a.a(f3694d, this, obj, sVar)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable V() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3694d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof t3.s) {
                m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                t3.s sVar = (t3.s) obj;
                Object j4 = sVar.j();
                if (j4 != t3.s.f4520h) {
                    return (Runnable) j4;
                }
                androidx.concurrent.futures.a.a(f3694d, this, obj, sVar.i());
            } else if (obj == C0978g0.f3706b) {
                return null;
            } else {
                if (androidx.concurrent.futures.a.a(f3694d, this, obj, (Object) null)) {
                    m.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean X(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3694d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (A()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f3694d, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof t3.s) {
                m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                t3.s sVar = (t3.s) obj;
                int a5 = sVar.a(runnable);
                if (a5 == 0) {
                    return true;
                }
                if (a5 == 1) {
                    androidx.concurrent.futures.a.a(f3694d, this, obj, sVar.i());
                } else if (a5 == 2) {
                    return false;
                }
            } else if (obj == C0978g0.f3706b) {
                return false;
            } else {
                t3.s sVar2 = new t3.s(8, true);
                m.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar2.a((Runnable) obj);
                sVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f3694d, this, obj, sVar2)) {
                    return true;
                }
            }
        }
    }

    private final void Z() {
        b bVar;
        C0969c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f3695e.get(this);
            if (cVar != null && (bVar = (b) cVar.i()) != null) {
                R(nanoTime, bVar);
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: o3.d0$c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int c0(long r4, o3.C0972d0.b r6) {
        /*
            r3 = this;
            boolean r0 = r3.A()
            if (r0 == 0) goto L_0x0008
            r4 = 1
            return r4
        L_0x0008:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f3695e
            java.lang.Object r1 = r0.get(r3)
            o3.d0$c r1 = (o3.C0972d0.c) r1
            if (r1 != 0) goto L_0x0025
            o3.d0$c r1 = new o3.d0$c
            r1.<init>(r4)
            r2 = 0
            androidx.concurrent.futures.a.a(r0, r3, r2, r1)
            java.lang.Object r0 = r0.get(r3)
            kotlin.jvm.internal.m.b(r0)
            r1 = r0
            o3.d0$c r1 = (o3.C0972d0.c) r1
        L_0x0025:
            int r4 = r6.f(r4, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.C0972d0.c0(long, o3.d0$b):int");
    }

    private final void d0(boolean z4) {
        f3696f.set(this, z4 ? 1 : 0);
    }

    private final boolean e0(b bVar) {
        b bVar2;
        c cVar = (c) f3695e.get(this);
        if (cVar != null) {
            bVar2 = (b) cVar.e();
        } else {
            bVar2 = null;
        }
        if (bVar2 == bVar) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long I() {
        b bVar;
        if (super.I() == 0) {
            return 0;
        }
        Object obj = f3694d.get(this);
        if (obj != null) {
            if (obj instanceof t3.s) {
                if (!((t3.s) obj).g()) {
                    return 0;
                }
            } else if (obj == C0978g0.f3706b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        c cVar = (c) f3695e.get(this);
        if (cVar == null || (bVar = (b) cVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j4 = bVar.f3699a;
        C0969c.a();
        return e.b(j4 - System.nanoTime(), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long N() {
        /*
            r9 = this;
            boolean r0 = r9.O()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f3695e
            java.lang.Object r0 = r0.get(r9)
            o3.d0$c r0 = (o3.C0972d0.c) r0
            if (r0 == 0) goto L_0x0049
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0049
            o3.C0969c.a()
            long r3 = java.lang.System.nanoTime()
        L_0x0020:
            monitor-enter(r0)
            t3.O r5 = r0.b()     // Catch:{ all -> 0x0038 }
            r6 = 0
            if (r5 != 0) goto L_0x002a
            monitor-exit(r0)
            goto L_0x0042
        L_0x002a:
            o3.d0$b r5 = (o3.C0972d0.b) r5     // Catch:{ all -> 0x0038 }
            boolean r7 = r5.g(r3)     // Catch:{ all -> 0x0038 }
            r8 = 0
            if (r7 == 0) goto L_0x003a
            boolean r5 = r9.X(r5)     // Catch:{ all -> 0x0038 }
            goto L_0x003b
        L_0x0038:
            r1 = move-exception
            goto L_0x0047
        L_0x003a:
            r5 = 0
        L_0x003b:
            if (r5 == 0) goto L_0x0041
            t3.O r6 = r0.h(r8)     // Catch:{ all -> 0x0038 }
        L_0x0041:
            monitor-exit(r0)
        L_0x0042:
            o3.d0$b r6 = (o3.C0972d0.b) r6
            if (r6 != 0) goto L_0x0020
            goto L_0x0049
        L_0x0047:
            monitor-exit(r0)
            throw r1
        L_0x0049:
            java.lang.Runnable r0 = r9.V()
            if (r0 == 0) goto L_0x0053
            r0.run()
            return r1
        L_0x0053:
            long r0 = r9.I()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.C0972d0.N():long");
    }

    public void W(Runnable runnable) {
        if (X(runnable)) {
            S();
        } else {
            O.f3668g.W(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public boolean Y() {
        if (!M()) {
            return false;
        }
        c cVar = (c) f3695e.get(this);
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = f3694d.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof t3.s) {
            return ((t3.s) obj).g();
        }
        if (obj == C0978g0.f3706b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a0() {
        f3694d.set(this, (Object) null);
        f3695e.set(this, (Object) null);
    }

    public final void b0(long j4, b bVar) {
        int c02 = c0(j4, bVar);
        if (c02 != 0) {
            if (c02 == 1) {
                R(j4, bVar);
            } else if (c02 != 2) {
                throw new IllegalStateException("unexpected result");
            }
        } else if (e0(bVar)) {
            S();
        }
    }

    public final void dispatch(g gVar, Runnable runnable) {
        W(runnable);
    }

    public void n(long j4, C0989m mVar) {
        long c5 = C0978g0.c(j4);
        if (c5 < 4611686018427387903L) {
            C0969c.a();
            long nanoTime = System.nanoTime();
            a aVar = new a(c5 + nanoTime, mVar);
            b0(nanoTime, aVar);
            C0995p.a(mVar, aVar);
        }
    }

    public void shutdown() {
        S0.f3672a.c();
        d0(true);
        U();
        do {
        } while (N() <= 0);
        Z();
    }
}
