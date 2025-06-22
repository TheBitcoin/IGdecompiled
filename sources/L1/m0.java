package L1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class m0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f7345a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f7346b;

    public /* synthetic */ m0(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f7345a = preferencesActivity;
        this.f7346b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.f4(this.f7345a, this.f7346b, view);
    }
}
