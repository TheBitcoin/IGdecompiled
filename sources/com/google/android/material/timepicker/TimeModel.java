package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        public TimeModel[] newArray(int i4) {
            return new TimeModel[i4];
        }
    };
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    public TimeModel() {
        this(0);
    }

    @Nullable
    public static String formatText(Resources resources, CharSequence charSequence) {
        return formatText(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    private static int getPeriod(int i4) {
        return i4 >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.hour == timeModel.hour && this.minute == timeModel.minute && this.format == timeModel.format && this.selection == timeModel.selection) {
            return true;
        }
        return false;
    }

    @StringRes
    public int getHourContentDescriptionResId() {
        if (this.format == 1) {
            return R.string.material_hour_24h_suffix;
        }
        return R.string.material_hour_suffix;
    }

    public int getHourForDisplay() {
        if (this.format == 1) {
            return this.hour % 24;
        }
        int i4 = this.hour;
        if (i4 % 12 == 0) {
            return 12;
        }
        if (this.period == 1) {
            return i4 - 12;
        }
        return i4;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int i4) {
        if (this.format == 1) {
            this.hour = i4;
            return;
        }
        int i5 = 12;
        int i6 = i4 % 12;
        if (this.period != 1) {
            i5 = 0;
        }
        this.hour = i6 + i5;
    }

    public void setHourOfDay(int i4) {
        this.period = getPeriod(i4);
        this.hour = i4;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i4) {
        this.minute = i4 % 60;
    }

    public void setPeriod(int i4) {
        if (i4 != this.period) {
            this.period = i4;
            int i5 = this.hour;
            if (i5 < 12 && i4 == 1) {
                this.hour = i5 + 12;
            } else if (i5 >= 12 && i4 == 0) {
                this.hour = i5 - 12;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.selection);
        parcel.writeInt(this.format);
    }

    public TimeModel(int i4) {
        this(0, 0, 10, i4);
    }

    @Nullable
    public static String formatText(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public TimeModel(int i4, int i5, int i6, int i7) {
        this.hour = i4;
        this.minute = i5;
        this.selection = i6;
        this.format = i7;
        this.period = getPeriod(i4);
        this.minuteInputValidator = new MaxInputValidator(59);
        this.hourInputValidator = new MaxInputValidator(i7 == 1 ? 23 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
