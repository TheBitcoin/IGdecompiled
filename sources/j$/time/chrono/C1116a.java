package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.time.b;
import j$.time.j;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* renamed from: j$.time.chrono.a  reason: case insensitive filesystem */
public abstract class C1116a implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap f4871a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap f4872b = new ConcurrentHashMap();

    public final int compareTo(Object obj) {
        return i().compareTo(((l) obj).i());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l j(C1116a aVar, String str) {
        String s4;
        l lVar = (l) f4871a.putIfAbsent(str, aVar);
        if (lVar == null && (s4 = aVar.s()) != null) {
            f4872b.putIfAbsent(s4, aVar);
        }
        return lVar;
    }

    public C1120e o(LocalDateTime localDateTime) {
        try {
            return l(localDateTime).v(j.E(localDateTime));
        } catch (b e5) {
            throw new RuntimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e5);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1116a) && i().compareTo(((C1116a) obj).i()) == 0;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ i().hashCode();
    }

    public final String toString() {
        return i();
    }
}
