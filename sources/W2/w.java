package w2;

import android.animation.ValueAnimator;
import com.uptodown.util.views.UsernameTextView;

public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UsernameTextView f22053a;

    public /* synthetic */ w(UsernameTextView usernameTextView) {
        this.f22053a = usernameTextView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        UsernameTextView.b.b(this.f22053a, valueAnimator);
    }
}
