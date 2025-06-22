package c4;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import b4.d;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.data.storage.SharedStorage;
import k3.c;
import kotlin.jvm.internal.m;

public final class g implements ViewModelProvider.Factory {
    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public ViewModel create(Class cls) {
        m.e(cls, "modelClass");
        d dVar = d.f24465a;
        SharedStorage m4 = dVar.m();
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        return new f(m4, choiceCmp.getCallback(), dVar.p().b(), choiceCmp.getPortalConfig$app_release(), dVar.o(), dVar.e());
    }
}
