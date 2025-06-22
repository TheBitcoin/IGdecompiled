package androidx.datastore.preferences.core;

import N3.C2520k;
import S2.C1601o;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioStorage;
import d3.a;
import d3.p;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.P0;
import o3.Y;

public final class PreferenceDataStoreFactory {
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, J j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 4) != 0) {
            list = C1601o.h();
        }
        if ((i4 & 8) != 0) {
            j4 = K.a(Actual_jvmKt.ioDispatcher().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, j4);
    }

    public static /* synthetic */ DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, J j4, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 2) != 0) {
            list = C1601o.h();
        }
        if ((i4 & 4) != 0) {
            j4 = K.a(Actual_jvmKt.ioDispatcher().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, j4, aVar);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage) {
        m.e(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) null, (List) null, (J) null, 14, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        m.e(aVar, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, (List) null, (J) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        m.e(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (J) null, 12, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        m.e(list, "migrations");
        m.e(aVar, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, list, (J) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list) {
        m.e(storage, "storage");
        m.e(list, "migrations");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (J) null, 8, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(a aVar) {
        m.e(aVar, "produceFile");
        return createWithPath$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (J) null, aVar, 7, (Object) null);
    }

    public static /* synthetic */ DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, J j4, a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i4 & 2) != 0) {
            list = C1601o.h();
        }
        if ((i4 & 4) != 0) {
            j4 = K.a(Y.b().plus(P0.b((C1001s0) null, 1, (Object) null)));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, j4, aVar);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, a aVar) {
        m.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (J) null, aVar, 6, (Object) null);
    }

    public final DataStore<Preferences> createWithPath(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, J j4, a aVar) {
        m.e(list, "migrations");
        m.e(j4, "scope");
        m.e(aVar, "produceFile");
        return create(replaceFileCorruptionHandler, list, j4, (a) new PreferenceDataStoreFactory$createWithPath$1(aVar));
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, a aVar) {
        m.e(list, "migrations");
        m.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (J) null, aVar, 4, (Object) null);
    }

    public final DataStore<Preferences> create(a aVar) {
        m.e(aVar, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (J) null, aVar, 7, (Object) null);
    }

    public final DataStore<Preferences> create(ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, J j4, a aVar) {
        m.e(list, "migrations");
        m.e(j4, "scope");
        m.e(aVar, "produceFile");
        return new PreferenceDataStore(create((Storage<Preferences>) new OkioStorage(C2520k.f23728b, PreferencesSerializer.INSTANCE, (p) null, new PreferenceDataStoreFactory$create$delegate$1(aVar), 4, (C2103g) null), replaceFileCorruptionHandler, list, j4));
    }

    public final DataStore<Preferences> create(Storage<Preferences> storage, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, List<? extends DataMigration<Preferences>> list, J j4) {
        m.e(storage, "storage");
        m.e(list, "migrations");
        m.e(j4, "scope");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, list, j4));
    }
}
