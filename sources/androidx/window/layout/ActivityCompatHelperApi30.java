package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.m;

@RequiresApi(30)
public final class ActivityCompatHelperApi30 {
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect currentWindowBounds(Activity activity) {
        m.e(activity, "activity");
        Rect a5 = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        m.d(a5, "activity.windowManager.currentWindowMetrics.bounds");
        return a5;
    }

    public final Rect maximumWindowBounds(Activity activity) {
        m.e(activity, "activity");
        Rect a5 = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        m.d(a5, "activity.windowManager.maximumWindowMetrics.bounds");
        return a5;
    }
}
