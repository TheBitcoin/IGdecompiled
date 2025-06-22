package w2;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* renamed from: w2.b  reason: case insensitive filesystem */
public final /* synthetic */ class C2344b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f22020a;

    public /* synthetic */ C2344b(ImageView imageView) {
        this.f22020a = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        C2345c.f(this.f22020a, valueAnimator);
    }
}
