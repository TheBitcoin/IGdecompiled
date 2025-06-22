package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new Parcelable.Creator<DateValidatorPointForward>() {
        @NonNull
        public DateValidatorPointForward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        @NonNull
        public DateValidatorPointForward[] newArray(int i4) {
            return new DateValidatorPointForward[i4];
        }
    };
    private final long point;

    @NonNull
    public static DateValidatorPointForward from(long j4) {
        return new DateValidatorPointForward(j4);
    }

    @NonNull
    public static DateValidatorPointForward now() {
        return from(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointForward) && this.point == ((DateValidatorPointForward) obj).point) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long j4) {
        if (j4 >= this.point) {
            return true;
        }
        return false;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeLong(this.point);
    }

    private DateValidatorPointForward(long j4) {
        this.point = j4;
    }
}
