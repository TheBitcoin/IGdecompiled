package t3;

import V2.g;
import V2.h;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import o3.C0989m;
import o3.G;
import o3.I;
import o3.P;
import o3.T;

/* renamed from: t3.m  reason: case insensitive filesystem */
public final class C1063m extends G implements T {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4502f = AtomicIntegerFieldUpdater.newUpdater(C1063m.class, "runningWorkers");
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final G f4503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4504b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ T f4505c;

    /* renamed from: d  reason: collision with root package name */
    private final r f4506d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4507e;
    private volatile int runningWorkers;

    /* renamed from: t3.m$a */
    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f4508a;

        public a(Runnable runnable) {
            this.f4508a = runnable;
        }

        public void run() {
            int i4 = 0;
            while (true) {
                try {
                    this.f4508a.run();
                } catch (Throwable th) {
                    I.a(h.f8445a, th);
                }
                Runnable F4 = C1063m.this.G();
                if (F4 != null) {
                    this.f4508a = F4;
                    i4++;
                    if (i4 >= 16 && C1063m.this.f4503a.isDispatchNeeded(C1063m.this)) {
                        C1063m.this.f4503a.dispatch(C1063m.this, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public C1063m(G g4, int i4) {
        T t4;
        this.f4503a = g4;
        this.f4504b = i4;
        if (g4 instanceof T) {
            t4 = (T) g4;
        } else {
            t4 = null;
        }
        this.f4505c = t4 == null ? P.a() : t4;
        this.f4506d = new r(false);
        this.f4507e = new Object();
    }

    /* access modifiers changed from: private */
    public final Runnable G() {
        while (true) {
            Runnable runnable = (Runnable) this.f4506d.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f4507e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4502f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f4506d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean H() {
        synchronized (this.f4507e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4502f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f4504b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    public void dispatch(g gVar, Runnable runnable) {
        Runnable G4;
        this.f4506d.a(runnable);
        if (f4502f.get(this) < this.f4504b && H() && (G4 = G()) != null) {
            this.f4503a.dispatch(this, new a(G4));
        }
    }

    public void dispatchYield(g gVar, Runnable runnable) {
        Runnable G4;
        this.f4506d.a(runnable);
        if (f4502f.get(this) < this.f4504b && H() && (G4 = G()) != null) {
            this.f4503a.dispatchYield(this, new a(G4));
        }
    }

    public G limitedParallelism(int i4) {
        C1064n.a(i4);
        if (i4 >= this.f4504b) {
            return this;
        }
        return super.limitedParallelism(i4);
    }

    public void n(long j4, C0989m mVar) {
        this.f4505c.n(j4, mVar);
    }
}
