package com.google.android.material.internal;

import android.view.View;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11017a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f11018b;

    public /* synthetic */ k(View view, boolean z4) {
        this.f11017a = view;
        this.f11018b = z4;
    }

    public final void run() {
        ViewUtils.showKeyboard(this.f11017a, this.f11018b);
    }
}
