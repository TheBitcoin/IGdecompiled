package N3;

import R2.s;
import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.m;

/* renamed from: N3.i  reason: case insensitive filesystem */
public abstract class C2518i implements Closeable, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23709a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f23710b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f23711c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f23712d = c0.b();

    /* renamed from: N3.i$a */
    private static final class a implements X, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2518i f23713a;

        /* renamed from: b  reason: collision with root package name */
        private long f23714b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23715c;

        public a(C2518i iVar, long j4) {
            m.e(iVar, "fileHandle");
            this.f23713a = iVar;
            this.f23714b = j4;
        }

        public void close() {
            if (!this.f23715c) {
                this.f23715c = true;
                ReentrantLock l4 = this.f23713a.l();
                l4.lock();
                try {
                    C2518i iVar = this.f23713a;
                    iVar.f23711c = iVar.f23711c - 1;
                    if (this.f23713a.f23711c == 0) {
                        if (this.f23713a.f23710b) {
                            s sVar = s.f8222a;
                            l4.unlock();
                            this.f23713a.n();
                        }
                    }
                } finally {
                    l4.unlock();
                }
            }
        }

        public void flush() {
            if (!this.f23715c) {
                this.f23713a.o();
                return;
            }
            throw new IllegalStateException("closed");
        }

        public void m(C2514e eVar, long j4) {
            m.e(eVar, "source");
            if (!this.f23715c) {
                long j5 = j4;
                this.f23713a.D(this.f23714b, eVar, j5);
                this.f23714b += j5;
                return;
            }
            throw new IllegalStateException("closed");
        }

        public a0 timeout() {
            return a0.f23669e;
        }
    }

    /* renamed from: N3.i$b */
    private static final class b implements Z, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2518i f23716a;

        /* renamed from: b  reason: collision with root package name */
        private long f23717b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f23718c;

        public b(C2518i iVar, long j4) {
            m.e(iVar, "fileHandle");
            this.f23716a = iVar;
            this.f23717b = j4;
        }

        public void close() {
            if (!this.f23718c) {
                this.f23718c = true;
                ReentrantLock l4 = this.f23716a.l();
                l4.lock();
                try {
                    C2518i iVar = this.f23716a;
                    iVar.f23711c = iVar.f23711c - 1;
                    if (this.f23716a.f23711c == 0) {
                        if (this.f23716a.f23710b) {
                            s sVar = s.f8222a;
                            l4.unlock();
                            this.f23716a.n();
                        }
                    }
                } finally {
                    l4.unlock();
                }
            }
        }

        public long e(C2514e eVar, long j4) {
            m.e(eVar, "sink");
            if (!this.f23718c) {
                long g4 = this.f23716a.v(this.f23717b, eVar, j4);
                if (g4 != -1) {
                    this.f23717b += g4;
                }
                return g4;
            }
            throw new IllegalStateException("closed");
        }

        public a0 timeout() {
            return a0.f23669e;
        }
    }

    public C2518i(boolean z4) {
        this.f23709a = z4;
    }

    /* access modifiers changed from: private */
    public final void D(long j4, C2514e eVar, long j5) {
        long j6 = j5;
        C2511b.b(eVar.A(), 0, j6);
        long j7 = j4 + j6;
        long j8 = j4;
        while (j8 < j7) {
            U u4 = eVar.f23694a;
            m.b(u4);
            int min = (int) Math.min(j7 - j8, (long) (u4.f23653c - u4.f23652b));
            u(j8, u4.f23651a, u4.f23652b, min);
            u4.f23652b += min;
            long j9 = (long) min;
            j8 += j9;
            eVar.z(eVar.A() - j9);
            if (u4.f23652b == u4.f23653c) {
                eVar.f23694a = u4.b();
                V.b(u4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final long v(long j4, C2514e eVar, long j5) {
        C2514e eVar2 = eVar;
        long j6 = j5;
        if (j6 >= 0) {
            long j7 = j6 + j4;
            long j8 = j4;
            while (true) {
                if (j8 >= j7) {
                    break;
                }
                U F4 = eVar2.F(1);
                byte[] bArr = F4.f23651a;
                int i4 = F4.f23653c;
                int p4 = p(j8, bArr, i4, (int) Math.min(j7 - j8, (long) (8192 - i4)));
                if (p4 == -1) {
                    if (F4.f23652b == F4.f23653c) {
                        eVar2.f23694a = F4.b();
                        V.b(F4);
                    }
                    if (j4 == j8) {
                        return -1;
                    }
                } else {
                    F4.f23653c += p4;
                    long j9 = (long) p4;
                    j8 += j9;
                    eVar2.z(eVar2.A() + j9);
                }
            }
            return j8 - j4;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j6).toString());
    }

    public static /* synthetic */ X x(C2518i iVar, long j4, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                j4 = 0;
            }
            return iVar.w(j4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
    }

    /* JADX INFO: finally extract failed */
    public final Z A(long j4) {
        ReentrantLock reentrantLock = this.f23712d;
        reentrantLock.lock();
        try {
            if (!this.f23710b) {
                this.f23711c++;
                reentrantLock.unlock();
                return new b(this, j4);
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void close() {
        ReentrantLock reentrantLock = this.f23712d;
        reentrantLock.lock();
        try {
            if (!this.f23710b) {
                this.f23710b = true;
                if (this.f23711c != 0) {
                    reentrantLock.unlock();
                    return;
                }
                s sVar = s.f8222a;
                reentrantLock.unlock();
                n();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public final void flush() {
        if (this.f23709a) {
            ReentrantLock reentrantLock = this.f23712d;
            reentrantLock.lock();
            try {
                if (!this.f23710b) {
                    s sVar = s.f8222a;
                    reentrantLock.unlock();
                    o();
                    return;
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("file handle is read-only");
        }
    }

    public final ReentrantLock l() {
        return this.f23712d;
    }

    /* access modifiers changed from: protected */
    public abstract void n();

    /* access modifiers changed from: protected */
    public abstract void o();

    /* access modifiers changed from: protected */
    public abstract int p(long j4, byte[] bArr, int i4, int i5);

    /* access modifiers changed from: protected */
    public abstract long r();

    /* access modifiers changed from: protected */
    public abstract void u(long j4, byte[] bArr, int i4, int i5);

    /* JADX INFO: finally extract failed */
    public final X w(long j4) {
        if (this.f23709a) {
            ReentrantLock reentrantLock = this.f23712d;
            reentrantLock.lock();
            try {
                if (!this.f23710b) {
                    this.f23711c++;
                    reentrantLock.unlock();
                    return new a(this, j4);
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("file handle is read-only");
        }
    }

    /* JADX INFO: finally extract failed */
    public final long z() {
        ReentrantLock reentrantLock = this.f23712d;
        reentrantLock.lock();
        try {
            if (!this.f23710b) {
                s sVar = s.f8222a;
                reentrantLock.unlock();
                return r();
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
