package y2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import w2.j;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    public static final a f22817b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f22818a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public n(Context context) {
        m.e(context, "context");
        this.f22818a = context;
    }

    /* access modifiers changed from: private */
    public static final void e(View view, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* access modifiers changed from: private */
    public static final void k(ImageView imageView, ValueAnimator valueAnimator) {
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
    public static final void m(ImageView imageView, ValueAnimator valueAnimator) {
        m.e(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        m.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        imageView.setScaleX(floatValue);
        imageView.setScaleY(floatValue);
        int i4 = (int) (((float) 10) * (((float) 1) - floatValue));
        imageView.setPadding(i4, i4, i4, i4);
    }

    public final void d(View view, float f4) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (f4 == 1.0f) {
            view.setClickable(true);
        } else if (f4 == 0.3f) {
            view.setClickable(false);
        }
        if (!com.uptodown.activities.preferences.a.f18818a.N(this.f22818a) || UptodownApp.f17422D.Q()) {
            view.setAlpha(f4);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{view.getAlpha(), f4});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new l(view));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    public final void f(int i4, View view, int i5) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f22818a, i5);
        loadAnimation.setRepeatCount(i4);
        view.startAnimation(loadAnimation);
    }

    public final void g(View view, int i4, Animation.AnimationListener animationListener) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        m.e(animationListener, "callback");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f22818a, i4);
        if (!com.uptodown.activities.preferences.a.f18818a.N(this.f22818a) || UptodownApp.f17422D.Q()) {
            animationListener.onAnimationEnd(loadAnimation);
            return;
        }
        loadAnimation.setAnimationListener(animationListener);
        view.startAnimation(loadAnimation);
    }

    public final void h(View view, int i4) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (!com.uptodown.activities.preferences.a.f18818a.N(this.f22818a) || UptodownApp.f17422D.Q()) {
            view.setVisibility(0);
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this.f22818a, i4));
        view.setVisibility(0);
    }

    public final void i(View view, int i4) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (!com.uptodown.activities.preferences.a.f18818a.N(this.f22818a) || UptodownApp.f17422D.Q()) {
            view.setVisibility(8);
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(this.f22818a, i4));
        view.setVisibility(8);
    }

    public final void j(ImageView imageView, d3.a aVar) {
        m.e(imageView, "iconView");
        m.e(aVar, "doOnEnd");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.6f, 1.0f});
        ofFloat.setStartDelay(200);
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new m(imageView));
        m.b(ofFloat);
        ofFloat.addListener(new b(aVar));
        ofFloat.start();
    }

    public final void l(ImageView imageView, d3.a aVar) {
        m.e(imageView, "iconView");
        m.e(aVar, "doOnEnd");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.6f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new k(imageView));
        m.b(ofFloat);
        ofFloat.addListener(new c(aVar));
        ofFloat.start();
    }

    public final void n(ImageView imageView) {
        m.e(imageView, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (com.uptodown.activities.preferences.a.f18818a.N(this.f22818a) && !UptodownApp.f17422D.Q()) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this.f22818a, R.drawable.vector_heart_red));
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f22818a, R.anim.like_bounce);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f22818a, R.anim.like_bounce_back);
            j jVar = new j(0.2d, 10.0d);
            loadAnimation.setInterpolator(jVar);
            loadAnimation2.setInterpolator(jVar);
            loadAnimation.setAnimationListener(new d(imageView, loadAnimation2));
            imageView.startAnimation(loadAnimation);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f22819a;

        public b(d3.a aVar) {
            this.f22819a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22819a.invoke();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f22820a;

        public c(d3.a aVar) {
            this.f22820a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22820a.invoke();
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f22821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Animation f22822b;

        d(ImageView imageView, Animation animation) {
            this.f22821a = imageView;
            this.f22822b = animation;
        }

        public void onAnimationEnd(Animation animation) {
            this.f22821a.startAnimation(this.f22822b);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }
}
