package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.m;

public final class SpannedStringKt {
    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = 0;
        }
        if ((i6 & 2) != 0) {
            i5 = spanned.length();
        }
        m.j(4, ExifInterface.GPS_DIRECTION_TRUE);
        return spanned.getSpans(i4, i5, Object.class);
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
