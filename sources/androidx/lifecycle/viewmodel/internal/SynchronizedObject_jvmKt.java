package androidx.lifecycle.viewmodel.internal;

import d3.a;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;

public final class SynchronizedObject_jvmKt {
    public static final <T> T synchronizedImpl(SynchronizedObject synchronizedObject, a aVar) {
        T invoke;
        m.e(synchronizedObject, "lock");
        m.e(aVar, "action");
        synchronized (synchronizedObject) {
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
