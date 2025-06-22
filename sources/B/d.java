package b;

import R2.n;
import R2.s;
import W2.b;
import X3.C2607c;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1098b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(m mVar, V2.d dVar) {
        super(2, dVar);
        this.f1098b = mVar;
    }

    public final V2.d create(Object obj, V2.d dVar) {
        return new d(this.f1098b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new d(this.f1098b, (V2.d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1097a;
        if (i4 == 0) {
            n.b(obj);
            C2607c cVar = this.f1098b.f1118e;
            this.f1097a = 1;
            Object a5 = cVar.a(this);
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
