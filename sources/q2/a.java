package Q2;

import android.text.Html;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import kotlin.jvm.internal.m;

public abstract class a {
    public static final Spanned a(String str) {
        m.e(str, "source");
        Spanned fromHtml = HtmlCompat.fromHtml(m3.m.u(m3.m.u(m3.m.u(m3.m.u(m3.m.u(m3.m.u(str, "<ul>", "<customUl>", true), "</ul>", "</customUl>", true), "<ol>", "<customOl>", true), "<ol>", "</customOl>", true), "<li>", "<customLi>", true), "</li>", "</customLi>", true), 0, (Html.ImageGetter) null, new b());
        m.d(fromHtml, "fromHtml(customTagsSourc…, null, HtmlTagHandler())");
        return fromHtml;
    }
}
