package i2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import j2.C2092a;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

/* renamed from: i2.e  reason: case insensitive filesystem */
public final class C2087e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2092a f20911a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2087e(C2092a aVar, d dVar) {
        super(2, dVar);
        this.f20911a = aVar;
    }

    public final d create(Object obj, d dVar) {
        return new C2087e(this.f20911a, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new C2087e(this.f20911a, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        n.b(obj);
        this.f20911a.b();
        return s.f8222a;
    }
}
