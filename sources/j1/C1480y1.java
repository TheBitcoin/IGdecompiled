package J1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: J1.y1  reason: case insensitive filesystem */
public final /* synthetic */ class C1480y1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f7217a;

    public /* synthetic */ C1480y1(MainActivity mainActivity) {
        this.f7217a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.Q6(this.f7217a, (ActivityResult) obj);
    }
}
