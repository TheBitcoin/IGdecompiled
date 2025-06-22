package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FullScreenCarouselStrategy extends CarouselStrategy {
    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float containerHeight;
        int i4;
        int i5;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
            i4 = layoutParams.leftMargin;
            i5 = layoutParams.rightMargin;
        } else {
            containerHeight = (float) carousel.getContainerHeight();
            i4 = layoutParams.topMargin;
            i5 = layoutParams.bottomMargin;
        }
        float f4 = (float) (i4 + i5);
        float f5 = containerHeight;
        return CarouselStrategyHelper.createLeftAlignedKeylineState(view.getContext(), f4, f5, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(f5 + f4, f5), 1, f5));
    }
}
