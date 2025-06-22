package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class f implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerView f11089a;

    public /* synthetic */ f(TimePickerView timePickerView) {
        this.f11089a = timePickerView;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i4, boolean z4) {
        TimePickerView.a(this.f11089a, materialButtonToggleGroup, i4, z4);
    }
}
