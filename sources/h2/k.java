package H2;

import R2.n;
import R2.s;
import T3.C2578f;
import T3.C2585m;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class k extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f6674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f6675b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(l lVar, d dVar) {
        super(2, dVar);
        this.f6675b = lVar;
    }

    public final d create(Object obj, d dVar) {
        return new k(this.f6675b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new k(this.f6675b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f6674a;
        if (i4 == 0) {
            n.b(obj);
            C2585m mVar = C2585m.f24018a;
            C2578f fVar = C2578f.GDPR;
            int i5 = this.f6675b.f6687l;
            this.f6674a = 1;
            if (mVar.c(fVar, i5, this) == c5) {
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
