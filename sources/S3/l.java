package s3;

import V2.g;
import d3.p;

public final class l implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f4394a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ g f4395b;

    public l(Throwable th, g gVar) {
        this.f4394a = th;
        this.f4395b = gVar;
    }

    public Object fold(Object obj, p pVar) {
        return this.f4395b.fold(obj, pVar);
    }

    public g.b get(g.c cVar) {
        return this.f4395b.get(cVar);
    }

    public g minusKey(g.c cVar) {
        return this.f4395b.minusKey(cVar);
    }

    public g plus(g gVar) {
        return this.f4395b.plus(gVar);
    }
}
