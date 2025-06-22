package s3;

import R2.n;
import R2.s;
import V2.d;
import V2.e;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.F;
import r3.C1035e;
import r3.C1036f;

public abstract class g extends e {

    /* renamed from: d  reason: collision with root package name */
    protected final C1035e f4351d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4352a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4353b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f4354c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, d dVar) {
            super(2, dVar);
            this.f4354c = gVar;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f4354c, dVar);
            aVar.f4353b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f4352a;
            if (i4 == 0) {
                n.b(obj);
                g gVar = this.f4354c;
                this.f4352a = 1;
                if (gVar.q((C1036f) this.f4353b, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(C1036f fVar, d dVar) {
            return ((a) create(fVar, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public g(C1035e eVar, V2.g gVar, int i4, q3.a aVar) {
        super(gVar, i4, aVar);
        this.f4351d = eVar;
    }

    static /* synthetic */ Object n(g gVar, C1036f fVar, d dVar) {
        if (gVar.f4342b == -3) {
            V2.g context = dVar.getContext();
            V2.g d5 = F.d(context, gVar.f4341a);
            if (m.a(d5, context)) {
                Object q4 = gVar.q(fVar, dVar);
                if (q4 == b.c()) {
                    return q4;
                }
                return s.f8222a;
            }
            e.b bVar = e.f8442a0;
            if (m.a(d5.get(bVar), context.get(bVar))) {
                Object p4 = gVar.p(fVar, d5, dVar);
                if (p4 == b.c()) {
                    return p4;
                }
                return s.f8222a;
            }
        }
        Object collect = super.collect(fVar, dVar);
        if (collect == b.c()) {
            return collect;
        }
        return s.f8222a;
    }

    static /* synthetic */ Object o(g gVar, q3.s sVar, d dVar) {
        Object q4 = gVar.q(new w(sVar), dVar);
        if (q4 == b.c()) {
            return q4;
        }
        return s.f8222a;
    }

    private final Object p(C1036f fVar, V2.g gVar, d dVar) {
        Object c5 = f.c(gVar, f.d(fVar, dVar.getContext()), (Object) null, new a(this, (d) null), dVar, 4, (Object) null);
        if (c5 == b.c()) {
            return c5;
        }
        return s.f8222a;
    }

    public Object collect(C1036f fVar, d dVar) {
        return n(this, fVar, dVar);
    }

    /* access modifiers changed from: protected */
    public Object h(q3.s sVar, d dVar) {
        return o(this, sVar, dVar);
    }

    /* access modifiers changed from: protected */
    public abstract Object q(C1036f fVar, d dVar);

    public String toString() {
        return this.f4351d + " -> " + super.toString();
    }
}
