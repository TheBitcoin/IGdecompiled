package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserEditProfileActivity;

public final /* synthetic */ class L5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserEditProfileActivity f6830a;

    public /* synthetic */ L5(UserEditProfileActivity userEditProfileActivity) {
        this.f6830a = userEditProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        UserEditProfileActivity.r3(this.f6830a, (ActivityResult) obj);
    }
}
