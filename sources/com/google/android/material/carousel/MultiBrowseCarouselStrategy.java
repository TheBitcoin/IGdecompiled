package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] SMALL_COUNTS = {1};
    private int keylineCount = 0;

    /* access modifiers changed from: package-private */
    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i4) {
        boolean z4;
        int itemCount = arrangement.getItemCount() - i4;
        if (itemCount <= 0 || (arrangement.smallCount <= 0 && arrangement.mediumCount <= 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        while (itemCount > 0) {
            int i5 = arrangement.smallCount;
            if (i5 > 0) {
                arrangement.smallCount = i5 - 1;
            } else {
                int i6 = arrangement.mediumCount;
                if (i6 > 1) {
                    arrangement.mediumCount = i6 - 1;
                }
            }
            itemCount--;
        }
        return z4;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        float containerHeight = (float) carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = (float) carousel.getContainerWidth();
        }
        float f4 = containerHeight;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f5 = (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        float measuredHeight = (float) view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f5 = (float) (layoutParams.leftMargin + layoutParams.rightMargin);
            measuredHeight = (float) view.getMeasuredWidth();
        }
        float f6 = f5;
        float smallItemSizeMin = getSmallItemSizeMin() + f6;
        float max = Math.max(getSmallItemSizeMax() + f6, smallItemSizeMin);
        float min = Math.min(measuredHeight + f6, f4);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f6, smallItemSizeMin + f6, max + f6);
        float f7 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        if (f4 < 2.0f * smallItemSizeMin) {
            iArr = new int[]{0};
        }
        int[] iArr2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArr = CarouselStrategy.doubleCounts(iArr);
            iArr2 = CarouselStrategy.doubleCounts(iArr2);
        }
        int[] iArr3 = iArr2;
        float f8 = f7;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr3;
        int ceil = (int) Math.ceil((double) (f4 / min));
        int max2 = (ceil - ((int) Math.max(1.0d, Math.floor((double) (((f4 - (((float) CarouselStrategyHelper.maxValue(iArr5)) * f8)) - (((float) CarouselStrategyHelper.maxValue(iArr4)) * max)) / min))))) + 1;
        int[] iArr6 = new int[max2];
        for (int i4 = 0; i4 < max2; i4++) {
            iArr6[i4] = ceil - i4;
        }
        float f9 = clamp;
        float f10 = smallItemSizeMin;
        float f11 = f9;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f4, f11, f10, max, iArr4, f8, iArr5, min, iArr6);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount())) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f4, f11, f10, max, new int[]{findLowestCostArrangement.smallCount}, f8, new int[]{findLowestCostArrangement.mediumCount}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f6, f4, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRefreshKeylineState(Carousel carousel, int i4) {
        if (i4 < this.keylineCount && carousel.getItemCount() >= this.keylineCount) {
            return true;
        }
        if (i4 < this.keylineCount || carousel.getItemCount() >= this.keylineCount) {
            return false;
        }
        return true;
    }
}
