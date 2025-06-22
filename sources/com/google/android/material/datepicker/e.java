package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;

public abstract /* synthetic */ class e {
    public static /* synthetic */ void a(EditText[] editTextArr, View view, boolean z4) {
        int length = editTextArr.length;
        int i4 = 0;
        while (i4 < length) {
            if (!editTextArr[i4].hasFocus()) {
                i4++;
            } else {
                return;
            }
        }
        ViewUtils.hideKeyboard(view, false);
    }

    public static void c(EditText... editTextArr) {
        if (editTextArr.length != 0) {
            c cVar = new c(editTextArr);
            for (EditText onFocusChangeListener : editTextArr) {
                onFocusChangeListener.setOnFocusChangeListener(cVar);
            }
            EditText editText = editTextArr[0];
            editText.postDelayed(new d(editText), 100);
        }
    }
}
