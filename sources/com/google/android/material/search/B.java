package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

public final /* synthetic */ class B implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FadeThroughDrawable f11025a;

    public /* synthetic */ B(FadeThroughDrawable fadeThroughDrawable) {
        this.f11025a = fadeThroughDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f11025a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
