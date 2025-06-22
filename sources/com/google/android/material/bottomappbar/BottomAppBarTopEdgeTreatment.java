package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f4, float f5, float f6) {
        this.fabMargin = f4;
        this.roundedCornerRadius = f5;
        setCradleVerticalOffset(f6);
        this.horizontalOffset = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        boolean z4;
        float f7;
        float f8;
        float f9 = f4;
        ShapePath shapePath2 = shapePath;
        float f10 = this.fabDiameter;
        if (f10 == 0.0f) {
            shapePath2.lineTo(f9, 0.0f);
            return;
        }
        float f11 = ((this.fabMargin * 2.0f) + f10) / 2.0f;
        float f12 = f6 * this.roundedCornerRadius;
        float f13 = f5 + this.horizontalOffset;
        float f14 = (this.cradleVerticalOffset * f6) + ((1.0f - f6) * f11);
        if (f14 / f11 >= 1.0f) {
            shapePath2.lineTo(f9, 0.0f);
            return;
        }
        float f15 = this.fabCornerSize;
        float f16 = f15 * f6;
        if (f15 == -1.0f || Math.abs((f15 * 2.0f) - f10) < 0.1f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            f8 = ROUNDED_CORNER_FAB_OFFSET;
            f7 = 0.0f;
        } else {
            f7 = f14;
            f8 = 0.0f;
        }
        float f17 = f11 + f12;
        float f18 = f7 + f12;
        float sqrt = (float) Math.sqrt((double) ((f17 * f17) - (f18 * f18)));
        float f19 = f13 - sqrt;
        float f20 = f13 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f18)));
        float f21 = (90.0f - degrees) + f8;
        shapePath2.lineTo(f19, 0.0f);
        float f22 = f19 - f12;
        float f23 = f19 + f12;
        float f24 = f12 * 2.0f;
        shapePath2.addArc(f22, 0.0f, f23, f24, 270.0f, degrees);
        float f25 = f24;
        float f26 = degrees;
        if (z4) {
            shapePath.addArc(f13 - f11, (-f11) - f7, f13 + f11, f11 - f7, 180.0f - f21, (f21 * 2.0f) - 180.0f);
        } else {
            float f27 = this.fabMargin;
            float f28 = f16 * 2.0f;
            float f29 = f27 + f28;
            float f30 = f27;
            float f31 = f13 - f11;
            float f32 = f30 + f16;
            float f33 = f29 + f31;
            float f34 = f32;
            ShapePath shapePath3 = shapePath;
            shapePath3.addArc(f31, -(f16 + f30), f33, f34, 180.0f - f21, ((f21 * 2.0f) - 180.0f) / 2.0f);
            float f35 = f13 + f11;
            float f36 = this.fabMargin;
            shapePath3.lineTo(f35 - ((f36 / 2.0f) + f16), f36 + f16);
            float f37 = this.fabMargin;
            float f38 = -(f16 + f37);
            float f39 = f37 + f16;
            shapePath3.addArc(f35 - (f28 + f37), f38, f35, f39, 90.0f, f21 - 0.049804688f);
        }
        ShapePath shapePath4 = shapePath;
        shapePath4.addArc(f20 - f12, 0.0f, f20 + f12, f25, 270.0f - f26, f26);
        shapePath4.lineTo(f9, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* access modifiers changed from: package-private */
    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f4) {
        if (f4 >= 0.0f) {
            this.cradleVerticalOffset = f4;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float f4) {
        this.fabCornerSize = f4;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleMargin(float f4) {
        this.fabMargin = f4;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f4) {
        this.roundedCornerRadius = f4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f4) {
        this.fabDiameter = f4;
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffset(float f4) {
        this.horizontalOffset = f4;
    }
}
