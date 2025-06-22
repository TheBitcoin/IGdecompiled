package androidx.leanback.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.leanback.widget.picker.PickerUtility;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DatePicker extends Picker {
    private static final int[] DATE_FIELDS = {5, 2, 1};
    static final String DATE_FORMAT = "MM/dd/yyyy";
    static final String LOG_TAG = "DatePicker";
    int mColDayIndex;
    int mColMonthIndex;
    int mColYearIndex;
    PickerUtility.DateConstant mConstant;
    Calendar mCurrentDate;
    final DateFormat mDateFormat;
    private String mDatePickerFormat;
    PickerColumn mDayColumn;
    Calendar mMaxDate;
    Calendar mMinDate;
    PickerColumn mMonthColumn;
    Calendar mTempDate;
    PickerColumn mYearColumn;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static boolean isAnyOf(char c5, char[] cArr) {
        for (char c6 : cArr) {
            if (c5 == c6) {
                return true;
            }
        }
        return false;
    }

    private boolean isNewDate(int i4, int i5, int i6) {
        if (this.mCurrentDate.get(1) == i4 && this.mCurrentDate.get(2) == i6 && this.mCurrentDate.get(5) == i5) {
            return false;
        }
        return true;
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(this.mDateFormat.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w(LOG_TAG, "Date: " + str + " not in format: " + DATE_FORMAT);
            return false;
        }
    }

    private void setDate(int i4, int i5, int i6) {
        this.mCurrentDate.set(i4, i5, i6);
        if (this.mCurrentDate.before(this.mMinDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        } else if (this.mCurrentDate.after(this.mMaxDate)) {
            this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        }
    }

    private void updateCurrentLocale() {
        PickerUtility.DateConstant dateConstantInstance = PickerUtility.getDateConstantInstance(Locale.getDefault(), getContext().getResources());
        this.mConstant = dateConstantInstance;
        this.mTempDate = PickerUtility.getCalendarForLocale(this.mTempDate, dateConstantInstance.locale);
        this.mMinDate = PickerUtility.getCalendarForLocale(this.mMinDate, this.mConstant.locale);
        this.mMaxDate = PickerUtility.getCalendarForLocale(this.mMaxDate, this.mConstant.locale);
        this.mCurrentDate = PickerUtility.getCalendarForLocale(this.mCurrentDate, this.mConstant.locale);
        PickerColumn pickerColumn = this.mMonthColumn;
        if (pickerColumn != null) {
            pickerColumn.setStaticLabels(this.mConstant.months);
            setColumnAt(this.mColMonthIndex, this.mMonthColumn);
        }
    }

    private static boolean updateMax(PickerColumn pickerColumn, int i4) {
        if (i4 == pickerColumn.getMaxValue()) {
            return false;
        }
        pickerColumn.setMaxValue(i4);
        return true;
    }

    private static boolean updateMin(PickerColumn pickerColumn, int i4) {
        if (i4 == pickerColumn.getMinValue()) {
            return false;
        }
        pickerColumn.setMinValue(i4);
        return true;
    }

    private void updateSpinners(final boolean z4) {
        post(new Runnable() {
            public void run() {
                DatePicker.this.updateSpinnersImpl(z4);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public List<CharSequence> extractSeparators() {
        String bestYearMonthDayPattern = getBestYearMonthDayPattern(this.mDatePickerFormat);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z4 = false;
        char c5 = 0;
        for (int i4 = 0; i4 < bestYearMonthDayPattern.length(); i4++) {
            char charAt = bestYearMonthDayPattern.charAt(i4);
            if (charAt != ' ') {
                if (charAt != '\'') {
                    if (z4) {
                        sb.append(charAt);
                    } else if (!isAnyOf(charAt, cArr)) {
                        sb.append(charAt);
                    } else if (charAt != c5) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c5 = charAt;
                } else if (!z4) {
                    sb.setLength(0);
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String getBestYearMonthDayPattern(String str) {
        String str2;
        if (PickerUtility.SUPPORTS_BEST_DATE_TIME_PATTERN) {
            str2 = android.text.format.DateFormat.getBestDateTimePattern(this.mConstant.locale, str);
        } else {
            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getContext());
            str2 = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toLocalizedPattern() : DATE_FORMAT;
        }
        if (TextUtils.isEmpty(str2)) {
            return DATE_FORMAT;
        }
        return str2;
    }

    public long getDate() {
        return this.mCurrentDate.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    public final void onColumnValueChanged(int i4, int i5) {
        this.mTempDate.setTimeInMillis(this.mCurrentDate.getTimeInMillis());
        int currentValue = getColumnAt(i4).getCurrentValue();
        if (i4 == this.mColDayIndex) {
            this.mTempDate.add(5, i5 - currentValue);
        } else if (i4 == this.mColMonthIndex) {
            this.mTempDate.add(2, i5 - currentValue);
        } else if (i4 == this.mColYearIndex) {
            this.mTempDate.add(1, i5 - currentValue);
        } else {
            throw new IllegalArgumentException();
        }
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5));
        updateSpinners(false);
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        if (!TextUtils.equals(this.mDatePickerFormat, str)) {
            this.mDatePickerFormat = str;
            List<CharSequence> extractSeparators = extractSeparators();
            if (extractSeparators.size() == str.length() + 1) {
                setSeparators(extractSeparators);
                this.mDayColumn = null;
                this.mMonthColumn = null;
                this.mYearColumn = null;
                this.mColMonthIndex = -1;
                this.mColDayIndex = -1;
                this.mColYearIndex = -1;
                String upperCase = str.toUpperCase();
                ArrayList arrayList = new ArrayList(3);
                for (int i4 = 0; i4 < upperCase.length(); i4++) {
                    char charAt = upperCase.charAt(i4);
                    if (charAt != 'D') {
                        if (charAt != 'M') {
                            if (charAt != 'Y') {
                                throw new IllegalArgumentException("datePicker format error");
                            } else if (this.mYearColumn == null) {
                                PickerColumn pickerColumn = new PickerColumn();
                                this.mYearColumn = pickerColumn;
                                arrayList.add(pickerColumn);
                                this.mColYearIndex = i4;
                                this.mYearColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
                            } else {
                                throw new IllegalArgumentException("datePicker format error");
                            }
                        } else if (this.mMonthColumn == null) {
                            PickerColumn pickerColumn2 = new PickerColumn();
                            this.mMonthColumn = pickerColumn2;
                            arrayList.add(pickerColumn2);
                            this.mMonthColumn.setStaticLabels(this.mConstant.months);
                            this.mColMonthIndex = i4;
                        } else {
                            throw new IllegalArgumentException("datePicker format error");
                        }
                    } else if (this.mDayColumn == null) {
                        PickerColumn pickerColumn3 = new PickerColumn();
                        this.mDayColumn = pickerColumn3;
                        arrayList.add(pickerColumn3);
                        this.mDayColumn.setLabelFormat(TimeModel.ZERO_LEADING_NUMBER_FORMAT);
                        this.mColDayIndex = i4;
                    } else {
                        throw new IllegalArgumentException("datePicker format error");
                    }
                }
                setColumns(arrayList);
                updateSpinners(false);
                return;
            }
            throw new IllegalStateException("Separators size: " + extractSeparators.size() + " must equal" + " the size of datePickerFormat: " + str.length() + " + 1");
        }
    }

    public void setMaxDate(long j4) {
        this.mTempDate.setTimeInMillis(j4);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            this.mMaxDate.setTimeInMillis(j4);
            if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public void setMinDate(long j4) {
        this.mTempDate.setTimeInMillis(j4);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            this.mMinDate.setTimeInMillis(j4);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public void updateDate(int i4, int i5, int i6, boolean z4) {
        if (isNewDate(i4, i5, i6)) {
            setDate(i4, i5, i6);
            updateSpinners(z4);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateSpinnersImpl(boolean z4) {
        boolean z5;
        boolean updateMax;
        boolean z6;
        int[] iArr = {this.mColDayIndex, this.mColMonthIndex, this.mColYearIndex};
        boolean z7 = true;
        boolean z8 = true;
        for (int length = DATE_FIELDS.length - 1; length >= 0; length--) {
            int i4 = iArr[length];
            if (i4 >= 0) {
                int i5 = DATE_FIELDS[length];
                PickerColumn columnAt = getColumnAt(i4);
                if (z7) {
                    z5 = updateMin(columnAt, this.mMinDate.get(i5));
                } else {
                    z5 = updateMin(columnAt, this.mCurrentDate.getActualMinimum(i5));
                }
                if (z8) {
                    updateMax = updateMax(columnAt, this.mMaxDate.get(i5));
                } else {
                    updateMax = updateMax(columnAt, this.mCurrentDate.getActualMaximum(i5));
                }
                boolean z9 = z5 | updateMax;
                boolean z10 = false;
                if (this.mCurrentDate.get(i5) == this.mMinDate.get(i5)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 &= z6;
                if (this.mCurrentDate.get(i5) == this.mMaxDate.get(i5)) {
                    z10 = true;
                }
                z8 &= z10;
                if (z9) {
                    setColumnAt(iArr[length], columnAt);
                }
                setColumnValue(iArr[length], this.mCurrentDate.get(i5), z4);
            }
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
        updateCurrentLocale();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbDatePicker);
        String string = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
        String string2 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
        this.mTempDate.clear();
        if (TextUtils.isEmpty(string)) {
            this.mTempDate.set(1900, 0, 1);
        } else if (!parseDate(string, this.mTempDate)) {
            this.mTempDate.set(1900, 0, 1);
        }
        this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
        this.mTempDate.clear();
        if (TextUtils.isEmpty(string2)) {
            this.mTempDate.set(2100, 0, 1);
        } else if (!parseDate(string2, this.mTempDate)) {
            this.mTempDate.set(2100, 0, 1);
        }
        this.mMaxDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
        String string3 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
        setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(android.text.format.DateFormat.getDateFormatOrder(context)) : string3);
    }
}
