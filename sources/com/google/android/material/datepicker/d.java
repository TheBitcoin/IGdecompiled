package com.google.android.material.datepicker;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11013a;

    public /* synthetic */ d(View view) {
        this.f11013a = view;
    }

    public final void run() {
        ViewUtils.requestFocusAndShowKeyboard(this.f11013a, false);
    }
}
