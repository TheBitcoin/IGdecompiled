package androidx.core.os;

import d3.a;

public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ a $action;

    public HandlerKt$postAtTime$runnable$1(a aVar) {
        this.$action = aVar;
    }

    public final void run() {
        this.$action.invoke();
    }
}
