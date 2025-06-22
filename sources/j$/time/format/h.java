package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.a;
import j$.time.temporal.n;

public final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4938a;

    public /* synthetic */ h(int i4) {
        this.f4938a = i4;
    }

    public final boolean j(p pVar, StringBuilder sb) {
        long j4;
        p pVar2 = pVar;
        StringBuilder sb2 = sb;
        switch (this.f4938a) {
            case 0:
                Long a5 = pVar2.a(a.INSTANT_SECONDS);
                a aVar = a.NANO_OF_SECOND;
                n nVar = pVar2.f4966a;
                Long valueOf = nVar.f(aVar) ? Long.valueOf(nVar.t(aVar)) : null;
                int i4 = 0;
                if (a5 == null) {
                    return false;
                }
                long longValue = a5.longValue();
                if (valueOf != null) {
                    j4 = valueOf.longValue();
                } else {
                    j4 = 0;
                }
                int a6 = aVar.f5014b.a(j4, aVar);
                if (longValue >= -62167219200L) {
                    long j5 = longValue - 253402300800L;
                    long B4 = j$.com.android.tools.r8.a.B(j5, 315569520000L) + 1;
                    LocalDateTime G4 = LocalDateTime.G(j$.com.android.tools.r8.a.A(j5, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (B4 > 0) {
                        sb2.append('+');
                        sb2.append(B4);
                    }
                    sb2.append(G4);
                    if (G4.f4844b.f4989c == 0) {
                        sb2.append(":00");
                    }
                } else {
                    long j6 = longValue + 62167219200L;
                    long j7 = j6 / 315569520000L;
                    long j8 = j6 % 315569520000L;
                    LocalDateTime G5 = LocalDateTime.G(j8 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb2.length();
                    sb2.append(G5);
                    if (G5.f4844b.f4989c == 0) {
                        sb2.append(":00");
                    }
                    if (j7 < 0) {
                        if (G5.f4843a.f4977a == -10000) {
                            sb2.replace(length, length + 2, Long.toString(j7 - 1));
                        } else if (j8 == 0) {
                            sb2.insert(length, j7);
                        } else {
                            sb2.insert(length + 1, Math.abs(j7));
                        }
                    }
                }
                if (a6 > 0) {
                    sb2.append('.');
                    int i5 = 100000000;
                    while (true) {
                        if (a6 > 0 || i4 % 3 != 0 || i4 < -2) {
                            int i6 = a6 / i5;
                            sb2.append((char) (i6 + 48));
                            a6 -= i6 * i5;
                            i5 /= 10;
                            i4++;
                        }
                    }
                }
                sb2.append('Z');
                return true;
            default:
                a aVar2 = n.f4956f;
                n nVar2 = pVar2.f4966a;
                Object p4 = nVar2.p(aVar2);
                if (p4 == null && pVar2.f4968c == 0) {
                    throw new RuntimeException("Unable to extract " + aVar2 + " from temporal " + nVar2);
                }
                ZoneId zoneId = (ZoneId) p4;
                if (zoneId == null) {
                    return false;
                }
                sb2.append(zoneId.i());
                return true;
        }
    }

    public final String toString() {
        switch (this.f4938a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
