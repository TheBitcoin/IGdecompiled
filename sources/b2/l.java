package B2;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import com.inmobi.cmp.ChoiceCmp;
import k3.c;
import kotlin.jvm.internal.m;

public final class l implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        m.e(cls, "modelClass");
        d dVar = d.f24465a;
        return new k(dVar.n(), dVar.j(), ChoiceCmp.INSTANCE.getGoogleVendorList$app_release(), dVar.j().f170b.b(), dVar.c(), dVar.p(), dVar.j().f174f.f24218j, dVar.j().f170b.f139l, dVar.j().f170b.f136i, dVar.j().f170b.f153z, dVar.j().f170b.f116H, dVar.e());
    }
}
