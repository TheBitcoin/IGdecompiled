package b;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.w;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class k extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1112a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1113b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(m mVar, d dVar) {
        super(2, dVar);
        this.f1113b = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new k(this.f1113b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new k(this.f1113b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1112a;
        if (i4 == 0) {
            n.b(obj);
            w wVar = this.f1113b.f1120g;
            this.f1112a = 1;
            Object a5 = wVar.a(this);
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
