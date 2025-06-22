package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f751a;

    /* renamed from: b  reason: collision with root package name */
    public int f752b;

    /* renamed from: c  reason: collision with root package name */
    public int f753c;

    /* renamed from: d  reason: collision with root package name */
    public int f754d;

    /* renamed from: e  reason: collision with root package name */
    public int f755e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i4) {
            return new ParcelableVolumeInfo[i4];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f751a = parcel.readInt();
        this.f753c = parcel.readInt();
        this.f754d = parcel.readInt();
        this.f755e = parcel.readInt();
        this.f752b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f751a);
        parcel.writeInt(this.f753c);
        parcel.writeInt(this.f754d);
        parcel.writeInt(this.f755e);
        parcel.writeInt(this.f752b);
    }
}
