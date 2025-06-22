package androidx.lifecycle;

import V2.g;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.jvm.internal.m;
import o3.E0;
import o3.Y;

public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    /* access modifiers changed from: private */
    public static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue dispatchQueue, Runnable runnable) {
        m.e(dispatchQueue, "this$0");
        m.e(runnable, "$runnable");
        dispatchQueue.enqueue(runnable);
    }

    @MainThread
    private final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables");
    }

    @MainThread
    public final boolean canRun() {
        if (this.finished || !this.paused) {
            return true;
        }
        return false;
    }

    @AnyThread
    public final void dispatchAndEnqueue(g gVar, Runnable runnable) {
        m.e(gVar, "context");
        m.e(runnable, "runnable");
        E0 D4 = Y.c().D();
        if (D4.isDispatchNeeded(gVar) || canRun()) {
            D4.dispatch(gVar, new d(this, runnable));
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (!this.isDraining) {
            boolean z4 = true;
            z4 = false;
            try {
                while (true) {
                    if (this.queue.isEmpty()) {
                        break;
                    } else if (!canRun()) {
                        break;
                    } else {
                        Runnable poll = this.queue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.isDraining = z4;
            } finally {
                this.isDraining = z4;
            }
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!this.finished) {
                this.paused = false;
                drainQueue();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher");
        }
    }
}
