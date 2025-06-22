package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
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
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class j implements m, o, Comparable, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final j f4983e;

    /* renamed from: f  reason: collision with root package name */
    public static final j f4984f = new j(23, 59, 59, 999999999);

    /* renamed from: g  reason: collision with root package name */
    public static final j f4985g;

    /* renamed from: h  reason: collision with root package name */
    public static final j[] f4986h = new j[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a  reason: collision with root package name */
    public final byte f4987a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f4988b;

    /* renamed from: c  reason: collision with root package name */
    public final byte f4989c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4990d;

    static {
        int i4 = 0;
        while (true) {
            j[] jVarArr = f4986h;
            if (i4 < jVarArr.length) {
                jVarArr[i4] = new j(i4, 0, 0, 0);
                i4++;
            } else {
                j jVar = jVarArr[0];
                f4985g = jVar;
                j jVar2 = jVarArr[12];
                f4983e = jVar;
                return;
            }
        }
    }

    public static j G(long j4) {
        a.NANO_OF_DAY.w(j4);
        int i4 = (int) (j4 / 3600000000000L);
        long j5 = j4 - (((long) i4) * 3600000000000L);
        int i5 = (int) (j5 / 60000000000L);
        long j6 = j5 - (((long) i5) * 60000000000L);
        int i6 = (int) (j6 / C.NANOS_PER_SECOND);
        return D(i4, i5, i6, (int) (j6 - (((long) i6) * C.NANOS_PER_SECOND)));
    }

    public static j E(n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        j jVar = (j) nVar.p(r.f5038g);
        if (jVar != null) {
            return jVar;
        }
        String name = nVar.getClass().getName();
        throw new RuntimeException("Unable to obtain LocalTime from TemporalAccessor: " + nVar + " of type " + name);
    }

    public static j D(int i4, int i5, int i6, int i7) {
        if ((i5 | i6 | i7) == 0) {
            return f4986h[i4];
        }
        return new j(i4, i5, i6, i7);
    }

    public j(int i4, int i5, int i6, int i7) {
        this.f4987a = (byte) i4;
        this.f4988b = (byte) i5;
        this.f4989c = (byte) i6;
        this.f4990d = i7;
    }

    public final boolean f(q qVar) {
        if (qVar instanceof a) {
            return ((a) qVar).C();
        }
        return qVar != null && qVar.m(this);
    }

    public final u n(q qVar) {
        return r.d(this, qVar);
    }

    public final int k(q qVar) {
        if (qVar instanceof a) {
            return F(qVar);
        }
        return r.a(this, qVar);
    }

    public final long t(q qVar) {
        if (!(qVar instanceof a)) {
            return qVar.k(this);
        }
        if (qVar == a.NANO_OF_DAY) {
            return N();
        }
        if (qVar == a.MICRO_OF_DAY) {
            return N() / 1000;
        }
        return (long) F(qVar);
    }

    public final int F(q qVar) {
        int i4 = i.f4981a[((a) qVar).ordinal()];
        byte b5 = this.f4988b;
        int i5 = this.f4990d;
        byte b6 = this.f4987a;
        switch (i4) {
            case 1:
                return i5;
            case 2:
                throw new RuntimeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return i5 / 1000;
            case 4:
                throw new RuntimeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return i5 / 1000000;
            case 6:
                return (int) (N() / 1000000);
            case 7:
                return this.f4989c;
            case 8:
                return O();
            case 9:
                return b5;
            case 10:
                return (b6 * 60) + b5;
            case 11:
                return b6 % 12;
            case 12:
                int i6 = b6 % 12;
                if (i6 % 12 == 0) {
                    return 12;
                }
                return i6;
            case 13:
                break;
            case 14:
                if (b6 == 0) {
                    return 24;
                }
                break;
            case 15:
                return b6 / 12;
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return b6;
    }

    /* renamed from: P */
    public final j d(long j4, q qVar) {
        if (!(qVar instanceof a)) {
            return (j) qVar.n(this, j4);
        }
        a aVar = (a) qVar;
        aVar.w(j4);
        int i4 = i.f4981a[aVar.ordinal()];
        byte b5 = this.f4988b;
        byte b6 = this.f4989c;
        int i5 = this.f4990d;
        byte b7 = this.f4987a;
        switch (i4) {
            case 1:
                return Q((int) j4);
            case 2:
                return G(j4);
            case 3:
                return Q(((int) j4) * 1000);
            case 4:
                return G(j4 * 1000);
            case 5:
                return Q(((int) j4) * 1000000);
            case 6:
                return G(j4 * 1000000);
            case 7:
                int i6 = (int) j4;
                if (b6 != i6) {
                    a.SECOND_OF_MINUTE.w((long) i6);
                    return D(b7, b5, i6, i5);
                }
                break;
            case 8:
                return L(j4 - ((long) O()));
            case 9:
                int i7 = (int) j4;
                if (b5 != i7) {
                    a.MINUTE_OF_HOUR.w((long) i7);
                    return D(b7, i7, b6, i5);
                }
                break;
            case 10:
                return J(j4 - ((long) ((b7 * 60) + b5)));
            case 11:
                return I(j4 - ((long) (b7 % 12)));
            case 12:
                if (j4 == 12) {
                    j4 = 0;
                }
                return I(j4 - ((long) (b7 % 12)));
            case 13:
                int i8 = (int) j4;
                if (b7 != i8) {
                    a.HOUR_OF_DAY.w((long) i8);
                    return D(i8, b5, b6, i5);
                }
                break;
            case 14:
                if (j4 == 24) {
                    j4 = 0;
                }
                int i9 = (int) j4;
                if (b7 != i9) {
                    a.HOUR_OF_DAY.w((long) i9);
                    return D(i9, b5, b6, i5);
                }
                break;
            case 15:
                return I((j4 - ((long) (b7 / 12))) * 12);
            default:
                throw new RuntimeException(c.a("Unsupported field: ", qVar));
        }
        return this;
    }

    public final j Q(int i4) {
        if (this.f4990d == i4) {
            return this;
        }
        a.NANO_OF_SECOND.w((long) i4);
        return D(this.f4987a, this.f4988b, this.f4989c, i4);
    }

    /* renamed from: H */
    public final j e(long j4, s sVar) {
        if (!(sVar instanceof b)) {
            return (j) sVar.j(this, j4);
        }
        switch (i.f4982b[((b) sVar).ordinal()]) {
            case 1:
                return K(j4);
            case 2:
                return K((j4 % 86400000000L) * 1000);
            case 3:
                return K((j4 % 86400000) * 1000000);
            case 4:
                return L(j4);
            case 5:
                return J(j4);
            case 6:
                return I(j4);
            case 7:
                return I((j4 % 2) * 12);
            default:
                throw new RuntimeException("Unsupported unit: " + sVar);
        }
    }

    public final j I(long j4) {
        if (j4 == 0) {
            return this;
        }
        return D(((((int) (j4 % 24)) + this.f4987a) + 24) % 24, this.f4988b, this.f4989c, this.f4990d);
    }

    public final j J(long j4) {
        if (j4 != 0) {
            int i4 = (this.f4987a * 60) + this.f4988b;
            int i5 = ((((int) (j4 % 1440)) + i4) + 1440) % 1440;
            if (i4 != i5) {
                return D(i5 / 60, i5 % 60, this.f4989c, this.f4990d);
            }
        }
        return this;
    }

    public final j L(long j4) {
        if (j4 != 0) {
            int i4 = (this.f4988b * 60) + (this.f4987a * 3600) + this.f4989c;
            int i5 = ((((int) (j4 % 86400)) + i4) + 86400) % 86400;
            if (i4 != i5) {
                return D(i5 / 3600, (i5 / 60) % 60, i5 % 60, this.f4990d);
            }
        }
        return this;
    }

    public final j K(long j4) {
        if (j4 != 0) {
            long N4 = N();
            long j5 = (((j4 % 86400000000000L) + N4) + 86400000000000L) % 86400000000000L;
            if (N4 != j5) {
                return D((int) (j5 / 3600000000000L), (int) ((j5 / 60000000000L) % 60), (int) ((j5 / C.NANOS_PER_SECOND) % 60), (int) (j5 % C.NANOS_PER_SECOND));
            }
        }
        return this;
    }

    public final m j(long j4, b bVar) {
        return j4 == Long.MIN_VALUE ? e(Long.MAX_VALUE, bVar).e(1, bVar) : e(-j4, bVar);
    }

    public final Object p(j$.time.format.a aVar) {
        if (aVar == r.f5033b || aVar == r.f5032a || aVar == r.f5036e || aVar == r.f5035d) {
            return null;
        }
        if (aVar == r.f5038g) {
            return this;
        }
        if (aVar == r.f5037f) {
            return null;
        }
        if (aVar == r.f5034c) {
            return b.NANOS;
        }
        return aVar.a(this);
    }

    public final m w(m mVar) {
        return mVar.d(N(), a.NANO_OF_DAY);
    }

    public final int O() {
        return (this.f4988b * 60) + (this.f4987a * 3600) + this.f4989c;
    }

    public final long N() {
        return (((long) this.f4989c) * C.NANOS_PER_SECOND) + (((long) this.f4988b) * 60000000000L) + (((long) this.f4987a) * 3600000000000L) + ((long) this.f4990d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = java.lang.Integer.compare(r2.f4988b, r3.f4988b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = java.lang.Integer.compare(r2.f4989c, r3.f4989c);
     */
    /* renamed from: C */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(j$.time.j r3) {
        /*
            r2 = this;
            byte r0 = r3.f4987a
            byte r1 = r2.f4987a
            int r0 = java.lang.Integer.compare(r1, r0)
            if (r0 != 0) goto L_0x0027
            byte r0 = r2.f4988b
            byte r1 = r3.f4988b
            int r0 = java.lang.Integer.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            byte r0 = r2.f4989c
            byte r1 = r3.f4989c
            int r0 = java.lang.Integer.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            int r0 = r2.f4990d
            int r3 = r3.f4990d
            int r3 = java.lang.Integer.compare(r0, r3)
            return r3
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.j.compareTo(j$.time.j):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        r5 = (j$.time.j) r5;
        r1 = r5.f4987a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof j$.time.j
            r2 = 0
            if (r1 == 0) goto L_0x0024
            j$.time.j r5 = (j$.time.j) r5
            byte r1 = r5.f4987a
            byte r3 = r4.f4987a
            if (r3 != r1) goto L_0x0024
            byte r1 = r4.f4988b
            byte r3 = r5.f4988b
            if (r1 != r3) goto L_0x0024
            byte r1 = r4.f4989c
            byte r3 = r5.f4989c
            if (r1 != r3) goto L_0x0024
            int r1 = r4.f4990d
            int r5 = r5.f4990d
            if (r1 != r5) goto L_0x0024
            return r0
        L_0x0024:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.j.equals(java.lang.Object):boolean");
    }

    public final m m(g gVar) {
        return (j) j$.com.android.tools.r8.a.a(gVar, this);
    }

    public final int hashCode() {
        long N4 = N();
        return (int) (N4 ^ (N4 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b5 = this.f4987a;
        sb.append(b5 < 10 ? "0" : "");
        sb.append(b5);
        String str = ":";
        byte b6 = this.f4988b;
        sb.append(b6 < 10 ? ":0" : str);
        sb.append(b6);
        byte b7 = this.f4989c;
        int i4 = this.f4990d;
        if (b7 > 0 || i4 > 0) {
            if (b7 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append(b7);
            if (i4 > 0) {
                sb.append('.');
                if (i4 % 1000000 == 0) {
                    sb.append(Integer.toString((i4 / 1000000) + 1000).substring(1));
                } else if (i4 % 1000 == 0) {
                    sb.append(Integer.toString((i4 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i4 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void R(DataOutput dataOutput) {
        byte b5 = this.f4989c;
        byte b6 = this.f4987a;
        byte b7 = this.f4988b;
        int i4 = this.f4990d;
        if (i4 != 0) {
            dataOutput.writeByte(b6);
            dataOutput.writeByte(b7);
            dataOutput.writeByte(b5);
            dataOutput.writeInt(i4);
        } else if (b5 != 0) {
            dataOutput.writeByte(b6);
            dataOutput.writeByte(b7);
            dataOutput.writeByte(~b5);
        } else if (b7 == 0) {
            dataOutput.writeByte(~b6);
        } else {
            dataOutput.writeByte(b6);
            dataOutput.writeByte(~b7);
        }
    }

    public static j M(ObjectInput objectInput) {
        byte b5;
        int i4;
        int readByte = objectInput.readByte();
        byte b6 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            b5 = 0;
        } else {
            byte readByte2 = objectInput.readByte();
            if (readByte2 < 0) {
                int i5 = ~readByte2;
                i4 = 0;
                b6 = i5;
                b5 = 0;
            } else {
                byte readByte3 = objectInput.readByte();
                if (readByte3 < 0) {
                    b5 = ~readByte3;
                    b6 = readByte2;
                } else {
                    int readInt = objectInput.readInt();
                    byte b7 = readByte2;
                    i4 = readInt;
                    b6 = b7;
                    b5 = readByte3;
                }
            }
            a.HOUR_OF_DAY.w((long) readByte);
            a.MINUTE_OF_HOUR.w((long) b6);
            a.SECOND_OF_MINUTE.w((long) b5);
            a.NANO_OF_SECOND.w((long) i4);
            return D(readByte, b6, b5, i4);
        }
        i4 = 0;
        a.HOUR_OF_DAY.w((long) readByte);
        a.MINUTE_OF_HOUR.w((long) b6);
        a.SECOND_OF_MINUTE.w((long) b5);
        a.NANO_OF_SECOND.w((long) i4);
        return D(readByte, b6, b5, i4);
    }
}
