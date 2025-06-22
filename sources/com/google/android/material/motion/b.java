package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class b implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialBackHandler f11019a;

    public /* synthetic */ b(MaterialBackHandler materialBackHandler) {
        this.f11019a = materialBackHandler;
    }

    public final void onBackInvoked() {
        this.f11019a.handleBackInvoked();
    }
}
