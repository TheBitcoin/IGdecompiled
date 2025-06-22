package N3;

import R2.s;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: N3.c  reason: case insensitive filesystem */
public class C2512c extends a0 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f23681i = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final ReentrantLock f23682j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Condition f23683k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final long f23684l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final long f23685m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static C2512c f23686n;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f23687f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public C2512c f23688g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f23689h;

    /* renamed from: N3.c$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean d(C2512c cVar) {
            ReentrantLock f4 = C2512c.f23681i.f();
            f4.lock();
            try {
                if (!cVar.f23687f) {
                    return false;
                }
                cVar.f23687f = false;
                for (C2512c j4 = C2512c.f23686n; j4 != null; j4 = j4.f23688g) {
                    if (j4.f23688g == cVar) {
                        j4.f23688g = cVar.f23688g;
                        cVar.f23688g = null;
                        f4.unlock();
                        return false;
                    }
                }
                f4.unlock();
                return true;
            } finally {
                f4.unlock();
            }
        }

        /* access modifiers changed from: private */
        public final void g(C2512c cVar, long j4, boolean z4) {
            ReentrantLock f4 = C2512c.f23681i.f();
            f4.lock();
            try {
                if (!cVar.f23687f) {
                    cVar.f23687f = true;
                    if (C2512c.f23686n == null) {
                        C2512c.f23686n = new C2512c();
                        new b().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
                    if (i4 != 0 && z4) {
                        cVar.f23689h = Math.min(j4, cVar.c() - nanoTime) + nanoTime;
                    } else if (i4 != 0) {
                        cVar.f23689h = j4 + nanoTime;
                    } else if (z4) {
                        cVar.f23689h = cVar.c();
                    } else {
                        throw new AssertionError();
                    }
                    long q4 = cVar.y(nanoTime);
                    C2512c j5 = C2512c.f23686n;
                    m.b(j5);
                    while (true) {
                        if (j5.f23688g == null) {
                            break;
                        }
                        C2512c o4 = j5.f23688g;
                        m.b(o4);
                        if (q4 < o4.y(nanoTime)) {
                            break;
                        }
                        j5 = j5.f23688g;
                        m.b(j5);
                    }
                    cVar.f23688g = j5.f23688g;
                    j5.f23688g = cVar;
                    if (j5 == C2512c.f23686n) {
                        C2512c.f23681i.e().signal();
                    }
                    s sVar = s.f8222a;
                    f4.unlock();
                    return;
                }
                throw new IllegalStateException("Unbalanced enter/exit");
            } catch (Throwable th) {
                f4.unlock();
                throw th;
            }
        }

        public final C2512c c() {
            C2512c j4 = C2512c.f23686n;
            m.b(j4);
            C2512c o4 = j4.f23688g;
            if (o4 == null) {
                long nanoTime = System.nanoTime();
                e().await(C2512c.f23684l, TimeUnit.MILLISECONDS);
                C2512c j5 = C2512c.f23686n;
                m.b(j5);
                if (j5.f23688g != null || System.nanoTime() - nanoTime < C2512c.f23685m) {
                    return null;
                }
                return C2512c.f23686n;
            }
            long q4 = o4.y(System.nanoTime());
            if (q4 > 0) {
                e().await(q4, TimeUnit.NANOSECONDS);
                return null;
            }
            C2512c j6 = C2512c.f23686n;
            m.b(j6);
            j6.f23688g = o4.f23688g;
            o4.f23688g = null;
            return o4;
        }

        public final Condition e() {
            return C2512c.f23683k;
        }

        public final ReentrantLock f() {
            return C2512c.f23682j;
        }

        private a() {
        }
    }

    /* renamed from: N3.c$b */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|(5:5|6|7|19|8)(5:10|11|12|13|(2:15|23)(1:22))|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            r1.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:18:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                N3.c$a r0 = N3.C2512c.f23681i     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.locks.ReentrantLock r1 = r0.f()     // Catch:{ InterruptedException -> 0x0000 }
                r1.lock()     // Catch:{ InterruptedException -> 0x0000 }
                N3.c r0 = r0.c()     // Catch:{ all -> 0x001b }
                N3.c r2 = N3.C2512c.f23686n     // Catch:{ all -> 0x001b }
                if (r0 != r2) goto L_0x001d
                r0 = 0
                N3.C2512c.f23686n = r0     // Catch:{ all -> 0x001b }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x001b:
                r0 = move-exception
                goto L_0x0028
            L_0x001d:
                R2.s r2 = R2.s.f8222a     // Catch:{ all -> 0x001b }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                if (r0 == 0) goto L_0x0000
                r0.B()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0028:
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                throw r0     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: N3.C2512c.b.run():void");
        }
    }

    /* renamed from: N3.c$c  reason: collision with other inner class name */
    public static final class C0285c implements X, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2512c f23690a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ X f23691b;

        C0285c(C2512c cVar, X x4) {
            this.f23690a = cVar;
            this.f23691b = x4;
        }

        /* renamed from: a */
        public C2512c timeout() {
            return this.f23690a;
        }

        public void close() {
            C2512c cVar = this.f23690a;
            X x4 = this.f23691b;
            cVar.v();
            try {
                x4.close();
                s sVar = s.f8222a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public void flush() {
            C2512c cVar = this.f23690a;
            X x4 = this.f23691b;
            cVar.v();
            try {
                x4.flush();
                s sVar = s.f8222a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public void m(C2514e eVar, long j4) {
            m.e(eVar, "source");
            C2511b.b(eVar.A(), 0, j4);
            while (true) {
                long j5 = 0;
                if (j4 > 0) {
                    U u4 = eVar.f23694a;
                    m.b(u4);
                    while (true) {
                        if (j5 >= 65536) {
                            break;
                        }
                        j5 += (long) (u4.f23653c - u4.f23652b);
                        if (j5 >= j4) {
                            j5 = j4;
                            break;
                        } else {
                            u4 = u4.f23656f;
                            m.b(u4);
                        }
                    }
                    C2512c cVar = this.f23690a;
                    X x4 = this.f23691b;
                    cVar.v();
                    try {
                        x4.m(eVar, j5);
                        s sVar = s.f8222a;
                        if (!cVar.w()) {
                            j4 -= j5;
                        } else {
                            throw cVar.p((IOException) null);
                        }
                    } catch (IOException e5) {
                        IOException iOException = e5;
                        if (cVar.w()) {
                            iOException = cVar.p(iOException);
                        }
                        throw iOException;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        cVar.w();
                        throw th2;
                    }
                } else {
                    return;
                }
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f23691b + ')';
        }
    }

    /* renamed from: N3.c$d */
    public static final class d implements Z, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2512c f23692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Z f23693b;

        d(C2512c cVar, Z z4) {
            this.f23692a = cVar;
            this.f23693b = z4;
        }

        /* renamed from: a */
        public C2512c timeout() {
            return this.f23692a;
        }

        public void close() {
            C2512c cVar = this.f23692a;
            Z z4 = this.f23693b;
            cVar.v();
            try {
                z4.close();
                s sVar = s.f8222a;
                if (cVar.w()) {
                    throw cVar.p((IOException) null);
                }
            } catch (IOException e5) {
                e = e5;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public long e(C2514e eVar, long j4) {
            m.e(eVar, "sink");
            C2512c cVar = this.f23692a;
            Z z4 = this.f23693b;
            cVar.v();
            try {
                long e5 = z4.e(eVar, j4);
                if (!cVar.w()) {
                    return e5;
                }
                throw cVar.p((IOException) null);
            } catch (IOException e6) {
                e = e6;
                if (cVar.w()) {
                    e = cVar.p(e);
                }
                throw e;
            } finally {
                cVar.w();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f23693b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f23682j = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        m.d(newCondition, "lock.newCondition()");
        f23683k = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60);
        f23684l = millis;
        f23685m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long y(long j4) {
        return this.f23689h - j4;
    }

    public final Z A(Z z4) {
        m.e(z4, "source");
        return new d(this, z4);
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long h4 = h();
        boolean e5 = e();
        if (h4 != 0 || e5) {
            f23681i.g(this, h4, e5);
        }
    }

    public final boolean w() {
        return f23681i.d(this);
    }

    /* access modifiers changed from: protected */
    public IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final X z(X x4) {
        m.e(x4, "sink");
        return new C0285c(this, x4);
    }

    /* access modifiers changed from: protected */
    public void B() {
    }
}
