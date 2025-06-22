package androidx.datastore;

import N3.C2520k;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import d3.l;
import d3.p;
import g3.a;
import java.util.List;
import k3.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.J;

public final class DataStoreSingletonDelegate<T> implements a {
    @GuardedBy("lock")
    private volatile DataStore<T> INSTANCE;
    private final ReplaceFileCorruptionHandler<T> corruptionHandler;
    /* access modifiers changed from: private */
    public final String fileName;
    private final Object lock = new Object();
    private final l produceMigrations;
    private final J scope;
    private final OkioSerializer<T> serializer;

    public DataStoreSingletonDelegate(String str, OkioSerializer<T> okioSerializer, ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler, l lVar, J j4) {
        m.e(str, "fileName");
        m.e(okioSerializer, "serializer");
        m.e(lVar, "produceMigrations");
        m.e(j4, "scope");
        this.fileName = str;
        this.serializer = okioSerializer;
        this.corruptionHandler = replaceFileCorruptionHandler;
        this.produceMigrations = lVar;
        this.scope = j4;
    }

    public DataStore<T> getValue(Context context, h hVar) {
        DataStore<T> dataStore;
        m.e(context, "thisRef");
        m.e(hVar, "property");
        DataStore<T> dataStore2 = this.INSTANCE;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.lock) {
            try {
                if (this.INSTANCE == null) {
                    Context applicationContext = context.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.INSTANCE;
                    OkioStorage okioStorage = new OkioStorage(C2520k.f23728b, this.serializer, (p) null, new DataStoreSingletonDelegate$getValue$1$1(applicationContext, this), 4, (C2103g) null);
                    ReplaceFileCorruptionHandler<T> replaceFileCorruptionHandler = this.corruptionHandler;
                    l lVar = this.produceMigrations;
                    m.d(applicationContext, "applicationContext");
                    this.INSTANCE = dataStoreFactory.create(okioStorage, replaceFileCorruptionHandler, (List) lVar.invoke(applicationContext), this.scope);
                }
                dataStore = this.INSTANCE;
                m.b(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
