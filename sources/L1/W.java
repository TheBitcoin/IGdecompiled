package L1;

import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class W implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7311a;

    public /* synthetic */ W(PreferencesActivity preferencesActivity) {
        this.f7311a = preferencesActivity;
    }

    public final void onActivityResult(Object obj) {
        PreferencesActivity.Q4(this.f7311a, ((Boolean) obj).booleanValue());
    }
}
