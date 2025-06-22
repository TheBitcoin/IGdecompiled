package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.b;
import j$.time.temporal.m;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.s;
import j$.time.temporal.u;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class Instant implements m, o, Comparable<Instant>, Serializable {
    public static final Instant MAX = D(31556889864403199L, 999999999);
    public static final Instant MIN = D(-31557014167219200L, 0);

    /* renamed from: c  reason: collision with root package name */
    public static final Instant f4838c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a  reason: collision with root package name */
    public final long f4839a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4840b;

    public final int compareTo(Object obj) {
        Instant instant = (Instant) obj;
        int compare = Long.compare(this.f4839a, instant.f4839a);
        if (compare != 0) {
            return compare;
        }
        return this.f4840b - instant.f4840b;
    }

    public static Instant D(long j4, long j5) {
        return C(a.x(j4, a.B(j5, C.NANOS_PER_SECOND)), (int) a.A(j5, C.NANOS_PER_SECOND));
    }

    public static Instant ofEpochMilli(long j4) {
        long j5 = (long) 1000;
        return C(a.B(j4, j5), ((int) a.A(j4, j5)) * 1000000);
    }

    public static Instant C(long j4, int i4) {
        if ((((long) i4) | j4) == 0) {
            return f4838c;
        }
        if (j4 >= -31557014167219200L && j4 <= 31556889864403199L) {
            return new Instant(j4, i4);
        }
        throw new RuntimeException("Instant exceeds minimum or maximum instant");
    }

    public Instant(long j4, int i4) {
        this.f4839a = j4;
        this.f4840b = i4;
    }

    public final boolean f(q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        return r.d(this, qVar);
    }

    public final int k(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return r.d(this, qVar).a(qVar.k(this), qVar);
        }
        int i4 = e.f4921a[((j$.time.temporal.a) qVar).ordinal()];
        int i5 = this.f4840b;
        if (i4 == 1) {
            return i5;
        }
        if (i4 == 2) {
            return i5 / 1000;
        }
        if (i4 == 3) {
            return i5 / 1000000;
        }
        if (i4 == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f5014b.a(this.f4839a, aVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long t(q qVar) {
        int i4;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.k(this);
        }
        int i5 = e.f4921a[((j$.time.temporal.a) qVar).ordinal()];
        int i6 = this.f4840b;
        if (i5 == 1) {
            return (long) i6;
        }
        if (i5 == 2) {
            i4 = i6 / 1000;
        } else if (i5 == 3) {
            i4 = i6 / 1000000;
        } else if (i5 == 4) {
            return this.f4839a;
        } else {
            throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return (long) i4;
    }

    public final m d(long j4, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.n(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.w(j4);
        int i4 = e.f4921a[aVar.ordinal()];
        int i5 = this.f4840b;
        long j5 = this.f4839a;
        if (i4 != 1) {
            if (i4 == 2) {
                int i6 = ((int) j4) * 1000;
                if (i6 != i5) {
                    return C(j5, i6);
                }
            } else if (i4 == 3) {
                int i7 = ((int) j4) * 1000000;
                if (i7 != i5) {
                    return C(j5, i7);
                }
            } else if (i4 != 4) {
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
            } else if (j4 != j5) {
                return C(j4, i5);
            }
        } else if (j4 != ((long) i5)) {
            return C(j5, (int) j4);
        }
        return this;
    }

    /* renamed from: F */
    public final Instant e(long j4, s sVar) {
        if (!(sVar instanceof b)) {
            return (Instant) sVar.j(this, j4);
        }
        switch (e.f4922b[((b) sVar).ordinal()]) {
            case 1:
                return E(0, j4);
            case 2:
                return E(j4 / 1000000, (j4 % 1000000) * 1000);
            case 3:
                return E(j4 / 1000, (j4 % 1000) * 1000000);
            case 4:
                return E(j4, 0);
            case 5:
                return E(a.w(j4, 60), 0);
            case 6:
                return E(a.w(j4, 3600), 0);
            case 7:
                return E(a.w(j4, 43200), 0);
            case 8:
                return E(a.w(j4, 86400), 0);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final Instant E(long j4, long j5) {
        if ((j4 | j5) == 0) {
            return this;
        }
        return D(a.x(a.x(this.f4839a, j4), j5 / C.NANOS_PER_SECOND), ((long) this.f4840b) + (j5 % C.NANOS_PER_SECOND));
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5034c) {
            return b.NANOS;
        }
        if (aVar == r.f5033b || aVar == r.f5032a || aVar == r.f5036e || aVar == r.f5035d || aVar == r.f5037f || aVar == r.f5038g) {
            return null;
        }
        return aVar.a(this);
    }

    public final m w(m mVar) {
        return mVar.d(this.f4839a, j$.time.temporal.a.INSTANT_SECONDS).d((long) this.f4840b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.C(this, zoneOffset);
    }

    public long toEpochMilli() {
        int i4 = this.f4840b;
        long j4 = this.f4839a;
        if (j4 >= 0 || i4 <= 0) {
            return a.x(a.w(j4, 1000), (long) (i4 / 1000000));
        }
        return a.x(a.w(j4 + 1, 1000), (long) ((i4 / 1000000) - 1000));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            return this.f4839a == instant.f4839a && this.f4840b == instant.f4840b;
        }
    }

    public int hashCode() {
        long j4 = this.f4839a;
        return (this.f4840b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f4925e.a(this);
    }

    private Object writeReplace() {
        return new r((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m m(g gVar) {
        return (Instant) a.a(gVar, this);
    }
}
