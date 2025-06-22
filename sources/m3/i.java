package m3;

import S2.C1587a;
import S2.C1588b;
import S2.C1601o;
import d3.l;
import j3.d;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import l3.h;

final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f21178a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f21179b;

    /* renamed from: c  reason: collision with root package name */
    private final g f21180c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    private List f21181d;

    public static final class a extends C1588b {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f21182b;

        a(i iVar) {
            this.f21182b = iVar;
        }

        public int c() {
            return this.f21182b.d().groupCount() + 1;
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return h((String) obj);
        }

        public /* bridge */ boolean h(String str) {
            return super.contains(str);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return k((String) obj);
        }

        /* renamed from: j */
        public String get(int i4) {
            String group = this.f21182b.d().group(i4);
            if (group == null) {
                return "";
            }
            return group;
        }

        public /* bridge */ int k(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int l(String str) {
            return super.lastIndexOf(str);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return l((String) obj);
        }
    }

    public static final class b extends C1587a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f21183a;

        static final class a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f21184a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(1);
                this.f21184a = bVar;
            }

            public final f a(int i4) {
                return this.f21184a.j(i4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        b(i iVar) {
            this.f21183a = iVar;
        }

        public int c() {
            return this.f21183a.d().groupCount() + 1;
        }

        public final /* bridge */ boolean contains(Object obj) {
            boolean z4;
            if (obj == null) {
                z4 = true;
            } else {
                z4 = obj instanceof f;
            }
            if (!z4) {
                return false;
            }
            return h((f) obj);
        }

        public /* bridge */ boolean h(f fVar) {
            return super.contains(fVar);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator iterator() {
            return h.m(C1601o.A(C1601o.i(this)), new a(this)).iterator();
        }

        public f j(int i4) {
            d c5 = k.f(this.f21183a.d(), i4);
            if (c5.getStart().intValue() < 0) {
                return null;
            }
            String group = this.f21183a.d().group(i4);
            m.d(group, "group(...)");
            return new f(group, c5);
        }
    }

    public i(Matcher matcher, CharSequence charSequence) {
        m.e(matcher, "matcher");
        m.e(charSequence, "input");
        this.f21178a = matcher;
        this.f21179b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult d() {
        return this.f21178a;
    }

    public List a() {
        if (this.f21181d == null) {
            this.f21181d = new a(this);
        }
        List list = this.f21181d;
        m.b(list);
        return list;
    }

    public d b() {
        return k.e(d());
    }

    public String getValue() {
        String group = d().group();
        m.d(group, "group(...)");
        return group;
    }

    public h next() {
        int i4;
        int end = d().end();
        if (d().end() == d().start()) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i5 = end + i4;
        if (i5 > this.f21179b.length()) {
            return null;
        }
        Matcher matcher = this.f21178a.pattern().matcher(this.f21179b);
        m.d(matcher, "matcher(...)");
        return k.d(matcher, i5, this.f21179b);
    }
}
