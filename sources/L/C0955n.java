package l;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import k3.c;
import kotlin.jvm.internal.m;

/* renamed from: l.n  reason: case insensitive filesystem */
public final class C0955n implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        m.e(cls, "modelClass");
        d dVar = d.f24465a;
        return new C0954m(dVar.n(), dVar.j(), dVar.j().f171c, dVar.p(), dVar.j().f170b.b(), dVar.j().f170b.f137j, dVar.j().f170b.f139l, dVar.j().f170b.f136i, dVar.j().f170b.f138k);
    }
}
