package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f10937a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f10938b;

    public /* synthetic */ c(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.f10937a = appBarLayout;
        this.f10938b = materialShapeDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout.a(this.f10937a, this.f10938b, valueAnimator);
    }
}
