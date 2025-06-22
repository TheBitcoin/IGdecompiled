package androidx.lifecycle.viewmodel;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (C2103g) null);
    }

    public <T> T get(CreationExtras.Key<T> key) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        return getMap$lifecycle_viewmodel_release().get(key);
    }

    public final <T> void set(CreationExtras.Key<T> key, T t4) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        getMap$lifecycle_viewmodel_release().put(key, t4);
    }

    public MutableCreationExtras(CreationExtras creationExtras) {
        m.e(creationExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(creationExtras.getMap$lifecycle_viewmodel_release());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
