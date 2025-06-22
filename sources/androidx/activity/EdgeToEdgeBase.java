package androidx.activity;

import android.view.View;
import android.view.Window;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

final class EdgeToEdgeBase implements EdgeToEdgeImpl {
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z4, boolean z5) {
        m.e(systemBarStyle, "statusBarStyle");
        m.e(systemBarStyle2, "navigationBarStyle");
        m.e(window, "window");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
    }
}
