package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

@RequiresApi(23)
final class EdgeToEdgeApi23 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z4, boolean z5) {
        m.e(systemBarStyle, "statusBarStyle");
        m.e(systemBarStyle2, "navigationBarStyle");
        m.e(window, "window");
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(systemBarStyle.getScrim$activity_release(z4));
        window.setNavigationBarColor(systemBarStyle2.getDarkScrim$activity_release());
        new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(!z4);
    }
}
