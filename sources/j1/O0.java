package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class O0 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6844a;

    public /* synthetic */ O0(MainActivity mainActivity) {
        this.f6844a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.F5(this.f6844a, (ActivityResult) obj);
    }
}
