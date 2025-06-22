package b;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.u;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class f extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1101a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1102b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(m mVar, d dVar) {
        super(2, dVar);
        this.f1102b = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new f(this.f1102b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new f(this.f1102b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1101a;
        if (i4 == 0) {
            n.b(obj);
            u uVar = this.f1102b.f1119f;
            this.f1101a = 1;
            Object b5 = uVar.b(this);
            if (b5 == c5) {
                return c5;
            }
            return b5;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
