package androidx.datastore.core;

import V2.d;

public interface DataMigration<T> {
    Object cleanUp(d dVar);

    Object migrate(T t4, d dVar);

    Object shouldMigrate(T t4, d dVar);
}
