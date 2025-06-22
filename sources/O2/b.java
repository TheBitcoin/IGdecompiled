package o2;

import androidx.preference.Preference;
import com.uptodown.tv.preferences.TvPrivacyPreferences;

public final /* synthetic */ class b implements Preference.OnPreferenceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvPrivacyPreferences.a f21428a;

    public /* synthetic */ b(TvPrivacyPreferences.a aVar) {
        this.f21428a = aVar;
    }

    public final boolean onPreferenceClick(Preference preference) {
        return TvPrivacyPreferences.a.k(this.f21428a, preference);
    }
}
