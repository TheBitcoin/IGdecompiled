package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i4) {
            return new BatchReportMessage[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f13360a;

    /* renamed from: b  reason: collision with root package name */
    private long f13361b;

    /* renamed from: c  reason: collision with root package name */
    private String f13362c;

    public BatchReportMessage(String str, String str2, long j4) {
        this.f13362c = str;
        this.f13360a = str2;
        this.f13361b = j4;
    }

    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f13360a;
    }

    public long getTimestamp() {
        return this.f13361b;
    }

    public String getUuid() {
        return this.f13362c;
    }

    public void setReportMessage(String str) {
        this.f13360a = str;
    }

    public void setTimestamp(long j4) {
        this.f13361b = j4;
    }

    public void setUuid(String str) {
        this.f13362c = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f13362c);
        parcel.writeString(this.f13360a);
        parcel.writeLong(this.f13361b);
    }

    protected BatchReportMessage(Parcel parcel) {
        this.f13362c = parcel.readString();
        this.f13360a = parcel.readString();
        this.f13361b = parcel.readLong();
    }
}
