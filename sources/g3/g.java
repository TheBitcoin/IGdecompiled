package G3;

import D3.C2451B;
import D3.C2453a;
import D3.C2457e;
import D3.C2461i;
import D3.C2467o;
import D3.C2471s;
import D3.C2473u;
import E3.C2476a;
import E3.c;
import G3.f;
import H3.C2484c;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final C2453a f23356a;

    /* renamed from: b  reason: collision with root package name */
    private f.a f23357b;

    /* renamed from: c  reason: collision with root package name */
    private C2451B f23358c;

    /* renamed from: d  reason: collision with root package name */
    private final C2461i f23359d;

    /* renamed from: e  reason: collision with root package name */
    public final C2457e f23360e;

    /* renamed from: f  reason: collision with root package name */
    public final C2467o f23361f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f23362g;

    /* renamed from: h  reason: collision with root package name */
    private final f f23363h;

    /* renamed from: i  reason: collision with root package name */
    private int f23364i;

    /* renamed from: j  reason: collision with root package name */
    private c f23365j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23366k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23367l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23368m;

    /* renamed from: n  reason: collision with root package name */
    private C2484c f23369n;

    public static final class a extends WeakReference {

        /* renamed from: a  reason: collision with root package name */
        public final Object f23370a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f23370a = obj;
        }
    }

    public g(C2461i iVar, C2453a aVar, C2457e eVar, C2467o oVar, Object obj) {
        this.f23359d = iVar;
        this.f23356a = aVar;
        this.f23360e = eVar;
        this.f23361f = oVar;
        this.f23363h = new f(aVar, o(), eVar, oVar);
        this.f23362g = obj;
    }

    private Socket d(boolean z4, boolean z5, boolean z6) {
        Socket socket;
        if (z6) {
            this.f23369n = null;
        }
        if (z5) {
            this.f23367l = true;
        }
        c cVar = this.f23365j;
        if (cVar != null) {
            if (z4) {
                cVar.f23338k = true;
            }
            if (this.f23369n == null && (this.f23367l || cVar.f23338k)) {
                k(cVar);
                if (this.f23365j.f23341n.isEmpty()) {
                    this.f23365j.f23342o = System.nanoTime();
                    if (C2476a.f23240a.e(this.f23359d, this.f23365j)) {
                        socket = this.f23365j.q();
                        this.f23365j = null;
                        return socket;
                    }
                }
                socket = null;
                this.f23365j = null;
                return socket;
            }
        }
        return null;
    }

    private c e(int i4, int i5, int i6, int i7, boolean z4) {
        c cVar;
        Socket m4;
        c cVar2;
        Socket socket;
        boolean z5;
        C2451B b5;
        boolean z6;
        c cVar3;
        f.a aVar;
        synchronized (this.f23359d) {
            try {
                if (this.f23367l) {
                    throw new IllegalStateException("released");
                } else if (this.f23369n != null) {
                    throw new IllegalStateException("codec != null");
                } else if (!this.f23368m) {
                    cVar = this.f23365j;
                    m4 = m();
                    cVar2 = this.f23365j;
                    socket = null;
                    if (cVar2 != null) {
                        cVar = null;
                    } else {
                        cVar2 = null;
                    }
                    if (!this.f23366k) {
                        cVar = null;
                    }
                    if (cVar2 == null) {
                        C2476a.f23240a.h(this.f23359d, this.f23356a, this, (C2451B) null);
                        c cVar4 = this.f23365j;
                        if (cVar4 != null) {
                            cVar2 = cVar4;
                            z5 = true;
                            b5 = null;
                        } else {
                            b5 = this.f23358c;
                        }
                    } else {
                        b5 = null;
                    }
                    z5 = false;
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
                Throwable th = th;
            }
        }
        c.e(m4);
        if (cVar != null) {
            this.f23361f.h(this.f23360e, cVar);
        }
        if (z5) {
            this.f23361f.g(this.f23360e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (b5 != null || ((aVar = this.f23357b) != null && aVar.b())) {
            z6 = false;
        } else {
            this.f23357b = this.f23363h.e();
            z6 = true;
        }
        synchronized (this.f23359d) {
            try {
                if (!this.f23368m) {
                    if (z6) {
                        List a5 = this.f23357b.a();
                        int size = a5.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size) {
                                break;
                            }
                            C2451B b6 = (C2451B) a5.get(i8);
                            C2476a.f23240a.h(this.f23359d, this.f23356a, this, b6);
                            c cVar5 = this.f23365j;
                            if (cVar5 != null) {
                                this.f23358c = b6;
                                cVar2 = cVar5;
                                z5 = true;
                                break;
                            }
                            i8++;
                        }
                    }
                    if (!z5) {
                        if (b5 == null) {
                            b5 = this.f23357b.c();
                        }
                        this.f23358c = b5;
                        this.f23364i = 0;
                        cVar2 = new c(this.f23359d, b5);
                        a(cVar2, false);
                    }
                    cVar3 = cVar2;
                } else {
                    throw new IOException("Canceled");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z5) {
            this.f23361f.g(this.f23360e, cVar3);
            return cVar3;
        }
        cVar3.c(i4, i5, i6, i7, z4, this.f23360e, this.f23361f);
        o().a(cVar3.p());
        synchronized (this.f23359d) {
            try {
                this.f23366k = true;
                C2476a.f23240a.i(this.f23359d, cVar3);
                if (cVar3.m()) {
                    socket = C2476a.f23240a.f(this.f23359d, this.f23356a, this);
                    cVar3 = this.f23365j;
                }
            } catch (Throwable th3) {
                while (true) {
                    throw th3;
                }
            }
        }
        c.e(socket);
        this.f23361f.g(this.f23360e, cVar3);
        return cVar3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r0.l(r10) != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private G3.c f(int r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        /*
            r4 = this;
        L_0x0000:
            G3.c r0 = r4.e(r5, r6, r7, r8, r9)
            r1 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            D3.i r2 = r5.f23359d
            monitor-enter(r2)
            int r3 = r0.f23339l     // Catch:{ all -> 0x0013 }
            if (r3 != 0) goto L_0x0016
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            return r0
        L_0x0013:
            r0 = move-exception
            r6 = r0
            goto L_0x0027
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.l(r10)
            if (r2 != 0) goto L_0x0026
            r4.i()
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r1
            goto L_0x0000
        L_0x0026:
            return r0
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.g.f(int, int, int, int, boolean, boolean):G3.c");
    }

    private void k(c cVar) {
        int size = cVar.f23341n.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (((Reference) cVar.f23341n.get(i4)).get() == this) {
                cVar.f23341n.remove(i4);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket m() {
        c cVar = this.f23365j;
        if (cVar == null || !cVar.f23338k) {
            return null;
        }
        return d(false, false, true);
    }

    private d o() {
        return C2476a.f23240a.j(this.f23359d);
    }

    public void a(c cVar, boolean z4) {
        if (this.f23365j == null) {
            this.f23365j = cVar;
            this.f23366k = z4;
            cVar.f23341n.add(new a(this, this.f23362g));
            return;
        }
        throw new IllegalStateException();
    }

    public C2484c b() {
        C2484c cVar;
        synchronized (this.f23359d) {
            cVar = this.f23369n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.f23365j;
    }

    public boolean g() {
        if (this.f23358c != null) {
            return true;
        }
        f.a aVar = this.f23357b;
        if ((aVar == null || !aVar.b()) && !this.f23363h.c()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    public C2484c h(C2473u uVar, C2471s.a aVar, boolean z4) {
        try {
            C2484c o4 = f(aVar.connectTimeoutMillis(), aVar.readTimeoutMillis(), aVar.writeTimeoutMillis(), uVar.r(), uVar.A(), z4).o(uVar, aVar, this);
            synchronized (this.f23359d) {
                this.f23369n = o4;
            }
            return o4;
        } catch (IOException e5) {
            throw new e(e5);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i() {
        c cVar;
        Socket d5;
        synchronized (this.f23359d) {
            cVar = this.f23365j;
            d5 = d(true, false, false);
            if (this.f23365j != null) {
                cVar = null;
            }
        }
        c.e(d5);
        if (cVar != null) {
            this.f23361f.h(this.f23360e, cVar);
        }
    }

    public void j() {
        c cVar;
        Socket d5;
        synchronized (this.f23359d) {
            cVar = this.f23365j;
            d5 = d(false, true, false);
            if (this.f23365j != null) {
                cVar = null;
            }
        }
        c.e(d5);
        if (cVar != null) {
            this.f23361f.h(this.f23360e, cVar);
        }
    }

    public Socket l(c cVar) {
        if (this.f23369n == null && this.f23365j.f23341n.size() == 1) {
            Socket d5 = d(true, false, false);
            this.f23365j = cVar;
            cVar.f23341n.add((Reference) this.f23365j.f23341n.get(0));
            return d5;
        }
        throw new IllegalStateException();
    }

    public C2451B n() {
        return this.f23358c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051 A[Catch:{ all -> 0x0018 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p(java.io.IOException r7) {
        /*
            r6 = this;
            D3.i r0 = r6.f23359d
            monitor-enter(r0)
            boolean r1 = r7 instanceof J3.n     // Catch:{ all -> 0x0018 }
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0023
            J3.n r7 = (J3.n) r7     // Catch:{ all -> 0x0018 }
            J3.b r7 = r7.f23603a     // Catch:{ all -> 0x0018 }
            J3.b r1 = J3.C2487b.REFUSED_STREAM     // Catch:{ all -> 0x0018 }
            if (r7 != r1) goto L_0x001a
            int r5 = r6.f23364i     // Catch:{ all -> 0x0018 }
            int r5 = r5 + r3
            r6.f23364i = r5     // Catch:{ all -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r7 = move-exception
            goto L_0x0065
        L_0x001a:
            if (r7 != r1) goto L_0x0020
            int r7 = r6.f23364i     // Catch:{ all -> 0x0018 }
            if (r7 <= r3) goto L_0x0046
        L_0x0020:
            r6.f23358c = r2     // Catch:{ all -> 0x0018 }
            goto L_0x0044
        L_0x0023:
            G3.c r1 = r6.f23365j     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.m()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof J3.C2486a     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0046
        L_0x0031:
            G3.c r1 = r6.f23365j     // Catch:{ all -> 0x0018 }
            int r1 = r1.f23339l     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0044
            D3.B r1 = r6.f23358c     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            G3.f r5 = r6.f23363h     // Catch:{ all -> 0x0018 }
            r5.a(r1, r7)     // Catch:{ all -> 0x0018 }
        L_0x0042:
            r6.f23358c = r2     // Catch:{ all -> 0x0018 }
        L_0x0044:
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            G3.c r1 = r6.f23365j     // Catch:{ all -> 0x0018 }
            java.net.Socket r7 = r6.d(r7, r4, r3)     // Catch:{ all -> 0x0018 }
            G3.c r3 = r6.f23365j     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0057
            boolean r3 = r6.f23366k     // Catch:{ all -> 0x0018 }
            if (r3 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r2 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            E3.c.e(r7)
            if (r2 == 0) goto L_0x0064
            D3.o r7 = r6.f23361f
            D3.e r0 = r6.f23360e
            r7.h(r0, r2)
        L_0x0064:
            return
        L_0x0065:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: G3.g.p(java.io.IOException):void");
    }

    public void q(boolean z4, C2484c cVar, long j4, IOException iOException) {
        c cVar2;
        Socket d5;
        boolean z5;
        this.f23361f.p(this.f23360e, j4);
        synchronized (this.f23359d) {
            if (cVar != null) {
                try {
                    if (cVar == this.f23369n) {
                        if (!z4) {
                            this.f23365j.f23339l++;
                        }
                        cVar2 = this.f23365j;
                        d5 = d(z4, false, true);
                        if (this.f23365j != null) {
                            cVar2 = null;
                        }
                        z5 = this.f23367l;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IllegalStateException("expected " + this.f23369n + " but was " + cVar);
        }
        c.e(d5);
        if (cVar2 != null) {
            this.f23361f.h(this.f23360e, cVar2);
        }
        if (iOException != null) {
            this.f23361f.b(this.f23360e, iOException);
        } else if (z5) {
            this.f23361f.a(this.f23360e);
        }
    }

    public String toString() {
        c c5 = c();
        if (c5 != null) {
            return c5.toString();
        }
        return this.f23356a.toString();
    }
}
