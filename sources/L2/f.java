package L2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import k3.c;
import kotlin.jvm.internal.m;

public final class f implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        m.e(cls, "modelClass");
        d dVar = d.f24465a;
        return new e(dVar.n(), dVar.j(), dVar.p());
    }
}
