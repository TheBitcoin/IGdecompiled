package com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        public final EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        public final EventMessage[] newArray(int i4) {
            return new EventMessage[i4];
        }
    };
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final long presentationTimeUs;
    public final String schemeIdUri;
    public final String value;

    public EventMessage(String str, String str2, long j4, long j5, byte[] bArr, long j6) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j4;
        this.id = j5;
        this.messageData = bArr;
        this.presentationTimeUs = j6;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && EventMessage.class == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.presentationTimeUs != eventMessage.presentationTimeUs || this.durationMs != eventMessage.durationMs || this.id != eventMessage.id || !Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) || !Util.areEqual(this.value, eventMessage.value) || !Arrays.equals(this.messageData, eventMessage.messageData)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        if (this.hashCode == 0) {
            String str = this.schemeIdUri;
            int i5 = 0;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = 0;
            }
            int i6 = (527 + i4) * 31;
            String str2 = this.value;
            if (str2 != null) {
                i5 = str2.hashCode();
            }
            long j4 = this.presentationTimeUs;
            long j5 = this.durationMs;
            long j6 = this.id;
            this.hashCode = ((((((((i6 + i5) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.id + ", value=" + this.value;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.presentationTimeUs);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.messageData);
    }

    EventMessage(Parcel parcel) {
        this.schemeIdUri = parcel.readString();
        this.value = parcel.readString();
        this.presentationTimeUs = parcel.readLong();
        this.durationMs = parcel.readLong();
        this.id = parcel.readLong();
        this.messageData = parcel.createByteArray();
    }
}
