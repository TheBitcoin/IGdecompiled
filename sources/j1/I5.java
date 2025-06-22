package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserDevicesActivity;

public final /* synthetic */ class I5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f6796a;

    public /* synthetic */ I5(UserDevicesActivity userDevicesActivity) {
        this.f6796a = userDevicesActivity;
    }

    public final void onActivityResult(Object obj) {
        UserDevicesActivity.o3(this.f6796a, (ActivityResult) obj);
    }
}
