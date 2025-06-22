package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        this.mHue = f4;
        this.mChroma = f5;
        this.mJ = f6;
        this.mQ = f7;
        this.mM = f8;
        this.mS = f9;
        this.mJstar = f10;
        this.mAstar = f11;
        this.mBstar = f12;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 100.0d) float f6) {
        float f7 = 100.0f;
        float f8 = 1000.0f;
        CamColor camColor = null;
        float f9 = 1000.0f;
        float f10 = 0.0f;
        while (Math.abs(f10 - f7) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f11 = ((f7 - f10) / 2.0f) + f10;
            int viewedInSrgb = fromJch(f11, f5, f4).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f6 - lStarFromInt);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f4));
                if (distance <= 1.0f) {
                    camColor = fromColor;
                    f8 = abs;
                    f9 = distance;
                }
            }
            if (f8 == 0.0f && f9 == 0.0f) {
                return camColor;
            }
            if (lStarFromInt < f6) {
                f10 = f11;
            } else {
                f7 = f11;
            }
        }
        return camColor;
    }

    @NonNull
    static CamColor fromColor(@ColorInt int i4) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i4, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void fromColorInViewingConditions(@ColorInt int i4, @NonNull ViewingConditions viewingConditions, @Size(7) @Nullable float[] fArr, @Size(3) @NonNull float[] fArr2) {
        float f4;
        float[] fArr3 = fArr2;
        CamUtils.xyzFromInt(i4, fArr3);
        float[][] fArr4 = CamUtils.XYZ_TO_CAM16RGB;
        float f5 = fArr3[0];
        float[] fArr5 = fArr4[0];
        float f6 = fArr3[1];
        float f7 = fArr3[2];
        float f8 = (fArr5[0] * f5) + (fArr5[1] * f6) + (fArr5[2] * f7);
        float[] fArr6 = fArr4[1];
        float f9 = (fArr6[0] * f5) + (fArr6[1] * f6) + (fArr6[2] * f7);
        float[] fArr7 = fArr4[2];
        float f10 = viewingConditions.getRgbD()[0] * f8;
        float f11 = viewingConditions.getRgbD()[1] * f9;
        float f12 = viewingConditions.getRgbD()[2] * ((f5 * fArr7[0]) + (f6 * fArr7[1]) + (f7 * fArr7[2]));
        float pow = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f10))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f11))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (viewingConditions.getFl() * Math.abs(f12))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f10) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f11) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f12) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d5 = (double) signum3;
        float f13 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d5)) / 11.0f;
        float f14 = ((float) (((double) (signum + signum2)) - (d5 * 2.0d))) / 9.0f;
        float f15 = signum2 * 20.0f;
        float f16 = (((signum * 40.0f) + f15) + signum3) / 20.0f;
        float f17 = (((signum * 20.0f) + f15) + (21.0f * signum3)) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f14, (double) f13)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f18 = (3.1415927f * atan2) / 180.0f;
        float f19 = f13;
        float f20 = f17;
        float pow4 = ((float) Math.pow((double) ((f16 * viewingConditions.getNbb()) / viewingConditions.getAw()), (double) (viewingConditions.getC() * viewingConditions.getZ()))) * 100.0f;
        float c5 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        if (((double) atan2) < 20.14d) {
            f4 = 360.0f + atan2;
        } else {
            f4 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.getN()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f4) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((double) ((f19 * f19) + (f14 * f14))))) / (f20 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f)))) * 50.0f;
        float f21 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * flRoot) + 1.0f))) * 43.85965f;
        double d6 = (double) f18;
        float cos = ((float) Math.cos(d6)) * log;
        float sin = log * ((float) Math.sin(d6));
        fArr3[0] = atan2;
        fArr3[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = c5;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f21;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 360.0d) float f6) {
        return fromJchInFrame(f4, f5, f6, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 360.0d) float f6, ViewingConditions viewingConditions) {
        double d5 = ((double) f4) / 100.0d;
        float c5 = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(d5)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f5;
        float sqrt = ((float) Math.sqrt((double) (((f5 / ((float) Math.sqrt(d5))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f)))) * 50.0f;
        float f7 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log = ((float) Math.log((((double) flRoot) * 0.0228d) + 1.0d)) * 43.85965f;
        double d6 = (double) ((3.1415927f * f6) / 180.0f);
        float cos = ((float) Math.cos(d6)) * log;
        float sin = log * ((float) Math.sin(d6));
        float f8 = cos;
        float f9 = flRoot;
        return new CamColor(f6, f5, f4, c5, f9, sqrt, f7, f8, sin);
    }

    public static void getM3HCTfromColor(@ColorInt int i4, @Size(3) @NonNull float[] fArr) {
        fromColorInViewingConditions(i4, ViewingConditions.DEFAULT, (float[]) null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i4);
    }

    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 100.0d) float f6) {
        return toColor(f4, f5, f6, ViewingConditions.DEFAULT);
    }

    /* access modifiers changed from: package-private */
    public float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((double) ((jStar * jStar) + (aStar * aStar) + (bStar * bStar))), 0.63d) * 1.41d);
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJ() {
        return this.mJ;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJStar() {
        return this.mJstar;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.mM;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.mQ;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.mS;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int viewed(@NonNull ViewingConditions viewingConditions) {
        float f4;
        if (((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) {
            f4 = 0.0f;
        } else {
            f4 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f4) / Math.pow(1.64d - Math.pow(0.29d, (double) viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (double) ((getHue() * 3.1415927f) / 180.0f);
        float aw = viewingConditions.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) viewingConditions.getC())) / ((double) viewingConditions.getZ())));
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f5 = (((0.305f + nbb) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f6 = cos2 * f5;
        float f7 = f5 * sin;
        float f8 = nbb * 460.0f;
        float f9 = (((451.0f * f6) + f8) + (288.0f * f7)) / 1403.0f;
        float f10 = ((f8 - (891.0f * f6)) - (261.0f * f7)) / 1403.0f;
        float f11 = ((f8 - (f6 * 220.0f)) - (f7 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f9) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f9)) * 27.13d) / (400.0d - ((double) Math.abs(f9))))), 2.380952380952381d));
        float signum2 = Math.signum(f10) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f10)) * 27.13d) / (400.0d - ((double) Math.abs(f10))))), 2.380952380952381d));
        float signum3 = Math.signum(f11) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11))))), 2.380952380952381d));
        float f12 = signum / viewingConditions.getRgbD()[0];
        float f13 = signum2 / viewingConditions.getRgbD()[1];
        float f14 = signum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f15 = (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor((double) f15, (double) ((fArr3[0] * f12) + (fArr3[1] * f13) + (fArr3[2] * f14)), (double) ((f12 * fArr4[0]) + (f13 * fArr4[1]) + (f14 * fArr4[2])));
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    @ColorInt
    static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f4, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f5, @FloatRange(from = 0.0d, to = 100.0d) float f6, @NonNull ViewingConditions viewingConditions) {
        float f7;
        if (((double) f5) < 1.0d || ((double) Math.round(f6)) <= 0.0d || ((double) Math.round(f6)) >= 100.0d) {
            return CamUtils.intFromLStar(f6);
        }
        if (f4 < 0.0f) {
            f7 = 0.0f;
        } else {
            f7 = Math.min(360.0f, f4);
        }
        float f8 = f5;
        CamColor camColor = null;
        float f9 = 0.0f;
        boolean z4 = true;
        while (Math.abs(f9 - f5) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor findCamByJ = findCamByJ(f7, f8, f6);
            if (!z4) {
                if (findCamByJ == null) {
                    f5 = f8;
                } else {
                    f9 = f8;
                    camColor = findCamByJ;
                }
                f8 = ((f5 - f9) / 2.0f) + f9;
            } else if (findCamByJ != null) {
                return findCamByJ.viewed(viewingConditions);
            } else {
                f8 = ((f5 - f9) / 2.0f) + f9;
                z4 = false;
            }
        }
        if (camColor == null) {
            return CamUtils.intFromLStar(f6);
        }
        return camColor.viewed(viewingConditions);
    }
}
