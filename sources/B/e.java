package b;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.q;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1099a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f1100b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(m mVar, d dVar) {
        super(2, dVar);
        this.f1100b = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new e(this.f1100b, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new e(this.f1100b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1099a;
        if (i4 == 0) {
            n.b(obj);
            m mVar = this.f1100b;
            q qVar = mVar.f1117d;
            int i5 = mVar.f1116c.f170b.f115G;
            this.f1099a = 1;
            Object a5 = qVar.a(i5, this);
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
