package androidx.lifecycle;

import R2.s;
import V2.d;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.p;
import o3.K;

public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p pVar, d dVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        } else if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return s.f8222a;
        } else {
            Object d5 = K.d(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, (d) null), dVar);
            return d5 == b.c() ? d5 : s.f8222a;
        }
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p pVar, d dVar) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, dVar);
        return repeatOnLifecycle == b.c() ? repeatOnLifecycle : s.f8222a;
    }
}
