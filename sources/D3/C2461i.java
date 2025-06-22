package D3;

import E3.c;
import G3.d;
import G3.g;
import L3.C2499f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: D3.i  reason: case insensitive filesystem */
public final class C2461i {

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f23058g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.B("OkHttp ConnectionPool", true));

    /* renamed from: a  reason: collision with root package name */
    private final int f23059a;

    /* renamed from: b  reason: collision with root package name */
    private final long f23060b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f23061c;

    /* renamed from: d  reason: collision with root package name */
    private final Deque f23062d;

    /* renamed from: e  reason: collision with root package name */
    final d f23063e;

    /* renamed from: f  reason: collision with root package name */
    boolean f23064f;

    /* renamed from: D3.i$a */
    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                D3.i r0 = D3.C2461i.this
                long r1 = java.lang.System.nanoTime()
                long r0 = r0.a(r1)
                r2 = -1
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x0011
                return
            L_0x0011:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0000
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r4 = r0 / r2
                long r2 = r2 * r4
                long r0 = r0 - r2
                D3.i r2 = D3.C2461i.this
                monitor-enter(r2)
                D3.i r3 = D3.C2461i.this     // Catch:{ InterruptedException -> 0x002b }
                int r1 = (int) r0     // Catch:{ InterruptedException -> 0x002b }
                r3.wait(r4, r1)     // Catch:{ InterruptedException -> 0x002b }
                goto L_0x002b
            L_0x0029:
                r0 = move-exception
                goto L_0x002d
            L_0x002b:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x0000
            L_0x002d:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: D3.C2461i.a.run():void");
        }
    }

    public C2461i() {
        this(5, 5, TimeUnit.MINUTES);
    }

    private int e(G3.c cVar, long j4) {
        List list = cVar.f23341n;
        int i4 = 0;
        while (i4 < list.size()) {
            Reference reference = (Reference) list.get(i4);
            if (reference.get() != null) {
                i4++;
            } else {
                C2499f.i().q("A connection to " + cVar.p().a().l() + " was leaked. Did you forget to close a response body?", ((g.a) reference).f23370a);
                list.remove(i4);
                cVar.f23338k = true;
                if (list.isEmpty()) {
                    cVar.f23342o = j4 - this.f23060b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* access modifiers changed from: package-private */
    public long a(long j4) {
        synchronized (this) {
            try {
                G3.c cVar = null;
                long j5 = Long.MIN_VALUE;
                int i4 = 0;
                int i5 = 0;
                for (G3.c cVar2 : this.f23062d) {
                    if (e(cVar2, j4) > 0) {
                        i5++;
                    } else {
                        i4++;
                        long j6 = j4 - cVar2.f23342o;
                        if (j6 > j5) {
                            cVar = cVar2;
                            j5 = j6;
                        }
                    }
                }
                long j7 = this.f23060b;
                if (j5 < j7) {
                    if (i4 <= this.f23059a) {
                        if (i4 > 0) {
                            long j8 = j7 - j5;
                            return j8;
                        } else if (i5 > 0) {
                            return j7;
                        } else {
                            this.f23064f = false;
                            return -1;
                        }
                    }
                }
                this.f23062d.remove(cVar);
                c.e(cVar.q());
                return 0;
            } finally {
                while (true) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(G3.c cVar) {
        if (cVar.f23338k || this.f23059a == 0) {
            this.f23062d.remove(cVar);
            return true;
        }
        notifyAll();
        return false;
    }

    /* access modifiers changed from: package-private */
    public Socket c(C2453a aVar, g gVar) {
        for (G3.c cVar : this.f23062d) {
            if (cVar.k(aVar, (C2451B) null) && cVar.m() && cVar != gVar.c()) {
                return gVar.l(cVar);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public G3.c d(C2453a aVar, g gVar, C2451B b5) {
        for (G3.c cVar : this.f23062d) {
            if (cVar.k(aVar, b5)) {
                gVar.a(cVar, true);
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f(G3.c cVar) {
        if (!this.f23064f) {
            this.f23064f = true;
            f23058g.execute(this.f23061c);
        }
        this.f23062d.add(cVar);
    }

    public C2461i(int i4, long j4, TimeUnit timeUnit) {
        this.f23061c = new a();
        this.f23062d = new ArrayDeque();
        this.f23063e = new d();
        this.f23059a = i4;
        this.f23060b = timeUnit.toNanos(j4);
        if (j4 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + j4);
        }
    }
}
