package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;

public final class ViewModelProviderGetKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        m.e(viewModelProvider, "<this>");
        m.j(4, "VM");
        return viewModelProvider.get(D.b(ViewModel.class));
    }
}
