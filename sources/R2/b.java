package R2;

import kotlin.jvm.internal.m;

abstract class b {
    public static void a(Throwable th, Throwable th2) {
        m.e(th, "<this>");
        m.e(th2, "exception");
        if (th != th2) {
            Y2.b.f8826a.a(th, th2);
        }
    }
}
