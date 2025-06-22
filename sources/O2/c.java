package o2;

import androidx.preference.Preference;
import com.uptodown.tv.preferences.TvPrivacyPreferences;

public final /* synthetic */ class c implements Preference.OnPreferenceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvPrivacyPreferences.a f21429a;

    public /* synthetic */ c(TvPrivacyPreferences.a aVar) {
        this.f21429a = aVar;
    }

    public final boolean onPreferenceClick(Preference preference) {
        return TvPrivacyPreferences.a.l(this.f21429a, preference);
    }
}
