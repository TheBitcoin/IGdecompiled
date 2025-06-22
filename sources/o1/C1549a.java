package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;

/* renamed from: O1.a  reason: case insensitive filesystem */
public final /* synthetic */ class C1549a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmationIntentWrapperActivity f7877a;

    public /* synthetic */ C1549a(ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity) {
        this.f7877a = confirmationIntentWrapperActivity;
    }

    public final void onActivityResult(Object obj) {
        ConfirmationIntentWrapperActivity.l(this.f7877a, (ActivityResult) obj);
    }
}
