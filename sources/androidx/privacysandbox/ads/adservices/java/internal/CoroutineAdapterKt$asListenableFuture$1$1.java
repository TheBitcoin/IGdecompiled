package androidx.privacysandbox.ads.adservices.java.internal;

import R2.s;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import d3.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.n;
import o3.Q;

final class CoroutineAdapterKt$asListenableFuture$1$1 extends n implements l {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ Q $this_asListenableFuture;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, Q q4) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = q4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            this.$completer.set(this.$this_asListenableFuture.d());
        } else if (th instanceof CancellationException) {
            this.$completer.setCancelled();
        } else {
            this.$completer.setException(th);
        }
    }
}
