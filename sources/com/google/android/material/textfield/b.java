package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClearTextEndIconDelegate f11072a;

    public /* synthetic */ b(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11072a = clearTextEndIconDelegate;
    }

    public final void onFocusChange(View view, boolean z4) {
        this.f11072a.animateIcon(this.f11072a.shouldBeVisible());
    }
}
