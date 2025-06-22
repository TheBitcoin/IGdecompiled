package L1;

import android.view.View;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: L1.p  reason: case insensitive filesystem */
public final /* synthetic */ class C1514p implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdvancedPreferencesActivity f7352a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7353b;

    public /* synthetic */ C1514p(AdvancedPreferencesActivity advancedPreferencesActivity, String str) {
        this.f7352a = advancedPreferencesActivity;
        this.f7353b = str;
    }

    public final boolean onLongClick(View view) {
        return AdvancedPreferencesActivity.C3(this.f7352a, this.f7353b, view);
    }
}
