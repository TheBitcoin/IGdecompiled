package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f4, boolean z4) {
        this.size = f4;
        this.inside = z4;
    }

    public void getEdgePath(float f4, float f5, float f6, @NonNull ShapePath shapePath) {
        if (this.inside) {
            shapePath.lineTo(f5 - (this.size * f6), 0.0f);
            float f7 = this.size;
            shapePath.lineTo(f5, f7 * f6, (f7 * f6) + f5, 0.0f);
            shapePath.lineTo(f4, 0.0f);
            return;
        }
        float f8 = this.size;
        shapePath.lineTo(f5 - (f8 * f6), 0.0f, f5, (-f8) * f6);
        shapePath.lineTo(f5 + (this.size * f6), 0.0f, f4, 0.0f);
    }
}
