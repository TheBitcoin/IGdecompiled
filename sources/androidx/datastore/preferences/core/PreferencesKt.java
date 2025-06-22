package androidx.datastore.preferences.core;

import V2.d;
import androidx.datastore.core.DataStore;
import d3.p;

public final class PreferencesKt {
    public static final Object edit(DataStore<Preferences> dataStore, p pVar, d dVar) {
        return dataStore.updateData(new PreferencesKt$edit$2(pVar, (d) null), dVar);
    }
}
