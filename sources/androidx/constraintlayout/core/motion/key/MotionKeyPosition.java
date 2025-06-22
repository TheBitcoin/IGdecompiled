package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.f;
import java.util.HashMap;
import java.util.HashSet;

public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing = null;

    public MotionKeyPosition() {
        int i4 = MotionKey.UNSET;
        this.mCurveFit = i4;
        this.mPathMotionArc = i4;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        float f11 = f6 - f4;
        float f12 = f7 - f5;
        float f13 = 0.0f;
        if (Float.isNaN(this.mPercentX)) {
            f8 = 0.0f;
        } else {
            f8 = this.mPercentX;
        }
        if (Float.isNaN(this.mAltPercentY)) {
            f9 = 0.0f;
        } else {
            f9 = this.mAltPercentY;
        }
        if (Float.isNaN(this.mPercentY)) {
            f10 = 0.0f;
        } else {
            f10 = this.mPercentY;
        }
        if (!Float.isNaN(this.mAltPercentX)) {
            f13 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (float) ((int) (f4 + (f8 * f11) + (f13 * f12)));
        this.mCalculatedPositionY = (float) ((int) (f5 + (f11 * f9) + (f12 * f10)));
    }

    private void calcPathPosition(float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        float f10 = this.mPercentX;
        float f11 = this.mPercentY;
        this.mCalculatedPositionX = f4 + (f8 * f10) + ((-f9) * f11);
        this.mCalculatedPositionY = f5 + (f9 * f10) + (f8 * f11);
    }

    private void calcScreenPosition(int i4, int i5) {
        float f4 = this.mPercentX;
        float f5 = (float) 0;
        this.mCalculatedPositionX = (((float) i4) * f4) + f5;
        this.mCalculatedPositionY = (((float) i5) * f4) + f5;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* access modifiers changed from: package-private */
    public void calcPosition(int i4, int i5, float f4, float f5, float f6, float f7) {
        int i6 = this.mPositionType;
        if (i6 == 1) {
            calcPathPosition(f4, f5, f6, f7);
        } else if (i6 != 2) {
            calcCartesianPosition(f4, f5, f6, f7);
        } else {
            calcScreenPosition(i4, i5);
        }
    }

    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getId(String str) {
        return f.a(str);
    }

    /* access modifiers changed from: package-private */
    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    /* access modifiers changed from: package-private */
    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i4, int i5, FloatRect floatRect, FloatRect floatRect2, float f4, float f5) {
        calcPosition(i4, i5, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        if (Math.abs(f4 - this.mCalculatedPositionX) >= SELECTION_SLOPE || Math.abs(f5 - this.mCalculatedPositionY) >= SELECTION_SLOPE) {
            return false;
        }
        return true;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f4, float f5, String[] strArr, float[] fArr) {
        int i4 = this.mPositionType;
        if (i4 == 1) {
            positionPathAttributes(floatRect, floatRect2, f4, f5, strArr, fArr);
        } else if (i4 != 2) {
            positionCartAttributes(floatRect, floatRect2, f4, f5, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f4, f5, strArr, fArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f4, float f5, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f4 - centerX) / centerX2;
            strArr[1] = "percentY";
            fArr[1] = (f5 - centerY) / centerY2;
        } else if ("percentX".equals(str)) {
            fArr[0] = (f4 - centerX) / centerX2;
            fArr[1] = (f5 - centerY) / centerY2;
        } else {
            fArr[1] = (f4 - centerX) / centerX2;
            fArr[0] = (f5 - centerY) / centerY2;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f4, float f5, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        float hypot = (float) Math.hypot((double) centerX2, (double) centerY2);
        if (((double) hypot) < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f6 = centerX2 / hypot;
        float f7 = centerY2 / hypot;
        float f8 = f5 - centerY;
        float f9 = f4 - centerX;
        float f10 = ((f6 * f8) - (f9 * f7)) / hypot;
        float f11 = ((f6 * f9) + (f7 * f8)) / hypot;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            strArr[1] = "percentY";
            fArr[0] = f11;
            fArr[1] = f10;
        } else if ("percentX".equals(str)) {
            fArr[0] = f11;
            fArr[1] = f10;
        }
    }

    /* access modifiers changed from: package-private */
    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f4, float f5, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f4 / ((float) width);
            strArr[1] = "percentY";
            fArr[1] = f5 / ((float) height);
        } else if ("percentX".equals(str)) {
            fArr[0] = f4 / ((float) width);
            fArr[1] = f5 / ((float) height);
        } else {
            fArr[1] = f4 / ((float) width);
            fArr[0] = f5 / ((float) height);
        }
    }

    public boolean setValue(int i4, int i5) {
        if (i4 == 100) {
            this.mFramePosition = i5;
            return true;
        } else if (i4 == 508) {
            this.mCurveFit = i5;
            return true;
        } else if (i4 != 510) {
            return super.setValue(i4, i5);
        } else {
            this.mPositionType = i5;
            return true;
        }
    }

    public MotionKey clone() {
        return new MotionKeyPosition().copy(this);
    }

    public boolean setValue(int i4, float f4) {
        switch (i4) {
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /*503*/:
                this.mPercentWidth = f4;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /*504*/:
                this.mPercentHeight = f4;
                return true;
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /*505*/:
                this.mPercentWidth = f4;
                this.mPercentHeight = f4;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /*506*/:
                this.mPercentX = f4;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /*507*/:
                this.mPercentY = f4;
                return true;
            default:
                return super.setValue(i4, f4);
        }
    }

    public boolean setValue(int i4, String str) {
        if (i4 != 501) {
            return super.setValue(i4, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
