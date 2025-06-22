package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i4, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i4, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i4, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            imageGetter = null;
        }
        if ((i5 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i4, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int i4) {
        return HtmlCompat.toHtml(spanned, i4);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        return HtmlCompat.toHtml(spanned, i4);
    }
}
