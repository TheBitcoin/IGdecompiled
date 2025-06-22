package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import j3.d;

public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object removeSpan : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(Spannable spannable, int i4, int i5, Object obj) {
        spannable.setSpan(obj, i4, i5, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, d dVar, Object obj) {
        spannable.setSpan(obj, dVar.getStart().intValue(), dVar.getEndInclusive().intValue(), 17);
    }
}
