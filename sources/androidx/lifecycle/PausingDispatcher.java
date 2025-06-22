package androidx.lifecycle;

import V2.g;
import kotlin.jvm.internal.m;
import o3.G;
import o3.Y;

public final class PausingDispatcher extends G {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    public void dispatch(g gVar, Runnable runnable) {
        m.e(gVar, "context");
        m.e(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(gVar, runnable);
    }

    public boolean isDispatchNeeded(g gVar) {
        m.e(gVar, "context");
        if (Y.c().D().isDispatchNeeded(gVar)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
