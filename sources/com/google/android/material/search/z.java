package com.google.android.material.search;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public final /* synthetic */ class z implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerArrowDrawable f11055a;

    public /* synthetic */ z(DrawerArrowDrawable drawerArrowDrawable) {
        this.f11055a = drawerArrowDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f11055a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
