package I2;

import I2.d;
import kotlin.jvm.internal.m;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6696a = new a();

    public static final class a {
        public final String a(String str, int i4) {
            m.e(str, "value");
            if (i4 == str.length()) {
                int length = str.length() / 2;
                d.a aVar = d.f6695a;
                StringBuilder sb = new StringBuilder();
                sb.append((char) (aVar.a(m3.m.y0(str, j3.e.i(0, length)), length) + 65));
                sb.append((char) (aVar.a(m3.m.y0(str, j3.e.i(length, str.length())), length) + 65));
                return sb.toString();
            }
            a aVar2 = e.f6696a;
            throw new G2.e(m.m("h.e", ": invalid bit length for language"));
        }
    }
}
