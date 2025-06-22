package q3;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import d3.p;
import o3.J;
import q3.h;

abstract /* synthetic */ class l {

    static final class a extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4097a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4098b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v f4099c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Object f4100d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(v vVar, Object obj, d dVar) {
            super(2, dVar);
            this.f4099c = vVar;
            this.f4100d = obj;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f4099c, this.f4100d, dVar);
            aVar.f4098b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object obj3;
            Object c5 = b.c();
            int i4 = this.f4097a;
            if (i4 == 0) {
                n.b(obj);
                J j4 = (J) this.f4098b;
                v vVar = this.f4099c;
                Object obj4 = this.f4100d;
                m.a aVar = m.f8216a;
                this.f4097a = 1;
                if (vVar.t(obj4, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                try {
                    n.b(obj);
                } catch (Throwable th) {
                    m.a aVar2 = m.f8216a;
                    obj2 = m.a(n.a(th));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = m.a(s.f8222a);
            if (m.d(obj2)) {
                obj3 = h.f4091b.c(s.f8222a);
            } else {
                obj3 = h.f4091b.a(m.b(obj2));
            }
            return h.b(obj3);
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final Object a(v vVar, Object obj) {
        Object B4 = vVar.B(obj);
        if (B4 instanceof h.c) {
            return ((h) C0979h.b((g) null, new a(vVar, obj, (d) null), 1, (Object) null)).k();
        }
        s sVar = (s) B4;
        return h.f4091b.c(s.f8222a);
    }
}
