package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType = 0;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private MotionKeyTrigger[] mKeyTriggers;
    private int mMaxDimension = 4;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private boolean mNoMovement = false;
    private int mPathMotionArc = -1;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private float mQuantizeMotionPhase = Float.NaN;
    private int mQuantizeMotionSteps = -1;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    Rect mTempRect = new Rect();
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    MotionWidget mView;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f4, float[] fArr) {
        float f5 = 0.0f;
        float f6 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f7 = this.mStaggerScale;
            if (((double) f7) != 1.0d) {
                float f8 = this.mStaggerOffset;
                if (f4 < f8) {
                    f4 = 0.0f;
                }
                if (f4 > f8 && ((double) f4) < 1.0d) {
                    f4 = Math.min((f4 - f8) * f7, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f9 = Float.NaN;
        int i4 = 0;
        while (i4 < size) {
            MotionPaths motionPaths = arrayList.get(i4);
            i4++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f10 = motionPaths2.mTime;
                if (f10 < f4) {
                    easing = easing2;
                    f5 = f10;
                } else if (Float.isNaN(f9)) {
                    f9 = motionPaths2.mTime;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f9)) {
                f6 = f9;
            }
            float f11 = f6 - f5;
            double d5 = (double) ((f4 - f5) / f11);
            f4 = (((float) easing.get(d5)) * f11) + f5;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d5);
            }
        }
        return f4;
    }

    private static DifferentialInterpolator getInterpolator(int i4, String str, int i5) {
        if (i4 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() {
            float mX;

            public float getInterpolation(float f4) {
                this.mX = f4;
                return (float) Easing.this.get((double) f4);
            }

            public float getVelocity() {
                return (float) Easing.this.getDiff((double) this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f4 = 1.0f / ((float) 99);
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i4 = 0;
        float f5 = 0.0f;
        while (i4 < 100) {
            float f6 = ((float) i4) * f4;
            double d7 = (double) f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f7 = Float.NaN;
            int i5 = 0;
            float f8 = 0.0f;
            while (i5 < size) {
                MotionPaths motionPaths = arrayList.get(i5);
                i5++;
                MotionPaths motionPaths2 = motionPaths;
                float f9 = f4;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    Easing easing3 = easing2;
                    float f10 = motionPaths2.mTime;
                    if (f10 < f6) {
                        f8 = f10;
                        easing = easing3;
                    } else if (Float.isNaN(f7)) {
                        f7 = motionPaths2.mTime;
                    }
                }
                f4 = f9;
            }
            float f11 = f4;
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                float f12 = f7 - f8;
                d7 = (double) ((((float) easing.get((double) ((f6 - f8) / f12))) * f12) + f8);
            }
            double d8 = d7;
            this.mSpline[0].getPos(d8, this.mInterpolateData);
            int i6 = i4;
            this.mStartMotionPath.getCenter(d8, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i6 > 0) {
                f5 += (float) Math.hypot(d6 - ((double) fArr[1]), d5 - ((double) fArr[0]));
            }
            d5 = (double) fArr[0];
            d6 = (double) fArr[1];
            i4 = i6 + 1;
            f4 = f11;
        }
        return f5;
    }

    private void insertKey(MotionPaths motionPaths) {
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        MotionPaths motionPaths2 = null;
        int i4 = 0;
        while (i4 < size) {
            MotionPaths motionPaths3 = arrayList.get(i4);
            i4++;
            MotionPaths motionPaths4 = motionPaths3;
            if (motionPaths.mPosition == motionPaths4.mPosition) {
                motionPaths2 = motionPaths4;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) this.mView.getX(), (float) this.mView.getY(), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i4) {
        int i5 = i4;
        float f4 = 1.0f;
        float f5 = 1.0f / ((float) (i5 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            KeyCycleOscillator keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            KeyCycleOscillator keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i6 = 0;
        while (i6 < i5) {
            float f6 = ((float) i6) * f5;
            float f7 = this.mStaggerScale;
            float f8 = 0.0f;
            if (f7 != f4) {
                float f9 = this.mStaggerOffset;
                if (f6 < f9) {
                    f6 = 0.0f;
                }
                if (f6 > f9 && ((double) f6) < 1.0d) {
                    f6 = Math.min((f6 - f9) * f7, f4);
                }
            }
            double d5 = (double) f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f10 = Float.NaN;
            int i7 = 0;
            while (i7 < size) {
                MotionPaths motionPaths = arrayList.get(i7);
                i7++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f11 = motionPaths2.mTime;
                    if (f11 < f6) {
                        easing = easing2;
                        f8 = f11;
                    } else if (Float.isNaN(f10)) {
                        f10 = motionPaths2.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f10)) {
                    f10 = 1.0f;
                }
                float f12 = f10 - f8;
                d5 = (double) ((((float) easing.get((double) ((f6 - f8) / f12))) * f12) + f8);
            }
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i6 * 2);
            i6++;
            f4 = 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                MotionPaths motionPaths = arrayList.get(i5);
                i5++;
                iArr[i4] = motionPaths.mMode;
                i4++;
            }
        }
        int i6 = 0;
        for (double pos : timePoints) {
            this.mSpline[0].getPos(pos, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            i6 += 2;
        }
        return i6 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                MotionPaths motionPaths = arrayList.get(i5);
                i5++;
                iArr[i4] = motionPaths.mMode;
                i4++;
            }
        }
        if (iArr2 != null) {
            ArrayList<MotionPaths> arrayList2 = this.mMotionPaths;
            int size2 = arrayList2.size();
            int i6 = 0;
            int i7 = 0;
            while (i7 < size2) {
                MotionPaths motionPaths2 = arrayList2.get(i7);
                i7++;
                iArr2[i6] = (int) (motionPaths2.mPosition * 100.0f);
                i6++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < timePoints.length; i9++) {
            this.mSpline[0].getPos(timePoints[i9], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i9], this.mInterpolateVariables, this.mInterpolateData, fArr, i8);
            i8 += 2;
        }
        return i8 / 2;
    }

    public void buildPath(float[] fArr, int i4) {
        SplineSet splineSet;
        SplineSet splineSet2;
        KeyCycleOscillator keyCycleOscillator;
        int i5 = i4;
        float f4 = 1.0f;
        float f5 = 1.0f / ((float) (i5 - 1));
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            keyCycleOscillator2 = hashMap4.get("translationY");
        }
        int i6 = 0;
        while (i6 < i5) {
            float f6 = ((float) i6) * f5;
            float f7 = this.mStaggerScale;
            float f8 = 0.0f;
            if (f7 != f4) {
                float f9 = this.mStaggerOffset;
                if (f6 < f9) {
                    f6 = 0.0f;
                }
                if (f6 > f9 && ((double) f6) < 1.0d) {
                    f6 = Math.min((f6 - f9) * f7, f4);
                }
            }
            double d5 = (double) f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f10 = Float.NaN;
            int i7 = 0;
            while (i7 < size) {
                MotionPaths motionPaths = arrayList.get(i7);
                i7++;
                MotionPaths motionPaths2 = motionPaths;
                float f11 = f5;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    Easing easing3 = easing2;
                    float f12 = motionPaths2.mTime;
                    if (f12 < f6) {
                        f8 = f12;
                        easing = easing3;
                    } else if (Float.isNaN(f10)) {
                        f10 = motionPaths2.mTime;
                    }
                }
                int i8 = i4;
                f5 = f11;
            }
            float f13 = f5;
            if (easing != null) {
                if (Float.isNaN(f10)) {
                    f10 = 1.0f;
                }
                float f14 = f10 - f8;
                d5 = (double) ((((float) easing.get((double) ((f6 - f8) / f14))) * f14) + f8);
            }
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                }
            }
            int i9 = i6 * 2;
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            if (keyCycleOscillator != null) {
                fArr[i9] = fArr[i9] + keyCycleOscillator.get(f6);
            } else if (splineSet != null) {
                fArr[i9] = fArr[i9] + splineSet.get(f6);
            }
            if (keyCycleOscillator2 != null) {
                int i10 = i9 + 1;
                fArr[i10] = fArr[i10] + keyCycleOscillator2.get(f6);
            } else if (splineSet2 != null) {
                int i11 = i9 + 1;
                fArr[i11] = fArr[i11] + splineSet2.get(f6);
            }
            i6++;
            i5 = i4;
            f5 = f13;
            f4 = 1.0f;
        }
    }

    public void buildRect(float f4, float[] fArr, int i4) {
        this.mSpline[0].getPos((double) getAdjustedPosition(f4, (float[]) null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
    }

    /* access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i4) {
        float f4 = 1.0f / ((float) (i4 - 1));
        for (int i5 = 0; i5 < i4; i5++) {
            this.mSpline[0].getPos((double) getAdjustedPosition(((float) i5) * f4, (float[]) null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i5 * 8);
        }
    }

    /* access modifiers changed from: package-private */
    public void endTrigger(boolean z4) {
    }

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    /* access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i4) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            fArr[i5] = splineSet.get((float) (i5 / (fArr.length - 1)));
        }
        return fArr.length;
    }

    public void getCenter(double d5, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d5, dArr);
        this.mSpline[0].getSlope(d5, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f4, float f5, float f6, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i4 = 0;
        if (curveFitArr != null) {
            double d5 = (double) adjustedPosition;
            curveFitArr[0].getSlope(d5, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            float f7 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i4 >= dArr.length) {
                    break;
                }
                dArr[i4] = dArr[i4] * ((double) f7);
                i4++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d5, dArr2);
                    this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        float f8 = f5;
        float f9 = f6;
        float[] fArr2 = fArr;
        MotionPaths motionPaths = this.mEndMotionPath;
        float f10 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f11 = f10 - motionPaths2.mX;
        float f12 = motionPaths.mY - motionPaths2.mY;
        float f13 = (motionPaths.mWidth - motionPaths2.mWidth) + f11;
        float f14 = (motionPaths.mHeight - motionPaths2.mHeight) + f12;
        fArr2[0] = (f11 * (1.0f - f8)) + (f13 * f8);
        fArr2[1] = (f12 * (1.0f - f9)) + (f14 * f9);
    }

    public int getDrawPath() {
        int i4 = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            MotionPaths motionPaths = arrayList.get(i5);
            i5++;
            i4 = Math.max(i4, motionPaths.mDrawPath);
        }
        return Math.max(i4, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i4) {
        return this.mMotionPaths.get(i4);
    }

    public int getKeyFrameInfo(int i4, int[] iArr) {
        int i5 = i4;
        float[] fArr = new float[2];
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < size) {
            int i9 = i6 + 1;
            MotionKey motionKey = arrayList.get(i6);
            int i10 = motionKey.mType;
            if (i10 == i5 || i5 != -1) {
                iArr[i8] = 0;
                iArr[i8 + 1] = i10;
                int i11 = motionKey.mFramePosition;
                iArr[i8 + 2] = i11;
                double d5 = (double) (((float) i11) / 100.0f);
                this.mSpline[0].getPos(d5, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i8 + 3] = Float.floatToIntBits(fArr[0]);
                int i12 = i8 + 4;
                iArr[i12] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i8 + 5] = motionKeyPosition.mPositionType;
                    iArr[i8 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i12 = i8 + 7;
                    iArr[i12] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i13 = i12 + 1;
                iArr[i8] = i13 - i8;
                i7++;
                i8 = i13;
            }
            i6 = i9;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i4, float f4, float f5) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f6 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f7 = motionPaths2.mX;
        float f8 = f6 - f7;
        float f9 = motionPaths.mY;
        float f10 = motionPaths2.mY;
        float f11 = f9 - f10;
        float f12 = f7 + (motionPaths2.mWidth / 2.0f);
        float f13 = f10 + (motionPaths2.mHeight / 2.0f);
        float hypot = (float) Math.hypot((double) f8, (double) f11);
        if (((double) hypot) < 1.0E-7d) {
            return Float.NaN;
        }
        float f14 = f4 - f12;
        float f15 = f5 - f13;
        if (((float) Math.hypot((double) f14, (double) f15)) == 0.0f) {
            return 0.0f;
        }
        float f16 = (f14 * f8) + (f15 * f11);
        if (i4 == 0) {
            return f16 / hypot;
        }
        if (i4 == 1) {
            return (float) Math.sqrt((double) ((hypot * hypot) - (f16 * f16)));
        }
        if (i4 == 2) {
            return f14 / f8;
        }
        if (i4 == 3) {
            return f15 / f8;
        }
        if (i4 == 4) {
            return f14 / f11;
        }
        if (i4 != 5) {
            return 0.0f;
        }
        return f15 / f11;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            int i7 = i5 + 1;
            MotionKey motionKey = arrayList.get(i5);
            int i8 = motionKey.mFramePosition;
            iArr[i4] = (motionKey.mType * 1000) + i8;
            double d5 = (double) (((float) i8) / 100.0f);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            i6 += 2;
            i5 = i7;
            i4++;
        }
        return i4;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    /* access modifiers changed from: package-private */
    public double[] getPos(double d5) {
        this.mSpline[0].getPos(d5, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d5, dArr);
            }
        }
        return this.mInterpolateData;
    }

    /* access modifiers changed from: package-private */
    public MotionKeyPosition getPositionKeyframe(int i4, int i5, float f4, float f5) {
        float f6;
        float f7;
        int i6;
        int i7;
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f8 = motionPaths.mX;
        floatRect.left = f8;
        float f9 = motionPaths.mY;
        floatRect.top = f9;
        floatRect.right = f8 + motionPaths.mWidth;
        floatRect.bottom = f9 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f10 = motionPaths2.mX;
        floatRect2.left = f10;
        float f11 = motionPaths2.mY;
        floatRect2.top = f11;
        floatRect2.right = f10 + motionPaths2.mWidth;
        floatRect2.bottom = f11 + motionPaths2.mHeight;
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            MotionKey motionKey = arrayList.get(i8);
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                i7 = i4;
                i6 = i5;
                f7 = f4;
                f6 = f5;
                if (motionKeyPosition.intersects(i7, i6, floatRect, floatRect2, f7, f6)) {
                    return motionKeyPosition;
                }
            } else {
                i7 = i4;
                i6 = i5;
                f7 = f4;
                f6 = f5;
            }
            i4 = i7;
            i5 = i6;
            f4 = f7;
            f5 = f6;
            i8 = i9;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f4, int i4, int i5, float f5, float f6, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get("rotationZ");
        }
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap6.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            keyCycleOscillator2 = null;
        } else {
            keyCycleOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            keyCycleOscillator3 = null;
        } else {
            keyCycleOscillator3 = hashMap8.get("rotationZ");
        }
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            keyCycleOscillator4 = null;
        } else {
            keyCycleOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d5 = (double) adjustedPosition;
                curveFit.getPos(d5, dArr);
                this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f5, f6, i4, i5, fArr);
            return;
        }
        int i6 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = (double) getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f7 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i6 < dArr2.length) {
                    dArr2[i6] = dArr2[i6] * ((double) f7);
                    i6++;
                } else {
                    float f8 = f5;
                    float f9 = f6;
                    float[] fArr2 = fArr;
                    this.mStartMotionPath.setDpDt(f8, f9, fArr2, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f8, f9, i4, i5, fArr2);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f10 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f11 = f10 - motionPaths2.mX;
            float f12 = motionPaths.mY - motionPaths2.mY;
            fArr[0] = (f11 * (1.0f - f5)) + (((motionPaths.mWidth - motionPaths2.mWidth) + f11) * f5);
            fArr[1] = (f12 * (1.0f - f6)) + ((f12 + (motionPaths.mHeight - motionPaths2.mHeight)) * f6);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f5, f6, i4, i5, fArr);
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f4, long j4, KeyCache keyCache) {
        float f5;
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f4, (float[]) null);
        int i4 = this.mQuantizeMotionSteps;
        if (i4 != -1) {
            float f6 = 1.0f / ((float) i4);
            float floor = ((float) Math.floor((double) (adjustedPosition / f6))) * f6;
            float f7 = (adjustedPosition % f6) / f6;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f7 = (f7 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            if (differentialInterpolator != null) {
                f5 = differentialInterpolator.getInterpolation(f7);
            } else if (((double) f7) > 0.5d) {
                f5 = 1.0f;
            } else {
                f5 = 0.0f;
            }
            adjustedPosition = (f5 * f6) + floor;
        }
        float f8 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet property : hashMap.values()) {
                property.setProperty(motionWidget2, f8);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d5 = (double) f8;
            curveFitArr[0].getPos(d5, this.mInterpolateData);
            this.mSpline[0].getSlope(d5, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                    this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                float f9 = f8;
                MotionWidget motionWidget3 = motionWidget2;
                float f10 = f9;
                this.mStartMotionPath.setView(f10, motionWidget3, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, (double[]) null);
                MotionWidget motionWidget4 = motionWidget3;
                f8 = f10;
                motionWidget2 = motionWidget4;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                MotionWidget motionWidget5 = this.mTransformPivotView;
                if (motionWidget5 != null) {
                    float top = ((float) (motionWidget5.getTop() + this.mTransformPivotView.getBottom())) / 2.0f;
                    float left = ((float) (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight())) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(left - ((float) motionWidget2.getLeft()));
                        motionWidget2.setPivotY(top - ((float) motionWidget2.getTop()));
                    }
                }
            }
            int i5 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i5 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i5].getPos(d5, this.mValuesBuff);
                this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[i5 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i5++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f8 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.mVisibility);
                } else if (f8 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != motionConstrainedPoint.mVisibility) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i6 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i6 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i6].conditionallyFire(f8, motionWidget2);
                    i6++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f11 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f12 = f11 + ((motionPaths2.mX - f11) * f8);
            float f13 = motionPaths.mY;
            float f14 = f13 + ((motionPaths2.mY - f13) * f8);
            float f15 = motionPaths.mWidth;
            float f16 = f15 + ((motionPaths2.mWidth - f15) * f8);
            float f17 = motionPaths.mHeight;
            float f18 = f12 + 0.5f;
            float f19 = f14 + 0.5f;
            motionWidget2.layout((int) f18, (int) f19, (int) (f18 + f16), (int) (f19 + f17 + ((motionPaths2.mHeight - f17) * f8)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 != null) {
            for (KeyCycleOscillator next : hashMap2.values()) {
                if (next instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) next).setPathRotate(motionWidget2, f8, dArr2[0], dArr2[1]);
                } else {
                    next.setProperty(motionWidget2, f8);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getName();
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f4, float f5, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.mX;
        floatRect.left = f6;
        float f7 = motionPaths.mY;
        floatRect.top = f7;
        floatRect.right = f6 + motionPaths.mWidth;
        floatRect.bottom = f7 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.mX;
        floatRect2.left = f8;
        float f9 = motionPaths2.mY;
        floatRect2.top = f9;
        floatRect2.right = f8 + motionPaths2.mWidth;
        floatRect2.bottom = f9 + motionPaths2.mHeight;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f4, f5, strArr, fArr);
    }

    /* access modifiers changed from: package-private */
    public void rotate(Rect rect, Rect rect2, int i4, int i5, int i6) {
        if (i4 == 1) {
            int i7 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i6 - ((i7 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i4 == 2) {
            int i8 = rect.left + rect.right;
            rect2.left = i5 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i8 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i4 == 3) {
            int i9 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i9 / 2);
            rect2.top = i6 - ((i9 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i4 == 4) {
            int i10 = rect.left + rect.right;
            rect2.left = i5 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i10 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    /* access modifiers changed from: package-private */
    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mEndMotionPath.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i4) {
        this.mStartMotionPath.mDrawPath = i4;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds((float) motionWidget.getLeft(), (float) motionWidget.getTop(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setIdString(String str) {
        this.mId = str;
        this.mStartMotionPath.mId = str;
    }

    public void setPathMotionArc(int i4) {
        this.mPathMotionArc = i4;
    }

    public void setStaggerOffset(float f4) {
        this.mStaggerOffset = f4;
    }

    public void setStaggerScale(float f4) {
        this.mStaggerScale = f4;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds((float) motionWidget.getX(), (float) motionWidget.getY(), (float) motionWidget.getWidth(), (float) motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta((TypedValues) this);
        }
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i4, int i5, int i6) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i4 == 1) {
            int i7 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i5 - ((i7 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i4 == 2) {
            int i8 = viewState.left + viewState.right;
            rect.left = i6 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i8 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        this.mStartPoint.setState(rect, motionWidget, i4, viewState.rotation);
    }

    public void setTransformPivotTarget(int i4) {
        this.mTransformPivotTarget = i4;
        this.mTransformPivotView = null;
    }

    public boolean setValue(int i4, boolean z4) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    public void setup(int i4, int i5, float f4, long j4) {
        ArrayList arrayList;
        char c5;
        HashSet hashSet;
        HashSet hashSet2;
        String[] strArr;
        boolean z4;
        int i6;
        int i7;
        CustomVariable customVariable;
        int i8;
        SplineSet splineSet;
        CustomVariable customVariable2;
        int i9;
        Integer num;
        HashSet hashSet3;
        HashSet hashSet4;
        SplineSet splineSet2;
        CustomVariable customVariable3;
        long j5 = j4;
        new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashMap hashMap = new HashMap();
        setupRelative();
        int i10 = this.mPathMotionArc;
        if (i10 != -1) {
            MotionPaths motionPaths = this.mStartMotionPath;
            if (motionPaths.mPathMotionArc == -1) {
                motionPaths.mPathMotionArc = i10;
            }
        }
        this.mStartPoint.different(this.mEndPoint, hashSet6);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        int i11 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            arrayList = null;
            int i12 = 0;
            while (i12 < size) {
                MotionKey motionKey = arrayList2.get(i12);
                i12++;
                MotionKey motionKey2 = motionKey;
                if (motionKey2 instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey2;
                    insertKey(new MotionPaths(i4, i5, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i13 = motionKeyPosition.mCurveFit;
                    if (i13 != -1) {
                        this.mCurveFitType = i13;
                    }
                } else if (motionKey2 instanceof MotionKeyCycle) {
                    motionKey2.getAttributeNames(hashSet7);
                } else if (motionKey2 instanceof MotionKeyTimeCycle) {
                    motionKey2.getAttributeNames(hashSet5);
                } else if (motionKey2 instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey2);
                } else {
                    motionKey2.setInterpolation(hashMap);
                    motionKey2.getAttributeNames(hashSet6);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        char c6 = 1;
        if (!hashSet6.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it = hashSet6.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = str.split(",")[c6];
                    ArrayList<MotionKey> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    while (i11 < size2) {
                        MotionKey motionKey3 = arrayList3.get(i11);
                        i11++;
                        HashSet hashSet8 = hashSet5;
                        MotionKey motionKey4 = motionKey3;
                        HashSet hashSet9 = hashSet7;
                        HashMap<String, CustomVariable> hashMap2 = motionKey4.mCustom;
                        if (!(hashMap2 == null || (customVariable3 = hashMap2.get(str2)) == null)) {
                            customVar.append(motionKey4.mFramePosition, customVariable3);
                        }
                        hashSet7 = hashSet9;
                        hashSet5 = hashSet8;
                    }
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    splineSet2 = SplineSet.makeCustomSplineSet(str, customVar);
                } else {
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    splineSet2 = SplineSet.makeSpline(str, j5);
                }
                if (splineSet2 != null) {
                    splineSet2.setType(str);
                    this.mAttributesMap.put(str, splineSet2);
                }
                hashSet7 = hashSet4;
                hashSet5 = hashSet3;
                i11 = 0;
                c6 = 1;
            }
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            c5 = 1;
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i14 = 0;
                while (i14 < size3) {
                    MotionKey motionKey5 = arrayList4.get(i14);
                    i14++;
                    MotionKey motionKey6 = motionKey5;
                    if (motionKey6 instanceof MotionKeyAttributes) {
                        motionKey6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String next : this.mAttributesMap.keySet()) {
                if (!hashMap.containsKey(next) || (num = (Integer) hashMap.get(next)) == null) {
                    i9 = 0;
                } else {
                    i9 = num.intValue();
                }
                SplineSet splineSet3 = this.mAttributesMap.get(next);
                if (splineSet3 != null) {
                    splineSet3.setup(i9);
                }
            }
        } else {
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            c5 = 1;
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                if (!this.mTimeCycleAttributesMap.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str4 = str3.split(",")[c5];
                        ArrayList<MotionKey> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            MotionKey motionKey7 = arrayList5.get(i15);
                            i15++;
                            MotionKey motionKey8 = motionKey7;
                            HashMap<String, CustomVariable> hashMap3 = motionKey8.mCustom;
                            if (!(hashMap3 == null || (customVariable2 = hashMap3.get(str4)) == null)) {
                                customVar2.append(motionKey8.mFramePosition, customVariable2);
                            }
                        }
                        splineSet = SplineSet.makeCustomSplineSet(str3, customVar2);
                    } else {
                        splineSet = SplineSet.makeSpline(str3, j5);
                    }
                    if (splineSet != null) {
                        splineSet.setType(str3);
                    }
                }
            }
            ArrayList<MotionKey> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i16 = 0;
                while (i16 < size5) {
                    MotionKey motionKey9 = arrayList6.get(i16);
                    i16++;
                    MotionKey motionKey10 = motionKey9;
                    if (motionKey10 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String next2 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(next2)) {
                    i8 = ((Integer) hashMap.get(next2)).intValue();
                } else {
                    i8 = 0;
                }
                this.mTimeCycleAttributesMap.get(next2).setup(i8);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i17 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i17];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i18 = 0;
        int i19 = 1;
        while (i18 < size7) {
            MotionPaths motionPaths2 = arrayList7.get(i18);
            i18++;
            motionPathsArr[i19] = motionPaths2;
            i19++;
        }
        HashSet hashSet10 = new HashSet();
        for (String next3 : this.mEndMotionPath.mCustomAttributes.keySet()) {
            if (this.mStartMotionPath.mCustomAttributes.containsKey(next3)) {
                if (!hashSet6.contains("CUSTOM," + next3)) {
                    hashSet10.add(next3);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet10.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i20 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i20 >= strArr.length) {
                break;
            }
            String str5 = strArr[i20];
            this.mAttributeInterpolatorCount[i20] = 0;
            int i21 = 0;
            while (true) {
                if (i21 < i17) {
                    if (motionPathsArr[i21].mCustomAttributes.containsKey(str5) && (customVariable = motionPathsArr[i21].mCustomAttributes.get(str5)) != null) {
                        int[] iArr = this.mAttributeInterpolatorCount;
                        iArr[i20] = iArr[i20] + customVariable.numberOfInterpolatedValues();
                        break;
                    }
                    i21++;
                } else {
                    break;
                }
            }
            i20++;
        }
        if (motionPathsArr[0].mPathMotionArc != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i22 = 1; i22 < i17; i22++) {
            motionPathsArr[i22].different(motionPathsArr[i22 - 1], zArr, this.mAttributeNames, z4);
        }
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                i23++;
            }
        }
        this.mInterpolateVariables = new int[i23];
        int i25 = 2;
        int max = Math.max(2, i23);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i26 = 0;
        for (int i27 = 1; i27 < length; i27++) {
            if (zArr[i27]) {
                this.mInterpolateVariables[i26] = i27;
                i26++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[c5] = this.mInterpolateVariables.length;
        iArr2[0] = i17;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance(cls, iArr2);
        double[] dArr2 = new double[i17];
        for (int i28 = 0; i28 < i17; i28++) {
            motionPathsArr[i28].fillStandard(dArr[i28], this.mInterpolateVariables);
            dArr2[i28] = (double) motionPathsArr[i28].mTime;
        }
        int i29 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i29 >= iArr3.length) {
                break;
            }
            if (iArr3[i29] < MotionPaths.sNames.length) {
                String str6 = MotionPaths.sNames[this.mInterpolateVariables[i29]] + " [";
                for (int i30 = 0; i30 < i17; i30++) {
                    str6 = str6 + dArr[i30][i29];
                }
            }
            i29++;
        }
        this.mSpline = new CurveFit[(this.mAttributeNames.length + 1)];
        int i31 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i31 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i31];
            int i32 = 0;
            int i33 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i32 < i17) {
                if (motionPathsArr[i32].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i17];
                        int[] iArr4 = new int[i25];
                        iArr4[c5] = motionPathsArr[i32].getCustomDataCount(str7);
                        i7 = 0;
                        iArr4[0] = i17;
                        dArr4 = (double[][]) Array.newInstance(cls, iArr4);
                    } else {
                        i7 = 0;
                    }
                    MotionPaths motionPaths3 = motionPathsArr[i32];
                    i6 = i31;
                    dArr3[i33] = (double) motionPaths3.mTime;
                    motionPaths3.getCustomData(str7, dArr4[i33], i7);
                    i33++;
                } else {
                    i6 = i31;
                }
                i32++;
                i31 = i6;
                i25 = 2;
            }
            int i34 = i31 + 1;
            this.mSpline[i34] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i33), (double[][]) Arrays.copyOf(dArr4, i33));
            i31 = i34;
            i25 = 2;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr5 = new int[i17];
            double[] dArr5 = new double[i17];
            int[] iArr6 = new int[2];
            iArr6[c5] = 2;
            iArr6[0] = i17;
            double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr6);
            for (int i35 = 0; i35 < i17; i35++) {
                MotionPaths motionPaths4 = motionPathsArr[i35];
                iArr5[i35] = motionPaths4.mPathMotionArc;
                dArr5[i35] = (double) motionPaths4.mTime;
                double[] dArr7 = dArr6[i35];
                dArr7[0] = (double) motionPaths4.mX;
                dArr7[c5] = (double) motionPaths4.mY;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it3 = hashSet2.iterator();
            float f5 = Float.NaN;
            while (it3.hasNext()) {
                String str8 = (String) it3.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(str8);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f5)) {
                        f5 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(str8);
                    this.mCycleMap.put(str8, makeWidgetCycle);
                }
            }
            ArrayList<MotionKey> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i36 = 0;
            while (i36 < size8) {
                MotionKey motionKey11 = arrayList8.get(i36);
                i36++;
                MotionKey motionKey12 = motionKey11;
                if (motionKey12 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey12).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f5);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mRelativeMotion = motion;
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    private void setupRelative() {
        Motion motion = this.mRelativeMotion;
        if (motion != null) {
            this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
            MotionPaths motionPaths = this.mEndMotionPath;
            Motion motion2 = this.mRelativeMotion;
            motionPaths.setupRelative(motion2, motion2.mEndMotionPath);
        }
    }

    public boolean setValue(int i4, int i5) {
        if (i4 == 509) {
            setPathMotionArc(i5);
            return true;
        } else if (i4 != 610) {
            return i4 == 704;
        } else {
            this.mQuantizeMotionSteps = i5;
            return true;
        }
    }

    public boolean setValue(int i4, float f4) {
        if (602 == i4) {
            this.mQuantizeMotionPhase = f4;
            return true;
        } else if (600 != i4) {
            return false;
        } else {
            this.mMotionStagger = f4;
            return true;
        }
    }

    public boolean setValue(int i4, String str) {
        if (705 == i4 || 611 == i4) {
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
            return true;
        } else if (605 != i4) {
            return false;
        } else {
            this.mStartMotionPath.mAnimateRelativeTo = str;
            return true;
        }
    }
}
