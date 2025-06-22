package androidx.core.os;

import V2.d;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;

@RequiresApi(31)
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> asOutcomeReceiver(d dVar) {
        return i.a(new ContinuationOutcomeReceiver(dVar));
    }
}
