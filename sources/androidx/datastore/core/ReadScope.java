package androidx.datastore.core;

import V2.d;

public interface ReadScope<T> extends Closeable {
    Object readData(d dVar);
}
