package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning = false;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.hourLayoutComboView = chipTextInputComboView;
        this.minuteLayoutComboView = chipTextInputComboView2;
        this.time = timeModel;
    }

    private void clearPrefilledText(EditText editText) {
        if (editText.getSelectionStart() == 0 && editText.length() == 2) {
            editText.getText().clear();
        }
    }

    private void moveSelection(int i4) {
        boolean z4;
        ChipTextInputComboView chipTextInputComboView = this.minuteLayoutComboView;
        boolean z5 = false;
        if (i4 == 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        chipTextInputComboView.setChecked(z4);
        ChipTextInputComboView chipTextInputComboView2 = this.hourLayoutComboView;
        if (i4 == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
        this.time.selection = i4;
    }

    private boolean onHourKeyPress(int i4, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (i4 >= 7 && i4 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
            moveSelection(12);
            return true;
        }
        clearPrefilledText(editText);
        return false;
    }

    private boolean onMinuteKeyPress(int i4, KeyEvent keyEvent, EditText editText) {
        if (i4 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            moveSelection(10);
            return true;
        }
        clearPrefilledText(editText);
        return false;
    }

    public void bind() {
        TextInputLayout textInput = this.hourLayoutComboView.getTextInput();
        TextInputLayout textInput2 = this.minuteLayoutComboView.getTextInput();
        EditText editText = textInput.getEditText();
        EditText editText2 = textInput2.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
        boolean z4;
        if (i4 == 5) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            moveSelection(12);
        }
        return z4;
    }

    public boolean onKey(View view, int i4, KeyEvent keyEvent) {
        boolean z4;
        if (this.keyListenerRunning) {
            return false;
        }
        this.keyListenerRunning = true;
        EditText editText = (EditText) view;
        if (this.time.selection == 12) {
            z4 = onMinuteKeyPress(i4, keyEvent, editText);
        } else {
            z4 = onHourKeyPress(i4, keyEvent, editText);
        }
        this.keyListenerRunning = false;
        return z4;
    }
}
