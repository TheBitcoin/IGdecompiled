package q;

import O2.a;
import s.C1045b;
import w.C1076e;
import x.r;
import x.v;

public final class w implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4030a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4031b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4032c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4033d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4034e;

    public w(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f4030a = aVar;
        this.f4031b = aVar2;
        this.f4032c = aVar3;
        this.f4033d = aVar4;
        this.f4034e = aVar5;
    }

    public static w a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(A.a aVar, A.a aVar2, C1076e eVar, r rVar, v vVar) {
        return new u(aVar, aVar2, eVar, rVar, vVar);
    }

    /* renamed from: b */
    public u get() {
        return c((A.a) this.f4030a.get(), (A.a) this.f4031b.get(), (C1076e) this.f4032c.get(), (r) this.f4033d.get(), (v) this.f4034e.get());
    }
}
