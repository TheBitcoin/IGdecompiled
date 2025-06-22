package androidx.room;

import R2.s;
import d3.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.n;
import o3.C1001s0;
import o3.C1012y;

final class RoomDatabaseKt$createTransactionContext$2 extends n implements l {
    final /* synthetic */ C1012y $controlJob;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabaseKt$createTransactionContext$2(C1012y yVar) {
        super(1);
        this.$controlJob = yVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        C1001s0.a.a(this.$controlJob, (CancellationException) null, 1, (Object) null);
    }
}
