package androidx.lifecycle;

import V2.d;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.P0;
import o3.Y;
import r3.C1035e;
import r3.C1037g;

public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        m.e(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, P0.b((C1001s0) null, 1, (Object) null).plus(Y.c().D()));
        } while (!i.a(lifecycle.getInternalScopeRef(), (Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final C1035e getEventFlow(Lifecycle lifecycle) {
        m.e(lifecycle, "<this>");
        return C1037g.t(C1037g.d(new LifecycleKt$eventFlow$1(lifecycle, (d) null)), Y.c().D());
    }
}
