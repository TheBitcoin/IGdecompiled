package androidx.work;

import R2.s;
import d3.l;
import kotlin.jvm.internal.n;
import o0.C2172d;

final class ListenableFutureKt$await$2$2 extends n implements l {
    final /* synthetic */ C2172d $this_await;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$2$2(C2172d dVar) {
        super(1);
        this.$this_await = dVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        this.$this_await.cancel(false);
    }
}
