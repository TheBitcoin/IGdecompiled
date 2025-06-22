package androidx.datastore.core;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class Final<T> extends State<T> {
    private final Throwable finalException;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Final(Throwable th) {
        super(Integer.MAX_VALUE, (C2103g) null);
        m.e(th, "finalException");
        this.finalException = th;
    }

    public final Throwable getFinalException() {
        return this.finalException;
    }
}
