package com.google.android.gms.internal.measurement;

final class H4 implements I4 {
    H4() {
    }

    private static C4 c(Object obj, long j4) {
        return (C4) F5.B(obj, j4);
    }

    public final void a(Object obj, long j4) {
        c(obj, j4).B();
    }

    public final void b(Object obj, Object obj2, long j4) {
        C4 c5 = c(obj, j4);
        C4 c6 = c(obj2, j4);
        int size = c5.size();
        int size2 = c6.size();
        if (size > 0 && size2 > 0) {
            if (!c5.b()) {
                c5 = c5.a(size2 + size);
            }
            c5.addAll(c6);
        }
        if (size > 0) {
            c6 = c5;
        }
        F5.j(obj, j4, c6);
    }
}
