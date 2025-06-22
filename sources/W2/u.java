package w2;

import N1.k;
import S2.C1601o;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.xml.sax.XMLReader;

public final class u implements Html.TagHandler {

    /* renamed from: c  reason: collision with root package name */
    public static final a f22048c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f22049a;

    /* renamed from: b  reason: collision with root package name */
    private final List f22050b = new ArrayList();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final Spanned a(Context context, String str) {
            m.e(context, "context");
            m.e(str, "rawText");
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned a5 = Html.fromHtml(str, 0, (Html.ImageGetter) null, new u(context));
                m.b(a5);
                return a5;
            }
            Spanned fromHtml = Html.fromHtml(str, (Html.ImageGetter) null, new u(context));
            m.b(fromHtml);
            return fromHtml;
        }

        private a() {
        }
    }

    public final class b extends MetricAffectingSpan {

        /* renamed from: a  reason: collision with root package name */
        private final Typeface f22051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f22052b;

        public b(u uVar, Typeface typeface) {
            m.e(typeface, "customTypeface");
            this.f22052b = uVar;
            this.f22051a = typeface;
        }

        private final void a(Paint paint, Typeface typeface) {
            paint.setTypeface(typeface);
        }

        public void updateDrawState(TextPaint textPaint) {
            m.e(textPaint, "tp");
            a(textPaint, this.f22051a);
        }

        public void updateMeasureState(TextPaint textPaint) {
            m.e(textPaint, "tp");
            a(textPaint, this.f22051a);
        }
    }

    public u(Context context) {
        m.e(context, "context");
        this.f22049a = context;
    }

    public void handleTag(boolean z4, String str, Editable editable, XMLReader xMLReader) {
        m.e(str, "tag");
        m.e(editable, "output");
        m.e(xMLReader, "xmlReader");
        if (!m3.m.p(str, "turbo", true)) {
            return;
        }
        if (z4) {
            this.f22050b.add(Integer.valueOf(editable.length()));
        } else if (!this.f22050b.isEmpty()) {
            List list = this.f22050b;
            int intValue = ((Number) list.remove(C1601o.j(list))).intValue();
            int length = editable.length();
            editable.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f22049a, R.color.turbo_main)), intValue, length, 33);
            k.a aVar = k.f7778g;
            if (aVar.w() != null) {
                Typeface w4 = aVar.w();
                m.b(w4);
                editable.setSpan(new b(this, w4), intValue, length, 33);
            }
        }
    }
}
