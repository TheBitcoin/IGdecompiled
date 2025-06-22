package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.leanback.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SeekBar extends View {
    private AccessibilitySeekListener mAccessibilitySeekListener;
    private int mActiveBarHeight;
    private int mActiveRadius;
    private final Paint mBackgroundPaint;
    private final RectF mBackgroundRect = new RectF();
    private int mBarHeight;
    private final Paint mKnobPaint;
    private int mKnobx;
    private int mMax;
    private int mProgress;
    private final Paint mProgressPaint;
    private final RectF mProgressRect = new RectF();
    private int mSecondProgress;
    private final Paint mSecondProgressPaint;
    private final RectF mSecondProgressRect = new RectF();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class AccessibilitySeekListener {
        public abstract boolean onAccessibilitySeekBackward();

        public abstract boolean onAccessibilitySeekForward();
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.mSecondProgressPaint = paint;
        Paint paint2 = new Paint(1);
        this.mProgressPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mBackgroundPaint = paint3;
        Paint paint4 = new Paint(1);
        this.mKnobPaint = paint4;
        setWillNotDraw(false);
        paint3.setColor(-7829368);
        paint.setColor(-3355444);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint4.setColor(-1);
        this.mBarHeight = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_bar_height);
        this.mActiveBarHeight = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_bar_height);
        this.mActiveRadius = context.getResources().getDimensionPixelSize(R.dimen.lb_playback_transport_progressbar_active_radius);
    }

    private void calculate() {
        int i4;
        int i5;
        if (isFocused()) {
            i4 = this.mActiveBarHeight;
        } else {
            i4 = this.mBarHeight;
        }
        int width = getWidth();
        int height = getHeight();
        int i6 = (height - i4) / 2;
        RectF rectF = this.mBackgroundRect;
        int i7 = this.mBarHeight;
        float f4 = (float) i6;
        float f5 = (float) (height - i6);
        rectF.set((float) (i7 / 2), f4, (float) (width - (i7 / 2)), f5);
        if (isFocused()) {
            i5 = this.mActiveRadius;
        } else {
            i5 = this.mBarHeight / 2;
        }
        float f6 = (float) (width - (i5 * 2));
        float f7 = (((float) this.mProgress) / ((float) this.mMax)) * f6;
        RectF rectF2 = this.mProgressRect;
        int i8 = this.mBarHeight;
        rectF2.set((float) (i8 / 2), f4, ((float) (i8 / 2)) + f7, f5);
        this.mSecondProgressRect.set(this.mProgressRect.right, f4, ((float) (this.mBarHeight / 2)) + ((((float) this.mSecondProgress) / ((float) this.mMax)) * f6), f5);
        this.mKnobx = i5 + ((int) f7);
        invalidate();
    }

    public CharSequence getAccessibilityClassName() {
        return android.widget.SeekBar.class.getName();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getSecondProgress() {
        return this.mSecondProgress;
    }

    public int getSecondaryProgressColor() {
        return this.mSecondProgressPaint.getColor();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i4;
        super.onDraw(canvas);
        if (isFocused()) {
            i4 = this.mActiveRadius;
        } else {
            i4 = this.mBarHeight / 2;
        }
        float f4 = (float) i4;
        canvas.drawRoundRect(this.mBackgroundRect, f4, f4, this.mBackgroundPaint);
        RectF rectF = this.mSecondProgressRect;
        if (rectF.right > rectF.left) {
            canvas.drawRoundRect(rectF, f4, f4, this.mSecondProgressPaint);
        }
        canvas.drawRoundRect(this.mProgressRect, f4, f4, this.mProgressPaint);
        canvas.drawCircle((float) this.mKnobx, (float) (getHeight() / 2), f4, this.mKnobPaint);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        calculate();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        calculate();
    }

    public boolean performAccessibilityAction(int i4, Bundle bundle) {
        AccessibilitySeekListener accessibilitySeekListener = this.mAccessibilitySeekListener;
        if (accessibilitySeekListener != null) {
            if (i4 == 4096) {
                return accessibilitySeekListener.onAccessibilitySeekForward();
            }
            if (i4 == 8192) {
                return accessibilitySeekListener.onAccessibilitySeekBackward();
            }
        }
        return super.performAccessibilityAction(i4, bundle);
    }

    public void setAccessibilitySeekListener(AccessibilitySeekListener accessibilitySeekListener) {
        this.mAccessibilitySeekListener = accessibilitySeekListener;
    }

    public void setActiveBarHeight(int i4) {
        this.mActiveBarHeight = i4;
        calculate();
    }

    public void setActiveRadius(int i4) {
        this.mActiveRadius = i4;
        calculate();
    }

    public void setBarHeight(int i4) {
        this.mBarHeight = i4;
        calculate();
    }

    public void setMax(int i4) {
        this.mMax = i4;
        calculate();
    }

    public void setProgress(int i4) {
        int i5 = this.mMax;
        if (i4 > i5) {
            i4 = i5;
        } else if (i4 < 0) {
            i4 = 0;
        }
        this.mProgress = i4;
        calculate();
    }

    public void setProgressColor(int i4) {
        this.mProgressPaint.setColor(i4);
    }

    public void setSecondaryProgress(int i4) {
        int i5 = this.mMax;
        if (i4 > i5) {
            i4 = i5;
        } else if (i4 < 0) {
            i4 = 0;
        }
        this.mSecondProgress = i4;
        calculate();
    }

    public void setSecondaryProgressColor(int i4) {
        this.mSecondProgressPaint.setColor(i4);
    }
}
