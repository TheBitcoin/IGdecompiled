package com.google.android.material.card;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialCardViewHelper f10941a;

    public /* synthetic */ b(MaterialCardViewHelper materialCardViewHelper) {
        this.f10941a = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        MaterialCardViewHelper.a(this.f10941a, valueAnimator);
    }
}
