package j$.time.zone;

import j$.com.android.tools.r8.a;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a  reason: collision with root package name */
    public final long f5054a;

    /* renamed from: b  reason: collision with root package name */
    public final LocalDateTime f5055b;

    /* renamed from: c  reason: collision with root package name */
    public final ZoneOffset f5056c;

    /* renamed from: d  reason: collision with root package name */
    public final ZoneOffset f5057d;

    public final int compareTo(Object obj) {
        return Long.compare(this.f5054a, ((b) obj).f5054a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.f5054a = a.t(localDateTime, zoneOffset);
        this.f5055b = localDateTime;
        this.f5056c = zoneOffset;
        this.f5057d = zoneOffset2;
    }

    public b(long j4, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f5054a = j4;
        this.f5055b = LocalDateTime.G(j4, 0, zoneOffset);
        this.f5056c = zoneOffset;
        this.f5057d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f5054a == bVar.f5054a && this.f5056c.equals(bVar.f5056c) && this.f5057d.equals(bVar.f5057d);
        }
    }

    public final int hashCode() {
        return (this.f5055b.hashCode() ^ this.f5056c.f4853b) ^ Integer.rotateLeft(this.f5057d.f4853b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        ZoneOffset zoneOffset = this.f5057d;
        int i4 = zoneOffset.f4853b;
        ZoneOffset zoneOffset2 = this.f5056c;
        sb.append(i4 > zoneOffset2.f4853b ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f5055b);
        sb.append(zoneOffset2);
        sb.append(" to ");
        sb.append(zoneOffset);
        sb.append(']');
        return sb.toString();
    }
}
