package d4;

import R2.n;
import R2.s;
import V2.d;
import X3.C2605a;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class b extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24529a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f24530b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, d dVar) {
        super(2, dVar);
        this.f24530b = cVar;
    }

    public final d create(Object obj, d dVar) {
        return new b(this.f24530b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new b(this.f24530b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = W2.b.c();
        int i4 = this.f24529a;
        if (i4 == 0) {
            n.b(obj);
            C2605a aVar = this.f24530b.f24531a;
            this.f24529a = 1;
            Object a5 = aVar.a(this);
            if (a5 == c5) {
                return c5;
            }
            return a5;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
