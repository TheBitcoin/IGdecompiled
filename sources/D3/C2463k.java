package D3;

import E3.c;
import H3.d;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: D3.k  reason: case insensitive filesystem */
public final class C2463k {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f23078j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f23079k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f23080l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f23081m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f23082a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23083b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23084c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23085d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23086e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f23087f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f23088g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f23089h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f23090i;

    private C2463k(String str, String str2, long j4, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f23082a = str;
        this.f23083b = str2;
        this.f23084c = j4;
        this.f23085d = str3;
        this.f23086e = str4;
        this.f23087f = z4;
        this.f23088g = z5;
        this.f23090i = z6;
        this.f23089h = z7;
    }

    private static int a(String str, int i4, int i5, boolean z4) {
        boolean z5;
        while (i4 < i5) {
            char charAt = str.charAt(i4);
            if ((charAt >= ' ' || charAt == 9) && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 == (!z4)) {
                return i4;
            }
            i4++;
        }
        return i5;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || c.D(str)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static D3.C2463k d(long r26, D3.C2470r r28, java.lang.String r29) {
        /*
            r0 = r29
            int r1 = r0.length()
            r2 = 0
            r3 = 59
            int r4 = E3.c.k(r0, r2, r1, r3)
            r5 = 61
            int r6 = E3.c.k(r0, r2, r4, r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = E3.c.C(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0028
            int r8 = E3.c.t(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002c
        L_0x0028:
            r16 = r7
            goto L_0x0141
        L_0x002c:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = E3.c.C(r0, r6, r4)
            int r11 = E3.c.t(r6)
            if (r11 == r10) goto L_0x0039
            return r7
        L_0x0039:
            int r4 = r4 + r8
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r16 = r8
            r22 = r12
            r14 = -1
            r18 = 0
            r19 = 0
            r20 = 1
            r21 = 0
        L_0x004e:
            if (r4 >= r1) goto L_0x00bc
            r24 = -1
            int r10 = E3.c.k(r0, r4, r1, r3)
            int r11 = E3.c.k(r0, r4, r10, r5)
            java.lang.String r4 = E3.c.C(r0, r4, r11)
            if (r11 >= r10) goto L_0x0067
            int r11 = r11 + 1
            java.lang.String r11 = E3.c.C(r0, r11, r10)
            goto L_0x0069
        L_0x0067:
            java.lang.String r11 = ""
        L_0x0069:
            java.lang.String r3 = "expires"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x007c
            int r3 = r11.length()     // Catch:{ IllegalArgumentException -> 0x00b7 }
            long r22 = h(r11, r2, r3)     // Catch:{ IllegalArgumentException -> 0x00b7 }
        L_0x0079:
            r21 = 1
            goto L_0x00b7
        L_0x007c:
            java.lang.String r3 = "max-age"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0089
            long r14 = i(r11)     // Catch:{  }
            goto L_0x0079
        L_0x0089:
            java.lang.String r3 = "domain"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0098
            java.lang.String r7 = g(r11)     // Catch:{ IllegalArgumentException -> 0x00b7 }
            r20 = 0
            goto L_0x00b7
        L_0x0098:
            java.lang.String r3 = "path"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a2
            r8 = r11
            goto L_0x00b7
        L_0x00a2:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00ad
            r18 = 1
            goto L_0x00b7
        L_0x00ad:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b7
            r19 = 1
        L_0x00b7:
            int r4 = r10 + 1
            r3 = 59
            goto L_0x004e
        L_0x00bc:
            r24 = -1
            r0 = -9223372036854775808
            int r3 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c6
            r11 = r0
            goto L_0x00ee
        L_0x00c6:
            int r0 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x00ec
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00d8
            r0 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 * r0
            goto L_0x00dd
        L_0x00d8:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00dd:
            long r14 = r26 + r14
            int r0 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r0 < 0) goto L_0x00ea
            int r0 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r11 = r14
            goto L_0x00ee
        L_0x00ea:
            r11 = r12
            goto L_0x00ee
        L_0x00ec:
            r11 = r22
        L_0x00ee:
            java.lang.String r0 = r28.k()
            if (r7 != 0) goto L_0x00f6
            r13 = r0
            goto L_0x00fe
        L_0x00f6:
            boolean r1 = b(r0, r7)
            if (r1 != 0) goto L_0x00fd
            return r16
        L_0x00fd:
            r13 = r7
        L_0x00fe:
            int r0 = r0.length()
            int r1 = r13.length()
            if (r0 == r1) goto L_0x0113
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.c()
            java.lang.String r0 = r0.d(r13)
            if (r0 != 0) goto L_0x0113
            return r16
        L_0x0113:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x0120
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r14 = r8
            goto L_0x0132
        L_0x0120:
            java.lang.String r1 = r28.g()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x0130
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x0130:
            r8 = r0
            goto L_0x011e
        L_0x0132:
            D3.k r8 = new D3.k
            r10 = r6
            r15 = r18
            r16 = r19
            r17 = r20
            r18 = r21
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
            return r8
        L_0x0141:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: D3.C2463k.d(long, D3.r, java.lang.String):D3.k");
    }

    public static C2463k e(C2470r rVar, String str) {
        return d(System.currentTimeMillis(), rVar, str);
    }

    public static List f(C2470r rVar, C2469q qVar) {
        List g4 = qVar.g("Set-Cookie");
        int size = g4.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            C2463k e5 = e(rVar, (String) g4.get(i4));
            if (e5 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e5);
            }
        }
        if (arrayList != null) {
            return DesugarCollections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    private static String g(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String b5 = c.b(str);
            if (b5 != null) {
                return b5;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i4, int i5) {
        int a5 = a(str, i4, i5, false);
        Matcher matcher = f23081m.matcher(str);
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        while (a5 < i5) {
            int a6 = a(str, a5 + 1, i5, true);
            matcher.region(a5, a6);
            if (i7 == -1 && matcher.usePattern(f23081m).matches()) {
                i7 = Integer.parseInt(matcher.group(1));
                i10 = Integer.parseInt(matcher.group(2));
                i11 = Integer.parseInt(matcher.group(3));
            } else if (i8 != -1 || !matcher.usePattern(f23080l).matches()) {
                if (i9 == -1) {
                    Pattern pattern = f23079k;
                    if (matcher.usePattern(pattern).matches()) {
                        i9 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i6 == -1 && matcher.usePattern(f23078j).matches()) {
                    i6 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i8 = Integer.parseInt(matcher.group(1));
            }
            a5 = a(str, a6 + 1, i5, false);
        }
        if (i6 >= 70 && i6 <= 99) {
            i6 += 1900;
        }
        if (i6 >= 0 && i6 <= 69) {
            i6 += 2000;
        }
        if (i6 < 1601) {
            throw new IllegalArgumentException();
        } else if (i9 == -1) {
            throw new IllegalArgumentException();
        } else if (i8 < 1 || i8 > 31) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 23) {
            throw new IllegalArgumentException();
        } else if (i10 < 0 || i10 > 59) {
            throw new IllegalArgumentException();
        } else if (i11 < 0 || i11 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(c.f23257p);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i6);
            gregorianCalendar.set(2, i9 - 1);
            gregorianCalendar.set(5, i8);
            gregorianCalendar.set(11, i7);
            gregorianCalendar.set(12, i10);
            gregorianCalendar.set(13, i11);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e5) {
            if (!str.matches("-?\\d+")) {
                throw e5;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    public String c() {
        return this.f23082a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2463k)) {
            return false;
        }
        C2463k kVar = (C2463k) obj;
        if (kVar.f23082a.equals(this.f23082a) && kVar.f23083b.equals(this.f23083b) && kVar.f23085d.equals(this.f23085d) && kVar.f23086e.equals(this.f23086e) && kVar.f23084c == this.f23084c && kVar.f23087f == this.f23087f && kVar.f23088g == this.f23088g && kVar.f23089h == this.f23089h && kVar.f23090i == this.f23090i) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f23084c;
        return ((((((((((((((((527 + this.f23082a.hashCode()) * 31) + this.f23083b.hashCode()) * 31) + this.f23085d.hashCode()) * 31) + this.f23086e.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f23087f ^ true ? 1 : 0)) * 31) + (this.f23088g ^ true ? 1 : 0)) * 31) + (this.f23089h ^ true ? 1 : 0)) * 31) + (this.f23090i ^ true ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public String j(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23082a);
        sb.append('=');
        sb.append(this.f23083b);
        if (this.f23089h) {
            if (this.f23084c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(d.a(new Date(this.f23084c)));
            }
        }
        if (!this.f23090i) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.f23085d);
        }
        sb.append("; path=");
        sb.append(this.f23086e);
        if (this.f23087f) {
            sb.append("; secure");
        }
        if (this.f23088g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String k() {
        return this.f23083b;
    }

    public String toString() {
        return j(false);
    }
}
