package w2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* renamed from: w2.a  reason: case insensitive filesystem */
public final /* synthetic */ class C2343a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f22019a;

    public /* synthetic */ C2343a(ImageView imageView) {
        this.f22019a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        C2345c.d(this.f22019a, valueAnimator);
    }
}
