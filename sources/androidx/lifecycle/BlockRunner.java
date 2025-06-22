package androidx.lifecycle;

import V2.d;
import V2.g;
import androidx.annotation.MainThread;
import d3.a;
import d3.p;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class BlockRunner<T> {
    /* access modifiers changed from: private */
    public final p block;
    private C1001s0 cancellationJob;
    /* access modifiers changed from: private */
    public final CoroutineLiveData<T> liveData;
    /* access modifiers changed from: private */
    public final a onDone;
    /* access modifiers changed from: private */
    public C1001s0 runningJob;
    private final J scope;
    /* access modifiers changed from: private */
    public final long timeoutInMs;

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, p pVar, long j4, J j5, a aVar) {
        m.e(coroutineLiveData, "liveData");
        m.e(pVar, "block");
        m.e(j5, "scope");
        m.e(aVar, "onDone");
        this.liveData = coroutineLiveData;
        this.block = pVar;
        this.timeoutInMs = j4;
        this.scope = j5;
        this.onDone = aVar;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob == null) {
            this.cancellationJob = C0981i.d(this.scope, Y.c().D(), (L) null, new BlockRunner$cancel$1(this, (d) null), 2, (Object) null);
            return;
        }
        throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
    }

    @MainThread
    public final void maybeRun() {
        C1001s0 s0Var = this.cancellationJob;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        this.cancellationJob = null;
        if (this.runningJob == null) {
            this.runningJob = C0981i.d(this.scope, (g) null, (L) null, new BlockRunner$maybeRun$1(this, (d) null), 3, (Object) null);
        }
    }
}
