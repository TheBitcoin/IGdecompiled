package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import q3.s;

public final /* synthetic */ class j implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f962a;

    public /* synthetic */ j(s sVar) {
        this.f962a = sVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleKt$eventFlow$1.invokeSuspend$lambda$0(this.f962a, lifecycleOwner, event);
    }
}
