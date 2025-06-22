package androidx.lifecycle;

import V2.d;
import androidx.lifecycle.Lifecycle;
import d3.p;
import o3.C0977g;
import o3.Y;

public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, d dVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, d dVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, d dVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, dVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, d dVar) {
        return C0977g.g(Y.c().D(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, (d) null), dVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, dVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, dVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, d dVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, dVar);
    }
}
