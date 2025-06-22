package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import j$.time.temporal.a;
import j$.time.temporal.m;
import j$.time.temporal.n;
import j$.time.temporal.o;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;
import j$.time.zone.f;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

public final class ZoneOffset extends ZoneId implements n, o, Comparable<ZoneOffset>, Serializable {
    public static final ZoneOffset UTC = J(0);

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap f4849d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e  reason: collision with root package name */
    public static final ConcurrentHashMap f4850e = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: f  reason: collision with root package name */
    public static final ZoneOffset f4851f = J(-64800);

    /* renamed from: g  reason: collision with root package name */
    public static final ZoneOffset f4852g = J(64800);
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b  reason: collision with root package name */
    public final int f4853b;

    /* renamed from: c  reason: collision with root package name */
    public final transient String f4854c;

    public final int compareTo(Object obj) {
        return ((ZoneOffset) obj).f4853b - this.f4853b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.time.ZoneOffset H(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            j$.util.Objects.requireNonNull(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = f4850e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0063
            r1 = 3
            if (r0 == r1) goto L_0x007f
            r4 = 5
            if (r0 == r4) goto L_0x005a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x0050
            r5 = 7
            if (r0 == r5) goto L_0x0043
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = K(r7, r2, r3)
            int r1 = K(r7, r6, r2)
            int r2 = K(r7, r5, r2)
            goto L_0x0085
        L_0x0037:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x0043:
            int r0 = K(r7, r2, r3)
            int r1 = K(r7, r1, r3)
            int r2 = K(r7, r4, r3)
            goto L_0x0085
        L_0x0050:
            int r0 = K(r7, r2, r3)
            int r1 = K(r7, r6, r2)
        L_0x0058:
            r2 = 0
            goto L_0x0085
        L_0x005a:
            int r0 = K(r7, r2, r3)
            int r1 = K(r7, r1, r3)
            goto L_0x0058
        L_0x0063:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L_0x007f:
            int r0 = K(r7, r2, r3)
            r1 = 0
            goto L_0x0058
        L_0x0085:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x009e
            if (r3 != r5) goto L_0x0092
            goto L_0x009e
        L_0x0092:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L_0x009e:
            if (r3 != r5) goto L_0x00a8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = I(r7, r0, r1)
            return r7
        L_0x00a8:
            j$.time.ZoneOffset r7 = I(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.H(java.lang.String):j$.time.ZoneOffset");
    }

    public final f C() {
        Objects.requireNonNull(this, TypedValues.CycleType.S_WAVE_OFFSET);
        return new f(this);
    }

    public static int K(String str, int i4, boolean z4) {
        if (!z4 || str.charAt(i4 - 1) == ':') {
            char charAt = str.charAt(i4);
            char charAt2 = str.charAt(i4 + 1);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
                throw new RuntimeException("Invalid ID for ZoneOffset, non numeric characters found: " + str);
            }
            return (charAt2 - '0') + ((charAt - '0') * 10);
        }
        throw new RuntimeException("Invalid ID for ZoneOffset, colon not found when expected: " + str);
    }

    public static ZoneOffset I(int i4, int i5, int i6) {
        if (i4 < -18 || i4 > 18) {
            throw new RuntimeException("Zone offset hours not in valid range: value " + i4 + " is not in the range -18 to 18");
        }
        if (i4 > 0) {
            if (i5 < 0 || i6 < 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i4 < 0) {
            if (i5 > 0 || i6 > 0) {
                throw new RuntimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i5 > 0 && i6 < 0) || (i5 < 0 && i6 > 0)) {
            throw new RuntimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (i5 < -59 || i5 > 59) {
            throw new RuntimeException("Zone offset minutes not in valid range: value " + i5 + " is not in the range -59 to 59");
        } else if (i6 < -59 || i6 > 59) {
            throw new RuntimeException("Zone offset seconds not in valid range: value " + i6 + " is not in the range -59 to 59");
        } else if (Math.abs(i4) != 18 || (i5 | i6) == 0) {
            return J((i5 * 60) + (i4 * 3600) + i6);
        } else {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
    }

    public static ZoneOffset J(int i4) {
        if (i4 < -64800 || i4 > 64800) {
            throw new RuntimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i4 % TypedValues.Custom.TYPE_INT != 0) {
            return new ZoneOffset(i4);
        } else {
            Integer valueOf = Integer.valueOf(i4);
            ConcurrentHashMap concurrentHashMap = f4849d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i4));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
            f4850e.putIfAbsent(zoneOffset2.f4854c, zoneOffset2);
            return zoneOffset2;
        }
    }

    public ZoneOffset(int i4) {
        String str;
        this.f4853b = i4;
        if (i4 == 0) {
            str = "Z";
        } else {
            int abs = Math.abs(i4);
            StringBuilder sb = new StringBuilder();
            int i5 = abs / 3600;
            int i6 = (abs / 60) % 60;
            sb.append(i4 < 0 ? "-" : "+");
            sb.append(i5 < 10 ? "0" : "");
            sb.append(i5);
            String str2 = ":";
            sb.append(i6 < 10 ? ":0" : str2);
            sb.append(i6);
            int i7 = abs % 60;
            if (i7 != 0) {
                sb.append(i7 < 10 ? ":0" : str2);
                sb.append(i7);
            }
            str = sb.toString();
        }
        this.f4854c = str;
    }

    public final String i() {
        return this.f4854c;
    }

    public final boolean f(q qVar) {
        return qVar instanceof a ? qVar == a.OFFSET_SECONDS : qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        return r.d(this, qVar);
    }

    public final int k(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return this.f4853b;
        }
        if (!c.b(qVar)) {
            return r.d(this, qVar).a(t(qVar), qVar);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final long t(q qVar) {
        if (qVar == a.OFFSET_SECONDS) {
            return (long) this.f4853b;
        }
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        throw new RuntimeException(c.a("Unsupported field: ", qVar));
    }

    public final Object p(j$.time.format.a aVar) {
        return (aVar == r.f5035d || aVar == r.f5036e) ? this : r.c(this, aVar);
    }

    public final m w(m mVar) {
        return mVar.d((long) this.f4853b, a.OFFSET_SECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r4 = ((j$.time.ZoneOffset) r4).f4853b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            if (r3 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof j$.time.ZoneOffset
            r2 = 0
            if (r1 == 0) goto L_0x0012
            j$.time.ZoneOffset r4 = (j$.time.ZoneOffset) r4
            int r4 = r4.f4853b
            int r1 = r3.f4853b
            if (r1 != r4) goto L_0x0012
            return r0
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f4853b;
    }

    public final String toString() {
        return this.f4854c;
    }

    private Object writeReplace() {
        return new r((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void G(ObjectOutput objectOutput) {
        objectOutput.writeByte(8);
        M(objectOutput);
    }

    public final void M(DataOutput dataOutput) {
        int i4 = this.f4853b;
        int i5 = i4 % TypedValues.Custom.TYPE_INT == 0 ? i4 / TypedValues.Custom.TYPE_INT : ModuleDescriptor.MODULE_VERSION;
        dataOutput.writeByte(i5);
        if (i5 == 127) {
            dataOutput.writeInt(i4);
        }
    }

    public static ZoneOffset L(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        return readByte == Byte.MAX_VALUE ? J(objectInput.readInt()) : J(readByte * 900);
    }
}
