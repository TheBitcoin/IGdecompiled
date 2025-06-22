package l1;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.f  reason: case insensitive filesystem */
public abstract class C2111f {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21007a = Pattern.compile("^[0-1]*$", 2);

    public static ZonedDateTime a(String str) {
        if (f21007a.matcher(str).matches() && str.length() == 36) {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(C2118m.a(str) * 100), ZoneId.of("UTC"));
        }
        throw new C2152a("Undecodable Datetime '" + str + "'");
    }

    public static String b(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return C2118m.b(zonedDateTime.toInstant().toEpochMilli() / 100, 36);
        }
        return C2118m.b(0, 36);
    }
}
