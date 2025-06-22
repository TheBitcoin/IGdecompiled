package f0;

import M.C0335p;

public abstract class A {
    public static String a(String str, String[] strArr, String[] strArr2) {
        boolean z4;
        C0335p.l(strArr);
        C0335p.l(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i4 = 0; i4 < min; i4++) {
            String str2 = strArr[i4];
            if (str == null && str2 == null) {
                z4 = true;
            } else if (str == null) {
                z4 = false;
            } else {
                z4 = str.equals(str2);
            }
            if (z4) {
                return strArr2[i4];
            }
        }
        return null;
    }
}
