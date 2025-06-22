package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class R0 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6865a;

    public /* synthetic */ R0(MainActivity mainActivity) {
        this.f6865a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.X5(this.f6865a, (ActivityResult) obj);
    }
}
