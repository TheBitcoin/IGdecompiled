package y2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class k implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f22814a;

    public /* synthetic */ k(ImageView imageView) {
        this.f22814a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.m(this.f22814a, valueAnimator);
    }
}
