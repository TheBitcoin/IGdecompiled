package y2;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class l implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f22815a;

    public /* synthetic */ l(View view) {
        this.f22815a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        n.e(this.f22815a, valueAnimator);
    }
}
