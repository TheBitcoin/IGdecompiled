package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l4, @Nullable Long l5) {
        return getDateRangeString(l4, l5, (SimpleDateFormat) null);
    }

    static String getDateString(long j4) {
        return getDateString(j4, (SimpleDateFormat) null);
    }

    static String getDayContentDescription(Context context, long j4, boolean z4, boolean z5, boolean z6) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j4);
        if (z4) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), new Object[]{optionalYearMonthDayOfWeekDay});
        }
        if (z5) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), new Object[]{optionalYearMonthDayOfWeekDay});
        } else if (!z6) {
            return optionalYearMonthDayOfWeekDay;
        } else {
            return String.format(context.getString(R.string.mtrl_picker_end_date_description), new Object[]{optionalYearMonthDayOfWeekDay});
        }
    }

    static String getMonthDay(long j4) {
        return getMonthDay(j4, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j4) {
        return getMonthDayOfWeekDay(j4, Locale.getDefault());
    }

    static String getOptionalYearMonthDayOfWeekDay(long j4) {
        if (isDateWithinCurrentYear(j4)) {
            return getMonthDayOfWeekDay(j4);
        }
        return getYearMonthDayOfWeekDay(j4);
    }

    static String getYearContentDescription(Context context, int i4) {
        if (UtcDates.getTodayCalendar().get(1) == i4) {
            return String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(i4)});
        }
        return String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(i4)});
    }

    static String getYearMonth(long j4) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j4));
        }
        return DateUtils.formatDateTime((Context) null, j4, 8228);
    }

    static String getYearMonthDay(long j4) {
        return getYearMonthDay(j4, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j4) {
        return getYearMonthDayOfWeekDay(j4, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j4) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j4);
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return true;
        }
        return false;
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l4, @Nullable Long l5, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l4 == null && l5 == null) {
            return Pair.create(null, null);
        }
        if (l4 == null) {
            return Pair.create(null, getDateString(l5.longValue(), simpleDateFormat));
        }
        if (l5 == null) {
            return Pair.create(getDateString(l4.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l4.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l5.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l4.longValue())), simpleDateFormat.format(new Date(l5.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return Pair.create(getYearMonthDay(l4.longValue(), Locale.getDefault()), getYearMonthDay(l5.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.create(getMonthDay(l4.longValue(), Locale.getDefault()), getMonthDay(l5.longValue(), Locale.getDefault()));
            }
            return Pair.create(getMonthDay(l4.longValue(), Locale.getDefault()), getYearMonthDay(l5.longValue(), Locale.getDefault()));
        }
    }

    static String getDateString(long j4, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j4));
        }
        if (isDateWithinCurrentYear(j4)) {
            return getMonthDay(j4);
        }
        return getYearMonthDay(j4);
    }

    static String getMonthDay(long j4, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j4));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j4));
    }

    static String getMonthDayOfWeekDay(long j4, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j4));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j4));
    }

    static String getYearMonthDay(long j4, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j4));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j4));
    }

    static String getYearMonthDayOfWeekDay(long j4, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j4));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j4));
    }
}
