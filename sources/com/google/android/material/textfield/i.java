package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

public final /* synthetic */ class i implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11078a;

    public /* synthetic */ i(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11078a = dropdownMenuEndIconDelegate;
    }

    public final void onDismiss() {
        DropdownMenuEndIconDelegate.f(this.f11078a);
    }
}
