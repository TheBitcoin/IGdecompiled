package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    private static final int ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPropertyAnimator currentAnimator;
    @ScrollState
    private int currentState = 2;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height = 0;
    @NonNull
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners = new LinkedHashSet<>();

    public interface OnScrollStateChangedListener {
        void onStateChanged(@NonNull View view, @ScrollState int i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void animateChildTo(@NonNull V v4, int i4, long j4, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v4.animate().translationY((float) i4).setInterpolator(timeInterpolator).setDuration(j4).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.currentAnimator = null;
            }
        });
    }

    private void updateCurrentState(@NonNull V v4, @ScrollState int i4) {
        this.currentState = i4;
        Iterator<OnScrollStateChangedListener> it = this.onScrollStateChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v4, this.currentState);
        }
    }

    public void addOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.add(onScrollStateChangedListener);
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }

    public boolean isScrolledDown() {
        if (this.currentState == 1) {
            return true;
        }
        return false;
    }

    public boolean isScrolledUp() {
        if (this.currentState == 2) {
            return true;
        }
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, int i4) {
        this.height = v4.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v4.getLayoutParams()).bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(v4.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(v4.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        Context context = v4.getContext();
        int i5 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(context, i5, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(v4.getContext(), i5, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(coordinatorLayout, v4, i4);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, int i4, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
        if (i5 > 0) {
            slideDown(v4);
        } else if (i5 < 0) {
            slideUp(v4);
        }
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v4, @NonNull View view, @NonNull View view2, int i4, int i5) {
        return i4 == 2;
    }

    public void removeOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.remove(onScrollStateChangedListener);
    }

    public void setAdditionalHiddenOffsetY(@NonNull V v4, @Dimension int i4) {
        this.additionalHiddenOffsetY = i4;
        if (this.currentState == 1) {
            v4.setTranslationY((float) (this.height + i4));
        }
    }

    public void slideDown(@NonNull V v4) {
        slideDown(v4, true);
    }

    public void slideUp(@NonNull V v4) {
        slideUp(v4, true);
    }

    public void slideDown(@NonNull V v4, boolean z4) {
        if (!isScrolledDown()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v4.clearAnimation();
            }
            updateCurrentState(v4, 1);
            int i4 = this.height + this.additionalHiddenOffsetY;
            if (z4) {
                animateChildTo(v4, i4, (long) this.exitAnimDuration, this.exitAnimInterpolator);
                return;
            }
            v4.setTranslationY((float) i4);
        }
    }

    public void slideUp(@NonNull V v4, boolean z4) {
        if (!isScrolledUp()) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v4.clearAnimation();
            }
            updateCurrentState(v4, 2);
            if (z4) {
                animateChildTo(v4, 0, (long) this.enterAnimDuration, this.enterAnimInterpolator);
                return;
            }
            v4.setTranslationY((float) 0);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
