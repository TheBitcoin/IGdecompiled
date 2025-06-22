package androidx.datastore.preferences.core;

import R2.l;
import S2.C1601o;
import S2.H;
import androidx.datastore.preferences.core.Preferences;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import j3.e;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    public MutablePreferences() {
        this((Map) null, false, 3, (C2103g) null);
    }

    public Map<Preferences.Key<?>, Object> asMap() {
        l lVar;
        Set<Map.Entry<Preferences.Key<?>, Object>> entrySet = this.preferencesMap.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.a(H.d(C1601o.p(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                m.d(copyOf, "copyOf(this, size)");
                lVar = new l(key, copyOf);
            } else {
                lVar = new l(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(lVar.c(), lVar.d());
        }
        return Actual_jvmKt.immutableMap(linkedHashMap);
    }

    public final void checkNotFrozen$datastore_preferences_core() {
        if (this.frozen.get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.clear();
    }

    public <T> boolean contains(Preferences.Key<T> key) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        return this.preferencesMap.containsKey(key);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L_0x0010
            return r3
        L_0x0010:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L_0x001d
            return r1
        L_0x001d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0026
            return r3
        L_0x0026:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x002e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0067
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L_0x0063
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L_0x005e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L_0x0063
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x005e:
            boolean r0 = kotlin.jvm.internal.m.a(r0, r2)
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 != 0) goto L_0x002e
            return r1
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void freeze$datastore_preferences_core() {
        this.frozen.set(true);
    }

    public <T> T get(Preferences.Key<T> key) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        T t4 = this.preferencesMap.get(key);
        if (!(t4 instanceof byte[])) {
            return t4;
        }
        byte[] bArr = (byte[]) t4;
        Object copyOf = Arrays.copyOf(bArr, bArr.length);
        m.d(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core() {
        return this.preferencesMap;
    }

    public int hashCode() {
        int i4;
        int i5 = 0;
        for (Map.Entry value : this.preferencesMap.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof byte[]) {
                i4 = Arrays.hashCode((byte[]) value2);
            } else {
                i4 = value2.hashCode();
            }
            i5 += i4;
        }
        return i5;
    }

    public final void minusAssign(Preferences.Key<?> key) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        checkNotFrozen$datastore_preferences_core();
        remove(key);
    }

    public final void plusAssign(Preferences preferences) {
        m.e(preferences, "prefs");
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.putAll(preferences.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairArr) {
        m.e(pairArr, "pairs");
        checkNotFrozen$datastore_preferences_core();
        for (Preferences.Pair<?> pair : pairArr) {
            setUnchecked$datastore_preferences_core(pair.getKey$datastore_preferences_core(), pair.getValue$datastore_preferences_core());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        checkNotFrozen$datastore_preferences_core();
        return this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T t4) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        setUnchecked$datastore_preferences_core(key, t4);
    }

    public final void setUnchecked$datastore_preferences_core(Preferences.Key<?> key, Object obj) {
        m.e(key, LeanbackPreferenceDialogFragment.ARG_KEY);
        checkNotFrozen$datastore_preferences_core();
        if (obj == null) {
            remove(key);
        } else if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmKt.immutableCopyOfSet((Set) obj));
        } else if (obj instanceof byte[]) {
            Map<Preferences.Key<?>, Object> map = this.preferencesMap;
            byte[] bArr = (byte[]) obj;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            m.d(copyOf, "copyOf(this, size)");
            map.put(key, copyOf);
        } else {
            this.preferencesMap.put(key, obj);
        }
    }

    public String toString() {
        return C1601o.O(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, MutablePreferences$toString$1.INSTANCE, 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(Map map, boolean z4, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? new LinkedHashMap() : map, (i4 & 2) != 0 ? true : z4);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        m.e(pair, "pair");
        checkNotFrozen$datastore_preferences_core();
        putAll(pair);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z4) {
        m.e(map, "preferencesMap");
        this.preferencesMap = map;
        this.frozen = new AtomicBoolean(z4);
    }
}
