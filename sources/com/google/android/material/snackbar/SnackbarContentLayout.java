package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void updateTopBottomPadding(@NonNull View view, int i4, int i5) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i4, ViewCompat.getPaddingEnd(view), i5);
        } else {
            view.setPadding(view.getPaddingLeft(), i4, view.getPaddingRight(), i5);
        }
    }

    private boolean updateViewsWithinLayout(int i4, int i5, int i6) {
        boolean z4;
        if (i4 != getOrientation()) {
            setOrientation(i4);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.messageView.getPaddingTop() == i5 && this.messageView.getPaddingBottom() == i6) {
            return z4;
        }
        updateTopBottomPadding(this.messageView, i5, i6);
        return true;
    }

    public void animateContentIn(int i4, int i5) {
        this.messageView.setAlpha(0.0f);
        long j4 = (long) i5;
        long j5 = (long) i4;
        this.messageView.animate().alpha(1.0f).setDuration(j4).setInterpolator(this.contentInterpolator).setStartDelay(j5).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j4).setInterpolator(this.contentInterpolator).setStartDelay(j5).start();
        }
    }

    public void animateContentOut(int i4, int i5) {
        this.messageView.setAlpha(1.0f);
        long j4 = (long) i5;
        long j5 = (long) i4;
        this.messageView.animate().alpha(0.0f).setDuration(j4).setInterpolator(this.contentInterpolator).setStartDelay(j5).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j4).setInterpolator(this.contentInterpolator).setStartDelay(j5).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        boolean z4;
        super.onMeasure(i4, i5);
        if (getOrientation() != 1) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
            Layout layout = this.messageView.getLayout();
            if (layout == null || layout.getLineCount() <= 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
                if (!z4) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                    return;
                }
            } else if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
            super.onMeasure(i4, i5);
        }
    }

    public void setMaxInlineActionWidth(int i4) {
        this.maxInlineActionWidth = i4;
    }

    /* access modifiers changed from: package-private */
    public void updateActionTextColorAlphaIfNeeded(float f4) {
        if (f4 != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f4));
        }
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }
}
