package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class OffsetDateTime implements m, o, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f4845c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a  reason: collision with root package name */
    public final LocalDateTime f4846a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f4847b;

    public final int compareTo(Object obj) {
        int i4;
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        ZoneOffset zoneOffset = offsetDateTime.f4847b;
        ZoneOffset zoneOffset2 = this.f4847b;
        if (zoneOffset2.equals(zoneOffset)) {
            i4 = toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f4846a;
            localDateTime.getClass();
            long t4 = a.t(localDateTime, zoneOffset2);
            LocalDateTime localDateTime2 = offsetDateTime.f4846a;
            localDateTime2.getClass();
            int compare = Long.compare(t4, a.t(localDateTime2, offsetDateTime.f4847b));
            i4 = compare == 0 ? localDateTime.f4844b.f4990d - localDateTime2.f4844b.f4990d : compare;
        }
        return i4 == 0 ? toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime()) : i4;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f4841c;
        ZoneOffset zoneOffset = ZoneOffset.f4852g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f4842d;
        ZoneOffset zoneOffset2 = ZoneOffset.f4851f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime C(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d5 = zoneId.C().d(instant);
        return new OffsetDateTime(LocalDateTime.G(instant.f4839a, instant.f4840b, d5), d5);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.f4846a = (LocalDateTime) Objects.requireNonNull(localDateTime, "dateTime");
        this.f4847b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final OffsetDateTime E(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        if (this.f4846a != localDateTime || !this.f4847b.equals(zoneOffset)) {
            return new OffsetDateTime(localDateTime, zoneOffset);
        }
        return this;
    }

    public final boolean f(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.m(this);
        }
        return true;
    }

    public final u n(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.p(this);
        }
        if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).f5014b;
        }
        return this.f4846a.n(qVar);
    }

    public final int k(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.a(this, qVar);
        }
        int i4 = o.f4998a[((j$.time.temporal.a) qVar).ordinal()];
        if (i4 == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i4 != 2) {
            return this.f4846a.k(qVar);
        } else {
            return this.f4847b.f4853b;
        }
    }

    public final long t(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.k(this);
        }
        int i4 = o.f4998a[((j$.time.temporal.a) qVar).ordinal()];
        ZoneOffset zoneOffset = this.f4847b;
        LocalDateTime localDateTime = this.f4846a;
        if (i4 == 1) {
            localDateTime.getClass();
            return a.t(localDateTime, zoneOffset);
        } else if (i4 != 2) {
            return localDateTime.t(qVar);
        } else {
            return (long) zoneOffset.f4853b;
        }
    }

    public LocalDateTime toLocalDateTime() {
        return this.f4846a;
    }

    public final m m(g gVar) {
        LocalDateTime localDateTime = this.f4846a;
        return E(localDateTime.L(gVar, localDateTime.f4844b), this.f4847b);
    }

    public final m d(long j4, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (OffsetDateTime) qVar.n(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i4 = o.f4998a[aVar.ordinal()];
        ZoneOffset zoneOffset = this.f4847b;
        LocalDateTime localDateTime = this.f4846a;
        if (i4 == 1) {
            return C(Instant.D(j4, (long) localDateTime.f4844b.f4990d), zoneOffset);
        }
        if (i4 != 2) {
            return E(localDateTime.d(j4, qVar), zoneOffset);
        }
        return E(localDateTime, ZoneOffset.J(aVar.f5014b.a(j4, aVar)));
    }

    /* renamed from: D */
    public final OffsetDateTime e(long j4, s sVar) {
        if (sVar instanceof b) {
            return E(this.f4846a.e(j4, sVar), this.f4847b);
        }
        return (OffsetDateTime) sVar.j(this, j4);
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5035d || aVar == r.f5036e) {
            return this.f4847b;
        }
        if (aVar == r.f5032a) {
            return null;
        }
        j$.time.format.a aVar2 = r.f5037f;
        LocalDateTime localDateTime = this.f4846a;
        if (aVar == aVar2) {
            return localDateTime.f4843a;
        }
        if (aVar == r.f5038g) {
            return localDateTime.f4844b;
        }
        if (aVar == r.f5033b) {
            return j$.time.chrono.s.f4904c;
        }
        if (aVar == r.f5034c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m w(m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        LocalDateTime localDateTime = this.f4846a;
        return mVar.d(localDateTime.f4843a.u(), aVar).d(localDateTime.f4844b.N(), j$.time.temporal.a.NANO_OF_DAY).d((long) this.f4847b.f4853b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            return this.f4846a.equals(offsetDateTime.f4846a) && this.f4847b.equals(offsetDateTime.f4847b);
        }
    }

    public final int hashCode() {
        return this.f4846a.hashCode() ^ this.f4847b.f4853b;
    }

    public final String toString() {
        String localDateTime = this.f4846a.toString();
        String str = this.f4847b.f4854c;
        return localDateTime + str;
    }

    private Object writeReplace() {
        return new r((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
