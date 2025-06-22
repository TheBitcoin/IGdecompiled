package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    /* access modifiers changed from: private */
    public OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    /* access modifiers changed from: private */
    public OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    interface OnPeriodChangeListener {
        void onPeriodChange(int i4);
    }

    interface OnSelectionChange {
        void onSelectionChanged(int i4);
    }

    public TimePickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static /* synthetic */ void a(TimePickerView timePickerView, MaterialButtonToggleGroup materialButtonToggleGroup, int i4, boolean z4) {
        int i5;
        if (!z4) {
            timePickerView.getClass();
            return;
        }
        OnPeriodChangeListener onPeriodChangeListener2 = timePickerView.onPeriodChangeListener;
        if (onPeriodChangeListener2 != null) {
            if (i4 == R.id.material_clock_period_pm_button) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            onPeriodChangeListener2.onPeriodChange(i5);
        }
    }

    private void setUpDisplay() {
        Chip chip = this.minuteView;
        int i4 = R.id.selection_type;
        chip.setTag(i4, 12);
        this.hourView.setTag(i4, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                OnDoubleTapListener access$100 = TimePickerView.this.onDoubleTapListener;
                if (access$100 == null) {
                    return false;
                }
                access$100.onDoubleTap();
                return true;
            }
        });
        AnonymousClass3 r12 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(r12);
        this.hourView.setOnTouchListener(r12);
    }

    private void updateSelection(Chip chip, boolean z4) {
        int i4;
        chip.setChecked(z4);
        if (z4) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        ViewCompat.setAccessibilityLiveRegion(chip, i4);
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentLevel() {
        return this.clockFace.getCurrentLevel();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i4) {
        super.onVisibilityChanged(view, i4);
        if (view == this && i4 == 0) {
            this.hourView.sendAccessibilityEvent(8);
        }
    }

    public void setActiveSelection(int i4) {
        boolean z4;
        Chip chip = this.minuteView;
        boolean z5 = false;
        if (i4 == 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        updateSelection(chip, z4);
        Chip chip2 = this.hourView;
        if (i4 == 10) {
            z5 = true;
        }
        updateSelection(chip2, z5);
    }

    public void setAnimateOnTouchUp(boolean z4) {
        this.clockHandView.setAnimateOnTouchUp(z4);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentLevel(int i4) {
        this.clockFace.setCurrentLevel(i4);
    }

    public void setHandRotation(float f4) {
        this.clockHandView.setHandRotation(f4);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, accessibilityDelegateCompat);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.hourView, accessibilityDelegateCompat);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    /* access modifiers changed from: package-private */
    public void setOnDoubleTapListener(@Nullable OnDoubleTapListener onDoubleTapListener2) {
        this.onDoubleTapListener = onDoubleTapListener2;
    }

    /* access modifiers changed from: package-private */
    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener2) {
        this.onPeriodChangeListener = onPeriodChangeListener2;
    }

    /* access modifiers changed from: package-private */
    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    public void setValues(String[] strArr, @StringRes int i4) {
        this.clockFace.setValues(strArr, i4);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTime(int i4, int i5, int i6) {
        int i7;
        if (i4 == 1) {
            i7 = R.id.material_clock_period_pm_button;
        } else {
            i7 = R.id.material_clock_period_am_button;
        }
        this.toggle.check(i7);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i6)});
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i5)});
        if (!TextUtils.equals(this.minuteView.getText(), format)) {
            this.minuteView.setText(format);
        }
        if (!TextUtils.equals(this.hourView.getText(), format2)) {
            this.hourView.setText(format2);
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setHandRotation(float f4, boolean z4) {
        this.clockHandView.setHandRotation(f4, z4);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.selectionListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new f(this));
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }
}
