package androidx.datastore.core;

import V2.d;
import d3.p;
import d3.q;

public interface StorageConnection<T> extends Closeable {
    InterProcessCoordinator getCoordinator();

    <R> Object readScope(q qVar, d dVar);

    Object writeScope(p pVar, d dVar);
}
