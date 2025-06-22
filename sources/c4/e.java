package c4;

import R2.n;
import R2.s;
import T3.C2578f;
import T3.C2579g;
import V2.d;
import W2.b;
import a4.a;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

public final class e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24508a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f24509b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f24510c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, boolean z4, d dVar) {
        super(2, dVar);
        this.f24509b = fVar;
        this.f24510c = z4;
    }

    public final d create(Object obj, d dVar) {
        return new e(this.f24509b, this.f24510c, dVar);
    }

    public Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new e(this.f24509b, this.f24510c, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f24508a;
        if (i4 == 0) {
            n.b(obj);
            C2579g gVar = this.f24509b.f24515e;
            Boolean a5 = kotlin.coroutines.jvm.internal.b.a(this.f24510c);
            String j4 = this.f24509b.f24511a.j(a.PRIVACY_STRING);
            C2578f fVar = C2578f.CCPA;
            this.f24508a = 1;
            if (C2579g.c(gVar, a5, (String) null, (String) null, (String) null, j4, fVar, this, 14) == c5) {
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
