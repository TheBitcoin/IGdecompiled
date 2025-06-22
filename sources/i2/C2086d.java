package i2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import j2.C2092a;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

/* renamed from: i2.d  reason: case insensitive filesystem */
public final class C2086d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2092a f20910a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2086d(C2092a aVar, d dVar) {
        super(2, dVar);
        this.f20910a = aVar;
    }

    public final d create(Object obj, d dVar) {
        return new C2086d(this.f20910a, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new C2086d(this.f20910a, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        n.b(obj);
        this.f20910a.c();
        return s.f8222a;
    }
}
