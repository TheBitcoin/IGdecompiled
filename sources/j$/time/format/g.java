package j$.time.format;

import j$.time.temporal.q;
import j$.time.temporal.u;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public final class g extends i {

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4937g;

    public g(q qVar, int i4, int i5, boolean z4, int i6) {
        super(qVar, i4, i5, u.NOT_NEGATIVE, i6);
        this.f4937g = z4;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Enum, j$.time.temporal.q] */
    public final i a() {
        if (this.f4944e == -1) {
            return this;
        }
        return new g(this.f4940a, this.f4941b, this.f4942c, this.f4937g, -1);
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Enum, j$.time.temporal.q] */
    public final i b(int i4) {
        return new g(this.f4940a, this.f4941b, this.f4942c, this.f4937g, this.f4944e + i4);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Enum, j$.time.temporal.q] */
    public final boolean j(p pVar, StringBuilder sb) {
        ? r02 = this.f4940a;
        Long a5 = pVar.a(r02);
        if (a5 == null) {
            return false;
        }
        s sVar = pVar.f4967b.f4928c;
        long longValue = a5.longValue();
        u j4 = r02.j();
        j4.b(longValue, r02);
        BigDecimal valueOf = BigDecimal.valueOf(j4.f5039a);
        BigDecimal add = BigDecimal.valueOf(j4.f5042d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z4 = this.f4937g;
        int i4 = this.f4941b;
        if (scale != 0) {
            String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i4), this.f4942c), roundingMode).toPlainString().substring(2);
            sVar.getClass();
            if (z4) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        } else if (i4 <= 0) {
            return true;
        } else {
            if (z4) {
                sVar.getClass();
                sb.append('.');
            }
            for (int i5 = 0; i5 < i4; i5++) {
                sVar.getClass();
                sb.append('0');
            }
            return true;
        }
    }

    public final String toString() {
        String str = this.f4937g ? ",DecimalPoint" : "";
        return "Fraction(" + this.f4940a + "," + this.f4941b + "," + this.f4942c + str + ")";
    }
}
