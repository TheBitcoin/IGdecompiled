package com.google.android.material.snackbar;

import android.view.View;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Snackbar f11069a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f11070b;

    public /* synthetic */ c(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f11069a = snackbar;
        this.f11070b = onClickListener;
    }

    public final void onClick(View view) {
        Snackbar.a(this.f11069a, this.f11070b, view);
    }
}
