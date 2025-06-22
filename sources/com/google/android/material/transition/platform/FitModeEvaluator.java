package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f4, FitModeResult fitModeResult);

    FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
