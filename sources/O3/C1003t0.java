package o3;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;

/* renamed from: o3.t0  reason: case insensitive filesystem */
public final class C1003t0 extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient C1001s0 f3729a;

    public C1003t0(String str, Throwable th, C1001s0 s0Var) {
        super(str);
        this.f3729a = s0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1003t0)) {
            return false;
        }
        C1003t0 t0Var = (C1003t0) obj;
        if (!m.a(t0Var.getMessage(), getMessage()) || !m.a(t0Var.f3729a, this.f3729a) || !m.a(t0Var.getCause(), getCause())) {
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i4;
        String message = getMessage();
        m.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f3729a.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i4 = cause.hashCode();
        } else {
            i4 = 0;
        }
        return hashCode + i4;
    }

    public String toString() {
        return super.toString() + "; job=" + this.f3729a;
    }
}
