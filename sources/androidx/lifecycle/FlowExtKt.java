package androidx.lifecycle;

import V2.d;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;

public final class FlowExtKt {
    public static final <T> C1035e flowWithLifecycle(C1035e eVar, Lifecycle lifecycle, Lifecycle.State state) {
        m.e(eVar, "<this>");
        m.e(lifecycle, "lifecycle");
        m.e(state, "minActiveState");
        return C1037g.d(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, eVar, (d) null));
    }

    public static /* synthetic */ C1035e flowWithLifecycle$default(C1035e eVar, Lifecycle lifecycle, Lifecycle.State state, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(eVar, lifecycle, state);
    }
}
