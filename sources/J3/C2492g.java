package J3;

import E3.C2477b;
import J3.h;
import L3.C2499f;
import N3.C2514e;
import N3.C2515f;
import N3.C2516g;
import N3.C2517h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: J3.g  reason: case insensitive filesystem */
public final class C2492g implements Closeable, AutoCloseable {
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public static final ExecutorService f23490u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), E3.c.B("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f23491a;

    /* renamed from: b  reason: collision with root package name */
    final h f23492b;

    /* renamed from: c  reason: collision with root package name */
    final Map f23493c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    final String f23494d;

    /* renamed from: e  reason: collision with root package name */
    int f23495e;

    /* renamed from: f  reason: collision with root package name */
    int f23496f;

    /* renamed from: g  reason: collision with root package name */
    boolean f23497g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ScheduledExecutorService f23498h;

    /* renamed from: i  reason: collision with root package name */
    private final ExecutorService f23499i;

    /* renamed from: j  reason: collision with root package name */
    final l f23500j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f23501k;

    /* renamed from: l  reason: collision with root package name */
    long f23502l = 0;

    /* renamed from: m  reason: collision with root package name */
    long f23503m;

    /* renamed from: n  reason: collision with root package name */
    m f23504n = new m();

    /* renamed from: o  reason: collision with root package name */
    final m f23505o;

    /* renamed from: p  reason: collision with root package name */
    boolean f23506p;

    /* renamed from: q  reason: collision with root package name */
    final Socket f23507q;

    /* renamed from: r  reason: collision with root package name */
    final j f23508r;

    /* renamed from: s  reason: collision with root package name */
    final j f23509s;

    /* renamed from: t  reason: collision with root package name */
    final Set f23510t;

    /* renamed from: J3.g$a */
    class a extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23511b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2487b f23512c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i4, C2487b bVar) {
            super(str, objArr);
            this.f23511b = i4;
            this.f23512c = bVar;
        }

        public void e() {
            try {
                C2492g.this.K(this.f23511b, this.f23512c);
            } catch (IOException unused) {
                C2492g.this.n();
            }
        }
    }

    /* renamed from: J3.g$b */
    class b extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23514b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f23515c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i4, long j4) {
            super(str, objArr);
            this.f23514b = i4;
            this.f23515c = j4;
        }

        public void e() {
            try {
                C2492g.this.f23508r.x(this.f23514b, this.f23515c);
            } catch (IOException unused) {
                C2492g.this.n();
            }
        }
    }

    /* renamed from: J3.g$c */
    class c extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23517b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f23518c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i4, List list) {
            super(str, objArr);
            this.f23517b = i4;
            this.f23518c = list;
        }

        public void e() {
            if (C2492g.this.f23500j.onRequest(this.f23517b, this.f23518c)) {
                try {
                    C2492g.this.f23508r.u(this.f23517b, C2487b.CANCEL);
                    synchronized (C2492g.this) {
                        C2492g.this.f23510t.remove(Integer.valueOf(this.f23517b));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: J3.g$d */
    class d extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23520b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f23521c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f23522d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i4, List list, boolean z4) {
            super(str, objArr);
            this.f23520b = i4;
            this.f23521c = list;
            this.f23522d = z4;
        }

        public void e() {
            boolean onHeaders = C2492g.this.f23500j.onHeaders(this.f23520b, this.f23521c, this.f23522d);
            if (onHeaders) {
                try {
                    C2492g.this.f23508r.u(this.f23520b, C2487b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (onHeaders || this.f23522d) {
                synchronized (C2492g.this) {
                    C2492g.this.f23510t.remove(Integer.valueOf(this.f23520b));
                }
            }
        }
    }

    /* renamed from: J3.g$e */
    class e extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23524b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2514e f23525c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f23526d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f23527e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i4, C2514e eVar, int i5, boolean z4) {
            super(str, objArr);
            this.f23524b = i4;
            this.f23525c = eVar;
            this.f23526d = i5;
            this.f23527e = z4;
        }

        public void e() {
            try {
                boolean a5 = C2492g.this.f23500j.a(this.f23524b, this.f23525c, this.f23526d, this.f23527e);
                if (a5) {
                    C2492g.this.f23508r.u(this.f23524b, C2487b.CANCEL);
                }
                if (a5 || this.f23527e) {
                    synchronized (C2492g.this) {
                        C2492g.this.f23510t.remove(Integer.valueOf(this.f23524b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: J3.g$f */
    class f extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f23529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2487b f23530c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i4, C2487b bVar) {
            super(str, objArr);
            this.f23529b = i4;
            this.f23530c = bVar;
        }

        public void e() {
            C2492g.this.f23500j.b(this.f23529b, this.f23530c);
            synchronized (C2492g.this) {
                C2492g.this.f23510t.remove(Integer.valueOf(this.f23529b));
            }
        }
    }

    /* renamed from: J3.g$g  reason: collision with other inner class name */
    public static class C0282g {

        /* renamed from: a  reason: collision with root package name */
        Socket f23532a;

        /* renamed from: b  reason: collision with root package name */
        String f23533b;

        /* renamed from: c  reason: collision with root package name */
        C2516g f23534c;

        /* renamed from: d  reason: collision with root package name */
        C2515f f23535d;

        /* renamed from: e  reason: collision with root package name */
        h f23536e = h.f23540a;

        /* renamed from: f  reason: collision with root package name */
        l f23537f = l.f23600a;

        /* renamed from: g  reason: collision with root package name */
        boolean f23538g;

        /* renamed from: h  reason: collision with root package name */
        int f23539h;

        public C0282g(boolean z4) {
            this.f23538g = z4;
        }

        public C2492g a() {
            return new C2492g(this);
        }

        public C0282g b(h hVar) {
            this.f23536e = hVar;
            return this;
        }

        public C0282g c(int i4) {
            this.f23539h = i4;
            return this;
        }

        public C0282g d(Socket socket, String str, C2516g gVar, C2515f fVar) {
            this.f23532a = socket;
            this.f23533b = str;
            this.f23534c = gVar;
            this.f23535d = fVar;
            return this;
        }
    }

    /* renamed from: J3.g$i */
    final class i extends C2477b {

        /* renamed from: b  reason: collision with root package name */
        final boolean f23541b;

        /* renamed from: c  reason: collision with root package name */
        final int f23542c;

        /* renamed from: d  reason: collision with root package name */
        final int f23543d;

        i(boolean z4, int i4, int i5) {
            super("OkHttp %s ping %08x%08x", C2492g.this.f23494d, Integer.valueOf(i4), Integer.valueOf(i5));
            this.f23541b = z4;
            this.f23542c = i4;
            this.f23543d = i5;
        }

        public void e() {
            C2492g.this.J(this.f23541b, this.f23542c, this.f23543d);
        }
    }

    C2492g(C0282g gVar) {
        int i4;
        C0282g gVar2 = gVar;
        m mVar = new m();
        this.f23505o = mVar;
        this.f23506p = false;
        this.f23510t = new LinkedHashSet();
        this.f23500j = gVar2.f23537f;
        boolean z4 = gVar2.f23538g;
        this.f23491a = z4;
        this.f23492b = gVar2.f23536e;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        this.f23496f = i4;
        if (z4) {
            this.f23496f = i4 + 2;
        }
        if (z4) {
            this.f23504n.i(7, 16777216);
        }
        String str = gVar2.f23533b;
        this.f23494d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, E3.c.B(E3.c.o("OkHttp %s Writer", str), false));
        this.f23498h = scheduledThreadPoolExecutor;
        if (gVar2.f23539h != 0) {
            i iVar = new i(false, 0, 0);
            int i5 = gVar2.f23539h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, (long) i5, (long) i5, TimeUnit.MILLISECONDS);
        }
        this.f23499i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), E3.c.B(E3.c.o("OkHttp %s Push Observer", str), true));
        mVar.i(7, 65535);
        mVar.i(5, 16384);
        this.f23503m = (long) mVar.d();
        this.f23507q = gVar2.f23532a;
        this.f23508r = new j(gVar2.f23535d, z4);
        this.f23509s = new j(new h(gVar2.f23534c, z4));
    }

    /* access modifiers changed from: private */
    public void n() {
        try {
            C2487b bVar = C2487b.PROTOCOL_ERROR;
            l(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private J3.i u(int r10, java.util.List r11, boolean r12) {
        /*
            r9 = this;
            r3 = r12 ^ 1
            J3.j r6 = r9.f23508r
            monitor-enter(r6)
            monitor-enter(r9)     // Catch:{ all -> 0x0082 }
            int r0 = r9.f23496f     // Catch:{ all -> 0x0076 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0018
            J3.b r0 = J3.C2487b.REFUSED_STREAM     // Catch:{ all -> 0x0013 }
            r9.F(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0018
        L_0x0013:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L_0x0080
        L_0x0018:
            boolean r0 = r9.f23497g     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0079
            int r1 = r9.f23496f     // Catch:{ all -> 0x0076 }
            int r0 = r1 + 2
            r9.f23496f = r0     // Catch:{ all -> 0x0076 }
            J3.i r0 = new J3.i     // Catch:{ all -> 0x0076 }
            r4 = 0
            r2 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x003d }
            if (r12 == 0) goto L_0x0040
            long r11 = r2.f23503m     // Catch:{ all -> 0x003d }
            r7 = 0
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0040
            long r11 = r0.f23564b     // Catch:{ all -> 0x003d }
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            r11 = 0
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            r10 = r0
            goto L_0x0080
        L_0x0040:
            r11 = 1
        L_0x0041:
            boolean r12 = r0.k()     // Catch:{ all -> 0x003d }
            if (r12 == 0) goto L_0x0050
            java.util.Map r12 = r2.f23493c     // Catch:{ all -> 0x003d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003d }
            r12.put(r4, r0)     // Catch:{ all -> 0x003d }
        L_0x0050:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            if (r10 != 0) goto L_0x005c
            J3.j r12 = r2.f23508r     // Catch:{ all -> 0x0059 }
            r12.w(r3, r1, r10, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0065
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            r10 = r0
            goto L_0x0085
        L_0x005c:
            boolean r12 = r2.f23491a     // Catch:{ all -> 0x0059 }
            if (r12 != 0) goto L_0x006e
            J3.j r12 = r2.f23508r     // Catch:{ all -> 0x0059 }
            r12.r(r10, r1, r5)     // Catch:{ all -> 0x0059 }
        L_0x0065:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            if (r11 == 0) goto L_0x006d
            J3.j r10 = r2.f23508r
            r10.flush()
        L_0x006d:
            return r0
        L_0x006e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0076:
            r0 = move-exception
            r2 = r9
            goto L_0x003e
        L_0x0079:
            r2 = r9
            J3.a r10 = new J3.a     // Catch:{ all -> 0x003d }
            r10.<init>()     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x003d }
        L_0x0080:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0082:
            r0 = move-exception
            r2 = r9
            goto L_0x005a
        L_0x0085:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.C2492g.u(int, java.util.List, boolean):J3.i");
    }

    /* access modifiers changed from: package-private */
    public void A(int i4, C2487b bVar) {
        this.f23499i.execute(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, bVar));
    }

    /* access modifiers changed from: package-private */
    public boolean D(int i4) {
        if (i4 == 0 || (i4 & 1) != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public synchronized i E(int i4) {
        i iVar;
        iVar = (i) this.f23493c.remove(Integer.valueOf(i4));
        notifyAll();
        return iVar;
    }

    public void F(C2487b bVar) {
        synchronized (this.f23508r) {
            synchronized (this) {
                if (!this.f23497g) {
                    this.f23497g = true;
                    int i4 = this.f23495e;
                    this.f23508r.l(i4, bVar, E3.c.f23242a);
                }
            }
        }
    }

    public void G() {
        H(true);
    }

    /* access modifiers changed from: package-private */
    public void H(boolean z4) {
        if (z4) {
            this.f23508r.d();
            this.f23508r.v(this.f23504n);
            int d5 = this.f23504n.d();
            if (d5 != 65535) {
                this.f23508r.x(0, (long) (d5 - 65535));
            }
        }
        new Thread(this.f23509s).start();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f23508r.o());
        r6 = (long) r3;
        r8.f23503m -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I(int r9, boolean r10, N3.C2514e r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            J3.j r12 = r8.f23508r
            r12.g(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0060
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f23503m     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0032
            java.util.Map r3 = r8.f23493c     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            r9 = move-exception
            goto L_0x005e
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0032:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0028 }
            int r4 = (int) r3     // Catch:{ all -> 0x0028 }
            J3.j r3 = r8.f23508r     // Catch:{ all -> 0x0028 }
            int r3 = r3.o()     // Catch:{ all -> 0x0028 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0028 }
            long r4 = r8.f23503m     // Catch:{ all -> 0x0028 }
            long r6 = (long) r3     // Catch:{ all -> 0x0028 }
            long r4 = r4 - r6
            r8.f23503m = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            long r12 = r12 - r6
            J3.j r4 = r8.f23508r
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.g(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0058:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            throw r9     // Catch:{ all -> 0x0028 }
        L_0x005e:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.C2492g.I(int, boolean, N3.e, long):void");
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z4, int i4, int i5) {
        boolean z5;
        if (!z4) {
            synchronized (this) {
                z5 = this.f23501k;
                this.f23501k = true;
            }
            if (z5) {
                n();
                return;
            }
        }
        try {
            this.f23508r.p(z4, i4, i5);
        } catch (IOException unused) {
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void K(int i4, C2487b bVar) {
        this.f23508r.u(i4, bVar);
    }

    /* access modifiers changed from: package-private */
    public void L(int i4, C2487b bVar) {
        try {
            this.f23498h.execute(new a("OkHttp %s stream %d", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void M(int i4, long j4) {
        try {
            this.f23498h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, j4));
        } catch (RejectedExecutionException unused) {
        }
    }

    public void close() {
        l(C2487b.NO_ERROR, C2487b.CANCEL);
    }

    public void flush() {
        this.f23508r.flush();
    }

    /* access modifiers changed from: package-private */
    public void k(long j4) {
        this.f23503m += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void l(C2487b bVar, C2487b bVar2) {
        i[] iVarArr = null;
        try {
            F(bVar);
            e = null;
        } catch (IOException e5) {
            e = e5;
        }
        synchronized (this) {
            try {
                if (!this.f23493c.isEmpty()) {
                    iVarArr = (i[]) this.f23493c.values().toArray(new i[this.f23493c.size()]);
                    this.f23493c.clear();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (iVarArr != null) {
            for (i d5 : iVarArr) {
                try {
                    d5.d(bVar2);
                } catch (IOException e6) {
                    if (e != null) {
                        e = e6;
                    }
                }
            }
        }
        try {
            this.f23508r.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.f23507q.close();
        } catch (IOException e8) {
            e = e8;
        }
        this.f23498h.shutdown();
        this.f23499i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized i o(int i4) {
        return (i) this.f23493c.get(Integer.valueOf(i4));
    }

    public synchronized boolean p() {
        return this.f23497g;
    }

    public synchronized int r() {
        return this.f23505o.e(Integer.MAX_VALUE);
    }

    public i v(List list, boolean z4) {
        return u(0, list, z4);
    }

    /* access modifiers changed from: package-private */
    public void w(int i4, C2516g gVar, int i5, boolean z4) {
        C2514e eVar = new C2514e();
        long j4 = (long) i5;
        gVar.require(j4);
        gVar.e(eVar, j4);
        if (eVar.A() == j4) {
            this.f23499i.execute(new e("OkHttp %s Push Data[%s]", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, eVar, i5, z4));
            return;
        }
        throw new IOException(eVar.A() + " != " + i5);
    }

    /* access modifiers changed from: package-private */
    public void x(int i4, List list, boolean z4) {
        try {
            this.f23499i.execute(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, list, z4));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void z(int i4, List list) {
        Throwable th;
        synchronized (this) {
            try {
                if (this.f23510t.contains(Integer.valueOf(i4))) {
                    try {
                        L(i4, C2487b.PROTOCOL_ERROR);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    this.f23510t.add(Integer.valueOf(i4));
                    try {
                        try {
                            this.f23499i.execute(new c("OkHttp %s Push Request[%s]", new Object[]{this.f23494d, Integer.valueOf(i4)}, i4, list));
                        } catch (RejectedExecutionException unused) {
                        }
                    } catch (RejectedExecutionException unused2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    /* renamed from: J3.g$j */
    class j extends C2477b implements h.b {

        /* renamed from: b  reason: collision with root package name */
        final h f23545b;

        /* renamed from: J3.g$j$a */
        class a extends C2477b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i f23547b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, i iVar) {
                super(str, objArr);
                this.f23547b = iVar;
            }

            public void e() {
                try {
                    C2492g.this.f23492b.b(this.f23547b);
                } catch (IOException e5) {
                    C2499f i4 = C2499f.i();
                    i4.p(4, "Http2Connection.Listener failure for " + C2492g.this.f23494d, e5);
                    try {
                        this.f23547b.d(C2487b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* renamed from: J3.g$j$b */
        class b extends C2477b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            public void e() {
                C2492g gVar = C2492g.this;
                gVar.f23492b.a(gVar);
            }
        }

        /* renamed from: J3.g$j$c */
        class c extends C2477b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ m f23550b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f23550b = mVar;
            }

            public void e() {
                try {
                    C2492g.this.f23508r.a(this.f23550b);
                } catch (IOException unused) {
                    C2492g.this.n();
                }
            }
        }

        j(h hVar) {
            super("OkHttp %s", C2492g.this.f23494d);
            this.f23545b = hVar;
        }

        private void f(m mVar) {
            try {
                C2492g.this.f23498h.execute(new c("OkHttp %s ACK Settings", new Object[]{C2492g.this.f23494d}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void a(int i4, C2487b bVar, C2517h hVar) {
            i[] iVarArr;
            hVar.G();
            synchronized (C2492g.this) {
                iVarArr = (i[]) C2492g.this.f23493c.values().toArray(new i[C2492g.this.f23493c.size()]);
                C2492g.this.f23497g = true;
            }
            for (i iVar : iVarArr) {
                if (iVar.g() > i4 && iVar.j()) {
                    iVar.p(C2487b.REFUSED_STREAM);
                    C2492g.this.E(iVar.g());
                }
            }
        }

        public void b(boolean z4, int i4, C2516g gVar, int i5) {
            if (C2492g.this.D(i4)) {
                C2492g.this.w(i4, gVar, i5, z4);
                return;
            }
            i o4 = C2492g.this.o(i4);
            if (o4 == null) {
                C2492g.this.L(i4, C2487b.PROTOCOL_ERROR);
                gVar.skip((long) i5);
                return;
            }
            o4.m(gVar, i5);
            if (z4) {
                o4.n();
            }
        }

        public void c(int i4, C2487b bVar) {
            if (C2492g.this.D(i4)) {
                C2492g.this.A(i4, bVar);
                return;
            }
            i E4 = C2492g.this.E(i4);
            if (E4 != null) {
                E4.p(bVar);
            }
        }

        /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r12, J3.m r13) {
            /*
                r11 = this;
                r0 = 0
                r1 = 1
                J3.g r2 = J3.C2492g.this
                monitor-enter(r2)
                J3.g r3 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                J3.m r3 = r3.f23505o     // Catch:{ all -> 0x0017 }
                int r3 = r3.d()     // Catch:{ all -> 0x0017 }
                if (r12 == 0) goto L_0x001a
                J3.g r12 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                J3.m r12 = r12.f23505o     // Catch:{ all -> 0x0017 }
                r12.a()     // Catch:{ all -> 0x0017 }
                goto L_0x001a
            L_0x0017:
                r12 = move-exception
                goto L_0x0095
            L_0x001a:
                J3.g r12 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                J3.m r12 = r12.f23505o     // Catch:{ all -> 0x0017 }
                r12.h(r13)     // Catch:{ all -> 0x0017 }
                r11.f(r13)     // Catch:{ all -> 0x0017 }
                J3.g r12 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                J3.m r12 = r12.f23505o     // Catch:{ all -> 0x0017 }
                int r12 = r12.d()     // Catch:{ all -> 0x0017 }
                r13 = -1
                r4 = 0
                r6 = 0
                if (r12 == r13) goto L_0x0067
                if (r12 == r3) goto L_0x0067
                int r12 = r12 - r3
                long r12 = (long) r12     // Catch:{ all -> 0x0017 }
                J3.g r3 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                boolean r7 = r3.f23506p     // Catch:{ all -> 0x0017 }
                if (r7 != 0) goto L_0x0043
                r3.k(r12)     // Catch:{ all -> 0x0017 }
                J3.g r3 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                r3.f23506p = r1     // Catch:{ all -> 0x0017 }
            L_0x0043:
                J3.g r3 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                java.util.Map r3 = r3.f23493c     // Catch:{ all -> 0x0017 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0017 }
                if (r3 != 0) goto L_0x0068
                J3.g r3 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                java.util.Map r3 = r3.f23493c     // Catch:{ all -> 0x0017 }
                java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0017 }
                J3.g r6 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                java.util.Map r6 = r6.f23493c     // Catch:{ all -> 0x0017 }
                int r6 = r6.size()     // Catch:{ all -> 0x0017 }
                J3.i[] r6 = new J3.i[r6]     // Catch:{ all -> 0x0017 }
                java.lang.Object[] r3 = r3.toArray(r6)     // Catch:{ all -> 0x0017 }
                r6 = r3
                J3.i[] r6 = (J3.i[]) r6     // Catch:{ all -> 0x0017 }
                goto L_0x0068
            L_0x0067:
                r12 = r4
            L_0x0068:
                java.util.concurrent.ExecutorService r3 = J3.C2492g.f23490u     // Catch:{ all -> 0x0017 }
                J3.g$j$b r7 = new J3.g$j$b     // Catch:{ all -> 0x0017 }
                java.lang.String r8 = "OkHttp %s settings"
                J3.g r9 = J3.C2492g.this     // Catch:{ all -> 0x0017 }
                java.lang.String r9 = r9.f23494d     // Catch:{ all -> 0x0017 }
                java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ all -> 0x0017 }
                r10[r0] = r9     // Catch:{ all -> 0x0017 }
                r7.<init>(r8, r10)     // Catch:{ all -> 0x0017 }
                r3.execute(r7)     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                if (r6 == 0) goto L_0x0094
                int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
                if (r2 == 0) goto L_0x0094
                int r2 = r6.length
            L_0x0086:
                if (r0 >= r2) goto L_0x0094
                r3 = r6[r0]
                monitor-enter(r3)
                r3.a(r12)     // Catch:{ all -> 0x0091 }
                monitor-exit(r3)     // Catch:{ all -> 0x0091 }
                int r0 = r0 + r1
                goto L_0x0086
            L_0x0091:
                r12 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0091 }
                throw r12
            L_0x0094:
                return
            L_0x0095:
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.C2492g.j.d(boolean, J3.m):void");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = J3.C2487b.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4.f23546c.l(r0, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r4 = this;
                J3.b r0 = J3.C2487b.INTERNAL_ERROR
                J3.h r1 = r4.f23545b     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r1.g(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            L_0x0007:
                J3.h r1 = r4.f23545b     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r2 = 0
                boolean r1 = r1.d(r2, r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                J3.b r1 = J3.C2487b.NO_ERROR     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                J3.b r0 = J3.C2487b.CANCEL     // Catch:{ IOException -> 0x0026 }
                J3.g r2 = J3.C2492g.this     // Catch:{ IOException -> 0x001a }
                r2.l(r1, r0)     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                J3.h r0 = r4.f23545b
                E3.c.d(r0)
                goto L_0x002e
            L_0x0020:
                r2 = move-exception
                goto L_0x002f
            L_0x0022:
                r2 = move-exception
                r1 = r0
                goto L_0x002f
            L_0x0025:
                r1 = r0
            L_0x0026:
                J3.b r0 = J3.C2487b.PROTOCOL_ERROR     // Catch:{ all -> 0x0020 }
                J3.g r1 = J3.C2492g.this     // Catch:{ IOException -> 0x001a }
                r1.l(r0, r0)     // Catch:{ IOException -> 0x001a }
                goto L_0x001a
            L_0x002e:
                return
            L_0x002f:
                J3.g r3 = J3.C2492g.this     // Catch:{ IOException -> 0x0034 }
                r3.l(r1, r0)     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                J3.h r0 = r4.f23545b
                E3.c.d(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.C2492g.j.e():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
            r0.o(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
            if (r6 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
            r0.n();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r9, int r10, int r11, java.util.List r12) {
            /*
                r8 = this;
                r11 = 2
                J3.g r0 = J3.C2492g.this
                boolean r0 = r0.D(r10)
                if (r0 == 0) goto L_0x000f
                J3.g r11 = J3.C2492g.this
                r11.x(r10, r12, r9)
                return
            L_0x000f:
                J3.g r1 = J3.C2492g.this
                monitor-enter(r1)
                J3.g r0 = J3.C2492g.this     // Catch:{ all -> 0x0022 }
                J3.i r0 = r0.o(r10)     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x006c
                J3.g r0 = J3.C2492g.this     // Catch:{ all -> 0x0022 }
                boolean r2 = r0.f23497g     // Catch:{ all -> 0x0022 }
                if (r2 == 0) goto L_0x0025
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                return
            L_0x0022:
                r0 = move-exception
                r9 = r0
                goto L_0x0078
            L_0x0025:
                int r2 = r0.f23495e     // Catch:{ all -> 0x0022 }
                if (r10 > r2) goto L_0x002b
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                return
            L_0x002b:
                int r2 = r10 % 2
                int r0 = r0.f23496f     // Catch:{ all -> 0x0022 }
                int r0 = r0 % r11
                if (r2 != r0) goto L_0x0034
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                return
            L_0x0034:
                J3.i r2 = new J3.i     // Catch:{ all -> 0x0022 }
                J3.g r4 = J3.C2492g.this     // Catch:{ all -> 0x0022 }
                r5 = 0
                r6 = r9
                r3 = r10
                r7 = r12
                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0022 }
                J3.g r9 = J3.C2492g.this     // Catch:{ all -> 0x0022 }
                r9.f23495e = r3     // Catch:{ all -> 0x0022 }
                java.util.Map r9 = r9.f23493c     // Catch:{ all -> 0x0022 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0022 }
                r9.put(r10, r2)     // Catch:{ all -> 0x0022 }
                java.util.concurrent.ExecutorService r9 = J3.C2492g.f23490u     // Catch:{ all -> 0x0022 }
                J3.g$j$a r10 = new J3.g$j$a     // Catch:{ all -> 0x0022 }
                java.lang.String r12 = "OkHttp %s stream %d"
                J3.g r0 = J3.C2492g.this     // Catch:{ all -> 0x0022 }
                java.lang.String r0 = r0.f23494d     // Catch:{ all -> 0x0022 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0022 }
                java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0022 }
                r4 = 0
                r11[r4] = r0     // Catch:{ all -> 0x0022 }
                r0 = 1
                r11[r0] = r3     // Catch:{ all -> 0x0022 }
                r10.<init>(r12, r11, r2)     // Catch:{ all -> 0x0022 }
                r9.execute(r10)     // Catch:{ all -> 0x0022 }
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                return
            L_0x006c:
                r6 = r9
                r7 = r12
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                r0.o(r7)
                if (r6 == 0) goto L_0x0077
                r0.n()
            L_0x0077:
                return
            L_0x0078:
                monitor-exit(r1)     // Catch:{ all -> 0x0022 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.C2492g.j.headers(boolean, int, int, java.util.List):void");
        }

        public void ping(boolean z4, int i4, int i5) {
            if (z4) {
                synchronized (C2492g.this) {
                    boolean unused = C2492g.this.f23501k = false;
                    C2492g.this.notifyAll();
                }
                return;
            }
            try {
                C2492g.this.f23498h.execute(new i(true, i4, i5));
            } catch (RejectedExecutionException unused2) {
            }
        }

        public void pushPromise(int i4, int i5, List list) {
            C2492g.this.z(i5, list);
        }

        public void windowUpdate(int i4, long j4) {
            if (i4 == 0) {
                synchronized (C2492g.this) {
                    C2492g gVar = C2492g.this;
                    gVar.f23503m += j4;
                    gVar.notifyAll();
                }
                return;
            }
            i o4 = C2492g.this.o(i4);
            if (o4 != null) {
                synchronized (o4) {
                    o4.a(j4);
                }
            }
        }

        public void ackSettings() {
        }

        public void priority(int i4, int i5, int i6, boolean z4) {
        }
    }

    /* renamed from: J3.g$h */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public static final h f23540a = new a();

        /* renamed from: J3.g$h$a */
        class a extends h {
            a() {
            }

            public void b(i iVar) {
                iVar.d(C2487b.REFUSED_STREAM);
            }
        }

        public abstract void b(i iVar);

        public void a(C2492g gVar) {
        }
    }
}
