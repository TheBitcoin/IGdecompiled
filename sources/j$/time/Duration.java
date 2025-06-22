package j$.time;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Duration f4835c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a  reason: collision with root package name */
    public final long f4836a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4837b;

    public final int compareTo(Object obj) {
        Duration duration = (Duration) obj;
        int compare = Long.compare(this.f4836a, duration.f4836a);
        if (compare != 0) {
            return compare;
        }
        return this.f4837b - duration.f4837b;
    }

    static {
        BigInteger.valueOf(C.NANOS_PER_SECOND);
    }

    public static Duration ofMinutes(long j4) {
        return j(a.w(j4, 60), 0);
    }

    public static Duration ofMillis(long j4) {
        long j5 = j4 / 1000;
        int i4 = (int) (j4 % 1000);
        if (i4 < 0) {
            i4 += 1000;
            j5--;
        }
        return j(j5, i4 * 1000000);
    }

    public static Duration j(long j4, int i4) {
        if ((((long) i4) | j4) == 0) {
            return f4835c;
        }
        return new Duration(j4, i4);
    }

    public Duration(long j4, int i4) {
        this.f4836a = j4;
        this.f4837b = i4;
    }

    public long toMillis() {
        long j4 = (long) this.f4837b;
        long j5 = this.f4836a;
        if (j5 < 0) {
            j5++;
            j4 -= C.NANOS_PER_SECOND;
        }
        return a.x(a.w(j5, 1000), j4 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            return this.f4836a == duration.f4836a && this.f4837b == duration.f4837b;
        }
    }

    public final int hashCode() {
        long j4 = this.f4836a;
        return (this.f4837b * 51) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        if (this == f4835c) {
            return "PT0S";
        }
        long j4 = this.f4836a;
        int i4 = this.f4837b;
        long j5 = (j4 >= 0 || i4 <= 0) ? j4 : 1 + j4;
        long j6 = j5 / 3600;
        int i5 = (int) ((j5 % 3600) / 60);
        int i6 = (int) (j5 % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j6 != 0) {
            sb.append(j6);
            sb.append('H');
        }
        if (i5 != 0) {
            sb.append(i5);
            sb.append('M');
        }
        if (i6 == 0 && i4 == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (j4 >= 0 || i4 <= 0) {
            sb.append(i6);
        } else if (i6 == 0) {
            sb.append("-0");
        } else {
            sb.append(i6);
        }
        if (i4 > 0) {
            int length = sb.length();
            if (j4 < 0) {
                sb.append(2000000000 - ((long) i4));
            } else {
                sb.append(((long) i4) + C.NANOS_PER_SECOND);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new r((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
