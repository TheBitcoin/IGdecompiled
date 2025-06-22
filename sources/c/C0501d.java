package c;

import R2.n;
import R2.s;
import T3.C2585m;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

/* renamed from: c.d  reason: case insensitive filesystem */
public final class C0501d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f1143a;

    public C0501d(d dVar) {
        super(2, dVar);
    }

    public final d create(Object obj, d dVar) {
        return new C0501d(dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new C0501d((d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f1143a;
        if (i4 == 0) {
            n.b(obj);
            C2585m mVar = C2585m.f24018a;
            this.f1143a = 1;
            if (mVar.d(this) == c5) {
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
