package i2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import j2.C2092a;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

/* renamed from: i2.f  reason: case insensitive filesystem */
public final class C2088f extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2092a f20912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f20913b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2088f(C2092a aVar, String str, d dVar) {
        super(2, dVar);
        this.f20912a = aVar;
        this.f20913b = str;
    }

    public final d create(Object obj, d dVar) {
        return new C2088f(this.f20912a, this.f20913b, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        J j4 = (J) obj;
        return new C2088f(this.f20912a, this.f20913b, (d) obj2).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        n.b(obj);
        this.f20912a.a(this.f20913b);
        return s.f8222a;
    }
}
