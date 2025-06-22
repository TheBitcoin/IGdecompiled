package j$.time.format;

import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.j;
import j$.time.temporal.n;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_LOCAL_DATE;

    /* renamed from: e  reason: collision with root package name */
    public static final DateTimeFormatter f4925e;

    /* renamed from: a  reason: collision with root package name */
    public final e f4926a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f4927b;

    /* renamed from: c  reason: collision with root package name */
    public final s f4928c;

    /* renamed from: d  reason: collision with root package name */
    public final s f4929d;

    static {
        n nVar = new n();
        a aVar = a.YEAR;
        u uVar = u.EXCEEDS_PAD;
        nVar.h(aVar, 4, 10, uVar);
        nVar.c('-');
        a aVar2 = a.MONTH_OF_YEAR;
        nVar.g(aVar2, 2);
        nVar.c('-');
        a aVar3 = a.DAY_OF_MONTH;
        nVar.g(aVar3, 2);
        t tVar = t.STRICT;
        s sVar = s.f4904c;
        DateTimeFormatter k4 = nVar.k(tVar, sVar);
        ISO_LOCAL_DATE = k4;
        n nVar2 = new n();
        k kVar = k.INSENSITIVE;
        nVar2.b(kVar);
        nVar2.a(k4);
        j jVar = j.f4946e;
        nVar2.b(jVar);
        nVar2.k(tVar, sVar);
        n nVar3 = new n();
        nVar3.b(kVar);
        nVar3.a(k4);
        nVar3.j();
        nVar3.b(jVar);
        nVar3.k(tVar, sVar);
        n nVar4 = new n();
        a aVar4 = a.HOUR_OF_DAY;
        nVar4.g(aVar4, 2);
        nVar4.c(':');
        a aVar5 = a.MINUTE_OF_HOUR;
        nVar4.g(aVar5, 2);
        nVar4.j();
        nVar4.c(':');
        a aVar6 = a.SECOND_OF_MINUTE;
        nVar4.g(aVar6, 2);
        nVar4.j();
        a aVar7 = a.NANO_OF_SECOND;
        g gVar = new g(aVar7, 0, 9, true, 0);
        a aVar8 = aVar7;
        Objects.requireNonNull(aVar8, "field");
        u uVar2 = aVar8.f5014b;
        a aVar9 = aVar4;
        a aVar10 = aVar6;
        if (uVar2.f5039a == uVar2.f5040b && uVar2.f5041c == uVar2.f5042d) {
            nVar4.b(gVar);
            DateTimeFormatter k5 = nVar4.k(tVar, (s) null);
            n nVar5 = new n();
            nVar5.b(kVar);
            nVar5.a(k5);
            nVar5.b(jVar);
            nVar5.k(tVar, (s) null);
            n nVar6 = new n();
            nVar6.b(kVar);
            nVar6.a(k5);
            nVar6.j();
            nVar6.b(jVar);
            nVar6.k(tVar, (s) null);
            n nVar7 = new n();
            nVar7.b(kVar);
            nVar7.a(k4);
            nVar7.c('T');
            nVar7.a(k5);
            DateTimeFormatter k6 = nVar7.k(tVar, sVar);
            n nVar8 = new n();
            nVar8.b(kVar);
            nVar8.a(k6);
            k kVar2 = k.LENIENT;
            nVar8.b(kVar2);
            nVar8.b(jVar);
            k kVar3 = k.STRICT;
            nVar8.b(kVar3);
            DateTimeFormatter k7 = nVar8.k(tVar, sVar);
            n nVar9 = new n();
            nVar9.a(k7);
            nVar9.j();
            nVar9.c('[');
            k kVar4 = k.SENSITIVE;
            nVar9.b(kVar4);
            nVar9.b(new h(1));
            nVar9.c(']');
            nVar9.k(tVar, sVar);
            n nVar10 = new n();
            nVar10.a(k6);
            nVar10.j();
            nVar10.b(jVar);
            nVar10.j();
            nVar10.c('[');
            nVar10.b(kVar4);
            nVar10.b(new h(1));
            nVar10.c(']');
            nVar10.k(tVar, sVar);
            n nVar11 = new n();
            nVar11.b(kVar);
            nVar11.h(aVar, 4, 10, uVar);
            nVar11.c('-');
            nVar11.g(a.DAY_OF_YEAR, 3);
            nVar11.j();
            nVar11.b(jVar);
            nVar11.k(tVar, sVar);
            n nVar12 = new n();
            nVar12.b(kVar);
            nVar12.h(j.f5024c, 4, 10, uVar);
            nVar12.d("-W");
            nVar12.g(j.f5023b, 2);
            nVar12.c('-');
            a aVar11 = a.DAY_OF_WEEK;
            nVar12.g(aVar11, 1);
            nVar12.j();
            nVar12.b(jVar);
            nVar12.k(tVar, sVar);
            n nVar13 = new n();
            nVar13.b(kVar);
            nVar13.b(new h(0));
            f4925e = nVar13.k(tVar, (s) null);
            n nVar14 = new n();
            nVar14.b(kVar);
            nVar14.g(aVar, 4);
            nVar14.g(aVar2, 2);
            nVar14.g(aVar3, 2);
            nVar14.j();
            nVar14.b(kVar2);
            nVar14.b(new j("+HHMMss", "Z"));
            nVar14.b(kVar3);
            nVar14.k(tVar, sVar);
            HashMap hashMap = new HashMap();
            hashMap.put(1L, "Mon");
            hashMap.put(2L, "Tue");
            hashMap.put(3L, "Wed");
            hashMap.put(4L, "Thu");
            hashMap.put(5L, "Fri");
            hashMap.put(6L, "Sat");
            hashMap.put(7L, "Sun");
            HashMap hashMap2 = new HashMap();
            hashMap2.put(1L, "Jan");
            hashMap2.put(2L, "Feb");
            hashMap2.put(3L, "Mar");
            hashMap2.put(4L, "Apr");
            hashMap2.put(5L, "May");
            hashMap2.put(6L, "Jun");
            hashMap2.put(7L, "Jul");
            hashMap2.put(8L, "Aug");
            hashMap2.put(9L, "Sep");
            hashMap2.put(10L, "Oct");
            hashMap2.put(11L, "Nov");
            hashMap2.put(12L, "Dec");
            n nVar15 = new n();
            nVar15.b(kVar);
            nVar15.b(kVar2);
            nVar15.j();
            nVar15.e(aVar11, hashMap);
            nVar15.d(", ");
            nVar15.i();
            nVar15.h(aVar3, 1, 2, u.NOT_NEGATIVE);
            nVar15.c(' ');
            nVar15.e(aVar2, hashMap2);
            nVar15.c(' ');
            nVar15.g(aVar, 4);
            nVar15.c(' ');
            nVar15.g(aVar9, 2);
            nVar15.c(':');
            nVar15.g(aVar5, 2);
            nVar15.j();
            nVar15.c(':');
            nVar15.g(aVar10, 2);
            nVar15.i();
            nVar15.c(' ');
            nVar15.b(new j("+HHMM", "GMT"));
            nVar15.k(t.SMART, sVar);
            return;
        }
        throw new IllegalArgumentException("Field must have a fixed set of values: " + aVar8);
    }

    public DateTimeFormatter(e eVar, Locale locale, t tVar, s sVar) {
        s sVar2 = s.f4971a;
        this.f4926a = (e) Objects.requireNonNull(eVar, "printerParser");
        this.f4927b = (Locale) Objects.requireNonNull(locale, "locale");
        this.f4928c = (s) Objects.requireNonNull(sVar2, "decimalStyle");
        t tVar2 = (t) Objects.requireNonNull(tVar, "resolverStyle");
        this.f4929d = sVar;
    }

    public final String a(n nVar) {
        StringBuilder sb = new StringBuilder(32);
        Objects.requireNonNull(nVar, "temporal");
        Objects.requireNonNull(sb, "appendable");
        try {
            this.f4926a.j(new p(nVar, this), sb);
            return sb.toString();
        } catch (IOException e5) {
            throw new RuntimeException(e5.getMessage(), e5);
        }
    }

    public final String toString() {
        String eVar = this.f4926a.toString();
        return eVar.startsWith("[") ? eVar : eVar.substring(1, eVar.length() - 1);
    }
}
