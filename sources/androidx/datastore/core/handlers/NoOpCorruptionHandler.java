package androidx.datastore.core.handlers;

import V2.d;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;

public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    public Object handleCorruption(CorruptionException corruptionException, d dVar) throws CorruptionException {
        throw corruptionException;
    }
}
