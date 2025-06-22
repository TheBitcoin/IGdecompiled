package I2;

import C2.b;
import C2.c;
import G2.e;
import com.inmobi.cmp.model.ChoiceError;
import kotlin.jvm.internal.m;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0088a f6691a = new C0088a();

    /* renamed from: I2.a$a  reason: collision with other inner class name */
    public static final class C0088a {
        public final long a(String str, int i4) {
            long j4;
            m.e(str, "value");
            if (i4 == str.length()) {
                m.e(str, "value");
                if (i4 != str.length()) {
                    b.a(b.f6277a, ChoiceError.ENCODE_INVALID_BIT_LENGTH, (String) null, (String) null, c.CONSOLE, (Throwable) null, 22);
                    j4 = -1;
                } else {
                    j4 = Long.parseLong(str, m3.a.a(2));
                }
                return j4 * ((long) 100);
            }
            C0088a aVar = a.f6691a;
            throw new e(m.m("h.a", ": invalid bit length"));
        }
    }
}
