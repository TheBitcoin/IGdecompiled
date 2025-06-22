package J1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

public final /* synthetic */ class V implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f6891a;

    public /* synthetic */ V(GdprPrivacySettings gdprPrivacySettings) {
        this.f6891a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.q3(this.f6891a, compoundButton, z4);
    }
}
