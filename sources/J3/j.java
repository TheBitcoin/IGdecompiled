package J3;

import E3.c;
import J3.C2489d;
import N3.C2514e;
import N3.C2515f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j implements Closeable, AutoCloseable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f23586g = Logger.getLogger(C2490e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final C2515f f23587a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23588b;

    /* renamed from: c  reason: collision with root package name */
    private final C2514e f23589c;

    /* renamed from: d  reason: collision with root package name */
    private int f23590d = 16384;

    /* renamed from: e  reason: collision with root package name */
    private boolean f23591e;

    /* renamed from: f  reason: collision with root package name */
    final C2489d.b f23592f;

    j(C2515f fVar, boolean z4) {
        this.f23587a = fVar;
        this.f23588b = z4;
        C2514e eVar = new C2514e();
        this.f23589c = eVar;
        this.f23592f = new C2489d.b(eVar);
    }

    private static void A(C2515f fVar, int i4) {
        fVar.writeByte((i4 >>> 16) & 255);
        fVar.writeByte((i4 >>> 8) & 255);
        fVar.writeByte(i4 & 255);
    }

    private void z(int i4, long j4) {
        byte b5;
        while (j4 > 0) {
            int min = (int) Math.min((long) this.f23590d, j4);
            long j5 = (long) min;
            j4 -= j5;
            if (j4 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            k(i4, min, (byte) 9, b5);
            this.f23587a.m(this.f23589c, j5);
        }
    }

    public synchronized void a(m mVar) {
        try {
            if (!this.f23591e) {
                this.f23590d = mVar.f(this.f23590d);
                if (mVar.c() != -1) {
                    this.f23592f.e(mVar.c());
                }
                k(0, 0, (byte) 4, (byte) 1);
                this.f23587a.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() {
        this.f23591e = true;
        this.f23587a.close();
    }

    public synchronized void d() {
        try {
            if (this.f23591e) {
                throw new IOException("closed");
            } else if (this.f23588b) {
                Logger logger = f23586g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(c.o(">> CONNECTION %s", C2490e.f23468a.m()));
                }
                this.f23587a.write(C2490e.f23468a.L());
                this.f23587a.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        if (!this.f23591e) {
            this.f23587a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void g(boolean z4, int i4, C2514e eVar, int i5) {
        byte b5;
        if (!this.f23591e) {
            if (z4) {
                b5 = (byte) 1;
            } else {
                b5 = 0;
            }
            i(i4, b5, eVar, i5);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void i(int i4, byte b5, C2514e eVar, int i5) {
        k(i4, i5, (byte) 0, b5);
        if (i5 > 0) {
            this.f23587a.m(eVar, (long) i5);
        }
    }

    public void k(int i4, int i5, byte b5, byte b6) {
        Logger logger = f23586g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(C2490e.b(false, i4, i5, b5, b6));
        }
        int i6 = this.f23590d;
        if (i5 > i6) {
            throw C2490e.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
        } else if ((Integer.MIN_VALUE & i4) == 0) {
            A(this.f23587a, i5);
            this.f23587a.writeByte(b5 & 255);
            this.f23587a.writeByte(b6 & 255);
            this.f23587a.writeInt(i4 & Integer.MAX_VALUE);
        } else {
            throw C2490e.c("reserved bit set: %s", Integer.valueOf(i4));
        }
    }

    public synchronized void l(int i4, C2487b bVar, byte[] bArr) {
        try {
            if (this.f23591e) {
                throw new IOException("closed");
            } else if (bVar.f23438a != -1) {
                k(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f23587a.writeInt(i4);
                this.f23587a.writeInt(bVar.f23438a);
                if (bArr.length > 0) {
                    this.f23587a.write(bArr);
                }
                this.f23587a.flush();
            } else {
                throw C2490e.c("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z4, int i4, List list) {
        byte b5;
        if (!this.f23591e) {
            this.f23592f.g(list);
            long A4 = this.f23589c.A();
            int min = (int) Math.min((long) this.f23590d, A4);
            long j4 = (long) min;
            int i5 = (A4 > j4 ? 1 : (A4 == j4 ? 0 : -1));
            if (i5 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            k(i4, min, (byte) 1, b5);
            this.f23587a.m(this.f23589c, j4);
            if (i5 > 0) {
                z(i4, A4 - j4);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int o() {
        return this.f23590d;
    }

    public synchronized void p(boolean z4, int i4, int i5) {
        if (!this.f23591e) {
            k(0, 8, (byte) 6, z4 ? (byte) 1 : 0);
            this.f23587a.writeInt(i4);
            this.f23587a.writeInt(i5);
            this.f23587a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void r(int i4, int i5, List list) {
        byte b5;
        if (!this.f23591e) {
            this.f23592f.g(list);
            long A4 = this.f23589c.A();
            int min = (int) Math.min((long) (this.f23590d - 4), A4);
            long j4 = (long) min;
            int i6 = (A4 > j4 ? 1 : (A4 == j4 ? 0 : -1));
            if (i6 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            k(i4, min + 4, (byte) 5, b5);
            this.f23587a.writeInt(i5 & Integer.MAX_VALUE);
            this.f23587a.m(this.f23589c, j4);
            if (i6 > 0) {
                z(i4, A4 - j4);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void u(int i4, C2487b bVar) {
        if (this.f23591e) {
            throw new IOException("closed");
        } else if (bVar.f23438a != -1) {
            k(i4, 4, (byte) 3, (byte) 0);
            this.f23587a.writeInt(bVar.f23438a);
            this.f23587a.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void v(m mVar) {
        int i4;
        try {
            if (!this.f23591e) {
                k(0, mVar.j() * 6, (byte) 4, (byte) 0);
                for (int i5 = 0; i5 < 10; i5++) {
                    if (mVar.g(i5)) {
                        if (i5 == 4) {
                            i4 = 3;
                        } else if (i5 == 7) {
                            i4 = 4;
                        } else {
                            i4 = i5;
                        }
                        this.f23587a.writeShort(i4);
                        this.f23587a.writeInt(mVar.b(i5));
                    }
                }
                this.f23587a.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public synchronized void w(boolean z4, int i4, int i5, List list) {
        if (!this.f23591e) {
            n(z4, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void x(int i4, long j4) {
        if (this.f23591e) {
            throw new IOException("closed");
        } else if (j4 == 0 || j4 > 2147483647L) {
            throw C2490e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
        } else {
            k(i4, 4, (byte) 8, (byte) 0);
            this.f23587a.writeInt((int) j4);
            this.f23587a.flush();
        }
    }
}
