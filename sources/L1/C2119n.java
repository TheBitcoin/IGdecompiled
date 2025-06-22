package l1;

import java.util.regex.Pattern;
import m1.C2152a;
import m1.C2153b;

/* renamed from: l1.n  reason: case insensitive filesystem */
public abstract class C2119n {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21015a = Pattern.compile("^[0-1]*$", 2);

    public static String a(String str) {
        if (!f21015a.matcher(str).matches() || str.length() % 6 != 0) {
            throw new C2152a("Undecodable FixedString '" + str + "'");
        }
        String str2 = "";
        int i4 = 0;
        while (i4 < str.length()) {
            int i5 = i4 + 6;
            int a5 = C2115j.a(str.substring(i4, i5));
            if (a5 == 63) {
                str2 = str2 + " ";
            } else {
                str2 = str2 + ((char) (a5 + 65));
            }
            i4 = i5;
        }
        return str2.trim();
    }

    public static String b(String str, int i4) {
        while (str.length() < i4) {
            str = str + " ";
        }
        String str2 = "";
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt == ' ') {
                str2 = str2 + C2115j.b(63, 6);
            } else if (charAt >= 'A') {
                str2 = str2 + C2115j.b(str.charAt(i5) - 'A', 6);
            } else {
                throw new C2153b("Unencodable FixedString '" + str + "'");
            }
        }
        return str2;
    }
}
