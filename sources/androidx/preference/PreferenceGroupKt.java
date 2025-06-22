package androidx.preference;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import d3.l;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import l3.e;

public final class PreferenceGroupKt {
    public static final boolean contains(PreferenceGroup preferenceGroup, Preference preference) {
        m.e(preferenceGroup, "<this>");
        m.e(preference, "preference");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i4 = 0;
        while (i4 < preferenceCount) {
            int i5 = i4 + 1;
            if (m.a(preferenceGroup.getPreference(i4), preference)) {
                return true;
            }
            i4 = i5;
        }
        return false;
    }

    public static final void forEach(PreferenceGroup preferenceGroup, l lVar) {
        m.e(preferenceGroup, "<this>");
        m.e(lVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i4 = 0; i4 < preferenceCount; i4++) {
            lVar.invoke(get(preferenceGroup, i4));
        }
    }

    public static final void forEachIndexed(PreferenceGroup preferenceGroup, p pVar) {
        m.e(preferenceGroup, "<this>");
        m.e(pVar, "action");
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i4 = 0; i4 < preferenceCount; i4++) {
            pVar.invoke(Integer.valueOf(i4), get(preferenceGroup, i4));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup preferenceGroup, CharSequence charSequence) {
        m.e(preferenceGroup, "<this>");
        m.e(charSequence, LeanbackPreferenceDialogFragment.ARG_KEY);
        return preferenceGroup.findPreference(charSequence);
    }

    public static final e getChildren(PreferenceGroup preferenceGroup) {
        m.e(preferenceGroup, "<this>");
        return new PreferenceGroupKt$children$1(preferenceGroup);
    }

    public static final int getSize(PreferenceGroup preferenceGroup) {
        m.e(preferenceGroup, "<this>");
        return preferenceGroup.getPreferenceCount();
    }

    public static final boolean isEmpty(PreferenceGroup preferenceGroup) {
        m.e(preferenceGroup, "<this>");
        if (preferenceGroup.getPreferenceCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(PreferenceGroup preferenceGroup) {
        m.e(preferenceGroup, "<this>");
        if (preferenceGroup.getPreferenceCount() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<Preference> iterator(PreferenceGroup preferenceGroup) {
        m.e(preferenceGroup, "<this>");
        return new PreferenceGroupKt$iterator$1(preferenceGroup);
    }

    public static final void minusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        m.e(preferenceGroup, "<this>");
        m.e(preference, "preference");
        preferenceGroup.removePreference(preference);
    }

    public static final void plusAssign(PreferenceGroup preferenceGroup, Preference preference) {
        m.e(preferenceGroup, "<this>");
        m.e(preference, "preference");
        preferenceGroup.addPreference(preference);
    }

    public static final Preference get(PreferenceGroup preferenceGroup, int i4) {
        m.e(preferenceGroup, "<this>");
        Preference preference = preferenceGroup.getPreference(i4);
        m.d(preference, "getPreference(index)");
        return preference;
    }
}
