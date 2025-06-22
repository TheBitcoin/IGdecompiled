package androidx.room;

import R2.s;
import d3.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.n;
import o3.C1001s0;

final class RoomDatabaseKt$acquireTransactionThread$2$1 extends n implements l {
    final /* synthetic */ C1001s0 $controlJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt$acquireTransactionThread$2$1(C1001s0 s0Var) {
        super(1);
        this.$controlJob = s0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        C1001s0.a.a(this.$controlJob, (CancellationException) null, 1, (Object) null);
    }
}
