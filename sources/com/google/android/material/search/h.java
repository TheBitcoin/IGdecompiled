package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f11037a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f11038b;

    public /* synthetic */ h(MaterialShapeDrawable materialShapeDrawable, View view) {
        this.f11037a = materialShapeDrawable;
        this.f11038b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchBarAnimationHelper.c(this.f11037a, this.f11038b, valueAnimator);
    }
}
