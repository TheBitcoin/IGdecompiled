package androidx.datastore.core;

import R2.a;
import d3.l;
import kotlin.jvm.internal.m;

public final class CloseableKt {
    public static final <T extends Closeable, R> R use(T t4, l lVar) {
        m.e(t4, "<this>");
        m.e(lVar, "block");
        try {
            R invoke = lVar.invoke(t4);
            kotlin.jvm.internal.l.b(1);
            try {
                t4.close();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                kotlin.jvm.internal.l.a(1);
                return invoke;
            }
            throw th;
        } catch (Throwable th2) {
            a.a(th, th2);
        }
        throw th;
    }
}
