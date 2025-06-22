package s3;

import java.util.concurrent.CancellationException;
import r3.C1036f;

public final class a extends CancellationException {

    /* renamed from: a  reason: collision with root package name */
    public final transient C1036f f4335a;

    public a(C1036f fVar) {
        super("Flow was aborted, no more elements needed");
        this.f4335a = fVar;
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
