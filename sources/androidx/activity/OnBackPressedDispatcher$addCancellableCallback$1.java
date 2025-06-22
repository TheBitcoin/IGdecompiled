package androidx.activity;

import d3.a;
import kotlin.jvm.internal.k;

/* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends k implements a {
    OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final void invoke() {
        ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }
}
