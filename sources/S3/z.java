package s3;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import r3.C1036f;
import t3.J;

final class z implements C1036f {

    /* renamed from: a  reason: collision with root package name */
    private final g f4414a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f4415b;

    /* renamed from: c  reason: collision with root package name */
    private final p f4416c;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4417a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4418b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1036f f4419c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1036f fVar, d dVar) {
            super(2, dVar);
            this.f4419c = fVar;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f4419c, dVar);
            aVar.f4418b = obj;
            return aVar;
        }

        public final Object invoke(Object obj, d dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f4417a;
            if (i4 == 0) {
                n.b(obj);
                Object obj2 = this.f4418b;
                C1036f fVar = this.f4419c;
                this.f4417a = 1;
                if (fVar.emit(obj2, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }
    }

    public z(C1036f fVar, g gVar) {
        this.f4414a = gVar;
        this.f4415b = J.b(gVar);
        this.f4416c = new a(fVar, (d) null);
    }

    public Object emit(Object obj, d dVar) {
        Object b5 = f.b(this.f4414a, obj, this.f4415b, this.f4416c, dVar);
        if (b5 == b.c()) {
            return b5;
        }
        return s.f8222a;
    }
}
