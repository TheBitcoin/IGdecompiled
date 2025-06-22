package b;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.m;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class h extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1106b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(m mVar, d dVar) {
        super(2, dVar);
        this.f1106b = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new h(this.f1106b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new h(this.f1106b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1105a;
        if (i4 == 0) {
            n.b(obj);
            m mVar = this.f1106b.f1121h;
            this.f1105a = 1;
            Object a5 = mVar.a(this);
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
