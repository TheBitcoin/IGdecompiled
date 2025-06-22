package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f4) {
        if (f4 >= 1.0f) {
            return 1.0f;
        }
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f4), fArr.length - 2);
        float f5 = this.mStepSize;
        float f6 = (f4 - (((float) min) * f5)) / f5;
        float[] fArr2 = this.mValues;
        float f7 = fArr2[min];
        return f7 + (f6 * (fArr2[min + 1] - f7));
    }
}
