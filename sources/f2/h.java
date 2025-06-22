package F2;

import E2.s;
import X3.g;
import Z3.C2616e;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import k3.c;
import kotlin.jvm.internal.m;

public final class h implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        m.e(cls, "modelClass");
        d dVar = d.f24465a;
        s n4 = dVar.n();
        if (d.f24489y == null) {
            d.f24489y = new X3.h(dVar.i(), dVar.l(), new C2616e());
        }
        g gVar = d.f24489y;
        if (gVar == null) {
            m.u("disclosureRepository_");
            gVar = null;
        }
        return new g(n4, gVar, dVar.p());
    }
}
