package androidx.leanback.widget;

import android.view.View;

final class ShadowHelper {
    private ShadowHelper() {
    }

    static Object addDynamicShadow(View view, float f4, float f5, int i4) {
        return ShadowHelperApi21.addDynamicShadow(view, f4, f5, i4);
    }

    static void setShadowFocusLevel(Object obj, float f4) {
        ShadowHelperApi21.setShadowFocusLevel(obj, f4);
    }

    static boolean supportsDynamicShadow() {
        return true;
    }
}
