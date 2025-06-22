package J1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

public final /* synthetic */ class T implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f6875a;

    public /* synthetic */ T(GdprPrivacySettings gdprPrivacySettings) {
        this.f6875a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.o3(this.f6875a, compoundButton, z4);
    }
}
