package com.google.android.material.motion;

import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClippableRoundedCornerLayout f11020a;

    public /* synthetic */ c(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.f11020a = clippableRoundedCornerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f11020a.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
