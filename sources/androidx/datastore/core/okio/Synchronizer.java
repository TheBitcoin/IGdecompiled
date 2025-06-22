package androidx.datastore.core.okio;

import d3.a;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

public final class Synchronizer {
    public final <T> T withLock(a aVar) {
        T invoke;
        m.e(aVar, "block");
        synchronized (this) {
            try {
                invoke = aVar.invoke();
                l.b(1);
            } catch (Throwable th) {
                l.b(1);
                l.a(1);
                throw th;
            }
        }
        l.a(1);
        return invoke;
    }
}
