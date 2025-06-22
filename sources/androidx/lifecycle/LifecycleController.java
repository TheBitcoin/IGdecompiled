package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o3.C1001s0;

@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle2, Lifecycle.State state, DispatchQueue dispatchQueue2, C1001s0 s0Var) {
        m.e(lifecycle2, "lifecycle");
        m.e(state, "minState");
        m.e(dispatchQueue2, "dispatchQueue");
        m.e(s0Var, "parentJob");
        this.lifecycle = lifecycle2;
        this.minState = state;
        this.dispatchQueue = dispatchQueue2;
        h hVar = new h(this, s0Var);
        this.observer = hVar;
        if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle2.addObserver(hVar);
    }

    private final void handleDestroy(C1001s0 s0Var) {
        C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        finish();
    }

    /* access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, C1001s0 s0Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.e(lifecycleController, "this$0");
        m.e(s0Var, "$parentJob");
        m.e(lifecycleOwner, "source");
        m.e(event, "<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
