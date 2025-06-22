package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setAlpha(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        public void setPoint(int i4, float f4, float f5, int i5, float f6) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            boolean z4;
            View view2 = view;
            long j5 = j4;
            this.mCurveFit.getPos((double) f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            long j6 = j5 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(view2, this.mAttributeName, 0);
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
                float[] fArr2 = this.mCache;
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
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view2, this.mCache);
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
            this.mCache = new float[numberOfInterpolatedValues];
            int[] iArr = new int[2];
            iArr[1] = i5;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                float[] valueAt = this.mWaveProperties.valueAt(i6);
                dArr[i6] = ((double) keyAt) * 0.01d;
                this.mConstraintAttributeList.valueAt(i6).getValuesToInterpolate(this.mTempValues);
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
                dArr3[numberOfInterpolatedValues] = (double) valueAt[0];
                dArr3[numberOfInterpolatedValues + 1] = (double) valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i4, dArr, dArr2);
        }

        public void setPoint(int i4, ConstraintAttribute constraintAttribute, float f4, int i5, float f5) {
            this.mConstraintAttributeList.append(i4, constraintAttribute);
            this.mWaveProperties.append(i4, new float[]{f4, f5});
            this.mWaveShape = Math.max(this.mWaveShape, i5);
        }
    }

    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setElevation(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f4, long j4, double d5, double d6) {
            View view2 = view;
            view2.setRotation(get(f4, j4, view2, keyCache) + ((float) Math.toDegrees(Math.atan2(d6, d5))));
            return this.mContinue;
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                progressSet = this;
                ((MotionLayout) view).setProgress(get(f4, j4, view, keyCache));
            } else {
                progressSet = this;
                View view2 = view;
                float f5 = f4;
                long j5 = j4;
                KeyCache keyCache2 = keyCache;
                if (progressSet.mNoMethod) {
                    return false;
                }
                try {
                    method = view2.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    progressSet.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    View view3 = view2;
                    try {
                        method.invoke(view3, new Object[]{Float.valueOf(progressSet.get(f5, j5, view3, keyCache2))});
                    } catch (IllegalAccessException e5) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e6);
                    }
                }
            }
            return progressSet.mContinue;
        }
    }

    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setRotation(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setRotationX(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setRotationY(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setScaleX(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setScaleY(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationX(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationY(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        public boolean setProperty(View view, float f4, long j4, KeyCache keyCache) {
            View view2 = view;
            view2.setTranslationZ(get(f4, j4, view2, keyCache));
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j4) {
        ViewTimeCycle viewTimeCycle;
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c5 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c5 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c5 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c5 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c5 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c5 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c5 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c5 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c5 = 11;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                viewTimeCycle = new RotationXset();
                break;
            case 1:
                viewTimeCycle = new RotationYset();
                break;
            case 2:
                viewTimeCycle = new TranslationXset();
                break;
            case 3:
                viewTimeCycle = new TranslationYset();
                break;
            case 4:
                viewTimeCycle = new TranslationZset();
                break;
            case 5:
                viewTimeCycle = new ProgressSet();
                break;
            case 6:
                viewTimeCycle = new ScaleXset();
                break;
            case 7:
                viewTimeCycle = new ScaleYset();
                break;
            case 8:
                viewTimeCycle = new RotationSet();
                break;
            case 9:
                viewTimeCycle = new ElevationSet();
                break;
            case 10:
                viewTimeCycle = new PathRotate();
                break;
            case 11:
                viewTimeCycle = new AlphaSet();
                break;
            default:
                return null;
        }
        viewTimeCycle.setStartTime(j4);
        return viewTimeCycle;
    }

    public float get(float f4, long j4, View view, KeyCache keyCache) {
        boolean z4;
        long j5 = j4;
        View view2 = view;
        KeyCache keyCache2 = keyCache;
        this.mCurveFit.getPos((double) f4, this.mCache);
        float[] fArr = this.mCache;
        float f5 = fArr[1];
        int i4 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i4 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.mLastCycle)) {
            float floatValue = keyCache2.getFloatValue(view2, this.mType, 0);
            this.mLastCycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.mLastCycle = 0.0f;
            }
        }
        float f6 = (float) ((((double) this.mLastCycle) + ((((double) (j5 - this.mLastTime)) * 1.0E-9d) * ((double) f5))) % 1.0d);
        this.mLastCycle = f6;
        keyCache2.setFloatValue(view2, this.mType, 0, f6);
        this.mLastTime = j5;
        float f7 = this.mCache[0];
        float calcWave = (calcWave(this.mLastCycle) * f7) + this.mCache[2];
        if (f7 == 0.0f && i4 == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.mContinue = z4;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f4, long j4, KeyCache keyCache);
}
