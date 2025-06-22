package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity
public final class Preference {
    @ColumnInfo(name = "key")
    @PrimaryKey
    private final String key;
    @ColumnInfo(name = "long_value")
    private final Long value;

    public Preference(String str, Long l4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        this.key = str;
        this.value = l4;
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = preference.key;
        }
        if ((i4 & 2) != 0) {
            l4 = preference.value;
        }
        return preference.copy(str, l4);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String str, Long l4) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return new Preference(str, l4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return m.a(this.key, preference.key) && m.a(this.value, preference.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l4 = this.value;
        return hashCode + (l4 == null ? 0 : l4.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(String str, boolean z4) {
        this(str, Long.valueOf(z4 ? 1 : 0));
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
    }
}
