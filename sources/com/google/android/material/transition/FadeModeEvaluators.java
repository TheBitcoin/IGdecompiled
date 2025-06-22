package com.google.android.material.transition;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), 255);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            float f8 = ((f6 - f5) * f7) + f5;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f8, f4), TransitionUtils.lerp(0, 255, f8, f6, f4));
        }
    };

    private FadeModeEvaluators() {
    }

    static FadeModeEvaluator get(int i4, boolean z4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return CROSS;
                }
                if (i4 == 3) {
                    return THROUGH;
                }
                throw new IllegalArgumentException("Invalid fade mode: " + i4);
            } else if (z4) {
                return OUT;
            } else {
                return IN;
            }
        } else if (z4) {
            return IN;
        } else {
            return OUT;
        }
    }
}
