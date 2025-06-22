package j$.time.format;

import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.h;
import j$.time.temporal.j;
import j$.time.temporal.l;
import j$.time.temporal.q;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

public final class n {

    /* renamed from: f  reason: collision with root package name */
    public static final a f4956f = new a(0);

    /* renamed from: a  reason: collision with root package name */
    public n f4957a;

    /* renamed from: b  reason: collision with root package name */
    public final n f4958b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f4959c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4960d;

    /* renamed from: e  reason: collision with root package name */
    public int f4961e;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put('G', a.ERA);
        hashMap.put('y', a.YEAR_OF_ERA);
        hashMap.put('u', a.YEAR);
        h hVar = j.f5022a;
        hashMap.put('Q', hVar);
        hashMap.put('q', hVar);
        a aVar = a.MONTH_OF_YEAR;
        hashMap.put('M', aVar);
        hashMap.put('L', aVar);
        hashMap.put('D', a.DAY_OF_YEAR);
        hashMap.put('d', a.DAY_OF_MONTH);
        hashMap.put('F', a.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        a aVar2 = a.DAY_OF_WEEK;
        hashMap.put('E', aVar2);
        hashMap.put('c', aVar2);
        hashMap.put('e', aVar2);
        hashMap.put('a', a.AMPM_OF_DAY);
        hashMap.put('H', a.HOUR_OF_DAY);
        hashMap.put('k', a.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', a.HOUR_OF_AMPM);
        hashMap.put('h', a.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', a.MINUTE_OF_HOUR);
        hashMap.put('s', a.SECOND_OF_MINUTE);
        a aVar3 = a.NANO_OF_SECOND;
        hashMap.put('S', aVar3);
        hashMap.put('A', a.MILLI_OF_DAY);
        hashMap.put('n', aVar3);
        hashMap.put('N', a.NANO_OF_DAY);
        hashMap.put('g', l.f5029a);
    }

    public n() {
        this.f4957a = this;
        this.f4959c = new ArrayList();
        this.f4961e = -1;
        this.f4958b = null;
        this.f4960d = false;
    }

    public n(n nVar) {
        this.f4957a = this;
        this.f4959c = new ArrayList();
        this.f4961e = -1;
        this.f4958b = nVar;
        this.f4960d = true;
    }

    public final void g(q qVar, int i4) {
        Objects.requireNonNull(qVar, "field");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i4);
        }
        f(new i(qVar, i4, i4, u.NOT_NEGATIVE));
    }

    public final void h(q qVar, int i4, int i5, u uVar) {
        if (i4 == i5 && uVar == u.NOT_NEGATIVE) {
            g(qVar, i5);
            return;
        }
        Objects.requireNonNull(qVar, "field");
        Objects.requireNonNull(uVar, "signStyle");
        if (i4 < 1 || i4 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i4);
        } else if (i5 < 1 || i5 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i5);
        } else if (i5 >= i4) {
            f(new i(qVar, i4, i5, uVar));
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i5 + " < " + i4);
        }
    }

    public final void f(i iVar) {
        i iVar2;
        n nVar = this.f4957a;
        int i4 = nVar.f4961e;
        if (i4 >= 0) {
            i iVar3 = (i) nVar.f4959c.get(i4);
            int i5 = iVar.f4941b;
            int i6 = iVar.f4942c;
            if (i5 == i6 && iVar.f4943d == u.NOT_NEGATIVE) {
                iVar2 = iVar3.b(i6);
                b(iVar.a());
                this.f4957a.f4961e = i4;
            } else {
                iVar2 = iVar3.a();
                this.f4957a.f4961e = b(iVar);
            }
            this.f4957a.f4959c.set(i4, iVar2);
            return;
        }
        nVar.f4961e = b(iVar);
    }

    public final void e(a aVar, HashMap hashMap) {
        Objects.requireNonNull(aVar, "field");
        Objects.requireNonNull(hashMap, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(hashMap);
        v vVar = v.FULL;
        b(new m(aVar, vVar, new b(new r(Collections.singletonMap(vVar, linkedHashMap)))));
    }

    public final void c(char c5) {
        b(new d(c5));
    }

    public final void d(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.isEmpty()) {
            return;
        }
        if (str.length() == 1) {
            b(new d(str.charAt(0)));
        } else {
            b(new l(str));
        }
    }

    public final void a(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        e eVar = dateTimeFormatter.f4926a;
        if (eVar.f4936b) {
            eVar = new e(eVar.f4935a, false);
        }
        b(eVar);
    }

    public final void j() {
        n nVar = this.f4957a;
        nVar.f4961e = -1;
        this.f4957a = new n(nVar);
    }

    public final void i() {
        n nVar = this.f4957a;
        if (nVar.f4958b == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        } else if (nVar.f4959c.size() > 0) {
            n nVar2 = this.f4957a;
            e eVar = new e(nVar2.f4959c, nVar2.f4960d);
            this.f4957a = this.f4957a.f4958b;
            b(eVar);
        } else {
            this.f4957a = this.f4957a.f4958b;
        }
    }

    public final int b(f fVar) {
        Objects.requireNonNull(fVar, "pp");
        n nVar = this.f4957a;
        nVar.getClass();
        nVar.f4959c.add(fVar);
        n nVar2 = this.f4957a;
        nVar2.f4961e = -1;
        return nVar2.f4959c.size() - 1;
    }

    public final DateTimeFormatter k(t tVar, s sVar) {
        return l(Locale.getDefault(), tVar, sVar);
    }

    public final DateTimeFormatter l(Locale locale, t tVar, s sVar) {
        Objects.requireNonNull(locale, "locale");
        while (this.f4957a.f4958b != null) {
            i();
        }
        e eVar = new e(this.f4959c, false);
        s sVar2 = s.f4971a;
        return new DateTimeFormatter(eVar, locale, tVar, sVar);
    }
}
