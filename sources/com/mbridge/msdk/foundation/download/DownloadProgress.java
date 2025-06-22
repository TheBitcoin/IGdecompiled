package com.mbridge.msdk.foundation.download;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadProgress implements Parcelable {
    public static final Parcelable.Creator<DownloadProgress> CREATOR = new Parcelable.Creator<DownloadProgress>() {
        public final DownloadProgress createFromParcel(Parcel parcel) {
            return new DownloadProgress(parcel);
        }

        public final DownloadProgress[] newArray(int i4) {
            return new DownloadProgress[i4];
        }
    };
    private long current;
    private int currentDownloadRate;
    private long total;

    public DownloadProgress(long j4, long j5, int i4) {
        this.current = j4;
        this.total = j5;
        this.currentDownloadRate = i4;
    }

    public int describeContents() {
        return 0;
    }

    public long getCurrent() {
        return this.current;
    }

    public int getCurrentDownloadRate() {
        return this.currentDownloadRate;
    }

    public long getTotal() {
        return this.total;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.current);
        parcel.writeLong(this.total);
        parcel.writeInt(this.currentDownloadRate);
    }

    protected DownloadProgress(Parcel parcel) {
        this.current = parcel.readLong();
        this.total = parcel.readLong();
        this.currentDownloadRate = parcel.readInt();
    }
}
