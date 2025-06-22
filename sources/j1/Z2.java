package J1;

import android.widget.CompoundButton;
import com.uptodown.activities.OldVersionsActivity;

public final /* synthetic */ class Z2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OldVersionsActivity f6934a;

    public /* synthetic */ Z2(OldVersionsActivity oldVersionsActivity) {
        this.f6934a = oldVersionsActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        OldVersionsActivity.y3(this.f6934a, compoundButton, z4);
    }
}
