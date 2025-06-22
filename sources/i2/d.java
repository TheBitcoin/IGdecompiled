package I2;

import G2.e;
import kotlin.jvm.internal.m;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6695a = new a();

    public static final class a {
        public final int a(String str, int i4) {
            m.e(str, "value");
            if (i4 == str.length()) {
                return Integer.parseInt(str, m3.a.a(2));
            }
            a aVar = d.f6695a;
            throw new e(m.m("h.d", ": invalid bit length"));
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String b(java.lang.Object r10, int r11) {
            /*
                r9 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.m.e(r10, r0)
                boolean r0 = r10 instanceof java.lang.Integer
                java.lang.String r1 = "h.d"
                java.lang.String r2 = "toString(this, checkRadix(radix))"
                r3 = 2
                if (r0 == 0) goto L_0x0027
                r0 = r10
                java.lang.Number r0 = (java.lang.Number) r0
                int r4 = r0.intValue()
                if (r4 < 0) goto L_0x0027
                int r0 = r0.intValue()
                int r3 = m3.a.a(r3)
                java.lang.String r0 = java.lang.Integer.toString(r0, r3)
                kotlin.jvm.internal.m.d(r0, r2)
                goto L_0x0047
            L_0x0027:
                boolean r0 = r10 instanceof java.lang.Long
                if (r0 == 0) goto L_0x0078
                r0 = r10
                java.lang.Number r0 = (java.lang.Number) r0
                long r4 = r0.longValue()
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 < 0) goto L_0x0078
                long r4 = r0.longValue()
                int r0 = m3.a.a(r3)
                java.lang.String r0 = java.lang.Long.toString(r4, r0)
                kotlin.jvm.internal.m.d(r0, r2)
            L_0x0047:
                int r2 = r0.length()
                if (r2 > r11) goto L_0x0054
                r10 = 48
                java.lang.String r10 = m3.m.Y(r0, r11, r10)
                return r10
            L_0x0054:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                I2.d$a r2 = I2.d.f6695a
                r0.append(r1)
                java.lang.String r1 = ": "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r10 = " too large to encode into "
                r0.append(r10)
                r0.append(r11)
                java.lang.String r10 = r0.toString()
                G2.e r11 = new G2.e
                r11.<init>(r10)
                throw r11
            L_0x0078:
                I2.d$a r10 = I2.d.f6695a
                java.lang.String r10 = ": incorrect format passed"
                java.lang.String r10 = kotlin.jvm.internal.m.m(r1, r10)
                G2.e r11 = new G2.e
                r11.<init>(r10)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: I2.d.a.b(java.lang.Object, int):java.lang.String");
        }
    }
}
