package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.RollbackActivity;

public final /* synthetic */ class E4 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RollbackActivity f6759a;

    public /* synthetic */ E4(RollbackActivity rollbackActivity) {
        this.f6759a = rollbackActivity;
    }

    public final void onActivityResult(Object obj) {
        RollbackActivity.R4(this.f6759a, (ActivityResult) obj);
    }
}
