package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f722a;

    /* renamed from: b  reason: collision with root package name */
    private final float f723b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i4) {
            return new RatingCompat[i4];
        }
    }

    RatingCompat(int i4, float f4) {
        this.f722a = i4;
        this.f723b = f4;
    }

    public int describeContents() {
        return this.f722a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f722a);
        sb.append(" rating=");
        float f4 = this.f723b;
        if (f4 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f4);
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f722a);
        parcel.writeFloat(this.f723b);
    }
}
