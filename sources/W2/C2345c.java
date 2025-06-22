package w2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.jvm.internal.m;

/* renamed from: w2.c  reason: case insensitive filesystem */
public final class C2345c {

    /* renamed from: a  reason: collision with root package name */
    public static final C2345c f22021a = new C2345c();

    private C2345c() {
    }

    /* access modifiers changed from: private */
    public static final void d(ImageView imageView, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i4 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i4, i4, i4, i4);
    }

    /* access modifiers changed from: private */
    public static final void f(ImageView imageView, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i4 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i4, i4, i4, i4);
    }

    public final void c(ProgressBar progressBar, ImageView imageView) {
        m.e(progressBar, "progressBar");
        m.e(imageView, "imageView");
        if (progressBar.getVisibility() == 0) {
            progressBar.setVisibility(8);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.4f, 1.0f});
            ofFloat.setStartDelay(200);
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2343a(imageView));
            m.b(ofFloat);
            ofFloat.addListener(new a(progressBar));
            ofFloat.start();
        }
    }

    public final void e(ProgressBar progressBar, ImageView imageView) {
        m.e(progressBar, "progressBar");
        m.e(imageView, "imageView");
        if (progressBar.getVisibility() == 8) {
            progressBar.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new C2344b(imageView));
            ofFloat.start();
        }
    }

    /* renamed from: w2.c$a */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f22022a;

        public a(ProgressBar progressBar) {
            this.f22022a = progressBar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22022a.setVisibility(8);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }
}
