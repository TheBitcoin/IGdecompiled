package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        public final CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        public final CommentFrame[] newArray(int i4) {
            return new CommentFrame[i4];
        }
    };
    public static final String ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super(ID);
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CommentFrame.class == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (!Util.areEqual(this.description, commentFrame.description) || !Util.areEqual(this.language, commentFrame.language) || !Util.areEqual(this.text, commentFrame.text)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5;
        String str = this.language;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = (527 + i4) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return i8 + i6;
    }

    public final String toString() {
        return this.id + ": language=" + this.language + ", description=" + this.description;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.id);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
    }

    CommentFrame(Parcel parcel) {
        super(ID);
        this.language = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }
}
