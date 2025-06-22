package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import j$.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Color compositeColors(Color color, Color color2) {
            if (Objects.equals(color.getModel(), color2.getModel())) {
                if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                    color = color.convert(color2.getColorSpace());
                }
                float[] components = color.getComponents();
                float[] components2 = color2.getComponents();
                float alpha = color.alpha();
                float alpha2 = color2.alpha() * (1.0f - alpha);
                int componentCount = color2.getComponentCount() - 1;
                float f4 = alpha + alpha2;
                components2[componentCount] = f4;
                if (f4 > 0.0f) {
                    alpha /= f4;
                    alpha2 /= f4;
                }
                for (int i4 = 0; i4 < componentCount; i4++) {
                    components2[i4] = (components[i4] * alpha) + (components2[i4] * alpha2);
                }
                return Color.valueOf(components2, color2.getColorSpace());
            }
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int i4;
        int i5;
        int i6;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float abs = (1.0f - Math.abs((f6 * 2.0f) - 1.0f)) * f5;
        float f7 = f6 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f4 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f4) / 60) {
            case 0:
                i6 = Math.round((abs + f7) * 255.0f);
                i5 = Math.round((abs2 + f7) * 255.0f);
                i4 = Math.round(f7 * 255.0f);
                break;
            case 1:
                i6 = Math.round((abs2 + f7) * 255.0f);
                i5 = Math.round((abs + f7) * 255.0f);
                i4 = Math.round(f7 * 255.0f);
                break;
            case 2:
                i6 = Math.round(f7 * 255.0f);
                i5 = Math.round((abs + f7) * 255.0f);
                i4 = Math.round((abs2 + f7) * 255.0f);
                break;
            case 3:
                i6 = Math.round(f7 * 255.0f);
                i5 = Math.round((abs2 + f7) * 255.0f);
                i4 = Math.round((abs + f7) * 255.0f);
                break;
            case 4:
                i6 = Math.round((abs2 + f7) * 255.0f);
                i5 = Math.round(f7 * 255.0f);
                i4 = Math.round((abs + f7) * 255.0f);
                break;
            case 5:
            case 6:
                i6 = Math.round((abs + f7) * 255.0f);
                i5 = Math.round(f7 * 255.0f);
                i4 = Math.round((abs2 + f7) * 255.0f);
                break;
            default:
                i4 = 0;
                i6 = 0;
                i5 = 0;
                break;
        }
        return Color.rgb(constrain(i6, 0, 255), constrain(i5, 0, 255), constrain(i4, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d5, d6, d7, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6, @FloatRange(from = -128.0d, to = 127.0d) double d7, @NonNull double[] dArr) {
        double d8;
        double d9 = (d5 + 16.0d) / 116.0d;
        double d10 = (d6 / 500.0d) + d9;
        double d11 = d9 - (d7 / 200.0d);
        double pow = Math.pow(d10, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d10 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d5 > 7.9996247999999985d) {
            d8 = Math.pow(d9, 3.0d);
        } else {
            d8 = d5 / XYZ_KAPPA;
        }
        double pow2 = Math.pow(d11, 3.0d);
        if (pow2 <= XYZ_EPSILON) {
            pow2 = ((d11 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d8 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = pow2 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 100.0d) float f6) {
        return CamColor.toColor(f4, f5, f6);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull float[] fArr) {
        float f4;
        float f5;
        float f6 = ((float) i4) / 255.0f;
        float f7 = ((float) i5) / 255.0f;
        float f8 = ((float) i6) / 255.0f;
        float max = Math.max(f6, Math.max(f7, f8));
        float min = Math.min(f6, Math.min(f7, f8));
        float f9 = max - min;
        float f10 = (max + min) / 2.0f;
        if (max == min) {
            f4 = 0.0f;
            f5 = 0.0f;
        } else {
            if (max == f6) {
                f4 = ((f7 - f8) / f9) % 6.0f;
            } else if (max == f7) {
                f4 = ((f8 - f6) / f9) + 2.0f;
            } else {
                f4 = 4.0f + ((f6 - f7) / f9);
            }
            f5 = f9 / (1.0f - Math.abs((2.0f * f10) - 1.0f));
        }
        float f11 = (f4 * 60.0f) % 360.0f;
        if (f11 < 0.0f) {
            f11 += 360.0f;
        }
        fArr[0] = constrain(f11, 0.0f, 360.0f);
        fArr[1] = constrain(f5, 0.0f, 1.0f);
        fArr[2] = constrain(f10, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
        RGBToXYZ(i4, i5, i6, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i4, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double d5;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d6 = ((double) i4) / 255.0d;
            if (d6 < 0.04045d) {
                pow = d6 / 12.92d;
            } else {
                pow = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            double d7 = ((double) i5) / 255.0d;
            if (d7 < 0.04045d) {
                pow2 = d7 / 12.92d;
            } else {
                pow2 = Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            }
            double d8 = ((double) i6) / 255.0d;
            if (d8 < 0.04045d) {
                d5 = d8 / 12.92d;
            } else {
                d5 = Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * d5)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * d5)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (d5 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d5, @FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = 0.0d, to = 108.883d) double d7) {
        double d8;
        double d9;
        double d10;
        double d11 = (((3.2406d * d5) + (-1.5372d * d6)) + (-0.4986d * d7)) / XYZ_WHITE_REFERENCE_Y;
        double d12 = (((-0.9689d * d5) + (1.8758d * d6)) + (0.0415d * d7)) / XYZ_WHITE_REFERENCE_Y;
        double d13 = (((0.0557d * d5) + (-0.204d * d6)) + (1.057d * d7)) / XYZ_WHITE_REFERENCE_Y;
        if (d11 > 0.0031308d) {
            d8 = (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d8 = d11 * 12.92d;
        }
        if (d12 > 0.0031308d) {
            d9 = (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d9 = d12 * 12.92d;
        }
        if (d13 > 0.0031308d) {
            d10 = (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d10 = 12.92d * d13;
        }
        return Color.rgb(constrain((int) Math.round(d8 * 255.0d), 0, 255), constrain((int) Math.round(d9 * 255.0d), 0, 255), constrain((int) Math.round(d10 * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d5, @FloatRange(from = 0.0d, to = 100.0d) double d6, @FloatRange(from = 0.0d, to = 108.883d) double d7, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d5 / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d6 / XYZ_WHITE_REFERENCE_Y);
            double pivotXyzComponent3 = pivotXyzComponent(d7 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i4, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((((float) Color.alpha(i4)) * f5) + (((float) Color.alpha(i5)) * f4)), (int) ((((float) Color.red(i4)) * f5) + (((float) Color.red(i5)) * f4)), (int) ((((float) Color.green(i4)) * f5) + (((float) Color.green(i5)) * f4)), (int) ((((float) Color.blue(i4)) * f5) + (((float) Color.blue(i5)) * f4)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f4, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f5 = 1.0f - f4;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f4);
            fArr3[1] = (fArr[1] * f5) + (fArr2[1] * f4);
            fArr3[2] = (fArr[2] * f5) + (fArr2[2] * f4);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d5, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d6 = 1.0d - d5;
            dArr3[0] = (dArr[0] * d6) + (dArr2[0] * d5);
            dArr3[1] = (dArr[1] * d6) + (dArr2[1] * d5);
            dArr3[2] = (dArr[2] * d6) + (dArr2[2] * d5);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i4, @ColorInt int i5) {
        if (Color.alpha(i5) == 255) {
            if (Color.alpha(i4) < 255) {
                i4 = compositeColors(i4, i5);
            }
            double calculateLuminance = calculateLuminance(i4) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i5) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i4) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i4, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i4, @ColorInt int i5, float f4) {
        int i6 = 255;
        if (Color.alpha(i5) == 255) {
            double d5 = (double) f4;
            if (calculateContrast(setAlphaComponent(i4, 255), i5) < d5) {
                return -1;
            }
            int i7 = 0;
            for (int i8 = 0; i8 <= 10 && i6 - i7 > 1; i8++) {
                int i9 = (i7 + i6) / 2;
                if (calculateContrast(setAlphaComponent(i4, i9), i5) < d5) {
                    i7 = i9;
                } else {
                    i6 = i9;
                }
            }
            return i6;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @VisibleForTesting
    static float circularInterpolate(float f4, float f5, float f6) {
        if (Math.abs(f5 - f4) > 180.0f) {
            if (f5 > f4) {
                f4 += 360.0f;
            } else {
                f5 += 360.0f;
            }
        }
        return (f4 + ((f5 - f4) * f6)) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i4, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
    }

    public static void colorToLAB(@ColorInt int i4, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i4), Color.green(i4), Color.blue(i4), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i4, @Size(3) @NonNull float[] fArr) {
        CamColor.getM3HCTfromColor(i4, fArr);
    }

    public static void colorToXYZ(@ColorInt int i4, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i4), Color.green(i4), Color.blue(i4), dArr);
    }

    private static int compositeAlpha(int i4, int i5) {
        return 255 - (((255 - i5) * (255 - i4)) / 255);
    }

    public static int compositeColors(@ColorInt int i4, @ColorInt int i5) {
        int alpha = Color.alpha(i5);
        int alpha2 = Color.alpha(i4);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i4), alpha2, Color.red(i5), alpha, compositeAlpha), compositeComponent(Color.green(i4), alpha2, Color.green(i5), alpha, compositeAlpha), compositeComponent(Color.blue(i4), alpha2, Color.blue(i5), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i4, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            return 0;
        }
        return (((i4 * 255) * i5) + ((i6 * i7) * (255 - i5))) / (i8 * 255);
    }

    private static float constrain(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : Math.min(f4, f6);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d5) {
        if (d5 > XYZ_EPSILON) {
            return Math.pow(d5, 0.3333333333333333d);
        }
        return ((d5 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        if (i5 >= 0 && i5 <= 255) {
            return (i4 & ViewCompat.MEASURED_SIZE_MASK) | (i5 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int i4, int i5, int i6) {
        return i4 < i5 ? i5 : Math.min(i4, i6);
    }

    @RequiresApi(26)
    @NonNull
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
