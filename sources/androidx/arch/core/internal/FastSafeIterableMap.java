package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k4) {
        if (contains(k4)) {
            return this.mHashMap.get(k4).mPrevious;
        }
        return null;
    }

    public boolean contains(K k4) {
        return this.mHashMap.containsKey(k4);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K k4) {
        return this.mHashMap.get(k4);
    }

    public V putIfAbsent(@NonNull K k4, @NonNull V v4) {
        SafeIterableMap.Entry entry = get(k4);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k4, put(k4, v4));
        return null;
    }

    public V remove(@NonNull K k4) {
        V remove = super.remove(k4);
        this.mHashMap.remove(k4);
        return remove;
    }
}
