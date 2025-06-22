package androidx.datastore.core;

import R2.s;
import V2.d;
import W2.b;

public final class StorageConnectionKt {
    public static final <T> Object readData(StorageConnection<T> storageConnection, d dVar) {
        return storageConnection.readScope(new StorageConnectionKt$readData$2((d) null), dVar);
    }

    public static final <T> Object writeData(StorageConnection<T> storageConnection, T t4, d dVar) {
        Object writeScope = storageConnection.writeScope(new StorageConnectionKt$writeData$2(t4, (d) null), dVar);
        if (writeScope == b.c()) {
            return writeScope;
        }
        return s.f8222a;
    }
}
