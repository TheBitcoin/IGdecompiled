package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.zone.f;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ZoneId implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f4848a;
    private static final long serialVersionUID = 8352817235686L;

    public abstract f C();

    public abstract void G(ObjectOutput objectOutput);

    public abstract String i();

    static {
        AbstractMap.SimpleImmutableEntry y4 = a.y("ACT", "Australia/Darwin");
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = y4;
        Map.Entry[] entryArr = {simpleImmutableEntry, a.y("AET", "Australia/Sydney"), a.y("AGT", "America/Argentina/Buenos_Aires"), a.y("ART", "Africa/Cairo"), a.y("AST", "America/Anchorage"), a.y("BET", "America/Sao_Paulo"), a.y("BST", "Asia/Dhaka"), a.y("CAT", "Africa/Harare"), a.y("CNT", "America/St_Johns"), a.y("CST", "America/Chicago"), a.y("CTT", "Asia/Shanghai"), a.y("EAT", "Africa/Addis_Ababa"), a.y("ECT", "Europe/Paris"), a.y("IET", "America/Indiana/Indianapolis"), a.y("IST", "Asia/Kolkata"), a.y("JST", "Asia/Tokyo"), a.y("MIT", "Pacific/Apia"), a.y("NET", "Asia/Yerevan"), a.y("NST", "Pacific/Auckland"), a.y("PLT", "Asia/Karachi"), a.y("PNT", "America/Phoenix"), a.y("PRT", "America/Puerto_Rico"), a.y("PST", "America/Los_Angeles"), a.y("SST", "Pacific/Guadalcanal"), a.y("VST", "Asia/Ho_Chi_Minh"), a.y("EST", "-05:00"), a.y("MST", "-07:00"), a.y("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        int i4 = 0;
        while (i4 < 28) {
            Map.Entry entry = entryArr[i4];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) == null) {
                i4++;
            } else {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        f4848a = Collections.unmodifiableMap(hashMap);
    }

    public static ZoneId of(String str) {
        return D(str, true);
    }

    public static ZoneId E(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zoneOffset.f4853b != 0) {
                str = str.concat(zoneOffset.f4854c);
            }
            return new w(str, zoneOffset.C());
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
    }

    public static ZoneId D(String str, boolean z4) {
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.H(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            return F(str, 3, z4);
        }
        if (str.startsWith("UT")) {
            return F(str, 2, z4);
        }
        return w.H(str, z4);
    }

    public static ZoneId F(String str, int i4, boolean z4) {
        String substring = str.substring(0, i4);
        if (str.length() == i4) {
            return E(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i4) != '+' && str.charAt(i4) != '-') {
            return w.H(str, z4);
        }
        try {
            ZoneOffset H4 = ZoneOffset.H(str.substring(i4));
            if (H4 == ZoneOffset.UTC) {
                return E(substring, H4);
            }
            return E(substring, H4);
        } catch (b e5) {
            throw new RuntimeException("Invalid ID for offset-based ZoneId: ".concat(str), e5);
        }
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != w.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return i().equals(((ZoneId) obj).i());
        }
        return false;
    }

    public int hashCode() {
        return i().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return i();
    }

    private Object writeReplace() {
        return new r((byte) 7, this);
    }
}
