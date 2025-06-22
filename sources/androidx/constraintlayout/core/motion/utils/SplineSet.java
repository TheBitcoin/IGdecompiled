package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int mCount;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[] mValues = new float[10];

    private static class CoreSpline extends SplineSet {
        long mStart;
        String mType;

        CoreSpline(String str, long j4) {
            this.mType = str;
            this.mStart = j4;
        }

        public void setProperty(TypedValues typedValues, float f4) {
            typedValues.setValue(typedValues.getId(this.mType), get(f4));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        public void setPoint(int i4, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f4) {
            this.mCurveFit.getPos((double) f4, this.mTempValues);
            widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        public void setup(int i4) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i5);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i5);
                dArr[i5] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i6 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i6 >= fArr.length) {
                        break;
                    }
                    dArr2[i5][i6] = (double) fArr[i6];
                    i6++;
                }
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, CustomAttribute customAttribute) {
            this.mConstraintAttributeList.append(i4, customAttribute);
        }
    }

    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        public void setPoint(int i4, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(TypedValues typedValues, float f4) {
            setProperty((MotionWidget) typedValues, f4);
        }

        public void setup(int i4) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = numberOfInterpolatedValues;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i5);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i5);
                dArr[i5] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i6 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i6 >= fArr.length) {
                        break;
                    }
                    dArr2[i5][i6] = (double) fArr[i6];
                    i6++;
                }
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, CustomVariable customVariable) {
            this.mConstraintAttributeList.append(i4, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f4) {
            this.mCurveFit.getPos((double) f4, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mTempValues);
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[] fArr, int i4, int i5) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i5;
            iArr2[1] = i4;
            int i6 = 2;
            while (i6 > 0) {
                int i7 = iArr2[i6 - 1];
                int i8 = i6 - 2;
                int i9 = iArr2[i8];
                if (i7 < i9) {
                    int partition = partition(iArr, fArr, i7, i9);
                    iArr2[i8] = partition - 1;
                    iArr2[i6 - 1] = i7;
                    int i10 = i6 + 1;
                    iArr2[i6] = i9;
                    i6 += 2;
                    iArr2[i10] = partition + 1;
                } else {
                    i6 = i8;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i4, int i5) {
            int i6 = iArr[i5];
            int i7 = i4;
            while (i4 < i5) {
                if (iArr[i4] <= i6) {
                    swap(iArr, fArr, i7, i4);
                    i7++;
                }
                i4++;
            }
            swap(iArr, fArr, i7, i5);
            return i7;
        }

        private static void swap(int[] iArr, float[] fArr, int i4, int i5) {
            int i6 = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = i6;
            float f4 = fArr[i4];
            fArr[i4] = fArr[i5];
            fArr[i5] = f4;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j4) {
        return new CoreSpline(str, j4);
    }

    public float get(float f4) {
        return (float) this.mCurveFit.getPos((double) f4, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f4) {
        return (float) this.mCurveFit.getSlope((double) f4, 0);
    }

    public void setPoint(int i4, float f4) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.mCount + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i5 = this.mCount;
        iArr2[i5] = i4;
        this.mValues[i5] = f4;
        this.mCount = i5 + 1;
    }

    public void setProperty(TypedValues typedValues, float f4) {
        typedValues.setValue(a.a(this.mType), get(f4));
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i4) {
        int i5 = this.mCount;
        if (i5 != 0) {
            Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i5 - 1);
            int i6 = 1;
            for (int i7 = 1; i7 < this.mCount; i7++) {
                int[] iArr = this.mTimePoints;
                if (iArr[i7 - 1] != iArr[i7]) {
                    i6++;
                }
            }
            double[] dArr = new double[i6];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i6;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
            int i8 = 0;
            for (int i9 = 0; i9 < this.mCount; i9++) {
                if (i9 > 0) {
                    int[] iArr3 = this.mTimePoints;
                    if (iArr3[i9] == iArr3[i9 - 1]) {
                    }
                }
                dArr[i8] = ((double) this.mTimePoints[i9]) * 0.01d;
                dArr2[i8][0] = (double) this.mValues[i9];
                i8++;
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i4 = 0; i4 < this.mCount; i4++) {
            str = str + "[" + this.mTimePoints[i4] + " , " + decimalFormat.format((double) this.mValues[i4]) + "] ";
        }
        return str;
    }
}
