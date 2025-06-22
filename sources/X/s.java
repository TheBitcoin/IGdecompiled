package x;

import O2.a;
import android.content.Context;
import java.util.concurrent.Executor;
import r.C1022e;
import s.C1045b;
import y.C1093c;
import y.C1094d;
import z.C1115b;

public final class s implements C1045b {

    /* renamed from: a  reason: collision with root package name */
    private final a f4663a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4664b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4665c;

    /* renamed from: d  reason: collision with root package name */
    private final a f4666d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4667e;

    /* renamed from: f  reason: collision with root package name */
    private final a f4668f;

    /* renamed from: g  reason: collision with root package name */
    private final a f4669g;

    /* renamed from: h  reason: collision with root package name */
    private final a f4670h;

    /* renamed from: i  reason: collision with root package name */
    private final a f4671i;

    public s(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        this.f4663a = aVar;
        this.f4664b = aVar2;
        this.f4665c = aVar3;
        this.f4666d = aVar4;
        this.f4667e = aVar5;
        this.f4668f = aVar6;
        this.f4669g = aVar7;
        this.f4670h = aVar8;
        this.f4671i = aVar9;
    }

    public static s a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, a aVar7, a aVar8, a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, C1022e eVar, C1094d dVar, x xVar, Executor executor, C1115b bVar, A.a aVar, A.a aVar2, C1093c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    /* renamed from: b */
    public r get() {
        return c((Context) this.f4663a.get(), (C1022e) this.f4664b.get(), (C1094d) this.f4665c.get(), (x) this.f4666d.get(), (Executor) this.f4667e.get(), (C1115b) this.f4668f.get(), (A.a) this.f4669g.get(), (A.a) this.f4670h.get(), (C1093c) this.f4671i.get());
    }
}
