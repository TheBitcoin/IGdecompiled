package N3;

import java.io.OutputStream;
import kotlin.jvm.internal.m;

final class O implements X, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f23637a;

    /* renamed from: b  reason: collision with root package name */
    private final a0 f23638b;

    public O(OutputStream outputStream, a0 a0Var) {
        m.e(outputStream, "out");
        m.e(a0Var, "timeout");
        this.f23637a = outputStream;
        this.f23638b = a0Var;
    }

    public void close() {
        this.f23637a.close();
    }

    public void flush() {
        this.f23637a.flush();
    }

    public void m(C2514e eVar, long j4) {
        m.e(eVar, "source");
        C2511b.b(eVar.A(), 0, j4);
        while (j4 > 0) {
            this.f23638b.f();
            U u4 = eVar.f23694a;
            m.b(u4);
            int min = (int) Math.min(j4, (long) (u4.f23653c - u4.f23652b));
            this.f23637a.write(u4.f23651a, u4.f23652b, min);
            u4.f23652b += min;
            long j5 = (long) min;
            j4 -= j5;
            eVar.z(eVar.A() - j5);
            if (u4.f23652b == u4.f23653c) {
                eVar.f23694a = u4.b();
                V.b(u4);
            }
        }
    }

    public a0 timeout() {
        return this.f23638b;
    }

    public String toString() {
        return "sink(" + this.f23637a + ')';
    }
}
