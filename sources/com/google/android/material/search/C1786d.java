package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.google.android.material.search.d  reason: case insensitive filesystem */
public final /* synthetic */ class C1786d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11030a;

    public /* synthetic */ C1786d(View view) {
        this.f11030a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f11030a.setAlpha(0.0f);
    }
}
