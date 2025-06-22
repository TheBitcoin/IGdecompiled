package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public final /* synthetic */ class d implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetDragHandleView f10940a;

    public /* synthetic */ d(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.f10940a = bottomSheetDragHandleView;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f10940a.expandOrCollapseBottomSheetIfPossible();
    }
}
