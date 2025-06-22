package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class Q0 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f6859a;

    public /* synthetic */ Q0(MainActivity mainActivity) {
        this.f6859a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.J6(this.f6859a, (ActivityResult) obj);
    }
}
