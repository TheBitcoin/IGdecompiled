package androidx.preference;

import e3.a;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, a {
    final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.getPreferenceCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i4 = this.index - 1;
        this.index = i4;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i4));
    }

    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i4 = this.index;
        this.index = i4 + 1;
        Preference preference = preferenceGroup.getPreference(i4);
        m.d(preference, "getPreference(index++)");
        return preference;
    }
}
