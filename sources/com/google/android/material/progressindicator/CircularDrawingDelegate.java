package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, @ColorInt int i4, @Px int i5, @Px int i6) {
        float f6;
        Paint.Cap cap;
        if (f5 >= f4) {
            f6 = f5 - f4;
        } else {
            f6 = (f5 + 1.0f) - f4;
        }
        float f7 = f4 % 1.0f;
        if (this.totalTrackLengthFraction < 1.0f) {
            float f8 = f7 + f6;
            if (f8 > 1.0f) {
                Canvas canvas2 = canvas;
                Paint paint2 = paint;
                int i7 = i4;
                drawArc(canvas2, paint2, f7, 1.0f, i7, i5, 0);
                drawArc(canvas2, paint2, 1.0f, f8, i7, 0, i6);
                return;
            }
        }
        float degrees = (float) Math.toDegrees((double) (this.displayedCornerRadius / this.adjustedRadius));
        if (f7 == 0.0f && f6 >= 0.99f) {
            f6 += ((f6 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
        }
        float lerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f7);
        float lerp2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f6);
        float degrees2 = (float) Math.toDegrees((double) (((float) i5) / this.adjustedRadius));
        float degrees3 = ((lerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees((double) (((float) i6) / this.adjustedRadius)));
        float f9 = (lerp * 360.0f) + degrees2;
        if (degrees3 > 0.0f) {
            paint.setAntiAlias(true);
            paint.setColor(i4);
            paint.setStrokeWidth(this.displayedTrackThickness);
            float f10 = degrees * 2.0f;
            if (degrees3 < f10) {
                float f11 = degrees3 / f10;
                paint.setStyle(Paint.Style.FILL);
                drawRoundedBlock(canvas, paint, f9 + (degrees * f11), this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, f11);
                return;
            }
            float f12 = f10;
            float f13 = this.adjustedRadius;
            RectF rectF = new RectF(-f13, -f13, f13, f13);
            paint.setStyle(Paint.Style.STROKE);
            if (this.useStrokeCap) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint.setStrokeCap(cap);
            float f14 = f9 + degrees;
            float f15 = degrees3 - f12;
            canvas.drawArc(rectF, f14, f15, false, paint);
            float f16 = f14;
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                Paint paint3 = paint;
                drawRoundedBlock(canvas, paint3, f16, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
                drawRoundedBlock(canvas, paint3, (f9 + degrees3) - degrees, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
            }
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, float f6) {
        drawRoundedBlock(canvas, paint, f4, f5, f6, 1.0f);
    }

    private int getSize() {
        S s4 = this.spec;
        return ((CircularProgressIndicatorSpec) s4).indicatorSize + (((CircularProgressIndicatorSpec) s4).indicatorInset * 2);
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f4, boolean z4, boolean z5) {
        boolean z6;
        float width = ((float) rect.width()) / ((float) getPreferredWidth());
        float height = ((float) rect.height()) / ((float) getPreferredHeight());
        S s4 = this.spec;
        float f5 = (((float) ((CircularProgressIndicatorSpec) s4).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s4).indicatorInset);
        canvas.translate((f5 * width) + ((float) rect.left), (f5 * height) + ((float) rect.top));
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f6 = -f5;
        canvas.clipRect(f6, f6, f5, f5);
        S s5 = this.spec;
        if (((CircularProgressIndicatorSpec) s5).trackThickness / 2 <= ((CircularProgressIndicatorSpec) s5).trackCornerRadius) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.useStrokeCap = z6;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s5).trackThickness) * f4;
        this.displayedCornerRadius = ((float) Math.min(((CircularProgressIndicatorSpec) s5).trackThickness / 2, ((CircularProgressIndicatorSpec) s5).trackCornerRadius)) * f4;
        S s6 = this.spec;
        float f7 = ((float) (((CircularProgressIndicatorSpec) s6).indicatorSize - ((CircularProgressIndicatorSpec) s6).trackThickness)) / 2.0f;
        this.adjustedRadius = f7;
        if (z4 || z5) {
            if ((z4 && ((CircularProgressIndicatorSpec) s6).showAnimationBehavior == 2) || (z5 && ((CircularProgressIndicatorSpec) s6).hideAnimationBehavior == 1)) {
                this.adjustedRadius = f7 + (((1.0f - f4) * ((float) ((CircularProgressIndicatorSpec) s6).trackThickness)) / 2.0f);
            } else if ((z4 && ((CircularProgressIndicatorSpec) s6).showAnimationBehavior == 1) || (z5 && ((CircularProgressIndicatorSpec) s6).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f7 - (((1.0f - f4) * ((float) ((CircularProgressIndicatorSpec) s6).trackThickness)) / 2.0f);
            }
        }
        if (!z5 || ((CircularProgressIndicatorSpec) s6).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f4;
        }
    }

    /* access modifiers changed from: package-private */
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
    }

    /* access modifiers changed from: package-private */
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i4) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i4);
        float f4 = activeIndicator.startFraction;
        float f5 = activeIndicator.endFraction;
        int i5 = activeIndicator.gapSize;
        drawArc(canvas, paint, f4, f5, compositeARGBWithAlpha, i5, i5);
    }

    /* access modifiers changed from: package-private */
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5, int i6) {
        drawArc(canvas, paint, f4, f5, MaterialColors.compositeARGBWithAlpha(i4, i5), i6, i6);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        return getSize();
    }

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, float f6, float f7) {
        float min = (float) ((int) Math.min(f6, this.displayedTrackThickness));
        float f8 = f5 / 2.0f;
        float min2 = Math.min(f8, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-min) / 2.0f, (-f5) / 2.0f, min / 2.0f, f8);
        canvas.save();
        double d5 = (double) f4;
        canvas.translate((float) (((double) this.adjustedRadius) * Math.cos(Math.toRadians(d5))), (float) (((double) this.adjustedRadius) * Math.sin(Math.toRadians(d5))));
        canvas.rotate(f4);
        canvas.scale(f7, f7);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
