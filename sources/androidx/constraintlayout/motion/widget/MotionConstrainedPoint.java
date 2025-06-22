package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int PERPENDICULAR = 1;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    private float mAlpha = 1.0f;
    private int mAnimateRelativeTo = -1;
    private boolean mApplyElevation = false;
    LinkedHashMap<String, ConstraintAttribute> mAttributes = new LinkedHashMap<>();
    private int mDrawPath = 0;
    private float mElevation = 0.0f;
    private float mHeight;
    private Easing mKeyFrameEasing;
    int mMode = 0;
    private float mPathRotate = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mPosition;
    private float mProgress = Float.NaN;
    private float mRotation = 0.0f;
    private float mRotationX = 0.0f;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    private float mTranslationX = 0.0f;
    private float mTranslationY = 0.0f;
    private float mTranslationZ = 0.0f;
    int mVisibility;
    int mVisibilityMode = 0;
    private float mWidth;
    private float mX;
    private float mY;
    public float rotationY = 0.0f;

    MotionConstrainedPoint() {
    }

    private boolean diff(float f4, float f5) {
        if (Float.isNaN(f4) || Float.isNaN(f5)) {
            if (Float.isNaN(f4) != Float.isNaN(f5)) {
                return true;
            }
            return false;
        } else if (Math.abs(f4 - f5) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public void addValues(HashMap<String, ViewSpline> hashMap, int i4) {
        for (String next : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(next);
            if (viewSpline != null) {
                next.getClass();
                float f4 = 1.0f;
                float f5 = 0.0f;
                char c5 = 65535;
                switch (next.hashCode()) {
                    case -1249320806:
                        if (next.equals("rotationX")) {
                            c5 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (next.equals("rotationY")) {
                            c5 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (next.equals("translationX")) {
                            c5 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (next.equals("translationY")) {
                            c5 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (next.equals("translationZ")) {
                            c5 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (next.equals("progress")) {
                            c5 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (next.equals("scaleX")) {
                            c5 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (next.equals("scaleY")) {
                            c5 = 7;
                            break;
                        }
                        break;
                    case -760884510:
                        if (next.equals(Key.PIVOT_X)) {
                            c5 = 8;
                            break;
                        }
                        break;
                    case -760884509:
                        if (next.equals(Key.PIVOT_Y)) {
                            c5 = 9;
                            break;
                        }
                        break;
                    case -40300674:
                        if (next.equals(Key.ROTATION)) {
                            c5 = 10;
                            break;
                        }
                        break;
                    case -4379043:
                        if (next.equals("elevation")) {
                            c5 = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (next.equals("transitionPathRotate")) {
                            c5 = 12;
                            break;
                        }
                        break;
                    case 92909918:
                        if (next.equals("alpha")) {
                            c5 = 13;
                            break;
                        }
                        break;
                }
                switch (c5) {
                    case 0:
                        if (!Float.isNaN(this.mRotationX)) {
                            f5 = this.mRotationX;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 1:
                        if (!Float.isNaN(this.rotationY)) {
                            f5 = this.rotationY;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 2:
                        if (!Float.isNaN(this.mTranslationX)) {
                            f5 = this.mTranslationX;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 3:
                        if (!Float.isNaN(this.mTranslationY)) {
                            f5 = this.mTranslationY;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 4:
                        if (!Float.isNaN(this.mTranslationZ)) {
                            f5 = this.mTranslationZ;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 5:
                        if (!Float.isNaN(this.mProgress)) {
                            f5 = this.mProgress;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 6:
                        if (!Float.isNaN(this.mScaleX)) {
                            f4 = this.mScaleX;
                        }
                        viewSpline.setPoint(i4, f4);
                        break;
                    case 7:
                        if (!Float.isNaN(this.mScaleY)) {
                            f4 = this.mScaleY;
                        }
                        viewSpline.setPoint(i4, f4);
                        break;
                    case 8:
                        if (!Float.isNaN(this.mPivotX)) {
                            f5 = this.mPivotX;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 9:
                        if (!Float.isNaN(this.mPivotY)) {
                            f5 = this.mPivotY;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 10:
                        if (!Float.isNaN(this.mRotation)) {
                            f5 = this.mRotation;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 11:
                        if (!Float.isNaN(this.mElevation)) {
                            f5 = this.mElevation;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 12:
                        if (!Float.isNaN(this.mPathRotate)) {
                            f5 = this.mPathRotate;
                        }
                        viewSpline.setPoint(i4, f5);
                        break;
                    case 13:
                        if (!Float.isNaN(this.mAlpha)) {
                            f4 = this.mAlpha;
                        }
                        viewSpline.setPoint(i4, f4);
                        break;
                    default:
                        if (!next.startsWith("CUSTOM")) {
                            Log.e("MotionPaths", "UNKNOWN spline " + next);
                            break;
                        } else {
                            String str = next.split(",")[1];
                            if (!this.mAttributes.containsKey(str)) {
                                break;
                            } else {
                                ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
                                if (!(viewSpline instanceof ViewSpline.CustomSet)) {
                                    Log.e("MotionPaths", next + " ViewSpline not a CustomSet frame = " + i4 + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                                    break;
                                } else {
                                    ((ViewSpline.CustomSet) viewSpline).setPoint(i4, constraintAttribute);
                                    break;
                                }
                            }
                        }
                }
            }
        }
    }

    public void applyParameters(View view) {
        this.mVisibility = view.getVisibility();
        this.mAlpha = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.mApplyElevation = false;
        this.mElevation = view.getElevation();
        this.mRotation = view.getRotation();
        this.mRotationX = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.mScaleX = view.getScaleX();
        this.mScaleY = view.getScaleY();
        this.mPivotX = view.getPivotX();
        this.mPivotY = view.getPivotY();
        this.mTranslationX = view.getTranslationX();
        this.mTranslationY = view.getTranslationY();
        this.mTranslationZ = view.getTranslationZ();
    }

    /* access modifiers changed from: package-private */
    public void different(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (diff(this.mAlpha, motionConstrainedPoint.mAlpha)) {
            hashSet.add("alpha");
        }
        if (diff(this.mElevation, motionConstrainedPoint.mElevation)) {
            hashSet.add("elevation");
        }
        int i4 = this.mVisibility;
        int i5 = motionConstrainedPoint.mVisibility;
        if (i4 != i5 && this.mVisibilityMode == 0 && (i4 == 0 || i5 == 0)) {
            hashSet.add("alpha");
        }
        if (diff(this.mRotation, motionConstrainedPoint.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mPathRotate) || !Float.isNaN(motionConstrainedPoint.mPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mProgress) || !Float.isNaN(motionConstrainedPoint.mProgress)) {
            hashSet.add("progress");
        }
        if (diff(this.mRotationX, motionConstrainedPoint.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (diff(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (diff(this.mPivotX, motionConstrainedPoint.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (diff(this.mPivotY, motionConstrainedPoint.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (diff(this.mScaleX, motionConstrainedPoint.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (diff(this.mScaleY, motionConstrainedPoint.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (diff(this.mTranslationX, motionConstrainedPoint.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (diff(this.mTranslationY, motionConstrainedPoint.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (diff(this.mTranslationZ, motionConstrainedPoint.mTranslationZ)) {
            hashSet.add("translationZ");
        }
    }

    /* access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        int[] iArr2 = iArr;
        int i4 = 0;
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mAlpha, this.mElevation, this.mRotation, this.mRotationX, this.rotationY, this.mScaleX, this.mScaleY, this.mPivotX, this.mPivotY, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mPathRotate};
        for (int i5 : iArr2) {
            if (i5 < 18) {
                dArr[i4] = (double) fArr[i5];
                i4++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i4) {
        ConstraintAttribute constraintAttribute = this.mAttributes.get(str);
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i4] = (double) constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i5 = 0;
        while (i5 < numberOfInterpolatedValues) {
            dArr[i4] = (double) fArr[i5];
            i5++;
            i4++;
        }
        return numberOfInterpolatedValues;
    }

    /* access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.mAttributes.get(str).numberOfInterpolatedValues();
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.mAttributes.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void setBounds(float f4, float f5, float f6, float f7) {
        this.mX = f4;
        this.mY = f5;
        this.mWidth = f6;
        this.mHeight = f7;
    }

    public void setState(View view) {
        setBounds(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
        applyParameters(view);
    }

    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.mPosition, motionConstrainedPoint.mPosition);
    }

    public void setState(Rect rect, View view, int i4, float f4) {
        setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(view);
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        if (i4 == 1) {
            this.mRotation = f4 - 90.0f;
        } else if (i4 == 2) {
            this.mRotation = f4 + 90.0f;
        }
    }

    public void setState(Rect rect, ConstraintSet constraintSet, int i4, int i5) {
        setBounds((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
        applyParameters(constraintSet.getParameters(i5));
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return;
                    }
                }
            }
            float f4 = this.mRotation + 90.0f;
            this.mRotation = f4;
            if (f4 > 180.0f) {
                this.mRotation = f4 - 360.0f;
                return;
            }
            return;
        }
        this.mRotation -= 90.0f;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        float f4;
        ConstraintSet.PropertySet propertySet = constraint.propertySet;
        int i4 = propertySet.mVisibilityMode;
        this.mVisibilityMode = i4;
        int i5 = propertySet.visibility;
        this.mVisibility = i5;
        if (i5 == 0 || i4 != 0) {
            f4 = propertySet.alpha;
        } else {
            f4 = 0.0f;
        }
        this.mAlpha = f4;
        ConstraintSet.Transform transform = constraint.transform;
        this.mApplyElevation = transform.applyElevation;
        this.mElevation = transform.elevation;
        this.mRotation = transform.rotation;
        this.mRotationX = transform.rotationX;
        this.rotationY = transform.rotationY;
        this.mScaleX = transform.scaleX;
        this.mScaleY = transform.scaleY;
        this.mPivotX = transform.transformPivotX;
        this.mPivotY = transform.transformPivotY;
        this.mTranslationX = transform.translationX;
        this.mTranslationY = transform.translationY;
        this.mTranslationZ = transform.translationZ;
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mProgress = constraint.propertySet.mProgress;
        for (String next : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(next);
            if (constraintAttribute.isContinuous()) {
                this.mAttributes.put(next, constraintAttribute);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void different(MotionConstrainedPoint motionConstrainedPoint, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | diff(this.mPosition, motionConstrainedPoint.mPosition);
        zArr[1] = zArr[1] | diff(this.mX, motionConstrainedPoint.mX);
        zArr[2] = zArr[2] | diff(this.mY, motionConstrainedPoint.mY);
        zArr[3] = zArr[3] | diff(this.mWidth, motionConstrainedPoint.mWidth);
        zArr[4] = diff(this.mHeight, motionConstrainedPoint.mHeight) | zArr[4];
    }
}
