package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.AnimationUtils;

class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static final float FADE_THRESHOLD = 0.5f;

    FadeTabIndicatorInterpolator() {
    }

    /* access modifiers changed from: package-private */
    public void updateIndicatorForOffset(TabLayout tabLayout, View view, View view2, float f4, @NonNull Drawable drawable) {
        float f5;
        int i4 = (f4 > 0.5f ? 1 : (f4 == 0.5f ? 0 : -1));
        if (i4 >= 0) {
            view = view2;
        }
        RectF calculateIndicatorWidthForTab = TabIndicatorInterpolator.calculateIndicatorWidthForTab(tabLayout, view);
        if (i4 < 0) {
            f5 = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, 0.5f, f4);
        } else {
            f5 = AnimationUtils.lerp(0.0f, 1.0f, 0.5f, 1.0f, f4);
        }
        drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
        drawable.setAlpha((int) (f5 * 255.0f));
    }
}
