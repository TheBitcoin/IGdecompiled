package J3;

import N3.C2512c;
import N3.C2514e;
import N3.C2516g;
import N3.X;
import N3.Z;
import N3.a0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    long f23563a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f23564b;

    /* renamed from: c  reason: collision with root package name */
    final int f23565c;

    /* renamed from: d  reason: collision with root package name */
    final C2492g f23566d;

    /* renamed from: e  reason: collision with root package name */
    private final List f23567e;

    /* renamed from: f  reason: collision with root package name */
    private List f23568f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23569g;

    /* renamed from: h  reason: collision with root package name */
    private final b f23570h;

    /* renamed from: i  reason: collision with root package name */
    final a f23571i;

    /* renamed from: j  reason: collision with root package name */
    final c f23572j = new c();

    /* renamed from: k  reason: collision with root package name */
    final c f23573k = new c();

    /* renamed from: l  reason: collision with root package name */
    C2487b f23574l = null;

    final class a implements X, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2514e f23575a = new C2514e();

        /* renamed from: b  reason: collision with root package name */
        boolean f23576b;

        /* renamed from: c  reason: collision with root package name */
        boolean f23577c;

        a() {
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r0.f23573k.C();
            r12.f23578d.c();
            r10 = java.lang.Math.min(r12.f23578d.f23564b, r12.f23575a.A());
            r0 = r12.f23578d;
            r0.f23564b -= r10;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(boolean r13) {
            /*
                r12 = this;
                J3.i r1 = J3.i.this
                monitor-enter(r1)
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x007b }
                J3.i$c r0 = r0.f23573k     // Catch:{ all -> 0x007b }
                r0.v()     // Catch:{ all -> 0x007b }
            L_0x000a:
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x0024 }
                long r2 = r0.f23564b     // Catch:{ all -> 0x0024 }
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0027
                boolean r2 = r12.f23577c     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                boolean r2 = r12.f23576b     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                J3.b r2 = r0.f23574l     // Catch:{ all -> 0x0024 }
                if (r2 != 0) goto L_0x0027
                r0.r()     // Catch:{ all -> 0x0024 }
                goto L_0x000a
            L_0x0024:
                r0 = move-exception
                r13 = r0
                goto L_0x007e
            L_0x0027:
                J3.i$c r0 = r0.f23573k     // Catch:{ all -> 0x007b }
                r0.C()     // Catch:{ all -> 0x007b }
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x007b }
                r0.c()     // Catch:{ all -> 0x007b }
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x007b }
                long r2 = r0.f23564b     // Catch:{ all -> 0x007b }
                N3.e r0 = r12.f23575a     // Catch:{ all -> 0x007b }
                long r4 = r0.A()     // Catch:{ all -> 0x007b }
                long r10 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x007b }
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x007b }
                long r2 = r0.f23564b     // Catch:{ all -> 0x007b }
                long r2 = r2 - r10
                r0.f23564b = r2     // Catch:{ all -> 0x007b }
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                J3.i$c r0 = r0.f23573k
                r0.v()
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x0061 }
                J3.g r6 = r0.f23566d     // Catch:{ all -> 0x0061 }
                int r7 = r0.f23565c     // Catch:{ all -> 0x0061 }
                if (r13 == 0) goto L_0x0064
                N3.e r13 = r12.f23575a     // Catch:{ all -> 0x0061 }
                long r0 = r13.A()     // Catch:{ all -> 0x0061 }
                int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0064
                r13 = 1
                r8 = 1
                goto L_0x0066
            L_0x0061:
                r0 = move-exception
                r13 = r0
                goto L_0x0073
            L_0x0064:
                r13 = 0
                r8 = 0
            L_0x0066:
                N3.e r9 = r12.f23575a     // Catch:{ all -> 0x0061 }
                r6.I(r7, r8, r9, r10)     // Catch:{ all -> 0x0061 }
                J3.i r13 = J3.i.this
                J3.i$c r13 = r13.f23573k
                r13.C()
                return
            L_0x0073:
                J3.i r0 = J3.i.this
                J3.i$c r0 = r0.f23573k
                r0.C()
                throw r13
            L_0x007b:
                r0 = move-exception
                r13 = r0
                goto L_0x0086
            L_0x007e:
                J3.i r0 = J3.i.this     // Catch:{ all -> 0x007b }
                J3.i$c r0 = r0.f23573k     // Catch:{ all -> 0x007b }
                r0.C()     // Catch:{ all -> 0x007b }
                throw r13     // Catch:{ all -> 0x007b }
            L_0x0086:
                monitor-exit(r1)     // Catch:{ all -> 0x007b }
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.i.a.a(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
            if (r8.f23578d.f23571i.f23577c != false) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
            if (r8.f23575a.A() <= 0) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            if (r8.f23575a.A() <= 0) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
            r0 = r8.f23578d;
            r0.f23566d.I(r0.f23565c, true, (N3.C2514e) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
            r2 = r8.f23578d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r8.f23576b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
            r8.f23578d.f23566d.flush();
            r8.f23578d.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r8 = this;
                J3.i r1 = J3.i.this
                monitor-enter(r1)
                boolean r0 = r8.f23576b     // Catch:{ all -> 0x0009 }
                if (r0 == 0) goto L_0x000b
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                return
            L_0x0009:
                r0 = move-exception
                goto L_0x0052
            L_0x000b:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                J3.i r0 = J3.i.this
                J3.i$a r0 = r0.f23571i
                boolean r0 = r0.f23577c
                r1 = 1
                if (r0 != 0) goto L_0x003c
                N3.e r0 = r8.f23575a
                long r2 = r0.A()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002f
            L_0x0021:
                N3.e r0 = r8.f23575a
                long r2 = r0.A()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x003c
                r8.a(r1)
                goto L_0x0021
            L_0x002f:
                J3.i r0 = J3.i.this
                J3.g r2 = r0.f23566d
                int r3 = r0.f23565c
                r5 = 0
                r6 = 0
                r4 = 1
                r2.I(r3, r4, r5, r6)
            L_0x003c:
                J3.i r2 = J3.i.this
                monitor-enter(r2)
                r8.f23576b = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                J3.i r0 = J3.i.this
                J3.g r0 = r0.f23566d
                r0.flush()
                J3.i r0 = J3.i.this
                r0.b()
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                monitor-exit(r1)     // Catch:{ all -> 0x0009 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.i.a.close():void");
        }

        public void flush() {
            synchronized (i.this) {
                i.this.c();
            }
            while (this.f23575a.A() > 0) {
                a(false);
                i.this.f23566d.flush();
            }
        }

        public void m(C2514e eVar, long j4) {
            this.f23575a.m(eVar, j4);
            while (this.f23575a.A() >= 16384) {
                a(false);
            }
        }

        public a0 timeout() {
            return i.this.f23573k;
        }
    }

    private final class b implements Z, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2514e f23579a = new C2514e();

        /* renamed from: b  reason: collision with root package name */
        private final C2514e f23580b = new C2514e();

        /* renamed from: c  reason: collision with root package name */
        private final long f23581c;

        /* renamed from: d  reason: collision with root package name */
        boolean f23582d;

        /* renamed from: e  reason: collision with root package name */
        boolean f23583e;

        b(long j4) {
            this.f23581c = j4;
        }

        private void a() {
            if (this.f23582d) {
                throw new IOException("stream closed");
            } else if (i.this.f23574l != null) {
                throw new n(i.this.f23574l);
            }
        }

        private void g() {
            i.this.f23572j.v();
            while (this.f23580b.A() == 0 && !this.f23583e && !this.f23582d) {
                try {
                    i iVar = i.this;
                    if (iVar.f23574l != null) {
                        break;
                    }
                    iVar.r();
                } finally {
                    i.this.f23572j.C();
                }
            }
        }

        public void close() {
            synchronized (i.this) {
                this.f23582d = true;
                this.f23580b.a();
                i.this.notifyAll();
            }
            i.this.b();
        }

        /* access modifiers changed from: package-private */
        public void d(C2516g gVar, long j4) {
            boolean z4;
            boolean z5;
            boolean z6;
            while (j4 > 0) {
                synchronized (i.this) {
                    z4 = this.f23583e;
                    z5 = false;
                    if (this.f23580b.A() + j4 > this.f23581c) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                }
                if (z6) {
                    gVar.skip(j4);
                    i.this.f(C2487b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z4) {
                    gVar.skip(j4);
                    return;
                } else {
                    long e5 = gVar.e(this.f23579a, j4);
                    if (e5 != -1) {
                        j4 -= e5;
                        synchronized (i.this) {
                            try {
                                if (this.f23580b.A() == 0) {
                                    z5 = true;
                                }
                                this.f23580b.J(this.f23579a);
                                if (z5) {
                                    i.this.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
            r10 = r7.f23584f.f23566d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r2 = r7.f23584f.f23566d;
            r3 = r2.f23502l + r8;
            r2.f23502l = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
            if (r3 < ((long) (r2.f23504n.d() / 2))) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
            r2 = r7.f23584f.f23566d;
            r2.M(0, r2.f23502l);
            r7.f23584f.f23566d.f23502l = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
            monitor-exit(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
            return r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
            throw r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long e(N3.C2514e r8, long r9) {
            /*
                r7 = this;
                r0 = 0
                int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x0087
                J3.i r2 = J3.i.this
                monitor-enter(r2)
                r7.g()     // Catch:{ all -> 0x001d }
                r7.a()     // Catch:{ all -> 0x001d }
                N3.e r3 = r7.f23580b     // Catch:{ all -> 0x001d }
                long r3 = r3.A()     // Catch:{ all -> 0x001d }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x001f
                r8 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                return r8
            L_0x001d:
                r8 = move-exception
                goto L_0x0085
            L_0x001f:
                N3.e r3 = r7.f23580b     // Catch:{ all -> 0x001d }
                long r4 = r3.A()     // Catch:{ all -> 0x001d }
                long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x001d }
                long r8 = r3.e(r8, r9)     // Catch:{ all -> 0x001d }
                J3.i r10 = J3.i.this     // Catch:{ all -> 0x001d }
                long r3 = r10.f23563a     // Catch:{ all -> 0x001d }
                long r3 = r3 + r8
                r10.f23563a = r3     // Catch:{ all -> 0x001d }
                J3.g r10 = r10.f23566d     // Catch:{ all -> 0x001d }
                J3.m r10 = r10.f23504n     // Catch:{ all -> 0x001d }
                int r10 = r10.d()     // Catch:{ all -> 0x001d }
                int r10 = r10 / 2
                long r5 = (long) r10     // Catch:{ all -> 0x001d }
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L_0x0052
                J3.i r10 = J3.i.this     // Catch:{ all -> 0x001d }
                J3.g r3 = r10.f23566d     // Catch:{ all -> 0x001d }
                int r4 = r10.f23565c     // Catch:{ all -> 0x001d }
                long r5 = r10.f23563a     // Catch:{ all -> 0x001d }
                r3.M(r4, r5)     // Catch:{ all -> 0x001d }
                J3.i r10 = J3.i.this     // Catch:{ all -> 0x001d }
                r10.f23563a = r0     // Catch:{ all -> 0x001d }
            L_0x0052:
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                J3.i r10 = J3.i.this
                J3.g r10 = r10.f23566d
                monitor-enter(r10)
                J3.i r2 = J3.i.this     // Catch:{ all -> 0x007f }
                J3.g r2 = r2.f23566d     // Catch:{ all -> 0x007f }
                long r3 = r2.f23502l     // Catch:{ all -> 0x007f }
                long r3 = r3 + r8
                r2.f23502l = r3     // Catch:{ all -> 0x007f }
                J3.m r2 = r2.f23504n     // Catch:{ all -> 0x007f }
                int r2 = r2.d()     // Catch:{ all -> 0x007f }
                int r2 = r2 / 2
                long r5 = (long) r2     // Catch:{ all -> 0x007f }
                int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r2 < 0) goto L_0x0081
                J3.i r2 = J3.i.this     // Catch:{ all -> 0x007f }
                J3.g r2 = r2.f23566d     // Catch:{ all -> 0x007f }
                long r3 = r2.f23502l     // Catch:{ all -> 0x007f }
                r5 = 0
                r2.M(r5, r3)     // Catch:{ all -> 0x007f }
                J3.i r2 = J3.i.this     // Catch:{ all -> 0x007f }
                J3.g r2 = r2.f23566d     // Catch:{ all -> 0x007f }
                r2.f23502l = r0     // Catch:{ all -> 0x007f }
                goto L_0x0081
            L_0x007f:
                r8 = move-exception
                goto L_0x0083
            L_0x0081:
                monitor-exit(r10)     // Catch:{ all -> 0x007f }
                return r8
            L_0x0083:
                monitor-exit(r10)     // Catch:{ all -> 0x007f }
                throw r8
            L_0x0085:
                monitor-exit(r2)     // Catch:{ all -> 0x001d }
                throw r8
            L_0x0087:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r8.<init>(r9)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.i.b.e(N3.e, long):long");
        }

        public a0 timeout() {
            return i.this.f23572j;
        }
    }

    class c extends C2512c {
        c() {
        }

        /* access modifiers changed from: protected */
        public void B() {
            i.this.f(C2487b.CANCEL);
        }

        public void C() {
            if (w()) {
                throw x((IOException) null);
            }
        }

        /* access modifiers changed from: protected */
        public IOException x(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    i(int i4, C2492g gVar, boolean z4, boolean z5, List list) {
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.f23565c = i4;
            this.f23566d = gVar;
            this.f23564b = (long) gVar.f23505o.d();
            b bVar = new b((long) gVar.f23504n.d());
            this.f23570h = bVar;
            a aVar = new a();
            this.f23571i = aVar;
            bVar.f23583e = z5;
            aVar.f23577c = z4;
            this.f23567e = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    private boolean e(C2487b bVar) {
        synchronized (this) {
            try {
                if (this.f23574l != null) {
                    return false;
                }
                if (this.f23570h.f23583e && this.f23571i.f23577c) {
                    return false;
                }
                this.f23574l = bVar;
                notifyAll();
                this.f23566d.E(this.f23565c);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j4) {
        this.f23564b += j4;
        if (j4 > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        boolean z4;
        boolean k4;
        synchronized (this) {
            try {
                b bVar = this.f23570h;
                if (!bVar.f23583e && bVar.f23582d) {
                    a aVar = this.f23571i;
                    if (!aVar.f23577c) {
                        if (aVar.f23576b) {
                        }
                    }
                    z4 = true;
                    k4 = k();
                }
                z4 = false;
                k4 = k();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z4) {
            d(C2487b.CANCEL);
        } else if (!k4) {
            this.f23566d.E(this.f23565c);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a aVar = this.f23571i;
        if (aVar.f23576b) {
            throw new IOException("stream closed");
        } else if (aVar.f23577c) {
            throw new IOException("stream finished");
        } else if (this.f23574l != null) {
            throw new n(this.f23574l);
        }
    }

    public void d(C2487b bVar) {
        if (e(bVar)) {
            this.f23566d.K(this.f23565c, bVar);
        }
    }

    public void f(C2487b bVar) {
        if (e(bVar)) {
            this.f23566d.L(this.f23565c, bVar);
        }
    }

    public int g() {
        return this.f23565c;
    }

    public X h() {
        synchronized (this) {
            try {
                if (!this.f23569g) {
                    if (!j()) {
                        throw new IllegalStateException("reply before requesting the sink");
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return this.f23571i;
    }

    public Z i() {
        return this.f23570h;
    }

    public boolean j() {
        boolean z4;
        if ((this.f23565c & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f23566d.f23491a == z4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0026, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean k() {
        /*
            r3 = this;
            monitor-enter(r3)
            J3.b r0 = r3.f23574l     // Catch:{ all -> 0x0013 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            J3.i$b r0 = r3.f23570h     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f23583e     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x0015
            boolean r0 = r0.f23582d     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0028
        L_0x0015:
            J3.i$a r0 = r3.f23571i     // Catch:{ all -> 0x0013 }
            boolean r2 = r0.f23577c     // Catch:{ all -> 0x0013 }
            if (r2 != 0) goto L_0x001f
            boolean r0 = r0.f23576b     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
        L_0x001f:
            boolean r0 = r3.f23569g     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0025
            monitor-exit(r3)
            return r1
        L_0x0025:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0013 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J3.i.k():boolean");
    }

    public a0 l() {
        return this.f23572j;
    }

    /* access modifiers changed from: package-private */
    public void m(C2516g gVar, int i4) {
        this.f23570h.d(gVar, (long) i4);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        boolean k4;
        synchronized (this) {
            this.f23570h.f23583e = true;
            k4 = k();
            notifyAll();
        }
        if (!k4) {
            this.f23566d.E(this.f23565c);
        }
    }

    /* access modifiers changed from: package-private */
    public void o(List list) {
        boolean z4;
        synchronized (this) {
            z4 = true;
            try {
                this.f23569g = true;
                if (this.f23568f == null) {
                    this.f23568f = list;
                    z4 = k();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.f23568f);
                    arrayList.add((Object) null);
                    arrayList.addAll(list);
                    this.f23568f = arrayList;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z4) {
            this.f23566d.E(this.f23565c);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void p(C2487b bVar) {
        if (this.f23574l == null) {
            this.f23574l = bVar;
            notifyAll();
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized List q() {
        List list;
        if (j()) {
            this.f23572j.v();
            while (this.f23568f == null && this.f23574l == null) {
                try {
                    r();
                } catch (Throwable th) {
                    this.f23572j.C();
                    throw th;
                }
            }
            this.f23572j.C();
            list = this.f23568f;
            if (list != null) {
                this.f23568f = null;
            } else {
                throw new n(this.f23574l);
            }
        } else {
            throw new IllegalStateException("servers cannot read response headers");
        }
        return list;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public a0 s() {
        return this.f23573k;
    }
}
