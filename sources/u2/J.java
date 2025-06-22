package u2;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import kotlin.jvm.internal.m;

public final class J {
    public final boolean a(MainActivity mainActivity) {
        m.e(mainActivity, "activity");
        if (!UptodownApp.f17422D.S(mainActivity)) {
            return false;
        }
        mainActivity.startActivity(new Intent(mainActivity, TvMainActivity.class));
        return true;
    }
}
