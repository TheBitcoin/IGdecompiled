package androidx.datastore.core;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class ReadException<T> extends State<T> {
    private final Throwable readException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadException(Throwable th, int i4) {
        super(i4, (C2103g) null);
        m.e(th, "readException");
        this.readException = th;
    }

    public final Throwable getReadException() {
        return this.readException;
    }
}
