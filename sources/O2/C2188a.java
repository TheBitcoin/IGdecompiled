package o2;

import androidx.preference.Preference;
import com.uptodown.tv.preferences.TvPrivacyPreferences;

/* renamed from: o2.a  reason: case insensitive filesystem */
public final /* synthetic */ class C2188a implements Preference.OnPreferenceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvPrivacyPreferences.a f21427a;

    public /* synthetic */ C2188a(TvPrivacyPreferences.a aVar) {
        this.f21427a = aVar;
    }

    public final boolean onPreferenceClick(Preference preference) {
        return TvPrivacyPreferences.a.j(this.f21427a, preference);
    }
}
