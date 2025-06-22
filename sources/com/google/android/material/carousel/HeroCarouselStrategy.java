package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public class HeroCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {0, 1};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int i4;
        int[] iArr;
        int[] iArr2;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f4 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredWidth = (float) (view.getMeasuredWidth() * 2);
        if (carousel.isHorizontal()) {
            f4 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredWidth = (float) (view.getMeasuredHeight() * 2);
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f4;
        float max = Math.max(getSmallItemSizeMax() + f4, smallItemSizeMin);
        float f5 = (float) containerHeight;
        float min = Math.min(measuredWidth + f4, f5);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f4, smallItemSizeMin + f4, max + f4);
        float f6 = (min + clamp) / 2.0f;
        int[] iArr3 = SMALL_COUNTS;
        int i5 = 0;
        int[] iArr4 = f5 < 2.0f * smallItemSizeMin ? new int[]{0} : iArr3;
        int max2 = (int) Math.max(1.0d, Math.floor((double) ((f5 - (((float) CarouselStrategyHelper.maxValue(iArr3)) * max)) / min)));
        int ceil = (((int) Math.ceil((double) (f5 / min))) - max2) + 1;
        int[] iArr5 = new int[ceil];
        for (int i6 = 0; i6 < ceil; i6++) {
            iArr5[i6] = max2 + i6;
        }
        if (carousel.getCarouselAlignment() == 1) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            iArr = CarouselStrategy.doubleCounts(iArr4);
        } else {
            iArr = iArr4;
        }
        if (i4 != 0) {
            iArr2 = CarouselStrategy.doubleCounts(MEDIUM_COUNTS);
        } else {
            iArr2 = MEDIUM_COUNTS;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f5, clamp, smallItemSizeMin, max, iArr, f6, iArr2, min, iArr5);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f5, clamp, smallItemSizeMin, max, iArr4, f6, MEDIUM_COUNTS, min, iArr5);
        } else {
            i5 = i4;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f4, f5, findLowestCostArrangement, i5);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i4) {
        if (carousel.getCarouselAlignment() != 1) {
            return false;
        }
        if ((i4 >= this.keylineCount || carousel.getItemCount() < this.keylineCount) && (i4 < this.keylineCount || carousel.getItemCount() >= this.keylineCount)) {
            return false;
        }
        return true;
    }
}
