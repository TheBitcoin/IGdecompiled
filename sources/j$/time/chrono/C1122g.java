package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.ZoneOffset;
import j$.time.format.a;
import j$.time.g;
import j$.time.j;
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

/* renamed from: j$.time.chrono.g  reason: case insensitive filesystem */
public final class C1122g implements C1120e, m, o, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a  reason: collision with root package name */
    public final transient C1117b f4875a;

    /* renamed from: b  reason: collision with root package name */
    public final transient j f4876b;

    public final /* synthetic */ Object p(a aVar) {
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    /* renamed from: x */
    public final /* synthetic */ int compareTo(C1120e eVar) {
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public static C1122g C(l lVar, m mVar) {
        C1122g gVar = (C1122g) mVar;
        if (lVar.equals(gVar.f4875a.a())) {
            return gVar;
        }
        String i4 = lVar.i();
        String i5 = gVar.f4875a.a().i();
        throw new ClassCastException("Chronology mismatch, required: " + i4 + ", actual: " + i5);
    }

    public final l a() {
        return this.f4875a.a();
    }

    public final m j(long j4, b bVar) {
        return C(this.f4875a.a(), r.b(this, j4, bVar));
    }

    public C1122g(C1117b bVar, j jVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(jVar, "time");
        this.f4875a = bVar;
        this.f4876b = jVar;
    }

    public final C1122g G(m mVar, j jVar) {
        C1117b bVar = this.f4875a;
        if (bVar == mVar && this.f4876b == jVar) {
            return this;
        }
        return new C1122g(C1119d.C(bVar.a(), mVar), jVar);
    }

    public final C1117b c() {
        return this.f4875a;
    }

    public final j b() {
        return this.f4876b;
    }

    public final boolean f(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.m(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.t() || aVar.C();
    }

    public final u n(q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.p(this);
        }
        if (!((j$.time.temporal.a) qVar).C()) {
            return this.f4875a.n(qVar);
        }
        j jVar = this.f4876b;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int k(q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).C() ? this.f4876b.k(qVar) : this.f4875a.k(qVar);
        }
        return n(qVar).a(t(qVar), qVar);
    }

    public final long t(q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).C() ? this.f4876b.t(qVar) : this.f4875a.t(qVar);
        }
        return qVar.k(this);
    }

    public final m m(g gVar) {
        return G(gVar, this.f4876b);
    }

    /* renamed from: F */
    public final C1122g d(long j4, q qVar) {
        boolean z4 = qVar instanceof j$.time.temporal.a;
        C1117b bVar = this.f4875a;
        if (!z4) {
            return C(bVar.a(), qVar.n(this, j4));
        }
        boolean C4 = ((j$.time.temporal.a) qVar).C();
        j jVar = this.f4876b;
        if (C4) {
            return G(bVar, jVar.d(j4, qVar));
        }
        return G(bVar.d(j4, qVar), jVar);
    }

    /* renamed from: D */
    public final C1122g e(long j4, s sVar) {
        long j5 = j4;
        s sVar2 = sVar;
        boolean z4 = sVar2 instanceof b;
        C1117b bVar = this.f4875a;
        if (!z4) {
            return C(bVar.a(), sVar2.j(this, j5));
        }
        int i4 = C1121f.f4874a[((b) sVar2).ordinal()];
        j jVar = this.f4876b;
        switch (i4) {
            case 1:
                return E(this.f4875a, 0, 0, 0, j4);
            case 2:
                C1122g G4 = G(bVar.e(j4 / 86400000000L, b.DAYS), jVar);
                return G4.E(G4.f4875a, 0, 0, 0, (j4 % 86400000000L) * 1000);
            case 3:
                C1122g G5 = G(bVar.e(j4 / 86400000, b.DAYS), jVar);
                return G5.E(G5.f4875a, 0, 0, 0, (j4 % 86400000) * 1000000);
            case 4:
                return E(this.f4875a, 0, 0, j4, 0);
            case 5:
                return E(this.f4875a, 0, j4, 0, 0);
            case 6:
                return E(this.f4875a, j5, 0, 0, 0);
            case 7:
                C1122g G6 = G(bVar.e(j5 / 256, b.DAYS), jVar);
                return G6.E(G6.f4875a, (j5 % 256) * 12, 0, 0, 0);
            default:
                return G(bVar.e(j5, sVar2), jVar);
        }
    }

    public final C1122g E(C1117b bVar, long j4, long j5, long j6, long j7) {
        C1117b bVar2 = bVar;
        j jVar = this.f4876b;
        if ((j4 | j5 | j6 | j7) == 0) {
            return G(bVar2, jVar);
        }
        long j8 = j5 / 1440;
        long j9 = j4 / 24;
        long j10 = (j5 % 1440) * 60000000000L;
        long j11 = ((j4 % 24) * 3600000000000L) + j10 + ((j6 % 86400) * C.NANOS_PER_SECOND) + (j7 % 86400000000000L);
        long N4 = jVar.N();
        long j12 = j11 + N4;
        long B4 = j$.com.android.tools.r8.a.B(j12, 86400000000000L) + j9 + j8 + (j6 / 86400) + (j7 / 86400000000000L);
        long A4 = j$.com.android.tools.r8.a.A(j12, 86400000000000L);
        if (A4 != N4) {
            jVar = j.G(A4);
        }
        return G(bVar2.e(B4, b.DAYS), jVar);
    }

    public final ChronoZonedDateTime q(ZoneOffset zoneOffset) {
        return k.C(zoneOffset, (ZoneOffset) null, this);
    }

    public final m w(m mVar) {
        return mVar.d(c().u(), j$.time.temporal.a.EPOCH_DAY).d(b().N(), j$.time.temporal.a.NANO_OF_DAY);
    }

    private Object writeReplace() {
        return new E((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1120e) && j$.com.android.tools.r8.a.h(this, (C1120e) obj) == 0;
    }

    public final int hashCode() {
        return this.f4875a.hashCode() ^ this.f4876b.hashCode();
    }

    public final String toString() {
        String bVar = this.f4875a.toString();
        String jVar = this.f4876b.toString();
        return bVar + ExifInterface.GPS_DIRECTION_TRUE + jVar;
    }
}
