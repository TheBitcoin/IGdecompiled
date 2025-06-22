package N3;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.m;

/* renamed from: N3.p  reason: case insensitive filesystem */
public final class C2525p implements Z, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final C2516g f23739a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f23740b;

    /* renamed from: c  reason: collision with root package name */
    private int f23741c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23742d;

    public C2525p(C2516g gVar, Inflater inflater) {
        m.e(gVar, "source");
        m.e(inflater, "inflater");
        this.f23739a = gVar;
        this.f23740b = inflater;
    }

    private final void g() {
        int i4 = this.f23741c;
        if (i4 != 0) {
            int remaining = i4 - this.f23740b.getRemaining();
            this.f23741c -= remaining;
            this.f23739a.skip((long) remaining);
        }
    }

    public final long a(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (this.f23742d) {
            throw new IllegalStateException("closed");
        } else if (i4 == 0) {
            return 0;
        } else {
            try {
                U F4 = eVar.F(1);
                int min = (int) Math.min(j4, (long) (8192 - F4.f23653c));
                d();
                int inflate = this.f23740b.inflate(F4.f23651a, F4.f23653c, min);
                g();
                if (inflate > 0) {
                    F4.f23653c += inflate;
                    long j5 = (long) inflate;
                    eVar.z(eVar.A() + j5);
                    return j5;
                }
                if (F4.f23652b == F4.f23653c) {
                    eVar.f23694a = F4.b();
                    V.b(F4);
                }
                return 0;
            } catch (DataFormatException e5) {
                throw new IOException(e5);
            }
        }
    }

    public void close() {
        if (!this.f23742d) {
            this.f23740b.end();
            this.f23742d = true;
            this.f23739a.close();
        }
    }

    public final boolean d() {
        if (!this.f23740b.needsInput()) {
            return false;
        }
        if (this.f23739a.exhausted()) {
            return true;
        }
        U u4 = this.f23739a.h().f23694a;
        m.b(u4);
        int i4 = u4.f23653c;
        int i5 = u4.f23652b;
        int i6 = i4 - i5;
        this.f23741c = i6;
        this.f23740b.setInput(u4.f23651a, i5, i6);
        return false;
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        do {
            long a5 = a(eVar, j4);
            if (a5 > 0) {
                return a5;
            }
            if (this.f23740b.finished() || this.f23740b.needsDictionary()) {
                return -1;
            }
        } while (!this.f23739a.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public a0 timeout() {
        return this.f23739a.timeout();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2525p(Z z4, Inflater inflater) {
        this(L.d(z4), inflater);
        m.e(z4, "source");
        m.e(inflater, "inflater");
    }
}
