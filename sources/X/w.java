package x;

import O2.a;
import java.util.concurrent.Executor;
import s.C1045b;
import y.C1094d;
import z.C1115b;

public final class w implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4678a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4679b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4680c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4681d;

    public w(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f4678a = aVar;
        this.f4679b = aVar2;
        this.f4680c = aVar3;
        this.f4681d = aVar4;
    }

    public static w a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, C1094d dVar, x xVar, C1115b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    /* renamed from: b */
    public v get() {
        return c((Executor) this.f4678a.get(), (C1094d) this.f4679b.get(), (x) this.f4680c.get(), (C1115b) this.f4681d.get());
    }
}
