package j$.time.chrono;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.time.j;
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

public final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a  reason: collision with root package name */
    public final transient C1122g f4884a;

    /* renamed from: b  reason: collision with root package name */
    public final transient ZoneOffset f4885b;

    /* renamed from: c  reason: collision with root package name */
    public final transient ZoneId f4886c;

    public final /* synthetic */ long B() {
        return a.u(this);
    }

    public final /* synthetic */ int k(q qVar) {
        return a.k(this, qVar);
    }

    public final /* synthetic */ Object p(j$.time.format.a aVar) {
        return a.r(this, aVar);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a.i(this, (ChronoZonedDateTime) obj);
    }

    public static k C(ZoneId zoneId, ZoneOffset zoneOffset, C1122g gVar) {
        Objects.requireNonNull(gVar, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, gVar);
        }
        f C4 = zoneId.C();
        LocalDateTime D4 = LocalDateTime.D(gVar);
        List f4 = C4.f(D4);
        if (f4.size() == 1) {
            zoneOffset = (ZoneOffset) f4.get(0);
        } else if (f4.size() == 0) {
            Object e5 = C4.e(D4);
            b bVar = e5 instanceof b ? (b) e5 : null;
            gVar = gVar.E(gVar.f4875a, 0, 0, Duration.j((long) (bVar.f5057d.f4853b - bVar.f5056c.f4853b), 0).f4836a, 0);
            zoneOffset = bVar.f5057d;
        } else {
            C1122g gVar2 = gVar;
            if (zoneOffset == null || !f4.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) f4.get(0);
            }
            gVar = gVar2;
        }
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, zoneOffset, gVar);
    }

    public final u n(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.p(this);
        }
        if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) qVar).f5014b;
        }
        return ((C1122g) y()).n(qVar);
    }

    public static k w(l lVar, m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.a())) {
            return kVar;
        }
        String i4 = lVar.i();
        String i5 = kVar.a().i();
        throw new ClassCastException("Chronology mismatch, required: " + i4 + ", actual: " + i5);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.k(this);
        }
        int i4 = C1124i.f4882a[((j$.time.temporal.a) qVar).ordinal()];
        if (i4 == 1) {
            return B();
        }
        if (i4 != 2) {
            return ((C1122g) y()).t(qVar);
        }
        return (long) g().f4853b;
    }

    public k(ZoneId zoneId, ZoneOffset zoneOffset, C1122g gVar) {
        this.f4884a = (C1122g) Objects.requireNonNull(gVar, "dateTime");
        this.f4885b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        this.f4886c = (ZoneId) Objects.requireNonNull(zoneId, "zone");
    }

    public final ZoneOffset g() {
        return this.f4885b;
    }

    public final C1117b c() {
        return ((C1122g) y()).c();
    }

    public final j b() {
        return ((C1122g) y()).b();
    }

    public final C1120e y() {
        return this.f4884a;
    }

    public final ZoneId r() {
        return this.f4886c;
    }

    public final l a() {
        return c().a();
    }

    public final ChronoZonedDateTime h(ZoneId zoneId) {
        return C(zoneId, this.f4885b, this.f4884a);
    }

    public final boolean f(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.m(this);
        }
        return true;
    }

    public final m d(long j4, q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return w(a(), qVar.n(this, j4));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i4 = C1125j.f4883a[aVar.ordinal()];
        if (i4 == 1) {
            return e(j4 - a.u(this), j$.time.temporal.b.SECONDS);
        }
        ZoneId zoneId = this.f4886c;
        C1122g gVar = this.f4884a;
        if (i4 != 2) {
            return C(zoneId, this.f4885b, gVar.d(j4, qVar));
        }
        ZoneOffset J4 = ZoneOffset.J(aVar.f5014b.a(j4, aVar));
        gVar.getClass();
        Instant D4 = Instant.D(a.t(gVar, J4), (long) gVar.f4876b.f4990d);
        l a5 = a();
        ZoneOffset d5 = zoneId.C().d(D4);
        Objects.requireNonNull(d5, TypedValues.CycleType.S_WAVE_OFFSET);
        return new k(zoneId, d5, (C1122g) a5.o(LocalDateTime.G(D4.f4839a, D4.f4840b, d5)));
    }

    /* renamed from: D */
    public final k e(long j4, s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return w(a(), sVar.j(this, j4));
        }
        return w(a(), this.f4884a.e(j4, sVar).w(this));
    }

    private Object writeReplace() {
        return new E((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && a.i(this, (ChronoZonedDateTime) obj) == 0;
    }

    public final int hashCode() {
        return (this.f4884a.hashCode() ^ this.f4885b.f4853b) ^ Integer.rotateLeft(this.f4886c.hashCode(), 3);
    }

    public final String toString() {
        String gVar = this.f4884a.toString();
        ZoneOffset zoneOffset = this.f4885b;
        String str = gVar + zoneOffset.f4854c;
        ZoneId zoneId = this.f4886c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    public final m m(g gVar) {
        return w(a(), gVar.w(this));
    }

    public final m j(long j4, j$.time.temporal.b bVar) {
        return w(a(), r.b(this, j4, bVar));
    }

    public final Instant toInstant() {
        return Instant.D(B(), (long) b().f4990d);
    }
}
