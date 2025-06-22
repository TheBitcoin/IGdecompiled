package androidx.datastore.preferences.core;

import V2.d;
import androidx.datastore.core.DataStore;
import d3.p;
import kotlin.jvm.internal.m;
import r3.C1035e;

public final class PreferenceDataStore implements DataStore<Preferences> {
    private final DataStore<Preferences> delegate;

    public PreferenceDataStore(DataStore<Preferences> dataStore) {
        m.e(dataStore, "delegate");
        this.delegate = dataStore;
    }

    public C1035e getData() {
        return this.delegate.getData();
    }

    public Object updateData(p pVar, d dVar) {
        return this.delegate.updateData(new PreferenceDataStore$updateData$2(pVar, (d) null), dVar);
    }
}
