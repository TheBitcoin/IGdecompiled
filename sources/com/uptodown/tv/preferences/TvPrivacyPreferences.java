package com.uptodown.tv.preferences;

import L1.C1522y;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.m;
import o2.C2188a;
import o2.b;
import o2.c;
import u2.q;

public final class TvPrivacyPreferences extends C1522y {

    public static final class a extends PreferenceFragmentCompat {
        /* access modifiers changed from: private */
        public static final boolean j(a aVar, Preference preference) {
            m.e(preference, "it");
            q qVar = new q();
            FragmentActivity requireActivity = aVar.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            String string = aVar.getString(R.string.url_contact);
            m.d(string, "getString(...)");
            q.r(qVar, requireActivity, string, (String) null, 4, (Object) null);
            return true;
        }

        /* access modifiers changed from: private */
        public static final boolean k(a aVar, Preference preference) {
            m.e(preference, "it");
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = aVar.requireContext();
            m.d(requireContext, "requireContext(...)");
            aVar2.G0(requireContext, true);
            Context requireContext2 = aVar.requireContext();
            m.d(requireContext2, "requireContext(...)");
            aVar2.r0(requireContext2, true);
            Context requireContext3 = aVar.requireContext();
            m.d(requireContext3, "requireContext(...)");
            aVar2.x0(requireContext3, true);
            Context requireContext4 = aVar.requireContext();
            m.d(requireContext4, "requireContext(...)");
            aVar2.j1(requireContext4, true);
            aVar.requireActivity().finish();
            return true;
        }

        /* access modifiers changed from: private */
        public static final boolean l(a aVar, Preference preference) {
            m.e(preference, "it");
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = aVar.requireContext();
            m.d(requireContext, "requireContext(...)");
            aVar2.G0(requireContext, false);
            Context requireContext2 = aVar.requireContext();
            m.d(requireContext2, "requireContext(...)");
            aVar2.r0(requireContext2, false);
            Context requireContext3 = aVar.requireContext();
            m.d(requireContext3, "requireContext(...)");
            aVar2.x0(requireContext3, false);
            Context requireContext4 = aVar.requireContext();
            m.d(requireContext4, "requireContext(...)");
            aVar2.j1(requireContext4, false);
            aVar.requireActivity().finish();
            return true;
        }

        public void onCreatePreferences(Bundle bundle, String str) {
            getPreferenceManager().setSharedPreferencesName("SettingsPreferences");
            addPreferencesFromResource(R.xml.tv_privacy_preferences);
            Preference findPreference = findPreference("right_to_be_forgotten");
            m.b(findPreference);
            findPreference.setOnPreferenceClickListener(new C2188a(this));
            Preference findPreference2 = findPreference("privacy_accept_all");
            m.b(findPreference2);
            findPreference2.setOnPreferenceClickListener(new b(this));
            Preference findPreference3 = findPreference("privacy_decline_all");
            m.b(findPreference3);
            findPreference3.setOnPreferenceClickListener(new c(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getSupportFragmentManager().beginTransaction().replace(16908290, new a()).commit();
    }
}
