package r;

/* renamed from: r.g  reason: case insensitive filesystem */
public abstract class C1024g {

    /* renamed from: r.g$a */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static C1024g a() {
        return new C1019b(a.FATAL_ERROR, -1);
    }

    public static C1024g d() {
        return new C1019b(a.INVALID_PAYLOAD, -1);
    }

    public static C1024g e(long j4) {
        return new C1019b(a.OK, j4);
    }

    public static C1024g f() {
        return new C1019b(a.TRANSIENT_ERROR, -1);
    }

    public abstract long b();

    public abstract a c();
}
