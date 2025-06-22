package j$.time.zone;

import j$.com.android.tools.r8.a;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public final class f implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final long[] f5069i = new long[0];

    /* renamed from: j  reason: collision with root package name */
    public static final e[] f5070j = new e[0];

    /* renamed from: k  reason: collision with root package name */
    public static final LocalDateTime[] f5071k = new LocalDateTime[0];

    /* renamed from: l  reason: collision with root package name */
    public static final b[] f5072l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a  reason: collision with root package name */
    public final long[] f5073a;

    /* renamed from: b  reason: collision with root package name */
    public final ZoneOffset[] f5074b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f5075c;

    /* renamed from: d  reason: collision with root package name */
    public final LocalDateTime[] f5076d;

    /* renamed from: e  reason: collision with root package name */
    public final ZoneOffset[] f5077e;

    /* renamed from: f  reason: collision with root package name */
    public final e[] f5078f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeZone f5079g;

    /* renamed from: h  reason: collision with root package name */
    public final transient ConcurrentHashMap f5080h = new ConcurrentHashMap();

    public final int hashCode() {
        TimeZone timeZone = this.f5079g;
        return (((((timeZone != null ? timeZone.hashCode() : 0) ^ Arrays.hashCode(this.f5073a)) ^ Arrays.hashCode(this.f5074b)) ^ Arrays.hashCode(this.f5075c)) ^ Arrays.hashCode(this.f5077e)) ^ Arrays.hashCode(this.f5078f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(j$.time.LocalDateTime r5, j$.time.zone.b r6) {
        /*
            j$.time.LocalDateTime r0 = r6.f5055b
            j$.time.ZoneOffset r1 = r6.f5057d
            int r2 = r1.f4853b
            j$.time.ZoneOffset r3 = r6.f5056c
            int r4 = r3.f4853b
            if (r2 <= r4) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            j$.time.LocalDateTime r4 = r6.f5055b
            if (r2 == 0) goto L_0x002b
            boolean r0 = r5.E(r0)
            if (r0 == 0) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            int r0 = r1.f4853b
            int r2 = r3.f4853b
            int r0 = r0 - r2
            long r2 = (long) r0
            j$.time.LocalDateTime r0 = r4.I(r2)
            boolean r5 = r5.E(r0)
            if (r5 == 0) goto L_0x0031
            goto L_0x0043
        L_0x002b:
            boolean r0 = r5.E(r0)
            if (r0 != 0) goto L_0x0032
        L_0x0031:
            return r1
        L_0x0032:
            int r0 = r1.f4853b
            int r1 = r3.f4853b
            int r0 = r0 - r1
            long r0 = (long) r0
            j$.time.LocalDateTime r0 = r4.I(r0)
            boolean r5 = r5.E(r0)
            if (r5 == 0) goto L_0x0043
        L_0x0042:
            return r3
        L_0x0043:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.a(j$.time.LocalDateTime, j$.time.zone.b):java.lang.Object");
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f5073a = jArr;
        this.f5074b = zoneOffsetArr;
        this.f5075c = jArr2;
        this.f5077e = zoneOffsetArr2;
        this.f5078f = eVarArr;
        if (jArr2.length == 0) {
            this.f5076d = f5071k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < jArr2.length) {
                ZoneOffset zoneOffset = zoneOffsetArr2[i4];
                int i5 = i4 + 1;
                ZoneOffset zoneOffset2 = zoneOffsetArr2[i5];
                LocalDateTime G4 = LocalDateTime.G(jArr2[i4], 0, zoneOffset);
                int i6 = zoneOffset2.f4853b;
                int i7 = zoneOffset.f4853b;
                if (i6 > i7) {
                    arrayList.add(G4);
                    arrayList.add(G4.I((long) (zoneOffset2.f4853b - i7)));
                } else {
                    arrayList.add(G4.I((long) (i6 - i7)));
                    arrayList.add(G4);
                }
                i4 = i5;
            }
            this.f5076d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f5079g = null;
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f5074b = zoneOffsetArr;
        zoneOffsetArr[0] = zoneOffset;
        long[] jArr = f5069i;
        this.f5073a = jArr;
        this.f5075c = jArr;
        this.f5076d = f5071k;
        this.f5077e = zoneOffsetArr;
        this.f5078f = f5070j;
        this.f5079g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[1];
        this.f5074b = zoneOffsetArr;
        zoneOffsetArr[0] = g(timeZone.getRawOffset());
        long[] jArr = f5069i;
        this.f5073a = jArr;
        this.f5075c = jArr;
        this.f5076d = f5071k;
        this.f5077e = zoneOffsetArr;
        this.f5078f = f5070j;
        this.f5079g = timeZone;
    }

    public static ZoneOffset g(int i4) {
        return ZoneOffset.J(i4 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f5079g != null ? (byte) 100 : 1, this);
    }

    public static int c(long j4, ZoneOffset zoneOffset) {
        return g.L(a.B(j4 + ((long) zoneOffset.f4853b), (long) 86400)).f4977a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f5079g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f5075c;
        if (jArr.length == 0) {
            return this.f5074b[0];
        }
        long j4 = instant.f4839a;
        int length = this.f5078f.length;
        ZoneOffset[] zoneOffsetArr = this.f5077e;
        if (length <= 0 || j4 <= jArr[jArr.length - 1]) {
            int binarySearch = Arrays.binarySearch(jArr, j4);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            return zoneOffsetArr[binarySearch + 1];
        }
        b[] b5 = b(c(j4, zoneOffsetArr[zoneOffsetArr.length - 1]));
        b bVar = null;
        for (int i4 = 0; i4 < b5.length; i4++) {
            bVar = b5[i4];
            if (j4 < bVar.f5054a) {
                return bVar.f5056c;
            }
        }
        return bVar.f5057d;
    }

    public final List f(LocalDateTime localDateTime) {
        Object e5 = e(localDateTime);
        if (!(e5 instanceof b)) {
            return Collections.singletonList((ZoneOffset) e5);
        }
        b bVar = (b) e5;
        ZoneOffset zoneOffset = bVar.f5057d;
        int i4 = zoneOffset.f4853b;
        ZoneOffset zoneOffset2 = bVar.f5056c;
        if (i4 > zoneOffset2.f4853b) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {zoneOffset2, zoneOffset};
        ArrayList arrayList = new ArrayList(2);
        for (int i5 = 0; i5 < 2; i5++) {
            arrayList.add(Objects.requireNonNull(objArr[i5]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Object e(LocalDateTime localDateTime) {
        int i4;
        Object obj = null;
        ZoneOffset[] zoneOffsetArr = this.f5074b;
        int i5 = 0;
        TimeZone timeZone = this.f5079g;
        if (timeZone != null) {
            b[] b5 = b(localDateTime.f4843a.f4977a);
            if (b5.length == 0) {
                return g(timeZone.getOffset(a.t(localDateTime, zoneOffsetArr[0]) * 1000));
            }
            int length = b5.length;
            while (i5 < length) {
                b bVar = b5[i5];
                Object a5 = a(localDateTime, bVar);
                if ((a5 instanceof b) || a5.equals(bVar.f5056c)) {
                    return a5;
                }
                i5++;
                obj = a5;
            }
            return obj;
        } else if (this.f5075c.length == 0) {
            return zoneOffsetArr[0];
        } else {
            int length2 = this.f5078f.length;
            LocalDateTime[] localDateTimeArr = this.f5076d;
            if (length2 > 0) {
                LocalDateTime localDateTime2 = localDateTimeArr[localDateTimeArr.length - 1];
                localDateTime.getClass();
                g gVar = localDateTime.f4843a;
                if (localDateTime2 == null ? gVar.u() > localDateTime2.f4843a.u() || (i4 == 0 && localDateTime.f4844b.N() > localDateTime2.f4844b.N()) : localDateTime.C(localDateTime2) > 0) {
                    b[] b6 = b(gVar.f4977a);
                    int length3 = b6.length;
                    while (i5 < length3) {
                        b bVar2 = b6[i5];
                        Object a6 = a(localDateTime, bVar2);
                        if ((a6 instanceof b) || a6.equals(bVar2.f5056c)) {
                            return a6;
                        }
                        i5++;
                        obj = a6;
                    }
                    return obj;
                }
            }
            int binarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
            ZoneOffset[] zoneOffsetArr2 = this.f5077e;
            if (binarySearch == -1) {
                return zoneOffsetArr2[0];
            }
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            } else if (binarySearch < localDateTimeArr.length - 1) {
                int i6 = binarySearch + 1;
                if (localDateTimeArr[binarySearch].equals(localDateTimeArr[i6])) {
                    binarySearch = i6;
                }
            }
            if ((binarySearch & 1) != 0) {
                return zoneOffsetArr2[(binarySearch / 2) + 1];
            }
            LocalDateTime localDateTime3 = localDateTimeArr[binarySearch];
            LocalDateTime localDateTime4 = localDateTimeArr[binarySearch + 1];
            int i7 = binarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr2[i7];
            ZoneOffset zoneOffset2 = zoneOffsetArr2[i7 + 1];
            if (zoneOffset2.f4853b > zoneOffset.f4853b) {
                return new b(localDateTime3, zoneOffset, zoneOffset2);
            }
            return new b(localDateTime4, zoneOffset, zoneOffset2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final j$.time.zone.b[] b(int r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = 0
            r3 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            j$.util.concurrent.ConcurrentHashMap r5 = r0.f5080h
            java.lang.Object r6 = r5.get(r4)
            j$.time.zone.b[] r6 = (j$.time.zone.b[]) r6
            if (r6 == 0) goto L_0x0015
            return r6
        L_0x0015:
            r6 = 2100(0x834, float:2.943E-42)
            java.util.TimeZone r9 = r0.f5079g
            if (r9 == 0) goto L_0x00d9
            j$.time.zone.b[] r10 = f5072l
            r11 = 1800(0x708, float:2.522E-42)
            if (r1 >= r11) goto L_0x0022
            return r10
        L_0x0022:
            int r11 = r1 + -1
            j$.time.LocalDateTime r12 = j$.time.LocalDateTime.f4841c
            r12 = 12
            r13 = 31
            j$.time.g r11 = j$.time.g.K(r11, r12, r13)
            j$.time.temporal.a r12 = j$.time.temporal.a.HOUR_OF_DAY
            long r13 = (long) r2
            r12.w(r13)
            j$.time.j[] r12 = j$.time.j.f4986h
            r12 = r12[r2]
            j$.time.LocalDateTime r13 = new j$.time.LocalDateTime
            r13.<init>(r11, r12)
            j$.time.ZoneOffset[] r11 = r0.f5074b
            r2 = r11[r2]
            long r11 = j$.com.android.tools.r8.a.t(r13, r2)
            r15 = 1000(0x3e8, double:4.94E-321)
            long r13 = r11 * r15
            int r2 = r9.getOffset(r13)
            r13 = 31968000(0x1e7cb00, double:1.57942906E-316)
            long r13 = r13 + r11
        L_0x0051:
            int r17 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r17 >= 0) goto L_0x00cb
            r17 = 7776000(0x76a700, double:3.8418545E-317)
            long r17 = r11 + r17
            r19 = 1
            long r7 = r17 * r15
            int r7 = r9.getOffset(r7)
            if (r2 == r7) goto L_0x00c1
        L_0x0064:
            long r7 = r17 - r11
            int r21 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r21 <= 0) goto L_0x0086
            long r7 = r17 + r11
            r22 = r4
            r21 = 1
            r3 = 2
            long r3 = j$.com.android.tools.r8.a.B(r7, r3)
            long r7 = r3 * r15
            int r7 = r9.getOffset(r7)
            if (r7 != r2) goto L_0x0080
            r11 = r3
            goto L_0x0082
        L_0x0080:
            r17 = r3
        L_0x0082:
            r4 = r22
            r3 = 1
            goto L_0x0064
        L_0x0086:
            r22 = r4
            r21 = 1
            long r3 = r11 * r15
            int r3 = r9.getOffset(r3)
            if (r3 == r2) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r11 = r17
        L_0x0095:
            j$.time.ZoneOffset r2 = g(r2)
            long r3 = r11 * r15
            int r3 = r9.getOffset(r3)
            j$.time.ZoneOffset r4 = g(r3)
            int r7 = c(r11, r4)
            if (r7 != r1) goto L_0x00bf
            int r7 = r10.length
            int r7 = r7 + 1
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r10, r7)
            j$.time.zone.b[] r7 = (j$.time.zone.b[]) r7
            int r8 = r7.length
            int r8 = r8 + -1
            j$.time.zone.b r10 = new j$.time.zone.b
            r10.<init>((long) r11, (j$.time.ZoneOffset) r2, (j$.time.ZoneOffset) r4)
            r7[r8] = r10
            r2 = r3
            r10 = r7
            goto L_0x00c7
        L_0x00bf:
            r2 = r3
            goto L_0x00c7
        L_0x00c1:
            r22 = r4
            r21 = 1
            r11 = r17
        L_0x00c7:
            r4 = r22
            r3 = 1
            goto L_0x0051
        L_0x00cb:
            r22 = r4
            r2 = 1916(0x77c, float:2.685E-42)
            if (r2 > r1) goto L_0x00d8
            if (r1 >= r6) goto L_0x00d8
            r3 = r22
            r5.putIfAbsent(r3, r10)
        L_0x00d8:
            return r10
        L_0x00d9:
            r3 = r4
            r19 = 1
            r21 = 1
            j$.time.zone.e[] r4 = r0.f5078f
            int r7 = r4.length
            j$.time.zone.b[] r7 = new j$.time.zone.b[r7]
            r8 = 0
        L_0x00e4:
            int r9 = r4.length
            if (r8 >= r9) goto L_0x01ba
            r9 = r4[r8]
            j$.time.d r10 = r9.f5062c
            java.lang.String r11 = "month"
            j$.time.l r12 = r9.f5060a
            byte r13 = r9.f5061b
            if (r13 >= 0) goto L_0x0133
            j$.time.chrono.s r14 = j$.time.chrono.s.f4904c
            r16 = r7
            long r6 = (long) r1
            r14.getClass()
            boolean r14 = j$.time.chrono.s.k(r6)
            int r14 = r12.D(r14)
            int r14 = r14 + 1
            int r14 = r14 + r13
            j$.time.g r13 = j$.time.g.f4975d
            j$.time.temporal.a r13 = j$.time.temporal.a.YEAR
            r13.w(r6)
            j$.util.Objects.requireNonNull(r12, r11)
            j$.time.temporal.a r6 = j$.time.temporal.a.DAY_OF_MONTH
            r22 = r3
            long r2 = (long) r14
            r6.w(r2)
            int r2 = r12.getValue()
            j$.time.g r2 = j$.time.g.D(r1, r2, r14)
            if (r10 == 0) goto L_0x0130
            int r3 = r10.getValue()
            j$.time.temporal.p r6 = new j$.time.temporal.p
            r10 = 1
            r6.<init>(r3, r10)
            j$.time.g r2 = r2.m(r6)
        L_0x0130:
            r3 = r8
        L_0x0131:
            r6 = 0
            goto L_0x0161
        L_0x0133:
            r22 = r3
            r16 = r7
            j$.time.g r2 = j$.time.g.f4975d
            j$.time.temporal.a r2 = j$.time.temporal.a.YEAR
            r3 = r8
            long r7 = (long) r1
            r2.w(r7)
            j$.util.Objects.requireNonNull(r12, r11)
            j$.time.temporal.a r2 = j$.time.temporal.a.DAY_OF_MONTH
            long r7 = (long) r13
            r2.w(r7)
            int r2 = r12.getValue()
            j$.time.g r2 = j$.time.g.D(r1, r2, r13)
            if (r10 == 0) goto L_0x0131
            int r7 = r10.getValue()
            j$.time.temporal.p r8 = new j$.time.temporal.p
            r6 = 0
            r8.<init>(r7, r6)
            j$.time.g r2 = r2.m(r8)
        L_0x0161:
            boolean r7 = r9.f5064e
            if (r7 == 0) goto L_0x016c
            r7 = r19
            j$.time.g r2 = r2.N(r7)
            goto L_0x016e
        L_0x016c:
            r7 = r19
        L_0x016e:
            j$.time.j r10 = r9.f5063d
            j$.time.LocalDateTime r2 = j$.time.LocalDateTime.F(r2, r10)
            j$.time.zone.d r10 = r9.f5065f
            r10.getClass()
            int[] r11 = j$.time.zone.c.f5058a
            int r10 = r10.ordinal()
            r10 = r11[r10]
            j$.time.ZoneOffset r11 = r9.f5067h
            int r12 = r11.f4853b
            r13 = 1
            if (r10 == r13) goto L_0x0197
            r13 = 2
            if (r10 == r13) goto L_0x018c
            goto L_0x01a1
        L_0x018c:
            j$.time.ZoneOffset r10 = r9.f5066g
            int r10 = r10.f4853b
            int r12 = r12 - r10
            long r12 = (long) r12
            j$.time.LocalDateTime r2 = r2.I(r12)
            goto L_0x01a1
        L_0x0197:
            j$.time.ZoneOffset r10 = j$.time.ZoneOffset.UTC
            int r10 = r10.f4853b
            int r12 = r12 - r10
            long r12 = (long) r12
            j$.time.LocalDateTime r2 = r2.I(r12)
        L_0x01a1:
            j$.time.zone.b r10 = new j$.time.zone.b
            j$.time.ZoneOffset r9 = r9.f5068i
            r10.<init>((j$.time.LocalDateTime) r2, (j$.time.ZoneOffset) r11, (j$.time.ZoneOffset) r9)
            r16[r3] = r10
            r21 = 1
            int r2 = r3 + 1
            r19 = r7
            r7 = r16
            r3 = r22
            r6 = 2100(0x834, float:2.943E-42)
            r8 = r2
            r2 = 0
            goto L_0x00e4
        L_0x01ba:
            r22 = r3
            r16 = r7
            r15 = 2100(0x834, float:2.943E-42)
            if (r1 >= r15) goto L_0x01ca
            r1 = r16
            r3 = r22
            r5.putIfAbsent(r3, r1)
            return r1
        L_0x01ca:
            r1 = r16
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.b(int):j$.time.zone.b[]");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return Objects.equals(this.f5079g, fVar.f5079g) && Arrays.equals(this.f5073a, fVar.f5073a) && Arrays.equals(this.f5074b, fVar.f5074b) && Arrays.equals(this.f5075c, fVar.f5075c) && Arrays.equals(this.f5077e, fVar.f5077e) && Arrays.equals(this.f5078f, fVar.f5078f);
        }
    }

    public final String toString() {
        TimeZone timeZone = this.f5079g;
        if (timeZone != null) {
            String id = timeZone.getID();
            return "ZoneRules[timeZone=" + id + "]";
        }
        ZoneOffset[] zoneOffsetArr = this.f5074b;
        ZoneOffset zoneOffset = zoneOffsetArr[zoneOffsetArr.length - 1];
        return "ZoneRules[currentStandardOffset=" + zoneOffset + "]";
    }
}
