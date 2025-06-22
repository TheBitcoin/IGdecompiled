package b;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.o;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class i extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1107a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1108b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(m mVar, d dVar) {
        super(2, dVar);
        this.f1108b = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new i(this.f1108b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new i(this.f1108b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1107a;
        if (i4 == 0) {
            n.b(obj);
            o oVar = this.f1108b.f1122i;
            this.f1107a = 1;
            Object a5 = oVar.a(this);
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
