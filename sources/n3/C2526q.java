package N3;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.m;

/* renamed from: N3.q  reason: case insensitive filesystem */
class C2526q implements Z, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f23743a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f23744b;

    public C2526q(InputStream inputStream, a0 a0Var) {
        m.e(inputStream, "input");
        m.e(a0Var, "timeout");
        this.f23743a = inputStream;
        this.f23744b = a0Var;
    }

    public void close() {
        this.f23743a.close();
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 == 0) {
            return 0;
        }
        if (i4 >= 0) {
            try {
                this.f23744b.f();
                U F4 = eVar.F(1);
                int read = this.f23743a.read(F4.f23651a, F4.f23653c, (int) Math.min(j4, (long) (8192 - F4.f23653c)));
                if (read != -1) {
                    F4.f23653c += read;
                    long j5 = (long) read;
                    eVar.z(eVar.A() + j5);
                    return j5;
                } else if (F4.f23652b != F4.f23653c) {
                    return -1;
                } else {
                    eVar.f23694a = F4.b();
                    V.b(F4);
                    return -1;
                }
            } catch (AssertionError e5) {
                if (L.e(e5)) {
                    throw new IOException(e5);
                }
                throw e5;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        }
    }

    public a0 timeout() {
        return this.f23744b;
    }

    public String toString() {
        return "source(" + this.f23743a + ')';
    }
}
