package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f4, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f4;
            rectF.left += abs;
            rectF.right -= abs;
        }

        public FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float f11 = f8;
            float f12 = f10;
            float lerp = TransitionUtils.lerp(f11, f12, f5, f6, f4, true);
            float f13 = lerp / f11;
            float f14 = lerp / f12;
            return new FitModeResult(f13, f14, f7 * f13, lerp, f9 * f14, lerp);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartWidth > fitModeResult.currentEndWidth) {
                return true;
            }
            return false;
        }
    };
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f4, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f4;
        }

        public FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float f11 = f7;
            float f12 = f9;
            float lerp = TransitionUtils.lerp(f11, f12, f5, f6, f4, true);
            float f13 = lerp / f11;
            float f14 = lerp / f12;
            return new FitModeResult(f13, f14, lerp, f8 * f13, lerp, f10 * f14);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartHeight > fitModeResult.currentEndHeight) {
                return true;
            }
            return false;
        }
    };

    private FitModeEvaluators() {
    }

    static FitModeEvaluator get(int i4, boolean z4, RectF rectF, RectF rectF2) {
        if (i4 != 0) {
            if (i4 == 1) {
                return WIDTH;
            }
            if (i4 == 2) {
                return HEIGHT;
            }
            throw new IllegalArgumentException("Invalid fit mode: " + i4);
        } else if (shouldAutoFitToWidth(z4, rectF, rectF2)) {
            return WIDTH;
        } else {
            return HEIGHT;
        }
    }

    private static boolean shouldAutoFitToWidth(boolean z4, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f4 = (height2 * width) / width2;
        float f5 = (width2 * height) / width;
        if (z4) {
            if (f4 >= height) {
                return true;
            }
            return false;
        } else if (f5 >= height2) {
            return true;
        } else {
            return false;
        }
    }
}
