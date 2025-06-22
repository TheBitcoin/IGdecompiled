package b0;

import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1133a;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 23) {
            i4 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            i4 = 0;
        }
        f1133a = i4;
    }
}
