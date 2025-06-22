package j$.time.format;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.time.temporal.q;

public class i implements f {

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f4939f = {0, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, 1000000, 10000000, 100000000, C.NANOS_PER_SECOND, 10000000000L};

    /* renamed from: a  reason: collision with root package name */
    public final Enum f4940a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4941b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4942c;

    /* renamed from: d  reason: collision with root package name */
    public final u f4943d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4944e;

    public i(q qVar, int i4, int i5, u uVar) {
        this.f4940a = (Enum) qVar;
        this.f4941b = i4;
        this.f4942c = i5;
        this.f4943d = uVar;
        this.f4944e = 0;
    }

    public i(q qVar, int i4, int i5, u uVar, int i6) {
        this.f4940a = (Enum) qVar;
        this.f4941b = i4;
        this.f4942c = i5;
        this.f4943d = uVar;
        this.f4944e = i6;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Enum, j$.time.temporal.q] */
    public i a() {
        if (this.f4944e == -1) {
            return this;
        }
        return new i(this.f4940a, this.f4941b, this.f4942c, this.f4943d, -1);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Enum, j$.time.temporal.q] */
    public i b(int i4) {
        int i5 = this.f4944e + i4;
        return new i(this.f4940a, this.f4941b, this.f4942c, this.f4943d, i5);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Enum, j$.time.temporal.q, java.lang.Object] */
    public boolean j(p pVar, StringBuilder sb) {
        ? r02 = this.f4940a;
        Long a5 = pVar.a(r02);
        if (a5 == null) {
            return false;
        }
        long longValue = a5.longValue();
        s sVar = pVar.f4967b.f4928c;
        String l4 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l4.length();
        int i4 = this.f4942c;
        if (length <= i4) {
            sVar.getClass();
            int i5 = this.f4941b;
            u uVar = this.f4943d;
            if (longValue >= 0) {
                int i6 = c.f4933a[uVar.ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        sb.append('+');
                    }
                } else if (i5 < 19 && longValue >= f4939f[i5]) {
                    sb.append('+');
                }
            } else {
                int i7 = c.f4933a[uVar.ordinal()];
                if (i7 == 1 || i7 == 2 || i7 == 3) {
                    sb.append('-');
                } else if (i7 == 4) {
                    throw new RuntimeException("Field " + r02 + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
                }
            }
            for (int i8 = 0; i8 < i5 - l4.length(); i8++) {
                sb.append('0');
            }
            sb.append(l4);
            return true;
        }
        throw new RuntimeException("Field " + r02 + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i4);
    }

    public String toString() {
        Enum enumR = this.f4940a;
        int i4 = this.f4942c;
        u uVar = this.f4943d;
        int i5 = this.f4941b;
        if (i5 == 1 && i4 == 19 && uVar == u.NORMAL) {
            return "Value(" + enumR + ")";
        } else if (i5 == i4 && uVar == u.NOT_NEGATIVE) {
            return "Value(" + enumR + "," + i5 + ")";
        } else {
            return "Value(" + enumR + "," + i5 + "," + i4 + "," + uVar + ")";
        }
    }
}
