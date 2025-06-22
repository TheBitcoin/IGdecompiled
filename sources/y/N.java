package y;

import O2.a;
import s.C1045b;

public final class N implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4734a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4735b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4736c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4737d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4738e;

    public N(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f4734a = aVar;
        this.f4735b = aVar2;
        this.f4736c = aVar3;
        this.f4737d = aVar4;
        this.f4738e = aVar5;
    }

    public static N a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new N(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static M c(A.a aVar, A.a aVar2, Object obj, Object obj2, a aVar3) {
        return new M(aVar, aVar2, (C1095e) obj, (W) obj2, aVar3);
    }

    /* renamed from: b */
    public M get() {
        return c((A.a) this.f4734a.get(), (A.a) this.f4735b.get(), this.f4736c.get(), this.f4737d.get(), this.f4738e);
    }
}
