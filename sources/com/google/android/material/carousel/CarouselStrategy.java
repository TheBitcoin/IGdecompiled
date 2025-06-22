package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

public abstract class CarouselStrategy {
    private float smallSizeMax;
    private float smallSizeMin;

    static int[] doubleCounts(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr2[i4] = iArr[i4] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    static float getChildMaskPercentage(float f4, float f5, float f6) {
        return 1.0f - ((f4 - f6) / (f5 - f6));
    }

    public float getSmallItemSizeMax() {
        return this.smallSizeMax;
    }

    public float getSmallItemSizeMin() {
        return this.smallSizeMin;
    }

    /* access modifiers changed from: package-private */
    public void initialize(Context context) {
        float f4 = this.smallSizeMin;
        if (f4 <= 0.0f) {
            f4 = CarouselStrategyHelper.getSmallSizeMin(context);
        }
        this.smallSizeMin = f4;
        float f5 = this.smallSizeMax;
        if (f5 <= 0.0f) {
            f5 = CarouselStrategyHelper.getSmallSizeMax(context);
        }
        this.smallSizeMax = f5;
    }

    /* access modifiers changed from: package-private */
    public boolean isContained() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view);

    public void setSmallItemSizeMax(float f4) {
        this.smallSizeMax = f4;
    }

    public void setSmallItemSizeMin(float f4) {
        this.smallSizeMin = f4;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRefreshKeylineState(Carousel carousel, int i4) {
        return false;
    }
}
