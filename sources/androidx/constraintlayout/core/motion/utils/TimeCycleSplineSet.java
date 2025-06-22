package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected float[] mCache;
    protected boolean mContinue;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected float mLastCycle;
    protected long mLastTime;
    protected int[] mTimePoints = new int[10];
    protected String mType;
    protected float[][] mValues;
    protected int mWaveShape = 0;

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        public void setPoint(int i4, float f4, float f5, int i5, float f6) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f4, long j4, KeyCache keyCache) {
            boolean z4;
            MotionWidget motionWidget2 = motionWidget;
            long j5 = j4;
            this.mCurveFit.getPos((double) f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            long j6 = j5 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f7 = (float) ((((double) this.mLastCycle) + ((((double) j6) * 1.0E-9d) * ((double) f5))) % 1.0d);
            this.mLastCycle = f7;
            this.mLastTime = j5;
            float calcWave = calcWave(f7);
            this.mContinue = false;
            int i4 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i4 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f8 = this.mTempValues[i4];
                if (((double) f8) != 0.0d) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mContinue = z5 | z4;
                fArr2[i4] = (f8 * calcWave) + f6;
                i4++;
            }
            motionWidget2.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f5 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i4) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i5 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i5];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i5;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i6);
                float[] valueAt2 = this.mWaveProperties.valueAt(i6);
                dArr[i6] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i7 >= fArr.length) {
                        break;
                    }
                    dArr2[i6][i7] = (double) fArr[i7];
                    i7++;
                }
                double[] dArr3 = dArr2[i6];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, CustomAttribute customAttribute, float f4, int i5, float f5) {
            this.mConstraintAttributeList.append(i4, customAttribute);
            this.mWaveProperties.append(i4, new float[]{f4, f5});
            this.mWaveShape = Math.max(this.mWaveShape, i5);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        public void setPoint(int i4, float f4, float f5, int i5, float f6) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f4, long j4, KeyCache keyCache) {
            boolean z4;
            MotionWidget motionWidget2 = motionWidget;
            long j5 = j4;
            this.mCurveFit.getPos((double) f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            long j6 = j5 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget2, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f7 = (float) ((((double) this.mLastCycle) + ((((double) j6) * 1.0E-9d) * ((double) f5))) % 1.0d);
            this.mLastCycle = f7;
            this.mLastTime = j5;
            float calcWave = calcWave(f7);
            this.mContinue = false;
            int i4 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i4 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f8 = this.mTempValues[i4];
                if (((double) f8) != 0.0d) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mContinue = z5 | z4;
                fArr2[i4] = (f8 * calcWave) + f6;
                i4++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget2, this.mCustomCache);
            if (f5 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        public void setup(int i4) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i5 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i5];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i5;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i6);
                float[] valueAt2 = this.mWaveProperties.valueAt(i6);
                dArr[i6] = ((double) keyAt) * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i7 >= fArr.length) {
                        break;
                    }
                    dArr2[i6][i7] = (double) fArr[i7];
                    i7++;
                }
                double[] dArr3 = dArr2[i6];
                dArr3[numberOfInterpolatedValues] = (double) valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, CustomVariable customVariable, float f4, int i5, float f5) {
            this.mConstraintAttributeList.append(i4, customVariable);
            this.mWaveProperties.append(i4, new float[]{f4, f5});
            this.mWaveShape = Math.max(this.mWaveShape, i5);
        }
    }

    protected static class Sort {
        protected Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[][] fArr, int i4, int i5) {
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

        private static int partition(int[] iArr, float[][] fArr, int i4, int i5) {
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

        private static void swap(int[] iArr, float[][] fArr, int i4, int i5) {
            int i6 = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = i6;
            float[] fArr2 = fArr[i4];
            fArr[i4] = fArr[i5];
            fArr[i5] = fArr2;
        }
    }

    public TimeCycleSplineSet() {
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = 10;
        this.mValues = (float[][]) Array.newInstance(Float.TYPE, iArr);
        this.mCache = new float[3];
        this.mContinue = false;
        this.mLastCycle = Float.NaN;
    }

    /* access modifiers changed from: protected */
    public float calcWave(float f4) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f4 * sVal2PI);
            case 2:
                abs = Math.abs(f4);
                break;
            case 3:
                return (((f4 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f4 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f4 * sVal2PI));
            case 6:
                float abs2 = 1.0f - Math.abs(((f4 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f4 * sVal2PI));
        }
        return 1.0f - abs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i4, float f4, float f5, int i5, float f6) {
        int[] iArr = this.mTimePoints;
        int i6 = this.mCount;
        iArr[i6] = i4;
        float[] fArr = this.mValues[i6];
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        this.mWaveShape = Math.max(this.mWaveShape, i5);
        this.mCount++;
    }

    /* access modifiers changed from: protected */
    public void setStartTime(long j4) {
        this.mLastTime = j4;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i4) {
        int i5 = this.mCount;
        if (i5 == 0) {
            PrintStream printStream = System.err;
            printStream.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i5 - 1);
        int i6 = 1;
        int i7 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i6 >= iArr.length) {
                break;
            }
            if (iArr[i6] != iArr[i6 - 1]) {
                i7++;
            }
            i6++;
        }
        if (i7 == 0) {
            i7 = 1;
        }
        double[] dArr = new double[i7];
        int[] iArr2 = new int[2];
        iArr2[1] = 3;
        iArr2[0] = i7;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        int i8 = 0;
        for (int i9 = 0; i9 < this.mCount; i9++) {
            if (i9 > 0) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i9] == iArr3[i9 - 1]) {
                }
            }
            dArr[i8] = ((double) this.mTimePoints[i9]) * 0.01d;
            double[] dArr3 = dArr2[i8];
            float[] fArr = this.mValues[i9];
            dArr3[0] = (double) fArr[0];
            dArr3[1] = (double) fArr[1];
            dArr3[2] = (double) fArr[2];
            i8++;
        }
        this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i4 = 0; i4 < this.mCount; i4++) {
            str = str + "[" + this.mTimePoints[i4] + " , " + decimalFormat.format(this.mValues[i4]) + "] ";
        }
        return str;
    }
}
