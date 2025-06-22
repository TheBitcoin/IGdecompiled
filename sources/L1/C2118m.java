package l1;

import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.m  reason: case insensitive filesystem */
public abstract class C2118m {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21014a = Pattern.compile("^[0-1]*$", 2);

    public static long a(String str) {
        if (f21014a.matcher(str).matches()) {
            long j4 = 0;
            int i4 = 0;
            while (i4 < str.length()) {
                int i5 = i4 + 1;
                if (str.charAt(str.length() - i5) == '1') {
                    j4 += 1 << i4;
                }
                i4 = i5;
            }
            return j4;
        }
        throw new C2152a("Undecodable FixedLong '" + str + "'");
    }

    public static String b(long j4, int i4) {
        String str = "";
        while (j4 > 0) {
            if ((j4 & 1) == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            j4 >>= 1;
        }
        while (str.length() < i4) {
            str = "0" + str;
        }
        return str;
    }
}
