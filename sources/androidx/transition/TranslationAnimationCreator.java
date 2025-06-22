package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private boolean mIsTransitionCanceled;
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View view, View view2, float f4, float f5) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mTerminalX = f4;
            this.mTerminalY = f5;
            int i4 = R.id.transition_position;
            int[] iArr = (int[]) view2.getTag(i4);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(i4, (Object) null);
            }
        }

        private void setInterruptedPosition() {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mMovingView.getLocationOnScreen(this.mTransitionPosition);
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        public void onAnimationCancel(Animator animator) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z4) {
            if (!z4) {
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
            }
        }

        public void onTransitionCancel(@NonNull Transition transition) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionEnd(@NonNull Transition transition, boolean z4) {
            if (!this.mIsTransitionCanceled) {
                this.mViewInHierarchy.setTag(R.id.transition_position, (Object) null);
            }
        }

        public void onTransitionPause(@NonNull Transition transition) {
            setInterruptedPosition();
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionResume(@NonNull Transition transition) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
            e.b(this, transition, z4);
        }

        public void onAnimationEnd(@NonNull Animator animator) {
            onAnimationEnd(animator, false);
        }

        public void onTransitionEnd(@NonNull Transition transition) {
            onTransitionEnd(transition, false);
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    static Animator createAnimation(@NonNull View view, @NonNull TransitionValues transitionValues, int i4, int i5, float f4, float f5, float f6, float f7, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        float f8;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f4 = ((float) (iArr[0] - i4)) + translationX;
            f8 = ((float) (iArr[1] - i5)) + translationY;
        } else {
            f8 = f5;
        }
        view.setTranslationX(f4);
        view.setTranslationY(f8);
        if (f4 == f6 && f8 == f7) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f4, f6}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f8, f7})});
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
