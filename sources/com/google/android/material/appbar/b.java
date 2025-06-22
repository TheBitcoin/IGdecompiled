package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f10932a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f10933b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ColorStateList f10934c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MaterialShapeDrawable f10935d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Integer f10936e;

    public /* synthetic */ b(AppBarLayout appBarLayout, ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.f10932a = appBarLayout;
        this.f10933b = colorStateList;
        this.f10934c = colorStateList2;
        this.f10935d = materialShapeDrawable;
        this.f10936e = num;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout.b(this.f10932a, this.f10933b, this.f10934c, this.f10935d, this.f10936e, valueAnimator);
    }
}
