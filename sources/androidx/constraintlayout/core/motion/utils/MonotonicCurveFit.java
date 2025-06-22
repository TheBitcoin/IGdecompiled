package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.mSlopeTemp = new double[length2];
        int i4 = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i4;
        Class cls = Double.TYPE;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr2);
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = 0;
            while (i6 < i4) {
                int i7 = i6 + 1;
                double d5 = dArr3[i7] - dArr3[i6];
                double[] dArr7 = dArr5[i6];
                double d6 = (dArr4[i7][i5] - dArr4[i6][i5]) / d5;
                dArr7[i5] = d6;
                if (i6 == 0) {
                    dArr6[i6][i5] = d6;
                } else {
                    dArr6[i6][i5] = (dArr5[i6 - 1][i5] + d6) * 0.5d;
                }
                i6 = i7;
            }
            dArr6[i4][i5] = dArr5[length - 2][i5];
        }
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                double d7 = dArr5[i8][i9];
                if (d7 == 0.0d) {
                    dArr6[i8][i9] = 0.0d;
                    dArr6[i8 + 1][i9] = 0.0d;
                } else {
                    double d8 = dArr6[i8][i9] / d7;
                    int i10 = i8 + 1;
                    double d9 = dArr6[i10][i9] / d7;
                    double hypot = Math.hypot(d8, d9);
                    if (hypot > 9.0d) {
                        double d10 = 3.0d / hypot;
                        double[] dArr8 = dArr6[i8];
                        double[] dArr9 = dArr5[i8];
                        dArr8[i9] = d8 * d10 * dArr9[i9];
                        dArr6[i10][i9] = d10 * d9 * dArr9[i9];
                    }
                }
            }
        }
        this.mT = dArr3;
        this.mY = dArr4;
        this.mTangent = dArr6;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i4 = 0;
        while (indexOf2 != -1) {
            dArr[i4] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i4++;
        }
        dArr[i4] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i4 + 1));
    }

    private static double diff(double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d6 * 6.0d;
        double d13 = 3.0d * d5;
        return (((((((((-6.0d * d11) * d8) + (d12 * d8)) + ((6.0d * d11) * d7)) - (d12 * d7)) + ((d13 * d10) * d11)) + ((d13 * d9) * d11)) - (((2.0d * d5) * d10) * d6)) - (((4.0d * d5) * d9) * d6)) + (d5 * d9);
    }

    private static double interpolate(double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d6 * d6;
        double d12 = d11 * d6;
        double d13 = 3.0d * d11;
        double d14 = d5 * d10;
        double d15 = d5 * d9;
        return ((((((((((-2.0d * d12) * d8) + (d13 * d8)) + ((d12 * 2.0d) * d7)) - (d13 * d7)) + d7) + (d14 * d12)) + (d12 * d15)) - (d14 * d11)) - (((d5 * 2.0d) * d9) * d11)) + (d15 * d6);
    }

    public void getPos(double d5, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i4 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr2[0];
            if (d5 <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.mY[0][i5] + ((d5 - this.mT[0]) * this.mSlopeTemp[i5]);
                }
                return;
            }
            int i6 = length - 1;
            double d7 = dArr2[i6];
            if (d5 >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i4 < length2) {
                    dArr[i4] = this.mY[i6][i4] + ((d5 - this.mT[i6]) * this.mSlopeTemp[i4]);
                    i4++;
                }
                return;
            }
        } else if (d5 <= dArr2[0]) {
            for (int i7 = 0; i7 < length2; i7++) {
                dArr[i7] = this.mY[0][i7];
            }
            return;
        } else {
            int i8 = length - 1;
            if (d5 >= dArr2[i8]) {
                while (i4 < length2) {
                    dArr[i4] = this.mY[i8][i4];
                    i4++;
                }
                return;
            }
        }
        int i9 = 0;
        while (i9 < length - 1) {
            if (d5 == this.mT[i9]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    dArr[i10] = this.mY[i9][i10];
                }
            }
            double[] dArr3 = this.mT;
            int i11 = i9 + 1;
            double d8 = dArr3[i11];
            if (d5 < d8) {
                double d9 = dArr3[i9];
                double d10 = d8 - d9;
                double d11 = (d5 - d9) / d10;
                while (i4 < length2) {
                    double[][] dArr4 = this.mY;
                    double d12 = dArr4[i9][i4];
                    double d13 = dArr4[i11][i4];
                    double[][] dArr5 = this.mTangent;
                    dArr[i4] = interpolate(d10, d11, d12, d13, dArr5[i9][i4], dArr5[i11][i4]);
                    i4++;
                }
                return;
            }
            i9 = i11;
        }
    }

    public void getSlope(double d5, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d6 = dArr2[0];
        if (d5 > d6) {
            d6 = dArr2[length - 1];
            if (d5 < d6) {
                d6 = d5;
            }
        }
        int i4 = 0;
        while (i4 < length - 1) {
            double[] dArr3 = this.mT;
            int i5 = i4 + 1;
            double d7 = dArr3[i5];
            if (d6 <= d7) {
                double d8 = dArr3[i4];
                double d9 = d7 - d8;
                double d10 = (d6 - d8) / d9;
                for (int i6 = 0; i6 < length2; i6++) {
                    double[][] dArr4 = this.mY;
                    double d11 = dArr4[i4][i6];
                    double d12 = dArr4[i5][i6];
                    double[][] dArr5 = this.mTangent;
                    dArr[i6] = diff(d9, d10, d11, d12, dArr5[i4][i6], dArr5[i5][i6]) / d9;
                }
                return;
            }
            i4 = i5;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d5 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr4 = new double[length];
        for (int i4 = 0; i4 < dArr2.length; i4++) {
            double d6 = dArr2[i4];
            int i5 = i4 + length2;
            dArr3[i5][0] = d6;
            double d7 = ((double) i4) * d5;
            dArr4[i5] = d7;
            if (i4 > 0) {
                int i6 = (length2 * 2) + i4;
                dArr3[i6][0] = d6 + 1.0d;
                dArr4[i6] = d7 + 1.0d;
                int i7 = i4 - 1;
                dArr3[i7][0] = (d6 - 1.0d) - d5;
                dArr4[i7] = (d7 - 4.0d) - d5;
            }
        }
        return new MonotonicCurveFit(dArr4, dArr3);
    }

    public double getSlope(double d5, int i4) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        double d6 = dArr[0];
        if (d5 >= d6) {
            d6 = dArr[length - 1];
            if (d5 < d6) {
                d6 = d5;
            }
        }
        while (i5 < length - 1) {
            double[] dArr2 = this.mT;
            int i6 = i5 + 1;
            double d7 = dArr2[i6];
            if (d6 <= d7) {
                double d8 = dArr2[i5];
                double d9 = d7 - d8;
                double[][] dArr3 = this.mY;
                double d10 = dArr3[i5][i4];
                double d11 = dArr3[i6][i4];
                double[][] dArr4 = this.mTangent;
                return diff(d9, (d6 - d8) / d9, d10, d11, dArr4[i5][i4], dArr4[i6][i4]) / d9;
            }
            i5 = i6;
        }
        return 0.0d;
    }

    public void getPos(double d5, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i4 = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d6 = dArr[0];
            if (d5 <= d6) {
                getSlope(d6, this.mSlopeTemp);
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) (this.mY[0][i5] + ((d5 - this.mT[0]) * this.mSlopeTemp[i5]));
                }
                return;
            }
            int i6 = length - 1;
            double d7 = dArr[i6];
            if (d5 >= d7) {
                getSlope(d7, this.mSlopeTemp);
                while (i4 < length2) {
                    fArr[i4] = (float) (this.mY[i6][i4] + ((d5 - this.mT[i6]) * this.mSlopeTemp[i4]));
                    i4++;
                }
                return;
            }
        } else if (d5 <= dArr[0]) {
            for (int i7 = 0; i7 < length2; i7++) {
                fArr[i7] = (float) this.mY[0][i7];
            }
            return;
        } else {
            int i8 = length - 1;
            if (d5 >= dArr[i8]) {
                while (i4 < length2) {
                    fArr[i4] = (float) this.mY[i8][i4];
                    i4++;
                }
                return;
            }
        }
        int i9 = 0;
        while (i9 < length - 1) {
            if (d5 == this.mT[i9]) {
                for (int i10 = 0; i10 < length2; i10++) {
                    fArr[i10] = (float) this.mY[i9][i10];
                }
            }
            double[] dArr2 = this.mT;
            int i11 = i9 + 1;
            double d8 = dArr2[i11];
            if (d5 < d8) {
                double d9 = dArr2[i9];
                double d10 = d8 - d9;
                double d11 = (d5 - d9) / d10;
                while (i4 < length2) {
                    double[][] dArr3 = this.mY;
                    double d12 = dArr3[i9][i4];
                    double d13 = dArr3[i11][i4];
                    double[][] dArr4 = this.mTangent;
                    fArr[i4] = (float) interpolate(d10, d11, d12, d13, dArr4[i9][i4], dArr4[i11][i4]);
                    i4++;
                }
                return;
            }
            i9 = i11;
        }
    }

    public double getPos(double d5, int i4) {
        double d6;
        double d7;
        double slope;
        int i5 = i4;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d8 = dArr[0];
            if (d5 <= d8) {
                d6 = this.mY[0][i5];
                d7 = d5 - d8;
                slope = getSlope(d8, i5);
            } else {
                int i7 = length - 1;
                double d9 = dArr[i7];
                if (d5 >= d9) {
                    d6 = this.mY[i7][i5];
                    d7 = d5 - d9;
                    slope = getSlope(d9, i5);
                }
            }
            return d6 + (d7 * slope);
        } else if (d5 <= dArr[0]) {
            return this.mY[0][i5];
        } else {
            int i8 = length - 1;
            if (d5 >= dArr[i8]) {
                return this.mY[i8][i5];
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d10 = dArr2[i6];
            if (d5 == d10) {
                return this.mY[i6][i5];
            }
            int i9 = i6 + 1;
            double d11 = dArr2[i9];
            if (d5 < d11) {
                double d12 = d11 - d10;
                double d13 = (d5 - d10) / d12;
                double[][] dArr3 = this.mY;
                double d14 = dArr3[i6][i5];
                double d15 = dArr3[i9][i5];
                double[][] dArr4 = this.mTangent;
                return interpolate(d12, d13, d14, d15, dArr4[i6][i5], dArr4[i9][i5]);
            }
            i6 = i9;
        }
        return 0.0d;
    }
}
