package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;

public final /* synthetic */ class d implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Transition.SeekController f1029a;

    public /* synthetic */ d(Transition.SeekController seekController) {
        this.f1029a = seekController;
    }

    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z4, float f4, float f5) {
        Transition.SeekController.a(this.f1029a, dynamicAnimation, z4, f4, f5);
    }
}
