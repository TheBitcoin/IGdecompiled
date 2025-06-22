package y2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f22816a;

    public /* synthetic */ m(ImageView imageView) {
        this.f22816a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.k(this.f22816a, valueAnimator);
    }
}
