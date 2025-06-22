package com.google.android.material.search;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* renamed from: com.google.android.material.search.c  reason: case insensitive filesystem */
public final /* synthetic */ class C1785c implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchBar f11029a;

    public /* synthetic */ C1785c(SearchBar searchBar) {
        this.f11029a = searchBar;
    }

    public final void onTouchExplorationStateChanged(boolean z4) {
        this.f11029a.setFocusableInTouchMode(z4);
    }
}
