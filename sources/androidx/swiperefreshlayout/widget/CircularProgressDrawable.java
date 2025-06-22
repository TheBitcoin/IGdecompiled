package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    private static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds = new RectF();

        Ring() {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            Paint paint3 = new Paint();
            this.mCirclePaint = paint3;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f4 = this.mRingCenterRadius;
            float f5 = (this.mStrokeWidth / 2.0f) + f4;
            if (f4 <= 0.0f) {
                f5 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.mArrowWidth) * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f5, ((float) rect.centerY()) - f5, ((float) rect.centerX()) + f5, ((float) rect.centerY()) + f5);
            float f6 = this.mStartTrim;
            float f7 = this.mRotation;
            float f8 = (f6 + f7) * 360.0f;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float f9 = this.mStrokeWidth / 2.0f;
            rectF.inset(f9, f9);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            float f10 = -f9;
            rectF.inset(f10, f10);
            float f11 = ((this.mEndTrim + f7) * 360.0f) - f8;
            Canvas canvas2 = canvas;
            float f12 = f8;
            canvas2.drawArc(rectF, f12, f11, false, this.mPaint);
            drawTriangle(canvas2, f12, f11, rectF);
        }

        /* access modifiers changed from: package-private */
        public void drawTriangle(Canvas canvas, float f4, float f5, RectF rectF) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(((float) this.mArrowWidth) * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f6 = this.mArrowScale;
                path3.lineTo((((float) this.mArrowWidth) * f6) / 2.0f, ((float) this.mArrowHeight) * f6);
                this.mArrow.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.mArrowWidth) * this.mArrowScale) / 2.0f), rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f4 + f5, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public int getAlpha() {
            return this.mAlpha;
        }

        /* access modifiers changed from: package-private */
        public float getArrowHeight() {
            return (float) this.mArrowHeight;
        }

        /* access modifiers changed from: package-private */
        public float getArrowScale() {
            return this.mArrowScale;
        }

        /* access modifiers changed from: package-private */
        public float getArrowWidth() {
            return (float) this.mArrowWidth;
        }

        /* access modifiers changed from: package-private */
        public int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        /* access modifiers changed from: package-private */
        public float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        /* access modifiers changed from: package-private */
        public int[] getColors() {
            return this.mColors;
        }

        /* access modifiers changed from: package-private */
        public float getEndTrim() {
            return this.mEndTrim;
        }

        /* access modifiers changed from: package-private */
        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        /* access modifiers changed from: package-private */
        public int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        /* access modifiers changed from: package-private */
        public float getRotation() {
            return this.mRotation;
        }

        /* access modifiers changed from: package-private */
        public boolean getShowArrow() {
            return this.mShowArrow;
        }

        /* access modifiers changed from: package-private */
        public float getStartTrim() {
            return this.mStartTrim;
        }

        /* access modifiers changed from: package-private */
        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        /* access modifiers changed from: package-private */
        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        /* access modifiers changed from: package-private */
        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        /* access modifiers changed from: package-private */
        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        /* access modifiers changed from: package-private */
        public Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        /* access modifiers changed from: package-private */
        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        /* access modifiers changed from: package-private */
        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        /* access modifiers changed from: package-private */
        public void setAlpha(int i4) {
            this.mAlpha = i4;
        }

        /* access modifiers changed from: package-private */
        public void setArrowDimensions(float f4, float f5) {
            this.mArrowWidth = (int) f4;
            this.mArrowHeight = (int) f5;
        }

        /* access modifiers changed from: package-private */
        public void setArrowScale(float f4) {
            if (f4 != this.mArrowScale) {
                this.mArrowScale = f4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setBackgroundColor(int i4) {
            this.mCirclePaint.setColor(i4);
        }

        /* access modifiers changed from: package-private */
        public void setCenterRadius(float f4) {
            this.mRingCenterRadius = f4;
        }

        /* access modifiers changed from: package-private */
        public void setColor(int i4) {
            this.mCurrentColor = i4;
        }

        /* access modifiers changed from: package-private */
        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void setColorIndex(int i4) {
            this.mColorIndex = i4;
            this.mCurrentColor = this.mColors[i4];
        }

        /* access modifiers changed from: package-private */
        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        /* access modifiers changed from: package-private */
        public void setEndTrim(float f4) {
            this.mEndTrim = f4;
        }

        /* access modifiers changed from: package-private */
        public void setRotation(float f4) {
            this.mRotation = f4;
        }

        /* access modifiers changed from: package-private */
        public void setShowArrow(boolean z4) {
            if (this.mShowArrow != z4) {
                this.mShowArrow = z4;
            }
        }

        /* access modifiers changed from: package-private */
        public void setStartTrim(float f4) {
            this.mStartTrim = f4;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeCap(Paint.Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f4) {
            this.mStrokeWidth = f4;
            this.mPaint.setStrokeWidth(f4);
        }

        /* access modifiers changed from: package-private */
        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float f4, Ring ring) {
        updateRingColor(f4, ring);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - MIN_PROGRESS_ARC) - ring.getStartingStartTrim()) * f4));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((((float) (Math.floor((double) (ring.getStartingRotation() / MAX_PROGRESS_ARC)) + 1.0d)) - ring.getStartingRotation()) * f4));
    }

    private int evaluateColorChange(float f4, int i4, int i5) {
        int i6 = (i4 >> 24) & 255;
        int i7 = (i4 >> 16) & 255;
        int i8 = (i4 >> 8) & 255;
        int i9 = i4 & 255;
        return ((i6 + ((int) (((float) (((i5 >> 24) & 255) - i6)) * f4))) << 24) | ((i7 + ((int) (((float) (((i5 >> 16) & 255) - i7)) * f4))) << 16) | ((i8 + ((int) (((float) (((i5 >> 8) & 255) - i8)) * f4))) << 8) | (i9 + ((int) (f4 * ((float) ((i5 & 255) - i9)))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f4) {
        this.mRotation = f4;
    }

    private void setSizeParameters(float f4, float f5, float f6, float f7) {
        Ring ring = this.mRing;
        float f8 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f5 * f8);
        ring.setCenterRadius(f4 * f8);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f6 * f8, f7 * f8);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.updateRingColor(floatValue, ring);
                CircularProgressDrawable.this.applyTransformation(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.applyTransformation(1.0f, ring, true);
                ring.storeOriginals();
                ring.goToNextColor();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.mFinishing) {
                    circularProgressDrawable.mFinishing = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.setShowArrow(false);
                    return;
                }
                circularProgressDrawable.mRotationCount += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }
        });
        this.mAnimator = ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void applyTransformation(float f4, Ring ring, boolean z4) {
        float f5;
        float f6;
        if (this.mFinishing) {
            applyFinishTranslation(f4, ring);
        } else if (f4 != 1.0f || z4) {
            float startingRotation = ring.getStartingRotation();
            if (f4 < 0.5f) {
                f5 = ring.getStartingStartTrim();
                f6 = (MATERIAL_INTERPOLATOR.getInterpolation(f4 / 0.5f) * 0.79f) + MIN_PROGRESS_ARC + f5;
            } else {
                float startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                float f7 = startingStartTrim;
                f5 = startingStartTrim - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f4 - 0.5f) / 0.5f)) * 0.79f) + MIN_PROGRESS_ARC);
                f6 = f7;
            }
            float f8 = startingRotation + (RING_ROTATION * f4);
            float f9 = (f4 + this.mRotationCount) * GROUP_FULL_ROTATION;
            ring.setStartTrim(f5);
            ring.setEndTrim(f6);
            ring.setRotation(f8);
            setRotation(f9);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int i4) {
        this.mRing.setAlpha(i4);
        invalidateSelf();
    }

    public void setArrowDimensions(float f4, float f5) {
        this.mRing.setArrowDimensions(f4, f5);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z4) {
        this.mRing.setShowArrow(z4);
        invalidateSelf();
    }

    public void setArrowScale(float f4) {
        this.mRing.setArrowScale(f4);
        invalidateSelf();
    }

    public void setBackgroundColor(int i4) {
        this.mRing.setBackgroundColor(i4);
        invalidateSelf();
    }

    public void setCenterRadius(float f4) {
        this.mRing.setCenterRadius(f4);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f4) {
        this.mRing.setRotation(f4);
        invalidateSelf();
    }

    public void setStartEndTrim(float f4, float f5) {
        this.mRing.setStartTrim(f4);
        this.mRing.setEndTrim(f5);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f4) {
        this.mRing.setStrokeWidth(f4);
        invalidateSelf();
    }

    public void setStyle(int i4) {
        if (i4 == 0) {
            setSizeParameters(CENTER_RADIUS_LARGE, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
        } else {
            setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666);
            this.mAnimator.start();
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void updateRingColor(float f4, Ring ring) {
        if (f4 > 0.75f) {
            ring.setColor(evaluateColorChange((f4 - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }
}
