package com.google.android.gms.internal.measurement;

abstract class J5 {

    /* renamed from: a  reason: collision with root package name */
    private static final L5 f1511a = new K5();

    static {
        if (F5.w()) {
            boolean z4 = F5.z();
        }
    }

    static int a(String str) {
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length && str.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char charAt = str.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                int length2 = str.length();
                while (i5 < length2) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 < 2048) {
                        i4 += (127 - charAt2) >>> 31;
                    } else {
                        i4 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i5) >= 65536) {
                                i5++;
                            } else {
                                throw new N5(i5, length2);
                            }
                        }
                    }
                    i5++;
                }
                i6 += i4;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i6) + 4294967296L));
    }

    static int b(String str, byte[] bArr, int i4, int i5) {
        return f1511a.b(str, bArr, i4, i5);
    }

    static /* synthetic */ int c(byte[] bArr, int i4, int i5) {
        byte b5 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 == 1) {
                byte b6 = bArr[i4];
                if (b5 > -12 || b6 > -65) {
                    return -1;
                }
                return (b6 << 8) ^ b5;
            } else if (i6 == 2) {
                byte b7 = bArr[i4];
                byte b8 = bArr[i4 + 1];
                if (b5 > -12 || b7 > -65 || b8 > -65) {
                    return -1;
                }
                return (b8 << 16) ^ ((b7 << 8) ^ b5);
            } else {
                throw new AssertionError();
            }
        } else if (b5 > -12) {
            return -1;
        } else {
            return b5;
        }
    }

    static String d(byte[] bArr, int i4, int i5) {
        return f1511a.c(bArr, i4, i5);
    }

    static boolean e(byte[] bArr, int i4, int i5) {
        if (f1511a.a(0, bArr, i4, i5) == 0) {
            return true;
        }
        return false;
    }
}
