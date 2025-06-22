package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f11063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f11064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11065c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f11066d;

    public /* synthetic */ d(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i4, View view) {
        this.f11063a = sideSheetBehavior;
        this.f11064b = marginLayoutParams;
        this.f11065c = i4;
        this.f11066d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SideSheetBehavior.c(this.f11063a, this.f11064b, this.f11065c, this.f11066d, valueAnimator);
    }
}
