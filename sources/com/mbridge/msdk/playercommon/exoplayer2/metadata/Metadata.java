package com.mbridge.msdk.playercommon.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        public final Metadata createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }

        public final Metadata[] newArray(int i4) {
            return new Metadata[0];
        }
    };
    private final Entry[] entries;

    public interface Entry extends Parcelable {
    }

    public Metadata(Entry... entryArr) {
        this.entries = entryArr == null ? new Entry[0] : entryArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Metadata.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.entries, ((Metadata) obj).entries);
    }

    public final Entry get(int i4) {
        return this.entries[i4];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public final int length() {
        return this.entries.length;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.entries.length);
        for (Entry writeParcelable : this.entries) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list != null) {
            Entry[] entryArr = new Entry[list.size()];
            this.entries = entryArr;
            list.toArray(entryArr);
            return;
        }
        this.entries = new Entry[0];
    }

    Metadata(Parcel parcel) {
        this.entries = new Entry[parcel.readInt()];
        int i4 = 0;
        while (true) {
            Entry[] entryArr = this.entries;
            if (i4 < entryArr.length) {
                entryArr[i4] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i4++;
            } else {
                return;
            }
        }
    }
}
