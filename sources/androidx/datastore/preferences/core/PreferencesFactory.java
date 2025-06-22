package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class PreferencesFactory {
    public static final Preferences create(Preferences.Pair<?>... pairArr) {
        m.e(pairArr, "pairs");
        return createMutable((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
    }

    public static final Preferences createEmpty() {
        return new MutablePreferences((Map) null, true, 1, (C2103g) null);
    }

    public static final MutablePreferences createMutable(Preferences.Pair<?>... pairArr) {
        m.e(pairArr, "pairs");
        MutablePreferences mutablePreferences = new MutablePreferences((Map) null, false, 1, (C2103g) null);
        mutablePreferences.putAll((Preferences.Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        return mutablePreferences;
    }
}
