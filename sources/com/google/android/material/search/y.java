package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchViewAnimationHelper f11051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f11052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f11053c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f11054d;

    public /* synthetic */ y(SearchViewAnimationHelper searchViewAnimationHelper, float f4, float f5, Rect rect) {
        this.f11051a = searchViewAnimationHelper;
        this.f11052b = f4;
        this.f11053c = f5;
        this.f11054d = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchViewAnimationHelper.b(this.f11051a, this.f11052b, this.f11053c, this.f11054d, valueAnimator);
    }
}
