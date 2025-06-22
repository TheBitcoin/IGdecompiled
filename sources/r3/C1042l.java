package r3;

import d3.l;
import d3.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

/* renamed from: r3.l  reason: case insensitive filesystem */
abstract /* synthetic */ class C1042l {

    /* renamed from: a  reason: collision with root package name */
    private static final l f4208a = b.f4211a;

    /* renamed from: b  reason: collision with root package name */
    private static final p f4209b = a.f4210a;

    /* renamed from: r3.l$a */
    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4210a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(m.a(obj, obj2));
        }
    }

    public static final C1035e a(C1035e eVar) {
        if (eVar instanceof I) {
            return eVar;
        }
        return b(eVar, f4208a, f4209b);
    }

    private static final C1035e b(C1035e eVar, l lVar, p pVar) {
        if (eVar instanceof C1034d) {
            C1034d dVar = (C1034d) eVar;
            if (dVar.f4193b == lVar && dVar.f4194c == pVar) {
                return eVar;
            }
        }
        return new C1034d(eVar, lVar, pVar);
    }

    /* renamed from: r3.l$b */
    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f4211a = new b();

        b() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
