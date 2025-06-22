package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    @Px
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z4);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z4);
    }

    public ClockHandView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void adjustLevel(float f4, float f5) {
        int i4 = 2;
        if (MathUtils.dist((float) (getWidth() / 2), (float) (getHeight() / 2), f4, f5) > ((float) getLeveledCircleRadius(2)) + ViewUtils.dpToPx(getContext(), 12)) {
            i4 = 1;
        }
        this.currentLevel = i4;
    }

    private void drawSelector(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int leveledCircleRadius = getLeveledCircleRadius(this.currentLevel);
        float f4 = (float) width;
        float f5 = (float) leveledCircleRadius;
        float cos = (((float) Math.cos(this.degRad)) * f5) + f4;
        float f6 = (float) height;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, (f5 * ((float) Math.sin(this.degRad))) + f6, (float) this.selectorRadius, this.paint);
        double sin = Math.sin(this.degRad);
        double cos2 = Math.cos(this.degRad);
        double d5 = (double) ((float) (leveledCircleRadius - this.selectorRadius));
        float f7 = (float) (height + ((int) (d5 * sin)));
        this.paint.setStrokeWidth((float) this.selectorStrokeWidth);
        Canvas canvas2 = canvas;
        canvas2.drawLine(f4, f6, (float) (width + ((int) (cos2 * d5))), f7, this.paint);
        canvas2.drawCircle(f4, f6, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float f4, float f5) {
        int degrees = (int) Math.toDegrees(Math.atan2((double) (f5 - ((float) (getHeight() / 2))), (double) (f4 - ((float) (getWidth() / 2)))));
        int i4 = degrees + 90;
        if (i4 < 0) {
            return degrees + 450;
        }
        return i4;
    }

    @Dimension
    private int getLeveledCircleRadius(int i4) {
        if (i4 == 2) {
            return Math.round(((float) this.circleRadius) * 0.66f);
        }
        return this.circleRadius;
    }

    private Pair<Float, Float> getValuesForAnimation(float f4) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f4) > 180.0f) {
            if (handRotation > 180.0f && f4 < 180.0f) {
                f4 += 360.0f;
            }
            if (handRotation < 180.0f && f4 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(handRotation), Float.valueOf(f4));
    }

    private boolean handleTouchInput(float f4, float f5, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        float degreesFromXY = (float) getDegreesFromXY(f4, f5);
        boolean z8 = false;
        if (getHandRotation() != degreesFromXY) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z5 && z7) {
            return true;
        }
        if (!z7 && !z4) {
            return false;
        }
        if (z6 && this.animatingOnTouchUp) {
            z8 = true;
        }
        setHandRotation(degreesFromXY, z8);
        return true;
    }

    private void setHandRotationInternal(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z4) {
        float f5 = f4 % 360.0f;
        this.originalDeg = f5;
        this.degRad = Math.toRadians((double) (f5 - 90.0f));
        float leveledCircleRadius = (float) getLeveledCircleRadius(this.currentLevel);
        float width = ((float) (getWidth() / 2)) + (((float) Math.cos(this.degRad)) * leveledCircleRadius);
        float height = ((float) (getHeight() / 2)) + (leveledCircleRadius * ((float) Math.sin(this.degRad)));
        RectF rectF = this.selectorBox;
        int i4 = this.selectorRadius;
        rectF.set(width - ((float) i4), height - ((float) i4), width + ((float) i4), height + ((float) i4));
        for (OnRotateListener onRotate : this.listeners) {
            onRotate.onRotate(f5, z4);
        }
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.listeners.add(onRotateListener);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSelector(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (!this.rotationAnimator.isRunning()) {
            setHandRotation(getHandRotation());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        boolean z6;
        OnActionUpListener onActionUpListener2;
        boolean z7;
        boolean z8;
        int actionMasked = motionEvent.getActionMasked();
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        if (actionMasked == 0) {
            this.downX = x4;
            this.downY = y4;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z6 = false;
            z5 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i4 = (int) (x4 - this.downX);
            int i5 = (int) (y4 - this.downY);
            if ((i4 * i4) + (i5 * i5) > this.scaledTouchSlop) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.isInTapRegion = z7;
            z6 = this.changedDuringTouch;
            if (actionMasked == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.isMultiLevel) {
                adjustLevel(x4, y4);
            }
            z4 = z8;
            z5 = false;
            boolean handleTouchInput = this.changedDuringTouch | handleTouchInput(x4, y4, z6, z5, z4);
            this.changedDuringTouch = handleTouchInput;
            if (handleTouchInput && z4 && (onActionUpListener2 = this.onActionUpListener) != null) {
                onActionUpListener2.onActionUp((float) getDegreesFromXY(x4, y4), this.isInTapRegion);
            }
            return true;
        } else {
            z6 = false;
            z5 = false;
        }
        z4 = false;
        boolean handleTouchInput2 = this.changedDuringTouch | handleTouchInput(x4, y4, z6, z5, z4);
        this.changedDuringTouch = handleTouchInput2;
        onActionUpListener2.onActionUp((float) getDegreesFromXY(x4, y4), this.isInTapRegion);
        return true;
    }

    public void setAnimateOnTouchUp(boolean z4) {
        this.animatingOnTouchUp = z4;
    }

    public void setCircleRadius(@Dimension int i4) {
        this.circleRadius = i4;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setCurrentLevel(int i4) {
        this.currentLevel = i4;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f4) {
        setHandRotation(f4, false);
    }

    /* access modifiers changed from: package-private */
    public void setMultiLevel(boolean z4) {
        if (this.isMultiLevel && !z4) {
            this.currentLevel = 1;
        }
        this.isMultiLevel = z4;
        invalidate();
    }

    public void setOnActionUpListener(OnActionUpListener onActionUpListener2) {
        this.onActionUpListener = onActionUpListener2;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f4, boolean z4) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z4) {
            setHandRotationInternal(f4, false);
            return;
        }
        Pair<Float, Float> valuesForAnimation = getValuesForAnimation(f4);
        this.rotationAnimator.setFloatValues(new float[]{((Float) valuesForAnimation.first).floatValue(), ((Float) valuesForAnimation.second).floatValue()});
        this.rotationAnimator.setDuration((long) this.animationDuration);
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.addUpdateListener(new b(this));
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint paint2 = new Paint();
        this.paint = paint2;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i4, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint2.setAntiAlias(true);
        paint2.setColor(color);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}
