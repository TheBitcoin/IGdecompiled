package androidx.datastore.core;

import V2.d;

public interface WriteScope<T> extends ReadScope<T> {
    Object writeData(T t4, d dVar);
}
