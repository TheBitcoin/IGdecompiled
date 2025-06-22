package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class h implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11077a;

    public /* synthetic */ h(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11077a = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return DropdownMenuEndIconDelegate.e(this.f11077a, view, motionEvent);
    }
}
