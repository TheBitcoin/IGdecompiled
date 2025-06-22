package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StepCurve extends Easing {
    private static final boolean DEBUG = false;
    MonotonicCurveFit mCurveFit;

    StepCurve(String str) {
        this.mStr = str;
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
        this.mCurveFit = genSpline(Arrays.copyOf(dArr, i4 + 1));
    }

    private static MonotonicCurveFit genSpline(String str) {
        String[] split = str.split("\\s+");
        int length = split.length;
        double[] dArr = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = Double.parseDouble(split[i4]);
        }
        return genSpline(dArr);
    }

    public double get(double d5) {
        return this.mCurveFit.getPos(d5, 0);
    }

    public double getDiff(double d5) {
        return this.mCurveFit.getSlope(d5, 0);
    }

    private static MonotonicCurveFit genSpline(double[] dArr) {
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
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr4, dArr3);
        System.out.println(" 0 " + monotonicCurveFit.getPos(0.0d, 0));
        System.out.println(" 1 " + monotonicCurveFit.getPos(1.0d, 0));
        return monotonicCurveFit;
    }
}
