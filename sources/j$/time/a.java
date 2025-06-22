package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

public final class a extends j$.com.android.tools.r8.a implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f4858b = new a(ZoneOffset.UTC);
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a  reason: collision with root package name */
    public final ZoneId f4859a;

    public a(ZoneId zoneId) {
        this.f4859a = zoneId;
    }

    static {
        System.currentTimeMillis();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f4859a.equals(((a) obj).f4859a);
    }

    public final int hashCode() {
        return this.f4859a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f4859a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
