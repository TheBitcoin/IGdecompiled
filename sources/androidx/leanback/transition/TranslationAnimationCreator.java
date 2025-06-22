package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View view, View view2, int i4, int i5, float f4, float f5) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i4 - Math.round(view.getTranslationX());
            this.mStartY = i5 - Math.round(view.getTranslationY());
            this.mTerminalX = f4;
            this.mTerminalY = f5;
            int i6 = R.id.transitionPosition;
            int[] iArr = (int[]) view2.getTag(i6);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(i6, (Object) null);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(((float) this.mStartX) + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(((float) this.mStartY) + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transitionPosition, this.mTransitionPosition);
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    private TranslationAnimationCreator() {
    }

    static Animator createAnimation(View view, TransitionValues transitionValues, int i4, int i5, float f4, float f5, float f6, float f7, TimeInterpolator timeInterpolator, Transition transition) {
        float f8 = f5;
        float translationX = view.getTranslationX();
        float f9 = f6;
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transitionPosition);
        if (iArr != null) {
            f4 = ((float) (iArr[0] - i4)) + translationX;
            f8 = ((float) (iArr[1] - i5)) + translationY;
        }
        int round = i4 + Math.round(f4 - translationX);
        int round2 = i5 + Math.round(f8 - translationY);
        view.setTranslationX(f4);
        view.setTranslationY(f8);
        if (f4 == f9 && f8 == f7) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f4, f8);
        path.lineTo(f9, f7);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, View.TRANSLATION_Y, path);
        int i6 = round2;
        int i7 = round;
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, i7, i6, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofFloat.addListener(transitionPositionListener);
        ofFloat.addPauseListener(transitionPositionListener);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }
}
