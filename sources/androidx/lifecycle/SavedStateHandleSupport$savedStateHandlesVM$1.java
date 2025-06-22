package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import k3.c;
import kotlin.jvm.internal.m;

public final class SavedStateHandleSupport$savedStateHandlesVM$1 implements ViewModelProvider.Factory {
    SavedStateHandleSupport$savedStateHandlesVM$1() {
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return o.a(this, cls);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        m.e(cls, "modelClass");
        m.e(creationExtras, "extras");
        return new SavedStateHandlesVM();
    }
}
