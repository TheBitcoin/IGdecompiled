package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType = -1;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    boolean mForceMeasure = false;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private KeyTrigger[] mKeyTriggers;
    private int mMaxDimension = 4;
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    float mMotionStagger = Float.NaN;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    Rect mTempRect = new Rect();
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff = new float[4];
    private float[] mVelocity = new float[1];
    View mView;

    MotionController(View view) {
        int i4 = Key.UNSET;
        this.mPathMotionArc = i4;
        this.mTransformPivotTarget = i4;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i4;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i4, String str, int i5) {
        if (i4 == -2) {
            return AnimationUtils.loadInterpolator(context, i5);
        }
        if (i4 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() {
                public float getInterpolation(float f4) {
                    return (float) Easing.this.get((double) f4);
                }
            };
        } else if (i4 == 0) {
            return new AccelerateDecelerateInterpolator();
        } else {
            if (i4 == 1) {
                return new AccelerateInterpolator();
            }
            if (i4 == 2) {
                return new DecelerateInterpolator();
            }
            if (i4 == 4) {
                return new BounceInterpolator();
            }
            if (i4 != 5) {
                return null;
            }
            return new OvershootInterpolator();
        }
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
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float) ((int) this.mView.getX()), (float) ((int) this.mView.getY()), (float) this.mView.getWidth(), (float) this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void buildBounds(float[] fArr, int i4) {
        int i5 = i4;
        float f4 = 1.0f;
        float f5 = 1.0f / ((float) (i5 - 1));
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            SplineSet splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            SplineSet splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            ViewOscillator viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            ViewOscillator viewOscillator2 = hashMap4.get("translationY");
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

    /* access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        for (int i7 = 0; i7 < timePoints.length; i7++) {
            this.mSpline[0].getPos(timePoints[i7], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i7], this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            i6 += 2;
        }
        return i6 / 2;
    }

    /* access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i4) {
        SplineSet splineSet;
        SplineSet splineSet2;
        ViewOscillator viewOscillator;
        int i5 = i4;
        float f4 = 1.0f;
        float f5 = 1.0f / ((float) (i5 - 1));
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator2 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            viewOscillator2 = hashMap4.get("translationY");
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
            if (viewOscillator != null) {
                fArr[i9] = fArr[i9] + viewOscillator.get(f6);
            } else if (splineSet != null) {
                fArr[i9] = fArr[i9] + splineSet.get(f6);
            }
            if (viewOscillator2 != null) {
                int i10 = i9 + 1;
                fArr[i10] = fArr[i10] + viewOscillator2.get(f6);
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

    /* access modifiers changed from: package-private */
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
        float f4;
        if ("button".equals(Debug.getName(this.mView)) && this.mKeyTriggers != null) {
            int i4 = 0;
            while (true) {
                KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                if (i4 < keyTriggerArr.length) {
                    KeyTrigger keyTrigger = keyTriggerArr[i4];
                    if (z4) {
                        f4 = -100.0f;
                    } else {
                        f4 = 100.0f;
                    }
                    keyTrigger.conditionallyFire(f4, this.mView);
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public int getAnimateRelativeTo() {
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

    /* access modifiers changed from: package-private */
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

    /* access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i4) {
        return this.mMotionPaths.get(i4);
    }

    public int getKeyFrameInfo(int i4, int[] iArr) {
        int i5 = i4;
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < size) {
            int i9 = i6 + 1;
            Key key = arrayList.get(i6);
            int i10 = key.mType;
            if (i10 == i5 || i5 != -1) {
                iArr[i8] = 0;
                iArr[i8 + 1] = i10;
                int i11 = key.mFramePosition;
                iArr[i8 + 2] = i11;
                double d5 = (double) (((float) i11) / 100.0f);
                this.mSpline[0].getPos(d5, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i8 + 3] = Float.floatToIntBits(fArr[0]);
                int i12 = i8 + 4;
                iArr[i12] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i8 + 5] = keyPosition.mPositionType;
                    iArr[i8 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i12 = i8 + 7;
                    iArr[i12] = Float.floatToIntBits(keyPosition.mPercentY);
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
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            int i7 = i5 + 1;
            Key key = arrayList.get(i5);
            int i8 = key.mFramePosition;
            iArr[i4] = (key.mType * 1000) + i8;
            double d5 = (double) (((float) i8) / 100.0f);
            this.mSpline[0].getPos(d5, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d5, this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            i6 += 2;
            i5 = i7;
            i4++;
        }
        return i4;
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
    public KeyPositionBase getPositionKeyframe(int i4, int i5, float f4, float f5) {
        float f6;
        float f7;
        int i6;
        int i7;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f8 = motionPaths.mX;
        rectF.left = f8;
        float f9 = motionPaths.mY;
        rectF.top = f9;
        rectF.right = f8 + motionPaths.mWidth;
        rectF.bottom = f9 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f10 = motionPaths2.mX;
        rectF2.left = f10;
        float f11 = motionPaths2.mY;
        rectF2.top = f11;
        rectF2.right = f10 + motionPaths2.mWidth;
        rectF2.bottom = f11 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            int i9 = i8 + 1;
            Key key = arrayList.get(i8);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i7 = i4;
                i6 = i5;
                f7 = f4;
                f6 = f5;
                if (keyPositionBase.intersects(i7, i6, rectF, rectF2, f7, f6)) {
                    return keyPositionBase;
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
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        ViewOscillator viewOscillator3;
        ViewOscillator viewOscillator4;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewOscillator viewOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get(Key.ROTATION);
        }
        HashMap<String, ViewSpline> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, ViewSpline> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, ViewOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            viewOscillator = null;
        } else {
            viewOscillator = hashMap6.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            viewOscillator2 = null;
        } else {
            viewOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            viewOscillator3 = null;
        } else {
            viewOscillator3 = hashMap8.get(Key.ROTATION);
        }
        HashMap<String, ViewOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            viewOscillator4 = null;
        } else {
            viewOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, ViewOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            viewOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator4, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
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
            velocityMatrix.setRotationVelocity((KeyCycleOscillator) viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity((KeyCycleOscillator) viewOscillator, (KeyCycleOscillator) viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity((KeyCycleOscillator) viewOscillator4, (KeyCycleOscillator) viewOscillator5, adjustedPosition);
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

    public View getView() {
        return this.mView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean interpolate(android.view.View r21, float r22, long r23, androidx.constraintlayout.core.motion.utils.KeyCache r25) {
        /*
            r20 = this;
            r0 = r20
            r2 = r21
            r1 = 0
            r3 = r22
            float r3 = r0.getAdjustedPosition(r3, r1)
            int r4 = r0.mQuantizeMotionSteps
            int r5 = androidx.constraintlayout.motion.widget.Key.UNSET
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r4 == r5) goto L_0x0045
            float r4 = (float) r4
            float r4 = r12 / r4
            float r5 = r3 / r4
            double r5 = (double) r5
            double r5 = java.lang.Math.floor(r5)
            float r5 = (float) r5
            float r5 = r5 * r4
            float r3 = r3 % r4
            float r3 = r3 / r4
            float r6 = r0.mQuantizeMotionPhase
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L_0x002e
            float r6 = r0.mQuantizeMotionPhase
            float r3 = r3 + r6
            float r3 = r3 % r12
        L_0x002e:
            android.view.animation.Interpolator r6 = r0.mQuantizeMotionInterpolator
            if (r6 == 0) goto L_0x0037
            float r3 = r6.getInterpolation(r3)
            goto L_0x0042
        L_0x0037:
            double r6 = (double) r3
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0041
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            float r3 = r3 * r4
            float r3 = r3 + r5
        L_0x0045:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r4 = r0.mAttributesMap
            if (r4 == 0) goto L_0x0061
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L_0x0051:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0061
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.motion.utils.ViewSpline r5 = (androidx.constraintlayout.motion.utils.ViewSpline) r5
            r5.setProperty(r2, r3)
            goto L_0x0051
        L_0x0061:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r4 = r0.mTimeCycleAttributesMap
            r13 = 0
            if (r4 == 0) goto L_0x0093
            java.util.Collection r4 = r4.values()
            java.util.Iterator r7 = r4.iterator()
            r8 = r1
            r9 = 0
        L_0x0070:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0090
            java.lang.Object r1 = r7.next()
            androidx.constraintlayout.motion.utils.ViewTimeCycle r1 = (androidx.constraintlayout.motion.utils.ViewTimeCycle) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate
            if (r4 == 0) goto L_0x0084
            r8 = r1
            androidx.constraintlayout.motion.utils.ViewTimeCycle$PathRotate r8 = (androidx.constraintlayout.motion.utils.ViewTimeCycle.PathRotate) r8
            goto L_0x0070
        L_0x0084:
            r4 = r23
            r6 = r25
            boolean r1 = r1.setProperty(r2, r3, r4, r6)
            r9 = r9 | r1
            r2 = r21
            goto L_0x0070
        L_0x0090:
            r14 = r9
            r9 = r8
            goto L_0x0095
        L_0x0093:
            r9 = r1
            r14 = 0
        L_0x0095:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r15 = 1
            if (r1 == 0) goto L_0x01f7
            r1 = r1[r13]
            double r4 = (double) r3
            double[] r2 = r0.mInterpolateData
            r1.getPos((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit[] r1 = r0.mSpline
            r1 = r1[r13]
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            if (r1 == 0) goto L_0x00be
            double[] r2 = r0.mInterpolateData
            int r6 = r2.length
            if (r6 <= 0) goto L_0x00be
            r1.getPos((double) r4, (double[]) r2)
            androidx.constraintlayout.core.motion.utils.CurveFit r1 = r0.mArcSpline
            double[] r2 = r0.mInterpolateVelocity
            r1.getSlope((double) r4, (double[]) r2)
        L_0x00be:
            boolean r1 = r0.mNoMovement
            if (r1 != 0) goto L_0x00e6
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            r5 = r4
            int[] r4 = r0.mInterpolateVariables
            r6 = r5
            double[] r5 = r0.mInterpolateData
            r7 = r6
            double[] r6 = r0.mInterpolateVelocity
            r16 = r7
            r7 = 0
            boolean r8 = r0.mForceMeasure
            r2 = r3
            r11 = r16
            r22 = 0
            r18 = 1065353216(0x3f800000, float:1.0)
            r3 = r21
            r1.setView(r2, r3, r4, r5, r6, r7, r8)
            r19 = r3
            r3 = r2
            r2 = r19
            r0.mForceMeasure = r13
            goto L_0x00ed
        L_0x00e6:
            r2 = r21
            r11 = r4
            r22 = 0
            r18 = 1065353216(0x3f800000, float:1.0)
        L_0x00ed:
            int r1 = r0.mTransformPivotTarget
            int r4 = androidx.constraintlayout.motion.widget.Key.UNSET
            if (r1 == r4) goto L_0x014f
            android.view.View r1 = r0.mTransformPivotView
            if (r1 != 0) goto L_0x0105
            android.view.ViewParent r1 = r2.getParent()
            android.view.View r1 = (android.view.View) r1
            int r4 = r0.mTransformPivotTarget
            android.view.View r1 = r1.findViewById(r4)
            r0.mTransformPivotView = r1
        L_0x0105:
            android.view.View r1 = r0.mTransformPivotView
            if (r1 == 0) goto L_0x014f
            int r1 = r1.getTop()
            android.view.View r4 = r0.mTransformPivotView
            int r4 = r4.getBottom()
            int r1 = r1 + r4
            float r1 = (float) r1
            r4 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r4
            android.view.View r5 = r0.mTransformPivotView
            int r5 = r5.getLeft()
            android.view.View r6 = r0.mTransformPivotView
            int r6 = r6.getRight()
            int r5 = r5 + r6
            float r5 = (float) r5
            float r5 = r5 / r4
            int r4 = r2.getRight()
            int r6 = r2.getLeft()
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x014f
            int r4 = r2.getBottom()
            int r6 = r2.getTop()
            int r4 = r4 - r6
            if (r4 <= 0) goto L_0x014f
            int r4 = r2.getLeft()
            float r4 = (float) r4
            float r5 = r5 - r4
            int r4 = r2.getTop()
            float r4 = (float) r4
            float r1 = r1 - r4
            r2.setPivotX(r5)
            r2.setPivotY(r1)
        L_0x014f:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r1 = r0.mAttributesMap
            if (r1 == 0) goto L_0x017f
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x015b:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x017f
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.core.motion.utils.SplineSet r1 = (androidx.constraintlayout.core.motion.utils.SplineSet) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewSpline.PathRotate
            if (r4 == 0) goto L_0x017c
            double[] r4 = r0.mInterpolateVelocity
            int r5 = r4.length
            if (r5 <= r15) goto L_0x017c
            androidx.constraintlayout.motion.utils.ViewSpline$PathRotate r1 = (androidx.constraintlayout.motion.utils.ViewSpline.PathRotate) r1
            r5 = r4[r13]
            r16 = r4[r15]
            r4 = r5
            r6 = r16
            r1.setPathRotate(r2, r3, r4, r6)
        L_0x017c:
            r2 = r21
            goto L_0x015b
        L_0x017f:
            if (r9 == 0) goto L_0x0197
            double[] r1 = r0.mInterpolateVelocity
            r7 = r1[r13]
            r4 = r1[r15]
            r2 = r21
            r1 = r9
            r9 = r4
            r5 = r23
            r4 = r3
            r3 = r25
            boolean r1 = r1.setPathRotate(r2, r3, r4, r5, r7, r9)
            r3 = r4
            r14 = r14 | r1
            goto L_0x0199
        L_0x0197:
            r2 = r21
        L_0x0199:
            r1 = 1
        L_0x019a:
            androidx.constraintlayout.core.motion.utils.CurveFit[] r4 = r0.mSpline
            int r5 = r4.length
            if (r1 >= r5) goto L_0x01be
            r4 = r4[r1]
            float[] r5 = r0.mValuesBuff
            r4.getPos((double) r11, (float[]) r5)
            androidx.constraintlayout.motion.widget.MotionPaths r4 = r0.mStartMotionPath
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r4 = r4.mAttributes
            java.lang.String[] r5 = r0.mAttributeNames
            int r6 = r1 + -1
            r5 = r5[r6]
            java.lang.Object r4 = r4.get(r5)
            androidx.constraintlayout.widget.ConstraintAttribute r4 = (androidx.constraintlayout.widget.ConstraintAttribute) r4
            float[] r5 = r0.mValuesBuff
            androidx.constraintlayout.motion.utils.CustomSupport.setInterpolatedValue(r4, r2, r5)
            int r1 = r1 + 1
            goto L_0x019a
        L_0x01be:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mStartPoint
            int r4 = r1.mVisibilityMode
            if (r4 != 0) goto L_0x01e5
            int r4 = (r3 > r22 ? 1 : (r3 == r22 ? 0 : -1))
            if (r4 > 0) goto L_0x01ce
            int r1 = r1.mVisibility
            r2.setVisibility(r1)
            goto L_0x01e5
        L_0x01ce:
            int r4 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r4 < 0) goto L_0x01da
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r1 = r0.mEndPoint
            int r1 = r1.mVisibility
            r2.setVisibility(r1)
            goto L_0x01e5
        L_0x01da:
            androidx.constraintlayout.motion.widget.MotionConstrainedPoint r4 = r0.mEndPoint
            int r4 = r4.mVisibility
            int r1 = r1.mVisibility
            if (r4 == r1) goto L_0x01e5
            r2.setVisibility(r13)
        L_0x01e5:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r1 = r0.mKeyTriggers
            if (r1 == 0) goto L_0x024b
            r1 = 0
        L_0x01ea:
            androidx.constraintlayout.motion.widget.KeyTrigger[] r4 = r0.mKeyTriggers
            int r5 = r4.length
            if (r1 >= r5) goto L_0x024b
            r4 = r4[r1]
            r4.conditionallyFire(r3, r2)
            int r1 = r1 + 1
            goto L_0x01ea
        L_0x01f7:
            r2 = r21
            androidx.constraintlayout.motion.widget.MotionPaths r1 = r0.mStartMotionPath
            float r4 = r1.mX
            androidx.constraintlayout.motion.widget.MotionPaths r5 = r0.mEndMotionPath
            float r6 = r5.mX
            float r6 = r6 - r4
            float r6 = r6 * r3
            float r4 = r4 + r6
            float r6 = r1.mY
            float r7 = r5.mY
            float r7 = r7 - r6
            float r7 = r7 * r3
            float r6 = r6 + r7
            float r7 = r1.mWidth
            float r8 = r5.mWidth
            float r9 = r8 - r7
            float r9 = r9 * r3
            float r9 = r9 + r7
            float r1 = r1.mHeight
            float r5 = r5.mHeight
            float r10 = r5 - r1
            float r10 = r10 * r3
            float r10 = r10 + r1
            r11 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r11
            int r12 = (int) r4
            float r6 = r6 + r11
            int r11 = (int) r6
            float r4 = r4 + r9
            int r4 = (int) r4
            float r6 = r6 + r10
            int r6 = (int) r6
            int r9 = r4 - r12
            int r10 = r6 - r11
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0239
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0239
            boolean r1 = r0.mForceMeasure
            if (r1 == 0) goto L_0x0248
        L_0x0239:
            r1 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r1)
            r2.measure(r5, r1)
            r0.mForceMeasure = r13
        L_0x0248:
            r2.layout(r12, r11, r4, r6)
        L_0x024b:
            java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewOscillator> r1 = r0.mCycleMap
            if (r1 == 0) goto L_0x0279
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x0257:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0279
            java.lang.Object r1 = r8.next()
            androidx.constraintlayout.motion.utils.ViewOscillator r1 = (androidx.constraintlayout.motion.utils.ViewOscillator) r1
            boolean r4 = r1 instanceof androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet
            if (r4 == 0) goto L_0x0275
            androidx.constraintlayout.motion.utils.ViewOscillator$PathRotateSet r1 = (androidx.constraintlayout.motion.utils.ViewOscillator.PathRotateSet) r1
            double[] r4 = r0.mInterpolateVelocity
            r5 = r4[r13]
            r9 = r4[r15]
            r4 = r5
            r6 = r9
            r1.setPathRotate(r2, r3, r4, r6)
            goto L_0x0257
        L_0x0275:
            r1.setProperty(r2, r3)
            goto L_0x0257
        L_0x0279:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.interpolate(android.view.View, float, long, androidx.constraintlayout.core.motion.utils.KeyCache):boolean");
    }

    /* access modifiers changed from: package-private */
    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f4, float f5, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.mX;
        rectF.left = f6;
        float f7 = motionPaths.mY;
        rectF.top = f7;
        rectF.right = f6 + motionPaths.mWidth;
        rectF.bottom = f7 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.mX;
        rectF2.left = f8;
        float f9 = motionPaths2.mY;
        rectF2.top = f9;
        rectF2.right = f8 + motionPaths2.mWidth;
        rectF2.bottom = f9 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f4, f5, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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
    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i4) {
        this.mStartMotionPath.mDrawPath = i4;
    }

    /* access modifiers changed from: package-private */
    public void setEndState(Rect rect, ConstraintSet constraintSet, int i4, int i5) {
        MotionController motionController;
        int i6 = constraintSet.mRotate;
        if (i6 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i6, i4, i5);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
            Rect rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i6, motionController.mId);
    }

    public void setPathMotionArc(int i4) {
        this.mPathMotionArc = i4;
    }

    /* access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i4, int i5, int i6) {
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
        this.mStartPoint.setState(rect, view, i4, viewState.rotation);
    }

    public void setTransformPivotTarget(int i4) {
        this.mTransformPivotTarget = i4;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i4, int i5, float f4, long j4) {
        ArrayList arrayList;
        char c5;
        String[] strArr;
        boolean z4;
        int i6;
        int i7;
        ConstraintAttribute constraintAttribute;
        int i8;
        ViewTimeCycle viewTimeCycle;
        ConstraintAttribute constraintAttribute2;
        int i9;
        Integer num;
        ViewSpline viewSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap hashMap = new HashMap();
        int i10 = this.mPathMotionArc;
        if (i10 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i10;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            arrayList = null;
            int i11 = 0;
            while (i11 < size) {
                Key key = arrayList2.get(i11);
                i11++;
                Key key2 = key;
                if (key2 instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key2;
                    insertKey(new MotionPaths(i4, i5, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i12 = keyPosition.mCurveFit;
                    if (i12 != Key.UNSET) {
                        this.mCurveFitType = i12;
                    }
                } else if (key2 instanceof KeyCycle) {
                    key2.getAttributeNames(hashSet3);
                } else if (key2 instanceof KeyTimeCycle) {
                    key2.getAttributeNames(hashSet);
                } else if (key2 instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key2);
                } else {
                    key2.setInterpolation(hashMap);
                    key2.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c6 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[c6];
                    ArrayList<Key> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    int i13 = 0;
                    while (i13 < size2) {
                        Key key3 = arrayList3.get(i13);
                        i13++;
                        Key key4 = key3;
                        HashMap<String, ConstraintAttribute> hashMap2 = key4.mCustomConstraints;
                        if (!(hashMap2 == null || (constraintAttribute3 = hashMap2.get(str2)) == null)) {
                            sparseArray.append(key4.mFramePosition, constraintAttribute3);
                        }
                    }
                    viewSpline = ViewSpline.makeCustomSpline(str, sparseArray);
                } else {
                    viewSpline = ViewSpline.makeSpline(str);
                }
                if (viewSpline != null) {
                    viewSpline.setType(str);
                    this.mAttributesMap.put(str, viewSpline);
                }
                c6 = 1;
            }
            c5 = 1;
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i14 = 0;
                while (i14 < size3) {
                    Key key5 = arrayList4.get(i14);
                    i14++;
                    Key key6 = key5;
                    if (key6 instanceof KeyAttributes) {
                        key6.addValues(this.mAttributesMap);
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
                SplineSet splineSet = this.mAttributesMap.get(next);
                if (splineSet != null) {
                    splineSet.setup(i9);
                }
            }
        } else {
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
                        SparseArray sparseArray2 = new SparseArray();
                        String str4 = str3.split(",")[c5];
                        ArrayList<Key> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            Key key7 = arrayList5.get(i15);
                            i15++;
                            Key key8 = key7;
                            HashMap<String, ConstraintAttribute> hashMap3 = key8.mCustomConstraints;
                            if (!(hashMap3 == null || (constraintAttribute2 = hashMap3.get(str4)) == null)) {
                                sparseArray2.append(key8.mFramePosition, constraintAttribute2);
                            }
                        }
                        viewTimeCycle = ViewTimeCycle.makeCustomSpline(str3, sparseArray2);
                        long j5 = j4;
                    } else {
                        viewTimeCycle = ViewTimeCycle.makeSpline(str3, j4);
                    }
                    if (viewTimeCycle != null) {
                        viewTimeCycle.setType(str3);
                        this.mTimeCycleAttributesMap.put(str3, viewTimeCycle);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i16 = 0;
                while (i16 < size5) {
                    Key key9 = arrayList6.get(i16);
                    i16++;
                    Key key10 = key9;
                    if (key10 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key10).addTimeValues(this.mTimeCycleAttributesMap);
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
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i18 = 0;
        int i19 = 1;
        while (i18 < size7) {
            MotionPaths motionPaths = arrayList7.get(i18);
            i18++;
            motionPathsArr[i19] = motionPaths;
            i19++;
        }
        HashSet hashSet4 = new HashSet();
        for (String next3 : this.mEndMotionPath.mAttributes.keySet()) {
            if (this.mStartMotionPath.mAttributes.containsKey(next3)) {
                if (!hashSet2.contains("CUSTOM," + next3)) {
                    hashSet4.add(next3);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
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
                    if (motionPathsArr[i21].mAttributes.containsKey(str5) && (constraintAttribute = motionPathsArr[i21].mAttributes.get(str5)) != null) {
                        int[] iArr = this.mAttributeInterpolatorCount;
                        iArr[i20] = iArr[i20] + constraintAttribute.numberOfInterpolatedValues();
                        break;
                    }
                    i21++;
                } else {
                    break;
                }
            }
            i20++;
        }
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
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
                    MotionPaths motionPaths2 = motionPathsArr[i32];
                    i6 = i31;
                    dArr3[i33] = (double) motionPaths2.mTime;
                    motionPaths2.getCustomData(str7, dArr4[i33], i7);
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
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i17];
            double[] dArr5 = new double[i17];
            int[] iArr6 = new int[2];
            iArr6[c5] = 2;
            iArr6[0] = i17;
            double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr6);
            for (int i35 = 0; i35 < i17; i35++) {
                MotionPaths motionPaths3 = motionPathsArr[i35];
                iArr5[i35] = motionPaths3.mPathMotionArc;
                dArr5[i35] = (double) motionPaths3.mTime;
                double[] dArr7 = dArr6[i35];
                dArr7[0] = (double) motionPaths3.mX;
                dArr7[c5] = (double) motionPaths3.mY;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator it3 = hashSet3.iterator();
            float f5 = Float.NaN;
            while (it3.hasNext()) {
                String str8 = (String) it3.next();
                ViewOscillator makeSpline = ViewOscillator.makeSpline(str8);
                if (makeSpline != null) {
                    if (makeSpline.variesByPath() && Float.isNaN(f5)) {
                        f5 = getPreCycleDistance();
                    }
                    makeSpline.setType(str8);
                    this.mCycleMap.put(str8, makeSpline);
                }
            }
            ArrayList<Key> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i36 = 0;
            while (i36 < size8) {
                Key key11 = arrayList8.get(i36);
                i36++;
                Key key12 = key11;
                if (key12 instanceof KeyCycle) {
                    ((KeyCycle) key12).addCycleValues(this.mCycleMap);
                }
            }
            for (ViewOscillator upVar : this.mCycleMap.values()) {
                upVar.setup(f5);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    /* access modifiers changed from: package-private */
    public void setStartState(Rect rect, ConstraintSet constraintSet, int i4, int i5) {
        Rect rect2;
        MotionController motionController;
        int i6 = constraintSet.mRotate;
        if (i6 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i6, i4, i5);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds((float) rect2.left, (float) rect2.top, (float) rect2.width(), (float) rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i6, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
