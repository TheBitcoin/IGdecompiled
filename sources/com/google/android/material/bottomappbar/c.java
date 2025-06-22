package com.google.android.material.bottomappbar;

import android.view.View;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f10939a;

    public /* synthetic */ c(View view) {
        this.f10939a = view;
    }

    public final void run() {
        this.f10939a.requestLayout();
    }
}
