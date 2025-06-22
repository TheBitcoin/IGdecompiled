package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

abstract class g {
    public static void a(Object obj, Parcel parcel, int i4) {
        ((MediaMetadata) obj).writeToParcel(parcel, i4);
    }
}
