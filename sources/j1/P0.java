package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class P0 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6852a;

    public /* synthetic */ P0(MainActivity mainActivity) {
        this.f6852a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.p7(this.f6852a, (ActivityResult) obj);
    }
}
