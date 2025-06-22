package I2;

import G2.e;
import com.inmobi.cmp.core.model.Vector;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6694a = new a();

    public static final class a {
        public final Vector a(String str, int i4) {
            m.e(str, "value");
            if (str.length() == i4) {
                Vector vector = new Vector((Map) null, 1, (C2103g) null);
                if (1 <= i4) {
                    int i5 = 1;
                    while (true) {
                        int i6 = i5 + 1;
                        String valueOf = String.valueOf(str.charAt(i5 - 1));
                        m.e(valueOf, "value");
                        if (m.a(valueOf, "1")) {
                            vector.set(i5);
                        }
                        if (i5 == i4) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                vector.setBitLength(str.length());
                return vector;
            }
            a aVar = c.f6694a;
            throw new e(m.m("h.c", ": bitfield encoding length mismatch"));
        }
    }
}
