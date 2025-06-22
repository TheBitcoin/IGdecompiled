package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class e implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimePickerTextInputPresenter f11088a;

    public /* synthetic */ e(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.f11088a = timePickerTextInputPresenter;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i4, boolean z4) {
        TimePickerTextInputPresenter.a(this.f11088a, materialButtonToggleGroup, i4, z4);
    }
}
