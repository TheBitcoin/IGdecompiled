package androidx.lifecycle;

import V2.d;
import V2.g;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.L;
import o3.Y;

public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final g coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle2, g gVar) {
        m.e(lifecycle2, "lifecycle");
        m.e(gVar, "coroutineContext");
        this.lifecycle = lifecycle2;
        this.coroutineContext = gVar;
        if (getLifecycle$lifecycle_common().getCurrentState() == Lifecycle.State.DESTROYED) {
            C1013y0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public g getCoroutineContext() {
        return this.coroutineContext;
    }

    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.e(lifecycleOwner, "source");
        m.e(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            C1013y0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void register() {
        C1001s0 unused = C0981i.d(this, Y.c().D(), (L) null, new LifecycleCoroutineScopeImpl$register$1(this, (d) null), 2, (Object) null);
    }
}
