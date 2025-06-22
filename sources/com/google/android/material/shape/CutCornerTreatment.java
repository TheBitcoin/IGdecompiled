package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f4, float f5, float f6) {
        shapePath.reset(0.0f, f6 * f5, 180.0f, 180.0f - f4);
        double d5 = (double) f6;
        double d6 = (double) f5;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f4)) * d5 * d6), (float) (Math.sin(Math.toRadians((double) (90.0f - f4))) * d5 * d6));
    }

    @Deprecated
    public CutCornerTreatment(float f4) {
        this.size = f4;
    }
}
