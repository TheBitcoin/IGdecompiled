package l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.h  reason: case insensitive filesystem */
public abstract class C2113h {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21009a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f21009a.matcher(str).matches()) {
            int i4 = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a5 = C2115j.a(str.substring(0, 12));
                int i5 = 0;
                for (int i6 = 0; i6 < a5; i6++) {
                    int i7 = i4 + 1;
                    if (C2109d.a(str.substring(i4, i7))) {
                        int indexOf = str.indexOf("11", i7) + 2;
                        int a6 = C2112g.a(str.substring(i7, indexOf)) + i5;
                        int indexOf2 = str.indexOf("11", indexOf) + 2;
                        int a7 = C2112g.a(str.substring(indexOf, indexOf2)) + a6;
                        while (a6 <= a7) {
                            arrayList.add(Integer.valueOf(a6));
                            a6++;
                        }
                        int i8 = indexOf2;
                        i5 = a7;
                        i4 = i8;
                    } else {
                        i4 = str.indexOf("11", i7) + 2;
                        int a8 = C2112g.a(str.substring(i7, i4)) + i5;
                        arrayList.add(Integer.valueOf(a8));
                        i5 = a8;
                    }
                }
                return arrayList;
            }
        }
        throw new C2152a("Undecodable FibonacciIntegerRange '" + str + "'");
    }

    public static String b(List list) {
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < list.size()) {
            int i5 = i4;
            while (i5 < list.size() - 1) {
                int i6 = i5 + 1;
                if (((Integer) list.get(i5)).intValue() + 1 != ((Integer) list.get(i6)).intValue()) {
                    break;
                }
                i5 = i6;
            }
            int i7 = i5 + 1;
            arrayList.add(list.subList(i4, i7));
            i4 = i7;
        }
        String b5 = C2115j.b(arrayList.size(), 12);
        int i8 = 0;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if (((List) arrayList.get(i9)).size() == 1) {
                int intValue = ((Integer) ((List) arrayList.get(i9)).get(0)).intValue() - i8;
                i8 = ((Integer) ((List) arrayList.get(i9)).get(0)).intValue();
                b5 = b5 + "0" + C2112g.b(intValue);
            } else {
                int intValue2 = ((Integer) ((List) arrayList.get(i9)).get(0)).intValue() - i8;
                int intValue3 = ((Integer) ((List) arrayList.get(i9)).get(((List) arrayList.get(i9)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i9)).get(0)).intValue();
                i8 = ((Integer) ((List) arrayList.get(i9)).get(((List) arrayList.get(i9)).size() - 1)).intValue();
                b5 = b5 + "1" + C2112g.b(intValue2) + C2112g.b(intValue3);
            }
        }
        return b5;
    }
}
