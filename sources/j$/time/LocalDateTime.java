package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.chrono.C1117b;
import j$.time.chrono.C1120e;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.l;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class LocalDateTime implements m, o, C1120e, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final LocalDateTime f4841c = F(g.f4975d, j.f4983e);

    /* renamed from: d  reason: collision with root package name */
    public static final LocalDateTime f4842d = F(g.f4976e, j.f4984f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a  reason: collision with root package name */
    public final g f4843a;

    /* renamed from: b  reason: collision with root package name */
    public final j f4844b;

    public final l a() {
        return ((g) c()).a();
    }

    public final ChronoZonedDateTime q(ZoneOffset zoneOffset) {
        return ZonedDateTime.C(this, zoneOffset, (ZoneOffset) null);
    }

    public static LocalDateTime F(g gVar, j jVar) {
        Objects.requireNonNull(gVar, "date");
        Objects.requireNonNull(jVar, "time");
        return new LocalDateTime(gVar, jVar);
    }

    public final m w(m mVar) {
        return mVar.d(((g) c()).u(), a.EPOCH_DAY).d(b().N(), a.NANO_OF_DAY);
    }

    public static LocalDateTime G(long j4, int i4, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        long j5 = (long) i4;
        a.NANO_OF_SECOND.w(j5);
        long j6 = j4 + ((long) zoneOffset.f4853b);
        long j7 = (long) 86400;
        return new LocalDateTime(g.L(j$.com.android.tools.r8.a.B(j6, j7)), j.G((((long) ((int) j$.com.android.tools.r8.a.A(j6, j7))) * C.NANOS_PER_SECOND) + j5));
    }

    public static LocalDateTime D(n nVar) {
        if (nVar instanceof LocalDateTime) {
            return (LocalDateTime) nVar;
        }
        if (nVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) nVar).f4855a;
        }
        if (nVar instanceof OffsetDateTime) {
            return ((OffsetDateTime) nVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(g.E(nVar), j.E(nVar));
        } catch (b e5) {
            String name = nVar.getClass().getName();
            throw new RuntimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + nVar + " of type " + name, e5);
        }
    }

    public LocalDateTime(g gVar, j jVar) {
        this.f4843a = gVar;
        this.f4844b = jVar;
    }

    public final LocalDateTime L(g gVar, j jVar) {
        if (this.f4843a == gVar && this.f4844b == jVar) {
            return this;
        }
        return new LocalDateTime(gVar, jVar);
    }

    public final boolean f(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar != null && qVar.m(this);
        }
        a aVar = (a) qVar;
        return aVar.t() || aVar.C();
    }

    public final u n(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        if (!((a) qVar).C()) {
            return this.f4843a.n(qVar);
        }
        j jVar = this.f4844b;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int k(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).C() ? this.f4844b.k(qVar) : this.f4843a.k(qVar);
        }
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).C() ? this.f4844b.t(qVar) : this.f4843a.t(qVar);
        }
        return qVar.k(this);
    }

    public final int C(LocalDateTime localDateTime) {
        int C4 = this.f4843a.C(localDateTime.f4843a);
        return C4 == 0 ? this.f4844b.compareTo(localDateTime.f4844b) : C4;
    }

    public final C1117b c() {
        return this.f4843a;
    }

    public final j b() {
        return this.f4844b;
    }

    public final m m(g gVar) {
        return L(gVar, this.f4844b);
    }

    /* renamed from: K */
    public final LocalDateTime d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (LocalDateTime) qVar.n(this, j4);
        }
        boolean C4 = ((a) qVar).C();
        j jVar = this.f4844b;
        g gVar = this.f4843a;
        if (C4) {
            return L(gVar, jVar.d(j4, qVar));
        }
        return L(gVar.d(j4, qVar), jVar);
    }

    /* renamed from: H */
    public final LocalDateTime e(long j4, s sVar) {
        long j5 = j4;
        s sVar2 = sVar;
        if (!(sVar2 instanceof b)) {
            return (LocalDateTime) sVar2.j(this, j5);
        }
        int i4 = h.f4980a[((b) sVar2).ordinal()];
        j jVar = this.f4844b;
        g gVar = this.f4843a;
        switch (i4) {
            case 1:
                return J(this.f4843a, 0, 0, 0, j4);
            case 2:
                LocalDateTime L4 = L(gVar.N(j4 / 86400000000L), jVar);
                return L4.J(L4.f4843a, 0, 0, 0, (j4 % 86400000000L) * 1000);
            case 3:
                LocalDateTime L5 = L(gVar.N(j4 / 86400000), jVar);
                return L5.J(L5.f4843a, 0, 0, 0, (j4 % 86400000) * 1000000);
            case 4:
                return I(j4);
            case 5:
                return J(this.f4843a, 0, j4, 0, 0);
            case 6:
                return J(this.f4843a, j5, 0, 0, 0);
            case 7:
                LocalDateTime L6 = L(gVar.N(j5 / 256), jVar);
                return L6.J(L6.f4843a, (j5 % 256) * 12, 0, 0, 0);
            default:
                return L(gVar.e(j5, sVar2), jVar);
        }
    }

    public final LocalDateTime I(long j4) {
        return J(this.f4843a, 0, 0, j4, 0);
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final LocalDateTime J(g gVar, long j4, long j5, long j6, long j7) {
        g gVar2 = gVar;
        j jVar = this.f4844b;
        if ((j4 | j5 | j6 | j7) == 0) {
            return L(gVar2, jVar);
        }
        long j8 = j5 / 1440;
        long j9 = j4 / 24;
        long j10 = j9 + j8 + (j6 / 86400) + (j7 / 86400000000000L);
        long j11 = (long) 1;
        long j12 = (j5 % 1440) * 60000000000L;
        long j13 = ((j4 % 24) * 3600000000000L) + j12 + ((j6 % 86400) * C.NANOS_PER_SECOND) + (j7 % 86400000000000L);
        long N4 = jVar.N();
        long j14 = (j13 * j11) + N4;
        long B4 = j$.com.android.tools.r8.a.B(j14, 86400000000000L) + (j10 * j11);
        long A4 = j$.com.android.tools.r8.a.A(j14, 86400000000000L);
        if (A4 != N4) {
            jVar = j.G(A4);
        }
        return L(gVar2.N(B4), jVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5037f) {
            return this.f4843a;
        }
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    /* renamed from: x */
    public final int compareTo(C1120e eVar) {
        if (eVar instanceof LocalDateTime) {
            return C((LocalDateTime) eVar);
        }
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public final boolean E(C1120e eVar) {
        if (eVar instanceof LocalDateTime) {
            return C((LocalDateTime) eVar) < 0;
        }
        int i4 = (this.f4843a.u() > eVar.c().u() ? 1 : (this.f4843a.u() == eVar.c().u() ? 0 : -1));
        if (i4 >= 0) {
            return i4 == 0 && this.f4844b.N() < eVar.b().N();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            return this.f4843a.equals(localDateTime.f4843a) && this.f4844b.equals(localDateTime.f4844b);
        }
    }

    public final int hashCode() {
        return this.f4843a.hashCode() ^ this.f4844b.hashCode();
    }

    public final String toString() {
        String gVar = this.f4843a.toString();
        String jVar = this.f4844b.toString();
        return gVar + ExifInterface.GPS_DIRECTION_TRUE + jVar;
    }

    private Object writeReplace() {
        return new r((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
