package J2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import X3.u;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class k extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public Object f7263a;

    /* renamed from: b  reason: collision with root package name */
    public int f7264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d3.l f7265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f7266d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(d3.l lVar, l lVar2, d dVar) {
        super(2, dVar);
        this.f7265c = lVar;
        this.f7266d = lVar2;
    }

    public final d create(Object obj, d dVar) {
        return new k(this.f7265c, this.f7266d, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new k(this.f7265c, this.f7266d, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        d3.l lVar;
        Object c5 = b.c();
        int i4 = this.f7264b;
        if (i4 == 0) {
            n.b(obj);
            d3.l lVar2 = this.f7265c;
            u uVar = this.f7266d.f7271e;
            this.f7263a = lVar2;
            this.f7264b = 1;
            Object a5 = uVar.a(this);
            if (a5 == c5) {
                return c5;
            }
            lVar = lVar2;
            obj = a5;
        } else if (i4 == 1) {
            lVar = (d3.l) this.f7263a;
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lVar.invoke(obj);
        return s.f8222a;
    }
}
