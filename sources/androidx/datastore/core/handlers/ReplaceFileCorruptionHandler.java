package androidx.datastore.core.handlers;

import V2.d;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import d3.l;
import java.io.IOException;
import kotlin.jvm.internal.m;

public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final l produceNewData;

    public ReplaceFileCorruptionHandler(l lVar) {
        m.e(lVar, "produceNewData");
        this.produceNewData = lVar;
    }

    public Object handleCorruption(CorruptionException corruptionException, d dVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
