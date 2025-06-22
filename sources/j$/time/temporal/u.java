package j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a  reason: collision with root package name */
    public final long f5039a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5040b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5041c;

    /* renamed from: d  reason: collision with root package name */
    public final long f5042d;

    public static u e(long j4, long j5) {
        if (j4 <= j5) {
            return new u(j4, j4, j5, j5);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static u f(long j4, long j5) {
        if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j5) {
            return new u(1, 1, j4, j5);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    public u(long j4, long j5, long j6, long j7) {
        this.f5039a = j4;
        this.f5040b = j5;
        this.f5041c = j6;
        this.f5042d = j7;
    }

    public final int a(long j4, q qVar) {
        if (this.f5039a >= -2147483648L && this.f5042d <= 2147483647L && d(j4)) {
            return (int) j4;
        }
        throw new RuntimeException(c(j4, qVar));
    }

    public final boolean d(long j4) {
        return j4 >= this.f5039a && j4 <= this.f5042d;
    }

    public final void b(long j4, q qVar) {
        if (!d(j4)) {
            throw new RuntimeException(c(j4, qVar));
        }
    }

    public final String c(long j4, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j4;
        }
        return "Invalid value (valid values " + this + "): " + j4;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j4 = this.f5039a;
        long j5 = this.f5040b;
        if (j4 <= j5) {
            long j6 = this.f5041c;
            long j7 = this.f5042d;
            if (j6 > j7) {
                throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
            } else if (j5 > j7) {
                throw new InvalidObjectException("Minimum value must be less than maximum value");
            }
        } else {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return this.f5039a == uVar.f5039a && this.f5040b == uVar.f5040b && this.f5041c == uVar.f5041c && this.f5042d == uVar.f5042d;
        }
    }

    public final int hashCode() {
        long j4 = this.f5040b;
        long j5 = this.f5039a + (j4 << 16) + (j4 >> 48);
        long j6 = this.f5041c;
        long j7 = j5 + (j6 << 32) + (j6 >> 32);
        long j8 = this.f5042d;
        long j9 = j7 + (j8 << 48) + (j8 >> 16);
        return (int) ((j9 >>> 32) ^ j9);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        long j4 = this.f5039a;
        sb.append(j4);
        long j5 = this.f5040b;
        if (j4 != j5) {
            sb.append('/');
            sb.append(j5);
        }
        sb.append(" - ");
        long j6 = this.f5041c;
        sb.append(j6);
        long j7 = this.f5042d;
        if (j6 != j7) {
            sb.append('/');
            sb.append(j7);
        }
        return sb.toString();
    }
}
