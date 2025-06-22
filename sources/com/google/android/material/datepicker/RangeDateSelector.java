package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        @NonNull
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Class<Long> cls = Long.class;
            Long unused = rangeDateSelector.selectedStartItem = (Long) parcel.readValue(cls.getClassLoader());
            Long unused2 = rangeDateSelector.selectedEndItem = (Long) parcel.readValue(cls.getClassLoader());
            return rangeDateSelector;
        }

        @NonNull
        public RangeDateSelector[] newArray(int i4) {
            return new RangeDateSelector[i4];
        }
    };
    @Nullable
    private CharSequence error;
    private final String invalidRangeEndError = " ";
    private String invalidRangeStartError;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextEnd = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long proposedTextStart = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedEndItem = null;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedStartItem = null;
    @Nullable
    private SimpleDateFormat textInputFormat;

    private void clearInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    private boolean isValidRange(long j4, long j5) {
        return j4 <= j5;
    }

    private void setInvalidRange(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateError(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (!TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = textInputLayout2.getError();
        } else {
            this.error = null;
        }
    }

    /* access modifiers changed from: private */
    public void updateIfValidTextProposal(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l4 = this.proposedTextStart;
        if (l4 == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(l4.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(@NonNull Context context) {
        int i4;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i4 = R.attr.materialCalendarTheme;
        } else {
            i4 = R.attr.materialCalendarFullscreenTheme;
        }
        return MaterialAttributes.resolveOrThrow(context, i4, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Nullable
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.selectedStartItem;
        if (l4 != null) {
            arrayList.add(l4);
        }
        Long l5 = this.selectedEndItem;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    @NonNull
    public String getSelectionContentDescription(@NonNull Context context) {
        String str;
        String str2;
        Resources resources = context.getResources();
        Pair<String, String> dateRangeString = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        F f4 = dateRangeString.first;
        if (f4 == null) {
            str = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            str = (String) f4;
        }
        S s4 = dateRangeString.second;
        if (s4 == null) {
            str2 = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            str2 = (String) s4;
        }
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, new Object[]{str, str2});
    }

    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l4 = this.selectedStartItem;
        if (l4 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.selectedEndItem;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{DateStrings.getDateString(l4.longValue())});
        } else if (l4 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{DateStrings.getDateString(l5.longValue())});
        } else {
            Pair<String, String> dateRangeString = DateStrings.getDateRangeString(l4, l5);
            return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[]{dateRangeString.first, dateRangeString.second});
        }
    }

    public boolean isSelectionComplete() {
        Long l4 = this.selectedStartItem;
        if (l4 == null || this.selectedEndItem == null || !isValidRange(l4.longValue(), this.selectedEndItem.longValue())) {
            return false;
        }
        return true;
    }

    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        boolean z4;
        String defaultTextInputHint;
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormat = this.textInputFormat;
        if (simpleDateFormat != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            simpleDateFormat = UtcDates.getDefaultTextInputFormat();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        Long l4 = this.selectedStartItem;
        if (l4 != null) {
            editText.setText(simpleDateFormat2.format(l4));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l5 = this.selectedEndItem;
        if (l5 != null) {
            editText2.setText(simpleDateFormat2.format(l5));
            this.proposedTextEnd = this.selectedEndItem;
        }
        if (z4) {
            defaultTextInputHint = simpleDateFormat2.toPattern();
        } else {
            defaultTextInputHint = UtcDates.getDefaultTextInputHint(inflate.getResources(), simpleDateFormat2);
        }
        String str = defaultTextInputHint;
        textInputLayout.setPlaceholderText(str);
        textInputLayout2.setPlaceholderText(str);
        final TextInputLayout textInputLayout3 = textInputLayout;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat2, textInputLayout, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextStart = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout2, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onValidDate(@Nullable Long l4) {
                Long unused = RangeDateSelector.this.proposedTextStart = l4;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout2, onSelectionChangedListener2);
            }
        });
        editText2.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat2, textInputLayout2, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                Long unused = RangeDateSelector.this.proposedTextEnd = null;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout2, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onValidDate(@Nullable Long l4) {
                Long unused = RangeDateSelector.this.proposedTextEnd = l4;
                RangeDateSelector.this.updateIfValidTextProposal(textInputLayout3, textInputLayout2, onSelectionChangedListener2);
            }
        });
        e.c(editText, editText2);
        return inflate;
    }

    public void select(long j4) {
        Long l4 = this.selectedStartItem;
        if (l4 == null) {
            this.selectedStartItem = Long.valueOf(j4);
        } else if (this.selectedEndItem != null || !isValidRange(l4.longValue(), j4)) {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j4);
        } else {
            this.selectedEndItem = Long.valueOf(j4);
        }
    }

    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    public void setSelection(@NonNull Pair<Long, Long> pair) {
        F f4 = pair.first;
        if (!(f4 == null || pair.second == null)) {
            Preconditions.checkArgument(isValidRange(((Long) f4).longValue(), ((Long) pair.second).longValue()));
        }
        F f5 = pair.first;
        Long l4 = null;
        this.selectedStartItem = f5 == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) f5).longValue()));
        S s4 = pair.second;
        if (s4 != null) {
            l4 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) s4).longValue()));
        }
        this.selectedEndItem = l4;
    }
}
