package androidx.core.util;

import V2.d;

public final class RunnableKt {
    public static final Runnable asRunnable(d dVar) {
        return new ContinuationRunnable(dVar);
    }
}
