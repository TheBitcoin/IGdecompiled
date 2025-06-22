package androidx.constraintlayout.core.motion.utils;

public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength = Double.NaN;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length > 2) {
            double d5 = 0.0d;
            int i4 = 0;
            while (true) {
                double d6 = d5;
                if (i4 < dArr.length) {
                    double d7 = dArr2[i4][0];
                    if (i4 > 0) {
                        Math.hypot(d7 - d5, d7 - d6);
                    }
                    i4++;
                    d5 = d7;
                } else {
                    this.mTotalLength = 0.0d;
                    return;
                }
            }
        }
    }

    private double getLength2D(double d5) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d5 <= dArr[0]) {
            return 0.0d;
        }
        int i4 = length - 1;
        if (d5 >= dArr[i4]) {
            return this.mTotalLength;
        }
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        int i5 = 0;
        while (i5 < i4) {
            double[] dArr2 = this.mY[i5];
            double d9 = dArr2[0];
            double d10 = dArr2[1];
            if (i5 > 0) {
                d6 += Math.hypot(d9 - d7, d10 - d8);
            }
            double[] dArr3 = this.mT;
            double d11 = dArr3[i5];
            if (d5 == d11) {
                return d6;
            }
            int i6 = i5 + 1;
            double d12 = dArr3[i6];
            if (d5 < d12) {
                double d13 = (d5 - d11) / (d12 - d11);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i5];
                double d14 = dArr5[0];
                double[] dArr6 = dArr4[i6];
                double d15 = 1.0d - d13;
                return d6 + Math.hypot(d10 - ((dArr5[1] * d15) + (dArr6[1] * d13)), d9 - ((d14 * d15) + (dArr6[0] * d13)));
            }
            i5 = i6;
            d7 = d9;
            d8 = d10;
        }
        return 0.0d;
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
                double d10 = (d5 - d9) / (d8 - d9);
                while (i4 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i4] = (dArr4[i9][i4] * (1.0d - d10)) + (dArr4[i11][i4] * d10);
                    i4++;
                }
                return;
            }
            i9 = i11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (r13 >= r4) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
        L_0x000f:
            r13 = r4
            goto L_0x001a
        L_0x0011:
            int r4 = r1 + -1
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r0 = 0
        L_0x001b:
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x0041
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            r13 = r4[r0]
            double r6 = r6 - r13
        L_0x002c:
            if (r3 >= r2) goto L_0x0041
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            r0 = r5
            goto L_0x001b
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r8 >= r3) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x000c
        L_0x000a:
            r8 = r3
            goto L_0x0015
        L_0x000c:
            int r3 = r1 + -1
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r0 = r1 + -1
            if (r2 >= r0) goto L_0x0035
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L_0x0033:
            r2 = r3
            goto L_0x0015
        L_0x0035:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
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
                double d10 = (d5 - d9) / (d8 - d9);
                while (i4 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i4] = (float) ((dArr3[i9][i4] * (1.0d - d10)) + (dArr3[i11][i4] * d10));
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
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        if (this.mExtrapolate) {
            double d8 = dArr[0];
            if (d5 <= d8) {
                d6 = this.mY[0][i4];
                d7 = d5 - d8;
                slope = getSlope(d8, i4);
            } else {
                int i6 = length - 1;
                double d9 = dArr[i6];
                if (d5 >= d9) {
                    d6 = this.mY[i6][i4];
                    d7 = d5 - d9;
                    slope = getSlope(d9, i4);
                }
            }
            return d6 + (d7 * slope);
        } else if (d5 <= dArr[0]) {
            return this.mY[0][i4];
        } else {
            int i7 = length - 1;
            if (d5 >= dArr[i7]) {
                return this.mY[i7][i4];
            }
        }
        while (i5 < length - 1) {
            double[] dArr2 = this.mT;
            double d10 = dArr2[i5];
            if (d5 == d10) {
                return this.mY[i5][i4];
            }
            int i8 = i5 + 1;
            double d11 = dArr2[i8];
            if (d5 < d11) {
                double d12 = (d5 - d10) / (d11 - d10);
                double[][] dArr3 = this.mY;
                return (dArr3[i5][i4] * (1.0d - d12)) + (dArr3[i8][i4] * d12);
            }
            i5 = i8;
        }
        return 0.0d;
    }
}
