package r3;

import V2.d;
import V2.g;
import V2.h;
import W2.b;
import d3.p;
import kotlin.jvm.internal.C2103g;
import q3.a;
import q3.s;
import s3.e;

/* renamed from: r3.c  reason: case insensitive filesystem */
class C1033c extends e {

    /* renamed from: d  reason: collision with root package name */
    private final p f4191d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1033c(p pVar, g gVar, int i4, a aVar, int i5, C2103g gVar2) {
        this(pVar, (i5 & 2) != 0 ? h.f8445a : gVar, (i5 & 4) != 0 ? -2 : i4, (i5 & 8) != 0 ? a.SUSPEND : aVar);
    }

    static /* synthetic */ Object n(C1033c cVar, s sVar, d dVar) {
        Object invoke = cVar.f4191d.invoke(sVar, dVar);
        if (invoke == b.c()) {
            return invoke;
        }
        return R2.s.f8222a;
    }

    /* access modifiers changed from: protected */
    public Object h(s sVar, d dVar) {
        return n(this, sVar, dVar);
    }

    /* access modifiers changed from: protected */
    public e i(g gVar, int i4, a aVar) {
        return new C1033c(this.f4191d, gVar, i4, aVar);
    }

    public String toString() {
        return "block[" + this.f4191d + "] -> " + super.toString();
    }

    public C1033c(p pVar, g gVar, int i4, a aVar) {
        super(gVar, i4, aVar);
        this.f4191d = pVar;
    }
}
