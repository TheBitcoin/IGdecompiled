package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserEditProfileActivity;

public final /* synthetic */ class K5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserEditProfileActivity f6822a;

    public /* synthetic */ K5(UserEditProfileActivity userEditProfileActivity) {
        this.f6822a = userEditProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        UserEditProfileActivity.q3(this.f6822a, (ActivityResult) obj);
    }
}
