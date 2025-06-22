package J1;

import android.widget.RadioGroup;
import com.uptodown.activities.UserDeviceDetailsActivity;
import g2.V;

/* renamed from: J1.w5  reason: case insensitive filesystem */
public final /* synthetic */ class C1470w5 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f7188a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ V f7189b;

    public /* synthetic */ C1470w5(UserDeviceDetailsActivity userDeviceDetailsActivity, V v4) {
        this.f7188a = userDeviceDetailsActivity;
        this.f7189b = v4;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i4) {
        UserDeviceDetailsActivity.v3(this.f7188a, this.f7189b, radioGroup, i4);
    }
}
