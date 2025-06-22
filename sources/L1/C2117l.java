package l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import m1.C2152a;

/* renamed from: l1.l  reason: case insensitive filesystem */
public abstract class C2117l {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f21013a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f21013a.matcher(str).matches()) {
            int i4 = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a5 = C2115j.a(str.substring(0, 12));
                for (int i5 = 0; i5 < a5; i5++) {
                    int i6 = i4 + 1;
                    if (C2109d.a(str.substring(i4, i6))) {
                        int i7 = i4 + 17;
                        i4 += 33;
                        int a6 = C2115j.a(str.substring(i7, i4));
                        for (int a7 = C2115j.a(str.substring(i6, i7)); a7 <= a6; a7++) {
                            arrayList.add(Integer.valueOf(a7));
                        }
                    } else {
                        i4 += 17;
                        arrayList.add(Integer.valueOf(C2115j.a(str.substring(i6, i4))));
                    }
                }
                return arrayList;
            }
        }
        throw new C2152a("Undecodable FixedIntegerRange '" + str + "'");
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
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            if (((List) arrayList.get(i8)).size() == 1) {
                b5 = b5 + "0" + C2115j.b(((Integer) ((List) arrayList.get(i8)).get(0)).intValue(), 16);
            } else {
                b5 = b5 + "1" + C2115j.b(((Integer) ((List) arrayList.get(i8)).get(0)).intValue(), 16) + C2115j.b(((Integer) ((List) arrayList.get(i8)).get(((List) arrayList.get(i8)).size() - 1)).intValue(), 16);
            }
        }
        return b5;
    }
}
