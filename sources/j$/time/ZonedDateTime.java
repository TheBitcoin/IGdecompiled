package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.chrono.C1117b;
import j$.time.chrono.C1120e;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.l;
import j$.time.temporal.m;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.time.zone.b;
import j$.time.zone.f;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class ZonedDateTime implements m, ChronoZonedDateTime<g>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a  reason: collision with root package name */
    public final LocalDateTime f4855a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f4856b;

    /* renamed from: c  reason: collision with root package name */
    public final ZoneId f4857c;

    public final /* synthetic */ long B() {
        return a.u(this);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a.i(this, (ChronoZonedDateTime) obj);
    }

    public static ZonedDateTime now() {
        String id = TimeZone.getDefault().getID();
        Objects.requireNonNull(id, "zoneId");
        Map map = ZoneId.f4848a;
        Objects.requireNonNull(map, "aliasMap");
        Object obj = (String) map.get(id);
        if (obj == null) {
            obj = Objects.requireNonNull(id, "defaultObj");
        }
        ZoneId of = ZoneId.of((String) obj);
        Objects.requireNonNull(new a(of), "clock");
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), of);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f4858b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        aVar.getClass();
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), aVar.f4859a);
    }

    public final l a() {
        return ((g) c()).a();
    }

    public static ZonedDateTime of(int i4, int i5, int i6, int i7, int i8, int i9, int i10, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f4841c;
        g K4 = g.K(i4, i5, i6);
        j$.time.temporal.a.HOUR_OF_DAY.w((long) i7);
        j$.time.temporal.a.MINUTE_OF_HOUR.w((long) i8);
        j$.time.temporal.a.SECOND_OF_MINUTE.w((long) i9);
        j$.time.temporal.a.NANO_OF_SECOND.w((long) i10);
        return C(new LocalDateTime(K4, j.D(i7, i8, i9, i10)), zoneId, (ZoneOffset) null);
    }

    public static ZonedDateTime C(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        f C4 = zoneId.C();
        List f4 = C4.f(localDateTime);
        if (f4.size() == 1) {
            zoneOffset = (ZoneOffset) f4.get(0);
        } else if (f4.size() == 0) {
            Object e5 = C4.e(localDateTime);
            b bVar = e5 instanceof b ? (b) e5 : null;
            localDateTime = localDateTime.I(Duration.j((long) (bVar.f5057d.f4853b - bVar.f5056c.f4853b), 0).f4836a);
            zoneOffset = bVar.f5057d;
        } else if (zoneOffset == null || !f4.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) f4.get(0), TypedValues.CycleType.S_WAVE_OFFSET);
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return w(instant.f4839a, instant.f4840b, zoneId);
    }

    public static ZonedDateTime w(long j4, int i4, ZoneId zoneId) {
        ZoneOffset d5 = zoneId.C().d(Instant.D(j4, (long) i4));
        return new ZonedDateTime(LocalDateTime.G(j4, i4, d5), zoneId, d5);
    }

    public final Instant toInstant() {
        return Instant.D(B(), (long) b().f4990d);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f4855a = localDateTime;
        this.f4856b = zoneOffset;
        this.f4857c = zoneId;
    }

    public final boolean f(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.m(this);
        }
        return true;
    }

    public final C1117b c() {
        return this.f4855a.f4843a;
    }

    public int getYear() {
        return this.f4855a.f4843a.f4977a;
    }

    public final u n(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.p(this);
        }
        if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).f5014b;
        }
        return this.f4855a.n(qVar);
    }

    public int getMonthValue() {
        return this.f4855a.f4843a.f4978b;
    }

    public int getDayOfMonth() {
        return this.f4855a.f4843a.f4979c;
    }

    public final int k(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return a.k(this, qVar);
        }
        int i4 = x.f5051a[((j$.time.temporal.a) qVar).ordinal()];
        if (i4 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i4 != 2) {
            return this.f4855a.k(qVar);
        } else {
            return this.f4856b.f4853b;
        }
    }

    public final j b() {
        return this.f4855a.f4844b;
    }

    public final m m(g gVar) {
        return C(LocalDateTime.F(gVar, this.f4855a.f4844b), this.f4857c, this.f4856b);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.k(this);
        }
        int i4 = x.f5051a[((j$.time.temporal.a) qVar).ordinal()];
        return i4 != 1 ? i4 != 2 ? this.f4855a.t(qVar) : (long) this.f4856b.f4853b : a.u(this);
    }

    public final ZoneOffset g() {
        return this.f4856b;
    }

    public final ZoneId r() {
        return this.f4857c;
    }

    public final ChronoZonedDateTime h(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f4857c.equals(zoneId) ? this : C(this.f4855a, zoneId, this.f4856b);
    }

    public final C1120e y() {
        return this.f4855a;
    }

    public final m d(long j4, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (ZonedDateTime) qVar.n(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i4 = x.f5051a[aVar.ordinal()];
        LocalDateTime localDateTime = this.f4855a;
        ZoneId zoneId = this.f4857c;
        if (i4 == 1) {
            return w(j4, localDateTime.f4844b.f4990d, zoneId);
        }
        ZoneOffset zoneOffset = this.f4856b;
        if (i4 != 2) {
            return C(localDateTime.d(j4, qVar), zoneId, zoneOffset);
        }
        ZoneOffset J4 = ZoneOffset.J(aVar.f5014b.a(j4, aVar));
        return (J4.equals(zoneOffset) || !zoneId.C().f(localDateTime).contains(J4)) ? this : new ZonedDateTime(localDateTime, zoneId, J4);
    }

    /* renamed from: D */
    public final ZonedDateTime e(long j4, s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (ZonedDateTime) sVar.j(this, j4);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
        int compareTo = bVar.compareTo(j$.time.temporal.b.DAYS);
        ZoneOffset zoneOffset = this.f4856b;
        ZoneId zoneId = this.f4857c;
        LocalDateTime localDateTime = this.f4855a;
        if (compareTo >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return C(localDateTime.e(j4, sVar), zoneId, zoneOffset);
        }
        LocalDateTime H4 = localDateTime.e(j4, sVar);
        Objects.requireNonNull(H4, "localDateTime");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.C().f(H4).contains(zoneOffset)) {
            return new ZonedDateTime(H4, zoneId, zoneOffset);
        }
        H4.getClass();
        return w(a.t(H4, zoneOffset), H4.f4844b.f4990d, zoneId);
    }

    public final m j(long j4, j$.time.temporal.b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        return aVar == r.f5037f ? this.f4855a.f4843a : a.r(this, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            return this.f4855a.equals(zonedDateTime.f4855a) && this.f4856b.equals(zonedDateTime.f4856b) && this.f4857c.equals(zonedDateTime.f4857c);
        }
    }

    public final int hashCode() {
        return (this.f4855a.hashCode() ^ this.f4856b.f4853b) ^ Integer.rotateLeft(this.f4857c.hashCode(), 3);
    }

    public final String toString() {
        String localDateTime = this.f4855a.toString();
        ZoneOffset zoneOffset = this.f4856b;
        String str = localDateTime + zoneOffset.f4854c;
        ZoneId zoneId = this.f4857c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new r((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
