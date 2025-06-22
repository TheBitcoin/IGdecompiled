package androidx.room;

import R2.s;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteCompat;
import d3.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.n;
import o3.C1001s0;

final class CoroutinesRoom$Companion$execute$4$1 extends n implements l {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ C1001s0 $job;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, C1001s0 s0Var) {
        super(1);
        this.$cancellationSignal = cancellationSignal;
        this.$job = s0Var;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return s.f8222a;
    }

    public final void invoke(Throwable th) {
        SupportSQLiteCompat.Api16Impl.cancel(this.$cancellationSignal);
        C1001s0.a.a(this.$job, (CancellationException) null, 1, (Object) null);
    }
}
