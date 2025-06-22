package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {
    private static String sTag = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f4, float f5, int i4, int i5, float[] fArr) {
        int i6 = i4;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = (f4 - 0.5f) * 2.0f;
        float f9 = (f5 - 0.5f) * 2.0f;
        float f10 = f6 + this.mDTranslateX;
        float f11 = f7 + this.mDTranslateY;
        float f12 = f10 + (this.mDScaleX * f8);
        float f13 = f11 + (this.mDScaleY * f9);
        float radians = (float) Math.toRadians((double) this.mDRotate);
        double radians2 = (double) ((float) Math.toRadians((double) this.mRotate));
        double d5 = (double) (((float) i5) * f9);
        fArr[0] = f12 + (((float) ((((double) (((float) (-i6)) * f8)) * Math.sin(radians2)) - (Math.cos(radians2) * d5))) * radians);
        fArr[1] = f13 + (radians * ((float) ((((double) (((float) i6) * f8)) * Math.cos(radians2)) - (d5 * Math.sin(radians2)))));
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f4) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f4);
            this.mRotate = splineSet.get(f4);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f4);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f4) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f4);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator != null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 != null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f4);
        }
    }
}
