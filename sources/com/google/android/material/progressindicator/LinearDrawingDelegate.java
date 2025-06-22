package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float totalTrackLengthFraction;
    private float trackLength = 300.0f;
    private boolean useStrokeCap;

    LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, @ColorInt int i4, @Px int i5, @Px int i6) {
        Paint.Cap cap;
        float f6;
        float clamp = MathUtils.clamp(f4, 0.0f, 1.0f);
        float clamp2 = MathUtils.clamp(f5, 0.0f, 1.0f);
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp2);
        float f7 = this.trackLength;
        int clamp3 = (int) ((lerp * f7) + ((float) ((int) ((((float) i5) * MathUtils.clamp(lerp, 0.0f, 0.01f)) / 0.01f))));
        int clamp4 = (int) ((lerp2 * f7) - ((float) ((int) ((((float) i6) * (1.0f - MathUtils.clamp(lerp2, 0.99f, 1.0f))) / 0.01f))));
        float f8 = (-f7) / 2.0f;
        if (clamp3 <= clamp4) {
            float f9 = this.displayedCornerRadius;
            float f10 = ((float) clamp3) + f9;
            float f11 = ((float) clamp4) - f9;
            float f12 = f9 * 2.0f;
            paint.setColor(i4);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (f10 >= f11) {
                Canvas canvas2 = canvas;
                Paint paint2 = paint;
                drawRoundedBlock(canvas2, paint2, new PointF(f10 + f8, 0.0f), new PointF(f11 + f8, 0.0f), f12, this.displayedTrackThickness);
                return;
            }
            float f13 = f12;
            paint.setStyle(Paint.Style.STROKE);
            if (this.useStrokeCap) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint.setStrokeCap(cap);
            float f14 = f10 + f8;
            float f15 = f11 + f8;
            canvas.drawLine(f14, 0.0f, f15, 0.0f, paint);
            float f16 = f14;
            float f17 = f15;
            if (!this.useStrokeCap && this.displayedCornerRadius > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                if (f10 > 0.0f) {
                    f6 = f13;
                    drawRoundedBlock(canvas, paint, new PointF(f16, 0.0f), f6, this.displayedTrackThickness);
                } else {
                    f6 = f13;
                }
                if (f11 < this.trackLength) {
                    drawRoundedBlock(canvas, paint, new PointF(f17, 0.0f), f6, this.displayedTrackThickness);
                }
            }
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, float f4, float f5) {
        drawRoundedBlock(canvas, paint, pointF, (PointF) null, f4, f5);
    }

    /* access modifiers changed from: package-private */
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f4, boolean z4, boolean z5) {
        boolean z6;
        this.trackLength = (float) rect.width();
        float f5 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate(((float) rect.left) + (((float) rect.width()) / 2.0f), ((float) rect.top) + (((float) rect.height()) / 2.0f) + Math.max(0.0f, (((float) rect.height()) - f5) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f6 = this.trackLength / 2.0f;
        float f7 = f5 / 2.0f;
        canvas.clipRect(-f6, -f7, f6, f7);
        S s4 = this.spec;
        if (((LinearProgressIndicatorSpec) s4).trackThickness / 2 == ((LinearProgressIndicatorSpec) s4).trackCornerRadius) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.useStrokeCap = z6;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s4).trackThickness) * f4;
        this.displayedCornerRadius = ((float) Math.min(((LinearProgressIndicatorSpec) s4).trackThickness / 2, ((LinearProgressIndicatorSpec) s4).trackCornerRadius)) * f4;
        if (z4 || z5) {
            if ((z4 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z5 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z4 || (z5 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness) * (1.0f - f4)) / 2.0f);
            }
        }
        if (!z5 || ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3) {
            this.totalTrackLengthFraction = 1.0f;
        } else {
            this.totalTrackLengthFraction = f4;
        }
    }

    /* access modifiers changed from: package-private */
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i4, i5);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize > 0 && compositeARGBWithAlpha != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(compositeARGBWithAlpha);
            PointF pointF = new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f);
            S s4 = this.spec;
            drawRoundedBlock(canvas, paint, pointF, (float) ((LinearProgressIndicatorSpec) s4).trackStopIndicatorSize, (float) ((LinearProgressIndicatorSpec) s4).trackStopIndicatorSize);
        }
    }

    /* access modifiers changed from: package-private */
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i4) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i4);
        float f4 = activeIndicator.startFraction;
        float f5 = activeIndicator.endFraction;
        int i5 = activeIndicator.gapSize;
        drawLine(canvas, paint, f4, f5, compositeARGBWithAlpha, i5, i5);
    }

    /* access modifiers changed from: package-private */
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f4, float f5, int i4, int i5, @Px int i6) {
        drawLine(canvas, paint, f4, f5, MaterialColors.compositeARGBWithAlpha(i4, i5), i6, i6);
    }

    /* access modifiers changed from: package-private */
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    /* access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return -1;
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, @Nullable PointF pointF2, float f4, float f5) {
        float min = Math.min(f5, this.displayedTrackThickness);
        float f6 = f4 / 2.0f;
        float min2 = Math.min(f6, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f4) / 2.0f, (-min) / 2.0f, f6, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
