package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class k implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11080a;

    public /* synthetic */ k(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11080a = dropdownMenuEndIconDelegate;
    }

    public final void onFocusChange(View view, boolean z4) {
        DropdownMenuEndIconDelegate.d(this.f11080a, view, z4);
    }
}
