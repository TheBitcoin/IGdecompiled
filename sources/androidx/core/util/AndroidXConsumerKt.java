package androidx.core.util;

import V2.d;

public final class AndroidXConsumerKt {
    public static final <T> Consumer<T> asAndroidXConsumer(d dVar) {
        return new AndroidXContinuationConsumer(dVar);
    }
}
