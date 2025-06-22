package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.AppDetailActivity;

/* renamed from: J1.b  reason: case insensitive filesystem */
public final /* synthetic */ class C1318b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f6951a;

    public /* synthetic */ C1318b(AppDetailActivity appDetailActivity) {
        this.f6951a = appDetailActivity;
    }

    public final void onActivityResult(Object obj) {
        AppDetailActivity.o3(this.f6951a, (ActivityResult) obj);
    }
}
