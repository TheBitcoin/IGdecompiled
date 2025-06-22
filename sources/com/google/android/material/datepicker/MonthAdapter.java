package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;

class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = ((UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7)) - 1);
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    @Nullable
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, @Nullable DayViewDecorator dayViewDecorator2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
        this.dayViewDecorator = dayViewDecorator2;
        this.previouslySelectedDates = dateSelector2.getSelectedDays();
    }

    private String getDayContentDescription(Context context, long j4) {
        return DateStrings.getDayContentDescription(context, j4, isToday(j4), isStartOfRange(j4), isEndOfRange(j4));
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    private boolean isSelected(long j4) {
        for (Long longValue : this.dateSelector.getSelectedDays()) {
            if (UtcDates.canonicalYearMonthDay(j4) == UtcDates.canonicalYearMonthDay(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isToday(long j4) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() == j4) {
            return true;
        }
        return false;
    }

    private void updateSelectedState(@Nullable TextView textView, long j4, int i4) {
        CalendarItemStyle calendarItemStyle;
        boolean z4;
        if (textView != null) {
            Context context = textView.getContext();
            String dayContentDescription = getDayContentDescription(context, j4);
            textView.setContentDescription(dayContentDescription);
            boolean isValid = this.calendarConstraints.getDateValidator().isValid(j4);
            if (isValid) {
                textView.setEnabled(true);
                boolean isSelected = isSelected(j4);
                textView.setSelected(isSelected);
                if (isSelected) {
                    calendarItemStyle = this.calendarStyle.selectedDay;
                } else if (isToday(j4)) {
                    calendarItemStyle = this.calendarStyle.todayDay;
                } else {
                    calendarItemStyle = this.calendarStyle.day;
                }
                z4 = isSelected;
            } else {
                textView.setEnabled(false);
                calendarItemStyle = this.calendarStyle.invalidDay;
                z4 = false;
            }
            DayViewDecorator dayViewDecorator2 = this.dayViewDecorator;
            if (dayViewDecorator2 == null || i4 == -1) {
                calendarItemStyle.styleItem(textView);
                return;
            }
            Month month2 = this.month;
            int i5 = month2.year;
            int i6 = month2.month;
            int i7 = i4;
            calendarItemStyle.styleItem(textView, dayViewDecorator2.getBackgroundColor(context, i5, i6, i7, isValid, z4), this.dayViewDecorator.getTextColor(context, i5, i6, i7, isValid, z4));
            textView.setCompoundDrawables(this.dayViewDecorator.getCompoundDrawableLeft(context, i5, i6, i7, isValid, z4), this.dayViewDecorator.getCompoundDrawableTop(context, i5, i6, i7, isValid, z4), this.dayViewDecorator.getCompoundDrawableRight(context, i5, i6, i7, isValid, z4), this.dayViewDecorator.getCompoundDrawableBottom(context, i5, i6, i7, isValid, z4));
            textView.setContentDescription(this.dayViewDecorator.getContentDescription(context, i5, i6, i7, isValid, z4, dayContentDescription));
        }
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j4) {
        if (Month.create(j4).equals(this.month)) {
            int dayOfMonth = this.month.getDayOfMonth(j4);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j4, dayOfMonth);
        }
    }

    /* access modifiers changed from: package-private */
    public int dayToPosition(int i4) {
        return firstPositionInMonth() + (i4 - 1);
    }

    /* access modifiers changed from: package-private */
    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    public long getItemId(int i4) {
        return (long) (i4 / this.month.daysInWeek);
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isEndOfRange(long j4) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            S s4 = pair.second;
            if (s4 != null && ((Long) s4).longValue() == j4) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstInRow(int i4) {
        if (i4 % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLastInRow(int i4) {
        if ((i4 + 1) % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isStartOfRange(long j4) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            F f4 = pair.first;
            if (f4 != null && ((Long) f4).longValue() == j4) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    /* access modifiers changed from: package-private */
    public int positionToDay(int i4) {
        return (i4 - firstPositionInMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.previouslySelectedDates) {
            updateSelectedStateForDate(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector2 = this.dateSelector;
        if (dateSelector2 != null) {
            for (Long longValue2 : dateSelector2.getSelectedDays()) {
                updateSelectedStateForDate(materialCalendarGridView, longValue2.longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean withinMonth(int i4) {
        if (i4 < firstPositionInMonth() || i4 > lastPositionInMonth()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Long getItem(int i4) {
        if (i4 < firstPositionInMonth() || i4 > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i4)));
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 1
            android.content.Context r1 = r8.getContext()
            r5.initializeStyles(r1)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r1 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r1, r8, r2)
            r1 = r7
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x001f:
            int r7 = r5.firstPositionInMonth()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0054
            com.google.android.material.datepicker.Month r8 = r5.month
            int r3 = r8.daysInMonth
            if (r7 < r3) goto L_0x002e
            goto L_0x0054
        L_0x002e:
            int r7 = r7 + r0
            r1.setTag(r8)
            android.content.res.Resources r8 = r1.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r2] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r1.setText(r8)
            r1.setVisibility(r2)
            r1.setEnabled(r0)
            goto L_0x005d
        L_0x0054:
            r7 = 8
            r1.setVisibility(r7)
            r1.setEnabled(r2)
            r7 = -1
        L_0x005d:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0064
            return r1
        L_0x0064:
            long r2 = r6.longValue()
            r5.updateSelectedState(r1, r2, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }
}
