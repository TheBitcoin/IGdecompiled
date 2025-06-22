package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    String mAnimateRelativeTo = null;
    HashMap<String, CustomVariable> mCustomAttributes = new HashMap<>();
    int mDrawPath = 0;
    float mHeight;
    public String mId;
    Easing mKeyFrameEasing;
    int mMode = 0;
    int mPathMotionArc = -1;
    float mPathRotate = Float.NaN;
    float mPosition;
    float mProgress = Float.NaN;
    float mRelativeAngle = Float.NaN;
    Motion mRelativeToController = null;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    float mTime;
    float mWidth;
    float mX;
    float mY;

    public MotionPaths() {
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

    private static float xRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return (((f8 - f6) * f5) - ((f9 - f7) * f4)) + f6;
    }

    private static float yRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return ((f8 - f6) * f4) + ((f9 - f7) * f5) + f7;
    }

    public void applyParameters(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.mMotion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.mMotion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.mPropertySet.mProgress;
        WidgetFrame widgetFrame = motionWidget.mWidgetFrame;
        if (!(widgetFrame == null || (constraintWidget = widgetFrame.widget) == null)) {
            this.mRelativeAngle = constraintWidget.mCircleConstraintAngle;
        }
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomAttributes.put(next, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos((double) this.mProgress);
    }

    /* access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z4) {
        boolean z5;
        boolean diff = diff(this.mX, motionPaths.mX);
        boolean diff2 = diff(this.mY, motionPaths.mY);
        boolean z6 = false;
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        boolean z7 = zArr[1];
        if (diff || diff2 || z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        zArr[1] = z7 | z5;
        boolean z8 = zArr[2];
        if (diff || diff2 || z4) {
            z6 = true;
        }
        zArr[2] = z8 | z6;
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    /* access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i4 = 0;
        for (int i5 : iArr) {
            if (i5 < 6) {
                dArr[i4] = (double) fArr[i5];
                i4++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.mWidth;
        float f5 = this.mHeight;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f6 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 3) {
                f4 = f6;
            } else if (i6 == 4) {
                f5 = f6;
            }
        }
        fArr[i4] = f4;
        fArr[i4 + 1] = f5;
    }

    /* access modifiers changed from: package-private */
    public void getCenter(double d5, int[] iArr, double[] dArr, float[] fArr, int i4) {
        int[] iArr2 = iArr;
        float f4 = this.mX;
        float f5 = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr2[i5];
            if (i6 == 1) {
                f4 = f8;
            } else if (i6 == 2) {
                f5 = f8;
            } else if (i6 == 3) {
                f6 = f8;
            } else if (i6 == 4) {
                f7 = f8;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d5, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = (double) f9;
            double d7 = (double) f4;
            double d8 = (double) f5;
            f4 = (float) ((d6 + (Math.sin(d8) * d7)) - ((double) (f6 / 2.0f)));
            f5 = (float) ((((double) f10) - (d7 * Math.cos(d8))) - ((double) (f7 / 2.0f)));
        }
        fArr[i4] = f4 + (f6 / 2.0f) + 0.0f;
        fArr[i4 + 1] = f5 + (f7 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void getCenterVelocity(double d5, int[] iArr, double[] dArr, float[] fArr, int i4) {
        int[] iArr2 = iArr;
        float f4 = this.mX;
        float f5 = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr2[i5];
            if (i6 == 1) {
                f4 = f8;
            } else if (i6 == 2) {
                f5 = f8;
            } else if (i6 == 3) {
                f6 = f8;
            } else if (i6 == 4) {
                f7 = f8;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d5, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = (double) f9;
            double d7 = (double) f4;
            double d8 = (double) f5;
            f4 = (float) ((d6 + (Math.sin(d8) * d7)) - ((double) (f6 / 2.0f)));
            f5 = (float) ((((double) f10) - (d7 * Math.cos(d8))) - ((double) (f7 / 2.0f)));
        }
        fArr[i4] = f4 + (f6 / 2.0f) + 0.0f;
        fArr[i4 + 1] = f5 + (f7 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i4) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        int i5 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i4] = (double) customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i5 < numberOfInterpolatedValues) {
            dArr[i4] = (double) fArr[i5];
            i5++;
            i4++;
        }
        return numberOfInterpolatedValues;
    }

    /* access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    /* access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i4) {
        float f4 = this.mX;
        float f5 = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                f4 = f8;
            } else if (i6 == 2) {
                f5 = f8;
            } else if (i6 == 3) {
                f6 = f8;
            } else if (i6 == 4) {
                f7 = f8;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            double d5 = (double) f4;
            double d6 = (double) f5;
            f5 = (float) ((((double) this.mRelativeToController.getCenterY()) - (d5 * Math.cos(d6))) - ((double) (f7 / 2.0f)));
            f4 = (float) ((((double) centerX) + (Math.sin(d6) * d5)) - ((double) (f6 / 2.0f)));
        }
        float f9 = f6 + f4;
        float f10 = f7 + f5;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i4] = f4 + 0.0f;
        fArr[i4 + 1] = f5 + 0.0f;
        fArr[i4 + 2] = f9 + 0.0f;
        fArr[i4 + 3] = f5 + 0.0f;
        fArr[i4 + 4] = f9 + 0.0f;
        int i7 = i4 + 6;
        fArr[i4 + 5] = f10 + 0.0f;
        fArr[i7] = f4 + 0.0f;
        fArr[i4 + 7] = f10 + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.mCustomAttributes.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6;
        float f7;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f8 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f8;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f4 = f8;
        } else {
            f4 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f5 = f8;
        } else {
            f5 = motionKeyPosition2.mPercentHeight;
        }
        float f9 = motionPaths4.mWidth;
        float f10 = motionPaths3.mWidth;
        float f11 = motionPaths4.mHeight;
        float f12 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f13 = motionPaths3.mX;
        float f14 = motionPaths3.mY;
        float f15 = f8;
        float f16 = motionPaths4.mX + (f9 / 2.0f);
        float f17 = f16 - ((f10 / 2.0f) + f13);
        float f18 = (motionPaths4.mY + (f11 / 2.0f)) - (f14 + (f12 / 2.0f));
        float f19 = (f9 - f10) * f4;
        float f20 = f19 / 2.0f;
        this.mX = (float) ((int) ((f13 + (f17 * f15)) - f20));
        float f21 = (f11 - f12) * f5;
        float f22 = f21 / 2.0f;
        this.mY = (float) ((int) ((f14 + (f18 * f15)) - f22));
        this.mWidth = (float) ((int) (f10 + f19));
        this.mHeight = (float) ((int) (f12 + f21));
        if (Float.isNaN(motionKeyPosition2.mPercentX)) {
            f6 = f15;
        } else {
            f6 = motionKeyPosition2.mPercentX;
        }
        float f23 = 0.0f;
        if (Float.isNaN(motionKeyPosition2.mAltPercentY)) {
            f7 = 0.0f;
        } else {
            f7 = motionKeyPosition2.mAltPercentY;
        }
        if (!Float.isNaN(motionKeyPosition2.mPercentY)) {
            f15 = motionKeyPosition2.mPercentY;
        }
        if (!Float.isNaN(motionKeyPosition2.mAltPercentX)) {
            f23 = motionKeyPosition2.mAltPercentX;
        }
        this.mMode = 0;
        this.mX = (float) ((int) (((motionPaths3.mX + (f6 * f17)) + (f23 * f18)) - f20));
        this.mY = (float) ((int) (((motionPaths3.mY + (f17 * f7)) + (f18 * f15)) - f22));
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition2.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f7 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f7;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f4 = f7;
        } else {
            f4 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f5 = f7;
        } else {
            f5 = motionKeyPosition2.mPercentHeight;
        }
        float f8 = motionPaths4.mWidth - motionPaths3.mWidth;
        float f9 = motionPaths4.mHeight - motionPaths3.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(motionKeyPosition2.mPercentX)) {
            f7 = motionKeyPosition2.mPercentX;
        }
        float f10 = motionPaths3.mX;
        float f11 = motionPaths3.mWidth;
        float f12 = motionPaths3.mY;
        float f13 = motionPaths3.mHeight;
        float f14 = f7;
        float f15 = motionPaths4.mX + (motionPaths4.mWidth / 2.0f);
        float f16 = f15 - ((f11 / 2.0f) + f10);
        float f17 = (motionPaths4.mY + (motionPaths4.mHeight / 2.0f)) - ((f13 / 2.0f) + f12);
        float f18 = f16 * f14;
        float f19 = f8 * f4;
        float f20 = f19 / 2.0f;
        this.mX = (float) ((int) ((f10 + f18) - f20));
        float f21 = f17 * f14;
        float f22 = f9 * f5;
        float f23 = f22 / 2.0f;
        this.mY = (float) ((int) ((f12 + f21) - f23));
        this.mWidth = (float) ((int) (f11 + f19));
        this.mHeight = (float) ((int) (f13 + f22));
        if (Float.isNaN(motionKeyPosition2.mPercentY)) {
            f6 = 0.0f;
        } else {
            f6 = motionKeyPosition2.mPercentY;
        }
        this.mMode = 1;
        this.mX = ((float) ((int) ((motionPaths3.mX + f18) - f20))) + ((-f17) * f6);
        this.mY = ((float) ((int) ((motionPaths3.mY + f21) - f23))) + (f16 * f6);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition2.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initPolar(int i4, int i5, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10 = ((float) motionKeyPosition.mFramePosition) / 100.0f;
        this.mTime = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        if (Float.isNaN(motionKeyPosition.mPercentWidth)) {
            f4 = f10;
        } else {
            f4 = motionKeyPosition.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition.mPercentHeight)) {
            f5 = f10;
        } else {
            f5 = motionKeyPosition.mPercentHeight;
        }
        float f11 = motionPaths2.mWidth;
        float f12 = motionPaths.mWidth;
        float f13 = motionPaths2.mHeight;
        float f14 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (float) ((int) (f12 + ((f11 - f12) * f4)));
        this.mHeight = (float) ((int) (f14 + ((f13 - f14) * f5)));
        int i6 = motionKeyPosition.mPositionType;
        if (i6 == 1) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f6 = f10;
            } else {
                f6 = motionKeyPosition.mPercentX;
            }
            float f15 = motionPaths2.mX;
            float f16 = motionPaths.mX;
            this.mX = (f6 * (f15 - f16)) + f16;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f10 = motionKeyPosition.mPercentY;
            }
            float f17 = motionPaths2.mY;
            float f18 = motionPaths.mY;
            this.mY = (f10 * (f17 - f18)) + f18;
        } else if (i6 != 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f9 = f10;
            } else {
                f9 = motionKeyPosition.mPercentX;
            }
            float f19 = motionPaths2.mX;
            float f20 = motionPaths.mX;
            this.mX = (f9 * (f19 - f20)) + f20;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f10 = motionKeyPosition.mPercentY;
            }
            float f21 = motionPaths2.mY;
            float f22 = motionPaths.mY;
            this.mY = (f10 * (f21 - f22)) + f22;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f23 = motionPaths2.mX;
                float f24 = motionPaths.mX;
                f7 = ((f23 - f24) * f10) + f24;
            } else {
                f7 = Math.min(f5, f4) * motionKeyPosition.mPercentX;
            }
            this.mX = f7;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f25 = motionPaths2.mY;
                float f26 = motionPaths.mY;
                f8 = (f10 * (f25 - f26)) + f26;
            } else {
                f8 = motionKeyPosition.mPercentY;
            }
            this.mY = f8;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void initScreen(int i4, int i5, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f6 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.mTime = f6;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f4 = f6;
        } else {
            f4 = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f5 = f6;
        } else {
            f5 = motionKeyPosition2.mPercentHeight;
        }
        float f7 = motionPaths4.mWidth;
        float f8 = motionPaths3.mWidth;
        float f9 = motionPaths4.mHeight;
        float f10 = motionPaths3.mHeight;
        this.mPosition = this.mTime;
        float f11 = motionPaths3.mX;
        float f12 = motionPaths3.mY;
        float f13 = motionPaths4.mX + (f7 / 2.0f);
        float f14 = motionPaths4.mY + (f9 / 2.0f);
        float f15 = (f7 - f8) * f4;
        this.mX = (float) ((int) ((f11 + ((f13 - ((f8 / 2.0f) + f11)) * f6)) - (f15 / 2.0f)));
        float f16 = (f9 - f10) * f5;
        this.mY = (float) ((int) ((f12 + ((f14 - (f12 + (f10 / 2.0f))) * f6)) - (f16 / 2.0f)));
        this.mWidth = (float) ((int) (f8 + f15));
        this.mHeight = (float) ((int) (f10 + f16));
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition2.mPercentX)) {
            this.mX = (float) ((int) (motionKeyPosition2.mPercentX * ((float) (i4 - ((int) this.mWidth)))));
        }
        if (!Float.isNaN(motionKeyPosition2.mPercentY)) {
            this.mY = (float) ((int) (motionKeyPosition2.mPercentY * ((float) (i5 - ((int) this.mHeight)))));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition2.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition2.mPathMotionArc;
    }

    /* access modifiers changed from: package-private */
    public void setBounds(float f4, float f5, float f6, float f7) {
        this.mX = f4;
        this.mY = f5;
        this.mWidth = f6;
        this.mHeight = f7;
    }

    /* access modifiers changed from: package-private */
    public void setDpDt(float f4, float f5, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            float f10 = (float) dArr[i4];
            int i5 = iArr2[i4];
            if (i5 == 1) {
                f6 = f10;
            } else if (i5 == 2) {
                f8 = f10;
            } else if (i5 == 3) {
                f7 = f10;
            } else if (i5 == 4) {
                f9 = f10;
            }
        }
        float f11 = f6 - ((0.0f * f7) / 2.0f);
        float f12 = f8 - ((0.0f * f9) / 2.0f);
        fArr[0] = (f11 * (1.0f - f4)) + (((f7 * 1.0f) + f11) * f4) + 0.0f;
        fArr[1] = (f12 * (1.0f - f5)) + (((f9 * 1.0f) + f12) * f5) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void setView(float f4, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f5;
        MotionWidget motionWidget2 = motionWidget;
        int[] iArr2 = iArr;
        float f6 = this.mX;
        float f7 = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        if (iArr2.length != 0 && this.mTempValue.length <= iArr2[iArr2.length - 1]) {
            int i4 = iArr2[iArr2.length - 1] + 1;
            this.mTempValue = new double[i4];
            this.mTempDelta = new double[i4];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            double[] dArr4 = this.mTempValue;
            int i6 = iArr2[i5];
            dArr4[i6] = dArr[i5];
            this.mTempDelta[i6] = dArr2[i5];
        }
        float f10 = Float.NaN;
        int i7 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i7 >= dArr5.length) {
                break;
            }
            double d5 = 0.0d;
            if (!Double.isNaN(dArr5[i7]) || !(dArr3 == null || dArr3[i7] == 0.0d)) {
                if (dArr3 != null) {
                    d5 = dArr3[i7];
                }
                if (!Double.isNaN(this.mTempValue[i7])) {
                    d5 = this.mTempValue[i7] + d5;
                }
                f5 = f10;
                float f15 = (float) d5;
                float f16 = (float) this.mTempDelta[i7];
                if (i7 == 1) {
                    f10 = f5;
                    f11 = f16;
                    f6 = f15;
                } else if (i7 == 2) {
                    f10 = f5;
                    f12 = f16;
                    f7 = f15;
                } else if (i7 == 3) {
                    f10 = f5;
                    f13 = f16;
                    f8 = f15;
                } else if (i7 == 4) {
                    f10 = f5;
                    f14 = f16;
                    f9 = f15;
                } else if (i7 == 5) {
                    f10 = f15;
                }
                i7++;
            } else {
                f5 = f10;
            }
            f10 = f5;
            i7++;
        }
        float f17 = f10;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter((double) f4, fArr, fArr2);
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr2[0];
            float f21 = fArr2[1];
            double d6 = (double) f6;
            double d7 = (double) f7;
            f6 = (float) ((((double) f18) + (Math.sin(d7) * d6)) - ((double) (f8 / 2.0f)));
            f7 = (float) ((((double) f19) - (Math.cos(d7) * d6)) - ((double) (f9 / 2.0f)));
            double d8 = (double) f20;
            double d9 = (double) f11;
            double d10 = d7;
            double d11 = (double) f12;
            float sin = (float) (d8 + (Math.sin(d7) * d9) + (Math.cos(d7) * d6 * d11));
            float cos = (float) ((((double) f21) - (d9 * Math.cos(d10))) + (Math.sin(d10) * d6 * d11));
            double[] dArr6 = dArr2;
            if (dArr6.length >= 2) {
                dArr6[0] = (double) sin;
                dArr6[1] = (double) cos;
            }
            if (!Float.isNaN(f17)) {
                motionWidget2.setRotationZ((float) (((double) f17) + Math.toDegrees(Math.atan2((double) cos, (double) sin))));
            }
        } else {
            float f22 = f17;
            if (!Float.isNaN(f22)) {
                motionWidget2.setRotationZ(((float) (((double) f22) + Math.toDegrees(Math.atan2((double) (f12 + (f14 / 2.0f)), (double) (f11 + (f13 / 2.0f)))))) + 0.0f);
            }
        }
        float f23 = f6 + 0.5f;
        float f24 = f7 + 0.5f;
        motionWidget2.layout((int) f23, (int) f24, (int) (f23 + f8), (int) (f24 + f9));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d5 = (double) (((this.mX + (this.mWidth / 2.0f)) - motionPaths.mX) - (motionPaths.mWidth / 2.0f));
        double d6 = (double) (((this.mY + (this.mHeight / 2.0f)) - motionPaths.mY) - (motionPaths.mHeight / 2.0f));
        this.mRelativeToController = motion;
        this.mX = (float) Math.hypot(d6, d5);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d6, d5) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians((double) this.mRelativeAngle);
        }
    }

    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i4, int i5, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        if (motionPaths.mAnimateRelativeTo != null) {
            initPolar(i4, i5, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        MotionPaths motionPaths3 = motionPaths2;
        MotionPaths motionPaths4 = motionPaths;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        int i6 = i5;
        int i7 = motionKeyPosition2.mPositionType;
        if (i7 == 1) {
            initPath(motionKeyPosition2, motionPaths4, motionPaths3);
        } else if (i7 != 2) {
            initCartesian(motionKeyPosition2, motionPaths4, motionPaths3);
        } else {
            initScreen(i4, i6, motionKeyPosition2, motionPaths4, motionPaths3);
        }
    }

    /* access modifiers changed from: package-private */
    public void getCenter(double d5, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f4;
        int[] iArr2 = iArr;
        float f5 = this.mX;
        float f6 = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            float f13 = (float) dArr[i4];
            float f14 = (float) dArr2[i4];
            int i5 = iArr2[i4];
            if (i5 == 1) {
                f5 = f13;
                f9 = f14;
            } else if (i5 == 2) {
                f6 = f13;
                f11 = f14;
            } else if (i5 == 3) {
                f7 = f13;
                f10 = f14;
            } else if (i5 == 4) {
                f8 = f13;
                f12 = f14;
            }
        }
        float f15 = (f10 / 2.0f) + f9;
        float f16 = (f12 / 2.0f) + f11;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d5, fArr3, fArr4);
            float f17 = fArr3[0];
            float f18 = fArr3[1];
            float f19 = fArr4[0];
            float f20 = fArr4[1];
            f4 = 2.0f;
            double d6 = (double) f5;
            double d7 = (double) f6;
            f5 = (float) ((((double) f17) + (Math.sin(d7) * d6)) - ((double) (f7 / 2.0f)));
            double d8 = d7;
            f6 = (float) ((((double) f18) - (Math.cos(d7) * d6)) - ((double) (f8 / 2.0f)));
            double d9 = (double) f9;
            double d10 = (double) f11;
            f16 = (float) ((((double) f20) - (d9 * Math.cos(d8))) + (Math.sin(d8) * d10));
            f15 = (float) (((double) f19) + (Math.sin(d8) * d9) + (Math.cos(d8) * d10));
        } else {
            f4 = 2.0f;
        }
        fArr[0] = f5 + (f7 / f4) + 0.0f;
        fArr[1] = f6 + (f8 / f4) + 0.0f;
        fArr2[0] = f15;
        fArr2[1] = f16;
    }
}
