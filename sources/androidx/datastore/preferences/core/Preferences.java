package androidx.datastore.preferences.core;

import S2.H;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;
import kotlin.jvm.internal.m;

public abstract class Preferences {

    public static final class Key<T> {
        private final String name;

        public Key(String str) {
            m.e(str, RewardPlus.NAME);
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return m.a(this.name, ((Key) obj).name);
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public final Pair<T> to(T t4) {
            return new Pair<>(this, t4);
        }

        public String toString() {
            return this.name;
        }
    }

    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public Pair(Key<T> key2, T t4) {
            m.e(key2, LeanbackPreferenceDialogFragment.ARG_KEY);
            this.key = key2;
            this.value = t4;
        }

        public final Key<T> getKey$datastore_preferences_core() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core() {
            return this.value;
        }
    }

    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> boolean contains(Key<T> key);

    public abstract <T> T get(Key<T> key);

    public final MutablePreferences toMutablePreferences() {
        return new MutablePreferences(H.t(asMap()), false);
    }

    public final Preferences toPreferences() {
        return new MutablePreferences(H.t(asMap()), true);
    }
}
