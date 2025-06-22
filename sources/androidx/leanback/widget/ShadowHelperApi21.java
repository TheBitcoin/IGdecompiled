package androidx.leanback.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ShadowHelperApi21 {
    static final ViewOutlineProvider sOutlineProvider = new ViewOutlineProvider() {
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(1.0f);
        }
    };

    static class ShadowImpl {
        float mFocusedZ;
        float mNormalZ;
        View mShadowContainer;

        ShadowImpl() {
        }
    }

    private ShadowHelperApi21() {
    }

    public static Object addDynamicShadow(View view, float f4, float f5, int i4) {
        if (i4 > 0) {
            RoundedRectHelperApi21.setClipToRoundedOutline(view, true, i4);
        } else {
            view.setOutlineProvider(sOutlineProvider);
        }
        ShadowImpl shadowImpl = new ShadowImpl();
        shadowImpl.mShadowContainer = view;
        shadowImpl.mNormalZ = f4;
        shadowImpl.mFocusedZ = f5;
        view.setZ(f4);
        return shadowImpl;
    }

    public static void setShadowFocusLevel(Object obj, float f4) {
        ShadowImpl shadowImpl = (ShadowImpl) obj;
        View view = shadowImpl.mShadowContainer;
        float f5 = shadowImpl.mNormalZ;
        view.setZ(f5 + (f4 * (shadowImpl.mFocusedZ - f5)));
    }
}
