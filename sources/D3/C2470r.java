package D3;

import E3.c;
import N3.C2514e;
import j$.util.DesugarCollections;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* renamed from: D3.r  reason: case insensitive filesystem */
public final class C2470r {

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f23108j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f23109a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23110b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23111c;

    /* renamed from: d  reason: collision with root package name */
    final String f23112d;

    /* renamed from: e  reason: collision with root package name */
    final int f23113e;

    /* renamed from: f  reason: collision with root package name */
    private final List f23114f;

    /* renamed from: g  reason: collision with root package name */
    private final List f23115g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23116h;

    /* renamed from: i  reason: collision with root package name */
    private final String f23117i;

    /* renamed from: D3.r$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f23118a;

        /* renamed from: b  reason: collision with root package name */
        String f23119b = "";

        /* renamed from: c  reason: collision with root package name */
        String f23120c = "";

        /* renamed from: d  reason: collision with root package name */
        String f23121d;

        /* renamed from: e  reason: collision with root package name */
        int f23122e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List f23123f;

        /* renamed from: g  reason: collision with root package name */
        List f23124g;

        /* renamed from: h  reason: collision with root package name */
        String f23125h;

        /* renamed from: D3.r$a$a  reason: collision with other inner class name */
        enum C0278a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f23123f = arrayList;
            arrayList.add("");
        }

        private static String b(String str, int i4, int i5) {
            return c.b(C2470r.r(str, i4, i5, false));
        }

        private boolean f(String str) {
            if (str.equals(".") || str.equalsIgnoreCase("%2e")) {
                return true;
            }
            return false;
        }

        private boolean g(String str) {
            if (str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e")) {
                return true;
            }
            return false;
        }

        private static int i(String str, int i4, int i5) {
            try {
                int parseInt = Integer.parseInt(C2470r.a(str, i4, i5, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void j() {
            List list = this.f23123f;
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f23123f.isEmpty()) {
                this.f23123f.add("");
                return;
            }
            List list2 = this.f23123f;
            list2.set(list2.size() - 1, "");
        }

        private static int l(String str, int i4, int i5) {
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt == ':') {
                    return i4;
                }
                if (charAt == '[') {
                    do {
                        i4++;
                        if (i4 >= i5) {
                            break;
                        }
                    } while (str.charAt(i4) == ']');
                }
                i4++;
            }
            return i5;
        }

        private void m(String str, int i4, int i5, boolean z4, boolean z5) {
            String a5 = C2470r.a(str, i4, i5, " \"<>^`{}|/\\?#", z5, false, false, true, (Charset) null);
            if (!f(a5)) {
                if (g(a5)) {
                    j();
                    return;
                }
                List list = this.f23123f;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List list2 = this.f23123f;
                    list2.set(list2.size() - 1, a5);
                } else {
                    this.f23123f.add(a5);
                }
                if (z4) {
                    this.f23123f.add("");
                }
            }
        }

        private void o(String str, int i4, int i5) {
            boolean z4;
            if (i4 != i5) {
                char charAt = str.charAt(i4);
                if (charAt == '/' || charAt == '\\') {
                    this.f23123f.clear();
                    this.f23123f.add("");
                    i4++;
                } else {
                    List list = this.f23123f;
                    list.set(list.size() - 1, "");
                }
                int i6 = i4;
                while (i6 < i5) {
                    int l4 = c.l(str, i6, i5, "/\\");
                    if (l4 < i5) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    String str2 = str;
                    m(str2, i6, l4, z4, true);
                    if (z4) {
                        l4++;
                    }
                    i6 = l4;
                    str = str2;
                }
            }
        }

        private static int q(String str, int i4, int i5) {
            if (i5 - i4 < 2) {
                return -1;
            }
            char charAt = str.charAt(i4);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i4++;
                    if (i4 >= i5) {
                        break;
                    }
                    char charAt2 = str.charAt(i4);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i4;
                        }
                    }
                }
            }
            return -1;
        }

        private static int r(String str, int i4, int i5) {
            int i6 = 0;
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i6++;
                i4++;
            }
            return i6;
        }

        public C2470r a() {
            if (this.f23118a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f23121d != null) {
                return new C2470r(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            int i4 = this.f23122e;
            if (i4 != -1) {
                return i4;
            }
            return C2470r.d(this.f23118a);
        }

        public a d(String str) {
            List list;
            if (str != null) {
                list = C2470r.y(C2470r.b(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f23124g = list;
            return this;
        }

        public a e(String str) {
            if (str != null) {
                String b5 = b(str, 0, str.length());
                if (b5 != null) {
                    this.f23121d = b5;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public C0278a h(C2470r rVar, String str) {
            String str2;
            int l4;
            char c5;
            String str3;
            int i4;
            C2470r rVar2 = rVar;
            String str4 = str;
            int z4 = c.z(str4, 0, str4.length());
            int A4 = c.A(str4, z4, str4.length());
            if (q(str4, z4, A4) != -1) {
                if (str4.regionMatches(true, z4, "https:", 0, 6)) {
                    this.f23118a = "https";
                    z4 += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, z4, "http:", 0, 5)) {
                        return C0278a.UNSUPPORTED_SCHEME;
                    }
                    this.f23118a = "http";
                    z4 += 5;
                }
            } else if (rVar2 == null) {
                return C0278a.MISSING_SCHEME;
            } else {
                this.f23118a = rVar2.f23109a;
            }
            int r4 = r(str4, z4, A4);
            char c6 = '#';
            if (r4 >= 2 || rVar2 == null || !rVar2.f23109a.equals(this.f23118a)) {
                int i5 = z4 + r4;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    l4 = c.l(str4, i5, A4, "@/\\?#");
                    if (l4 != A4) {
                        c5 = str4.charAt(l4);
                    } else {
                        c5 = 65535;
                    }
                    if (c5 == 65535 || c5 == c6 || c5 == '/' || c5 == '\\' || c5 == '?') {
                        int i6 = l4;
                        str2 = str4;
                        int i7 = i5;
                        int l5 = l(str2, i7, i6);
                        int i8 = l5 + 1;
                    } else {
                        if (c5 != '@') {
                            str3 = str4;
                        } else {
                            if (!z5) {
                                int k4 = c.k(str4, i5, l4, ':');
                                int i9 = l4;
                                String str5 = "%40";
                                String a5 = C2470r.a(str, i5, k4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z6) {
                                    a5 = this.f23119b + str5 + a5;
                                }
                                this.f23119b = a5;
                                if (k4 != i9) {
                                    int i10 = k4 + 1;
                                    i4 = i9;
                                    this.f23120c = C2470r.a(str, i10, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z5 = true;
                                } else {
                                    i4 = i9;
                                }
                                str3 = str;
                                z6 = true;
                            } else {
                                i4 = l4;
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f23120c);
                                sb.append("%40");
                                str3 = str;
                                sb.append(C2470r.a(str3, i5, i4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null));
                                this.f23120c = sb.toString();
                            }
                            i5 = i4 + 1;
                        }
                        str4 = str3;
                        c6 = '#';
                    }
                }
                int i62 = l4;
                str2 = str4;
                int i72 = i5;
                int l52 = l(str2, i72, i62);
                int i82 = l52 + 1;
                if (i82 < i62) {
                    this.f23121d = b(str2, i72, l52);
                    int i11 = i(str2, i82, i62);
                    this.f23122e = i11;
                    if (i11 == -1) {
                        return C0278a.INVALID_PORT;
                    }
                } else {
                    this.f23121d = b(str2, i72, l52);
                    this.f23122e = C2470r.d(this.f23118a);
                }
                if (this.f23121d == null) {
                    return C0278a.INVALID_HOST;
                }
                z4 = i62;
            } else {
                this.f23119b = rVar2.j();
                this.f23120c = rVar2.f();
                this.f23121d = rVar2.f23112d;
                this.f23122e = rVar2.f23113e;
                this.f23123f.clear();
                this.f23123f.addAll(rVar2.h());
                if (z4 == A4 || str4.charAt(z4) == '#') {
                    d(rVar2.i());
                }
                str2 = str4;
            }
            int l6 = c.l(str2, z4, A4, "?#");
            o(str2, z4, l6);
            if (l6 < A4 && str2.charAt(l6) == '?') {
                int k5 = c.k(str2, l6, A4, '#');
                this.f23124g = C2470r.y(C2470r.a(str2, l6 + 1, k5, " \"'<>#", true, false, true, true, (Charset) null));
                l6 = k5;
            }
            if (l6 < A4 && str2.charAt(l6) == '#') {
                this.f23125h = C2470r.a(str2, l6 + 1, A4, "", true, false, false, false, (Charset) null);
            }
            return C0278a.SUCCESS;
        }

        public a k(int i4) {
            if (i4 <= 0 || i4 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i4);
            }
            this.f23122e = i4;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a n() {
            int size = this.f23123f.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f23123f.set(i4, C2470r.b((String) this.f23123f.get(i4), "[]", true, true, false, true));
            }
            List list = this.f23124g;
            if (list != null) {
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str = (String) this.f23124g.get(i5);
                    if (str != null) {
                        this.f23124g.set(i5, C2470r.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f23125h;
            if (str2 != null) {
                this.f23125h = C2470r.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a p(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            } else if (str.equalsIgnoreCase("http")) {
                this.f23118a = "http";
                return this;
            } else if (str.equalsIgnoreCase("https")) {
                this.f23118a = "https";
                return this;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f23118a);
            sb.append("://");
            if (!this.f23119b.isEmpty() || !this.f23120c.isEmpty()) {
                sb.append(this.f23119b);
                if (!this.f23120c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f23120c);
                }
                sb.append('@');
            }
            if (this.f23121d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f23121d);
                sb.append(']');
            } else {
                sb.append(this.f23121d);
            }
            int c5 = c();
            if (c5 != C2470r.d(this.f23118a)) {
                sb.append(':');
                sb.append(c5);
            }
            C2470r.q(sb, this.f23123f);
            if (this.f23124g != null) {
                sb.append('?');
                C2470r.m(sb, this.f23124g);
            }
            if (this.f23125h != null) {
                sb.append('#');
                sb.append(this.f23125h);
            }
            return sb.toString();
        }
    }

    C2470r(a aVar) {
        List list;
        this.f23109a = aVar.f23118a;
        this.f23110b = s(aVar.f23119b, false);
        this.f23111c = s(aVar.f23120c, false);
        this.f23112d = aVar.f23121d;
        this.f23113e = aVar.c();
        this.f23114f = t(aVar.f23123f, false);
        List list2 = aVar.f23124g;
        String str = null;
        if (list2 != null) {
            list = t(list2, true);
        } else {
            list = null;
        }
        this.f23115g = list;
        String str2 = aVar.f23125h;
        this.f23116h = str2 != null ? s(str2, false) : str;
        this.f23117i = aVar.toString();
    }

    static String a(String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        int i6 = i4;
        while (i6 < i5) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z4 || (z5 && !v(str, i6, i5)))) || (codePointAt == 43 && z6)))) {
                C2514e eVar = new C2514e();
                eVar.R(str, i4, i6);
                c(eVar, str, i6, i5, str2, z4, z5, z6, z7, charset);
                return eVar.readUtf8();
            }
            i6 += Character.charCount(codePointAt);
        }
        return str.substring(i4, i5);
    }

    static String b(String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7) {
        return a(str, 0, str.length(), str2, z4, z5, z6, z7, (Charset) null);
    }

    static void c(C2514e eVar, String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        C2514e eVar2 = null;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (!z4 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z6) {
                    eVar.writeUtf8(z4 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z7) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z4 || (z5 && !v(str, i4, i5)))))) {
                    if (eVar2 == null) {
                        eVar2 = new C2514e();
                    }
                    if (charset == null || charset.equals(c.f23251j)) {
                        eVar2.S(codePointAt);
                    } else {
                        eVar2.P(str, i4, Character.charCount(codePointAt) + i4, charset);
                    }
                    while (!eVar2.exhausted()) {
                        byte readByte = eVar2.readByte();
                        eVar.writeByte(37);
                        char[] cArr = f23108j;
                        eVar.writeByte(cArr[((readByte & 255) >> 4) & 15]);
                        eVar.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    eVar.S(codePointAt);
                }
            }
            i4 += Character.charCount(codePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void m(StringBuilder sb, List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4 += 2) {
            String str = (String) list.get(i4);
            String str2 = (String) list.get(i4 + 1);
            if (i4 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static C2470r p(String str) {
        a aVar = new a();
        if (aVar.h((C2470r) null, str) == a.C0278a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    static void q(StringBuilder sb, List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append('/');
            sb.append((String) list.get(i4));
        }
    }

    static String r(String str, int i4, int i5, boolean z4) {
        for (int i6 = i4; i6 < i5; i6++) {
            char charAt = str.charAt(i6);
            if (charAt == '%' || (charAt == '+' && z4)) {
                C2514e eVar = new C2514e();
                eVar.R(str, i4, i6);
                u(eVar, str, i6, i5, z4);
                return eVar.readUtf8();
            }
        }
        return str.substring(i4, i5);
    }

    static String s(String str, boolean z4) {
        return r(str, 0, str.length(), z4);
    }

    private List t(List list, boolean z4) {
        String str;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            String str2 = (String) list.get(i4);
            if (str2 != null) {
                str = s(str2, z4);
            } else {
                str = null;
            }
            arrayList.add(str);
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    static void u(C2514e eVar, String str, int i4, int i5, boolean z4) {
        int i6;
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt == 37 && (i6 = i4 + 2) < i5) {
                int h4 = c.h(str.charAt(i4 + 1));
                int h5 = c.h(str.charAt(i6));
                if (!(h4 == -1 || h5 == -1)) {
                    eVar.writeByte((h4 << 4) + h5);
                    i4 = i6;
                    i4 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z4) {
                eVar.writeByte(32);
                i4 += Character.charCount(codePointAt);
            }
            eVar.S(codePointAt);
            i4 += Character.charCount(codePointAt);
        }
    }

    static boolean v(String str, int i4, int i5) {
        int i6 = i4 + 2;
        if (i6 >= i5 || str.charAt(i4) != '%' || c.h(str.charAt(i4 + 1)) == -1 || c.h(str.charAt(i6)) == -1) {
            return false;
        }
        return true;
    }

    static List y(String str) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 <= str.length()) {
            int indexOf = str.indexOf(38, i4);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i4);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i4, indexOf));
                arrayList.add((Object) null);
            } else {
                arrayList.add(str.substring(i4, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i4 = indexOf + 1;
        }
        return arrayList;
    }

    public String A() {
        return this.f23109a;
    }

    public URI B() {
        String aVar = n().n().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e5) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    public String e() {
        if (this.f23116h == null) {
            return null;
        }
        return this.f23117i.substring(this.f23117i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2470r) || !((C2470r) obj).f23117i.equals(this.f23117i)) {
            return false;
        }
        return true;
    }

    public String f() {
        if (this.f23111c.isEmpty()) {
            return "";
        }
        int indexOf = this.f23117i.indexOf(64);
        return this.f23117i.substring(this.f23117i.indexOf(58, this.f23109a.length() + 3) + 1, indexOf);
    }

    public String g() {
        int indexOf = this.f23117i.indexOf(47, this.f23109a.length() + 3);
        String str = this.f23117i;
        return this.f23117i.substring(indexOf, c.l(str, indexOf, str.length(), "?#"));
    }

    public List h() {
        int indexOf = this.f23117i.indexOf(47, this.f23109a.length() + 3);
        String str = this.f23117i;
        int l4 = c.l(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < l4) {
            int i4 = indexOf + 1;
            int k4 = c.k(this.f23117i, i4, l4, '/');
            arrayList.add(this.f23117i.substring(i4, k4));
            indexOf = k4;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f23117i.hashCode();
    }

    public String i() {
        if (this.f23115g == null) {
            return null;
        }
        int indexOf = this.f23117i.indexOf(63) + 1;
        String str = this.f23117i;
        return this.f23117i.substring(indexOf, c.k(str, indexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f23110b.isEmpty()) {
            return "";
        }
        int length = this.f23109a.length() + 3;
        String str = this.f23117i;
        return this.f23117i.substring(length, c.l(str, length, str.length(), ":@"));
    }

    public String k() {
        return this.f23112d;
    }

    public boolean l() {
        return this.f23109a.equals("https");
    }

    public a n() {
        int i4;
        a aVar = new a();
        aVar.f23118a = this.f23109a;
        aVar.f23119b = j();
        aVar.f23120c = f();
        aVar.f23121d = this.f23112d;
        if (this.f23113e != d(this.f23109a)) {
            i4 = this.f23113e;
        } else {
            i4 = -1;
        }
        aVar.f23122e = i4;
        aVar.f23123f.clear();
        aVar.f23123f.addAll(h());
        aVar.d(i());
        aVar.f23125h = e();
        return aVar;
    }

    public a o(String str) {
        a aVar = new a();
        if (aVar.h(this, str) == a.C0278a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public String toString() {
        return this.f23117i;
    }

    public int w() {
        return this.f23113e;
    }

    public String x() {
        if (this.f23115g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m(sb, this.f23115g);
        return sb.toString();
    }

    public C2470r z(String str) {
        a o4 = o(str);
        if (o4 != null) {
            return o4.a();
        }
        return null;
    }
}
