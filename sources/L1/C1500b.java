package L1;

import P1.a;
import android.widget.CompoundButton;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: L1.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1500b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f7317a;

    public /* synthetic */ C1500b(a aVar) {
        this.f7317a = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        AdvancedPreferencesActivity.U3(this.f7317a, compoundButton, z4);
    }
}
