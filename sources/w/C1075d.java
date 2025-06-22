package w;

import O2.a;
import java.util.concurrent.Executor;
import r.C1022e;
import s.C1045b;
import x.x;
import y.C1094d;
import z.C1115b;

/* renamed from: w.d  reason: case insensitive filesystem */
public final class C1075d implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4600a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4601b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4602c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4603d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4604e;

    public C1075d(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f4600a = aVar;
        this.f4601b = aVar2;
        this.f4602c = aVar3;
        this.f4603d = aVar4;
        this.f4604e = aVar5;
    }

    public static C1075d a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new C1075d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static C1074c c(Executor executor, C1022e eVar, x xVar, C1094d dVar, C1115b bVar) {
        return new C1074c(executor, eVar, xVar, dVar, bVar);
    }

    /* renamed from: b */
    public C1074c get() {
        return c((Executor) this.f4600a.get(), (C1022e) this.f4601b.get(), (x) this.f4602c.get(), (C1094d) this.f4603d.get(), (C1115b) this.f4604e.get());
    }
}
