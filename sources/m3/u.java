package m3;

import kotlin.jvm.internal.m;

abstract class u extends t {
    public static Integer f(String str) {
        m.e(str, "<this>");
        return g(str, 10);
    }

    public static final Integer g(String str, int i4) {
        int i5;
        boolean z4;
        int i6;
        m.e(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i7 = 0;
        char charAt = str.charAt(0);
        int i8 = -2147483647;
        if (m.g(charAt, 48) < 0) {
            i5 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z4 = false;
            } else if (charAt != '-') {
                return null;
            } else {
                i8 = Integer.MIN_VALUE;
                z4 = true;
            }
        } else {
            z4 = false;
            i5 = 0;
        }
        int i9 = -59652323;
        while (i5 < length) {
            int b5 = b.b(str.charAt(i5), i4);
            if (b5 < 0) {
                return null;
            }
            if ((i7 < i9 && (i9 != -59652323 || i7 < (i9 = i8 / i4))) || (i6 = i7 * i4) < i8 + b5) {
                return null;
            }
            i7 = i6 - b5;
            i5++;
        }
        if (z4) {
            return Integer.valueOf(i7);
        }
        return Integer.valueOf(-i7);
    }

    public static Long h(String str) {
        m.e(str, "<this>");
        return i(str, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long i(java.lang.String r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.m.e(r0, r2)
            m3.b.a(r1)
            int r2 = r0.length()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            return r3
        L_0x0014:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.m.g(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L_0x0038
            r6 = 1
            if (r2 != r6) goto L_0x002a
            return r3
        L_0x002a:
            r9 = 43
            if (r5 == r9) goto L_0x0037
            r4 = 45
            if (r5 == r4) goto L_0x0033
            return r3
        L_0x0033:
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x0039
        L_0x0037:
            r4 = 1
        L_0x0038:
            r6 = 0
        L_0x0039:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L_0x0041:
            if (r4 >= r2) goto L_0x0073
            char r5 = r0.charAt(r4)
            int r5 = m3.b.b(r5, r1)
            if (r5 >= 0) goto L_0x004e
            return r3
        L_0x004e:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005e
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L_0x0062
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x005e
            return r3
        L_0x005e:
            r15 = r3
            r16 = r4
            goto L_0x0063
        L_0x0062:
            return r3
        L_0x0063:
            long r3 = (long) r1
            long r11 = r11 * r3
            long r3 = (long) r5
            long r17 = r7 + r3
            int r5 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r5 >= 0) goto L_0x006e
            return r15
        L_0x006e:
            long r11 = r11 - r3
            int r4 = r16 + 1
            r3 = r15
            goto L_0x0041
        L_0x0073:
            if (r6 == 0) goto L_0x007a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            return r0
        L_0x007a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.u.i(java.lang.String, int):java.lang.Long");
    }
}
