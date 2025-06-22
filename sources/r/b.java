package R;

import M.C0333n;

public abstract class b {
    public static boolean a(int[] iArr, int i4) {
        if (iArr != null) {
            for (int i5 : iArr) {
                if (i5 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int i4;
        if (objArr != null) {
            i4 = objArr.length;
        } else {
            i4 = 0;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                break;
            } else if (!C0333n.a(objArr[i5], obj)) {
                i5++;
            } else if (i5 >= 0) {
                return true;
            }
        }
        return false;
    }
}
