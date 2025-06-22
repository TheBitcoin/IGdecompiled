package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d5, double d6, double d7, double d8) {
            this.mA = d5;
            this.mB = d6;
            this.mC = d7;
            this.mD = d8;
        }

        public double eval(double d5) {
            return (((((this.mD * d5) + this.mC) * d5) + this.mB) * d5) + this.mA;
        }

        public double vel(double d5) {
            return (((this.mD * 3.0d * d5) + (this.mC * 2.0d)) * d5) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    static Cubic[] calcNaturalCubic(int i4, double[] dArr) {
        int i5 = i4;
        double[] dArr2 = new double[i5];
        double[] dArr3 = new double[i5];
        double[] dArr4 = new double[i5];
        int i6 = i5 - 1;
        int i7 = 0;
        dArr2[0] = 0.5d;
        int i8 = 1;
        for (int i9 = 1; i9 < i6; i9++) {
            dArr2[i9] = 1.0d / (4.0d - dArr2[i9 - 1]);
        }
        int i10 = i5 - 2;
        dArr2[i6] = 1.0d / (2.0d - dArr2[i10]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i8 < i6) {
            int i11 = i8 + 1;
            int i12 = i8 - 1;
            dArr3[i8] = (((dArr[i11] - dArr[i12]) * 3.0d) - dArr3[i12]) * dArr2[i8];
            i8 = i11;
        }
        double d5 = (((dArr[i6] - dArr[i10]) * 3.0d) - dArr3[i10]) * dArr2[i6];
        dArr3[i6] = d5;
        dArr4[i6] = d5;
        while (i10 >= 0) {
            dArr4[i10] = dArr3[i10] - (dArr2[i10] * dArr4[i10 + 1]);
            i10--;
        }
        Cubic[] cubicArr = new Cubic[i6];
        while (i7 < i6) {
            double d6 = dArr[i7];
            double d7 = dArr4[i7];
            int i13 = i7 + 1;
            double d8 = dArr[i13];
            double d9 = dArr4[i13];
            cubicArr[i7] = new Cubic((double) ((float) d6), d7, (((d8 - d6) * 3.0d) - (d7 * 2.0d)) - d9, ((d6 - d8) * 2.0d) + d7 + d9);
            i7 = i13;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i4;
        Cubic[] cubicArr2 = cubicArr;
        int length = cubicArr2.length;
        double[] dArr = new double[length];
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        while (true) {
            i4 = 0;
            if (d6 >= 1.0d) {
                break;
            }
            double d8 = 0.0d;
            while (i4 < length) {
                double d9 = dArr[i4];
                double eval = cubicArr2[i4].eval(d6);
                dArr[i4] = eval;
                double d10 = d9 - eval;
                d8 += d10 * d10;
                i4++;
            }
            if (d6 > 0.0d) {
                d7 += Math.sqrt(d8);
            }
            d6 += 0.1d;
        }
        while (i4 < length) {
            double d11 = dArr[i4];
            double eval2 = cubicArr2[i4].eval(1.0d);
            dArr[i4] = eval2;
            double d12 = d11 - eval2;
            d5 += d12 * d12;
            i4++;
        }
        return d7 + Math.sqrt(d5);
    }

    public void getPos(double d5, double[] dArr) {
        double d6 = d5 * this.mTotalLength;
        int i4 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i4 >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i4];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i4++;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = this.mCurve[i5][i4].eval(d6 / this.mCurveLength[i4]);
        }
    }

    public void getVelocity(double d5, double[] dArr) {
        double d6 = d5 * this.mTotalLength;
        int i4 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i4 >= dArr2.length - 1) {
                break;
            }
            double d7 = dArr2[i4];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i4++;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = this.mCurve[i5][i4].vel(d6 / this.mCurveLength[i4]);
        }
    }

    public void setup(double[][] dArr) {
        int i4;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, iArr);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i5 = 0; i5 < this.mDimensionality; i5++) {
            for (int i6 = 0; i6 < this.mPoints; i6++) {
                this.mCtl[i5][i6] = dArr[i6][i5];
            }
        }
        int i7 = 0;
        while (true) {
            i4 = this.mDimensionality;
            if (i7 >= i4) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i7];
            cubicArr[i7] = calcNaturalCubic(dArr2.length, dArr2);
            i7++;
        }
        this.mCurveLength = new double[(this.mPoints - 1)];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i4];
        for (int i8 = 0; i8 < this.mCurveLength.length; i8++) {
            for (int i9 = 0; i9 < this.mDimensionality; i9++) {
                cubicArr2[i9] = this.mCurve[i9][i8];
            }
            double d5 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i8] = approxLength;
            this.mTotalLength = d5 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d5, float[] fArr) {
        double d6 = d5 * this.mTotalLength;
        int i4 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i4 >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i4];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i4++;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            fArr[i5] = (float) this.mCurve[i5][i4].eval(d6 / this.mCurveLength[i4]);
        }
    }

    public double getPos(double d5, int i4) {
        double[] dArr;
        double d6 = d5 * this.mTotalLength;
        int i5 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i5 >= dArr.length - 1) {
                break;
            }
            double d7 = dArr[i5];
            if (d7 >= d6) {
                break;
            }
            d6 -= d7;
            i5++;
        }
        return this.mCurve[i4][i5].eval(d6 / dArr[i5]);
    }
}
