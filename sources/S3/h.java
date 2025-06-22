package s3;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import kotlin.jvm.internal.C2103g;
import q3.a;
import r3.C1035e;
import r3.C1036f;

public final class h extends g {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(C1035e eVar, g gVar, int i4, a aVar, int i5, C2103g gVar2) {
        this(eVar, (i5 & 2) != 0 ? V2.h.f8445a : gVar, (i5 & 4) != 0 ? -3 : i4, (i5 & 8) != 0 ? a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    public e i(g gVar, int i4, a aVar) {
        return new h(this.f4351d, gVar, i4, aVar);
    }

    public C1035e j() {
        return this.f4351d;
    }

    /* access modifiers changed from: protected */
    public Object q(C1036f fVar, d dVar) {
        Object collect = this.f4351d.collect(fVar, dVar);
        if (collect == b.c()) {
            return collect;
        }
        return s.f8222a;
    }

    public h(C1035e eVar, g gVar, int i4, a aVar) {
        super(eVar, gVar, i4, aVar);
    }
}
