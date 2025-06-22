package N3;

import kotlin.jvm.internal.m;

/* renamed from: N3.m  reason: case insensitive filesystem */
public abstract class C2522m implements Z, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    private final Z f23732a;

    public C2522m(Z z4) {
        m.e(z4, "delegate");
        this.f23732a = z4;
    }

    public final Z a() {
        return this.f23732a;
    }

    public void close() {
        this.f23732a.close();
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        return this.f23732a.e(eVar, j4);
    }

    public a0 timeout() {
        return this.f23732a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f23732a + ')';
    }
}
