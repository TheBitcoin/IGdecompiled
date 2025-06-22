package m3;

import S2.C1601o;
import d3.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import l3.e;
import l3.h;

public final class j implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21185b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f21186a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final int b(int i4) {
            if ((i4 & 2) != 0) {
                return i4 | 64;
            }
            return i4;
        }

        private a() {
        }
    }

    static final class b extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f21187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CharSequence f21188b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f21189c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar, CharSequence charSequence, int i4) {
            super(0);
            this.f21187a = jVar;
            this.f21188b = charSequence;
            this.f21189c = i4;
        }

        /* renamed from: a */
        public final h invoke() {
            return this.f21187a.a(this.f21188b, this.f21189c);
        }
    }

    /* synthetic */ class c extends k implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f21190a = new c();

        c() {
            super(1, h.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        /* renamed from: d */
        public final h invoke(h hVar) {
            m.e(hVar, "p0");
            return hVar.next();
        }
    }

    public j(Pattern pattern) {
        m.e(pattern, "nativePattern");
        this.f21186a = pattern;
    }

    public static /* synthetic */ h b(j jVar, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return jVar.a(charSequence, i4);
    }

    public static /* synthetic */ e d(j jVar, CharSequence charSequence, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return jVar.c(charSequence, i4);
    }

    public final h a(CharSequence charSequence, int i4) {
        m.e(charSequence, "input");
        Matcher matcher = this.f21186a.matcher(charSequence);
        m.d(matcher, "matcher(...)");
        return k.d(matcher, i4, charSequence);
    }

    public final e c(CharSequence charSequence, int i4) {
        m.e(charSequence, "input");
        if (i4 >= 0 && i4 <= charSequence.length()) {
            return h.e(new b(this, charSequence, i4), c.f21190a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i4 + ", input length: " + charSequence.length());
    }

    public final boolean e(CharSequence charSequence) {
        m.e(charSequence, "input");
        return this.f21186a.matcher(charSequence).matches();
    }

    public final String f(CharSequence charSequence, l lVar) {
        m.e(charSequence, "input");
        m.e(lVar, "transform");
        int i4 = 0;
        h b5 = b(this, charSequence, 0, 2, (Object) null);
        if (b5 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i4, b5.b().getStart().intValue());
            sb.append((CharSequence) lVar.invoke(b5));
            i4 = b5.b().getEndInclusive().intValue() + 1;
            b5 = b5.next();
            if (i4 >= length) {
                break;
            }
        } while (b5 != null);
        if (i4 < length) {
            sb.append(charSequence, i4, length);
        }
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }

    public final String g(CharSequence charSequence, String str) {
        m.e(charSequence, "input");
        m.e(str, "replacement");
        String replaceAll = this.f21186a.matcher(charSequence).replaceAll(str);
        m.d(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final List h(CharSequence charSequence, int i4) {
        m.e(charSequence, "input");
        w.e0(i4);
        Matcher matcher = this.f21186a.matcher(charSequence);
        if (i4 == 1 || !matcher.find()) {
            return C1601o.e(charSequence.toString());
        }
        int i5 = 10;
        if (i4 > 0) {
            i5 = j3.e.c(i4, 10);
        }
        ArrayList arrayList = new ArrayList(i5);
        int i6 = i4 - 1;
        int i7 = 0;
        do {
            arrayList.add(charSequence.subSequence(i7, matcher.start()).toString());
            i7 = matcher.end();
            if ((i6 >= 0 && arrayList.size() == i6) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i7, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i7, matcher.start()).toString());
            i7 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i7, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f21186a.toString();
        m.d(pattern, "toString(...)");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.m.d(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.j.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public j(java.lang.String r2, m3.l r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.m.e(r3, r0)
            m3.j$a r0 = f21185b
            int r3 = r3.b()
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.m.d(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.j.<init>(java.lang.String, m3.l):void");
    }
}
