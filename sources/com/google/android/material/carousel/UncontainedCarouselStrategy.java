package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.KeylineState;

public final class UncontainedCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD = 0.85f;

    private float calculateMediumChildSize(float f4, float f5, float f6) {
        float max = Math.max(1.5f * f6, f4);
        float f7 = MEDIUM_LARGE_ITEM_PERCENTAGE_THRESHOLD * f5;
        if (max > f7) {
            max = Math.max(f7, f6 * 1.2f);
        }
        return Math.min(f5, max);
    }

    private KeylineState createCenterAlignedKeylineState(float f4, float f5, float f6, int i4, float f7, float f8, float f9) {
        float f10 = f5;
        float f11 = f6;
        float f12 = f7;
        float min = Math.min(f8, f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, f11, f10);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f12, f11, f10);
        float f13 = f12 / 2.0f;
        float f14 = (f9 + 0.0f) - f13;
        float f15 = f14 + f13;
        float f16 = min / 2.0f;
        float f17 = (((float) i4) * f11) + f15;
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(f11, f4).addAnchorKeyline((f14 - f13) - f16, childMaskPercentage, min).addKeyline(f14, childMaskPercentage2, f12, false).addKeylineRange((f11 / 2.0f) + f15, 0.0f, f11, i4, true);
        addKeylineRange.addKeyline(f13 + f17, childMaskPercentage2, f12, false);
        addKeylineRange.addAnchorKeyline(f17 + f12 + f16, childMaskPercentage, min);
        return addKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f4, float f5, float f6, int i4, float f7, int i5, float f8) {
        float f9 = f4;
        float f10 = f6;
        float f11 = f7;
        float min = Math.min(f8, f10);
        float max = Math.max(min, 0.5f * f11);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(max, f10, f9);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(min, f10, f9);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f11, f10, f9);
        int i6 = i4;
        float f12 = (((float) i6) * f10) + 0.0f;
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(f10, f5).addAnchorKeyline(0.0f - (max / 2.0f), childMaskPercentage, max).addKeylineRange(f10 / 2.0f, 0.0f, f10, i6, true);
        if (i5 > 0) {
            float f13 = (f11 / 2.0f) + f12;
            f12 += f11;
            addKeylineRange.addKeyline(f13, childMaskPercentage3, f11, false);
        }
        addKeylineRange.addAnchorKeyline(f12 + (CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f), childMaskPercentage2, min);
        return addKeylineRange.build();
    }

    /* access modifiers changed from: package-private */
    public boolean isContained() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight;
        int i4;
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        float f4 = (float) containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f5 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f6 = measuredHeight;
        float f7 = f5;
        float f8 = f6 + f7;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f7;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f7;
        int max = Math.max(1, (int) Math.floor((double) (f4 / f8)));
        float f9 = f4 - (((float) max) * f8);
        if (carousel.getCarouselAlignment() == 1) {
            float f10 = f9 / 2.0f;
            KeylineState createCenterAlignedKeylineState = createCenterAlignedKeylineState(f4, f7, f8, max, Math.max(Math.min(3.0f * f10, f8), getSmallItemSizeMin() + f7), extraSmallSize2, f10);
            return createCenterAlignedKeylineState;
        }
        float f11 = f8;
        float f12 = f4;
        if (f9 > 0.0f) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        float calculateMediumChildSize = calculateMediumChildSize(extraSmallSize, f11, f9);
        float f13 = extraSmallSize2;
        return createLeftAlignedKeylineState(view.getContext(), f7, f12, f11, max, calculateMediumChildSize, i4, f13);
    }
}
