package com.google.android.material.textfield;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

public final /* synthetic */ class l implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11081a;

    public /* synthetic */ l(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11081a = dropdownMenuEndIconDelegate;
    }

    public final void onTouchExplorationStateChanged(boolean z4) {
        DropdownMenuEndIconDelegate.b(this.f11081a, z4);
    }
}
