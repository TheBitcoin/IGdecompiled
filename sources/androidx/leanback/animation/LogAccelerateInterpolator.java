package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LogAccelerateInterpolator implements TimeInterpolator {
    int mBase;
    int mDrift;
    final float mLogScale;

    public LogAccelerateInterpolator(int i4, int i5) {
        this.mBase = i4;
        this.mDrift = i5;
        this.mLogScale = 1.0f / computeLog(1.0f, i4, i5);
    }

    static float computeLog(float f4, int i4, int i5) {
        return ((float) (-Math.pow((double) i4, (double) (-f4)))) + 1.0f + (((float) i5) * f4);
    }

    public float getInterpolation(float f4) {
        return 1.0f - (computeLog(1.0f - f4, this.mBase, this.mDrift) * this.mLogScale);
    }
}
