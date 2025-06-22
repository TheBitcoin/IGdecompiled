package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class Q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f7306b;

    public /* synthetic */ Q(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f7305a = preferencesActivity;
        this.f7306b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.I4(this.f7305a, this.f7306b, view);
    }
}
