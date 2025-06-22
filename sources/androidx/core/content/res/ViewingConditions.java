package androidx.core.content.res;

import androidx.annotation.NonNull;

final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.mN = f4;
        this.mAw = f5;
        this.mNbb = f6;
        this.mNcb = f7;
        this.mC = f8;
        this.mNc = f9;
        this.mRgbD = fArr;
        this.mFl = f10;
        this.mFlRoot = f11;
        this.mZ = f12;
    }

    @NonNull
    static ViewingConditions make(@NonNull float[] fArr, float f4, float f5, float f6, boolean z4) {
        float lerp;
        float f7;
        float f8 = f4;
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f9 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = (fArr3[0] * f9) + (fArr3[1] * f10) + (fArr3[2] * f11);
        float[] fArr4 = fArr2[1];
        float f13 = (fArr4[0] * f9) + (fArr4[1] * f10) + (fArr4[2] * f11);
        float[] fArr5 = fArr2[2];
        float f14 = (f9 * fArr5[0]) + (f10 * fArr5[1]) + (f11 * fArr5[2]);
        float f15 = (f6 / 10.0f) + 0.8f;
        if (((double) f15) >= 0.9d) {
            lerp = CamUtils.lerp(0.59f, 0.69f, (f15 - 0.9f) * 10.0f);
        } else {
            lerp = CamUtils.lerp(0.525f, 0.59f, (f15 - 0.8f) * 10.0f);
        }
        float f16 = lerp;
        if (z4) {
            f7 = 1.0f;
        } else {
            f7 = (1.0f - (((float) Math.exp((double) (((-f8) - 42.0f) / 92.0f))) * 0.2777778f)) * f15;
        }
        double d5 = (double) f7;
        if (d5 > 1.0d) {
            f7 = 1.0f;
        } else if (d5 < 0.0d) {
            f7 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f12) * f7) + 1.0f) - f7, (((100.0f / f13) * f7) + 1.0f) - f7, (((100.0f / f14) * f7) + 1.0f) - f7};
        float f17 = 1.0f / ((5.0f * f8) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float f20 = f14;
        float cbrt = (f18 * f8) + (0.1f * f19 * f19 * ((float) Math.cbrt(((double) f8) * 5.0d)));
        float yFromLStar = CamUtils.yFromLStar(f5) / fArr[1];
        double d6 = (double) yFromLStar;
        float[] fArr7 = fArr6;
        float sqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float[] fArr8 = {(float) Math.pow(((double) ((fArr7[0] * cbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr7[1] * cbrt) * f13)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr7[2] * cbrt) * f20)) / 100.0d, 0.42d)};
        float f21 = fArr8[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr8[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr8[2];
        float[] fArr9 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        return new ViewingConditions(yFromLStar, ((fArr9[0] * 2.0f) + fArr9[1] + (fArr9[2] * 0.05f)) * pow, pow, pow, f16, f15, fArr7, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float getAw() {
        return this.mAw;
    }

    /* access modifiers changed from: package-private */
    public float getC() {
        return this.mC;
    }

    /* access modifiers changed from: package-private */
    public float getFl() {
        return this.mFl;
    }

    /* access modifiers changed from: package-private */
    public float getFlRoot() {
        return this.mFlRoot;
    }

    /* access modifiers changed from: package-private */
    public float getN() {
        return this.mN;
    }

    /* access modifiers changed from: package-private */
    public float getNbb() {
        return this.mNbb;
    }

    /* access modifiers changed from: package-private */
    public float getNc() {
        return this.mNc;
    }

    /* access modifiers changed from: package-private */
    public float getNcb() {
        return this.mNcb;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    /* access modifiers changed from: package-private */
    public float getZ() {
        return this.mZ;
    }
}
