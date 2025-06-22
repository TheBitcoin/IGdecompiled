package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.AppDetailActivity;

/* renamed from: J1.c  reason: case insensitive filesystem */
public final /* synthetic */ class C1325c implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f6973a;

    public /* synthetic */ C1325c(AppDetailActivity appDetailActivity) {
        this.f6973a = appDetailActivity;
    }

    public final void onActivityResult(Object obj) {
        AppDetailActivity.i3(this.f6973a, (ActivityResult) obj);
    }
}
