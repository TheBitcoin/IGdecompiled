package l1;

import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.j  reason: case insensitive filesystem */
public abstract class C2115j {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21011a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (f21011a.matcher(str).matches()) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < str.length()) {
                int i6 = i4 + 1;
                if (str.charAt(str.length() - i6) == '1') {
                    i5 += 1 << i4;
                }
                i4 = i6;
            }
            return i5;
        }
        throw new C2152a("Undecodable FixedInteger '" + str + "'");
    }

    public static String b(int i4, int i5) {
        String str = "";
        while (i4 > 0) {
            if ((i4 & 1) == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            i4 >>= 1;
        }
        while (str.length() < i5) {
            str = "0" + str;
        }
        return str;
    }
}
