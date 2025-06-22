package G2;

import R2.s;
import com.inmobi.cmp.core.model.Vector;
import d3.p;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.n;
import m3.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6590a = new b();

    public static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C f6591a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C c5) {
            super(2);
            this.f6591a = c5;
        }

        public Object invoke(Object obj, Object obj2) {
            char c5;
            int intValue = ((Number) obj).intValue();
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            if (intValue > 0 && intValue <= m.F((CharSequence) this.f6591a.f20968a) + 1) {
                C c6 = this.f6591a;
                StringBuilder sb = new StringBuilder((String) c6.f20968a);
                int i4 = intValue - 1;
                if (booleanValue) {
                    c5 = '1';
                } else {
                    c5 = '0';
                }
                sb.setCharAt(i4, c5);
                String sb2 = sb.toString();
                kotlin.jvm.internal.m.d(sb2, "StringBuilder(result).ap…             }.toString()");
                c6.f20968a = sb2;
            }
            return s.f8222a;
        }
    }

    public final String a(Vector vector) {
        kotlin.jvm.internal.m.e(vector, "vector");
        C c5 = new C();
        c5.f20968a = m.s("0", vector.getMaxId());
        vector.forEach(new a(c5));
        return (String) c5.f20968a;
    }
}
