package androidx.datastore.migrations;

import S2.C1601o;
import S2.H;
import android.content.SharedPreferences;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class SharedPreferencesView {
    private final Set<String> keySet;
    private final SharedPreferences prefs;

    public SharedPreferencesView(SharedPreferences sharedPreferences, Set<String> set) {
        m.e(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.keySet = set;
    }

    private final String checkKey(String str) {
        Set<String> set = this.keySet;
        if (set == null || set.contains(str)) {
            return str;
        }
        throw new IllegalStateException(("Can't access key outside migration: " + str).toString());
    }

    public static /* synthetic */ String getString$default(SharedPreferencesView sharedPreferencesView, String str, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        return sharedPreferencesView.getString(str, str2);
    }

    public static /* synthetic */ Set getStringSet$default(SharedPreferencesView sharedPreferencesView, String str, Set set, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            set = null;
        }
        return sharedPreferencesView.getStringSet(str, set);
    }

    public final boolean contains(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.contains(checkKey(str));
    }

    public final Map<String, Object> getAll() {
        boolean z4;
        Map<String, ?> all = this.prefs.getAll();
        m.d(all, "prefs.all");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Set<String> set = this.keySet;
            if (set != null) {
                z4 = set.contains(str);
            } else {
                z4 = true;
            }
            if (z4) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(H.d(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = C1601o.d0((Iterable) value);
            }
            linkedHashMap2.put(key, value);
        }
        return linkedHashMap2;
    }

    public final boolean getBoolean(String str, boolean z4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.getBoolean(checkKey(str), z4);
    }

    public final float getFloat(String str, float f4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.getFloat(checkKey(str), f4);
    }

    public final int getInt(String str, int i4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.getInt(checkKey(str), i4);
    }

    public final long getLong(String str, long j4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.getLong(checkKey(str), j4);
    }

    public final String getString(String str, String str2) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.prefs.getString(checkKey(str), str2);
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        Set<String> stringSet = this.prefs.getStringSet(checkKey(str), set);
        if (stringSet != null) {
            return C1601o.c0(stringSet);
        }
        return null;
    }
}
