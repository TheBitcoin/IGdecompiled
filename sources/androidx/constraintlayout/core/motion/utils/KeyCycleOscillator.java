package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();
    private int mWaveShape = 0;
    private String mWaveString = null;

    private static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setProperty(MotionWidget motionWidget, float f4) {
            motionWidget.setValue(this.mTypeId, get(f4));
        }
    }

    static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst = 0;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase = 1;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue = 2;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int i4, String str, int i5, int i6) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mWaveShape = i4;
            this.mVariesBy = i5;
            oscillator.setType(i4, str);
            this.mValues = new float[i6];
            this.mPosition = new double[i6];
            this.mPeriod = new float[i6];
            this.mOffsetArr = new float[i6];
            this.mPhaseArr = new float[i6];
            this.mScale = new float[i6];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f4) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d5 = (double) f4;
                curveFit.getSlope(d5, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d5, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d6 = (double) f4;
            double value = this.mOscillator.getValue(d6, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d6, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public double getValues(float f4) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos((double) f4, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = (double) this.mOffsetArr[0];
                dArr[1] = (double) this.mPhaseArr[0];
                dArr[2] = (double) this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return dArr2[0] + (this.mOscillator.getValue((double) f4, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public void setPoint(int i4, int i5, float f4, float f5, float f6, float f7) {
            this.mPosition[i4] = ((double) i5) / 100.0d;
            this.mPeriod[i4] = f4;
            this.mOffsetArr[i4] = f5;
            this.mPhaseArr[i4] = f6;
            this.mValues[i4] = f7;
        }

        public void setup(float f4) {
            this.mPathLength = f4;
            int length = this.mPosition.length;
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = length;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[(fArr.length + 2)];
            this.mSplineSlopeCache = new double[(fArr.length + 2)];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length2 = dArr2.length - 1;
            if (dArr2[length2] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length2]);
            }
            for (int i4 = 0; i4 < dArr.length; i4++) {
                double[] dArr3 = dArr[i4];
                dArr3[0] = (double) this.mOffsetArr[i4];
                dArr3[1] = (double) this.mPhaseArr[i4];
                dArr3[2] = (double) this.mValues[i4];
                this.mOscillator.addPoint(this.mPosition[i4], this.mPeriod[i4]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = c.a(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f4, double d5, double d6) {
            motionWidget.setRotationZ(get(f4) + ((float) Math.toDegrees(Math.atan2(d6, d5))));
        }

        public void setProperty(MotionWidget motionWidget, float f4) {
            motionWidget.setValue(this.mTypeId, get(f4));
        }
    }

    static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        WavePoint(int i4, float f4, float f5, float f6, float f7) {
            this.mPosition = i4;
            this.mValue = f7;
            this.mOffset = f5;
            this.mPeriod = f4;
            this.mPhase = f6;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        return new CoreSpline(str);
    }

    public float get(float f4) {
        return (float) this.mCycleOscillator.getValues(f4);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f4) {
        return (float) this.mCycleOscillator.getSlope(f4);
    }

    /* access modifiers changed from: protected */
    public void setCustom(Object obj) {
    }

    public void setPoint(int i4, int i5, String str, int i6, float f4, float f5, float f6, float f7, Object obj) {
        this.mWavePoints.add(new WavePoint(i4, f4, f5, f6, f7));
        if (i6 != -1) {
            this.mVariesBy = i6;
        }
        this.mWaveShape = i5;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f4) {
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f4) {
        int size = this.mWavePoints.size();
        if (size != 0) {
            Collections.sort(this.mWavePoints, new Comparator<WavePoint>() {
                public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                    return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
                }
            });
            double[] dArr = new double[size];
            int[] iArr = new int[2];
            iArr[1] = 3;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
            ArrayList<WavePoint> arrayList = this.mWavePoints;
            int size2 = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size2) {
                int i6 = i4 + 1;
                WavePoint wavePoint = arrayList.get(i4);
                float f5 = wavePoint.mPeriod;
                dArr[i5] = ((double) f5) * 0.01d;
                double[] dArr3 = dArr2[i5];
                float f6 = wavePoint.mValue;
                dArr3[0] = (double) f6;
                float f7 = wavePoint.mOffset;
                dArr3[1] = (double) f7;
                float f8 = wavePoint.mPhase;
                dArr3[2] = (double) f8;
                this.mCycleOscillator.setPoint(i5, wavePoint.mPosition, f5, f7, f8, f6);
                i5++;
                i4 = i6;
                dArr2 = dArr2;
            }
            double[][] dArr4 = dArr2;
            this.mCycleOscillator.setup(f4);
            this.mCurveFit = CurveFit.get(0, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            WavePoint wavePoint = arrayList.get(i4);
            i4++;
            WavePoint wavePoint2 = wavePoint;
            str = str + "[" + wavePoint2.mPosition + " , " + decimalFormat.format((double) wavePoint2.mValue) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        if (this.mVariesBy == 1) {
            return true;
        }
        return false;
    }

    public void setPoint(int i4, int i5, String str, int i6, float f4, float f5, float f6, float f7) {
        this.mWavePoints.add(new WavePoint(i4, f4, f5, f6, f7));
        if (i6 != -1) {
            this.mVariesBy = i6;
        }
        this.mWaveShape = i5;
        this.mWaveString = str;
    }
}
