package l1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.i  reason: case insensitive filesystem */
public abstract class C2114i {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21010a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f21010a.matcher(str).matches()) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < str.length()) {
                int i5 = i4 + 1;
                arrayList.add(Boolean.valueOf(C2109d.a(str.substring(i4, i5))));
                i4 = i5;
            }
            return arrayList;
        }
        throw new C2152a("Undecodable FixedBitfield '" + str + "'");
    }

    public static String b(List list, int i4) {
        String str = "";
        for (int i5 = 0; i5 < list.size(); i5++) {
            str = str + C2109d.b((Boolean) list.get(i5));
        }
        while (str.length() < i4) {
            str = str + "0";
        }
        return str;
    }
}
