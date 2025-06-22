package com.google.android.material.sidesheet;

import com.google.android.material.sidesheet.SideSheetBehavior;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior.StateSettlingTracker f11067a;

    public /* synthetic */ e(SideSheetBehavior.StateSettlingTracker stateSettlingTracker) {
        this.f11067a = stateSettlingTracker;
    }

    public final void run() {
        SideSheetBehavior.StateSettlingTracker.a(this.f11067a);
    }
}
