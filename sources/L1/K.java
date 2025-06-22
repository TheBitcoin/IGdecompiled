package L1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class K implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7296a;

    public /* synthetic */ K(PreferencesActivity preferencesActivity) {
        this.f7296a = preferencesActivity;
    }

    public final void onActivityResult(Object obj) {
        PreferencesActivity.b4(this.f7296a, (ActivityResult) obj);
    }
}
