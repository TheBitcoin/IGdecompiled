package androidx.lifecycle;

import V2.d;
import V2.g;
import d3.p;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;

public abstract class LifecycleCoroutineScope implements J {
    public abstract /* synthetic */ g getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final C1001s0 launchWhenCreated(p pVar) {
        m.e(pVar, "block");
        return C0981i.d(this, (g) null, (L) null, new LifecycleCoroutineScope$launchWhenCreated$1(this, pVar, (d) null), 3, (Object) null);
    }

    public final C1001s0 launchWhenResumed(p pVar) {
        m.e(pVar, "block");
        return C0981i.d(this, (g) null, (L) null, new LifecycleCoroutineScope$launchWhenResumed$1(this, pVar, (d) null), 3, (Object) null);
    }

    public final C1001s0 launchWhenStarted(p pVar) {
        m.e(pVar, "block");
        return C0981i.d(this, (g) null, (L) null, new LifecycleCoroutineScope$launchWhenStarted$1(this, pVar, (d) null), 3, (Object) null);
    }
}
