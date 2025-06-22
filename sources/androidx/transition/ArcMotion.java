package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
    private float mMaximumTangent = DEFAULT_MAX_TANGENT;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent = 0.0f;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    private static float toTangent(float f4) {
        if (f4 >= 0.0f && f4 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f4 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @NonNull
    public Path getPath(float f4, float f5, float f6, float f7) {
        boolean z4;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path = new Path();
        path.moveTo(f4, f5);
        float f13 = f6 - f4;
        float f14 = f7 - f5;
        float f15 = (f13 * f13) + (f14 * f14);
        float f16 = (f4 + f6) / 2.0f;
        float f17 = (f5 + f7) / 2.0f;
        float f18 = 0.25f * f15;
        if (f5 > f7) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (Math.abs(f13) < Math.abs(f14)) {
            float abs = Math.abs(f15 / (f14 * 2.0f));
            if (z4) {
                f9 = abs + f7;
                f8 = f6;
            } else {
                f9 = abs + f5;
                f8 = f4;
            }
            f10 = this.mMinimumVerticalTangent;
        } else {
            float f19 = f15 / (f13 * 2.0f);
            if (z4) {
                f12 = f5;
                f11 = f19 + f4;
            } else {
                f11 = f6 - f19;
                f12 = f7;
            }
            f10 = this.mMinimumHorizontalTangent;
        }
        float f20 = f18 * f10 * f10;
        float f21 = f16 - f8;
        float f22 = f17 - f9;
        float f23 = (f21 * f21) + (f22 * f22);
        float f24 = this.mMaximumTangent;
        float f25 = f18 * f24 * f24;
        if (f23 >= f20) {
            if (f23 > f25) {
                f20 = f25;
            } else {
                f20 = 0.0f;
            }
        }
        if (f20 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f20 / f23));
            f8 = ((f8 - f16) * sqrt) + f16;
            f9 = f17 + (sqrt * (f9 - f17));
        }
        path.cubicTo((f4 + f8) / 2.0f, (f5 + f9) / 2.0f, (f8 + f6) / 2.0f, (f9 + f7) / 2.0f, f6, f7);
        return path;
    }

    public void setMaximumAngle(float f4) {
        this.mMaximumAngle = f4;
        this.mMaximumTangent = toTangent(f4);
    }

    public void setMinimumHorizontalAngle(float f4) {
        this.mMinimumHorizontalAngle = f4;
        this.mMinimumHorizontalTangent = toTangent(f4);
    }

    public void setMinimumVerticalAngle(float f4) {
        this.mMinimumVerticalAngle = f4;
        this.mMinimumVerticalTangent = toTangent(f4);
    }

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }
}
