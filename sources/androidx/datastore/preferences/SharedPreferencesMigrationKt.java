package androidx.datastore.preferences;

import V2.d;
import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.preferences.core.Preferences;
import d3.a;
import d3.p;
import d3.q;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class SharedPreferencesMigrationKt {
    private static final Set<String> MIGRATE_ALL_KEYS = new LinkedHashSet();

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str) {
        m.e(context, "context");
        m.e(str, "sharedPreferencesName");
        return SharedPreferencesMigration$default(context, str, (Set) null, 4, (Object) null);
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(a aVar, Set<String> set, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(aVar, set);
    }

    public static final Set<String> getMIGRATE_ALL_KEYS() {
        return MIGRATE_ALL_KEYS;
    }

    private static final q getMigrationFunction() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1((d) null);
    }

    private static final p getShouldRunMigration(Set<String> set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, (d) null);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(a aVar) {
        m.e(aVar, "produceSharedPreferences");
        return SharedPreferencesMigration$default(aVar, (Set) null, 2, (Object) null);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(a aVar, Set<String> set) {
        m.e(aVar, "produceSharedPreferences");
        m.e(set, "keysToMigrate");
        if (set != MIGRATE_ALL_KEYS) {
            return new SharedPreferencesMigration<>(aVar, set, getShouldRunMigration(set), getMigrationFunction());
        }
        return new SharedPreferencesMigration<>(aVar, (Set) null, getShouldRunMigration(set), getMigrationFunction(), 2, (C2103g) null);
    }

    public static /* synthetic */ SharedPreferencesMigration SharedPreferencesMigration$default(Context context, String str, Set<String> set, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            set = MIGRATE_ALL_KEYS;
        }
        return SharedPreferencesMigration(context, str, set);
    }

    public static final SharedPreferencesMigration<Preferences> SharedPreferencesMigration(Context context, String str, Set<String> set) {
        m.e(context, "context");
        m.e(str, "sharedPreferencesName");
        m.e(set, "keysToMigrate");
        if (set == MIGRATE_ALL_KEYS) {
            return new SharedPreferencesMigration<>(context, str, (Set) null, getShouldRunMigration(set), getMigrationFunction(), 4, (C2103g) null);
        }
        return new SharedPreferencesMigration<>(context, str, set, getShouldRunMigration(set), getMigrationFunction());
    }
}
