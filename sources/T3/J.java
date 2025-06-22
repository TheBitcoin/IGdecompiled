package t3;

import V2.g;
import d3.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.Q0;

public abstract class J {

    /* renamed from: a  reason: collision with root package name */
    public static final F f4469a = new F("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final p f4470b = a.f4473a;

    /* renamed from: c  reason: collision with root package name */
    private static final p f4471c = b.f4474a;

    /* renamed from: d  reason: collision with root package name */
    private static final p f4472d = c.f4475a;

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4473a = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Object invoke(Object obj, g.b bVar) {
            Integer num;
            int i4;
            if (!(bVar instanceof Q0)) {
                return obj;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i4 = num.intValue();
            } else {
                i4 = 1;
            }
            if (i4 == 0) {
                return bVar;
            }
            return Integer.valueOf(i4 + 1);
        }
    }

    static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f4474a = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final Q0 invoke(Q0 q02, g.b bVar) {
            if (q02 != null) {
                return q02;
            }
            if (bVar instanceof Q0) {
                return (Q0) bVar;
            }
            return null;
        }
    }

    static final class c extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f4475a = new c();

        c() {
            super(2);
        }

        /* renamed from: a */
        public final P invoke(P p4, g.b bVar) {
            if (bVar instanceof Q0) {
                Q0 q02 = (Q0) bVar;
                p4.a(q02, q02.o(p4.f4482a));
            }
            return p4;
        }
    }

    public static final void a(g gVar, Object obj) {
        if (obj != f4469a) {
            if (obj instanceof P) {
                ((P) obj).b(gVar);
                return;
            }
            Object fold = gVar.fold((Object) null, f4471c);
            m.c(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((Q0) fold).x(gVar, obj);
        }
    }

    public static final Object b(g gVar) {
        Object fold = gVar.fold(0, f4470b);
        m.b(fold);
        return fold;
    }

    public static final Object c(g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f4469a;
        }
        if (obj instanceof Integer) {
            return gVar.fold(new P(gVar, ((Number) obj).intValue()), f4472d);
        }
        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((Q0) obj).o(gVar);
    }
}
