package l1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.k  reason: case insensitive filesystem */
public abstract class C2116k {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21012a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str, int i4, int i5) {
        if (f21012a.matcher(str).matches()) {
            int i6 = i4 * i5;
            if (str.length() > i6) {
                throw new C2152a("Undecodable FixedIntegerList '" + str + "'");
            } else if (str.length() % i4 == 0) {
                while (str.length() < i6) {
                    str = str + "0";
                }
                if (str.length() > i6) {
                    str = str.substring(0, i6);
                }
                ArrayList arrayList = new ArrayList();
                int i7 = 0;
                while (i7 < str.length()) {
                    int i8 = i7 + i4;
                    arrayList.add(Integer.valueOf(C2115j.a(str.substring(i7, i8))));
                    i7 = i8;
                }
                while (arrayList.size() < i5) {
                    arrayList.add(0);
                }
                return arrayList;
            } else {
                throw new C2152a("Undecodable FixedIntegerList '" + str + "'");
            }
        } else {
            throw new C2152a("Undecodable FixedIntegerList '" + str + "'");
        }
    }

    public static String b(List list, int i4, int i5) {
        String str = "";
        for (int i6 = 0; i6 < list.size(); i6++) {
            str = str + C2115j.b(((Integer) list.get(i6)).intValue(), i4);
        }
        while (str.length() < i4 * i5) {
            str = str + "0";
        }
        return str;
    }
}
