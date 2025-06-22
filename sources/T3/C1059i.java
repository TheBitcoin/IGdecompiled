package t3;

import V2.g;

/* renamed from: t3.i  reason: case insensitive filesystem */
public final class C1059i extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient g f4494a;

    public C1059i(g gVar) {
        this.f4494a = gVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public String getLocalizedMessage() {
        return this.f4494a.toString();
    }
}
