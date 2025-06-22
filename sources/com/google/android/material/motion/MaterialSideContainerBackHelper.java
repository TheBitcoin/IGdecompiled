package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(@NonNull View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean checkAbsoluteGravity(@GravityInt int i4, @GravityInt int i5) {
        if ((GravityCompat.getAbsoluteGravity(i4, ViewCompat.getLayoutDirection(this.view)) & i5) == i5) {
            return true;
        }
        return false;
    }

    private int getEdgeMargin(boolean z4) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z4) {
            return marginLayoutParams.leftMargin;
        }
        return marginLayoutParams.rightMargin;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f})});
            V v4 = this.view;
            if (v4 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v4;
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(viewGroup.getChildAt(i4), View.SCALE_Y, new float[]{1.0f})});
                }
            }
            animatorSet.setDuration((long) this.cancelDuration);
            animatorSet.start();
        }
    }

    public void finishBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt final int i4, @Nullable Animator.AnimatorListener animatorListener, @Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z4;
        if (backEventCompat.getSwipeEdge() == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i4, 3);
        float width = (((float) this.view.getWidth()) * this.view.getScaleX()) + ((float) getEdgeMargin(checkAbsoluteGravity));
        V v4 = this.view;
        Property property = View.TRANSLATION_X;
        if (checkAbsoluteGravity) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v4, property, new float[]{width});
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.setDuration((long) AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, backEventCompat.getProgress()));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.view.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.updateBackProgress(0.0f, z4, i4);
            }
        });
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void startBackProgress(@NonNull BackEventCompat backEventCompat) {
        super.onStartBackProgress(backEventCompat);
    }

    public void updateBackProgress(@NonNull BackEventCompat backEventCompat, @GravityInt int i4) {
        if (super.onUpdateBackProgress(backEventCompat) != null) {
            updateBackProgress(backEventCompat.getProgress(), backEventCompat.getSwipeEdge() == 0, i4);
        }
    }

    @VisibleForTesting
    public void updateBackProgress(float f4, boolean z4, @GravityInt int i4) {
        int i5;
        float interpolateProgress = interpolateProgress(f4);
        boolean checkAbsoluteGravity = checkAbsoluteGravity(i4, 3);
        boolean z5 = z4 == checkAbsoluteGravity;
        int width = this.view.getWidth();
        int height = this.view.getHeight();
        float f5 = (float) width;
        if (f5 > 0.0f) {
            float f6 = (float) height;
            if (f6 > 0.0f) {
                float f7 = this.maxScaleXDistanceShrink / f5;
                float f8 = this.maxScaleXDistanceGrow / f5;
                float f9 = this.maxScaleYDistance / f6;
                V v4 = this.view;
                if (checkAbsoluteGravity) {
                    f5 = 0.0f;
                }
                v4.setPivotX(f5);
                if (!z5) {
                    f8 = -f7;
                }
                float lerp = AnimationUtils.lerp(0.0f, f8, interpolateProgress);
                float f10 = lerp + 1.0f;
                this.view.setScaleX(f10);
                float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f9, interpolateProgress);
                this.view.setScaleY(lerp2);
                V v5 = this.view;
                if (v5 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v5;
                    for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
                        View childAt = viewGroup.getChildAt(i6);
                        if (checkAbsoluteGravity) {
                            i5 = (width - childAt.getRight()) + childAt.getWidth();
                        } else {
                            i5 = -childAt.getLeft();
                        }
                        childAt.setPivotX((float) i5);
                        childAt.setPivotY((float) (-childAt.getTop()));
                        float f11 = z5 ? 1.0f - lerp : 1.0f;
                        float f12 = lerp2 != 0.0f ? (f10 / lerp2) * f11 : 1.0f;
                        childAt.setScaleX(f11);
                        childAt.setScaleY(f12);
                    }
                }
            }
        }
    }
}
