package defpackage;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: b  reason: default package */
public final class b extends MetricAffectingSpan {

    /* renamed from: d  reason: collision with root package name */
    public static final a f1090d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final float f1091a;

    /* renamed from: b  reason: collision with root package name */
    private final Typeface f1092b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1093c;

    /* renamed from: b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final SpannableString a(String str) {
            m.e(str, MimeTypes.BASE_TYPE_TEXT);
            if (Build.VERSION.SDK_INT >= 24) {
                return new SpannableString(Html.fromHtml(str, 0));
            }
            return new SpannableString(Html.fromHtml(str));
        }

        private a() {
        }
    }

    public b(float f4, Typeface typeface, int i4) {
        m.e(typeface, "typeface");
        this.f1091a = f4;
        this.f1092b = typeface;
        this.f1093c = i4;
    }

    public void updateDrawState(TextPaint textPaint) {
        m.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTextSize(this.f1091a);
        textPaint.setTypeface(this.f1092b);
        textPaint.setColor(this.f1093c);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m.e(textPaint, TtmlNode.TAG_P);
        textPaint.setTextSize(this.f1091a);
        textPaint.setTypeface(this.f1092b);
        textPaint.setColor(this.f1093c);
    }
}
