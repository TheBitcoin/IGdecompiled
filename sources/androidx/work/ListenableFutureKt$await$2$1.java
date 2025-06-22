package androidx.work;

import R2.m;
import R2.n;
import java.util.concurrent.CancellationException;
import o0.C2172d;
import o3.C0989m;

public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ C0989m $cancellableContinuation;
    final /* synthetic */ C2172d $this_await;

    public ListenableFutureKt$await$2$1(C0989m mVar, C2172d dVar) {
        this.$cancellableContinuation = mVar;
        this.$this_await = dVar;
    }

    public final void run() {
        try {
            C0989m mVar = this.$cancellableContinuation;
            m.a aVar = m.f8216a;
            mVar.resumeWith(m.a(this.$this_await.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.y(cause);
                return;
            }
            C0989m mVar2 = this.$cancellableContinuation;
            m.a aVar2 = m.f8216a;
            mVar2.resumeWith(m.a(n.a(cause)));
        }
    }
}
