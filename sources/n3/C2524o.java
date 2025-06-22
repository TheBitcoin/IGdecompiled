package N3;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.m;

/* renamed from: N3.o  reason: case insensitive filesystem */
public final class C2524o implements Z, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private byte f23734a;

    /* renamed from: b  reason: collision with root package name */
    private final T f23735b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f23736c;

    /* renamed from: d  reason: collision with root package name */
    private final C2525p f23737d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f23738e = new CRC32();

    public C2524o(Z z4) {
        m.e(z4, "source");
        T t4 = new T(z4);
        this.f23735b = t4;
        Inflater inflater = new Inflater(true);
        this.f23736c = inflater;
        this.f23737d = new C2525p((C2516g) t4, inflater);
    }

    private final void a(String str, int i4, int i5) {
        if (i5 != i4) {
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i5), Integer.valueOf(i4)}, 3));
            m.d(format, "format(this, *args)");
            throw new IOException(format);
        }
    }

    private final void d() {
        boolean z4;
        this.f23735b.require(10);
        byte n4 = this.f23735b.f23647b.n(3);
        if (((n4 >> 1) & 1) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i(this.f23735b.f23647b, 0, 10);
        }
        a("ID1ID2", 8075, this.f23735b.readShort());
        this.f23735b.skip(8);
        if (((n4 >> 2) & 1) == 1) {
            this.f23735b.require(2);
            if (z4) {
                i(this.f23735b.f23647b, 0, 2);
            }
            long readShortLe = (long) (this.f23735b.f23647b.readShortLe() & 65535);
            this.f23735b.require(readShortLe);
            if (z4) {
                i(this.f23735b.f23647b, 0, readShortLe);
            }
            this.f23735b.skip(readShortLe);
        }
        if (((n4 >> 3) & 1) == 1) {
            long indexOf = this.f23735b.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z4) {
                    i(this.f23735b.f23647b, 0, indexOf + 1);
                }
                this.f23735b.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((n4 >> 4) & 1) == 1) {
            long indexOf2 = this.f23735b.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z4) {
                    i(this.f23735b.f23647b, 0, indexOf2 + 1);
                }
                this.f23735b.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z4) {
            a("FHCRC", this.f23735b.readShortLe(), (short) ((int) this.f23738e.getValue()));
            this.f23738e.reset();
        }
    }

    private final void g() {
        a("CRC", this.f23735b.readIntLe(), (int) this.f23738e.getValue());
        a("ISIZE", this.f23735b.readIntLe(), (int) this.f23736c.getBytesWritten());
    }

    private final void i(C2514e eVar, long j4, long j5) {
        U u4 = eVar.f23694a;
        m.b(u4);
        while (true) {
            int i4 = u4.f23653c;
            int i5 = u4.f23652b;
            if (j4 < ((long) (i4 - i5))) {
                break;
            }
            j4 -= (long) (i4 - i5);
            u4 = u4.f23656f;
            m.b(u4);
        }
        while (j5 > 0) {
            int i6 = (int) (((long) u4.f23652b) + j4);
            int min = (int) Math.min((long) (u4.f23653c - i6), j5);
            this.f23738e.update(u4.f23651a, i6, min);
            j5 -= (long) min;
            u4 = u4.f23656f;
            m.b(u4);
            j4 = 0;
        }
    }

    public void close() {
        this.f23737d.close();
    }

    public long e(C2514e eVar, long j4) {
        C2524o oVar;
        m.e(eVar, "sink");
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (i4 == 0) {
            return 0;
        } else {
            if (this.f23734a == 0) {
                d();
                this.f23734a = 1;
            }
            if (this.f23734a == 1) {
                long A4 = eVar.A();
                long e5 = this.f23737d.e(eVar, j4);
                if (e5 != -1) {
                    i(eVar, A4, e5);
                    return e5;
                }
                oVar = this;
                oVar.f23734a = 2;
            } else {
                oVar = this;
            }
            if (oVar.f23734a == 2) {
                g();
                oVar.f23734a = 3;
                if (!oVar.f23735b.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public a0 timeout() {
        return this.f23735b.timeout();
    }
}
