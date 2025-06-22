package J1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

public final /* synthetic */ class S implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f6869a;

    public /* synthetic */ S(GdprPrivacySettings gdprPrivacySettings) {
        this.f6869a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.n3(this.f6869a, compoundButton, z4);
    }
}
