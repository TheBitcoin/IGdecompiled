package com.google.android.material.timepicker;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClockHandView f11085a;

    public /* synthetic */ b(ClockHandView clockHandView) {
        this.f11085a = clockHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ClockHandView.a(this.f11085a, valueAnimator);
    }
}
