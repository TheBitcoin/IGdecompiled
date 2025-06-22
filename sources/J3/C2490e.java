package J3;

import E3.c;
import N3.C2517h;
import java.io.IOException;

/* renamed from: J3.e  reason: case insensitive filesystem */
public abstract class C2490e {

    /* renamed from: a  reason: collision with root package name */
    static final C2517h f23468a = C2517h.f("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f23469b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f23470c = new String[64];

    /* renamed from: d  reason: collision with root package name */
    static final String[] f23471d = new String[256];

    static {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr = f23471d;
            if (i5 >= strArr.length) {
                break;
            }
            strArr[i5] = c.o("%8s", Integer.toBinaryString(i5)).replace(' ', '0');
            i5++;
        }
        String[] strArr2 = f23470c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i6 = iArr[0];
        strArr2[i6 | 8] = strArr2[i6] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i7 = 0; i7 < 3; i7++) {
            int i8 = iArr2[i7];
            int i9 = iArr[0];
            String[] strArr3 = f23470c;
            int i10 = i9 | i8;
            strArr3[i10] = strArr3[i9] + '|' + strArr3[i8];
            strArr3[i10 | 8] = strArr3[i9] + '|' + strArr3[i8] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f23470c;
            if (i4 < strArr4.length) {
                if (strArr4[i4] == null) {
                    strArr4[i4] = f23471d[i4];
                }
                i4++;
            } else {
                return;
            }
        }
    }

    static String a(byte b5, byte b6) {
        String str;
        if (b6 == 0) {
            return "";
        }
        if (!(b5 == 2 || b5 == 3)) {
            if (b5 == 4 || b5 == 6) {
                if (b6 == 1) {
                    return "ACK";
                }
                return f23471d[b6];
            } else if (!(b5 == 7 || b5 == 8)) {
                String[] strArr = f23470c;
                if (b6 < strArr.length) {
                    str = strArr[b6];
                } else {
                    str = f23471d[b6];
                }
                if (b5 == 5 && (b6 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b5 != 0 || (b6 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f23471d[b6];
    }

    static String b(boolean z4, int i4, int i5, byte b5, byte b6) {
        String str;
        String str2;
        String[] strArr = f23469b;
        if (b5 < strArr.length) {
            str = strArr[b5];
        } else {
            str = c.o("0x%02x", Byte.valueOf(b5));
        }
        String a5 = a(b5, b6);
        if (z4) {
            str2 = "<<";
        } else {
            str2 = ">>";
        }
        return c.o("%s 0x%08x %5d %-13s %s", str2, Integer.valueOf(i4), Integer.valueOf(i5), str, a5);
    }

    static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(c.o(str, objArr));
    }

    static IOException d(String str, Object... objArr) {
        throw new IOException(c.o(str, objArr));
    }
}
