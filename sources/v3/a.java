package v3;

import R2.s;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import j3.e;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0969c;
import o3.N;
import t3.A;
import t3.F;

public final class a implements Executor, Closeable, AutoCloseable {

    /* renamed from: h  reason: collision with root package name */
    public static final C0051a f4532h = new C0051a((C2103g) null);

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4533i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4534j;

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4535k;

    /* renamed from: l  reason: collision with root package name */
    public static final F f4536l = new F("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: a  reason: collision with root package name */
    public final int f4537a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4538b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4539c;
    private volatile long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final String f4540d;

    /* renamed from: e  reason: collision with root package name */
    public final d f4541e;

    /* renamed from: f  reason: collision with root package name */
    public final d f4542f;

    /* renamed from: g  reason: collision with root package name */
    public final A f4543g;
    private volatile long parkedWorkersStack;

    /* renamed from: v3.a$a  reason: collision with other inner class name */
    public static final class C0051a {
        public /* synthetic */ C0051a(C2103g gVar) {
            this();
        }

        private C0051a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4544a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                v3.a$d[] r0 = v3.a.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                v3.a$d r1 = v3.a.d.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                v3.a$d r1 = v3.a.d.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                v3.a$d r1 = v3.a.d.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                v3.a$d r1 = v3.a.d.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                v3.a$d r1 = v3.a.d.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f4544a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: v3.a.b.<clinit>():void");
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<a> cls = a.class;
        f4533i = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        f4534j = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        f4535k = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public a(int i4, int i5, long j4, String str) {
        this.f4537a = i4;
        this.f4538b = i5;
        this.f4539c = j4;
        this.f4540d = str;
        if (i4 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i4 + " should be at least 1").toString());
        } else if (i5 < i4) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should be greater than or equals to core pool size " + i4).toString());
        } else if (i5 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j4 > 0) {
            this.f4541e = new d();
            this.f4542f = new d();
            this.f4543g = new A((i4 + 1) * 2);
            this.controlState = ((long) i4) << 42;
            this._isTerminated = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
    }

    private final h A(c cVar, h hVar, boolean z4) {
        if (cVar == null || cVar.f4548c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f4570b.b() == 0 && cVar.f4548c == d.BLOCKING) {
            return hVar;
        }
        cVar.f4552g = true;
        return cVar.f4546a.a(hVar, z4);
    }

    private final boolean D(long j4) {
        if (e.a(((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21)), 0) < this.f4537a) {
            int g4 = g();
            if (g4 == 1 && this.f4537a > 1) {
                g();
            }
            if (g4 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean E(a aVar, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = f4534j.get(aVar);
        }
        return aVar.D(j4);
    }

    private final boolean F() {
        c p4;
        do {
            p4 = p();
            if (p4 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(p4, -1, 0));
        LockSupport.unpark(p4);
        return true;
    }

    private final boolean d(h hVar) {
        if (hVar.f4570b.b() == 1) {
            return this.f4542f.a(hVar);
        }
        return this.f4541e.a(hVar);
    }

    private final int g() {
        synchronized (this.f4543g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f4534j;
                long j4 = atomicLongFieldUpdater.get(this);
                int i4 = (int) (j4 & 2097151);
                int a5 = e.a(i4 - ((int) ((j4 & 4398044413952L) >> 21)), 0);
                if (a5 >= this.f4537a) {
                    return 0;
                }
                if (i4 >= this.f4538b) {
                    return 0;
                }
                int i5 = ((int) (f4534j.get(this) & 2097151)) + 1;
                if (i5 <= 0 || this.f4543g.b(i5) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i5);
                this.f4543g.c(i5, cVar);
                if (i5 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i6 = a5 + 1;
                    cVar.start();
                    return i6;
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final c k() {
        c cVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof c) {
            cVar = (c) currentThread;
        } else {
            cVar = null;
        }
        if (cVar == null || !m.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void n(a aVar, Runnable runnable, i iVar, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            iVar = l.f4579g;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        aVar.l(runnable, iVar, z4);
    }

    private final int o(c cVar) {
        Object i4 = cVar.i();
        while (i4 != f4536l) {
            if (i4 == null) {
                return 0;
            }
            c cVar2 = (c) i4;
            int h4 = cVar2.h();
            if (h4 != 0) {
                return h4;
            }
            i4 = cVar2.i();
        }
        return -1;
    }

    private final c p() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4533i;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f4543g.b((int) (2097151 & j4));
            if (cVar == null) {
                return null;
            }
            long j5 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j4) & -2097152;
            int o4 = o(cVar);
            if (o4 >= 0) {
                if (f4533i.compareAndSet(this, j4, ((long) o4) | j5)) {
                    cVar.r(f4536l);
                    return cVar;
                }
            }
        }
    }

    private final void x(long j4, boolean z4) {
        if (!z4 && !F() && !D(j4)) {
            F();
        }
    }

    public void close() {
        w(WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public void execute(Runnable runnable) {
        n(this, runnable, (i) null, false, 6, (Object) null);
    }

    public final h i(Runnable runnable, i iVar) {
        long a5 = l.f4578f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a5, iVar);
        }
        h hVar = (h) runnable;
        hVar.f4569a = a5;
        hVar.f4570b = iVar;
        return hVar;
    }

    public final boolean isTerminated() {
        if (f4535k.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final void l(Runnable runnable, i iVar, boolean z4) {
        boolean z5;
        long j4;
        C0969c.a();
        h i4 = i(runnable, iVar);
        boolean z6 = false;
        if (i4.f4570b.b() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            j4 = f4534j.addAndGet(this, CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE);
        } else {
            j4 = 0;
        }
        c k4 = k();
        h A4 = A(k4, i4, z4);
        if (A4 == null || d(A4)) {
            if (z4 && k4 != null) {
                z6 = true;
            }
            if (z5) {
                x(j4, z6);
            } else if (!z6) {
                z();
            }
        } else {
            throw new RejectedExecutionException(this.f4540d + " was terminated");
        }
    }

    public final boolean r(c cVar) {
        long j4;
        int h4;
        if (cVar.i() != f4536l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4533i;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            h4 = cVar.h();
            cVar.r(this.f4543g.b((int) (2097151 & j4)));
        } while (!f4533i.compareAndSet(this, j4, ((CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j4) & -2097152) | ((long) h4)));
        return true;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a5 = this.f4543g.a();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 1; i9 < a5; i9++) {
            c cVar = (c) this.f4543g.b(i9);
            if (cVar != null) {
                int e5 = cVar.f4546a.e();
                int i10 = b.f4544a[cVar.f4548c.ordinal()];
                if (i10 == 1) {
                    i6++;
                } else if (i10 == 2) {
                    i5++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(e5);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i10 == 3) {
                    i4++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e5);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i10 == 4) {
                    i7++;
                    if (e5 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(e5);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i10 == 5) {
                    i8++;
                }
            }
        }
        long j4 = f4534j.get(this);
        return this.f4540d + '@' + N.b(this) + "[Pool Size {core = " + this.f4537a + ", max = " + this.f4538b + "}, Worker States {CPU = " + i4 + ", blocking = " + i5 + ", parked = " + i6 + ", dormant = " + i7 + ", terminated = " + i8 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f4541e.c() + ", global blocking queue size = " + this.f4542f.c() + ", Control State {created workers= " + ((int) (2097151 & j4)) + ", blocking tasks = " + ((int) ((4398044413952L & j4) >> 21)) + ", CPUs acquired = " + (this.f4537a - ((int) ((9223367638808264704L & j4) >> 42))) + "}]";
    }

    public final void u(c cVar, int i4, int i5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4533i;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            int i6 = (int) (2097151 & j4);
            long j5 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j4) & -2097152;
            if (i6 == i4) {
                if (i5 == 0) {
                    i6 = o(cVar);
                } else {
                    i6 = i5;
                }
            }
            if (i6 >= 0) {
                if (f4533i.compareAndSet(this, j4, j5 | ((long) i6))) {
                    return;
                }
            }
        }
    }

    public final void v(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        } finally {
            C0969c.a();
        }
    }

    public final void w(long j4) {
        int i4;
        h hVar;
        if (f4535k.compareAndSet(this, 0, 1)) {
            c k4 = k();
            synchronized (this.f4543g) {
                i4 = (int) (f4534j.get(this) & 2097151);
            }
            if (1 <= i4) {
                int i5 = 1;
                while (true) {
                    Object b5 = this.f4543g.b(i5);
                    m.b(b5);
                    c cVar = (c) b5;
                    if (cVar != k4) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j4);
                        }
                        cVar.f4546a.f(this.f4542f);
                    }
                    if (i5 == i4) {
                        break;
                    }
                    i5++;
                }
            }
            this.f4542f.b();
            this.f4541e.b();
            while (true) {
                if (k4 != null) {
                    hVar = k4.g(true);
                    if (hVar != null) {
                        continue;
                        v(hVar);
                    }
                }
                hVar = (h) this.f4541e.d();
                if (hVar == null && (hVar = (h) this.f4542f.d()) == null) {
                    break;
                }
                v(hVar);
            }
            if (k4 != null) {
                k4.u(d.TERMINATED);
            }
            f4533i.set(this, 0);
            f4534j.set(this, 0);
        }
    }

    public final void z() {
        if (!F() && !E(this, 0, 1, (Object) null)) {
            F();
        }
    }

    public final class c extends Thread {

        /* renamed from: i  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f4545i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a  reason: collision with root package name */
        public final n f4546a;

        /* renamed from: b  reason: collision with root package name */
        private final C f4547b;

        /* renamed from: c  reason: collision with root package name */
        public d f4548c;

        /* renamed from: d  reason: collision with root package name */
        private long f4549d;

        /* renamed from: e  reason: collision with root package name */
        private long f4550e;

        /* renamed from: f  reason: collision with root package name */
        private int f4551f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f4552g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f4546a = new n();
            this.f4547b = new C();
            this.f4548c = d.DORMANT;
            this.nextParkedWorker = a.f4536l;
            this.f4551f = h3.c.f20861a.b();
        }

        private final void b(int i4) {
            if (i4 != 0) {
                a.f4534j.addAndGet(a.this, -2097152);
                if (this.f4548c != d.TERMINATED) {
                    this.f4548c = d.DORMANT;
                }
            }
        }

        private final void c(int i4) {
            if (i4 != 0 && u(d.BLOCKING)) {
                a.this.z();
            }
        }

        private final void d(h hVar) {
            int b5 = hVar.f4570b.b();
            k(b5);
            c(b5);
            a.this.v(hVar);
            b(b5);
        }

        private final h e(boolean z4) {
            boolean z5;
            h o4;
            h o5;
            if (z4) {
                if (m(a.this.f4537a * 2) == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 && (o5 = o()) != null) {
                    return o5;
                }
                h g4 = this.f4546a.g();
                if (g4 != null) {
                    return g4;
                }
                if (!z5 && (o4 = o()) != null) {
                    return o4;
                }
            } else {
                h o6 = o();
                if (o6 != null) {
                    return o6;
                }
            }
            return v(3);
        }

        private final h f() {
            h h4 = this.f4546a.h();
            if (h4 != null) {
                return h4;
            }
            h hVar = (h) a.this.f4542f.d();
            if (hVar == null) {
                return v(1);
            }
            return hVar;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f4545i;
        }

        private final void k(int i4) {
            this.f4549d = 0;
            if (this.f4548c == d.PARKING) {
                this.f4548c = d.BLOCKING;
            }
        }

        private final boolean l() {
            if (this.nextParkedWorker != a.f4536l) {
                return true;
            }
            return false;
        }

        private final void n() {
            if (this.f4549d == 0) {
                this.f4549d = System.nanoTime() + a.this.f4539c;
            }
            LockSupport.parkNanos(a.this.f4539c);
            if (System.nanoTime() - this.f4549d >= 0) {
                this.f4549d = 0;
                w();
            }
        }

        private final h o() {
            if (m(2) == 0) {
                h hVar = (h) a.this.f4541e.d();
                if (hVar != null) {
                    return hVar;
                }
                return (h) a.this.f4542f.d();
            }
            h hVar2 = (h) a.this.f4542f.d();
            if (hVar2 != null) {
                return hVar2;
            }
            return (h) a.this.f4541e.d();
        }

        private final void p() {
            loop0:
            while (true) {
                boolean z4 = false;
                while (!a.this.isTerminated() && this.f4548c != d.TERMINATED) {
                    h g4 = g(this.f4552g);
                    if (g4 != null) {
                        this.f4550e = 0;
                        d(g4);
                    } else {
                        this.f4552g = false;
                        if (this.f4550e == 0) {
                            t();
                        } else if (!z4) {
                            z4 = true;
                        } else {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f4550e);
                            this.f4550e = 0;
                        }
                    }
                }
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            long j4;
            if (this.f4548c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater a5 = a.f4534j;
            do {
                j4 = a5.get(aVar);
                if (((int) ((9223367638808264704L & j4) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f4534j.compareAndSet(aVar, j4, j4 - 4398046511104L));
            this.f4548c = d.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                a.this.r(this);
                return;
            }
            f4545i.set(this, -1);
            while (l() && f4545i.get(this) == -1 && !a.this.isTerminated() && this.f4548c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i4) {
            int i5 = (int) (a.f4534j.get(a.this) & 2097151);
            if (i5 < 2) {
                return null;
            }
            int m4 = m(i5);
            a aVar = a.this;
            long j4 = Long.MAX_VALUE;
            for (int i6 = 0; i6 < i5; i6++) {
                m4++;
                if (m4 > i5) {
                    m4 = 1;
                }
                c cVar = (c) aVar.f4543g.b(m4);
                if (cVar == null || cVar == this) {
                    int i7 = i4;
                } else {
                    long n4 = cVar.f4546a.n(i4, this.f4547b);
                    if (n4 == -1) {
                        C c5 = this.f4547b;
                        h hVar = (h) c5.f20968a;
                        c5.f20968a = null;
                        return hVar;
                    } else if (n4 > 0) {
                        j4 = Math.min(j4, n4);
                    }
                }
            }
            if (j4 == Long.MAX_VALUE) {
                j4 = 0;
            }
            this.f4550e = j4;
            return null;
        }

        private final void w() {
            a aVar = a.this;
            synchronized (aVar.f4543g) {
                try {
                    if (!aVar.isTerminated()) {
                        if (((int) (a.f4534j.get(aVar) & 2097151)) > aVar.f4537a) {
                            if (f4545i.compareAndSet(this, -1, 1)) {
                                int i4 = this.indexInArray;
                                q(0);
                                aVar.u(this, i4, 0);
                                int andDecrement = (int) (2097151 & a.f4534j.getAndDecrement(aVar));
                                if (andDecrement != i4) {
                                    Object b5 = aVar.f4543g.b(andDecrement);
                                    m.b(b5);
                                    c cVar = (c) b5;
                                    aVar.f4543g.c(i4, cVar);
                                    cVar.q(i4);
                                    aVar.u(cVar, andDecrement, i4);
                                }
                                aVar.f4543g.c(andDecrement, (Object) null);
                                s sVar = s.f8222a;
                                this.f4548c = d.TERMINATED;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final h g(boolean z4) {
            if (s()) {
                return e(z4);
            }
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i4) {
            int i5 = this.f4551f;
            int i6 = i5 ^ (i5 << 13);
            int i7 = i6 ^ (i6 >> 17);
            int i8 = i7 ^ (i7 << 5);
            this.f4551f = i8;
            int i9 = i4 - 1;
            if ((i9 & i4) == 0) {
                return i8 & i9;
            }
            return (i8 & Integer.MAX_VALUE) % i4;
        }

        public final void q(int i4) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f4540d);
            sb.append("-worker-");
            if (i4 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i4);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i4;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            boolean z4;
            d dVar2 = this.f4548c;
            if (dVar2 == d.CPU_ACQUIRED) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                a.f4534j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f4548c = dVar;
            }
            return z4;
        }

        public c(a aVar, int i4) {
            this();
            q(i4);
        }
    }
}
