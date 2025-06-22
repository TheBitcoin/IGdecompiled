package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;

@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {
    static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    static final float SHADOW_BOTTOM_SCALE = 1.0f;
    static final float SHADOW_HORIZ_SCALE = 0.5f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners = true;
    @NonNull
    final RectF contentBounds;
    float cornerRadius;
    @NonNull
    final Paint cornerShadowPaint;
    Path cornerShadowPath;
    private boolean dirty = true;
    @NonNull
    final Paint edgeShadowPaint;
    float maxShadowSize;
    private boolean printedShadowClipWarning = false;
    float rawMaxShadowSize;
    float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    float shadowSize;
    private final int shadowStartColor;

    public ShadowDrawableWrapper(Context context, Drawable drawable, float f4, float f5, float f6) {
        super(drawable);
        this.shadowStartColor = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.shadowMiddleColor = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.shadowEndColor = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.cornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.cornerRadius = (float) Math.round(f4);
        this.contentBounds = new RectF();
        Paint paint2 = new Paint(paint);
        this.edgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f5, f6);
    }

    private void buildComponents(@NonNull Rect rect) {
        float f4 = this.rawMaxShadowSize;
        float f5 = SHADOW_MULTIPLIER * f4;
        this.contentBounds.set(((float) rect.left) + f4, ((float) rect.top) + f5, ((float) rect.right) - f4, ((float) rect.bottom) - f5);
        Drawable drawable = getDrawable();
        RectF rectF = this.contentBounds;
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f4 = this.cornerRadius;
        RectF rectF = new RectF(-f4, -f4, f4, f4);
        RectF rectF2 = new RectF(rectF);
        float f5 = this.shadowSize;
        rectF2.inset(-f5, -f5);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.cornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.cornerShadowPath.moveTo(-this.cornerRadius, 0.0f);
        this.cornerShadowPath.rLineTo(-this.shadowSize, 0.0f);
        this.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.cornerShadowPath.close();
        float f6 = -rectF2.top;
        if (f6 > 0.0f) {
            float f7 = this.cornerRadius / f6;
            this.cornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, f7, ((1.0f - f7) / 2.0f) + f7, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.edgeShadowPaint.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.shadowStartColor, this.shadowMiddleColor, this.shadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.edgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f4, float f5, boolean z4) {
        if (z4) {
            return (float) (((double) f4) + ((1.0d - COS_45) * ((double) f5)));
        }
        return f4;
    }

    public static float calculateVerticalPadding(float f4, float f5, boolean z4) {
        if (z4) {
            return (float) (((double) (f4 * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f5)));
        }
        return f4 * SHADOW_MULTIPLIER;
    }

    private void drawShadow(@NonNull Canvas canvas) {
        boolean z4;
        boolean z5;
        float f4;
        int i4;
        Canvas canvas2 = canvas;
        int save = canvas2.save();
        canvas2.rotate(this.rotation, this.contentBounds.centerX(), this.contentBounds.centerY());
        float f5 = this.cornerRadius;
        float f6 = (-f5) - this.shadowSize;
        float f7 = f5 * 2.0f;
        if (this.contentBounds.width() - f7 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.contentBounds.height() - f7 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        float f8 = this.rawShadowSize;
        float f9 = f5 / ((f8 - (0.5f * f8)) + f5);
        float f10 = f5 / ((f8 - (SHADOW_TOP_SCALE * f8)) + f5);
        float f11 = f5 / ((f8 - (f8 * 1.0f)) + f5);
        int save2 = canvas2.save();
        RectF rectF = this.contentBounds;
        canvas2.translate(rectF.left + f5, rectF.top + f5);
        canvas2.scale(f9, f10);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas2.scale(1.0f / f9, 1.0f);
            i4 = save2;
            f4 = 1.0f;
            canvas2.drawRect(0.0f, f6, this.contentBounds.width() - f7, -this.cornerRadius, this.edgeShadowPaint);
        } else {
            i4 = save2;
            f4 = 1.0f;
        }
        canvas2.restoreToCount(i4);
        int save3 = canvas2.save();
        RectF rectF2 = this.contentBounds;
        canvas2.translate(rectF2.right - f5, rectF2.bottom - f5);
        canvas2.scale(f9, f11);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z4) {
            canvas2.scale(f4 / f9, 1.0f);
            canvas2.drawRect(0.0f, f6, this.contentBounds.width() - f7, this.shadowSize + (-this.cornerRadius), this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas2.save();
        RectF rectF3 = this.contentBounds;
        canvas2.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas2.scale(f9, f11);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas2.scale(1.0f / f11, 1.0f);
            canvas2.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
        int save5 = canvas2.save();
        RectF rectF4 = this.contentBounds;
        canvas2.translate(rectF4.right - f5, rectF4.top + f5);
        canvas2.scale(f9, f10);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.cornerShadowPath, this.cornerShadowPaint);
        if (z5) {
            canvas2.scale(1.0f / f10, 1.0f);
            canvas2.drawRect(0.0f, f6, this.contentBounds.height() - f7, -this.cornerRadius, this.edgeShadowPaint);
        }
        canvas2.restoreToCount(save5);
        canvas2.restoreToCount(save);
    }

    private static int toEven(float f4) {
        int round = Math.round(f4);
        if (round % 2 == 1) {
            return round - 1;
        }
        return round;
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.dirty) {
            buildComponents(getBounds());
            this.dirty = false;
        }
        drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f4 = this.rawMaxShadowSize;
        return (Math.max(f4, this.cornerRadius + ((f4 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * SHADOW_MULTIPLIER * 2.0f);
    }

    public float getMinWidth() {
        float f4 = this.rawMaxShadowSize;
        return (Math.max(f4, this.cornerRadius + (f4 / 2.0f)) * 2.0f) + (this.rawMaxShadowSize * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(@NonNull Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.rawMaxShadowSize, this.cornerRadius, this.addPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean z4) {
        this.addPaddingForCorners = z4;
        invalidateSelf();
    }

    public void setAlpha(int i4) {
        super.setAlpha(i4);
        this.cornerShadowPaint.setAlpha(i4);
        this.edgeShadowPaint.setAlpha(i4);
    }

    public void setCornerRadius(float f4) {
        float round = (float) Math.round(f4);
        if (this.cornerRadius != round) {
            this.cornerRadius = round;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setMaxShadowSize(float f4) {
        setShadowSize(this.rawShadowSize, f4);
    }

    public final void setRotation(float f4) {
        if (this.rotation != f4) {
            this.rotation = f4;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f4, float f5) {
        if (f4 < 0.0f || f5 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float even = (float) toEven(f4);
        float even2 = (float) toEven(f5);
        if (even > even2) {
            if (!this.printedShadowClipWarning) {
                this.printedShadowClipWarning = true;
            }
            even = even2;
        }
        if (this.rawShadowSize != even || this.rawMaxShadowSize != even2) {
            this.rawShadowSize = even;
            this.rawMaxShadowSize = even2;
            this.shadowSize = (float) Math.round(even * SHADOW_MULTIPLIER);
            this.maxShadowSize = even2;
            this.dirty = true;
            invalidateSelf();
        }
    }

    public void setShadowSize(float f4) {
        setShadowSize(f4, this.rawMaxShadowSize);
    }
}
