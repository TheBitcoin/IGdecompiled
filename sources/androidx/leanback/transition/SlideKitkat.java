package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import androidx.leanback.R;

@RequiresApi(19)
class SlideKitkat extends Visibility {
    private static final String TAG = "SlideKitkat";
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final CalculateSlide sCalculateBottom = new CalculateSlideVertical() {
        public float getGone(View view) {
            return view.getTranslationY() + ((float) view.getHeight());
        }
    };
    private static final CalculateSlide sCalculateEnd = new CalculateSlideHorizontal() {
        public float getGone(View view) {
            if (view.getLayoutDirection() == 1) {
                return view.getTranslationX() - ((float) view.getWidth());
            }
            return view.getTranslationX() + ((float) view.getWidth());
        }
    };
    private static final CalculateSlide sCalculateLeft = new CalculateSlideHorizontal() {
        public float getGone(View view) {
            return view.getTranslationX() - ((float) view.getWidth());
        }
    };
    private static final CalculateSlide sCalculateRight = new CalculateSlideHorizontal() {
        public float getGone(View view) {
            return view.getTranslationX() + ((float) view.getWidth());
        }
    };
    private static final CalculateSlide sCalculateStart = new CalculateSlideHorizontal() {
        public float getGone(View view) {
            if (view.getLayoutDirection() == 1) {
                return view.getTranslationX() + ((float) view.getWidth());
            }
            return view.getTranslationX() - ((float) view.getWidth());
        }
    };
    private static final CalculateSlide sCalculateTop = new CalculateSlideVertical() {
        public float getGone(View view) {
            return view.getTranslationY() - ((float) view.getHeight());
        }
    };
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;

    private interface CalculateSlide {
        float getGone(View view);

        float getHere(View view);

        Property<View, Float> getProperty();
    }

    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        CalculateSlideHorizontal() {
        }

        public float getHere(View view) {
            return view.getTranslationX();
        }

        public Property<View, Float> getProperty() {
            return View.TRANSLATION_X;
        }
    }

    private static abstract class CalculateSlideVertical implements CalculateSlide {
        CalculateSlideVertical() {
        }

        public float getHere(View view) {
            return view.getTranslationY();
        }

        public Property<View, Float> getProperty() {
            return View.TRANSLATION_Y;
        }
    }

    private static class SlideAnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private final float mEndValue;
        private final int mFinalVisibility;
        private float mPausedValue;
        private final Property<View, Float> mProp;
        private final float mTerminalValue;
        private final View mView;

        public SlideAnimatorListener(View view, Property<View, Float> property, float f4, float f5, int i4) {
            this.mProp = property;
            this.mView = view;
            this.mTerminalValue = f4;
            this.mEndValue = f5;
            this.mFinalVisibility = i4;
            view.setVisibility(0);
        }

        public void onAnimationCancel(Animator animator) {
            this.mView.setTag(R.id.lb_slide_transition_value, new float[]{this.mView.getTranslationX(), this.mView.getTranslationY()});
            this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            }
            this.mView.setVisibility(this.mFinalVisibility);
        }

        public void onAnimationPause(Animator animator) {
            this.mPausedValue = this.mProp.get(this.mView).floatValue();
            this.mProp.set(this.mView, Float.valueOf(this.mEndValue));
            this.mView.setVisibility(this.mFinalVisibility);
        }

        public void onAnimationResume(Animator animator) {
            this.mProp.set(this.mView, Float.valueOf(this.mPausedValue));
            this.mView.setVisibility(0);
        }
    }

    public SlideKitkat() {
        setSlideEdge(80);
    }

    private Animator createAnimation(View view, Property<View, Float> property, float f4, float f5, float f6, TimeInterpolator timeInterpolator, int i4) {
        int i5 = R.id.lb_slide_transition_value;
        float[] fArr = (float[]) view.getTag(i5);
        if (fArr != null) {
            if (View.TRANSLATION_Y == property) {
                f4 = fArr[1];
            } else {
                f4 = fArr[0];
            }
            view.setTag(i5, (Object) null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, new float[]{f4, f5});
        SlideAnimatorListener slideAnimatorListener = new SlideAnimatorListener(view, property, f6, f5, i4);
        ofFloat.addListener(slideAnimatorListener);
        ofFloat.addPauseListener(slideAnimatorListener);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i4, TransitionValues transitionValues2, int i5) {
        View view;
        if (transitionValues2 != null) {
            view = transitionValues2.view;
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), this.mSlideCalculator.getGone(view), here, here, sDecelerate, 0);
    }

    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i4, TransitionValues transitionValues2, int i5) {
        View view;
        if (transitionValues != null) {
            view = transitionValues.view;
        } else {
            view = null;
        }
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), here, this.mSlideCalculator.getGone(view), here, sAccelerate, 4);
    }

    public void setSlideEdge(int i4) {
        if (i4 == 3) {
            this.mSlideCalculator = sCalculateLeft;
        } else if (i4 == 5) {
            this.mSlideCalculator = sCalculateRight;
        } else if (i4 == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i4 == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i4 == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else if (i4 == 8388613) {
            this.mSlideCalculator = sCalculateEnd;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.mSlideEdge = i4;
    }

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 80));
        long j4 = (long) obtainStyledAttributes.getInt(R.styleable.lbSlide_android_duration, -1);
        if (j4 >= 0) {
            setDuration(j4);
        }
        long j5 = (long) obtainStyledAttributes.getInt(R.styleable.lbSlide_android_startDelay, -1);
        if (j5 > 0) {
            setStartDelay(j5);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.lbSlide_android_interpolator, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }
}
