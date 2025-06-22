package N3;

import kotlin.jvm.internal.m;

/* renamed from: N3.l  reason: case insensitive filesystem */
public abstract class C2521l implements X, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final X f23731a;

    public C2521l(X x4) {
        m.e(x4, "delegate");
        this.f23731a = x4;
    }

    public void close() {
        this.f23731a.close();
    }

    public void flush() {
        this.f23731a.flush();
    }

    public void m(C2514e eVar, long j4) {
        m.e(eVar, "source");
        this.f23731a.m(eVar, j4);
    }

    public a0 timeout() {
        return this.f23731a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f23731a + ')';
    }
}
