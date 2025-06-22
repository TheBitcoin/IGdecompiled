package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = ((float) Math.toRadians(45.0d));
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection = 2;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath = new Path();
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float lerp(float f4, float f5, float f6) {
        return f4 + ((f5 - f4) * f6);
    }

    public void draw(@NonNull Canvas canvas) {
        float f4;
        float f5;
        int i4;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i5 = this.mDirection;
        boolean z4 = false;
        if (i5 != 0 && (i5 == 1 || (i5 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z4 = true;
        }
        float f6 = this.mArrowHeadLength;
        float lerp = lerp(this.mBarLength, (float) Math.sqrt((double) (f6 * f6 * 2.0f)), this.mProgress);
        float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float round = (float) Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (z4) {
            f4 = 0.0f;
        } else {
            f4 = -180.0f;
        }
        if (z4) {
            f5 = 180.0f;
        } else {
            f5 = 0.0f;
        }
        float lerp4 = lerp(f4, f5, this.mProgress);
        double d5 = (double) lerp;
        double d6 = (double) lerp3;
        boolean z5 = z4;
        float round2 = (float) Math.round(Math.cos(d6) * d5);
        float round3 = (float) Math.round(d5 * Math.sin(d6));
        this.mPath.rewind();
        float lerp5 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f7 = (-lerp2) / 2.0f;
        this.mPath.moveTo(f7 + round, 0.0f);
        this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f7, lerp5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f7, -lerp5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas2.save();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f8 = this.mBarGap;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (f8 * 2.0f))) / 4) * 2)) + (strokeWidth * 1.5f) + f8);
        if (this.mSpin) {
            if (this.mVerticalMirror ^ z5) {
                i4 = -1;
            } else {
                i4 = 1;
            }
            canvas2.rotate(lerp4 * ((float) i4));
        } else if (z5) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.mPath, this.mPaint);
        canvas2.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    public void setAlpha(int i4) {
        if (i4 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i4);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f4) {
        if (this.mArrowHeadLength != f4) {
            this.mArrowHeadLength = f4;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f4) {
        if (this.mArrowShaftLength != f4) {
            this.mArrowShaftLength = f4;
            invalidateSelf();
        }
    }

    public void setBarLength(float f4) {
        if (this.mBarLength != f4) {
            this.mBarLength = f4;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f4) {
        if (this.mPaint.getStrokeWidth() != f4) {
            this.mPaint.setStrokeWidth(f4);
            this.mMaxCutForBarSize = (float) (((double) (f4 / 2.0f)) * Math.cos((double) ARROW_HEAD_ANGLE));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i4) {
        if (i4 != this.mPaint.getColor()) {
            this.mPaint.setColor(i4);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i4) {
        if (i4 != this.mDirection) {
            this.mDirection = i4;
            invalidateSelf();
        }
    }

    public void setGapSize(float f4) {
        if (f4 != this.mBarGap) {
            this.mBarGap = f4;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.mProgress != f4) {
            this.mProgress = f4;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z4) {
        if (this.mSpin != z4) {
            this.mSpin = z4;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z4) {
        if (this.mVerticalMirror != z4) {
            this.mVerticalMirror = z4;
            invalidateSelf();
        }
    }
}
