package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.C1117b;
import j$.time.chrono.l;
import j$.time.chrono.s;
import j$.time.temporal.a;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.util.Objects;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final n f4966a;

    /* renamed from: b  reason: collision with root package name */
    public final DateTimeFormatter f4967b;

    /* renamed from: c  reason: collision with root package name */
    public int f4968c;

    public p(n nVar, DateTimeFormatter dateTimeFormatter) {
        l lVar = dateTimeFormatter.f4929d;
        if (lVar != null) {
            l lVar2 = (l) nVar.p(r.f5033b);
            ZoneId zoneId = (ZoneId) nVar.p(r.f5032a);
            C1117b bVar = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            Objects.equals((Object) null, zoneId);
            if (lVar != null) {
                l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (nVar.f(a.EPOCH_DAY)) {
                        bVar = lVar3.l(nVar);
                    } else if (!(lVar == s.f4904c && lVar2 == null)) {
                        a[] values = a.values();
                        int length = values.length;
                        int i4 = 0;
                        while (i4 < length) {
                            a aVar = values[i4];
                            if (!aVar.t() || !nVar.f(aVar)) {
                                i4++;
                            } else {
                                throw new RuntimeException("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + nVar);
                            }
                        }
                    }
                }
                nVar = new o(bVar, nVar, lVar3, zoneId);
            }
        }
        this.f4966a = nVar;
        this.f4967b = dateTimeFormatter;
    }

    public final Long a(q qVar) {
        int i4 = this.f4968c;
        n nVar = this.f4966a;
        if (i4 <= 0 || nVar.f(qVar)) {
            return Long.valueOf(nVar.t(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f4966a.toString();
    }
}
