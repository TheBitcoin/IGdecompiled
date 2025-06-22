package o3;

import V2.b;
import V2.d;
import V2.e;
import V2.g;
import d3.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import t3.C1060j;
import t3.C1063m;
import t3.C1064n;

public abstract class G extends V2.a implements e {
    public static final a Key = new a((C2103g) null);

    public static final class a extends b {

        /* renamed from: o3.G$a$a  reason: collision with other inner class name */
        static final class C0030a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0030a f3653a = new C0030a();

            C0030a() {
                super(1);
            }

            /* renamed from: a */
            public final G invoke(g.b bVar) {
                if (bVar instanceof G) {
                    return (G) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
            super(e.f8442a0, C0030a.f3653a);
        }
    }

    public G() {
        super(e.f8442a0);
    }

    public abstract void dispatch(g gVar, Runnable runnable);

    public void dispatchYield(g gVar, Runnable runnable) {
        dispatch(gVar, runnable);
    }

    public <E extends g.b> E get(g.c cVar) {
        return e.a.a(this, cVar);
    }

    public final <T> d interceptContinuation(d dVar) {
        return new C1060j(this, dVar);
    }

    public boolean isDispatchNeeded(g gVar) {
        return true;
    }

    public G limitedParallelism(int i4) {
        C1064n.a(i4);
        return new C1063m(this, i4);
    }

    public g minusKey(g.c cVar) {
        return e.a.b(this, cVar);
    }

    public final void releaseInterceptedContinuation(d dVar) {
        m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1060j) dVar).r();
    }

    public String toString() {
        return N.a(this) + '@' + N.b(this);
    }

    public final G plus(G g4) {
        return g4;
    }
}
