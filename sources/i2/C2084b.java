package i2;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import j2.C2092a;
import kotlin.coroutines.jvm.internal.l;
import l2.C2124d;
import m2.C2155a;
import o3.J;

/* renamed from: i2.b  reason: case insensitive filesystem */
public final class C2084b extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f20902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2083a f20903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20904c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C2092a f20905d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2084b(C2083a aVar, String str, C2092a aVar2, d dVar) {
        super(2, dVar);
        this.f20903b = aVar;
        this.f20904c = str;
        this.f20905d = aVar2;
    }

    public final d create(Object obj, d dVar) {
        return new C2084b(this.f20903b, this.f20904c, this.f20905d, dVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C2084b) create((J) obj, (d) obj2)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.f20902a;
        if (i4 == 0) {
            n.b(obj);
            C2124d b5 = new C2155a(this.f20903b.f20901a).b(this.f20904c);
            C2083a aVar = this.f20903b;
            C2092a aVar2 = this.f20905d;
            this.f20902a = 1;
            if (C2083a.b(aVar, b5, aVar2, this) == c5) {
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
