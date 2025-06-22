package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class M implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener f914a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f915b;

    public /* synthetic */ M(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.f914a = viewPropertyAnimatorUpdateListener;
        this.f915b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f914a.onAnimationUpdate(this.f915b);
    }
}
