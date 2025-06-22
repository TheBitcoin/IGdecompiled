package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText[] f11012a;

    public /* synthetic */ c(EditText[] editTextArr) {
        this.f11012a = editTextArr;
    }

    public final void onFocusChange(View view, boolean z4) {
        e.a(this.f11012a, view, z4);
    }
}
