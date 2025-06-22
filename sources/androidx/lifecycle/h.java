package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import o3.C1001s0;

public final /* synthetic */ class h implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1001s0 f961b;

    public /* synthetic */ h(LifecycleController lifecycleController, C1001s0 s0Var) {
        this.f960a = lifecycleController;
        this.f961b = s0Var;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.f960a, this.f961b, lifecycleOwner, event);
    }
}
