package com.google.android.material.textfield;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f11084a;

    public /* synthetic */ y(TextInputLayout textInputLayout) {
        this.f11084a = textInputLayout;
    }

    public final void run() {
        this.f11084a.editText.requestLayout();
    }
}
