package androidx.datastore.core;

import V2.d;

public interface CorruptionHandler<T> {
    Object handleCorruption(CorruptionException corruptionException, d dVar);
}
