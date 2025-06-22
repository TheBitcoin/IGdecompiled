package androidx.datastore.core;

import S2.C1601o;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import d3.a;
import d3.l;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.P0;
import o3.Y;

public final class DataStoreFactory {
    public static final DataStoreFactory INSTANCE = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, J j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 4) != 0) {
            list = C1601o.h();
        }
        if ((i4 & 8) != 0) {
            j4 = K.a(Actual_jvmKt.ioDispatcher().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(storage, replaceFileCorruptionHandler, list, j4);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, a aVar) {
        m.e(serializer, "serializer");
        m.e(aVar, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, (List) null, (J) null, aVar, 12, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, a aVar) {
        m.e(serializer, "serializer");
        m.e(list, "migrations");
        m.e(aVar, "produceFile");
        return create$default(this, serializer, replaceFileCorruptionHandler, list, (J) null, aVar, 8, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, a aVar) {
        m.e(serializer, "serializer");
        m.e(aVar, "produceFile");
        return create$default(this, serializer, (ReplaceFileCorruptionHandler) null, (List) null, (J) null, aVar, 14, (Object) null);
    }

    public static /* synthetic */ DataStore create$default(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, J j4, a aVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 4) != 0) {
            list = C1601o.h();
        }
        if ((i4 & 8) != 0) {
            j4 = K.a(Y.b().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return dataStoreFactory.create(serializer, replaceFileCorruptionHandler, list, j4, aVar);
    }

    public final <T> DataStore<T> create(Storage<T> storage) {
        m.e(storage, "storage");
        return create$default(this, storage, (ReplaceFileCorruptionHandler) null, (List) null, (J) null, 14, (Object) null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler) {
        m.e(storage, "storage");
        return create$default(this, storage, replaceFileCorruptionHandler, (List) null, (J) null, 12, (Object) null);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list) {
        m.e(storage, "storage");
        m.e(list, "migrations");
        return create$default(this, storage, replaceFileCorruptionHandler, list, (J) null, 8, (Object) null);
    }

    public final <T> DataStore<T> create(Serializer<T> serializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, J j4, a aVar) {
        m.e(serializer, "serializer");
        m.e(list, "migrations");
        m.e(j4, "scope");
        m.e(aVar, "produceFile");
        return create(new FileStorage(serializer, (l) null, aVar, 2, (C2103g) null), replaceFileCorruptionHandler, list, j4);
    }

    public final <T> DataStore<T> create(Storage<T> storage, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, List<? extends DataMigration<T>> list, J j4) {
        m.e(storage, "storage");
        m.e(list, "migrations");
        m.e(j4, "scope");
        CorruptionHandler corruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            corruptionHandler = new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, C1601o.e(DataMigrationInitializer.Companion.getInitializer(list)), corruptionHandler, j4);
    }
}
