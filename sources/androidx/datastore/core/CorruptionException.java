package androidx.datastore.core;

import java.io.IOException;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class CorruptionException extends IOException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CorruptionException(String str, Throwable th, int i4, C2103g gVar) {
        this(str, (i4 & 2) != 0 ? null : th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CorruptionException(String str, Throwable th) {
        super(str, th);
        m.e(str, "message");
    }
}
