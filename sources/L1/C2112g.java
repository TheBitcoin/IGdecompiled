package l1;

import java.util.ArrayList;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.g  reason: case insensitive filesystem */
public abstract class C2112g {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21008a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (!f21008a.matcher(str).matches() || str.length() < 2 || str.indexOf("11") != str.length() - 2) {
            throw new C2152a("Undecodable FibonacciInteger '" + str + "'");
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < str.length() - 1; i4++) {
            if (i4 == 0) {
                arrayList.add(1);
            } else if (i4 == 1) {
                arrayList.add(2);
            } else {
                arrayList.add(Integer.valueOf(((Integer) arrayList.get(i4 - 1)).intValue() + ((Integer) arrayList.get(i4 - 2)).intValue()));
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < str.length() - 1; i6++) {
            if (str.charAt(i6) == '1') {
                i5 += ((Integer) arrayList.get(i6)).intValue();
            }
        }
        return i5;
    }

    public static String b(int i4) {
        ArrayList arrayList = new ArrayList();
        if (i4 >= 1) {
            arrayList.add(1);
            int i5 = 2;
            if (i4 >= 2) {
                arrayList.add(2);
                while (true) {
                    int i6 = i5 - 1;
                    int i7 = i5 - 2;
                    if (i4 < ((Integer) arrayList.get(i6)).intValue() + ((Integer) arrayList.get(i7)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i6)).intValue() + ((Integer) arrayList.get(i7)).intValue()));
                    i5++;
                }
            }
        }
        String str = "1";
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) arrayList.get(size)).intValue();
            if (i4 >= intValue) {
                str = "1" + str;
                i4 -= intValue;
            } else {
                str = "0" + str;
            }
        }
        return str;
    }
}
