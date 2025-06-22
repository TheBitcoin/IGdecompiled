package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import r3.t;

public final /* synthetic */ class g implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t f959a;

    public /* synthetic */ g(t tVar) {
        this.f959a = tVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Lifecycle._get_currentStateFlow_$lambda$0(this.f959a, lifecycleOwner, event);
    }
}
