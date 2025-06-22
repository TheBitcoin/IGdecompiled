package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i4) {
        this.slideEdge = i4;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i4, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i4 == 3) {
            return createTranslationXAnimator(view2, ((float) i5) + translationX, translationX, translationX);
        }
        if (i4 == 5) {
            return createTranslationXAnimator(view2, translationX - ((float) i5), translationX, translationX);
        }
        if (i4 == 48) {
            return createTranslationYAnimator(view2, translationY - ((float) i5), translationY, translationY);
        }
        if (i4 == 80) {
            return createTranslationYAnimator(view2, ((float) i5) + translationY, translationY, translationY);
        }
        if (i4 == 8388611) {
            if (isRtl(view)) {
                f4 = ((float) i5) + translationX;
            } else {
                f4 = translationX - ((float) i5);
            }
            return createTranslationXAnimator(view2, f4, translationX, translationX);
        } else if (i4 == 8388613) {
            if (isRtl(view)) {
                f5 = translationX - ((float) i5);
            } else {
                f5 = ((float) i5) + translationX;
            }
            return createTranslationXAnimator(view2, f5, translationX, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i4);
        }
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i4, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i4 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - ((float) i5), translationX);
        }
        if (i4 == 5) {
            return createTranslationXAnimator(view2, translationX, ((float) i5) + translationX, translationX);
        }
        if (i4 == 48) {
            return createTranslationYAnimator(view2, translationY, ((float) i5) + translationY, translationY);
        }
        if (i4 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - ((float) i5), translationY);
        }
        if (i4 == 8388611) {
            if (isRtl(view)) {
                f4 = translationX - ((float) i5);
            } else {
                f4 = ((float) i5) + translationX;
            }
            return createTranslationXAnimator(view2, translationX, f4, translationX);
        } else if (i4 == 8388613) {
            if (isRtl(view)) {
                f5 = ((float) i5) + translationX;
            } else {
                f5 = translationX - ((float) i5);
            }
            return createTranslationXAnimator(view2, translationX, f5, translationX);
        } else {
            throw new IllegalArgumentException("Invalid slide direction: " + i4);
        }
    }

    private static Animator createTranslationXAnimator(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f4, f5})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f4, f5})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i4 = this.slideDistance;
        if (i4 != -1) {
            return i4;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i4) {
        if (i4 >= 0) {
            this.slideDistance = i4;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i4) {
        this.slideEdge = i4;
    }
}
