package androidx.core.util;

import V2.d;
import androidx.annotation.RequiresApi;
import java.util.function.Consumer;

@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> Consumer<T> asConsumer(d dVar) {
        return new ContinuationConsumer(dVar);
    }
}
