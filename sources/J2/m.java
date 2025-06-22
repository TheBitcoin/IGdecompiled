package J2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import com.inmobi.cmp.ChoiceCmp;
import k3.c;

public final class m implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        kotlin.jvm.internal.m.e(cls, "modelClass");
        d dVar = d.f24465a;
        return new l(dVar.n(), dVar.j(), ChoiceCmp.INSTANCE.getGoogleVendorList$app_release(), dVar.j().f170b.b(), dVar.k(), dVar.c(), dVar.j().f170b.f144q, dVar.p().c(), dVar.e(), dVar.f());
    }
}
