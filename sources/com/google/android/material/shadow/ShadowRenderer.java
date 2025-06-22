package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    @NonNull
    private final Paint cornerShadowPaint;
    @NonNull
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    @NonNull
    private final Paint shadowPaint;
    private int shadowStartColor;
    private final Paint transparentPaint;

    public ShadowRenderer() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void drawCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i4, float f4, float f5) {
        boolean z4;
        float f6;
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i5 = i4;
        float f7 = f5;
        if (f7 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        Path path = this.scratch;
        if (z4) {
            int[] iArr = cornerColors;
            iArr[0] = 0;
            iArr[1] = this.shadowEndColor;
            iArr[2] = this.shadowMiddleColor;
            iArr[3] = this.shadowStartColor;
            f6 = f4;
        } else {
            path.rewind();
            path.moveTo(rectF2.centerX(), rectF2.centerY());
            f6 = f4;
            path.arcTo(rectF2, f6, f7);
            path.close();
            float f8 = (float) (-i5);
            rectF2.inset(f8, f8);
            int[] iArr2 = cornerColors;
            iArr2[0] = 0;
            iArr2[1] = this.shadowStartColor;
            iArr2[2] = this.shadowMiddleColor;
            iArr2[3] = this.shadowEndColor;
        }
        float width = rectF2.width() / 2.0f;
        if (width > 0.0f) {
            float f9 = 1.0f - (((float) i5) / width);
            float[] fArr = cornerPositions;
            fArr[1] = f9;
            fArr[2] = ((1.0f - f9) / 2.0f) + f9;
            this.cornerShadowPaint.setShader(new RadialGradient(rectF2.centerX(), rectF2.centerY(), width, cornerColors, fArr, Shader.TileMode.CLAMP));
            canvas2.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF2.height() / rectF2.width());
            if (!z4) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.transparentPaint);
            }
            canvas2.drawArc(rectF2, f6, f7, true, this.cornerShadowPaint);
            canvas.restore();
        }
    }

    public void drawEdgeShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i4) {
        rectF.bottom += (float) i4;
        rectF.offset(0.0f, (float) (-i4));
        int[] iArr = edgeColors;
        iArr[0] = this.shadowEndColor;
        iArr[1] = this.shadowMiddleColor;
        iArr[2] = this.shadowStartColor;
        Paint paint = this.edgeShadowPaint;
        float f4 = rectF.left;
        paint.setShader(new LinearGradient(f4, rectF.top, f4, rectF.bottom, iArr, edgePositions, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    public void drawInnerCornerShadow(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i4, float f4, float f5, @NonNull float[] fArr) {
        if (f5 > 0.0f) {
            f4 += f5;
            f5 = -f5;
        }
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        RectF rectF2 = rectF;
        float f6 = f4;
        float f7 = f5;
        drawCornerShadow(canvas2, matrix2, rectF2, i4, f6, f7);
        Path path = this.scratch;
        path.rewind();
        path.moveTo(fArr[0], fArr[1]);
        path.arcTo(rectF2, f6, f7);
        path.close();
        canvas2.save();
        canvas2.concat(matrix2);
        canvas2.scale(1.0f, rectF2.height() / rectF2.width());
        canvas2.drawPath(path, this.transparentPaint);
        canvas2.drawPath(path, this.shadowPaint);
        canvas2.restore();
    }

    @NonNull
    public Paint getShadowPaint() {
        return this.shadowPaint;
    }

    public void setShadowColor(int i4) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i4, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i4, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i4, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }

    public ShadowRenderer(int i4) {
        this.scratch = new Path();
        Paint paint = new Paint();
        this.transparentPaint = paint;
        this.shadowPaint = new Paint();
        setShadowColor(i4);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.cornerShadowPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.edgeShadowPaint = new Paint(paint2);
    }
}
