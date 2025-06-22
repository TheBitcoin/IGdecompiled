package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.temporal.a;
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

public final class p implements m, o, Comparable, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f4999c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a  reason: collision with root package name */
    public final j f5000a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset f5001b;

    public final int compareTo(Object obj) {
        p pVar = (p) obj;
        ZoneOffset zoneOffset = pVar.f5001b;
        ZoneOffset zoneOffset2 = this.f5001b;
        boolean equals = zoneOffset2.equals(zoneOffset);
        j jVar = pVar.f5000a;
        j jVar2 = this.f5000a;
        if (equals) {
            return jVar2.compareTo(jVar);
        }
        int compare = Long.compare(jVar2.N() - (((long) zoneOffset2.f4853b) * C.NANOS_PER_SECOND), jVar.N() - (((long) pVar.f5001b.f4853b) * C.NANOS_PER_SECOND));
        return compare == 0 ? jVar2.compareTo(jVar) : compare;
    }

    static {
        j jVar = j.f4983e;
        ZoneOffset zoneOffset = ZoneOffset.f4852g;
        jVar.getClass();
        new p(jVar, zoneOffset);
        j jVar2 = j.f4984f;
        ZoneOffset zoneOffset2 = ZoneOffset.f4851f;
        jVar2.getClass();
        new p(jVar2, zoneOffset2);
    }

    public p(j jVar, ZoneOffset zoneOffset) {
        this.f5000a = (j) Objects.requireNonNull(jVar, "time");
        this.f5001b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final p D(j jVar, ZoneOffset zoneOffset) {
        if (this.f5000a != jVar || !this.f5001b.equals(zoneOffset)) {
            return new p(jVar, zoneOffset);
        }
        return this;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? ((a) qVar).C() || qVar == a.OFFSET_SECONDS : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.p(this);
        }
        if (qVar == a.OFFSET_SECONDS) {
            return ((a) qVar).f5014b;
        }
        j jVar = this.f5000a;
        jVar.getClass();
        return r.d(jVar, qVar);
    }

    public final int k(q qVar) {
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (qVar instanceof a) {
            return qVar == a.OFFSET_SECONDS ? (long) this.f5001b.f4853b : this.f5000a.t(qVar);
        }
        return qVar.k(this);
    }

    public final m d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (p) qVar.n(this, j4);
        }
        a aVar = a.OFFSET_SECONDS;
        j jVar = this.f5000a;
        if (qVar != aVar) {
            return D(jVar.d(j4, qVar), this.f5001b);
        }
        a aVar2 = (a) qVar;
        return D(jVar, ZoneOffset.J(aVar2.f5014b.a(j4, aVar2)));
    }

    /* renamed from: C */
    public final p e(long j4, s sVar) {
        if (sVar instanceof b) {
            return D(this.f5000a.e(j4, sVar), this.f5001b);
        }
        return (p) sVar.j(this, j4);
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5035d || aVar == r.f5036e) {
            return this.f5001b;
        }
        boolean z4 = false;
        boolean z5 = aVar == r.f5032a;
        if (aVar == r.f5033b) {
            z4 = true;
        }
        if ((z5 || z4) || aVar == r.f5037f) {
            return null;
        }
        if (aVar == r.f5038g) {
            return this.f5000a;
        }
        if (aVar == r.f5034c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m w(m mVar) {
        return mVar.d(this.f5000a.N(), a.NANO_OF_DAY).d((long) this.f5001b.f4853b, a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.f5000a.equals(pVar.f5000a) && this.f5001b.equals(pVar.f5001b);
        }
    }

    public final int hashCode() {
        return this.f5000a.hashCode() ^ this.f5001b.f4853b;
    }

    public final String toString() {
        String jVar = this.f5000a.toString();
        String str = this.f5001b.f4854c;
        return jVar + str;
    }

    private Object writeReplace() {
        return new r((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final m m(g gVar) {
        return (p) j$.com.android.tools.r8.a.a(gVar, this);
    }
}
