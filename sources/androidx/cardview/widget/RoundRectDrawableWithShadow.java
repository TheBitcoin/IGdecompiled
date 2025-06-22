package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f4, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f4, float f5, float f6) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (float) ((int) (f4 + 0.5f));
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f5, f6);
    }

    private void buildComponents(Rect rect) {
        float f4 = this.mRawMaxShadowSize;
        float f5 = SHADOW_MULTIPLIER * f4;
        this.mCardBounds.set(((float) rect.left) + f4, ((float) rect.top) + f5, ((float) rect.right) - f4, ((float) rect.bottom) - f5);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f4 = this.mCornerRadius;
        RectF rectF = new RectF(-f4, -f4, f4, f4);
        RectF rectF2 = new RectF(rectF);
        float f5 = this.mShadowSize;
        rectF2.inset(-f5, -f5);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f6 = this.mCornerRadius;
        float f7 = f6 / (this.mShadowSize + f6);
        Paint paint = this.mCornerShadowPaint;
        float f8 = this.mCornerRadius + this.mShadowSize;
        int i4 = this.mShadowStartColor;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f8, new int[]{i4, i4, this.mShadowEndColor}, new float[]{0.0f, f7, 1.0f}, tileMode));
        Paint paint2 = this.mEdgeShadowPaint;
        float f9 = this.mCornerRadius;
        float f10 = this.mShadowSize;
        float f11 = (-f9) - f10;
        int i5 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, (-f9) + f10, 0.0f, f11, new int[]{i5, i5, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float f4, float f5, boolean z4) {
        if (z4) {
            return (float) (((double) f4) + ((1.0d - COS_45) * ((double) f5)));
        }
        return f4;
    }

    static float calculateVerticalPadding(float f4, float f5, boolean z4) {
        if (z4) {
            return (float) (((double) (f4 * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f5)));
        }
        return f4 * SHADOW_MULTIPLIER;
    }

    private void drawShadow(Canvas canvas) {
        boolean z4;
        boolean z5;
        Canvas canvas2;
        float f4 = this.mCornerRadius;
        float f5 = (-f4) - this.mShadowSize;
        float f6 = f4 + ((float) this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        float f7 = 2.0f * f6;
        if (this.mCardBounds.width() - f7 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.mCardBounds.height() - f7 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f6, rectF.top + f6);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z4) {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, f5, this.mCardBounds.width() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
        } else {
            canvas2 = canvas;
        }
        canvas2.restoreToCount(save);
        int save2 = canvas2.save();
        RectF rectF2 = this.mCardBounds;
        canvas2.translate(rectF2.right - f6, rectF2.bottom - f6);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z4) {
            canvas2.drawRect(0.0f, f5, this.mCardBounds.width() - f7, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save2);
        int save3 = canvas2.save();
        RectF rectF3 = this.mCardBounds;
        canvas2.translate(rectF3.left + f6, rectF3.bottom - f6);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z5) {
            canvas2.drawRect(0.0f, f5, this.mCardBounds.height() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save3);
        int save4 = canvas2.save();
        RectF rectF4 = this.mCardBounds;
        canvas2.translate(rectF4.right - f6, rectF4.top + f6);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z5) {
            canvas2.drawRect(0.0f, f5, this.mCardBounds.height() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas2.restoreToCount(save4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f4, float f5) {
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f4 + ". Must be >= 0");
        } else if (f5 >= 0.0f) {
            float even = (float) toEven(f4);
            float even2 = (float) toEven(f5);
            if (even > even2) {
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
                even = even2;
            }
            if (this.mRawShadowSize != even || this.mRawMaxShadowSize != even2) {
                this.mRawShadowSize = even;
                this.mRawMaxShadowSize = even2;
                this.mShadowSize = (float) ((int) ((even * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow) + 0.5f));
                this.mDirty = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f5 + ". Must be >= 0");
        }
    }

    private int toEven(float f4) {
        int i4 = (int) (f4 + 0.5f);
        if (i4 % 2 == 1) {
            return i4 - 1;
        }
        return i4;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getColor() {
        return this.mBackground;
    }

    /* access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    /* access modifiers changed from: package-private */
    public void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    /* access modifiers changed from: package-private */
    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    /* access modifiers changed from: package-private */
    public float getMinHeight() {
        float f4 = this.mRawMaxShadowSize;
        return (Math.max(f4, this.mCornerRadius + ((float) this.mInsetShadow) + ((f4 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public float getMinWidth() {
        float f4 = this.mRawMaxShadowSize;
        return (Math.max(f4, this.mCornerRadius + ((float) this.mInsetShadow) + (f4 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* access modifiers changed from: package-private */
    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        if ((colorStateList == null || !colorStateList.isStateful()) && !super.isStateful()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setAddPaddingForCorners(boolean z4) {
        this.mAddPaddingForCorners = z4;
        invalidateSelf();
    }

    public void setAlpha(int i4) {
        this.mPaint.setAlpha(i4);
        this.mCornerShadowPaint.setAlpha(i4);
        this.mEdgeShadowPaint.setAlpha(i4);
    }

    /* access modifiers changed from: package-private */
    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: package-private */
    public void setCornerRadius(float f4) {
        if (f4 >= 0.0f) {
            float f5 = (float) ((int) (f4 + 0.5f));
            if (this.mCornerRadius != f5) {
                this.mCornerRadius = f5;
                this.mDirty = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f4 + ". Must be >= 0");
    }

    /* access modifiers changed from: package-private */
    public void setMaxShadowSize(float f4) {
        setShadowSize(this.mRawShadowSize, f4);
    }

    /* access modifiers changed from: package-private */
    public void setShadowSize(float f4) {
        setShadowSize(f4, this.mRawMaxShadowSize);
    }
}
