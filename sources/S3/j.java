package s3;

import java.util.concurrent.CancellationException;

public final class j extends CancellationException {
    public j() {
        super("Child of the scoped flow was cancelled");
    }

    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
