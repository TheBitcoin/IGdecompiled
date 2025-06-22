package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExpandCollapseAnimationHelper f11015a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Rect f11016b;

    public /* synthetic */ a(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.f11015a = expandCollapseAnimationHelper;
        this.f11016b = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewUtils.setBoundsFromRect(this.f11015a.expandedView, this.f11016b);
    }
}
