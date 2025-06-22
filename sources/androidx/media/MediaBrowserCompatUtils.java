package androidx.media;

import android.os.Bundle;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) {
                return true;
            }
            return false;
        } else if (bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (bundle == null) {
            i4 = -1;
        } else {
            i4 = bundle.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle2 == null) {
            i5 = -1;
        } else {
            i5 = bundle2.getInt("android.media.browse.extra.PAGE", -1);
        }
        if (bundle == null) {
            i6 = -1;
        } else {
            i6 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        if (bundle2 == null) {
            i7 = -1;
        } else {
            i7 = bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        }
        int i11 = Integer.MAX_VALUE;
        if (i4 == -1 || i6 == -1) {
            i8 = Integer.MAX_VALUE;
            i9 = 0;
        } else {
            i9 = i4 * i6;
            i8 = (i6 + i9) - 1;
        }
        if (i5 == -1 || i7 == -1) {
            i10 = 0;
        } else {
            i10 = i5 * i7;
            i11 = (i7 + i10) - 1;
        }
        if (i8 < i10 || i11 < i9) {
            return false;
        }
        return true;
    }
}
