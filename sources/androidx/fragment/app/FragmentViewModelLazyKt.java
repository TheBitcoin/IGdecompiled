package androidx.fragment.app;

import R2.g;
import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import d3.a;
import k3.c;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;

public final class FragmentViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> g activityViewModels(Fragment fragment, a aVar) {
        m.e(fragment, "$this$activityViewModels");
        m.j(4, "VM");
        c b5 = D.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b5, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    public static /* synthetic */ g activityViewModels$default(Fragment fragment, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = null;
        }
        m.e(fragment, "$this$activityViewModels");
        m.j(4, "VM");
        c b5 = D.b(ViewModel.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(fragment);
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$activityViewModels$2(fragment);
        }
        return createViewModelLazy(fragment, b5, fragmentViewModelLazyKt$activityViewModels$1, aVar);
    }

    @MainThread
    public static final <VM extends ViewModel> g createViewModelLazy(Fragment fragment, c cVar, a aVar, a aVar2) {
        m.e(fragment, "$this$createViewModelLazy");
        m.e(cVar, "viewModelClass");
        m.e(aVar, "storeProducer");
        if (aVar2 == null) {
            aVar2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(cVar, aVar, aVar2);
    }

    public static /* synthetic */ g createViewModelLazy$default(Fragment fragment, c cVar, a aVar, a aVar2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, cVar, aVar, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> g viewModels(Fragment fragment, a aVar, a aVar2) {
        m.e(fragment, "$this$viewModels");
        m.e(aVar, "ownerProducer");
        m.j(4, "VM");
        return createViewModelLazy(fragment, D.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(aVar), aVar2);
    }

    public static /* synthetic */ g viewModels$default(Fragment fragment, a aVar, a aVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = new FragmentViewModelLazyKt$viewModels$1(fragment);
        }
        if ((i4 & 2) != 0) {
            aVar2 = null;
        }
        m.e(fragment, "$this$viewModels");
        m.e(aVar, "ownerProducer");
        m.j(4, "VM");
        return createViewModelLazy(fragment, D.b(ViewModel.class), new FragmentViewModelLazyKt$viewModels$2(aVar), aVar2);
    }
}
