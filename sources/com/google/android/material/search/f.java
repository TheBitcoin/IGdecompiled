package com.google.android.material.search;

import android.animation.Animator;
import com.google.android.material.animation.AnimatableView;

public final /* synthetic */ class f implements AnimatableView.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Animator f11031a;

    public /* synthetic */ f(Animator animator) {
        this.f11031a = animator;
    }

    public final void onAnimationEnd() {
        this.f11031a.start();
    }
}
