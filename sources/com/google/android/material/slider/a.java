package com.google.android.material.slider;

import android.view.ViewTreeObserver;

public final /* synthetic */ class a implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseSlider f11068a;

    public /* synthetic */ a(BaseSlider baseSlider) {
        this.f11068a = baseSlider;
    }

    public final void onScrollChanged() {
        this.f11068a.updateLabels();
    }
}
