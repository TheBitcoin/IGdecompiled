package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i4, float f4, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i4, f4, displayMetrics);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i4, float f4, @NonNull DisplayMetrics displayMetrics) {
        float f5;
        float f6;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i4, f4, displayMetrics);
        }
        if (i4 == 0) {
            return f4;
        }
        if (i4 == 1) {
            float f7 = displayMetrics.density;
            if (f7 == 0.0f) {
                return 0.0f;
            }
            return f4 / f7;
        } else if (i4 != 2) {
            if (i4 == 3) {
                float f8 = displayMetrics.xdpi;
                if (f8 == 0.0f) {
                    return 0.0f;
                }
                f5 = f4 / f8;
                f6 = INCHES_PER_PT;
            } else if (i4 == 4) {
                float f9 = displayMetrics.xdpi;
                if (f9 == 0.0f) {
                    return 0.0f;
                }
                return f4 / f9;
            } else if (i4 == 5) {
                float f10 = displayMetrics.xdpi;
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                f5 = f4 / f10;
                f6 = INCHES_PER_MM;
            } else {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i4);
            }
            return f5 / f6;
        } else {
            float f11 = displayMetrics.scaledDensity;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            return f4 / f11;
        }
    }

    public static float dpToPx(float f4, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f4, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i4) {
        return i4 & 15;
    }

    public static float pxToDp(float f4, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f4, displayMetrics);
    }

    public static float pxToSp(float f4, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f4, displayMetrics);
    }

    public static float spToPx(float f4, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f4, displayMetrics);
    }
}
