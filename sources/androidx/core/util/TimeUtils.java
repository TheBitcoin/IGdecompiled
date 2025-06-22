package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr = new char[24];
    private static final Object sFormatSync = new Object();

    private TimeUtils() {
    }

    private static int accumField(int i4, int i5, boolean z4, int i6) {
        if (i4 > 99 || (z4 && i6 >= 3)) {
            return i5 + 3;
        }
        if (i4 > 9 || (z4 && i6 >= 2)) {
            return i5 + 2;
        }
        if (z4 || i4 > 0) {
            return i5 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, StringBuilder sb) {
        synchronized (sFormatSync) {
            sb.append(sFormatStr, 0, formatDurationLocked(j4, 0));
        }
    }

    private static int formatDurationLocked(long j4, int i4) {
        char c5;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z4;
        boolean z5;
        int i9;
        boolean z6;
        int i10;
        boolean z7;
        int i11;
        int i12;
        boolean z8;
        boolean z9;
        boolean z10;
        int i13;
        long j5 = j4;
        int i14 = i4;
        if (sFormatStr.length < i14) {
            sFormatStr = new char[i14];
        }
        char[] cArr = sFormatStr;
        int i15 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i15 == 0) {
            int i16 = i14 - 1;
            while (i16 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i15 > 0) {
            c5 = '+';
        } else {
            j5 = -j5;
            c5 = '-';
        }
        int i17 = (int) (j5 % 1000);
        int floor = (int) Math.floor((double) (j5 / 1000));
        if (floor > SECONDS_PER_DAY) {
            i5 = floor / SECONDS_PER_DAY;
            floor -= SECONDS_PER_DAY * i5;
        } else {
            i5 = 0;
        }
        if (floor > SECONDS_PER_HOUR) {
            i6 = floor / SECONDS_PER_HOUR;
            floor -= i6 * SECONDS_PER_HOUR;
        } else {
            i6 = 0;
        }
        if (floor > 60) {
            int i18 = floor / 60;
            floor -= i18 * 60;
            i7 = i18;
        } else {
            i7 = 0;
        }
        if (i14 != 0) {
            int accumField = accumField(i5, 1, false, 0);
            if (accumField > 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            int accumField2 = accumField + accumField(i6, 1, z8, 2);
            if (accumField2 > 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            int accumField3 = accumField2 + accumField(i7, 1, z9, 2);
            if (accumField3 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int accumField4 = accumField3 + accumField(floor, 1, z10, 2);
            if (accumField4 > 0) {
                i13 = 3;
            } else {
                i13 = 0;
            }
            i8 = 0;
            for (int accumField5 = accumField4 + accumField(i17, 2, true, i13) + 1; accumField5 < i14; accumField5++) {
                cArr[i8] = ' ';
                i8++;
            }
        } else {
            i8 = 0;
        }
        cArr[i8] = c5;
        int i19 = i8 + 1;
        if (i14 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int printField = printField(cArr, i5, 'd', i19, false, 0);
        int i20 = i19;
        if (printField != i20) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4) {
            i9 = 2;
        } else {
            i9 = 0;
        }
        int i21 = i20;
        int i22 = i6;
        int i23 = i21;
        int printField2 = printField(cArr, i22, 'h', printField, z5, i9);
        if (printField2 != i23) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int printField3 = printField(cArr, i7, 'm', printField2, z6, i10);
        if (printField3 != i23) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z4) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int printField4 = printField(cArr, floor, 's', printField3, z7, i11);
        if (!z4 || printField4 == i23) {
            i12 = 0;
        } else {
            i12 = 3;
        }
        int printField5 = printField(cArr, i17, 'm', printField4, true, i12);
        cArr[printField5] = 's';
        return printField5 + 1;
    }

    private static int printField(char[] cArr, int i4, char c5, int i5, boolean z4, int i6) {
        int i7;
        if (!z4 && i4 <= 0) {
            return i5;
        }
        if ((!z4 || i6 < 3) && i4 <= 99) {
            i7 = i5;
        } else {
            int i8 = i4 / 100;
            cArr[i5] = (char) (i8 + 48);
            i7 = i5 + 1;
            i4 -= i8 * 100;
        }
        if ((z4 && i6 >= 2) || i4 > 9 || i5 != i7) {
            int i9 = i4 / 10;
            cArr[i7] = (char) (i9 + 48);
            i7++;
            i4 -= i9 * 10;
        }
        cArr[i7] = (char) (i4 + 48);
        cArr[i7 + 1] = c5;
        return i7 + 2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, PrintWriter printWriter, int i4) {
        synchronized (sFormatSync) {
            printWriter.print(new String(sFormatStr, 0, formatDurationLocked(j4, i4)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, PrintWriter printWriter) {
        formatDuration(j4, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long j4, long j5, PrintWriter printWriter) {
        if (j4 == 0) {
            printWriter.print("--");
        } else {
            formatDuration(j4 - j5, printWriter, 0);
        }
    }
}
