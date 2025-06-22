package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    private final WeakReference<View> mView;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f4) {
            return viewPropertyAnimator.translationZ(f4);
        }

        @DoNotInline
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f4) {
            return viewPropertyAnimator.translationZBy(f4);
        }

        @DoNotInline
        static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float f4) {
            return viewPropertyAnimator.z(f4);
        }

        @DoNotInline
        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f4) {
            return viewPropertyAnimator.zBy(f4);
        }
    }

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().alphaBy(f4);
        }
        return this;
    }

    public void cancel() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @Nullable
    public Interpolator getInterpolator() {
        View view = this.mView.get();
        if (view != null) {
            return (Interpolator) view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotation(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationX(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationXBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationY(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().rotationYBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleX(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleXBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleY(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().scaleYBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long j4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator interpolator) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = this.mView.get();
        if (view != null) {
            setListenerInternal(view, viewPropertyAnimatorListener);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long j4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().setStartDelay(j4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        M m4;
        View view = this.mView.get();
        if (view != null) {
            if (viewPropertyAnimatorUpdateListener != null) {
                m4 = new M(viewPropertyAnimatorUpdateListener, view);
            } else {
                m4 = null;
            }
            view.animate().setUpdateListener(m4);
        }
        return this;
    }

    public void start() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationX(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationXBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().translationYBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float f4) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZ(view.animate(), f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.translationZBy(view.animate(), f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withEndAction(runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @NonNull
    public ViewPropertyAnimatorCompat withLayer() {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withLayer();
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable runnable) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().withStartAction(runnable);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().x(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().xBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().y(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            view.animate().yBy(f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float f4) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.z(view.animate(), f4);
        }
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float f4) {
        View view = this.mView.get();
        if (view != null) {
            Api21Impl.zBy(view.animate(), f4);
        }
        return this;
    }
}
