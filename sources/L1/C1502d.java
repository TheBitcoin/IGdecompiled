package L1;

import P1.a;
import android.widget.CompoundButton;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: L1.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1502d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f7321a;

    public /* synthetic */ C1502d(a aVar) {
        this.f7321a = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        AdvancedPreferencesActivity.W3(this.f7321a, compoundButton, z4);
    }
}
