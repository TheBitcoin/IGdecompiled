package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class F implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f7291b;

    public /* synthetic */ F(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f7290a = preferencesActivity;
        this.f7291b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.s4(this.f7290a, this.f7291b, view);
    }
}
