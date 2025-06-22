package g2;

import N1.k;
import S2.C1601o;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import f2.C2019j;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m3.h;
import m3.j;

/* renamed from: g2.q  reason: case insensitive filesystem */
public final class C2059q {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20700f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private int f20701a;

    /* renamed from: b  reason: collision with root package name */
    private String f20702b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f20703c;

    /* renamed from: d  reason: collision with root package name */
    private String f20704d;

    /* renamed from: e  reason: collision with root package name */
    private String f20705e;

    /* renamed from: g2.q$a */
    public static final class a {

        /* renamed from: g2.q$a$a  reason: collision with other inner class name */
        public static final class C0251a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Integer.valueOf(((C2059q) obj).b()), Integer.valueOf(((C2059q) obj2).b()));
            }
        }

        /* renamed from: g2.q$a$b */
        public static final class b extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f20706a;

            b(Context context) {
                this.f20706a = context;
            }

            public void onClick(View view) {
                m.e(view, "widget");
            }

            public void updateDrawState(TextPaint textPaint) {
                m.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f20706a, R.color.main_blue));
                textPaint.setTypeface(k.f7778g.w());
            }
        }

        /* renamed from: g2.q$a$c */
        public static final class c extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2059q f20707a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2019j f20708b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f20709c;

            c(C2059q qVar, C2019j jVar, Context context) {
                this.f20707a = qVar;
                this.f20708b = jVar;
                this.f20709c = context;
            }

            public void onClick(View view) {
                m.e(view, "widget");
                if (UptodownApp.f17422D.a0() && this.f20707a.a() != null) {
                    this.f20708b.a(this.f20707a.a().longValue());
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                m.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f20709c, R.color.main_blue));
                textPaint.setTypeface(k.f7778g.w());
            }
        }

        /* renamed from: g2.q$a$d */
        public static final class d extends ClickableSpan {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2059q f20710a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2019j f20711b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f20712c;

            d(C2059q qVar, C2019j jVar, Context context) {
                this.f20710a = qVar;
                this.f20711b = jVar;
                this.f20712c = context;
            }

            public void onClick(View view) {
                m.e(view, "widget");
                if (UptodownApp.f17422D.a0() && this.f20710a.a() != null) {
                    C2053k kVar = new C2053k((int) this.f20710a.a().longValue(), this.f20710a.d(), (String) null, 4, (C2103g) null);
                    kVar.q(true);
                    this.f20711b.b(kVar);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                m.e(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(ContextCompat.getColor(this.f20712c, R.color.main_blue));
                textPaint.setTypeface(k.f7778g.w());
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final C2059q f(h hVar) {
            m.e(hVar, "it");
            return new C2059q(hVar.b().c(), (String) hVar.a().get(0), (String) hVar.a().get(1), hVar.getValue());
        }

        private final List g(String str) {
            ArrayList arrayList = new ArrayList();
            for (h hVar : j.d(new j("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]"), str, 0, 2, (Object) null)) {
                arrayList.add(new C2059q(hVar.b().c(), (String) hVar.a().get(1), Long.valueOf(Long.parseLong((String) hVar.a().get(2))), (String) hVar.a().get(3), hVar.getValue()));
            }
            for (h hVar2 : j.d(new j("<(\\w+)>(.*?)</(\\w+)>"), str, 0, 2, (Object) null)) {
                arrayList.add(new C2059q(hVar2.b().c(), (String) hVar2.a().get(1), (String) hVar2.a().get(2), hVar2.getValue()));
            }
            return C1601o.W(arrayList, new C0251a());
        }

        /* access modifiers changed from: private */
        public static final CharSequence i(h hVar) {
            m.e(hVar, "it");
            return (CharSequence) hVar.a().get(1);
        }

        /* access modifiers changed from: private */
        public static final CharSequence k(h hVar) {
            m.e(hVar, "it");
            return (CharSequence) hVar.a().get(3);
        }

        /* access modifiers changed from: private */
        public static final CharSequence l(h hVar) {
            m.e(hVar, "it");
            return (CharSequence) hVar.a().get(2);
        }

        public final List e(String str, String str2) {
            m.e(str, "inputText");
            m.e(str2, "tag");
            return l3.h.o(l3.h.m(j.d(new j(str2), str, 0, 2, (Object) null), new C2055m()));
        }

        public final SpannableStringBuilder h(Context context, String str) {
            m.e(context, "context");
            m.e(str, "inputText");
            List<C2059q> e5 = e(str, "\\[a](.*?)\\[/a]");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new j("\\[a](.*?)\\[/a]").f(str, new C2056n()));
            for (C2059q qVar : e5) {
                int L4 = m3.m.L(spannableStringBuilder, qVar.d(), 0, false, 6, (Object) null);
                int length = qVar.d().length() + L4;
                if (L4 >= 0) {
                    spannableStringBuilder.setSpan(new b(context), L4, length, 33);
                }
            }
            return spannableStringBuilder;
        }

        public final String j(SpannableStringBuilder spannableStringBuilder) {
            m.e(spannableStringBuilder, "<this>");
            return m3.m.w(new j("<(\\w+)>(.*?)</(\\w+)>").f(new j("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]").f(spannableStringBuilder, new C2057o()), new C2058p()), "<br />", "", false, 4, (Object) null);
        }

        public final SpannableStringBuilder m(String str, Context context, C2019j jVar) {
            Context context2 = context;
            C2019j jVar2 = jVar;
            String str2 = str;
            m.e(str2, "inputText");
            m.e(context2, "context");
            m.e(jVar2, "listener");
            String w4 = m3.m.w(m3.m.w(str2, "<br />", "\n", false, 4, (Object) null), "<br/>", "\n", false, 4, (Object) null);
            List<C2059q> g4 = g(w4);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(w4);
            int i4 = 0;
            for (C2059q qVar : g4) {
                int b5 = qVar.b() - i4;
                int length = qVar.d().length() + b5;
                String e5 = qVar.e();
                m.b(e5);
                spannableStringBuilder = spannableStringBuilder.replace(b5, e5.length() + b5, qVar.d());
                String c5 = qVar.c();
                int hashCode = c5.hashCode();
                if (hashCode != 98) {
                    if (hashCode != 105) {
                        if (hashCode != 117) {
                            if (hashCode != 93028092) {
                                if (hashCode != 1524339519) {
                                    if (hashCode != 3274) {
                                        if (hashCode == 3275 && c5.equals("h3")) {
                                            float dimension = context2.getResources().getDimension(R.dimen.text_size_m);
                                            Typeface w5 = k.f7778g.w();
                                            m.b(w5);
                                            spannableStringBuilder.setSpan(new defpackage.b(dimension, w5, ContextCompat.getColor(context2, R.color.text_primary)), b5, length, 33);
                                        }
                                    } else if (c5.equals("h2")) {
                                        float dimension2 = context2.getResources().getDimension(R.dimen.text_size_l);
                                        Typeface w6 = k.f7778g.w();
                                        m.b(w6);
                                        spannableStringBuilder.setSpan(new defpackage.b(dimension2, w6, ContextCompat.getColor(context2, R.color.text_primary)), b5, length, 33);
                                    }
                                } else if (c5.equals("floatingCategoryID")) {
                                    spannableStringBuilder.setSpan(new d(qVar, jVar2, context2), b5, length, 33);
                                }
                            } else if (c5.equals("appID")) {
                                spannableStringBuilder.setSpan(new c(qVar, jVar2, context2), b5, length, 33);
                            }
                        } else if (c5.equals("u")) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), b5, length, 33);
                        }
                    } else if (c5.equals(i.f13483a)) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), b5, length, 33);
                    }
                } else if (c5.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), b5, length, 33);
                }
                String e6 = qVar.e();
                m.b(e6);
                i4 = (i4 + e6.length()) - qVar.d().length();
            }
            return spannableStringBuilder;
        }

        private a() {
        }
    }

    public C2059q(int i4, String str, Long l4, String str2, String str3) {
        m.e(str, "tagType");
        m.e(str2, MimeTypes.BASE_TYPE_TEXT);
        this.f20701a = i4;
        this.f20702b = str;
        this.f20703c = l4;
        this.f20704d = str2;
        this.f20705e = str3;
    }

    public final Long a() {
        return this.f20703c;
    }

    public final int b() {
        return this.f20701a;
    }

    public final String c() {
        return this.f20702b;
    }

    public final String d() {
        return this.f20704d;
    }

    public final String e() {
        return this.f20705e;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2059q(int i4, String str, String str2, String str3) {
        this(i4, str, (Long) null, str2, str3);
        m.e(str, "tagType");
        m.e(str2, MimeTypes.BASE_TYPE_TEXT);
    }
}
