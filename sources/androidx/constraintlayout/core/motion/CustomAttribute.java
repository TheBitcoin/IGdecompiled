package androidx.constraintlayout.core.motion;

import androidx.core.view.ViewCompat;

public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    private static int clamp(int i4) {
        int i5 = (i4 & (~(i4 >> 31))) - 255;
        return (i5 & (i5 >> 31)) + 255;
    }

    public static int hsvToRgb(float f4, float f5, float f6) {
        float f7 = f4 * 6.0f;
        int i4 = (int) f7;
        float f8 = f7 - ((float) i4);
        float f9 = f6 * 255.0f;
        int i5 = (int) (((1.0f - f5) * f9) + 0.5f);
        int i6 = (int) (((1.0f - (f8 * f5)) * f9) + 0.5f);
        int i7 = (int) (((1.0f - ((1.0f - f8) * f5)) * f9) + 0.5f);
        int i8 = (int) (f9 + 0.5f);
        if (i4 == 0) {
            return ((i8 << 16) + (i7 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i4 == 1) {
            return ((i6 << 16) + (i8 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i4 == 2) {
            return ((i5 << 16) + (i8 << 8) + i7) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i4 == 3) {
            return ((i5 << 16) + (i6 << 8) + i8) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i4 == 4) {
            return ((i7 << 16) + (i5 << 8) + i8) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i4 != 5) {
            return 0;
        }
        return ((i8 << 16) + (i5 << 8) + i6) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute != null && (attributeType = this.mType) == customAttribute.mType) {
            switch (attributeType.ordinal()) {
                case 0:
                case 7:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case 1:
                    if (this.mFloatValue == customAttribute.mFloatValue) {
                        return true;
                    }
                    return false;
                case 2:
                case 3:
                    if (this.mColorValue == customAttribute.mColorValue) {
                        return true;
                    }
                    return false;
                case 4:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    return false;
                case 5:
                    if (this.mBooleanValue == customAttribute.mBooleanValue) {
                        return true;
                    }
                    return false;
                case 6:
                    if (this.mFloatValue == customAttribute.mFloatValue) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType.ordinal()) {
            case 0:
                return (float) this.mIntegerValue;
            case 1:
                return this.mFloatValue;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                if (this.mBooleanValue) {
                    return 1.0f;
                }
                return 0.0f;
            case 6:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f4;
        switch (this.mType.ordinal()) {
            case 0:
                fArr[0] = (float) this.mIntegerValue;
                return;
            case 1:
                fArr[0] = this.mFloatValue;
                return;
            case 2:
            case 3:
                int i4 = this.mColorValue;
                float pow = (float) Math.pow((double) (((float) ((i4 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i4 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i4 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i4 >> 24) & 255)) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (this.mBooleanValue) {
                    f4 = 1.0f;
                } else {
                    f4 = 0.0f;
                }
                fArr[0] = f4;
                return;
            case 6:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 4 || ordinal == 5 || ordinal == 7) {
            return false;
        }
        return true;
    }

    public int numberOfInterpolatedValues() {
        int ordinal = this.mType.ordinal();
        if (ordinal == 2 || ordinal == 3) {
            return 4;
        }
        return 1;
    }

    public void setColorValue(int i4) {
        this.mColorValue = i4;
    }

    public void setFloatValue(float f4) {
        this.mFloatValue = f4;
    }

    public void setIntValue(int i4) {
        this.mIntegerValue = i4;
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        boolean z4 = true;
        switch (this.mType.ordinal()) {
            case 0:
            case 7:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 1:
                this.mFloatValue = fArr[0];
                return;
            case 2:
            case 3:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = hsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (hsvToRgb & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (((double) fArr[0]) <= 0.5d) {
                    z4 = false;
                }
                this.mBooleanValue = z4;
                return;
            case 6:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z4) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z4;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.mType.ordinal()) {
            case 0:
            case 7:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 1:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.mColorValue = ((Integer) obj).intValue();
                return;
            case 4:
                this.mStringValue = (String) obj;
                return;
            case 5:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }
}
