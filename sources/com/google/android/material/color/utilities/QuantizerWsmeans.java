package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    private static final class Distance implements Comparable<Distance> {
        double distance = -1.0d;
        int index = -1;

        Distance() {
        }

        public int compareTo(Distance distance2) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance2.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i4) {
        double[][] dArr;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        Random random = new Random(272008);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr2 = new double[iArr3.length][];
        int[] iArr5 = new int[iArr3.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i5 = 0;
        for (int i6 : iArr3) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i6));
            if (num == null) {
                dArr2[i5] = pointProviderLab.fromInt(i6);
                iArr5[i5] = i6;
                i5++;
                linkedHashMap.put(Integer.valueOf(i6), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i6), Integer.valueOf(num.intValue() + 1));
            }
        }
        int[] iArr6 = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr6[i7] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr5[i7]))).intValue();
        }
        int min = Math.min(i4, i5);
        if (iArr4.length != 0) {
            min = Math.min(min, iArr4.length);
        }
        double[][] dArr3 = new double[min][];
        int i8 = 0;
        for (int i9 = 0; i9 < iArr4.length; i9++) {
            dArr3[i9] = pointProviderLab.fromInt(iArr4[i9]);
            i8++;
        }
        int i10 = min - i8;
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
            }
        }
        int[] iArr7 = new int[i5];
        for (int i12 = 0; i12 < i5; i12++) {
            iArr7[i12] = random.nextInt(min);
        }
        int[][] iArr8 = new int[min][];
        for (int i13 = 0; i13 < min; i13++) {
            iArr8[i13] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min][];
        for (int i14 = 0; i14 < min; i14++) {
            distanceArr[i14] = new Distance[min];
            for (int i15 = 0; i15 < min; i15++) {
                distanceArr[i14][i15] = new Distance();
            }
        }
        int[] iArr9 = new int[min];
        int i16 = 0;
        while (true) {
            if (i16 >= 10) {
                dArr = dArr3;
                break;
            }
            int i17 = 0;
            while (i17 < min) {
                int i18 = i17 + 1;
                int i19 = i18;
                while (i19 < min) {
                    int[] iArr10 = iArr6;
                    double distance = pointProviderLab.distance(dArr3[i17], dArr3[i19]);
                    Distance distance2 = distanceArr[i19][i17];
                    distance2.distance = distance;
                    distance2.index = i17;
                    Distance distance3 = distanceArr[i17][i19];
                    distance3.distance = distance;
                    distance3.index = i19;
                    i19++;
                    iArr6 = iArr10;
                    iArr7 = iArr7;
                }
                int[] iArr11 = iArr6;
                int[] iArr12 = iArr7;
                Arrays.sort(distanceArr[i17]);
                for (int i20 = 0; i20 < min; i20++) {
                    iArr8[i17][i20] = distanceArr[i17][i20].index;
                }
                iArr6 = iArr11;
                iArr7 = iArr12;
                i17 = i18;
            }
            int[] iArr13 = iArr6;
            int[] iArr14 = iArr7;
            int i21 = 0;
            int i22 = 0;
            while (i21 < i5) {
                double[] dArr4 = dArr2[i21];
                int i23 = iArr14[i21];
                double distance4 = pointProviderLab.distance(dArr4, dArr3[i23]);
                int i24 = i21;
                double d5 = distance4;
                int i25 = -1;
                int i26 = 0;
                while (i26 < min) {
                    int i27 = i22;
                    double[][] dArr5 = dArr2;
                    double[][] dArr6 = dArr3;
                    if (distanceArr[i23][i26].distance < 4.0d * distance4) {
                        double distance5 = pointProviderLab.distance(dArr4, dArr6[i26]);
                        if (distance5 < d5) {
                            d5 = distance5;
                            i25 = i26;
                        }
                    }
                    i26++;
                    dArr2 = dArr5;
                    i22 = i27;
                    dArr3 = dArr6;
                }
                int i28 = i22;
                double[][] dArr7 = dArr2;
                double[][] dArr8 = dArr3;
                if (i25 == -1 || Math.abs(Math.sqrt(d5) - Math.sqrt(distance4)) <= 3.0d) {
                    i22 = i28;
                } else {
                    i22 = i28 + 1;
                    iArr14[i24] = i25;
                }
                i21 = i24 + 1;
                dArr2 = dArr7;
                dArr3 = dArr8;
            }
            double[][] dArr9 = dArr2;
            dArr = dArr3;
            if (i22 == 0 && i16 != 0) {
                break;
            }
            double[] dArr10 = new double[min];
            double[] dArr11 = new double[min];
            double[] dArr12 = new double[min];
            char c5 = 0;
            Arrays.fill(iArr9, 0);
            int i29 = 0;
            while (i29 < i5) {
                int i30 = iArr14[i29];
                double[] dArr13 = dArr9[i29];
                int i31 = iArr13[i29];
                iArr9[i30] = iArr9[i30] + i31;
                double d6 = (double) i31;
                dArr10[i30] = dArr10[i30] + (dArr13[c5] * d6);
                dArr11[i30] = dArr11[i30] + (dArr13[1] * d6);
                dArr12[i30] = dArr12[i30] + (dArr13[2] * d6);
                i29++;
                distanceArr = distanceArr;
                c5 = 0;
            }
            Distance[][] distanceArr2 = distanceArr;
            for (int i32 = 0; i32 < min; i32++) {
                int i33 = iArr9[i32];
                if (i33 == 0) {
                    dArr[i32] = new double[]{0.0d, 0.0d, 0.0d};
                } else {
                    double d7 = (double) i33;
                    double d8 = dArr10[i32] / d7;
                    double d9 = dArr11[i32] / d7;
                    double d10 = dArr12[i32] / d7;
                    double[] dArr14 = dArr[i32];
                    dArr14[0] = d8;
                    dArr14[1] = d9;
                    dArr14[2] = d10;
                }
            }
            i16++;
            iArr6 = iArr13;
            iArr7 = iArr14;
            distanceArr = distanceArr2;
            dArr2 = dArr9;
            dArr3 = dArr;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i34 = 0; i34 < min; i34++) {
            int i35 = iArr9[i34];
            if (i35 != 0) {
                int i36 = pointProviderLab.toInt(dArr[i34]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i36))) {
                    linkedHashMap2.put(Integer.valueOf(i36), Integer.valueOf(i35));
                }
            }
        }
        return linkedHashMap2;
    }
}
