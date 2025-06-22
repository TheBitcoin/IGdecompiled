package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    S spec;

    protected static class ActiveIndicator {
        @ColorInt
        int color;
        @FloatRange(from = 0.0d, to = 1.0d)
        float endFraction;
        @Px
        int gapSize;
        @FloatRange(from = 0.0d, to = 1.0d)
        float startFraction;

        protected ActiveIndicator() {
        }
    }

    public DrawingDelegate(S s4) {
        this.spec = s4;
    }

    /* access modifiers changed from: package-private */
    public abstract void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = -1.0d, to = 1.0d) float f4, boolean z4, boolean z5);

    /* access modifiers changed from: package-private */
    public abstract void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5);

    /* access modifiers changed from: package-private */
    public abstract void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i4);

    /* access modifiers changed from: package-private */
    public abstract void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5, @Px int i6);

    /* access modifiers changed from: package-private */
    public abstract int getPreferredHeight();

    /* access modifiers changed from: package-private */
    public abstract int getPreferredWidth();

    /* access modifiers changed from: package-private */
    public void validateSpecAndAdjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f4, boolean z4, boolean z5) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f4, z4, z5);
    }
}
