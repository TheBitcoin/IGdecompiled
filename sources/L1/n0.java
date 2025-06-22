package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class n0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7348a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f7349b;

    public /* synthetic */ n0(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f7348a = preferencesActivity;
        this.f7349b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.h4(this.f7348a, this.f7349b, view);
    }
}
