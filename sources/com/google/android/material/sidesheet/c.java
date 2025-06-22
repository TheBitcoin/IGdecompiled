package com.google.android.material.sidesheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class c implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f11061a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11062b;

    public /* synthetic */ c(SideSheetBehavior sideSheetBehavior, int i4) {
        this.f11061a = sideSheetBehavior;
        this.f11062b = i4;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f11061a.setState(this.f11062b);
    }
}
