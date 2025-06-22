package v3;

import o3.G;
import t3.C1064n;

public final class c extends f {

    /* renamed from: g  reason: collision with root package name */
    public static final c f4562g = new c();

    private c() {
        super(l.f4575c, l.f4576d, l.f4577e, l.f4573a);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public G limitedParallelism(int i4) {
        C1064n.a(i4);
        if (i4 >= l.f4575c) {
            return this;
        }
        return super.limitedParallelism(i4);
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}
