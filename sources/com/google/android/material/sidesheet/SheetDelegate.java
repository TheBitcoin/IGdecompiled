package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class SheetDelegate {
    SheetDelegate() {
    }

    /* access modifiers changed from: package-private */
    public abstract int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract float calculateSlideOffset(int i4);

    /* access modifiers changed from: package-private */
    public abstract int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    /* access modifiers changed from: package-private */
    public abstract int getExpandedOffset();

    /* access modifiers changed from: package-private */
    public abstract int getHiddenOffset();

    /* access modifiers changed from: package-private */
    public abstract int getMaxViewPositionHorizontal();

    /* access modifiers changed from: package-private */
    public abstract int getMinViewPositionHorizontal();

    /* access modifiers changed from: package-private */
    public abstract <V extends View> int getOuterEdge(@NonNull V v4);

    /* access modifiers changed from: package-private */
    public abstract int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout);

    /* access modifiers changed from: package-private */
    public abstract int getSheetEdge();

    /* access modifiers changed from: package-private */
    public abstract boolean isExpandingOutwards(float f4);

    /* access modifiers changed from: package-private */
    public abstract boolean isReleasedCloseToInnerEdge(@NonNull View view);

    /* access modifiers changed from: package-private */
    public abstract boolean isSwipeSignificant(float f4, float f5);

    /* access modifiers changed from: package-private */
    public abstract boolean shouldHide(@NonNull View view, float f4);

    /* access modifiers changed from: package-private */
    public abstract void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i4);

    /* access modifiers changed from: package-private */
    public abstract void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5);
}
