package H0;

import java.util.HashMap;

/* renamed from: H0.c  reason: case insensitive filesystem */
public class C1302c implements C1303d {

    /* renamed from: a  reason: collision with root package name */
    private final int f6620a;

    public C1302c(int i4) {
        this.f6620a = i4;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, int i4, int i5) {
        int i6 = i5 - i4;
        if (i5 + i6 > stackTraceElementArr.length) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!stackTraceElementArr[i4 + i7].equals(stackTraceElementArr[i5 + i7])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, int i4) {
        int i5;
        HashMap hashMap = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i6];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !b(stackTraceElementArr, num.intValue(), i6)) {
                stackTraceElementArr2[i7] = stackTraceElementArr[i6];
                i7++;
                i5 = i6;
                i8 = 1;
            } else {
                int intValue = i6 - num.intValue();
                if (i8 < i4) {
                    System.arraycopy(stackTraceElementArr, i6, stackTraceElementArr2, i7, intValue);
                    i7 += intValue;
                    i8++;
                }
                i5 = (intValue - 1) + i6;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i6));
            i6 = i5 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i7];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i7);
        return stackTraceElementArr3;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] c5 = c(stackTraceElementArr, this.f6620a);
        if (c5.length < stackTraceElementArr.length) {
            return c5;
        }
        return stackTraceElementArr;
    }
}
