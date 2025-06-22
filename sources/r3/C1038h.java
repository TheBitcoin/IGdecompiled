package r3;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import d3.p;
import kotlin.jvm.internal.C2103g;

/* renamed from: r3.h  reason: case insensitive filesystem */
abstract /* synthetic */ class C1038h {

    /* renamed from: r3.h$a */
    public static final class a implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f4201a;

        public a(Object obj) {
            this.f4201a = obj;
        }

        public Object collect(C1036f fVar, d dVar) {
            Object emit = fVar.emit(this.f4201a, dVar);
            if (emit == b.c()) {
                return emit;
            }
            return s.f8222a;
        }
    }

    public static final C1035e a(p pVar) {
        return new C1032b(pVar, (g) null, 0, (q3.a) null, 14, (C2103g) null);
    }

    public static final C1035e b(p pVar) {
        return new C1033c(pVar, (g) null, 0, (q3.a) null, 14, (C2103g) null);
    }

    public static final C1035e c(p pVar) {
        return new w(pVar);
    }

    public static final C1035e d(Object obj) {
        return new a(obj);
    }
}
